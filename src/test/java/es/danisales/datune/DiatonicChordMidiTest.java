package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.*;
import es.danisales.datune.musical.*;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DiatonicChordMidiTest {
	@Test
	public void chordConstructorPowerChords() {
		Tonality s = Tonality.of( Chromatic.C, Scale.MAJOR );
		DiatonicChordMidi c;

		c = new DiatonicChordMidi( ChromaticFunction.I5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.C5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.G5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.II5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.D5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.A5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.III5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.E5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.B5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.IV5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.F5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.C6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.V5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.G5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.D6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VI5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.A5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.E6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VII5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.B5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.FF6, c.get( 1 ).getCode() );

		s = TonalityEnum.Cm;

		c = new DiatonicChordMidi( ChromaticFunction.I5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.C5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.G5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.II5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.D5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.A5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.III5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.DD5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.AA5, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.IV5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.F5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.C6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.V5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.G5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.D6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VI5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.GG5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.DD6, c.get( 1 ).getCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VII5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( PitchMidi.AA5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.F6, c.get( 1 ).getCode() );
	}

	@Test
	public void constructorDiatonicFunc() {
		Tonality s =Tonality.of( Chromatic.C, Scale.MAJOR );
		DiatonicChordMidi c;
		c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.C5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.E5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.G5, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.II, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.D5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.F5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.A5, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.III, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.E5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.G5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.B5, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.IV, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.F5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.A5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.C6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.V, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.G5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.B5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.D6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VI, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.A5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.C6, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.E6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VII, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.B5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.D6, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.F6, c.get( 2 ).getCode() );

		s = Tonality.of( Chromatic.FF, Scale.MINOR );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.FF5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.A5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.CC6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.II, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.GG5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.B5, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.D6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.III, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.A5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.CC6, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.E6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.IV, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.B5, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.D6, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.FF6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.V, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.CC6, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.E6, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.GG6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VI, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.D6, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.FF6, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.A6, c.get( 2 ).getCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VII, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( PitchMidi.E6, c.get( 0 ).getCode() );
		assertEquals( PitchMidi.GG6, c.get( 1 ).getCode() );
		assertEquals( PitchMidi.B6, c.get( 2 ).getCode() );
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
		Chromatic chromatic0 = ChromaticAdapter.from( c.get( 0 ) );
		Chromatic chromatic1 = ChromaticAdapter.from( c.get( 1 ) );
		Chromatic chromatic2 = ChromaticAdapter.from( c.getRoot() );
		Chromatic chromaticRoot = ChromaticAdapter.from( c.get( 2 ) );
		assertEquals( Chromatic.E, chromatic0 );
		assertEquals( Chromatic.G, chromatic1 );
		assertEquals( Chromatic.C, chromatic2 );
		assertEquals( Chromatic.C, chromaticRoot );
		assertEquals( 2, c.getRootPos() );
	}

	@Test
	public void getRoot() {
		Chromatic chromatic = ChromaticAdapter.from( new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C ).getRoot() );
		assertEquals(Chromatic.C, chromatic);
		DiatonicChordMidi c = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C );
		c.inv();
		assertEquals( 2, c.getRootPos() );
		assertEquals( Chromatic.C, ChromaticAdapter.from( c.getRoot() ) );

		c = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.F5 );
		assertEquals( 0, c.getRootPos() );
		assertEquals( Chromatic.F, ChromaticAdapter.from( c.getRoot() ) );

		c.inv();
		assertEquals( 1, c.getRootPos() );
		assertEquals( Chromatic.F, ChromaticAdapter.from( c.getRoot() ) );
	}

	@Test
	public void names() {
		assertEquals( "C", ChromaticChordEnum.C.toString() );

		DiatonicChordMidi dcm = new DiatonicChordMidi( DiatonicFunction.I, TonalityEnum.C );

		assertEquals( "C (C)", dcm.toString() );

		dcm = new DiatonicChordMidi( DiatonicFunction.I, TonalityEnum.Cm );
		assertEquals( "Cm (C)", dcm.toString() );
		dcm = new DiatonicChordMidi( DiatonicFunction.I, TonalityEnum.C );
		dcm.inv();
		
		assertEquals( "C/E (C)", dcm.toString() );
		dcm.inv();
		assertEquals( "C/G (C)", dcm.toString() );
		dcm.inv();
		assertEquals( "C (C)", dcm.toString() );

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

		CustomChromaticChord cc = CustomChromaticChord.from( Chromatic.C, Chromatic.D, Chromatic.G );
		dcm = new DiatonicChordMidi( TonalityEnum.C, cc );
		assertEquals( "Csus2 (I2)", dcm.toString() );
	}

	@Test
	public void addChromatics() {
		DiatonicChordMidi dcm = new DiatonicChordMidi( TonalityEnum.C );
		assertEquals( TonalityEnum.C, dcm.getTonality() );
		assertEquals( 0, dcm.size() );
		ChromaticChordMidi ccm = ChromaticChordMidi.from( ChromaticChordEnum.F5 );
		for ( ChromaticMidi cm : ccm )
			dcm.add( cm );
		assertEquals( 0, dcm.getRootPos() );
		Chromatic chromatic0 = ChromaticAdapter.from( dcm.get( 0 ) );
		Chromatic chromatic1 = ChromaticAdapter.from( dcm.get( 1 ) );
		assertEquals( Chromatic.F, chromatic0 );
		assertEquals( Chromatic.C, chromatic1 );
		assertEquals( TonalityEnum.C, dcm.getTonality() );
		assertEquals( "F5 (IV5)", dcm.toString() );
	}

	@Test
	public void addChromaticChord() {
		DiatonicChordMidi dcm = new DiatonicChordMidi( TonalityEnum.C );
		assertEquals( TonalityEnum.C, dcm.getTonality() );
		assertEquals( 0, dcm.size() );
		ChromaticChordMidi ccm = ChromaticChordMidi.from( ChromaticChordEnum.F5 );
		dcm = new DiatonicChordMidi( TonalityEnum.C );
		dcm.add( ccm );
		assertNotEquals( 0, dcm.size() );
		assertEquals( 0, dcm.getRootPos() );
		Chromatic chromatic0 = ChromaticAdapter.from( dcm.get( 0 ) );
		Chromatic chromatic1 = ChromaticAdapter.from( dcm.get( 1 ) );
		assertEquals( Chromatic.F, chromatic0 );
		assertEquals( Chromatic.C, chromatic1 );
		assertEquals( TonalityEnum.C, dcm.getTonality() );
		assertEquals( "F5 (IV5)", dcm.toString() );
	}

	@Test
	public void chromaticChordToMidi() {
		DiatonicChordMidi c = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.F5 );
		assertEquals( 0, c.getRootPos() );
		Chromatic chromatic0 = ChromaticAdapter.from( c.get( 0 ) );
		Chromatic chromatic1 = ChromaticAdapter.from( c.get( 1 ) );
		assertEquals( Chromatic.F, chromatic0 );
		assertEquals( Chromatic.C, chromatic1 );
		assertEquals( "F5 (IV5)", c.toString() );
	}

	@Test
	public void functions() {
		Tonality ton = TonalityEnum.C;
		DiatonicChordMidi dcm = new DiatonicChordMidi( DiatonicFunction.I, ton );
		assertEquals( ChromaticChordEnum.C, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.II, ton );
		assertEquals( ChromaticChordEnum.Dm, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.III, ton );
		assertEquals( ChromaticChordEnum.Em, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.IV, ton );
		assertEquals( ChromaticChordEnum.F, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.V, ton );
		assertEquals( ChromaticChordEnum.G, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.VI, ton );
		assertEquals( ChromaticChordEnum.Am, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.VII, ton );
		assertEquals( ChromaticChordEnum.Bdim, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( ChromaticFunction.IV5, ton );
		assertEquals( CustomChromaticChord.from( Chromatic.F, Chromatic.C ), ChromaticChord.from(dcm) );

		ton = TonalityEnum.FFm;
		dcm = new DiatonicChordMidi( DiatonicFunction.I, ton );
		assertEquals( ChromaticChordEnum.FFm, ChromaticChord.from(dcm) );

		assertEquals(
			new CustomDiatonicChord( Diatonic.D, Diatonic.F, Diatonic.A), DiatonicChord.from( DiatonicFunction.II )
		);
		assertEquals(
			ChromaticChordEnum.GGdim, DiatonicChord.from( DiatonicFunction.II ).toChromaticChord( TonalityEnum.FFm )
		);
/*
		assertEquals(
			ChromaticChordEnum.GGdim, new CustomDiatonicChord( DiatonicFunction.D ).toChromaticChord( TonalityEnum.FFm ).toMidi().toChromaticChord()
		);*/
		assertEquals( Chromatic.GG, TonalityEnum.FFm.getNote( DiatonicDegree.II ) );

		dcm = new DiatonicChordMidi( DiatonicFunction.II, ton );
		assertEquals( ChromaticChordEnum.GGdim, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.III, ton );
		assertEquals( ChromaticChordEnum.A, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.IV, ton );
		assertEquals( ChromaticChordEnum.Bm, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.V, ton );
		assertEquals( ChromaticChordEnum.CCm, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.VI, ton );
		assertEquals( ChromaticChordEnum.D, ChromaticChord.from(dcm) );

		dcm = new DiatonicChordMidi( DiatonicFunction.VII, ton );
		assertEquals( ChromaticChordEnum.E, ChromaticChord.from(dcm) );
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
		c.add( PitchMidi.C5.toMidi() );
		c.add( PitchMidi.E5.toMidi() );
		c.add( PitchMidi.G5.toMidi() );
		c2.add( PitchMidi.C5.toMidi() );
		c2.add( PitchMidi.E5.toMidi() );
		c2.add( PitchMidi.G5.toMidi() );
		assertEquals( c, c2 );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, TonalityEnum.Am );
		c2 = new DiatonicChordMidi( DiatonicFunction.VI, 5, TonalityEnum.C );
		assertNotEquals( c, c2 );
		assertEquals( ChromaticChord.from(c), ChromaticChord.from(c2) );
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

		List<DiatonicChordMidi> chords = ccm.toDiatonicChordMidi( false );

		assertEquals( true, chords.size() > 0 );
		DiatonicChordMidi c2 = chords.get( 0 );
		assertEquals( Duration.V1, c2.get(0).getLength() );
		assertEquals( c.getArpegio(), c2.getArpegio() );
		assertEquals( c.getDuration(), c2.getDuration() );
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
