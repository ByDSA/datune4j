package Tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import diatonic.ChromaticFunction;
import diatonic.DiatonicFunction;
import tonality.Tonality;
import tonality.TonalityEnum;

public class TonalityEnumTest {

	@Test
	public void getDiatonicFunction() {
		Tonality t = TonalityEnum.C;
		for (DiatonicFunction df : DiatonicFunction.values()) {
			assertNotNull( t.get( df ) );
		}
	}
	
	@Test
	public void getChromaticFunction() {
		Tonality t = TonalityEnum.C;
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( t.get( cf ) );
		}
	}
}
