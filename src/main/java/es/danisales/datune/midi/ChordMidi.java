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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public abstract class ChordMidi<N extends Note<P>, I extends Interval, P extends PitchMidiInterface> extends Chord<N, I>
		implements Durable, PitchOctaveMidiEditable, PitchOctave, EventComplex {
	protected Arpegio	arpegio;
	protected int		length;

	ChromaticChord meta = null;

	ChordMidi() {
		super(new ArrayList<>());
	}

	protected abstract <T extends ChordMidi<N, I, P>> T newChord();

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
	public boolean containsPitchAll(@NonNull Collection<N> c) {
		for (N note : c)
			if (!containsPitch(note))
				return false;

		return true;
	}

	@Override
	public boolean add(@NonNull N n) throws AddedException {
		if (!containsPitch(n))
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

	public int getVelocity() {
		return getMaxNoteVelocity();
	}

	private int getMaxNoteVelocity() {
		int max = -1;
		for (N n : this)
			max = Math.max(max, n.getVelocity());

		return max;
	}

	@Override
	public void setLength(int d) {
		length = d;
	}

	@Override
	public int getLength() {
		if (arpegio == null)
			return getMaxNoteLength();
		else
			return arpegio.getLength();
	}

	@Override
	public void shiftOctave(int octaveShift) {
        for (N n : this) {
            try {
                n.getPitch().shiftOctave(octaveShift);
            } catch (PitchMidiException e) {
                throw new RuntimeException();
            }
        }
	}

	@Override
	public void setOctave(int newOctave) {
		int diff = newOctave - getOctave();
		shiftOctave( diff );
	}

	@Override
	public int getOctave() {
		return get(0).getPitch().getOctave();
	}

	public <N2 extends Note<?>> int dist(@NonNull ChordMidi<N2, ?, ?> n) {
		return dist( n, true );
	}

	protected <N2 extends Note<?>> int dist(@NonNull ChordMidi<N2, ?, ?> n, boolean bidirectional) {
		int d = 0;

		for ( N i : this ) {
			int localMin = 9999;
			assert n.size() > 0;
			for (N2 j : n) {
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

	@SuppressWarnings("unchecked")
	@Override
	public ChordMidi<N, I, P> clone() {
		ChordMidi<N, I, P> chordMidi = newChord();

		for (N n : this)
			chordMidi.add((N) n.clone());

		if (arpegio != null)
			chordMidi.arpegio = arpegio.clone();
		chordMidi.length = length;

		return chordMidi;
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
