package diatonic;

public enum IntervalDiatonic {
    UNISON(0), SECOND(1), THIRD(2), FOURTH(3), FIFTH(4), SIXTH(5), SEVENTH(6),
    OCTAVE(7), NINTH(8), TENTH(9), ELEVENTH(10), TWELFTH(11), THIRTEENTH(12), FOURTEENTH(13),
    FIFTEENTH(14);

    public static final IntervalDiatonic[] INTERVALS = new IntervalDiatonic[] {
        UNISON, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH,
        OCTAVE, NINTH, TENTH, ELEVENTH, TWELFTH, THIRTEENTH, FOURTEENTH, FIFTEENTH
    };

    private final int value;

    private IntervalDiatonic(
        int value) {
        this.value = value;
    }

    public int val() {
        return value;
    }

    public static IntervalDiatonic get(int n) {
    	n = n < 0 ? -n : n;
    	
        switch (n) {
            case 0:
                return UNISON;
            case 1:
                return SECOND;
            case 2:
                return THIRD;
            case 3:
                return FOURTH;
            case 4:
                return FIFTH;
            case 5:
                return SIXTH;
            case 6:
                return SEVENTH;
            case 7:
                return OCTAVE;
            case 8:
                return NINTH;
            case 9:
                return TENTH;
            case 10:
                return ELEVENTH;
            case 11:
                return TWELFTH;
            case 12:
                return THIRTEENTH;
            case 13:
                return FOURTEENTH;
            case 14:
                return FIFTEENTH;
            default:
                return null;
        }
    }

    public static IntervalDiatonic get(Degree d) {
        switch (d) {
            case I:
                return UNISON;
            case II:
                return SECOND;
            case III:
                return THIRD;
            case IV:
                return FOURTH;
            case V:
                return FIFTH;
            case VI:
                return SIXTH;
            case VII:
                return SEVENTH;
            default:
                return null;
        }
    }

    public String toString() {
        switch (this) {
            case UNISON:
                return "Unísono";
            case SECOND:
                return "Segunda";
            case THIRD:
                return "Tercera";
            case FOURTH:
                return "Cuarta";
            case FIFTH:
                return "Quinta";
            case SIXTH:
                return "Sexta";
            case SEVENTH:
                return "Séptima";
            case OCTAVE:
                return "Octava";
            case NINTH:
                return "Novena";
            case TENTH:
                return "Décima";
            case ELEVENTH:
                return "Onceava";
            case TWELFTH:
                return "Doceava";
            case THIRTEENTH:
                return "Treceava";
            case FOURTEENTH:
                return "Catorceava";
            case FIFTEENTH:
                return "Quinceava";
        }

        return null;
    }
}
