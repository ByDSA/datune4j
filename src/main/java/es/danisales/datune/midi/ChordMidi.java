package es.danisales.datune.midi;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.interval.Interval;
import es.danisales.datune.midi.arpegios.Arpegio;
import es.danisales.datune.midi.arpegios.ArpegioDefault;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.midi.pitch.PitchMidiInterface;
import es.danisales.datune.midi.pitch.PitchOctaveMidiEditable;
import es.danisales.datune.musical.ChromaticChordInfo;
import es.danisales.datune.pitch.ChordMutable;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public abstract class ChordMidi<N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface>
		extends ChordMutable<N, I>
		implements Durable, Velocitiable, PitchOctaveMidiEditable, PitchOctave, EventComplex {
	protected Arpegio	arpegio;
	protected int		length;
	private ChromaticChordInfo meta;

	ChordMidi() {
		super(new ArrayList<>());
	}

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
		if (!(o instanceof NoteMidi))
			return false;

		NoteMidi nIn = (NoteMidi) o;
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
	public abstract ChordMidi<N, I, P> clone();

	@Override
	public boolean add(@NonNull N n) throws AddedException {
		if (!containsPitch(n)) {
			super.add(n);
			sortByPitch();
		} else
			throw new AddedException(n, this);

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
	private void sortByPitch() {
		this.sort(
				Comparator.comparing(NoteMidi::getPitch)
		);
	}

	@Override
	public void setVelocity(int v) {
		for ( N n : this )
			n.setVelocity( (int) Math.round( n.getVelocity() * v / 100.0 ) );
	}

	@Override
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
	public void shiftOctave(int octaveShift) throws PitchMidiException {
		for (N n : this) {
			n.getPitch().shiftOctave(octaveShift);
		}
	}

	@Override
	public void setOctave(int newOctave) throws PitchMidiException {
		int diff = newOctave - getOctave();
		shiftOctave( diff );
	}

	@Override
	public int getOctave() {
		return get(0).getPitch().getOctave();
	}

	void setArpegioIfNull() {
		if (arpegio == null)
			setArpegio(new ArpegioDefault());
	}

	@SuppressWarnings("unchecked")
	ChordMidi<N, I, P> commonClone(ChordMidi<N, I, P> chordMidi) {
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

	@Override
	public int hashCode() {
		return super.hashCode() + 37 * ( arpegio.hashCode() + 41 * Integer.hashCode(length) );
	}
}
