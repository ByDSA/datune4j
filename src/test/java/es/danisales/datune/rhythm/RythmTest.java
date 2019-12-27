package es.danisales.datune.rhythm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class RythmTest {

    @Test
    public void iterator() {
        RhythmPattern rythm = RhythmPattern.fromInt(1, 0, 0, 0);
        Iterator<Integer> iterator = rythm.iterator();
        assertEquals(1, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
        assertEquals(0, (int) iterator.next());
    }

    @Test
    public void fromInt() {
        RhythmPattern rythm = RhythmPattern.fromInt(1, 0, 0, 0);
        assertEquals(1, rythm.get(0));
        assertEquals(0, rythm.get(1));
        assertEquals(0, rythm.get(2));
        assertEquals(0, rythm.get(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void get_exceed() {
        RhythmPattern rythm = RhythmPattern.fromInt(1, 0, 0, 0);
        rythm.get(4);
    }

    @Test
    public void fromEuclideanString_content() {
        RhythmPattern rythm = RhythmPattern.fromPattern(2, 2, 2, 3);
        Iterator<Integer> iterator = rythm.iterator();
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
        RhythmPattern rythm = RhythmPattern.fromPattern(2, 2, 2, 3);
        assertEquals(9, rythm.size());
    }

    @Test
    public void getRotation() {
        RhythmPattern rythm = RhythmPattern.fromPattern(2, 2, 2, 3);

        RhythmPattern rotatedRythm = rythm.getRotation(3);

        assertEquals(Arrays.asList(3, 2, 2, 2), rotatedRythm.getPattern());
    }
}