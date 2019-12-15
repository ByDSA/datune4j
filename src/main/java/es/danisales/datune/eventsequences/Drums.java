package es.danisales.datune.eventsequences;

public enum Drums {
    ACOUSTIC_BASS_DRUM(35),
    BASS_DRUM1(36),
    SIDE_STICK(37),
    ACOUSTIC_SNARE(38),
    HAND_CLAP(39),
    ELECTRIC_SNARE(40),
    LOW_FLOOR_TOM(41),
    CLOSED_HI_HAT(42),
    HIGH_FLOOR_TOM(43),
    PEDAL_HIHAT(44),
    LOW_TOM(45),
    OPEN_HIHAT(46),
    LOWMID_TOM(47),
    HIMID_TOM(48),
    CRASH_CYMBAL1(49),
    HIGH_TOM(50),
    RIDE_CYMBAL1(51),
    CHINESE_CYMBAL(52),
    RIDE_BELL(53),
    TAMBOURINE(54),
    SPLASH_CYMBAL(55),
    COWBELL(56),
    CRASH_CYMBAL2(57),
    VIBRASLAP(58),
    RIDE_CYMBAL2(59),
    HI_BONGO(60),
    LOW_BONGO(61),
    MUTE_HI_CONGA(62),
    OPEN_HI_CONGA(63),
    LOW_CONGA(64),
    HIGH_TIMBALE(65),
    LOW_TIMBALE(66),
    HIGH_AGOGO(67),
    LOW_AGOGO(68),
    CABASA(69),
    MARACAS(70),
    SHORT_WHISTLE(71),
    LONG_WHISTLE(72),
    SHORT_GUIRO(73),
    LONG_GUIRO(74),
    CLAVES(75),
    HI_WOOD_BLOCK(76),
    LOW_WOOD_BLOCK(77),
    MUTE_CUICA(78),
    OPEN_CUICA(79),
    MUTE_TRIANGLE(80),
    OPEN_TRIANGLE(81);

    private final int code;

    Drums(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}