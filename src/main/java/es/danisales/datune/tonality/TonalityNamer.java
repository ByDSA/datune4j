package es.danisales.datune.tonality;

import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.log.string.Logging;

public class TonalityNamer {
    private TonalityNamer() {
    }


    public static void showNotes(Tonality tonality) {
        Logging.log( tonality + ": " + notesFrom(tonality) );
    }

    public static String notesFrom(Tonality tonality) {
        StringBuilder sb = new StringBuilder();
        for (DiatonicAlt diatonicAlt : tonality.getNotes()) {
            sb.append(diatonicAlt).append(" ");
        }

        return sb.toString();
    }
}
