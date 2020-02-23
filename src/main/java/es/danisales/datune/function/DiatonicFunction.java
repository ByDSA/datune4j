package es.danisales.datune.function;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.TonalityModern;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Objects;

public final class DiatonicFunction
		implements HarmonicFunction {
	private static final Table<DiatonicDegreePattern, DiatonicDegree, DiatonicFunction> table = HashBasedTable.create();

	public static final DiatonicFunction I = from(DiatonicDegree.I, DiatonicDegreePattern.I);
	public static final DiatonicFunction II = from(DiatonicDegree.II, DiatonicDegreePattern.II);
	public static final DiatonicFunction III = from(DiatonicDegree.III, DiatonicDegreePattern.III);
	public static final DiatonicFunction IV = from(DiatonicDegree.IV, DiatonicDegreePattern.IV);
	public static final DiatonicFunction V = from(DiatonicDegree.V, DiatonicDegreePattern.V);
	public static final DiatonicFunction VI = from(DiatonicDegree.VI, DiatonicDegreePattern.VI);
	public static final DiatonicFunction VII = from(DiatonicDegree.VII, DiatonicDegreePattern.VII);

	public static final DiatonicFunction I6 = from(DiatonicDegree.I, DiatonicDegreePattern.I6);
	public static final DiatonicFunction II6 = from(DiatonicDegree.II, DiatonicDegreePattern.II6);
	public static final DiatonicFunction III6 = from(DiatonicDegree.III, DiatonicDegreePattern.III6);
	public static final DiatonicFunction IV6 = from(DiatonicDegree.IV, DiatonicDegreePattern.IV6);
	public static final DiatonicFunction V6 = from(DiatonicDegree.V, DiatonicDegreePattern.V6);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction VI6 = from(DiatonicDegree.VI, DiatonicDegreePattern.VI6);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction VII6 = from(DiatonicDegree.VII, DiatonicDegreePattern.VII6);

	public static final DiatonicFunction I7 = from(DiatonicDegree.I, DiatonicDegreePattern.I7);
	public static final DiatonicFunction II7 = from(DiatonicDegree.II, DiatonicDegreePattern.II7);
	public static final DiatonicFunction III7 = from(DiatonicDegree.III, DiatonicDegreePattern.III7);
	public static final DiatonicFunction IV7 = from(DiatonicDegree.IV, DiatonicDegreePattern.IV7);
	public static final DiatonicFunction V7 = from(DiatonicDegree.V, DiatonicDegreePattern.V7);
	public static final DiatonicFunction VI7 = from(DiatonicDegree.VI, DiatonicDegreePattern.VI7);
	public static final DiatonicFunction VII7 = from(DiatonicDegree.VII, DiatonicDegreePattern.VII7);

	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction I9 = from(DiatonicDegree.I, DiatonicDegreePattern.I9);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction II9 = from(DiatonicDegree.II, DiatonicDegreePattern.II9);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction III9 = from(DiatonicDegree.III, DiatonicDegreePattern.III9);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction IV9 = from(DiatonicDegree.IV, DiatonicDegreePattern.IV9);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction V9 = from(DiatonicDegree.V, DiatonicDegreePattern.V9);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction VI9 = from(DiatonicDegree.VI, DiatonicDegreePattern.VI9);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction VII9 = from(DiatonicDegree.VII, DiatonicDegreePattern.VII9);

	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction I11 = from(DiatonicDegree.I, DiatonicDegreePattern.I11);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction II11 = from(DiatonicDegree.II, DiatonicDegreePattern.II11);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction III11 = from(DiatonicDegree.III, DiatonicDegreePattern.III11);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction IV11 = from(DiatonicDegree.IV, DiatonicDegreePattern.IV11);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction V11 = from(DiatonicDegree.V, DiatonicDegreePattern.V11);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction VI11 = from(DiatonicDegree.VI, DiatonicDegreePattern.VI11);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction VII11 = from(DiatonicDegree.VII, DiatonicDegreePattern.VII11);

	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction I13 = from(DiatonicDegree.I, DiatonicDegreePattern.I13);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction II13 = from(DiatonicDegree.II, DiatonicDegreePattern.II13);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction III13 = from(DiatonicDegree.III, DiatonicDegreePattern.III13);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction IV13 = from(DiatonicDegree.IV, DiatonicDegreePattern.IV13);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction V13 = from(DiatonicDegree.V, DiatonicDegreePattern.V13);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction VI13 = from(DiatonicDegree.VI, DiatonicDegreePattern.VI13);
	@SuppressWarnings("WeakerAccess")
	public static final DiatonicFunction VII13 = from(DiatonicDegree.VII, DiatonicDegreePattern.VII13);

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

	public static final List<DiatonicFunction> SEVENTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I7)
			.add(II7)
			.add(III7)
			.add(IV7)
			.add(V7)
			.add(VI7)
			.add(VII7)
			.build();

	public static final List<DiatonicFunction> NINTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I9)
			.add(II9)
			.add(III9)
			.add(IV9)
			.add(V9)
			.add(VI9)
			.add(VII9)
			.build();

	@SuppressWarnings("WeakerAccess")
	public static final List<DiatonicFunction> ELEVENTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I11)
			.add(II11)
			.add(III11)
			.add(IV11)
			.add(V11)
			.add(VI11)
			.add(VII11)
			.build();

	@SuppressWarnings("WeakerAccess")
	public static final List<DiatonicFunction> THIRTEENTH = new ImmutableList.Builder<DiatonicFunction>()
			.add(I13)
			.add(II13)
			.add(III13)
			.add(IV13)
			.add(V13)
			.add(VI13)
			.add(VII13)
			.build();

	private static final List<DiatonicFunction> immutableValues = new ImmutableList.Builder<DiatonicFunction>()
			.addAll(TRIADS)
			.addAll(SIXTH)
			.addAll(SEVENTH)
			.addAll(NINTH)
			.addAll(ELEVENTH)
			.addAll(THIRTEENTH)
			.build();

	public static List<DiatonicFunction> immutableValues() {
		return immutableValues;
	}

	/*********************** END CONSTANTS *********/

	private final DiatonicDegreePattern diatonicDegreePattern;
	private final DiatonicDegree diatonicDegree;

	private DiatonicFunction(DiatonicDegree diatonicDegree, DiatonicDegreePattern diatonicDegreePattern) {
		this.diatonicDegreePattern = diatonicDegreePattern;
		this.diatonicDegree = diatonicDegree;
	}

	public static DiatonicFunction from(DiatonicDegree diatonicDegree, DiatonicDegreePattern diatonicDegreePattern) {
		DiatonicFunction cached = table.get(diatonicDegreePattern, diatonicDegree);
		if (cached == null) {
			cached = new DiatonicFunction(diatonicDegree, diatonicDegreePattern);
			table.put(diatonicDegreePattern, diatonicDegree, cached);
		}

		return cached;
	}

	public DiatonicDegree getDiatonicDegree() {
		return diatonicDegree;
	}

	@SuppressWarnings("WeakerAccess")
	public DiatonicDegreePattern getDiatonicDegreePattern() {
		return diatonicDegreePattern;
	}

	@Override
	@NonNull
	public ChromaticChord getChord(@NonNull TonalityModern tonality) throws ScaleRelativeDegreeException {
		Objects.requireNonNull(tonality);

		TonalChord tonalChord = TonalChord.from(tonality, this);

		return (ChromaticChord) FunctionCache.get(tonalChord);
	}

	@Override
	public @NonNull HarmonicFunction getShifted(int i) {
		return from(diatonicDegree.getShifted(i), diatonicDegreePattern);
	}

	public String toString() {
		return symbolDegree() + symbolPattern() + " (Diatonic)";
	}

	private String symbolDegree() {
		switch (diatonicDegree) {
			case I: return "I";
			case II: return "II";
			case III: return "III";
			case IV: return "IV";
			case V: return "V";
			case VI: return "VI";
			case VII: return "VII";
		}

		throw NeverHappensException.switchOf(diatonicDegree);
	}

	private String symbolPattern() {
		if (diatonicDegreePattern.equals(DiatonicDegreePattern.I)
		|| diatonicDegreePattern.equals(DiatonicDegreePattern.II)
		|| diatonicDegreePattern.equals(DiatonicDegreePattern.III)
		|| diatonicDegreePattern.equals(DiatonicDegreePattern.IV)
		|| diatonicDegreePattern.equals(DiatonicDegreePattern.V)
		|| diatonicDegreePattern.equals(DiatonicDegreePattern.VI)
		|| diatonicDegreePattern.equals(DiatonicDegreePattern.VII)
		)
			return "";
		else if (diatonicDegreePattern.equals(DiatonicDegreePattern.I6)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.II6)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.III6)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.IV6)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.V6)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VI6)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VII6)
		)
			return "6";
		else if (diatonicDegreePattern.equals(DiatonicDegreePattern.I7)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.II7)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.III7)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.IV7)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.V7)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VI7)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VII7)
		)
			return "7";
		else if (diatonicDegreePattern.equals(DiatonicDegreePattern.I9)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.II9)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.III9)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.IV9)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.V9)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VI9)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VII9)
		)
			return "9";
		else if (diatonicDegreePattern.equals(DiatonicDegreePattern.I11)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.II11)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.III11)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.IV11)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.V11)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VI11)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VII11)
		)
			return "11";
		else if (diatonicDegreePattern.equals(DiatonicDegreePattern.I13)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.II13)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.III13)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.IV13)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.V13)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VI13)
				|| diatonicDegreePattern.equals(DiatonicDegreePattern.VII13)
		)
			return "13";

		return super.toString();
	}
}
