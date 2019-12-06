package es.danisales.datune.pitch;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Pentatonic;
import es.danisales.datune.degree.Degree;
import es.danisales.datune.interval.Interval;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class CyclicAbsoluteDegreeAdapter {
    private CyclicAbsoluteDegreeAdapter() {
    }

    private static Map<Integer, Function<DiatonicAlt, CyclicAbsoluteDegree>> conversorMap = new HashMap<>();

    static {
        conversorMap.put(5, Pentatonic::from);
        conversorMap.put(7, DiatonicAlt::getDiatonic);
        conversorMap.put(12, Chromatic::from);
    }

    public static CyclicAbsoluteDegree from(DiatonicAlt noteBase, int size) {
        Function<DiatonicAlt, CyclicAbsoluteDegree> f = conversorMap.get(size);
        if (f != null)
            return f.apply(noteBase);

        return createDegree(noteBase, size);
    }

    public static @NonNull CyclicAbsoluteDegree from(int degree, int size) {
        CyclicAbsoluteDegree[] CyclicAbsoluteDegrees = new CyclicAbsoluteDegree[size];

        for (AtomicInteger ai = new AtomicInteger(0); ai.get() < size; ai.incrementAndGet()) {
            CyclicAbsoluteDegrees[ai.get()] = new CyclicAbsoluteDegree() {
                int currentIndex = ai.get();

                @Override
                public Degree getDegree() {
                    return Degree.getMainDegreesFromScaleSize(size).get(currentIndex);
                }

                @Override
                public CyclicAbsoluteDegree getNext() {
                    int index = limit(currentIndex+1);
                    return CyclicAbsoluteDegrees[index];
                }

                @Override
                public CyclicAbsoluteDegree getPrevious() {
                    int index = limit(currentIndex-1);
                    return CyclicAbsoluteDegrees[index];
                }

                @Override
                public CyclicAbsoluteDegree getShifted(Interval interval) {
                    CyclicAbsoluteDegree self = this;
                    for (int i = 0; i < interval.ordinal(); i++)
                        self = self.getNext();
                    return self;
                }

                @Override
                public CyclicAbsoluteDegree getShiftedNegative(Interval interval) {
                    CyclicAbsoluteDegree self = this;
                    for (int i = 0; i < interval.ordinal(); i++)
                        self = self.getPrevious();
                    return self;
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

    public static int getNumber(CyclicAbsoluteDegree CyclicAbsoluteDegreeBase) {
        int i = 0;
        CyclicAbsoluteDegree CyclicAbsoluteDegree = CyclicAbsoluteDegreeBase;
        while (i == 0 || CyclicAbsoluteDegree != CyclicAbsoluteDegreeBase) {
            i++;
            CyclicAbsoluteDegree = CyclicAbsoluteDegree.getNext();
        }
        return i;
    }

    private static CyclicAbsoluteDegree createDegree(DiatonicAlt noteBase, int size) {
        int retIndex = noteBase.getDiatonic().ordinal() % size;
        return from(retIndex, size);
    }
}
