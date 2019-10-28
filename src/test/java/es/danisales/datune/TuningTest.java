package es.danisales.datune;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tuning.NoteTuning;
import es.danisales.datune.tuning.PythagoreanTemperament;
import es.danisales.datune.tuning.Temperament;
import es.danisales.datune.tuning.Tuning;
import org.junit.Test;

public class TuningTest {
	@Test
	public void test() {
		NoteTuning nb = new NoteTuning(Chromatic.A, 4);
		double f = 432;
		Temperament t = new PythagoreanTemperament();
		Tuning tu = new Tuning(t, nb, f);
		tu.showNotes();
	}
}
