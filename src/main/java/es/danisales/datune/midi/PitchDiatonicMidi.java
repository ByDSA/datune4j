package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
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
        return PitchDiatonicMidiAdapter.from(diatonicDegree, tonality, octave);
	}

	public static @Nullable PitchDiatonicMidi from(@NonNull PitchChromaticMidi pitchChromaticMidi, @NonNull Tonality tonality) {
        return PitchDiatonicMidiAdapter.from(pitchChromaticMidi, tonality);
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

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public PitchDiatonicMidi clone() {
        return PitchDiatonicMidiAdapter.fromUncheck(degree, tonality, octave);
    }

    @SuppressWarnings("ConstantConditions")
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
        octave += totalIndex / Diatonic.NUMBER;
        if (totalIndex < 0)
            octave--;

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
	public void shiftOctave(int octaveShift) {
		setOctave(octave + octaveShift);
	}

	@Override
	public void setOctave(int octave) {
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
