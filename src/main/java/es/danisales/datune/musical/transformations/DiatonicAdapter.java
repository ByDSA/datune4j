package es.danisales.datune.musical.transformations;

import com.sun.javafx.geom.transform.BaseTransform;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import static es.danisales.datune.musical.DiatonicAlt.*;

public class DiatonicAdapter {
    private DiatonicAdapter() {
    }

    public static Diatonic from(DiatonicDegree d) {
        return from( d.val() );
    }

    public static Diatonic from(int n) {
        n = delimit(n);

        switch ( n ) {
            case 0:
                return Diatonic.C;
            case 1:
                return Diatonic.D;
            case 2:
                return Diatonic.E;
            case 3:
                return Diatonic.F;
            case 4:
                return Diatonic.G;
            case 5:
                return Diatonic.A;
            case 6:
                return Diatonic.B;
        }

        return null;
    }

    private static int delimit(int n) {
        n %= Diatonic.N;
        while ( n < 0 )
            n += Diatonic.N;

        return n;
    }

    public static @NonNull Diatonic from(@NonNull DiatonicAlt diatonicAlt) {
        return diatonicAlt.getDiatonic();
    }

    public static Diatonic from(DiatonicAlt diatonicAlt, Tonality ton) {
        DiatonicDegree pos = ton.getDegreeFrom(diatonicAlt);
        if (pos == null)
            throw new TonalityException(diatonicAlt, ton);
        else {
            return Diatonic.from(pos);
        }
    }

    public Diatonic from(ChromaticMidi chromaticMidi, Tonality tonality) throws TonalityException {
        Chromatic chromatic = ChromaticAdapter.from(chromaticMidi);
        DiatonicDegree degree = tonality.getDegreeFrom( chromatic );
        return Diatonic.from( degree );
    }

    public @Nullable Diatonic from(@NonNull PitchMidi pitchMidi, @NonNull Tonality tonality) {
        Chromatic chromatic = pitchMidi.getChromatic();
        DiatonicDegree diatonicDegree = tonality.getDegreeFrom(chromatic);
        if (diatonicDegree == null)
            return null;
        DiatonicAlt diatonicAlt = tonality.get(diatonicDegree);
        return diatonicAlt.getDiatonic();
    }

    public Diatonic from(DiatonicMidi diatonicMidi) {
        return Diatonic.from( diatonicMidi.getDegree() );
    }
}
