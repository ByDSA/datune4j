package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.chromatic.ChromaticChordPattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class ChordRetrievalFromTonality {
    private ChordRetrievalFromTonality() {
    }

    public static @NonNull ChromaticChord getFromDiatonicFunction(@NonNull Tonality<Chromatic> tonality, @NonNull DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        Objects.requireNonNull(diatonicFunction);

        ChromaticChord chromaticChord = null;
        if (tonality.getScale().equals(Scale.MAJOR))
            chromaticChord = TonalityGetDiatonicFunctionMajor.get(tonality, diatonicFunction);
        else if (tonality.getScale().equals(Scale.MINOR))
            chromaticChord = TonalityGetDiatonicFunctionMinor.get(tonality, diatonicFunction);

        if (chromaticChord == null)
            chromaticChord = TonalityGetDiatonicFunctionDefault.get(tonality, diatonicFunction);

        return chromaticChord;
    }

    public static @NonNull ChromaticChord getFromChromaticFunction(@NonNull Tonality<Chromatic> tonality, @NonNull ChromaticDegreeFunction chromaticDegreeFunction) throws ScaleRelativeDegreeException {
        Objects.requireNonNull(tonality);
        Objects.requireNonNull(chromaticDegreeFunction);

        ChromaticChordPattern chromaticChordPattern = chromaticDegreeFunction.getChromaticChordPattern();
        Objects.requireNonNull(chromaticChordPattern, chromaticDegreeFunction.toString());
        Chromatic noteBase = TonalityGetChromaticFunction.getNoteBaseFromChromaticFunctionAndTonality(tonality, chromaticDegreeFunction);

        ChromaticChord ret;
        try {
            ret = ChromaticChord.builder()
                    .chromaticBase(noteBase)
                    .chromaticChordPattern(chromaticChordPattern)
                    .build();
        } catch (BuildingException e) {
            throw NeverHappensException.make("");
        }

        return ret;
    }

    public static @NonNull ChromaticChord getFromChromaticFunction(@NonNull Tonality<Chromatic> tonality, @NonNull ChromaticFunction chromaticFunction) throws ScaleRelativeDegreeException {
        Objects.requireNonNull(tonality);
        Objects.requireNonNull(chromaticFunction);

        switch (chromaticFunction) {
            case V_II:
            case V_III:
            case V_IV:
            case V_V:
            case V_VI:
            case V7_II:
            case V7_III:
            case V7_IV:
            case V7_V:
            case V7_VI:
            case SUBV7:
            case SUBV7_II:
            case SUBV7_III:
            case SUBV7_IV:
            case SUBV7_V:
            case SUBV7_VI:
            case V7ALT:
                DiatonicFunction diatonicFunction = TonalityGetChromaticFunction.getDiatonicFunctionFromChromaticFunction(chromaticFunction);
                tonality = TonalityGetChromaticFunction.getTonalityFromChromaticFunction(tonality, chromaticFunction);

                try {
                    return ChromaticChord.builder()
                            .tonality(tonality)
                            .diatonicFunction(diatonicFunction)
                            .build();
                } catch (BuildingException e) {
                    if (e.getInnerException() instanceof ScaleRelativeDegreeException) {
                        throw (ScaleRelativeDegreeException)e.getInnerException();
                    } else
                        throw NeverHappensException.make("");
                }
        }

        throw NeverHappensException.switchOf(chromaticFunction);
    }
}
