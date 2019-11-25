package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionTest {
	@Test
	public void degree() {
		Tonality tonality = Tonality.C;
		ChromaticChord chromaticChord = ChromaticChord.from( tonality, ChromaticFunction.I );
		assertEquals( DiatonicDegree.I, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.from( tonality, ChromaticFunction.II );
		assertEquals( DiatonicDegree.II, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.from( tonality, ChromaticFunction.III );
		assertEquals( DiatonicDegree.III, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.from( tonality, ChromaticFunction.IV );
		assertEquals( DiatonicDegree.IV, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.from( tonality, ChromaticFunction.V );
		assertEquals( DiatonicDegree.V, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.from( tonality, ChromaticFunction.VI );
		assertEquals( DiatonicDegree.VI, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.from( tonality, ChromaticFunction.VII );
		assertEquals( DiatonicDegree.VII, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
	}
	
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
