package es.danisales.datune.midi.pitch;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.degree.ChromaticDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.pitch.PitchAbsoluteDegree;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;

enum PitchChromaticMidiImmutable implements PitchChromaticSingle, PitchOctave, PitchAbsoluteDegree<ChromaticDegree, IntervalChromatic> {
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

    public PitchChromaticMidiImmutable getWithShiftOctave(int o) throws PitchMidiException {
        return from(getCode() + Chromatic.NUMBER * o);
    }

    public PitchChromaticMidiImmutable getWithOctave(int o) throws PitchMidiException {
        return from(getCode() % Chromatic.NUMBER + Chromatic.NUMBER * o);
    }

    public int getCode() {
        return ordinal();
    }

    @Override
    public int getOctave() {
        return ordinal() / Chromatic.NUMBER;
    }

    public static PitchChromaticMidiImmutable from(int code) throws PitchMidiException {
        PitchMidiException.check(code);

        Chromatic n = Chromatic.from(code % Chromatic.NUMBER);
        int o = code / Chromatic.NUMBER;
        return from(n, o);
    }

    public static @NonNull PitchChromaticMidiImmutable from(Chromatic chromatic, int octave) throws PitchMidiException {
        switch (octave) {
            case 0:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C0;
                    case CC:
                        return PitchChromaticMidiImmutable.CC0;
                    case D:
                        return PitchChromaticMidiImmutable.D0;
                    case DD:
                        return PitchChromaticMidiImmutable.DD0;
                    case E:
                        return PitchChromaticMidiImmutable.E0;
                    case F:
                        return PitchChromaticMidiImmutable.F0;
                    case FF:
                        return PitchChromaticMidiImmutable.FF0;
                    case G:
                        return PitchChromaticMidiImmutable.G0;
                    case GG:
                        return PitchChromaticMidiImmutable.GG0;
                    case A:
                        return PitchChromaticMidiImmutable.A0;
                    case AA:
                        return PitchChromaticMidiImmutable.AA0;
                    case B:
                        return PitchChromaticMidiImmutable.B0;
                }
            case 1:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C1;
                    case CC:
                        return PitchChromaticMidiImmutable.CC1;
                    case D:
                        return PitchChromaticMidiImmutable.D1;
                    case DD:
                        return PitchChromaticMidiImmutable.DD1;
                    case E:
                        return PitchChromaticMidiImmutable.E1;
                    case F:
                        return PitchChromaticMidiImmutable.F1;
                    case FF:
                        return PitchChromaticMidiImmutable.FF1;
                    case G:
                        return PitchChromaticMidiImmutable.G1;
                    case GG:
                        return PitchChromaticMidiImmutable.GG1;
                    case A:
                        return PitchChromaticMidiImmutable.A1;
                    case AA:
                        return PitchChromaticMidiImmutable.AA1;
                    case B:
                        return PitchChromaticMidiImmutable.B1;
                }
            case 2:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C2;
                    case CC:
                        return PitchChromaticMidiImmutable.CC2;
                    case D:
                        return PitchChromaticMidiImmutable.D2;
                    case DD:
                        return PitchChromaticMidiImmutable.DD2;
                    case E:
                        return PitchChromaticMidiImmutable.E2;
                    case F:
                        return PitchChromaticMidiImmutable.F2;
                    case FF:
                        return PitchChromaticMidiImmutable.FF2;
                    case G:
                        return PitchChromaticMidiImmutable.G2;
                    case GG:
                        return PitchChromaticMidiImmutable.GG2;
                    case A:
                        return PitchChromaticMidiImmutable.A2;
                    case AA:
                        return PitchChromaticMidiImmutable.AA2;
                    case B:
                        return PitchChromaticMidiImmutable.B2;
                }
            case 3:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C3;
                    case CC:
                        return PitchChromaticMidiImmutable.CC3;
                    case D:
                        return PitchChromaticMidiImmutable.D3;
                    case DD:
                        return PitchChromaticMidiImmutable.DD3;
                    case E:
                        return PitchChromaticMidiImmutable.E3;
                    case F:
                        return PitchChromaticMidiImmutable.F3;
                    case FF:
                        return PitchChromaticMidiImmutable.FF3;
                    case G:
                        return PitchChromaticMidiImmutable.G3;
                    case GG:
                        return PitchChromaticMidiImmutable.GG3;
                    case A:
                        return PitchChromaticMidiImmutable.A3;
                    case AA:
                        return PitchChromaticMidiImmutable.AA3;
                    case B:
                        return PitchChromaticMidiImmutable.B3;
                }
            case 4:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C4;
                    case CC:
                        return PitchChromaticMidiImmutable.CC4;
                    case D:
                        return PitchChromaticMidiImmutable.D4;
                    case DD:
                        return PitchChromaticMidiImmutable.DD4;
                    case E:
                        return PitchChromaticMidiImmutable.E4;
                    case F:
                        return PitchChromaticMidiImmutable.F4;
                    case FF:
                        return PitchChromaticMidiImmutable.FF4;
                    case G:
                        return PitchChromaticMidiImmutable.G4;
                    case GG:
                        return PitchChromaticMidiImmutable.GG4;
                    case A:
                        return PitchChromaticMidiImmutable.A4;
                    case AA:
                        return PitchChromaticMidiImmutable.AA4;
                    case B:
                        return PitchChromaticMidiImmutable.B4;
                }
            case 5:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C5;
                    case CC:
                        return PitchChromaticMidiImmutable.CC5;
                    case D:
                        return PitchChromaticMidiImmutable.D5;
                    case DD:
                        return PitchChromaticMidiImmutable.DD5;
                    case E:
                        return PitchChromaticMidiImmutable.E5;
                    case F:
                        return PitchChromaticMidiImmutable.F5;
                    case FF:
                        return PitchChromaticMidiImmutable.FF5;
                    case G:
                        return PitchChromaticMidiImmutable.G5;
                    case GG:
                        return PitchChromaticMidiImmutable.GG5;
                    case A:
                        return PitchChromaticMidiImmutable.A5;
                    case AA:
                        return PitchChromaticMidiImmutable.AA5;
                    case B:
                        return PitchChromaticMidiImmutable.B5;
                }
            case 6:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C6;
                    case CC:
                        return PitchChromaticMidiImmutable.CC6;
                    case D:
                        return PitchChromaticMidiImmutable.D6;
                    case DD:
                        return PitchChromaticMidiImmutable.DD6;
                    case E:
                        return PitchChromaticMidiImmutable.E6;
                    case F:
                        return PitchChromaticMidiImmutable.F6;
                    case FF:
                        return PitchChromaticMidiImmutable.FF6;
                    case G:
                        return PitchChromaticMidiImmutable.G6;
                    case GG:
                        return PitchChromaticMidiImmutable.GG6;
                    case A:
                        return PitchChromaticMidiImmutable.A6;
                    case AA:
                        return PitchChromaticMidiImmutable.AA6;
                    case B:
                        return PitchChromaticMidiImmutable.B6;
                }
            case 7:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C7;
                    case CC:
                        return PitchChromaticMidiImmutable.CC7;
                    case D:
                        return PitchChromaticMidiImmutable.D7;
                    case DD:
                        return PitchChromaticMidiImmutable.DD7;
                    case E:
                        return PitchChromaticMidiImmutable.E7;
                    case F:
                        return PitchChromaticMidiImmutable.F7;
                    case FF:
                        return PitchChromaticMidiImmutable.FF7;
                    case G:
                        return PitchChromaticMidiImmutable.G7;
                    case GG:
                        return PitchChromaticMidiImmutable.GG7;
                    case A:
                        return PitchChromaticMidiImmutable.A7;
                    case AA:
                        return PitchChromaticMidiImmutable.AA7;
                    case B:
                        return PitchChromaticMidiImmutable.B7;
                }
            case 8:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C8;
                    case CC:
                        return PitchChromaticMidiImmutable.CC8;
                    case D:
                        return PitchChromaticMidiImmutable.D8;
                    case DD:
                        return PitchChromaticMidiImmutable.DD8;
                    case E:
                        return PitchChromaticMidiImmutable.E8;
                    case F:
                        return PitchChromaticMidiImmutable.F8;
                    case FF:
                        return PitchChromaticMidiImmutable.FF8;
                    case G:
                        return PitchChromaticMidiImmutable.G8;
                    case GG:
                        return PitchChromaticMidiImmutable.GG8;
                    case A:
                        return PitchChromaticMidiImmutable.A8;
                    case AA:
                        return PitchChromaticMidiImmutable.AA8;
                    case B:
                        return PitchChromaticMidiImmutable.B8;
                }
            case 9:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C9;
                    case CC:
                        return PitchChromaticMidiImmutable.CC9;
                    case D:
                        return PitchChromaticMidiImmutable.D9;
                    case DD:
                        return PitchChromaticMidiImmutable.DD9;
                    case E:
                        return PitchChromaticMidiImmutable.E9;
                    case F:
                        return PitchChromaticMidiImmutable.F9;
                    case FF:
                        return PitchChromaticMidiImmutable.FF9;
                    case G:
                        return PitchChromaticMidiImmutable.G9;
                    case GG:
                        return PitchChromaticMidiImmutable.GG9;
                    case A:
                        return PitchChromaticMidiImmutable.A9;
                    case AA:
                        return PitchChromaticMidiImmutable.AA9;
                    case B:
                        return PitchChromaticMidiImmutable.B9;
                }
            case 10:
                switch (chromatic) {
                    case C:
                        return PitchChromaticMidiImmutable.C10;
                    case CC:
                        return PitchChromaticMidiImmutable.CC10;
                    case D:
                        return PitchChromaticMidiImmutable.D10;
                    case DD:
                        return PitchChromaticMidiImmutable.DD10;
                    case E:
                        return PitchChromaticMidiImmutable.E10;
                    case F:
                        return PitchChromaticMidiImmutable.F10;
                    case FF:
                        return PitchChromaticMidiImmutable.FF10;
                    case G:
                        return PitchChromaticMidiImmutable.G10;
                }
        }

        throw new PitchMidiException(chromatic, octave);
    }

    public @NonNull PitchChromaticMidiImmutable getShift(int semitones) throws PitchMidiException {
        return PitchChromaticMidiImmutable.from(getCode() + semitones);
    }

    public @NonNull PitchChromaticMidiImmutable getShift(@NonNull IntervalChromatic intervalChromatic) throws PitchMidiException {
        return getShift(intervalChromatic.getSemitones());
    }

    public @NonNull PitchChromaticMidiImmutable getShiftNegative(@NonNull IntervalChromatic intervalChromatic) throws PitchMidiException {
        return getShift(-intervalChromatic.getSemitones());
    }

    @Override
    public ChromaticDegree getDegree() {
        return ChromaticDegree.values()[getChromatic().ordinal()];
    }

    @Override
    public @NonNull PitchChromaticMidiImmutable getNext() throws PitchMidiException {
        return from(getCode() + 1);
    }

    @Override
    public @NonNull PitchChromaticMidiImmutable getPrevious() throws PitchMidiException {
        return from(getCode() - 1);
    }

    @Override
    public @NonNull PitchChromaticMidiImmutable getShifted(IntervalChromatic intervalChromatic) throws PitchMidiException {
        return PitchChromaticMidiImmutable.from(ordinal() + intervalChromatic.getSemitones());
    }

    @Override
    public @NonNull PitchChromaticMidiImmutable getShiftedNegative(IntervalChromatic intervalChromatic) throws PitchMidiException {
        return PitchChromaticMidiImmutable.from(ordinal() - intervalChromatic.getSemitones());
    }
}
