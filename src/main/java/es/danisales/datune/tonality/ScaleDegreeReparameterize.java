package es.danisales.datune.tonality;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.degrees.scale.PentatonicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;
import java.util.Set;

public class ScaleDegreeReparameterize implements Cloneable {
    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize PENTATONIC = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.II)
                    .put(2, DiatonicDegree.III)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.VI)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize PENTATONIC_MINOR = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.III)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.VII)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize EGYPTIAN = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.II)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.VII)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize BLUE_MINOR = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.III)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.VI)
                    .put(4, DiatonicDegree.VII)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize BLUES_b5 = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.III)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.V)
                    .put(5, DiatonicDegree.VII)

                    .put(0, PentatonicDegree.I)
                    .put(1, PentatonicDegree.II)
                    .put(2, PentatonicDegree.III)
                    .put(3, PentatonicDegree.IV)
                    .put(4, PentatonicDegree.IV)
                    .put(5, PentatonicDegree.V)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize BLUES_a4 = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.III)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.IV)
                    .put(4, DiatonicDegree.V)
                    .put(5, DiatonicDegree.VII)

                    .put(0, PentatonicDegree.I)
                    .put(1, PentatonicDegree.II)
                    .put(2, PentatonicDegree.III)
                    .put(3, PentatonicDegree.III)
                    .put(4, PentatonicDegree.IV)
                    .put(5, PentatonicDegree.V)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize BLUE_MAJOR = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.II)
                    .put(2, DiatonicDegree.IV)
                    .put(3, DiatonicDegree.V)
                    .put(4, DiatonicDegree.VI)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize WHOLE_NOTE = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
                    .put(0, DiatonicDegree.I)
                    .put(1, DiatonicDegree.II)
                    .put(2, DiatonicDegree.III)
                    .put(3, DiatonicDegree.IV)
                    .put(4, DiatonicDegree.V)
                    .put(5, DiatonicDegree.VI)
                    .build()
    );

    @SuppressWarnings("WeakerAccess")
    public static final ScaleDegreeReparameterize CHROMATIC = new ScaleDegreeReparameterize(
            new ImmutableMultimap.Builder<Integer, ScaleDegree>()
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

    private Multimap<Integer, ScaleDegree> multimap;
    private final boolean fixed;

    private ScaleDegreeReparameterize(Multimap<Integer, ScaleDegree> map) {
        multimap = ArrayListMultimap.create();
        multimap.putAll(map);
        fixed = true;
    }

    private ScaleDegreeReparameterize() {
        multimap = ArrayListMultimap.create();
        fixed = false;
    }

    public static ScaleDegreeReparameterize create() {
        return new ScaleDegreeReparameterize();
    }

    private void checkFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    public void put(ScaleDegree relativeDegree, int n) {
        checkFixed();
        multimap.put(n, relativeDegree);
    }

    public void put(int n, ScaleDegree relativeDegree) {
        put(relativeDegree, n);
    }

    @SuppressWarnings("WeakerAccess")
    public @Nullable Set<ScaleDegree> getByIndex(int n) {
        return ImmutableSet.copyOf(multimap.get(n));
    }

    @SuppressWarnings("WeakerAccess")
    public @Nullable Integer getByKey(@NonNull ScaleDegree relativeDegree) {
        for (Map.Entry<Integer, ScaleDegree> entry : multimap.entries())
            if (entry.getValue() == relativeDegree)
                return entry.getKey();
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ScaleDegreeReparameterize))
            return false;

        ScaleDegreeReparameterize scaleDiatonicReparametrizer = (ScaleDegreeReparameterize) o;

        return multimap.equals(scaleDiatonicReparametrizer.multimap);
    }

    @Override
    public int hashCode() {
        return multimap.hashCode();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public ScaleDegreeReparameterize clone() {
        ScaleDegreeReparameterize scaleDiatonicReparametrizer = create();
        scaleDiatonicReparametrizer.multimap.putAll(multimap);
        return scaleDiatonicReparametrizer;
    }
}
