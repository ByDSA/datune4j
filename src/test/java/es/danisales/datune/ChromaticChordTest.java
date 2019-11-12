package es.danisales.datune;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.ChromaticChordEnum;
import es.danisales.datune.musical.CustomChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ChromaticChordTest {
	@Test
	public void _clone() {
		CustomChromaticChord ca = CustomChromaticChord.from( Chromatic.C, Chromatic.E, Chromatic.G );
		CustomChromaticChord ca2 = ca.duplicate();

		assertEquals( ca, ca2 );
	}

	@Test
	public void inv() {
		CustomChromaticChord c = CustomChromaticChord.from( ChromaticChordEnum.C );
		c.inv();
		assertEquals( Chromatic.E, c.get( 0 ) );
		assertEquals( Chromatic.G, c.get( 1 ) );
		assertEquals( Chromatic.C, c.get( 2 ) );
		assertEquals( Chromatic.C, c.getRoot() );
		assertEquals( 2, c.getRootPos() );
	}

	@Test
	public void getRoot() {
		assertEquals( Chromatic.C, ChromaticChordEnum.C.getRoot() );
		CustomChromaticChord c = CustomChromaticChord.from( ChromaticChordEnum.C );
		c.inv();
		assertEquals( 2, c.getRootPos() );
		assertEquals( Chromatic.C, c.getRoot() );
		c = CustomChromaticChord.from( ChromaticChordEnum.F5 );
		c.inv();
		assertEquals( 1, c.getRootPos() );
		assertEquals( Chromatic.F, c.getRoot() );
	}

	@Test
	public void names() {
		assertEquals( "C", ChromaticChordEnum.C.toString() );

		CustomChromaticChord cc = CustomChromaticChord.from( Chromatic.C, Chromatic.E, Chromatic.G );

		assertEquals( "C", cc.toString() );

		assertEquals( "Cm", ChromaticChordEnum.Cm.toString() );
		assertEquals( "C7", ChromaticChordEnum.C7.toString() );
		DiatonicChordMidi ccm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.C );
		cc.inv();
		assertEquals(
			"C/E (C)", ccm.toString()
		);
		cc = CustomChromaticChord.from(ChromaticChordEnum.C);
		cc.inv();
		assertEquals( "C/E", cc.toString() );
		cc = CustomChromaticChord.from(ChromaticChordEnum.C);
		cc.inv(2);
		assertEquals( "C/G", cc.toString() );
		cc = CustomChromaticChord.from(ChromaticChordEnum.C);
		cc.inv(3);
		assertEquals( "C", cc.toString() );
		assertEquals( "F5", ChromaticChordEnum.F5.toString() );
		cc = CustomChromaticChord.from(ChromaticChordEnum.F5);
		cc.inv();
		assertEquals( "F5/C", cc.toString() );

		assertEquals( "Csus2", ChromaticChordEnum.Csus2.toString() );
		cc = CustomChromaticChord.from(ChromaticChordEnum.Csus2);
		cc.inv();
		assertEquals( "Csus2/D", cc.toString() );
		assertEquals( "Gsus4", ChromaticChordEnum.Gsus4.toString() );
		cc = CustomChromaticChord.from(ChromaticChordEnum.Gsus4);
		cc.inv();
		assertEquals( "Gsus4/C", cc.toString() );
	}
/*
	@Test
	public void mean() {
		assertEquals( Chromatic.E.intValue(), Math.round( ChromaticChordEnum.C.getPitchMean() ) );
	}

	@Test
	public void dist() {
		ChromaticChordEnum cc = ChromaticChordEnum.C;
		assertEquals( 4, Math.round( Chromatic.C.dist( ChromaticChordEnum.C ) ) );
		assertEquals( 0, Math.round( Chromatic.E.dist( ChromaticChordEnum.C ) ) );
	}*/
}
