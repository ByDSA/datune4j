package es.danisales.datune.diatonic;

import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

public class RelativeDegreeAdapter {
    private RelativeDegreeAdapter() {
    }

    public static void checkDegree(@NonNull Tonality tonality, @NonNull RelativeDegree degree) { //todo: private
        for ( RelativeDegree diatonicDegree : tonality.getDegrees() ) {
            if (diatonicDegree.ordinal() == degree.ordinal())
                return;
        }

        throw new RuntimeException("TonalityDegree de tipo " + degree.getClass()
                + ". Esperado " + tonality.getDegrees().get(0).getClass() + " (" + tonality.size() + ").");
    }
}
