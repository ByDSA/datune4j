package es.danisales.datune;

import es.danisales.datune.chords.ChordProgression;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {

	@Test
	public void chordFunction() {
		assertEquals(0, DiatonicDegree.from(DiatonicFunction.I).ordinal());
	}
}
