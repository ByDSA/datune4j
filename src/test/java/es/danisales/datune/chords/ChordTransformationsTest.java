package es.danisales.datune.chords;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChordTransformationsTest {
    @Test
    public void getMinDistances_itself() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.C, ChromaticChord.C);
        for(int i : set) {
            assertEquals(0, i);
        }
    }

    @Test
    public void getMinDistances_itself_seventh() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.C7, ChromaticChord.C7);
        for(int i : set) {
            assertEquals(0, i);
        }
    }

    @Test
    public void getMinDistances_C_Dm() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.C, ChromaticChord.Dm);
        assertEquals(2, (int)set.get(0));
        assertEquals(1, (int)set.get(1));
        assertEquals(2, (int)set.get(2));
    }

    @Test
    public void getMinDistances_Dm7_CMaj7() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.Dm7, ChromaticChord.CMaj7);
        assertEquals(2, (int)set.get(0));
        assertEquals(1, (int)set.get(1));
        assertEquals(2, (int)set.get(2));
        assertEquals(0, (int)set.get(3));
    }

    @Test
    public void getMinDistances_FMaj7_CMaj7() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.FMaj7, ChromaticChord.CMaj7);
        assertEquals(1, (int)set.get(0));
        assertEquals(2, (int)set.get(1));
        assertEquals(0, (int)set.get(2));
        assertEquals(0, (int)set.get(3));
    }

    @Test
    public void getMinDistances_GG_C() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.GG, ChromaticChord.C);
        assertEquals(1, (int)set.get(0));
        assertEquals(0, (int)set.get(1));
        assertEquals(1, (int)set.get(2));
    }
}