package es.danisales.datune.tonality;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

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
            ton[i] = Chromatic.from(current).distSemitonesTo(nextChromatic);
            while ( ton[i] < 0 )
                ton[i] += Chromatic.NUMBER;
            sum += ton[i];
        }
        int dif = Chromatic.NUMBER - sum;
        checkArgument(dif > 0);
        ton[notes.size() - 1] = dif;

        return Scale.fromIntegers( ton );
    }

    static @NonNull ScaleInterface fromIntegers(int... v) {
        List<ScaleDistance> distanceScaleList = new ArrayList<>();
        for (int i : v)
            distanceScaleList.add( ScaleDistance.from(i) );

        ScaleInterface s = ScaleEnum.of( distanceScaleList );
        if (s == null)
            s = new ScaleCustom( distanceScaleList );

        return s;
    }
}
