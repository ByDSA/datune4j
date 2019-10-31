package es.danisales.datune.musical.transformations;

import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

public class Namer {
    private Namer() {
    }

    @SuppressWarnings("WeakerAccess")
    public static final String FLAT = "b";
    @SuppressWarnings("WeakerAccess")
    public static final String SHARP = "#";

    public static String from(Chromatic chromatic) {
        Chromatic chromaticWithoutAlterations = AlterationsCalculator.removeAlterationsFrom(chromatic);

        switch(chromatic) {
            case C: return "C";
            case D: return "D";
            case E: return "E";
            case F: return "F";
            case G: return "G";
            case A: return "A";
            case B: return "B";
            case CC:
            case DD:
            case EE:
            case FF:
            case GG:
            case AA:
            case BB:
                return chromaticWithoutAlterations + SHARP;
            case CCC:
            case DDD:
            case EEE:
            case FFF:
            case GGG:
            case AAA:
            case BBB:
                return chromaticWithoutAlterations + SHARP + SHARP;
            case CCCC:
            case DDDD:
            case EEEE:
            case FFFF:
            case GGGG:
            case AAAA:
            case BBBB:
                return chromaticWithoutAlterations + SHARP + SHARP;
            case CCCCC:
            case DDDDD:
            case EEEEE:
            case FFFFF:
            case GGGGG:
            case AAAAA:
            case BBBBB:
                return chromaticWithoutAlterations + SHARP + SHARP + SHARP;
            case Cb:
            case Db:
            case Eb:
            case Fb:
            case Gb:
            case Ab:
            case Bb:
                return chromaticWithoutAlterations + FLAT;
            case Cbb:
            case Dbb:
            case Ebb:
            case Fbb:
            case Gbb:
            case Abb:
            case Bbb:
                return chromaticWithoutAlterations + FLAT + FLAT;
            case Cbbb:
            case Dbbb:
            case Ebbb:
            case Fbbb:
            case Gbbb:
            case Abbb:
            case Bbbb:
                return chromaticWithoutAlterations + FLAT + FLAT + FLAT;
            default: return "Nota desconocida";
        }
    }

    public static String from(ChromaticMidi chromaticMidi) {
        return from(chromaticMidi, null);
    }

    public static String from(ChromaticMidi chromaticMidi, Tonality tonality) {
        return ChromaticMidi.literal(ChromaticAdapter.from(chromaticMidi.getPitch()), tonality ) + chromaticMidi.getOctave();
    }

    public static @NonNull String from(@NonNull IntervalDiatonic intervalDiatonic) {
        switch (intervalDiatonic) {
            case UNISON:
                return "Unísono";
            case SECOND:
                return "Segunda";
            case THIRD:
                return "Tercera";
            case FOURTH:
                return "Cuarta";
            case FIFTH:
                return "Quinta";
            case SIXTH:
                return "Sexta";
            case SEVENTH:
                return "Séptima";
            case OCTAVE:
                return "Octava";
            case NINTH:
                return "Novena";
            case TENTH:
                return "Décima";
            case ELEVENTH:
                return "Onceava";
            case TWELFTH:
                return "Doceava";
            case THIRTEENTH:
                return "Treceava";
            case FOURTEENTH:
                return "Catorceava";
            case FIFTEENTH:
                return "Quinceava";
        }
        throw new RuntimeException("Impossible");
    }

    public static @NonNull String fromShort(@NonNull Quality quality) {
        switch (quality) {
            case DIMINISHED:
                return "d";
            case AUGMENTED:
                return "A";
            case MAJOR:
                return "M";
            case MINOR:
                return "m";
            case PERFECT:
                return "P";
            case INDETERMINATED:
                return "undef";
        }

        throw new RuntimeException("Impossible");
    }

    public static @NonNull String fromLong(@NonNull Quality quality) {
        switch (quality) {
            case DIMINISHED:
                return "disminuida";
            case AUGMENTED:
                return "aumentada";
            case MAJOR:
                return "mayor";
            case MINOR:
                return "menor";
            case PERFECT:
                return "perfecta";
            case INDETERMINATED:
                return "indeterminada";
        }

        throw new RuntimeException("Impossible");
    }

    public static @NonNull String fromShort(IntervalChromatic intervalChromatic) {
        StringBuilder sb = new StringBuilder();
        sb.append( Namer.fromShort(intervalChromatic.getQuality()) );

        IntervalDiatonic intervalDiatonic = IntervalDiatonic.from(intervalChromatic);
        sb.append( intervalDiatonic.ordinal() + 1 );

        return sb.toString();
    }

    public static @NonNull String fromLong(IntervalChromatic intervalChromatic) {
        StringBuilder sb = new StringBuilder();

        IntervalDiatonic intervalDiatonic = IntervalDiatonic.from(intervalChromatic);
        sb.append( Namer.from(intervalDiatonic) );
        sb.append(" ");
        sb.append( Namer.fromLong(intervalChromatic.getQuality()) );

        return sb.toString();
    }
}
