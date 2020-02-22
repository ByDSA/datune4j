package es.danisales.datune.function;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

public class TonalityGetChromaticFunction {


	static @NonNull Chromatic getNoteBaseFromChromaticFunctionAndTonality(Tonality<Chromatic> tonality, @NonNull ChromaticDegreeFunction chromaticDegreeFunction) throws ScaleRelativeDegreeException {
		return tonality.getRoot().getShifted(chromaticDegreeFunction.getChromaticDegree().ordinal());
	}
}
