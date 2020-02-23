package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.TonalityModern;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChromaticDegreeFunctionTest {
    @Test
    public void MAJOR_toString() {
        assertEquals("I" , ChromaticDegreeFunction.I.toString());
        assertEquals("bII" , ChromaticDegreeFunction.bII.toString());
        assertEquals("II" , ChromaticDegreeFunction.II.toString());
        assertEquals("bIII" , ChromaticDegreeFunction.bIII.toString());
        assertEquals("III" , ChromaticDegreeFunction.III.toString());
        assertEquals("IV" , ChromaticDegreeFunction.IV.toString());
        assertEquals("bV" , ChromaticDegreeFunction.bV.toString());
        assertEquals("V" , ChromaticDegreeFunction.V.toString());
        assertEquals("bVI" , ChromaticDegreeFunction.bVI.toString());
        assertEquals("VI" , ChromaticDegreeFunction.VI.toString());
        assertEquals("bVII" , ChromaticDegreeFunction.bVII.toString());
        assertEquals("VII" , ChromaticDegreeFunction.VII.toString());
    }

    @Test
    public void SECONDARY_DOMINANT_V_toString() {
        assertEquals("V/II" , SecondaryDominant.V_II.toString());
        assertEquals("V/III" , SecondaryDominant.V_III.toString());
        assertEquals("V/IV" , SecondaryDominant.V_IV.toString());
        assertEquals("V/V" , SecondaryDominant.V_V.toString());
        assertEquals("V/VI" , SecondaryDominant.V_VI.toString());
    }

    @Test
    public void SECONDARY_DOMINANT_V7_toString() {
        assertEquals("V7/II" , SecondaryDominant.V7_II.toString());
        assertEquals("V7/III" , SecondaryDominant.V7_III.toString());
        assertEquals("V7/IV" , SecondaryDominant.V7_IV.toString());
        assertEquals("V7/V" , SecondaryDominant.V7_V.toString());
        assertEquals("V7/VI" , SecondaryDominant.V7_VI.toString());
    }

    @Test
    public void SECONDARY_DOMINANT_SUBV7_toString() {
        assertEquals("SUBV7/II" , SecondaryDominant.SUBV7_II.toString());
        assertEquals("SUBV7/III" , SecondaryDominant.SUBV7_III.toString());
        assertEquals("SUBV7/IV" , SecondaryDominant.SUBV7_IV.toString());
        assertEquals("SUBV7/V" , SecondaryDominant.SUBV7_V.toString());
        assertEquals("SUBV7/VI" , SecondaryDominant.SUBV7_VI.toString());
    }

    @Test
    public void normal_ii() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = CompoundFunction.from(ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChord(TonalityModern.C);

        assertEquals(ChromaticChord.Dm, chromaticChord);
    }

    @Test
    public void secondaryDominant__V_V() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = CompoundFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.V);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChord(TonalityModern.C);

        assertEquals(ChromaticChord.D, chromaticChord);
    }

    @Test
    public void secondaryDominant__v_V() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = CompoundFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.v);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChord(TonalityModern.C);

        assertEquals(ChromaticChord.Dm, chromaticChord);
    }

    @Test
    public void normal__V_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = CompoundFunction.from(ChromaticDegreeFunction.V7);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChord(TonalityModern.DD);

        assertEquals(ChromaticChord.AA7, chromaticChord);
    }

    @Test
    public void secondaryDominant__v_V_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = CompoundFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.v);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChord(TonalityModern.DD);

        assertEquals(ChromaticChord.Fm, chromaticChord);
    }

    @Test
    public void secondaryDominant__ii_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = CompoundFunction.from(ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChord(TonalityModern.DD);

        assertEquals(ChromaticChord.Fm, chromaticChord);
    }

    @Test
    public void secondaryDominant__V7_ii_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = CompoundFunction.from(ChromaticDegreeFunction.ii, ChromaticDegreeFunction.V7);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChord(TonalityModern.DD);

        assertEquals(ChromaticChord.C7, chromaticChord);
    }

    @Test
    public void secondaryDominant__ii_ii_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = CompoundFunction.from(ChromaticDegreeFunction.ii, ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChord(TonalityModern.DD);

        assertEquals(ChromaticChord.Gm, chromaticChord);
    }

}