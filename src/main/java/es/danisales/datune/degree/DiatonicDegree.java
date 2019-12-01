package es.danisales.datune.degree;

import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Grado diatónico
 */
public enum DiatonicDegree implements RelativeDegree {
	I, II, III, IV, V, VI, VII;

	public static DiatonicDegree from(IntervalDiatonic intervalDiatonic) {
		return values()[intervalDiatonic.ordinal() % DiatonicDegree.values().length];
	}

	/**
     * Returns the degree with the added interval function
	 *
	 * @param id the id
	 * @return the degree
	 */
	public static DiatonicDegree add(DiatonicDegree diatonicDegree, IntervalDiatonic id) {
		return fromIndex( diatonicDegree.ordinal() + id.ordinal() );
	}

	public static DiatonicDegree sub(DiatonicDegree diatonicDegree, IntervalDiatonic id) {
		return fromIndex( diatonicDegree.ordinal() - id.ordinal() );
	}

	/**
	 * Gets the degree fromIndex an int
	 *
	 * @param n the n
	 * @return the degree
	 */
	private static DiatonicDegree fromIndex(int n) {
		n = limitToOneOctave(n);

		return values()[n];
	}

	private static int limitToOneOctave(int n) {
		n = n % Diatonic.NUMBER;
		if ( n < 0 )
			n += Diatonic.NUMBER;
		return n;
	}

	public static @NonNull DiatonicDegree from(DiatonicFunction diatonicFunction) {
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
				return DiatonicDegree.I;
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
				return DiatonicDegree.II;
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
				return DiatonicDegree.III;
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
				return DiatonicDegree.IV;
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
				return DiatonicDegree.V;
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
				return DiatonicDegree.VI;
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
				return DiatonicDegree.VII;
		}
		throw new RuntimeException("Impossible");
	}

	public static @NonNull DiatonicDegree from(@NonNull ChromaticFunction chromaticFunction) {
		switch ( chromaticFunction ) {
			case I:
			case I5:
			case i:
			case I0:
				return DiatonicDegree.I;
			case II:
			case II5:
			case ii:
			case II0:
			case N6:
				return DiatonicDegree.II;
			case III:
			case III5:
			case iii:
			case III0:
				return DiatonicDegree.III;
			case IV:
			case IV5:
			case iv:
			case IV0:
				return DiatonicDegree.IV;
			case V:
			case V5:
			case v:
			case V0:
				return DiatonicDegree.V;
			case VI:
			case VI5:
			case vi:
			case VI0:
				return DiatonicDegree.VI;
			case VII:
			case VII5:
			case vii:
			case VII0:
				return DiatonicDegree.VII;
			case SUBV7:
			case V7ALT:
				return DiatonicDegree.I;
			case SUBV7_II:
			case V7_II:
			case V_II:
				return DiatonicDegree.II;
			case SUBV7_III:
			case V7_III:
			case V_III:
				return DiatonicDegree.III;
			case SUBV7_IV:
			case V7_IV:
			case V_IV:
				return DiatonicDegree.IV;
			case SUBV7_V:
			case V_V:
			case V7_V:
				return DiatonicDegree.V;
			case SUBV7_VI:
			case V7_VI:
			case V_VI:
				return DiatonicDegree.VI;
		}

		throw new RuntimeException("Impossible");
	}

    public DiatonicDegree getNext() { // todo: move to RelativeDegree
        int index = (ordinal() + 1) % DiatonicDegree.values().length;
        return values()[index];
    }

    public DiatonicDegree getPrevious() { // todo: move to RelativeDegree
        int index = (ordinal() - 1 + DiatonicDegree.values().length) % DiatonicDegree.values().length;
        return values()[index];
    }
}
