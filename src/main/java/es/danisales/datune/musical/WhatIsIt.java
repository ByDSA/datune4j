package es.danisales.datune.musical;

import es.danisales.datune.pitch.ChordCommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class WhatIsIt {
    private WhatIsIt() {
    }

    private static final Map<ChromaticChordPattern, List<ChromaticChordMutable>> patternToChromaticChords = new HashMap<>();

    static {
        for (ChromaticChordImmutable chromaticChordEnum : ChromaticChordImmutable.values()) {
            for ( int i = 0; i < chromaticChordEnum.size(); i++ ) {
                ChromaticChordMutable chromaticChordCustom = ChromaticChordMutable.from(chromaticChordEnum);
                chromaticChordCustom.inv( i );

                putInPatternToChromaticChords(chromaticChordCustom);
            }
        }
    }

    private static void putInPatternToChromaticChords(ChromaticChordMutable chromaticChordCustom) {
        ChromaticChordPattern array = ChromaticChordPattern.from(chromaticChordCustom);
        List<ChromaticChordMutable> arrayListChords = patternToChromaticChords.getOrDefault(array, new ArrayList<>());
        arrayListChords.add( chromaticChordCustom );
        patternToChromaticChords.put( array, arrayListChords );
    }

    public static void updateWhatIsIt(ChromaticChord chromaticChord, BiFunction<List<ChromaticChord>, ChordCommon<?>, ChromaticChord> fSelectChord) {
        updateWhatIsIt((ChromaticChordMutable) chromaticChord.innerChord, fSelectChord);
    }

    public static void updateWhatIsIt(ChromaticChordMutable chromaticChordCustom1, BiFunction<List<ChromaticChord>, ChordCommon<?>, ChromaticChord> fSelectChord) {
        ChromaticChordPattern integerChromatics = ChromaticChordPattern.from(chromaticChordCustom1);

        List<ChromaticChordMutable> foundCustomChords = patternToChromaticChords.get(integerChromatics);

        if ( foundCustomChords == null ) {
            chromaticChordCustom1.autoName();
            chromaticChordCustom1.meta.updated = true;
            return;
        }

        List<ChromaticChord> foundChords = new ArrayList<>();
        for (ChromaticChordMutable chromaticChordCustom : foundCustomChords)
            foundChords.add(ChromaticChord.builder().fromChromatic(chromaticChordCustom).build());

        ChromaticChord foundChord = fSelectChord.apply( foundChords, chromaticChordCustom1 );

        chromaticChordCustom1.assignMeta((ChromaticChordMutable) foundChord.innerChord);

        chromaticChordCustom1.meta.updated = true;
    }

    public static void updateWhatIsIt(ChromaticChordMutable chromaticChordCustom) {
        updateWhatIsIt(chromaticChordCustom,
                (List<ChromaticChord> chords, ChordCommon<?> self) -> chords.get(0)
        );
    }

    static void updateWhatIsItIfNeeded(ChromaticChordMutable chromaticChordCustom) {
        if ( !chromaticChordCustom.meta.updated )
            updateWhatIsIt(chromaticChordCustom);
    }
}
