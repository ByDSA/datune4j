package Tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import diatonic.ChordNotation;
import diatonic.ChromaticFunction;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.IntervalDiatonic;
import diatonic.ScaleEnum;
import diatonic.Tonality;
import midi.AddedException;
import pitch.Chromatic;
import pitch.ChromaticChord;
import pitch.ChromaticChordMidi;
import pitch.ChromaticMidi;
import pitch.Diatonic;
import pitch.DiatonicChordMidi;
import pitch.DiatonicMidi;
import pitch.Pitch;

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
		Pitch p = Pitch.get( Chromatic.C, 5 );
		assertEquals( Pitch.C5, p );

		p = Pitch.get( Chromatic.C, 0 );
		assertEquals( true, p.equals( Pitch.MIN ) );

		p = Pitch.get( Chromatic.G, 10 );
		assertEquals( true, p.equals( Pitch.MAX ) );

		ChromaticMidi n = Chromatic.C.toMidi( 5 );

		assertEquals( Pitch.C5, n.getPitchCode() );
	}

	@Test
	public void chordFunction() {
		assertEquals( 0, DiatonicFunction.I.getDegree().val() );
	}

	@Test
	public void dist() {
		ChromaticChordMidi notes = new ChromaticChordMidi(
			Chromatic.FF, Chromatic.A, Chromatic.CC
		);

		assertEquals( Pitch.FF5, notes.get( 0 ).getPitchCode() );

		Integer[] n = notes.integerNotationFromRoot();

		assertArrayEquals(
			new Integer[] {
				0,
				3,
				7
			}, n
		);
	}

	@Test
	public void chordSameNote() {
		DiatonicMidi n1 = new DiatonicMidi( DiatonicFunction.I, Tonality.C, 5 );
		DiatonicMidi n2 = new DiatonicMidi( DiatonicFunction.II, Tonality.C, 5 );
		DiatonicMidi n3 = new DiatonicMidi( DiatonicFunction.III, Tonality.C, 5 );

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
		assertEquals( Pitch.G5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.C5, c.get( 0 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.C );
		assertEquals( Pitch.G5, c.get( 2 ).getPitchCode() );
		assertEquals( Pitch.E5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.C5, c.get( 0 ).getPitchCode() );
		c.inv();

		assertEquals( Pitch.C6, c.get( 2 ).getPitchCode() );
		assertEquals( Pitch.G5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.E5, c.get( 0 ).getPitchCode() );
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

		int code = notes.get( 0 ).getPitchCode().val();
		for ( int i = 1; i < notes.size(); i++ ) {
			int code_i = notes.get( i ).getPitchCode().val();
			assert ( code_i >= code );
			code = code_i;
		}
	}

	@Test
	public void makeChord() {
		Tonality s = Tonality.B;
		int o = 5;
		DiatonicChordMidi c1 = new DiatonicChordMidi( DiatonicFunction.I, o, s );
		DiatonicChordMidi c2 = new DiatonicChordMidi( DiatonicFunction.II, o, s );

		assertEquals( Pitch.B5, c1.get( 0 ).getPitchCode() );
		assertEquals( Pitch.CC6, c2.get( 0 ).getPitchCode() );
	}

	@Test
	public void scaleByChord() {
		Tonality s = Tonality.C;
		DiatonicChordMidi c = new DiatonicChordMidi( ChromaticFunction.V7_IV, 5, s );

		assertEquals(
			new Tonality( Chromatic.C, ScaleEnum.MIXOLYDIAN ).getScale(), c.getTonality().getScale()
		);

		c = new DiatonicChordMidi( ChromaticFunction.V7_V, 5, Tonality.E );
		assertEquals(
			new Tonality( Chromatic.FF, ScaleEnum.MIXOLYDIAN ).getScale(), c.getTonality().getScale()
		);
	}

	@Test
	public void toChordUnfunc() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) )
				.inv( 3 );

		ChromaticChordMidi cc = c.toChromaticChordMidi();
	}

	@Test
	public void toChordFunc() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) )
				.inv( 3 );

		ArrayList<DiatonicChordMidi> chords = c.toChromaticChordMidi().toDiatonicChordMidi( false );
	}

	@Test
	public void whatIsIt() {
		DiatonicChordMidi c = ( new DiatonicChordMidi( DiatonicFunction.IV6, 5, Tonality.C ) )
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
		Tonality s = Tonality.C;
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );

		ChromaticChordMidi notes = new ChromaticChordMidi();
		for ( DiatonicMidi n : c )
			notes.add( n.toChromaticMidi() );

		ArrayList<DiatonicChordMidi> chords = notes.toDiatonicChordMidi( false );
		assert ( chords.size() > 0 );
	}

	@Test
	public void scaleRelative() {
		Tonality scale = Tonality.E.getRelativeScaleDiatonic( IntervalDiatonic.FIFTH );
		assertEquals( Chromatic.B, scale.getRoot() );
		assertEquals( new Tonality( Chromatic.B, ScaleEnum.MAJOR ).getScale(), scale.getScale() );
	}

	@Test
	public void scaleGet() {
		Tonality s = Tonality.C;

		assertEquals( Chromatic.C, s.getRoot() );

		assertEquals( Chromatic.C, s.get( 0 ) );
		assertEquals( Chromatic.D, s.get( 1 ) );
	}

	@Test
	public void addDuplicateChord() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.VI_THIRD, Tonality.Gm );
		assertEquals( Pitch.DD6, c.get( 0 ).getPitchCode() );
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
		Pitch p = Pitch.getFromCode( 60 );
		assertEquals( Pitch.C5, p );
		p = Pitch.get( Chromatic.C, 5 );
		assertEquals( Pitch.C5, p );
		ChromaticMidi n = Chromatic.C.toMidi( 5 );
		assertEquals( Pitch.C5, n.getPitchCode() );

		n = Chromatic.B.toMidi( 5 );
		assertEquals( Pitch.B5, n.getPitchCode() );

		DiatonicMidi n2 = new DiatonicMidi( DiatonicFunction.I, Tonality.C, 5 );
		assertEquals( Pitch.C5, n2.getPitchCode() );
		n2 = new DiatonicMidi( DiatonicFunction.VII, Tonality.C, 5 );
		assertEquals( Pitch.B5, n2.getPitchCode() );
	}

	@Test
	public void getDegree() {
		DiatonicMidi n2 = new DiatonicMidi( DiatonicFunction.I, Tonality.C, 5 );
		assertEquals( Degree.I, n2.getDegree() );
		n2 = new DiatonicMidi( DiatonicFunction.VII, Tonality.C, 5 );
		assertEquals( Degree.VII, n2.getDegree() );
	}

	@Test
	public void addDuplicate() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.II_THIRD, 6, Tonality.Gm );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.A6, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.C7, c.get( 1 ).getPitchCode() );
		c.addDuplicate( 1 );
		assertEquals( 4, c.size() );
		assertEquals( Pitch.A7, c.get( 2 ).getPitchCode() );
		assertEquals( Pitch.C8, c.get( 3 ).getPitchCode() );
	}

	@Test
	public void chordUnfuncChords() {
		assertEquals( 3, ChromaticChord.C.size() );

		for ( ChromaticChord c : ChromaticChord.TRIAD_CHORDS ) {
			assertEquals( 3, c.size() );
		}

		for ( ChromaticChord c : ChromaticChord.COMMON_CHORDS ) {
			assertEquals( true, c.size() > 1 );
			assertNotEquals( c.notesToString(), null, c.getQuality() );
			assertNotEquals( ChordNotation.EMPTY_CHORD, c.toString() );
		}

		for ( ChromaticChord c : ChromaticChord.CHORDS_MAJOR )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					4,
					7
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_MINOR )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					3,
					7
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_DIMINISHED )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					3,
					6
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_AUGMENTED )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					4,
					8
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_SUS4 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					5,
					7
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_SUS2 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					2,
					7
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_7 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					4,
					7,
					10
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_7b5 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					4,
					6,
					10
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_7a5 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					4,
					8,
					10
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_Maj7 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					4,
					7,
					11
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_mMaj7 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					3,
					7,
					11
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_m7 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					3,
					7,
					10
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_m7a5 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					3,
					8,
					10
				}, c.integerNotationFromRoot()
			);
		for ( ChromaticChord c : ChromaticChord.CHORDS_m7b5 )
			Assert.assertArrayEquals(
				new Integer[] {
					0,
					3,
					6,
					10
				}, c.integerNotationFromRoot()
			);
	}
}
