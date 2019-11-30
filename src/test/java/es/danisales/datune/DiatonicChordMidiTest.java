package es.danisales.datune;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.*;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DiatonicChordMidiTest {

    private void assertPitchInChord(PitchChromaticMidi pitchChromaticMidi, DiatonicChordMidi diatonicChordMidi, int pos) {
        assertEquals("Actual: " + PitchChromaticMidi.from(diatonicChordMidi.get(pos).getPitch()) + " Expected: " + pitchChromaticMidi,
                pitchChromaticMidi.getMidiCode(), diatonicChordMidi.get(pos).getPitch().getMidiCode());
    }

    @Test
    public void fromDiatonicFunction() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction2() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I_THIRD, Tonality.C)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 1);
    }

    @Test
    public void fromDiatonicFunction3() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I_THIRD, Tonality.Gm)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.AA5, diatonicChordMidi, 1);
    }

    @Test
    public void fromDiatonicFunction4() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.II_THIRD, Tonality.Gm)
                .octave(6)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.A6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.C7, diatonicChordMidi, 1);
    }

    @Test
    public void fromDiatonicFunction5() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VI_THIRD, Tonality.Gm)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.DD6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.G6, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.I5, Tonality.C)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction2() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.II5, Tonality.C)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.D5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction3() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.VII5, Tonality.C)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.FF6, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction4() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.I5, Tonality.Cm)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction5() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.II5, Tonality.Cm)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.D5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 1);
    }

    @Test
    public void addDuplicate() {
        DiatonicChordMidi c = DiatonicChordMidi.builder().from(DiatonicFunction.II_THIRD, Tonality.Gm)
                .octave(6)
                .build();
        DiatonicChordMidiTransformations.addDuplicate(c, 1);
        assertEquals(4, c.size());
        assertEquals(PitchChromaticMidi.A7.getMidiCode(), c.get(2).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.C8.getMidiCode(), c.get(3).getPitch().getMidiCode());
    }

    @Test
    public void addDuplicateChord() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VI_THIRD, Tonality.Gm)
                .build();
        assertEquals(PitchChromaticMidi.DD6.getMidiCode(), c.get(0).getPitch().getMidiCode());
        DiatonicChordMidiTransformations.addDuplicate(c, 1);
    }

    @Test
    public void constructorDiatonicFunc() {
        Tonality s = Tonality.from(Chromatic.C, Scale.MAJOR);
        DiatonicChordMidi c;
        c = DiatonicChordMidi.builder().from(DiatonicFunction.I, s)
                .octave(5)
                .build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.C5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.E5.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.G5.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.II, s)
                .octave(5)
                .build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.D5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.F5.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.A5.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.III, s)
                .octave(5)
                .build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.E5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.G5.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.B5.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.IV, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.F5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.A5.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.C6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.V, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.G5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.B5.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.D6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.VI, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.A5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.C6.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.E6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.VII, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.B5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.D6.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.F6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        s = Tonality.from(Chromatic.FF, Scale.MINOR);

        c = DiatonicChordMidi.builder().from(DiatonicFunction.I, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.FF5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.A5.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.CC6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.II, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.GG5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.B5.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.D6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.III, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.A5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.CC6.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.E6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.IV, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.B5.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.D6.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.FF6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.V, s)
                .octave(5)
                .build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.CC6.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.E6.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.GG6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.VI, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.D6.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.FF6.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.A6.getMidiCode(), c.get(2).getPitch().getMidiCode());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.VII, s).octave(5).build();
        assertEquals(3, c.size());
        assertEquals(PitchChromaticMidi.E6.getMidiCode(), c.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.GG6.getMidiCode(), c.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.B6.getMidiCode(), c.get(2).getPitch().getMidiCode());
    }

    @Test
    public void fromChromaticChordAndTonality() {
        DiatonicChordMidi ca = DiatonicChordMidi.builder()
                .from(ChromaticChord.C, Tonality.C)
                .build();
        assertNotNull(ca);
        assertEquals(Tonality.C, ca.getTonality());
    }

    @Test
    public void cloneTest() {
        DiatonicChordMidi ca = DiatonicChordMidi.builder()
                .from(ChromaticChord.C, Tonality.C)
                .build();
        DiatonicChordMidi ca2 = ca.clone();

        assertEquals(ca, ca2);
    }

    @Test
    public void inv() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(ChromaticChord.C, Tonality.C)
                .build();
        c.inv();
        Chromatic chromatic0 = Chromatic.from(c.get(0));
        Chromatic chromatic1 = Chromatic.from(c.get(1));
        Chromatic chromatic2 = Chromatic.from(c.getRoot());
        Chromatic chromaticRoot = Chromatic.from(c.get(2));
        assertEquals(Chromatic.E, chromatic0);
        assertEquals(Chromatic.G, chromatic1);
        assertEquals(Chromatic.C, chromatic2);
        assertEquals(Chromatic.C, chromaticRoot);
        assertEquals(2, c.getRootIndex());
    }

    @Test
    public void getRoot() {
        Chromatic chromatic = Chromatic.from(
                DiatonicChordMidi.builder()
                        .from(ChromaticChord.C, Tonality.C)
                        .build()
                        .getRoot()
        );
        assertEquals(Chromatic.C, chromatic);
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(ChromaticChord.C, Tonality.C)
                .build();
        c.inv();
        assertEquals(2, c.getRootIndex());
        assertEquals(Chromatic.C, Chromatic.from(c.getRoot()));

        c = DiatonicChordMidi.builder()
                .from(ChromaticChord.F5, Tonality.C)
                .build();
        assertEquals(0, c.getRootIndex());
        assertEquals(Chromatic.F, Chromatic.from(c.getRoot()));

        c.inv();
        assertEquals(1, c.getRootIndex());
        assertEquals(Chromatic.F, Chromatic.from(c.getRoot()));
    }

    @Test
    public void names() {
        DiatonicChordMidi ccm = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).build();
        assertEquals(
                "C/E (C)", ccm.toString()
        );

        assertEquals("C", ChromaticChord.C.toString());

        DiatonicChordMidi dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).build();

        assertEquals("C (C)", dcm.toString());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.Cm).build();
        assertEquals("Cm (C)", dcm.toString());
        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).build();
        dcm.inv();

        assertEquals("C/E (C)", dcm.toString());
        dcm.inv();
        assertEquals("C/G (C)", dcm.toString());
        dcm.inv();
        assertEquals("C (C)", dcm.toString());

        dcm = DiatonicChordMidi.builder().from(ChromaticFunction.IV5, Tonality.C).build();
        assertEquals("F5 (IV5)", dcm.toString());
        dcm.inv();
        assertEquals("F5/C (IV5)", dcm.toString());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I2, Tonality.C).build();
        assertEquals("Csus2 (I2)", dcm.toString());
        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.V4, Tonality.C).build();
        assertEquals("Gsus4 (V4)", dcm.toString());
        dcm.inv();
        assertEquals("Gsus4/C (V4)", dcm.toString());

        ChromaticChord chromaticChord = ChromaticChord.builder().fromChromatic(
                Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.G)
        ).build();
        dcm = DiatonicChordMidi.builder()
                .from(chromaticChord, Tonality.C)
                .build();
        assertEquals("Csus2 (I2)", dcm.toString());
    }


    @Test
    public void chordSameNote() throws TonalityException, PitchMidiException {
        DiatonicMidi n1 = DiatonicMidi.builder()
                .pitch(DiatonicDegree.I, Tonality.C, 5)
                .build();
        DiatonicMidi n2 = DiatonicMidi.builder()
                .pitch(DiatonicDegree.II, Tonality.C, 5)
                .build();
        DiatonicMidi n3 = DiatonicMidi.builder()
                .pitch(DiatonicDegree.III, Tonality.C, 5)
                .build();

        boolean error = false;
        DiatonicChordMidi c2 = DiatonicChordMidiBuilder.from(Arrays.asList(n2, n3));
        try {
            c2.add(n1);
        } catch (Exception e) {
            e.printStackTrace();
            error = true;
        }

        assertFalse(error);

        try {
            c2.add(n2);
            c2.add(n3);
        } catch (AddedException e) {
            error = true;
        }

        assertTrue(error);
    }


    @Test
    public void makeChord() {
        Tonality s = Tonality.B;
        int o = 5;
        DiatonicChordMidi c1 = DiatonicChordMidi.builder().from(DiatonicFunction.I, s).octave(o).build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder().from(DiatonicFunction.II, s).octave(o).build();

        assertEquals(PitchChromaticMidi.B5.getMidiCode(), c1.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.CC6.getMidiCode(), c2.get(0).getPitch().getMidiCode());
    }

    @Test
    public void scaleByChord() {
        Tonality s = Tonality.C;
        DiatonicChordMidi c = DiatonicChordMidi.builder().from(ChromaticFunction.V7_IV, s).octave(5).build();

        assertEquals(
                Tonality.from(Chromatic.C, Scale.MIXOLYDIAN).getScale(), c.getTonality().getScale()
        );

        c = DiatonicChordMidi.builder().from(ChromaticFunction.V7_V, Tonality.E).octave(5).build();
        assertEquals(
                Tonality.from(Chromatic.FF, Scale.MIXOLYDIAN).getScale(), c.getTonality().getScale()
        );
    }

    @Test
    public void toChordUnfunc() {
        DiatonicChordMidi c = (DiatonicChordMidi.builder().from(DiatonicFunction.IV6, Tonality.C).octave(5).build());
        c.inv(3);

        ChromaticChordMidi cc = ChromaticChordMidi.builder().fromDiatonicChordMidi(c).build();
    }

    @Test
    public void toChordFunc() {
        DiatonicChordMidi c = (DiatonicChordMidi.builder().from(DiatonicFunction.IV6, Tonality.C).octave(5).build());
        c.inv(3);

        List<DiatonicChordMidi> chords = DiatonicChordMidiBuilder.fromChromaticChord(
                ChromaticChord.builder().fromDiatonicChordMidi(c).build(),
                false
        );
    }

    @Test
    public void whatIsIt() {
        DiatonicChordMidi c = (DiatonicChordMidi.builder().from(DiatonicFunction.IV6, Tonality.C).octave(5).build());
        c.inv(3);

        List<DiatonicChordMidi> chords = DiatonicChordMidiBuilder.fromChromaticChord(
                ChromaticChord.builder().fromDiatonicChordMidi(c).build(),
                false
        );

        int s1 = chords.size();
        assertEquals(50, s1);

        chords = DiatonicChordMidiBuilder.fromChromaticChord(
                ChromaticChord.builder().fromDiatonicChordMidi(c).build(),
                true
        );
        int s2 = chords.size();

        assertNotEquals(s1, s2);
        assertEquals(75, s2);
    }


    @Test
    public void chordInv() {
        DiatonicChordMidi c = DiatonicChordMidi.builder().from(ChromaticFunction.I5, Tonality.C).octave(5).build();
        assertEquals(PitchChromaticMidi.G5, c.get(1).getPitch());
        assertEquals(PitchChromaticMidi.C5, c.get(0).getPitch());

        c = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).octave(5).build();
        assertEquals(PitchChromaticMidi.G5, c.get(2).getPitch());
        assertEquals(PitchChromaticMidi.E5, c.get(1).getPitch());
        assertEquals(PitchChromaticMidi.C5, c.get(0).getPitch());
        c.inv();

        assertEquals(PitchChromaticMidi.C6, c.get(2).getPitch());
        assertEquals(PitchChromaticMidi.G5, c.get(1).getPitch());
        assertEquals(PitchChromaticMidi.E5, c.get(0).getPitch());
    }

    @Test
    public void addChromatics() throws PitchMidiException, TonalityException {
        DiatonicChordMidi dcm = DiatonicChordMidi.builder()
                .tonality(Tonality.C)
                .build();
        assertEquals(Tonality.C, dcm.getTonality());
        assertEquals(0, dcm.size());
        ChromaticChordMidi ccm = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.F5).build();
        dcm.addAll(ccm);
        assertEquals(0, dcm.getRootIndex());
        Chromatic chromatic0 = Chromatic.from(dcm.get(0));
        Chromatic chromatic1 = Chromatic.from(dcm.get(1));
        assertEquals(Chromatic.F, chromatic0);
        assertEquals(Chromatic.C, chromatic1);
        assertEquals(Tonality.C, dcm.getTonality());
        assertEquals("F5 (IV5)", dcm.toString());
    }

    @Test
    public void addChromaticChord() throws TonalityException, PitchMidiException {
        DiatonicChordMidi dcm = DiatonicChordMidi.builder()
                .tonality(Tonality.C)
                .build();
        assertEquals(Tonality.C, dcm.getTonality());
        assertEquals(0, dcm.size());
        ChromaticChordMidi ccm = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.F5).build();
        dcm = DiatonicChordMidi.builder()
                .tonality(Tonality.C)
                .build();
        dcm.addAll(ccm);
        assertNotEquals(0, dcm.size());
        assertEquals(0, dcm.getRootIndex());
        Chromatic chromatic0 = Chromatic.from(dcm.get(0));
        Chromatic chromatic1 = Chromatic.from(dcm.get(1));
        assertEquals(Chromatic.F, chromatic0);
        assertEquals(Chromatic.C, chromatic1);
        assertEquals(Tonality.C, dcm.getTonality());
        assertEquals("F5 (IV5)", dcm.toString());
    }

    @Test
    public void chromaticChordToMidi() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(ChromaticChord.F5, Tonality.C)
                .build();
        assertEquals(0, c.getRootIndex());
        Chromatic chromatic0 = Chromatic.from(c.get(0));
        Chromatic chromatic1 = Chromatic.from(c.get(1));
        assertEquals(Chromatic.F, chromatic0);
        assertEquals(Chromatic.C, chromatic1);
        assertEquals("F5 (IV5)", c.toString());
    }

    @Test
    public void functions() {
        Tonality ton = Tonality.C;
        DiatonicChordMidi dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I, ton).build();
        assertEquals(ChromaticChord.C, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.II, ton).build();
        assertEquals(ChromaticChord.Dm, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.III, ton).build();
        assertEquals(ChromaticChord.Em, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.IV, ton).build();
        assertEquals(ChromaticChord.F, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.V, ton).build();
        assertEquals(ChromaticChord.G, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.VI, ton).build();
        assertEquals(ChromaticChord.Am, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.VII, ton).build();
        assertEquals(ChromaticChord.Bdim, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(ChromaticFunction.IV5, ton).build();
        assertEquals(ChromaticChord.builder().fromChromatic(
                Arrays.asList(Chromatic.F, Chromatic.C)
        ).build(), ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        ton = Tonality.FFm;
        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I, ton).build();
        assertEquals(ChromaticChord.FFm, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        assertEquals(
                DiatonicChord.from(Arrays.asList(Diatonic.D, Diatonic.F, Diatonic.A)), DiatonicChord.from(DiatonicFunction.II, Diatonic.C)
        );

        assertEquals(
                ChromaticChord.GGdim,
                ChromaticChord.builder()
                        .diatonicFunction(DiatonicFunction.II)
                        .tonality(Tonality.FFm)
                        .build()
        );
/*
		assertEquals(
			ChromaticChord.GGdim, new CustomDiatonicChord( DiatonicFunction.D ).toChromaticChord( Tonality.FFm ).toMidi().toChromaticChord()
		);*/
        assertEquals(Chromatic.GG, Chromatic.from(Tonality.FFm.getNote(DiatonicDegree.II)));

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.II, ton).build();
        assertEquals(ChromaticChord.GGdim, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.III, ton).build();
        assertEquals(ChromaticChord.A, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.IV, ton).build();
        assertEquals(ChromaticChord.Bm, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.V, ton).build();
        assertEquals(ChromaticChord.CCm, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.VI, ton).build();
        assertEquals(ChromaticChord.D, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.VII, ton).build();
        assertEquals(ChromaticChord.E, ChromaticChord.builder().fromDiatonicChordMidi(dcm).build());
    }

    @Test
    public void equals() throws TonalityException, PitchMidiException {
        DiatonicChordMidi c = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).octave(5).build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).octave(5).build();
        assertEquals(c, c2);

        c.setLength(Duration.L2);
        assertNotEquals(c, c2);
        c2.setLength(Duration.L2);
        assertEquals(c, c2);

        c.setOctave(6);
        assertNotEquals(c, c2);
        c2.setOctave(6);
        assertEquals(c, c2);

        c.setScaleAsMinor();
        assertNotEquals(c, c2);
        c2.setScaleAsMinor();
        assertEquals(c, c2);

        c.setVelocity(50);
        assertNotEquals(c, c2);
        c2.setVelocity(50);
        assertEquals(c, c2);

        c = DiatonicChordMidi.builder()
                .tonality(Tonality.C)
                .build();
        c2 = c.clone();
        c.addAll(
                Arrays.asList(
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.C5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.E5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.G5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.C5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.E5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.G5).build()
                )
        );
        assertEquals(c, c2);

        c = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.Am).octave(5).build();
        c2 = DiatonicChordMidi.builder().from(DiatonicFunction.VI, Tonality.C).octave(5).build();
        assertNotEquals(c, c2);
        assertEquals(ChromaticChordInterface.from(c), ChromaticChordInterface.from(c2));
    }

    @Test
    public void toDiatonic() {
        DiatonicChordMidi c = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).octave(5).build();
        assertEquals(Duration.L1, c.get(0).getLength());
        ChromaticChord ccm = ChromaticChord.builder().fromDiatonicChordMidi(c).build();
        assertEquals(Settings.DefaultValues.LENGTH_CHORD, c.get(0).getLength());
        assertEquals(c.get(0).getLength(), c.get(0).clone().getLength());

        List<DiatonicChordMidi> chords = DiatonicChordMidiBuilder.fromChromaticChord(
                ccm,
                false
        );

        assertEquals(true, chords.size() > 0);
        DiatonicChordMidi c2 = chords.get(0);
        assertEquals(Duration.L1, c2.get(0).getLength());
        assertEquals(c.getArpegio(), c2.getArpegio());
        assertEquals(c.getLength(), c2.getLength());
        assertEquals(ChordNamer.from(c), ChordNamer.from(c2));
        assertEquals(c.get(0).getPitch(), c2.get(0).getPitch());
        assertEquals(c.get(0).getPitch().getDegree(), c2.get(0).getPitch().getDegree());
        assertEquals(c.get(0).getLength(), c.get(0).clone().getLength());
        assertEquals(c.get(0).getLength(), c2.get(0).getLength());
        assertEquals(c.get(0).getVelocity(), c2.get(0).getVelocity());
        assertEquals(c.get(0), c2.get(0));
        assertEquals(c.get(1), c2.get(1));
        assertEquals(c.get(2), c2.get(2));

        assertEquals(c, c2);
    }
}
