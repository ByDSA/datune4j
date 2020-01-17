package es.danisales.datune.degrees.octave;

import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.degrees.OrderedDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface OctaveDegree extends OrderedDegree {
    static @NonNull OrderedDegree from(DiatonicAlt noteBase, int size) {
        return OctaveDegreeAdapter.from(noteBase, size);
    }

    static @NonNull OrderedDegree from(int degree, int size) {
        return OctaveDegreeAdapter.from(degree, size);
    }

    @Override
    OctaveDegree getNext();
    @Override
    OctaveDegree getPrevious();
    @Override
    OctaveDegree getShifted(int i);
}
