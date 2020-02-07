package es.danisales.datune.chords.diatonicalt;

import es.danisales.datune.lang.Nominator;

public class DiatonicAltRelative {
    private final int diatonicNumber;
    private final int alts;

    @SuppressWarnings("WeakerAccess")
    public int getDiatonicNumber() {
        return diatonicNumber;
    }

    private DiatonicAltRelative(int diatonicNumber, int alts) {
        this.diatonicNumber = diatonicNumber;
        this.alts = alts;
    }

    public static DiatonicAltRelative from(int diatonicNumber, int alts) {
        return new DiatonicAltRelative(diatonicNumber, alts);
    }

    public static DiatonicAltRelative from(int diatonicNumber) {
        return from(diatonicNumber, 0);
    }

    @Override
    public String toString() {
        return Nominator.alt(alts) + diatonicNumber;
    }
}
