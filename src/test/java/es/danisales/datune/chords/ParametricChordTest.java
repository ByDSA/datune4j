package es.danisales.datune.chords;

import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParametricChordTest {

    @Test
    public void from() {
        ParametricChord parametricChord = ParametricChord.from(Tonality.C, DiatonicFunction.I);
        assertEquals(Tonality.C, parametricChord.getTonality());
        assertEquals(DiatonicFunction.I, parametricChord.getHarmonicFunction());
    }

    @Test
    public void setTonality() {
        ParametricChord parametricChord = ParametricChord.from(Tonality.C, DiatonicFunction.I);
        parametricChord.setTonality(Tonality.D);
        assertEquals(Tonality.D, parametricChord.getTonality());
    }

    @Test
    public void setHarmonicFunction() {
        ParametricChord parametricChord = ParametricChord.from(Tonality.C, DiatonicFunction.I);
        parametricChord.setHarmonicFunction(ChromaticFunction.II);
        assertEquals(ChromaticFunction.II, parametricChord.getHarmonicFunction());
    }

    @Test
    public void equals() {
        ParametricChord parametricChord1 = ParametricChord.from(Tonality.C, DiatonicFunction.I);
        ParametricChord parametricChord2 = ParametricChord.from(Tonality.C, DiatonicFunction.I);

        assertEquals(parametricChord1, parametricChord2);
    }

    @Test
    public void hashCodeTest() {
        ParametricChord parametricChord1 = ParametricChord.from(Tonality.C, DiatonicFunction.I);
        ParametricChord parametricChord2 = ParametricChord.from(Tonality.C, DiatonicFunction.I);

        assertEquals(parametricChord1.hashCode(), parametricChord2.hashCode());
    }
}