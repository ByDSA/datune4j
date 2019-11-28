package es.danisales.datune.diatonic;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Functiones diatónicas
 *
 */
public enum DiatonicFunction implements HarmonicFunction {
	I, II, III, IV, V, VI, VII,
	I2, II2, III2, IV2, V2, VI2, VII2,
	I4, II4, III4, IV4, V4, VI4, VII4,
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

	/** SUS2 */
	public static final DiatonicFunction[] SUS2 = new DiatonicFunction[] {
			I2,
			II2,
			III2,
			IV2,
			V2,
			VI2,
			VII2
	};

	/** SUS4 */
	public static final DiatonicFunction[] SUS4 = new DiatonicFunction[] {
			I4,
			II4,
			III4,
			IV4,
			V4,
			VI4,
			VII4,
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

	/** Con und�cima */
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
			.concat( TRIADS, SUS2, SUS4, SIXTH, SEVENTH, NINTH, ELEVENTH );

	/** Intervalos */
	public static final DiatonicFunction[] INTERVALS = new DiatonicFunction[] {
			I_THIRD,
			II_THIRD,
			III_THIRD,
			IV_THIRD,
			V_THIRD,
			VI_THIRD,
			VII_THIRD,
			I_SECOND,
			II_SECOND,
			III_SECOND,
			IV_SECOND,
			V_SECOND,
			VI_SECOND,
			VII_SECOND,
			I_FOURTH,
			II_FOURTH,
			III_FOURTH,
			IV_FOURTH,
			V_FOURTH,
			VI_FOURTH,
			VII_FOURTH
	};

	/** Con omitidos */
	public static final DiatonicFunction[] OMIT = new DiatonicFunction[] {
			I6_O5,
			II6_O5,
			III6_O5,
			IV6_O5,
			V6_O5,
			VI6_O5,
			VII6_O5,
			I7_O5,
			II7_O5,
			III7_O5,
			IV7_O5,
			V7_O5,
			VI7_O5,
			VII7_O5,
			I7_O3,
			II7_O3,
			III7_O3,
			IV7_O3,
			V7_O3,
			VI7_O3,
			VII7_O3,

			I9_O7,
			II9_O7,
			III9_O7,
			IV9_O7,
			V9_O7,
			VI9_O7,
			VII9_O7,
			I9_O3_O7,
			II9_O3_O7,
			III9_O3_O7,
			IV9_O3_O7,
			V9_O3_O7,
			VI9_O3_O7,
			VII9_O3_O7,
	};

	@Deprecated
	public DiatonicDegree getDegree() {
		return DiatonicDegree.from(this);
	}

	public boolean isSus2() {
		return ArrayUtils.contains( this, SUS2 );
	}

	public boolean isSus4() {
		return ArrayUtils.contains( this, SUS4 );
	}

	public static @NonNull DiatonicFunction from(@NonNull DiatonicDegree diatonicDegree) {
		switch ( diatonicDegree ) {
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
		throw new RuntimeException("Impossible");
	}

	public String toString() {
		switch ( this ) {
			case I_SECOND:
			case I2:
				return "I2";
			case I_FOURTH:
			case I4:
				return "I4";
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
			case II2:
				return "II2";
			case II_FOURTH:
			case II4:
				return "II4";
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
			case III2:
				return "III2";
			case III_FOURTH:
			case III4:
				return "III4";
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
			case IV2:
				return "IV2";
			case IV_FOURTH:
			case IV4:
				return "IV4";
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
			case V2:
				return "V2";
			case V_FOURTH:
			case V4:
				return "V4";
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
			case VI2:
				return "VI2";
			case VI_FOURTH:
			case VI4:
				return "VI4";
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
			case VII2:
				return "VII2";
			case VII_FOURTH:
			case VII4:
				return "VII4";
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

	/**
	 * Gets the diatonic function fromIndex a diatonic chord midi with a tonality
	 * @param c diatonic chord midi
	 * @return the diatonic function
	 */
	public static @Nullable DiatonicFunction from(@NonNull DiatonicChordMidi c) {
		checkArgument(c.getTonality() != null);
		checkArgument(c.metaTonality!= null);
		Tonality ton = c.getMetatonality();
        ChromaticChord chromaticChord = ChromaticChord.builder().fromDiatonicChordMidi(c).build();
        HarmonicFunction hf = ton.getFunctionFrom(chromaticChord);
		if ( hf instanceof DiatonicFunction )
			return (DiatonicFunction) hf;
		else
			return null;
	}
}
