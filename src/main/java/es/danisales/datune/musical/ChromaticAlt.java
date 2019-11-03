package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.transformations.*;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public enum ChromaticAlt implements PitchChromaticSingle {
	C(0), D(2), E(4), F(5), G(7),A(9), B(11),
	CC(C.intValue() + 1), DD(D.intValue() + 1), EE(E.intValue() + 1), FF(F.intValue() + 1), GG(G.intValue() + 1), AA(A.intValue() + 1), BB(B.intValue() + 1),
	CCC(C.intValue() + 2), DDD(D.intValue() + 2), EEE(E.intValue() + 2), FFF(F.intValue() + 2), GGG(G.intValue() + 2), AAA(A.intValue() + 2), BBB(B.intValue() + 2),
	CCCC(C.intValue() + 3), DDDD(D.intValue() + 3), EEEE(E.intValue() + 3), FFFF(F.intValue() + 3), GGGG(G.intValue() + 3), AAAA(A.intValue() + 3), BBBB(B.intValue() + 3),
	CCCCC(C.intValue() + 4), DDDDD(D.intValue() + 4), EEEEE(E.intValue() + 3), FFFFF(F.intValue() + 4), GGGGG(G.intValue() + 4), AAAAA(A.intValue() + 4), BBBBB(B.intValue() + 4),
	Cb(C.intValue() - 1), Db(D.intValue() - 1), Eb(E.intValue() - 1), Fb(F.intValue() - 1), Gb(G.intValue() - 1), Ab(A.intValue() - 1), Bb(B.intValue() - 1),
	Cbb(C.intValue() - 2), Dbb(D.intValue() - 2), Ebb(E.intValue() - 2), Fbb(F.intValue() - 2), Gbb(G.intValue() - 2), Abb(A.intValue() - 2), Bbb(B.intValue() - 2),
	Cbbb(C.intValue() - 3), Dbbb(D.intValue() - 3), Ebbb(E.intValue() - 3), Fbbb(F.intValue() - 3), Gbbb(G.intValue() - 3), Abbb(A.intValue() - 3), Bbbb(B.intValue() - 3);

    public static final int N = 12;

    private final int value;

	ChromaticAlt(int value) {
		this.value = delimit(value);
	}

	int intValue() {
		return value;
	}

	private boolean isEnharmonicFrom(ChromaticAlt chromatic) {
		return value == chromatic.value;
	}

	public ChromaticAlt addSemi(int n) {
		return from(this.intValue() + n);
	}

	public ChromaticAlt addSemi() {
		return PitchTransformation.addSemi(this);
	}

	public ChromaticAlt subSemi() {
		return PitchTransformation.subSemi(this);
	}

	public List<ChromaticAlt> getEnharmonics() {
		return EnharmonicsCalculator.calculateFrom(this);
	}

	public int getAlterations() {
		return AlterationsCalculator.from(this);
	}

	private static int delimit(int n) {
		n = n % N;
		while(n < 0)
			n += N;

		return n;
	}

	public static @NonNull ChromaticAlt from(int intVal) {
		intVal = delimit(intVal);

		switch(intVal) {
			case 0: return C;
			case 1: return CC;
			case 2: return D;
			case 3: return DD;
			case 4: return E;
			case 5: return F;
			case 6: return FF;
			case 7: return G;
			case 8: return GG;
			case 9: return A;
			case 10: return AA;
			case 11: return B;
		}

		throw new RuntimeException("Impossible");
	}

	public String toString() {
		return Namer.from(this);
	}

	public IntervalChromatic dist(ChromaticAlt n, IntervalDiatonic i) {
		return DistanceCalculator.calculareInterval(this, n, i);
	}

	public ChromaticAlt rename(Tonality ton) {
		return ton.getEnharmonic(this);
	}

	public int distSemitonesTo(ChromaticAlt n2) {
		int d = n2.intValue() - intValue();
		while (d < 0)
			d += IntervalChromatic.PERFECT_OCTAVE.getSemitones();

		return d;
	}

	public int distSemitonesFromC() {
		return ChromaticAlt.C.distSemitonesTo(this);
	}

	public ChromaticAlt nextDiatonic() {
		switch(this) {
			case A: 	return B;
			case AA: 	return BB;
			case AAA: 	return BBB;
			case AAAA: 	return BBBB;
			case AAAAA:	return BBBBB;
			case Ab:	return Bb;
			case Abb:	return Bbb;
			case Abbb:	return Bbbb;
			case B:		return C;
			case BB:	return CC;
			case BBB:	return CCC;
			case BBBB:	return CCCC;
			case BBBBB:	return CCCCC;
			case Bb:	return Cb;
			case Bbb:	return Cbb;
			case Bbbb:	return Cbbb;
			case C:		return D;
			case CC:	return DD;
			case CCC:	return DDD;
			case CCCC:	return DDDD;
			case CCCCC:	return DDDDD;
			case Cb:	return Db;
			case Cbb:	return Dbb;
			case Cbbb:	return Dbbb;
			case D:		return E;
			case DD:	return EE;
			case DDD:	return EEE;
			case DDDD:	return EEEE;
			case DDDDD:	return EEEEE;
			case Db:	return Eb;
			case Dbb:	return Ebb;
			case Dbbb:	return Ebbb;
			case E:		return F;
			case EE:	return FF;
			case EEE:	return FFF;
			case EEEE:	return FFFF;
			case EEEEE:	return FFFFF;
			case Eb:	return Fb;
			case Ebb:	return Fbb;
			case Ebbb:	return Fbbb;
			case F:		return G;
			case FF:	return GG;
			case FFF:	return GGG;
			case FFFF:	return GGGG;
			case FFFFF:	return GGGGG;
			case Fb:	return Gb;
			case Fbb:	return Gbb;
			case Fbbb:	return Gbbb;
			case G:		return A;
			case GG:	return AA;
			case GGG:	return AAA;
			case GGGG:	return AAAA;
			case GGGGG:	return AAAAA;
			case Gb:	return Ab;
			case Gbb:	return Abb;
			case Gbbb:	return Abbb;
			default:	throw new AlterationException();
		}
	}

	/** Comparator **/

	private static class EnharmonicComparator implements java.util.Comparator<ChromaticAlt> {
		@Override
		public int compare(ChromaticAlt o1, ChromaticAlt o2) {
			return Integer.compare(o1.intValue(), o2.intValue());
		}
	}

	public int compareEnharmonicTo(ChromaticAlt otherChromatic) {
		return new EnharmonicComparator().compare(this, otherChromatic);
	}
}
