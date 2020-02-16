package es.danisales.datune.function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.chromatic.ChromaticChordPattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public enum SecondaryDominant implements ChromaticFunction {
	/** Dominantes secundarios */
	V_II(Type.V, ChromaticDegreeFunction.VI),
	V_III(Type.V, ChromaticDegreeFunction.VII),
	V_IV(Type.V, ChromaticDegreeFunction.I),
	V_V(Type.V, ChromaticDegreeFunction.II),
	V_VI(Type.V, ChromaticDegreeFunction.III),

	/** Dominantes secundarios con séptima */
	V7_II(Type.V7, ChromaticDegreeFunction.VI7),
	V7_III(Type.V7, ChromaticDegreeFunction.VII7),
	V7_IV(Type.V7, ChromaticDegreeFunction.I7),
	V7_V(Type.V7, ChromaticDegreeFunction.II7),
	V7_VI(Type.V7, ChromaticDegreeFunction.III7),

	/** SUBV7 */
	SUBV7(Type.SUBV7, ChromaticDegreeFunction.bII7),
	SUBV7_II(Type.SUBV7, ChromaticDegreeFunction.bIII7),
	SUBV7_III(Type.SUBV7, ChromaticDegreeFunction.IV7),
	SUBV7_IV(Type.SUBV7, ChromaticDegreeFunction.bV7),
	SUBV7_V(Type.SUBV7, ChromaticDegreeFunction.bVI7),
	SUBV7_VI(Type.SUBV7, ChromaticDegreeFunction.bVII7);

		/* https://guitarmonia.es/dominantes-secundarios/

	I: V7/IV
	bII: SubV7
	II: V7/V
	bIII: SubV7/II
	III: V7/VI
	IV: SubV7/III
	bV: SubV7/IV
	V: V7/I
	bVI, Ab7, SubV7/V
	VI: V7/II
	bVII: SubV7/VI
	VII: V7/III

	 */

	public enum Type {
		V, V7, SUBV7
	}

	private final Type type;
	private final ChromaticDegreeFunction chromaticDegreeFunction;

	SecondaryDominant(Type type, ChromaticDegreeFunction chromaticDegreeFunction) {
		this.type = type;
		this.chromaticDegreeFunction = chromaticDegreeFunction;
	}

	/** Dominantes secundarios triada */
	public static final List<SecondaryDominant> V_FUNCTIONS = new ImmutableList.Builder<SecondaryDominant>()
			.add(
					V_II,
					V_III,
					V_IV,
					V_V,
					V_VI)
			.build();

	/** Seventh */
	public static final List<SecondaryDominant> V7_FUNCTIONS = new ImmutableList.Builder<SecondaryDominant>()
			.add(V7_II,
					V7_III,
					V7_IV,
					V7_V,
					V7_VI)
			.build();

	public static final List<SecondaryDominant> SUBV7_FUNCTIONS = new ImmutableList.Builder<SecondaryDominant>()
			.add(SUBV7,
					SUBV7_II,
					SUBV7_III,
					SUBV7_IV,
					SUBV7_V,
					SUBV7_VI)
			.build();

	/** The Constant ALL. */
	public static final List<SecondaryDominant> ALL = new ImmutableList.Builder<SecondaryDominant>()
			.addAll(V_FUNCTIONS)
			.addAll(V7_FUNCTIONS)
			.addAll(SUBV7_FUNCTIONS)
			.build();

	/*
	 * FIN CONSTANTES
	 **********************************************************************************************************/

	@SuppressWarnings("Duplicates")
	@Nullable
	public static SecondaryDominant from(Type type, DiatonicDegree diatonicDegree) {
		switch (type) {
			case V:
				switch (diatonicDegree) {
					case II: return V_II;
					case III: return V_III;
					case IV: return V_IV;
					case V: return V_V;
					case VI: return V_VI;
				}
				break;
			case V7:
				switch (diatonicDegree) {
					case II: return V7_II;
					case III: return V7_III;
					case IV: return V7_IV;
					case V: return V7_V;
					case VI: return V7_VI;
				}
				break;
			case SUBV7:
				switch (diatonicDegree) {
					case I: return SUBV7;
					case II: return SUBV7_II;
					case III: return SUBV7_III;
					case IV: return SUBV7_IV;
					case V: return SUBV7_V;
					case VI: return SUBV7_VI;
				}
				break;
		}

		return null;
	}

	private final static Map<ChromaticDegreeFunction, SecondaryDominant> map = new ImmutableMap.Builder<ChromaticDegreeFunction, SecondaryDominant>()
			.put(ChromaticDegreeFunction.I, V_IV)
			.put(ChromaticDegreeFunction.II, V_V)
			.put(ChromaticDegreeFunction.III, V_VI)
			.put(ChromaticDegreeFunction.VI, V_II)
			.put(ChromaticDegreeFunction.VII, V_III)
			.put(ChromaticDegreeFunction.I7, V7_IV)
			.put(ChromaticDegreeFunction.II7, V7_V)
			.put(ChromaticDegreeFunction.III7, V7_VI)
			.put(ChromaticDegreeFunction.VI7, V7_II)
			.put(ChromaticDegreeFunction.VII7, V7_III)
			.put(ChromaticDegreeFunction.bII7, SUBV7)
			.put(ChromaticDegreeFunction.bIII7, SUBV7_II)
			.put(ChromaticDegreeFunction.IV7, SUBV7_III)
			.put(ChromaticDegreeFunction.bV7, SUBV7_IV)
			.put(ChromaticDegreeFunction.bVI7, SUBV7_V)
			.put(ChromaticDegreeFunction.bVII7, SUBV7_VI)
			.build();

	public @NonNull String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		switch (type) {
			case V:
				stringBuilder.append("V");
				break;
			case V7:
				stringBuilder.append("V7");
				break;
			case SUBV7:
				stringBuilder.append("SUBV7");
				break;
		}

		stringBuilder.append("/")
				.append(chromaticDegreeFunction);
		return stringBuilder.toString();
	}

	@Override
	@NonNull
	public ChromaticChord getChromaticChordFromTonality(Tonality<Chromatic> tonality) throws ScaleRelativeDegreeException {
		Objects.requireNonNull(tonality);

		Chromatic chromaticTarget = getTargetChromatic(tonality, this);

		switch (type) {
			case V:
				return secondaryDominantTriad(chromaticTarget);
			case V7:
				return secondaryDominant7(chromaticTarget);
			case SUBV7:
				return subv7(tonality, this);
		}

		throw NeverHappensException.switchOf(this);
	}

	@Override
	public @NonNull ChromaticFunction getShifted(int i) {
		ChromaticFunction secondaryDominant = from(chromaticDegreeFunction.getShifted(i));
		if (secondaryDominant == null) {
			switch (type) {
				case V:
					return ChromaticDegreeFunction.V;
				case V7:
				case SUBV7:
					return ChromaticDegreeFunction.V7;
			}
		}

		return secondaryDominant;
	}

	private @Nullable ChromaticFunction from(ChromaticDegreeFunction chromaticDegreeFunction) {
		return map.get(chromaticDegreeFunction);
	}

	private static @NonNull ChromaticChord secondaryDominantTriad(Chromatic target) {
		Chromatic fifthOf = fifthOf(target);

		try {
			return ChromaticChord.builder()
					.chromaticBase(fifthOf)
					.chromaticChordPattern(ChromaticChordPattern.TRIAD_MAJOR)
					.build();
		} catch (BuildingException e) {
			throw NeverHappensException.make("");
		}
	}

	private static @NonNull ChromaticChord secondaryDominant7(Chromatic target) {
		Chromatic fifthOf = fifthOf(target);

		try {
			return ChromaticChord.builder()
					.chromaticBase(fifthOf)
					.chromaticChordPattern(ChromaticChordPattern.SEVENTH)
					.build();
		} catch (BuildingException e) {
			throw NeverHappensException.make("");
		}
	}

	private static Chromatic fifthOf(Chromatic target) {
		return target.getShifted(-5);
	}

	private static @NonNull ChromaticChord subv7(Tonality<Chromatic> tonality, SecondaryDominant secondaryDominant) throws ScaleRelativeDegreeException {
		ChromaticChordPattern chromaticChordPattern = getPattern(secondaryDominant);
		Chromatic chromatic = getTargetChromatic(tonality, secondaryDominant);
		chromatic = chromatic.getNext();
		try {
			return ChromaticChord.builder()
					.chromaticBase(chromatic)
					.chromaticChordPattern(chromaticChordPattern)
					.build();
		} catch (BuildingException e) {
			throw NeverHappensException.make("");
		}
	}

	private static Chromatic getTargetChromatic(Tonality<Chromatic> tonality, SecondaryDominant chromaticFunction) throws ScaleRelativeDegreeException {
		switch (chromaticFunction) {
			case SUBV7:
				return tonality.getRoot();
			case V_II:
			case V7_II:
			case SUBV7_II:
				return tonality.getNote(DiatonicDegree.II);
			case V_III:
			case V7_III:
			case SUBV7_III:
				return tonality.getNote(DiatonicDegree.III);
			case V_IV:
			case V7_IV:
			case SUBV7_IV:
				return tonality.getNote(DiatonicDegree.IV);
			case V_V:
			case V7_V:
			case SUBV7_V:
				return tonality.getNote(DiatonicDegree.V);
			case V_VI:
			case V7_VI:
			case SUBV7_VI:
				return tonality.getNote(DiatonicDegree.VI);
		}

		throw NeverHappensException.switchOf(chromaticFunction);
	}

	private static ChromaticChordPattern getPattern(SecondaryDominant chromaticFunction) {
		switch (chromaticFunction) {
			case V_II:
			case V_III:
			case V_IV:
			case V_V:
			case V_VI:
				return ChromaticChordPattern.TRIAD_MAJOR;
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
				return ChromaticChordPattern.SEVENTH;
		}

		throw NeverHappensException.switchOf(chromaticFunction);
	}
}
