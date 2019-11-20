package es.danisales.datune;

import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.PitchChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
