package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pitch.Chromatic;
import pitch.ChromaticChord;
import pitch.ChromaticChordMidi;
import pitch.Pitch;

public class ChromaticChordMidiTest {
	@Test
	public void chromaticChordToMidi() {
		ChromaticChordMidi ccm = new ChromaticChordMidi(ChromaticChord.F5);
		assertEquals(Pitch.F5, ccm.get(0).getPitchCode());
		assertEquals(Pitch.C6, ccm.get(1).getPitchCode());
		assertEquals(0, ccm.getRootPos());
		assertEquals(Chromatic.F, ccm.get(0).getChromatic());
		assertEquals(Chromatic.C, ccm.get(1).getChromatic());
	}
	
	@Test
	public void names() {
		assertEquals("C", ChromaticChord.C.toString());
		
		ChromaticChordMidi ccm = new ChromaticChordMidi(Chromatic.C, Chromatic.E, Chromatic.G);
		
		assertEquals("C", ccm.toString());
		
		assertEquals("Cm", ChromaticChord.Cm.toString());
		assertEquals("C7", ChromaticChord.C7.toString());
		assertEquals("C/E", ChromaticChord.C.duplicate().inv().toString());
		assertEquals("C/G", ChromaticChord.C.duplicate().inv(2).toString());
		assertEquals("C", ChromaticChord.C.duplicate().inv(3).toString());
		assertEquals("F5", ChromaticChord.F5.duplicate().toString());
		assertEquals("F5/C", ChromaticChord.F5.duplicate().inv().toString());
		
		assertEquals("Csus2", ChromaticChord.Csus2.toString());
		assertEquals("Gsus4", ChromaticChord.Gsus4.toString());
		assertEquals("Gsus4/C", ChromaticChord.Gsus4.duplicate().inv().toString());
	}
}
