package es.danisales.datune.degree;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface RelativeDegree {
    int ordinal();
    static @NonNull List<RelativeDegree> valuesFrom(int n) {
        switch (n) {
            case 5: return Collections.unmodifiableList(
                    Arrays.asList( PentatonicDegree.values() )
            );
            case 7: return Collections.unmodifiableList(
                    Arrays.asList( DiatonicDegree.values() )
            );
            case 12: return Collections.unmodifiableList(
                    Arrays.asList( ChromaticDegree.values() )
            );
            default:
                List<RelativeDegree> ret = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    AtomicInteger iAtomic = new AtomicInteger(i);
                    RelativeDegree tonalityDegree = iAtomic::get;
                    ret.add(tonalityDegree);
                }

                return ret;
        }
    }
}
