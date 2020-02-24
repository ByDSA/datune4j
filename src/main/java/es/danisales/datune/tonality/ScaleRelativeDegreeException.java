package es.danisales.datune.tonality;

import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.function.HarmonicFunction;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ScaleRelativeDegreeException extends Exception {
    public ScaleRelativeDegreeException(@NonNull ScaleDegree relativeDegree, @NonNull Scale scale) {
        super("La escala " + scale + " no tiene el " + relativeDegree);
    }

    public ScaleRelativeDegreeException(@NonNull ScaleDegree relativeDegree, @NonNull ScaleInner scale) {
        super("La escala " + scale + " no tiene el " + relativeDegree);
    }

    public ScaleRelativeDegreeException(@NonNull HarmonicFunction harmonicFunction, @NonNull Scale scale) {
        super("La escala " + scale + " no tiene la función " + harmonicFunction);
    }
}