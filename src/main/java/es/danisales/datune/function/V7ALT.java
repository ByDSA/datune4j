package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityModern;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum V7ALT implements HarmonicFunction {
    b5;

    @Override
    @NonNull
    public ChromaticChord getChord(TonalityModern tonality) throws ScaleRelativeDegreeException {
        DiatonicFunction diatonicFunction = DiatonicFunction.I7;
        Chromatic newRoot = tonality.getNote(DiatonicDegree.V);
        tonality = Tonality.from(newRoot, Scale.SUPERLOCRIAN);

        try {
            return diatonicFunction.getChord(tonality);
        } catch (Exception e) {
                throw NeverHappensException.make("");
        }
    }

    @Override
    public @NonNull HarmonicFunction getShifted(int i) { // todo
        return null;
    }
}
