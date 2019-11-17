package es.danisales.datune.tonality;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

class ScaleAdapter {
    private ScaleAdapter() {
    }

    static @NonNull Scale fromDiatonicAltList(@NonNull List<DiatonicAlt> notes) {
        int[] ton = new int[notes.size()];
        int sum = 0;
        for ( int i = 0; i < notes.size() - 1; i++ ) {
            DiatonicAlt current = notes.get(i);
            DiatonicAlt next = notes.get(i + 1);
            Chromatic nextChromatic = Chromatic.from(next);
            Chromatic currentChromatic = Chromatic.from(current);

            ton[i] = currentChromatic.distSemitonesTo(nextChromatic);
            while ( ton[i] < 0 )
                ton[i] += Chromatic.NUMBER;
            sum += ton[i];
        }
        int dif = Chromatic.NUMBER - sum;
        if (dif <= 0) {
            notes = sort(notes);
            return fromDiatonicAltList(notes);
        }
        ton[notes.size() - 1] = dif;

        return Scale.from( ton );
    }

    private static @NonNull List<DiatonicAlt> sort(@NonNull List<DiatonicAlt> list) {
        Set<DiatonicAlt> diatonicAltSet = new HashSet<>(list);

        List<DiatonicAlt> ret = new ArrayList<>(diatonicAltSet);

        ret.sort(Comparator.comparing(Chromatic::from));

        while (!ret.get(0).equals(list.get(0)))
            Collections.rotate(ret,1);

        return ret;
    }

    static @NonNull ScaleInterface fromIntegers(int... v) {
        List<ScaleDistance> distanceScaleList = new ArrayList<>();
        for (int i : v)
            distanceScaleList.add( ScaleDistance.from(i) );

        ScaleInterface s = ScaleEnum.from( distanceScaleList );
        if (s == null)
            s = new ScaleCustom( distanceScaleList );

        return s;
    }
}
