package es.danisales.datune.function;

import es.danisales.datune.chords.Chord;
import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityClassical;
import es.danisales.datune.tonality.TonalityModern;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

class FunctionCache { // todo: generalziar para todas harmonic function
    private static final Map<TonalChord, Chord<? extends CyclicDegree>> map = new HashMap<>();

    static @NonNull Chord<? extends CyclicDegree> get(@NonNull TonalChord tonalChord) throws ScaleRelativeDegreeException {
        Chord<? extends CyclicDegree> cached = map.get(tonalChord);
        if (cached != null)
            return cached;

        Tonality tonality = tonalChord.getTonality();
        DiatonicFunction diatonicFunction = (DiatonicFunction)tonalChord.getHarmonicFunction();
        CyclicDegree noteBase = getNoteBaseFrom(tonality, diatonicFunction);
        DiatonicDegreePattern diatonicChordPattern = diatonicFunction.getDiatonicDegreePattern();

        Chord<? extends CyclicDegree> chord;
        if (noteBase instanceof Chromatic && tonality instanceof TonalityModern) {
                chord = ChromaticChord.builder()
                        .chromaticBase((Chromatic) noteBase)
                        .diatonicDegreePattern(diatonicChordPattern)
                        .tonality((TonalityModern)tonality)
                        .build();
                //noinspection CastCanBeRemovedNarrowingVariableType
                map.put(tonalChord.clone(), ChromaticChord.immutableFrom((ChromaticChord)chord));

                return chord;
        } else if (noteBase instanceof DiatonicAlt && tonality instanceof TonalityClassical) {
            return null; // todo
        }

        throw new ScaleRelativeDegreeException(diatonicFunction.getDiatonicDegree(), tonality.getScale());
    }

    private static CyclicDegree getNoteBaseFrom(Tonality tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        return tonality.getNote( diatonicFunction.getDiatonicDegree() );
    }
}
