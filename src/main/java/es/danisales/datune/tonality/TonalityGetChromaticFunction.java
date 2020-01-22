package es.danisales.datune.tonality;

import es.danisales.datune.degrees.CyclicDegree;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.ChromaticChordPattern;
import es.danisales.datune.chords.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TonalityGetChromaticFunction {
	static @Nullable ChromaticChordPattern getChromaticChordPatternFromChromaticFunction(@NonNull ChromaticFunction chromaticFunction) {
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
			case ISUS4:
			case IISUS4:
			case bIIISUS4:
			case IVSUS4:
			case VSUS4:
			case VISUS4:
			case bVIISUS4:
				return ChromaticChordPattern.SUS4;
			case N6:
				return ChromaticChordPattern.N6;
			case V_II:
				break;
			case V_III:
				break;
			case V_IV:
				break;
			case V_V:
				break;
			case V_VI:
				break;
			case V7_II:
				break;
			case V7_III:
				break;
			case V7_IV:
				break;
			case V7_V:
				break;
			case V7_VI:
				break;
			case SUBV7:
				break;
			case SUBV7_II:
				break;
			case SUBV7_III:
				break;
			case SUBV7_IV:
				break;
			case SUBV7_V:
				break;
			case SUBV7_VI:
				break;
			case V7ALT:
				break;
			case bVII:
				return ChromaticChordPattern.TRIAD_MAJOR;
			case bVI:
				return ChromaticChordPattern.TRIAD_MAJOR;
		}

		return null;
	}

	static @NonNull DiatonicFunction getDiatonicFunctionFromChromaticFunction(@NonNull ChromaticFunction chromaticFunction) {
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

	@SuppressWarnings("ConstantConditions") // DiatonicFunction.patternFrom nunca devuelve null en este contexto
	private static <C extends CyclicDegree> @Nullable Tonality getT(@NonNull Tonality<C> tonality, @NonNull ChromaticFunction chromaticFunction) {
		DiatonicFunction diatonicFunction = DiatonicFunction.from(chromaticFunction);
		ChromaticChord chromaticChord = ChromaticChord.builder()
				.diatonicFunction(diatonicFunction)
				.tonality(tonality)
				.build();

		ChromaticChord chromaticChord2 = ChromaticChord.builder()
				.chromaticFunction(chromaticFunction)
				.tonality(tonality)
				.build();

		if ( !chromaticChord.equals(chromaticChord2) ) {
			for (Tonality<C> mode : tonality.getModesSameRoot()) {
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

	public static @NonNull Tonality getTonalityFromChromaticFunction(@NonNull Tonality<DiatonicAlt> tonality, @NonNull ChromaticFunction chromaticFunction) throws ScaleRelativeDegreeException {
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
			case bVII:
			case bVI:
			case bIII:
				if (TonalityUtils.hasAsDiatonicFunction(tonality, chromaticFunction))
					return tonality;

				ChromaticChord chromaticChord4 = ChromaticChord.builder()
						.chromaticFunction(chromaticFunction)
						.tonality(tonality)
						.build();

				List<Tonality> modesSameRoot;
				if (tonality.getScale().equals(Scale.MAJOR)
						|| tonality.getScale().equals(Scale.MINOR)
						|| tonality.getScale().equals(Scale.DORIAN)
						|| tonality.getScale().equals(Scale.MIXOLYDIAN)
						|| tonality.getScale().equals(Scale.PHRYGIAN)
						|| tonality.getScale().equals(Scale.LYDIAN)
						|| tonality.getScale().equals(Scale.LOCRIAN)
				)
					modesSameRoot = Arrays.asList(
							Tonality.from(tonality.getRoot(), Scale.MAJOR),
							Tonality.from(tonality.getRoot(), Scale.MINOR),
							Tonality.from(tonality.getRoot(), Scale.MIXOLYDIAN),
							Tonality.from(tonality.getRoot(), Scale.DORIAN),
							Tonality.from(tonality.getRoot(), Scale.PHRYGIAN),
							Tonality.from(tonality.getRoot(), Scale.LYDIAN),
							Tonality.from(tonality.getRoot(), Scale.LOCRIAN)
					);
				else
					modesSameRoot = tonality.getModesSameRoot();

				for (Tonality mode : modesSameRoot) {
					DiatonicFunction diatonicFunction = DiatonicFunction.from(chromaticFunction);

					Objects.requireNonNull(diatonicFunction, chromaticFunction.toString());

					ChromaticChord chromaticChord2 = ChromaticChord.builder()
							.diatonicFunction(diatonicFunction)
							.tonality(mode)
							.build();

					if (chromaticChord2.equals(chromaticChord4))
						return mode;
				}
				return TonalityRetrieval.listFromChordFirst(chromaticChord4);
			case ISUS4:
			case IISUS4:
			case VSUS4:
			case VISUS4:
				return Tonality.from(tonality.getRoot(), Scale.MAJOR);
			case IVSUS4:
				return Tonality.from(tonality.getRoot(), Scale.MINOR);

			case bIIISUS4:
			case bVIISUS4:
				return Tonality.from(tonality.getRoot(), Scale.MINOR);
			case N6:
				DiatonicAlt diatonicAlt = tonality.getRoot().getAddSemi(1);
				return Tonality.from(diatonicAlt, Scale.MAJOR);
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

	static @NonNull DiatonicAlt getNoteBaseFromChromaticFunctionAndTonality(Tonality<DiatonicAlt> tonality, @NonNull ChromaticFunction chromaticFunction) throws ScaleRelativeDegreeException {
		switch (chromaticFunction) {
			case I:
			case i:
			case I0:
			case I5:
				return tonality.getNote(DiatonicDegree.I);
			case ISUS4:
				return Tonality.from(tonality.getRoot(), Scale.MAJOR).getNote(DiatonicDegree.I);
			case II:
			case ii:
			case II0:
			case II5:
				return tonality.getNote(DiatonicDegree.II);
			case IISUS4:
				return Tonality.from(tonality.getRoot(), Scale.MAJOR).getNote(DiatonicDegree.II);
			case III:
			case iii:
			case III0:
			case III5:
				return tonality.getNote(DiatonicDegree.III);
			case bIIISUS4:
			case bIII:
				return Tonality.from(tonality.getRoot(), Scale.MINOR).getNote(DiatonicDegree.III);
			case IV:
			case iv:
			case IV0:
			case IV5:
				return tonality.getNote(DiatonicDegree.IV);
			case IVSUS4:
				return Tonality.from(tonality.getRoot(), Scale.MAJOR).getNote(DiatonicDegree.IV);
			case V:
			case v:
			case V0:
			case V5:
				return tonality.getNote(DiatonicDegree.V);
			case VSUS4:
				return Tonality.from(tonality.getRoot(), Scale.MAJOR).getNote(DiatonicDegree.V);
			case VI:
			case vi:
			case VI0:
			case VI5:
				return tonality.getNote(DiatonicDegree.VI);
			case VISUS4:
				return Tonality.from(tonality.getRoot(), Scale.MAJOR).getNote(DiatonicDegree.VI);
			case bVI:
				return Tonality.from(tonality.getRoot(), Scale.MINOR).getNote(DiatonicDegree.VI);
			case VII:
			case vii:
			case VII0:
			case VII5:
				return tonality.getNote(DiatonicDegree.VII);
			case bVII:
			case bVIISUS4:
				return Tonality.from(tonality.getRoot(), Scale.MINOR).getNote(DiatonicDegree.VII);
			case N6:
				return tonality.getNote(DiatonicDegree.I);
		}

		throw new RuntimeException(tonality + " " + chromaticFunction);
	}
}
