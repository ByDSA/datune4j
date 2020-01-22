package es.danisales.datune.tonality;

import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.degrees.CyclicDegree;
import es.danisales.log.string.Logging;

public class TonalityNamer {
    private TonalityNamer() {
    }


    public static <C extends CyclicDegree> void showNotes(Tonality<C> tonality) {
        Logging.log( tonality + ": " + notesFrom(tonality) );
    }

    public static <C extends CyclicDegree> String notesFrom(Tonality<C> tonality) {
        StringBuilder sb = new StringBuilder();
        for (C diatonicAlt : tonality.getNotes()) {
            sb.append(diatonicAlt).append(" ");
        }

        return sb.toString();
    }
}
