package es.danisales.datune;

import es.danisales.datune.function.DiatonicFunction;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DiatonicFunctionTest {
	/*@Test
	public void getAllFrom() {
		checkTonality( TonalityEnum.C );
		checkTonality( TonalityEnum.D );
		checkTonality( TonalityEnum.Cm );
		checkTonality( TonalityEnum.Dm );
	}

	public void checkTonality(Tonality ton) {
		DiatonicChordMidi diatonicChordMidi = null;
		for ( DiatonicFunction df : DiatonicFunction.ALL ) {
			diatonicChordMidi = ton.getAllFrom( df ).toDiatonicChordMidi( ton );
			assertEquals( df, DiatonicFunction.getAllFrom( diatonicChordMidi ) );
		}
	}
	*/
	@Test
	public void getDegreeNotNull() {
		for (DiatonicFunction df : DiatonicFunction.immutableValues()) {
            assertNotNull(df.toString(), df.getDiatonicDegree());
		}
	}
}
