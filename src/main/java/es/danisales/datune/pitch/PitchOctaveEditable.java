package es.danisales.datune.pitch;

public interface PitchOctaveEditable extends PitchOctave {
	void shiftOctave(int o);
	void setOctave(int o);
}
