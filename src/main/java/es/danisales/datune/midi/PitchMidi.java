package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.AlterationsCalculator;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import es.danisales.others.Codeable;

public enum PitchMidi implements PitchChromaticSingle, PitchOctaveMidi, Codeable {
	C0(0), CC0(1), D0(2), DD0(3), E0(4), F0(5), FF0(6), G0(7), GG0(8), A0(9), AA0(10), B0(11),
	C1(12), CC1(13), D1(14), DD1(15), E1(16), F1(17), FF1(18), G1(19), GG1(20), A1(21), AA1(22), B1(23),
	C2(0 + Chromatic.NUMBER * 2), CC2(1 + Chromatic.NUMBER * 2), D2(2 + Chromatic.NUMBER * 2), DD2(3 + Chromatic.NUMBER * 2), E2(4 + Chromatic.NUMBER * 2), F2(5 + Chromatic.NUMBER * 2), FF2(6 + Chromatic.NUMBER * 2), G2(7 + Chromatic.NUMBER * 2), GG2(8 + Chromatic.NUMBER * 2), A2(9 + Chromatic.NUMBER * 2), AA2(10 + Chromatic.NUMBER * 2), B2(11 + Chromatic.NUMBER * 2),
	C3(0 + Chromatic.NUMBER * 3), CC3(1 + Chromatic.NUMBER * 3), D3(2 + Chromatic.NUMBER * 3), DD3(3 + Chromatic.NUMBER * 3), E3(4 + Chromatic.NUMBER * 3), F3(5 + Chromatic.NUMBER * 3), FF3(6 + Chromatic.NUMBER * 3), G3(7 + Chromatic.NUMBER * 3), GG3(8 + Chromatic.NUMBER * 3), A3(9 + Chromatic.NUMBER * 3), AA3(10 + Chromatic.NUMBER * 3), B3(11 + Chromatic.NUMBER * 3),
	C4(0 + Chromatic.NUMBER * 4), CC4(1 + Chromatic.NUMBER * 4), D4(2 + Chromatic.NUMBER * 4), DD4(3 + Chromatic.NUMBER * 4), E4(4 + Chromatic.NUMBER * 4), F4(5 + Chromatic.NUMBER * 4), FF4(6 + Chromatic.NUMBER * 4), G4(7 + Chromatic.NUMBER * 4), GG4(8 + Chromatic.NUMBER * 4), A4(9 + Chromatic.NUMBER * 4), AA4(10 + Chromatic.NUMBER * 4), B4(11 + Chromatic.NUMBER * 4),
	C5(0 + Chromatic.NUMBER * 5), CC5(1 + Chromatic.NUMBER * 5), D5(2 + Chromatic.NUMBER * 5), DD5(3 + Chromatic.NUMBER * 5), E5(4 + Chromatic.NUMBER * 5), F5(5 + Chromatic.NUMBER * 5), FF5(6 + Chromatic.NUMBER * 5), G5(7 + Chromatic.NUMBER * 5), GG5(8 + Chromatic.NUMBER * 5), A5(9 + Chromatic.NUMBER * 5), AA5(10 + Chromatic.NUMBER * 5), B5(11 + Chromatic.NUMBER * 5),
	C6(0 + Chromatic.NUMBER * 6), CC6(1 + Chromatic.NUMBER * 6), D6(2 + Chromatic.NUMBER * 6), DD6(3 + Chromatic.NUMBER * 6), E6(4 + Chromatic.NUMBER * 6), F6(5 + Chromatic.NUMBER * 6), FF6(6 + Chromatic.NUMBER * 6), G6(7 + Chromatic.NUMBER * 6), GG6(8 + Chromatic.NUMBER * 6), A6(9 + Chromatic.NUMBER * 6), AA6(10 + Chromatic.NUMBER * 6), B6(11 + Chromatic.NUMBER * 6),
	C7(0 + Chromatic.NUMBER * 7), CC7(1 + Chromatic.NUMBER * 7), D7(2 + Chromatic.NUMBER * 7), DD7(3 + Chromatic.NUMBER * 7), E7(4 + Chromatic.NUMBER * 7), F7(5 + Chromatic.NUMBER * 7), FF7(6 + Chromatic.NUMBER * 7), G7(7 + Chromatic.NUMBER * 7), GG7(8 + Chromatic.NUMBER * 7), A7(9 + Chromatic.NUMBER * 7), AA7(10 + Chromatic.NUMBER * 7), B7(11 + Chromatic.NUMBER * 7),
	C8(0 + Chromatic.NUMBER * 8), CC8(1 + Chromatic.NUMBER * 8), D8(2 + Chromatic.NUMBER * 8), DD8(3 + Chromatic.NUMBER * 8), E8(4 + Chromatic.NUMBER * 8), F8(5 + Chromatic.NUMBER * 8), FF8(6 + Chromatic.NUMBER * 8), G8(7 + Chromatic.NUMBER * 8), GG8(8 + Chromatic.NUMBER * 8), A8(9 + Chromatic.NUMBER * 8), AA8(10 + Chromatic.NUMBER * 8), B8(11 + Chromatic.NUMBER * 8),
	C9(0 + Chromatic.NUMBER * 9), CC9(1 + Chromatic.NUMBER * 9), D9(2 + Chromatic.NUMBER * 9), DD9(3 + Chromatic.NUMBER * 9), E9(4 + Chromatic.NUMBER * 9), F9(5 + Chromatic.NUMBER * 9), FF9(6 + Chromatic.NUMBER * 9), G9(7 + Chromatic.NUMBER * 9), GG9(8 + Chromatic.NUMBER * 9), A9(9 + Chromatic.NUMBER * 9), AA9(10 + Chromatic.NUMBER * 9), B9(11 + Chromatic.NUMBER * 9),
	C10(0 + Chromatic.NUMBER * 10), CC10(1 + Chromatic.NUMBER * 10), D10(2 + Chromatic.NUMBER * 10), DD10(3 + Chromatic.NUMBER * 10), E10(4 + Chromatic.NUMBER * 10), F10(5 + Chromatic.NUMBER * 10), FF10(6 + Chromatic.NUMBER * 10), G10(7 + Chromatic.NUMBER * 10),
	MIN(C0), MAX(G10);

	private int value;

	private PitchMidi(int v) {
		value = v;
	}

	private PitchMidi(PitchMidi p) {
		value = p.value;
	}

	@Override
	public PitchMidi shiftOctave(int o) {
		return from( getCode() + Chromatic.NUMBER * o );
	}

	@Override
	public PitchMidi setOctave(int o) {
		return from( getCode() % Chromatic.NUMBER + Chromatic.NUMBER * o );
	}

	@Override
	public int getCode() {
		return value;
	}

	public boolean equals(PitchMidi p) {
		return value == p.value;
	}

	@Override
	public int getOctave() {
		return value / Chromatic.NUMBER;
	}

	public static PitchMidi from(int code) {
		PitchMidiException.check( code );
		Chromatic n = Chromatic.from( code % Chromatic.NUMBER);
		int o = code / Chromatic.NUMBER;
		return from( n, o );
	}

	public static PitchMidi from(Chromatic chromatic, int octave) {
		switch ( octave ) {
			case 0:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C0;
					case CC:
						return PitchMidi.CC0;
					case D:
						return PitchMidi.D0;
					case DD:
						return PitchMidi.DD0;
					case E:
						return PitchMidi.E0;
					case F:
						return PitchMidi.F0;
					case FF:
						return PitchMidi.FF0;
					case G:
						return PitchMidi.G0;
					case GG:
						return PitchMidi.GG0;
					case A:
						return PitchMidi.A0;
					case AA:
						return PitchMidi.AA0;
					case B:
						return PitchMidi.B0;
					default:
						return null;
				}
			case 1:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C1;
					case CC:
						return PitchMidi.CC1;
					case D:
						return PitchMidi.D1;
					case DD:
						return PitchMidi.DD1;
					case E:
						return PitchMidi.E1;
					case F:
						return PitchMidi.F1;
					case FF:
						return PitchMidi.FF1;
					case G:
						return PitchMidi.G1;
					case GG:
						return PitchMidi.GG1;
					case A:
						return PitchMidi.A1;
					case AA:
						return PitchMidi.AA1;
					case B:
						return PitchMidi.B1;
					default:
						return null;
				}
			case 2:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C2;
					case CC:
						return PitchMidi.CC2;
					case D:
						return PitchMidi.D2;
					case DD:
						return PitchMidi.DD2;
					case E:
						return PitchMidi.E2;
					case F:
						return PitchMidi.F2;
					case FF:
						return PitchMidi.FF2;
					case G:
						return PitchMidi.G2;
					case GG:
						return PitchMidi.GG2;
					case A:
						return PitchMidi.A2;
					case AA:
						return PitchMidi.AA2;
					case B:
						return PitchMidi.B2;
					default:
						return null;
				}
			case 3:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C3;
					case CC:
						return PitchMidi.CC3;
					case D:
						return PitchMidi.D3;
					case DD:
						return PitchMidi.DD3;
					case E:
						return PitchMidi.E3;
					case F:
						return PitchMidi.F3;
					case FF:
						return PitchMidi.FF3;
					case G:
						return PitchMidi.G3;
					case GG:
						return PitchMidi.GG3;
					case A:
						return PitchMidi.A3;
					case AA:
						return PitchMidi.AA3;
					case B:
						return PitchMidi.B3;
					default:
						return null;
				}
			case 4:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C4;
					case CC:
						return PitchMidi.CC4;
					case D:
						return PitchMidi.D4;
					case DD:
						return PitchMidi.DD4;
					case E:
						return PitchMidi.E4;
					case F:
						return PitchMidi.F4;
					case FF:
						return PitchMidi.FF4;
					case G:
						return PitchMidi.G4;
					case GG:
						return PitchMidi.GG4;
					case A:
						return PitchMidi.A4;
					case AA:
						return PitchMidi.AA4;
					case B:
						return PitchMidi.B4;
					default:
						return null;
				}
			case 5:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C5;
					case CC:
						return PitchMidi.CC5;
					case D:
						return PitchMidi.D5;
					case DD:
						return PitchMidi.DD5;
					case E:
						return PitchMidi.E5;
					case F:
						return PitchMidi.F5;
					case FF:
						return PitchMidi.FF5;
					case G:
						return PitchMidi.G5;
					case GG:
						return PitchMidi.GG5;
					case A:
						return PitchMidi.A5;
					case AA:
						return PitchMidi.AA5;
					case B:
						return PitchMidi.B5;
					default:
						return null;
				}
			case 6:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C6;
					case CC:
						return PitchMidi.CC6;
					case D:
						return PitchMidi.D6;
					case DD:
						return PitchMidi.DD6;
					case E:
						return PitchMidi.E6;
					case F:
						return PitchMidi.F6;
					case FF:
						return PitchMidi.FF6;
					case G:
						return PitchMidi.G6;
					case GG:
						return PitchMidi.GG6;
					case A:
						return PitchMidi.A6;
					case AA:
						return PitchMidi.AA6;
					case B:
						return PitchMidi.B6;
					default:
						return null;
				}
			case 7:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C7;
					case CC:
						return PitchMidi.CC7;
					case D:
						return PitchMidi.D7;
					case DD:
						return PitchMidi.DD7;
					case E:
						return PitchMidi.E7;
					case F:
						return PitchMidi.F7;
					case FF:
						return PitchMidi.FF7;
					case G:
						return PitchMidi.G7;
					case GG:
						return PitchMidi.GG7;
					case A:
						return PitchMidi.A7;
					case AA:
						return PitchMidi.AA7;
					case B:
						return PitchMidi.B7;
					default:
						return null;
				}
			case 8:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C8;
					case CC:
						return PitchMidi.CC8;
					case D:
						return PitchMidi.D8;
					case DD:
						return PitchMidi.DD8;
					case E:
						return PitchMidi.E8;
					case F:
						return PitchMidi.F8;
					case FF:
						return PitchMidi.FF8;
					case G:
						return PitchMidi.G8;
					case GG:
						return PitchMidi.GG8;
					case A:
						return PitchMidi.A8;
					case AA:
						return PitchMidi.AA8;
					case B:
						return PitchMidi.B8;
					default:
						return null;
				}
			case 9:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C9;
					case CC:
						return PitchMidi.CC9;
					case D:
						return PitchMidi.D9;
					case DD:
						return PitchMidi.DD9;
					case E:
						return PitchMidi.E9;
					case F:
						return PitchMidi.F9;
					case FF:
						return PitchMidi.FF9;
					case G:
						return PitchMidi.G9;
					case GG:
						return PitchMidi.GG9;
					case A:
						return PitchMidi.A9;
					case AA:
						return PitchMidi.AA9;
					case B:
						return PitchMidi.B9;
					default:
						return null;
				}
			case 10:
				switch ( chromatic ) {
					case C:
						return PitchMidi.C10;
					case CC:
						return PitchMidi.CC10;
					case D:
						return PitchMidi.D10;
					case DD:
						return PitchMidi.DD10;
					case E:
						return PitchMidi.E10;
					case F:
						return PitchMidi.F10;
					case FF:
						return PitchMidi.FF10;
					case G:
						return PitchMidi.G10;
					default:
						return null;
				}
			default:
				int code = getCodeFrom(chromatic, octave);
				throw new PitchMidiException(code);
		}
	}

	public PitchMidi shift(int i) {
		return PitchMidi.from(getCode() + i);
	}

	public PitchMidi shift(IntervalChromatic i) {
		return shift( i.getSemitones() );
	}

	public static int getCodeFrom(Chromatic chromatic, int octave) {
		return Chromatic.C.distSemitonesTo(chromatic) + octave * Chromatic.NUMBER;
	}
	
	public static PitchMidi from(DiatonicDegree degree, Tonality tonality, int octave) {
		int code = getCodeFrom( tonality.get( degree ), + octave);
		Chromatic root = tonality.getRoot();
		Chromatic degreeChromatic = tonality.get(degree);
		if ( degreeChromatic.compareEnharmonicTo(root) < 0 )
			code += Chromatic.NUMBER;

		return from( code );
	}

	public ChromaticMidi toMidi() {
		return ChromaticMidi.builder()
				.pitch(this)
				.build();
	}
}
