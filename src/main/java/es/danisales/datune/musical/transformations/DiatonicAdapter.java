package es.danisales.datune.musical.transformations;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;

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

    public static Diatonic from(Chromatic n) {
        switch ( n ) {
            case C:
            case CC:
            case CCC:
            case CCCC:
            case CCCCC:
            case Cb:
            case Cbb:
            case Cbbb:
                return Diatonic.C;
            case D:
            case DD:
            case DDD:
            case DDDD:
            case DDDDD:
            case Db:
            case Dbb:
            case Dbbb:
                return Diatonic.D;
            case E:
            case EE:
            case EEE:
            case EEEE:
            case EEEEE:
            case Eb:
            case Ebb:
            case Ebbb:
                return Diatonic.E;
            case F:
            case FF:
            case FFF:
            case FFFF:
            case FFFFF:
            case Fb:
            case Fbb:
            case Fbbb:
                return Diatonic.F;
            case G:
            case GG:
            case GGG:
            case GGGG:
            case GGGGG:
            case Gb:
            case Gbb:
            case Gbbb:
                return Diatonic.G;
            case A:
            case AA:
            case AAA:
            case AAAA:
            case AAAAA:
            case Ab:
            case Abb:
            case Abbb:
                return Diatonic.A;
            case B:
            case BB:
            case BBB:
            case BBBB:
            case BBBBB:
            case Bb:
            case Bbb:
            case Bbbb:
                return Diatonic.B;
            default:
                return null;
        }
    }

    public static Diatonic from(Chromatic chromatic, Tonality ton) {
        DiatonicDegree pos = ton.getDegree(chromatic);
        if (pos == null)
            throw new TonalityException(chromatic, ton);
        else {
            return Diatonic.from(pos);
        }
    }

    public Diatonic from(ChromaticMidi chromaticMidi, Tonality tonality) throws TonalityException {
        Chromatic chromatic = ChromaticAdapter.from(chromaticMidi);
        DiatonicDegree degree = tonality.getDegree( chromatic );
        return Diatonic.from( degree );
    }

    public Diatonic from(PitchMidi pitchMidi, Tonality tonality) {
        Chromatic chromatic = ChromaticAdapter.from(pitchMidi);
        return from(chromatic, tonality );
    }

    public Diatonic from(DiatonicMidi diatonicMidi) {
        return Diatonic.from( diatonicMidi.getDegree() );
    }
}
