package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

public class PitchDiatonicMidi implements PitchOctaveMidiEditable, PitchMidiInterface<IntervalDiatonic> {
	protected DiatonicDegree degree;
	protected int octave;
	protected Tonality tonality;

	public static PitchDiatonicMidi from(PitchDiatonicMidi pitchDiatonicMidi) {
		return from(pitchDiatonicMidi.degree, pitchDiatonicMidi.tonality, pitchDiatonicMidi.octave);
	}

	public static @Nullable PitchDiatonicMidi from(@NonNull DiatonicDegree diatonicDegree, @NonNull Tonality tonality, int octave) {
		Objects.requireNonNull(diatonicDegree);
		Objects.requireNonNull(tonality);
		PitchDiatonicMidi ret = fromUncheck(diatonicDegree, tonality, octave);

		return ret.checkRange() ? ret : null;
	}

	private static PitchDiatonicMidi fromUncheck(@NonNull DiatonicDegree diatonicDegree, @NonNull Tonality tonality, int octave) {
		PitchDiatonicMidi ret = new PitchDiatonicMidi();
		ret.degree = diatonicDegree;
		ret.tonality = tonality;
		ret.octave = octave;

		return ret;
	}

	public static @Nullable PitchDiatonicMidi from(@NonNull PitchChromaticMidi pitchChromaticMidi, @NonNull Tonality tonality) {
		Objects.requireNonNull(pitchChromaticMidi);
		Objects.requireNonNull(tonality);
		DiatonicDegree diatonicDegree = getDegreeFromChromaticMidi(pitchChromaticMidi, tonality);
		if (diatonicDegree == null)
			return null;

		int octave = getOctaveFromChromaticMidi(pitchChromaticMidi, diatonicDegree, tonality);

		return PitchDiatonicMidi.fromUncheck(diatonicDegree, tonality, octave);
	}

	private static @Nullable DiatonicDegree getDegreeFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, Tonality tonality) {
		Chromatic chromatic = pitchChromaticMidi.getChromatic();
		return (DiatonicDegree) tonality.getDegreeFrom(chromatic);
	}

	private static int getOctaveFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, DiatonicDegree diatonicDegree, Tonality tonality) {
		Chromatic chromaticRootWithoutAlts = Chromatic.from(tonality.getRoot().getDiatonic());

		PitchChromaticMidi pitchChromaticMidiRootWithoutAlts = PitchChromaticMidi.from(chromaticRootWithoutAlts, pitchChromaticMidi.getOctave());
		float semis = pitchChromaticMidiRootWithoutAlts.getMidiCode();// + tonality.getRoot().getAlterations();

		Chromatic chromatic = pitchChromaticMidi.getChromatic();
		Diatonic diatonic = Diatonic.from(chromatic);
		Diatonic root = tonality.getRoot().getDiatonic();

		/*int i = 0;
		for (ScaleDistance scaleDistance : tonality.getScale()) {
			if (i == diatonicDegree.ordinal()) {
				break;
			}
			semis += scaleDistance.getMicrotonalSemitones();
			i++;
		}*/

		int semisInt = Math.round(semis);
		PitchChromaticMidi pitchChromaticMidiOut = PitchChromaticMidi.from(semisInt);
		int octave = pitchChromaticMidiOut.getOctave();

		if (diatonic.compareTo(root) < 0)
			octave--;

		/*DiatonicAlt diatonicAltRoot = tonality.getRoot();
		int altsRoot = diatonicAltRoot.getSemitonesAdded();
		int semis = Chromatic.from(diatonicAltRoot.getDiatonic()).ordinal() + altsRoot;
		while (semis < 0) {
			octave++;
			semis += Chromatic.NUMBER;
		}

		while (semis >= Chromatic.NUMBER) {
			octave--;
			semis -= Chromatic.NUMBER;
		}

		Chromatic chromatic = pitchChromaticMidi.getChromatic();
		Diatonic diatonic = Diatonic.from(chromatic);
		Diatonic root = tonality.getRoot().getDiatonic();
		if (diatonic.compareTo(root) < 0)
			octave--;*/
		return octave;
	}

	private boolean checkRange() {
		try {
			PitchChromaticMidi.from(this);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public @NonNull DiatonicDegree getDegree() {
		return degree;
	}

	public @NonNull DiatonicAlt getDiatonicAlt() {
		return tonality.getNote(degree);
	}

	public Diatonic getDiatonic() {
		return tonality.getNote(degree).getDiatonic();
	}

	@Override
	public int getMidiCode() {
		PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(this);
		return pitchChromaticMidi.getMidiCode();
	}

	@Override
	public void next() {
		shift(IntervalDiatonic.SECOND);
	}

	@Override
	public void previous() {
		shiftNegative(IntervalDiatonic.SECOND);
	}

	@Override
	public void shift(IntervalDiatonic intervalDiatonic) {
		shift(intervalDiatonic, 1);
	}

	@Override
	public void shiftNegative(IntervalDiatonic intervalDiatonic) {
		shift(intervalDiatonic, -1);
	}

	private void shift(IntervalDiatonic intervalDiatonic, int signFactor) {
		int intervalDiatonicDegreeIndex = intervalDiatonic.ordinal();
		int totalIndex = degree.ordinal() + intervalDiatonicDegreeIndex * signFactor;
		int degreeIndex = totalIndex % Diatonic.NUMBER;
		degree = DiatonicDegree.values()[degreeIndex];
		octave = totalIndex / Diatonic.NUMBER;
	}

	@Override
	public int getOctave() {
		return octave;
	}

	@Override
	public void shiftOctave(int octaveShift) {
		setOctave(octave + octaveShift);
	}

	@Override
	public void setOctave(int octave) {
		this.octave = octave;
	}

	public void setTonality(@NonNull Tonality tonality) {
		Objects.requireNonNull(tonality);
		this.tonality = tonality;
	}

	public void setDegree(@NonNull DiatonicDegree diatonicDegree) {
		Objects.requireNonNull(diatonicDegree);
		degree = diatonicDegree;
	}

	public Tonality getTonality() {
		return tonality;
	}

	@Override
	public String toString() {
		return degree + " " + tonality + " " + octave;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PitchDiatonicMidi))
			return false;


		PitchDiatonicMidi pitchDiatonicMidi = (PitchDiatonicMidi) o;

		return pitchDiatonicMidi.tonality == tonality
				&& pitchDiatonicMidi.degree == degree
				&& pitchDiatonicMidi.octave == octave;
	}

	@Override
	public int hashCode() {
		return tonality.hashCode() + 17 * (degree.hashCode() + 31 * Integer.hashCode(octave));
	}
}
