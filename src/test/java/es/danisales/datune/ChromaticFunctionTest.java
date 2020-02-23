package es.danisales.datune;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionTest {
	@Test
	public void degree() throws ScaleRelativeDegreeException {
		Tonality<Chromatic> tonality = Tonality.C;

		ChromaticChord chromaticChord = ChromaticDegreeFunction.I.getChromaticChordFromTonality(tonality);
		assertEquals( DiatonicDegree.I, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.ii.getChromaticChordFromTonality(tonality);
		assertEquals( DiatonicDegree.II, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.iii.getChromaticChordFromTonality(tonality);
		assertEquals( DiatonicDegree.III, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.IV.getChromaticChordFromTonality(tonality);
		assertEquals( DiatonicDegree.IV, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.V.getChromaticChordFromTonality(tonality);
		assertEquals( DiatonicDegree.V, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.vi.getChromaticChordFromTonality(tonality);
		assertEquals( DiatonicDegree.VI, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );

		chromaticChord = ChromaticDegreeFunction.VII0.getChromaticChordFromTonality(tonality);
		assertEquals( DiatonicDegree.VII, tonality.getDegreeFrom( chromaticChord.get( 0 ) ) );
	}

	@Test
	public void _toStringNotNull() {
		for (ChromaticDegreeFunction cf : SecondaryDominant.values()) {
			assertNotNull( cf.toString() );
		}
	}
}
