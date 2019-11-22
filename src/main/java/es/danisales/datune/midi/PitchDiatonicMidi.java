package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.tonality.Tonality;

public class PitchDiatonicMidi implements PitchOctaveMidiEditable, PitchMidiInterface<IntervalDiatonic> {
	protected DiatonicDegree degree;
	protected int octave;
	protected Tonality tonality;

	public static PitchDiatonicMidi from(PitchDiatonicMidi pitchDiatonicMidi) {
		return from(pitchDiatonicMidi.degree, pitchDiatonicMidi.tonality, pitchDiatonicMidi.octave);
	}

	public static PitchDiatonicMidi from(DiatonicDegree diatonicDegree, Tonality tonality, int octave) {
		PitchDiatonicMidi ret = new PitchDiatonicMidi();
		ret.degree = diatonicDegree;
		ret.tonality = tonality;
		ret.octave = octave;

		ret.checkRange();

		return ret;
	}

	private void checkRange() {
		PitchChromaticMidi.from(this);
	}

	@Override
	public int getOctave() {
		return octave;
	}

	private void shift(IntervalDiatonic intervalDiatonic, int signFactor) {
		int intervalDiatonicDegreeIndex = intervalDiatonic.ordinal();
		int totalIndex = degree.ordinal() + intervalDiatonicDegreeIndex * signFactor;
		int degreeIndex = totalIndex % Diatonic.NUMBER;
		degree = DiatonicDegree.values()[degreeIndex];
		octave = totalIndex / Diatonic.NUMBER;
	}

	public Diatonic getDiatonic() {
		return tonality.getNote(degree).getDiatonic();
	}

	@Override
	public void shiftOctave(int octaveShift) {
		setOctave(octave + octaveShift);
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

	@Override
	public void setOctave(int octave) {
		this.octave = octave;
	}
}
