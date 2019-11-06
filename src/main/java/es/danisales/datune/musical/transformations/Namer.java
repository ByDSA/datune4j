package es.danisales.datune.musical.transformations;

import es.danisales.datune.diatonic.ChordNotation;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchSingleMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

public class Namer {
    private Namer() {
    }

    public static String from(DiatonicAlt diatonicAlt) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( diatonicAlt.getDiatonic() );
        int alterations = diatonicAlt.getAlterations();
        if (alterations > 0) {
            if (diatonicAlt.getSemitonesAdded() < 0) {
                for (int i = 0; i < alterations; i++)
                    stringBuilder.append(ChordNotation.FLAT);
            } else if (diatonicAlt.getSemitonesAdded() > 0) {
                for (int i = 0; i < alterations; i++)
                    stringBuilder.append(ChordNotation.SHARP);
            }
        }
        return  stringBuilder.toString();
    }

    public static String from(Chromatic chromatic) {
        switch(chromatic) {
            case C:  return "C";
            case CC: return from(Chromatic.C) + ChordNotation.SHARP;
            case D:  return "D";
            case DD: return from(Chromatic.D) + ChordNotation.SHARP;
            case E:  return "E";
            case F:  return "F";
            case FF: return from(Chromatic.F) + ChordNotation.SHARP;
            case G:  return "G";
            case GG: return from(Chromatic.G) + ChordNotation.SHARP;
            case A:  return "A";
            case AA: return from(Chromatic.A) + ChordNotation.SHARP;
            case B:  return "B";
        }

        throw new RuntimeException("Impossible");
    }

    public static String from(ChromaticMidi chromaticMidi) {
        return from(chromaticMidi, null);
    }

    public static String from(PitchSingleMidi chromaticMidi, Tonality tonality) {
        Chromatic chromatic = ChromaticAdapter.from(chromaticMidi.getPitchMidi());
        DiatonicAlt diatonicAlt = tonality.get( tonality.getDegreeFrom(chromatic) );
        return ChromaticMidi.literal(diatonicAlt, tonality ) + chromaticMidi.getOctave();
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

    public static @NonNull String shortFrom(@NonNull Quality quality) {
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

    public static @NonNull String longFrom(@NonNull Quality quality) {
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

    public static @NonNull String shortFrom(IntervalChromatic intervalChromatic) {
        StringBuilder sb = new StringBuilder();
        sb.append( Namer.shortFrom(intervalChromatic.getQuality()) );

        IntervalDiatonic intervalDiatonic = IntervalDiatonic.from(intervalChromatic);
        sb.append( intervalDiatonic.ordinal() + 1 );

        return sb.toString();
    }

    public static @NonNull String longFrom(IntervalChromatic intervalChromatic) {
        StringBuilder sb = new StringBuilder();

        IntervalDiatonic intervalDiatonic = IntervalDiatonic.from(intervalChromatic);
        sb.append( Namer.from(intervalDiatonic) );
        sb.append(" ");
        sb.append( Namer.longFrom(intervalChromatic.getQuality()) );

        return sb.toString();
    }
}
