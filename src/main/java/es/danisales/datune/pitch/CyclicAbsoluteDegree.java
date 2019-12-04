package es.danisales.datune.pitch;

import es.danisales.datune.degree.Degree;
import es.danisales.datune.interval.Interval;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface CyclicAbsoluteDegree<D extends Degree, I extends Interval>
        extends AbsoluteDegree<D>, SymbolicPitch {
    static @NonNull CyclicAbsoluteDegree from(DiatonicAlt noteBase, int size) {
        return CyclicAbsoluteDegreeAdapter.from(noteBase, size);
    }

    static @NonNull CyclicAbsoluteDegree from(int degree, int size) {
        return CyclicAbsoluteDegreeAdapter.from(degree, size);
    }

    CyclicAbsoluteDegree<D, I> getNext();

    CyclicAbsoluteDegree<D, I> getPrevious();

    CyclicAbsoluteDegree<D, I> getShifted(I interval);

    CyclicAbsoluteDegree<D, I> getShiftedNegative(I interval);
}
