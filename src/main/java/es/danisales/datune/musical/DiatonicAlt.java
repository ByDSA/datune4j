package es.danisales.datune.musical;

import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.SymbolicPitch;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

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

	private final int semitonesAdded;
	private final Diatonic diatonicBase;

	private DiatonicAlt(Diatonic diatonicBase, int semitonesAdded) {
		this.diatonicBase = diatonicBase;
		this.semitonesAdded = semitonesAdded;
	}

	public static @NonNull DiatonicAlt from(@NonNull PitchChromaticSingle chromatic, @NonNull Diatonic diatonic) {
		return DiatonicAltAdapter.from(chromatic, diatonic);
	}

	public static @NonNull DiatonicAlt from(@NonNull Diatonic diatonic, int alt) {
		return new DiatonicAlt(diatonic, alt);
	}

	public static @NonNull DiatonicAlt from(@NonNull PitchChromaticSingle pitchChromaticSingle) {
		return DiatonicAltAdapter.from(pitchChromaticSingle);
	}

	public static @Nullable DiatonicAlt from(@NonNull Diatonic diatonic, @NonNull Tonality tonality) {
		for ( DiatonicAlt diatonicAlt : tonality.getNotes() )
			if (diatonicAlt.getDiatonic().equals(diatonic))
				return diatonicAlt;

			return null;
	}

	public int getSemitonesAdded() {
		return semitonesAdded;
	}

	public @NonNull DiatonicAlt addSemi(int semis) {
		return new DiatonicAlt(diatonicBase, semitonesAdded + semis);
	}

	public int getAlterations() {
		int altSigned = getSemitonesAdded();
		if (altSigned == 0)
			return 0;
		return Math.abs( altSigned );
	}

	public @NonNull DiatonicAlt getNextDiatonic() {
		return new DiatonicAlt(diatonicBase.getNext(), semitonesAdded);
	}

	public @NonNull DiatonicAlt getPreviousDiatonic() {
		return new DiatonicAlt(diatonicBase.getPrevious(), semitonesAdded);
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

		return this.diatonicBase == casted.diatonicBase && this.semitonesAdded == casted.semitonesAdded;
	}

	@Override
	public int hashCode() {
		return diatonicBase.hashCode() + Integer.hashCode(semitonesAdded);
	}
}
