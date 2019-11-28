package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ChromaticChordMidiTest {
	@Test
    public void fromChromaticChord() throws PitchMidiException {
        ChromaticChord chromaticChord = ChromaticChord.F5;
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(chromaticChord).build();
        for (int i = 0; i < chromaticChord.size(); i++)
            assertEquals(chromaticChord.get(i), chromaticChordMidi.get(i).getPitch().getChromatic());

        assertEquals(0, chromaticChordMidi.getRootPos());

        assertEquals(PitchChromaticMidi.F5, chromaticChordMidi.get(0).getPitch());
        assertEquals(PitchChromaticMidi.C6, chromaticChordMidi.get(1).getPitch());
    }

    @Test
    public void fromChromaticChord2() throws PitchMidiException {
        ChromaticChord chromaticChord = ChromaticChord.B9;
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(chromaticChord).build();
        for (int i = 0; i < chromaticChord.size(); i++)
            assertEquals(chromaticChord.get(i), chromaticChordMidi.get(i).getPitch().getChromatic());

        assertEquals(0, chromaticChordMidi.getRootPos());

        assertEquals(PitchChromaticMidi.B5, chromaticChordMidi.get(0).getPitch());
        assertEquals(PitchChromaticMidi.DD6, chromaticChordMidi.get(1).getPitch());
        assertEquals(PitchChromaticMidi.FF6, chromaticChordMidi.get(2).getPitch());
        assertEquals(PitchChromaticMidi.A6, chromaticChordMidi.get(3).getPitch());
        assertEquals(PitchChromaticMidi.CC7, chromaticChordMidi.get(4).getPitch());
	}

	@Test
    public void setOctave() throws PitchMidiException {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.B9).build();
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
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        ChromaticChordMidi chromaticChordMidi2 = chromaticChordMidi.clone();
        chromaticChordMidi2.shiftOctave(1);

        assertEquals(26, chromaticChordMidi.dist(chromaticChordMidi2));
	}

	@Test
    public void dist2() throws PitchMidiException {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        ChromaticChordMidi chromaticChordMidi2 = chromaticChordMidi.clone();
        chromaticChordMidi2.shiftOctave(1);

        assertNotEquals(0, chromaticChordMidi.dist(chromaticChordMidi2));
    }

    @Test
    public void dist3() throws PitchMidiException {
        ChromaticChordMidi ccm = ChromaticChordMidi.builder().fromChromaticMidi(
                ChromaticMidi.builder().pitch(67).build(),
                ChromaticMidi.builder().pitch(69).build(),
                ChromaticMidi.builder().pitch(74).build()
        ).build();
        ChromaticChordMidi ccm2 = ChromaticChordMidi.builder().fromChromaticMidi(
                ChromaticMidi.builder().pitch(4).build(),
                ChromaticMidi.builder().pitch(69).build(),
                ChromaticMidi.builder().pitch(74).build()
        ).build();

        assertEquals(ccm2.dist(ccm), ccm.dist(ccm2));
        assertEquals(63, ccm.dist(ccm2));
        assertTrue(ccm.dist(ccm2) > 2);
    }

    @SuppressWarnings("CollectionAddedToSelf")
    @Test
    public void distItself() throws PitchMidiException {
        ChromaticChordMidi ccm = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        assertEquals(0.0f, ccm.dist(ccm), 0);
    }

    @Test
    public void distSameBidirectional() throws PitchMidiException {
        ChromaticChordMidi ccm = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        ChromaticChordMidi ccm2 = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.D).build();
        assertEquals(ccm2.dist(ccm), ccm.dist(ccm2), 0);
        assertNotEquals(0, ccm.dist(ccm2));
    }

    @Test
    public void setMinOctave() throws PitchMidiException {
        ChromaticChordMidi ccm = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C5).build();
        assertEquals(5, ccm.getOctave());
        ccm.setMinOctave();
        Assert.assertEquals(PitchChromaticMidi.MIN_OCTAVE, ccm.getOctave());
	}

	@Test
    public void noteSorting() throws PitchMidiException {
        ChromaticChordMidi notes = ChromaticChordMidi.builder().fromChromaticMidi(
				ChromaticMidi.builder().pitch(Chromatic.A).build(),
				ChromaticMidi.builder().pitch(Chromatic.E).build(),
				ChromaticMidi.builder().pitch(Chromatic.F).build(),
				ChromaticMidi.builder().pitch(Chromatic.B, 6).build(),
				ChromaticMidi.builder().pitch(Chromatic.C, 4).build(),
				ChromaticMidi.builder().pitch(Chromatic.G).build()
        ).build();

        int code = notes.get(0).getPitch().getMidiCode();
		for ( int i = 1; i < notes.size(); i++ ) {
            int code_i = notes.get(i).getPitch().getMidiCode();
			assertTrue ( code_i >= code );
			code = code_i;
		}
	}

	@Test
	public void whatIsIt3() {
        ChromaticChordMidi cu = ChromaticChordMidi.builder().fromChromaticMidi(
				ChromaticMidi.builder().pitch(Chromatic.C).build(),
				ChromaticMidi.builder().pitch(Chromatic.E).build(),
				ChromaticMidi.builder().pitch(Chromatic.G).build()
        ).build();
		// assertEquals("", cu.toChordFunc(false).getAllFrom(0).str);
	}

	@Test
    public void shiftOctave() throws PitchMidiException {
        ChromaticChordMidi ccm = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C5).build();
		Assert.assertEquals(5, ccm.getOctave());
		ccm.shiftOctave(-1);
		Assert.assertEquals(4, ccm.getOctave());
		ccm.setMinOctave();
		Assert.assertEquals(PitchChromaticMidi.MIN_OCTAVE, ccm.getOctave());
		ccm.shiftOctave(1);
		Assert.assertEquals(1, ccm.getOctave());
	}

	@Test
    public void getEvents() {
        fail();
    }

    @Test
    public void getLength() {
        fail();
    }

    @Test
    public void sizeSameAsChromaticChord() throws PitchMidiException {
        for (ChromaticChord chromaticChord : ChromaticChord.values()) {
            assertEquals(chromaticChord.size(), ChromaticChordMidi.builder().fromChromatic(chromaticChord).build().size());
        }
    }


    @Test
    public void sizeFromNew() {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().build();
        chromaticChordMidi.add(ChromaticMidi.builder().pitch(PitchChromaticMidi.C5).build());
        chromaticChordMidi.add(ChromaticMidi.builder().pitch(PitchChromaticMidi.E5).build());
        chromaticChordMidi.add(ChromaticMidi.builder().pitch(PitchChromaticMidi.G5).build());

        assertEquals(3, chromaticChordMidi.size());
    }

    @Test
    public void getArpegio() {
        fail();
    }

    @Test
    public void setArpegio() {
        fail();
    }

    @Test
    public void add() {
    }

    @Test
    public void setVelocity() {
    }

    @Test
    public void setLength() {
    }

    @Test
    public void shiftOctave1() {
    }

    @Test
    public void setOctave1() {
    }

    @Test
    public void getOctave() {
    }

    @Test
    public void sortByPitch() {
    }

    @Test
    public void equals() {
    }

    @Test
    public void cloneTest() {
    }

    @Test
    public void add1() {
    }

    @Test
    public void add2() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void setRootPos() {
    }

    @Test
    public void getRoot() {
    }

    @Test
    public void getRootPos() {
    }

    @Test
    public void hashCodeTest() {
    }

    @Test
    public void add3() {
    }

    @Test
    public void add4() {
    }

    @Test
    public void addAll1() {
    }

    @Test
    public void addAll2() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void containsPitch() throws PitchMidiException {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        ChromaticMidi chromaticMidi = ChromaticMidi.builder().pitch(60).build();
        assertTrue(chromaticChordMidi.containsPitch(chromaticMidi));
    }

    @Test
    public void containsPitchFalse() throws PitchMidiException {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        ChromaticMidi chromaticMidi = ChromaticMidi.builder().pitch(61).build();
        assertFalse(chromaticChordMidi.containsPitch(chromaticMidi));
    }

    @Test
    public void containsPitchAllChromaticChordMidi() throws PitchMidiException {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        ChromaticMidi chromaticMidi = ChromaticMidi.builder().pitch(60).build();
        ChromaticMidi chromaticMidi2 = ChromaticMidi.builder().pitch(64).build();
        ChromaticMidi chromaticMidi3 = ChromaticMidi.builder().pitch(67).build();
        ChromaticChordMidi chromaticChordMidi2 = ChromaticChordMidi.builder().fromChromaticMidi(
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
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        ChromaticMidi chromaticMidi = ChromaticMidi.builder().pitch(60).build();
        ChromaticMidi chromaticMidi2 = ChromaticMidi.builder().pitch(64).build();
        ChromaticMidi chromaticMidi3 = ChromaticMidi.builder().pitch(67).build();
        List<ChromaticMidi> chromaticChordMidi2 = Arrays.asList(
                chromaticMidi,
                chromaticMidi2,
                chromaticMidi3
        );
        assertTrue(chromaticChordMidi.containsPitchAll(chromaticChordMidi2));
    }

    @Test
    public void get() throws PitchMidiException {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromChromatic(ChromaticChord.C).build();
        ChromaticMidi chromaticMidi = ChromaticMidi.builder().pitch(60).build();
        ChromaticMidi chromaticMidi2 = ChromaticMidi.builder().pitch(64).build();
        ChromaticMidi chromaticMidi3 = ChromaticMidi.builder().pitch(67).build();

        assertEquals(chromaticMidi, chromaticChordMidi.get(0));
        assertEquals(chromaticMidi2, chromaticChordMidi.get(1));
        assertEquals(chromaticMidi3, chromaticChordMidi.get(2));
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void iterator() {
    }

    @Test
    public void lastIndexOf() {
    }

    @Test
    public void listIterator() {
    }

    @Test
    public void listIterator1() {
    }

    @Test
    public void remove1() {
    }

    @Test
    public void remove2() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void set() {
    }

    @Test
    public void size() {
    }

    @Test
    public void subList() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void toArray1() {
    }

    @Test
    public void replaceAll() {
    }

    @Test
    public void sort() {
    }

    @Test
    public void spliterator() {
    }

    @Test
    public void removeIf() {
    }

    @Test
    public void spliterator1() {
    }

    @Test
    public void stream() {
    }

    @Test
    public void parallelStream() {
    }

    @Test
    public void forEach() {
    }

    @Test
    public void spliterator2() {
    }

    @Test
    public void getAllInversions() {
    }

    @Test
    public void resetRoot() {
    }

    @Test
    public void over() {
    }

    @Test
    public void inv() {
    }

    @Test
    public void inv1() {
    }

    @Test
    public void getInversionNumber() {
    }

    @Test
    public void from() {
    }

    @Test
    public void builder() {
    }

    @Test
    public void from1() {
    }

    @Test
    public void from2() {
    }

    @Test
    public void from3() {
    }

    @Test
    public void from4() {
    }

    @Test
    public void fromDiatonicChordMidi() {
    }

    @Test
    public void addAll3() {
    }

    @Test
    public void add5() {
    }

    @Test
    public void add6() {
    }

    @Test
    public void compact() {
    }

    @Test
    public void getQuality() {
    }

    @Test
    public void shift() {
    }

    @Test
    public void shiftNegative() {
    }

    @Test
    public void clone1() {
	}
}
