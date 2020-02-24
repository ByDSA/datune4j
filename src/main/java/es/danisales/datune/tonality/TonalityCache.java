package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.function.HarmonicFunction;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkState;

class TonalityCache {
    private Map<ChromaticChord, Set<HarmonicFunction>> chromaticChordFunctionMap;
    private Map<HarmonicFunction, ChromaticChord> functionChromaticChordMap;

    private final Tonality tonality;

    TonalityCache(Tonality tonality) {
        this.tonality = tonality;
    }

    @SuppressWarnings("Duplicates")
    private void create() {
        if (tonality.getRoot() instanceof DiatonicAlt)
            return;
        chromaticChordFunctionMap = new HashMap<>();
        functionChromaticChordMap = new HashMap<>();

        for (HarmonicFunction harmonicFunction : tonality.getScale().getHarmonicFunctions()) {
            ChromaticChord chromaticChord = harmonicFunction.getChord((TonalityModern) tonality);
            checkState(chromaticChord != null, harmonicFunction + " " + tonality);

            Set<HarmonicFunction> list = chromaticChordFunctionMap.getOrDefault(chromaticChord, new HashSet<>());
            list.add(harmonicFunction);
            chromaticChordFunctionMap.putIfAbsent(chromaticChord, list);
            functionChromaticChordMap.put(harmonicFunction, chromaticChord);
        }
    }

    @SuppressWarnings("WeakerAccess")
    public @NonNull Set<HarmonicFunction> getFunctions(ChromaticChord chromaticChord) {
        createIfNeeded();

        return chromaticChordFunctionMap.getOrDefault(chromaticChord, new HashSet<>());
    }

    public ChromaticChord getChord(@NonNull HarmonicFunction harmonicFunction) {
        createIfNeeded();

        return functionChromaticChordMap.get(harmonicFunction);
    }

    void clear() {
        chromaticChordFunctionMap = null;
        functionChromaticChordMap = null;
    }

    private void createIfNeeded() {
        if (chromaticChordFunctionMap == null || functionChromaticChordMap == null)
            create();
        checkState(chromaticChordFunctionMap != null && functionChromaticChordMap != null);
    }

    @SuppressWarnings("WeakerAccess")
    public Set<? extends HarmonicFunction> getFunctions() {
        createIfNeeded();
        return functionChromaticChordMap.keySet();
    }
}
