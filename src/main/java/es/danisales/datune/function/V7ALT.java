package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum V7ALT implements ChromaticFunction {
    b5;

    @Override
    @NonNull
    public ChromaticChord getChromaticChordFromTonality(Tonality<Chromatic> tonality) throws ScaleRelativeDegreeException {
        DiatonicFunction diatonicFunction = DiatonicFunction.I7;
        Chromatic newRoot = tonality.getNote(DiatonicDegree.V);
        tonality = Tonality.from(newRoot, Scale.SUPERLOCRIAN);

        try {
            return ChromaticChord.builder()
                    .tonality(tonality)
                    .function(diatonicFunction)
                    .build();
        } catch (BuildingException e) {
            if (e.getInnerException() instanceof ScaleRelativeDegreeException) {
                throw (ScaleRelativeDegreeException)e.getInnerException();
            } else
                throw NeverHappensException.make("");
        }
    }
}
