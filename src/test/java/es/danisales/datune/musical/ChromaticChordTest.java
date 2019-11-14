package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.tonality.Tonality;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class ChromaticChordTest {

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
            Assert.assertEquals(c.toString(), 7, c.size());
    }

    @Test
    public void names() {
        assertEquals( "C", ChromaticChord.C.toString() );

        ChromaticChord cc = ChromaticChord.from(
                Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)
        );

        assertEquals( "C", cc.toString() );

        assertEquals( "Cm", ChromaticChord.Cm.toString() );
        assertEquals( "C7", ChromaticChord.C7.toString() );
        DiatonicChordMidi ccm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.C );
        cc.inv();
        assertEquals(
                "C/E (C)", ccm.toString()
        );
        cc = ChromaticChord.from(ChromaticChord.C);
        cc.inv();
        assertEquals( "C/E", cc.toString() );
        cc = ChromaticChord.from(ChromaticChord.C);
        cc.inv(2);
        assertEquals( "C/G", cc.toString() );
        cc = ChromaticChord.from(ChromaticChord.C);
        cc.inv(3);
        assertEquals( "C", cc.toString() );
        assertEquals( "F5", ChromaticChord.F5.toString() );
        cc = ChromaticChord.from(ChromaticChord.F5);
        cc.inv();
        assertEquals( "F5/C", cc.toString() );

        assertEquals( "Csus2", ChromaticChord.Csus2.toString() );
        cc = ChromaticChord.from(ChromaticChord.Csus2);
        cc.inv();
        assertEquals( "Csus2/D", cc.toString() );
        assertEquals( "Gsus4", ChromaticChord.Gsus4.toString() );
        cc = ChromaticChord.from(ChromaticChord.Gsus4);
        cc.inv();
        assertEquals( "Gsus4/C", cc.toString() );
    }

    @Test
    public void from() {
    }

    @Test
    public void from1() {
    }

    @Test
    public void getAllInversions() {
    }

    @Test
    public void duplicate() {
    }
}
