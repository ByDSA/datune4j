package es.danisales.datune.musical;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.transformations.AlterationsCalculator;
import es.danisales.datune.musical.transformations.EnharmonicsCalculator;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.SymbolicPitch;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

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

	public static DiatonicAlt from(@NonNull PitchChromaticSingle chromatic, @NonNull Diatonic diatonic) {
		return DiatonicAltAdapter.from(chromatic, diatonic);
	}

	public static DiatonicAlt from(Diatonic diatonic, int alt) {
		return new DiatonicAlt(diatonic, alt);
	}

	public static @NonNull DiatonicAlt from(@NonNull PitchChromaticSingle pitchChromaticSingle) {

		if (pitchChromaticSingle instanceof Chromatic)
			switch ((Chromatic)pitchChromaticSingle) {
				case C: return DiatonicAlt.C;
				case CC: return DiatonicAlt.CC;
				case D: return DiatonicAlt.D;
				case DD: return DiatonicAlt.DD;
				case E: return DiatonicAlt.E;
				case F: return DiatonicAlt.F;
				case FF: return DiatonicAlt.FF;
				case G: return DiatonicAlt.G;
				case GG: return DiatonicAlt.GG;
				case A: return DiatonicAlt.A;
				case AA: return DiatonicAlt.AA;
				case B: return DiatonicAlt.B;
			}
		else if (pitchChromaticSingle instanceof ChromaticMidi) {
			ChromaticMidi chromaticMidi = (ChromaticMidi)pitchChromaticSingle;
			Chromatic chromatic = Chromatic.from(chromaticMidi);
			return from(chromatic);
		}

		throw new RuntimeException("Impossible");
	}

	public static List<DiatonicAlt> listFromAlterations(int alts) {
		List<DiatonicAlt> ret = new ArrayList<>();
		for (int i = -alts; i <= alts; i++)
			for (Diatonic diatonic : Diatonic.values()) {
				DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, i);
				ret.add(diatonicAlt);
			}

		return ret;
	}

	public int getSemitonesAdded() {
		return semitonesAdded;
	}

	private boolean isEnharmonicFrom(DiatonicAlt chromatic) {
		return semitonesAdded == chromatic.semitonesAdded;
	}

	public DiatonicAlt addSemi(int semis) {
		return new DiatonicAlt(diatonicBase, semitonesAdded + semis);
	}

	public List<DiatonicAlt> getEnharmonics(int maxAlterations) {
		return EnharmonicsCalculator.calculateFrom(this, maxAlterations);
	}

	public int getAlterations() {
		int altSigned = getSemitonesAdded();
		if (altSigned == 0)
			return 0;
		return Math.abs( altSigned );
	}

	public String toString() {
		return Namer.from(this);
	}

	public DiatonicAlt getNextDiatonic() {
		return new DiatonicAlt(diatonicBase.shift(1), semitonesAdded);
	}

	public Diatonic getDiatonic() {
		return diatonicBase;
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof DiatonicAlt))
			return false;

		DiatonicAlt casted = (DiatonicAlt)o;

		return this.diatonicBase == casted.diatonicBase && this.semitonesAdded == casted.semitonesAdded;
	}
}
