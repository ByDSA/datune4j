package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface AbsoluteDegree<T extends RelativeDegree> {
    static @Nullable AbsoluteDegree from(DiatonicAlt noteBase, int size) {
        return AbsoluteDegreeAdapter.from(noteBase, size);
    }

    static @NonNull AbsoluteDegree from(int degree, int size) {
        return AbsoluteDegreeAdapter.from(degree, size);
    }

    T getDegree();
    default int ordinal() {
        return getDegree().ordinal();
    }
    AbsoluteDegree<T> getNext();
    AbsoluteDegree<T> getPrevious();
}
