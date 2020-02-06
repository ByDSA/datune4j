package es.danisales.datune.interval;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsonanceIntervalsCalculatorTest {
    @Test
    public void changeConsonance_sameChord() {
        int ret = ConsonanceIntervalsCalculator.differenceOfConsonanceChord(ChromaticChord.C, ChromaticChord.C);
        assertEquals(0, ret);
    }

    @Test
    public void changeConsonance_majorMinor() {
        int ret = ConsonanceIntervalsCalculator.differenceOfConsonanceChord(ChromaticChord.C, ChromaticChord.Cm);
        assertEquals(0, ret);
    }

    @Test
    public void changeConsonance_dimToMajor() {
        int ret = ConsonanceIntervalsCalculator.differenceOfConsonanceChord(ChromaticChord.Cdim, ChromaticChord.C);
        assertEquals(12, ret);
    }

    @Test
    public void changeConsonance_differentLength1() {
        int ret = ConsonanceIntervalsCalculator.differenceOfConsonanceChord(ChromaticChord.C5, ChromaticChord.C);
        assertEquals(-6, ret);
    }

    @Test
    public void changeConsonance_differentLength2() {
        int ret = ConsonanceIntervalsCalculator.differenceOfConsonanceChord(ChromaticChord.C, ChromaticChord.C5);
        assertEquals(6, ret);
    }

    @Test
    public void changeConsonance_dimToP5() {
        int ret = ConsonanceIntervalsCalculator.differenceOfConsonanceChord(ChromaticChord.Cdim, ChromaticChord.C5);
        assertEquals(18, ret);
    }
}