package es.danisales.datune.degrees.octave;

import es.danisales.datune.degrees.OrderedDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.lang.Nominator;
import es.danisales.datune.midi.pitch.PitchTonalMidi;
import es.danisales.utils.MathUtils;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public enum Chromatic implements CyclicDegree, OrderedDegree, Cloneable {
	C, CC, D, DD, E, F, FF, G, GG, A, AA, B;

	public static final int NUMBER = values().length;

	private static final Map<DiatonicAlt, Chromatic> diatonicAltChromaticMap = new HashMap<>();
	static {
		diatonicAltChromaticMap.put(DiatonicAlt.BB, Chromatic.C);
		diatonicAltChromaticMap.put(DiatonicAlt.C, Chromatic.C);
		diatonicAltChromaticMap.put(DiatonicAlt.BBB, Chromatic.CC);
		diatonicAltChromaticMap.put(DiatonicAlt.CC, Chromatic.CC);
		diatonicAltChromaticMap.put(DiatonicAlt.CCC, Chromatic.D);
		diatonicAltChromaticMap.put(DiatonicAlt.D, Chromatic.D);
		diatonicAltChromaticMap.put(DiatonicAlt.DD, Chromatic.DD);
		diatonicAltChromaticMap.put(DiatonicAlt.DDD, Chromatic.E);
		diatonicAltChromaticMap.put(DiatonicAlt.E, Chromatic.E);
		diatonicAltChromaticMap.put(DiatonicAlt.EE, Chromatic.F);
		diatonicAltChromaticMap.put(DiatonicAlt.F, Chromatic.F);
		diatonicAltChromaticMap.put(DiatonicAlt.EEE, Chromatic.FF);
		diatonicAltChromaticMap.put(DiatonicAlt.FF, Chromatic.FF);
		diatonicAltChromaticMap.put(DiatonicAlt.FFF, Chromatic.G);
		diatonicAltChromaticMap.put(DiatonicAlt.G, Chromatic.G);
		diatonicAltChromaticMap.put(DiatonicAlt.GG, Chromatic.GG);
		diatonicAltChromaticMap.put(DiatonicAlt.GGG, Chromatic.A);
		diatonicAltChromaticMap.put(DiatonicAlt.A, Chromatic.A);
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
	}

	private static Map<Class<? extends CyclicDegree>, Function<CyclicDegree, Chromatic>> conversionMap = new HashMap<>();

	static {
		conversionMap.put(DiatonicAlt.class, Chromatic::fromDiatonicAlt);
		conversionMap.put(Diatonic.class, Chromatic::fromDiatonic);
		conversionMap.put(Chromatic.class, Chromatic::fromChromatic);
	}

	public static @NonNull Chromatic from(@NonNull CyclicDegree cyclicDegree) {
		Class<? extends CyclicDegree> cClass = cyclicDegree.getClass();
		Function<CyclicDegree, Chromatic> function = conversionMap.get(cClass);
		return function.apply(cyclicDegree);
	}

	private static @NonNull Chromatic fromDiatonicAlt(@NonNull CyclicDegree cyclicDegree) {
		DiatonicAlt diatonicAlt = (DiatonicAlt)Objects.requireNonNull(cyclicDegree);
		Chromatic ret = diatonicAltChromaticMap.get(diatonicAlt);
		if (ret == null) {
			Diatonic diatonicOriginal = diatonicAlt.getDiatonic();
			int semitones = Math.round(diatonicAlt.getSemitonesAdded() + diatonicAlt.getMicrotonalPartAdded());
			Chromatic chromaticDiatonicOriginal = Chromatic.from(diatonicOriginal);
			ret = chromaticDiatonicOriginal.getNext(semitones);
		}

		return ret;
	}

	private static @NonNull Chromatic fromChromatic(@NonNull CyclicDegree cyclicDegree) {
		return (Chromatic)cyclicDegree;
	}

	@SuppressWarnings("Duplicates")
    private static @NonNull Chromatic fromDiatonic(@NonNull CyclicDegree cyclicDegree) {
		Diatonic diatonic = (Diatonic)Objects.requireNonNull(cyclicDegree);
		switch (diatonic) {
			case C: return C;
			case D: return D;
			case E: return E;
			case F: return F;
			case G: return G;
			case A: return A;
			case B: return B;
		}

        throw NeverHappensException.switchOf(diatonic);
	}

	public static @NonNull Chromatic from(@NonNull PitchTonalMidi pitchDiatonicMidi) {
		return pitchDiatonicMidi.getDiatonicAlt();
	}

	@NonNull
    public Chromatic getNext(int n) {
		int index = delimit(ordinal() + n);
		return values()[index];
	}

	public static @NonNull Chromatic from(int intVal) {
		intVal = delimit(intVal);
		return Chromatic.values()[intVal];
	}

	private static int delimit(int n) {
		return MathUtils.rotativeTrim(n, NUMBER);
	}

	public String toString() {
		return Nominator.from(this);
	}

	public int distSemitonesTo(@NonNull Chromatic chromatic) {
		return MathUtils.rotativeTrim( chromatic.compareTo(this), Chromatic.NUMBER );
	}

	public int minDistSemitonesTo(@NonNull Chromatic chromatic) {
		int d = distSemitonesTo(chromatic);
		if (d > 6)
			d = Chromatic.NUMBER - d;

		return d;
	}

	@Override
	public Chromatic getNext() {
		return Chromatic.from(ordinal()+1);
	}

	@Override
	public Chromatic getPrevious() {
		return Chromatic.from(ordinal()-1);
	}

	@Override
	public Chromatic getShifted(int i) {
		return Chromatic.from(ordinal() + i);
	}

	public Chromatic getShifted(IntervalChromatic intervalChromatic) {
		return getShifted( intervalChromatic.getSemitones() );
	}

	public Chromatic getShiftedNegative(IntervalChromatic intervalChromatic) {
		return getShifted( -intervalChromatic.getSemitones() );
	}
}
