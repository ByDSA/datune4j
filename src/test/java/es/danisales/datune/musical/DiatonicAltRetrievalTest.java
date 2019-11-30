package es.danisales.datune.musical;

import es.danisales.datune.degree.RelativeDegree;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleDistance;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DiatonicAltRetrievalTest {

    @Test
    public void listFromAlterations() { // todo
    }

    @Test
    public void listFrom() { // todo
    }

    @Test
    public void areEnharmonic() { // todo
    }

    @Test
    public void getEnharmonicsFrom() {
        // todo
    }

    @Test
    public void getNoteAbsoluteDegree3() {
        Scale scale = Scale.fromIntegers(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        RelativeDegree relativeDegree = RelativeDegree.valuesFrom(scale.size()).get(0);
        Tonality tonality = Tonality.from(DiatonicAlt.C, scale);
        System.out.println(tonality.getNotes());
        assertEquals(DiatonicAlt.C,
                tonality.getNote(relativeDegree));

        relativeDegree = RelativeDegree.valuesFrom(scale.size()).get(8);

        assertEquals(DiatonicAlt.GG,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getNoteAbsoluteDegreeMicrotonal() {
        Scale scale = Scale.fromDistances( Arrays.asList(
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ));
        List<DiatonicAlt> diatonicAltList = DiatonicAltRetrieval.listFrom(DiatonicAlt.C, scale);
System.out.println(diatonicAltList);
        assertEquals(11, diatonicAltList.size());

        assertSame(DiatonicAlt.C, diatonicAltList.get(0));
        assertEquals(DiatonicAlt.C.add(ScaleDistance.QUARTER), diatonicAltList.get(1));
        assertEquals(DiatonicAlt.CC, diatonicAltList.get(2));
        assertEquals(DiatonicAlt.D.sub(ScaleDistance.QUARTER), diatonicAltList.get(3));
        assertSame(DiatonicAlt.D, diatonicAltList.get(4));
        assertEquals(DiatonicAlt.D.add(ScaleDistance.QUARTER), diatonicAltList.get(5));
        assertSame(DiatonicAlt.DD, diatonicAltList.get(6));
        assertSame(DiatonicAlt.F, diatonicAltList.get(7));
        assertSame(DiatonicAlt.G, diatonicAltList.get(8));
        assertSame(DiatonicAlt.A, diatonicAltList.get(9));
        assertSame(DiatonicAlt.B, diatonicAltList.get(10));
    }
}