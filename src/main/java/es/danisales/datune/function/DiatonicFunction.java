package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public enum DiatonicFunction implements HarmonicFunction {
	I, II, III, IV, V, VI, VII,
	I6, II6, III6, IV6, V6, VI6, VII6,
	I7, II7, III7, IV7, V7, VI7, VII7,
	I9, II9, III9, IV9, V9, VI9, VII9,
	I11, II11, III11, IV11, V11, VI11, VII11,
	I13, II13, III13, IV13, V13, VI13, VII13;

	/** Main Triads */
	public static final DiatonicFunction[] TRIADS = new DiatonicFunction[] {
			I,
			II,
			III,
			IV,
			V,
			VI,
			VII
	};

	/** Triads + 6th */
	public static final DiatonicFunction[] SIXTH = new DiatonicFunction[] {
			I6,
			II6,
			III6,
			IV6,
			V6,
			VI6,
			VII6,
	};

	/** 7th */
	public static final DiatonicFunction[] SEVENTH = new DiatonicFunction[] {
			I7,
			II7,
			III7,
			IV7,
			V7,
			VI7,
			VII7
	};

	/** 9th */
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
	 * 11th
	 */
	@SuppressWarnings("unused")
	public static final DiatonicFunction[] ELEVENTH = new DiatonicFunction[] {
			I11,
			II11,
			III11,
			IV11,
			V11,
			VI11,
			VII11,
	};

	@SuppressWarnings("unused")
	public static final DiatonicFunction[] THIRTEENTH = new DiatonicFunction[] {
			I13,
			II13,
			III13,
			IV13,
			V13,
			VI13,
			VII13,
	};

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
			case I6:
				return "I6";
			case I7:
				return "I7";
			case I9:
				return "I9";
			case I11:
				return "I11";
			case I:
				return "I";

			case II6:
				return "II6";
			case II7:
				return "II7";
			case II9:
				return "II9";
			case II11:
				return "II11";
			case II:
				return "II";

			case III6:
				return "III6";
			case III7:
				return "III7";
			case III9:
				return "III9";
			case III11:
				return "III11";
			case III:
				return "III";

			case IV6:
				return "IV6";
			case IV7:
				return "IV7";
			case IV9:
				return "IV9";
			case IV11:
				return "IV11";
			case IV:
				return "IV";

			case V6:
				return "V6";
			case V9:
				return "V9";
			case V11:
				return "V11";
			case V:
				return "V";

			case V7:
				return "V7";

			case VI6:
				return "VI6";
			case VI7:
				return "VI7";
			case VI9:
				return "VI9";
			case VI11:
				return "VI11";
			case VI:
				return "VI";

			case VII6:
				return "VII6";
			case VII7:
				return "VII7";
			case VII9:
				return "VII9";
			case VII11:
				return "VII11";
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
		}

		throw NeverHappensException.switchOf(this);
	}

	public static @Nullable DiatonicFunction from(@NonNull ChromaticChord chromaticChord, @NonNull Tonality<Chromatic> tonality) {
		HarmonicFunction harmonicFunction = tonality.getFunctionFrom(chromaticChord);
		if (harmonicFunction instanceof DiatonicFunction)
			return (DiatonicFunction) harmonicFunction;

		return null;
	}
}
