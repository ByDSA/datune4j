package pitch;

import diatonic.DiatonicDegree;
import diatonic.IntervalChromatic;
import eventsequences.EventSequence;
import midi.FigureLength;
import midi.FigureVelocity;
import midi.PitchMidiException;
import midi.Settings;
import musical.Chromatic;
import musical.Diatonic;
import others.Codeable;
import tonality.Tonality;
import tonality.TonalityException;
import tuning.Tuning;

public enum NoteMidi implements PitchChromaticSingle, SingleFrequency, PitchMidi, Codeable {
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

	private NoteMidi(int v) {
		value = v;
	}

	private NoteMidi(NoteMidi p) {
		value = p.value;
	}

	@Override
	public NoteMidi shiftOctave(int o) {
		return of( getCode() + 12 * o );
	}

	@Override
	public NoteMidi setOctave(int o) {
		return of( getCode() % 12 + 12 * o );
	}

	@Override
	public int getCode() {
		return value;
	}

	public boolean equals(NoteMidi p) {
		return value == p.value;
	}

	@Override
	public int getOctave() {
		return value / 12;
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

	@Override
	public Chromatic getChromatic() {
		int value = getCode();
		return Chromatic.get( value % 12 );
	}

	public static NoteMidi of(int code) {
		PitchMidiException.check( code );
		Chromatic n = Chromatic.get( code % Chromatic.notesPerOctave() );
		int o = code / 12;
		return of( n, o );
	}

	public static NoteMidi of(Chromatic c, int o) {
		switch ( o ) {
			case 0:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C0;
					case 1:
						return NoteMidi.CC0;
					case 2:
						return NoteMidi.D0;
					case 3:
						return NoteMidi.DD0;
					case 4:
						return NoteMidi.E0;
					case 5:
						return NoteMidi.F0;
					case 6:
						return NoteMidi.FF0;
					case 7:
						return NoteMidi.G0;
					case 8:
						return NoteMidi.GG0;
					case 9:
						return NoteMidi.A0;
					case 10:
						return NoteMidi.AA0;
					case 11:
						return NoteMidi.B0;
					default:
						return null;
				}
			case 1:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C1;
					case 1:
						return NoteMidi.CC1;
					case 2:
						return NoteMidi.D1;
					case 3:
						return NoteMidi.DD1;
					case 4:
						return NoteMidi.E1;
					case 5:
						return NoteMidi.F1;
					case 6:
						return NoteMidi.FF1;
					case 7:
						return NoteMidi.G1;
					case 8:
						return NoteMidi.GG1;
					case 9:
						return NoteMidi.A1;
					case 10:
						return NoteMidi.AA1;
					case 11:
						return NoteMidi.B1;
					default:
						return null;
				}
			case 2:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C2;
					case 1:
						return NoteMidi.CC2;
					case 2:
						return NoteMidi.D2;
					case 3:
						return NoteMidi.DD2;
					case 4:
						return NoteMidi.E2;
					case 5:
						return NoteMidi.F2;
					case 6:
						return NoteMidi.FF2;
					case 7:
						return NoteMidi.G2;
					case 8:
						return NoteMidi.GG2;
					case 9:
						return NoteMidi.A2;
					case 10:
						return NoteMidi.AA2;
					case 11:
						return NoteMidi.B2;
					default:
						return null;
				}
			case 3:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C3;
					case 1:
						return NoteMidi.CC3;
					case 2:
						return NoteMidi.D3;
					case 3:
						return NoteMidi.DD3;
					case 4:
						return NoteMidi.E3;
					case 5:
						return NoteMidi.F3;
					case 6:
						return NoteMidi.FF3;
					case 7:
						return NoteMidi.G3;
					case 8:
						return NoteMidi.GG3;
					case 9:
						return NoteMidi.A3;
					case 10:
						return NoteMidi.AA3;
					case 11:
						return NoteMidi.B3;
					default:
						return null;
				}
			case 4:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C4;
					case 1:
						return NoteMidi.CC4;
					case 2:
						return NoteMidi.D4;
					case 3:
						return NoteMidi.DD4;
					case 4:
						return NoteMidi.E4;
					case 5:
						return NoteMidi.F4;
					case 6:
						return NoteMidi.FF4;
					case 7:
						return NoteMidi.G4;
					case 8:
						return NoteMidi.GG4;
					case 9:
						return NoteMidi.A4;
					case 10:
						return NoteMidi.AA4;
					case 11:
						return NoteMidi.B4;
					default:
						return null;
				}
			case 5:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C5;
					case 1:
						return NoteMidi.CC5;
					case 2:
						return NoteMidi.D5;
					case 3:
						return NoteMidi.DD5;
					case 4:
						return NoteMidi.E5;
					case 5:
						return NoteMidi.F5;
					case 6:
						return NoteMidi.FF5;
					case 7:
						return NoteMidi.G5;
					case 8:
						return NoteMidi.GG5;
					case 9:
						return NoteMidi.A5;
					case 10:
						return NoteMidi.AA5;
					case 11:
						return NoteMidi.B5;
					default:
						return null;
				}
			case 6:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C6;
					case 1:
						return NoteMidi.CC6;
					case 2:
						return NoteMidi.D6;
					case 3:
						return NoteMidi.DD6;
					case 4:
						return NoteMidi.E6;
					case 5:
						return NoteMidi.F6;
					case 6:
						return NoteMidi.FF6;
					case 7:
						return NoteMidi.G6;
					case 8:
						return NoteMidi.GG6;
					case 9:
						return NoteMidi.A6;
					case 10:
						return NoteMidi.AA6;
					case 11:
						return NoteMidi.B6;
					default:
						return null;
				}
			case 7:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C7;
					case 1:
						return NoteMidi.CC7;
					case 2:
						return NoteMidi.D7;
					case 3:
						return NoteMidi.DD7;
					case 4:
						return NoteMidi.E7;
					case 5:
						return NoteMidi.F7;
					case 6:
						return NoteMidi.FF7;
					case 7:
						return NoteMidi.G7;
					case 8:
						return NoteMidi.GG7;
					case 9:
						return NoteMidi.A7;
					case 10:
						return NoteMidi.AA7;
					case 11:
						return NoteMidi.B7;
					default:
						return null;
				}
			case 8:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C8;
					case 1:
						return NoteMidi.CC8;
					case 2:
						return NoteMidi.D8;
					case 3:
						return NoteMidi.DD8;
					case 4:
						return NoteMidi.E8;
					case 5:
						return NoteMidi.F8;
					case 6:
						return NoteMidi.FF8;
					case 7:
						return NoteMidi.G8;
					case 8:
						return NoteMidi.GG8;
					case 9:
						return NoteMidi.A8;
					case 10:
						return NoteMidi.AA8;
					case 11:
						return NoteMidi.B8;
					default:
						return null;
				}
			case 9:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C9;
					case 1:
						return NoteMidi.CC9;
					case 2:
						return NoteMidi.D9;
					case 3:
						return NoteMidi.DD9;
					case 4:
						return NoteMidi.E9;
					case 5:
						return NoteMidi.F9;
					case 6:
						return NoteMidi.FF9;
					case 7:
						return NoteMidi.G9;
					case 8:
						return NoteMidi.GG9;
					case 9:
						return NoteMidi.A9;
					case 10:
						return NoteMidi.AA9;
					case 11:
						return NoteMidi.B9;
					default:
						return null;
				}
			case 10:
				switch ( c.val() ) {
					case 0:
						return NoteMidi.C10;
					case 1:
						return NoteMidi.CC10;
					case 2:
						return NoteMidi.D10;
					case 3:
						return NoteMidi.DD10;
					case 4:
						return NoteMidi.E10;
					case 5:
						return NoteMidi.F10;
					case 6:
						return NoteMidi.FF10;
					case 7:
						return NoteMidi.G10;
					default:
						return null;
				}
			default:
				throw new PitchMidiException( o * 12 + c.val() );
		}
	}

	@Override
	public Diatonic getDiatonic(Tonality ton) throws TonalityException {
		return getChromatic().getDiatonic( ton );
	}

	public NoteMidi shift(int i) {
		return NoteMidi.of(getCode() + i);
	}

	public NoteMidi shift(IntervalChromatic i) {
		return shift( i.val() );
	}
	
	@Override
	public double getFrequency() {
		return Tuning.DEFAULT.get( this );
	}
	
	public static NoteMidi of(DiatonicDegree degree, Tonality tonality, int octave) {
		int code = tonality.get( degree ).val() + octave * 12;
		if ( tonality.get( degree ).val() < tonality.getRoot().val() )
			code += 12;

		return of( code );
	}
}
