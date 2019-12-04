package es.danisales.datune.degree;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.absolutedegree.Pentatonic;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RelativeDegreeTest {
    @Test
    public void getValuesFromScaleSizeDiatonic() {
        List<Degree> diatonicDegrees = Degree.getMainDegreesFromScaleSize(Diatonic.NUMBER);
        assertEquals(7, diatonicDegrees.size());
        assertSame(DiatonicDegree.I, diatonicDegrees.get(0));
        assertSame(DiatonicDegree.II, diatonicDegrees.get(1));
        assertSame(DiatonicDegree.III, diatonicDegrees.get(2));
        assertSame(DiatonicDegree.IV, diatonicDegrees.get(3));
        assertSame(DiatonicDegree.V, diatonicDegrees.get(4));
        assertSame(DiatonicDegree.VI, diatonicDegrees.get(5));
        assertSame(DiatonicDegree.VII, diatonicDegrees.get(6));
    }

    @Test
    public void getValuesFromScaleSizeChromatic() {
        List<Degree> diatonicDegrees = Degree.getMainDegreesFromScaleSize(Chromatic.NUMBER);
        assertEquals(12, diatonicDegrees.size());
        assertSame(ChromaticDegree.I, diatonicDegrees.get(0));
        assertSame(ChromaticDegree.II, diatonicDegrees.get(1));
        assertSame(ChromaticDegree.III, diatonicDegrees.get(2));
        assertSame(ChromaticDegree.IV, diatonicDegrees.get(3));
        assertSame(ChromaticDegree.V, diatonicDegrees.get(4));
        assertSame(ChromaticDegree.VI, diatonicDegrees.get(5));
        assertSame(ChromaticDegree.VII, diatonicDegrees.get(6));
        assertSame(ChromaticDegree.VIII, diatonicDegrees.get(7));
        assertSame(ChromaticDegree.IX, diatonicDegrees.get(8));
        assertSame(ChromaticDegree.X, diatonicDegrees.get(9));
        assertSame(ChromaticDegree.XI, diatonicDegrees.get(10));
        assertSame(ChromaticDegree.XII, diatonicDegrees.get(11));
    }

    @Test
    public void getValuesFromScaleSizePentatonic() {
        List<Degree> pentatonicDegrees = Degree.getMainDegreesFromScaleSize(Pentatonic.NUMBER);
        assertEquals(5, pentatonicDegrees.size());
        assertSame(PentatonicDegree.I, pentatonicDegrees.get(0));
        assertSame(PentatonicDegree.II, pentatonicDegrees.get(1));
        assertSame(PentatonicDegree.III, pentatonicDegrees.get(2));
        assertSame(PentatonicDegree.IV, pentatonicDegrees.get(3));
        assertSame(PentatonicDegree.V, pentatonicDegrees.get(4));
    }

    @Test
    public void getValuesFromScaleSize6() {
        List<Degree> relativeDegrees = Degree.getMainDegreesFromScaleSize(6);
        assertEquals(6, relativeDegrees.size());
        assertNotNull(relativeDegrees.get(0));
        assertNotNull(relativeDegrees.get(1));
        assertNotNull(relativeDegrees.get(2));
        assertNotNull(relativeDegrees.get(3));
        assertNotNull(relativeDegrees.get(4));
        assertNotNull(relativeDegrees.get(5));
    }

    @Test
    public void getValuesFromScaleSize6AlwaysTheSame() {
        List<Degree> relativeDegrees = Degree.getMainDegreesFromScaleSize(6);
        List<Degree> relativeDegrees2 = Degree.getMainDegreesFromScaleSize(6);
        assertSame(relativeDegrees, relativeDegrees2);
    }
}