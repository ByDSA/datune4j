package es.danisales.datune.chords.chromatic;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.TonalityModern;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChromaticChordRetrievalTest {
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

        assertEquals(6, chromaticChordSet.size());
        assertTrue(chromaticChordSet.contains(ChromaticChord.Em7a5));
        assertTrue(chromaticChordSet.contains(ChromaticChord.Am7));
        assertTrue(chromaticChordSet.contains(ChromaticChord.CMaj7));
        assertTrue(chromaticChordSet.contains(ChromaticChord.C7add13));
        assertTrue(chromaticChordSet.contains(ChromaticChord.C7add11));
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
}