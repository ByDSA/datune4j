package es.danisales.datune.tonality;

import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
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
    public void getFunction() {
        Tonality ton = Tonality.ET12.C;
        Assert.assertEquals(DiatonicFunction.I, ton.getFunctionFrom(ChromaticChord.C));
        Assert.assertEquals(DiatonicFunction.II, ton.getFunctionFrom(ChromaticChord.Dm));
        Assert.assertEquals(DiatonicFunction.III, ton.getFunctionFrom(ChromaticChord.Em));
        Assert.assertEquals(DiatonicFunction.IV, ton.getFunctionFrom(ChromaticChord.F));
        Assert.assertEquals(DiatonicFunction.V, ton.getFunctionFrom(ChromaticChord.G));
        Assert.assertEquals(DiatonicFunction.VI, ton.getFunctionFrom(ChromaticChord.Am));
        Assert.assertEquals(DiatonicFunction.VII, ton.getFunctionFrom(ChromaticChord.Bdim));

        ton.getChordFromHarmonicFunction(ChromaticFunction.ISUS4);

        Assert.assertEquals(ChromaticFunction.ISUS4, ton.getFunctionFrom(ChromaticChord.Csus4));
        Assert.assertEquals(ChromaticFunction.IISUS4, ton.getFunctionFrom(ChromaticChord.Dsus4));
        Assert.assertEquals(ChromaticFunction.bIIISUS4, ton.getFunctionFrom(ChromaticChord.DDsus4));
        Assert.assertEquals(ChromaticFunction.VSUS4, ton.getFunctionFrom(ChromaticChord.Gsus4));
        Assert.assertEquals(ChromaticFunction.VISUS4, ton.getFunctionFrom(ChromaticChord.Asus4));

        Assert.assertEquals(DiatonicFunction.I6, ton.getFunctionFrom(ChromaticChord.C6));
        Assert.assertEquals(DiatonicFunction.II6, ton.getFunctionFrom(ChromaticChord.Dm6));
        Assert.assertEquals(DiatonicFunction.IV6, ton.getFunctionFrom(ChromaticChord.F6));
        Assert.assertEquals(DiatonicFunction.V6, ton.getFunctionFrom(ChromaticChord.G6));

        Assert.assertEquals(DiatonicFunction.I7, ton.getFunctionFrom(ChromaticChord.CMaj7));
        Assert.assertEquals(DiatonicFunction.II7, ton.getFunctionFrom(ChromaticChord.Dm7));
        Assert.assertEquals(DiatonicFunction.III7, ton.getFunctionFrom(ChromaticChord.Em7));
        Assert.assertEquals(DiatonicFunction.IV7, ton.getFunctionFrom(ChromaticChord.FMaj7));
        Assert.assertEquals(DiatonicFunction.V7, ton.getFunctionFrom(ChromaticChord.G7));
        Assert.assertEquals(DiatonicFunction.VI7, ton.getFunctionFrom(ChromaticChord.Am7));
        Assert.assertEquals(DiatonicFunction.VII7, ton.getFunctionFrom(ChromaticChord.Bm7b5));
    }

    @Test
    public void hasFromDiatonicFunction() {
        for (Tonality<Chromatic> t : TonalityRetrieval.ET12.ALL_MAJOR_MINOR)
            for (DiatonicFunction df : DiatonicFunction.values()) {
                ChromaticChord chromaticChord = ChromaticChord.builder()
                        .tonality(t)
                        .diatonicFunction(df)
                        .build();
                Assert.assertTrue(t.toString() + " " + df.toString() + " " + chromaticChord.toString(), t.containsAll(chromaticChord));
            }
    }


    @Test
    public void getChromaticFunction() {
        Tonality<Chromatic> t = Tonality.ET12.C;
        for (ChromaticFunction cf : ChromaticFunction.values()) {
            assertNotNull(ChromaticChord.builder()
                    .tonality(t)
                    .chromaticFunction(cf)
                    .build());
        }
    }

    @Test
    public void getChordFromHarmonicFunction() {
        Tonality<Chromatic> t = Tonality.ET12.C;

        t.getChordFromHarmonicFunction(DiatonicFunction.I);
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

        Set<Tonality<Chromatic>> values = TonalityRetrieval.ET12.ALL_MAJOR_MINOR;

        for (Tonality tonality : values)
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

        Assert.assertEquals(1029, tonalities.size());
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
