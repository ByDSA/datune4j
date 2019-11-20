package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import es.danisales.datune.pitch.PitchOctaveEditable;
import es.danisales.datune.tonality.Tonality;

public enum PitchChromaticMidi implements PitchChromaticSingle, PitchMidiInterface {
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

	public static final PitchChromaticMidi MIN = C0;
	public static final PitchChromaticMidi MAX = G10;
	public static final int MIN_OCTAVE = 0;
	public static final int MAX_OCTAVE = 10;

	public static PitchChromaticMidi from(PitchMidi pitchMidi) {
		PitchChromaticMidi pitchChromaticMidi = pitchMidi.getPitchChromaticMidi();
		return pitchMidi.getCents() < 50 ? pitchChromaticMidi : pitchChromaticMidi.getNext();
	}

	public Chromatic getChromatic() {
		return Chromatic.from(ordinal() % Chromatic.NUMBER);
	}

	public PitchChromaticMidi getWithShiftOctave(int o) {
		return from( getCode() + Chromatic.NUMBER * o );
	}

	public PitchChromaticMidi getWithOctave(int o) {
		return from( getCode() % Chromatic.NUMBER + Chromatic.NUMBER * o );
	}

	@Override
	public int getCode() {
		return ordinal();
	}

	@Override
	public int getOctave() {
		return ordinal() / Chromatic.NUMBER;
	}

	public static PitchChromaticMidi from(int code) {
		PitchMidiException.check( code );
		Chromatic n = Chromatic.from( code % Chromatic.NUMBER);
		int o = code / Chromatic.NUMBER;
		return from( n, o );
	}

	public static PitchChromaticMidi from(Chromatic chromatic, int octave) {
		switch ( octave ) {
			case 0:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C0;
					case CC:
						return PitchChromaticMidi.CC0;
					case D:
						return PitchChromaticMidi.D0;
					case DD:
						return PitchChromaticMidi.DD0;
					case E:
						return PitchChromaticMidi.E0;
					case F:
						return PitchChromaticMidi.F0;
					case FF:
						return PitchChromaticMidi.FF0;
					case G:
						return PitchChromaticMidi.G0;
					case GG:
						return PitchChromaticMidi.GG0;
					case A:
						return PitchChromaticMidi.A0;
					case AA:
						return PitchChromaticMidi.AA0;
					case B:
						return PitchChromaticMidi.B0;
					default:
						return null;
				}
			case 1:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C1;
					case CC:
						return PitchChromaticMidi.CC1;
					case D:
						return PitchChromaticMidi.D1;
					case DD:
						return PitchChromaticMidi.DD1;
					case E:
						return PitchChromaticMidi.E1;
					case F:
						return PitchChromaticMidi.F1;
					case FF:
						return PitchChromaticMidi.FF1;
					case G:
						return PitchChromaticMidi.G1;
					case GG:
						return PitchChromaticMidi.GG1;
					case A:
						return PitchChromaticMidi.A1;
					case AA:
						return PitchChromaticMidi.AA1;
					case B:
						return PitchChromaticMidi.B1;
					default:
						return null;
				}
			case 2:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C2;
					case CC:
						return PitchChromaticMidi.CC2;
					case D:
						return PitchChromaticMidi.D2;
					case DD:
						return PitchChromaticMidi.DD2;
					case E:
						return PitchChromaticMidi.E2;
					case F:
						return PitchChromaticMidi.F2;
					case FF:
						return PitchChromaticMidi.FF2;
					case G:
						return PitchChromaticMidi.G2;
					case GG:
						return PitchChromaticMidi.GG2;
					case A:
						return PitchChromaticMidi.A2;
					case AA:
						return PitchChromaticMidi.AA2;
					case B:
						return PitchChromaticMidi.B2;
					default:
						return null;
				}
			case 3:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C3;
					case CC:
						return PitchChromaticMidi.CC3;
					case D:
						return PitchChromaticMidi.D3;
					case DD:
						return PitchChromaticMidi.DD3;
					case E:
						return PitchChromaticMidi.E3;
					case F:
						return PitchChromaticMidi.F3;
					case FF:
						return PitchChromaticMidi.FF3;
					case G:
						return PitchChromaticMidi.G3;
					case GG:
						return PitchChromaticMidi.GG3;
					case A:
						return PitchChromaticMidi.A3;
					case AA:
						return PitchChromaticMidi.AA3;
					case B:
						return PitchChromaticMidi.B3;
					default:
						return null;
				}
			case 4:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C4;
					case CC:
						return PitchChromaticMidi.CC4;
					case D:
						return PitchChromaticMidi.D4;
					case DD:
						return PitchChromaticMidi.DD4;
					case E:
						return PitchChromaticMidi.E4;
					case F:
						return PitchChromaticMidi.F4;
					case FF:
						return PitchChromaticMidi.FF4;
					case G:
						return PitchChromaticMidi.G4;
					case GG:
						return PitchChromaticMidi.GG4;
					case A:
						return PitchChromaticMidi.A4;
					case AA:
						return PitchChromaticMidi.AA4;
					case B:
						return PitchChromaticMidi.B4;
					default:
						return null;
				}
			case 5:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C5;
					case CC:
						return PitchChromaticMidi.CC5;
					case D:
						return PitchChromaticMidi.D5;
					case DD:
						return PitchChromaticMidi.DD5;
					case E:
						return PitchChromaticMidi.E5;
					case F:
						return PitchChromaticMidi.F5;
					case FF:
						return PitchChromaticMidi.FF5;
					case G:
						return PitchChromaticMidi.G5;
					case GG:
						return PitchChromaticMidi.GG5;
					case A:
						return PitchChromaticMidi.A5;
					case AA:
						return PitchChromaticMidi.AA5;
					case B:
						return PitchChromaticMidi.B5;
					default:
						return null;
				}
			case 6:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C6;
					case CC:
						return PitchChromaticMidi.CC6;
					case D:
						return PitchChromaticMidi.D6;
					case DD:
						return PitchChromaticMidi.DD6;
					case E:
						return PitchChromaticMidi.E6;
					case F:
						return PitchChromaticMidi.F6;
					case FF:
						return PitchChromaticMidi.FF6;
					case G:
						return PitchChromaticMidi.G6;
					case GG:
						return PitchChromaticMidi.GG6;
					case A:
						return PitchChromaticMidi.A6;
					case AA:
						return PitchChromaticMidi.AA6;
					case B:
						return PitchChromaticMidi.B6;
					default:
						return null;
				}
			case 7:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C7;
					case CC:
						return PitchChromaticMidi.CC7;
					case D:
						return PitchChromaticMidi.D7;
					case DD:
						return PitchChromaticMidi.DD7;
					case E:
						return PitchChromaticMidi.E7;
					case F:
						return PitchChromaticMidi.F7;
					case FF:
						return PitchChromaticMidi.FF7;
					case G:
						return PitchChromaticMidi.G7;
					case GG:
						return PitchChromaticMidi.GG7;
					case A:
						return PitchChromaticMidi.A7;
					case AA:
						return PitchChromaticMidi.AA7;
					case B:
						return PitchChromaticMidi.B7;
					default:
						return null;
				}
			case 8:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C8;
					case CC:
						return PitchChromaticMidi.CC8;
					case D:
						return PitchChromaticMidi.D8;
					case DD:
						return PitchChromaticMidi.DD8;
					case E:
						return PitchChromaticMidi.E8;
					case F:
						return PitchChromaticMidi.F8;
					case FF:
						return PitchChromaticMidi.FF8;
					case G:
						return PitchChromaticMidi.G8;
					case GG:
						return PitchChromaticMidi.GG8;
					case A:
						return PitchChromaticMidi.A8;
					case AA:
						return PitchChromaticMidi.AA8;
					case B:
						return PitchChromaticMidi.B8;
					default:
						return null;
				}
			case 9:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C9;
					case CC:
						return PitchChromaticMidi.CC9;
					case D:
						return PitchChromaticMidi.D9;
					case DD:
						return PitchChromaticMidi.DD9;
					case E:
						return PitchChromaticMidi.E9;
					case F:
						return PitchChromaticMidi.F9;
					case FF:
						return PitchChromaticMidi.FF9;
					case G:
						return PitchChromaticMidi.G9;
					case GG:
						return PitchChromaticMidi.GG9;
					case A:
						return PitchChromaticMidi.A9;
					case AA:
						return PitchChromaticMidi.AA9;
					case B:
						return PitchChromaticMidi.B9;
					default:
						return null;
				}
			case 10:
				switch ( chromatic ) {
					case C:
						return PitchChromaticMidi.C10;
					case CC:
						return PitchChromaticMidi.CC10;
					case D:
						return PitchChromaticMidi.D10;
					case DD:
						return PitchChromaticMidi.DD10;
					case E:
						return PitchChromaticMidi.E10;
					case F:
						return PitchChromaticMidi.F10;
					case FF:
						return PitchChromaticMidi.FF10;
					case G:
						return PitchChromaticMidi.G10;
					default:
						return null;
				}
			default:
				int code = getCodeNoTestLimits(chromatic, octave);
				throw new PitchMidiException(code);
		}
	}

	public PitchChromaticMidi getShift(int i) {
		return PitchChromaticMidi.from(getCode() + i);
	}

	public PitchChromaticMidi getShift(IntervalChromatic i) {
		return getShift( i.getSemitones() );
	}

	public static PitchChromaticMidi from(PitchDiatonicMidi pitchDiatonicMidi) {
		Tonality tonality = pitchDiatonicMidi.tonality;
		DiatonicDegree degree = pitchDiatonicMidi.degree;
		int octave = pitchDiatonicMidi.octave;

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
	public PitchChromaticMidi getNext() {
		return from(getCode()+1);
	}

	@Override
	public PitchChromaticMidi getPrevious() {
		return from(getCode()-1);
	}

	@Override
	public void shiftOctave(int o) {
		// todo
	}

	@Override
	public void setOctave(int o) {
// todo
	}
}
