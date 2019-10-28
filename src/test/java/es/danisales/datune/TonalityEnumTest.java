package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityEnum;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
