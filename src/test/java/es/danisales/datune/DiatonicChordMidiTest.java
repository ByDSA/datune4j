package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.*;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DiatonicChordMidiTest {
	@Test
	public void chordConstructorPowerChords() {
		Tonality s = Tonality.from( Chromatic.C, Scale.MAJOR );
		DiatonicChordMidi c;

		c = new DiatonicChordMidi( ChromaticFunction.I5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.C5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.G5, c.get( 1 ).getPitch());

		c = new DiatonicChordMidi( ChromaticFunction.II5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.D5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.A5, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.III5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.E5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.B5, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.IV5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.F5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.C6, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.V5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.G5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.D6, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.VI5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.A5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.E6, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.VII5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.B5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.FF6, c.get( 1 ).getPitch() );

		s = Tonality.Cm;

		c = new DiatonicChordMidi( ChromaticFunction.I5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.C5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.G5, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.II5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.D5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.A5, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.III5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.DD5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.AA5, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.IV5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.F5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.C6, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.V5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.G5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.D6, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.VI5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.GG5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.DD6, c.get( 1 ).getPitch() );

		c = new DiatonicChordMidi( ChromaticFunction.VII5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchChromaticMidi.AA5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.F6, c.get( 1 ).getPitch() );
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

	@Test
	public void constructorDiatonicFunc() {
		Tonality s = Tonality.from( Chromatic.C, Scale.MAJOR );
		DiatonicChordMidi c;
		c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.C5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.E5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.G5, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.II, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.D5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.F5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.A5, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.III, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.E5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.G5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.B5, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.IV, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.F5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.A5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.C6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.V, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.G5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.B5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.D6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.VI, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.A5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.C6, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.E6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.VII, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.B5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.D6, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.F6, c.get( 2 ).getPitch() );

		s = Tonality.from( Chromatic.FF, Scale.MINOR );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.FF5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.A5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.CC6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.II, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.GG5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.B5, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.D6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.III, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.A5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.CC6, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.E6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.IV, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.B5, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.D6, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.FF6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.V, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.CC6, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.E6, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.GG6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.VI, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.D6, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.FF6, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.A6, c.get( 2 ).getPitch() );

		c = new DiatonicChordMidi( DiatonicFunction.VII, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchChromaticMidi.E6, c.get( 0 ).getPitch() );
		assertEquals( PitchChromaticMidi.GG6, c.get( 1 ).getPitch() );
		assertEquals( PitchChromaticMidi.B6, c.get( 2 ).getPitch() );
	}

	@Test
	public void duplicate() {
		DiatonicChordMidi ca = new DiatonicChordMidi( Tonality.C, ChromaticChord.C );
		DiatonicChordMidi ca2 = ca.clone();

		assertEquals( ca.getFunction(), ca2.getFunction() );

		assertEquals( ca.getMetatonality(), ca2.getMetatonality() );

		assertEquals( true, ca instanceof DiatonicChordMidi );
		assertEquals( true, ca2 instanceof DiatonicChordMidi );

		assertEquals( ca, ca2 );
	}

	@Test
	public void inv() {
		DiatonicChordMidi c = new DiatonicChordMidi( Tonality.C, ChromaticChord.C );
		c.inv();
		Chromatic chromatic0 = Chromatic.from( c.get( 0 ) );
		Chromatic chromatic1 = Chromatic.from( c.get( 1 ) );
		Chromatic chromatic2 = Chromatic.from( c.getRoot() );
		Chromatic chromaticRoot = Chromatic.from( c.get( 2 ) );
		assertEquals( Chromatic.E, chromatic0 );
		assertEquals( Chromatic.G, chromatic1 );
		assertEquals( Chromatic.C, chromatic2 );
		assertEquals( Chromatic.C, chromaticRoot );
		assertEquals( 2, c.getRootPos() );
	}

	@Test
	public void getRoot() {
		Chromatic chromatic = Chromatic.from( new DiatonicChordMidi( Tonality.C, ChromaticChord.C ).getRoot() );
		assertEquals(Chromatic.C, chromatic);
		DiatonicChordMidi c = new DiatonicChordMidi( Tonality.C, ChromaticChord.C );
		c.inv();
		assertEquals( 2, c.getRootPos() );
		assertEquals( Chromatic.C, Chromatic.from( c.getRoot() ) );

		c = new DiatonicChordMidi( Tonality.C, ChromaticChord.F5 );
		assertEquals( 0, c.getRootPos() );
		assertEquals( Chromatic.F, Chromatic.from( c.getRoot() ) );

		c.inv();
		assertEquals( 1, c.getRootPos() );
		assertEquals( Chromatic.F, Chromatic.from( c.getRoot() ) );
	}

	@Test
	public void names() {
		DiatonicChordMidi ccm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.C );
		assertEquals(
				"C/E (C)", ccm.toString()
		);

		assertEquals( "C", ChromaticChord.C.toString() );

		DiatonicChordMidi dcm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.C );

		assertEquals( "C (C)", dcm.toString() );

		dcm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.Cm );
		assertEquals( "Cm (C)", dcm.toString() );
		dcm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.C );
		dcm.inv();
		
		assertEquals( "C/E (C)", dcm.toString() );
		dcm.inv();
		assertEquals( "C/G (C)", dcm.toString() );
		dcm.inv();
		assertEquals( "C (C)", dcm.toString() );

		dcm = new DiatonicChordMidi( ChromaticFunction.IV5, Tonality.C );
		assertEquals( "F5 (IV5)", dcm.toString() );
		dcm.inv();
		assertEquals( "F5/C (IV5)", dcm.toString() );

		dcm = new DiatonicChordMidi( DiatonicFunction.I2, Tonality.C );
		assertEquals( "Csus2 (I2)", dcm.toString() );
		dcm = new DiatonicChordMidi( DiatonicFunction.V4, Tonality.C );
		assertEquals( "Gsus4 (V4)", dcm.toString() );
		dcm.inv();
		assertEquals( "Gsus4/C (V4)", dcm.toString() );

		ChromaticChord cc = ChromaticChord.from(
				Arrays.asList( Chromatic.C, Chromatic.D, Chromatic.G )
		);
		dcm = new DiatonicChordMidi( Tonality.C, cc );
		assertEquals( "Csus2 (I2)", dcm.toString() );
	}


	@Test
	public void addDuplicateChord() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.VI_THIRD, Tonality.Gm );
		assertEquals( PitchChromaticMidi.DD6, c.get( 0 ).getPitch() );
		c.addDuplicate( 1 );
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
	public void addChromatics() {
		DiatonicChordMidi dcm = new DiatonicChordMidi( Tonality.C );
		assertEquals( Tonality.C, dcm.getTonality() );
		assertEquals( 0, dcm.size() );
		ChromaticChordMidi ccm = ChromaticChordMidi.from( ChromaticChord.F5 );
		for ( ChromaticMidi cm : ccm )
			dcm.add( cm );
		assertEquals( 0, dcm.getRootPos() );
		Chromatic chromatic0 = Chromatic.from( dcm.get( 0 ) );
		Chromatic chromatic1 = Chromatic.from( dcm.get( 1 ) );
		assertEquals( Chromatic.F, chromatic0 );
		assertEquals( Chromatic.C, chromatic1 );
		assertEquals( Tonality.C, dcm.getTonality() );
		assertEquals( "F5 (IV5)", dcm.toString() );
	}

	@Test
	public void addChromaticChord() {
		DiatonicChordMidi dcm = new DiatonicChordMidi( Tonality.C );
		assertEquals( Tonality.C, dcm.getTonality() );
		assertEquals( 0, dcm.size() );
		ChromaticChordMidi ccm = ChromaticChordMidi.from( ChromaticChord.F5 );
		dcm = new DiatonicChordMidi( Tonality.C );
		dcm.add( ccm );
		assertNotEquals( 0, dcm.size() );
		assertEquals( 0, dcm.getRootPos() );
		Chromatic chromatic0 = Chromatic.from( dcm.get( 0 ) );
		Chromatic chromatic1 = Chromatic.from( dcm.get( 1 ) );
		assertEquals( Chromatic.F, chromatic0 );
		assertEquals( Chromatic.C, chromatic1 );
		assertEquals( Tonality.C, dcm.getTonality() );
		assertEquals( "F5 (IV5)", dcm.toString() );
	}

	@Test
	public void chromaticChordToMidi() {
		DiatonicChordMidi c = new DiatonicChordMidi( Tonality.C, ChromaticChord.F5 );
		assertEquals( 0, c.getRootPos() );
		Chromatic chromatic0 = Chromatic.from( c.get( 0 ) );
		Chromatic chromatic1 = Chromatic.from( c.get( 1 ) );
		assertEquals( Chromatic.F, chromatic0 );
		assertEquals( Chromatic.C, chromatic1 );
		assertEquals( "F5 (IV5)", c.toString() );
	}

	@Test
	public void functions() {
		Tonality ton = Tonality.C;
		DiatonicChordMidi dcm = new DiatonicChordMidi( DiatonicFunction.I, ton );
		assertEquals( ChromaticChord.C, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.II, ton );
		assertEquals( ChromaticChord.Dm, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.III, ton );
		assertEquals( ChromaticChord.Em, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.IV, ton );
		assertEquals( ChromaticChord.F, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.V, ton );
		assertEquals( ChromaticChord.G, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.VI, ton );
		assertEquals( ChromaticChord.Am, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.VII, ton );
		assertEquals( ChromaticChord.Bdim, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( ChromaticFunction.IV5, ton );
		assertEquals( ChromaticChord.from(
				Arrays.asList( Chromatic.F, Chromatic.C )
		), ChromaticChordInterface.from(dcm) );

		ton = Tonality.FFm;
		dcm = new DiatonicChordMidi( DiatonicFunction.I, ton );
		assertEquals( ChromaticChord.FFm, ChromaticChordInterface.from(dcm) );

		assertEquals(
			DiatonicChord.from(Arrays.asList( Diatonic.D, Diatonic.F, Diatonic.A) ), DiatonicChord.from( DiatonicFunction.II )
		);

		assertEquals(
			ChromaticChord.GGdim, ChromaticChordInterface.from( DiatonicChord.from( DiatonicFunction.II ), Tonality.FFm )
		);
/*
		assertEquals(
			ChromaticChord.GGdim, new CustomDiatonicChord( DiatonicFunction.D ).toChromaticChord( Tonality.FFm ).toMidi().toChromaticChord()
		);*/
		assertEquals( Chromatic.GG, Tonality.FFm.getNote( DiatonicDegree.II ) );

		dcm = new DiatonicChordMidi( DiatonicFunction.II, ton );
		assertEquals( ChromaticChord.GGdim, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.III, ton );
		assertEquals( ChromaticChord.A, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.IV, ton );
		assertEquals( ChromaticChord.Bm, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.V, ton );
		assertEquals( ChromaticChord.CCm, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.VI, ton );
		assertEquals( ChromaticChord.D, ChromaticChordInterface.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.VII, ton );
		assertEquals( ChromaticChord.E, ChromaticChordInterface.from(dcm) );
	}

	@Test
	public void equals() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.C );
		DiatonicChordMidi c2 = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.C );
		assertEquals( c, c2 );

		c.setLength( Duration.V2 );
		assertNotEquals( c, c2 );
		c2.setLength( Duration.V2 );
		assertEquals( c, c2 );

		c.setOctave( 6 );
		assertNotEquals( c, c2 );
		c2.setOctave( 6 );
		assertEquals( c, c2 );

		c.setMinorScale();
		assertNotEquals( c, c2 );
		c2.setMinorScale();
		assertEquals( c, c2 );

		c.setVelocity( 50 );
		assertNotEquals( c, c2 );
		c2.setVelocity( 50 );
		assertEquals( c, c2 );

		c = new DiatonicChordMidi( Tonality.C );
		c2 = new DiatonicChordMidi( Tonality.C );
		c.add( ChromaticMidi.builder().pitch( PitchChromaticMidi.C5 ).build() );
		c.add( ChromaticMidi.builder().pitch( PitchChromaticMidi.E5 ).build() );
		c.add( ChromaticMidi.builder().pitch( PitchChromaticMidi.G5 ).build() );
		c2.add( ChromaticMidi.builder().pitch( PitchChromaticMidi.C5 ).build() );
		c2.add( ChromaticMidi.builder().pitch( PitchChromaticMidi.E5 ).build() );
		c2.add( ChromaticMidi.builder().pitch( PitchChromaticMidi.G5 ).build() );
		assertEquals( c, c2 );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.Am );
		c2 = new DiatonicChordMidi( DiatonicFunction.VI, 5, Tonality.C );
		assertNotEquals( c, c2 );
		assertEquals( ChromaticChordInterface.from(c), ChromaticChordInterface.from(c2) );
	}

	@Test
	public void toDiatonic() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.C );
		assertEquals( Duration.V1, c.get(0).getLength() );
		ChromaticChordMidi ccm = c.toChromaticChordMidi();
		assertEquals( Duration.V1, ccm.get(0).getLength() );
		assertEquals( c.get( 0 ).getLength(), ccm.get( 0 ).getLength() );
		assertEquals( Settings.DefaultValues.LENGTH_CHORD, c.get( 0 ).getLength() );
		assertEquals( c.get( 0 ).getLength(), c.get( 0 ).clone().getLength() );

		List<DiatonicChordMidi> chords = ccm.toDiatonicChordMidi( false );

		assertEquals( true, chords.size() > 0 );
		DiatonicChordMidi c2 = chords.get( 0 );
		assertEquals( Duration.V1, c2.get(0).getLength() );
		assertEquals( c.getArpegio(), c2.getArpegio() );
		assertEquals( c.getLength(), c2.getLength() );
		assertEquals( ChordNamer.from(c), ChordNamer.from(c2) );
		assertEquals( c.get( 0 ).getPitch(), c2.get( 0 ).getPitch() );
		assertEquals( c.get( 0 ).getDegree(), c2.get( 0 ).getDegree() );
		assertEquals( c.get( 0 ).getLength(), c.get( 0 ).clone().getLength() );
		assertEquals( c.get( 0 ).getLength(), c2.get( 0 ).getLength() );
		assertEquals( c.get( 0 ).getVelocity(), c2.get( 0 ).getVelocity() );
		assertEquals( c.get( 0 ), c2.get( 0 ) );
		assertEquals( c.get( 1 ), c2.get( 1 ) );
		assertEquals( c.get( 2 ), c2.get( 2 ) );

		assertEquals( c, c2 );
	}
}
