package es.danisales.datune.tonality;

import com.google.common.base.Preconditions;
import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

class ScaleAdapter {
    private ScaleAdapter() {
    }

    static @NonNull Scale fromDiatonicAltList(@NonNull List<DiatonicAlt> notes) {
        List<Integer> ton = new ArrayList<>();
        int sum = 0;
        for ( int i = 0; i < notes.size() - 1; i++ ) {
            DiatonicAlt current = notes.get(i);
            Chromatic currentChromatic = Chromatic.from(current);
            DiatonicAlt next = notes.get(i + 1);
            Chromatic nextChromatic = Chromatic.from(next);

            int newInt = currentChromatic.distSemitonesTo(nextChromatic);
            ton.add(newInt);

            sum += newInt;
            if (sum >= Chromatic.NUMBER)
                break;
        }

        if (sum >= Chromatic.NUMBER) {
            notes = getSorted(notes);
            return fromDiatonicAltList(notes);
        }
        ton.add(Chromatic.NUMBER - sum);

        return Scale.fromIntegers(ton);
    }

    private static List<DiatonicAlt> getWithRemovedDuplicates(List<DiatonicAlt> list) {
        Set<DiatonicAlt> set = new LinkedHashSet<>(list);
        Set<Chromatic> added = new LinkedHashSet<>();
        List<DiatonicAlt> ret = new ArrayList<>();
        for (DiatonicAlt diatonicAlt : set) {
            Chromatic chromatic = Chromatic.from(diatonicAlt);
            if (!added.contains(chromatic)) {
                ret.add(diatonicAlt);
                added.add(chromatic);
            }
        }
        return ret;
    }

    private static List<DiatonicAlt> getSorted(@NonNull List<DiatonicAlt> list) {
        list = getWithRemovedDuplicates(list);
        DiatonicAlt prevFirst = list.get(0);

        list.sort(Comparator.comparing(Chromatic::from));

        int rotationIndex = list.indexOf(prevFirst);
        Collections.rotate(list, -rotationIndex);

        Preconditions.checkState(prevFirst == list.get(0), "Expected: " + prevFirst + " Actual: " + list.get(0));

        return list;
    }

    static @NonNull ScaleInner fromIntegers(List<Integer> v) {
        List<ScaleDistance> distanceScaleList = getScaleDistanceListFromIntegersList(v);

        return fromScaleDistanceList(distanceScaleList);
    }

    private static @NonNull ScaleInner fromScaleDistanceList(List<ScaleDistance> scaleDistanceList) {
        ScaleInner scaleInterface = ScaleInnerImmutable.from(scaleDistanceList);
        if (scaleInterface == null)
            scaleInterface = new ScaleInnerMutable(scaleDistanceList);

        return scaleInterface;
    }

    private static List<ScaleDistance> getScaleDistanceListFromIntegersList(List<Integer> v) {
        List<ScaleDistance> distanceScaleList = new ArrayList<>();
        for (int i : v) {
            ScaleDistance scaleDistance = ScaleDistance.from(i);
            distanceScaleList.add(scaleDistance);
        }

        return distanceScaleList;
    }
}
