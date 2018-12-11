package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.IntervalDiatonic;
import pitch.Chromatic;
import pitch.DiatonicMidi;
import pitch.PitchMidiEnum;
import pitch.PitchMidiSingle;
import tonality.ScaleEnum;
import tonality.Tonality;
import tonality.TonalityEnum;

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
		DiatonicMidi n = new DiatonicMidi( DiatonicFunction.V, TonalityEnum.E, 6 );
		DiatonicMidi n2 = n.clone().sub( IntervalDiatonic.UNISON );
		assertEquals( PitchMidiEnum.B6, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.SECOND );
		assertEquals( PitchMidiEnum.A6, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.THIRD );
		assertEquals( PitchMidiEnum.GG6, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.FOURTH );
		assertEquals( PitchMidiEnum.FF6, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.FIFTH );
		assertEquals( PitchMidiEnum.E6, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.SIXTH );
		assertEquals( PitchMidiEnum.DD6, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.SEVENTH );
		assertEquals( PitchMidiEnum.CC6, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.OCTAVE );
		assertEquals( PitchMidiEnum.B5, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.NINTH );
		assertEquals( PitchMidiEnum.A5, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.TENTH );
		assertEquals( PitchMidiEnum.GG5, n2.getPitchCode() );
		n2 = n.clone().sub( IntervalDiatonic.ELEVENTH );
		assertEquals( PitchMidiEnum.FF5, n2.getPitchCode() );
		
	}

	@Test
	public void add() {
		Tonality s = Tonality.of( Chromatic.FF, ScaleEnum.MIXOLYDIAN );
		DiatonicMidi n = new DiatonicMidi( DiatonicFunction.I, s, 3 );
		assertEquals( 42, n.getPitchCode().getCode() );
		assertEquals( 3, n.getOctave() );
		assertEquals( 46, n.clone().add( IntervalDiatonic.THIRD ).getPitchCode().getCode() );
		assertEquals( 49, n.clone().add( IntervalDiatonic.FIFTH ).getPitchCode().getCode() );
		assertEquals( 3, n.clone().add( IntervalDiatonic.FIFTH ).getOctave() );
		assertEquals( 52, n.clone().add( IntervalDiatonic.SEVENTH ).getPitchCode().getCode() );
	}
	
	@Test
	public void noteScaleConstructor() {
		Tonality s = Tonality.of( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicMidi n = new DiatonicMidi( IntervalDiatonic.OCTAVE, s, 5 );

		assertEquals( PitchMidiEnum.C6, n.getPitchCode() );
		assertEquals( 6, n.getOctave() );
		assertEquals( 6, n.toChromaticMidi().getOctave() );

		n = new DiatonicMidi( IntervalDiatonic.SIXTH, s, 5 );

		assertEquals( Degree.VI, n.getDegree() );
		assertEquals( Chromatic.A, n.toChromaticMidi().getChromatic() );
		assertEquals( 5, n.getOctave() );
		assertEquals( PitchMidiSingle.of( 60 + diffM[4] ), n.getPitchCode() );
		s = Tonality.of( Chromatic.FF, ScaleEnum.MINOR );
		n = new DiatonicMidi( IntervalDiatonic.FIFTH, s, 5 );

		assertEquals( 5, n.getOctave() );
		assertEquals( 6, n.toChromaticMidi().getOctave() );
		assertEquals( PitchMidiSingle.of( 73 ), n.getPitchCode() );

		n = new DiatonicMidi( IntervalDiatonic.SIXTH, s, 4 );

		assertEquals( PitchMidiSingle.of( 62 ), n.getPitchCode() );
		assertEquals( 4, n.getOctave() );
		assertEquals( 5, n.toChromaticMidi().getOctave() );
	}
	
	@Test
	public void noteScaleAdd() {
		Tonality s = Tonality.of( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicMidi n = new DiatonicMidi( s );

		for ( int i = 0; i < diffM.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.of( i+1 );
			DiatonicMidi n2 = n.clone().add( id );
			int d1 = n2.getPitchCode().getCode() - n.getPitchCode().getCode();
			int d2 = diffM[i];
			assertEquals( d2, d1 );
		}

		s = Tonality.of( Chromatic.FF, ScaleEnum.MINOR );
		n = new DiatonicMidi( s );

		for ( int i = 0; i < diffm.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.of( i+1 );
			DiatonicMidi n2 = n.clone().add( id );
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
			IntervalDiatonic id = IntervalDiatonic.of( i );
			DiatonicMidi n2 = n.clone().add( id );
			int d1 = n2.getPitchCode().ordinal();
			assertEquals( "Error al añadir " + i + " posiciones a " + n, r[i], d1 );
		}
	}
	
	@Test
	public void equals() {
		DiatonicMidi dm = new DiatonicMidi( Degree.I, TonalityEnum.C, 5 );
		DiatonicMidi dm2 = new DiatonicMidi( Degree.I, TonalityEnum.C, 5 );
		assertEquals(dm2, dm);
	}
}
