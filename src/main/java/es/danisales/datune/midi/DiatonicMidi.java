package es.danisales.datune.midi;

import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.lang.Namer;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DiatonicMidi extends NoteMidi<PitchDiatonicMidi> implements PitchDiatonicSingle, EventComplex {
	public static DiatonicMidiBuilder builder() {
		return new DiatonicMidiBuilder();
	}

	DiatonicMidi() {
	}

	@NonNull
	public static DiatonicMidi from(@NonNull ChromaticMidi chromaticMidi, @NonNull Tonality tonality) throws TonalityException {
		return builder()
				.from(chromaticMidi, tonality)
				.build();
	}

	@SuppressWarnings("WeakerAccess")
	public @Nullable IntervalChromatic distTo(@NonNull DiatonicMidi diatonicMidi) throws TonalityException {
		if (!diatonicMidi.pitch.getTonality().equals(pitch.getTonality()))
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
		try {
			StringBuilder stringBuilder = new StringBuilder();
			ChromaticMidi chromaticMidi = ChromaticMidi.from(this);

			stringBuilder
					.append(Namer.from(chromaticMidi, pitch.getTonality()))
					.append(" (")
					.append(pitch.getDegree())
					.append(", ")
					.append(pitch.getTonality())
					.append(")");

			return stringBuilder.toString();
		} catch (ScaleRelativeDegreeException e) {
			e.printStackTrace();
			return null;
		}
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
