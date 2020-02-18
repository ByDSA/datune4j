package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.*;

public class RelativeChromaticDegreeFunctionTest {
    @Test
    public void normal_ii() {
        RelativeChromaticDegreeFunction chromaticDegreeFunction = RelativeChromaticDegreeFunction.from(ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.C);

        assertEquals(ChromaticChord.Dm, chromaticChord);
    }

    @Test
    public void secondaryDominant__V_V() {
        RelativeChromaticDegreeFunction chromaticDegreeFunction = RelativeChromaticDegreeFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.V);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.C);

        assertEquals(ChromaticChord.D, chromaticChord);
    }

    @Test
    public void secondaryDominant__v_V() {
        RelativeChromaticDegreeFunction chromaticDegreeFunction = RelativeChromaticDegreeFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.v);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.C);

        assertEquals(ChromaticChord.Dm, chromaticChord);
    }

    @Test
    public void normal__V_Eb() {
        RelativeChromaticDegreeFunction chromaticDegreeFunction = RelativeChromaticDegreeFunction.from(ChromaticDegreeFunction.V7);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.AA7, chromaticChord);
    }

    @Test
    public void secondaryDominant__v_V_Eb() {
        RelativeChromaticDegreeFunction chromaticDegreeFunction = RelativeChromaticDegreeFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.v);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.Fm, chromaticChord);
    }

    @Test
    public void secondaryDominant__ii_Eb() {
        RelativeChromaticDegreeFunction chromaticDegreeFunction = RelativeChromaticDegreeFunction.from(ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.Fm, chromaticChord);
    }

    @Test
    public void secondaryDominant__V7_ii_Eb() {
        RelativeChromaticDegreeFunction chromaticDegreeFunction = RelativeChromaticDegreeFunction.from(ChromaticDegreeFunction.ii, ChromaticDegreeFunction.V7);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.C7, chromaticChord);
    }

    @Test
    public void secondaryDominant__ii_ii_Eb() {
        RelativeChromaticDegreeFunction chromaticDegreeFunction = RelativeChromaticDegreeFunction.from(ChromaticDegreeFunction.ii, ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.Gm, chromaticChord);
    }
}