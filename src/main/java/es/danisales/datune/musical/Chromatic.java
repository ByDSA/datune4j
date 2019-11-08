package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.musical.transformations.DistanceCalculator;
import es.danisales.datune.musical.transformations.EnharmonicsCalculator;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.ScaleDistance;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public enum Chromatic implements PitchChromaticSingle {
	C, CC, D, DD, E, F, FF, G, GG, A, AA, B;

    public static final int NUMBER = values().length;

	private static final Map<DiatonicAlt, Chromatic> diatonicAltChromaticMap = new HashMap<>();
	static {
		diatonicAltChromaticMap.put(DiatonicAlt.AAAA, Chromatic.C);
		diatonicAltChromaticMap.put(DiatonicAlt.BB, Chromatic.C);
		diatonicAltChromaticMap.put(DiatonicAlt.C, Chromatic.C);
		diatonicAltChromaticMap.put(DiatonicAlt.AAAAA, Chromatic.CC);
		diatonicAltChromaticMap.put(DiatonicAlt.BBB, Chromatic.CC);
		diatonicAltChromaticMap.put(DiatonicAlt.CC, Chromatic.CC);
		diatonicAltChromaticMap.put(DiatonicAlt.BBBB, Chromatic.D);
		diatonicAltChromaticMap.put(DiatonicAlt.CCC, Chromatic.D);
		diatonicAltChromaticMap.put(DiatonicAlt.D, Chromatic.D);
		diatonicAltChromaticMap.put(DiatonicAlt.BBBBB, Chromatic.DD);
		diatonicAltChromaticMap.put(DiatonicAlt.CCCC, Chromatic.DD);
		diatonicAltChromaticMap.put(DiatonicAlt.DD, Chromatic.DD);
		diatonicAltChromaticMap.put(DiatonicAlt.CCCCC, Chromatic.E);
		diatonicAltChromaticMap.put(DiatonicAlt.DDD, Chromatic.E);
		diatonicAltChromaticMap.put(DiatonicAlt.E, Chromatic.E);
		diatonicAltChromaticMap.put(DiatonicAlt.EE, Chromatic.F);
		diatonicAltChromaticMap.put(DiatonicAlt.DDDD, Chromatic.F);
		diatonicAltChromaticMap.put(DiatonicAlt.F, Chromatic.F);
		diatonicAltChromaticMap.put(DiatonicAlt.EEE, Chromatic.FF);
		diatonicAltChromaticMap.put(DiatonicAlt.DDDDD, Chromatic.FF);
		diatonicAltChromaticMap.put(DiatonicAlt.FF, Chromatic.FF);
		diatonicAltChromaticMap.put(DiatonicAlt.EEEE, Chromatic.G);
		diatonicAltChromaticMap.put(DiatonicAlt.FFF, Chromatic.G);
		diatonicAltChromaticMap.put(DiatonicAlt.G, Chromatic.G);
		diatonicAltChromaticMap.put(DiatonicAlt.EEEEE, Chromatic.GG);
		diatonicAltChromaticMap.put(DiatonicAlt.FFFF, Chromatic.GG);
		diatonicAltChromaticMap.put(DiatonicAlt.GG, Chromatic.GG);
		diatonicAltChromaticMap.put(DiatonicAlt.FFFFF, Chromatic.A);
		diatonicAltChromaticMap.put(DiatonicAlt.GGG, Chromatic.A);
		diatonicAltChromaticMap.put(DiatonicAlt.A, Chromatic.A);
		diatonicAltChromaticMap.put(DiatonicAlt.GGGG, Chromatic.AA);
		diatonicAltChromaticMap.put(DiatonicAlt.AA, Chromatic.AA);
		diatonicAltChromaticMap.put(DiatonicAlt.AAA, Chromatic.B);
		diatonicAltChromaticMap.put(DiatonicAlt.B, Chromatic.B);

		diatonicAltChromaticMap.put(DiatonicAlt.Cb, Chromatic.B);
		diatonicAltChromaticMap.put(DiatonicAlt.Db, Chromatic.CC);
		diatonicAltChromaticMap.put(DiatonicAlt.Eb, Chromatic.DD);
		diatonicAltChromaticMap.put(DiatonicAlt.Fb, Chromatic.E);
		diatonicAltChromaticMap.put(DiatonicAlt.Gb, Chromatic.FF);
		diatonicAltChromaticMap.put(DiatonicAlt.Ab, Chromatic.GG);
		diatonicAltChromaticMap.put(DiatonicAlt.Bb, Chromatic.AA);

		diatonicAltChromaticMap.put(DiatonicAlt.Dbb, Chromatic.C);
		diatonicAltChromaticMap.put(DiatonicAlt.Ebb, Chromatic.D);
		diatonicAltChromaticMap.put(DiatonicAlt.Fbb, Chromatic.DD);
		diatonicAltChromaticMap.put(DiatonicAlt.Gbb, Chromatic.F);
		diatonicAltChromaticMap.put(DiatonicAlt.Abb, Chromatic.G);
		diatonicAltChromaticMap.put(DiatonicAlt.Bbb, Chromatic.A);
		diatonicAltChromaticMap.put(DiatonicAlt.Cbb, Chromatic.AA);

		diatonicAltChromaticMap.put(DiatonicAlt.Dbbb, Chromatic.B);
		diatonicAltChromaticMap.put(DiatonicAlt.Ebbb, Chromatic.CC);
		diatonicAltChromaticMap.put(DiatonicAlt.Fbbb, Chromatic.D);
		diatonicAltChromaticMap.put(DiatonicAlt.Gbbb, Chromatic.E);
		diatonicAltChromaticMap.put(DiatonicAlt.Abbb, Chromatic.FF);
		diatonicAltChromaticMap.put(DiatonicAlt.Bbbb, Chromatic.GG);
		diatonicAltChromaticMap.put(DiatonicAlt.Cbbb, Chromatic.A);
	}

	public static @NonNull Chromatic from(@NonNull DiatonicAlt diatonicAlt) {
		Objects.requireNonNull(diatonicAlt);
		Chromatic ret = diatonicAltChromaticMap.get(diatonicAlt);
		if (ret == null) {
			Diatonic diatonicOriginal = diatonicAlt.getDiatonic();
			int semitones = diatonicAlt.getSemitonesAdded();
			Chromatic chromaticDiatonicOriginal = Chromatic.from(diatonicOriginal);
			ret = chromaticDiatonicOriginal.addSemi(semitones);
		}

		return ret;
	}

	@SuppressWarnings("DuplicatedCode")
	public static @NonNull Chromatic from(Diatonic diatonic) {
		switch (diatonic) {
			case C: return C;
			case D: return D;
			case E: return E;
			case F: return F;
			case G: return G;
			case A: return A;
			case B: return B;
		}

		throw new RuntimeException("Impossible");
	}

	public static Chromatic from(PitchChromaticSingle t) {
		return ChromaticAdapter.from(t);
	}

	public static Chromatic from(DiatonicDegree diatonicDegree, Tonality tonality) {
		DiatonicAlt diatonicAlt = tonality.getNote(diatonicDegree);
		return Chromatic.from(diatonicAlt);
	}

	public Chromatic addSemi(int n) {
		int index = delimit(ordinal() + n);
		return values()[index];
	}

	public Chromatic addSemi(ScaleDistance distanceScale) {
		return addSemi(distanceScale.getSemitones());
	}

	public Chromatic addSemi() {
		return addSemi(1);
	}

	public List<DiatonicAlt> getEnharmonics(int maxAlts) {
		return EnharmonicsCalculator.calculateFrom(this, maxAlts);
	}

	private static int delimit(int n) {
		return MathUtils.rotativeTrim(n,  NUMBER);
	}

	public static @NonNull Chromatic from(int intVal) {
		intVal = delimit(intVal);
		return Chromatic.values()[intVal];
	}

	public String toString() {
		return Namer.from(this);
	}

	public IntervalChromatic dist(@NonNull Chromatic n, @NonNull IntervalDiatonic i) {
		return DistanceCalculator.calculareInterval(this, n, i);
	}

	public @Nullable DiatonicAlt rename(@NonNull Tonality ton) {
		return ton.getDiatonicAltFrom(this);
	}

	public int distSemitonesTo(@NonNull Chromatic n2) {
		int d = n2.ordinal() - ordinal();
		while (d < 0)
			d += IntervalChromatic.PERFECT_OCTAVE.getSemitones();

		return d;
	}

	/** Comparator **/

	@Deprecated
	private static class EnharmonicComparator implements java.util.Comparator<Chromatic> {
		@Override
		public int compare(Chromatic o1, Chromatic o2) {
			return Integer.compare(o1.ordinal(), o2.ordinal());
		}
	}

	@Deprecated
	public int compareEnharmonicTo(Chromatic otherChromatic) {
		return new EnharmonicComparator().compare(this, otherChromatic);
	}
}
