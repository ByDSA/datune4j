package es.danisales.datune.diatonic;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalDiatonicTest {
    @Test
    public void fromIndex() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(0);
        assertEquals(IntervalDiatonic.UNISON, intervalDiatonic);
    }

    @Test
    public void fromIndex2() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(7);
        assertEquals(IntervalDiatonic.OCTAVE, intervalDiatonic);
    }

    @Test
    public void fromIndex3() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(9);
        assertEquals(IntervalDiatonic.TENTH, intervalDiatonic);
    }

    @Test
    public void fromIndex4() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(14);
        assertEquals(IntervalDiatonic.FIFTEENTH, intervalDiatonic);
    }

    @Test
    public void fromIndexNegative() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(-1);
        assertEquals(IntervalDiatonic.SECOND, intervalDiatonic);
    }

    @Test
    public void fromIndexNegative2() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(-7);
        assertEquals(IntervalDiatonic.OCTAVE, intervalDiatonic);
    }

    @Test
    public void fromIndexNegativeExceed() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(-16);
        assertEquals(IntervalDiatonic.SECOND, intervalDiatonic);
    }

    @Test
    public void fromIndexExceed() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(15);
        assertEquals(IntervalDiatonic.UNISON, intervalDiatonic);
    }

    @Test
    public void from() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.from(IntervalChromatic.PERFECT_UNISON);
        assertEquals(IntervalDiatonic.UNISON, intervalDiatonic);
    }

    @Test
    public void from2() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.from(IntervalChromatic.DIMINISHED_OCTAVE);
        assertEquals(IntervalDiatonic.OCTAVE, intervalDiatonic);
    }

    @Test
    public void from3() {
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.from(IntervalChromatic.AUGMENTED_FIFTEENTH);
        assertEquals(IntervalDiatonic.FIFTEENTH, intervalDiatonic);
    }

    @Test
    public void toStringTestNotNull() {
        for (IntervalDiatonic intervalDiatonic : IntervalDiatonic.values())
            assertNotNull(intervalDiatonic.toString());
    }
}