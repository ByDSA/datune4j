package es.danisales.datune.tonality;

import es.danisales.datune.degrees.scale.ScaleDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ScaleRelativeDegreeException extends Exception {
    public ScaleRelativeDegreeException(@NonNull ScaleDegree relativeDegree, @NonNull Scale scale) {
        super("La escala " + scale + " no tiene el " + relativeDegree);
    }

    public ScaleRelativeDegreeException(@NonNull ScaleDegree relativeDegree, @NonNull ScaleInner scale) {
        super("La escala " + scale + " no tiene el " + relativeDegree);
    }
}