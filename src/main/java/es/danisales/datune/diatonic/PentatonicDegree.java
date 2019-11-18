package es.danisales.datune.diatonic;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Grado
 */
public enum PentatonicDegree implements RelativeDegree {
	I, II, III, IV, V;

	public static @Nullable PentatonicDegree from(DiatonicFunction diatonicFunction) {
		switch ( diatonicFunction ) {
			case I:
			case I2:
			case I4:
			case I6:
			case I7:
			case I9:
			case I_THIRD:
			case I_SECOND:
			case I_FOURTH:
			case I6_O5:
			case I7_O5:
			case I7_O3:
			case I9_O7:
			case I9_O3_O7:
			case I11:
			case I13:
				return PentatonicDegree.I;
			case II:
			case II2:
			case II4:
			case II6:
			case II7:
			case II9:
			case II11:
			case II_THIRD:
			case II_SECOND:
			case II_FOURTH:
			case II6_O5:
			case II7_O5:
			case II7_O3:
			case II9_O7:
			case II9_O3_O7:
			case II13:
				return PentatonicDegree.II;
			case III:
			case III2:
			case III4:
			case III6:
			case III7:
			case III9:
			case III11:
			case III_THIRD:
			case III_SECOND:
			case III_FOURTH:
			case III6_O5:
			case III7_O5:
			case III7_O3:
			case III9_O7:
			case III9_O3_O7:
			case III13:
				return PentatonicDegree.III;
			case IV:
			case IV2:
			case IV4:
			case IV6:
			case IV7:
			case IV9:
			case IV11:
			case IV_THIRD:
			case IV_SECOND:
			case IV_FOURTH:
			case IV6_O5:
			case IV7_O5:
			case IV7_O3:
			case IV9_O7:
			case IV9_O3_O7:
			case IV13:
				return null;
			case V:
			case V2:
			case V4:
			case V6:
			case V7:
			case V9:
			case V11:
			case V_THIRD:
			case V_SECOND:
			case V_FOURTH:
			case V6_O5:
			case V7_O5:
			case V7_O3:
			case V9_O7:
			case V9_O3_O7:
			case V13:
				return PentatonicDegree.IV;
			case VI:
			case VI2:
			case VI4:
			case VI6:
			case VI7:
			case VI9:
			case VI11:
			case VI_THIRD:
			case VI_SECOND:
			case VI_FOURTH:
			case VI6_O5:
			case VI7_O5:
			case VI7_O3:
			case VI9_O7:
			case VI9_O3_O7:
			case VI13:
				return PentatonicDegree.V;
			case VII:
			case VII2:
			case VII4:
			case VII6:
			case VII7:
			case VII9:
			case VII11:
			case VII_THIRD:
			case VII_SECOND:
			case VII_FOURTH:
			case VII6_O5:
			case VII7_O5:
			case VII7_O3:
			case VII9_O7:
			case VII9_O3_O7:
			case VII13:
				return null;
		}
		throw new RuntimeException("Impossible");
	}

	public static @Nullable PentatonicDegree from(@NonNull ChromaticFunction chromaticFunction) {
		switch ( chromaticFunction ) {
			case I:
			case I5:
			case i:
			case I0:
				return PentatonicDegree.I;
			case II:
			case II5:
			case ii:
			case II0:
			case N6:
				return PentatonicDegree.II;
			case III:
			case III5:
			case iii:
			case III0:
				return PentatonicDegree.III;
			case IV:
			case IV5:
			case iv:
			case IV0:
				return null;
			case V:
			case V5:
			case v:
			case V0:
				return PentatonicDegree.IV;
			case VI:
			case VI5:
			case vi:
			case VI0:
				return PentatonicDegree.V;
			case VII:
			case VII5:
			case vii:
			case VII0:
				return null;
			case SUBV7:
			case V7ALT:
				return PentatonicDegree.I;
			case SUBV7_II:
			case V7_II:
			case V_II:
				return PentatonicDegree.II;
			case SUBV7_III:
			case V7_III:
			case V_III:
				return PentatonicDegree.III;
			case SUBV7_IV:
			case V7_IV:
			case V_IV:
				return null;
			case SUBV7_V:
			case V_V:
			case V7_V:
				return PentatonicDegree.IV;
			case SUBV7_VI:
			case V7_VI:
			case V_VI:
				return PentatonicDegree.V;
		}

		throw new RuntimeException("Impossible");
	}
}
