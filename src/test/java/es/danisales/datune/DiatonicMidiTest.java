package es.danisales.datune;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.ScaleEnum;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
		DiatonicMidi n = DiatonicMidi.of( DiatonicFunction.V, TonalityEnum.E, 6 );
		DiatonicMidi n2 = n.clone().sub( IntervalDiatonic.UNISON );
		assertEquals( PitchMidi.B6, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.SECOND );
		assertEquals( PitchMidi.A6, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.THIRD );
		assertEquals( PitchMidi.GG6, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.FOURTH );
		assertEquals( PitchMidi.FF6, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.FIFTH );
		assertEquals( PitchMidi.E6, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.SIXTH );
		assertEquals( PitchMidi.DD6, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.SEVENTH );
		assertEquals( PitchMidi.CC6, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.OCTAVE );
		assertEquals( PitchMidi.B5, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.NINTH );
		assertEquals( PitchMidi.A5, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.TENTH );
		assertEquals( PitchMidi.GG5, n2.getCode() );
		n2 = n.clone().sub( IntervalDiatonic.ELEVENTH );
		assertEquals( PitchMidi.FF5, n2.getCode() );
		
	}

	@Test
	public void add() {
		Tonality s = Tonality.of( Chromatic.FF, ScaleEnum.MIXOLYDIAN );
		DiatonicMidi n = DiatonicMidi.of( DiatonicFunction.I, s, 3 );
		assertEquals( 42, n.getCode() );
		assertEquals( 3, n.getOctave() );
		assertEquals( 46, n.clone().add( IntervalDiatonic.THIRD ).getCode() );
		assertEquals( 49, n.clone().add( IntervalDiatonic.FIFTH ).getCode() );
		assertEquals( 3, n.clone().add( IntervalDiatonic.FIFTH ).getOctave() );
		assertEquals( 52, n.clone().add( IntervalDiatonic.SEVENTH ).getCode() );
	}
	
	@Test
	public void noteScaleAdd() {
		Tonality s = Tonality.of( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicMidi n = DiatonicMidi.of( DiatonicFunction.I, s, 4 );

		for ( int i = 0; i < diffM.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.fromIndex( i+1 );
			DiatonicMidi n2 = n.clone().add( id );
			int d1 = n2.getCode() - n.getCode();
			int d2 = diffM[i];
			assertEquals( d2, d1 );
		}

		s = Tonality.of( Chromatic.FF, ScaleEnum.MINOR );
		n = DiatonicMidi.of( DiatonicFunction.I, s, 4 );

		for ( int i = 0; i < diffm.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.fromIndex( i+1 );
			DiatonicMidi n2 = n.clone().add( id );
			int d1 = n2.getCode() - n.getCode();
			int d2 = diffm[i];
			assertEquals( "Error al a�adir " + i + " posiciones a " + n, d2, d1 );
		}

		n = DiatonicMidi.of( DiatonicDegree.VI, s, 4 );
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
			IntervalDiatonic id = IntervalDiatonic.fromIndex( i );
			DiatonicMidi n2 = n.clone().add( id );
			int d1 = n2.getCode();
			assertEquals( "Error al a�adir " + i + " posiciones a " + n, r[i], d1 );
		}
	}
	
	@Test
	public void equals() {
		DiatonicMidi dm = DiatonicMidi.of( DiatonicDegree.I, TonalityEnum.C, 5 );
		DiatonicMidi dm2 = DiatonicMidi.of( DiatonicDegree.I, TonalityEnum.C, 5 );
		assertEquals(dm2, dm);
	}
}
