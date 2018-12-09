package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import diatonic.ChromaticFunction;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.ScaleEnum;
import diatonic.Tonality;
import midi.Duration;
import midi.Settings;
import pitch.Chromatic;
import pitch.ChromaticChord;
import pitch.ChromaticChordMidi;
import pitch.ChromaticMidi;
import pitch.Diatonic;
import pitch.DiatonicChord;
import pitch.DiatonicChordMidi;
import pitch.Pitch;

public class DiatonicChordMidiTest {
	@Test
	public void chordConstructorPowerChords() {
		Tonality s = new Tonality( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicChordMidi c;

		c = new DiatonicChordMidi( ChromaticFunction.I5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.C5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.G5, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.II5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.D5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.A5, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.III5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.E5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.B5, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.IV5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.F5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.C6, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.V5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.G5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.D6, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VI5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.A5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.E6, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VII5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.B5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.FF6, c.get( 1 ).getPitchCode() );

		s = Tonality.Cm;

		c = new DiatonicChordMidi( ChromaticFunction.I5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.C5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.G5, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.II5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.D5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.A5, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.III5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.DD5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.AA5, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.IV5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.F5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.C6, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.V5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.G5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.D6, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VI5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.GG5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.DD6, c.get( 1 ).getPitchCode() );

		c = new DiatonicChordMidi( ChromaticFunction.VII5, 5, s );
		assertEquals( 2, c.size() );
		assertEquals( Pitch.AA5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.F6, c.get( 1 ).getPitchCode() );
	}

	@Test
	public void constructorDiatonicFunc() {
		Tonality s = new Tonality( Chromatic.C, ScaleEnum.MAJOR );
		DiatonicChordMidi c;
		c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.C5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.E5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.G5, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.II, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.D5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.F5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.A5, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.III, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.E5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.G5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.B5, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.IV, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.F5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.A5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.C6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.V, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.G5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.B5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.D6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VI, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.A5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.C6, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.E6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VII, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.B5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.D6, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.F6, c.get( 2 ).getPitchCode() );

		s = new Tonality( Chromatic.FF, ScaleEnum.MINOR );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.FF5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.A5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.CC6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.II, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.GG5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.B5, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.D6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.III, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.A5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.CC6, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.E6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.IV, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.B5, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.D6, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.FF6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.V, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.CC6, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.E6, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.GG6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VI, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.D6, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.FF6, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.A6, c.get( 2 ).getPitchCode() );

		c = new DiatonicChordMidi( DiatonicFunction.VII, 5, s );
		assertEquals( 3, c.size() );
		assertEquals( Pitch.E6, c.get( 0 ).getPitchCode() );
		assertEquals( Pitch.GG6, c.get( 1 ).getPitchCode() );
		assertEquals( Pitch.B6, c.get( 2 ).getPitchCode() );
	}

	@Test
	public void duplicate() {
		DiatonicChordMidi ca = new DiatonicChordMidi( Tonality.C, ChromaticChord.C );
		DiatonicChordMidi ca2 = ca.duplicate();

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
		assertEquals( Chromatic.E, c.get( 0 ).getChromatic() );
		assertEquals( Chromatic.G, c.get( 1 ).getChromatic() );
		assertEquals( Chromatic.C, c.get( 2 ).getChromatic() );
		assertEquals( Chromatic.C, c.getRoot().getChromatic() );
		assertEquals( 2, c.getRootPos() );
	}

	@Test
	public void getRoot() {
		assertEquals(
			Chromatic.C, new DiatonicChordMidi( Tonality.C, ChromaticChord.C ).getRoot().getChromatic()
		);
		DiatonicChordMidi c = new DiatonicChordMidi( Tonality.C, ChromaticChord.C );
		c.inv();
		assertEquals( 2, c.getRootPos() );
		assertEquals( Chromatic.C, c.getRoot().getChromatic() );

		c = new DiatonicChordMidi( Tonality.C, ChromaticChord.F5 );
		assertEquals( 0, c.getRootPos() );
		assertEquals( Chromatic.F, c.getRoot().getChromatic() );

		c.inv();
		assertEquals( 1, c.getRootPos() );
		assertEquals( Chromatic.F, c.getRoot().getChromatic() );
	}

	@Test
	public void names() {
		assertEquals( "C", ChromaticChord.C.toString() );

		DiatonicChordMidi dcm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.C );

		assertEquals( "C (I)", dcm.toString() );

		dcm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.Cm );
		assertEquals( "Cm (I)", dcm.toString() );
		dcm = new DiatonicChordMidi( DiatonicFunction.I, Tonality.C );
		dcm.inv();
		dcm.show();
		ChromaticChord.E.show();
		ChromaticChord.E.showNotes();
		dcm.meta.show();
		dcm.meta.showNotes();
		
		assertEquals( "C/E (I)", dcm.toString() );
		dcm.inv();
		assertEquals( "C/G (I)", dcm.toString() );
		dcm.inv();
		assertEquals( "C (I)", dcm.toString() );

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

		ChromaticChord cc = new ChromaticChord( Chromatic.C, Chromatic.D, Chromatic.G );
		dcm = new DiatonicChordMidi( Tonality.C, cc );
		assertEquals( "Csus2 (I2)", dcm.toString() );
	}

	@Test
	public void addChromatics() {
		DiatonicChordMidi dcm = new DiatonicChordMidi( Tonality.C );
		assertEquals( Tonality.C, dcm.getTonality() );
		assertEquals( 0, dcm.size() );
		ChromaticChordMidi ccm = new ChromaticChordMidi( ChromaticChord.F5 );
		for ( ChromaticMidi cm : ccm )
			dcm.add( cm );
		assertEquals( 0, dcm.getRootPos() );
		assertEquals( Chromatic.F, dcm.get( 0 ).getChromatic() );
		assertEquals( Chromatic.C, dcm.get( 1 ).getChromatic() );
		assertEquals( Tonality.C, dcm.getTonality() );
		assertEquals( "F5 (IV5)", dcm.toString() );
	}

	@Test
	public void addChromaticChord() {
		DiatonicChordMidi dcm = new DiatonicChordMidi( Tonality.C );
		assertEquals( Tonality.C, dcm.getTonality() );
		assertEquals( 0, dcm.size() );
		ChromaticChordMidi ccm = new ChromaticChordMidi( ChromaticChord.F5 );
		dcm = new DiatonicChordMidi( Tonality.C );
		dcm.add( ccm );
		assertEquals( 0, dcm.getRootPos() );
		assertEquals( Chromatic.F, dcm.get( 0 ).getChromatic() );
		assertEquals( Chromatic.C, dcm.get( 1 ).getChromatic() );
		assertEquals( Tonality.C, dcm.getTonality() );
		assertEquals( "F5 (IV5)", dcm.toString() );
	}

	@Test
	public void chromaticChordToMidi() {
		DiatonicChordMidi c = new DiatonicChordMidi( Tonality.C, ChromaticChord.F5 );
		assertEquals( 0, c.getRootPos() );
		assertEquals( Chromatic.F, c.get( 0 ).getChromatic() );
		assertEquals( Chromatic.C, c.get( 1 ).getChromatic() );
		assertEquals( "F5 (IV5)", c.toString() );
	}

	@Test
	public void functions() {
		Tonality ton = Tonality.C;
		DiatonicChordMidi dcm = new DiatonicChordMidi( DiatonicFunction.I, ton );
		assertEquals( ChromaticChord.C, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.II, ton );
		assertEquals( ChromaticChord.Dm, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.III, ton );
		assertEquals( ChromaticChord.Em, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.IV, ton );
		assertEquals( ChromaticChord.F, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.V, ton );
		assertEquals( ChromaticChord.G, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.VI, ton );
		assertEquals( ChromaticChord.Am, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.VII, ton );
		assertEquals( ChromaticChord.Bdim, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( ChromaticFunction.IV5, ton );
		assertEquals( new ChromaticChord( Chromatic.F, Chromatic.C ), dcm.toChromaticChord() );

		ton = Tonality.FFm;
		dcm = new DiatonicChordMidi( DiatonicFunction.I, ton );
		assertEquals( ChromaticChord.FFm, dcm.toChromaticChord() );

		assertEquals(
			new DiatonicChord( Diatonic.II, Diatonic.IV, Diatonic.VI ), new DiatonicChord( DiatonicFunction.II )
		);
		assertEquals(
			ChromaticChord.GGdim, new DiatonicChord( DiatonicFunction.II ).toChromatic( Tonality.FFm )
		);

		assertEquals(
			ChromaticChord.GGdim, new DiatonicChord( DiatonicFunction.II ).toChromatic( Tonality.FFm ).toMidi().toChromaticChord()
		);
		assertEquals( Chromatic.GG, Tonality.FFm.get( Degree.II ) );

		dcm = new DiatonicChordMidi( DiatonicFunction.II, ton );
		assertEquals( ChromaticChord.GGdim, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.III, ton );
		assertEquals( ChromaticChord.A, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.IV, ton );
		assertEquals( ChromaticChord.Bm, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.V, ton );
		assertEquals( ChromaticChord.CCm, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.VI, ton );
		assertEquals( ChromaticChord.D, dcm.toChromaticChord() );

		dcm = new DiatonicChordMidi( DiatonicFunction.VII, ton );
		assertEquals( ChromaticChord.E, dcm.toChromaticChord() );
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

		c.setScaleMinor();
		assertNotEquals( c, c2 );
		c2.setScaleMinor();
		assertEquals( c, c2 );

		c.setVelocity( 50 );
		assertNotEquals( c, c2 );
		c2.setVelocity( 50 );
		assertEquals( c, c2 );

		c = new DiatonicChordMidi( Tonality.C );
		c2 = new DiatonicChordMidi( Tonality.C );
		c.add( Pitch.C5.toMidi() );
		c.add( Pitch.E5.toMidi() );
		c.add( Pitch.G5.toMidi() );
		c2.add( Pitch.C5.toMidi() );
		c2.add( Pitch.E5.toMidi() );
		c2.add( Pitch.G5.toMidi() );
		assertEquals( c, c2 );

		c = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.Am );
		c2 = new DiatonicChordMidi( DiatonicFunction.VI, 5, Tonality.C );
		assertNotEquals( c, c2 );
		assertEquals( c.toChromaticChord(), c2.toChromaticChord() );
	}

	@Test
	public void toDiatonic() {
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, Tonality.C );
		assertEquals( Duration.V1, c.get(0).getLength() );
		ChromaticChordMidi ccm = c.toChromaticChordMidi();
		assertEquals( Duration.V1, ccm.get(0).getLength() );
		assertEquals( c.get( 0 ).getLength(), ccm.get( 0 ).getLength() );
		assertEquals( Settings.DefaultValues.DURATION_CHORD, c.get( 0 ).getLength() );
		assertEquals( c.get( 0 ).getLength(), c.get( 0 ).duplicate( true ).getLength() );

		ArrayList<DiatonicChordMidi> chords = ccm.toDiatonicChordMidi( false );

		assertEquals( true, chords.size() > 0 );
		DiatonicChordMidi c2 = chords.get( 0 );
		assertEquals( Duration.V1, c2.get(0).getLength() );
		assertEquals( c.getArpegio(), c2.getArpegio() );
		assertEquals( c.getLength(), c2.getLength() );
		assertEquals( c.notesToString(), c2.notesToString() );
		assertEquals( c.get( 0 ).getPitchMean(), c2.get( 0 ).getPitchMean(), 0 );
		assertEquals( c.get( 0 ).getPitchCode(), c2.get( 0 ).getPitchCode() );
		assertEquals( c.get( 0 ).getDegree(), c2.get( 0 ).getDegree() );
		assertEquals( c.get( 0 ).getLength(), c.get( 0 ).duplicate( true ).getLength() );
		assertEquals( c.get( 0 ).getLength(), c2.get( 0 ).getLength() );
		assertEquals( c.get( 0 ).getVelocity(), c2.get( 0 ).getVelocity() );
		assertEquals( c.get( 0 ), c2.get( 0 ) );
		assertEquals( c.get( 1 ), c2.get( 1 ) );
		assertEquals( c.get( 2 ), c2.get( 2 ) );

		assertEquals( c, c2 );
	}
}
