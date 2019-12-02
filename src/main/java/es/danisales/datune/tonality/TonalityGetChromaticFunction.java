package es.danisales.datune.tonality;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.ChromaticChordPattern;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

public class TonalityGetChromaticFunction {
	private static @Nullable ChromaticChordPattern getChromaticChordPatternFromChromaticFunction(@NonNull ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
			case I:
			case II:
			case III:
			case IV:
			case V:
			case VI:
			case VII:
				return ChromaticChordPattern.TRIAD_MAJOR;
			case i:
			case ii:
			case iii:
			case iv:
			case v:
			case vi:
			case vii:
				return ChromaticChordPattern.TRIAD_MINOR;
			case I0:
			case II0:
			case III0:
			case IV0:
			case V0:
			case VI0:
			case VII0:
				return ChromaticChordPattern.TRIAD_DIMINISHED;
			case I5:
			case II5:
			case III5:
			case IV5:
			case V5:
			case VI5:
			case VII5:
				return ChromaticChordPattern.POWER_CHORD;
			case N6:
				return ChromaticChordPattern.N6;
			default:
				return null;
		}
	}

	private static @NonNull DiatonicFunction getDiatonicFunctionFromChromaticFunction(@NonNull ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
			case V_II:
			case V_III:
			case V_IV:
			case V_V:
			case V_VI:
				return DiatonicFunction.V;
			case V7_II:
			case V7_III:
			case V7_IV:
			case V7_V:
			case V7_VI:
				return DiatonicFunction.V7;
			case SUBV7:
			case SUBV7_II:
			case SUBV7_III:
			case SUBV7_IV:
			case SUBV7_V:
			case SUBV7_VI:
			case V7ALT:
				return DiatonicFunction.I7;
			default:
				throw new RuntimeException();
		}
	}

    public static @NonNull ChromaticChord get(@NonNull Tonality tonality, @NonNull ChromaticFunction chromaticFunction) throws TonalityException {
		Objects.requireNonNull(tonality);
		Objects.requireNonNull(chromaticFunction);

		switch (chromaticFunction) {
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
				ChromaticChordPattern chromaticChordPattern = getChromaticChordPatternFromChromaticFunction(chromaticFunction);
				Objects.requireNonNull(chromaticChordPattern);
                DiatonicAlt noteBase = getNoteBaseFromChromaticFunctionAndTonality(tonality, chromaticFunction);
                if (noteBase == null)
                    throw new TonalityException(tonality, chromaticFunction);

				Chromatic noteBaseChromatic = Chromatic.from(noteBase);
                ChromaticChord ret = ChromaticChord.builder()
                        .chromaticBase(noteBaseChromatic)
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
				DiatonicFunction diatonicFunction = getDiatonicFunctionFromChromaticFunction(chromaticFunction);
				tonality = getTonalityFromChromaticFunction(tonality, chromaticFunction);

                return ChromaticChord.builder()
                        .tonality(tonality)
                        .diatonicFunction(diatonicFunction)
                        .build();
		}

		return null;
	}

    @SuppressWarnings("ConstantConditions") // DiatonicFunction.from nunca devuelve null en este contexto
    private static @Nullable Tonality getT(@NonNull Tonality tonality, @NonNull ChromaticFunction chromaticFunction) {
        DiatonicFunction diatonicFunction = DiatonicFunction.from(chromaticFunction);
        ChromaticChord chromaticChord = ChromaticChord.builder()
                .diatonicFunction(diatonicFunction)
                .tonality(tonality)
                .build();

        ChromaticChord chromaticChord2 = ChromaticChord.builder()
                .chromaticFunction(chromaticFunction)
                .tonality(tonality)
                .build();

        if (!chromaticChord.equals(chromaticChord2)) {
            for (Tonality mode : tonality.getModesSameRoot()) {
                if (mode.equals(tonality))
                    continue;

                ChromaticChord chromaticChord3 = ChromaticChord.builder()
                        .chromaticFunction(chromaticFunction)
                        .tonality(tonality)
                        .build();
                if (chromaticChord.equals(chromaticChord3))
                    return mode;
            }
        }

        return null;
    }

    public static @NonNull Tonality getTonalityFromChromaticFunction(@NonNull Tonality tonality, @NonNull ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
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
                if (tonality.hasAsDiatonicFunction(chromaticFunction))
                    return tonality;

                ChromaticChord chromaticChord4 = ChromaticChord.builder()
                        .chromaticFunction(chromaticFunction)
                        .tonality(tonality)
                        .build();

                for (Tonality mode : tonality.getModesSameRoot()) {
                    ChromaticChord chromaticChord2 = ChromaticChord.builder()
                            .chromaticFunction(chromaticFunction)
                            .tonality(mode)
                            .build();

                    if (chromaticChord2.equals(chromaticChord4))
                        return mode;
                }
				return TonalityRetrieval.listFromChordFirst(chromaticChord4);
            case N6:
                throw new RuntimeException();
			case V_II:
			case V7_II:
				DiatonicAlt newRoot = tonality.getNote(DiatonicDegree.II);
				return Tonality.from(newRoot, tonality.getScale());
			case V_III:
			case V7_III:
				newRoot = tonality.getNote(DiatonicDegree.III);
				return Tonality.from(newRoot, tonality.getScale());
			case V_IV:
			case V7_IV:
				newRoot = tonality.getNote(DiatonicDegree.IV);
				return Tonality.from(newRoot, tonality.getScale());
			case V_V:
			case V7_V:
				newRoot = tonality.getNote(DiatonicDegree.V);
				return Tonality.from(newRoot, tonality.getScale());
			case V_VI:
			case V7_VI:
				newRoot = tonality.getNote(DiatonicDegree.VI);
				return Tonality.from(newRoot, tonality.getScale());
			case SUBV7:
				newRoot = tonality.getNote(DiatonicDegree.V);
				Chromatic newRootChromatic = Chromatic.from(newRoot).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_II:
                ChromaticChord chromaticChord = ChromaticChord.builder()
                        .tonality(tonality)
                        .chromaticFunction(ChromaticFunction.V7_II)
                        .build();
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_III:
                chromaticChord = ChromaticChord.builder()
                        .tonality(tonality)
                        .chromaticFunction(ChromaticFunction.V7_III)
                        .build();
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_IV:
                chromaticChord = ChromaticChord.builder()
                        .tonality(tonality)
                        .chromaticFunction(ChromaticFunction.V7_IV)
                        .build();
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_V:
                chromaticChord = ChromaticChord.builder()
                        .tonality(tonality)
                        .chromaticFunction(ChromaticFunction.V7_V)
                        .build();
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_VI:
                chromaticChord = ChromaticChord.builder()
                        .tonality(tonality)
                        .chromaticFunction(ChromaticFunction.V7_VI)
                        .build();
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case V7ALT:
				newRoot = tonality.getNote(DiatonicDegree.V);
				return Tonality.from(newRoot, Scale.SUPERLOCRIAN);
            default:
                return tonality;
		}
	}

    private static @Nullable DiatonicAlt getNoteBaseFromChromaticFunctionAndTonality(Tonality tonality, @NonNull ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
			case I:
			case i:
			case I0:
			case I5:
				return tonality.getNote(DiatonicDegree.I);
			case II:
			case ii:
			case II0:
			case II5:
				return tonality.getNote(DiatonicDegree.II);
			case III:
			case iii:
			case III0:
			case III5:
				return tonality.getNote(DiatonicDegree.III);
			case IV:
			case iv:
			case IV0:
			case IV5:
				return tonality.getNote(DiatonicDegree.IV);
			case V:
			case v:
			case V0:
			case V5:
				return tonality.getNote(DiatonicDegree.V);
			case VI:
			case vi:
			case VI0:
			case VI5:
				return tonality.getNote(DiatonicDegree.VI);
			case VII:
			case vii:
			case VII0:
			case VII5:
				return tonality.getNote(DiatonicDegree.VII);
			case N6:
				return tonality.getNote(DiatonicDegree.I);
		}

        throw new RuntimeException(tonality + " " + chromaticFunction);
	}
}
