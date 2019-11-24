package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Arpegios.Arpegio;
import es.danisales.datune.midi.Arpegios.ArpegioDefault;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public abstract class ChordMidi<N extends Note<P>, I extends Interval, P extends PitchMidiInterface> extends Chord<N, I>
		implements Durable, PitchOctaveMidiEditable, PitchOctave, EventComplex {
	protected Arpegio	arpegio;
	protected int		length;

	ChromaticChord meta = null;

    ChordMidi() {
		super(new ArrayList<>());
	}

    @Deprecated
    protected abstract <T extends ChordMidi<N, I, P>> T newChord();

    @Deprecated
        // deprecated or private
    <T extends ChordMidi<N, I, P>> void assign(@NonNull T c) {
        Objects.requireNonNull(c);
        clear();
        this.addAll(c);
        arpegio = c.arpegio;
        length = c.length;
    }

	@SuppressWarnings("unchecked")
	@Override
	public EventSequence getEvents() {
		EventSequence es = new EventSequence();

		Arpegio aNodes;
		if ( arpegio == null )
			this.setArpegio( new ArpegioDefault() );
		int arpDuration = arpegio.getLength();

		if ( length != 0 && length > arpDuration ) {
			aNodes = arpegio.clone();
			int newArpDuration = arpDuration;

			while ( length > newArpDuration ) {
				int currentLoop = newArpDuration;
				for ( Arpegio.Node n : arpegio.getNodes() ) {
					aNodes.add( currentLoop + n.time, n.note, n.length );
				}
				newArpDuration += arpDuration;
			}
		} else
			aNodes = arpegio;

		for ( Arpegio.Node node : aNodes.getNodes() ) {
			if ( length != 0 && node.time > length || node.note < 0 )
				continue;

			N n = (N) get( node.note ).clone();

			if ( length != 0 )
				n.setLength( Math.min( node.time + node.length, length ) - node.time );
			else
				n.setLength( node.length );
			es.add( node.time, n );
		}
		return es;
	}

	@Override
	public int getLength() {
		if ( arpegio == null )
            return getMaxNoteLength();
		else
			return arpegio.getLength();
	}

    private int getMaxNoteLength() {
		int max = length;
		for ( N n : this )
			max = Math.max( max, n.getLength() );

		return max;
	}

	public @Nullable Arpegio getArpegio() {
		return arpegio;
	}

	public void setArpegio(@NonNull Arpegio a) {
		Objects.requireNonNull(a);

		arpegio = a.clone();
		arpegio.setChord( this );
	}

    @SuppressWarnings("WeakerAccess")
    public boolean containsPitch(@NonNull Object o) {
        if (!(o instanceof Note))
            return false;

        Note nIn = (Note) o;
        int nInCode = nIn.pitch.getMidiCode();
        for (N note : this)
            if (note.pitch.getMidiCode() == nInCode)
				return true;

		return false;
	}

    @SuppressWarnings("WeakerAccess")
    public boolean containsPitchAll(@NonNull Collection<?> c) {
        for (N note : this)
            if (!containsPitch(note))
                return false;

        return true;
    }

	@Override
	public boolean add(@NonNull N n) throws AddedException {
        if (!contains(n))
			super.add( n );
		else
			throw new AddedException( n, this );

		sortByPitch();

		return true;
	}

    @Override
    public boolean addAll(@NonNull Collection<? extends N> collection) {
        boolean ret = super.addAll(collection);
        sortByPitch();
        return ret;
    }

    @Override
    public void add(int n, N chromaticMidi) throws AddedException {
        super.add(n, chromaticMidi);
        sortByPitch();
    }

    @SuppressWarnings("unchecked")
    void sortByPitch() {
        this.sort(
                Comparator.comparing(Note::getPitch)
        );
    }

	public void setVelocity(int v) {
		for ( N n : this )
			n.setVelocity( (int) Math.round( n.getVelocity() * v / 100.0 ) );
	}

	@Override
	public void setLength(int d) {
		length = d;
	}

	@Override
	public void shiftOctave(int octaveShift) {
		for ( N n : this )
			n.pitch.shiftOctave(octaveShift);
	}

	@Override
	public void setOctave(int octave) {
		int diff = octave - getOctave();
		shiftOctave( diff );
	}

	@Override
	public int getOctave() {
		return get( 0 ).pitch.getOctave();
	}

    // todo: move to transforms

	public <A extends List<N>> boolean hasSameNotesOrderSameOctave(A notes) {
		if ( size() != notes.size() || size() == 0 )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ) != notes.get( i ) )
				return false;
		}

		return true;
	}
    // todo: move to transforms

	public <A extends List<N>> boolean hasSameNotesOrder(boolean sameOctave, A notes) {
		return sameOctave && hasSameNotesOrderSameOctave( notes )
				;//|| !sameOctave && hasSameNotesOrder( notes );
	}
    // todo: move to transforms

	private <T extends ChordMidi<N, I, P>> List<T> _getAllInversions() {
		List<T> ret = new ArrayList<>();

		ret.add( (T) this.clone() );

		T last = (T)this;
		for ( int i = 0; i < size(); i++ ) {
			ret.add( last );
			last.inv();
		}

		return ret;
	}
    // todo: move to transforms

	public <T extends ChordMidi<N, I, P>> List<T> getAllDispositionsWithInv() {
		List<T> ret = new ArrayList<>();
		List<T> bases = _getAllInversions();
		for ( T c : bases )
			ret.addAll( (List<T>) c.getAllInversions() );

		return ret;
	}
    // todo: move to transforms

	@Override
	public List<ChordMidi<N, I, P>> getAllInversions() {
		ChordMidi<N, I, P> c = clone();
		c.setMinOctave();
		c.minimize();

		return c.getAllDispositionsSub( true, 0, true );
	}

    // todo: move to transforms
	protected <T extends ChordMidi<N, I, P>> List<T> getAllDispositionsSub(boolean sub, int level, boolean first) {
		ArrayList<T> ret = new ArrayList<>();
		assert size() > 0;

		if ( first && level == 0 )
			ret.add( (T) clone() );

		try {
            while ((size() > 1 && get(0).pitch.getMidiCode() < get(1).pitch.getMidiCode()
					|| size() == 1 ) ) {
				if ( !first ) {
					T d = (T) clone();
					ret.add( d );
				}

				if ( sub && size() > 1 ) {
					// Copia acorde desde la segunda a la �ltima nota
					T subChord = newChord();
					for ( int j = 1; j < size(); j++ )
						subChord.add( (N)get( j ).clone() );

					List<T> subCombinations = subChord.clone()
							.getAllDispositionsSub( true, level + 1, first );
					for ( T subCombination : subCombinations ) {
						// Forma listOf superChord = [listOf[0] + subChordcombination]
						T superChord = newChord();
						superChord.add( (N)get( 0 ).clone() );
						superChord.addAll( subCombination.clone() );

						// Combinaciones de 'n�mero' dentro del listOf superChord = ['n�mero' +
						// subChordcombination]
						List<T> superCombinations = superChord.clone()
								.getAllDispositionsSub( false, level, false );
						ret.addAll( superCombinations );
					}
				}

				get(0).pitch.shiftOctave(1);
				first = false;
			}
		} catch ( PitchMidiException e ) {

		}

		return ret;
	}

    // todo: move to transforms
    public void minimize() {
        for (int i = 1; i < size(); i++) {
            N note = get( i );
            N prev = get( i - 1 );
            while (note.pitch.getMidiCode() - 12 > prev.pitch.getMidiCode())
                note.pitch.shiftOctave(-1);
        }
    }

    // todo: move to transforms
    public void minimizeDistanceTo(@NonNull ChordMidi cIn) {
        Objects.requireNonNull(cIn);

        List<ChordMidi<N, I, P>> ret = getAllDispositionsWithInv();
        int minDist = 9999;
        ChordMidi<N, I, P> minDistChord = null;
        for (ChordMidi<N, I, P> c : ret) {
            int d = (int) Math.abs( cIn.dist( c ) );
            if ( d < minDist ) {
                minDist = d;
                minDistChord = c;
            }
        }
        assign( minDistChord );
    }

    public int dist(@NonNull ChordMidi<N, I, P> n) {
		return dist( n, true );
	}

    protected int dist(@NonNull ChordMidi<N, I, P> n, boolean bidirectional) {
		int d = 0;

		for ( N i : this ) {
			int localMin = 9999;
			assert n.size() > 0;
			for ( N j : n ) {
                int m = Math.abs(j.pitch.getMidiCode() - i.pitch.getMidiCode());
				if ( m < localMin )
					localMin = m;
			}
			assert localMin < 127 && localMin >= 0;
			d += localMin;
		}

		if ( bidirectional )
			d = Math.max( d, n.dist( this, false ) );

		return d;
	}

    void setArpegioIfNull() {
        if (arpegio == null)
            setArpegio(new ArpegioDefault());
    }

    @Override
    public ChordMidi<N, I, P> clone() { // todo
        return null;
    }

	@Override
	public boolean equals(Object o) {
		if ( !( o instanceof ChordMidi ) )
			return false;

		ChordMidi cm = (ChordMidi) o;

		if ( arpegio == null && cm.arpegio != null || cm.arpegio == null && arpegio != null )
			return false;

		return super.equals(cm) && (arpegio == null || arpegio.equals(cm.arpegio)) && length == cm.length;
	}
}
