package pitch;

import diatonic.IntervalChromatic;
import midi.FigureLength;
import midi.FigureVelocity;
import midi.PitchMidiException;
import midi.Events.EventComplex;
import others.Codeable;

public interface PitchMidiSingle extends PitchChromaticableSingle, PitchOctave, PitchMidi, Codeable {
	@Override
	public default float getPitchMean() {
		return getCode();
	}
	
	@Override
	public default Chromatic getChromatic() {
		int value = getCode();
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
	public default PitchMidiSingle shiftOctave(int o) {
		return of( getCode() + 12 * o );
	}

	@Override
	public default PitchMidiSingle setOctave(int o) {
		return of( getCode() % 12 + 12 * o );
	}
	
	public default PitchMidiSingle addMidi(int i) {
		return of( getCode() + i );
	}

	public default PitchMidiSingle add(IntervalChromatic i) {
		return addMidi(i.val() );
	}
	
	public static PitchMidiEnum of(int code) {
		PitchMidiException.check( code );
		Chromatic n = Chromatic.get( code % NOTES_PER_OCTAVE );
		int o = code / 12;
		return of( n, o );
	}
	
	public static PitchMidiEnum of(Chromatic c, int o) {
		switch ( o ) {
			case 0:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C0;
					case 1:
						return PitchMidiEnum.CC0;
					case 2:
						return PitchMidiEnum.D0;
					case 3:
						return PitchMidiEnum.DD0;
					case 4:
						return PitchMidiEnum.E0;
					case 5:
						return PitchMidiEnum.F0;
					case 6:
						return PitchMidiEnum.FF0;
					case 7:
						return PitchMidiEnum.G0;
					case 8:
						return PitchMidiEnum.GG0;
					case 9:
						return PitchMidiEnum.A0;
					case 10:
						return PitchMidiEnum.AA0;
					case 11:
						return PitchMidiEnum.B0;
					default:
						return null;
				}
			case 1:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C1;
					case 1:
						return PitchMidiEnum.CC1;
					case 2:
						return PitchMidiEnum.D1;
					case 3:
						return PitchMidiEnum.DD1;
					case 4:
						return PitchMidiEnum.E1;
					case 5:
						return PitchMidiEnum.F1;
					case 6:
						return PitchMidiEnum.FF1;
					case 7:
						return PitchMidiEnum.G1;
					case 8:
						return PitchMidiEnum.GG1;
					case 9:
						return PitchMidiEnum.A1;
					case 10:
						return PitchMidiEnum.AA1;
					case 11:
						return PitchMidiEnum.B1;
					default:
						return null;
				}
			case 2:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C2;
					case 1:
						return PitchMidiEnum.CC2;
					case 2:
						return PitchMidiEnum.D2;
					case 3:
						return PitchMidiEnum.DD2;
					case 4:
						return PitchMidiEnum.E2;
					case 5:
						return PitchMidiEnum.F2;
					case 6:
						return PitchMidiEnum.FF2;
					case 7:
						return PitchMidiEnum.G2;
					case 8:
						return PitchMidiEnum.GG2;
					case 9:
						return PitchMidiEnum.A2;
					case 10:
						return PitchMidiEnum.AA2;
					case 11:
						return PitchMidiEnum.B2;
					default:
						return null;
				}
			case 3:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C3;
					case 1:
						return PitchMidiEnum.CC3;
					case 2:
						return PitchMidiEnum.D3;
					case 3:
						return PitchMidiEnum.DD3;
					case 4:
						return PitchMidiEnum.E3;
					case 5:
						return PitchMidiEnum.F3;
					case 6:
						return PitchMidiEnum.FF3;
					case 7:
						return PitchMidiEnum.G3;
					case 8:
						return PitchMidiEnum.GG3;
					case 9:
						return PitchMidiEnum.A3;
					case 10:
						return PitchMidiEnum.AA3;
					case 11:
						return PitchMidiEnum.B3;
					default:
						return null;
				}
			case 4:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C4;
					case 1:
						return PitchMidiEnum.CC4;
					case 2:
						return PitchMidiEnum.D4;
					case 3:
						return PitchMidiEnum.DD4;
					case 4:
						return PitchMidiEnum.E4;
					case 5:
						return PitchMidiEnum.F4;
					case 6:
						return PitchMidiEnum.FF4;
					case 7:
						return PitchMidiEnum.G4;
					case 8:
						return PitchMidiEnum.GG4;
					case 9:
						return PitchMidiEnum.A4;
					case 10:
						return PitchMidiEnum.AA4;
					case 11:
						return PitchMidiEnum.B4;
					default:
						return null;
				}
			case 5:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C5;
					case 1:
						return PitchMidiEnum.CC5;
					case 2:
						return PitchMidiEnum.D5;
					case 3:
						return PitchMidiEnum.DD5;
					case 4:
						return PitchMidiEnum.E5;
					case 5:
						return PitchMidiEnum.F5;
					case 6:
						return PitchMidiEnum.FF5;
					case 7:
						return PitchMidiEnum.G5;
					case 8:
						return PitchMidiEnum.GG5;
					case 9:
						return PitchMidiEnum.A5;
					case 10:
						return PitchMidiEnum.AA5;
					case 11:
						return PitchMidiEnum.B5;
					default:
						return null;
				}
			case 6:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C6;
					case 1:
						return PitchMidiEnum.CC6;
					case 2:
						return PitchMidiEnum.D6;
					case 3:
						return PitchMidiEnum.DD6;
					case 4:
						return PitchMidiEnum.E6;
					case 5:
						return PitchMidiEnum.F6;
					case 6:
						return PitchMidiEnum.FF6;
					case 7:
						return PitchMidiEnum.G6;
					case 8:
						return PitchMidiEnum.GG6;
					case 9:
						return PitchMidiEnum.A6;
					case 10:
						return PitchMidiEnum.AA6;
					case 11:
						return PitchMidiEnum.B6;
					default:
						return null;
				}
			case 7:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C7;
					case 1:
						return PitchMidiEnum.CC7;
					case 2:
						return PitchMidiEnum.D7;
					case 3:
						return PitchMidiEnum.DD7;
					case 4:
						return PitchMidiEnum.E7;
					case 5:
						return PitchMidiEnum.F7;
					case 6:
						return PitchMidiEnum.FF7;
					case 7:
						return PitchMidiEnum.G7;
					case 8:
						return PitchMidiEnum.GG7;
					case 9:
						return PitchMidiEnum.A7;
					case 10:
						return PitchMidiEnum.AA7;
					case 11:
						return PitchMidiEnum.B7;
					default:
						return null;
				}
			case 8:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C8;
					case 1:
						return PitchMidiEnum.CC8;
					case 2:
						return PitchMidiEnum.D8;
					case 3:
						return PitchMidiEnum.DD8;
					case 4:
						return PitchMidiEnum.E8;
					case 5:
						return PitchMidiEnum.F8;
					case 6:
						return PitchMidiEnum.FF8;
					case 7:
						return PitchMidiEnum.G8;
					case 8:
						return PitchMidiEnum.GG8;
					case 9:
						return PitchMidiEnum.A8;
					case 10:
						return PitchMidiEnum.AA8;
					case 11:
						return PitchMidiEnum.B8;
					default:
						return null;
				}
			case 9:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C9;
					case 1:
						return PitchMidiEnum.CC9;
					case 2:
						return PitchMidiEnum.D9;
					case 3:
						return PitchMidiEnum.DD9;
					case 4:
						return PitchMidiEnum.E9;
					case 5:
						return PitchMidiEnum.F9;
					case 6:
						return PitchMidiEnum.FF9;
					case 7:
						return PitchMidiEnum.G9;
					case 8:
						return PitchMidiEnum.GG9;
					case 9:
						return PitchMidiEnum.A9;
					case 10:
						return PitchMidiEnum.AA9;
					case 11:
						return PitchMidiEnum.B9;
					default:
						return null;
				}
			case 10:
				switch ( c.val() ) {
					case 0:
						return PitchMidiEnum.C10;
					case 1:
						return PitchMidiEnum.CC10;
					case 2:
						return PitchMidiEnum.D10;
					case 3:
						return PitchMidiEnum.DD10;
					case 4:
						return PitchMidiEnum.E10;
					case 5:
						return PitchMidiEnum.F10;
					case 6:
						return PitchMidiEnum.FF10;
					case 7:
						return PitchMidiEnum.G10;
					default:
						return null;
				}
			default:
				throw new PitchMidiException( o * 12 + c.val() );
		}
	}
}
