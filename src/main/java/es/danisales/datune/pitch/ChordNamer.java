package es.danisales.datune.pitch;

public class ChordNamer {
    private ChordNamer() {
    }

    public static <N extends SymbolicPitch> String from(ChordCommon<N> chordCommon) {
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
        sb.append(chordCommon.getRootIndex());
        sb.append(")");

        return sb.toString();
    }
}
