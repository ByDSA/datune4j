package es.danisales.datune.tonality;

import com.google.common.collect.ImmutableList;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;

import java.util.ArrayList;
import java.util.List;

public class TonalityChordRetrieval {
    private TonalityChordRetrieval() {
    }

    public static List<ChromaticChord> getChordsFrom(Iterable<? extends HarmonicFunction> harmonicFunctions, Tonality tonality) {
        ScaleNonDiatonicException.check(tonality.getScale());
        List<ChromaticChord> ret = new ArrayList<>();
        for ( HarmonicFunction harmonicFunction : harmonicFunctions ) {
            ChromaticChord chromaticChord;
            try {
                chromaticChord = ChromaticChord.builder().tonality(tonality).function(harmonicFunction).build();
                if (chromaticChord == null)
                    throw new RuntimeException();
            } catch (Exception e) {
                continue;
            }
            ret.add(chromaticChord);
        }

        return ret;
    }

    public static List<ChromaticChord> getTriadChordsFrom(Tonality tonality) {
        List<DiatonicFunction> triadFunctions = new ImmutableList.Builder<DiatonicFunction>()
                .addAll(DiatonicFunction.TRIADS)
                .build();

        return getChordsFrom(triadFunctions, tonality);
    }

    public static List<ChromaticChord> getSeventhChordsFrom(Tonality tonality) {
        List<DiatonicFunction> seventhFunctions = new ImmutableList.Builder<DiatonicFunction>()
                .addAll(DiatonicFunction.SEVENTH)
                .build();

        return getChordsFrom(seventhFunctions, tonality);
    }
}
