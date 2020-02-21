package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
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
        assertEquals("V/II" , ChromaticDegreeFunction.V_II.toString());
        assertEquals("V/III" , ChromaticDegreeFunction.V_III.toString());
        assertEquals("V/IV" , ChromaticDegreeFunction.V_IV.toString());
        assertEquals("V/V" , ChromaticDegreeFunction.V_V.toString());
        assertEquals("V/VI" , ChromaticDegreeFunction.V_VI.toString());
    }

    @Test
    public void SECONDARY_DOMINANT_V7_toString() {
        assertEquals("V7/II" , ChromaticDegreeFunction.V7_II.toString());
        assertEquals("V7/III" , ChromaticDegreeFunction.V7_III.toString());
        assertEquals("V7/IV" , ChromaticDegreeFunction.V7_IV.toString());
        assertEquals("V7/V" , ChromaticDegreeFunction.V7_V.toString());
        assertEquals("V7/VI" , ChromaticDegreeFunction.V7_VI.toString());
    }

    @Test
    public void SECONDARY_DOMINANT_SUBV7_toString() {
        assertEquals("SUBV7/II" , ChromaticDegreeFunction.SUBV7_II.toString());
        assertEquals("SUBV7/III" , ChromaticDegreeFunction.SUBV7_III.toString());
        assertEquals("SUBV7/IV" , ChromaticDegreeFunction.SUBV7_IV.toString());
        assertEquals("SUBV7/V" , ChromaticDegreeFunction.SUBV7_V.toString());
        assertEquals("SUBV7/VI" , ChromaticDegreeFunction.SUBV7_VI.toString());
    }

    @Test
    public void normal_ii() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.from(ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.C);

        assertEquals(ChromaticChord.Dm, chromaticChord);
    }

    @Test
    public void secondaryDominant__V_V() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.V);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.C);

        assertEquals(ChromaticChord.D, chromaticChord);
    }

    @Test
    public void secondaryDominant__v_V() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.v);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.C);

        assertEquals(ChromaticChord.Dm, chromaticChord);
    }

    @Test
    public void normal__V_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.from(ChromaticDegreeFunction.V7);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.AA7, chromaticChord);
    }

    @Test
    public void secondaryDominant__v_V_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.from(ChromaticDegreeFunction.V, ChromaticDegreeFunction.v);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.Fm, chromaticChord);
    }

    @Test
    public void secondaryDominant__ii_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.from(ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.Fm, chromaticChord);
    }

    @Test
    public void secondaryDominant__V7_ii_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.from(ChromaticDegreeFunction.ii, ChromaticDegreeFunction.V7);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.C7, chromaticChord);
    }

    @Test
    public void secondaryDominant__ii_ii_Eb() throws ScaleRelativeDegreeException {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.from(ChromaticDegreeFunction.ii, ChromaticDegreeFunction.ii);

        ChromaticChord chromaticChord = chromaticDegreeFunction.getChromaticChordFromTonality(Tonality.ET12.DD);

        assertEquals(ChromaticChord.Gm, chromaticChord);
    }

}