package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.function.DiatonicFunction;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TonalityRetrievalTest {
    /* Main Major */

    @Test
    public void mainMajorSize() {
        Set<TonalityModern> tonalitySet = TonalityRetrieval.ALL_MAJOR;

        assertEquals(12, tonalitySet.size());
    }

    @Test
    public void mainMajorContent() {
        Set<TonalityModern> tonalitySet = TonalityRetrieval.ALL_MAJOR;

        assertTrue(tonalitySet.contains(TonalityModern.C));
        assertTrue(tonalitySet.contains(TonalityModern.CC));
        assertTrue(tonalitySet.contains(TonalityModern.D));
        assertTrue(tonalitySet.contains(TonalityModern.DD));
        assertTrue(tonalitySet.contains(TonalityModern.E));
        assertTrue(tonalitySet.contains(TonalityModern.F));
        assertTrue(tonalitySet.contains(TonalityModern.FF));
        assertTrue(tonalitySet.contains(TonalityModern.G));
        assertTrue(tonalitySet.contains(TonalityModern.GG));
        assertTrue(tonalitySet.contains(TonalityModern.A));
        assertTrue(tonalitySet.contains(TonalityModern.AA));
        assertTrue(tonalitySet.contains(TonalityModern.B));
    }

    @Test
    public void mainMajorAreReallyMajor() {
        Set<TonalityModern> tonalitySet = TonalityRetrieval.ALL_MAJOR;

        for (Tonality tonality : tonalitySet)
            assertEquals(tonality.getScale(), Scale.MAJOR);
    }

    /* Main Minor */

    @Test
    public void getScale_ALL_MINOR() {
        Set<TonalityModern> tonalities = TonalityRetrieval.ALL_MINOR;
        for (TonalityModern tonality : tonalities)
            TestCase.assertEquals(tonality.getScale(), Scale.MINOR);
    }

    @Test
    public void getScale_ALL_MAJOR() {
        Set<TonalityModern> tonalities = TonalityRetrieval.ALL_MAJOR;
        for (TonalityModern tonality : tonalities)
            TestCase.assertEquals(tonality.getScale(), Scale.MAJOR);
    }

    @Test
    public void mainMinorSize() {
        Set<TonalityModern> tonalityList = TonalityRetrieval.ALL_MINOR;

        assertEquals(12, tonalityList.size());
    }

    @Test
    public void mainMinorContent() {
        Set<TonalityModern> tonalitySet = TonalityRetrieval.ALL_MINOR;

        assertTrue(tonalitySet.contains(TonalityModern.Cm));
        assertTrue(tonalitySet.contains(TonalityModern.CCm));
        assertTrue(tonalitySet.contains(TonalityModern.Dm));
        assertTrue(tonalitySet.contains(TonalityModern.DDm));
        assertTrue(tonalitySet.contains(TonalityModern.Em));
        assertTrue(tonalitySet.contains(TonalityModern.Fm));
        assertTrue(tonalitySet.contains(TonalityModern.FFm));
        assertTrue(tonalitySet.contains(TonalityModern.Gm));
        assertTrue(tonalitySet.contains(TonalityModern.GGm));
        assertTrue(tonalitySet.contains(TonalityModern.Am));
        assertTrue(tonalitySet.contains(TonalityModern.AAm));
        assertTrue(tonalitySet.contains(TonalityModern.Bm));
    }

    @Test
    public void mainMinorAreReallyMinor() {
        Set<TonalityModern> tonalityList = TonalityRetrieval.ALL_MINOR;

        for (Tonality tonality : tonalityList)
            assertEquals(tonality.getScale(), Scale.MINOR);
    }

    @Test(timeout = 1500)
    public void fromChordHarmonicFunction() {
        List<TonalityModern> ts = TonalityRetrieval.listFromChordAllFunctions(ChromaticChord.C);
        assertFalse(ts.isEmpty());
    }

    @Test
    public void getEnharmonicMinimalAltsFromPentatonic() {
        TonalityClassical target = Tonality.from(DiatonicAlt.Eb, Scale.PENTATONIC_MINOR);
        TonalityClassical target2 = Tonality.from(DiatonicAlt.DD, Scale.PENTATONIC_MINOR);
        TonalityClassical source = Tonality.from(DiatonicAlt.Fbb, Scale.PENTATONIC_MINOR);
        Set<TonalityClassical> result = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(source);

        assertEquals(2, result.size());
        assertTrue(result.contains(target));
        assertTrue(result.contains(target2));
    }

    @Test
    public void getEnharmonicMinimalAltsFromDiatonic() {
        TonalityClassical target1 = TonalityClassical.FF;
        TonalityClassical target2 = TonalityClassical.Gb;
        TonalityClassical tonality = Tonality.from(DiatonicAlt.EEE, Scale.MAJOR);
        Set<TonalityClassical> result = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(tonality);

        assertEquals(2, result.size());
        assertTrue(result.contains(target1));
        assertTrue(result.contains(target2));
    }



    @Test
    public void C_iv() throws ScaleRelativeDegreeException {
        ChromaticChord chromaticChord = DiatonicFunction.IV.getChord(TonalityModern.C);

        assertEquals(ChromaticChord.F, chromaticChord);
    }

    @Test
    public void bb() {
        List<ChromaticChord> chromaticChordProgression = new ArrayList<>();
        chromaticChordProgression.add(ChromaticChord.C);
        chromaticChordProgression.add(ChromaticChord.G);
        chromaticChordProgression.add(ChromaticChord.Am);
        chromaticChordProgression.add(ChromaticChord.F);

        List<TonalityModern> t = new ArrayList<>();
        t.addAll(TonalityRetrieval.ALL_MAJOR_MODES);
        t.addAll(TonalityRetrieval.ALL_HARMONIC_MINOR_MODES);
        t.addAll(TonalityRetrieval.ALL_MELODIC_MINOR_MODES);

        List<TonalityModern> tonalities = TonalityRetrieval.fromChordProgression(chromaticChordProgression, t);
        System.out.println(tonalities);
    }
}
