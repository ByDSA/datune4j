package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.CustomTonality;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityChordRetrieval;
import es.danisales.datune.tonality.TonalityEnum;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TonalityTest {
	@Test
	public void notes2tonality() {
		Tonality s = TonalityEnum.A;
		DiatonicAlt[] notes = new DiatonicAlt[7];
		for ( int i = 0; i < 7; i++ )
			notes[i] = s.getNote( i );

		assertEquals( s.getScale(), TonalityEnum.notes2scale( notes ) );
	}

	@Test
	public void getAlterations() {
		assertEquals( (Integer) 0, TonalityEnum.C.getAlteration() );
		assertEquals( (Integer) 5, TonalityEnum.Db.getAlteration() );
		assertEquals( (Integer) 2, TonalityEnum.D.getAlteration() );
		assertEquals( (Integer) 3, TonalityEnum.Eb.getAlteration() );
		assertEquals( (Integer) 4, TonalityEnum.E.getAlteration() );
		assertEquals( (Integer) 3, TonalityEnum.Cm.getAlteration() );
	}

	@Test
	public void _clone() {
		for ( Tonality t : TonalityEnum.values() ) {
			assertTrue(t.hasSameRootAs(Tonality.of(t)));
			assertTrue(t.hasSameScaleAs(Tonality.of(t)));
			assertTrue(t.hasSameNotesAs(Tonality.of(t)));
			assertTrue(t.equals(Tonality.of(t)));
		}

		assertFalse(TonalityEnum.FF.equals(TonalityEnum.Gb));
	}

	@Test
	public void minimizeAlterations() {
		for ( final CustomTonality t : CustomTonality.all() ) {
			CustomTonality t2 = t.clone();
			int alt = t2.getAlteration();
			ArrayList<CustomTonality> out = t2.minimizeAlterations();

			assertTrue(t2.getAlteration() <= alt);
		}
	}

	@Test
	public void updateChromaticsFromBase() {
		Tonality t = TonalityEnum.Gb;
		assertEquals( DiatonicAlt.Gb, t.getRoot() );
		t.updateChromaticsFromBase( DiatonicAlt.FF );
		assertEquals( DiatonicAlt.FF, t.getRoot() );
	}

	@Test
	public void whichGetsChord() {
		List<CustomTonality> ts = CustomTonality.getFromChord( false, ChromaticChordEnum.C );
		assertTrue(ts.size() > 0);
	}

	@Test
	public void whichGetsChordOutScale() {
		List<CustomTonality> ts = CustomTonality.getFromChord( true, ChromaticChordEnum.C );
		assertTrue(ts.size() > 0);
	}

	@Test
	public void getChordFunction() {
		Tonality ton = TonalityEnum.E;
		PitchChromaticChord cc = ChromaticChord.from(ton, DiatonicFunction.I );

		assertEquals( ChromaticChordEnum.E, cc );
		cc = ChromaticChord.from(ton, DiatonicFunction.VII );

		assertEquals( ChromaticChordEnum.DDdim, cc );

		ton = TonalityEnum.Em;
		cc = ChromaticChord.from(ton, DiatonicFunction.I );

		assertEquals( ChromaticChordEnum.Em, cc );
		cc = ChromaticChord.from(ton, DiatonicFunction.VII );

		assertEquals( ChromaticChordEnum.D, cc );

		ton = TonalityEnum.C;
		cc = ChromaticChord.from(ton, DiatonicFunction.V7 );

		assertEquals( ChromaticChordEnum.G7, cc );
	}

	@Test
	public void getTriadSeventhChords() {
		Tonality t = TonalityEnum.C;

		assertEquals(
				Arrays.asList(
						ChromaticChordEnum.C,
						ChromaticChordEnum.Dm,
						ChromaticChordEnum.Em,
						ChromaticChordEnum.F,
						ChromaticChordEnum.G,
						ChromaticChordEnum.Am,
						ChromaticChordEnum.Bdim

				), TonalityChordRetrieval.getTriadChordsFrom(t)
		);

		assertEquals(
				Arrays.asList(
						ChromaticChordEnum.CMaj7,
						ChromaticChordEnum.Dm7,
						ChromaticChordEnum.Em7,
						ChromaticChordEnum.FMaj7,
						ChromaticChordEnum.G7,
						ChromaticChordEnum.Am7,
						ChromaticChordEnum.Bm7b5

				), TonalityChordRetrieval.getTriadChordsFrom(t)
		);

		t = TonalityEnum.Am;

		assertEquals(
				Arrays.asList(
						ChromaticChordEnum.Am,
						ChromaticChordEnum.Bdim,
						ChromaticChordEnum.C,
						ChromaticChordEnum.Dm,
						ChromaticChordEnum.Em,
						ChromaticChordEnum.F,
						ChromaticChordEnum.G
				), TonalityChordRetrieval.getTriadChordsFrom(t)
		);

		assertEquals(
				Arrays.asList(
						ChromaticChordEnum.Am7,
						ChromaticChordEnum.Bm7b5,
						ChromaticChordEnum.CMaj7,
						ChromaticChordEnum.Dm7,
						ChromaticChordEnum.Em7,
						ChromaticChordEnum.FMaj7,
						ChromaticChordEnum.G7
				), TonalityChordRetrieval.getTriadChordsFrom(t)
		);
	}

	@Test
	public void getAllChords() {
		Tonality t = TonalityEnum.C;
		Set<ChromaticChord> cs = t.getScaleChords();
		assertEquals( 49, DiatonicFunction.COMMON.length );
		assertEquals( 49, cs.size() );

		cs = t.getBorrowedChords();
		assertEquals( 42, cs.size() );
		cs = t.getOutScaleChords();
		int i = 1;
		for (ChromaticChord c : cs) {
			System.out.println( t.getFunction( c )  + ": " + c);
		}
		assertEquals( 25, ChromaticFunction.ALL.length );
		assertEquals( 25, cs.size() );

		List<ChromaticChord> ccs = t.getAllChords( );
		assertEquals( 116, ccs.size() );
	}

	@Test
	public void has() {
		TonalityEnum ton = TonalityEnum.C;

		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.C ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Dm ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Em ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.F ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.G ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Am ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Bdim ) );

		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Csus2 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Dsus2 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Esusb2 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Fsus2 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Gsus2 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Asus2 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Bsusb2b5 ) );

		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Csus4 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Dsus4 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Esus4 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Fsusa4 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Gsus4 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Asus4 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.Bsusa4 ) );

		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.C6 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Dm6 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.Em6 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.F6 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.G6 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.Am6 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.B6 ) );

		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.CMaj7 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Dm7 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Em7 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.F7 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.G7 ) );
		assertEquals( true, ton.hasEnharmonic( ChromaticChordEnum.Am7 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.B7 ) );
		/*
		 * assertEquals( true, ton.has( ChromaticChord.C9 ) ); assertEquals( true,
		 * ton.has( ChromaticChord.D9 ) ); assertEquals( true, ton.has(
		 * ChromaticChord.E9 ) ); assertEquals( true, ton.has( ChromaticChord.F9 ) );
		 * assertEquals( true, ton.has( ChromaticChord.G9 ) ); assertEquals( true,
		 * ton.has( ChromaticChord.A9 ) ); assertEquals( true, ton.has(
		 * ChromaticChord.B9 ) );
		 *
		 * assertEquals( true, ton.has( ChromaticChord.C11 ) ); assertEquals( true,
		 * ton.has( ChromaticChord.D11 ) ); assertEquals( true, ton.has(
		 * ChromaticChord.E11 ) ); assertEquals( true, ton.has( ChromaticChord.F11 ) );
		 * assertEquals( true, ton.has( ChromaticChord.G11 ) ); assertEquals( true,
		 * ton.has( ChromaticChord.A11 ) ); assertEquals( true, ton.has(
		 * ChromaticChord.B11 ) );
		 */

		for ( ChromaticChord c : ton.getScaleChords() ) {
			/*c.show();
			c.showNotes();*/
			assertTrue(ton.hasEnharmonic(c));
		}

		for ( DiatonicFunction df : DiatonicFunction.COMMON )
			assertTrue(ton.has(ChromaticChord.from(ton, df)));

		ton = TonalityEnum.Db;
		for ( ChromaticChord c : ton.getScaleChords() )
			assertTrue(ton.hasEnharmonic(c));

		for ( DiatonicFunction df : DiatonicFunction.COMMON )
			assertTrue(ton.has(ChromaticChord.from(ton, df)));
	}

	@Test
	public void getDegree() {
		Tonality ton = TonalityEnum.C;

		assertEquals( DiatonicDegree.I, ton.getDegreeFrom( PitchMidi.C5.getChromatic() ) );
		assertEquals( DiatonicDegree.II, ton.getDegreeFrom( PitchMidi.D5.getChromatic() ) );
		assertEquals( DiatonicDegree.III, ton.getDegreeFrom( PitchMidi.E6.getChromatic() ) );
		assertEquals( DiatonicDegree.IV, ton.getDegreeFrom( Chromatic.F ) );
		assertNull(ton.getDegreeFrom(DiatonicAlt.EEEE));
		assertEquals( DiatonicDegree.V, ton.getDegreeFrom( DiatonicAlt.EEEE ) );
	}

	@Test
	public void get() {
		Tonality ton = TonalityEnum.C;
		assertEquals( ChromaticChordEnum.C, ChromaticChord.from( ton, DiatonicFunction.I ) );
		assertEquals( ChromaticChordEnum.Dm, ChromaticChord.from( ton, DiatonicFunction.II ) );
		assertEquals( ChromaticChordEnum.Em, ChromaticChord.from( ton, DiatonicFunction.III ) );
		assertEquals( ChromaticChordEnum.F, ChromaticChord.from( ton, DiatonicFunction.IV ) );
		assertEquals( ChromaticChordEnum.G, ChromaticChord.from( ton, DiatonicFunction.V ) );
		assertEquals( ChromaticChordEnum.Am, ChromaticChord.from( ton, DiatonicFunction.VI ) );
		assertEquals( ChromaticChordEnum.Bdim, ChromaticChord.from( ton, DiatonicFunction.VII ) );

		assertEquals( ChromaticChordEnum.Csus2, ChromaticChord.from( ton, DiatonicFunction.I2 ) );
		assertEquals( ChromaticChordEnum.Dsus2, ChromaticChord.from( ton, DiatonicFunction.II2 ) );
		// assertEquals( DiatonicFunction.III2, ChromaticChord.from( ton, ChromaticChord.Em ) );
		assertEquals( ChromaticChordEnum.Fsus2, ChromaticChord.from( ton, DiatonicFunction.IV2 ) );
		assertEquals( ChromaticChordEnum.Gsus2, ChromaticChord.from( ton, DiatonicFunction.V2 ) );
		assertEquals( ChromaticChordEnum.Asus2, ChromaticChord.from( ton, DiatonicFunction.VI2 ) );
		// assertEquals( DiatonicFunction.VII2, ChromaticChord.from( ton, ChromaticChord.Bdim ) );

		assertEquals( ChromaticChordEnum.Csus4, ChromaticChord.from( ton, DiatonicFunction.I4 ) );
		assertEquals( ChromaticChordEnum.Dsus4, ChromaticChord.from( ton, DiatonicFunction.II4 ) );
		assertEquals( ChromaticChordEnum.Esus4, ChromaticChord.from( ton, DiatonicFunction.III4 ) );
		// assertEquals( DiatonicFunction.IV4, ChromaticChord.from( ton, ChromaticChord.F ) );
		assertEquals( ChromaticChordEnum.Gsus4, ChromaticChord.from( ton, DiatonicFunction.V4 ) );
		assertEquals( ChromaticChordEnum.Asus4, ChromaticChord.from( ton, DiatonicFunction.VI4 ) );
		// assertEquals( DiatonicFunction.VII4, ChromaticChord.from( ton, ChromaticChord.Bdim ) );

		assertEquals( ChromaticChordEnum.C6, ChromaticChord.from( ton, DiatonicFunction.I6 ) );
		assertEquals( ChromaticChordEnum.Dm6, ChromaticChord.from( ton, DiatonicFunction.II6 ) );
		// assertEquals( DiatonicFunction.III6, ChromaticChord.from( ton, ChromaticChord.Em ) );
		assertEquals( ChromaticChordEnum.F6, ChromaticChord.from( ton, DiatonicFunction.IV6 ) );
		assertEquals( ChromaticChordEnum.G6, ChromaticChord.from( ton, DiatonicFunction.V6 ) );
		// assertEquals( DiatonicFunction.VI6, ChromaticChord.from( ton, ChromaticChord.Am ) );
		// assertEquals( DiatonicFunction.VII6, ChromaticChord.from( ton, ChromaticChord.Bdim ) );

		assertEquals( ChromaticChordEnum.CMaj7, ChromaticChord.from( ton, DiatonicFunction.I7 ) );
		assertEquals( ChromaticChordEnum.Dm7, ChromaticChord.from( ton, DiatonicFunction.II7 ) );
		assertEquals( ChromaticChordEnum.Em7, ChromaticChord.from( ton, DiatonicFunction.III7 ) );
		assertEquals( ChromaticChordEnum.FMaj7, ChromaticChord.from( ton, DiatonicFunction.IV7 ) );
		assertEquals( ChromaticChordEnum.G7, ChromaticChord.from( ton, DiatonicFunction.V7 ) );
		assertEquals( ChromaticChordEnum.Am7, ChromaticChord.from( ton, DiatonicFunction.VI7 ) );
		assertEquals( ChromaticChordEnum.Bm7b5, ChromaticChord.from( ton, DiatonicFunction.VII7 ) );

		assertEquals( ChromaticChordEnum.C5, ChromaticChord.from( ton, ChromaticFunction.I5 ) );
		assertEquals( ChromaticChordEnum.D5, ChromaticChord.from( ton, ChromaticFunction.II5 ) );
		assertEquals( ChromaticChordEnum.E5, ChromaticChord.from( ton, ChromaticFunction.III5 ) );
		assertEquals( ChromaticChordEnum.F5, ChromaticChord.from( ton, ChromaticFunction.IV5 ) );
		assertEquals( ChromaticChordEnum.G5, ChromaticChord.from( ton, ChromaticFunction.V5 ) );
		assertEquals( ChromaticChordEnum.A5, ChromaticChord.from( ton, ChromaticFunction.VI5 ) );
		assertEquals( ChromaticChordEnum.B5, ChromaticChord.from( ton, ChromaticFunction.VII5 ) );

		assertEquals( ChromaticChordEnum.A, ChromaticChord.from( ton, ChromaticFunction.V_II ) );
		assertEquals( ChromaticChordEnum.B, ChromaticChord.from( ton, ChromaticFunction.V_III ) );
		assertEquals( ChromaticChordEnum.C, ChromaticChord.from( ton, ChromaticFunction.V_IV ) );
		assertEquals( ChromaticChord.from( ton, DiatonicFunction.I ), ChromaticChord.from( ton, ChromaticFunction.V_IV ) );
		assertEquals( ChromaticChordEnum.D, ChromaticChord.from( ton, ChromaticFunction.V_V ) );
		assertEquals( ChromaticChordEnum.E, ChromaticChord.from( ton, ChromaticFunction.V_VI ) );

		assertEquals( ChromaticChordEnum.A7, ChromaticChord.from( ton, ChromaticFunction.V7_II ) );
		assertEquals( ChromaticChordEnum.B7, ChromaticChord.from( ton, ChromaticFunction.V7_III ) );
		assertTrue(ChromaticChord.from(ton, ChromaticFunction.V7_IV).equalsEnharmonic(ChromaticChordEnum.C7));
		assertEquals( ChromaticChordEnum.D7, ChromaticChord.from( ton, ChromaticFunction.V7_V ) );
		assertEquals( ChromaticChordEnum.E7, ChromaticChord.from( ton, ChromaticFunction.V7_VI ) );

		assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7).equalsEnharmonic(ChromaticChordEnum.CC7));

		assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_II).equalsEnharmonic(ChromaticChordEnum.DD7));

		assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_III).equalsEnharmonic(ChromaticChordEnum.F7));

		assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_IV).equalsEnharmonic(ChromaticChordEnum.FF7));

		assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_V).equalsEnharmonic(ChromaticChordEnum.GG7));

		assertTrue(ChromaticChord.from(ton, ChromaticFunction.SUBV7_VI).equalsEnharmonic(ChromaticChordEnum.AA7));

		assertEquals(
				ChromaticChordEnum.CC.getInv(), ChromaticChord.from( ton,  ChromaticFunction.N6 )
		);

		// TODO:
		// V7ALT

		ton = TonalityEnum.Cm;

		assertTrue(ChromaticChord.from(ton, DiatonicFunction.VII7).equalsEnharmonic(ChromaticChordEnum.AA7));

		ton = TonalityEnum.Db;
		assertTrue(ChromaticChord.from(ton, DiatonicFunction.II).equalsEnharmonic(ChromaticChordEnum.DDm));
	}

	@Test
	public void getFunction() {
		Tonality ton = TonalityEnum.C;
		assertEquals( DiatonicFunction.I, ton.getFunction( ChromaticChordEnum.C ) );
		assertEquals( DiatonicFunction.II, ton.getFunction( ChromaticChordEnum.Dm ) );
		assertEquals( DiatonicFunction.III, ton.getFunction( ChromaticChordEnum.Em ) );
		assertEquals( DiatonicFunction.IV, ton.getFunction( ChromaticChordEnum.F ) );
		assertEquals( DiatonicFunction.V, ton.getFunction( ChromaticChordEnum.G ) );
		assertEquals( DiatonicFunction.VI, ton.getFunction( ChromaticChordEnum.Am ) );
		assertEquals( DiatonicFunction.VII, ton.getFunction( ChromaticChordEnum.Bdim ) );

		assertEquals( ChromaticChordEnum.Csus2, ChromaticChord.from( ton,  DiatonicFunction.I2 ) );
		assertEquals( DiatonicFunction.I2, ton.getFunction( ChromaticChordEnum.Csus2 ) );
		assertEquals( DiatonicFunction.II2, ton.getFunction( ChromaticChordEnum.Dsus2 ) );
		// assertEquals( DiatonicFunction.III2, ton.getFunction( ChromaticChord.Em ) );
		assertEquals( DiatonicFunction.IV2, ton.getFunction( ChromaticChordEnum.Fsus2 ) );
		assertEquals( DiatonicFunction.V2, ton.getFunction( ChromaticChordEnum.Gsus2 ) );
		assertEquals( DiatonicFunction.VI2, ton.getFunction( ChromaticChordEnum.Asus2 ) );
		// assertEquals( DiatonicFunction.VII2, ton.getFunction( ChromaticChord.Bdim )
		// );

		assertEquals( DiatonicFunction.I4, ton.getFunction( ChromaticChordEnum.Csus4 ) );
		assertEquals( DiatonicFunction.II4, ton.getFunction( ChromaticChordEnum.Dsus4 ) );
		assertEquals( DiatonicFunction.III4, ton.getFunction( ChromaticChordEnum.Esus4 ) );
		// assertEquals( DiatonicFunction.IV4, ton.getFunction( ChromaticChord.F ) );
		assertEquals( DiatonicFunction.V4, ton.getFunction( ChromaticChordEnum.Gsus4 ) );
		assertEquals( DiatonicFunction.VI4, ton.getFunction( ChromaticChordEnum.Asus4 ) );
		// assertEquals( DiatonicFunction.VII4, ton.getFunction( ChromaticChord.Bdim )
		// );

		assertEquals( DiatonicFunction.I6, ton.getFunction( ChromaticChordEnum.C6 ) );
		assertEquals( DiatonicFunction.II6, ton.getFunction( ChromaticChordEnum.Dm6 ) );
		// assertEquals( DiatonicFunction.III6, ton.getFunction( ChromaticChord.Em ) );
		assertEquals( DiatonicFunction.IV6, ton.getFunction( ChromaticChordEnum.F6 ) );
		assertEquals( DiatonicFunction.V6, ton.getFunction( ChromaticChordEnum.G6 ) );
		// assertEquals( DiatonicFunction.VI6, ton.getFunction( ChromaticChord.Am ) );
		// assertEquals( DiatonicFunction.VII6, ton.getFunction( ChromaticChord.Bdim )
		// );

		assertEquals( DiatonicFunction.I7, ton.getFunction( ChromaticChordEnum.CMaj7 ) );
		assertEquals( DiatonicFunction.II7, ton.getFunction( ChromaticChordEnum.Dm7 ) );
		assertEquals( DiatonicFunction.III7, ton.getFunction( ChromaticChordEnum.Em7 ) );
		assertEquals( DiatonicFunction.IV7, ton.getFunction( ChromaticChordEnum.FMaj7 ) );
		assertEquals( DiatonicFunction.V7, ton.getFunction( ChromaticChordEnum.G7 ) );
		assertEquals( DiatonicFunction.VI7, ton.getFunction( ChromaticChordEnum.Am7 ) );
		assertEquals( DiatonicFunction.VII7, ton.getFunction( ChromaticChordEnum.Bm7b5 ) );
		/*
		 * assertEquals( DiatonicFunction.I9, ton.getFunction( ChromaticChord.C ) );
		 * assertEquals( DiatonicFunction.II9, ton.getFunction( ChromaticChord.Dm ) );
		 * assertEquals( DiatonicFunction.III9, ton.getFunction( ChromaticChord.Em ) );
		 * assertEquals( DiatonicFunction.IV9, ton.getFunction( ChromaticChord.F ) );
		 * assertEquals( DiatonicFunction.V9, ton.getFunction( ChromaticChord.G ) );
		 * assertEquals( DiatonicFunction.VI9, ton.getFunction( ChromaticChord.Am ) );
		 * assertEquals( DiatonicFunction.VII9, ton.getFunction( ChromaticChord.Bdim )
		 * );
		 */
		ton = TonalityEnum.Cm;
		assertEquals( DiatonicFunction.VII7, ton.getFunction( CustomChromaticChord.from( ChromaticChordEnum.AA7 ).rename(ton) ) );
	}
}
