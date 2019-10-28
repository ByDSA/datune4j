package es.danisales.datune;

import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChordEnum;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChromaticChordMidiTest {
	@Test
	public void chromaticChordToMidi() {
		ChromaticChordMidi ccm = ChromaticChordMidi.of(ChromaticChordEnum.F5);
		assertTrue(PitchMidi.F5.equals( ccm.get(0) ));
		assertTrue(PitchMidi.C6.equals( ccm.get(1) ));
		assertEquals(0, ccm.getRootPos());
		assertEquals(Chromatic.F, ccm.get(0).getChromatic());
		assertEquals(Chromatic.C, ccm.get(1).getChromatic());
	}
	
	@Test
	public void names() {
		assertEquals("C", ChromaticChordEnum.C.toString());
		
		ChromaticChordMidi ccm = ChromaticChordMidi.of(Chromatic.C, Chromatic.E, Chromatic.G);
		
		assertEquals("C", ccm.toString());
		
		assertEquals("Cm", ChromaticChordEnum.Cm.toString());
		assertEquals("C7", ChromaticChordEnum.C7.toString());
		assertEquals("C/E", ChromaticChordEnum.C.inv().toString());
		assertEquals("C/G", ChromaticChordEnum.C.inv(2).toString());
		assertEquals("C", ChromaticChordEnum.C.inv(3).toString());
		assertEquals("F5", ChromaticChordEnum.F5.toString());
		assertEquals("F5/C", ChromaticChordEnum.F5.inv().toString());
		
		assertEquals("Csus2", ChromaticChordEnum.Csus2.toString());
		assertEquals("Gsus4", ChromaticChordEnum.Gsus4.toString());
		assertEquals("Gsus4/C", ChromaticChordEnum.Gsus4.inv().toString());
	}
}
