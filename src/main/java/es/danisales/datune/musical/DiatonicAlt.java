package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.lang.Namer;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.pitch.CyclicAbsoluteDegree;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.SymbolicPitch;
import es.danisales.datune.tonality.ScaleDistance;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("WeakerAccess")
public class DiatonicAlt implements SymbolicPitch {
	public static final DiatonicAlt C = new DiatonicAlt(Diatonic.C, 0);
	public static final DiatonicAlt D = new DiatonicAlt(Diatonic.D, 0);
	public static final DiatonicAlt E = new DiatonicAlt(Diatonic.E, 0);
	public static final DiatonicAlt F = new DiatonicAlt(Diatonic.F, 0);
	public static final DiatonicAlt G = new DiatonicAlt(Diatonic.G, 0);
	public static final DiatonicAlt A = new DiatonicAlt(Diatonic.A,0);
	public static final DiatonicAlt B = new DiatonicAlt(Diatonic.B,0);

	public static final DiatonicAlt CC = new DiatonicAlt(Diatonic.C, 1);
	public static final DiatonicAlt DD = new DiatonicAlt(Diatonic.D, 1);
	public static final DiatonicAlt EE = new DiatonicAlt(Diatonic.E, 1);
	public static final DiatonicAlt FF = new DiatonicAlt(Diatonic.F, 1);
	public static final DiatonicAlt GG = new DiatonicAlt(Diatonic.G, 1);
	public static final DiatonicAlt AA = new DiatonicAlt(Diatonic.A, 1);
	public static final DiatonicAlt BB = new DiatonicAlt(Diatonic.B,1);

	public static final DiatonicAlt CCC = new DiatonicAlt(Diatonic.C, 2);
	public static final DiatonicAlt DDD = new DiatonicAlt(Diatonic.D, 2);
	public static final DiatonicAlt EEE = new DiatonicAlt(Diatonic.E, 2);
	public static final DiatonicAlt FFF = new DiatonicAlt(Diatonic.F, 2);
	public static final DiatonicAlt GGG = new DiatonicAlt(Diatonic.G,2);
	public static final DiatonicAlt AAA = new DiatonicAlt(Diatonic.A,2);
	public static final DiatonicAlt BBB = new DiatonicAlt(Diatonic.B,2);

	public static final DiatonicAlt CCCC = new DiatonicAlt(Diatonic.C, 3);
	public static final DiatonicAlt DDDD = new DiatonicAlt(Diatonic.D, 3);
	public static final DiatonicAlt EEEE = new DiatonicAlt(Diatonic.E, 3);
	public static final DiatonicAlt FFFF = new DiatonicAlt(Diatonic.F, 3);
	public static final DiatonicAlt GGGG = new DiatonicAlt(Diatonic.G, 3);
	public static final DiatonicAlt AAAA = new DiatonicAlt(Diatonic.A, 3);
	public static final DiatonicAlt BBBB = new DiatonicAlt(Diatonic.B, 3);

	public static final DiatonicAlt CCCCC = new DiatonicAlt(Diatonic.C, 4);
	public static final DiatonicAlt DDDDD = new DiatonicAlt(Diatonic.D, 4);
	public static final DiatonicAlt EEEEE = new DiatonicAlt(Diatonic.E, 4);
	public static final DiatonicAlt FFFFF = new DiatonicAlt(Diatonic.F, 4);
	public static final DiatonicAlt GGGGG = new DiatonicAlt(Diatonic.G, 4);
	public static final DiatonicAlt AAAAA = new DiatonicAlt(Diatonic.A, 4);
	public static final DiatonicAlt BBBBB = new DiatonicAlt(Diatonic.B, 4);

	public static final DiatonicAlt Cb = new DiatonicAlt(Diatonic.C, -1);
	public static final DiatonicAlt Db = new DiatonicAlt(Diatonic.D, -1);
	public static final DiatonicAlt Eb = new DiatonicAlt(Diatonic.E, -1);
	public static final DiatonicAlt Fb = new DiatonicAlt(Diatonic.F, -1);
	public static final DiatonicAlt Gb = new DiatonicAlt(Diatonic.G, -1);
	public static final DiatonicAlt Ab = new DiatonicAlt(Diatonic.A, -1);
	public static final DiatonicAlt Bb = new DiatonicAlt(Diatonic.B, -1);
	public static final DiatonicAlt Cbb = new DiatonicAlt(Diatonic.C, -2);
	public static final DiatonicAlt Dbb = new DiatonicAlt(Diatonic.D, -2);
	public static final DiatonicAlt Ebb = new DiatonicAlt(Diatonic.E, -2);
	public static final DiatonicAlt Fbb = new DiatonicAlt(Diatonic.F, -2);
	public static final DiatonicAlt Gbb = new DiatonicAlt(Diatonic.G, -2);
	public static final DiatonicAlt Abb = new DiatonicAlt(Diatonic.A, -2);
	public static final DiatonicAlt Bbb = new DiatonicAlt(Diatonic.B, -2);

	public static final DiatonicAlt Cbbb = new DiatonicAlt(Diatonic.C, -3);
	public static final DiatonicAlt Dbbb = new DiatonicAlt(Diatonic.D, -3);
	public static final DiatonicAlt Ebbb = new DiatonicAlt(Diatonic.E, -3);
	public static final DiatonicAlt Fbbb = new DiatonicAlt(Diatonic.F, -3);
	public static final DiatonicAlt Gbbb = new DiatonicAlt(Diatonic.G, -3);
	public static final DiatonicAlt Abbb = new DiatonicAlt(Diatonic.A, -3);
	public static final DiatonicAlt Bbbb = new DiatonicAlt(Diatonic.B, -3);

	private static final Set<DiatonicAlt> ALL_PRECALC = Collections.unmodifiableSet( new HashSet<>(Arrays.asList(
			C, D, E, F, G, A, B,
			CC, DD, EE, FF, GG, AA, BB,
			CCC, DDD, EEE, FFF, GGG, AAA, BBB,
			CCCC, DDDD, EEEE, FFFF, GGGG, AAAA, BBBB,
			CCCCC, DDDDD, EEEEE, FFFFF, GGGGG, AAAAA, BBBBB,
			Cb, Db, Eb, Fb, Gb, Ab, Bb,
			Cbb, Dbb, Ebb, Fbb, Gbb, Abb, Bbb,
			Cbbb, Dbbb, Ebbb, Fbbb, Gbbb, Abbb, Bbbb
	)));

	private static final float TOLERANCE = 0.01f;

	private final int semitonesAdded;
	private final float microtonalAdded;
	private final Diatonic diatonicBase;
	private final float alt;

	private DiatonicAlt(Diatonic diatonicBase, float alt) {
		this.diatonicBase = diatonicBase;
		this.alt = alt;
		this.semitonesAdded = (int)alt;
		float diff = alt - this.semitonesAdded;
		this.microtonalAdded = Math.abs(diff) < TOLERANCE ? 0 : diff;
	}

	public static @NonNull DiatonicAlt from(@NonNull PitchChromaticSingle chromatic, @NonNull Diatonic diatonic) {
		return DiatonicAltAdapter.from(chromatic, diatonic);
	}

	public static @NonNull DiatonicAlt from(@NonNull Diatonic diatonic, float alt) {
		DiatonicAlt ret = getPrecalc(diatonic, alt);
		if (ret != null)
			return ret;

		return new DiatonicAlt(diatonic, alt);
	}

	private static @Nullable DiatonicAlt getPrecalc(Diatonic diatonic, float alt) {
		for (DiatonicAlt d : ALL_PRECALC)
			if (d.getDiatonic().equals(diatonic) && d.getSemitonesAdded() + d.getMicrotonalPartAdded() == alt)
				return d;

			return null;
	}

	public static @NonNull DiatonicAlt from(@NonNull Chromatic chromatic) {
		return DiatonicAltAdapter.from(chromatic);
	}

	public static @NonNull DiatonicAlt from(@NonNull ChromaticMidi chromaticMidi) {
		return DiatonicAltAdapter.from(chromaticMidi);
	}

	public static @NonNull DiatonicAlt from(@NonNull Diatonic diatonic, @NonNull Tonality tonality) throws TonalityException {
		for ( DiatonicAlt diatonicAlt : tonality.getNotes() )
			if (diatonicAlt.getDiatonic().equals(diatonic))
				return diatonicAlt;

		throw new TonalityException(diatonic, tonality);
	}

    public static DiatonicAlt from(@NonNull Chromatic chromatic, float microPart, @NonNull CyclicAbsoluteDegree absoluteDegree) {
		return DiatonicAltAdapter.from(chromatic, microPart, absoluteDegree);
	}

    public static DiatonicAlt from(float semis, @NonNull CyclicAbsoluteDegree absoluteDegree) {
		return DiatonicAltAdapter.from(semis, absoluteDegree);
	}

	public int getSemitonesAdded() {
		return semitonesAdded;
	}

	public float getMicrotonalPartAdded() {
		return microtonalAdded;
	}

	public @NonNull DiatonicAlt add(ScaleDistance scaleDistance) {
		return DiatonicAlt.from(diatonicBase, alt + scaleDistance.getMicrotonalSemitones());
	}

	public @NonNull DiatonicAlt sub(ScaleDistance scaleDistance) {
		return DiatonicAlt.from(diatonicBase, alt - scaleDistance.getMicrotonalSemitones());
	}

	public @NonNull DiatonicAlt getAddSemi(int semis) {
		return DiatonicAlt.from(diatonicBase, alt + semis);
	}

	public float getUnsignedAlterations() {
		return Math.abs( getAlterations() );
	}

	public float getAlterations() {
		return getSemitonesAdded() + getMicrotonalPartAdded();
	}

	public @NonNull DiatonicAlt getNextDiatonic() { // todo: used only in tunning (revisar tras hacer tunning)
		return new DiatonicAlt(diatonicBase.getNext(), alt);
	}

	public @NonNull Diatonic getDiatonic() {
		return diatonicBase;
	}

	@Override
	public String toString() {
		return Namer.from(this);
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof DiatonicAlt))
			return false;

		DiatonicAlt casted = (DiatonicAlt)o;

		return this.diatonicBase == casted.diatonicBase
				&& this.semitonesAdded == casted.semitonesAdded
				&& this.microtonalAdded == casted.microtonalAdded;
	}

	@Override
	public int hashCode() {
		return diatonicBase.hashCode() + Float.hashCode(alt);
	}
}
