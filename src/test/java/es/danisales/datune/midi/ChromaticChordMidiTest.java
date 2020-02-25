package es.danisales.datune.midi;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.chromatic.ChromaticChordRetrieval;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ChromaticChordMidiTest {
    @Test
    public void fromChromaticChord() {
        ChromaticChord chromaticChord = ChromaticChord.F5;
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(chromaticChord).build();
        for (int i = 0; i < chromaticChord.size(); i++)
            assertEquals(chromaticChord.get(i), chromaticChordMidi.get(i).getPitch().getNote());

        assertEquals(PitchChromaticMidi.F5, chromaticChordMidi.get(0).getPitch());
        assertEquals(PitchChromaticMidi.C6, chromaticChordMidi.get(1).getPitch());
    }

    @Test
    public void fromChromaticChord2() {
        ChromaticChord chromaticChord = ChromaticChord.B9;
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(chromaticChord).build();
        for (int i = 0; i < chromaticChord.size(); i++)
            assertEquals(chromaticChord.get(i), chromaticChordMidi.get(i).getPitch().getNote());

        assertEquals(PitchChromaticMidi.B5, chromaticChordMidi.get(0).getPitch());
        assertEquals(PitchChromaticMidi.DD6, chromaticChordMidi.get(1).getPitch());
        assertEquals(PitchChromaticMidi.FF6, chromaticChordMidi.get(2).getPitch());
        assertEquals(PitchChromaticMidi.A6, chromaticChordMidi.get(3).getPitch());
        assertEquals(PitchChromaticMidi.CC7, chromaticChordMidi.get(4).getPitch());
    }

    @Test
    public void setOctave() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .fromChromaticChord(ChromaticChord.B9)
                .build();
        System.out.println(chromaticChordMidi);
        assertEquals(5, chromaticChordMidi.getOctave());

        chromaticChordMidi.setOctave(4);
        assertEquals(4, chromaticChordMidi.getOctave());
        assertEquals(4, chromaticChordMidi.get(0).getPitch().getOctave());
        assertEquals(5, chromaticChordMidi.get(1).getPitch().getOctave());
        assertEquals(5, chromaticChordMidi.get(2).getPitch().getOctave());
        assertEquals(5, chromaticChordMidi.get(3).getPitch().getOctave());
        assertEquals(6, chromaticChordMidi.get(4).getPitch().getOctave());
    }

    @Test
    public void dist() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        ChordMidi chromaticChordMidi2 = chromaticChordMidi.clone();
        chromaticChordMidi2.shiftOctave(1);

        assertEquals(26, ChordMidiTransformations.dist(chromaticChordMidi, chromaticChordMidi2));
    }

    @Test
    public void dist2() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        ChordMidi chromaticChordMidi2 = chromaticChordMidi.clone();
        chromaticChordMidi2.shiftOctave(1);

        assertNotEquals(0, ChordMidiTransformations.dist(chromaticChordMidi, chromaticChordMidi2));
    }

    @Test
    public void dist3() throws PitchMidiException {
        ChordMidi ccm = ChordMidi.builder().fromNoteMidi(
                NoteMidi.builder().pitch(67).build(),
                NoteMidi.builder().pitch(69).build(),
                NoteMidi.builder().pitch(74).build()
        ).build();
        ChordMidi ccm2 = ChordMidi.builder().fromNoteMidi(
                NoteMidi.builder().pitch(4).build(),
                NoteMidi.builder().pitch(69).build(),
                NoteMidi.builder().pitch(74).build()
        ).build();

        assertEquals(ChordMidiTransformations.dist(ccm2, ccm), ChordMidiTransformations.dist(ccm, ccm2));
        assertEquals(63, ChordMidiTransformations.dist(ccm, ccm2));
        assertTrue(ChordMidiTransformations.dist(ccm, ccm2) > 2);
    }

    @Test
    public void distItself() {
        ChordMidi ccm = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        assertEquals(0.0f, ChordMidiTransformations.dist(ccm, ccm), 0);
    }

    @Test
    public void distSameBidirectional() {
        ChordMidi ccm = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        ChordMidi ccm2 = ChordMidi.builder().fromChromaticChord(ChromaticChord.D).build();
        assertEquals(ChordMidiTransformations.dist(ccm2, ccm), ChordMidiTransformations.dist(ccm, ccm2), 0);
        assertNotEquals(0, ChordMidiTransformations.dist(ccm, ccm2));
    }

    @Test
    public void setMinOctave() {
        ChordMidi ccm = ChordMidi.builder()
                .fromChromaticChord(ChromaticChord.C5)
                .build();
        ccm.setMinOctave();
        Assert.assertEquals(PitchChromaticMidi.MIN_OCTAVE, ccm.getOctave());
    }

    @Test
    public void noteSorting() throws PitchMidiException {
        ChordMidi notes = ChordMidi.builder().fromNoteMidi(
                NoteMidi.builder().pitch(Chromatic.A).build(),
                NoteMidi.builder().pitch(Chromatic.E).build(),
                NoteMidi.builder().pitch(Chromatic.F).build(),
                NoteMidi.builder().pitch(Chromatic.B, 6).build(),
                NoteMidi.builder().pitch(Chromatic.C, 4).build(),
                NoteMidi.builder().pitch(Chromatic.G).build()
        ).build();

        int code = notes.get(0).getPitch().getMidiCode();
        for (int i = 1; i < notes.size(); i++) {
            int code_i = notes.get(i).getPitch().getMidiCode();
            assertTrue(code_i >= code);
            code = code_i;
        }
    }

    @Test
    public void octave_default() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .fromChromaticChord(ChromaticChord.C5)
                .build();
        Assert.assertEquals(5, chromaticChordMidi.getOctave());
    }

    @Test
    public void shiftOctave() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .fromChromaticChord(ChromaticChord.C5)
                .build();
        chromaticChordMidi.shiftOctave(-1);
        Assert.assertEquals(4, chromaticChordMidi.getOctave());
    }

    @Test
    public void sizeSameAsChromaticChord() {
        for (ChromaticChord chromaticChord : ChromaticChordRetrieval.immutableValues()) {
            assertEquals(chromaticChord.size(), ChordMidi.builder().fromChromaticChord(chromaticChord).build().size());
        }
    }

    @Test
    public void sizeFromNew() {
        ChordMidi chromaticChordMidi = ChordMidi.builder().build();
        chromaticChordMidi.add(NoteMidi.builder().pitch(PitchChromaticMidi.C5).build());
        chromaticChordMidi.add(NoteMidi.builder().pitch(PitchChromaticMidi.E5).build());
        chromaticChordMidi.add(NoteMidi.builder().pitch(PitchChromaticMidi.G5).build());

        assertEquals(3, chromaticChordMidi.size());
    }

    @Test
    public void add() {
        ChordMidi chromaticChordMidi = ChordMidi.builder().build();
        chromaticChordMidi.add(NoteMidi.builder().pitch(PitchChromaticMidi.C5).build());
        chromaticChordMidi.add(NoteMidi.builder().pitch(PitchChromaticMidi.E5).build());
        chromaticChordMidi.add(NoteMidi.builder().pitch(PitchChromaticMidi.G5).build());

        assertEquals(3, chromaticChordMidi.size());
        assertEquals(PitchChromaticMidi.C5, chromaticChordMidi.get(0).getPitch());
        assertEquals(PitchChromaticMidi.E5, chromaticChordMidi.get(1).getPitch());
        assertEquals(PitchChromaticMidi.G5, chromaticChordMidi.get(2).getPitch());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void add_null() {
        ChordMidi chromaticChordMidi = ChordMidi.builder().build();
        chromaticChordMidi.add(null);
    }

    @Test
    public void add_index() {
        ChordMidi chromaticChordMidi = ChordMidi.builder().build();
        chromaticChordMidi.add(0, NoteMidi.builder().pitch(PitchChromaticMidi.G5).build());
        chromaticChordMidi.add(0, NoteMidi.builder().pitch(PitchChromaticMidi.E5).build());
        chromaticChordMidi.add(0, NoteMidi.builder().pitch(PitchChromaticMidi.C5).build());

        assertEquals(3, chromaticChordMidi.size());
        assertEquals(PitchChromaticMidi.C5, chromaticChordMidi.get(0).getPitch());
        assertEquals(PitchChromaticMidi.E5, chromaticChordMidi.get(1).getPitch());
        assertEquals(PitchChromaticMidi.G5, chromaticChordMidi.get(2).getPitch());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_index_greaterThanSize() {
        ChordMidi chromaticChordMidi = ChordMidi.builder().build();
        chromaticChordMidi.add(1, NoteMidi.builder().pitch(PitchChromaticMidi.E5).build());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void add_index_null() {
        ChordMidi chromaticChordMidi = ChordMidi.builder().build();
        chromaticChordMidi.add(0, null);
    }

    @Test
    public void setVelocity() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(NoteMidi.builder().pitch(PitchChromaticMidi.C5).build())
                .add(NoteMidi.builder().pitch(PitchChromaticMidi.E5).velocity(50).build())
                .add(NoteMidi.builder().pitch(PitchChromaticMidi.G5).velocity(0).build())
                .build();

        chromaticChordMidi.setVelocity(50);

        assertEquals(64, chromaticChordMidi.get(0).getVelocity());
        assertEquals(25, chromaticChordMidi.get(1).getVelocity());
        assertEquals(0, chromaticChordMidi.get(2).getVelocity());
    }

    @Test
    public void setVelocity2() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(NoteMidi.builder().pitch(PitchChromaticMidi.C5).build())
                .add(NoteMidi.builder().pitch(PitchChromaticMidi.E5).velocity(50).build())
                .add(NoteMidi.builder().pitch(PitchChromaticMidi.G5).velocity(0).build())
                .build();

        chromaticChordMidi.setVelocity(200);

        assertEquals(128, chromaticChordMidi.get(0).getVelocity());
        assertEquals(100, chromaticChordMidi.get(1).getVelocity());
        assertEquals(0, chromaticChordMidi.get(2).getVelocity());
    }

    @Test
    public void getOctave() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C6)
                .add(PitchChromaticMidi.E7)
                .add(PitchChromaticMidi.G5)
                .build();

        assertEquals(5, chromaticChordMidi.getOctave());
    }

    @Test
    public void equals() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C6)
                .add(PitchChromaticMidi.E7)
                .add(PitchChromaticMidi.G5)
                .build();

        ChordMidi chromaticChordMidi2 = ChordMidi.builder()
                .add(PitchChromaticMidi.G5)
                .add(PitchChromaticMidi.C6)
                .add(PitchChromaticMidi.E7)
                .build();

        assertEquals(chromaticChordMidi, chromaticChordMidi2);
    }

    @Test
    public void cloneTest() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C6)
                .add(PitchChromaticMidi.E7)
                .add(PitchChromaticMidi.G5)
                .build();

        ChordMidi chromaticChordMidi2 = chromaticChordMidi.clone();

        assertEquals(chromaticChordMidi, chromaticChordMidi2);
        assertNotSame(chromaticChordMidi, chromaticChordMidi2);

        for (int i = 0; i < chromaticChordMidi.size(); i++) {
            assertEquals(chromaticChordMidi.get(i), chromaticChordMidi2.get(i));
            assertNotSame(chromaticChordMidi.get(i), chromaticChordMidi2.get(i));
        }
    }

    @Test
    public void remove() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C5)
                .add(PitchChromaticMidi.E5)
                .add(PitchChromaticMidi.G5)
                .build();

        chromaticChordMidi.remove(NoteMidi.builder().pitch(PitchChromaticMidi.E5).build());

        assertEquals(2, chromaticChordMidi.size());
        assertEquals(PitchChromaticMidi.C5, chromaticChordMidi.get(0).getPitch());
        assertEquals(PitchChromaticMidi.G5, chromaticChordMidi.get(1).getPitch());
    }

    @Test
    public void remove_notFound() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C5)
                .add(PitchChromaticMidi.E5)
                .add(PitchChromaticMidi.G5)
                .build();

        chromaticChordMidi.remove(NoteMidi.builder().pitch(PitchChromaticMidi.E5).velocity(50).build());

        assertEquals(3, chromaticChordMidi.size());
        assertEquals(PitchChromaticMidi.C5, chromaticChordMidi.get(0).getPitch());
        assertEquals(PitchChromaticMidi.E5, chromaticChordMidi.get(1).getPitch());
        assertEquals(PitchChromaticMidi.G5, chromaticChordMidi.get(2).getPitch());
    }

    @Test
    public void hashCodeTest() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C5)
                .add(PitchChromaticMidi.E5)
                .add(PitchChromaticMidi.G5)
                .build();
        ChordMidi chromaticChordMidi2 = chromaticChordMidi.clone();

        assertEquals(chromaticChordMidi.hashCode(), chromaticChordMidi2.hashCode());
    }

    @Test
    public void hashCodeTest_different() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C5)
                .add(PitchChromaticMidi.E5)
                .add(PitchChromaticMidi.G5)
                .build();
        ChordMidi chromaticChordMidi2 = chromaticChordMidi.clone();
        chromaticChordMidi2.get(0).setVelocity(50);

        assertNotEquals(chromaticChordMidi.hashCode(), chromaticChordMidi2.hashCode());
    }

    @Test
    public void hashCodeTest_different_emptyChord() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C5)
                .add(PitchChromaticMidi.E5)
                .add(PitchChromaticMidi.G5)
                .build();
        ChordMidi chromaticChordMidi2 = chromaticChordMidi.clone();
        chromaticChordMidi2.clear();

        assertNotEquals(chromaticChordMidi.hashCode(), chromaticChordMidi2.hashCode());
    }

    @Test
    public void clear() {
        ChordMidi chromaticChordMidi = ChordMidi.builder()
                .add(PitchChromaticMidi.C5)
                .add(PitchChromaticMidi.E5)
                .add(PitchChromaticMidi.G5)
                .build();
        chromaticChordMidi.clear();

        assertEquals(0, chromaticChordMidi.size());
    }

    @Test
    public void containsPitch() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        NoteMidi chromaticMidi = NoteMidi.builder().pitch(60).build();
        assertTrue(chromaticChordMidi.containsPitch(chromaticMidi));
    }

    @Test
    public void containsPitchFalse() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        NoteMidi chromaticMidi = NoteMidi.builder().pitch(61).build();
        assertFalse(chromaticChordMidi.containsPitch(chromaticMidi));
    }

    @Test
    public void containsPitchAllChromaticChordMidi() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        NoteMidi chromaticMidi = NoteMidi.builder().pitch(60).build();
        NoteMidi chromaticMidi2 = NoteMidi.builder().pitch(64).build();
        NoteMidi chromaticMidi3 = NoteMidi.builder().pitch(67).build();
        ChordMidi chromaticChordMidi2 = ChordMidi.builder().fromNoteMidi(
                Arrays.asList(
                        chromaticMidi,
                        chromaticMidi2,
                        chromaticMidi3
                )
        ).build();
        assertTrue(chromaticChordMidi.containsPitchAll(chromaticChordMidi2));
    }

    @Test
    public void containsPitchAllList() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        NoteMidi chromaticMidi = NoteMidi.builder().pitch(60).build();
        NoteMidi chromaticMidi2 = NoteMidi.builder().pitch(64).build();
        NoteMidi chromaticMidi3 = NoteMidi.builder().pitch(67).build();
        List<NoteMidi> chromaticChordMidi2 = Arrays.asList(
                chromaticMidi,
                chromaticMidi2,
                chromaticMidi3
        );
        assertTrue(chromaticChordMidi.containsPitchAll(chromaticChordMidi2));
    }

    @Test
    public void get() throws PitchMidiException {
        ChordMidi chromaticChordMidi = ChordMidi.builder().fromChromaticChord(ChromaticChord.C).build();
        NoteMidi chromaticMidi = NoteMidi.builder().pitch(60).build();
        NoteMidi chromaticMidi2 = NoteMidi.builder().pitch(64).build();
        NoteMidi chromaticMidi3 = NoteMidi.builder().pitch(67).build();

        assertEquals(chromaticMidi.pitch, chromaticChordMidi.get(0).pitch);
        assertEquals(chromaticMidi2.pitch, chromaticChordMidi.get(1).pitch);
        assertEquals(chromaticMidi3.pitch, chromaticChordMidi.get(2).pitch);
    }
}
