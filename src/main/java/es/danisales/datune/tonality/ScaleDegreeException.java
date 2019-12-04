package es.danisales.datune.tonality;

import es.danisales.datune.degree.Degree;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ScaleDegreeException extends Exception {
    public ScaleDegreeException(@NonNull Degree relativeDegree, @NonNull Scale scale) {
        super("La escala " + scale + " no tiene el " + relativeDegree);
    }

    public ScaleDegreeException(@NonNull Degree relativeDegree, @NonNull ScaleInner scale) {
        super("La escala " + scale + " no tiene el " + relativeDegree);
    }
}