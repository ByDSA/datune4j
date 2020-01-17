package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class ScaleUtils {
    private ScaleUtils() {
    }

    @SuppressWarnings("WeakerAccess")
    public static String getStringDistancesFrom(@NonNull Scale scale) {
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

    public static boolean hasIntervalFromRoot(@NonNull Scale scale, @NonNull IntervalChromatic intervalChromatic) {
        int intervalChromaticSemitones = intervalChromatic.getSemitones() % Chromatic.NUMBER;
        float sum = 0;
        for (ScaleDistance scaleDistance : scale.getCode()) {
            if (ScaleDistance.compare(sum, intervalChromaticSemitones))
                return true;
            else if (sum > intervalChromaticSemitones)
                return false;
            sum += scaleDistance.getMicrotonalSemitones();
        }

        return false;
    }

    private static class Tuple {
        ScaleDegree relativeDegree;
        int diff;

        Tuple(ScaleDegree relativeDegree, int diff) {
            this.relativeDegree = relativeDegree;
            this.diff = diff;
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static String getMajorScaleAlterationsFrom(@NonNull Scale scale) {
        //checkState(scale.size() <= 7);

        List<Tuple> alterations = new MajorScaleIntegerAlterationGenerator(scale).generate();

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
                sb.append("¿").append(altered).append("?");

            sb.append(alterations.get(i).relativeDegree.ordinal() + 1);
        }

        return sb.toString();
    }

    private static final int[] majorScaleSemitonesSum = new int[]{
            0, 2, 4, 5, 7, 9, 11
    };

    private static class MajorScaleIntegerAlterationGenerator {
        Scale scale;
        int alteredScale;
        List<Tuple> ret;

        MajorScaleIntegerAlterationGenerator(Scale scale) {
            this.scale = scale;
        }

        List<Tuple> generate() {
            ret = new ArrayList<>();
            alteredScale = 0;

            for (int i = 0; i < scale.size(); i++) {
                DiatonicDegree diatonicDegree = scale.degreeGetter()
                        .index(i)
                        .getFirstOfClass(DiatonicDegree.class);

                if (diatonicDegree == null)
                    continue;

                ScaleDistance scaleDistance;
                if (i == 0)
                    scaleDistance = ScaleDistance.NONE;
                else
                    scaleDistance = scaleGetIndex(i - 1);

                makeTupleAndAdd(diatonicDegree, scaleDistance);
            }

            return ret;
        }

        private ScaleDistance scaleGetIndex(int i) {
            Iterator<ScaleDistance> iterator = scale.iterator();
            for (int j = 0; j < i; j++)
                iterator.next();

            return iterator.next();
        }

        void makeTupleAndAdd(DiatonicDegree diatonicDegree, ScaleDistance scaleDistance) {
            alteredScale += scaleDistance.getIntegerSemitones();
            int diff = alteredScale - majorScaleSemitonesSum[diatonicDegree.ordinal()];
            Tuple tuple = new Tuple(diatonicDegree, diff);
            ret.add(tuple);
        }
    }

    public static boolean isMajorOrMinor(@NonNull Scale scale) {
        return scale.equals(Scale.MAJOR) || scale.equals(Scale.MINOR);
    }
}
