package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.chords.diatonicalt.DiatonicAltChord;
import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;

public class TonalityGetDiatonicFunctionDefault {
    public static DiatonicAltChord getDiatonicAlt(Tonality<DiatonicAlt> tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        return null;
    }

public static ChromaticChord get(Tonality<Chromatic> tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        Chromatic noteBase = getNoteBaseFrom(tonality, diatonicFunction);
        DiatonicDegreePattern diatonicChordPattern = DiatonicDegreePattern.from(diatonicFunction);

        if (noteBase == null || diatonicChordPattern == null)
            throw new RuntimeException(tonality + " " +diatonicFunction.toString());

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

    private static DiatonicAlt getNoteBaseDiatonicAltFrom(Tonality<DiatonicAlt> tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        return tonality.getNote( DiatonicDegree.from(diatonicFunction) );
    }

    private static Chromatic getNoteBaseFrom(Tonality<Chromatic> tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        return tonality.getNote( DiatonicDegree.from(diatonicFunction) );
    }
}
