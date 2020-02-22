package es.danisales.datune.function.progression;

import com.google.common.collect.ImmutableList;
import es.danisales.datastructures.ListProxy;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.CompoundFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class HarmonicFunctionProgression
        extends ListProxy<HarmonicFunction> {

    /* Constants */

    public static final HarmonicFunctionProgression I_V_vi_IV = builder()
            .add(
            ChromaticDegreeFunction.I,
            ChromaticDegreeFunction.V,
            ChromaticDegreeFunction.vi,
            ChromaticDegreeFunction.IV
    ).build();

    public static final HarmonicFunctionProgression I_IV_vi_V = builder()
            .add(
            ChromaticDegreeFunction.I,
            ChromaticDegreeFunction.IV,
            ChromaticDegreeFunction.vi,
            ChromaticDegreeFunction.V
    ).build();

    public static final HarmonicFunctionProgression i_bVI_bIII_bVII = builder()
            .addAll(I_V_vi_IV)
            .rotate(2)
            .shift(3)
            .build();

    public static final HarmonicFunctionProgression RHYTHM_CHANGES = builder()
            .add(
                    ChromaticDegreeFunction.IMaj7,
                    ChromaticDegreeFunction.vi7,
                    ChromaticDegreeFunction.ii7,
                    ChromaticDegreeFunction.V7,
                    CompoundFunction.from(SecondaryDominant.ii, ChromaticDegreeFunction.ii7),
                    SecondaryDominant.V7_II,
                    ChromaticDegreeFunction.ii7,
                    ChromaticDegreeFunction.V7
                    ).build();

    /* END CONSTANTS **/

    private HarmonicFunctionProgression() {
        super(new ArrayList<>());
    }


    private HarmonicFunctionProgression(List<HarmonicFunction> list) {
        super(ImmutableList.copyOf(list));
    }

    public List<ChromaticChord> getChordsFrom(Tonality<Chromatic> tonality) {
        List<ChromaticChord> chromaticChordProgression = new ArrayList<>();
        for (HarmonicFunction harmonicFunction : this) {
            ChromaticChord chromaticChord;
            if (harmonicFunction != null) {
                try {
                    chromaticChord = harmonicFunction.getChromaticChordFromTonality(tonality);
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

    /* Object*/

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public HarmonicFunctionProgression clone() {
        HarmonicFunctionProgression chromaticFunctionProgression = new HarmonicFunctionProgression();
        chromaticFunctionProgression.addAll(this);
        return chromaticFunctionProgression;
    }

    /* Builder */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends es.danisales.utils.building.Builder<Builder, HarmonicFunctionProgression> {
        private HarmonicFunctionProgression harmonicFunctionProgression;

        Builder() {
            this.harmonicFunctionProgression = new HarmonicFunctionProgression();
        }

        public Builder shift(int n) {
            for (int i = 0; i < harmonicFunctionProgression.size(); i++) {
                if (harmonicFunctionProgression.get(i) instanceof ChromaticDegreeFunction)
                    harmonicFunctionProgression.set(i, ((ChromaticDegreeFunction)harmonicFunctionProgression.get(i)).getShifted(n));
            }

            return self();
        }

        public Builder add(@NonNull HarmonicFunction... harmonicFunctions) {
            this.harmonicFunctionProgression.addAll(Arrays.asList(harmonicFunctions));

            return self();
        }

        public Builder rotate(int n) {
            Collections.rotate(harmonicFunctionProgression, n);

            return self();
        }

        public Builder addAll(@NonNull HarmonicFunctionProgression... harmonicFunctionProgressions) {
            for (HarmonicFunctionProgression harmonicFunctionProgression : harmonicFunctionProgressions)
                this.harmonicFunctionProgression.addAll(harmonicFunctionProgression);

            return self();
        }

        @NonNull
        @Override
        public HarmonicFunctionProgression build() {
            return new HarmonicFunctionProgression(harmonicFunctionProgression);
        }

        @SuppressWarnings("NullableProblems")
        @Override
        protected HarmonicFunctionProgression.Builder self() {
            return this;
        }
    }
}
