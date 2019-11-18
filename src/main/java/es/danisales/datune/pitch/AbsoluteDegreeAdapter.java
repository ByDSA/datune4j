package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.Pentatonic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class AbsoluteDegreeAdapter {
    private AbsoluteDegreeAdapter() {
    }

    static Map<Integer, Function<DiatonicAlt, AbsoluteDegree>> conversorMap = new HashMap<>();

    static {
        conversorMap.put(5, Pentatonic::from);
        conversorMap.put(7, Diatonic::from);
        conversorMap.put(12, Chromatic::from);
    }

    public static AbsoluteDegree from(DiatonicAlt noteBase, int size) {
        Function<DiatonicAlt, AbsoluteDegree> f = conversorMap.get(size);
        if (f != null)
            return f.apply(noteBase);

        return createDegree(noteBase, size);
    }

    public static @NonNull AbsoluteDegree from(int degree, int size) {
        AbsoluteDegree[] absoluteDegrees = new AbsoluteDegree[size];

        for (AtomicInteger ai = new AtomicInteger(0); ai.get() < size; ai.incrementAndGet()) {
            absoluteDegrees[ai.get()] = new AbsoluteDegree() {
                int currentIndex = ai.get();

                @Override
                public RelativeDegree getDegree() {
                    return () -> currentIndex;
                }

                @Override
                public AbsoluteDegree getNext() {
                    int index = limit(currentIndex+1);
                    return absoluteDegrees[index];
                }

                @Override
                public AbsoluteDegree getPrevious() {
                    int index = limit(currentIndex-1);
                    return absoluteDegrees[index];
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

        return absoluteDegrees[degree];
    }

    public static int getNumber(AbsoluteDegree absoluteDegreeBase) {
        int i = 0;
        AbsoluteDegree absoluteDegree = absoluteDegreeBase;
        while (i == 0 || absoluteDegree != absoluteDegreeBase) {
            i++;
            absoluteDegree = absoluteDegree.getNext();
        }
        return i;
    }

    static AbsoluteDegree createDegree(DiatonicAlt noteBase, int size) {
        int retIndex = noteBase.getDiatonic().ordinal() % size;
        return from(retIndex, size);
    }
}
