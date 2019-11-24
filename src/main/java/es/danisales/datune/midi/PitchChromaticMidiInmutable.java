package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.Nullable;

enum PitchChromaticMidiInmutable implements PitchChromaticSingle, PitchOctave, AbsoluteDegree<ChromaticDegree, IntervalChromatic> {
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

    public Chromatic getChromatic() {
        return Chromatic.from(ordinal() % Chromatic.NUMBER);
    }

    public PitchChromaticMidiInmutable getWithShiftOctave(int o) {
        return from(getCode() + Chromatic.NUMBER * o);
    }

    public PitchChromaticMidiInmutable getWithOctave(int o) {
        return from(getCode() % Chromatic.NUMBER + Chromatic.NUMBER * o);
    }

    public int getCode() {
        return ordinal();
    }

    @Override
    public int getOctave() {
        return ordinal() / Chromatic.NUMBER;
    }

    public static PitchChromaticMidiInmutable from(int code) {
        PitchMidiException.check(code);
        Chromatic n = Chromatic.from(code % Chromatic.NUMBER);
        int o = code / Chromatic.NUMBER;
        return from(n, o);
    }

    public static @Nullable PitchChromaticMidiInmutable from(Chromatic chromatic, int octave) {
        switch (octave) {
            case 0:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C0;
                    case CC:
                        return PitchChromaticMidiInmutable.CC0;
                    case D:
                        return PitchChromaticMidiInmutable.D0;
                    case DD:
                        return PitchChromaticMidiInmutable.DD0;
                    case E:
                        return PitchChromaticMidiInmutable.E0;
                    case F:
                        return PitchChromaticMidiInmutable.F0;
                    case FF:
                        return PitchChromaticMidiInmutable.FF0;
                    case G:
                        return PitchChromaticMidiInmutable.G0;
                    case GG:
                        return PitchChromaticMidiInmutable.GG0;
                    case A:
                        return PitchChromaticMidiInmutable.A0;
                    case AA:
                        return PitchChromaticMidiInmutable.AA0;
                    case B:
                        return PitchChromaticMidiInmutable.B0;
                    default:
                        return null;
                }
            case 1:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C1;
                    case CC:
                        return PitchChromaticMidiInmutable.CC1;
                    case D:
                        return PitchChromaticMidiInmutable.D1;
                    case DD:
                        return PitchChromaticMidiInmutable.DD1;
                    case E:
                        return PitchChromaticMidiInmutable.E1;
                    case F:
                        return PitchChromaticMidiInmutable.F1;
                    case FF:
                        return PitchChromaticMidiInmutable.FF1;
                    case G:
                        return PitchChromaticMidiInmutable.G1;
                    case GG:
                        return PitchChromaticMidiInmutable.GG1;
                    case A:
                        return PitchChromaticMidiInmutable.A1;
                    case AA:
                        return PitchChromaticMidiInmutable.AA1;
                    case B:
                        return PitchChromaticMidiInmutable.B1;
                    default:
                        return null;
                }
            case 2:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C2;
                    case CC:
                        return PitchChromaticMidiInmutable.CC2;
                    case D:
                        return PitchChromaticMidiInmutable.D2;
                    case DD:
                        return PitchChromaticMidiInmutable.DD2;
                    case E:
                        return PitchChromaticMidiInmutable.E2;
                    case F:
                        return PitchChromaticMidiInmutable.F2;
                    case FF:
                        return PitchChromaticMidiInmutable.FF2;
                    case G:
                        return PitchChromaticMidiInmutable.G2;
                    case GG:
                        return PitchChromaticMidiInmutable.GG2;
                    case A:
                        return PitchChromaticMidiInmutable.A2;
                    case AA:
                        return PitchChromaticMidiInmutable.AA2;
                    case B:
                        return PitchChromaticMidiInmutable.B2;
                    default:
                        return null;
                }
            case 3:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C3;
                    case CC:
                        return PitchChromaticMidiInmutable.CC3;
                    case D:
                        return PitchChromaticMidiInmutable.D3;
                    case DD:
                        return PitchChromaticMidiInmutable.DD3;
                    case E:
                        return PitchChromaticMidiInmutable.E3;
                    case F:
                        return PitchChromaticMidiInmutable.F3;
                    case FF:
                        return PitchChromaticMidiInmutable.FF3;
                    case G:
                        return PitchChromaticMidiInmutable.G3;
                    case GG:
                        return PitchChromaticMidiInmutable.GG3;
                    case A:
                        return PitchChromaticMidiInmutable.A3;
                    case AA:
                        return PitchChromaticMidiInmutable.AA3;
                    case B:
                        return PitchChromaticMidiInmutable.B3;
                    default:
                        return null;
                }
            case 4:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C4;
                    case CC:
                        return PitchChromaticMidiInmutable.CC4;
                    case D:
                        return PitchChromaticMidiInmutable.D4;
                    case DD:
                        return PitchChromaticMidiInmutable.DD4;
                    case E:
                        return PitchChromaticMidiInmutable.E4;
                    case F:
                        return PitchChromaticMidiInmutable.F4;
                    case FF:
                        return PitchChromaticMidiInmutable.FF4;
                    case G:
                        return PitchChromaticMidiInmutable.G4;
                    case GG:
                        return PitchChromaticMidiInmutable.GG4;
                    case A:
                        return PitchChromaticMidiInmutable.A4;
                    case AA:
                        return PitchChromaticMidiInmutable.AA4;
                    case B:
                        return PitchChromaticMidiInmutable.B4;
                    default:
                        return null;
                }
            case 5:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C5;
                    case CC:
                        return PitchChromaticMidiInmutable.CC5;
                    case D:
                        return PitchChromaticMidiInmutable.D5;
                    case DD:
                        return PitchChromaticMidiInmutable.DD5;
                    case E:
                        return PitchChromaticMidiInmutable.E5;
                    case F:
                        return PitchChromaticMidiInmutable.F5;
                    case FF:
                        return PitchChromaticMidiInmutable.FF5;
                    case G:
                        return PitchChromaticMidiInmutable.G5;
                    case GG:
                        return PitchChromaticMidiInmutable.GG5;
                    case A:
                        return PitchChromaticMidiInmutable.A5;
                    case AA:
                        return PitchChromaticMidiInmutable.AA5;
                    case B:
                        return PitchChromaticMidiInmutable.B5;
                    default:
                        return null;
                }
            case 6:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C6;
                    case CC:
                        return PitchChromaticMidiInmutable.CC6;
                    case D:
                        return PitchChromaticMidiInmutable.D6;
                    case DD:
                        return PitchChromaticMidiInmutable.DD6;
                    case E:
                        return PitchChromaticMidiInmutable.E6;
                    case F:
                        return PitchChromaticMidiInmutable.F6;
                    case FF:
                        return PitchChromaticMidiInmutable.FF6;
                    case G:
                        return PitchChromaticMidiInmutable.G6;
                    case GG:
                        return PitchChromaticMidiInmutable.GG6;
                    case A:
                        return PitchChromaticMidiInmutable.A6;
                    case AA:
                        return PitchChromaticMidiInmutable.AA6;
                    case B:
                        return PitchChromaticMidiInmutable.B6;
                    default:
                        return null;
                }
            case 7:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C7;
                    case CC:
                        return PitchChromaticMidiInmutable.CC7;
                    case D:
                        return PitchChromaticMidiInmutable.D7;
                    case DD:
                        return PitchChromaticMidiInmutable.DD7;
                    case E:
                        return PitchChromaticMidiInmutable.E7;
                    case F:
                        return PitchChromaticMidiInmutable.F7;
                    case FF:
                        return PitchChromaticMidiInmutable.FF7;
                    case G:
                        return PitchChromaticMidiInmutable.G7;
                    case GG:
                        return PitchChromaticMidiInmutable.GG7;
                    case A:
                        return PitchChromaticMidiInmutable.A7;
                    case AA:
                        return PitchChromaticMidiInmutable.AA7;
                    case B:
                        return PitchChromaticMidiInmutable.B7;
                    default:
                        return null;
                }
            case 8:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C8;
                    case CC:
                        return PitchChromaticMidiInmutable.CC8;
                    case D:
                        return PitchChromaticMidiInmutable.D8;
                    case DD:
                        return PitchChromaticMidiInmutable.DD8;
                    case E:
                        return PitchChromaticMidiInmutable.E8;
                    case F:
                        return PitchChromaticMidiInmutable.F8;
                    case FF:
                        return PitchChromaticMidiInmutable.FF8;
                    case G:
                        return PitchChromaticMidiInmutable.G8;
                    case GG:
                        return PitchChromaticMidiInmutable.GG8;
                    case A:
                        return PitchChromaticMidiInmutable.A8;
                    case AA:
                        return PitchChromaticMidiInmutable.AA8;
                    case B:
                        return PitchChromaticMidiInmutable.B8;
                    default:
                        return null;
                }
            case 9:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C9;
                    case CC:
                        return PitchChromaticMidiInmutable.CC9;
                    case D:
                        return PitchChromaticMidiInmutable.D9;
                    case DD:
                        return PitchChromaticMidiInmutable.DD9;
                    case E:
                        return PitchChromaticMidiInmutable.E9;
                    case F:
                        return PitchChromaticMidiInmutable.F9;
                    case FF:
                        return PitchChromaticMidiInmutable.FF9;
                    case G:
                        return PitchChromaticMidiInmutable.G9;
                    case GG:
                        return PitchChromaticMidiInmutable.GG9;
                    case A:
                        return PitchChromaticMidiInmutable.A9;
                    case AA:
                        return PitchChromaticMidiInmutable.AA9;
                    case B:
                        return PitchChromaticMidiInmutable.B9;
                    default:
                        return null;
                }
            case 10:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiInmutable.C10;
                    case CC:
                        return PitchChromaticMidiInmutable.CC10;
                    case D:
                        return PitchChromaticMidiInmutable.D10;
                    case DD:
                        return PitchChromaticMidiInmutable.DD10;
                    case E:
                        return PitchChromaticMidiInmutable.E10;
                    case F:
                        return PitchChromaticMidiInmutable.F10;
                    case FF:
                        return PitchChromaticMidiInmutable.FF10;
                    case G:
                        return PitchChromaticMidiInmutable.G10;
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    public PitchChromaticMidiInmutable getShift(int i) {
        return PitchChromaticMidiInmutable.from(getCode() + i);
    }

    public PitchChromaticMidiInmutable getShift(IntervalChromatic i) {
        return getShift(i.getSemitones());
    }

    public PitchChromaticMidiInmutable getShiftNegative(IntervalChromatic i) {
        return getShift(-i.getSemitones());
    }

    private static int getCodeNoTestLimits(Chromatic chromatic, int octave) {
        return Chromatic.NUMBER * octave + chromatic.ordinal();
    }

    @Override
    public ChromaticDegree getDegree() {
        return ChromaticDegree.values()[getChromatic().ordinal()];
    }

    @Override
    public PitchChromaticMidiInmutable getNext() {
        return from(getCode() + 1);
    }

    @Override
    public PitchChromaticMidiInmutable getPrevious() {
        return from(getCode() - 1);
    }

    @Override
    public PitchChromaticMidiInmutable getShifted(IntervalChromatic intervalChromatic) {
        return PitchChromaticMidiInmutable.from(ordinal() + intervalChromatic.getSemitones());
    }

    @Override
    public PitchChromaticMidiInmutable getShiftedNegative(IntervalChromatic intervalChromatic) {
        return PitchChromaticMidiInmutable.from(ordinal() - intervalChromatic.getSemitones());
    }
}
