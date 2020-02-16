package es.danisales.datune.function;

import com.google.common.collect.ImmutableList;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.*;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Objects;

public enum DiatonicFunction
		implements ChromaticFunction {
	I, II, III, IV, V, VI, VII,
	I6, II6, III6, IV6, V6, VI6, VII6,
	I7, II7, III7, IV7, V7, VI7, VII7,
	I9, II9, III9, IV9, V9, VI9, VII9,
	I11, II11, III11, IV11, V11, VI11, VII11,
	I13, II13, III13, IV13, V13, VI13, VII13;

	/** Main Triads */
	public static final List<DiatonicFunction> TRIADS = new ImmutableList.Builder<DiatonicFunction>()
			.add(I)
			.add(II)
			.add(III)
			.add(IV)
			.add(V)
			.add(VI)
			.add(VII)
			.build();

	/** Triads + 6th */
	public static final List<DiatonicFunction> SIXTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I6)
			.add(II6)
			.add(III6)
			.add(IV6)
			.add(V6)
			.add(VI6)
			.add(VII6)
			.build();

	/** 7th */
	public static final List<DiatonicFunction> SEVENTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I7)
			.add(II7)
			.add(III7)
			.add(IV7)
			.add(V7)
			.add(VI7)
			.add(VII7)
			.build();

	/** 9th */
	public static final List<DiatonicFunction> NINTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I9)
			.add(II9)
			.add(III9)
			.add(IV9)
			.add(V9)
			.add(VI9)
			.add(VII9)
			.build();

	/**
	 * 11th
	 */
	@SuppressWarnings("unused")
	public static final List<DiatonicFunction> ELEVENTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I11)
			.add(II11)
			.add(III11)
			.add(IV11)
			.add(V11)
			.add(VI11)
			.add(VII11)
			.build();

	@SuppressWarnings("unused")
	public static final List<DiatonicFunction> THIRTEENTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I13)
			.add(II13)
			.add(III13)
			.add(IV13)
			.add(V13)
			.add(VI13)
			.add(VII13)
			.build();

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
				return "bII";

			case III6:
				return "III6";
			case III7:
				return "III7";
			case III9:
				return "III9";
			case III11:
				return "III11";
			case III:
				return "II";

			case IV6:
				return "IV6";
			case IV7:
				return "IV7";
			case IV9:
				return "IV9";
			case IV11:
				return "IV11";
			case IV:
				return "bIII";

			case V6:
				return "V6";
			case V9:
				return "V9";
			case V11:
				return "V11";
			case V:
				return "III";

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
				return "IV";

			case VII6:
				return "VII6";
			case VII7:
				return "VII7";
			case VII9:
				return "VII9";
			case VII11:
				return "VII11";
			case VII:
				return "bV";
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

	@Override
	@NonNull
	public ChromaticChord getChromaticChordFromTonality(@NonNull Tonality<Chromatic> tonality) throws ScaleRelativeDegreeException {
		Objects.requireNonNull(tonality);

		ChromaticChord chromaticChord = null;
		if (tonality.getScale().equals(Scale.MAJOR))
			chromaticChord = TonalityGetDiatonicFunctionMajor.get(tonality, this);
		else if (tonality.getScale().equals(Scale.MINOR))
			chromaticChord = TonalityGetDiatonicFunctionMinor.get(tonality, this);

		if (chromaticChord == null)
			chromaticChord = TonalityGetDiatonicFunctionDefault.get(tonality, this);

		return chromaticChord;
	}
}
