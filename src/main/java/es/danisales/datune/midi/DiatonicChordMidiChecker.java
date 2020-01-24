package es.danisales.datune.midi;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;

public class DiatonicChordMidiChecker {
    private DiatonicChordMidiChecker() {
    }

    public static boolean isTonic(TonalChord tonalChord) {
        DiatonicDegree diatonicDegree = DiatonicDegree.from(tonalChord.getHarmonicFunction());
        switch (diatonicDegree) {
            case I:
            case III:
            case VI:
                return true;
            default:
                return false;
        }
    }

    public static boolean isSubdominant(TonalChord tonalChord) {
        ChromaticChord chromaticChord = ChromaticChord.from(tonalChord);
        for (Chromatic chromatic : chromaticChord) {
            try {
                if (chromatic == tonalChord.getTonality().getNote( DiatonicDegree.IV ))
                    return true;
            } catch (ScaleRelativeDegreeException e) {
                return false;
            }
        }
        return false;
    }

    public boolean isDominant(TonalChord tonalChord) {
        DiatonicDegree diatonicDegree = DiatonicDegree.from(tonalChord.getHarmonicFunction());
        switch (diatonicDegree) {
            case V:
            case VII:
                return true;
            default:
                return false;
        }
    }
}
