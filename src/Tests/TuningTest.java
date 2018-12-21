package Tests;

import org.junit.Test;

import musical.Chromatic;
import tuning.NoteTuning;
import tuning.PythagoreanTemperament;
import tuning.Temperament;
import tuning.Tuning;

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
