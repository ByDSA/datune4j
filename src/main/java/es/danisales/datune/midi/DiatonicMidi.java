package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.NoteOff;
import es.danisales.datune.midi.Events.NoteOn;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.datune.pitch.SymbolicPitch;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public final class DiatonicMidi extends Note<PitchDiatonicMidi> implements PitchDiatonicSingle, SymbolicPitch, PitchOctaveMidiEditable, EventComplex {
	DiatonicMidi() {
	}

	public static DiatonicMidiBuilder builder() {
		return new DiatonicMidiBuilder();
	}

	public static DiatonicMidi from(DiatonicDegree diatonicDegree, Tonality tonality, int octave) {
		Chromatic chromatic = Chromatic.from(diatonicDegree, tonality);
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(chromatic, octave)
				.build();
		return DiatonicMidi.builder()
		.fromChromatic(chromaticMidi, tonality)
				.build();
	}

	public DiatonicMidi sub(IntervalDiatonic i) {
		return _add(-i.ordinal());
	}

	private DiatonicMidi _add(int i) {
		int degreeInt = getDegree().ordinal() + i;
		int o = ( degreeInt ) / IntervalDiatonic.OCTAVE.ordinal();
		if ( degreeInt < 0 )
			o--;
		DiatonicDegree degree = DiatonicDegree.values()[degreeInt];
		assert degree != null : getDegree().ordinal() + " " + i;

		DiatonicMidi dm = clone();
		dm.setDegree( degree );
		dm.shiftOctave( o );
		return dm;
	}

	@Override
	public void shiftOctave(int octaveShift) {
		pitch.octave += octaveShift;
	}

	@Override
	public void setOctave(int octave) {
		pitch.octave = octave;
	}

	public DiatonicMidi add(IntervalDiatonic i) {
		return _add(i.ordinal());
	}

	public void setTonality(@NonNull Tonality s) {
		Objects.requireNonNull(s);
		pitch.tonality = s;
	}


	@Override
	public DiatonicMidi clone() {
		return builder()
				.pitch(pitch)
				.length(length)
				.velocity(velocity)
				.build();
	}

	public void setDegree(DiatonicDegree diatonicDegree) {
		pitch.degree = diatonicDegree;
	}

	public void shiftPos(IntervalDiatonic intervalDiatonic) {
		DiatonicDegree newDegree = DiatonicDegree.add(getDegree(), intervalDiatonic);
		setDegree( newDegree );
	}

	public IntervalChromatic distInterval(DiatonicMidi n) throws TonalityException {
		if ( !n.pitch.tonality.equals( pitch.tonality ) )
			throw new TonalityException( this, n );

		int tonalityLength = n.getTonality().size();

		IntervalDiatonic id = IntervalDiatonic.fromIndex(
				n.getPitch().getOctave() * tonalityLength + n.getDegree().ordinal()
						- ( getPitch().getOctave() * tonalityLength + getDegree().ordinal() )
		);
		int diffSemi = PitchChromaticMidi.from(n.pitch).getCode() - PitchChromaticMidi.from(pitch).getCode();
		return IntervalChromatic.from( id, diffSemi );
	}

	@Override
	public DiatonicDegree getDegree() {
		return pitch.degree;
	}

	@Override
	public int ordinal() {
		return getDegree().ordinal();
	}

	@Override
	public DiatonicMidi getNext() {
		DiatonicMidi dup = clone();
		dup.pitch.next();
		return dup;
	}

	@Override
	public DiatonicMidi getPrevious() {
		DiatonicMidi dup = clone();
		dup.pitch.previous();
		return dup;
	}

	public Tonality getTonality() {
		return pitch.tonality;
	}

	public String toString(Tonality tonality) {
		ChromaticMidi chromatidMidi = ChromaticMidi.from(this);
		return Namer.from(chromatidMidi, tonality);
	}

	@Override
	public String toString() {
		return toString( pitch.tonality ) + " (" + pitch.degree + ")";
	}

	public DiatonicAlt getDiatonicAlt() {
		return pitch.tonality.getNote(pitch.degree);
	}

	@Override
	public Diatonic getDiatonic() {
		return getDiatonicAlt().getDiatonic();
	}

	@Override
	public PitchDiatonicSingle getShifted(IntervalDiatonic intervalDiatonic) {
		DiatonicMidi diatonicMidi = DiatonicMidi.from(this);
		pitch.shift(intervalDiatonic);
		return diatonicMidi;
	}

	@Override
	public PitchDiatonicSingle getShiftedNegative(IntervalDiatonic intervalDiatonic) {
		DiatonicMidi diatonicMidi = DiatonicMidi.from(this);
		pitch.shiftNegative(intervalDiatonic);
		return diatonicMidi;
	}

	private static DiatonicMidi from(DiatonicMidi diatonicMidi) {
		return diatonicMidi.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if ( !( obj instanceof DiatonicMidi ) )
			return false;
		DiatonicMidi dm = (DiatonicMidi) obj;
		return pitch.equals( dm.pitch ) && length == dm.length && velocity == dm.velocity;
	}

	@Override
	public int hashCode() {
		return pitch.hashCode() + 31 * ( Integer.hashCode(velocity) + 37 * (Integer.hashCode(length) ) );
	}

	@Override
	public EventSequence getEvents() {
		EventSequence es = new EventSequence();
		es.add( 0, new NoteOn( this ) );
		es.add( length, new NoteOff( this ) );

		return es;
	}
}
