package es.danisales.datune.function;

import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

class TonalityGetDiatonicFunctionDefault {
    static ChromaticChord get(@NonNull Tonality<Chromatic> tonality, @NonNull DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        Chromatic noteBase = getNoteBaseFrom(tonality, diatonicFunction);
        DiatonicDegreePattern diatonicChordPattern = DiatonicDegreePattern.from(diatonicFunction);

        try {
            return ChromaticChord.builder()
                    .chromaticBase(noteBase)
                    .diatonicDegreePattern(diatonicChordPattern)
                    .tonality(tonality)
                    .build();
        } catch (BuildingException e) {
            if (e.getInnerException() instanceof ScaleRelativeDegreeException)
                throw (ScaleRelativeDegreeException)e.getInnerException();
            else
                throw NeverHappensException.make("");
        }
    }

    private static Chromatic getNoteBaseFrom(Tonality<Chromatic> tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        return tonality.getNote( DiatonicDegree.from(diatonicFunction) );
    }
}
