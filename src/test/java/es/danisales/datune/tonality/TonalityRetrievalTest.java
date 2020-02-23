package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
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
        Set<Tonality<Chromatic>> tonalitySet = TonalityRetrieval.ALL_MAJOR;

        assertEquals(12, tonalitySet.size());
    }

    @Test
    public void mainMajorContent() {
        Set<Tonality<Chromatic>> tonalitySet = TonalityRetrieval.ALL_MAJOR;

        assertTrue(tonalitySet.contains(Tonality.C));
        assertTrue(tonalitySet.contains(Tonality.CC));
        assertTrue(tonalitySet.contains(Tonality.D));
        assertTrue(tonalitySet.contains(Tonality.DD));
        assertTrue(tonalitySet.contains(Tonality.E));
        assertTrue(tonalitySet.contains(Tonality.F));
        assertTrue(tonalitySet.contains(Tonality.FF));
        assertTrue(tonalitySet.contains(Tonality.G));
        assertTrue(tonalitySet.contains(Tonality.GG));
        assertTrue(tonalitySet.contains(Tonality.A));
        assertTrue(tonalitySet.contains(Tonality.AA));
        assertTrue(tonalitySet.contains(Tonality.B));
    }

    @Test
    public void mainMajorAreReallyMajor() {
        Set<Tonality<Chromatic>> tonalitySet = TonalityRetrieval.ALL_MAJOR;

        for (Tonality tonality : tonalitySet)
            assertEquals(tonality.getScale(), Scale.MAJOR);
    }

    /* Main Minor */

    @Test
    public void getScale_ALL_MINOR() {
        Set<Tonality<Chromatic>> tonalities = TonalityRetrieval.ALL_MINOR;
        for (Tonality<Chromatic> tonality : tonalities)
            TestCase.assertEquals(tonality.getScale(), Scale.MINOR);
    }

    @Test
    public void getScale_ALL_MAJOR() {
        Set<Tonality<Chromatic>> tonalities = TonalityRetrieval.ALL_MAJOR;
        for (Tonality<Chromatic> tonality : tonalities)
            TestCase.assertEquals(tonality.getScale(), Scale.MAJOR);
    }

    @Test
    public void mainMinorSize() {
        Set<Tonality<Chromatic>> tonalityList = TonalityRetrieval.ALL_MINOR;

        assertEquals(12, tonalityList.size());
    }

    @Test
    public void mainMinorContent() {
        Set<Tonality<Chromatic>> tonalitySet = TonalityRetrieval.ALL_MINOR;

        assertTrue(tonalitySet.contains(Tonality.Cm));
        assertTrue(tonalitySet.contains(Tonality.CCm));
        assertTrue(tonalitySet.contains(Tonality.Dm));
        assertTrue(tonalitySet.contains(Tonality.DDm));
        assertTrue(tonalitySet.contains(Tonality.Em));
        assertTrue(tonalitySet.contains(Tonality.Fm));
        assertTrue(tonalitySet.contains(Tonality.FFm));
        assertTrue(tonalitySet.contains(Tonality.Gm));
        assertTrue(tonalitySet.contains(Tonality.GGm));
        assertTrue(tonalitySet.contains(Tonality.Am));
        assertTrue(tonalitySet.contains(Tonality.AAm));
        assertTrue(tonalitySet.contains(Tonality.Bm));
    }

    @Test
    public void mainMinorAreReallyMinor() {
        Set<Tonality<Chromatic>> tonalityList = TonalityRetrieval.ALL_MINOR;

        for (Tonality tonality : tonalityList)
            assertEquals(tonality.getScale(), Scale.MINOR);
    }

    @Test(timeout = 1000)
    public void fromChordHarmonicFunction() {
        List<Tonality<Chromatic>> ts = TonalityRetrieval.listFromChordAllFunctions(ChromaticChord.C);
        assertFalse(ts.isEmpty());
    }

    @Test
    public void getEnharmonicMinimalAltsFromPentatonic() {
        Tonality<DiatonicAlt> target = Tonality.from(DiatonicAlt.Eb, Scale.PENTATONIC_MINOR);
        Tonality<DiatonicAlt> target2 = Tonality.from(DiatonicAlt.DD, Scale.PENTATONIC_MINOR);
        Tonality<DiatonicAlt> source = Tonality.from(DiatonicAlt.Fbb, Scale.PENTATONIC_MINOR);
        Set<Tonality<DiatonicAlt>> result = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(source);

        assertEquals(2, result.size());
        assertTrue(result.contains(target));
        assertTrue(result.contains(target2));
    }

    @Test
    public void getEnharmonicMinimalAltsFromDiatonic() {
        Tonality<DiatonicAlt> target1 = Tonality.Classical.FF;
        Tonality<DiatonicAlt> target2 = Tonality.Classical.Gb;
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.EEE, Scale.MAJOR);
        Set<Tonality<DiatonicAlt>> result = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(tonality);

        assertEquals(2, result.size());
        assertTrue(result.contains(target1));
        assertTrue(result.contains(target2));
    }



    @Test
    public void C_iv() throws ScaleRelativeDegreeException {
        ChromaticChord chromaticChord = DiatonicFunction.IV.getChromaticChordFromTonality(Tonality.C);

        assertEquals(ChromaticChord.F, chromaticChord);
    }

    @Test
    public void bb() {
        List<ChromaticChord> chromaticChordProgression = new ArrayList<>();
        chromaticChordProgression.add(ChromaticChord.C);
        chromaticChordProgression.add(ChromaticChord.G);
        chromaticChordProgression.add(ChromaticChord.Am);
        chromaticChordProgression.add(ChromaticChord.F);

        List<Tonality<Chromatic>> t = new ArrayList<>();
        t.addAll(TonalityRetrieval.ALL_MAJOR_MODES);
        t.addAll(TonalityRetrieval.ALL_HARMONIC_MINOR_MODES);
        t.addAll(TonalityRetrieval.ALL_MELODIC_MINOR_MODES);

        List<Tonality<Chromatic>> tonalities = TonalityRetrieval.fromChordProgression(chromaticChordProgression, t);
        System.out.println(tonalities);
    }
}
