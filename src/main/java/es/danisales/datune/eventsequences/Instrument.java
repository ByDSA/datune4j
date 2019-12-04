package es.danisales.datune.eventsequences;


import es.danisales.arrays.ArrayUtils;

public enum Instrument {
	ACOUSTIC_GRAND_PIANO(0),
	BRIGHT_ACOUSTIC_PIANO(1),
	ELECTRIC_GRAND_PIANO(2),
	HONKY_TONK_PIANO(3),
	ELECTRIC_PIANO1(4),
	ELECTRIC_PIANO2(5),
	HARPSICHORD(6),
	CLAVINET(7),
	CELESTA(8),
	GLOCKENSPIEL(9),
	MUSIC_BOX(10),
	VIBRAPHONE(11),
	MARIMBA(12),
	XYLOPHONE(13),
	TUBULAR_BELLS(14),
	DULCIMER(15),
	DRAWBAR_ORGAN(16),
	PERCUSSIVE_ORGAN(17),
	ROCK_ORGAN(18),
	CHURCH_ORGAN(19),
	REED_ORGAN(20),
	ACCORDION(21),
	HARMONICA(22),
	TANGO_ACCORDION(23),
	ACOUSTIC_GUITAR_NYLON(24),
	ACOUSTIC_GUITAR_STEEL(25),
	ELECTRIC_GUITAR_JAZZ(26),
	ELECTRIC_GUITAR_CLEAN(27),
	ELECTRIC_GUITAR_MUTED(28),
	OVERDRIVEN_GUITAR(29),
	DISTORTION_GUITAR(30),
	GUITAR_HARMONICS(31),
	ACOUSTIC_BASS(32),
	ELECTRIC_BASS_FINGER(33),
	ELECTRIC_BASS_PICK(34),
	FRETLESS_BASS(35),
	SLAP_BASS_1(36),
	SLAP_BASS_2(37),
	SYNTH_BASS_1(38),
	SYNTH_BASS_2(39),
	VIOLIN(40),
	VIOLA(41),
	CELLO(42),
	CONTRABASS(43),
	TREMOLO_STRINGS(44),
	PIZZICATO_STRINGS(45),
	ORCHESTRAL_HARP(46),
	TIMPANI(47),
	STRING_ENSEMBLE_1(48),
	STRING_ENSEMBLE_2(49),
	SYNTH_STRINGS_1(50),
	SYNTH_STRINGS_2(51),
	CHOIR_AAHS(52),
	VOICE_OOHS(53),
	SYNTH_CHOIR(54),
	ORCHESTRA_HIT(55),
	TRUMPET(56),
	TROMBONE(57),
	TUBA(58),
	MUTED_TRUMPET(59),
	FRENCH_HORN(60),
	BRASS_SECTION(61),
	SYNTH_BRASS_1(62),
	SYNTH_BRASS_2(63),
	SOPRANO_SAX(64),
	ALTO_SAX(65),
	TENOR_SAX(66),
	BARITONE_SAX(67),
	OBOE(68),
	ENGLISH_HORN(69),
	BASSOON(70),
	CLARINET(71),
	PICCOLO(72),
	FLUTE(73),
	RECORDER(74),
	PAN_FLUTE(75),
	BLOWN_BOTTLE(76),
	SHAKUHACHI(77),
	WHISTLE(78),
	OCARINA(79),
	LEAD1_SQUARE(80),
	LEAD2_SAWTOOTH(81),
	LEAD3_CALLIOPE(82),
	LEAD4_CHIFF(83),
	LEAD5_CHARANG(84),
	LEAD6_VOICE(85),
	LEAD7_FIFTHS(86),
	LEAD8_BASS_LEAD(87),
	PAD1_NEW_AGE(88),
	PAD2_WARM(89),
	PAD3_POLYSYNTH(90),
	PAD4_CHOIR(91),
	PAD5_BOWED(92),
	PAD6_METALLIC(93),
	PAD7_HALO(94),
	PAD8_SWEEP(95),
	FX1_RAIN(96),
	FX2_SOUNDTRACK(97),
	FX3_CRYSTAL(98),
	FX4_ATMOSPHERE(99),
	FX5_BRIGHTNESS(100),
	FX6_GOBLINS(101),
	FX7_ECHOES(102),
	FX8_SCI_FI(103),
	SITAR(104),
	BANJO(105),
	SHAMISEN(106),
	KOTO(107),
	KALIMBA(108),
	BAGPIPE(109),
	FIDDLE(110),
	SHANAI(111),
	TINKLE_BELL(112),
	AGOGO(113),
	STEEL_DRUMS(114),
	WOODBLOCK(115),
	TAIKO_DRUM(116),
	MELODIC_TOM(117),
	SYNTH_DRUM(118),
	REVERSE_CYMBAL(119),
	GUITAR_FRET_NOISE(120),
	BREATH_NOISE(121),
	SEASHORE(122),
	BIRD_TWEET(123),
	TELEPHONE_RING(124),
	HELICOPTER(125),
	APPLAUSE(126),
	GUNSHOT(127);

	public static final Instrument[] PIANO = {
		ACOUSTIC_GRAND_PIANO,
		BRIGHT_ACOUSTIC_PIANO,
		ELECTRIC_GRAND_PIANO,
		HONKY_TONK_PIANO,
		ELECTRIC_PIANO1,
		ELECTRIC_PIANO2,
		HARPSICHORD,
		CLAVINET
	};

	public static final Instrument[] CHROMATIC_PERCUSSION = {
		CELESTA,
		GLOCKENSPIEL,
		MUSIC_BOX,
		VIBRAPHONE,
		MARIMBA,
		XYLOPHONE,
		TUBULAR_BELLS,
		DULCIMER
	};

	public static final Instrument[] ORGAN = {
		DRAWBAR_ORGAN,
		PERCUSSIVE_ORGAN,
		ROCK_ORGAN,
		CHURCH_ORGAN,
		REED_ORGAN,
		ACCORDION,
		HARMONICA,
		TANGO_ACCORDION
	};

	public static final Instrument[] GUITAR = {
		ACOUSTIC_GUITAR_NYLON,
		ACOUSTIC_GUITAR_STEEL,
		ELECTRIC_GUITAR_JAZZ,
		ELECTRIC_GUITAR_CLEAN,
		ELECTRIC_GUITAR_MUTED,
		OVERDRIVEN_GUITAR,
		DISTORTION_GUITAR,
		GUITAR_HARMONICS
	};

	public static final Instrument[] BASS = {
		ACOUSTIC_BASS,
		ELECTRIC_BASS_FINGER,
		ELECTRIC_BASS_PICK,
		FRETLESS_BASS,
		SLAP_BASS_1,
		SLAP_BASS_2,
		SYNTH_BASS_1,
		SYNTH_BASS_2
	};

	public static final Instrument[] STRINGS = {
		VIOLIN,
		VIOLA,
		CELLO,
		CONTRABASS,
		TREMOLO_STRINGS,
		PIZZICATO_STRINGS,
		ORCHESTRAL_HARP,
		TIMPANI
	};

	public static final Instrument[] ENSEMBLE = {
		STRING_ENSEMBLE_1,
		STRING_ENSEMBLE_2,
		SYNTH_STRINGS_1,
		SYNTH_STRINGS_2,
		CHOIR_AAHS,
		VOICE_OOHS,
		SYNTH_CHOIR,
		ORCHESTRA_HIT
	};

	public static final Instrument[] BRASS = {
		TRUMPET,
		TROMBONE,
		TUBA,
		MUTED_TRUMPET,
		FRENCH_HORN,
		BRASS_SECTION,
		SYNTH_BRASS_1,
		SYNTH_BRASS_2
	};

	public static final Instrument[] REED = {
		SOPRANO_SAX,
		ALTO_SAX,
		TENOR_SAX,
		BARITONE_SAX,
		OBOE,
		ENGLISH_HORN,
		BASSOON,
		CLARINET
	};

	public static final Instrument[] PIPE = {
		PICCOLO,
		FLUTE,
		RECORDER,
		PAN_FLUTE,
		BLOWN_BOTTLE,
		SHAKUHACHI,
		WHISTLE,
		OCARINA
	};

	public static final Instrument[] SYNTH_LEAD = {
		LEAD1_SQUARE,
		LEAD2_SAWTOOTH,
		LEAD3_CALLIOPE,
		LEAD4_CHIFF,
		LEAD5_CHARANG,
		LEAD6_VOICE,
		LEAD7_FIFTHS,
		LEAD8_BASS_LEAD
	};

	public static final Instrument[] SYNTH_PAD = {
		PAD1_NEW_AGE,
		PAD2_WARM,
		PAD3_POLYSYNTH,
		PAD4_CHOIR,
		PAD5_BOWED,
		PAD6_METALLIC,
		PAD7_HALO,
		PAD8_SWEEP
	};

	public static final Instrument[] SYNTH_EFFECTS = {
		FX1_RAIN,
		FX2_SOUNDTRACK,
		FX3_CRYSTAL,
		FX4_ATMOSPHERE,
		FX5_BRIGHTNESS,
		FX6_GOBLINS,
		FX7_ECHOES,
		FX8_SCI_FI
	};

	public static final Instrument[] ETHNIC = {
		SITAR,
		BANJO,
		SHAMISEN,
		KOTO,
		KALIMBA,
		BAGPIPE,
		FIDDLE,
		SHANAI
	};

	public static final Instrument[] PERCUSSIVE = {
		TINKLE_BELL,
		AGOGO,
		STEEL_DRUMS,
		WOODBLOCK,
		TAIKO_DRUM,
		MELODIC_TOM,
		SYNTH_DRUM,
		REVERSE_CYMBAL
	};

	public static final Instrument[] SOUND_EFFECTS = {
		GUITAR_FRET_NOISE,
		BREATH_NOISE,
		SEASHORE,
		BIRD_TWEET,
		TELEPHONE_RING,
		HELICOPTER,
		APPLAUSE,
		GUNSHOT
	};

	private static final Instrument[] ALL = ArrayUtils.concat(
		PIANO, CHROMATIC_PERCUSSION, ORGAN, GUITAR, BASS, STRINGS, ENSEMBLE, BRASS, REED, PIPE, SYNTH_LEAD, SYNTH_PAD, SYNTH_EFFECTS, ETHNIC, PERCUSSIVE, SOUND_EFFECTS
	);

	private final int value;

    Instrument(
            int v) {
		value = v;
	}

	public int val() {
		return value;
	}

	public static Instrument get(int ins) {
		switch ( ins ) {
			case 0:
			default:
				return ACOUSTIC_GRAND_PIANO;
			case 1:
				return BRIGHT_ACOUSTIC_PIANO;
			case 2:
				return ELECTRIC_GRAND_PIANO;
			case 3:
				return HONKY_TONK_PIANO;
			case 4:
				return ELECTRIC_PIANO1;
			case 5:
				return ELECTRIC_PIANO2;
			case 6:
				return HARPSICHORD;
			case 7:
				return CLAVINET;
			case 8:
				return CELESTA;
			case 9:
				return GLOCKENSPIEL;
			case 10:
				return MUSIC_BOX;
			case 11:
				return VIBRAPHONE;
			case 12:
				return MARIMBA;
			case 13:
				return XYLOPHONE;
			case 14:
				return TUBULAR_BELLS;
			case 15:
				return DULCIMER;
			case 16:
				return DRAWBAR_ORGAN;
			case 17:
				return PERCUSSIVE_ORGAN;
			case 18:
				return ROCK_ORGAN;
			case 19:
				return CHURCH_ORGAN;
			case 20:
				return REED_ORGAN;
			case 21:
				return ACCORDION;
			case 22:
				return HARMONICA;
			case 23:
				return TANGO_ACCORDION;
			case 24:
				return ACOUSTIC_GUITAR_NYLON;
			case 25:
				return ACOUSTIC_GUITAR_STEEL;
			case 26:
				return ELECTRIC_GUITAR_JAZZ;
			case 27:
				return ELECTRIC_GUITAR_CLEAN;
			case 28:
				return ELECTRIC_GUITAR_MUTED;
			case 29:
				return OVERDRIVEN_GUITAR;
			case 30:
				return DISTORTION_GUITAR;
			case 31:
				return GUITAR_HARMONICS;
			case 32:
				return ACOUSTIC_BASS;
			case 33:
				return ELECTRIC_BASS_FINGER;
			case 34:
				return ELECTRIC_BASS_PICK;
			case 35:
				return FRETLESS_BASS;
			case 36:
				return SLAP_BASS_1;
			case 37:
				return SLAP_BASS_2;
			case 38:
				return SYNTH_BASS_1;
			case 39:
				return SYNTH_BASS_2;
			case 40:
				return VIOLIN;
			case 41:
				return VIOLA;
			case 42:
				return CELLO;
			case 43:
				return CONTRABASS;
			case 44:
				return TREMOLO_STRINGS;
			case 45:
				return PIZZICATO_STRINGS;
			case 46:
				return ORCHESTRAL_HARP;
			case 47:
				return TIMPANI;
			case 48:
				return STRING_ENSEMBLE_1;
			case 49:
				return STRING_ENSEMBLE_2;
			case 50:
				return SYNTH_STRINGS_1;
			case 51:
				return SYNTH_STRINGS_2;
			case 52:
				return CHOIR_AAHS;
			case 53:
				return VOICE_OOHS;
			case 54:
				return SYNTH_CHOIR;
			case 55:
				return ORCHESTRA_HIT;
			case 56:
				return TRUMPET;
			case 57:
				return TROMBONE;
			case 58:
				return TUBA;
			case 59:
				return MUTED_TRUMPET;
			case 60:
				return FRENCH_HORN;
			case 61:
				return BRASS_SECTION;
			case 62:
				return SYNTH_BRASS_1;
			case 63:
				return SYNTH_BRASS_2;
			case 64:
				return SOPRANO_SAX;
			case 65:
				return ALTO_SAX;
			case 66:
				return TENOR_SAX;
			case 67:
				return BARITONE_SAX;
			case 68:
				return OBOE;
			case 69:
				return ENGLISH_HORN;
			case 70:
				return BASSOON;
			case 71:
				return CLARINET;
			case 72:
				return PICCOLO;
			case 73:
				return FLUTE;
			case 74:
				return RECORDER;
			case 75:
				return PAN_FLUTE;
			case 76:
				return BLOWN_BOTTLE;
			case 77:
				return SHAKUHACHI;
			case 78:
				return WHISTLE;
			case 79:
				return OCARINA;
			case 80:
				return LEAD1_SQUARE;
			case 81:
				return LEAD2_SAWTOOTH;
			case 82:
				return LEAD3_CALLIOPE;
			case 83:
				return LEAD4_CHIFF;
			case 84:
				return LEAD5_CHARANG;
			case 85:
				return LEAD6_VOICE;
			case 86:
				return LEAD7_FIFTHS;
			case 87:
				return LEAD8_BASS_LEAD;
			case 88:
				return PAD1_NEW_AGE;
			case 89:
				return PAD2_WARM;
			case 90:
				return PAD3_POLYSYNTH;
			case 91:
				return PAD4_CHOIR;
			case 92:
				return PAD5_BOWED;
			case 93:
				return PAD6_METALLIC;
			case 94:
				return PAD7_HALO;
			case 95:
				return PAD8_SWEEP;
			case 96:
				return FX1_RAIN;
			case 97:
				return FX2_SOUNDTRACK;
			case 98:
				return FX3_CRYSTAL;
			case 99:
				return FX4_ATMOSPHERE;
			case 100:
				return FX5_BRIGHTNESS;
			case 101:
				return FX6_GOBLINS;
			case 102:
				return FX7_ECHOES;
			case 103:
				return FX8_SCI_FI;
			case 104:
				return SITAR;
			case 105:
				return BANJO;
			case 106:
				return SHAMISEN;
			case 107:
				return KOTO;
			case 108:
				return KALIMBA;
			case 109:
				return BAGPIPE;
			case 110:
				return FIDDLE;
			case 111:
				return SHANAI;
			case 112:
				return TINKLE_BELL;
			case 113:
				return AGOGO;
			case 114:
				return STEEL_DRUMS;
			case 115:
				return WOODBLOCK;
			case 116:
				return TAIKO_DRUM;
			case 117:
				return MELODIC_TOM;
			case 118:
				return SYNTH_DRUM;
			case 119:
				return REVERSE_CYMBAL;
			case 120:
				return GUITAR_FRET_NOISE;
			case 121:
				return BREATH_NOISE;
			case 122:
				return SEASHORE;
			case 123:
				return BIRD_TWEET;
			case 124:
				return TELEPHONE_RING;
			case 125:
				return HELICOPTER;
			case 126:
				return APPLAUSE;
			case 127:
				return GUNSHOT;
		}
	}

	public String toString() {
		switch ( this ) {
			default:
				return "Unknown";
			case ACOUSTIC_GRAND_PIANO:
				return "Acoustic Grand Piano";
			case BRIGHT_ACOUSTIC_PIANO:
				return "Bright Acoustic Piano";
			case ELECTRIC_GRAND_PIANO:
				return "Electric Grand Piano";
			case HONKY_TONK_PIANO:
				return "Honky-tonk Piano";
			case ELECTRIC_PIANO1:
				return "Electric Piano 1";
			case ELECTRIC_PIANO2:
				return "Electric Piano 2";
			case HARPSICHORD:
				return "Harpsichord";
			case CLAVINET:
				return "Clavinet";
			case CELESTA:
				return "Celesta";
			case GLOCKENSPIEL:
				return "Glockenspiel";
			case MUSIC_BOX:
				return "Music Box";
			case VIBRAPHONE:
				return "Vibraphone";
			case MARIMBA:
				return "Marimba";
			case XYLOPHONE:
				return "Xylophone";
			case TUBULAR_BELLS:
				return "Tubular Bells";
			case DULCIMER:
				return "Dulcimer";
			case DRAWBAR_ORGAN:
				return "Drawbar Organ";
			case PERCUSSIVE_ORGAN:
				return "Percussive Organ";
			case ROCK_ORGAN:
				return "Rock Organ";
			case CHURCH_ORGAN:
				return "Church Organ";
			case REED_ORGAN:
				return "Reed Organ";
			case ACCORDION:
				return "Accordion";
			case HARMONICA:
				return "Harmonica";
			case TANGO_ACCORDION:
				return "Tango Accordion";
			case ACOUSTIC_GUITAR_NYLON:
				return "Acoustic Guitar (nylon)";
			case ACOUSTIC_GUITAR_STEEL:
				return "Acoustic Guitar (steel)";
			case ELECTRIC_GUITAR_JAZZ:
				return "Electric Guitar (jazz)";
			case ELECTRIC_GUITAR_CLEAN:
				return "Electric Guitar (clean)";
			case ELECTRIC_GUITAR_MUTED:
				return "Electric Guitar (muted)";
			case OVERDRIVEN_GUITAR:
				return "Overdriven Guitar";
			case DISTORTION_GUITAR:
				return "Distortion Guitar";
			case GUITAR_HARMONICS:
				return "Guitar Harmonics";
			case ACOUSTIC_BASS:
				return "Acoustic Bass";
			case ELECTRIC_BASS_FINGER:
				return "Electric Bass (finger)";
			case ELECTRIC_BASS_PICK:
				return "Electric Bass (pick)";
			case FRETLESS_BASS:
				return "Fretless Bass";
			case SLAP_BASS_1:
				return "Slap Bass 1";
			case SLAP_BASS_2:
				return "Slap Bass 2";
			case SYNTH_BASS_1:
				return "Synth Bass 1";
			case SYNTH_BASS_2:
				return "Synth Bass 2";
			case VIOLIN:
				return "Violin";
			case VIOLA:
				return "Viola";
			case CELLO:
				return "Cello";
			case CONTRABASS:
				return "Contrabass";
			case TREMOLO_STRINGS:
				return "Tremolo Strings";
			case PIZZICATO_STRINGS:
				return "Pizzicato Strings";
			case ORCHESTRAL_HARP:
				return "Orchestral Harp";
			case TIMPANI:
				return "Timpani";
			case STRING_ENSEMBLE_1:
				return "String Ensemble 1";
			case STRING_ENSEMBLE_2:
				return "String Ensemble 2";
			case SYNTH_STRINGS_1:
				return " Synth Strings 1";
			case SYNTH_STRINGS_2:
				return " Synth Strings 2";
			case CHOIR_AAHS:
				return "Choir Aahs";
			case VOICE_OOHS:
				return "Voice Oohs";
			case SYNTH_CHOIR:
				return "Synth Choir";
			case ORCHESTRA_HIT:
				return "Orchestra Hit";
			case TRUMPET:
				return "Trumpet";
			case TROMBONE:
				return "Trombone";
			case TUBA:
				return "Tuba";
			case MUTED_TRUMPET:
				return "Muted Trumpet";
			case FRENCH_HORN:
				return "French Horn";
			case BRASS_SECTION:
				return "Brass Section";
			case SYNTH_BRASS_1:
				return "Synth Brass 1";
			case SYNTH_BRASS_2:
				return "Synth Brass 2";
			case SOPRANO_SAX:
				return "Soprano Sax";
			case ALTO_SAX:
				return "Alto Sax";
			case TENOR_SAX:
				return "Tenor Sax";
			case BARITONE_SAX:
				return "Baritone Sax";
			case OBOE:
				return "Oboe";
			case ENGLISH_HORN:
				return "English Horn";
			case BASSOON:
				return "Bassoon";
			case CLARINET:
				return "Clarinet";
			case PICCOLO:
				return "Piccolo";
			case FLUTE:
				return "Flute";
			case RECORDER:
				return "Recorder";
			case PAN_FLUTE:
				return "Pan Flute";
			case BLOWN_BOTTLE:
				return "Blown bottle";
			case SHAKUHACHI:
				return "Shakuhachi";
			case WHISTLE:
				return "Whistle";
			case OCARINA:
				return "Ocarina";
			case LEAD1_SQUARE:
				return "Lead 1 (square)";
			case LEAD2_SAWTOOTH:
				return "Lead 2 (sawtooth)";
			case LEAD3_CALLIOPE:
				return "Lead 3 (calliope)";
			case LEAD4_CHIFF:
				return "Lead 4 (chiff)";
			case LEAD5_CHARANG:
				return "Lead 5 (charang)";
			case LEAD6_VOICE:
				return "Lead 6 (voice)";
			case LEAD7_FIFTHS:
				return "Lead 7 (fifths)";
			case LEAD8_BASS_LEAD:
				return "Lead 8 (bass + lead)";
			case PAD1_NEW_AGE:
				return "Pad 1 (new age)";
			case PAD2_WARM:
				return "Pad 2 (warm)";
			case PAD3_POLYSYNTH:
				return "Pad 3 (polysynth)";
			case PAD4_CHOIR:
				return "Pad 4 (choir)";
			case PAD5_BOWED:
				return "Pad 5 (bowed)";
			case PAD6_METALLIC:
				return "Pad 6 (metallic)";
			case PAD7_HALO:
				return "Pad 7 (halo)";
			case PAD8_SWEEP:
				return "Pad 8 (sweep)";
			case FX1_RAIN:
				return "FX 1 (rain)";
			case FX2_SOUNDTRACK:
				return "FX 2 (soundtrack)";
			case FX3_CRYSTAL:
				return "FX 3 (crystal)";
			case FX4_ATMOSPHERE:
				return "FX 4 (atmosphere)";
			case FX5_BRIGHTNESS:
				return "FX 5 (brightness)";
			case FX6_GOBLINS:
				return "FX 6 (goblins)";
			case FX7_ECHOES:
				return "FX 7 (echoes)";
			case FX8_SCI_FI:
				return "FX 8 (sci-fi)";
			case SITAR:
				return "Sitar";
			case BANJO:
				return "Banjo";
			case SHAMISEN:
				return "Shamisen";
			case KOTO:
				return "Koto";
			case KALIMBA:
				return "Kalimba";
			case BAGPIPE:
				return "Bagpipe";
			case FIDDLE:
				return "Fiddle";
			case SHANAI:
				return "Shanai";
			case TINKLE_BELL:
				return "Tinkle Bell";
			case AGOGO:
				return "Agogo";
			case STEEL_DRUMS:
				return "Steel Drums";
			case WOODBLOCK:
				return "Woodblock";
			case TAIKO_DRUM:
				return "Taiko Drum";
			case MELODIC_TOM:
				return "Melodic Tom";
			case SYNTH_DRUM:
				return "Synth Drum";
			case REVERSE_CYMBAL:
				return "Reverse Cymbal";
			case GUITAR_FRET_NOISE:
				return "Guitar Fret Noise";
			case BREATH_NOISE:
				return "Breath Noise";
			case SEASHORE:
				return "Seashore";
			case BIRD_TWEET:
				return "Bird Tweet";
			case TELEPHONE_RING:
				return "Telephone Ring";
			case HELICOPTER:
				return "Helicopter";
			case APPLAUSE:
				return "Applause";
			case GUNSHOT:
				return "Gunshot";
		}
	}

	public static Instrument[] all() {
		return ALL;
	}
}