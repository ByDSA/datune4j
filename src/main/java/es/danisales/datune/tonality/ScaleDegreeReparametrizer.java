package es.danisales.datune.tonality;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.degree.RelativeDegree;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;

public class ScaleDegreeReparametrizer implements Cloneable {
    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparametrizer PENTATONIC = new ScaleDegreeReparametrizer(
            new ImmutableMultimap.Builder<Integer, RelativeDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.II)
                    .put(2, DiatonicDegree.III)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.VI)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparametrizer PENTATONIC_MINOR = new ScaleDegreeReparametrizer(
            new ImmutableMultimap.Builder<Integer, RelativeDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.III)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.VII)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparametrizer EGYPTIAN = new ScaleDegreeReparametrizer(
            new ImmutableMultimap.Builder<Integer, RelativeDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.II)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.VII)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparametrizer BLUE_MINOR = new ScaleDegreeReparametrizer(
            new ImmutableMultimap.Builder<Integer, RelativeDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.III)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.VI)
                    .put(4, DiatonicDegree.VII)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparametrizer BLUE_MAJOR = new ScaleDegreeReparametrizer(
            new ImmutableMultimap.Builder<Integer, RelativeDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.II)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.VI)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparametrizer WHOLE_NOTE = new ScaleDegreeReparametrizer(
            new ImmutableMultimap.Builder<Integer, RelativeDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.II)
                    .put(2, DiatonicDegree.III)
                    .put(3, DiatonicDegree.IV)
                    .put(4, DiatonicDegree.V)
                    .put(5, DiatonicDegree.VI)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparametrizer CHROMATIC = new ScaleDegreeReparametrizer(
            new ImmutableMultimap.Builder<Integer, RelativeDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.I)
                    .put(2, DiatonicDegree.II)
                    .put(3, DiatonicDegree.II)
                    .put(4, DiatonicDegree.III)
                    .put(5, DiatonicDegree.IV)
                    .put(6, DiatonicDegree.IV)
                    .put(7, DiatonicDegree.V)
                    .put(8, DiatonicDegree.V)
                    .put(9, DiatonicDegree.VI)
                    .put(10, DiatonicDegree.VI)
                    .put(11, DiatonicDegree.VII)
                    .build()
    );

    private Multimap<Integer, RelativeDegree> multimap;
    private final boolean fixed;

    private ScaleDegreeReparametrizer(Multimap<Integer, RelativeDegree> map) {
        multimap = ArrayListMultimap.create();
        multimap.putAll(map);
        fixed = true;
    }

    private ScaleDegreeReparametrizer() {
        multimap = ArrayListMultimap.create();
        fixed = false;
    }

    public static ScaleDegreeReparametrizer create() {
        return new ScaleDegreeReparametrizer();
    }

    private void checkFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    public void put(RelativeDegree relativeDegree, int n) {
        checkFixed();
        multimap.put(n, relativeDegree);
    }

    public void put(int n, RelativeDegree relativeDegree) {
        put(relativeDegree, n);
    }

    @SuppressWarnings("WeakerAccess")
    public @Nullable RelativeDegree getByIndex(int n) {
        return multimap.get(n).iterator().next();
    }

    @SuppressWarnings("WeakerAccess")
    public @Nullable Integer getByKey(@NonNull RelativeDegree relativeDegree) {
        for (Map.Entry<Integer, RelativeDegree> entry : multimap.entries())
            if (entry.getValue() == relativeDegree)
                return entry.getKey();
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ScaleDegreeReparametrizer))
            return false;

        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = (ScaleDegreeReparametrizer) o;

        return multimap.equals(scaleDiatonicReparametrizer.multimap);
    }

    @Override
    public int hashCode() {
        return multimap.hashCode();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public ScaleDegreeReparametrizer clone() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = create();
        scaleDiatonicReparametrizer.multimap.putAll(multimap);
        return scaleDiatonicReparametrizer;
    }
}
