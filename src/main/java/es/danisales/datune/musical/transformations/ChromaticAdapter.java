package es.danisales.datune.musical.transformations;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.MusicalChecker;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import java.util.Objects;

public class ChromaticAdapter {
    private ChromaticAdapter() {
    }

    public static Chromatic from(@NonNull Diatonic diatonic, Tonality tonality) {
        return tonality.get(diatonic.getDegree());
    }

    public static Chromatic from(@NonNull Diatonic diatonic, int semitoneValue) {
        Objects.requireNonNull(diatonic);
        MusicalChecker.semitoneIntValue(semitoneValue);

        switch ( diatonic ) {
            case C:
                switch ( semitoneValue ) {
                    case 0:
                        return Chromatic.C;
                    case 1:
                        return Chromatic.CC;
                    case 2:
                        return Chromatic.CCC;
                    case 3:
                        return Chromatic.CCCC;
                    case 4:
                        return Chromatic.CCCCC;
                    case 11:
                        return Chromatic.Cb;
                    case 10:
                        return Chromatic.Cbb;
                    case 9:
                        return Chromatic.Cbbb;
                }
                break;
            case D:
                switch ( semitoneValue ) {
                    case 2:
                        return Chromatic.D;

                    case 3:
                        return Chromatic.DD;
                    case 4:
                        return Chromatic.DDD;
                    case 5:
                        return Chromatic.DDDD;
                    case 6:
                        return Chromatic.DDDDD;
                    case 1:
                        return Chromatic.Db;
                    case 0:
                        return Chromatic.Dbb;
                    case 11:
                        return Chromatic.Dbbb;
                }
                break;
            case E:
                switch ( semitoneValue ) {
                    case 4:
                        return Chromatic.E;
                    case 5:
                        return Chromatic.EE;
                    case 6:
                        return Chromatic.EEE;
                    case 7:
                        return Chromatic.EEEE;
                    case 8:
                        return Chromatic.EEEEE;
                    case 3:
                        return Chromatic.Eb;
                    case 2:
                        return Chromatic.Ebb;
                    case 1:
                        return Chromatic.Ebbb;
                }
                break;
            case F:
                switch ( semitoneValue ) {
                    case 5:
                        return Chromatic.F;

                    case 6:
                        return Chromatic.FF;
                    case 7:
                        return Chromatic.FFF;
                    case 8:
                        return Chromatic.FFFF;
                    case 9:
                        return Chromatic.FFFFF;
                    case 4:
                        return Chromatic.Fb;
                    case 3:
                        return Chromatic.Fbb;
                    case 2:
                        return Chromatic.Fbbb;
                }
                break;
            case G:
                switch ( semitoneValue ) {
                    case 7:
                        return Chromatic.G;

                    case 8:
                        return Chromatic.GG;
                    case 9:
                        return Chromatic.GGG;
                    case 10:
                        return Chromatic.GGGG;
                    case 11:
                        return Chromatic.GGGGG;
                    case 6:
                        return Chromatic.Gb;
                    case 5:
                        return Chromatic.Gbb;
                    case 4:
                        return Chromatic.Gbbb;
                }
                break;
            case A:
                switch ( semitoneValue ) {
                    case 9:
                        return Chromatic.A;

                    case 10:
                        return Chromatic.AA;
                    case 11:
                        return Chromatic.AAA;
                    case 0:
                        return Chromatic.AAAA;
                    case 1:
                        return Chromatic.AAAAA;
                    case 8:
                        return Chromatic.Ab;
                    case 7:
                        return Chromatic.Abb;
                    case 6:
                        return Chromatic.Abbb;
                }
                break;
            case B:
                switch ( semitoneValue ) {
                    case 11:
                        return Chromatic.B;
                    case 0:
                        return Chromatic.BB;
                    case 1:
                        return Chromatic.BBB;
                    case 2:
                        return Chromatic.BBBB;
                    case 3:
                        return Chromatic.BBBBB;
                    case 10:
                        return Chromatic.Bb;
                    case 9:
                        return Chromatic.Bbb;
                    case 8:
                        return Chromatic.Bbbb;
                }
                break;
        }
        throw new RuntimeException("Impossible conversion");
    }

    public static Chromatic from(PitchMidi pitchMidi) {
        int value = pitchMidi.getCode();
        return Chromatic.from( value % 12 );
    }

    public static Chromatic from(ChromaticMidi chromaticMidi) {
        return from( chromaticMidi.getPitch() );
    }

    public static Chromatic from(PitchChromaticSingle t) {
        if (t.getClass().equals(PitchMidi.class))
            return from((PitchMidi)t);
        else if (t.getClass().equals(ChromaticMidi.class))
            return from((ChromaticMidi) t);
        else if (t.getClass().equals(Chromatic.class))
            return (Chromatic)t;

        throw new RuntimeException("Undefined for class " + t.getClass());
    }
}
