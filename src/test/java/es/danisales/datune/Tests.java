package es.danisales.datune;

import es.danisales.datune.diatonic.ChordNotation;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.*;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChordEnum;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.Tonality;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Tests {
	@Test
	public void chromaticDiatonicConversion() throws Exception {
		DiatonicAlt c = DiatonicAlt.Cb;
		assertEquals( Diatonic.C, Diatonic.from( c ) );
		c = DiatonicAlt.BB;
		assertEquals( Diatonic.B, Diatonic.from( c ) );

		Diatonic d = Diatonic.B;
		assertEquals( DiatonicAlt.BB, Chromatic.from(DiatonicAlt.C ) );
		d = Diatonic.C;
		assertEquals( Chromatic.C, Chromatic.from(DiatonicAlt.BB) );
	}

	@Test
	public void pitchGet() {
		PitchMidi p = PitchMidi.from( Chromatic.C, 5 );
		assertEquals( PitchMidi.C5, p );

		p = PitchMidi.from( Chromatic.C, 0 );
		assertEquals( true, p.equals( PitchMidi.MIN ) );

		p = PitchMidi.from( Chromatic.G, 10 );
		assertEquals( true, p.equals( PitchMidi.MAX ) );

		ChromaticMidi n = ChromaticMidi.builder()
				.pitch(Chromatic.C, 5 )
				.build();

		assertEquals( PitchMidi.C5, n.getCode() );
	}

	@Test
	public void chordFunction() {
		assertEquals( 0, DiatonicFunction.I.getDegree().val() );
	}

	@Test
	public void dist() {
		ChromaticChordMidi notes = ChromaticChordMidi.of(
				Chromatic.FF, Chromatic.A, Chromatic.CC
		);

		assertEquals( PitchMidi.FF5, notes.get( 0 ).getCode() );

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
		assertEquals( PitchMidi.G5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.C5, c.get( 0 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.C );
		assertEquals( PitchMidi.G5, c.get( 2 ).getCode() );
		assertEquals( PitchMidi.E5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.C5, c.get( 0 ).getCode() );
		c.inv();

		assertEquals( PitchMidi.C6, c.get( 2 ).getCode() );
		assertEquals( PitchMidi.G5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.E5, c.get( 0 ).getCode() );
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

		int code = notes.get( 0 ).getCode();
		for ( int i = 1; i < notes.size(); i++ ) {
			int code_i = notes.get( i ).getCode();
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

		assertEquals( PitchMidi.B5, c1.get( 0 ).getCode() );
		assertEquals( PitchMidi.CC6, c2.get( 0 ).getCode() );
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
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) )
				.getInv( 3 );

		ChromaticChordMidi cc = c.toChromaticChordMidi();
	}

	@Test
	public void toChordFunc() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) )
				.getInv( 3 );

		List<DiatonicChordMidi> chords = c.toChromaticChordMidi().toDiatonicChordMidi( false );
	}

	@Test
	public void whatIsIt() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) )
				.getInv( 3 );

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
		// assertEquals("", cu.toChordFunc(false).calculateFrom(0).str);
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
	public void scaleRelative() {
		Tonality scale = Tonality.E.getRelativeScaleDiatonic( DiatonicDegree.V );
		assertEquals( Chromatic.B, scale.getRoot() );
		assertEquals( Tonality.from( Chromatic.B, Scale.MAJOR ).getScale(), scale.getScale() );
	}

	@Test
	public void scaleGet() {
		Tonality s = Tonality.C;

		assertEquals( Chromatic.C, s.getRoot() );

		assertEquals( Chromatic.C, s.getNote( DiatonicDegree.I ) );
		assertEquals( Chromatic.D, s.getNote( DiatonicDegree.II ) );
	}

	@Test
	public void addDuplicateChord() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.VI_THIRD, Tonality.Gm );
		assertEquals( PitchMidi.DD6, c.get( 0 ).getCode() );
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
		PitchMidi p = PitchMidi.from( 60 );
		assertEquals( PitchMidi.C5, p );
		p = PitchMidi.from( Chromatic.C, 5 );
		assertEquals( PitchMidi.C5, p );
		ChromaticMidi n = ChromaticMidi.builder().pitch(Chromatic.C, 5 ).build();
		assertEquals( PitchMidi.C5, n.getCode() );

		n = ChromaticMidi.builder().pitch(Chromatic.B, 5 ).build();
		assertEquals( PitchMidi.B5, n.getCode() );

		DiatonicMidi n2 = DiatonicMidi.from( DiatonicDegree.I, Tonality.C, 5 );
		assertEquals( PitchMidi.C5, n2.getCode() );
		n2 = DiatonicMidi.from( DiatonicDegree.VII, Tonality.C, 5 );
		assertEquals( PitchMidi.B5, n2.getCode() );
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
		assertEquals( PitchMidi.A6, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.C7, c.get( 1 ).getCode() );
		c.addDuplicate( 1 );
		assertEquals( 4, c.size() );
		assertEquals( PitchMidi.A7, c.get( 2 ).getCode() );
		assertEquals( PitchMidi.C8, c.get( 3 ).getCode() );
	}

	@Test
	public void chordUnfuncChords() {
		assertEquals( 3, ChromaticChordEnum.C.size() );

		for ( ChromaticChordEnum c : ChromaticChordEnum.TRIAD_CHORDS ) {
			assertEquals( 3, c.size() );
		}

		for ( ChromaticChordEnum c : ChromaticChordEnum.COMMON_CHORDS ) {
			assertEquals( true, c.size() > 1 );
			assertNotEquals( c.notesToString(), null, c.getQuality() );
			assertNotEquals( ChordNotation.EMPTY_CHORD, c.toString() );
		}

		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_MAJOR )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							4,
							7
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_MINOR )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							3,
							7
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_DIMINISHED )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							3,
							6
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_AUGMENTED )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							4,
							8
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_SUS4 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							5,
							7
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_SUS2 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							2,
							7
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_7 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							4,
							7,
							10
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_7b5 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							4,
							6,
							10
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_7a5 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							4,
							8,
							10
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_Maj7 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							4,
							7,
							11
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_mMaj7 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							3,
							7,
							11
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_m7 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							3,
							7,
							10
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_m7a5 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							3,
							8,
							10
					}, c.integerNotationFromRoot().toArray()
			);
		for ( ChromaticChordEnum c : ChromaticChordEnum.CHORDS_m7b5 )
			Assert.assertArrayEquals(
					new Integer[] {
							0,
							3,
							6,
							10
					}, c.integerNotationFromRoot().toArray()
			);
	}
}
