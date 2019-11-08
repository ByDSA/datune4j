package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TonalityTest {
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
            Tonality tonality2 = Tonality.of(t);
            assertEquals(t, tonality2);
        }
    }

    @Test
    public void enharmonicNotEquals1() {
        assertNotEquals(Tonality.FF, Tonality.Gb);
    }
    @Test
    public void enharmonicNotEquals2() {
        Tonality tonality = Tonality.of(DiatonicAlt.BB, Scale.MAJOR);
        assertNotEquals(Tonality.C, tonality);
    }

    @Test
    public void minimizeAlterationsBB() {
        Tonality tonality = Tonality.of(DiatonicAlt.BB, Scale.MAJOR);
        Tonality minimizedTonality = Tonality.minAltsFrom(tonality).get(0);

        assertEquals(Tonality.C, minimizedTonality);
    }

    @Test
    public void minimizeAlterationsSize1() {
        Tonality tonality = Tonality.of(DiatonicAlt.BB, Scale.MAJOR);
        List<Tonality> minimizedTonalityList = Tonality.minAltsFrom(tonality);

        assertEquals(1, minimizedTonalityList.size());
    }

    @Test
    public void minimizeAlterationsSizeNot1() {
        int max = Integer.MIN_VALUE;
        for (Tonality tonality : TonalityRetrieval.all()) {
            List<Tonality> minimizedTonalityList = Tonality.minAltsFrom(tonality);
            max = Math.max(max, minimizedTonalityList.size());
            if (max == minimizedTonalityList.size())
                System.out.println();
        }

        assertTrue(max > 1);
    }

    @Test
    public void updateChromaticsFromBase() {
        Tonality t = Tonality.Gb;
        assertEquals(DiatonicAlt.Gb, t.getRoot());
        assertEquals(DiatonicAlt.FF, t.getRoot());
    }

    @Test
    public void getChordFunction() {
        Tonality ton = Tonality.E;
        PitchChromaticChord cc = ChromaticChord.from(ton, DiatonicFunction.I);

        assertEquals(ChromaticChordEnum.E, cc);
        cc = ChromaticChord.from(ton, DiatonicFunction.VII);

        assertEquals(ChromaticChordEnum.DDdim, cc);

        ton = Tonality.Em;
        cc = ChromaticChord.from(ton, DiatonicFunction.I);

        assertEquals(ChromaticChordEnum.Em, cc);
        cc = ChromaticChord.from(ton, DiatonicFunction.VII);

        assertEquals(ChromaticChordEnum.D, cc);

        ton = Tonality.C;
        cc = ChromaticChord.from(ton, DiatonicFunction.V7);

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

                ), TonalityChordRetrieval.getTriadChordsFrom(t)
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
            assertTrue(ton.has(ChromaticChord.from(ton, df)));

        ton = Tonality.Db;

        for (DiatonicFunction df : DiatonicFunction.COMMON)
            assertTrue(ton.has(ChromaticChord.from(ton, df)));
    }

    @Test
    public void getDegree() {
        Tonality ton = Tonality.C;

        assertEquals(DiatonicDegree.I, ton.getDegreeFrom(PitchMidi.C5.getChromatic()));
        assertEquals(DiatonicDegree.II, ton.getDegreeFrom(PitchMidi.D5.getChromatic()));
        assertEquals(DiatonicDegree.III, ton.getDegreeFrom(PitchMidi.E6.getChromatic()));
        assertEquals(DiatonicDegree.IV, ton.getDegreeFrom(Chromatic.F));
        assertNull(ton.getDegreeFrom(DiatonicAlt.EEEE));
        assertEquals(DiatonicDegree.V, ton.getDegreeFrom(DiatonicAlt.EEEE));
    }

    @Test
    public void get() {
        Tonality ton = Tonality.C;
        assertEquals(ChromaticChordEnum.C, ChromaticChord.from(ton, DiatonicFunction.I));
        assertEquals(ChromaticChordEnum.Dm, ChromaticChord.from(ton, DiatonicFunction.II));
        assertEquals(ChromaticChordEnum.Em, ChromaticChord.from(ton, DiatonicFunction.III));
        assertEquals(ChromaticChordEnum.F, ChromaticChord.from(ton, DiatonicFunction.IV));
        assertEquals(ChromaticChordEnum.G, ChromaticChord.from(ton, DiatonicFunction.V));
        assertEquals(ChromaticChordEnum.Am, ChromaticChord.from(ton, DiatonicFunction.VI));
        assertEquals(ChromaticChordEnum.Bdim, ChromaticChord.from(ton, DiatonicFunction.VII));

        assertEquals(ChromaticChordEnum.Csus2, ChromaticChord.from(ton, DiatonicFunction.I2));
        assertEquals(ChromaticChordEnum.Dsus2, ChromaticChord.from(ton, DiatonicFunction.II2));
        assertEquals(ChromaticChordEnum.Fsus2, ChromaticChord.from(ton, DiatonicFunction.IV2));
        assertEquals(ChromaticChordEnum.Gsus2, ChromaticChord.from(ton, DiatonicFunction.V2));
        assertEquals(ChromaticChordEnum.Asus2, ChromaticChord.from(ton, DiatonicFunction.VI2));

        assertEquals(ChromaticChordEnum.Csus4, ChromaticChord.from(ton, DiatonicFunction.I4));
        assertEquals(ChromaticChordEnum.Dsus4, ChromaticChord.from(ton, DiatonicFunction.II4));
        assertEquals(ChromaticChordEnum.Esus4, ChromaticChord.from(ton, DiatonicFunction.III4));
        assertEquals(ChromaticChordEnum.Gsus4, ChromaticChord.from(ton, DiatonicFunction.V4));
        assertEquals(ChromaticChordEnum.Asus4, ChromaticChord.from(ton, DiatonicFunction.VI4));

        assertEquals(ChromaticChordEnum.C6, ChromaticChord.from(ton, DiatonicFunction.I6));
        assertEquals(ChromaticChordEnum.Dm6, ChromaticChord.from(ton, DiatonicFunction.II6));
        assertEquals(ChromaticChordEnum.F6, ChromaticChord.from(ton, DiatonicFunction.IV6));
        assertEquals(ChromaticChordEnum.G6, ChromaticChord.from(ton, DiatonicFunction.V6));

        assertEquals(ChromaticChordEnum.CMaj7, ChromaticChord.from(ton, DiatonicFunction.I7));
        assertEquals(ChromaticChordEnum.Dm7, ChromaticChord.from(ton, DiatonicFunction.II7));
        assertEquals(ChromaticChordEnum.Em7, ChromaticChord.from(ton, DiatonicFunction.III7));
        assertEquals(ChromaticChordEnum.FMaj7, ChromaticChord.from(ton, DiatonicFunction.IV7));
        assertEquals(ChromaticChordEnum.G7, ChromaticChord.from(ton, DiatonicFunction.V7));
        assertEquals(ChromaticChordEnum.Am7, ChromaticChord.from(ton, DiatonicFunction.VI7));
        assertEquals(ChromaticChordEnum.Bm7b5, ChromaticChord.from(ton, DiatonicFunction.VII7));

        assertEquals(ChromaticChordEnum.C5, ChromaticChord.from(ton, ChromaticFunction.I5));
        assertEquals(ChromaticChordEnum.D5, ChromaticChord.from(ton, ChromaticFunction.II5));
        assertEquals(ChromaticChordEnum.E5, ChromaticChord.from(ton, ChromaticFunction.III5));
        assertEquals(ChromaticChordEnum.F5, ChromaticChord.from(ton, ChromaticFunction.IV5));
        assertEquals(ChromaticChordEnum.G5, ChromaticChord.from(ton, ChromaticFunction.V5));
        assertEquals(ChromaticChordEnum.A5, ChromaticChord.from(ton, ChromaticFunction.VI5));
        assertEquals(ChromaticChordEnum.B5, ChromaticChord.from(ton, ChromaticFunction.VII5));

        assertEquals(ChromaticChordEnum.A, ChromaticChord.from(ton, ChromaticFunction.V_II));
        assertEquals(ChromaticChordEnum.B, ChromaticChord.from(ton, ChromaticFunction.V_III));
        assertEquals(ChromaticChordEnum.C, ChromaticChord.from(ton, ChromaticFunction.V_IV));
        assertEquals(ChromaticChord.from(ton, DiatonicFunction.I), ChromaticChord.from(ton, ChromaticFunction.V_IV));
        assertEquals(ChromaticChordEnum.D, ChromaticChord.from(ton, ChromaticFunction.V_V));
        assertEquals(ChromaticChordEnum.E, ChromaticChord.from(ton, ChromaticFunction.V_VI));

        assertEquals(ChromaticChordEnum.A7, ChromaticChord.from(ton, ChromaticFunction.V7_II));
        assertEquals(ChromaticChordEnum.B7, ChromaticChord.from(ton, ChromaticFunction.V7_III));
        assertTrue(ChromaticChord.from(ton, ChromaticFunction.V7_IV).equalsEnharmonic(ChromaticChordEnum.C7));
        assertEquals(ChromaticChordEnum.D7, ChromaticChord.from(ton, ChromaticFunction.V7_V));
        assertEquals(ChromaticChordEnum.E7, ChromaticChord.from(ton, ChromaticFunction.V7_VI));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7).equalsEnharmonic(ChromaticChordEnum.CC7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_II).equalsEnharmonic(ChromaticChordEnum.DD7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_III).equalsEnharmonic(ChromaticChordEnum.F7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_IV).equalsEnharmonic(ChromaticChordEnum.FF7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_V).equalsEnharmonic(ChromaticChordEnum.GG7));

        assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_VI).equalsEnharmonic(ChromaticChordEnum.AA7));

        assertEquals(
                ChromaticChordEnum.CC.getInv(), ChromaticChord.from(ton, ChromaticFunction.N6)
        );

        // TODO:
        // V7ALT

        ton = Tonality.Cm;

        assertTrue(ChromaticChord.from(ton, DiatonicFunction.VII7).equalsEnharmonic(ChromaticChordEnum.AA7));

        ton = Tonality.Db;
        assertTrue(ChromaticChord.from(ton, DiatonicFunction.II).equalsEnharmonic(ChromaticChordEnum.DDm));
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

        assertEquals(ChromaticChordEnum.Csus2, ChromaticChord.from(ton, DiatonicFunction.I2));
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
        assertEquals(DiatonicFunction.VII7, ton.getFunction(CustomChromaticChord.from(ChromaticChordEnum.AA7).rename(ton)));
    }
}
