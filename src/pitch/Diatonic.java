package pitch;

import diatonic.Degree;
import diatonic.IntervalDiatonic;
import tonality.Tonality;

public enum Diatonic
		implements PitchDiatonicSingle<Diatonic>, PitchMidiableSingle<DiatonicMidi> {
	I(0), II(1), III(2), IV(3), V(4), VI(5), VII(6);

	private final int value;

	private Diatonic(int value) {
		this.value = ( value + 12 ) % 12;
	}

	public int val() {
		return value;
	}

	public Diatonic add(int n) {
		return get( this.val() + n );
	}

	public static Diatonic get(int n) {
		n %= 7;
		while ( n < 0 )
			n += 7;

		switch ( n ) {
			case 0:
				return I;
			case 1:
				return II;
			case 2:
				return III;
			case 3:
				return IV;
			case 4:
				return V;
			case 5:
				return VI;
			case 6:
				return VII;
		}

		return null;
	}

	public static Diatonic get(Degree d) {
		return get( d.val() );
	}

	public static Diatonic get(Chromatic n) {
		switch ( n ) {
			case C:
			case CC:
			case CCC:
			case CCCC:
			case CCCCC:
			case Cb:
			case Cbb:
			case Cbbb:
				return Diatonic.I;
			case D:
			case DD:
			case DDD:
			case DDDD:
			case DDDDD:
			case Db:
			case Dbb:
			case Dbbb:
				return Diatonic.II;
			case E:
			case EE:
			case EEE:
			case EEEE:
			case EEEEE:
			case Eb:
			case Ebb:
			case Ebbb:
				return Diatonic.III;
			case F:
			case FF:
			case FFF:
			case FFFF:
			case FFFFF:
			case Fb:
			case Fbb:
			case Fbbb:
				return Diatonic.IV;
			case G:
			case GG:
			case GGG:
			case GGGG:
			case GGGGG:
			case Gb:
			case Gbb:
			case Gbbb:
				return Diatonic.V;
			case A:
			case AA:
			case AAA:
			case AAAA:
			case AAAAA:
			case Ab:
			case Abb:
			case Abbb:
				return Diatonic.VI;
			case B:
			case BB:
			case BBB:
			case BBBB:
			case BBBBB:
			case Bb:
			case Bbb:
			case Bbbb:
				return Diatonic.VII;
			default:
				return null;
		}
	}

	@Override
	public Degree getDegree() {
		return Degree.get( value );
	}

	public IntervalDiatonic dist(Diatonic n2) {
		int d = n2.getDegree().val() - getDegree().val();
		IntervalDiatonic id = IntervalDiatonic.get( d );

		return id;
	}

	@Override
	public Diatonic getDiatonic() {
		return this;
	}

	@Override
	public Chromatic toChromatic(Tonality t) {
		return t.get( getDegree() );
	}

	/**
	 * TODO: no es seguro que se usen
	 */
	public Chromatic toChromatic(Chromatic cn) throws Exception {
		return toChromatic( cn.val() );
	}

	public Chromatic toChromatic(int cn) throws Exception {
		switch ( this ) {
			case I:
				switch ( cn ) {
					case 0:
						return Chromatic.C;

					case 1:
						return Chromatic.CC;
					case 2:
						return Chromatic.CCC;
					case 3:
						return Chromatic.CCCC;
					case 4:
						return Chromatic.CCCCC;
					case 11:
						return Chromatic.Cb;
					case 10:
						return Chromatic.Cbb;
					case 9:
						return Chromatic.Cbbb;
				}
				break;
			case II:
				switch ( cn ) {
					case 2:
						return Chromatic.D;

					case 3:
						return Chromatic.DD;
					case 4:
						return Chromatic.DDD;
					case 5:
						return Chromatic.DDDD;
					case 6:
						return Chromatic.DDDDD;
					case 1:
						return Chromatic.Db;
					case 0:
						return Chromatic.Dbb;
					case 11:
						return Chromatic.Dbbb;
				}
				break;
			case III:
				switch ( cn ) {
					case 4:
						return Chromatic.E;

					case 5:
						return Chromatic.EE;
					case 6:
						return Chromatic.EEE;
					case 7:
						return Chromatic.EEEE;
					case 8:
						return Chromatic.EEEEE;
					case 3:
						return Chromatic.Eb;
					case 2:
						return Chromatic.Ebb;
					case 1:
						return Chromatic.Ebbb;
				}
				break;
			case IV:
				switch ( cn ) {
					case 5:
						return Chromatic.F;

					case 6:
						return Chromatic.FF;
					case 7:
						return Chromatic.FFF;
					case 8:
						return Chromatic.FFFF;
					case 9:
						return Chromatic.FFFFF;
					case 4:
						return Chromatic.Fb;
					case 3:
						return Chromatic.Fbb;
					case 2:
						return Chromatic.Fbbb;
				}
				break;
			case V:
				switch ( cn ) {
					case 7:
						return Chromatic.G;

					case 8:
						return Chromatic.GG;
					case 9:
						return Chromatic.GGG;
					case 10:
						return Chromatic.GGGG;
					case 11:
						return Chromatic.GGGGG;
					case 6:
						return Chromatic.Gb;
					case 5:
						return Chromatic.Gbb;
					case 4:
						return Chromatic.Gbbb;
				}
				break;
			case VI:
				switch ( cn ) {
					case 9:
						return Chromatic.A;

					case 10:
						return Chromatic.AA;
					case 11:
						return Chromatic.AAA;
					case 0:
						return Chromatic.AAAA;
					case 1:
						return Chromatic.AAAAA;
					case 8:
						return Chromatic.Ab;
					case 7:
						return Chromatic.Abb;
					case 6:
						return Chromatic.Abbb;
				}
				break;
			case VII:
				switch ( cn ) {
					case 11:
						return Chromatic.B;

					case 0:
						return Chromatic.BB;
					case 1:
						return Chromatic.BBB;
					case 2:
						return Chromatic.BBBB;
					case 3:
						return Chromatic.BBBBB;
					case 10:
						return Chromatic.Bb;
					case 9:
						return Chromatic.Bbb;
					case 8:
						return Chromatic.Bbbb;
				}
				break;
		}

		throw new Exception(
			"No se pudo convertir de nota diatónica (" + this + ", " + cn + ") a cromática."
		);
	}

	@Override
	public DiatonicMidi toMidi(Tonality t, int octave, int length, int velocity) {
		DiatonicMidi dm = new DiatonicMidi( getDegree(), t, octave, length, velocity );
		return dm;
	}
}
