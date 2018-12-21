package Tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import diatonic.ChordNotation;
import diatonic.ChromaticFunction;
import diatonic.DiatonicDegree;
import diatonic.DiatonicFunction;
import diatonic.IntervalDiatonic;
import midi.AddedException;
import musical.Chromatic;
import musical.ChromaticChordEnum;
import musical.Diatonic;
import pitch.ChromaticChordMidi;
import pitch.ChromaticMidi;
import pitch.DiatonicChordMidi;
import pitch.DiatonicMidi;
import pitch.NoteMidi;
import tonality.ScaleEnum;
import tonality.Tonality;
import tonality.TonalityEnum;

public class Tests {
	@Test
	public void chromaticDiatonicConversion() throws Exception {
		Chromatic c = Chromatic.Cb;
		assertEquals( Diatonic.I, Diatonic.get( c ) );
		c = Chromatic.BB;
		assertEquals( Diatonic.VII, Diatonic.get( c ) );

		Diatonic d = Diatonic.VII;
		assertEquals( Chromatic.BB, d.toChromatic( Chromatic.C ) );
		d = Diatonic.I;
		assertEquals( Chromatic.C, d.toChromatic( Chromatic.BB ) );
	}

	@Test
	public void pitchGet() {
		NoteMidi p = NoteMidi.of( Chromatic.C, 5 );
		assertEquals( NoteMidi.C5, p );

		p = NoteMidi.of( Chromatic.C, 0 );
		assertEquals( true, p.equals( NoteMidi.MIN ) );

		p = NoteMidi.of( Chromatic.G, 10 );
		assertEquals( true, p.equals( NoteMidi.MAX ) );

		ChromaticMidi n = Chromatic.C.toMidi( 5 );

		assertEquals( NoteMidi.C5, n.getCode() );
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

		assertEquals( NoteMidi.FF5, notes.get( 0 ).getCode() );

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
		DiatonicMidi n1 = DiatonicMidi.of( DiatonicFunction.I, TonalityEnum.C, 5 );
		DiatonicMidi n2 = DiatonicMidi.of( DiatonicFunction.II, TonalityEnum.C, 5 );
		DiatonicMidi n3 = DiatonicMidi.of( DiatonicFunction.III, TonalityEnum.C, 5 );

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
		DiatonicChordMidi c = new DiatonicChordMidi( ChromaticFunction.I5, 5, TonalityEnum.C );
		assertEquals( NoteMidi.G5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.C5, c.get( 0 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, TonalityEnum.C );
		assertEquals( NoteMidi.G5, c.get( 2 ).getCode() );
		assertEquals( NoteMidi.E5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.C5, c.get( 0 ).getCode() );
		c.inv();

		assertEquals( NoteMidi.C6, c.get( 2 ).getCode() );
		assertEquals( NoteMidi.G5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.E5, c.get( 0 ).getCode() );
	}

	@Test
	public void noteSorting() {
		ChromaticChordMidi notes = new ChromaticChordMidi();
		notes.add( Chromatic.A.toMidi() );
		notes.add( Chromatic.E.toMidi() );
		notes.add( Chromatic.F.toMidi() );
		notes.add( Chromatic.B.toMidi( 6 ) );
		notes.add( Chromatic.C.toMidi( 4 ) );
		notes.add( Chromatic.G.toMidi() );

		int code = notes.get( 0 ).getCode();
		for ( int i = 1; i < notes.size(); i++ ) {
			int code_i = notes.get( i ).getCode();
			assert ( code_i >= code );
			code = code_i;
		}
	}

	@Test
	public void makeChord() {
		Tonality s = TonalityEnum.B;
		int o = 5;
		DiatonicChordMidi c1 = new DiatonicChordMidi( DiatonicFunction.I, o, s );
		DiatonicChordMidi c2 = new DiatonicChordMidi( DiatonicFunction.II, o, s );

		assertEquals( NoteMidi.B5, c1.get( 0 ).getCode() );
		assertEquals( NoteMidi.CC6, c2.get( 0 ).getCode() );
	}

	@Test
	public void scaleByChord() {
		Tonality s = TonalityEnum.C;
		DiatonicChordMidi c = new DiatonicChordMidi( ChromaticFunction.V7_IV, 5, s );

		assertEquals(
			Tonality.of( Chromatic.C, ScaleEnum.MIXOLYDIAN ).getScale(), c.getTonality().getScale()
		);

		c = new DiatonicChordMidi( ChromaticFunction.V7_V, 5, TonalityEnum.E );
		assertEquals(
			Tonality.of( Chromatic.FF, ScaleEnum.MIXOLYDIAN ).getScale(), c.getTonality().getScale()
		);
	}

	@Test
	public void toChordUnfunc() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, TonalityEnum.C ) )
				.inv( 3 );

		ChromaticChordMidi cc = c.toChromaticChordMidi();
	}

	@Test
	public void toChordFunc() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, TonalityEnum.C ) )
				.inv( 3 );

		ArrayList<DiatonicChordMidi> chords = c.toChromaticChordMidi().toDiatonicChordMidi( false );
	}

	@Test
	public void whatIsIt() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, TonalityEnum.C ) )
				.inv( 3 );

		ArrayList<DiatonicChordMidi> chords = c.toChromaticChordMidi().toDiatonicChordMidi( false );

		int s1 = chords.size();
		assertEquals( 50, s1 );

		chords = c.toChromaticChordMidi().toDiatonicChordMidi( true );
		int s2 = chords.size();

		assertNotEquals( s1, s2 );
		assertEquals( 75, s2 );
	}

	@Test
	public void whatIsIt3() {
		ChromaticChordMidi cu = new ChromaticChordMidi();
		cu.add( Chromatic.C.toMidi() );
		cu.add( Chromatic.E.toMidi() );
		cu.add( Chromatic.G.toMidi() );
		// assertEquals("", cu.toChordFunc(false).get(0).str);
	}

	@Test
	public void whatIsItStatic() {
		Tonality s = TonalityEnum.C;
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );

		ChromaticChordMidi notes = new ChromaticChordMidi();
		for ( DiatonicMidi n : c )
			notes.add( n );

		ArrayList<DiatonicChordMidi> chords = notes.toDiatonicChordMidi( false );
		assert ( chords.size() > 0 );
	}

	@Test
	public void scaleRelative() {
		Tonality scale = TonalityEnum.E.getRelativeScaleDiatonic( IntervalDiatonic.FIFTH );
		assertEquals( Chromatic.B, scale.getRoot() );
		assertEquals( Tonality.of( Chromatic.B, ScaleEnum.MAJOR ).getScale(), scale.getScale() );
	}

	@Test
	public void scaleGet() {
		Tonality s = TonalityEnum.C;

		assertEquals( Chromatic.C, s.getRoot() );

		assertEquals( Chromatic.C, s.get( 0 ) );
		assertEquals( Chromatic.D, s.get( 1 ) );
	}

	@Test
	public void addDuplicateChord() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.VI_THIRD, TonalityEnum.Gm );
		assertEquals( NoteMidi.DD6, c.get( 0 ).getCode() );
		c.addDuplicate( 1 );
	}

	@Test
	public void getModes() {
		assertArrayEquals(
			new int[] {
				2,
				1,
				2,
				2,
				1,
				2,
				2
			}, ScaleEnum.MINOR.val()
		);
	}

	@Test
	public void getCode() {
		NoteMidi p = NoteMidi.of( 60 );
		assertEquals( NoteMidi.C5, p );
		p = NoteMidi.of( Chromatic.C, 5 );
		assertEquals( NoteMidi.C5, p );
		ChromaticMidi n = Chromatic.C.toMidi( 5 );
		assertEquals( NoteMidi.C5, n.getCode() );

		n = Chromatic.B.toMidi( 5 );
		assertEquals( NoteMidi.B5, n.getCode() );

		DiatonicMidi n2 = DiatonicMidi.of( DiatonicFunction.I, TonalityEnum.C, 5 );
		assertEquals( NoteMidi.C5, n2.getCode() );
		n2 = DiatonicMidi.of( DiatonicFunction.VII, TonalityEnum.C, 5 );
		assertEquals( NoteMidi.B5, n2.getCode() );
	}

	@Test
	public void getDegree() {
		DiatonicMidi n2 = DiatonicMidi.of( DiatonicFunction.I, TonalityEnum.C, 5 );
		assertEquals( DiatonicDegree.I, n2.getDegree() );
		n2 = DiatonicMidi.of( DiatonicFunction.VII, TonalityEnum.C, 5 );
		assertEquals( DiatonicDegree.VII, n2.getDegree() );
	}

	@Test
	public void addDuplicate() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.II_THIRD, 6, TonalityEnum.Gm );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.A6, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.C7, c.get( 1 ).getCode() );
		c.addDuplicate( 1 );
		assertEquals( 4, c.size() );
		assertEquals( NoteMidi.A7, c.get( 2 ).getCode() );
		assertEquals( NoteMidi.C8, c.get( 3 ).getCode() );
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
