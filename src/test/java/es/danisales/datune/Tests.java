package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.*;
import es.danisales.datune.musical.*;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.Arrays;
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
	public void dist() {
		ChromaticChordMidi notes = ChromaticChordMidi.of(
				Chromatic.FF, Chromatic.A, Chromatic.CC
		);

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

	@Test
	public void chordSameNote() {
		DiatonicMidi n1 = DiatonicMidi.from( DiatonicDegree.I, Tonality.C, 5 );
		DiatonicMidi n2 = DiatonicMidi.from( DiatonicDegree.II, Tonality.C, 5 );
		DiatonicMidi n3 = DiatonicMidi.from( DiatonicDegree.III, Tonality.C, 5 );

		boolean error = false;
		DiatonicChordMidi c2 = new DiatonicChordMidi( n2, n3 );
		try {
			c2.add( n1 );
		} catch ( Exception e ) {
			e.printStackTrace();
			error = true;
		}

		assertEquals( false, error );

		try {
			c2.add( n2 );
			c2.add( n3 );
		} catch ( AddedException e ) {
			error = true;
		}

		assertEquals( true, error );
	}

	@Test
	public void chordInv() {
		DiatonicChordMidi c = new DiatonicChordMidi( ChromaticFunction.I5, 5, Tonality.C );
		assertEquals( PitchChromaticMidi.G5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.C5, c.get( 0 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.C );
		assertEquals( PitchChromaticMidi.G5, c.get( 2 ).getPitch() );
		assertEquals( PitchChromaticMidi.E5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.C5, c.get( 0 ).getPitch() );
		c.inv();

		assertEquals( PitchChromaticMidi.C6, c.get( 2 ).getPitch() );
		assertEquals( PitchChromaticMidi.G5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.E5, c.get( 0 ).getPitch() );
	}

	@Test
	public void noteSorting() {
		ChromaticChordMidi notes = ChromaticChordMidi.from(
				ChromaticMidi.builder().pitch(Chromatic.A).build(),
				ChromaticMidi.builder().pitch(Chromatic.E).build(),
				ChromaticMidi.builder().pitch(Chromatic.F).build(),
				ChromaticMidi.builder().pitch(Chromatic.B, 6).build(),
				ChromaticMidi.builder().pitch(Chromatic.C, 4).build(),
				ChromaticMidi.builder().pitch(Chromatic.G).build()
		);

		int code = notes.get( 0 ).getPitch().getCode();
		for ( int i = 1; i < notes.size(); i++ ) {
			int code_i = notes.get( i ).getPitch().getCode();
			assertTrue ( code_i >= code );
			code = code_i;
		}
	}

	@Test
	public void makeChord() {
		Tonality s = Tonality.B;
		int o = 5;
		DiatonicChordMidi c1 = new DiatonicChordMidi( DiatonicFunction.I, o, s );
		DiatonicChordMidi c2 = new DiatonicChordMidi( DiatonicFunction.II, o, s );

		assertEquals( PitchChromaticMidi.B5, c1.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.CC6, c2.get( 0 ).getPitch() );
	}

	@Test
	public void scaleByChord() {
		Tonality s = Tonality.C;
		DiatonicChordMidi c = new DiatonicChordMidi( ChromaticFunction.V7_IV, 5, s );

		assertEquals(
				Tonality.from( Chromatic.C, Scale.MIXOLYDIAN ).getScale(), c.getTonality().getScale()
		);

		c = new DiatonicChordMidi( ChromaticFunction.V7_V, 5, Tonality.E );
		assertEquals(
				Tonality.from( Chromatic.FF, Scale.MIXOLYDIAN ).getScale(), c.getTonality().getScale()
		);
	}

	@Test
	public void toChordUnfunc() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) );
		c.inv(3);

		ChromaticChordMidi cc = c.toChromaticChordMidi();
	}

	@Test
	public void toChordFunc() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) );
		c.inv(3);

		List<DiatonicChordMidi> chords = c.toChromaticChordMidi().toDiatonicChordMidi( false );
	}

	@Test
	public void whatIsIt() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) );
		c.inv(3);

		List<DiatonicChordMidi> chords = c.toChromaticChordMidi().toDiatonicChordMidi( false );

		int s1 = chords.size();
		assertEquals( 50, s1 );

		chords = c.toChromaticChordMidi().toDiatonicChordMidi( true );
		int s2 = chords.size();

		assertNotEquals( s1, s2 );
		assertEquals( 75, s2 );
	}

	@Test
	public void whatIsIt3() {
		ChromaticChordMidi cu = ChromaticChordMidi.from(
				ChromaticMidi.builder().pitch(Chromatic.C).build(),
				ChromaticMidi.builder().pitch(Chromatic.E).build(),
				ChromaticMidi.builder().pitch(Chromatic.G).build()
		);
		// assertEquals("", cu.toChordFunc(false).getAllFrom(0).str);
	}

	@Test
	public void whatIsItStatic() {
		Tonality s = Tonality.C;
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );

		ChromaticChordMidi notes = ChromaticChordMidi.newEmpty();
		for ( DiatonicMidi n : c ) {
			ChromaticMidi chromaticMidi = ChromaticMidi.from(n);
			notes.add(chromaticMidi);
		}

		List<DiatonicChordMidi> chords = notes.toDiatonicChordMidi( false );
		assert ( chords.size() > 0 );
	}

	@Test
	public void addDuplicateChord() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.VI_THIRD, Tonality.Gm );
		assertEquals( PitchChromaticMidi.DD6, c.get( 0 ).getPitch() );
		c.addDuplicate( 1 );
	}

	@Test
	public void getModes() {
		assertEquals(
				Arrays.asList(
						2,
						1,
						2,
						2,
						1,
						2,
						2
				), Scale.MINOR.getCode()
		);
	}

	@Test
	public void getCode() {
		PitchChromaticMidi p = PitchChromaticMidi.from( 60 );
		assertEquals( PitchChromaticMidi.C5, p );
		p = PitchChromaticMidi.from( Chromatic.C, 5 );
		assertEquals( PitchChromaticMidi.C5, p );
		ChromaticMidi n = ChromaticMidi.builder().pitch(Chromatic.C, 5 ).build();
		assertEquals( PitchChromaticMidi.C5, n.getPitch() );

		n = ChromaticMidi.builder().pitch(Chromatic.B, 5 ).build();
		assertEquals( PitchChromaticMidi.B5, n.getPitch() );

		DiatonicMidi n2 = DiatonicMidi.from( DiatonicDegree.I, Tonality.C, 5 );
		assertEquals( PitchChromaticMidi.C5, n2.getPitch() );
		n2 = DiatonicMidi.from( DiatonicDegree.VII, Tonality.C, 5 );
		assertEquals( PitchChromaticMidi.B5, n2.getPitch() );
	}

	@Test
	public void getDegree() {
		DiatonicMidi n2 = DiatonicMidi.from( DiatonicDegree.I, Tonality.C, 5 );
		assertEquals( DiatonicDegree.I, n2.getDegree() );
		n2 = DiatonicMidi.from( DiatonicDegree.VII, Tonality.C, 5 );
		assertEquals( DiatonicDegree.VII, n2.getDegree() );
	}

	@Test
	public void addDuplicate() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.II_THIRD, 6, Tonality.Gm );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.A6, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.C7, c.get( 1 ).getPitch() );
		c.addDuplicate( 1 );
		assertEquals( 4, c.size() );
		assertEquals( PitchChromaticMidi.A7, c.get( 2 ).getPitch() );
		assertEquals( PitchChromaticMidi.C8, c.get( 3 ).getPitch() );
	}
}
