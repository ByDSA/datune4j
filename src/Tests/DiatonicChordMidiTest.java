package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import diatonic.ChromaticFunction;
import diatonic.DiatonicDegree;
import diatonic.DiatonicFunction;
import midi.Duration;
import midi.Settings;
import musical.Chromatic;
import musical.ChromaticChordEnum;
import musical.CustomChromaticChord;
import musical.CustomDiatonicChord;
import musical.Diatonic;
import pitch.ChromaticChordMidi;
import pitch.ChromaticMidi;
import pitch.DiatonicChordMidi;
import pitch.NoteMidi;
import tonality.ScaleEnum;
import tonality.Tonality;
import tonality.TonalityEnum;

public class DiatonicChordMidiTest {
	@Test
	public void chordConstructorPowerChords() {
		Tonality s = Tonality.of( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicChordMidi c;

		c = new DiatonicChordMidi( ChromaticFunction.I5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.C5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.G5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.II5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.D5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.A5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.III5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.E5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.B5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.IV5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.F5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.C6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.V5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.G5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.D6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VI5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.A5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.E6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VII5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.B5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.FF6, c.get( 1 ).getCode() );

		s = TonalityEnum.Cm;

		c = new DiatonicChordMidi( ChromaticFunction.I5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.C5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.G5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.II5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.D5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.A5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.III5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.DD5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.AA5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.IV5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.F5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.C6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.V5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.G5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.D6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VI5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.GG5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.DD6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VII5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( NoteMidi.AA5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.F6, c.get( 1 ).getCode() );
	}

	@Test
	public void constructorDiatonicFunc() {
		Tonality s =Tonality.of( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicChordMidi c;
		c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.C5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.E5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.G5, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.II, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.D5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.F5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.A5, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.III, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.E5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.G5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.B5, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.IV, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.F5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.A5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.C6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.V, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.G5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.B5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.D6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VI, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.A5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.C6, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.E6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VII, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.B5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.D6, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.F6, c.get( 2 ).getCode() );

		s = Tonality.of( Chromatic.FF, ScaleEnum.MINOR );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.FF5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.A5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.CC6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.II, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.GG5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.B5, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.D6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.III, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.A5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.CC6, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.E6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.IV, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.B5, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.D6, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.FF6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.V, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.CC6, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.E6, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.GG6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VI, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.D6, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.FF6, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.A6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VII, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( NoteMidi.E6, c.get( 0 ).getCode() );
		assertEquals( NoteMidi.GG6, c.get( 1 ).getCode() );
		assertEquals( NoteMidi.B6, c.get( 2 ).getCode() );
	}

	@Test
	public void duplicate() {
		DiatonicChordMidi ca = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C );
		DiatonicChordMidi ca2 = ca.clone();

		assertEquals( ca.getFunction(), ca2.getFunction() );

		assertEquals( ca.getMetatonality(), ca2.getMetatonality() );

		assertEquals( true, ca instanceof DiatonicChordMidi );
		assertEquals( true, ca2 instanceof DiatonicChordMidi );

		assertEquals( ca, ca2 );
	}

	@Test
	public void inv() {
		DiatonicChordMidi c = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C );
		c.inv();
		assertEquals( Chromatic.E, c.get( 0 ).getChromatic() );
		assertEquals( Chromatic.G, c.get( 1 ).getChromatic() );
		assertEquals( Chromatic.C, c.get( 2 ).getChromatic() );
		assertEquals( Chromatic.C, c.getRoot().getChromatic() );
		assertEquals( 2, c.getRootPos() );
	}

	@Test
	public void getRoot() {
		assertEquals(
			Chromatic.C, new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C ).getRoot().getChromatic()
		);
		DiatonicChordMidi c = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C );
		c.inv();
		assertEquals( 2, c.getRootPos() );
		assertEquals( Chromatic.C, c.getRoot().getChromatic() );

		c = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.F5 );
		assertEquals( 0, c.getRootPos() );
		assertEquals( Chromatic.F, c.getRoot().getChromatic() );

		c.inv();
		assertEquals( 1, c.getRootPos() );
		assertEquals( Chromatic.F, c.getRoot().getChromatic() );
	}

	@Test
	public void names() {
		assertEquals( "C", ChromaticChordEnum.C.toString() );

		DiatonicChordMidi dcm = new DiatonicChordMidi( DiatonicFunction.I, TonalityEnum.C );

		assertEquals( "C (I)", dcm.toString() );

		dcm = new DiatonicChordMidi( DiatonicFunction.I, TonalityEnum.Cm );
		assertEquals( "Cm (I)", dcm.toString() );
		dcm = new DiatonicChordMidi( DiatonicFunction.I, TonalityEnum.C );
		dcm.inv();
		
		assertEquals( "C/E (I)", dcm.toString() );
		dcm.inv();
		assertEquals( "C/G (I)", dcm.toString() );
		dcm.inv();
		assertEquals( "C (I)", dcm.toString() );

		dcm = new DiatonicChordMidi( ChromaticFunction.IV5, TonalityEnum.C );
		assertEquals( "F5 (IV5)", dcm.toString() );
		dcm.inv();
		assertEquals( "F5/C (IV5)", dcm.toString() );

		dcm = new DiatonicChordMidi( DiatonicFunction.I2, TonalityEnum.C );
		assertEquals( "Csus2 (I2)", dcm.toString() );
		dcm = new DiatonicChordMidi( DiatonicFunction.V4, TonalityEnum.C );
		assertEquals( "Gsus4 (V4)", dcm.toString() );
		dcm.inv();
		assertEquals( "Gsus4/C (V4)", dcm.toString() );

		CustomChromaticChord cc = CustomChromaticChord.copyOf( Chromatic.C, Chromatic.D, Chromatic.G );
		dcm = new DiatonicChordMidi( TonalityEnum.C, cc );
		assertEquals( "Csus2 (I2)", dcm.toString() );
	}

	@Test
	public void addChromatics() {
		DiatonicChordMidi dcm = new DiatonicChordMidi( TonalityEnum.C );
		assertEquals( TonalityEnum.C, dcm.getTonality() );
		assertEquals( 0, dcm.size() );
		ChromaticChordMidi ccm = ChromaticChordMidi.copyOf( ChromaticChordEnum.F5 );
		for ( ChromaticMidi cm : ccm )
			dcm.add( cm );
		assertEquals( 0, dcm.getRootPos() );
		assertEquals( Chromatic.F, dcm.get( 0 ).getChromatic() );
		assertEquals( Chromatic.C, dcm.get( 1 ).getChromatic() );
		assertEquals( TonalityEnum.C, dcm.getTonality() );
		assertEquals( "F5 (IV5)", dcm.toString() );
	}

	@Test
	public void addChromaticChord() {
		DiatonicChordMidi dcm = new DiatonicChordMidi( TonalityEnum.C );
		assertEquals( TonalityEnum.C, dcm.getTonality() );
		assertEquals( 0, dcm.size() );
		ChromaticChordMidi ccm = ChromaticChordMidi.copyOf( ChromaticChordEnum.F5 );
		dcm = new DiatonicChordMidi( TonalityEnum.C );
		dcm.add( ccm );
		assertNotEquals( 0, dcm.size() );
		assertEquals( 0, dcm.getRootPos() );
		assertEquals( Chromatic.F, dcm.get( 0 ).getChromatic() );
		assertEquals( Chromatic.C, dcm.get( 1 ).getChromatic() );
		assertEquals( TonalityEnum.C, dcm.getTonality() );
		assertEquals( "F5 (IV5)", dcm.toString() );
	}

	@Test
	public void chromaticChordToMidi() {
		DiatonicChordMidi c = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.F5 );
		assertEquals( 0, c.getRootPos() );
		assertEquals( Chromatic.F, c.get( 0 ).getChromatic() );
		assertEquals( Chromatic.C, c.get( 1 ).getChromatic() );
		assertEquals( "F5 (IV5)", c.toString() );
	}

	@Test
	public void functions() {
		Tonality ton = TonalityEnum.C;
		DiatonicChordMidi dcm = new DiatonicChordMidi( DiatonicFunction.I, ton );
		assertEquals( ChromaticChordEnum.C, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.II, ton );
		assertEquals( ChromaticChordEnum.Dm, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.III, ton );
		assertEquals( ChromaticChordEnum.Em, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.IV, ton );
		assertEquals( ChromaticChordEnum.F, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.V, ton );
		assertEquals( ChromaticChordEnum.G, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.VI, ton );
		assertEquals( ChromaticChordEnum.Am, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.VII, ton );
		assertEquals( ChromaticChordEnum.Bdim, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( ChromaticFunction.IV5, ton );
		assertEquals( CustomChromaticChord.copyOf( Chromatic.F, Chromatic.C ), dcm.toChromaticChord() );

		ton = TonalityEnum.FFm;
		dcm = new DiatonicChordMidi( DiatonicFunction.I, ton );
		assertEquals( ChromaticChordEnum.FFm, dcm.toChromaticChord() );

		assertEquals(
			new CustomDiatonicChord( Diatonic.II, Diatonic.IV, Diatonic.VI ), new CustomDiatonicChord( DiatonicFunction.II )
		);
		assertEquals(
			ChromaticChordEnum.GGdim, new CustomDiatonicChord( DiatonicFunction.II ).toChromaticChord( TonalityEnum.FFm )
		);
/*
		assertEquals(
			ChromaticChordEnum.GGdim, new CustomDiatonicChord( DiatonicFunction.II ).toChromaticChord( TonalityEnum.FFm ).toMidi().toChromaticChord()
		);*/
		assertEquals( Chromatic.GG, TonalityEnum.FFm.get( DiatonicDegree.II ) );

		dcm = new DiatonicChordMidi( DiatonicFunction.II, ton );
		assertEquals( ChromaticChordEnum.GGdim, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.III, ton );
		assertEquals( ChromaticChordEnum.A, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.IV, ton );
		assertEquals( ChromaticChordEnum.Bm, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.V, ton );
		assertEquals( ChromaticChordEnum.CCm, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.VI, ton );
		assertEquals( ChromaticChordEnum.D, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.VII, ton );
		assertEquals( ChromaticChordEnum.E, dcm.toChromaticChord() );
	}

	@Test
	public void equals() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, TonalityEnum.C );
		DiatonicChordMidi c2 = new DiatonicChordMidi( DiatonicFunction.I, 5, TonalityEnum.C );
		assertEquals( c, c2 );

		c.setLength( Duration.V2 );
		assertNotEquals( c, c2 );
		c2.setLength( Duration.V2 );
		assertEquals( c, c2 );

		c.setOctave( 6 );
		assertNotEquals( c, c2 );
		c2.setOctave( 6 );
		assertEquals( c, c2 );

		c.setScaleMinor();
		assertNotEquals( c, c2 );
		c2.setScaleMinor();
		assertEquals( c, c2 );

		c.setVelocity( 50 );
		assertNotEquals( c, c2 );
		c2.setVelocity( 50 );
		assertEquals( c, c2 );

		c = new DiatonicChordMidi( TonalityEnum.C );
		c2 = new DiatonicChordMidi( TonalityEnum.C );
		c.add( NoteMidi.C5.toMidi() );
		c.add( NoteMidi.E5.toMidi() );
		c.add( NoteMidi.G5.toMidi() );
		c2.add( NoteMidi.C5.toMidi() );
		c2.add( NoteMidi.E5.toMidi() );
		c2.add( NoteMidi.G5.toMidi() );
		assertEquals( c, c2 );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, TonalityEnum.Am );
		c2 = new DiatonicChordMidi( DiatonicFunction.VI, 5, TonalityEnum.C );
		assertNotEquals( c, c2 );
		assertEquals( c.toChromaticChord(), c2.toChromaticChord() );
	}

	@Test
	public void toDiatonic() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, TonalityEnum.C );
		assertEquals( Duration.V1, c.get(0).getLength() );
		ChromaticChordMidi ccm = c.toChromaticChordMidi();
		assertEquals( Duration.V1, ccm.get(0).getLength() );
		assertEquals( c.get( 0 ).getLength(), ccm.get( 0 ).getLength() );
		assertEquals( Settings.DefaultValues.DURATION_CHORD, c.get( 0 ).getLength() );
		assertEquals( c.get( 0 ).getLength(), c.get( 0 ).clone().getLength() );

		ArrayList<DiatonicChordMidi> chords = ccm.toDiatonicChordMidi( false );

		assertEquals( true, chords.size() > 0 );
		DiatonicChordMidi c2 = chords.get( 0 );
		assertEquals( Duration.V1, c2.get(0).getLength() );
		assertEquals( c.getArpegio(), c2.getArpegio() );
		assertEquals( c.getLength(), c2.getLength() );
		assertEquals( c.notesToString(), c2.notesToString() );
		assertEquals( c.get( 0 ).getCode(), c2.get( 0 ).getCode() );
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
