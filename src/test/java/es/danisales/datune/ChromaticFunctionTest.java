package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionTest {
	@Test
	public void degree() throws TonalityException {
		Tonality tonality = Tonality.C;
		ChromaticChord chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.chromaticFunction(ChromaticFunction.I)
				.build();
		assertEquals( DiatonicDegree.I, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.chromaticFunction(ChromaticFunction.II)
				.build();
		assertEquals( DiatonicDegree.II, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.chromaticFunction(ChromaticFunction.III)
				.build();
		assertEquals( DiatonicDegree.III, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.chromaticFunction(ChromaticFunction.IV)
				.build();
		assertEquals( DiatonicDegree.IV, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.chromaticFunction(ChromaticFunction.V)
				.build();
		assertEquals( DiatonicDegree.V, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.chromaticFunction(ChromaticFunction.VI)
				.build();
		assertEquals( DiatonicDegree.VI, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.chromaticFunction(ChromaticFunction.VII)
				.build();
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
