package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.chromatic.ChromaticChordPattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class ChordRetrievalFromTonality {
    private ChordRetrievalFromTonality() {
    }

    public static @NonNull ChromaticChord getFromDiatonicFunction(@NonNull Tonality tonality, @NonNull DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        Objects.requireNonNull(diatonicFunction);

        ChromaticChord chromaticChord = TonalityGetDiatonicFunctionMajor.get(tonality, diatonicFunction);
        if (chromaticChord == null)
            chromaticChord = TonalityGetDiatonicFunctionMinor.get(tonality, diatonicFunction);
        if (chromaticChord == null)
            chromaticChord = TonalityGetDiatonicFunctionDefault.get(tonality, diatonicFunction);

        return chromaticChord;
    }

    public static @NonNull ChromaticChord getFromChromaticFunction(@NonNull Tonality<Chromatic> tonality, @NonNull ChromaticFunction chromaticFunction) throws ScaleRelativeDegreeException {
        Objects.requireNonNull(tonality);
        Objects.requireNonNull(chromaticFunction);

        switch (chromaticFunction) {
            case ISUS4:
            case IISUS4:
            case bIIISUS4:
            case IVSUS4:
            case VSUS4:
            case VISUS4:
            case bVIISUS4:
            case I:
            case II:
            case III:
            case IV:
            case V:
            case VI:
            case VII:
            case i:
            case ii:
            case iii:
            case iv:
            case v:
            case vi:
            case vii:
            case I0:
            case II0:
            case III0:
            case IV0:
            case V0:
            case VI0:
            case VII0:
            case I5:
            case II5:
            case III5:
            case IV5:
            case V5:
            case VI5:
            case VII5:
            case N6:
                ChromaticChordPattern chromaticChordPattern = TonalityGetChromaticFunction.getChromaticChordPatternFromChromaticFunction(chromaticFunction);
                Objects.requireNonNull(chromaticChordPattern, chromaticFunction.toString());
                Chromatic noteBase = TonalityGetChromaticFunction.getNoteBaseFromChromaticFunctionAndTonality(tonality, chromaticFunction);

                ChromaticChord ret = ChromaticChord.builder()
                        .chromaticBase(noteBase)
                        .chromaticChordPattern(chromaticChordPattern)
                        .build();

                if (chromaticFunction == ChromaticFunction.N6)
                    ret.setRootIndex(2);

                return ret;
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

                return ChromaticChord.builder()
                        .tonality(tonality)
                        .diatonicFunction(diatonicFunction)
                        .build();
            case bVII: {
                Tonality parallelMinor;
                if (tonality.getScale().equals(Scale.MINOR))
                    parallelMinor = tonality;
                else
                    parallelMinor = Tonality.from(tonality.getRoot(), Scale.MINOR);

                return ChromaticChord.builder()
                        .diatonicFunction(DiatonicFunction.VII)
                        .tonality(parallelMinor)
                        .build();
            }
            case bVI: {
                Tonality parallelMinor;
                if (tonality.getScale().equals(Scale.MINOR))
                    parallelMinor = tonality;
                else
                    parallelMinor = Tonality.from(tonality.getRoot(), Scale.MINOR);

                return ChromaticChord.builder()
                        .diatonicFunction(DiatonicFunction.VI)
                        .tonality(parallelMinor)
                        .build();
            }
            case bIII: {
                Tonality parallelMinor;
                if (tonality.getScale().equals(Scale.MINOR))
                    parallelMinor = tonality;
                else
                    parallelMinor = Tonality.from(tonality.getRoot(), Scale.MINOR);

                return ChromaticChord.builder()
                        .diatonicFunction(DiatonicFunction.III)
                        .tonality(parallelMinor)
                        .build();
            }
        }

        throw NeverHappensException.switchOf(chromaticFunction);
    }
}
