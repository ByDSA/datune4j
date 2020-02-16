package es.danisales.datune.function.progression;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;

import java.util.*;

public class HarmonicFunctionProgression
        extends ListProxy<HarmonicFunction> {
    @SuppressWarnings("WeakerAccess")
    public static final HarmonicFunctionProgression I_V_vi_IV = HarmonicFunctionProgression.copyOf(
            Arrays.asList(
                    ChromaticDegreeFunction.I,
                    ChromaticDegreeFunction.V,
                    ChromaticDegreeFunction.vi,
                    ChromaticDegreeFunction.IV
            )
    );

    @SuppressWarnings("WeakerAccess")
    public static final HarmonicFunctionProgression I_IV_vi_V = HarmonicFunctionProgression.copyOf(
            Arrays.asList(
                    ChromaticDegreeFunction.I,
                    ChromaticDegreeFunction.IV,
                    ChromaticDegreeFunction.vi,
                    ChromaticDegreeFunction.V
            )
    );

    @SuppressWarnings("WeakerAccess")
    public static final HarmonicFunctionProgression i_bVI_bIII_bVII = ChromaticFunctionProgressionTransformations.shift(
            I_V_vi_IV.clone().rotate(2),
            3);

    private final boolean fixed;

    private HarmonicFunctionProgression() {
        super(new ArrayList<>());

        fixed = false;
    }

    public static HarmonicFunctionProgression create() {
        return new HarmonicFunctionProgression();
    }

    public static HarmonicFunctionProgression copyOf(Collection<ChromaticDegreeFunction> chromaticFunctions) {
        HarmonicFunctionProgression chromaticFunctionProgression = new HarmonicFunctionProgression();
        chromaticFunctionProgression.addAll(chromaticFunctions);

        return chromaticFunctionProgression;
    }

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

    public boolean isImmutable() {
        return fixed;
    }

    private void exceptionIfImmutable() {
        if (isImmutable())
            throw new UnsupportedOperationException();
    }

    public HarmonicFunctionProgression rotate(int n) {
        exceptionIfImmutable();
        Collections.rotate(this, n);

        return this;
    }

    /* Object*/

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public HarmonicFunctionProgression clone() {
        HarmonicFunctionProgression chromaticFunctionProgression = new HarmonicFunctionProgression();
        chromaticFunctionProgression.addAll(this);
        return chromaticFunctionProgression;
    }
}
