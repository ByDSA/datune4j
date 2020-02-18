package es.danisales.datune.function;

import com.google.common.collect.ImmutableList;
import es.danisales.datastructures.ListProxy;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

public class RelativeChromaticDegreeFunction
        extends ListProxy<ChromaticDegreeFunction>
        implements ChromaticFunction {
    private RelativeChromaticDegreeFunction(List<ChromaticDegreeFunction> listAdapter) {
        super(listAdapter);
    }

    public static RelativeChromaticDegreeFunction from(@NonNull ChromaticDegreeFunction... array) {
        return new RelativeChromaticDegreeFunction(ImmutableList.copyOf(Arrays.asList(array)));
    }

    @Override
    public @NonNull ChromaticChord getChromaticChordFromTonality(Tonality<Chromatic> tonality) {
        checkState(size() > 0);
        Chromatic chromatic = tonality.getRoot().getShifted(get(0).getChromaticDegree().ordinal());
        for (int i = 1; i < size()-1; i++) {
            chromatic = chromatic.getShifted(get(i).getChromaticDegree().ordinal());
        }

        ChromaticDegreeFunction lastChromaticDegreeFunction = get(size()-1);
        if (size() > 1)
            chromatic = chromatic.getShifted(lastChromaticDegreeFunction.getChromaticDegree().ordinal());
        try {
            return ChromaticChord.builder()
                    .chromaticBase(chromatic)
                    .chromaticChordPattern(lastChromaticDegreeFunction.getChromaticChordPattern())
                    .build();
        } catch (BuildingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public @NonNull ChromaticFunction getShifted(int i) {
        throw new UnsupportedOperationException();
    }
}
