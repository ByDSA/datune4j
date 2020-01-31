package es.danisales.datune.function;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.chords.Chord;
import es.danisales.datune.chords.ChordProgression;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ChromaticFunctionProgression
        extends ListProxy<ChromaticFunction> {
    public static final ChromaticFunctionProgression I_V_vi_iv = ChromaticFunctionProgression.copyOf(
            Arrays.asList(
                    ChromaticFunction.I,
                    ChromaticFunction.V,
                    ChromaticFunction.vi,
                    ChromaticFunction.iv
            )
    );

    public static final ChromaticFunctionProgression I_iv_vi_V = ChromaticFunctionProgression.copyOf(
            Arrays.asList(
                    ChromaticFunction.I,
                    ChromaticFunction.iv,
                    ChromaticFunction.vi,
                    ChromaticFunction.V
            )
    );

    public static final ChromaticFunctionProgression i_vi_III_VII = ChromaticFunctionProgressionTransformations.shift(ChromaticFunctionProgressionTransformations.rotate(I_V_vi_iv, 2), 2);

    private ChromaticFunctionProgression() {
        super(new ArrayList<>());
    }

    public static ChromaticFunctionProgression create() {
        return new ChromaticFunctionProgression();
    }

    public static ChromaticFunctionProgression copyOf(Collection<ChromaticFunction> chromaticFunctions) {
        ChromaticFunctionProgression chromaticFunctionProgression = new ChromaticFunctionProgression();
        chromaticFunctionProgression.addAll(chromaticFunctions);

        return chromaticFunctionProgression;
    }

    @SuppressWarnings("WeakerAccess")
    public ChordProgression<Chromatic> getChordsFrom(Tonality<Chromatic> tonality) {
        ChordProgression<Chromatic> chromaticChordProgression = ChordProgression.create();
        for (ChromaticFunction chromaticFunction : this) {
            Chord<Chromatic> chromaticChord = tonality.getChordFromHarmonicFunction(chromaticFunction);
            chromaticChordProgression.add(chromaticChord);
        }

        return chromaticChordProgression;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public ChromaticFunctionProgression clone() {
        ChromaticFunctionProgression chromaticFunctionProgression = new ChromaticFunctionProgression();
        chromaticFunctionProgression.addAll(this);
        return chromaticFunctionProgression;
    }
}
