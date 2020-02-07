package es.danisales.datune.function;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChromaticFunctionProgression
        extends ListProxy<ChromaticFunction> {
    @SuppressWarnings("WeakerAccess")
    public static final ChromaticFunctionProgression I_V_vi_IV = ChromaticFunctionProgression.copyOf(
            Arrays.asList(
                    ChromaticFunction.I,
                    ChromaticFunction.V,
                    ChromaticFunction.vi,
                    ChromaticFunction.IV
            )
    );

    @SuppressWarnings("WeakerAccess")
    public static final ChromaticFunctionProgression I_IV_vi_V = ChromaticFunctionProgression.copyOf(
            Arrays.asList(
                    ChromaticFunction.I,
                    ChromaticFunction.IV,
                    ChromaticFunction.vi,
                    ChromaticFunction.V
            )
    );

    @SuppressWarnings("WeakerAccess")
    public static final ChromaticFunctionProgression i_VI_III_VII = ChromaticFunctionProgressionTransformations.shift(ChromaticFunctionProgressionTransformations.rotate(I_V_vi_IV, 2), 2);

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
    public List<ChromaticChord> getChordsFrom(Tonality<Chromatic> tonality) {
        List<ChromaticChord> chromaticChordProgression = new ArrayList<>();
        for (ChromaticFunction chromaticFunction : this) {
            ChromaticChord chromaticChord = (ChromaticChord)tonality.getChordFromHarmonicFunction(chromaticFunction);
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
