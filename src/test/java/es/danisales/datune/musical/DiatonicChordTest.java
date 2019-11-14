package es.danisales.datune.musical;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DiatonicChordTest {
    @Test
    public void getInvToEnum() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        assertNotSame(DiatonicChordEnum.TRIAD, diatonicChord);
        assertNotEquals(DiatonicChordEnum.TRIAD, diatonicChord);
    }

    @Test
    public void getInvToEnumResetRoot() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        diatonicChord.setRootPos(0);
        assertSame(DiatonicChordEnum.TRIAD, diatonicChord.innerChord);
    }

}
