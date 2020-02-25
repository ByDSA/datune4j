package es.danisales.datune.tonality;

import es.danisales.datune.degrees.scale.DiatonicDegree;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaleDegreeReparameterizeTest {
    @Test
    public void create() {
        ScaleDegreeReparameterize scaleDegreeReparameterize = ScaleDegreeReparameterize.create();
        assertNotNull(scaleDegreeReparameterize);
    }

    @Test
    public void put() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        assertNull(scaleDiatonicReparameterize.getByKey(DiatonicDegree.I));
        scaleDiatonicReparameterize.put(DiatonicDegree.I, 0);
        assertNotNull(scaleDiatonicReparameterize.getByKey(DiatonicDegree.I));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putFixed() {
        ScaleDegreeReparameterize.PENTATONIC.put(DiatonicDegree.VII, 7);
    }

    @Test
    public void getByIndex() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize.put(DiatonicDegree.I, 0);
        assertNotNull(scaleDiatonicReparameterize.getByKey(DiatonicDegree.I));
    }

    @Test
    public void getByKey() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize.put(DiatonicDegree.I, 0);
        assertNotNull(scaleDiatonicReparameterize.getByIndex(0));
    }

    @Test
    public void equalsEmpty() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        ScaleDegreeReparameterize scaleDiatonicReparameterize2 = ScaleDegreeReparameterize.create();

        assertEquals(scaleDiatonicReparameterize, scaleDiatonicReparameterize2);
        assertEquals(scaleDiatonicReparameterize2, scaleDiatonicReparameterize);
    }

    @Test
    public void equals() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize.put(DiatonicDegree.I, 0);

        ScaleDegreeReparameterize scaleDiatonicReparameterize2 = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize2.put(DiatonicDegree.I, 0);

        assertEquals(scaleDiatonicReparameterize, scaleDiatonicReparameterize2);
        assertEquals(scaleDiatonicReparameterize2, scaleDiatonicReparameterize);
    }

    @Test
    public void hashCodeTestEmpty() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        ScaleDegreeReparameterize scaleDiatonicReparameterize2 = ScaleDegreeReparameterize.create();
        assertEquals(scaleDiatonicReparameterize.hashCode(), scaleDiatonicReparameterize2.hashCode());
    }

    @Test
    public void hashCodeTest() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize.put(DiatonicDegree.I, 0);

        ScaleDegreeReparameterize scaleDiatonicReparameterize2 = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize2.put(DiatonicDegree.I, 0);

        assertEquals(scaleDiatonicReparameterize.hashCode(), scaleDiatonicReparameterize2.hashCode());
    }

    @Test
    public void hashCodeDifferentTest() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize.put(DiatonicDegree.I, 0);

        ScaleDegreeReparameterize scaleDiatonicReparameterize2 = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize2.put(DiatonicDegree.II, 0);

        assertNotEquals(scaleDiatonicReparameterize.hashCode(), scaleDiatonicReparameterize2.hashCode());
    }

    @Test
    public void cloneTest() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.PENTATONIC.clone();
        assertEquals(scaleDiatonicReparameterize, ScaleDegreeReparameterize.PENTATONIC);
        assertNotSame(scaleDiatonicReparameterize, ScaleDegreeReparameterize.PENTATONIC);
    }

    @Test
    public void cloneTestIndependentMap() {
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.PENTATONIC.clone();
        scaleDiatonicReparameterize.put(DiatonicDegree.VII, 7);
        assertNotEquals(scaleDiatonicReparameterize, ScaleDegreeReparameterize.PENTATONIC);
    }
}