package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.datune.tonality.Tonality;

public class PitchDiatonicMidi implements PitchDiatonicSingle, PitchMidiInterface<DiatonicDegree, IntervalDiatonic> {
	protected DiatonicDegree degree;
	protected int octave;
	protected Tonality tonality;

	public static final int MIN_OCTAVE = 0;
	public static final int MAX_OCTAVE = 10;

	public static PitchDiatonicMidi from(PitchDiatonicMidi pitchDiatonicMidi) {
		return from(pitchDiatonicMidi.degree, pitchDiatonicMidi.tonality, pitchDiatonicMidi.octave);
	}

	public PitchDiatonicMidi getWithShiftOctave(int o) {
		return getWithOctave(octave + o);
	}

	public PitchDiatonicMidi getWithOctave(int o) {
		return from(degree, tonality, o);
	}

	@Override
	public int getOctave() {
		return octave;
	}

	public static PitchDiatonicMidi from(DiatonicDegree diatonicDegree, Tonality tonality, int octave) {
		PitchDiatonicMidi ret = new PitchDiatonicMidi();
		ret.degree = diatonicDegree;
		ret.tonality = tonality;
		ret.octave = octave;

		return ret;
	}

	@Override
	public PitchDiatonicMidi getShifted(IntervalDiatonic intervalDiatonic) {
		return getShifted(intervalDiatonic, 1);
	}

	@Override
	public PitchDiatonicMidi getShiftedNegative(IntervalDiatonic intervalDiatonic) {
		return getShifted(intervalDiatonic, -1);
	}

	private PitchDiatonicMidi getShifted(IntervalDiatonic intervalDiatonic, int signFactor) {
		int intervalDiatonicDegreeIndex = intervalDiatonic.ordinal();
		int totalIndex = degree.ordinal() + intervalDiatonicDegreeIndex * signFactor;
		int degreeIndex = totalIndex % Diatonic.NUMBER;
		DiatonicDegree diatonicDegree = DiatonicDegree.values()[degreeIndex];
		int newOctave = totalIndex / Diatonic.NUMBER;
		return PitchDiatonicMidi.from(diatonicDegree, tonality, newOctave);
	}

	@Override
	public DiatonicDegree getDegree() {
		return degree;
	}

	@Override
	public PitchDiatonicMidi getNext() {
		return getShifted(IntervalDiatonic.SECOND);
	}

	@Override
	public PitchDiatonicMidi getPrevious() {
		return getShiftedNegative(IntervalDiatonic.SECOND);
	}

	@Override
	public Diatonic getDiatonic() {
		return tonality.getNote(degree).getDiatonic();
	}

	@Override
	public void shiftOctave(int o) {
		octave += o;
	}

	@Override
	public void setOctave(int o) {
		octave = o;
	}
}
