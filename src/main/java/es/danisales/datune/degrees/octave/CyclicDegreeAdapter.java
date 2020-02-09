package es.danisales.datune.degrees.octave;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

class CyclicDegreeAdapter {
    private CyclicDegreeAdapter() {
    }

    private static Map<Integer, Function<DiatonicAlt, CyclicDegree>> conversorMap = new HashMap<>();

    static {
        conversorMap.put(5, Pentatonic::from);
        conversorMap.put(7, DiatonicAlt::getDiatonic);
        conversorMap.put(12, Chromatic::from);
    }

    public static CyclicDegree from(DiatonicAlt noteBase, int size) {
        Function<DiatonicAlt, CyclicDegree> f = conversorMap.get(size);
        if (f != null)
            return f.apply(noteBase);

        return createDegree(noteBase, size);
    }

    public static @NonNull CyclicDegree from(int degree, int size) {
        CyclicDegree[] CyclicAbsoluteDegrees = new CyclicDegree[size];

        for (AtomicInteger ai = new AtomicInteger(0); ai.get() < size; ai.incrementAndGet()) {
            CyclicAbsoluteDegrees[ai.get()] = new CyclicDegree() {
                int currentIndex = ai.get();

                @Override
                public int ordinal() {
                    return currentIndex;
                }

                @Override
                public CyclicDegree getNext() {
                    int index = limit(currentIndex+1);
                    return CyclicAbsoluteDegrees[index];
                }

                @Override
                public CyclicDegree getPrevious() {
                    int index = limit(currentIndex-1);
                    return CyclicAbsoluteDegrees[index];
                }

                @Override
                public CyclicDegree getShifted(int i) {
                    if (i > 0) {
                        CyclicDegree self = this;
                        for (int j = 0; j < i; j++)
                            self = self.getNext();
                        return self;
                    } else if (i < 0) {
                        CyclicDegree self = this;
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

    static int getNumber(CyclicDegree CyclicAbsoluteDegreeBase) {
        int i = 0;
        CyclicDegree CyclicAbsoluteDegree = CyclicAbsoluteDegreeBase;
        while (i == 0 || CyclicAbsoluteDegree != CyclicAbsoluteDegreeBase) {
            i++;
            CyclicAbsoluteDegree = CyclicAbsoluteDegree.getNext();
        }
        return i;
    }

    private static CyclicDegree createDegree(DiatonicAlt noteBase, int size) {
        int retIndex = noteBase.getDiatonic().ordinal() % size;
        return from(retIndex, size);
    }
}
