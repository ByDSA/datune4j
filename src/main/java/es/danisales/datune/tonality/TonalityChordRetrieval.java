package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.ChromaticChordInterface;
import es.danisales.datune.pitch.PitchChromaticChord;

import java.util.ArrayList;
import java.util.List;

public class TonalityChordRetrieval {
    private TonalityChordRetrieval() {
    }

    public static Tonality searchInModeSameRoot(Tonality tonality, PitchChromaticChord c) {
        List<Tonality> ts;
        if ( tonality.getScale().isDiatonic() ) {
            ts = new ArrayList<>();
            ts.add( new TonalityCustom( tonality.getRoot(), Scale.MAJOR ) );
            ts.add( new TonalityCustom( tonality.getRoot(), Scale.MINOR ) );
            ts.add( new TonalityCustom( tonality.getRoot(), Scale.DORIAN ) );
            ts.add( new TonalityCustom( tonality.getRoot(), Scale.PHRYGIAN ) );
            ts.add( new TonalityCustom( tonality.getRoot(), Scale.LYDIAN ) );
            ts.add( new TonalityCustom( tonality.getRoot(), Scale.MIXOLYDIAN ) );
            ts.add( new TonalityCustom( tonality.getRoot(), Scale.LOCRIAN ) );
        } else
            ts = tonality.getModesSameRoot();

        for ( Tonality t : ts ) {
            if ( t.equals( tonality ) )
                continue;
            HarmonicFunction function = t.getFunction(ChromaticChord.from(c) );
            if (function instanceof DiatonicFunction) {
                return t;
            }
        }

        return null;
    }

    public static Tonality getRelativeMinorFrom(Tonality tonality) {
        Tonality[] rel = tonality.getModes();
        for ( Tonality s : rel )
            if ( s.getScale().equals( Scale.MINOR ) )
                return s;

        return null;
    }

    public static Tonality getRelativeMajorFrom(Tonality tonality) {
        Tonality[] rel = tonality.getModes();
        for ( Tonality s : rel )
            if ( s.getScale().equals( Scale.MAJOR ) )
                return s;

        return null;
    }

    public static List<ChromaticChord> getTriadChordsFrom(Tonality tonality) {
        NoDiatonicScaleException.check( tonality.getScale() );
        List<ChromaticChord> ret = new ArrayList<>();
        for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
            DiatonicFunction f = null;
            switch ( diatonicDegree ) {
                case I:
                    f = DiatonicFunction.I;
                    break;
                case II:
                    f = DiatonicFunction.II;
                    break;
                case III:
                    f = DiatonicFunction.III;
                    break;
                case IV:
                    f = DiatonicFunction.IV;
                    break;
                case V:
                    f = DiatonicFunction.V;
                    break;
                case VI:
                    f = DiatonicFunction.VI;
                    break;
                case VII:
                    f = DiatonicFunction.VII;
            }
            ChromaticChord chromaticChord = ChromaticChord.from(tonality, f);
            ret.add(chromaticChord);
        }

        return ret;
    }

    public static List<ChromaticChord> getSeventhChordsFrom(Tonality tonality) {
        NoDiatonicScaleException.check( tonality.getScale() );
        List<ChromaticChord> ret = new ArrayList<>();
        for (DiatonicDegree diatonicDegree : DiatonicDegree.values()) {
            DiatonicFunction f = null;
            switch ( diatonicDegree ) {
                case I:
                    f = DiatonicFunction.I7;
                    break;
                case II:
                    f = DiatonicFunction.II7;
                    break;
                case III:
                    f = DiatonicFunction.III7;
                    break;
                case IV:
                    f = DiatonicFunction.IV7;
                    break;
                case V:
                    f = DiatonicFunction.V7;
                    break;
                case VI:
                    f = DiatonicFunction.VI7;
                    break;
                case VII:
                    f = DiatonicFunction.VII7;
            }
            ChromaticChord chromaticChord = ChromaticChord.from(tonality, f);
            ret.add(chromaticChord);
        }

        return ret;
    }
}
