package es.danisales.datune.degrees.octave;

import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

class DiatonicAdapter {
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

    public static Diatonic from(DiatonicAlt diatonicAlt, Tonality<DiatonicAlt> ton) throws TonalityException {
        DiatonicDegree pos = (DiatonicDegree)ton.getDegreeFrom(diatonicAlt);
        if (pos == null)
            throw new TonalityException(diatonicAlt, ton);
        else {
            return Diatonic.from(pos);
        }
    }

    public @NonNull Diatonic from(NoteMidi chromaticMidi, Tonality<Chromatic> tonality) throws TonalityException {
        Chromatic chromatic = chromaticMidi.getPitch().getNote();
        DiatonicDegree degree = (DiatonicDegree)tonality.getDegreeFrom( chromatic );
        if (degree == null)
            throw new TonalityException(chromatic, tonality);
        return Diatonic.from( degree );
    }

    public @NonNull Diatonic from(@NonNull PitchChromaticMidi pitchMidi, @NonNull Tonality<Chromatic> tonality) throws ScaleRelativeDegreeException, TonalityException {
        Chromatic chromatic = pitchMidi.getNote();
        DiatonicDegree diatonicDegree = (DiatonicDegree)tonality.getDegreeFrom(chromatic);
        if (diatonicDegree == null)
            throw new TonalityException(chromatic, tonality);
        Chromatic diatonicAlt = tonality.getNote(diatonicDegree);
        return Diatonic.from(diatonicAlt);
    }
}
