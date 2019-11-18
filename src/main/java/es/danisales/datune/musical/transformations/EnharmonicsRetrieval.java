package es.danisales.datune.musical.transformations;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import static com.google.common.base.Preconditions.checkArgument;

public class EnharmonicsRetrieval {
    private EnharmonicsRetrieval() {
    }

    public static @NonNull Set<DiatonicAlt> getAllFrom(@NonNull DiatonicAlt diatonicAlt, int maxAlterations) {
        checkArgument(maxAlterations > 0);
        
        Chromatic chromatic = Chromatic.from(diatonicAlt);
        return getAllFrom(chromatic, maxAlterations);
    }

    public static @NonNull Set<DiatonicAlt> getAllFrom(@NonNull Chromatic chromatic, int maxAlterations) {
        checkArgument(maxAlterations > 0);

        Set<DiatonicAlt> tmp = new HashSet<>();

        for (int alt = - maxAlterations; alt <= maxAlterations; alt++)
            for (Diatonic diatonic : Diatonic.values()) {
                DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, alt);
                Chromatic diatonicAltChromatic = Chromatic.from(diatonicAlt);
                if (diatonicAltChromatic == chromatic)
                    tmp.add(diatonicAlt);
            }

        return tmp;
    }

    public static @NonNull DiatonicAlt getMinAlts(@NonNull DiatonicAlt diatonicAlt) {
        Set<DiatonicAlt> set = EnharmonicsRetrieval.getAllFrom(diatonicAlt, 1);
        Iterator<DiatonicAlt> iterator = set.iterator();
        final AtomicReference<DiatonicAlt> ret = new AtomicReference<>( iterator.next() );
        iterator.forEachRemaining((DiatonicAlt d) -> {
            if (d.getAlterations() < ret.get().getAlterations())
                ret.set(d);
        });

        return DiatonicAlt.from(ret.get().getDiatonic(),
                ret.get().getMicrotonalSemitonesAdded() + MathUtils.decimalPart(diatonicAlt.getMicrotonalSemitonesAdded()));
    }
}
