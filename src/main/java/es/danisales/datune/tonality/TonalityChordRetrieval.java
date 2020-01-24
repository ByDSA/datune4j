package es.danisales.datune.tonality;

import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.chords.chromatic.ChromaticChord;

import java.util.ArrayList;
import java.util.List;

public class TonalityChordRetrieval {
    private TonalityChordRetrieval() {
    }

    public static List<ChromaticChord> getTriadChordsFrom(Tonality tonality) {
        ScaleNonDiatonicException.check(tonality.getScale());
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
            ChromaticChord chromaticChord = ChromaticChord.builder().tonality(tonality).diatonicFunction(f).build();
            ret.add(chromaticChord);
        }

        return ret;
    }

    public static List<ChromaticChord> getSeventhChordsFrom(Tonality tonality) {
        ScaleNonDiatonicException.check(tonality.getScale());
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
            ChromaticChord chromaticChord = ChromaticChord.builder().tonality(tonality).diatonicFunction(f).build();
            ret.add(chromaticChord);
        }

        return ret;
    }
}
