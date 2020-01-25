package es.danisales.datune.chords.diatonicalt;

import es.danisales.datune.lang.Namer;

public class DiatonicAltRelative {
    private final int diatonicNumber;
    private final int alts;

    public int getDiatonicNumber() {
        return diatonicNumber;
    }

    public int getAlts() {
        return alts;
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
        return Namer.alt(alts) + diatonicNumber;
    }
}
