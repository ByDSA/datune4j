package es.danisales.datune;

import es.danisales.datune.function.DiatonicFunction;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DiatonicFunctionTest {
	@Test
	public void getDegreeNotNull() {
		for (DiatonicFunction df : DiatonicFunction.immutableValues()) {
            assertNotNull(df.toString(), df.getDiatonicDegree());
		}
	}
}
