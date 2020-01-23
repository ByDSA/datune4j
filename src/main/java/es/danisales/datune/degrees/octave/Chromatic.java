package es.danisales.datune.degrees.octave;

import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.degrees.OrderedDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.lang.Namer;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.utils.MathUtils;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkState;

public enum Chromatic implements PitchChromaticSingle, CyclicDegree, OrderedDegree {
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

	private static Map<Class<? extends CyclicDegree>, Function<CyclicDegree, Chromatic>> conversionMap = new HashMap<>();

	static {
		conversionMap.put(DiatonicAlt.class, Chromatic::fromDiatonicAlt);
		conversionMap.put(Diatonic.class, Chromatic::fromDiatonic);
	}

	public static @NonNull Chromatic from(@NonNull CyclicDegree cyclicDegree) {
		return conversionMap.get(cyclicDegree.getClass()).apply(cyclicDegree);
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

	public static @NonNull Chromatic from(@NonNull PitchDiatonicMidi pitchDiatonicMidi) {
		DiatonicAlt diatonicAlt = pitchDiatonicMidi.getDiatonicAlt();
		return Chromatic.from(diatonicAlt);
	}

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
		return Namer.from(this);
	}

	public int distSemitonesTo(@NonNull Chromatic chromatic) {
		int d = chromatic.compareTo(this);
		if (d < 0)
			d += IntervalChromatic.PERFECT_OCTAVE.getSemitones();

		checkState(d >= 0 && d < Chromatic.NUMBER);

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
