package es.danisales.datune.rhythm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EuclideanRhythmCalculatorTest {
    @Test
    public void calculate_4_8() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(4, 8);
        assertEquals(
                RhythmPattern.fromInt(1, 0, 1, 0, 1, 0, 1, 0),
                rhythm);
    }

    /* paper: Euclidean strings */

    @Test
    public void calculate_2_5() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(2, 5);
        assertEquals(
                RhythmPattern.fromInt(1, 0, 1, 0, 0),
                rhythm);
    }

    @Test
    public void calculate_3_7() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(3, 7);
        assertEquals(
                RhythmPattern.fromInt(1, 0, 1, 0, 1, 0, 0),
                rhythm);
    }

    @Test
    public void calculate_4_9() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(4, 9);
        assertEquals(
                RhythmPattern.fromInt(1, 0, 1, 0, 1, 0, 1, 0, 0),
                rhythm);
    }

    @Test
    public void calculate_5_11() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(5, 11);
        assertEquals(
                RhythmPattern.fromInt(1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0),
                rhythm);
    }

    @Test
    public void calculate_5_16() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(5, 16);
        assertEquals(
                RhythmPattern.fromInt(1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0),
                rhythm);
    }

    /* paper: reverse Euclidean strings */

    @Test
    public void calculate_2_3() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(2, 3);
        assertEquals(
                RhythmPattern.fromPattern(2, 1),
                rhythm);
    }

    @Test
    public void calculate_3_4() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(3, 4);
        assertEquals(
                RhythmPattern.fromPattern(2, 1, 1),
                rhythm);
    }

    @Test
    public void calculate_3_5() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(3, 5);
        assertEquals(
                RhythmPattern.fromPattern(2, 2, 1),
                rhythm);
    }

    @Test
    public void calculate_3_8() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(3, 8);
        assertEquals(
                RhythmPattern.fromPattern(3, 3, 2),
                rhythm);
    }

    @Test
    public void calculate_4_7() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(4, 7);
        assertEquals(
                RhythmPattern.fromPattern(2, 2, 2, 1),
                rhythm);
    }

    @Test
    public void calculate_4_11() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(4, 11);
        assertEquals(
                RhythmPattern.fromPattern(3, 3, 3, 2),
                rhythm);
    }

    @Test
    public void calculate_5_6() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(5, 6);
        assertEquals(
                RhythmPattern.fromPattern(2, 1, 1, 1, 1),
                rhythm);
    }

    @Test
    public void calculate_5_7() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(5, 7);
        assertEquals(
                RhythmPattern.fromPattern(2, 1, 2, 1, 1),
                rhythm);
    }

    @Test
    public void calculate_5_9() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(5, 9);
        assertEquals(
                RhythmPattern.fromPattern(2, 2, 2, 2, 1),
                rhythm);
    }

    @Test
    public void calculate_5_12() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(5, 12);
        assertEquals(
                RhythmPattern.fromPattern(3, 2, 3, 2, 2),
                rhythm);
    }

    @Test
    public void calculate_7_8() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(7, 8);
        assertEquals(
                RhythmPattern.fromPattern(2, 1, 1, 1, 1, 1, 1),
                rhythm);
    }

    @Test
    public void calculate_7_16() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(7, 16);
        assertEquals(
                RhythmPattern.fromInt(1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0),
                rhythm);
    }

    @Test
    public void calculate_11_24() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(11, 24);
        assertEquals(
                RhythmPattern.fromPattern(3, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2),
                rhythm);
    }

    // paper: neither Euclidean nor reverse Euclidean strings

    @Test
    public void calculate_5_8() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(5, 8);
        assertEquals(
                RhythmPattern.fromPattern(2, 1, 2, 1, 2),
                rhythm);
    }

    @Test
    public void calculate_7_12() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(7, 12);
        assertEquals(
                RhythmPattern.fromPattern(2, 1, 2, 2, 1, 2, 2),
                rhythm);
    }

    @Test
    public void calculate_9_16() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(9, 16);
        assertEquals(
                RhythmPattern.fromInt(1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0),
                rhythm);
    }

    @Test
    public void calculate_13_24() {
        RhythmPattern rhythm = EucledianRhythmCalculator.calculate(13, 24);
        assertEquals(
                RhythmPattern.fromPattern(2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2),
                rhythm);
    }
}