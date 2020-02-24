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
import org.checkerframework.checker.nullness.qual.Nullable;

public class V7ALT extends HarmonicFunction {
    public static final V7ALT b5 = new V7ALT();

    @Override
    @Nullable
    public ChromaticChord calculateChord(TonalityModern tonality) {
        DiatonicFunction diatonicFunction = DiatonicFunction.I7;
        Chromatic newRoot;
        try {
            newRoot = tonality.getNote(DiatonicDegree.V);
        } catch (ScaleRelativeDegreeException e) {
            return null;
        }
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
