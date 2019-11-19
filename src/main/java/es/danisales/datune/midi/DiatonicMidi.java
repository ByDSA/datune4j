package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import static com.google.common.base.Preconditions.checkArgument;

public class DiatonicMidi implements PitchSingleMidi, PitchDiatonicSingle {
	protected PitchMidi pitch;
	protected int velocity;
	protected int length;

	protected DiatonicDegree degree;
	protected int octave;
	protected Tonality tonality;

	DiatonicMidi() {
	}

	public static @Nullable DiatonicMidi from(@NonNull ChromaticMidi chromaticMidi, @NonNull Tonality tonality) {
		return DiatonicMidiAdapter.from(chromaticMidi, tonality);
	}

	public static DiatonicMidiBuilder builder() {
		return new DiatonicMidiBuilder();
	}

	public static DiatonicMidi from(DiatonicDegree diatonicDegree, Tonality tonality, int octave) {
		Chromatic chromatic = Chromatic.from(diatonicDegree, tonality);
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(chromatic, octave)
				.build();
		return DiatonicMidi.from(chromaticMidi, tonality);
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

	public DiatonicMidi add(IntervalDiatonic i) {
		return _add(i.ordinal());
	}

	public DiatonicMidi setTonality(Tonality s) {
		assert s != null;
		tonality = s;

		return this;
	}


	@Override
	public DiatonicMidi clone() {
		return builder()
				.diatonicDegree(degree)
				.tonality( Tonality.from( tonality ) )
				.octave(octave)
				.length(length)
				.velocity(velocity)
				.build();
	}

	@Override
	public PitchMidi getPitchMidi() {
		return pitch;
	}

	public void setDegree(DiatonicDegree diatonicDegree) {
		degree = diatonicDegree;
	}

	public void shiftPos(IntervalDiatonic intervalDiatonic) {
		DiatonicDegree newDegree = DiatonicDegree.add(getDegree(), intervalDiatonic);
		setDegree( newDegree );
	}

	public IntervalChromatic distInterval(DiatonicMidi n) throws TonalityException {
		if ( !n.tonality.equals( tonality ) )
			throw new TonalityException( this, n );

		int tonalityLength = n.getTonality().size();

		IntervalDiatonic id = IntervalDiatonic.fromIndex(
				n.getOctave() * tonalityLength + n.getDegree().ordinal()
						- ( getOctave() * tonalityLength + getDegree().ordinal() )
		);
		int diffSemi = n.getCode() - getCode();
		return IntervalChromatic.from( id, diffSemi );
	}

	@Override
	public DiatonicDegree getDegree() {
		return degree;
	}

	@Override
	public int ordinal() {
		return getDegree().ordinal();
	}

	@Override
	public DiatonicMidi getNext() {
		DiatonicMidi dup = clone();
		dup.pitch = dup.pitch.getNext();
		return dup;
	}

	@Override
	public DiatonicMidi getPrevious() {
		DiatonicMidi dup = clone();
		dup.pitch = dup.pitch.getPrevious();
		return dup;
	}

	public Tonality getTonality() {
		return tonality;
	}

	public String toString(Tonality tonality) {
		return Namer.from(this, tonality);
	}

	@Override
	public String toString() {
		return toString( tonality ) + " (" + degree + ")";
	}

	public String toStringFull() {
		return degree.toString() + " " + tonality.toString() + " Octava " + octave + " Duraci�n: "
				+ length + " Velocity: " + velocity;
	}

	@Override
	public DiatonicMidi setVelocity(int v) {
		velocity = v;
		return this;
	}

	@Override
	public int getVelocity() {
		return velocity;
	}

	@Override
	public DiatonicMidi setLength(int d) {
		length = d;
		return this;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void shiftOctave(int o) {
		octave += o;
		updatePitch();
	}

	private void updatePitch() {
		pitch = PitchMidi.from( degree, tonality, octave );
	}

	@Override
	public void setOctave(int o) {
		octave = o;
		updatePitch();
	}

	@Override
	public int getOctave() {
		return octave;
	}

	@Override
	public boolean equals(Object obj) {
		if ( !( obj instanceof DiatonicMidi ) )
			return false;
		DiatonicMidi dm = (DiatonicMidi) obj;
		return degree.equals( dm.degree ) && tonality.equals( dm.tonality ) && octave == dm.octave && length == dm.length && velocity == dm.velocity;
	}

	public DiatonicAlt getDiatonicAlt() {
		return tonality.getNote(degree);
	}

	@Override
	public Diatonic getDiatonic() {
		return getDiatonicAlt().getDiatonic();
	}

	@Override
	public PitchDiatonicSingle getShifted(IntervalDiatonic i) {
		DiatonicMidi diatonicMidi = DiatonicMidi.from(this);
		diatonicMidi.degree = DiatonicDegree.add(diatonicMidi.degree, i);
		return diatonicMidi;
	}

	private static DiatonicMidi from(DiatonicMidi diatonicMidi) {
		return diatonicMidi.clone();
	}
}
