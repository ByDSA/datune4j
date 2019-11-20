package es.danisales.datune;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
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
		DiatonicMidi n = DiatonicMidi.from( DiatonicDegree.V, Tonality.E, 6 );
		DiatonicMidi n2 = n.clone().sub( IntervalDiatonic.UNISON );
		assertEquals( PitchChromaticMidi.B6, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.SECOND );
		assertEquals( PitchChromaticMidi.A6, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.THIRD );
		assertEquals( PitchChromaticMidi.GG6, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.FOURTH );
		assertEquals( PitchChromaticMidi.FF6, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.FIFTH );
		assertEquals( PitchChromaticMidi.E6, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.SIXTH );
		assertEquals( PitchChromaticMidi.DD6, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.SEVENTH );
		assertEquals( PitchChromaticMidi.CC6, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.OCTAVE );
		assertEquals( PitchChromaticMidi.B5, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.NINTH );
		assertEquals( PitchChromaticMidi.A5, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.TENTH );
		assertEquals( PitchChromaticMidi.GG5, n2.getPitch() );
		n2 = n.clone().sub( IntervalDiatonic.ELEVENTH );
		assertEquals( PitchChromaticMidi.FF5, n2.getPitch() );
		
	}

	@Test
	public void add() {
		Tonality s = Tonality.from( Chromatic.FF, Scale.MIXOLYDIAN );
		DiatonicMidi n = DiatonicMidi.from( DiatonicDegree.I, s, 3 );
		assertEquals( 42, n.getPitch() );
		assertEquals( 3, n.getOctave() );
		assertEquals( 46, n.clone().add( IntervalDiatonic.THIRD ).getPitch() );
		assertEquals( 49, n.clone().add( IntervalDiatonic.FIFTH ).getPitch() );
		assertEquals( 3, n.clone().add( IntervalDiatonic.FIFTH ).getOctave() );
		assertEquals( 52, n.clone().add( IntervalDiatonic.SEVENTH ).getPitch() );
	}
	
	@Test
	public void noteScaleAdd() {
		Tonality s = Tonality.from( Chromatic.C, Scale.MAJOR );
		DiatonicMidi n = DiatonicMidi.from( DiatonicDegree.I, s, 4 );

		for ( int i = 0; i < diffM.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.fromIndex( i+1 );
			DiatonicMidi n2 = n.clone().add( id );
			int d1 = n2.getPitch().getCode() - n.getPitch().getCode();
			int d2 = diffM[i];
			assertEquals( d2, d1 );
		}

		s = Tonality.from( Chromatic.FF, Scale.MINOR );
		n = DiatonicMidi.from( DiatonicDegree.I, s, 4 );

		for ( int i = 0; i < diffm.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.fromIndex( i+1 );
			DiatonicMidi n2 = n.clone().add( id );
			int d1 = n2.getPitch().getCode() - n.getPitch().getCode();
			int d2 = diffm[i];
			assertEquals( "Error al a�adir " + i + " posiciones a " + n, d2, d1 );
		}

		n = DiatonicMidi.from( DiatonicDegree.VI, s, 4 );
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
			int d1 = n2.getPitch().getCode();
			assertEquals( "Error al añadir " + i + " posiciones a " + n, r[i], d1 );
		}
	}
	
	@Test
	public void equals() {
		DiatonicMidi dm = DiatonicMidi.from( DiatonicDegree.I, Tonality.C, 5 );
		DiatonicMidi dm2 = DiatonicMidi.from( DiatonicDegree.I, Tonality.C, 5 );
		assertEquals(dm2, dm);
	}
}
