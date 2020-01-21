package es.danisales.datune.function;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;

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

	/**
	 * Power Chord.
	 */
	I5, II5, III5, IV5, V5, VI5, VII5,

    /**
     * SUS
     **/
    ISUS4, IISUS4, bIIISUS4, IVSUS4, VSUS4, VISUS4, bVIISUS4,

	/** sexta napolitana. */
	N6, //bII

	/** Quinto de... */
	V_II, V_III, V_IV, V_V, V_VI,

	/** V7 de... */
	V7_II, V7_III, V7_IV, V7_V, V7_VI,

	/** SUBV7 */
	SUBV7, SUBV7_II, SUBV7_III, SUBV7_IV, SUBV7_V, SUBV7_VI,

	/** The v7alt. */
	V7ALT,

	/* altered */
	bIII,
	bVII,
	bVI;

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
            bIII,
            bVI,
			bVII
	};

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

	public static final ChromaticFunction[] SUBV7_FUNCTIONS = new ChromaticFunction[] {
			SUBV7,
			SUBV7_II,
			SUBV7_III,
			SUBV7_IV,
			SUBV7_V,
			SUBV7_VI,
    };

	/** Otras funciones */
	public static final ChromaticFunction[] OTHER_TENSIONS = new ChromaticFunction[] {
			V7ALT,
	};

	/** The Constant TENSIONS. */
	public static final ChromaticFunction[] TENSIONS = ArrayUtils
			.concat( V_FUNCTIONS, V7_FUNCTIONS, SUBV7_FUNCTIONS, OTHER_TENSIONS);
	public static final ChromaticFunction[] SUS4 = new ChromaticFunction[] {
			ISUS4,
			IISUS4,
			bIIISUS4,
			IVSUS4,
			VSUS4,
			VISUS4,
			bVIISUS4,
	};

	/*
	 * FIN CONSTANTES
	 **********************************************************************************************************/

	/**
	 * Gets the chromatic function fromIndex a chromatic chord and a tonality
	 *
     * @param pitchChromaticChord chromatic chord
	 * @param tonality tonality
	 * @return the chromatic function
	 */
    public static @Nullable ChromaticFunction from(@NonNull Collection<Chromatic> pitchChromaticChord, @NonNull Tonality tonality) {
        ChromaticChord chromaticChord = ChromaticChord.builder()
                .addAll(pitchChromaticChord)
                .build();
        HarmonicFunction hf = tonality.getFunctionFrom(chromaticChord);
		if ( hf instanceof ChromaticFunction )
			return (ChromaticFunction) hf;

		return null;
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
            case ISUS4:
                return "ISUS4";
            case IISUS4:
                return "IISUS4";
            case bIIISUS4:
                return "bIIISUS4";
            case IVSUS4:
                return "IVSUS4";
            case VSUS4:
                return "VSUS4";
            case VISUS4:
                return "VISUS4";
            case bVIISUS4:
				return "bVIISUS4";
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
				return "Iº";
            case II0:
				return "IIº";
            case III0:
				return "IIIº";
            case IV0:
				return "IVº";
            case V0:
				return "Vº";
            case VI0:
				return "VIº";
            case VII0:
                return "VIIº";
            case bIII:
				return "bIII";
			case bVII:
				return "bVII";
			case bVI:
				return "bVI";
		}

		throw new RuntimeException();
	}
}
