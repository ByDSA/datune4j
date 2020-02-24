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
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

class FunctionCache {
    private final Map<TonalChord, Chord<? extends CyclicDegree>> map = new HashMap<>();

    @Nullable Chord<? extends CyclicDegree> get(@NonNull TonalChord tonalChord) {
        Chord<? extends CyclicDegree> cached = map.get(tonalChord);
        if (cached != null)
            return cached;

        Tonality tonality = tonalChord.getTonality();
        HarmonicFunction harmonicFunction = tonalChord.getHarmonicFunction();

        Chord<? extends CyclicDegree> chord;
        if (tonality instanceof TonalityModern) {
            chord = harmonicFunction.calculateChord((TonalityModern)tonality);
            if (chord == null)
                return null;
            //noinspection CastCanBeRemovedNarrowingVariableType
            map.put(tonalChord.clone(), ChromaticChord.immutableFrom((ChromaticChord)chord));

            return chord;
        } else if (tonality instanceof TonalityClassical) {
            return null; // todo
        }

        return null;
    }


    void put(TonalChord tonalChord, Chord<? extends CyclicDegree> chord) {
        map.put(tonalChord, chord);
    }

    boolean containsKey(TonalChord tonalChord) {
        return map.containsKey(tonalChord);
    }

}
