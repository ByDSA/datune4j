package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import diatonic.DiatonicFunction;
import diatonic.Tonality;
import pitch.DiatonicChordMidi;

public class DiatonicFunctionTest {
	@Test
	public void get() {
		checkTonality( Tonality.C );
		checkTonality( Tonality.D );
		checkTonality( Tonality.Cm );
		checkTonality( Tonality.Dm );
	}

	public void checkTonality(Tonality ton) {
		DiatonicChordMidi diatonicChordMidi = null;
		for ( DiatonicFunction df : DiatonicFunction.ALL ) {
			diatonicChordMidi = ton.get( df ).toDiatonicChordMidi( ton );
			assertEquals( df, DiatonicFunction.get( diatonicChordMidi ) );
		}
	}
	
	@Test
	public void getDregreeNotNull() {
		for (DiatonicFunction df : DiatonicFunction.values()) {
			assertNotNull( df.getDegree() );
		}
	}
}
