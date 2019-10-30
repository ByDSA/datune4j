package es.danisales.datune;

import es.danisales.datune.diatonic.DiatonicFunction;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DiatonicFunctionTest {
	/*@Test
	public void calculateFrom() {
		checkTonality( TonalityEnum.C );
		checkTonality( TonalityEnum.D );
		checkTonality( TonalityEnum.Cm );
		checkTonality( TonalityEnum.Dm );
	}

	public void checkTonality(Tonality ton) {
		DiatonicChordMidi diatonicChordMidi = null;
		for ( DiatonicFunction df : DiatonicFunction.COMMON ) {
			diatonicChordMidi = ton.calculateFrom( df ).toDiatonicChordMidi( ton );
			assertEquals( df, DiatonicFunction.calculateFrom( diatonicChordMidi ) );
		}
	}
	*/
	@Test
	public void getDregreeNotNull() {
		for (DiatonicFunction df : DiatonicFunction.values()) {
			assertNotNull( df.toString(), df.getDegree() );
		}
	}
}
