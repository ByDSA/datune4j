package es.danisales.datune.degree;

import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class DegreeAdapter {
    private DegreeAdapter() {
    }

    private static final Map<Integer, List<Degree>> map = new HashMap<>();

    static {
        map.put(5,
                ImmutableList.copyOf(PentatonicDegree.values())
        );

        map.put(7,
                ImmutableList.copyOf(DiatonicDegree.values())
        );

        map.put(12,
                ImmutableList.copyOf(ChromaticDegree.values())
        );
    }

    static List<Degree> getValuesFromScaleSizeDefault(int n) {
        List<Degree> cachedList = map.get(n);
        if (cachedList != null)
            return cachedList;

        final List<Degree> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            AtomicInteger iAtomic = new AtomicInteger(i);
            Degree tonalityDegree = new Degree() {
                @Override
                public int ordinal() {
                    return iAtomic.get();
                }

                @NonNull
                @Override
                public Degree getPrevious() {
                    int index = ordinal() - 1;
                    if (index < 0)
                        index += ret.size();
                    return ret.get(index);
                }

                @NonNull
                @Override
                public Degree getNext() {
                    int index = ordinal() + 1;
                    index %= ret.size();
                    return ret.get(index);
                }
            };
            ret.add(tonalityDegree);
        }

        return putAsImmutableAndReturn(n, ret);
    }

    private static List<Degree> putAsImmutableAndReturn(int n, List<Degree> list) {
        List<Degree> ret2 = ImmutableList.copyOf(list);
        map.put(n, ret2);

        return ret2;
    }
}
