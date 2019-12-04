package es.danisales.datune.tonality;

import es.danisales.datune.degree.Degree;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Set;

public class ScaleDegreeGetter {
    private Scale scale;
    private int index = -1;

    ScaleDegreeGetter(Scale scale) {
        this.scale = scale;
    }

    public ScaleDegreeGetter index(int i) {
        index = i;

        return this;
    }

    public @NonNull Set<Degree> get() {
        return scale.innerScale.getRelativeDegreeByIndex(index);
    }

    @SuppressWarnings({"unchecked", "WeakerAccess"})
    public <T extends Degree> @Nullable T getFirstOfClass(Class<T> tClass) {
        for (Degree relativeDegree : get())
            if (tClass.isInstance(relativeDegree))
                return (T) relativeDegree;

        return null;
    }
}
