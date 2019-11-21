package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface AbsoluteDegree<D extends RelativeDegree, I extends Interval> {
    static @Nullable AbsoluteDegree from(DiatonicAlt noteBase, int size) {
        return AbsoluteDegreeAdapter.from(noteBase, size);
    }

    static @NonNull AbsoluteDegree from(int degree, int size) {
        return AbsoluteDegreeAdapter.from(degree, size);
    }

    D getDegree();
    default int ordinal() {
        return getDegree().ordinal();
    }
    AbsoluteDegree<D, I> getNext();
    AbsoluteDegree<D, I> getPrevious();
    AbsoluteDegree<D, I> getShifted(I interval);
    AbsoluteDegree<D, I> getShiftedNegative(I interval);
}
