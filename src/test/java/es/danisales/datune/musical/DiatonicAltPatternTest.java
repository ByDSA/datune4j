package es.danisales.datune.musical;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiatonicAltPatternTest {
    @Test
    public void fromDiatonicAlt_majorTriad() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.MAJOR_TRIAD;
        assertEquals("[1, 3, 5]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_minorTriad() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.MINOR_TRIAD;
        assertEquals("[1, b3, 5]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_augmentedTriad() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.AUGMENTED_TRIAD;
        assertEquals("[1, 3, #5]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_diminishedTriad() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.DIMINISHED_TRIAD;
        assertEquals("[1, b3, b5]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_majorSixth() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.MAJOR_SIXTH;
        assertEquals("[1, 3, 5, 6]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_minorSixth() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.MINOR_SIXTH;
        assertEquals("[1, b3, 5, 6]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_Maj7Seventh() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.MAJ7_SEVENTH;
        assertEquals("[1, 3, 5, 7]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_minorSeventh() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.MINOR_SEVENTH;
        assertEquals("[1, b3, 5, b7]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_dominantSeventh() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.DOMINANT_SEVENTH;
        assertEquals("[1, 3, 5, b7]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_dominant_a5_Seventh() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.DOMINANT_a5_SEVENTH;
        assertEquals("[1, 3, #5, b7]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_diminishedSeventh() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.DIMINISHED_SEVENTH;
        assertEquals("[1, b3, b5, bb7]", diatonicAltPattern.toString());
    }

    @Test
    public void fromDiatonicAlt_sus4() {
        DiatonicAltPattern diatonicAltPattern = DiatonicAltPattern.from(
                DiatonicAlt.C,
                DiatonicAlt.F,
                DiatonicAlt.G
        );
        assertEquals("[1, 4, 5]", diatonicAltPattern.toString());
    }
}