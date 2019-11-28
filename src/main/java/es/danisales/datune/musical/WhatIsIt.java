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

    private static final Map<ChromaticChordPattern, List<ChromaticChordCustom>> patternToChromaticChords = new HashMap<>();

    static {
        for ( ChromaticChordEnum chromaticChordEnum : ChromaticChordEnum.values() ) {
            for ( int i = 0; i < chromaticChordEnum.size(); i++ ) {
                ChromaticChordCustom chromaticChordCustom = ChromaticChordCustom.from(chromaticChordEnum);
                chromaticChordCustom.inv( i );

                putInPatternToChromaticChords(chromaticChordCustom);
            }
        }
    }

    private static void putInPatternToChromaticChords(ChromaticChordCustom chromaticChordCustom) {
        ChromaticChordPattern array = ChromaticChordPattern.from(chromaticChordCustom);
        List<ChromaticChordCustom> arrayListChords = patternToChromaticChords.getOrDefault( array, new ArrayList<>() );
        arrayListChords.add( chromaticChordCustom );
        patternToChromaticChords.put( array, arrayListChords );
    }

    public static void updateWhatIsIt(ChromaticChord chromaticChord, BiFunction<List<ChromaticChord>, ChordCommon<?>, ChromaticChord> fSelectChord) {
        updateWhatIsIt((ChromaticChordCustom)chromaticChord.innerChord, fSelectChord);
    }

    public static void updateWhatIsIt(ChromaticChordCustom chromaticChordCustom1, BiFunction<List<ChromaticChord>, ChordCommon<?>, ChromaticChord> fSelectChord) {
        ChromaticChordPattern integerChromatics = ChromaticChordPattern.from(chromaticChordCustom1);

        List<ChromaticChordCustom> foundCustomChords = patternToChromaticChords.get( integerChromatics );

        if ( foundCustomChords == null ) {
            chromaticChordCustom1.autoName();
            chromaticChordCustom1.meta.updated = true;
            return;
        }

        List<ChromaticChord> foundChords = new ArrayList<>();
        for (ChromaticChordCustom chromaticChordCustom : foundCustomChords)
            foundChords.add(ChromaticChord.builder().fromChromatic(chromaticChordCustom).build());

        ChromaticChord foundChord = fSelectChord.apply( foundChords, chromaticChordCustom1 );

        chromaticChordCustom1.assignMeta( (ChromaticChordCustom)foundChord.innerChord );

        chromaticChordCustom1.meta.updated = true;
    }

    public static void updateWhatIsIt(ChromaticChordCustom chromaticChordCustom) {
        updateWhatIsIt(chromaticChordCustom,
                (List<ChromaticChord> chords, ChordCommon<?> self) -> chords.get(0)
        );
    }

    static void updateWhatIsItIfNeeded(ChromaticChordCustom chromaticChordCustom) {
        if ( !chromaticChordCustom.meta.updated )
            updateWhatIsIt(chromaticChordCustom);
    }
}
