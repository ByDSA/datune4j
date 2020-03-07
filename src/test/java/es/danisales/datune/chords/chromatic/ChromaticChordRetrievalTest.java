package es.danisales.datune.chords.chromatic;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.TonalityModern;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChromaticChordRetrievalTest {
    @Test
    public void fifths_contains_C() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromFifths()
                .whichContains(Chromatic.C)
                .retrieve();

        assertEquals(2, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.C5));
        assertTrue(chromaticChordSet.contains(ChromaticChord.F5));
    }

    @Test
    public void triads_contains_C_E_G() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromTriads()
                .whichContains(Chromatic.C, Chromatic.E, Chromatic.G)
                .retrieve();

        assertEquals(1, chromaticChordSet.size());
        assertEquals(ChromaticChord.C, chromaticChordSet.iterator().next());
    }

    @Test
    public void triads_contains_C_E() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromTriads()
                .whichContains(Chromatic.C, Chromatic.E)
                .retrieve();

        assertEquals(5, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.GGaug));
        assertTrue(chromaticChordSet.contains(ChromaticChord.Am));
        assertTrue(chromaticChordSet.contains(ChromaticChord.Caug));
        assertTrue(chromaticChordSet.contains(ChromaticChord.C));
        assertTrue(chromaticChordSet.contains(ChromaticChord.Eaug));
    }

    @Test
    public void seventh_contains_C_E_G() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromSevenths()
                .whichContains(Chromatic.C, Chromatic.E, Chromatic.G)
                .retrieve();

        assertEquals(4, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.Em7a5));
        assertTrue(chromaticChordSet.contains(ChromaticChord.Am7));
        assertTrue(chromaticChordSet.contains(ChromaticChord.CMaj7));
        assertTrue(chromaticChordSet.contains(ChromaticChord.C7));
    }

    @Test
    public void seventh_contains_C_E_G_Tonality_any_C_Am() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromSevenths()
                .whichContains(Chromatic.C, Chromatic.E, Chromatic.G)
                .inAnyTonalities(TonalityModern.C, TonalityModern.Am)
                .retrieve();

        assertEquals(3, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.Am7));
        assertTrue(chromaticChordSet.contains(ChromaticChord.CMaj7));
        assertTrue(chromaticChordSet.contains(ChromaticChord.C7));
    }

    @Test
    public void seventh_contains_C_E_G_Tonality_all_C_Cm() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromSevenths()
                .whichContains(Chromatic.C, Chromatic.E, Chromatic.G)
                .inAllTonalities(TonalityModern.C, TonalityModern.Cm)
                .retrieve();

        assertEquals(1, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.C7));
    }

    @Test
    public void ninth_contains_C_E_G_B() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromNinth()
                .whichContains(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B)
                .retrieve();

        assertEquals(4, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.Am9));
        assertTrue(chromaticChordSet.contains(ChromaticChord.CMaj9a11));
        assertTrue(chromaticChordSet.contains(ChromaticChord.FMaj9a11));
        assertTrue(chromaticChordSet.contains(ChromaticChord.CMaj9));
    }

    @Test
    public void eleventh_contains_C_E_G_B() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromEleventh()
                .whichContains(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B)
                .retrieve();

        assertEquals(2, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.CMaj11));
        assertTrue(chromaticChordSet.contains(ChromaticChord.Am11));
    }

    @Test
    public void thirteenth_contains_C_E_G_B_D_F() {
        Set<ChromaticChord> chromaticChordSet = ChromaticChord.retrieval()
                .fromThirteenth()
                .whichContains(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F)
                .retrieve();

        assertEquals(4, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.CMaj13));
        assertTrue(chromaticChordSet.contains(ChromaticChord.G13b9));
        assertTrue(chromaticChordSet.contains(ChromaticChord.G13a9));
        assertTrue(chromaticChordSet.contains(ChromaticChord.Dm13));
    }
}