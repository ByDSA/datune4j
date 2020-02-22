package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.utils.building.BuildingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TonalityChromaticTest {
    @Test
    public void from_C_MAJOR() {
        Tonality<Chromatic> tonality = Tonality.ET12.C;
        assertEquals(Chromatic.C, tonality.getRoot());
        assertEquals(Scale.MAJOR, tonality.getScale());
    }

    @Test
    public void notes_C_MAJOR() throws ScaleRelativeDegreeException {
        Tonality<Chromatic> tonality = Tonality.ET12.C;
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
        Tonality<Chromatic> tonality = Tonality.ET12.C;
        assertTrue( tonality.containsAll(Chromatic.E) );
    }

    @Test
    public void contains_FF_in_C_MAJOR() {
        Tonality<Chromatic> tonality = Tonality.ET12.C;
        assertFalse( tonality.containsAll(Chromatic.FF) );
    }

    @Test
    public void contains_chord_C_in_C_MAJOR() {
        Tonality<Chromatic> tonality = Tonality.ET12.C;
        assertTrue( tonality.containsAll(ChromaticChord.C) );
    }

    @Test
    public void contains_chord_D_in_C_MAJOR() {
        Tonality<Chromatic> tonality = Tonality.ET12.C;
        assertFalse( tonality.containsAll(ChromaticChord.D) );
    }

    @Test
    public void isModeOf_Cm_of_C() {
        Tonality<Chromatic> tonality1 = Tonality.ET12.Cm;
        Tonality<Chromatic> tonality2 = Tonality.ET12.C;
        assertTrue( tonality1.isModeOf(tonality2) );
    }
    
    @Test
    public void getFunction_diatonicFunction() {
        Tonality ton = Tonality.ET12.C;
        assertTrue(ton.getFunctionsFrom(ChromaticChord.C).contains(DiatonicFunction.I));
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Dm).contains(DiatonicFunction.II));
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Em).contains(DiatonicFunction.III));
        assertTrue(ton.getFunctionsFrom(ChromaticChord.F).contains(DiatonicFunction.IV));
        assertTrue(ton.getFunctionsFrom(ChromaticChord.G).contains(DiatonicFunction.V));
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Am).contains(DiatonicFunction.VI));
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Bdim).contains(DiatonicFunction.VII));

        assertEquals(DiatonicFunction.I6, ton.getFunctionsFrom(ChromaticChord.C6).iterator().next());
        assertEquals(DiatonicFunction.II6, ton.getFunctionsFrom(ChromaticChord.Dm6).iterator().next());
        assertEquals(DiatonicFunction.IV6, ton.getFunctionsFrom(ChromaticChord.F6).iterator().next());
        assertEquals(DiatonicFunction.V6, ton.getFunctionsFrom(ChromaticChord.G6).iterator().next());

        assertEquals(DiatonicFunction.I7, ton.getFunctionsFrom(ChromaticChord.CMaj7).iterator().next());
        assertEquals(DiatonicFunction.II7, ton.getFunctionsFrom(ChromaticChord.Dm7).iterator().next());
        assertEquals(DiatonicFunction.III7, ton.getFunctionsFrom(ChromaticChord.Em7).iterator().next());
        assertEquals(DiatonicFunction.IV7, ton.getFunctionsFrom(ChromaticChord.FMaj7).iterator().next());
        assertEquals(DiatonicFunction.V7, ton.getFunctionsFrom(ChromaticChord.G7).iterator().next());
        assertEquals(DiatonicFunction.VI7, ton.getFunctionsFrom(ChromaticChord.Am7).iterator().next());
        assertEquals(DiatonicFunction.VII7, ton.getFunctionsFrom(ChromaticChord.Bm7b5).iterator().next());
    }

    @Test
    public void getFunction_chromaticDegree() {
        Tonality ton = Tonality.ET12.C;

        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.Csus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Csus4).contains(ChromaticDegreeFunction.ISUS4));
        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.Dsus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Dsus4).contains(ChromaticDegreeFunction.IISUS4));
        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.DDsus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.DDsus4).contains(ChromaticDegreeFunction.bIIISUS4));
        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.Gsus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Gsus4).contains(ChromaticDegreeFunction.VSUS4));
        assertEquals(1, ton.getFunctionsFrom(ChromaticChord.Asus4).size());
        assertTrue(ton.getFunctionsFrom(ChromaticChord.Asus4).contains(ChromaticDegreeFunction.VISUS4));
    }

    @Test
    public void hasFromDiatonicFunction() throws BuildingException {
        for (Tonality<Chromatic> t : TonalityRetrieval.ET12.ALL_MAJOR_MINOR)
            for (DiatonicFunction df : DiatonicFunction.immutableValues()) {
                ChromaticChord chromaticChord = ChromaticChord.builder()
                        .tonality(t)
                        .function(df)
                        .build();
                Assert.assertTrue(t.toString() + " " + df.toString() + " " + chromaticChord.toString(), t.containsAll(chromaticChord));
            }
    }


    @Test
    public void getChromaticFunction() throws BuildingException {
        Tonality<Chromatic> t = Tonality.ET12.C;
        for (ChromaticDegreeFunction cf : SecondaryDominant.values()) {
            assertNotNull(ChromaticChord.builder()
                    .tonality(t)
                    .function(cf)
                    .build());
        }
    }

    @Test
    public void getChordFromHarmonicFunction() {
        Tonality<Chromatic> t = Tonality.ET12.C;

        t.getChord(DiatonicFunction.I);
    }

    /* Main Major And Minor */

    @Test
    public void mainMajorMinorAreMajorOrMinor() {
        Set<Tonality<Chromatic>> tonalityList = TonalityRetrieval.ET12.ALL_MAJOR_MINOR;

        for (Tonality tonality : tonalityList)
            assertTrue(ScaleUtils.isMajorOrMinor(tonality.getScale()));
    }

    /* From ChordProxy */

    // todo: generar tonalidades DiatonicAlt
/*
    @Test
    public void fromChordDiatonicFunction() {
        List<Tonality<Chromatic>> ts = TonalityRetrieval.listFromChordDiatonicFunction(ChromaticChord.C);
        assertFalse(ts.isEmpty());
    }


    @Test
    public void allContainsValues() {
        List<Tonality> tonalities = TonalityRetrieval.allUsualKeys();

        Set<Tonality<Chromatic>> immutableValues = TonalityRetrieval.ET12.ALL_MAJOR_MINOR;

        for (Tonality tonality : immutableValues)
            Assert.assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }
*/
    @Test
    public void valuesSize() {
        Set<Tonality<Chromatic>> tonalities = TonalityRetrieval.ET12.ALL_MAJOR_MINOR;

        Assert.assertEquals( 24, tonalities.size() );
    }

    @Test
    public void allSize() {
        List<Tonality<Chromatic>> tonalities = TonalityRetrieval.allUsualKeys();

        Assert.assertEquals(Scale.allUsualScales().size() * Chromatic.NUMBER, tonalities.size());
    }

    private void allContains(Tonality tonality) {
        List<Tonality<Chromatic>> tonalities = TonalityRetrieval.allUsualKeys();

        Assert.assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    @Test
    public void allContains1() {
        allContains(Tonality.ET12.C);
    }

    @Test
    public void allContains2() {
        allContains(Tonality.ET12.C);
    }

    @Test
    public void allContains3() {
        allContains(Tonality.ET12.GG);
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
