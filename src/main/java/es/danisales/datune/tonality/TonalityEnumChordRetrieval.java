package es.danisales.datune.tonality;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.musical.ChromaticChordInterface;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

class TonalityEnumChordRetrieval {
    private TonalityEnumChordRetrieval() {
    }

    static @NonNull BiMap<HarmonicFunction, ChromaticChordInterface> getHarmonicFunctionChomaticChordBiMap(@NonNull TonalityEnum tonalityEnum) {
        Objects.requireNonNull(tonalityEnum);

        BiMap<HarmonicFunction, ChromaticChordInterface> map = HashBiMap.create();

        for (DiatonicFunction diatonicFunction : DiatonicFunction.values())
            map.put(diatonicFunction, ChromaticChordInterface.from(tonalityEnum, diatonicFunction));

        for (ChromaticFunction chromaticFunction : ChromaticFunction.values())
            map.put(chromaticFunction, ChromaticChordInterface.from(tonalityEnum, chromaticFunction));

        return map;
    }
}
