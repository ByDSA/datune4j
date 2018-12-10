package pitch;

import diatonic.IntervalChromatic;
import midi.PitchException;
import midi.Settings;
import tonality.Tonality;

public enum PitchMidi implements PitchChromaticableSingle, PitchOctave<PitchMidi> {
	C0(0), CC0(1), D0(2), DD0(3), E0(4), F0(5), FF0(6), G0(7), GG0(8), A0(9), AA0(10), B0(11),
	C1(12), CC1(13), D1(14), DD1(15), E1(16), F1(17), FF1(18), G1(19), GG1(20), A1(21), AA1(22), B1(23),
	C2(0 + 12 * 2), CC2(1 + 12 * 2), D2(2 + 12 * 2), DD2(3 + 12 * 2), E2(4 + 12 * 2), F2(5 + 12 * 2), FF2(6 + 12 * 2), G2(7 + 12 * 2), GG2(8 + 12 * 2), A2(9 + 12 * 2), AA2(10 + 12 * 2), B2(11 + 12 * 2),
	C3(0 + 12 * 3), CC3(1 + 12 * 3), D3(2 + 12 * 3), DD3(3 + 12 * 3), E3(4 + 12 * 3), F3(5 + 12 * 3), FF3(6 + 12 * 3), G3(7 + 12 * 3), GG3(8 + 12 * 3), A3(9 + 12 * 3), AA3(10 + 12 * 3), B3(11 + 12 * 3),
	C4(0 + 12 * 4), CC4(1 + 12 * 4), D4(2 + 12 * 4), DD4(3 + 12 * 4), E4(4 + 12 * 4), F4(5 + 12 * 4), FF4(6 + 12 * 4), G4(7 + 12 * 4), GG4(8 + 12 * 4), A4(9 + 12 * 4), AA4(10 + 12 * 4), B4(11 + 12 * 4),
	C5(0 + 12 * 5), CC5(1 + 12 * 5), D5(2 + 12 * 5), DD5(3 + 12 * 5), E5(4 + 12 * 5), F5(5 + 12 * 5), FF5(6 + 12 * 5), G5(7 + 12 * 5), GG5(8 + 12 * 5), A5(9 + 12 * 5), AA5(10 + 12 * 5), B5(11 + 12 * 5),
	C6(0 + 12 * 6), CC6(1 + 12 * 6), D6(2 + 12 * 6), DD6(3 + 12 * 6), E6(4 + 12 * 6), F6(5 + 12 * 6), FF6(6 + 12 * 6), G6(7 + 12 * 6), GG6(8 + 12 * 6), A6(9 + 12 * 6), AA6(10 + 12 * 6), B6(11 + 12 * 6),
	C7(0 + 12 * 7), CC7(1 + 12 * 7), D7(2 + 12 * 7), DD7(3 + 12 * 7), E7(4 + 12 * 7), F7(5 + 12 * 7), FF7(6 + 12 * 7), G7(7 + 12 * 7), GG7(8 + 12 * 7), A7(9 + 12 * 7), AA7(10 + 12 * 7), B7(11 + 12 * 7),
	C8(0 + 12 * 8), CC8(1 + 12 * 8), D8(2 + 12 * 8), DD8(3 + 12 * 8), E8(4 + 12 * 8), F8(5 + 12 * 8), FF8(6 + 12 * 8), G8(7 + 12 * 8), GG8(8 + 12 * 8), A8(9 + 12 * 8), AA8(10 + 12 * 8), B8(11 + 12 * 8),
	C9(0 + 12 * 9), CC9(1 + 12 * 9), D9(2 + 12 * 9), DD9(3 + 12 * 9), E9(4 + 12 * 9), F9(5 + 12 * 9), FF9(6 + 12 * 9), G9(7 + 12 * 9), GG9(8 + 12 * 9), A9(9 + 12 * 9), AA9(10 + 12 * 9), B9(11 + 12 * 9),
	C10(0 + 12 * 10), CC10(1 + 12 * 10), D10(2 + 12 * 10), DD10(3 + 12 * 10), E10(4 + 12 * 10), F10(5 + 12 * 10), FF10(6 + 12 * 10), G10(7 + 12 * 10),
	MIN(C0), MAX(G10);

	private int value;

	private PitchMidi(int v) {
		value = v;
	}

	private PitchMidi(PitchMidi p) {
		value = p.value;
	}

	public int val() {
		return value;
	}

	public boolean equals(PitchMidi p) {
		return value == p.value;
	}

	public static PitchMidi get(Chromatic c, int o) {
		switch ( o ) {
			case 0:
				switch ( c.val() ) {
					case 0:
						return C0;
					case 1:
						return CC0;
					case 2:
						return D0;
					case 3:
						return DD0;
					case 4:
						return E0;
					case 5:
						return F0;
					case 6:
						return FF0;
					case 7:
						return G0;
					case 8:
						return GG0;
					case 9:
						return A0;
					case 10:
						return AA0;
					case 11:
						return B0;
					default:
						return null;
				}
			case 1:
				switch ( c.val() ) {
					case 0:
						return C1;
					case 1:
						return CC1;
					case 2:
						return D1;
					case 3:
						return DD1;
					case 4:
						return E1;
					case 5:
						return F1;
					case 6:
						return FF1;
					case 7:
						return G1;
					case 8:
						return GG1;
					case 9:
						return A1;
					case 10:
						return AA1;
					case 11:
						return B1;
					default:
						return null;
				}
			case 2:
				switch ( c.val() ) {
					case 0:
						return C2;
					case 1:
						return CC2;
					case 2:
						return D2;
					case 3:
						return DD2;
					case 4:
						return E2;
					case 5:
						return F2;
					case 6:
						return FF2;
					case 7:
						return G2;
					case 8:
						return GG2;
					case 9:
						return A2;
					case 10:
						return AA2;
					case 11:
						return B2;
					default:
						return null;
				}
			case 3:
				switch ( c.val() ) {
					case 0:
						return C3;
					case 1:
						return CC3;
					case 2:
						return D3;
					case 3:
						return DD3;
					case 4:
						return E3;
					case 5:
						return F3;
					case 6:
						return FF3;
					case 7:
						return G3;
					case 8:
						return GG3;
					case 9:
						return A3;
					case 10:
						return AA3;
					case 11:
						return B3;
					default:
						return null;
				}
			case 4:
				switch ( c.val() ) {
					case 0:
						return C4;
					case 1:
						return CC4;
					case 2:
						return D4;
					case 3:
						return DD4;
					case 4:
						return E4;
					case 5:
						return F4;
					case 6:
						return FF4;
					case 7:
						return G4;
					case 8:
						return GG4;
					case 9:
						return A4;
					case 10:
						return AA4;
					case 11:
						return B4;
					default:
						return null;
				}
			case 5:
				switch ( c.val() ) {
					case 0:
						return C5;
					case 1:
						return CC5;
					case 2:
						return D5;
					case 3:
						return DD5;
					case 4:
						return E5;
					case 5:
						return F5;
					case 6:
						return FF5;
					case 7:
						return G5;
					case 8:
						return GG5;
					case 9:
						return A5;
					case 10:
						return AA5;
					case 11:
						return B5;
					default:
						return null;
				}
			case 6:
				switch ( c.val() ) {
					case 0:
						return C6;
					case 1:
						return CC6;
					case 2:
						return D6;
					case 3:
						return DD6;
					case 4:
						return E6;
					case 5:
						return F6;
					case 6:
						return FF6;
					case 7:
						return G6;
					case 8:
						return GG6;
					case 9:
						return A6;
					case 10:
						return AA6;
					case 11:
						return B6;
					default:
						return null;
				}
			case 7:
				switch ( c.val() ) {
					case 0:
						return C7;
					case 1:
						return CC7;
					case 2:
						return D7;
					case 3:
						return DD7;
					case 4:
						return E7;
					case 5:
						return F7;
					case 6:
						return FF7;
					case 7:
						return G7;
					case 8:
						return GG7;
					case 9:
						return A7;
					case 10:
						return AA7;
					case 11:
						return B7;
					default:
						return null;
				}
			case 8:
				switch ( c.val() ) {
					case 0:
						return C8;
					case 1:
						return CC8;
					case 2:
						return D8;
					case 3:
						return DD8;
					case 4:
						return E8;
					case 5:
						return F8;
					case 6:
						return FF8;
					case 7:
						return G8;
					case 8:
						return GG8;
					case 9:
						return A8;
					case 10:
						return AA8;
					case 11:
						return B8;
					default:
						return null;
				}
			case 9:
				switch ( c.val() ) {
					case 0:
						return C9;
					case 1:
						return CC9;
					case 2:
						return D9;
					case 3:
						return DD9;
					case 4:
						return E9;
					case 5:
						return F9;
					case 6:
						return FF9;
					case 7:
						return G9;
					case 8:
						return GG9;
					case 9:
						return A9;
					case 10:
						return AA9;
					case 11:
						return B9;
					default:
						return null;
				}
			case 10:
				switch ( c.val() ) {
					case 0:
						return C10;
					case 1:
						return CC10;
					case 2:
						return D10;
					case 3:
						return DD10;
					case 4:
						return E10;
					case 5:
						return F10;
					case 6:
						return FF10;
					case 7:
						return G10;
					default:
						return null;
				}
			default:
				throw new PitchException( o * 12 + c.val() );
		}
	}

	@Override
	public Chromatic getChromatic() {
		if ( value % 12 == 0 )
			return Chromatic.C;
		else if ( value % 12 == 1 )
			return Chromatic.CC;
		else if ( value % 12 == 2 )
			return Chromatic.D;
		else if ( value % 12 == 3 )
			return Chromatic.DD;
		else if ( value % 12 == 4 )
			return Chromatic.E;
		else if ( value % 12 == 5 )
			return Chromatic.F;
		else if ( value % 12 == 6 )
			return Chromatic.FF;
		else if ( value % 12 == 7 )
			return Chromatic.G;
		else if ( value % 12 == 8 )
			return Chromatic.GG;
		else if ( value % 12 == 9 )
			return Chromatic.A;
		else if ( value % 12 == 10 )
			return Chromatic.AA;
		else if ( value % 12 == 11 )
			return Chromatic.B;
		else
			return null;
	}

	@Override
	public PitchMidi shiftOctave(int o) {
		return getFromCode( value + 12 * o );
	}

	@Override
	public PitchMidi setOctave(int o) {
		return getFromCode( value % 12 + 12 * o );
	}

	@Override
	public int getOctave() {
		return value / 12;
	}

	@Override
	public float getPitchMean() {
		return value;
	}

	public static PitchMidi add(PitchMidi p, int i) {
		return getFromCode( p.value + i );
	}

	public static PitchMidi add(PitchMidi p, IntervalChromatic i) {
		return add( p, i.val() );
	}

	public static PitchMidi getFromCode(int code) {
		PitchException.check( code );
		Chromatic n = Chromatic.get( code % ChromaticMidi.NOTES_PER_OCTAVE );
		int o = code / 12;
		return get( n, o );
	}

	public ChromaticMidi toMidi(int length, int velocity) {
		return new ChromaticMidi( this, length, velocity );
	}

	public ChromaticMidi toMidi(int length) {
		return toMidi( length, Settings.DefaultValues.VELOCITY );
	}

	public ChromaticMidi toMidi() {
		return toMidi( Settings.DefaultValues.VELOCITY );
	}
}
