package es.danisales.datune.tonality;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;

class TonalityEnumChordRetrieval {
    private TonalityEnumChordRetrieval() {
    }

    static @NonNull BiMap<HarmonicFunction, ChromaticChord> getHarmonicFunctionChomaticChordBiMap(TonalityEnum tonalityEnum) {
        BiMap<HarmonicFunction, ChromaticChord> map = HashBiMap.create();

        for (DiatonicFunction diatonicFunction : DiatonicFunction.values())
            map.put(diatonicFunction, ChromaticChord.from(tonalityEnum, diatonicFunction));

        for (ChromaticFunction chromaticFunction : ChromaticFunction.values())
            map.put(chromaticFunction, ChromaticChord.from(tonalityEnum, chromaticFunction));

        return map;
    }
}
