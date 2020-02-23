package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.progression.HarmonicFunctionProgression;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class TonalityChordRetrieval {
    private TonalityChordRetrieval() {
    }

    @SuppressWarnings("WeakerAccess")
    public static List<ChromaticChord> getTriadChordsFrom(TonalityModern tonality) {
        HarmonicFunctionProgression harmonicFunctionProgression = HarmonicFunctionProgression.builder()
                .addAll(DiatonicFunction.TRIADS)
                .build();

        return harmonicFunctionProgression.getChordsFrom(tonality);
    }

    @SuppressWarnings("WeakerAccess")
    public static List<ChromaticChord> getSeventhChordsFrom(TonalityModern tonality) {
        HarmonicFunctionProgression harmonicFunctionProgression = HarmonicFunctionProgression.builder()
                .addAll(DiatonicFunction.SEVENTH)
                .build();

        return harmonicFunctionProgression.getChordsFrom(tonality);
    }
}
