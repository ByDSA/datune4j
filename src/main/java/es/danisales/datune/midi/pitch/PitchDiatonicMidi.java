package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class PitchDiatonicMidi implements PitchOctaveMidiEditable, PitchMidiInterface<IntervalDiatonic> {
	protected ScaleDegree degree;
	protected int octave;
	protected Tonality tonality;

	public static PitchDiatonicMidi from(@NonNull PitchDiatonicMidi pitchDiatonicMidi) {
		try {
			return from(pitchDiatonicMidi.degree, pitchDiatonicMidi.tonality, pitchDiatonicMidi.octave);
		} catch (PitchMidiException e) {
			throw NeverHappensException.make("Si PitchDiatonicMidi es consistente, lo va a ser la copia");
		}
	}

	public static @NonNull PitchDiatonicMidi from(@NonNull ScaleDegree scaleDegree, @NonNull Tonality tonality, int octave) throws PitchMidiException {
		return PitchDiatonicMidiAdapter.from(scaleDegree, tonality, octave);
	}

	public static @NonNull PitchDiatonicMidi from(@NonNull PitchChromaticMidi pitchChromaticMidi, @NonNull Tonality tonality) throws TonalityException {
		return PitchDiatonicMidiAdapter.from(pitchChromaticMidi, tonality);
	}

	public @NonNull ScaleDegree getDegree() {
		return degree;
	}

	public @NonNull DiatonicAlt getDiatonicAlt() {
		try {
			return (DiatonicAlt)tonality.getNote(degree);
		} catch (ScaleRelativeDegreeException e) {
			e.printStackTrace();
			throw NeverHappensException.make("Si PitchDiatonicMidi es consistente, la Tonality siempre va a tener ScaleDegree y nunca devolverá null");
		}
	}

	@SuppressWarnings("MethodDoesntCallSuperMethod")
	@NonNull
	@Override
	public PitchDiatonicMidi clone() {
		return PitchDiatonicMidiAdapter.fromUncheck(degree, tonality, octave);
	}

	@Override
	public int getMidiCode() {
		PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(this);
		return pitchChromaticMidi.getMidiCode();
	}

	@Override
	public void next() throws PitchMidiException {
		shift(IntervalDiatonic.SECOND);
	}

	@Override
	public void previous() throws PitchMidiException {
		shiftNegative(IntervalDiatonic.SECOND);
	}

	@Override
	public void shift(IntervalDiatonic intervalDiatonic) throws PitchMidiException {
		shift(intervalDiatonic, 1);
	}

	@Override
	public void shift(int pos) throws PitchMidiException {
		shift(pos, 1);
	}

	@Override
	public void shiftNegative(IntervalDiatonic intervalDiatonic) throws PitchMidiException {
		shift(intervalDiatonic, -1);
	}

	private void shift(IntervalDiatonic intervalDiatonic, int signFactor) throws PitchMidiException {
		int intervalDiatonicDegreeIndex = intervalDiatonic.ordinal();
		shift(intervalDiatonicDegreeIndex, signFactor);
	}

	private void shift(int intervalDiatonicDegreeIndex, int signFactor) throws PitchMidiException {
		int totalIndex = degree.ordinal() + intervalDiatonicDegreeIndex * signFactor;
		shiftOctave(totalIndex / Diatonic.NUMBER);
		if (totalIndex < 0)
			shiftOctave(-1);

		totalIndex = trimIndex(totalIndex);
		degree = DiatonicDegree.values()[totalIndex];
	}

	private int trimIndex(int i) {
		while (i < 0)
			i += Diatonic.NUMBER;
		i %= Diatonic.NUMBER;
		return i;
	}

	@Override
	public int getOctave() {
		return octave;
	}

	@Override
	public void shiftOctave(int octaveShift) throws PitchMidiException {
        PitchMidiException.check(getMidiCode() + Chromatic.NUMBER * octaveShift);
		setOctave(octave + octaveShift);
	}

	@Override
	public void setOctave(int octave) throws PitchMidiException {
        PitchDiatonicMidi cloned = clone();
        cloned.octave = octave;
        PitchMidiException.check(cloned);

		this.octave = octave;
	}

	public void setDegree(@NonNull DiatonicDegree diatonicDegree) {
		Objects.requireNonNull(diatonicDegree);
		degree = diatonicDegree;
	}

	public void setTonality(@NonNull Tonality tonality) {
		Objects.requireNonNull(tonality);
		this.tonality = tonality;
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
