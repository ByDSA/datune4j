package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.Duration;
import es.danisales.datune.midi.Events.NoteOn;

public class Drums extends EventSequence {
	public static final int ACOUSTIC_BASS_DRUM = 35;
	public static final int BASS_DRUM1 = 36;
	public static final int SIDE_STICK = 37;
	public static final int ACOUSTIC_SNARE = 38;
	public static final int HAND_CLAP = 39;
	public static final int ELECTRIC_SNARE = 40;
	public static final int LOW_FLOOR_TOM = 41;
	public static final int CLOSED_HI_HAT = 42;
	public static final int HIGH_FLOOR_TOM = 43;
	public static final int PEDAL_HIHAT = 44;
	public static final int LOW_TOM = 45;
	public static final int OPEN_HIHAT = 46;
	public static final int LOWMID_TOM = 47;
	public static final int HIMID_TOM = 48;
	public static final int CRASH_CYMBAL1 = 49;
	public static final int HIGH_TOM = 50;
	public static final int RIDE_CYMBAL1 = 51;
	public static final int CHINESE_CYMBAL = 52;
	public static final int RIDE_BELL = 53;
	public static final int TAMBOURINE = 54;
	public static final int SPLASH_CYMBAL = 55;
	public static final int COWBELL = 56;
	public static final int CRASH_CYMBAL2 = 57;
	public static final int VIBRASLAP = 58;
	public static final int RIDE_CYMBAL2 = 59;
	public static final int HI_BONGO = 60;
	public static final int LOW_BONGO = 61;
	public static final int MUTE_HI_CONGA = 62;
	public static final int OPEN_HI_CONGA = 63;
	public static final int LOW_CONGA = 64;
	public static final int HIGH_TIMBALE = 65;
	public static final int LOW_TIMBALE = 66;
	public static final int HIGH_AGOGO = 67;
	public static final int LOW_AGOGO = 68;
	public static final int CABASA = 69;
	public static final int MARACAS = 70;
	public static final int SHORT_WHISTLE = 71;
	public static final int LONG_WHISTLE = 72;
	public static final int SHORT_GUIRO = 73;
	public static final int LONG_GUIRO = 74;
	public static final int CLAVES = 75;
	public static final int HI_WOOD_BLOCK = 76;
	public static final int LOW_WOOD_BLOCK = 77;
	public static final int MUTE_CUICA = 78;
	public static final int OPEN_CUICA = 79;
	public static final int MUTE_TRIANGLE = 80;
	public static final int OPEN_TRIANGLE = 81;

	/* SAMPLES */
	public final static Drums POWER = new Drums();
	static {
		for (int i = 0; i < Duration.V1; i += Duration.V4)
			POWER.add( i, Drums.ACOUSTIC_SNARE );

		for (int i = 0; i < Duration.V1; i += Duration.V16)
			POWER.add( i, Drums.BASS_DRUM1 );

		POWER.setLength( Duration.V1 );
	}

	public Drums add(int d, int n) {
		add( d, new NoteOn( n ) );
		return this;
	}
}
