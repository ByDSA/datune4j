package es.danisales.datune.degrees.scale;

import es.danisales.datune.degrees.CyclicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public interface ScaleDegree extends CyclicDegree {
    static @NonNull List<ScaleDegree> getDefaultDegreesFromScaleSize(int n) {
        return DegreeAdapter.getValuesFromScaleSizeDefault(n);
    }
}
