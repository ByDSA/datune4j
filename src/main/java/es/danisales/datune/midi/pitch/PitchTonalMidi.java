package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.tonality.*;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class PitchTonalMidi implements PitchOctaveMidiEditable, PitchMidiInterface<IntervalDiatonic> {
	protected ScaleDegree degree;
	protected int octave;
	protected TonalityModern tonality;

	public static PitchTonalMidi from(@NonNull PitchTonalMidi pitchDiatonicMidi) {
		try {
			return from(pitchDiatonicMidi.degree, pitchDiatonicMidi.tonality, pitchDiatonicMidi.octave);
		} catch (PitchMidiException e) {
			throw NeverHappensException.make("Si PitchTonalMidi es consistente, lo va a ser la copia");
		}
	}

	public static <C extends CyclicDegree> @NonNull PitchTonalMidi from(@NonNull ScaleDegree scaleDegree, @NonNull Tonality<C> tonality, int octave) throws PitchMidiException {
		TonalityModern tonality2 = turnToTonalityModern(tonality);
		if (tonality.getRoot() instanceof DiatonicAlt)
			//noinspection unchecked
			octave += PitchChromaticMidi.octaveCorrectorAltRoot((Tonality<DiatonicAlt>)tonality);
		return PitchTonalMidiAdapter.from(scaleDegree, tonality2, octave);
	}

	public static <C extends CyclicDegree> @NonNull PitchTonalMidi from(@NonNull PitchChromaticMidi pitchChromaticMidi, @NonNull Tonality<C> tonality) throws TonalityException {
		return PitchTonalMidiAdapter.from(pitchChromaticMidi, tonality);
	}

	static <C extends CyclicDegree> TonalityModern turnToTonalityModern(Tonality<C> tonality) {
		TonalityModern tonality2;
		if (tonality.getRoot() instanceof Chromatic)
			tonality2 = (TonalityModern)tonality;
		else if (tonality.getRoot() instanceof DiatonicAlt) {
			tonality2 = TonalityConverter.fromDiatonicAltToChromatic((TonalityClassical)tonality);
		} else
			throw new RuntimeException();

		return tonality2;
	}

	public @NonNull ScaleDegree getDegree() {
		return degree;
	}

	public @NonNull Chromatic getDiatonicAlt() {
		try {
			return tonality.getNote(degree);
		} catch (ScaleRelativeDegreeException e) {
			e.printStackTrace();
			throw NeverHappensException.make("Si PitchTonalMidi es consistente, la Tonality siempre va a tener ScaleDegree y nunca devolverá null");
		}
	}

	@SuppressWarnings("MethodDoesntCallSuperMethod")
	@NonNull
	@Override
	public PitchTonalMidi clone() {
		return PitchTonalMidiAdapter.fromUncheck(degree, tonality, octave);
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
		PitchTonalMidi cloned = clone();
		cloned.octave = octave;
		PitchMidiException.check(cloned);

		this.octave = octave;
	}

	public void setDegree(@NonNull DiatonicDegree diatonicDegree) {
		Objects.requireNonNull(diatonicDegree);
		degree = diatonicDegree;
	}

	public void setTonality(@NonNull TonalityModern tonality) {
		Objects.requireNonNull(tonality);
		this.tonality = tonality;
	}

	public Tonality<Chromatic> getTonality() {
		return tonality;
	}

	@Override
	public String toString() {
		return degree + " " + tonality + " " + octave;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PitchTonalMidi))
			return false;


		PitchTonalMidi pitchDiatonicMidi = (PitchTonalMidi) o;

		return pitchDiatonicMidi.tonality.equals(tonality)
				&& pitchDiatonicMidi.degree == degree
				&& pitchDiatonicMidi.octave == octave;
	}

	@Override
	public int hashCode() {
		return tonality.hashCode() + 17 * (degree.hashCode() + 31 * Integer.hashCode(octave));
	}
}
