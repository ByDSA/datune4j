package es.danisales.datune;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.PitchOctaveMidi;
import es.danisales.datune.musical.ChromaticChordEnum;
import org.junit.Test;

import es.danisales.datune.midi.ChromaticChordMidi;

public class ChordMidiTest {
	@Test
	public void setMinOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.of(ChromaticChordEnum.C5);
		assertEquals(5, ccm.getOctave());
		ccm.setMinOctave();
		assertEquals(PitchOctaveMidi.MIN_OCTAVE, ccm.getOctave());
	}
	
	@Test
	public void setOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.of(ChromaticChordEnum.C5);
		assertEquals(5, ccm.getOctave());
		ccm.setOctave(4);
		assertEquals(4, ccm.getOctave());
	}
	
	@Test
	public void shiftOctave() {
		ChromaticChordMidi ccm = ChromaticChordMidi.of(ChromaticChordEnum.C5);
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
		ChromaticChordMidi ccm = ChromaticChordMidi.of(ChromaticChordEnum.C);
		ChromaticChordMidi ccm2 = ChromaticChordMidi.of(ChromaticChordEnum.D);
		assertEquals(0.0f, ccm.dist(ccm), 0);
		assertEquals(ccm2.dist(ccm), ccm.dist(ccm2), 0);
		assertNotEquals(0, ccm.dist(ccm2));
		assertEquals(26, ccm.dist(ccm.clone().shiftOctave(1)));
		assertNotEquals(0, ccm.dist(ccm.clone().shiftOctave(1)));
	}
	
	@Test
	public void dist2() {
		ChromaticChordMidi ccm = ChromaticChordMidi.of(ChromaticMidi.of(67), ChromaticMidi.of(69), ChromaticMidi.of(74));
		ChromaticChordMidi ccm2 = ChromaticChordMidi.of(ChromaticMidi.of(4), ChromaticMidi.of(69), ChromaticMidi.of(74));
		assertEquals(ccm2.dist(ccm), ccm.dist(ccm2));
		assertEquals(63, ccm.dist(ccm2));
		assertEquals(true, ccm.dist(ccm2) > 2);
	}
	/*
	@Test
	public void equals() {
		ChordMidi cm = ChromaticChordEnum.C.toMidi();
		ChordMidi cm2 = (ChordMidi) cm.duplicate();
		
		assertNotEquals(null, cm.getArpegio());
		assertNotEquals(null, cm2.getArpegio());
		assertEquals(cm.getArpegio(), cm2.getArpegio());
		assertEquals(cm.getLength(), cm2.getLength());
		
		cm = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C );
		cm2 = (ChordMidi) cm.duplicate();
		
		assertNotEquals(null, cm.getArpegio());
		assertNotEquals(null, cm2.getArpegio());
		assertEquals(cm.getArpegio(), cm2.getArpegio());
		assertEquals(cm.getLength(), cm2.getLength());
	}*/
}
