package es.danisales.datune;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChordEnum;
import es.danisales.datune.musical.CustomChromaticChord;
import es.danisales.datune.tonality.TonalityEnum;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ChromaticChordTest {
	@Test
	public void _clone() {
		CustomChromaticChord ca = CustomChromaticChord.copyOf( Chromatic.C, Chromatic.E, Chromatic.G );
		CustomChromaticChord ca2 = ca.clone();

		assertEquals( ca, ca2 );
	}

	@Test
	public void inv() {
		CustomChromaticChord c = CustomChromaticChord.copyOf( ChromaticChordEnum.C );
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
		CustomChromaticChord c = CustomChromaticChord.copyOf( ChromaticChordEnum.C );
		c.inv();
		assertEquals( 2, c.getRootPos() );
		assertEquals( Chromatic.C, c.getRoot() );
		c = ChromaticChordEnum.F5.inv();
		assertEquals( 1, c.getRootPos() );
		assertEquals( Chromatic.F, c.getRoot() );
	}

	@Test
	public void names() {
		assertEquals( "C", ChromaticChordEnum.C.toString() );

		CustomChromaticChord cc = CustomChromaticChord.copyOf( Chromatic.C, Chromatic.E, Chromatic.G );

		assertEquals( "C", cc.toString() );

		assertEquals( "Cm", ChromaticChordEnum.Cm.toString() );
		assertEquals( "C7", ChromaticChordEnum.C7.toString() );
		assertEquals(
			"C/E (C)", new DiatonicChordMidi( DiatonicFunction.I, TonalityEnum.C ).inv().toString()
		);
		assertEquals( "C/E", ChromaticChordEnum.C.inv().toString() );
		assertEquals( "C/G", ChromaticChordEnum.C.inv( 2 ).toString() );
		assertEquals( "C", ChromaticChordEnum.C.inv( 3 ).toString() );
		assertEquals( "F5", ChromaticChordEnum.F5.toString() );
		assertEquals( "F5/C", ChromaticChordEnum.F5.inv().toString() );

		assertEquals( "Csus2", ChromaticChordEnum.Csus2.toString() );
		assertEquals( "Csus2/D", ChromaticChordEnum.Csus2.inv().toString() );
		assertEquals( "Gsus4", ChromaticChordEnum.Gsus4.toString() );
		assertEquals( "Gsus4/C", ChromaticChordEnum.Gsus4.inv().toString() );
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
