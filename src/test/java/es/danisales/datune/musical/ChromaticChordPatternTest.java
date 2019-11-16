package es.danisales.datune.musical;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChromaticChordPatternTest {

    @Test
    public void from() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);

        List<Integer> list = new ArrayList<>();
        for (Integer n : chromaticChordPattern)
            list.add(n);

        assertEquals(Arrays.asList(0, 4, 7), list);
    }

    @Test
    public void equalsTest() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);

        assertEquals(chromaticChordPattern, ChromaticChordPattern.TRIAD_MAJOR);
    }

    @Test
    public void sameEnum() {
        ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);

        assertSame(chromaticChordPattern.innerPattern, ChromaticChordPattern.TRIAD_MAJOR.innerPattern);
    }

    @Test
    public void hashCodeTest() {
        List<Integer> list = Arrays.asList(0, 4, 7);

        assertEquals(list.hashCode(), ChromaticChordPattern.TRIAD_MAJOR.hashCode());
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



    }
}