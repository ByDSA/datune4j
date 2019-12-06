package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ChromaticChordPatternTest {
    /* patternFrom */

    @Test
    public void from_Integers() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);
        assertEquals(ChromaticChordPattern.TRIAD_MAJOR.getList(), chromaticChordPattern.getList());
    }

    @Test
    public void from_ChromaticChord() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(ChromaticChord.C13a5b9);
        assertEquals(chromaticChordPattern.getList().toString(), ChromaticChordPattern.THIRTEENTH_a5b9, chromaticChordPattern);
    }

    @Test
    public void from_ChromaticChord_Custom() {
        ChromaticChord chromaticChord = ChromaticChord.builder()
                .addAll(Chromatic.FF, Chromatic.A, Chromatic.CC)
                .build();

        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(chromaticChord);

        assertEquals(ChromaticChordPattern.TRIAD_MINOR, chromaticChordPattern);
    }

    @Test
    public void from_ChromaticChord_Inv() {
        ChromaticChord chromaticChord = ChromaticChord.C.clone();
        chromaticChord.inv();
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(chromaticChord);
        ChromaticChordPattern reference = ChromaticChordPattern.from(ChromaticChord.C);

        assertEquals(chromaticChordPattern.getList().toString(), reference, chromaticChordPattern);
    }

    /* iterator */

    @Test
    public void iterator_next() {
        Iterator<Integer> iterator = ChromaticChordPattern.TRIAD_MAJOR.iterator();
        assertEquals((Integer)0, iterator.next());
        assertEquals((Integer)4, iterator.next());
        assertEquals((Integer)7, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_Remove() {
        Iterator<Integer> iterator = ChromaticChordPattern.TRIAD_MAJOR.iterator();
        iterator.next();
        iterator.remove();
    }

    @Test
    public void getList() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.TRIAD_MAJOR;

        assertEquals(Arrays.asList(0, 4, 7), chromaticChordPattern.getList());
    }

    @Test
    public void sameEnum() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.immutableOf(0, 4, 7);

        assertSame(chromaticChordPattern, ChromaticChordPattern.TRIAD_MAJOR);
    }

    @Test
    public void notSameEnum() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);

        assertEquals(chromaticChordPattern, ChromaticChordPattern.TRIAD_MAJOR);
        assertNotSame(chromaticChordPattern, ChromaticChordPattern.TRIAD_MAJOR);
    }

    /* object */

    @Test
    public void equalsTest() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);

        assertEquals(chromaticChordPattern, ChromaticChordPattern.TRIAD_MAJOR);
    }

    @Test
    public void hashCodeTest() {
        List<Integer> list = Arrays.asList(0, 4, 7);

        assertEquals(list.hashCode(), ChromaticChordPattern.TRIAD_MAJOR.hashCode());
    }

    @Test
    public void toStringTest() {
        assertEquals("[0, 4, 7]", ChromaticChordPattern.TRIAD_MAJOR.toString());
        assertEquals("[0, 2, 4]", ChromaticChordPattern.from(Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.E)).toString());
    }
}