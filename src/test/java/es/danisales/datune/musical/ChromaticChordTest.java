package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.tonality.Tonality;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class ChromaticChordTest {
    @Test
    public void fromChromaticDiatonicChordTonality() {
        ChromaticChord chromaticChord = ChromaticChord.from( Chromatic.B, DiatonicChordPattern.NINTH, Tonality.C );
        assertEquals( Arrays.asList(
                Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
                chromaticChord.getNotes()
        );
    }

    @Test
    public void inv() {
        ChromaticChord chromaticChord = ChromaticChord.Gsus4.duplicate();
        chromaticChord.inv();
        assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.D,
                Chromatic.G
                ),
                chromaticChord.getNotes()
        );
        assertEquals(2, chromaticChord.getRootPos());
        chromaticChord.inv(2);
        assertEquals(Arrays.asList(
                Chromatic.G,
                Chromatic.C,
                Chromatic.D
                ),
                chromaticChord.getNotes()
        );
        assertEquals(0, chromaticChord.getRootPos());
    }

    @Test
    public void size() {
        for (ChromaticChord c : ChromaticChord.CHORDS_FIFTH)
            Assert.assertEquals(2, c.size());

        for (ChromaticChord c : ChromaticChord.TRIAD_CHORDS)
            Assert.assertEquals(3, c.size());

        for (ChromaticChord c : ChromaticChord.SEVENTH_CHORDS)
            if (ChromaticChord.CHORDS_7add11.contains( c ) || ChromaticChord.CHORDS_7add13.contains( c ))
                Assert.assertEquals(c.toString(), 5, c.size());
            else
                Assert.assertEquals(c.toString(), 4, c.size());

        for (ChromaticChord c : ChromaticChord.NINTH_CHORDS)
            if (ChromaticChord.CHORDS_9add6.contains( c ) || ChromaticChord.CHORDS_9a11.contains( c ) || ChromaticChord.CHORDS_Maj9a11.contains( c ))
                Assert.assertEquals(c.toString(), 6, c.size());
            else
                Assert.assertEquals(c.toString(), 5, c.size());

        for (ChromaticChord c : ChromaticChord.ELEVENTH_CHORDS)
            Assert.assertEquals(c.toString(), 6, c.size());

        for (ChromaticChord c : ChromaticChord.THIRTEENTH_CHORDS)
            Assert.assertTrue(c.toString(), c.size() == 6 || c.size() == 7);
    }

    @Test
    public void namesFixed() {
        assertEquals( "C", ChromaticChord.C.toString() );
        assertEquals( "Cm", ChromaticChord.Cm.toString() );
        assertEquals( "C7", ChromaticChord.C7.toString() );
        assertEquals( "F5", ChromaticChord.F5.toString() );
        assertEquals( "Csus2", ChromaticChord.Csus2.toString() );
        assertEquals( "Gsus4", ChromaticChord.Gsus4.toString() );
        assertEquals( "C13#5#9", ChromaticChord.C13a5a9.toString() );
        assertEquals( "C#13#5b9 (omit11)", ChromaticChord.CC13a5b9omit11.toString() );
    }

    @Test
    public void namesFrom() {
        ChromaticChord cc = ChromaticChord.from(
                Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)
        );

        assertEquals( "C", cc.toString() );

        cc = ChromaticChord.from(
                Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA)
        );
        assertEquals( "C7", cc.toString() );
    }

    @Test
    public void namesInv() {
        ChromaticChord chromaticChord = ChromaticChord.C.duplicate();
        chromaticChord.inv();
        assertEquals("C/E", chromaticChord.toString());
        chromaticChord.inv();
        assertEquals("C/G", chromaticChord.toString());
        chromaticChord.inv();
        assertEquals("C", chromaticChord.toString());

        chromaticChord = ChromaticChord.F5.duplicate();
        chromaticChord.inv();
        assertEquals( "F5/C", chromaticChord.toString() );

        chromaticChord = ChromaticChord.Csus2.duplicate();
        chromaticChord.inv();
        assertEquals( "Csus2/D", chromaticChord.toString() );

        chromaticChord = ChromaticChord.Gsus4.duplicate();
        chromaticChord.inv();
        assertEquals( "Gsus4/C", chromaticChord.toString() );
    }

    @Test
    public void sameNotesAndDifferentRootAreDifferent() {
        ChromaticChord Csus2 = ChromaticChord.Csus2;
        ChromaticChord Gsus4_inv = ChromaticChord.Gsus4.duplicate();
        Gsus4_inv.inv();
        assertEquals(Csus2.getNotes(), Gsus4_inv.getNotes());
        assertNotEquals(Csus2.getRootPos(), Gsus4_inv.getRootPos());
        assertNotEquals(Csus2, Gsus4_inv);
    }

    @Test
    public void from() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.E) );
        assertNotNull(chromaticChord);

        assertEquals(3, chromaticChord.size());
        assertEquals(0, chromaticChord.getRootPos());
        assertEquals(Chromatic.C, chromaticChord.get(0));
        assertEquals(Chromatic.D, chromaticChord.get(1));
        assertEquals(Chromatic.E, chromaticChord.get(2));
    }

    @Test
    public void getAllInversions() {
        List<ChromaticChord> listChromaticChords = ChromaticChord.C.getAllInversions();

        ChromaticChord original = ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G) );
        ChromaticChord inv1 = ChromaticChord.from( Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C) );
        inv1.setRootPos(2);
        ChromaticChord inv2 = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E) );
        inv2.setRootPos(1);

        assertEquals(3, listChromaticChords.size());
        assertEquals( original, listChromaticChords.get(0) );
        assertEquals( inv1, listChromaticChords.get(1) );
        assertEquals( inv2, listChromaticChords.get(2) );
    }

    @Test
    public void duplicateCustom() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.E ));
        ChromaticChord duplicatedChromaticChord = chromaticChord.duplicate();

        assertEquals(chromaticChord, duplicatedChromaticChord);

        chromaticChord.set(2, Chromatic.G);

        assertNotEquals(chromaticChord, duplicatedChromaticChord);
    }

    @Test
    public void duplicateCustomInv() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.D ));
        chromaticChord.inv();
        ChromaticChord duplicatedChromaticChord = chromaticChord.duplicate();

        assertEquals(chromaticChord, duplicatedChromaticChord);
    }

    @Test
    public void duplicateEnum() {
        ChromaticChord chromaticChord = ChromaticChord.C.duplicate();
        assertEquals(ChromaticChord.C.innerChord, chromaticChord.innerChord);


        chromaticChord.set(1, Chromatic.DD);

        assertNotEquals(ChromaticChord.C.innerChord, chromaticChord.innerChord);
    }

    @Test
    public void set() {
        ChromaticChord chromaticChord = ChromaticChord.C.duplicate();
        assertEquals(ChromaticChord.C.innerChord, chromaticChord.innerChord);

        chromaticChord.set(1, Chromatic.DD);

        assertEquals(Chromatic.DD, chromaticChord.get(1));
    }
}
