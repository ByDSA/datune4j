package es.danisales.datune.chords;

import es.danisales.datune.degrees.scale.DiatonicDegree;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class DiatonicDegreePatternTest {
    @Test
    public void getWithOmitted() {
        DiatonicDegreePattern diatonicDegreePattern = DiatonicDegreePattern.I.getWithOmitted(DiatonicDegree.III);
        assertSame(DiatonicDegreePattern.I_FIFTH, diatonicDegreePattern);
    }

    @Test
    public void getWithOmitted_thereIsNot() {
        DiatonicDegreePattern diatonicDegreePattern = DiatonicDegreePattern.II.getWithOmitted(DiatonicDegree.III);
        assertSame(DiatonicDegreePattern.II, diatonicDegreePattern);
    }
}