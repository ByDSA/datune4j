package es.danisales.datune.degrees.octave;

import es.danisales.datune.chords.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

class OctaveDegreeAdapter {
    private OctaveDegreeAdapter() {
    }

    private static Map<Integer, Function<DiatonicAlt, OctaveDegree>> conversorMap = new HashMap<>();

    static {
        conversorMap.put(5, Pentatonic::from);
        conversorMap.put(7, DiatonicAlt::getDiatonic);
        conversorMap.put(12, Chromatic::from);
    }

    public static OctaveDegree from(DiatonicAlt noteBase, int size) {
        Function<DiatonicAlt, OctaveDegree> f = conversorMap.get(size);
        if (f != null)
            return f.apply(noteBase);

        return createDegree(noteBase, size);
    }

    public static @NonNull OctaveDegree from(int degree, int size) {
        OctaveDegree[] CyclicAbsoluteDegrees = new OctaveDegree[size];

        for (AtomicInteger ai = new AtomicInteger(0); ai.get() < size; ai.incrementAndGet()) {
            CyclicAbsoluteDegrees[ai.get()] = new OctaveDegree() {
                int currentIndex = ai.get();

                @Override
                public int ordinal() {
                    return currentIndex;
                }

                @Override
                public OctaveDegree getNext() {
                    int index = limit(currentIndex+1);
                    return CyclicAbsoluteDegrees[index];
                }

                @Override
                public OctaveDegree getPrevious() {
                    int index = limit(currentIndex-1);
                    return CyclicAbsoluteDegrees[index];
                }

                @Override
                public OctaveDegree getShifted(int i) {
                    if (i > 0) {
                        OctaveDegree self = this;
                        for (int j = 0; j < i; j++)
                            self = self.getNext();
                        return self;
                    } else if (i < 0) {
                        OctaveDegree self = this;
                        for (int j = 0; j < -i; j++)
                            self = self.getPrevious();
                        return self;
                    } else
                        return this;
                }

                @Override
                public String toString() {
                    return "(" + currentIndex + ")";
                }

                private int limit(int i) {
                    return (i + size) % size;
                }
            };
        }

        return CyclicAbsoluteDegrees[degree];
    }

    static int getNumber(OctaveDegree CyclicAbsoluteDegreeBase) {
        int i = 0;
        OctaveDegree CyclicAbsoluteDegree = CyclicAbsoluteDegreeBase;
        while (i == 0 || CyclicAbsoluteDegree != CyclicAbsoluteDegreeBase) {
            i++;
            CyclicAbsoluteDegree = CyclicAbsoluteDegree.getNext();
        }
        return i;
    }

    private static OctaveDegree createDegree(DiatonicAlt noteBase, int size) {
        int retIndex = noteBase.getDiatonic().ordinal() % size;
        return from(retIndex, size);
    }
}
