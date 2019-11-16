package es.danisales.datune;

import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.PitchOctaveMidi;
import es.danisales.datune.musical.ChromaticChord;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ChordMidiTest {
	@Test
	public void setMinOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.C5);
		assertEquals(5, ccm.getOctave());
		ccm.setMinOctave();
		assertEquals(PitchOctaveMidi.MIN_OCTAVE, ccm.getOctave());
	}
	
	@Test
	public void setOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.C5);
		assertEquals(5, ccm.getOctave());
		ccm.setOctave(4);
		assertEquals(4, ccm.getOctave());
	}
	
	@Test
	public void shiftOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.C5);
		assertEquals(5, ccm.getOctave());
		ccm.shiftOctave(-1);
		assertEquals(4, ccm.getOctave());
		ccm.setMinOctave();
		assertEquals(PitchOctaveMidi.MIN_OCTAVE, ccm.getOctave());
		ccm.shiftOctave(1);
		assertEquals(1, ccm.getOctave());
	}
	
	@Test
	public void dist() {
		ChromaticChordMidi ccm = ChromaticChordMidi.from(ChromaticChord.C);
		ChromaticChordMidi ccm2 = ChromaticChordMidi.from(ChromaticChord.D);
		assertEquals(0.0f, ccm.dist(ccm), 0);
		assertEquals(ccm2.dist(ccm), ccm.dist(ccm2), 0);
		assertNotEquals(0, ccm.dist(ccm2));

		ChromaticChordMidi ccmTmp = ccm.clone();
		ccmTmp.shiftOctave(1);
		assertEquals(26, ccm.dist(ccmTmp));

		ccmTmp = ccm.clone();
		ccmTmp.shiftOctave(1);
		assertNotEquals(0, ccm.dist(ccmTmp));
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
		assertEquals(ccm2.dist(ccm), ccm.dist(ccm2));
		assertEquals(63, ccm.dist(ccm2));
		assertEquals(true, ccm.dist(ccm2) > 2);
	}
	/*
	@Test
	public void equals() {
		ChordMidi cm = ChromaticChord.C.toMidi();
		ChordMidi cm2 = (ChordMidi) cm.duplicate();
		
		assertNotEquals(null, cm.getArpegio());
		assertNotEquals(null, cm2.getArpegio());
		assertEquals(cm.getArpegio(), cm2.getArpegio());
		assertEquals(cm.getLength(), cm2.getLength());
		
		cm = new DiatonicChordMidi( TonalityEnum.C, ChromaticChord.C );
		cm2 = (ChordMidi) cm.duplicate();
		
		assertNotEquals(null, cm.getArpegio());
		assertNotEquals(null, cm2.getArpegio());
		assertEquals(cm.getArpegio(), cm2.getArpegio());
		assertEquals(cm.getLength(), cm2.getLength());
	}*/
}
