package es.danisales.datune.degrees.scale;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.octave.Pentatonic;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RelativeDegreeTest {
    @Test
    public void getValuesFromScaleSizeDiatonic() {
        List<ScaleDegree> diatonicDegrees = ScaleDegree.getDefaultDegreesFromScaleSize(Diatonic.NUMBER);
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
        List<ScaleDegree> diatonicDegrees = ScaleDegree.getDefaultDegreesFromScaleSize(Chromatic.NUMBER);
        assertEquals(12, diatonicDegrees.size());
        assertSame(ChromaticDegree.I, diatonicDegrees.get(0));
        assertSame(ChromaticDegree.bII, diatonicDegrees.get(1));
        assertSame(ChromaticDegree.II, diatonicDegrees.get(2));
        assertSame(ChromaticDegree.bIII, diatonicDegrees.get(3));
        assertSame(ChromaticDegree.III, diatonicDegrees.get(4));
        assertSame(ChromaticDegree.IV, diatonicDegrees.get(5));
        assertSame(ChromaticDegree.bV, diatonicDegrees.get(6));
        assertSame(ChromaticDegree.V, diatonicDegrees.get(7));
        assertSame(ChromaticDegree.bVI, diatonicDegrees.get(8));
        assertSame(ChromaticDegree.VI, diatonicDegrees.get(9));
        assertSame(ChromaticDegree.bVII, diatonicDegrees.get(10));
        assertSame(ChromaticDegree.VII, diatonicDegrees.get(11));
    }

    @Test
    public void getValuesFromScaleSizePentatonic() {
        List<ScaleDegree> pentatonicDegrees = ScaleDegree.getDefaultDegreesFromScaleSize(Pentatonic.NUMBER);
        assertEquals(5, pentatonicDegrees.size());
        assertSame(PentatonicDegree.I, pentatonicDegrees.get(0));
        assertSame(PentatonicDegree.II, pentatonicDegrees.get(1));
        assertSame(PentatonicDegree.III, pentatonicDegrees.get(2));
        assertSame(PentatonicDegree.IV, pentatonicDegrees.get(3));
        assertSame(PentatonicDegree.V, pentatonicDegrees.get(4));
    }

    @Test
    public void getValuesFromScaleSize6() {
        List<ScaleDegree> relativeDegrees = ScaleDegree.getDefaultDegreesFromScaleSize(6);
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
        List<ScaleDegree> relativeDegrees = ScaleDegree.getDefaultDegreesFromScaleSize(6);
        List<ScaleDegree> relativeDegrees2 = ScaleDegree.getDefaultDegreesFromScaleSize(6);
        assertSame(relativeDegrees, relativeDegrees2);
    }
}