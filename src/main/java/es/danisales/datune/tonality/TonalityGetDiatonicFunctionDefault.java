package es.danisales.datune.tonality;

import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;

public class TonalityGetDiatonicFunctionDefault {
    public static ChromaticChord get(Tonality tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        DiatonicAlt noteBase = getNoteBaseFrom(tonality, diatonicFunction);
        DiatonicDegreePattern diatonicChordPattern = DiatonicDegreePattern.from(diatonicFunction);

        if (noteBase == null || diatonicChordPattern == null)
            throw new RuntimeException(tonality + " " +diatonicFunction.toString());

        Chromatic noteBaseChromatic = Chromatic.from(noteBase);
        return ChromaticChord.builder()
                .chromaticBase(noteBaseChromatic)
                .diatonicDegreePattern(diatonicChordPattern)
                .tonality(tonality)
                .build();
    }

    private static DiatonicAlt getNoteBaseFrom(Tonality<DiatonicAlt> tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        return tonality.getNote( DiatonicDegree.from(diatonicFunction) );
    }
}
