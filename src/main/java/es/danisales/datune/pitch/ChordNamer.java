package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;

public class ChordNamer {
    private ChordNamer() {
    }

    public static <N, I extends Interval> String from(ChordCommon<N> chordCommon) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (N n : chordCommon) {
            if (first) {
                first = false;
            } else
                sb.append(", ");
            sb.append(n);
        }

        sb.append(" | root = ");
        sb.append(chordCommon.getRoot());
        sb.append("(");
        sb.append(chordCommon.getRootPos());
        sb.append(")");

        return sb.toString();
    }
}
