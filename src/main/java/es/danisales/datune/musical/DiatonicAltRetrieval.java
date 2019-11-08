package es.danisales.datune.musical;

import es.danisales.datune.musical.transformations.EnharmonicsCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DiatonicAltRetrieval {
    private DiatonicAltRetrieval() {
    }

    public static List<DiatonicAlt> listFromAlterations(int alts) {
        List<DiatonicAlt> ret = new ArrayList<>();
        for (int i = -alts; i <= alts; i++)
            for (Diatonic diatonic : Diatonic.values()) {
                DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, i);
                ret.add(diatonicAlt);
            }

        return ret;
    }

    public static boolean areEnharmonic(DiatonicAlt diatonicAlt1, DiatonicAlt diatonicAlt2) {
        Chromatic chromatic1 = Chromatic.from(diatonicAlt1);
        Chromatic chromatic2 = Chromatic.from(diatonicAlt2);
        return chromatic1 == chromatic2;
    }


    public static Set<DiatonicAlt> getEnharmonicsFrom(DiatonicAlt diatonicAlt, int maxAlterations) {
        return EnharmonicsCalculator.calculateFrom(diatonicAlt, maxAlterations);
    }
}
