package es.danisales.datune.tonality;

import com.google.common.collect.ImmutableList;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.chromatic.ChromaticChordPattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.degrees.scale.ChromaticDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

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
        List<HarmonicFunction> harmonicFunctionList = new ImmutableList.Builder<HarmonicFunction>()
                .addAll(DiatonicFunction.immutableValues())
                .addAll(ChromaticDegreeFunction.SUS4_FUNCTIONS)
                .addAll(ChromaticDegreeFunction.POWER_CHORD_FUNCTIONS)
                .addAll(SecondaryDominant.values())
                .build();
        for (HarmonicFunction harmonicFunction : harmonicFunctionList) {
            ChromaticChord chromaticChord;
            try {
                chromaticChord = harmonicFunction.getChord((TonalityModern) tonality);
                if (chromaticChord == null)
                    throw new RuntimeException();
            } catch (Exception e) {
                continue;
            }

            Set<HarmonicFunction> list = chromaticChordFunctionMap.getOrDefault(chromaticChord, new HashSet<>());
            list.add(harmonicFunction);
            if (harmonicFunction instanceof DiatonicFunction) {
                DiatonicFunction diatonicFunction = (DiatonicFunction)harmonicFunction;
                ChromaticDegreeFunction chromaticDegreeFunction = get(diatonicFunction, chromaticChord);
                if (chromaticDegreeFunction != null) {
                    list.add(chromaticDegreeFunction);
                    functionChromaticChordMap.put(chromaticDegreeFunction, chromaticChord);
                }
            }
            chromaticChordFunctionMap.putIfAbsent(chromaticChord, list);
            functionChromaticChordMap.put(harmonicFunction, chromaticChord);
        }
    }

    private @Nullable ChromaticDegreeFunction get(DiatonicFunction diatonicFunction, ChromaticChord chromaticChord) {
        Chromatic chromatic;
        try {
            chromatic = (Chromatic)tonality.getNote(diatonicFunction.getDiatonicDegree());
            chromatic = chromatic.getShifted(-tonality.getRoot().ordinal());
            ChromaticDegree chromaticDegree = ChromaticDegree.values()[chromatic.ordinal()];
            ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(chromaticChord);
            return ChromaticDegreeFunction.from(chromaticDegree, chromaticChordPattern);
        } catch (ScaleRelativeDegreeException ignored) {
            return null;
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
