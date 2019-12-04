package es.danisales.datune.degree;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public interface Degree {
    int ordinal();

    @NonNull Degree getPrevious();

    @NonNull Degree getNext();

    static @NonNull List<Degree> getMainDegreesFromScaleSize(int n) {
        return DegreeAdapter.getValuesFromScaleSizeDefault(n);
    }
}
