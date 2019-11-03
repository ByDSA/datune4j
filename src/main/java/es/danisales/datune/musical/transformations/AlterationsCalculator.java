package es.danisales.datune.musical.transformations;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static es.danisales.datune.musical.DiatonicAlt.*;

public class AlterationsCalculator {
    private AlterationsCalculator() {
    }

    public static int from(DiatonicAlt diatonicAlt) {
        int altSigned = diatonicAlt.getAlterations();
        if (altSigned == 0)
            return 0;
        return Math.abs( altSigned );
    }

    @Deprecated
    public static @NonNull Diatonic removeAlterationsFrom(@NonNull DiatonicAlt chromatic) {
        Objects.requireNonNull(chromatic);

        return chromatic.getDiatonic();
    }
}
