package es.danisales.datune.function;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChromaticFunctionProgression
        extends ListProxy<HarmonicFunction> {
    @SuppressWarnings("WeakerAccess")
    public static final ChromaticFunctionProgression I_V_vi_IV = ChromaticFunctionProgression.copyOf(
            Arrays.asList(
                    ChromaticDegreeFunction.I,
                    ChromaticDegreeFunction.V,
                    ChromaticDegreeFunction.vi,
                    ChromaticDegreeFunction.IV
            )
    );

    @SuppressWarnings("WeakerAccess")
    public static final ChromaticFunctionProgression I_IV_vi_V = ChromaticFunctionProgression.copyOf(
            Arrays.asList(
                    ChromaticDegreeFunction.I,
                    ChromaticDegreeFunction.IV,
                    ChromaticDegreeFunction.vi,
                    ChromaticDegreeFunction.V
            )
    );

    @SuppressWarnings("WeakerAccess")
    public static final ChromaticFunctionProgression i_bVI_bIII_bVII = ChromaticFunctionProgressionTransformations.shift(
            ChromaticFunctionProgressionTransformations.rotate(I_V_vi_IV, 2),
            3);

    private ChromaticFunctionProgression() {
        super(new ArrayList<>());
    }

    public static ChromaticFunctionProgression create() {
        return new ChromaticFunctionProgression();
    }

    public static ChromaticFunctionProgression copyOf(Collection<ChromaticDegreeFunction> chromaticFunctions) {
        ChromaticFunctionProgression chromaticFunctionProgression = new ChromaticFunctionProgression();
        chromaticFunctionProgression.addAll(chromaticFunctions);

        return chromaticFunctionProgression;
    }

    @SuppressWarnings("WeakerAccess")
    public List<ChromaticChord> getChordsFrom(Tonality<Chromatic> tonality) {
        List<ChromaticChord> chromaticChordProgression = new ArrayList<>();
        for (HarmonicFunction harmonicFunction : this) {
            ChromaticChord chromaticChord;
            if (harmonicFunction instanceof ChromaticFunction) {
                try {
                    chromaticChord = ((ChromaticFunction) harmonicFunction).getChromaticChordFromTonality(tonality);
                } catch (ScaleRelativeDegreeException e) {
                    e.printStackTrace();
                    continue;
                }
            }
            else
                continue;
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
