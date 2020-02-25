package es.danisales.datune.rhythm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class RhythmTest {

    @Test
    public void iterator() {
        RhythmPattern rhythm = RhythmPattern.fromInt(1, 0, 0, 0);
        Iterator<Integer> iterator = rhythm.iterator();
        assertEquals(1, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
    }

    @Test
    public void fromInt() {
        RhythmPattern rhythm = RhythmPattern.fromInt(1, 0, 0, 0);
        assertEquals(1, rhythm.get(0));
        assertEquals(0, rhythm.get(1));
        assertEquals(0, rhythm.get(2));
        assertEquals(0, rhythm.get(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void get_exceed() {
        RhythmPattern rhythm = RhythmPattern.fromInt(1, 0, 0, 0);
        rhythm.get(4);
    }

    @Test
    public void fromEuclideanString_content() {
        RhythmPattern rhythm = RhythmPattern.fromPattern(2, 2, 2, 3);
        Iterator<Integer> iterator = rhythm.iterator();
        assertEquals(1, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
        assertEquals(1, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
        assertEquals(1, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
        assertEquals(1, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
    }

    @Test
    public void fromEuclideanString_size() {
        RhythmPattern rhythm = RhythmPattern.fromPattern(2, 2, 2, 3);
        assertEquals(9, rhythm.size());
    }

    @Test
    public void getRotation() {
        RhythmPattern rhythm = RhythmPattern.fromPattern(2, 2, 2, 3);

        RhythmPattern rotatedRhythm = rhythm.getRotation(3);

        assertEquals(Arrays.asList(3, 2, 2, 2), rotatedRhythm.getPattern());
    }
}