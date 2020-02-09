package es.danisales.datune.function;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;

public enum ChromaticFunction implements HarmonicFunction {
	/** Dominantes secundarios */
	V_II, V_III, V_IV, V_V, V_VI,

	/** Dominantes secundarios con séptima */
	V7_II, V7_III, V7_IV, V7_V, V7_VI,

	/** SUBV7 */
	SUBV7, SUBV7_II, SUBV7_III, SUBV7_IV, SUBV7_V, SUBV7_VI,

	/** v7alt */
	V7ALT;

	/** Dominantes secundarios triada */
	public static final ChromaticFunction[] V_FUNCTIONS = new ChromaticFunction[] {
			V_II,
			V_III,
			V_IV,
			V_V,
			V_VI,
	};

	/** Dominantes secundarios cuatriada */
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
		ChromaticChord chromaticChord;
		try {
			chromaticChord = ChromaticChord.builder()
					.addAll(pitchChromaticChord)
					.build();

			HarmonicFunction hf = tonality.getFunctionFrom(chromaticChord);
			if ( hf instanceof ChromaticFunction )
				return (ChromaticFunction) hf;
		} catch (BuildingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public @NonNull String toString() {
		switch ( this ) {
			case V7_II:
				return "V7/bII";
			case V7_III:
				return "V7/II";
			case V7_IV:
				return "V7/bIII";
			case V7_V:
				return "V7/III";
			case V7_VI:
				return "V7/IV";
			case V_II:
				return "III/bII";
			case V_III:
				return "III/II";
			case V_IV:
				return "III/bIII";
			case V_V:
				return "III/III";
			case V_VI:
				return "III/IV";
			case SUBV7:
				return "subV7";
			case SUBV7_II:
				return "subV7/bII";
			case SUBV7_III:
				return "subV7/II";
			case SUBV7_IV:
				return "subV7/bIII";
			case SUBV7_V:
				return "subV7/III";
			case SUBV7_VI:
				return "subV7/IV";
			case V7ALT:
				return "V7Alt";
		}

		throw NeverHappensException.switchOf(this);
	}
}
