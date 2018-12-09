package pitch;

import java.util.ArrayList;

import diatonic.Degree;
import diatonic.Tonality;
import diatonic.TonalityException;
import midi.Settings;

public enum Chromatic implements PitchChromaticSingle<Chromatic> {
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

	private Chromatic removeAlterations() {
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

	public float dist(PitchChromaticable n) {
		float d = n.getPitchMean() - getPitchMean();
		d %= 12;

		float a = Math.abs(d);
		float b = Math.abs(d+12);
		float c = Math.abs(d-12);
		float min = Math.min(a, Math.min(b, c));
		if (min == a)
			return d;
		else if (min == b)
			return d+12;
		else
			return d-12;
	}

	@Override
	public Chromatic getChromatic() {
		return this;
	}

	@Override
	public Diatonic toDiatonicChordMidi(Tonality ton) throws TonalityException {
		Degree pos = ton.getDegree(getChromatic());
		if (pos == null)
			throw new TonalityException(this, ton);
		else {
			return Diatonic.get(pos);
		}
	}

	@Override
	public float getPitchMean() {
		return val();
	}

	@Override
	public Chromatic duplicate(boolean b) {
		return Chromatic.get(value);
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
}
