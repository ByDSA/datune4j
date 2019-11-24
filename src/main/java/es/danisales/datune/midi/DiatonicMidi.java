package es.danisales.datune.midi;

import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DiatonicMidi extends Note<PitchDiatonicMidi> implements PitchDiatonicSingle, EventComplex {
	public static DiatonicMidiBuilder builder() {
		return new DiatonicMidiBuilder();
	}

	public static @Nullable DiatonicMidi from(ChromaticMidi chromaticMidi, Tonality tonality) {
		PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(chromaticMidi.pitch, tonality);
		if (pitchDiatonicMidi == null)
			return null;

		return DiatonicMidi.builder()
				.pitch(pitchDiatonicMidi)
				.length(chromaticMidi.length)
				.velocity(chromaticMidi.velocity)
				.build();
	}

	DiatonicMidi() {
	}

	public IntervalChromatic distTo(DiatonicMidi diatonicMidi) throws TonalityException {
		if (!diatonicMidi.pitch.tonality.equals(pitch.tonality))
			throw new TonalityException(this, diatonicMidi);

		int index = diatonicMidi.index() - index();

		IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(index);
		int diffSemi = diatonicMidi.pitch.getMidiCode() - pitch.getMidiCode();
		return IntervalChromatic.from(intervalDiatonic, diffSemi);
	}

	private int index() {
		return getPitch().getOctave() * getPitch().getTonality().size() + getPitch().getDegree().ordinal();
	}

	@Override
	public DiatonicMidi clone() {
		return builder()
                .pitch(pitch.clone())
				.length(length)
				.velocity(velocity)
				.build();
	}

	@Override
	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ChromaticMidi chromatidMidi = ChromaticMidi.from(this);
        stringBuilder.append(Namer.from(chromatidMidi, pitch.tonality));
        stringBuilder.append(" (").append(pitch.degree).append(")");

        return stringBuilder.toString();
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
}
