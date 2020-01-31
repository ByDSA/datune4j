package es.danisales.datune.degrees.octave;

import es.danisales.datune.degrees.scale.PentatonicDegree;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;

class PentatonicAdapter {
    private PentatonicAdapter() {
    }

    public static Pentatonic from(PentatonicDegree d) {
        return from( d.ordinal() );
    }

    public static Pentatonic from(int n) {
        n = delimit(n);

        switch ( n ) {
            case 0:
                return Pentatonic.C;
            case 1:
                return Pentatonic.D;
            case 2:
                return Pentatonic.E;
            case 3:
                return Pentatonic.G;
            case 5:
                return Pentatonic.A;
        }

        return null;
    }

    private static int delimit(int n) {
        n %= Pentatonic.NUMBER;
        while ( n < 0 )
            n += Pentatonic.NUMBER;

        return n;
    }

    public static Pentatonic from(DiatonicAlt diatonicAlt, Tonality<DiatonicAlt> ton) throws TonalityException {
        PentatonicDegree pos = (PentatonicDegree)ton.getDegreeFrom(diatonicAlt);
        if (pos == null)
            throw TonalityException.from(diatonicAlt, ton);
        else {
            return Pentatonic.from(pos);
        }
    }
}
