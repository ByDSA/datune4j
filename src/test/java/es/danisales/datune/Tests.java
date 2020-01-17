package es.danisales.datune;

import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.*;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {

	@Test
	public void chordFunction() {
		assertEquals(0, DiatonicDegree.from(DiatonicFunction.I).ordinal());
	}

	@Test(timeout = 1000)
	public void whatIsItStatic() throws BuildingException {
		Tonality s = Tonality.C;
		DiatonicChordMidi c = DiatonicChordMidi.builder()
				.from(DiatonicFunction.I, s)
				.octave(5)
				.build();

		ChromaticChord notes = ChromaticChord.builder().build();
		for ( DiatonicMidi n : c ) {
			ChromaticMidi chromaticMidi = ChromaticMidi.from(n);
			notes.add(chromaticMidi.getPitch().getChromatic());
		}

		List<DiatonicChordMidiInfo> chords = DiatonicChordMidiBuilder.fromChromaticChord(
				notes,
				false
		);
		assert ( chords.size() > 0 );
	}
}
