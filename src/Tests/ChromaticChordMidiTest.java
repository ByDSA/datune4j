package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chromaticchord.ChromaticChordEnum;
import pitch.Chromatic;
import pitch.ChromaticChordMidi;
import pitch.PitchMidi;

public class ChromaticChordMidiTest {
	@Test
	public void chromaticChordToMidi() {
		ChromaticChordMidi ccm = new ChromaticChordMidi(ChromaticChordEnum.F5);
		assertEquals(PitchMidi.F5, ccm.get(0).getPitchCode());
		assertEquals(PitchMidi.C6, ccm.get(1).getPitchCode());
		assertEquals(0, ccm.getRootPos());
		assertEquals(Chromatic.F, ccm.get(0).getChromatic());
		assertEquals(Chromatic.C, ccm.get(1).getChromatic());
	}
	
	@Test
	public void names() {
		assertEquals("C", ChromaticChordEnum.C.toString());
		
		ChromaticChordMidi ccm = new ChromaticChordMidi(Chromatic.C, Chromatic.E, Chromatic.G);
		
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
