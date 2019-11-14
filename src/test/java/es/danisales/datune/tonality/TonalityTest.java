package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.junit.Test;

import java.util.*;

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
        PitchChromaticChord cc = ChromaticChordInterface.from(ton, DiatonicFunction.I);

        assertEquals(ChromaticChordEnum.E, cc);
        cc = ChromaticChordInterface.from(ton, DiatonicFunction.VII);

        assertEquals(ChromaticChordEnum.DDdim, cc);

        ton = Tonality.Em;
        cc = ChromaticChordInterface.from(ton, DiatonicFunction.I);

        assertEquals(ChromaticChordEnum.Em, cc);
        cc = ChromaticChordInterface.from(ton, DiatonicFunction.VII);

        assertEquals(ChromaticChordEnum.D, cc);

        ton = Tonality.C;
        cc = ChromaticChordInterface.from(ton, DiatonicFunction.V7);

        assertEquals(ChromaticChordEnum.G7, cc);
    }

    @Test
    public void getTriadSeventhChords() {
        Tonality t = Tonality.C;

        assertEquals(
                Arrays.asList(
                        ChromaticChordEnum.C,
                        ChromaticChordEnum.Dm,
                        ChromaticChordEnum.Em,
                        ChromaticChordEnum.F,
                        ChromaticChordEnum.G,
                        ChromaticChordEnum.Am,
                        ChromaticChordEnum.Bdim

                ), TonalityChordRetrieval.getTriadChordsFrom(t)
        );

        assertEquals(
                Arrays.asList(
                        ChromaticChordEnum.CMaj7,
                        ChromaticChordEnum.Dm7,
                        ChromaticChordEnum.Em7,
                        ChromaticChordEnum.FMaj7,
                        ChromaticChordEnum.G7,
                        ChromaticChordEnum.Am7,
                        ChromaticChordEnum.Bm7b5
                ), TonalityChordRetrieval.getSeventhChordsFrom(t)
        );

        t = Tonality.Am;

        assertEquals(
                Arrays.asList(
                        ChromaticChordEnum.Am,
                        ChromaticChordEnum.Bdim,
                        ChromaticChordEnum.C,
                        ChromaticChordEnum.Dm,
                        ChromaticChordEnum.Em,
                        ChromaticChordEnum.F,
                        ChromaticChordEnum.G
                ), TonalityChordRetrieval.getTriadChordsFrom(t)
        );

        assertEquals(
                Arrays.asList(
                        ChromaticChordEnum.Am7,
                        ChromaticChordEnum.Bm7b5,
                        ChromaticChordEnum.CMaj7,
                        ChromaticChordEnum.Dm7,
                        ChromaticChordEnum.Em7,
                        ChromaticChordEnum.FMaj7,
                        ChromaticChordEnum.G7
                ), TonalityChordRetrieval.getTriadChordsFrom(t)
        );
    }

    @Test
    public void has() {
        Tonality ton = Tonality.C;

        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.C));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Dm));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Em));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.F));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.G));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Am));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Bdim));

        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Csus2));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Dsus2));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Esusb2));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Fsus2));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Gsus2));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Asus2));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Bsusb2b5));

        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Csus4));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Dsus4));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Esus4));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Fsusa4));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Gsus4));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Asus4));
        assertTrue(ton.has(ChromaticChordEnum.Bsusa4));

        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.C6));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Dm6));
        assertTrue(ton.has(ChromaticChordEnum.Em6));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.F6));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.G6));
        assertTrue(ton.has(ChromaticChordEnum.Am6));
        assertTrue(ton.has(ChromaticChordEnum.B6));

        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.CMaj7));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Dm7));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Em7));
        assertTrue(ton.has(ChromaticChordEnum.F7));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.G7));
        assertTrue(ton.hasEnharmonic(ChromaticChordEnum.Am7));
        assertTrue(ton.has(ChromaticChordEnum.B7));

        for (DiatonicFunction df : DiatonicFunction.COMMON)
            assertTrue(ton.has(ChromaticChordInterface.from(ton, df)));

        ton = Tonality.Db;

        for (DiatonicFunction df : DiatonicFunction.COMMON)
            assertTrue(ton.has(ChromaticChordInterface.from(ton, df)));
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
        assertEquals(ChromaticChordEnum.C, ChromaticChordInterface.from(ton, DiatonicFunction.I));
        assertEquals(ChromaticChordEnum.Dm, ChromaticChordInterface.from(ton, DiatonicFunction.II));
        assertEquals(ChromaticChordEnum.Em, ChromaticChordInterface.from(ton, DiatonicFunction.III));
        assertEquals(ChromaticChordEnum.F, ChromaticChordInterface.from(ton, DiatonicFunction.IV));
        assertEquals(ChromaticChordEnum.G, ChromaticChordInterface.from(ton, DiatonicFunction.V));
        assertEquals(ChromaticChordEnum.Am, ChromaticChordInterface.from(ton, DiatonicFunction.VI));
        assertEquals(ChromaticChordEnum.Bdim, ChromaticChordInterface.from(ton, DiatonicFunction.VII));

        assertEquals(ChromaticChordEnum.Csus2, ChromaticChordInterface.from(ton, DiatonicFunction.I2));
        assertEquals(ChromaticChordEnum.Dsus2, ChromaticChordInterface.from(ton, DiatonicFunction.II2));
        assertEquals(ChromaticChordEnum.Fsus2, ChromaticChordInterface.from(ton, DiatonicFunction.IV2));
        assertEquals(ChromaticChordEnum.Gsus2, ChromaticChordInterface.from(ton, DiatonicFunction.V2));
        assertEquals(ChromaticChordEnum.Asus2, ChromaticChordInterface.from(ton, DiatonicFunction.VI2));

        assertEquals(ChromaticChordEnum.Csus4, ChromaticChordInterface.from(ton, DiatonicFunction.I4));
        assertEquals(ChromaticChordEnum.Dsus4, ChromaticChordInterface.from(ton, DiatonicFunction.II4));
        assertEquals(ChromaticChordEnum.Esus4, ChromaticChordInterface.from(ton, DiatonicFunction.III4));
        assertEquals(ChromaticChordEnum.Gsus4, ChromaticChordInterface.from(ton, DiatonicFunction.V4));
        assertEquals(ChromaticChordEnum.Asus4, ChromaticChordInterface.from(ton, DiatonicFunction.VI4));

        assertEquals(ChromaticChordEnum.C6, ChromaticChordInterface.from(ton, DiatonicFunction.I6));
        assertEquals(ChromaticChordEnum.Dm6, ChromaticChordInterface.from(ton, DiatonicFunction.II6));
        assertEquals(ChromaticChordEnum.F6, ChromaticChordInterface.from(ton, DiatonicFunction.IV6));
        assertEquals(ChromaticChordEnum.G6, ChromaticChordInterface.from(ton, DiatonicFunction.V6));

        assertEquals(ChromaticChordEnum.CMaj7, ChromaticChordInterface.from(ton, DiatonicFunction.I7));
        assertEquals(ChromaticChordEnum.Dm7, ChromaticChordInterface.from(ton, DiatonicFunction.II7));
        assertEquals(ChromaticChordEnum.Em7, ChromaticChordInterface.from(ton, DiatonicFunction.III7));
        assertEquals(ChromaticChordEnum.FMaj7, ChromaticChordInterface.from(ton, DiatonicFunction.IV7));
        assertEquals(ChromaticChordEnum.G7, ChromaticChordInterface.from(ton, DiatonicFunction.V7));
        assertEquals(ChromaticChordEnum.Am7, ChromaticChordInterface.from(ton, DiatonicFunction.VI7));
        assertEquals(ChromaticChordEnum.Bm7b5, ChromaticChordInterface.from(ton, DiatonicFunction.VII7));

        assertEquals(ChromaticChordEnum.C5, ChromaticChordInterface.from(ton, ChromaticFunction.I5));
        assertEquals(ChromaticChordEnum.D5, ChromaticChordInterface.from(ton, ChromaticFunction.II5));
        assertEquals(ChromaticChordEnum.E5, ChromaticChordInterface.from(ton, ChromaticFunction.III5));
        assertEquals(ChromaticChordEnum.F5, ChromaticChordInterface.from(ton, ChromaticFunction.IV5));
        assertEquals(ChromaticChordEnum.G5, ChromaticChordInterface.from(ton, ChromaticFunction.V5));
        assertEquals(ChromaticChordEnum.A5, ChromaticChordInterface.from(ton, ChromaticFunction.VI5));
        assertEquals(ChromaticChordEnum.B5, ChromaticChordInterface.from(ton, ChromaticFunction.VII5));

        assertEquals(ChromaticChordEnum.A, ChromaticChordInterface.from(ton, ChromaticFunction.V_II));
        assertEquals(ChromaticChordEnum.B, ChromaticChordInterface.from(ton, ChromaticFunction.V_III));
        assertEquals(ChromaticChordEnum.C, ChromaticChordInterface.from(ton, ChromaticFunction.V_IV));
        assertEquals(ChromaticChordInterface.from(ton, DiatonicFunction.I), ChromaticChordInterface.from(ton, ChromaticFunction.V_IV));
        assertEquals(ChromaticChordEnum.D, ChromaticChordInterface.from(ton, ChromaticFunction.V_V));
        assertEquals(ChromaticChordEnum.E, ChromaticChordInterface.from(ton, ChromaticFunction.V_VI));

        assertEquals(ChromaticChordEnum.A7, ChromaticChordInterface.from(ton, ChromaticFunction.V7_II));
        assertEquals(ChromaticChordEnum.B7, ChromaticChordInterface.from(ton, ChromaticFunction.V7_III));
        assertTrue(ChromaticChordInterface.from(ton, ChromaticFunction.V7_IV).equalsEnharmonic(ChromaticChordEnum.C7));
        assertEquals(ChromaticChordEnum.D7, ChromaticChordInterface.from(ton, ChromaticFunction.V7_V));
        assertEquals(ChromaticChordEnum.E7, ChromaticChordInterface.from(ton, ChromaticFunction.V7_VI));

        assertTrue(ChromaticChordInterface.from(ton, ChromaticFunction.SUBV7).equalsEnharmonic(ChromaticChordEnum.CC7));

        assertTrue(ChromaticChordInterface.from(ton, ChromaticFunction.SUBV7_II).equalsEnharmonic(ChromaticChordEnum.DD7));

        assertTrue(ChromaticChordInterface.from(ton, ChromaticFunction.SUBV7_III).equalsEnharmonic(ChromaticChordEnum.F7));

        assertTrue(ChromaticChordInterface.from(ton, ChromaticFunction.SUBV7_IV).equalsEnharmonic(ChromaticChordEnum.FF7));

        assertTrue(ChromaticChordInterface.from(ton, ChromaticFunction.SUBV7_V).equalsEnharmonic(ChromaticChordEnum.GG7));

        assertTrue(ChromaticChordInterface.from(ton, ChromaticFunction.SUBV7_VI).equalsEnharmonic(ChromaticChordEnum.AA7));

        ChromaticChordCustom c = ChromaticChordEnum.CC.duplicate();
        c.inv();
        assertEquals(
                c, ChromaticChordInterface.from(ton, ChromaticFunction.N6)
        );

        // TODO:
        // V7ALT

        ton = Tonality.Cm;

        assertTrue(ChromaticChordInterface.from(ton, DiatonicFunction.VII7).equalsEnharmonic(ChromaticChordEnum.AA7));

        ton = Tonality.Db;
        assertTrue(ChromaticChordInterface.from(ton, DiatonicFunction.II).equalsEnharmonic(ChromaticChordEnum.DDm));
    }

    @Test
    public void getFunction() {
        Tonality ton = Tonality.C;
        assertEquals(DiatonicFunction.I, ton.getFunction(ChromaticChordEnum.C));
        assertEquals(DiatonicFunction.II, ton.getFunction(ChromaticChordEnum.Dm));
        assertEquals(DiatonicFunction.III, ton.getFunction(ChromaticChordEnum.Em));
        assertEquals(DiatonicFunction.IV, ton.getFunction(ChromaticChordEnum.F));
        assertEquals(DiatonicFunction.V, ton.getFunction(ChromaticChordEnum.G));
        assertEquals(DiatonicFunction.VI, ton.getFunction(ChromaticChordEnum.Am));
        assertEquals(DiatonicFunction.VII, ton.getFunction(ChromaticChordEnum.Bdim));

        assertEquals(ChromaticChordEnum.Csus2, ChromaticChordInterface.from(ton, DiatonicFunction.I2));
        assertEquals(DiatonicFunction.I2, ton.getFunction(ChromaticChordEnum.Csus2));
        assertEquals(DiatonicFunction.II2, ton.getFunction(ChromaticChordEnum.Dsus2));
        assertEquals(DiatonicFunction.IV2, ton.getFunction(ChromaticChordEnum.Fsus2));
        assertEquals(DiatonicFunction.V2, ton.getFunction(ChromaticChordEnum.Gsus2));
        assertEquals(DiatonicFunction.VI2, ton.getFunction(ChromaticChordEnum.Asus2));

        assertEquals(DiatonicFunction.I4, ton.getFunction(ChromaticChordEnum.Csus4));
        assertEquals(DiatonicFunction.II4, ton.getFunction(ChromaticChordEnum.Dsus4));
        assertEquals(DiatonicFunction.III4, ton.getFunction(ChromaticChordEnum.Esus4));
        assertEquals(DiatonicFunction.V4, ton.getFunction(ChromaticChordEnum.Gsus4));
        assertEquals(DiatonicFunction.VI4, ton.getFunction(ChromaticChordEnum.Asus4));

        assertEquals(DiatonicFunction.I6, ton.getFunction(ChromaticChordEnum.C6));
        assertEquals(DiatonicFunction.II6, ton.getFunction(ChromaticChordEnum.Dm6));
        assertEquals(DiatonicFunction.IV6, ton.getFunction(ChromaticChordEnum.F6));
        assertEquals(DiatonicFunction.V6, ton.getFunction(ChromaticChordEnum.G6));

        assertEquals(DiatonicFunction.I7, ton.getFunction(ChromaticChordEnum.CMaj7));
        assertEquals(DiatonicFunction.II7, ton.getFunction(ChromaticChordEnum.Dm7));
        assertEquals(DiatonicFunction.III7, ton.getFunction(ChromaticChordEnum.Em7));
        assertEquals(DiatonicFunction.IV7, ton.getFunction(ChromaticChordEnum.FMaj7));
        assertEquals(DiatonicFunction.V7, ton.getFunction(ChromaticChordEnum.G7));
        assertEquals(DiatonicFunction.VI7, ton.getFunction(ChromaticChordEnum.Am7));
        assertEquals(DiatonicFunction.VII7, ton.getFunction(ChromaticChordEnum.Bm7b5));
        ton = Tonality.Cm;
        assertEquals(DiatonicFunction.VII7, ton.getFunction(ChromaticChordCustom.from(ChromaticChordEnum.AA7).rename(ton)));
    }
}
