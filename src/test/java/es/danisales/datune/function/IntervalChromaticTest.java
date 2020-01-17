package es.danisales.datune.function;

import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.chords.Quality;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class IntervalChromaticTest {
    @Test
    public void getSemitones() {
        assertEquals(12, IntervalChromatic.PERFECT_OCTAVE.getSemitones());
    }

    @Test
    public void getSemitones2() {
        assertEquals(3, IntervalChromatic.MINOR_THIRD.getSemitones());
    }

    @Test
    public void getSemitones3() {
        assertEquals(4, IntervalChromatic.MAJOR_THIRD.getSemitones());
    }

    @Test
    public void getSemitones4() {
        assertEquals(6, IntervalChromatic.DIMINISHED_FIFTH.getSemitones());
    }

    @Test
    public void getSemitones5() {
        assertEquals(3, IntervalChromatic.AUGMENTED_SECOND.getSemitones());
    }

    @Test
    public void getQuality() {
        assertEquals(Quality.PERFECT, IntervalChromatic.PERFECT_OCTAVE.getQuality());
    }

    @Test
    public void getQuality2() {
        assertEquals(Quality.MINOR, IntervalChromatic.MINOR_THIRD.getQuality());
    }

    @Test
    public void getQuality3() {
        assertEquals(Quality.MAJOR, IntervalChromatic.MAJOR_THIRD.getQuality());
    }

    @Test
    public void getQuality4() {
        assertEquals(Quality.DIMINISHED, IntervalChromatic.DIMINISHED_FIFTH.getQuality());
    }

    @Test
    public void getQuality5() {
        assertEquals(Quality.AUGMENTED, IntervalChromatic.AUGMENTED_SECOND.getQuality());
    }

    @Test
    public void isCompound() {
        assertTrue( IntervalChromatic.AUGMENTED_OCTAVE.isCompound() );
    }

    @Test
    public void isCompound2() {
        assertFalse( IntervalChromatic.PERFECT_OCTAVE.isCompound() );
    }

    @Test
    public void isCompound3() {
        assertFalse( IntervalChromatic.MAJOR_THIRD.isCompound() );
    }

    @Test
    public void isCompound4() {
        assertTrue( IntervalChromatic.AUGMENTED_FIFTEENTH.isCompound() );
    }

    @Test
    public void isCompound5() {
        assertTrue( IntervalChromatic.DIMINISHED_NINTH.isCompound() );
    }

    @Test
    public void fromDiatonicSemitones() {
        assertEquals( IntervalChromatic.MINOR_THIRD, IntervalChromatic.from(IntervalDiatonic.THIRD, 3) );
    }

    @Test
    public void fromDiatonicSemitones2() {
        assertEquals( IntervalChromatic.DIMINISHED_FIFTH, IntervalChromatic.from(IntervalDiatonic.FIFTH, 6) );
    }

    @Test
    public void fromDiatonicNotEmpty() {
        for (IntervalDiatonic intervalDiatonic : IntervalDiatonic.values())
            assertTrue( !IntervalChromatic.from(intervalDiatonic).isEmpty() );
    }

    @Test
    public void fromDiatonic() {
        Set<IntervalChromatic> intervalChromaticList = IntervalChromatic.from(IntervalDiatonic.OCTAVE);
        assertEquals(3, intervalChromaticList.size());
        assertTrue(intervalChromaticList.contains(IntervalChromatic.PERFECT_OCTAVE));
        assertTrue(intervalChromaticList.contains(IntervalChromatic.AUGMENTED_OCTAVE));
        assertTrue(intervalChromaticList.contains(IntervalChromatic.DIMINISHED_OCTAVE));
    }

    @Test
    public void toStringTest() {
        for (IntervalChromatic intervalChromatic : IntervalChromatic.values()) {
            assertNotNull(intervalChromatic.toString());
        }
    }
}