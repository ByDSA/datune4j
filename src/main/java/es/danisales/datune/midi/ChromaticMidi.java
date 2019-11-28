package es.danisales.datune.midi;

import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.musical.transformations.DistanceCalculator;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class ChromaticMidi extends Note<PitchChromaticMidi> implements PitchChromaticSingle, EventComplex {
	public static ChromaticMidiBuilder builder() {
		return new ChromaticMidiBuilder();
	}

    public static @NonNull ChromaticMidi from(@NonNull DiatonicMidi diatonicMidi) throws PitchMidiException {
		PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(diatonicMidi.pitch);
		return ChromaticMidi.builder()
				.pitch(pitchChromaticMidi)
				.velocity(diatonicMidi.velocity)
				.length(diatonicMidi.length)
				.build();
	}

	ChromaticMidi() { }

    @SuppressWarnings("WeakerAccess")
    public int distTo(@NonNull ChromaticMidi chromaticMidi) {
        return DistanceCalculator.calculateDistanceInSemitones(this, chromaticMidi);
    }

	@Override
	public @NonNull ChromaticMidi clone() {
		return ChromaticMidi.builder()
                .pitch(pitch.clone())
				.velocity(velocity)
				.length(length)
				.build();
	}

	@Override
	public String toString() {
        return pitch + " (vel=" + velocity + ", length=" + length + ")";
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof ChromaticMidi) )
			return false;

		ChromaticMidi chromaticMidi = (ChromaticMidi) o;

		return pitch.equals( chromaticMidi.pitch) && velocity == chromaticMidi.velocity && length == chromaticMidi.length;
	}

	@Override
	public int hashCode() {
		return pitch.hashCode() + 31 * ( Integer.hashCode(velocity) + 37 * Integer.hashCode(length) );
	}
}