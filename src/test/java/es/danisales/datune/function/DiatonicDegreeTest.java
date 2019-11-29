package es.danisales.datune.function;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalDiatonic;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiatonicDegreeTest {
    @Test
    public void add() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.add(degree, IntervalDiatonic.SECOND);
        assertEquals(DiatonicDegree.II, degree);
    }

    @Test
    public void addNone() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.add(degree, IntervalDiatonic.UNISON);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void addExceed() {
        DiatonicDegree degree = DiatonicDegree.VII;
        degree = DiatonicDegree.add(degree, IntervalDiatonic.SECOND);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void addExceed2() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.add(degree, IntervalDiatonic.OCTAVE);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void addExceed3() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.add(degree, IntervalDiatonic.THIRTEENTH);
        assertEquals(DiatonicDegree.VI, degree);
    }

    @Test
    public void addExceed4() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.add(degree, IntervalDiatonic.FIFTEENTH);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void sub() {
        DiatonicDegree degree = DiatonicDegree.II;
        degree = DiatonicDegree.sub(degree, IntervalDiatonic.SECOND);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void subNone() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.sub(degree, IntervalDiatonic.UNISON);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void subExceed() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.sub(degree, IntervalDiatonic.SECOND);
        assertEquals(DiatonicDegree.VII, degree);
    }

    @Test
    public void subExceed2() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.sub(degree, IntervalDiatonic.OCTAVE);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void subExceed3() {
        DiatonicDegree degree = DiatonicDegree.VI;
        degree = DiatonicDegree.sub(degree, IntervalDiatonic.THIRTEENTH);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void subExceed4() {
        DiatonicDegree degree = DiatonicDegree.I;
        degree = DiatonicDegree.sub(degree, IntervalDiatonic.FIFTEENTH);
        assertEquals(DiatonicDegree.I, degree);
    }

    @Test
    public void fromDiatonicFunctionNoneImpossible() {
        for (DiatonicFunction diatonicFunction : DiatonicFunction.values()) {
            DiatonicDegree diatonicDegree = DiatonicDegree.from(diatonicFunction);
            assertNotNull(diatonicDegree);
        }
    }

    @Test
    public void fromChromaticFunctionNoneImpossible() {
        for (ChromaticFunction diatonicFunction : ChromaticFunction.values()) {
            DiatonicDegree diatonicDegree = DiatonicDegree.from(diatonicFunction);
            assertNotNull(diatonicDegree);
        }
    }

    @Test
    public void getNext() {
        assertSame(DiatonicDegree.I, DiatonicDegree.VII.getNext());
    }

    @Test
    public void getPrevious() {
        assertSame(DiatonicDegree.VII, DiatonicDegree.I.getPrevious());
    }
}