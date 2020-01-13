package es.danisales.datune.lang;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.Quality;
import es.danisales.datune.tonality.ScaleDegreeException;
import es.danisales.datune.tonality.ScaleDistance;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

public class Namer {
    private Namer() {
    }

    public static String alt(int alt) {
        StringBuilder stringBuilder = new StringBuilder();
        if (alt < 0) {
            for (int i = alt; i < 0; i++)
                stringBuilder.append(ChordNotation.FLAT);
        } else if (alt > 0) {
            for (int i = 0; i < alt; i++)
                stringBuilder.append(ChordNotation.SHARP);
        }

        return stringBuilder.toString();
    }

    public static String from(@NonNull DiatonicAlt diatonicAlt) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( diatonicAlt.getDiatonic() );
        float alterations = diatonicAlt.getUnsignedAlterations();
        if (alterations > 0) {
            stringBuilder.append(alt(diatonicAlt.getSemitonesAdded()));

            float decimalPart = diatonicAlt.getMicrotonalPartAdded();
            if (Math.abs(decimalPart) > 0) {
                int quarters = Math.round(Math.abs(decimalPart)/ ScaleDistance.QUARTER.getMicrotonalSemitones());
                if (decimalPart < 0)
                    stringBuilder.append("(-").append(quarters).append("q)");
                else if (decimalPart > 0)
                    stringBuilder.append("(+").append(quarters).append("q)");
            }
        }
        return  stringBuilder.toString();
    }

    public static String from(@NonNull Chromatic chromatic) {
        switch(chromatic) {
            case C:
                return Diatonic.C.toString();
            case CC: return from(Chromatic.C) + ChordNotation.SHARP;
            case D:
                return Diatonic.D.toString();
            case DD: return from(Chromatic.D) + ChordNotation.SHARP;
            case E:
                return Diatonic.E.toString();
            case F:
                return Diatonic.F.toString();
            case FF: return from(Chromatic.F) + ChordNotation.SHARP;
            case G:
                return Diatonic.G.toString();
            case GG: return from(Chromatic.G) + ChordNotation.SHARP;
            case A:
                return Diatonic.A.toString();
            case AA: return from(Chromatic.A) + ChordNotation.SHARP;
            case B:
                return Diatonic.B.toString();
        }

        throw NeverHappensException.switchOf(chromatic);
    }

    public static String from(@NonNull ChromaticMidi chromaticMidi, @NonNull Tonality tonality) throws TonalityException, ScaleDegreeException {
        Chromatic chromatic = chromaticMidi.getPitch().getChromatic();
        DiatonicDegree diatonicDegree = (DiatonicDegree)tonality.getDegreeFrom(chromatic);
        DiatonicAlt diatonicAlt = tonality.getNote(diatonicDegree);
        return diatonicAlt.toString() + chromaticMidi.getPitch().getOctave();
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
        throw NeverHappensException.switchOf(intervalDiatonic);
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

        throw NeverHappensException.switchOf(quality);
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

        throw NeverHappensException.switchOf(quality);
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
