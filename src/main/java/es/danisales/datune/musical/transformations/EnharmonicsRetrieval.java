package es.danisales.datune.musical.transformations;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import static com.google.common.base.Preconditions.checkArgument;

public class EnharmonicsRetrieval {
    private EnharmonicsRetrieval() {
    }

    public static @NonNull Set<DiatonicAlt> getFromDiatonicAlt(@NonNull DiatonicAlt diatonicAlt, int maxAlterations) {
        checkArgument(maxAlterations >= 0);

        Chromatic chromatic = Chromatic.from(diatonicAlt);
        return getFromChromaticMicro(chromatic, diatonicAlt.getMicrotonalPartAdded(), maxAlterations);
    }

    public static @NonNull Set<DiatonicAlt> getFromChromatic(@NonNull Chromatic chromatic, int maxAlt) {
        return getFromChromaticMicro(chromatic, 0, maxAlt);
    }

    public static @NonNull Set<DiatonicAlt> getFromChromaticMicro(@NonNull Chromatic chromatic, float micro, int maxAlt) {
        checkArgument(maxAlt >= 0);

        Set<DiatonicAlt> ret = new HashSet<>();

        for (float alt = - maxAlt; alt <= maxAlt; alt++)
            for (Diatonic diatonic : Diatonic.values()) {
                DiatonicAlt diatonicAlt = DiatonicAlt.from(chromatic.ordinal() + alt + micro, diatonic);
                Chromatic diatonicAltChromatic = Chromatic.from(diatonicAlt);
                if (diatonicAltChromatic == chromatic && Math.floor(diatonicAlt.getUnsignedAlterations()) <= maxAlt)
                    ret.add(diatonicAlt);
            }

        return ret;
    }

    public static @NonNull DiatonicAlt getMinAlts(@NonNull DiatonicAlt diatonicAlt) {
        Set<DiatonicAlt> set = EnharmonicsRetrieval.getFromDiatonicAlt(diatonicAlt, 1);
        Iterator<DiatonicAlt> iterator = set.iterator();
        final AtomicReference<DiatonicAlt> ret = new AtomicReference<>( diatonicAlt );
        iterator.forEachRemaining((DiatonicAlt d) -> {
            float retuAlts = ret.get().getUnsignedAlterations();
            float duAlts = d.getUnsignedAlterations();
            if (duAlts < retuAlts
                    || duAlts < diatonicAlt.getUnsignedAlterations() && duAlts == retuAlts && d.getAlterations() > ret.get().getAlterations())
                ret.set(d);
        });

        return ret.get();
    }
}
