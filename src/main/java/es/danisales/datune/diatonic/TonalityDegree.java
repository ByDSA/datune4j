package es.danisales.datune.diatonic;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface TonalityDegree {
    int val();
    static @NonNull List<TonalityDegree> valuesFrom(int n) {
        if (n == 7)
            return Arrays.asList( DiatonicDegree.values() );
        else {
            List<TonalityDegree> ret = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                AtomicInteger iAtomic = new AtomicInteger(i);
                TonalityDegree tonalityDegree = iAtomic::get;
                ret.add(tonalityDegree);
            }

            return ret;
        }
    }
}
