package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;

public class ChordNamer {
    private ChordNamer() {
    }

    public static <N extends AbsoluteDegree<D, I>, D extends RelativeDegree, I extends Interval> String from(ChordCommon<N, D, I> chordCommon){
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for ( N n : chordCommon ) {
                if ( first ) {
                    first = false;
                } else
                    sb.append( ", " );
                sb.append( n );
            }

            sb.append(" | rootIndex = ");
            sb.append(chordCommon.getRoot());
            sb.append("(");
            sb.append(chordCommon.getRootPos());
            sb.append(")");

            return sb.toString();
    }
}
