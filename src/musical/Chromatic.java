package musical;

import java.util.ArrayList;

import diatonic.DiatonicDegree;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import midi.Settings;
import pitch.ChromaticMidi;
import pitch.PitchChromaticSingle;
import pitch.PitchSingle;
import tonality.Tonality;
import tonality.TonalityException;

public enum Chromatic implements PitchChromaticSingle {
	C(0), D(2), E(4), F(5), G(7),A(9), B(11),
	CC(C.val() + 1), DD(D.val() + 1), EE(E.val() + 1), FF(F.val() + 1), GG(G.val() + 1), AA(A.val() + 1), BB(B.val() + 1),
	CCC(C.val() + 2), DDD(D.val() + 2), EEE(E.val() + 2), FFF(F.val() + 2), GGG(G.val() + 2), AAA(A.val() + 2), BBB(B.val() + 2),
	CCCC(C.val() + 3), DDDD(D.val() + 3), EEEE(E.val() + 3), FFFF(F.val() + 3), GGGG(G.val() + 3), AAAA(A.val() + 3), BBBB(B.val() + 3),
	CCCCC(C.val() + 4), DDDDD(D.val() + 4), EEEEE(E.val() + 3), FFFFF(F.val() + 4), GGGGG(G.val() + 4), AAAAA(A.val() + 4), BBBBB(B.val() + 4),
	Cb(C.val() - 1), Db(D.val() - 1), Eb(E.val() - 1), Fb(F.val() - 1), Gb(G.val() - 1), Ab(A.val() - 1), Bb(B.val() - 1),
	Cbb(C.val() - 2), Dbb(D.val() - 2), Ebb(E.val() - 2), Fbb(F.val() - 2), Gbb(G.val() - 2), Abb(A.val() - 2), Bbb(B.val() - 2),
	Cbbb(C.val() - 3), Dbbb(D.val() - 3), Ebbb(E.val() - 3), Fbbb(F.val() - 3), Gbbb(G.val() - 3), Abbb(A.val() - 3), Bbbb(B.val() - 3);

	public static final String FLAT = "b";
	public static final String SHARP = "#";

	private final int value;
	private Chromatic(int value) {
		this.value = delimit(value);
	}

	public int val() {
		return value;
	}

	public Chromatic add(int n) {
		return get(this.val() + n);
	}
	
	public Chromatic addSemi() {
		switch(this) {
			case A: 	return AA;
			case AA: 	return AAA;
			case AAA: 	return AAAA;
			case AAAA: 	return AAAAA;
			case Ab: 	return A;
			case Abb:	return Ab;
			case Abbb:	return Abb;
			case B:		return BB;
			case BB:	return BBB;
			case BBB:	return BBBB;
			case BBBB:	return BBBBB;
			case Bb:	return B;
			case Bbb:	return Bb;
			case Bbbb:	return Bbb;
			case C:		return CC;
			case CC:	return CCC;
			case CCC:	return CCCC;
			case CCCC:	return CCCCC;
			case Cb:	return C;
			case Cbb:	return Cb;
			case Cbbb:	return Cbb;
			case D:		return DD;
			case DD:	return DDD;
			case DDD:	return DDDD;
			case DDDD:	return DDDDD;
			case Db:	return D;
			case Dbb:	return Db;
			case Dbbb:	return Dbb;
			case E:		return EE;
			case EE:	return EEE;
			case EEE:	return EEEE;
			case EEEE:	return EEEEE;
			case Eb:	return E;
			case Ebb:	return Eb;
			case Ebbb:	return Ebb;
			case F:		return FF;
			case FF:	return FFF;
			case FFF:	return FFFF;
			case FFFF:	return FFFFF;
			case Fb:	return F;
			case Fbb:	return Fb;
			case Fbbb:	return Fbb;
			case G:		return GG;
			case GG:	return GGG;
			case GGG:	return GGGG;
			case GGGG:	return GGGGG;
			case Gb:	return G;
			case Gbb:	return Gb;
			case Gbbb:	return Gbb;
			default:	throw new AlterationException();
		}
	}
	
	public Chromatic subSemi() {
		switch(this) {
			case A: 	return Ab;
			case AA: 	return A;
			case AAA: 	return AA;
			case AAAA: 	return AAA;
			case AAAAA:	return AAAA;
			case Ab: 	return Abb;
			case Abb:	return Abbb;
			case B:		return Bb;
			case BB:	return B;
			case BBB:	return BB;
			case BBBB:	return BBB;
			case BBBBB:	return BBBB;
			case Bb:	return Bbb;
			case Bbb:	return Bbbb;
			case C:		return Cb;
			case CC:	return C;
			case CCC:	return CC;
			case CCCC:	return CCC;
			case CCCCC:	return CCCC;
			case Cb:	return Cbb;
			case Cbb:	return Cbbb;
			case D:		return Db;
			case DD:	return D;
			case DDD:	return DD;
			case DDDD:	return DDD;
			case DDDDD:	return DDDD;
			case Db:	return Dbb;
			case Dbb:	return Dbbb;
			case E:		return Eb;
			case EE:	return E;
			case EEE:	return EE;
			case EEEE:	return EEE;
			case EEEEE:	return EEEE;
			case Eb:	return Ebb;
			case Ebb:	return Ebbb;
			case F:		return Fb;
			case FF:	return F;
			case FFF:	return FF;
			case FFFF:	return FFF;
			case FFFFF:	return FFFF;
			case Fb:	return Fbb;
			case Fbb:	return Fbbb;
			case G:		return Gb;
			case GG:	return G;
			case GGG:	return GG;
			case GGGG:	return GGG;
			case GGGGG:	return GGGG;
			case Gb:	return Gbb;
			case Gbb:	return Gbbb;
			default:	throw new AlterationException();
		}
	}

	public Chromatic[] getEnharmonics() {
		ArrayList<Chromatic> tmp = new ArrayList<Chromatic>();

		Chromatic[] values = C.getDeclaringClass().getEnumConstants();

		for(Chromatic c : values)
			if (c.value == value)
				tmp.add(c);

		Chromatic[] out = new Chromatic[tmp.size()];
		tmp.toArray(out);

		return out;
	}

	public static Chromatic[] getAllEnharmonics() {
		Chromatic[] values = C.getDeclaringClass().getEnumConstants();

		return values;
	}

	public int getAlterations() {
		switch(this) {
		case CC:
		case DD:
		case EE:
		case FF:
		case GG:
		case AA:
		case BB:
		case Cb:
		case Db:
		case Eb:
		case Fb:
		case Gb:
		case Ab:
		case Bb:
			return 1;
		case CCC:
		case DDD:
		case EEE:
		case FFF:
		case GGG:
		case AAA:
		case BBB:
		case Cbb:
		case Dbb:
		case Ebb:
		case Fbb:
		case Gbb:
		case Abb:
		case Bbb:
			return 2;
		case CCCC:
		case DDDD:
		case EEEE:
		case FFFF:
		case GGGG:
		case AAAA:
		case BBBB:
		case Cbbb:
		case Dbbb:
		case Ebbb:
		case Fbbb:
		case Gbbb:
		case Abbb:
		case Bbbb:
			return 3;
		case CCCCC:
		case DDDDD:
		case EEEEE:
		case FFFFF:
		case GGGGG:
		case AAAAA:
		case BBBBB:
			return 4;
		case A:
		case B:
		case C:
		case D:
		case E:
		case F:
		case G:
			return 0;
		}

		assert false : this;
		return 0;
	}

	

	private static int delimit(int n) {
		n = n % 12;
		while(n < 0)
			n += 12;

		return n;
	}

	public static Chromatic get(int n) {
		n = delimit(n);

		switch(n) {
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
		default: return null;
		}
	}

	public Chromatic removeAlterations() {
		switch(this) {
		case C:
		case CC:
		case CCC:
		case CCCC:
		case CCCCC:
		case Cb:
		case Cbb:
		case Cbbb:
			return C;
		case D:
		case DD:
		case DDD:
		case DDDD:
		case DDDDD:
		case Db:
		case Dbb:
		case Dbbb:
			return D;
		case E:
		case EE:
		case EEE:
		case EEEE:
		case EEEEE:
		case Eb:
		case Ebb:
		case Ebbb:
			return E;
		case F:
		case FF:
		case FFF:
		case FFFF:
		case FFFFF:
		case Fb:
		case Fbb:
		case Fbbb:
			return F;
		case G:
		case GG:
		case GGG:
		case GGGG:
		case GGGGG:
		case Gb:
		case Gbb:
		case Gbbb:
			return G;
		case A:
		case AA:
		case AAA:
		case AAAA:
		case AAAAA:
		case Ab:
		case Abb:
		case Abbb:
			return A;
		case B:
		case BB:
		case BBB:
		case BBBB:
		case BBBBB:
		case Bb:
		case Bbb:
		case Bbbb:
			return B;
		}

		return null;
	}

	public String toString() {
		Chromatic c = removeAlterations();

		switch(this) {
		case C: return "C";
		case D: return "D";
		case E: return "E";
		case F: return "F";
		case G: return "G";
		case A: return "A";
		case B: return "B";
		case CC:
		case DD:
		case EE:
		case FF:
		case GG:
		case AA:
		case BB:
			return c + SHARP;
		case CCC:
		case DDD:
		case EEE:
		case FFF:
		case GGG:
		case AAA:
		case BBB:
			return c + SHARP + SHARP; 
		case CCCC:
		case DDDD:
		case EEEE:
		case FFFF:
		case GGGG:
		case AAAA:
		case BBBB:
			return c + SHARP + SHARP; 
		case CCCCC:
		case DDDDD:
		case EEEEE:
		case FFFFF:
		case GGGGG:
		case AAAAA:
		case BBBBB:
			return c + SHARP + SHARP + SHARP; 
		case Cb:
		case Db:
		case Eb:
		case Fb:
		case Gb:
		case Ab:
		case Bb:
			return c + FLAT;
		case Cbb:
		case Dbb:
		case Ebb:
		case Fbb:
		case Gbb:
		case Abb:
		case Bbb:
			return c + FLAT + FLAT;
		case Cbbb:
		case Dbbb:
		case Ebbb:
		case Fbbb:
		case Gbbb:
		case Abbb:
		case Bbbb:
			return c + FLAT + FLAT + FLAT;
		default: return "Nota desconocida";
		}
	}

	public IntervalChromatic dist(Chromatic n, IntervalDiatonic i) {
		int d = n.getChromatic().val() - this.val();
		return IntervalChromatic.get( i, d );
	}

	public Chromatic getChromatic() {
		return this;
	}

	public Diatonic getDiatonic(Tonality ton) throws TonalityException {
		DiatonicDegree pos = ton.getDegree(getChromatic());
		if (pos == null)
			throw new TonalityException(this, ton);
		else {
			return Diatonic.get(pos);
		}
	}

	public ChromaticMidi toMidi(int octave, int length, int velocity) {
		ChromaticMidi cm = new ChromaticMidi( this, octave, length, velocity );
		return cm;
	}
	
	public ChromaticMidi toMidi(int octave, int length) {
		return toMidi(octave, length, Settings.DefaultValues.VELOCITY);
	}
	
	public ChromaticMidi toMidi(int octave) {
		return toMidi(octave, Settings.DefaultValues.DURATION_NOTE);
	}
	
	public ChromaticMidi toMidi() {
		return toMidi(Settings.DefaultValues.OCTAVE);
	}

	public Chromatic rename(Tonality ton) {
		return ton.getEnharmonic(this);
	}
	
	public boolean equalsEnharmonic(Chromatic c) {
		return val() == c.val();
	}
	
	public Integer dist(Chromatic n2) {
		int d = n2.getChromatic().val() - getChromatic().val();
		while (d < 0)
			d += IntervalChromatic.PERFECT_OCTAVE.val();
		
		return d;
	}

	public Chromatic next() {
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
	
	public static int notesPerOctave() {
		return 12;
	}
}
