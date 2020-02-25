package es.danisales.datune.chords;

import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.tonality.TonalityModern;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TonalChordTest {
    @Test
    public void from() {
        TonalChord parametricChord = TonalChord.from(TonalityModern.C, DiatonicFunction.I);
        assertEquals(TonalityModern.C, parametricChord.getTonality());
        assertEquals(DiatonicFunction.I, parametricChord.getHarmonicFunction());
    }

    @Test
    public void setTonalityModern() {
        TonalChord parametricChord = TonalChord.from(TonalityModern.C, DiatonicFunction.I);
        parametricChord.setTonality(TonalityModern.D);
        assertEquals(TonalityModern.D, parametricChord.getTonality());
    }

    @Test
    public void setHarmonicFunction() {
        TonalChord parametricChord = TonalChord.from(TonalityModern.C, DiatonicFunction.I);
        parametricChord.setHarmonicFunction(ChromaticDegreeFunction.II);
        assertEquals(ChromaticDegreeFunction.II, parametricChord.getHarmonicFunction());
    }

    @Test
    public void equals() {
        TonalChord parametricChord1 = TonalChord.from(TonalityModern.C, DiatonicFunction.I);
        TonalChord parametricChord2 = TonalChord.from(TonalityModern.C, DiatonicFunction.I);

        assertEquals(parametricChord1, parametricChord2);
    }

    @Test
    public void hashCodeTest() {
        TonalChord parametricChord1 = TonalChord.from(TonalityModern.C, DiatonicFunction.I);
        TonalChord parametricChord2 = TonalChord.from(TonalityModern.C, DiatonicFunction.I);

        assertEquals(parametricChord1.hashCode(), parametricChord2.hashCode());
    }
}