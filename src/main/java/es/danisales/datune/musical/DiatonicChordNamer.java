package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalDiatonic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DiatonicChordNamer {
    private DiatonicChordNamer() {
    }

    public static @NonNull List<IntervalDiatonic> integerNotationFromRootFrom(@NonNull DiatonicChordInterface diatonicChord) {
        List<IntervalDiatonic> distancesAbsolute = new ArrayList<>();
        distancesAbsolute.add( IntervalDiatonic.UNISON );

        for ( int i = 1; i < diatonicChord.size(); i++ ) {
            Diatonic n1 = diatonicChord.get( 0 ).getDiatonic();
            Diatonic n2 = diatonicChord.get( i ).getDiatonic();
            distancesAbsolute.add( n1.dist( n2 ) );
        }

        return distancesAbsolute;
    }
}
