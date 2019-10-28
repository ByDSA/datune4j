package es.danisales.datune.pitch;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;

public interface PitchChromaticSingle extends SymbolicPitch {
	Chromatic getChromatic();
	Diatonic getDiatonic(Tonality ton) throws TonalityException;
}
