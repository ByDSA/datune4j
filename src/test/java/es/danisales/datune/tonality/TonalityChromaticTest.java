package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TonalityChromaticTest {
    @Test
    public void from_C_MAJOR() {
        TonalityModern tonality = TonalityModern.C;
        assertEquals(Chromatic.C, tonality.getRoot());
        assertEquals(Scale.MAJOR, tonality.getScale());
    }

    @Test
    public void notes_C_MAJOR() throws ScaleRelativeDegreeException {
        TonalityModern tonality = TonalityModern.C;
        assertEquals( Chromatic.C, tonality.getNote(DiatonicDegree.I) );
        assertEquals( Chromatic.D, tonality.getNote(DiatonicDegree.II) );
        assertEquals( Chromatic.E, tonality.getNote(DiatonicDegree.III) );
        assertEquals( Chromatic.F, tonality.getNote(DiatonicDegree.IV) );
        assertEquals( Chromatic.G, tonality.getNote(DiatonicDegree.V) );
        assertEquals( Chromatic.A, tonality.getNote(DiatonicDegree.VI) );
        assertEquals( Chromatic.B, tonality.getNote(DiatonicDegree.VII) );
    }

    @Test
    public void contains_E_in_C_MAJOR() {
        TonalityModern tonality = TonalityModern.C;
        assertTrue( tonality.containsAll(Chromatic.E) );
    }

    @Test
    public void contains_FF_in_C_MAJOR() {
        TonalityModern tonality = TonalityModern.C;
        assertFalse( tonality.containsAll(Chromatic.FF) );
    }

    @Test
    public void contains_chord_C_in_C_MAJOR() {
        TonalityModern tonality = TonalityModern.C;
        assertTrue( tonality.containsAll(ChromaticChord.C) );
    }

    @Test
    public void contains_chord_D_in_C_MAJOR() {
        TonalityModern tonality = TonalityModern.C;
        assertFalse( tonality.containsAll(ChromaticChord.D) );
    }

    @Test
    public void isModeOf_Cm_of_C() {
        TonalityModern tonality1 = TonalityModern.Cm;
        TonalityModern tonality2 = TonalityModern.C;
        assertTrue( tonality1.isModeOf(tonality2) );
    }

    @Test
    public void getFunction_diatonicFunction() {
        TonalityModern ton = TonalityModern.C;
        assertChromaticChordToFunction(ton, ChromaticChord.C, DiatonicFunction.I, ChromaticDegreeFunction.I, SecondaryDominant.V_IV);
        assertChromaticChordToFunction(ton, ChromaticChord.Dm, DiatonicFunction.II, ChromaticDegreeFunction.ii);
        assertChromaticChordToFunction(ton, ChromaticChord.Em, DiatonicFunction.III, ChromaticDegreeFunction.iii);
        assertChromaticChordToFunction(ton, ChromaticChord.F, DiatonicFunction.IV, ChromaticDegreeFunction.IV);
        assertChromaticChordToFunction(ton, ChromaticChord.G, DiatonicFunction.V, ChromaticDegreeFunction.V);
        assertChromaticChordToFunction(ton, ChromaticChord.Am, DiatonicFunction.VI, ChromaticDegreeFunction.vi);
        assertChromaticChordToFunction(ton, ChromaticChord.Bdim, DiatonicFunction.VII, ChromaticDegreeFunction.VII0);

        assertChromaticChordToFunction(ton, ChromaticChord.C6, DiatonicFunction.I6, ChromaticDegreeFunction.I6);
        assertChromaticChordToFunction(ton, ChromaticChord.Dm6, DiatonicFunction.II6, ChromaticDegreeFunction.IIm6);
        assertChromaticChordToFunction(ton, ChromaticChord.F6, DiatonicFunction.IV6, ChromaticDegreeFunction.IV6);
        assertChromaticChordToFunction(ton, ChromaticChord.G6, DiatonicFunction.V6, ChromaticDegreeFunction.V6);

        assertChromaticChordToFunction(ton, ChromaticChord.CMaj7, DiatonicFunction.I7, ChromaticDegreeFunction.IMaj7);
        assertChromaticChordToFunction(ton, ChromaticChord.Dm7, DiatonicFunction.II7, ChromaticDegreeFunction.ii7);
        assertChromaticChordToFunction(ton, ChromaticChord.Em7, DiatonicFunction.III7, ChromaticDegreeFunction.iii7);
        assertChromaticChordToFunction(ton, ChromaticChord.FMaj7, DiatonicFunction.IV7, ChromaticDegreeFunction.IVMaj7);
        assertChromaticChordToFunction(ton, ChromaticChord.G7, DiatonicFunction.V7, ChromaticDegreeFunction.V7);
        assertChromaticChordToFunction(ton, ChromaticChord.Am7, DiatonicFunction.VI7, ChromaticDegreeFunction.vi7);
        assertChromaticChordToFunction(ton, ChromaticChord.Bm7b5, DiatonicFunction.VII7, ChromaticDegreeFunction.vii7b5);
    }

    private <C extends CyclicDegree> void assertChromaticChordToFunction(Tonality<C> tonality, ChromaticChord chromaticChord, HarmonicFunction... harmonicFunction) {
        Set<HarmonicFunction> functions = tonality.getFunctionsFrom(chromaticChord);
        assertEquals(harmonicFunction.length, functions.size());
        assertTrue(functions.containsAll(Arrays.asList(harmonicFunction)));
    }

    @Test
    public void getFunction_chromaticDegree() {
        Tonality ton = TonalityModern.C;

        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.Csus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Csus4).contains(ChromaticDegreeFunction.ISUS4));
        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.Dsus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Dsus4).contains(ChromaticDegreeFunction.IISUS4));
        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.Gsus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Gsus4).contains(ChromaticDegreeFunction.VSUS4));
        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.Asus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Asus4).contains(ChromaticDegreeFunction.VISUS4));

        ton = TonalityModern.Cm;

        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.DDsus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.DDsus4).contains(ChromaticDegreeFunction.bIIISUS4));
    }

    @Test
    public void hasFromDiatonicFunction() {
        for (TonalityModern t : TonalityRetrieval.ALL_MAJOR_MINOR)
            for (DiatonicFunction df : DiatonicFunction.immutableValues()) {
                ChromaticChord chromaticChord = df.getChord(t);
                Assert.assertTrue(t.toString() + " " + df.toString() + " " + chromaticChord, t.containsAll(chromaticChord));
            }
    }

    @Test
    public void getChromaticFunction() {
        TonalityModern t = TonalityModern.C;
        for (ChromaticDegreeFunction cf : SecondaryDominant.values()) {
            assertNotNull(cf.getChord(t));
        }
    }

    @Test
    public void getChordFromHarmonicFunction() {
        TonalityModern t = TonalityModern.C;

        assertNotNull( DiatonicFunction.I.getChord(t) );
    }

    /* Main Major And Minor */

    @Test
    public void mainMajorMinorAreMajorOrMinor() {
        Set<TonalityModern> tonalityList = TonalityRetrieval.ALL_MAJOR_MINOR;

        for (Tonality tonality : tonalityList)
            assertTrue(ScaleUtils.isMajorOrMinor(tonality.getScale()));
    }

    /* From ChordProxy */

    @Test
    public void valuesSize() {
        Set<TonalityModern> tonalities = TonalityRetrieval.ALL_MAJOR_MINOR;

        Assert.assertEquals( 24, tonalities.size() );
    }

    @Test
    public void allSize() {
        List<TonalityModern> tonalities = TonalityRetrieval.allUsualKeys();

        Assert.assertEquals(Scale.allUsualScales().size() * Chromatic.NUMBER, tonalities.size());
    }

    private void allContains(TonalityModern tonality) {
        List<TonalityModern> tonalities = TonalityRetrieval.allUsualKeys();

        Assert.assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    @Test
    public void allContains1() {
        allContains(TonalityModern.C);
    }

    @Test
    public void allContains2() {
        allContains(TonalityModern.C);
    }

    @Test
    public void allContains3() {
        allContains(TonalityModern.GG);
    }

    @Test
    public void allContains4() {
        allContains(Tonality.from(Chromatic.FF, Scale.DORIAN));
    }

    @Test
    public void allContains5() {
        allContains(Tonality.from(Chromatic.GG, Scale.DORIAN));
    }

}
