package es.danisales.datune;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionTest {
	@SuppressWarnings("ConstantConditions")
	@Test
	public void degree() {
		Tonality<Chromatic> tonality = Tonality.ET12.C;

		ChromaticChord chromaticChord = (ChromaticChord)tonality.getChord(ChromaticDegreeFunction.I);
		assertEquals( DiatonicDegree.I, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = (ChromaticChord)tonality.getChord(ChromaticDegreeFunction.ii);
		assertEquals( DiatonicDegree.II, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = (ChromaticChord)tonality.getChord(ChromaticDegreeFunction.iii);
		assertEquals( DiatonicDegree.III, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = (ChromaticChord)tonality.getChord(ChromaticDegreeFunction.IV);
		assertEquals( DiatonicDegree.IV, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = (ChromaticChord)tonality.getChord(ChromaticDegreeFunction.V);
		assertEquals( DiatonicDegree.V, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = (ChromaticChord)tonality.getChord(ChromaticDegreeFunction.vi);
		assertEquals( DiatonicDegree.VI, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = (ChromaticChord)tonality.getChord(ChromaticDegreeFunction.VII0);
		assertEquals( DiatonicDegree.VII, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
	}

	@Test
	public void _toStringNotNull() {
		for (ChromaticDegreeFunction cf : SecondaryDominant.values()) {
			assertNotNull( cf.toString() );
		}
	}
}
