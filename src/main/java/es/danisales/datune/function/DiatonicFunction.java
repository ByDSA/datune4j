package es.danisales.datune.function;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Functiones diatónicas
 *
 */
public enum DiatonicFunction implements HarmonicFunction {
	I, II, III, IV, V, VI, VII,
	I6, II6, III6, IV6, V6, VI6, VII6,
	I7, II7, III7, IV7, V7, VI7, VII7,
	I9, II9, III9, IV9, V9, VI9, VII9,
	I11, II11, III11, IV11, V11, VI11, VII11,
	I13, II13, III13, IV13, V13, VI13, VII13,

	/** Intervalos */
	I_SECOND, II_SECOND, III_SECOND, IV_SECOND, V_SECOND, VI_SECOND, VII_SECOND,
	I_THIRD, II_THIRD, III_THIRD, IV_THIRD, V_THIRD, VI_THIRD, VII_THIRD,
	I_FOURTH, II_FOURTH, III_FOURTH, IV_FOURTH, V_FOURTH, VI_FOURTH, VII_FOURTH,

	/** Con omitidos */
	I6_O5, II6_O5, III6_O5, IV6_O5, V6_O5, VI6_O5, VII6_O5,
	I7_O5, II7_O5, III7_O5, IV7_O5, V7_O5, VI7_O5, VII7_O5,
	I7_O3, II7_O3, III7_O3, IV7_O3, V7_O3, VI7_O3, VII7_O3,
	I9_O7, II9_O7, III9_O7, IV9_O7, V9_O7, VI9_O7, VII9_O7,
	I9_O3_O7, II9_O3_O7, III9_O3_O7, IV9_O3_O7, V9_O3_O7, VI9_O3_O7, VII9_O3_O7;

	/** Triadas básicas */
	public static final DiatonicFunction[] TRIADS = new DiatonicFunction[] {
			I,
			II,
			III,
			IV,
			V,
			VI,
			VII
	};

	/** Triadas con sexta */
	public static final DiatonicFunction[] SIXTH = new DiatonicFunction[] {
			I6,
			II6,
			III6,
			IV6,
			V6,
			VI6,
			VII6,
	};

	/** Con séptima */
	public static final DiatonicFunction[] SEVENTH = new DiatonicFunction[] {
			I7,
			II7,
			III7,
			IV7,
			V7,
			VI7,
			VII7
	};

	/** Con novena */
	public static final DiatonicFunction[] NINTH = new DiatonicFunction[] {
			I9,
			II9,
			III9,
			IV9,
			V9,
			VI9,
			VII9,
	};

	/**
	 * Con undécima
	 */
	public static final DiatonicFunction[] ELEVENTH = new DiatonicFunction[] {
			I11,
			II11,
			III11,
			IV11,
			V11,
			VI11,
			VII11,
	};

	/** Todas */
	public static final DiatonicFunction[] COMMON = ArrayUtils
            .concat(TRIADS, SIXTH, SEVENTH, NINTH, ELEVENTH);

	@SuppressWarnings("Duplicates")
	public static @NonNull DiatonicFunction from(@NonNull DiatonicDegree diatonicDegree) {
		switch (diatonicDegree) {
			case I:
				return I;
			case II:
				return II;
			case III:
				return III;
			case IV:
				return IV;
			case V:
				return V;
			case VI:
				return VI;
			case VII:
				return VII;
		}
		throw NeverHappensException.switchOf(diatonicDegree);
	}

	public static @Nullable DiatonicFunction from(@NonNull ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
			case I:
			case i:
			case I0:
            case I5:
				return DiatonicFunction.I;
			case II:
			case ii:
			case II0:
            case II5:
				return DiatonicFunction.II;
			case III:
			case iii:
			case III0:
            case III5:
            case bIII:
				return DiatonicFunction.III;
			case IV:
			case iv:
			case IV0:
            case IV5:
				return DiatonicFunction.IV;
			case V:
			case v:
			case V0:
            case V5:
				return DiatonicFunction.V;
			case VI:
			case vi:
			case VI0:
            case VI5:
            case bVI:
				return DiatonicFunction.VI;
			case VII:
			case vii:
			case VII0:
            case VII5:
            case bVII:
				return DiatonicFunction.VII;
		}

		return null;
	}

	public String toString() {
		switch ( this ) {
			case I_SECOND:
                return "ISUS2";
			case I_FOURTH:
                return "ISUS4";
			case I6_O5:
			case I6:
				return "I6";
			case I7_O5:
			case I7_O3:
			case I7:
				return "I7";
			case I9_O7:
			case I9_O3_O7:
			case I9:
				return "I9";
			case I11:
				return "I11";
			case I_THIRD:
			case I:
				return "I";

			case II_SECOND:
                return "IISUS2";
			case II_FOURTH:
                return "IISUS4";
			case II6_O5:
			case II6:
				return "II6";
			case II7_O5:
			case II7_O3:
			case II7:
				return "II7";
			case II9_O7:
			case II9_O3_O7:
			case II9:
				return "II9";
			case II11:
				return "II11";
			case II_THIRD:
			case II:
				return "II";

			case III_SECOND:
                return "bIIISUS2";
			case III_FOURTH:
                return "bIIISUS4";
			case III6_O5:
			case III6:
				return "III6";
			case III7_O5:
			case III7_O3:
			case III7:
				return "III7";
			case III9_O7:
			case III9_O3_O7:
			case III9:
				return "III9";
			case III11:
				return "III11";
			case III_THIRD:
			case III:
				return "III";

			case IV_SECOND:
                return "IVSUS2";
			case IV_FOURTH:
                return "IVSUS4";
			case IV6_O5:
			case IV6:
				return "IV6";
			case IV7_O5:
			case IV7_O3:
			case IV7:
				return "IV7";
			case IV9_O7:
			case IV9_O3_O7:
			case IV9:
				return "IV9";
			case IV11:
				return "IV11";
			case IV_THIRD:
			case IV:
				return "IV";

			case V_SECOND:
                return "VSUS2";
			case V_FOURTH:
                return "VSUS4";
			case V6_O5:
			case V6:
				return "V6";
			case V9_O7:
			case V9_O3_O7:
			case V9:
				return "V9";
			case V11:
				return "V11";
			case V_THIRD:
			case V:
				return "V";

			case V7_O5:
			case V7_O3:
			case V7:
				return "V7";

			case VI_SECOND:
                return "bVISUS2";
			case VI_FOURTH:
                return "VISUS4";
			case VI6_O5:
			case VI6:
				return "VI6";
			case VI7_O5:
			case VI7_O3:
			case VI7:
				return "VI7";
			case VI9_O7:
			case VI9_O3_O7:
			case VI9:
				return "VI9";
			case VI11:
				return "VI11";
			case VI_THIRD:
			case VI:
				return "VI";

			case VII_SECOND:
                return "bVIISUS2";
			case VII_FOURTH:
                return "bVIISUS4";
			case VII6_O5:
			case VII6:
				return "VII6";
			case VII7_O5:
			case VII7_O3:
			case VII7:
				return "VII7";
			case VII9_O7:
			case VII9_O3_O7:
			case VII9:
				return "VII9";
			case VII11:
				return "VII11";
			case VII_THIRD:
			case VII:
				return "VII";
			case I13:
				return "I13";
			case II13:
				return "II13";
			case III13:
				return "III13";
			case IV13:
				return "IV13";
			case V13:
				return "V13";
			case VI13:
				return "VI13";
			case VII13:
				return "VII13";
			default:
				return "NaN";
		}
	}

	public static @Nullable DiatonicFunction from(@NonNull ChromaticChord chromaticChord, @NonNull Tonality tonality) {
		HarmonicFunction harmonicFunction = tonality.getFunctionFrom(chromaticChord);
		if (harmonicFunction instanceof DiatonicFunction)
			return (DiatonicFunction) harmonicFunction;

		return null;
	}
}
