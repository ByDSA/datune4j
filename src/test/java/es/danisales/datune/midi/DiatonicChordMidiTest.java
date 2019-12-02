package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.ChromaticChordInterface;
import es.danisales.datune.musical.DiatonicChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static es.danisales.datune.midi.DiatonicChordMidiFromDiatonicFunctionTest.assertPitchInChord;
import static org.junit.Assert.*;

public class DiatonicChordMidiTest {

    @Test
    public void addDuplicate() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.II_THIRD, Tonality.Gm)
                .octave(6)
                .build();
        DiatonicChordMidiTransformations.addDuplicate(c, 1);
        assertEquals(4, c.size());
        assertPitchInChord(PitchChromaticMidi.A6, c, 0);
        assertPitchInChord(PitchChromaticMidi.C7, c, 1);
        assertPitchInChord(PitchChromaticMidi.A7, c, 2);
        assertPitchInChord(PitchChromaticMidi.C8, c, 3);
    }

    @Test
    public void addDuplicate2() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VI_THIRD, Tonality.Gm)
                .build();
        DiatonicChordMidiTransformations.addDuplicate(c, 2);
        assertEquals(4, c.size());
        assertPitchInChord(PitchChromaticMidi.DD6, c, 0);
        assertPitchInChord(PitchChromaticMidi.G6, c, 1);
        assertPitchInChord(PitchChromaticMidi.DD8, c, 2);
        assertPitchInChord(PitchChromaticMidi.G8, c, 3);
    }

    @Test(expected = AddedException.class)
    public void addDuplicate3() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VI_THIRD, Tonality.Gm)
                .build();
        DiatonicChordMidiTransformations.addDuplicate(c, 0);
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
    public void chordSameNote() throws PitchMidiException {
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
    public void info() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.IV6, Tonality.C)
                .octave(5)
                .build();
        diatonicChordMidi.inv(3);

        assertEquals(DiatonicFunction.IV6, diatonicChordMidi.getInfo().getFunction());
        assertEquals(3, diatonicChordMidi.getInfo().getChromaticChord().getInversionNumber());
    }

    @Test
    public void info2() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.IV6, Tonality.C)
                .octave(5)
                .build();

        assertEquals(DiatonicFunction.IV6, diatonicChordMidi.getInfo().getFunction());
        assertEquals(0, diatonicChordMidi.getInfo().getChromaticChord().getInversionNumber());
    }

    @Test(timeout = 1000)
    public void toChordFunc() {
        DiatonicChordMidi c = (DiatonicChordMidi.builder().from(DiatonicFunction.IV6, Tonality.C).octave(5).build());
        c.inv(3);

        List<DiatonicChordMidiInfo> chords = DiatonicChordMidiBuilder.fromChromaticChord(
                ChromaticChord.builder().fromDiatonicChordMidi(c).build(),
                false
        );
    }

    @Test
    public void getDiatonicFunctionFrom() {
        DiatonicChordMidi c = (DiatonicChordMidi.builder()
                .from(DiatonicFunction.IV6, Tonality.C)
                .octave(5).build());
        c.inv(3);

        ChromaticChord chromaticChord = ChromaticChord.builder()
                .fromDiatonicChordMidi(c)
                .build();
        List<DiatonicFunction> diatonicFunctionList = c.getTonality().getDiatonicFunctionFrom(chromaticChord);
        assertEquals(1, diatonicFunctionList.size());
        assertEquals(DiatonicFunction.IV6, diatonicFunctionList.get(0));
    }

    @Test(timeout = 1000)
    public void whatIsIt() {
        DiatonicChordMidi c = (DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5).build());

        List<DiatonicChordMidiInfo> chords = DiatonicChordMidiBuilder.fromChromaticChord(
                ChromaticChord.builder().fromDiatonicChordMidi(c).build(),
                false
        );

        for (DiatonicChordMidiInfo diatonicChordMidi : chords)
            System.out.println(diatonicChordMidi);
        int s1 = chords.size();
        assertEquals(50, s1);
    }

    @Test(timeout = 1000)
    public void whatIsIt2() {
        DiatonicChordMidi c = (DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5).build());

        List<DiatonicChordMidiInfo> chords = DiatonicChordMidiBuilder.fromChromaticChord(
                ChromaticChord.builder().fromDiatonicChordMidi(c).build(),
                true
        );

        for (DiatonicChordMidiInfo diatonicChordMidi : chords)
            System.out.println(diatonicChordMidi);
        int s1 = chords.size();
        assertEquals(50, s1);
    }

    @Test
    public void chordInv() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .build();
        c.inv();
        assertEquals(2, c.getRootIndex());
        assertPitchInChord(PitchChromaticMidi.E5, c, 0);
        assertPitchInChord(PitchChromaticMidi.G5, c, 1);
        assertPitchInChord(PitchChromaticMidi.C6, c, 2);
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
    public void equals() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .build();
        assertEquals(c, c2);
    }

    @Test
    public void equals2() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .length(Duration.L2)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .build();

        assertNotEquals(c, c2);
    }

    @Test
    public void equals3() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .length(Duration.L2)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .length(Duration.L2)
                .build();

        assertEquals(c, c2);
    }

    @Test
    public void equals4() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(6)
                .length(Duration.L2)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .length(Duration.L2)
                .build();

        assertNotEquals(c, c2);
    }

    @Test
    public void equals5() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(6)
                .length(Duration.L2)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(6)
                .length(Duration.L2)
                .build();

        assertEquals(c, c2);
    }


    @Test
    public void equals6() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.Cm)
                .octave(6)
                .length(Duration.L2)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(6)
                .length(Duration.L2)
                .build();

        assertNotEquals(c, c2);
    }

    @Test
    public void equals7() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.Cm)
                .octave(6)
                .length(Duration.L2)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.Cm)
                .octave(6)
                .length(Duration.L2)
                .build();

        assertEquals(c, c2);
    }

    @Test
    public void equals8() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.Cm)
                .octave(6)
                .length(Duration.L2)
                .velocity(50)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.Cm)
                .octave(6)
                .length(Duration.L2)
                .build();

        assertNotEquals(c, c2);
    }

    @Test
    public void equals9() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.Cm)
                .octave(6)
                .length(Duration.L2)
                .velocity(50)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.Cm)
                .octave(6)
                .length(Duration.L2)
                .velocity(50)
                .build();

        assertEquals(c, c2);
    }

    @Test(expected = AddedException.class)
    public void equals10() throws TonalityException {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .tonality(Tonality.C)
                .build();
        DiatonicChordMidi diatonicChordMidi2 = diatonicChordMidi.clone();
        diatonicChordMidi.addAll(
                Arrays.asList(
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.C5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.E5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.G5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.C5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.E5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.G5).build()
                )
        );
        assertEquals(diatonicChordMidi, diatonicChordMidi2);
    }


    @Test
    public void equals11() {
        DiatonicChordMidi c = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.Am).octave(5).build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder().from(DiatonicFunction.VI, Tonality.C).octave(5).build();
        assertNotEquals(c, c2);
        assertEquals(ChromaticChordInterface.from(c), ChromaticChordInterface.from(c2));
    }
/*
    @Test
    public void toDiatonic() {
        DiatonicChordMidi c = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).octave(5).build();
        assertEquals(Duration.L1, c.get(0).getLength());
        ChromaticChord ccm = ChromaticChord.builder().fromDiatonicChordMidi(c).build();
        assertEquals(Settings.DefaultValues.LENGTH_CHORD, c.get(0).getLength());
        assertEquals(c.get(0).getLength(), c.get(0).clone().getLength());

        List<DiatonicChordMidiInfo> chords = DiatonicChordMidiBuilder.fromChromaticChord(
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
    }*/
}
