package es.danisales.datune;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionTest {
	@Test
	public void degree() throws BuildingException {
		Tonality<Chromatic> tonality = Tonality.ET12.C;
		ChromaticChord chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.function(ChromaticDegreeFunction.I)
				.build();
		assertEquals( DiatonicDegree.I, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.function(ChromaticDegreeFunction.II)
				.build();
		assertEquals( DiatonicDegree.II, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.function(ChromaticDegreeFunction.III)
				.build();
		assertEquals( DiatonicDegree.III, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.function(ChromaticDegreeFunction.IV)
				.build();
		assertEquals( DiatonicDegree.IV, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.function(ChromaticDegreeFunction.V)
				.build();
		assertEquals( DiatonicDegree.V, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.function(ChromaticDegreeFunction.VI)
				.build();
		assertEquals( DiatonicDegree.VI, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
		chromaticChord = ChromaticChord.builder()
				.tonality(tonality)
				.function(ChromaticDegreeFunction.VII)
				.build();
		assertEquals( DiatonicDegree.VII, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
	}

	@Test
	public void _toStringNotNull() {
		for (SecondaryDominant cf : SecondaryDominant.values()) {
			assertNotNull( cf.toString() );
		}
	}

	@Test
	public void getDregreeNotNull() {
		for (SecondaryDominant cf : SecondaryDominant.values()) {
			assertNotNull( DiatonicDegree.from(cf) );
		}
	}
}
