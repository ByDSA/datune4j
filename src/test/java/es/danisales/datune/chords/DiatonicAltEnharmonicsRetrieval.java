package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.ScaleDistance;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class DiatonicAltEnharmonicsRetrieval {
    @Test
    public void getAllFromDiatonicAlt() {
        Set<DiatonicAlt> diatonicAltSet = es.danisales.datune.chords.transformations.DiatonicAltEnharmonicsRetrieval.getFromDiatonicAlt(DiatonicAlt.Eb, 1);
        assertEquals( 2, diatonicAltSet.size() );
        assertTrue( diatonicAltSet.contains(DiatonicAlt.Eb) );
        assertTrue( diatonicAltSet.contains(DiatonicAlt.DD) );
    }

    @Test
    public void getAllFromDiatonicAlt2() {
        Set<DiatonicAlt> diatonicAltSet = es.danisales.datune.chords.transformations.DiatonicAltEnharmonicsRetrieval.getFromDiatonicAlt(DiatonicAlt.Eb, 0);
        assertEquals( 0, diatonicAltSet.size() );
    }

    @Test
    public void getAllFromDiatonicAlt3() {
        Set<DiatonicAlt> diatonicAltSet = es.danisales.datune.chords.transformations.DiatonicAltEnharmonicsRetrieval.getFromDiatonicAlt(DiatonicAlt.Fb, 0);
        assertEquals( 1, diatonicAltSet.size() );
        assertTrue( diatonicAltSet.contains(DiatonicAlt.E) );
    }

    @Test
    public void getAllFromChromaticAndMaxAlt() {
        Set<DiatonicAlt> diatonicAltSet = es.danisales.datune.chords.transformations.DiatonicAltEnharmonicsRetrieval.getFromChromatic(Chromatic.C, 1);
        assertEquals( 2, diatonicAltSet.size() );
        assertTrue( diatonicAltSet.contains(DiatonicAlt.BB));
        assertTrue( diatonicAltSet.contains(DiatonicAlt.C));
        System.out.println(diatonicAltSet);
    }

    @Test
    public void getAllFromChromaticAndMaxAlt2() {
        Set<DiatonicAlt> diatonicAltSet = es.danisales.datune.chords.transformations.DiatonicAltEnharmonicsRetrieval.getFromChromaticMicro(Chromatic.DD, 0.5f, 1);
        assertEquals( 2, diatonicAltSet.size() );
        assertFalse( diatonicAltSet.contains(DiatonicAlt.DD));
        assertFalse( diatonicAltSet.contains(DiatonicAlt.Eb));
        assertFalse( diatonicAltSet.contains(DiatonicAlt.DD.add(ScaleDistance.QUARTER)));
        assertFalse( diatonicAltSet.contains(DiatonicAlt.Eb.add(ScaleDistance.QUARTER)));
    }

    private void getMinAlts(DiatonicAlt target, DiatonicAlt source) {
        DiatonicAlt actual = es.danisales.datune.chords.transformations.DiatonicAltEnharmonicsRetrieval.getMinimizedAlts(source);
        assertSame(target, actual);
    }

    @Test
    public void getMinAlts0() {
        getMinAlts(DiatonicAlt.E, DiatonicAlt.Fb);
    }

    @Test
    public void getMinAlts1() {
        DiatonicAlt source = DiatonicAlt.CCC;
        DiatonicAlt target = DiatonicAlt.D;
        getMinAlts(target, source);
    }

    @Test
    public void getMinAlts2() {
        DiatonicAlt source = DiatonicAlt.Cb;
        DiatonicAlt target = DiatonicAlt.B;
        getMinAlts(target, source);
    }

    @Test
    public void getMinAlts3() {
        DiatonicAlt source = DiatonicAlt.CCCC;
        DiatonicAlt target = DiatonicAlt.DD;
        getMinAlts(target, source);
    }

    @Test
    public void getMinAlts4() {
        DiatonicAlt source = DiatonicAlt.Eb;
        DiatonicAlt target = DiatonicAlt.Eb;
        getMinAlts(target, source);
    }
}