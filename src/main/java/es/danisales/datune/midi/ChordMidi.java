package es.danisales.datune.midi;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Arpegios.Arpegio;
import es.danisales.datune.midi.Arpegios.ArpegioDefault;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.musical.ChromaticChordCustom;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.ChordCommon;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public abstract class ChordMidi<N extends PitchSingleMidi> extends Chord<N>
		implements Durable, PitchOctaveMidiEditable, EventComplex {
	protected Arpegio	arpegio;
	protected int		length;

	ChromaticChordCustom meta = null;

	<T extends ChordMidi<N>> void assign(@NonNull T c) {
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
		int max = length;

		if ( arpegio == null )
			for ( N n : this )
				max = Math.max( max, n.getLength() );
		else
			max = arpegio.getLength();

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

	public boolean contains(@NonNull N nIn) {
		int nInCode = nIn.getCode();
		for ( N n : this )
			if ( n.getCode() == nInCode )
				return true;

		return false;
	}

	public boolean add(@NonNull N n) throws AddedException {
		if ( !contains( n ) )
			super.add( n );
		else
			throw new AddedException( n, this );

		sort();

		return true;
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
	public void shiftOctave(int o) {
		for ( N n : this )
			n.shiftOctave( o );
	}

	@Override
	public void setOctave(int o) {
		int diff = o - getOctave();
		shiftOctave( diff );
	}

	@Override
	public int getOctave() {
		return get( 0 ).getOctave();
	}

	protected void sort() {
		this.sort(
				(N n1, N n2) -> ( n1.getCode() > n2.getCode() ? 1
						: ( n1 == n2 ? 0 : -1 ) )
		);
	}

	public <A extends List<N>> boolean hasSameNotesOrderSameOctave(A notes) {
		if ( size() != notes.size() || size() == 0 )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ) != notes.get( i ) )
				return false;
		}

		return true;
	}

	public <A extends List<N>> boolean hasSameNotesOrder(boolean sameOctave, A notes) {
		return sameOctave && hasSameNotesOrderSameOctave( notes )
				;//|| !sameOctave && hasSameNotesOrder( notes );
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<List<ChromaticChordCustom>, ChordCommon<?>, ChromaticChordCustom> f) {
		meta = ChromaticChordCustom.from( this );
		assert f != null;
		Boolean ret = meta.updateWhatIsIt( f );
		root = meta.getRootPos();
		return ret;
	}

	/*
	 * protected void updateMeta() { meta = new ChromaticChord(this);
	 * meta.setRoot(getRootPos()); }
	 */

	@Override
	public Boolean updateWhatIsItIfNeeded() {
		boolean ret = meta == null || !this.equals( meta );
		if ( ret )
			updateWhatIsIt();

		return ret;
	}
	/*
        public double getPitchMean() {
            int sum = 0, oct = 0;
            ChromaticMidi last = null;
            for ( NUMBER c : this ) {
                sum += c.getFrequency();
            }
            return ( (double) sum ) / size();
        }
    */

	private <T extends ChordMidi<N>> List<T> _getAllInversions() {
		List<T> ret = new ArrayList<>();

		ret.add( (T) this.clone() );

		T last = (T)this;
		for ( int i = 0; i < size(); i++ ) {
			ret.add( last );
			last.inv();
		}

		return ret;
	}

	public <T extends ChordMidi<N>> List<T> getAllDispositionsWithInv() {
		List<T> ret = new ArrayList<>();
		List<T> bases = _getAllInversions();
		for ( T c : bases )
			ret.addAll( (List<T>) c.getAllInversions() );

		return ret;
	}

	@Override
	public List<ChordMidi<N>> getAllInversions() {
		ChordMidi<N> c =  clone();
		c.setMinOctave();
		c.minimize();

		return c.getAllDispositionsSub( true, 0, true );
	}

	public void showNotesOctave() {
		for ( N n : this )
			System.out.print( n.getOctave() + " " );
		System.out.println( "" );
	}

	protected abstract <T extends ChordMidi<N>> T newChord();

	protected <T extends ChordMidi<N>> List<T> getAllDispositionsSub(boolean sub, int level, boolean first) {
		ArrayList<T> ret = new ArrayList<>();
		assert size() > 0;

		if ( first && level == 0 )
			ret.add( (T) clone() );

		try {
			while ( ( size() > 1 && get( 0 ).getCode() < get( 1 ).getCode()
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

				get( 0 ).shiftOctave( 1 );
				first = false;
			}
		} catch ( PitchMidiException e ) {

		}

		return ret;
	}

	public void minimize() {
		for ( int i = 1; i < size(); i++ ) {
			N note = get( i );
			N prev = get( i - 1 );
			while ( note.getCode() - 12 > prev.getCode() )
				note.shiftOctave( -1 );
		}
	}

	public void minimizeDistanceTo(ChordMidi cIn) {
		assert cIn != null;
		List<ChordMidi<N>> ret = getAllDispositionsWithInv();
		int minDist = 9999;
		ChordMidi<N> minDistChord = null;
		for ( ChordMidi<N> c : ret ) {
			int d = (int) Math.abs( cIn.dist( c ) );
			if ( d < minDist ) {
				minDist = d;
				minDistChord = c;
			}
		}
		assign( minDistChord );
	}

	public int dist(ChordMidi<N> n) {
		return dist( n, true );
	}

	protected int dist(ChordMidi<N> n, boolean bidirectional) {
		int d = 0;

		for ( N i : this ) {
			int localMin = 9999;
			assert n.size() > 0;
			for ( N j : n ) {
				int m = Math.abs( j.getCode() - i.getCode() );
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

	@Override
	public boolean equals(Object o) {
		if ( !( o instanceof ChordMidi ) )
			return false;

		ChordMidi cm = (ChordMidi) o;

		if ( arpegio == null && cm.arpegio != null || cm.arpegio == null && arpegio != null )
			return false;

		return super.equals(cm) && ( arpegio == null && cm.arpegio == null || arpegio.equals( cm.arpegio ) ) && length == cm.length;
	}

	protected void setArpegioIfNull() {
		if ( arpegio == null )
			setArpegio( new ArpegioDefault() );
	}

	@Override
	public ChordMidi<N> clone() { // todo
		return (ChordMidi<N>)null;
	}
}
