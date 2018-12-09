package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.IntervalDiatonic;
import diatonic.ScaleEnum;
import diatonic.Tonality;
import pitch.Chromatic;
import pitch.DiatonicMidi;
import pitch.Pitch;

public class DiatonicMidiTest {
	int[]	diffM	= new int[] {
		2,
		4,
		5,
		7,
		9,
		11,
		12,
		14,
		16
	};
	int[]	diffm	= new int[] {
		2,
		3,
		5,
		7,
		8,
		10,
		12,
		14,
		15
	};
	
	@Test
	public void addNegative() {
		DiatonicMidi n = new DiatonicMidi( DiatonicFunction.V, Tonality.E, 6 );
		DiatonicMidi n2 = DiatonicMidi.add(n, -IntervalDiatonic.UNISON.val() );
		assertEquals( Pitch.B6, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.SECOND.val() );
		assertEquals( Pitch.A6, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.THIRD.val() );
		assertEquals( Pitch.GG6, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.FOURTH.val() );
		assertEquals( Pitch.FF6, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.FIFTH.val() );
		assertEquals( Pitch.E6, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.SIXTH.val() );
		assertEquals( Pitch.DD6, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.SEVENTH.val() );
		assertEquals( Pitch.CC6, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.OCTAVE.val() );
		assertEquals( Pitch.B5, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.NINTH.val() );
		assertEquals( Pitch.A5, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.TENTH.val() );
		assertEquals( Pitch.GG5, n2.getPitchCode() );
		n2 = DiatonicMidi.add(n, -IntervalDiatonic.ELEVENTH.val() );
		assertEquals( Pitch.FF5, n2.getPitchCode() );
		
	}

	@Test
	public void add() {
		Tonality s = new Tonality( Chromatic.FF, ScaleEnum.MIXOLYDIAN );
		DiatonicMidi n = new DiatonicMidi( DiatonicFunction.I, s, 3 );
		assertEquals( 42, n.getPitchCode().val() );
		assertEquals( 3, n.getOctave() );
		assertEquals( 46, DiatonicMidi.add( n, IntervalDiatonic.THIRD ).getPitchCode().val() );
		assertEquals( 49, DiatonicMidi.add( n, IntervalDiatonic.FIFTH ).getPitchCode().val() );
		assertEquals( 3, DiatonicMidi.add( n, IntervalDiatonic.FIFTH ).getOctave() );
		assertEquals( 52, DiatonicMidi.add( n, IntervalDiatonic.SEVENTH ).getPitchCode().val() );
	}
	
	@Test
	public void noteScaleConstructor() {
		Tonality s = new Tonality( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicMidi n = new DiatonicMidi( IntervalDiatonic.OCTAVE, s, 5 );

		assertEquals( Pitch.C6, n.getPitchCode() );
		assertEquals( 6, n.getOctave() );
		assertEquals( 6, n.toChromaticMidi().getOctave() );

		n = new DiatonicMidi( IntervalDiatonic.SIXTH, s, 5 );

		assertEquals( Degree.VI, n.getDegree() );
		assertEquals( Chromatic.A, n.toChromaticMidi().getChromatic() );
		assertEquals( 5, n.getOctave() );
		assertEquals( Pitch.getFromCode( 60 + diffM[4] ), n.getPitchCode() );
		s = new Tonality( Chromatic.FF, ScaleEnum.MINOR );
		n = new DiatonicMidi( IntervalDiatonic.FIFTH, s, 5 );

		assertEquals( 5, n.getOctave() );
		assertEquals( 6, n.toChromaticMidi().getOctave() );
		assertEquals( Pitch.getFromCode( 73 ), n.getPitchCode() );

		n = new DiatonicMidi( IntervalDiatonic.SIXTH, s, 4 );

		assertEquals( Pitch.getFromCode( 62 ), n.getPitchCode() );
		assertEquals( 4, n.getOctave() );
		assertEquals( 5, n.toChromaticMidi().getOctave() );
	}
	
	@Test
	public void noteScaleAdd() {
		Tonality s = new Tonality( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicMidi n = new DiatonicMidi( s );

		for ( int i = 0; i < diffM.length; i++ ) {
			DiatonicMidi n2 = DiatonicMidi.add( n, i + 1 );
			int d1 = n2.getPitchCode().val() - n.getPitchCode().val();
			int d2 = diffM[i];
			assertEquals( d2, d1 );
		}

		s = new Tonality( Chromatic.FF, ScaleEnum.MINOR );
		n = new DiatonicMidi( s );

		for ( int i = 0; i < diffm.length; i++ ) {
			DiatonicMidi n2 = DiatonicMidi.add( n, i + 1 );
			int d1 = n2.getPitchCode().ordinal() - n.getPitchCode().ordinal();
			int d2 = diffm[i];
			assertEquals( "Error al añadir " + i + " posiciones a " + n, d2, d1 );
		}

		n = new DiatonicMidi( Degree.VI, s, 4 );
		int[] r = new int[] {
			62,
			64,
			66,
			68,
			69,
			71,
			73,
			74
		};
		for ( int i = 0; i < r.length; i++ ) {
			DiatonicMidi n2 = DiatonicMidi.add( n, i );
			int d1 = n2.getPitchCode().ordinal();
			assertEquals( "Error al añadir " + i + " posiciones a " + n, r[i], d1 );
		}
	}
	
	@Test
	public void equals() {
		DiatonicMidi dm = new DiatonicMidi( Degree.I, Tonality.C, 5 );
		DiatonicMidi dm2 = new DiatonicMidi( Degree.I, Tonality.C, 5 );
		assertEquals(dm2, dm);
	}
}
