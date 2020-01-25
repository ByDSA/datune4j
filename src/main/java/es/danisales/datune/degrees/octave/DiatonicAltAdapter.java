package es.danisales.datune.degrees.octave;

import es.danisales.datune.degrees.OrderedDegree;
import es.danisales.datune.midi.NoteMidi;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

class DiatonicAltAdapter {
    static @NonNull DiatonicAlt from(@NonNull Chromatic pitchChromaticSingle, @NonNull Diatonic diatonic) {
        return from((OrderedDegree) pitchChromaticSingle, diatonic);
    }

    static @NonNull DiatonicAlt from(@NonNull Chromatic pitchChromaticSingle, float microPart, @NonNull CyclicDegree absoluteDegree) {
        checkArgument(microPart < 1);

        Diatonic diatonic = Diatonic.from(absoluteDegree);
        Objects.requireNonNull(diatonic);

        DiatonicAlt diatonicAltWithoutMicro = DiatonicAlt.from(pitchChromaticSingle, diatonic);
        if (microPart == 0)
            return diatonicAltWithoutMicro;

        float alt = diatonicAltWithoutMicro.getSemitonesAdded() + microPart;
        return DiatonicAlt.from(diatonicAltWithoutMicro.getDiatonic(), alt);
    }

    static @NonNull DiatonicAlt from(float semis, @NonNull CyclicDegree absoluteDegree) {
        Diatonic diatonic = Diatonic.from(absoluteDegree);
        Objects.requireNonNull(diatonic);

        return from(semis, diatonic);
    }

    private static @NonNull DiatonicAlt from(float semis, @NonNull Diatonic diatonic) {
        int semisInt = Math.round(semis);
        float microPart = semis - semisInt;

        Chromatic chromatic = Chromatic.from(semisInt);

        return from(chromatic, microPart, diatonic);
    }

    private static @NonNull DiatonicAlt from(@NonNull OrderedDegree absoluteDegree, @NonNull Diatonic diatonic) {
        Objects.requireNonNull(diatonic);
        Objects.requireNonNull(absoluteDegree);

        if (absoluteDegree instanceof Chromatic) {
            Chromatic chromatic = (Chromatic)absoluteDegree;
            switch (diatonic) {
                case C:
                    switch (chromatic) {
                        case C:
                            return DiatonicAlt.C;
                        case CC:
                            return DiatonicAlt.CC;
                        case D:
                            return DiatonicAlt.CCC;
                        case B:
                            return DiatonicAlt.Cb;
                        case AA:
                            return DiatonicAlt.Cbb;
                    }
                    break;
                case D:
                    switch (chromatic) {
                        case D:
                            return DiatonicAlt.D;
                        case DD:
                            return DiatonicAlt.DD;
                        case E:
                            return DiatonicAlt.DDD;
                        case CC:
                            return DiatonicAlt.Db;
                        case C:
                            return DiatonicAlt.Dbb;
                    }
                    break;
                case E:
                    switch (chromatic) {
                        case E:
                            return DiatonicAlt.E;
                        case F:
                            return DiatonicAlt.EE;
                        case FF:
                            return DiatonicAlt.EEE;
                        case DD:
                            return DiatonicAlt.Eb;
                        case D:
                            return DiatonicAlt.Ebb;
                    }
                    break;
                case F:
                    switch (chromatic) {
                        case F:
                            return DiatonicAlt.F;
                        case FF:
                            return DiatonicAlt.FF;
                        case G:
                            return DiatonicAlt.FFF;
                        case E:
                            return DiatonicAlt.Fb;
                        case DD:
                            return DiatonicAlt.Fbb;
                    }
                    break;
                case G:
                    switch (chromatic) {
                        case G:
                            return DiatonicAlt.G;
                        case GG:
                            return DiatonicAlt.GG;
                        case A:
                            return DiatonicAlt.GGG;
                        case FF:
                            return DiatonicAlt.Gb;
                        case F:
                            return DiatonicAlt.Gbb;
                    }
                    break;
                case A:
                    switch (chromatic) {
                        case A:
                            return DiatonicAlt.A;
                        case AA:
                            return DiatonicAlt.AA;
                        case B:
                            return DiatonicAlt.AAA;
                        case GG:
                            return DiatonicAlt.Ab;
                        case G:
                            return DiatonicAlt.Abb;
                    }
                    break;
                case B:
                    switch (chromatic) {
                        case B:
                            return DiatonicAlt.B;
                        case C:
                            return DiatonicAlt.BB;
                        case CC:
                            return DiatonicAlt.BBB;
                        case AA:
                            return DiatonicAlt.Bb;
                        case A:
                            return DiatonicAlt.Bbb;
                    }
                    break;
            }
        } else if (absoluteDegree instanceof Pentatonic) {
            Pentatonic pentatonic = (Pentatonic) absoluteDegree;
            switch (diatonic) {
                case C:
                    switch (pentatonic) {
                        case C:
                            return DiatonicAlt.C;
                        case D:
                            return DiatonicAlt.CCC;
                    }
                    break;
                case D:
                    switch (pentatonic) {
                        case D:
                            return DiatonicAlt.D;
                        case E:
                            return DiatonicAlt.DDD;
                        case C:
                            return DiatonicAlt.Dbb;
                    }
                    break;
                case E:
                    switch (pentatonic) {
                        case E:
                            return DiatonicAlt.E;
                        case D:
                            return DiatonicAlt.Ebb;
                    }
                    break;
                case F:
                    switch (pentatonic) {
                        case G:
                            return DiatonicAlt.FFF;
                        case E:
                            return DiatonicAlt.Fb;
                    }
                    break;
                case G:
                    switch (pentatonic) {
                        case G:
                            return DiatonicAlt.G;
                        case A:
                            return DiatonicAlt.GGG;
                    }
                    break;
                case A:
                    switch (pentatonic) {
                        case A:
                            return DiatonicAlt.A;
                        case G:
                            return DiatonicAlt.Abb;
                    }
                    break;
                case B:
                    switch (pentatonic) {
                        case C:
                            return DiatonicAlt.BB;
                        case A:
                            return DiatonicAlt.Bbb;
                    }
                    break;
            }
        }

        Chromatic chromaticDiatonic = Chromatic.from(diatonic);
        int semis = chromaticDiatonic.distSemitonesTo(chromaticDiatonic);
        return DiatonicAlt.from(diatonic, semis);
    }

    static @NonNull DiatonicAlt from(@NonNull Chromatic chromatic) {
        switch (chromatic) {
            case C:
                return DiatonicAlt.C;
            case CC:
                return DiatonicAlt.CC;
            case D:
                return DiatonicAlt.D;
            case DD:
                return DiatonicAlt.DD;
            case E:
                return DiatonicAlt.E;
            case F:
                return DiatonicAlt.F;
            case FF:
                return DiatonicAlt.FF;
            case G:
                return DiatonicAlt.G;
            case GG:
                return DiatonicAlt.GG;
            case A:
                return DiatonicAlt.A;
            case AA:
                return DiatonicAlt.AA;
            case B:
                return DiatonicAlt.B;
        }

        throw NeverHappensException.switchOf(chromatic);
    }

    static @NonNull DiatonicAlt from(@NonNull NoteMidi chromaticMidi) {
        Chromatic chromatic = chromaticMidi.getPitch().getNote();
        return from(chromatic);
    }
}
