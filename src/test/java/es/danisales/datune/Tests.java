package es.danisales.datune;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicChordMidiBuilder;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.ChromaticChordPattern;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class Tests {
	@Test
	public void diatonicAltToDiatonic() {
		DiatonicAlt c = DiatonicAlt.Cb;
		assertSame( Diatonic.C, Diatonic.from( c ) );
		assertSame( Diatonic.C, c.getDiatonic() );
	}

	@Test
	public void diatonicAltToChromatic() {
		assertEquals( Chromatic.C, Chromatic.from(DiatonicAlt.BB ) );
		assertEquals( Chromatic.G, Chromatic.from(DiatonicAlt.FFF ) );
		assertEquals( Chromatic.GG, Chromatic.from(DiatonicAlt.FFFF ) );
	}

	@Test
	public void chordFunction() {
		assertEquals(0, DiatonicDegree.from(DiatonicFunction.I).ordinal());
	}

	@Test
	public void whatIsItStatic() {
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

		List<DiatonicChordMidi> chords = DiatonicChordMidiBuilder.fromChromaticChord(
				notes,
				false
		);
		assert ( chords.size() > 0 );
	}


	@Test
	public void dist() {
		ChromaticChord notes = ChromaticChord.builder().fromChromatic(
				Chromatic.FF, Chromatic.A, Chromatic.CC
		).build();

		ChromaticChordPattern n = ChromaticChordPattern.from(notes);

		assertEquals(
				Arrays.asList(
						0,
						3,
						7
				), n
		);
	}
}
