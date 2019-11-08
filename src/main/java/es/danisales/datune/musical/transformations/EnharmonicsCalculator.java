package es.danisales.datune.musical.transformations;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

public class EnharmonicsCalculator {
    private EnharmonicsCalculator() {
    }

    public static Set<DiatonicAlt> calculateFrom(DiatonicAlt diatonicAlt, int maxAlterations) {
        checkArgument(maxAlterations > 0);
        
        Chromatic chromatic = Chromatic.from(diatonicAlt);
        return calculateFrom(chromatic, maxAlterations);
    }

    public static Set<DiatonicAlt> calculateFrom(Chromatic chromatic, int maxAlterations) {
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
}
