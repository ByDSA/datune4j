package es.danisales.datune.musical.transformations;

import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class AlterationsCalculator {
    private AlterationsCalculator() {
    }

    @Deprecated
    public static @NonNull Diatonic removeAlterationsFrom(@NonNull DiatonicAlt chromatic) {
        Objects.requireNonNull(chromatic);

        return chromatic.getDiatonic();
    }
}
