package es.danisales.datune.degrees.octave;

import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.degrees.OrderedDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface CyclicDegree extends OrderedDegree {
    static @NonNull CyclicDegree from(DiatonicAlt noteBase, int size) {
        return CyclicDegreeAdapter.from(noteBase, size);
    }

    static @NonNull CyclicDegree from(int degree, int size) {
        return CyclicDegreeAdapter.from(degree, size);
    }

    @Override
    CyclicDegree getNext();
    @Override
    CyclicDegree getPrevious();
    @Override
    CyclicDegree getShifted(int i);
}
