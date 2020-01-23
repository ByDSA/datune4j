package es.danisales.datune.degrees.scale;

import com.google.common.collect.ImmutableList;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class DegreeAdapter {
    private DegreeAdapter() {
    }

    private static final Map<Integer, List<ScaleDegree>> number2DegreeListMap = new HashMap<>();

    static {
        number2DegreeListMap.put(5,
                ImmutableList.copyOf(PentatonicDegree.values())
        );

        number2DegreeListMap.put(7,
                ImmutableList.copyOf(DiatonicDegree.values())
        );

        number2DegreeListMap.put(12,
                ImmutableList.copyOf(ChromaticDegree.values())
        );
    }

    static List<ScaleDegree> getValuesFromScaleSizeDefault(int n) {
        List<ScaleDegree> cachedList = number2DegreeListMap.get(n);
        if (cachedList != null)
            return cachedList;

        final List<ScaleDegree> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            AtomicInteger iAtomic = new AtomicInteger(i);
            ScaleDegree tonalityDegree = new ScaleDegree() {
                @Override
                public int ordinal() {
                    return iAtomic.get();
                }

                @NonNull
                @Override
                public ScaleDegree getPrevious() {
                    int index = ordinal() - 1;
                    if (index < 0)
                        index += ret.size();
                    return ret.get(index);
                }

                @Override
                public CyclicDegree getShifted(int i) {
                    i = MathUtils.rotativeTrim(i, n);
                    return ret.get(i);
                }

                @NonNull
                @Override
                public ScaleDegree getNext() {
                    int index = ordinal() + 1;
                    index %= ret.size();
                    return ret.get(index);
                }
            };
            ret.add(tonalityDegree);
        }

        return putAsImmutableAndReturn(n, ret);
    }

    private static List<ScaleDegree> putAsImmutableAndReturn(int n, List<ScaleDegree> list) {
        List<ScaleDegree> ret2 = ImmutableList.copyOf(list);
        number2DegreeListMap.put(n, ret2);

        return ret2;
    }
}
