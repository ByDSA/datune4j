package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ChromaticChordPatternTest {
    @Test
    public void fromIntegers() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);
        assertEquals(ChromaticChordPattern.TRIAD_MAJOR.getList(), chromaticChordPattern.getList());
    }

    @Test
    public void fromChromaticChord() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(ChromaticChord.C13a5b9);
        assertEquals(chromaticChordPattern.getList().toString(), ChromaticChordPattern.THIRTEENTH_a5b9, chromaticChordPattern);
    }

    @Test
    public void fromChromaticChordInv() {
        ChromaticChord chromaticChord = ChromaticChord.C.clone();
        chromaticChord.inv();
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(chromaticChord);
        ChromaticChordPattern reference = ChromaticChordPattern.from(ChromaticChord.C);

        assertEquals(chromaticChordPattern.getList().toString(), reference, chromaticChordPattern);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemove() {
        Iterator<Integer> iterator = ChromaticChordPattern.TRIAD_MAJOR.iterator();
        iterator.next();
        iterator.remove();
    }

    @Test
    public void iterator() {
        Iterator<Integer> iterator = ChromaticChordPattern.TRIAD_MAJOR.iterator();
        assertEquals((Integer)0, iterator.next());
        assertEquals((Integer)4, iterator.next());
        assertEquals((Integer)7, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void getList() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.TRIAD_MAJOR;

        assertEquals(Arrays.asList(0, 4, 7), chromaticChordPattern.getList());
    }

    @Test
    public void equalsTest() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);

        assertEquals(chromaticChordPattern, ChromaticChordPattern.TRIAD_MAJOR);
    }

    @Test
    public void sameEnum() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);

        assertSame(chromaticChordPattern.numbersPattern, ChromaticChordPattern.TRIAD_MAJOR.numbersPattern);
    }

    @Test
    public void hashCodeTest() {
        List<Integer> list = Arrays.asList(0, 4, 7);

        assertEquals(list.hashCode() + 31 * Boolean.hashCode(true), ChromaticChordPattern.TRIAD_MAJOR.hashCode());
    }

    @Test
    public void toStringTest() {
        assertEquals("[0, 4, 7]", ChromaticChordPattern.TRIAD_MAJOR.toString());
        assertEquals("[0, 2, 4]", ChromaticChordPattern.from(Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.E)).toString());
    }

    // Fuente: https://es.wikipedia.org/wiki/Anexo:Especies_de_acordes
    @Test
    public void codes() {
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.G
        ), ChromaticChord.C5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G
        ), ChromaticChord.C.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G
        ), ChromaticChord.Cm.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG
        ), ChromaticChord.Caug.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.FF
        ), ChromaticChord.Cdim.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G
        ), ChromaticChord.Csus4.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.D,
                Chromatic.G
        ), ChromaticChord.Csus2.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA
        ), ChromaticChord.C7.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA
        ), ChromaticChord.C7b5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.AA
        ), ChromaticChord.C7a5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.AA
        ), ChromaticChord.C7sus4.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA
        ), ChromaticChord.Cm7.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.FF,
                Chromatic.AA
        ), ChromaticChord.Cm7b5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.GG,
                Chromatic.AA
        ), ChromaticChord.Cm7a5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.A
        ), ChromaticChord.C6.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.A
        ), ChromaticChord.C6sus4.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B
        ), ChromaticChord.CMaj7.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B
        ), ChromaticChord.CmMaj7.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.A,
                Chromatic.D
        ), ChromaticChord.C6add9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.A,
                Chromatic.D
        ), ChromaticChord.Cm6add9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC
        ), ChromaticChord.C7b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.DD
        ), ChromaticChord.C7a9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC
        ), ChromaticChord.Cm7b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC
        ), ChromaticChord.Cm7b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.F
        ), ChromaticChord.C7add11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.A
        ), ChromaticChord.C7add13.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.Cm9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9b5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9a5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9sus4.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D
        ), ChromaticChord.CMaj9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D
        ), ChromaticChord.CmMaj9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.A,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9add6.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.FF
        ), ChromaticChord.C9a11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.FF
        ), ChromaticChord.CMaj9a11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F
        ), ChromaticChord.C11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F
        ), ChromaticChord.Cm11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.F
        ), ChromaticChord.C11b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.DD,
                Chromatic.F
        ), ChromaticChord.C11a9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F
        ), ChromaticChord.CMaj11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F
        ), ChromaticChord.CmMaj11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.Cm13.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.Cm13omit11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13sus4.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.C13sus4omit11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13b5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.C13b5omit11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13a5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.C13a5omit11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.A
        ), ChromaticChord.C13b9omit11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13a9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.DD,
                Chromatic.A
        ), ChromaticChord.C13a9omit11.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13b5b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.A
        ), ChromaticChord.C13b5b9omit11.getNotes());

        // Do treceava mayor
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.A
                ), ChromaticChord.CMaj13omit11.getNotes());

        // Do menor treceava mayor
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CmMaj13.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.A
                ), ChromaticChord.CmMaj13omit11.getNotes());

        // Do treceava mayor con quinta bemol
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13b5.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.D,
                Chromatic.A
                ), ChromaticChord.CMaj13b5omit11.getNotes());

        // Do treceava mayor con quinta aumentada
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13a9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.A
                ), ChromaticChord.CMaj13a9omit11.getNotes());

        // Do treceava mayor con novena bemol
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.A
                ), ChromaticChord.CMaj13b9omit11.getNotes());


        // Do treceava mayor con novena aumentada
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13a9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.A
                ), ChromaticChord.CMaj13a9omit11.getNotes());

        // Do treceava mayor con quinta y novena bemoles
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13b5b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.A
                ), ChromaticChord.CMaj13b5b9omit11.getNotes());

        // Do treceava mayor con quinta bemol y novena aumentada
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13b5a9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.A
                ), ChromaticChord.CMaj13b5a9omit11.getNotes());

        //Do treceava mayor con quinta aumentada y novena bemol
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13a5b9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.A
                ), ChromaticChord.CMaj13a5b9omit11.getNotes());

        // Do treceava mayor con quinta y novena aumentadas
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
                ), ChromaticChord.CMaj13a5a9.getNotes());

        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.A
                ), ChromaticChord.CMaj13a5a9omit11.getNotes());

    }
}