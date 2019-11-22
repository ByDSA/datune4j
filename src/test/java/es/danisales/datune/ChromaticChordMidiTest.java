package es.danisales.datune;

import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.PitchChromaticMidi;
import es.danisales.datune.midi.PitchOctaveMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ChromaticChordMidiTest {
	@Test
	public void chromaticChordToMidi() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.F5);
		Assert.assertEquals(PitchChromaticMidi.F5, ccm.get(0).getPitch());
		Assert.assertEquals(PitchChromaticMidi.C6, ccm.get(1).getPitch());
		assertEquals(0, ccm.getRootPos());
		Chromatic chromaticCcm0 = Chromatic.from( ccm.get(0) );
		Chromatic chromaticCcm1 = Chromatic.from( ccm.get(1) );
		assertEquals(Chromatic.F, chromaticCcm0);
		assertEquals(Chromatic.C, chromaticCcm1);
	}

	@Test
	public void setOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.C5);
		Assert.assertEquals(5, ccm.getOctave());
		ccm.setOctave(4);
		Assert.assertEquals(4, ccm.getOctave());
	}

	@Test
	public void dist() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.C);
		ChromaticChordMidi ccm2 = ChromaticChordMidi.from(ChromaticChord.D);
		Assert.assertEquals(0.0f, ccm.dist(ccm), 0);
		Assert.assertEquals(ccm2.dist(ccm), ccm.dist(ccm2), 0);
		assertNotEquals(0, ccm.dist(ccm2));

		ChromaticChordMidi ccmTmp = ccm.clone();
		ccmTmp.shiftOctave(1);
		Assert.assertEquals(26, ccm.dist(ccmTmp));

		ccmTmp = ccm.clone();
		ccmTmp.shiftOctave(1);
		assertNotEquals(0, ccm.dist(ccmTmp));
	}

	@Test
	public void setMinOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.C5);
		Assert.assertEquals(5, ccm.getOctave());
		ccm.setMinOctave();
		Assert.assertEquals(PitchChromaticMidi.MIN_OCTAVE, ccm.getOctave());
	}

	@Test
	public void dist2() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(
				ChromaticMidi.builder().pitch(67).build(),
				ChromaticMidi.builder().pitch(69).build(),
				ChromaticMidi.builder().pitch(74).build()
		);
		ChromaticChordMidi ccm2 = ChromaticChordMidi.from(
				ChromaticMidi.builder().pitch(4).build(),
				ChromaticMidi.builder().pitch(69).build(),
				ChromaticMidi.builder().pitch(74).build()
		);
		Assert.assertEquals(ccm2.dist(ccm), ccm.dist(ccm2));
		Assert.assertEquals(63, ccm.dist(ccm2));
		Assert.assertEquals(true, ccm.dist(ccm2) > 2);
	}


	@Test
	public void noteSorting() {
		ChromaticChordMidi notes = ChromaticChordMidi.from(
				ChromaticMidi.builder().pitch(Chromatic.A).build(),
				ChromaticMidi.builder().pitch(Chromatic.E).build(),
				ChromaticMidi.builder().pitch(Chromatic.F).build(),
				ChromaticMidi.builder().pitch(Chromatic.B, 6).build(),
				ChromaticMidi.builder().pitch(Chromatic.C, 4).build(),
				ChromaticMidi.builder().pitch(Chromatic.G).build()
		);

		int code = notes.get( 0 ).getPitch().getCode();
		for ( int i = 1; i < notes.size(); i++ ) {
			int code_i = notes.get( i ).getPitch().getCode();
			assertTrue ( code_i >= code );
			code = code_i;
		}
	}

	@Test
	public void whatIsIt3() {
		ChromaticChordMidi cu = ChromaticChordMidi.from(
				ChromaticMidi.builder().pitch(Chromatic.C).build(),
				ChromaticMidi.builder().pitch(Chromatic.E).build(),
				ChromaticMidi.builder().pitch(Chromatic.G).build()
		);
		// assertEquals("", cu.toChordFunc(false).getAllFrom(0).str);
	}

	@Test
	public void shiftOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.C5);
		Assert.assertEquals(5, ccm.getOctave());
		ccm.shiftOctave(-1);
		Assert.assertEquals(4, ccm.getOctave());
		ccm.setMinOctave();
		Assert.assertEquals(PitchChromaticMidi.MIN_OCTAVE, ccm.getOctave());
		ccm.shiftOctave(1);
		Assert.assertEquals(1, ccm.getOctave());
	}
	
	@Test
	public void names() {
		assertEquals("C", ChromaticChord.C.toString());
		
		ChromaticChordMidi ccm = ChromaticChordMidi.of(Chromatic.C, Chromatic.E, Chromatic.G);
		
		assertEquals("C", ccm.toString());
		
		assertEquals("Cm", ChromaticChord.Cm.toString());
		assertEquals("C7", ChromaticChord.C7.toString());
		ChromaticChord c = ChromaticChord.from(ChromaticChord.C);
		c.inv();
		assertEquals("C/E", c.toString());
		c = ChromaticChord.from(ChromaticChord.C);
		c.inv(2);
		assertEquals("C/G", c.toString());
		c = ChromaticChord.from(ChromaticChord.C);
		c.inv(3);
		assertEquals("C", c.toString());
		assertEquals("F5", ChromaticChord.F5.toString());
		c = ChromaticChord.from(ChromaticChord.F5);
		c.inv();
		assertEquals("F5/C", c.toString());
		
		assertEquals("Csus2", ChromaticChord.Csus2.toString());
		assertEquals("Gsus4", ChromaticChord.Gsus4.toString());
		c = ChromaticChord.from(ChromaticChord.Gsus4);
		c.inv();
		assertEquals("Gsus4/C", c.toString());
	}
}
