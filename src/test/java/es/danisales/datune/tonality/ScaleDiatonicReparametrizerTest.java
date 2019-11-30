package es.danisales.datune.tonality;

import es.danisales.datune.degree.DiatonicDegree;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaleDiatonicReparametrizerTest {
    @Test
    public void create() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        assertNotNull(scaleDiatonicReparametrizer);
    }

    @Test
    public void put() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        assertNull(scaleDiatonicReparametrizer.getByKey(DiatonicDegree.I));
        scaleDiatonicReparametrizer.put(DiatonicDegree.I, 0);
        assertNotNull(scaleDiatonicReparametrizer.getByKey(DiatonicDegree.I));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putFixed() {
        ScaleDegreeReparametrizer.PENTATONIC.put(DiatonicDegree.VII, 7);
    }

    @Test
    public void getByIndex() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer.put(DiatonicDegree.I, 0);
        assertNotNull(scaleDiatonicReparametrizer.getByKey(DiatonicDegree.I));
    }

    @Test
    public void getByKey() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer.put(DiatonicDegree.I, 0);
        assertNotNull(scaleDiatonicReparametrizer.getByIndex(0));
    }

    @Test
    public void equalsEmpty() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer2 = ScaleDegreeReparametrizer.create();

        assertEquals(scaleDiatonicReparametrizer, scaleDiatonicReparametrizer2);
        assertEquals(scaleDiatonicReparametrizer2, scaleDiatonicReparametrizer);
    }

    @Test
    public void equals() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer.put(DiatonicDegree.I, 0);

        ScaleDegreeReparametrizer scaleDiatonicReparametrizer2 = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer2.put(DiatonicDegree.I, 0);

        assertEquals(scaleDiatonicReparametrizer, scaleDiatonicReparametrizer2);
        assertEquals(scaleDiatonicReparametrizer2, scaleDiatonicReparametrizer);
    }

    @Test
    public void hashCodeTestEmpty() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer2 = ScaleDegreeReparametrizer.create();
        assertEquals(scaleDiatonicReparametrizer.hashCode(), scaleDiatonicReparametrizer2.hashCode());
    }

    @Test
    public void hashCodeTest() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer.put(DiatonicDegree.I, 0);

        ScaleDegreeReparametrizer scaleDiatonicReparametrizer2 = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer2.put(DiatonicDegree.I, 0);

        assertEquals(scaleDiatonicReparametrizer.hashCode(), scaleDiatonicReparametrizer2.hashCode());
    }

    @Test
    public void hashCodeDifferentTest() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer.put(DiatonicDegree.I, 0);

        ScaleDegreeReparametrizer scaleDiatonicReparametrizer2 = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer2.put(DiatonicDegree.II, 0);

        assertNotEquals(scaleDiatonicReparametrizer.hashCode(), scaleDiatonicReparametrizer2.hashCode());
    }

    @Test
    public void cloneTest() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.PENTATONIC.clone();
        assertEquals(scaleDiatonicReparametrizer, ScaleDegreeReparametrizer.PENTATONIC);
        assertNotSame(scaleDiatonicReparametrizer, ScaleDegreeReparametrizer.PENTATONIC);
    }

    @Test
    public void cloneTestIndependentMap() {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.PENTATONIC.clone();
        scaleDiatonicReparametrizer.put(DiatonicDegree.VII, 7);
        assertNotEquals(scaleDiatonicReparametrizer, ScaleDegreeReparametrizer.PENTATONIC);
    }
}