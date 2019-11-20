package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChordInterface;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionTest {
	@Test
	public void degree() {
		Tonality ton = Tonality.C;
		ChromaticChordInterface cc = ChromaticChordInterface.from( ChromaticFunction.I, ton );
		assertEquals( DiatonicDegree.I, ton.getDegreeFrom( cc.get( 0 ) ) );
		cc = ChromaticChordInterface.from( ChromaticFunction.II, ton );
		assertEquals( DiatonicDegree.II, ton.getDegreeFrom( cc.get( 0 ) ) );
		cc = ChromaticChordInterface.from( ChromaticFunction.III, ton );
		assertEquals( DiatonicDegree.III, ton.getDegreeFrom( cc.get( 0 ) ) );
		cc = ChromaticChordInterface.from( ChromaticFunction.IV, ton );
		assertEquals( DiatonicDegree.IV, ton.getDegreeFrom( cc.get( 0 ) ) );
		cc = ChromaticChordInterface.from( ChromaticFunction.V, ton );
		assertEquals( DiatonicDegree.V, ton.getDegreeFrom( cc.get( 0 ) ) );
		cc = ChromaticChordInterface.from( ChromaticFunction.VI, ton );
		assertEquals( DiatonicDegree.VI, ton.getDegreeFrom( cc.get( 0 ) ) );
		cc = ChromaticChordInterface.from( ChromaticFunction.VII, ton );
		assertEquals( DiatonicDegree.VII, ton.getDegreeFrom( cc.get( 0 ) ) );

		cc = ChromaticChordInterface.from( ChromaticFunction.I, ton );
		ChromaticChordMidi ccm = cc.toMidi();
		DiatonicChordMidi dc = ccm
				.getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.I, dc.getDegree() );
		cc = ChromaticChordInterface.from( ChromaticFunction.ii, ton );
		dc = cc.toMidi().getDiatonicChordMidi( ton );
		Chromatic c = Chromatic.from( dc.getRoot() );
		RelativeDegree d = ton.getDegreeFrom( c );
		assertEquals( DiatonicDegree.II, d );
		assertEquals( DiatonicDegree.II, dc.getDegree() );
		cc = ChromaticChordInterface.from( ChromaticFunction.iii, ton );
		dc = cc.toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.III, dc.getDegree() );
		cc = ChromaticChordInterface.from( ChromaticFunction.IV, ton );
		dc = cc.toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.IV, dc.getDegree() );
		cc = ChromaticChordInterface.from( ChromaticFunction.V, ton );
		dc = cc.toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.V, dc.getDegree() );
		cc = ChromaticChordInterface.from( ChromaticFunction.vi, ton );
		dc = cc.toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.VI, dc.getDegree() );
		cc = ChromaticChordInterface.from( ChromaticFunction.VII0, ton );
		dc = cc.toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.VII, dc.getDegree() );
	}
/*
	@Test
	public void getAllFrom() {
		Tonality t = Tonality.C;
		ChromaticChordEnum cc = ChromaticChordEnum.F5;
		assertEquals( ChromaticFunction.IV5, ChromaticFunction.getAllFrom( cc, t ) );

		checkTonality( Tonality.C );
		checkTonality( Tonality.D );
		checkTonality( Tonality.Cm );
		checkTonality( Tonality.Dm );
	}

	public void checkTonality(Tonality ton) {
		DiatonicChordMidi diatonicChordMidi = null;
		for ( ChromaticFunction cf : ChromaticFunction.ALL ) {
			if ( cf == ChromaticFunction.V_IV || cf == ChromaticFunction.V7_IV )
				continue;
			diatonicChordMidi = ton.getAllFrom( cf ).toDiatonicChordMidi( ton );
			assertEquals( cf, ChromaticFunction.getAllFrom( diatonicChordMidi ) );
		}
	}*/
	
	@Test
	public void _toStringNotNull() {
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( cf.toString() );
		}
	}
	
	@Test
	public void getDregreeNotNull() {
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( cf.getDegree() );
		}
	}
}
