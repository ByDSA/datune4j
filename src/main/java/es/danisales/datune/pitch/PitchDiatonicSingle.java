package es.danisales.datune.pitch;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.tonality.Tonality;

public interface PitchDiatonicSingle extends PitchDiatonic, SymbolicPitch {
	Diatonic getDiatonic();
}
