package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.ChromaticChordInterface;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TonalityEnumTest {

	@Test
	public void getDiatonicFunction() {
		Tonality t = Tonality.C;
		for (DiatonicFunction df : DiatonicFunction.values()) {
			assertNotNull( ChromaticChord.from( t, df ) );
		}
	}
	
	@Test
	public void getChromaticFunction() {
		Tonality t = Tonality.C;
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( ChromaticChord.from( t, cf ) );
		}
	}
}
