package es.danisales.datune.musical.transformations;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class EnharmonicsCalculator {
    private EnharmonicsCalculator() {
    }

    public static List<DiatonicAlt> calculateFrom(DiatonicAlt diatonicAlt, int maxAlterations) {
        checkArgument(maxAlterations > 0);
        
        Chromatic chromatic = Chromatic.from(diatonicAlt);
        return calculateFrom(chromatic, maxAlterations);
    }

    public static List<DiatonicAlt> calculateFrom(Chromatic chromatic, int maxAlterations) {
        checkArgument(maxAlterations > 0);

        List<DiatonicAlt> tmp = new ArrayList<>();

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
