package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import diatonic.DiatonicFunction;
import pitch.DiatonicChordMidi;
import tonality.Tonality;
import tonality.TonalityEnum;

public class DiatonicFunctionTest {
	/*@Test
	public void get() {
		checkTonality( TonalityEnum.C );
		checkTonality( TonalityEnum.D );
		checkTonality( TonalityEnum.Cm );
		checkTonality( TonalityEnum.Dm );
	}

	public void checkTonality(Tonality ton) {
		DiatonicChordMidi diatonicChordMidi = null;
		for ( DiatonicFunction df : DiatonicFunction.COMMON ) {
			diatonicChordMidi = ton.get( df ).toDiatonicChordMidi( ton );
			assertEquals( df, DiatonicFunction.get( diatonicChordMidi ) );
		}
	}
	*/
	@Test
	public void getDregreeNotNull() {
		for (DiatonicFunction df : DiatonicFunction.values()) {
			assertNotNull( df.getDegree() );
		}
	}
}
