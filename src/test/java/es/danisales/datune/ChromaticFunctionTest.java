package es.danisales.datune;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.tonality.TonalityModern;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionTest {
	@SuppressWarnings("ConstantConditions")
	@Test
	public void degree() {
		TonalityModern tonality = TonalityModern.C;

		ChromaticChord chromaticChord = tonality.getChord(ChromaticDegreeFunction.I);
		assertEquals( DiatonicDegree.I, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.ii.getChord(tonality);
		assertEquals( DiatonicDegree.II, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.iii.getChord(tonality);
		assertEquals( DiatonicDegree.III, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.IV.getChord(tonality);
		assertEquals( DiatonicDegree.IV, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.V.getChord(tonality);
		assertEquals( DiatonicDegree.V, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.vi.getChord(tonality);
		assertEquals( DiatonicDegree.VI, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.VII0.getChord(tonality);
		assertEquals( DiatonicDegree.VII, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
	}

	@Test
	public void _toStringNotNull() {
		for (ChromaticDegreeFunction cf : SecondaryDominant.values()) {
			assertNotNull( cf.toString() );
		}
	}
}
