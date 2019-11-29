package es.danisales.datune.tonality;

import es.danisales.datune.degree.DiatonicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

public class ScaleUtils {
    private ScaleUtils() {
    }

    @SuppressWarnings("WeakerAccess")
    public static String getDistancesFrom(@NonNull Scale scale) {
        StringBuilder sb = new StringBuilder();

        boolean first = true;
        for (ScaleDistance scaleDistance : scale.getCode()) {
            if (first)
                first = false;
            else
                sb.append("-");
            sb.append(scaleDistance);
        }

        return sb.toString();
    }

    private static class Tuple {
        DiatonicDegree diatonicDegree;
        int diff;

        Tuple(DiatonicDegree diatonicDegree, int diff) {
            this.diatonicDegree = diatonicDegree;
            this.diff = diff;
        }
    }

    public static String getMajorScaleAlterationsFrom(@NonNull Scale scale) {
        checkState(scale.size() <= 7);

        List<Tuple> alterations = getMajorScaleIntegerAlterationsFrom(scale);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alterations.size(); i++) {
            if (i > 0)
                sb.append("-");

            int altered = alterations.get(i).diff;
            if (altered == -1)
                sb.append("b");
            else if (altered == -2)
                sb.append("bb");
            else if (altered == 1)
                sb.append("#");
            else if (altered != 0)
                sb.append("?");

            sb.append(alterations.get(i).diatonicDegree.ordinal() + 1);
        }

        return sb.toString();
    }

    private static final int[] majorScale = new int[]{
            0, 2, 4, 5, 7, 9, 11
    };

    private static @NonNull List<Tuple> getMajorScaleIntegerAlterationsFrom(@NonNull Scale scale) {
        List<Tuple> ret = new ArrayList<>();
        int alteredScale = 0;

        for (DiatonicDegree diatonicDegree : DiatonicDegree.values()) {
            ScaleDistance scaleDistance = scale.get(diatonicDegree);
            if (scaleDistance == null)
                continue;
            alteredScale += scaleDistance.getSemitones();
            int diff = alteredScale - majorScale[diatonicDegree.ordinal()];
            Tuple tuple = new Tuple(diatonicDegree, diff);
            ret.add(tuple);
        }

        return ret;
    }
}
