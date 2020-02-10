package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.chromatic.ChromaticChordPattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.tonality.*;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.List;

public class TonalityGetChromaticFunction {
	static @NonNull DiatonicFunction getDiatonicFunctionFromChromaticFunction(@NonNull SecondaryDominant chromaticFunction) {
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
				return DiatonicFunction.I7;
			default:
				throw new RuntimeException();
		}
	}

	@SuppressWarnings("ConstantConditions") // DiatonicFunction.patternFrom nunca devuelve null en este contexto
	/*private static <C extends CyclicDegree> @Nullable Tonality getT(@NonNull Tonality<C> tonality, @NonNull SecondaryDominant function) throws BuildingException {
		if ( !(tonality.getRoot() instanceof Chromatic) )
			return null;
		DiatonicFunction diatonicFunction = DiatonicFunction.from(function);
		ChromaticChord chromaticChord = ChromaticChord.builder()
				.diatonicFunction(diatonicFunction)
				.tonality((Tonality<Chromatic>)tonality)
				.build();

		ChromaticChord chromaticChord2 = ChromaticChord.builder()
				.function(function)
				.tonality((Tonality<Chromatic>)tonality)
				.build();

		if ( !chromaticChord.equals(chromaticChord2) ) {
			for (Tonality<C> mode : tonality.getModesSameRoot()) {
				if (mode.equals(tonality))
					continue;

				ChromaticChord chromaticChord3 = ChromaticChord.builder()
						.function(function)
						.tonality((Tonality<Chromatic>)tonality)
						.build();
				if (chromaticChord.equals(chromaticChord3))
					return mode;
			}
		}

		return null;
	}*/

	private static ScaleRelativeDegreeException buildingException2ScaleRelativeDegreeException(BuildingException e) {
		if (e.getInnerException() instanceof ScaleRelativeDegreeException) {
			return  (ScaleRelativeDegreeException)e.getInnerException();
		} else
			throw NeverHappensException.make("");
	}

	public static @NonNull Tonality<Chromatic> getTonalityFromChromaticFunction(@NonNull Tonality<Chromatic> tonality, @NonNull ChromaticDegreeFunction chromaticDegreeFunction) {
		if (chromaticDegreeFunction.getChromaticChordPattern().equals(ChromaticChordPattern.TRIAD_MINOR)
				|| chromaticDegreeFunction.getChromaticChordPattern().equals(ChromaticChordPattern.TRIAD_MAJOR)
				|| chromaticDegreeFunction.getChromaticChordPattern().equals(ChromaticChordPattern.TRIAD_DIMINISHED)
				|| chromaticDegreeFunction.getChromaticChordPattern().equals(ChromaticChordPattern.TRIAD_AUGMENTED)) {
			if (TonalityUtils.hasAsDiatonicFunction(tonality, chromaticDegreeFunction))
				return tonality;

			ChromaticChord chromaticChord4 = null;
			try {
				chromaticChord4 = ChromaticChord.builder()
						.function(chromaticDegreeFunction)
						.tonality(tonality)
						.build();
			} catch (BuildingException e) {
				buildingException2ScaleRelativeDegreeException(e);
			}

			List<Tonality<Chromatic>> modesSameRoot;
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

			for (Tonality<Chromatic> mode : modesSameRoot)
				if (TonalityUtils.hasAsDiatonicFunction(mode, chromaticDegreeFunction))
					return mode;

			return TonalityRetrieval.listFromChordFirst(chromaticChord4);
		} else  if (chromaticDegreeFunction.getChromaticChordPattern().equals(ChromaticChordPattern.SUS4)){
			switch (chromaticDegreeFunction.getChromaticDegree()) {
				case I:
				case bII:
				case II:
				case bV:
				case V:
				case bVI:
				case VI:
					return Tonality.from(tonality.getRoot(), Scale.MAJOR);
				case bIII:
				case III:
				case IV:
				case bVII:
				case VII:
					return Tonality.from(tonality.getRoot(), Scale.MINOR);
			}
		}

		return null;
	}

	public static @NonNull Tonality<Chromatic> getTonalityFromChromaticFunction(@NonNull Tonality<Chromatic> tonality, @NonNull SecondaryDominant chromaticFunction) throws ScaleRelativeDegreeException {
		switch (chromaticFunction) {
			case V_II:
			case V7_II:
				Chromatic newRoot = tonality.getNote(DiatonicDegree.II);
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
				ChromaticChord chromaticChord = null;
				try {
					chromaticChord = ChromaticChord.builder()
							.tonality(tonality)
							.function(SecondaryDominant.V7_II)
							.build();
				} catch (BuildingException e) {
					throw buildingException2ScaleRelativeDegreeException(e);
				}
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_III:
				try {
					chromaticChord = ChromaticChord.builder()
							.tonality(tonality)
							.function(SecondaryDominant.V7_III)
							.build();
				} catch (BuildingException e) {
					throw buildingException2ScaleRelativeDegreeException(e);
				}
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_IV:
				try {
					chromaticChord = ChromaticChord.builder()
							.tonality(tonality)
							.function(SecondaryDominant.V7_IV)
							.build();
				} catch (BuildingException e) {
					throw buildingException2ScaleRelativeDegreeException(e);
				}
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_V:
				try {
					chromaticChord = ChromaticChord.builder()
							.tonality(tonality)
							.function(SecondaryDominant.V7_V)
							.build();
				} catch (BuildingException e) {
					throw buildingException2ScaleRelativeDegreeException(e);
				}
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_VI:
				try {
					chromaticChord = ChromaticChord.builder()
							.tonality(tonality)
							.function(SecondaryDominant.V7_VI)
							.build();
				} catch (BuildingException e) {
					throw buildingException2ScaleRelativeDegreeException(e);
				}
				newRootChromatic = chromaticChord.get(0).getNext(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			default:
				return tonality;
		}
	}

	static @NonNull Chromatic getNoteBaseFromChromaticFunctionAndTonality(Tonality<Chromatic> tonality, @NonNull ChromaticDegreeFunction chromaticDegreeFunction) throws ScaleRelativeDegreeException {
		return tonality.getRoot().getShifted(chromaticDegreeFunction.getChromaticDegree().ordinal());
	}
}
