package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TonalityTest {
    @Test
    public void getRoot1() {
        assertEquals( DiatonicAlt.C, Tonality.C.getRoot() );
    }

    @Test
    public void getRoot2() {
        assertEquals( DiatonicAlt.Bb, Tonality.Bb.getRoot() );
    }

    @Test
    public void getRoot3() {
        assertEquals( DiatonicAlt.Bb, Tonality.Bbm.getRoot() );
    }

    @Test
    public void getScale1() {
        assertEquals( Scale.MAJOR, Tonality.C.getScale() );
    }

    @Test
    public void getScale2() {
        assertEquals( Scale.MAJOR, Tonality.Bb.getScale() );
    }

    @Test
    public void getScale3() {
        assertEquals( Scale.MINOR, Tonality.Bbm.getScale() );
    }

    @Test
    public void getNotes1() {
        List<DiatonicAlt> notes = Arrays.asList(
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E,
                DiatonicAlt.F,
                DiatonicAlt.G,
                DiatonicAlt.A,
                DiatonicAlt.B
        );
        assertEquals(notes, Tonality.C.getNotes() );
    }

    @Test
    public void getNotes2() {
        List<DiatonicAlt> notes = Arrays.asList(
                DiatonicAlt.A,
                DiatonicAlt.B,
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E,
                DiatonicAlt.F,
                DiatonicAlt.G
        );
        assertEquals(notes, Tonality.Am.getNotes() );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tryToEditNotes() {
        Tonality.C.getNotes().set(0, DiatonicAlt.CC);
    }

    @Test
    public void equals1() {
        Tonality tonality = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
        assertEquals( Tonality.C, tonality );
    }

    @Test
    public void equals2() {
        Tonality tonality = Tonality.from(DiatonicAlt.Bb, Scale.MAJOR);
        assertNotEquals( Tonality.C, tonality );
    }

    @Test
    public void equals3() {
        Tonality tonality1 = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality tonality2 = Tonality.from(DiatonicAlt.Ab, Scale.DORIAN);
        assertNotEquals( tonality1, tonality2 );
    }

    @Test
    public void hashCode1() {
        Tonality tonality = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
        assertEquals( Tonality.C.hashCode(), tonality.hashCode() );
    }

    @Test
    public void hashCode2() {
        Tonality tonality = Tonality.from(DiatonicAlt.Bb, Scale.MAJOR);
        assertNotEquals( Tonality.C.hashCode(), tonality.hashCode() );
    }

    @Test
    public void hashCode3() {
        Tonality tonality1 = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality tonality2 = Tonality.from(DiatonicAlt.Ab, Scale.DORIAN);
        assertNotEquals( tonality1.hashCode(), tonality2.hashCode() );
    }

    @Test
    public void allSize() {
        List<Tonality> tonalities = Tonality.all();

        assertEquals( 1071, tonalities.size() );
    }

    private void allContains(Tonality tonality) {
        List<Tonality> tonalities = Tonality.all();

        assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    @Test
    public void allContains1() {
        allContains(Tonality.C);
    }

    @Test
    public void allContains2() {
        allContains(TonalityEnum.C);
    }

    @Test
    public void allContains3() {
        allContains(TonalityEnum.Ab);
    }

    @Test
    public void allContains4() {
        allContains(Tonality.from(DiatonicAlt.Ab, Scale.DORIAN));
    }

    @Test
    public void allContains5() {
        allContains(Tonality.from(DiatonicAlt.GG, Scale.DORIAN));
    }

    @Test
    public void allContainsMajorMinor() {
        List<Tonality> tonalities = Tonality.all();

        Set<Tonality> majorMinor = TonalityRetrieval.majorMinor();

        for (Tonality tonality : majorMinor)
            assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    @Test
    public void fromDiatonicChord() {
    }

    @Test
    public void of() {
    }

    @Test
    public void from() {
    }

    @Test
    public void getNotesFrom() {
    }

    @Test
    public void testOf() {
    }

    @Test
    public void getAlterations() {
        assertEquals(0, Tonality.C.getAlterations());
        assertEquals(0, Tonality.Am.getAlterations());
        assertEquals(5, Tonality.Db.getAlterations());
        assertEquals(2, Tonality.D.getAlterations());
        assertEquals(3, Tonality.Eb.getAlterations());
        assertEquals(4, Tonality.E.getAlterations());
        assertEquals(3, Tonality.Cm.getAlterations());
    }

    @Test
    public void ofTonalityEquals() {
        for (Tonality t : Tonality.all()) {
            Tonality tonality2 = Tonality.from(t);
            assertEquals(t, tonality2);
        }
    }

    @Test
    public void enharmonicNotEquals1() {
        assertNotEquals(Tonality.FF, Tonality.Gb);
    }
    @Test
    public void enharmonicNotEquals2() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        assertNotEquals(Tonality.C, tonality);
    }

    @Test
    public void minimizeAlterationsBB() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        Tonality minimizedTonality = TonalityRetrieval.getEnharmonicMinimalAltsFrom(tonality).iterator().next();

        assertEquals(Tonality.C, minimizedTonality);
    }

    @Test
    public void minimizeAlterationsSize1() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        Set<Tonality> minimizedTonalityList = TonalityRetrieval.getEnharmonicMinimalAltsFrom(tonality);

        assertEquals(1, minimizedTonalityList.size());
    }

    @Test
    public void minimizeAlterationsSizeNot1() {
        Set<Tonality> tonalityList = TonalityRetrieval.getEnharmonicMinimalAltsFrom(Tonality.Gb);

        assertEquals(2, tonalityList.size());
    }

    @Test
    public void hashCodeTest() {
        Tonality tonality1 = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality tonality1b = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);

        assertEquals(tonality1.hashCode(), tonality1b.hashCode());
    }

    @Test
    public void minimizeAlterationsBidirectional1() {
        Set<Tonality> minTonalityListGG = TonalityRetrieval.getEnharmonicMinimalAltsFrom(Tonality.from(DiatonicAlt.GG, Scale.MAJOR));
        Set<Tonality> minTonalityListFb = TonalityRetrieval.getEnharmonicMinimalAltsFrom(Tonality.from(DiatonicAlt.Ab, Scale.MAJOR));

        assertEquals(minTonalityListFb.hashCode(), minTonalityListGG.hashCode());
        assertEquals(minTonalityListFb, minTonalityListGG);
    }

    @Test
    public void minimizeAlterationsBidirectionalAll() {
        for (Tonality tonality : Tonality.all()) {
            Set<Tonality> minTonalityListReference = TonalityRetrieval.getEnharmonicMinimalAltsFrom(tonality);

            if (minTonalityListReference.size() > 1)
                for (Tonality minTonality : minTonalityListReference) {
                    Set<Tonality> minTonalityListParticular = TonalityRetrieval.getEnharmonicMinimalAltsFrom(minTonality);

                    assertEquals(minTonalityListReference, minTonalityListParticular);
                }
        }
    }

    @Test
    public void getChordFunction() {
        Tonality ton = Tonality.E;
        ChromaticChord cc = ChromaticChord.from(ton, DiatonicFunction.I);

        assertEquals(ChromaticChord.E, cc);
        cc = ChromaticChord.from(ton, DiatonicFunction.VII);

        assertEquals(ChromaticChord.DDdim, cc);

        ton = Tonality.Em;
        cc = ChromaticChord.from(ton, DiatonicFunction.I);

        assertEquals(ChromaticChord.Em, cc);
        cc = ChromaticChord.from(ton, DiatonicFunction.VII);

        assertEquals(ChromaticChord.D, cc);

        ton = Tonality.C;
        cc = ChromaticChord.from(ton, DiatonicFunction.V7);

        assertEquals(ChromaticChord.G7, cc);
    }

    @Test
    public void getTriadSeventhChords() {
        Tonality t = Tonality.C;

        assertEquals(
                Arrays.asList(
                        ChromaticChord.C,
                        ChromaticChord.Dm,
                        ChromaticChord.Em,
                        ChromaticChord.F,
                        ChromaticChord.G,
                        ChromaticChord.Am,
                        ChromaticChord.Bdim

                ), TonalityChordRetrieval.getTriadChordsFrom(t)
        );

        assertEquals(
                Arrays.asList(
                        ChromaticChord.CMaj7,
                        ChromaticChord.Dm7,
                        ChromaticChord.Em7,
                        ChromaticChord.FMaj7,
                        ChromaticChord.G7,
                        ChromaticChord.Am7,
                        ChromaticChord.Bm7b5
                ), TonalityChordRetrieval.getSeventhChordsFrom(t)
        );

        t = Tonality.Am;

        assertEquals(
                Arrays.asList(
                        ChromaticChord.Am,
                        ChromaticChord.Bdim,
                        ChromaticChord.C,
                        ChromaticChord.Dm,
                        ChromaticChord.Em,
                        ChromaticChord.F,
                        ChromaticChord.G
                ), TonalityChordRetrieval.getTriadChordsFrom(t)
        );

        assertEquals(
                Arrays.asList(
                        ChromaticChord.Am7,
                        ChromaticChord.Bm7b5,
                        ChromaticChord.CMaj7,
                        ChromaticChord.Dm7,
                        ChromaticChord.Em7,
                        ChromaticChord.FMaj7,
                        ChromaticChord.G7
                ), TonalityChordRetrieval.getSeventhChordsFrom(t)
        );
    }

    @Test
    public void has() {
        Tonality ton = Tonality.C;

        assertTrue(ton.has(ChromaticChord.C));
        assertTrue(ton.has(ChromaticChord.Dm));
        assertTrue(ton.has(ChromaticChord.Em));
        assertTrue(ton.has(ChromaticChord.F));
        assertTrue(ton.has(ChromaticChord.G));
        assertTrue(ton.has(ChromaticChord.Am));
        assertTrue(ton.has(ChromaticChord.Bdim));

        assertTrue(ton.has(ChromaticChord.Csus2));
        assertTrue(ton.has(ChromaticChord.Dsus2));
        assertTrue(ton.has(ChromaticChord.Esusb2));
        assertTrue(ton.has(ChromaticChord.Fsus2));
        assertTrue(ton.has(ChromaticChord.Gsus2));
        assertTrue(ton.has(ChromaticChord.Asus2));
        assertTrue(ton.has(ChromaticChord.Bsusb2b5));

        assertTrue(ton.has(ChromaticChord.Csus4));
        assertTrue(ton.has(ChromaticChord.Dsus4));
        assertTrue(ton.has(ChromaticChord.Esus4));
        assertTrue(ton.has(ChromaticChord.Fsusa4));
        assertTrue(ton.has(ChromaticChord.Gsus4));
        assertTrue(ton.has(ChromaticChord.Asus4));
        assertFalse(ton.has(ChromaticChord.Bsusa4));

        assertTrue(ton.has(ChromaticChord.C6));
        assertTrue(ton.has(ChromaticChord.Dm6));
        assertFalse(ton.has(ChromaticChord.Em6));
        assertTrue(ton.has(ChromaticChord.F6));
        assertTrue(ton.has(ChromaticChord.G6));
        assertFalse(ton.has(ChromaticChord.Am6));
        assertFalse(ton.has(ChromaticChord.B6));

        assertTrue(ton.has(ChromaticChord.CMaj7));
        assertTrue(ton.has(ChromaticChord.Dm7));
        assertTrue(ton.has(ChromaticChord.Em7));
        assertTrue(ton.has(ChromaticChord.FMaj7));
        assertTrue(ton.has(ChromaticChord.G7));
        assertTrue(ton.has(ChromaticChord.Am7));
        assertFalse(ton.has(ChromaticChord.B7));
    }

    @Test
    public void hasFromDiatonicFunction() {
        for (Tonality t : TonalityEnum.values())
            for (DiatonicFunction df : DiatonicFunction.COMMON) {
                ChromaticChord chromaticChord = ChromaticChord.from(t, df);
                assertTrue(t.toString() + " " + df.toString() + " " + chromaticChord.toString(), t.has(chromaticChord) );
            }
    }

    @Test
    public void getDegree() {
        Tonality ton = Tonality.C;

        assertEquals(DiatonicDegree.I, ton.getDegreeFrom(PitchMidi.C5.getChromatic()));
        assertEquals(DiatonicDegree.II, ton.getDegreeFrom(PitchMidi.D5.getChromatic()));
        assertEquals(DiatonicDegree.III, ton.getDegreeFrom(PitchMidi.E6.getChromatic()));
        assertEquals(DiatonicDegree.IV, ton.getDegreeFrom(Chromatic.F));
        assertNull(ton.getDegreeFrom(DiatonicAlt.EEEE));
        assertEquals(DiatonicDegree.V, ton.getDegreeFrom(Chromatic.from(DiatonicAlt.EEEE)));
    }

    @Test
    public void get() {
        Tonality ton = Tonality.C;
        assertEquals(ChromaticChord.C, ChromaticChord.from(ton, DiatonicFunction.I));
        assertEquals(ChromaticChord.Dm, ChromaticChord.from(ton, DiatonicFunction.II));
        assertEquals(ChromaticChord.Em, ChromaticChord.from(ton, DiatonicFunction.III));
        assertEquals(ChromaticChord.F, ChromaticChord.from(ton, DiatonicFunction.IV));
        assertEquals(ChromaticChord.G, ChromaticChord.from(ton, DiatonicFunction.V));
        assertEquals(ChromaticChord.Am, ChromaticChord.from(ton, DiatonicFunction.VI));
        assertEquals(ChromaticChord.Bdim, ChromaticChord.from(ton, DiatonicFunction.VII));

        assertEquals(ChromaticChord.Csus2, ChromaticChord.from(ton, DiatonicFunction.I2));
        assertEquals(ChromaticChord.Dsus2, ChromaticChord.from(ton, DiatonicFunction.II2));
        assertEquals(ChromaticChord.Fsus2, ChromaticChord.from(ton, DiatonicFunction.IV2));
        assertEquals(ChromaticChord.Gsus2, ChromaticChord.from(ton, DiatonicFunction.V2));
        assertEquals(ChromaticChord.Asus2, ChromaticChord.from(ton, DiatonicFunction.VI2));

        assertEquals(ChromaticChord.Csus4, ChromaticChord.from(ton, DiatonicFunction.I4));
        assertEquals(ChromaticChord.Dsus4, ChromaticChord.from(ton, DiatonicFunction.II4));
        assertEquals(ChromaticChord.Esus4, ChromaticChord.from(ton, DiatonicFunction.III4));
        assertEquals(ChromaticChord.Gsus4, ChromaticChord.from(ton, DiatonicFunction.V4));
        assertEquals(ChromaticChord.Asus4, ChromaticChord.from(ton, DiatonicFunction.VI4));

        assertEquals(ChromaticChord.C6, ChromaticChord.from(ton, DiatonicFunction.I6));
        assertEquals(ChromaticChord.Dm6, ChromaticChord.from(ton, DiatonicFunction.II6));
        assertEquals(ChromaticChord.F6, ChromaticChord.from(ton, DiatonicFunction.IV6));
        assertEquals(ChromaticChord.G6, ChromaticChord.from(ton, DiatonicFunction.V6));

        assertEquals(ChromaticChord.CMaj7, ChromaticChord.from(ton, DiatonicFunction.I7));
        assertEquals(ChromaticChord.Dm7, ChromaticChord.from(ton, DiatonicFunction.II7));
        assertEquals(ChromaticChord.Em7, ChromaticChord.from(ton, DiatonicFunction.III7));
        assertEquals(ChromaticChord.FMaj7, ChromaticChord.from(ton, DiatonicFunction.IV7));
        assertEquals(ChromaticChord.G7, ChromaticChord.from(ton, DiatonicFunction.V7));
        assertEquals(ChromaticChord.Am7, ChromaticChord.from(ton, DiatonicFunction.VI7));
        assertEquals(ChromaticChord.Bm7b5, ChromaticChord.from(ton, DiatonicFunction.VII7));

        assertEquals(ChromaticChord.C5, ChromaticChord.from(ton, ChromaticFunction.I5));
        assertEquals(ChromaticChord.D5, ChromaticChord.from(ton, ChromaticFunction.II5));
        assertEquals(ChromaticChord.E5, ChromaticChord.from(ton, ChromaticFunction.III5));
        assertEquals(ChromaticChord.F5, ChromaticChord.from(ton, ChromaticFunction.IV5));
        assertEquals(ChromaticChord.G5, ChromaticChord.from(ton, ChromaticFunction.V5));
        assertEquals(ChromaticChord.A5, ChromaticChord.from(ton, ChromaticFunction.VI5));
        assertEquals(ChromaticChord.B5, ChromaticChord.from(ton, ChromaticFunction.VII5));

        assertEquals(ChromaticChord.A, ChromaticChord.from(ton, ChromaticFunction.V_II));
        assertEquals(ChromaticChord.B, ChromaticChord.from(ton, ChromaticFunction.V_III));
        assertEquals(ChromaticChord.C, ChromaticChord.from(ton, ChromaticFunction.V_IV));
        assertEquals(ChromaticChord.from(ton, DiatonicFunction.I), ChromaticChord.from(ton, ChromaticFunction.V_IV));
        assertEquals(ChromaticChord.D, ChromaticChord.from(ton, ChromaticFunction.V_V));
        assertEquals(ChromaticChord.E, ChromaticChord.from(ton, ChromaticFunction.V_VI));

        assertEquals(ChromaticChord.A7, ChromaticChord.from(ton, ChromaticFunction.V7_II));
        assertEquals(ChromaticChord.B7, ChromaticChord.from(ton, ChromaticFunction.V7_III));
        assertTrue(ChromaticChord.from(ton, ChromaticFunction.V7_IV).equalsEnharmonic(ChromaticChord.C7));
        assertEquals(ChromaticChord.D7, ChromaticChord.from(ton, ChromaticFunction.V7_V));
        assertEquals(ChromaticChord.E7, ChromaticChord.from(ton, ChromaticFunction.V7_VI));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7).equalsEnharmonic(ChromaticChord.CC7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_II).equalsEnharmonic(ChromaticChord.DD7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_III).equalsEnharmonic(ChromaticChord.F7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_IV).equalsEnharmonic(ChromaticChord.FF7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_V).equalsEnharmonic(ChromaticChord.GG7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_VI).equalsEnharmonic(ChromaticChord.AA7));

        ChromaticChord c = ChromaticChord.CC.duplicate();
        c.inv();
        assertEquals(
                c, ChromaticChord.from(ton, ChromaticFunction.N6)
        );

        // TODO:
        // V7ALT

        ton = Tonality.Cm;

        assertTrue(ChromaticChord.from(ton, DiatonicFunction.VII7).equalsEnharmonic(ChromaticChord.AA7));

        ton = Tonality.Db;
        assertTrue(ChromaticChord.from(ton, DiatonicFunction.II).equalsEnharmonic(ChromaticChord.DDm));
    }

    @Test
    public void getFunction() {
        Tonality ton = Tonality.C;
        assertEquals(DiatonicFunction.I, ton.getFunction(ChromaticChord.C));
        assertEquals(DiatonicFunction.II, ton.getFunction(ChromaticChord.Dm));
        assertEquals(DiatonicFunction.III, ton.getFunction(ChromaticChord.Em));
        assertEquals(DiatonicFunction.IV, ton.getFunction(ChromaticChord.F));
        assertEquals(DiatonicFunction.V, ton.getFunction(ChromaticChord.G));
        assertEquals(DiatonicFunction.VI, ton.getFunction(ChromaticChord.Am));
        assertEquals(DiatonicFunction.VII, ton.getFunction(ChromaticChord.Bdim));

        assertEquals(ChromaticChord.Csus2, ChromaticChord.from(ton, DiatonicFunction.I2));
        assertEquals(DiatonicFunction.I2, ton.getFunction(ChromaticChord.Csus2));
        assertEquals(DiatonicFunction.II2, ton.getFunction(ChromaticChord.Dsus2));
        assertEquals(DiatonicFunction.IV2, ton.getFunction(ChromaticChord.Fsus2));
        assertEquals(DiatonicFunction.V2, ton.getFunction(ChromaticChord.Gsus2));
        assertEquals(DiatonicFunction.VI2, ton.getFunction(ChromaticChord.Asus2));

        assertEquals(DiatonicFunction.I4, ton.getFunction(ChromaticChord.Csus4));
        assertEquals(DiatonicFunction.II4, ton.getFunction(ChromaticChord.Dsus4));
        assertEquals(DiatonicFunction.III4, ton.getFunction(ChromaticChord.Esus4));
        assertEquals(DiatonicFunction.V4, ton.getFunction(ChromaticChord.Gsus4));
        assertEquals(DiatonicFunction.VI4, ton.getFunction(ChromaticChord.Asus4));

        assertEquals(DiatonicFunction.I6, ton.getFunction(ChromaticChord.C6));
        assertEquals(DiatonicFunction.II6, ton.getFunction(ChromaticChord.Dm6));
        assertEquals(DiatonicFunction.IV6, ton.getFunction(ChromaticChord.F6));
        assertEquals(DiatonicFunction.V6, ton.getFunction(ChromaticChord.G6));

        assertEquals(DiatonicFunction.I7, ton.getFunction(ChromaticChord.CMaj7));
        assertEquals(DiatonicFunction.II7, ton.getFunction(ChromaticChord.Dm7));
        assertEquals(DiatonicFunction.III7, ton.getFunction(ChromaticChord.Em7));
        assertEquals(DiatonicFunction.IV7, ton.getFunction(ChromaticChord.FMaj7));
        assertEquals(DiatonicFunction.V7, ton.getFunction(ChromaticChord.G7));
        assertEquals(DiatonicFunction.VI7, ton.getFunction(ChromaticChord.Am7));
        assertEquals(DiatonicFunction.VII7, ton.getFunction(ChromaticChord.Bm7b5));
        ton = Tonality.Cm;
        //assertEquals(DiatonicFunction.VII7, ton.getFunction(ChromaticChord.fromDistances( ChromaticChord.fromDistances(ChromaticChord.AA7).rename(ton) )));
    }
}
