package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

public class DiatonicAdapter {
    private DiatonicAdapter() {
    }

    public static Diatonic from(DiatonicDegree d) {
        return from( d.ordinal() );
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
        n %= Diatonic.NUMBER;
        while ( n < 0 )
            n += Diatonic.NUMBER;

        return n;
    }

    public static @NonNull Diatonic from(@NonNull DiatonicAlt diatonicAlt) {
        return diatonicAlt.getDiatonic();
    }

    public static Diatonic from(DiatonicAlt diatonicAlt, Tonality ton) throws TonalityException {
        DiatonicDegree pos = (DiatonicDegree)ton.getDegreeFrom(diatonicAlt);
        if (pos == null)
            throw new TonalityException(diatonicAlt, ton);
        else {
            return Diatonic.from(pos);
        }
    }

    public Diatonic from(ChromaticMidi chromaticMidi, Tonality tonality) throws TonalityException {
        Chromatic chromatic = Chromatic.from(chromaticMidi);
        DiatonicDegree degree = (DiatonicDegree)tonality.getDegreeFrom( chromatic );
        return Diatonic.from( degree );
    }

    public @NonNull Diatonic from(@NonNull PitchChromaticMidi pitchMidi, @NonNull Tonality tonality) throws TonalityException {
        Chromatic chromatic = pitchMidi.getChromatic();
        DiatonicDegree diatonicDegree = (DiatonicDegree)tonality.getDegreeFrom(chromatic);
        DiatonicAlt diatonicAlt = tonality.getNote(diatonicDegree);
        return diatonicAlt.getDiatonic();
    }

    public Diatonic from(DiatonicMidi diatonicMidi) {
        RelativeDegree relativeDegree = diatonicMidi.getPitch().getDegree();
        if (relativeDegree instanceof DiatonicDegree)
            return Diatonic.from((DiatonicDegree) relativeDegree);
        else
            return null;
    }
}
