package es.danisales.datune.diatonic;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Funciones cromáticas
 */
public enum ChromaticFunction implements HarmonicFunction {
	/** Mayores */
	I, II, III,	IV,	V, VI, VII,

	/** Menores */
	i, ii, iii, iv, v, vi, vii,

	/** Diminished */
	I0, II0, III0, IV0, V0, VI0, VII0,

	/** The i5. */
	I5, II5, III5, IV5, V5, VI5, VII5,

	/** The sexta napolitana. */
	N6,

	/** Quinto de... */
	V_II, V_III, V_IV, V_V, V_VI,

	/** V7 de... */
	V7_II, V7_III, V7_IV, V7_V, V7_VI,

	/** SUBV7 */
	SUBV7, SUBV7_II, SUBV7_III, SUBV7_IV, SUBV7_V, SUBV7_VI,

	/** The v7alt. */
	V7ALT;

	/** Funciones de triada */
	public static final ChromaticFunction[] TRIAD_FUNCTIONS = new ChromaticFunction[] {
			I,
			II,
			III,
			IV,
			V,
			VI,
			VII,
			i,
			ii,
			iii,
			iv,
			v,
			vi,
			vii,
			I0,
			II0,
			III0,
			IV0,
			V0,
			VI0,
			VII0,
	};

	/** Funciones POWER */
	public static final ChromaticFunction[] POWER_CHORDS = new ChromaticFunction[] {
			I5,
			II5,
			III5,
			IV5,
			V5,
			VI5,
			VII5,
	};

	/** Funciones V de... */
	public static final ChromaticFunction[] V_FUNCTIONS = new ChromaticFunction[] {
			V_II,
			V_III,
			V_IV,
			V_V,
			V_VI,
	};

	/** Funciones V7 de... */
	public static final ChromaticFunction[] V7_FUNCTIONS = new ChromaticFunction[] {
			V7_II,
			V7_III,
			V7_IV,
			V7_V,
			V7_VI,
	};

	/** Funciones SUBV7. */
	public static final ChromaticFunction[] SUBV7_FUNCTIONS = new ChromaticFunction[] {
			SUBV7,
			SUBV7_II,
			SUBV7_III,
			SUBV7_IV,
			SUBV7_V,
			SUBV7_VI,
	};

	/** Otras funciones */
	public static final ChromaticFunction[] OTHERS = new ChromaticFunction[] {
			N6,
			V7ALT,
	};

	/** The Constant TENSIONS. */
	public static final ChromaticFunction[] TENSIONS = ArrayUtils
			.concat( V_FUNCTIONS, V7_FUNCTIONS, SUBV7_FUNCTIONS, OTHERS );

	/** The Constant ALL. */
	public static final ChromaticFunction[] ALL = ArrayUtils
			.concat( POWER_CHORDS, TENSIONS );

	/**
	 * FIN CONSTANTES
	 **********************************************************************************************************/

	/**
	 * Gets the chromatic function fromIndex a chromatic chord and a tonality
	 *
	 * @param chromaticChord chromatic chord
	 * @param tonality tonality
	 * @return the chromatic function
	 */
	public static @Nullable ChromaticFunction from(@NonNull PitchChromaticChord chromaticChord, @NonNull Tonality tonality) {
		HarmonicFunction hf = tonality.getFunctionFrom(ChromaticChord.from(chromaticChord));
		if ( hf instanceof ChromaticFunction )
			return (ChromaticFunction) hf;

		return null;
	}

	/**
	 * Gets the harmonic function from a diatonic chord with a tonality
	 *
	 * @param diatonicChordMidi the diatonic chord midi
	 * @return the harmonic function
	 */
	public static HarmonicFunction from(DiatonicChordMidi diatonicChordMidi) {
		ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.from(diatonicChordMidi);
		return ChromaticFunction
				.from( chromaticChordMidi, Tonality.from(diatonicChordMidi.metaTonality.getRoot(), diatonicChordMidi.metaTonality.getScale()) );
	}

	@Deprecated
	public DiatonicDegree getDegree() {
		return DiatonicDegree.from(this);
	}

	public @NonNull String toString() {
		switch ( this ) {
			case V7_II:
				return "V7/II";
			case V7_III:
				return "V7/III";
			case V7_IV:
				return "V7/IV";
			case V7_V:
				return "V7/V";
			case V7_VI:
				return "V7/VI";
			case V_II:
				return "V/II";
			case V_III:
				return "V/III";
			case V_IV:
				return "V/IV";
			case V_V:
				return "V/V";
			case V_VI:
				return "V/VI";

			case N6:
				return "N6";

			case SUBV7:
				return "subV7";
			case SUBV7_II:
				return "subV7/II";
			case SUBV7_III:
				return "subV7/III";
			case SUBV7_IV:
				return "subV7/IV";
			case SUBV7_V:
				return "subV7/V";
			case SUBV7_VI:
				return "subV7/VI";

			case V7ALT:
				return "V7Alt";
			case III5:
				return "III5";
			case II5:
				return "II5";
			case IV5:
				return "IV5";
			case I5:
				return "I5";
			case VII5:
				return "VII5";
			case VI5:
				return "VI5";
			case V5:
				return "V5";
			case I:
				return "I";
			case II:
				return "II";
			case III:
				return "III";
			case IV:
				return "IV";
			case V:
				return "V";
			case VI:
				return "VI";
			case VII:
				return "VII";
			case i:
				return "i";
			case ii:
				return "ii";
			case iii:
				return "iii";
			case iv:
				return "iv";
			case v:
				return "v";
			case vi:
				return "vi";
			case vii:
				return "vii";
			case I0:
				return "I0";
			case II0:
				return "II0";
			case III0:
				return "III0";
			case IV0:
				return "IV0";
			case V0:
				return "V0";
			case VI0:
				return "VI0";
			case VII0:
				return "VII0";
		}

		return null;
	}
}
