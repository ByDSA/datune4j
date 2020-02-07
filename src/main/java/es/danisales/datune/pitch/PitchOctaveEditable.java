package es.danisales.datune.pitch;

public interface PitchOctaveEditable extends PitchOctave {
    <E extends PitchException> void shiftOctave(int octaveShift) throws E;

    <E extends PitchException> void setOctave(int octave) throws E;
}
