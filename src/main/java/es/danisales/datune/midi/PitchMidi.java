package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;

public enum PitchMidi implements PitchChromaticSingle, PitchOctaveMidi {
	C0, CC0, D0, DD0, E0, F0, FF0, G0, GG0, A0, AA0, B0,
	C1, CC1, D1, DD1, E1, F1, FF1, G1, GG1, A1, AA1, B1,
	C2, CC2, D2, DD2, E2, F2, FF2, G2, GG2, A2, AA2, B2,
	C3, CC3, D3, DD3, E3, F3, FF3, G3, GG3, A3, AA3, B3,
	C4, CC4, D4, DD4, E4, F4, FF4, G4, GG4, A4, AA4, B4,
	C5, CC5, D5, DD5, E5, F5, FF5, G5, GG5, A5, AA5, B5,
	C6, CC6, D6, DD6, E6, F6, FF6, G6, GG6, A6, AA6, B6,
	C7, CC7, D7, DD7, E7, F7, FF7, G7, GG7, A7, AA7, B7,
	C8, CC8, D8, DD8, E8, F8, FF8, G8, GG8, A8, AA8, B8,
	C9, CC9, D9, DD9, E9, F9, FF9, G9, GG9, A9, AA9, B9,
	C10, CC10, D10, DD10, E10, F10, FF10, G10;

	public static final PitchMidi MIN = C0;
	public static final PitchMidi MAX = G10;

	public Chromatic getChromatic() {
		return Chromatic.from(ordinal() % Chromatic.NUMBER);
	}

	public PitchMidi getWithShiftOctave(int o) {
		return from( getCode() + Chromatic.NUMBER * o );
	}

	public PitchMidi getWithOctave(int o) {
		return from( getCode() % Chromatic.NUMBER + Chromatic.NUMBER * o );
	}
	
	public int getCode() {
		return ordinal();
	}

	@Override
	public int getOctave() {
		return ordinal() / Chromatic.NUMBER;
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
				int code = getCodeNoTestLimits(chromatic, octave);
				throw new PitchMidiException(code);
		}
	}

	public PitchMidi getShift(int i) {
		return PitchMidi.from(getCode() + i);
	}

	public PitchMidi getShift(IntervalChromatic i) {
		return getShift( i.getSemitones() );
	}

	public static PitchMidi from(DiatonicDegree degree, Tonality tonality, int octave) {
		DiatonicAlt diatonicAlt = tonality.getNote( degree );
		Chromatic chromatic = Chromatic.from(diatonicAlt);
		int code = getCodeNoTestLimits(chromatic, octave);
		DiatonicAlt root = tonality.getRoot();
		Chromatic rootChromatic = Chromatic.from(root);
		DiatonicAlt degreeDiatonicAlt = tonality.getNote(degree);
		Chromatic degreeChromatic = Chromatic.from(degreeDiatonicAlt);
		if ( degreeChromatic.ordinal() < rootChromatic.ordinal() )
			code += Chromatic.NUMBER;

		return from( code );
	}

	private static int getCodeNoTestLimits(Chromatic chromatic, int octave) {
		return Chromatic.NUMBER * octave + chromatic.ordinal();
	}

	public ChromaticMidi toMidi() {
		return ChromaticMidi.builder()
				.pitch(this)
				.build();
	}

	@Override
	public ChromaticDegree getDegree() {
		return ChromaticDegree.values()[ getChromatic().ordinal() ];
	}

	@Override
	public PitchMidi getNext() {
		return from(getCode()+1);
	}

	@Override
	public PitchMidi getPrevious() {
		return from(getCode()-1);
	}
}
