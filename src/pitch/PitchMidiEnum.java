package pitch;

import midi.PitchMidiException;
import midi.Settings;
import others.Codeable;

public enum PitchMidiEnum implements PitchMidiSingle {
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

	private PitchMidiEnum(int v) {
		value = v;
	}

	private PitchMidiEnum(PitchMidiEnum p) {
		value = p.value;
	}
	
	@Override
	public PitchMidiEnum addMidi(int i) {
		return PitchMidiSingle.of(value + i);
	}
	
	@Override
	public PitchMidiEnum shiftOctave(int o) {
		return PitchMidiSingle.of( getCode() + 12 * o );
	}

	@Override
	public PitchMidiEnum setOctave(int o) {
		return PitchMidiSingle.of( getCode() % 12 + 12 * o );
	}

	@Override
	public int getCode() {
		return value;
	}

	public boolean equals(PitchMidiEnum p) {
		return value == p.value;
	}

	@Override
	public int getOctave() {
		return value / 12;
	}

	@Override
	public float getPitchMean() {
		return value;
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
