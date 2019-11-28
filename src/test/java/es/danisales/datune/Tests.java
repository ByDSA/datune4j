package es.danisales.datune;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.*;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
		assertEquals( 0, DiatonicFunction.I.getDegree().ordinal() );
	}

	@Test
    public void whatIsItStatic() throws PitchMidiException {
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

		List<DiatonicChordMidi> chords = DiatonicChordMidi.fromChromaticChord(
                notes,
                false
        );
		assert ( chords.size() > 0 );
	}


	@Test
    public void dist() throws PitchMidiException {
		ChromaticChordMidi notes = ChromaticChordMidi.builder().fromChromatic(
				Chromatic.FF, Chromatic.A, Chromatic.CC
		).build();

		assertEquals( PitchChromaticMidi.FF5, notes.get( 0 ).getPitch());

		List<Integer> n = notes.integerNotationFromRoot();

		assertArrayEquals(
				new Integer[] {
						0,
						3,
						7
				}, n.toArray()
		);
	}
}
