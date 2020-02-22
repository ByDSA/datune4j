package es.danisales.datune;

import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

	@Test
	public void chordFunction() {
		assertEquals(0, DiatonicFunction.I.getDiatonicDegree().ordinal());
	}
}
