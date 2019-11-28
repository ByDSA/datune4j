package es.danisales.datune.pitch;

public interface PitchOctaveEditable {
    <E extends PitchException> void shiftOctave(int octaveShift) throws E;

    <E extends PitchException> void setOctave(int octave) throws E;
}
