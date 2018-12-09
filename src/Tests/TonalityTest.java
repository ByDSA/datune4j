package Tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import diatonic.ChromaticFunction;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.Tonality;
import pitch.Chromatic;
import pitch.ChromaticChord;
import pitch.Pitch;

public class TonalityTest {
	@Test
	public void notes2tonality() {
		Tonality s = Tonality.A;
		Chromatic[] notes = new Chromatic[7];
		for ( int i = 0; i < 7; i++ )
			notes[i] = s.get( i );

		assertEquals( s.getScale(), Tonality.notes2scale( notes ) );
	}

	@Test
	public void getAlterations() {
		assertEquals( (Integer) 0, Tonality.C.getAlteration() );
		assertEquals( (Integer) 5, Tonality.Db.getAlteration() );
		assertEquals( (Integer) 2, Tonality.D.getAlteration() );
		assertEquals( (Integer) 3, Tonality.Eb.getAlteration() );
		assertEquals( (Integer) 4, Tonality.E.getAlteration() );
		assertEquals( (Integer) 3, Tonality.Cm.getAlteration() );
	}

	@Test
	public void duplicate() {
		for ( Tonality t : Tonality.all() ) {
			assertEquals( true, t.sameRoot( t.duplicate() ) );
			assertEquals( true, t.sameScale( t.duplicate() ) );
			assertEquals( true, t.sameNotes( t.duplicate() ) );
			assertEquals( true, t.equals( t.duplicate() ) );
		}

		assertEquals( false, Tonality.FF.equals( Tonality.Gb.duplicate() ) );
	}

	@Test
	public void minimizeAlterations() {
		for ( final Tonality t : Tonality.all() ) {
			Tonality t2 = t.duplicate();
			int alt = t2.getAlteration();
			ArrayList<Tonality> out = t2.minimizeAlterations();

			assertEquals( true, t2.getAlteration() <= alt );
		}
	}

	@Test
	public void updateChromaticsFromBase() {
		Tonality t = Tonality.Gb.duplicate();
		assertEquals( Chromatic.Gb, t.getRoot() );
		t.updateChromaticsFromBase( Chromatic.FF );
		assertEquals( Chromatic.FF, t.getRoot() );
	}

	@Test
	public void whichGetsChord() {
		ArrayList<Tonality> ts = Tonality.getFromChord( false, ChromaticChord.C );
		assertEquals( true, ts.size() > 0 );
	}

	@Test
	public void whichGetsChordOutScale() {
		ArrayList<Tonality> ts = Tonality.getFromChord( true, ChromaticChord.C );
		assertEquals( true, ts.size() > 0 );
	}

	@Test
	public void getChordFunction() {
		Tonality ton = Tonality.E;
		ChromaticChord cc = ton.get( DiatonicFunction.I );

		assertEquals( ChromaticChord.E, cc );
		cc = ton.get( DiatonicFunction.VII );

		assertEquals( ChromaticChord.DDdim, cc );

		ton = Tonality.Em;
		cc = ton.get( DiatonicFunction.I );

		assertEquals( ChromaticChord.Em, cc );
		cc = ton.get( DiatonicFunction.VII );

		assertEquals( ChromaticChord.D, cc );

		ton = Tonality.C;
		cc = ton.get( DiatonicFunction.V7 );

		assertEquals( ChromaticChord.G7, cc );
	}

	@Test
	public void getTriadSeventhChords() {
		Tonality t = Tonality.C;

		assertArrayEquals(
			new ChromaticChord[] {
				ChromaticChord.C,
				ChromaticChord.Dm,
				ChromaticChord.Em,
				ChromaticChord.F,
				ChromaticChord.G,
				ChromaticChord.Am,
				ChromaticChord.Bdim

			}, t.getTriadChords()
		);

		assertArrayEquals(
			new ChromaticChord[] {
				ChromaticChord.CMaj7,
				ChromaticChord.Dm7,
				ChromaticChord.Em7,
				ChromaticChord.FMaj7,
				ChromaticChord.G7,
				ChromaticChord.Am7,
				ChromaticChord.Bm7b5

			}, t.getSeventhChords()
		);

		t = Tonality.Am;

		assertArrayEquals(
			new ChromaticChord[] {
				ChromaticChord.Am,
				ChromaticChord.Bdim,
				ChromaticChord.C,
				ChromaticChord.Dm,
				ChromaticChord.Em,
				ChromaticChord.F,
				ChromaticChord.G
			}, t.getTriadChords()
		);

		assertArrayEquals(
			new ChromaticChord[] {
				ChromaticChord.Am7,
				ChromaticChord.Bm7b5,
				ChromaticChord.CMaj7,
				ChromaticChord.Dm7,
				ChromaticChord.Em7,
				ChromaticChord.FMaj7,
				ChromaticChord.G7
			}, t.getSeventhChords()
		);
	}

	@Test
	public void getAllChords() {
		Tonality t = Tonality.C;
		Set<ChromaticChord> cs = t.getScaleChords();
		assertEquals( 49, DiatonicFunction.ALL.length );
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
		
		ArrayList<ChromaticChord> ccs = t.getAllChords( );
		assertEquals( 116, ccs.size() );
	}

	@Test
	public void has() {
		Tonality ton = Tonality.C;

		assertEquals( true, ton.has( ChromaticChord.C ) );
		assertEquals( true, ton.has( ChromaticChord.Dm ) );
		assertEquals( true, ton.has( ChromaticChord.Em ) );
		assertEquals( true, ton.has( ChromaticChord.F ) );
		assertEquals( true, ton.has( ChromaticChord.G ) );
		assertEquals( true, ton.has( ChromaticChord.Am ) );
		assertEquals( true, ton.has( ChromaticChord.Bdim ) );

		assertEquals( true, ton.has( ChromaticChord.Csus2 ) );
		assertEquals( true, ton.has( ChromaticChord.Dsus2 ) );
		assertEquals( true, ton.has( ChromaticChord.Esusb2 ) );
		assertEquals( true, ton.has( ChromaticChord.Fsus2 ) );
		assertEquals( true, ton.has( ChromaticChord.Gsus2 ) );
		assertEquals( true, ton.has( ChromaticChord.Asus2 ) );
		assertEquals( true, ton.has( ChromaticChord.Bsusb2b5 ) );

		assertEquals( true, ton.has( ChromaticChord.Csus4 ) );
		assertEquals( true, ton.has( ChromaticChord.Dsus4 ) );
		assertEquals( true, ton.has( ChromaticChord.Esus4 ) );
		assertEquals( true, ton.has( ChromaticChord.Fsusa4 ) );
		assertEquals( true, ton.has( ChromaticChord.Gsus4 ) );
		assertEquals( true, ton.has( ChromaticChord.Asus4 ) );
		// assertEquals( true, ton.has( ChromaticChord.Bsusa4 ) );

		assertEquals( true, ton.has( ChromaticChord.C6 ) );
		assertEquals( true, ton.has( ChromaticChord.Dm6 ) );
		// assertEquals( true, ton.has( ChromaticChord.Em6 ) );
		assertEquals( true, ton.has( ChromaticChord.F6 ) );
		assertEquals( true, ton.has( ChromaticChord.G6 ) );
		// assertEquals( true, ton.has( ChromaticChord.Am6 ) );
		// assertEquals( true, ton.has( ChromaticChord.B6 ) );

		assertEquals( true, ton.has( ChromaticChord.CMaj7 ) );
		assertEquals( true, ton.has( ChromaticChord.Dm7 ) );
		assertEquals( true, ton.has( ChromaticChord.Em7 ) );
		// assertEquals( true, ton.has( ChromaticChord.F7 ) );
		assertEquals( true, ton.has( ChromaticChord.G7 ) );
		assertEquals( true, ton.has( ChromaticChord.Am7 ) );
		// assertEquals( true, ton.has( ChromaticChord.B7 ) );
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
			assertEquals( true, ton.has( c ) );
		}

		for ( DiatonicFunction df : DiatonicFunction.ALL )
			assertEquals( true, ton.has( ton.get( df ) ) );

		ton = Tonality.Db;
		for ( ChromaticChord c : ton.getScaleChords() )
			assertEquals( true, ton.has( c ) );

		for ( DiatonicFunction df : DiatonicFunction.ALL )
			assertEquals( true, ton.has( ton.get( df ) ) );
	}

	@Test
	public void getDegree() {
		Tonality ton = Tonality.C;

		assertEquals( Degree.I, ton.getDegree( Pitch.C5 ) );
		assertEquals( Degree.II, ton.getDegree( Pitch.D5 ) );
		assertEquals( Degree.III, ton.getDegree( Pitch.E6 ) );
		assertEquals( Degree.IV, ton.getDegree( Chromatic.F ) );
		assertEquals( null, ton.getDegree( Chromatic.EEEE, false ) );
		assertEquals( Degree.V, ton.getDegree( Chromatic.EEEE ) );
	}

	@Test
	public void get() {
		Tonality ton = Tonality.C;
		assertEquals( ChromaticChord.C, ton.get( DiatonicFunction.I ) );
		assertEquals( ChromaticChord.Dm, ton.get( DiatonicFunction.II ) );
		assertEquals( ChromaticChord.Em, ton.get( DiatonicFunction.III ) );
		assertEquals( ChromaticChord.F, ton.get( DiatonicFunction.IV ) );
		assertEquals( ChromaticChord.G, ton.get( DiatonicFunction.V ) );
		assertEquals( ChromaticChord.Am, ton.get( DiatonicFunction.VI ) );
		assertEquals( ChromaticChord.Bdim, ton.get( DiatonicFunction.VII ) );

		assertEquals( ChromaticChord.Csus2, ton.get( DiatonicFunction.I2 ) );
		assertEquals( ChromaticChord.Dsus2, ton.get( DiatonicFunction.II2 ) );
		// assertEquals( DiatonicFunction.III2, ton.getFunction( ChromaticChord.Em ) );
		assertEquals( ChromaticChord.Fsus2, ton.get( DiatonicFunction.IV2 ) );
		assertEquals( ChromaticChord.Gsus2, ton.get( DiatonicFunction.V2 ) );
		assertEquals( ChromaticChord.Asus2, ton.get( DiatonicFunction.VI2 ) );
		// assertEquals( DiatonicFunction.VII2, ton.get( ChromaticChord.Bdim ) );

		assertEquals( ChromaticChord.Csus4, ton.get( DiatonicFunction.I4 ) );
		assertEquals( ChromaticChord.Dsus4, ton.get( DiatonicFunction.II4 ) );
		assertEquals( ChromaticChord.Esus4, ton.get( DiatonicFunction.III4 ) );
		// assertEquals( DiatonicFunction.IV4, ton.get( ChromaticChord.F ) );
		assertEquals( ChromaticChord.Gsus4, ton.get( DiatonicFunction.V4 ) );
		assertEquals( ChromaticChord.Asus4, ton.get( DiatonicFunction.VI4 ) );
		// assertEquals( DiatonicFunction.VII4, ton.get( ChromaticChord.Bdim ) );

		assertEquals( ChromaticChord.C6, ton.get( DiatonicFunction.I6 ) );
		assertEquals( ChromaticChord.Dm6, ton.get( DiatonicFunction.II6 ) );
		// assertEquals( DiatonicFunction.III6, ton.get( ChromaticChord.Em ) );
		assertEquals( ChromaticChord.F6, ton.get( DiatonicFunction.IV6 ) );
		assertEquals( ChromaticChord.G6, ton.get( DiatonicFunction.V6 ) );
		// assertEquals( DiatonicFunction.VI6, ton.get( ChromaticChord.Am ) );
		// assertEquals( DiatonicFunction.VII6, ton.get( ChromaticChord.Bdim ) );

		assertEquals( ChromaticChord.CMaj7, ton.get( DiatonicFunction.I7 ) );
		assertEquals( ChromaticChord.Dm7, ton.get( DiatonicFunction.II7 ) );
		assertEquals( ChromaticChord.Em7, ton.get( DiatonicFunction.III7 ) );
		assertEquals( ChromaticChord.FMaj7, ton.get( DiatonicFunction.IV7 ) );
		assertEquals( ChromaticChord.G7, ton.get( DiatonicFunction.V7 ) );
		assertEquals( ChromaticChord.Am7, ton.get( DiatonicFunction.VI7 ) );
		assertEquals( ChromaticChord.Bm7b5, ton.get( DiatonicFunction.VII7 ) );

		assertEquals( ChromaticChord.C5, ton.get( ChromaticFunction.I5 ) );
		assertEquals( ChromaticChord.D5, ton.get( ChromaticFunction.II5 ) );
		assertEquals( ChromaticChord.E5, ton.get( ChromaticFunction.III5 ) );
		assertEquals( ChromaticChord.F5, ton.get( ChromaticFunction.IV5 ) );
		assertEquals( ChromaticChord.G5, ton.get( ChromaticFunction.V5 ) );
		assertEquals( ChromaticChord.A5, ton.get( ChromaticFunction.VI5 ) );
		assertEquals( ChromaticChord.B5, ton.get( ChromaticFunction.VII5 ) );

		assertEquals( ChromaticChord.A, ton.get( ChromaticFunction.V_II ) );
		assertEquals( ChromaticChord.B, ton.get( ChromaticFunction.V_III ) );
		assertEquals( ChromaticChord.C, ton.get( ChromaticFunction.V_IV ) );
		assertEquals( ton.get( DiatonicFunction.I ), ton.get( ChromaticFunction.V_IV ) );
		assertEquals( ChromaticChord.D, ton.get( ChromaticFunction.V_V ) );
		assertEquals( ChromaticChord.E, ton.get( ChromaticFunction.V_VI ) );

		assertEquals( ChromaticChord.A7, ton.get( ChromaticFunction.V7_II ) );
		assertEquals( ChromaticChord.B7, ton.get( ChromaticFunction.V7_III ) );
		assertEquals(
			true, ton.get( ChromaticFunction.V7_IV ).equalsEnharmonic( ChromaticChord.C7 ) );
			assertEquals( ChromaticChord.D7, ton.get( ChromaticFunction.V7_V ) );
		assertEquals( ChromaticChord.E7, ton.get( ChromaticFunction.V7_VI ) );

		assertEquals(
			true, ton.get( ChromaticFunction.SUBV7 ).equalsEnharmonic( ChromaticChord.CC7 ) );

			assertEquals(
				true, ton.get( ChromaticFunction.SUBV7_II ).equalsEnharmonic( ChromaticChord.DD7 ) );

				assertEquals(
					true, ton.get( ChromaticFunction.SUBV7_III ).equalsEnharmonic( ChromaticChord.F7 ) );

					assertEquals(
						true, ton.get( ChromaticFunction.SUBV7_IV ).equalsEnharmonic( ChromaticChord.FF7 ) );

						assertEquals(
							true, ton.get( ChromaticFunction.SUBV7_V ).equalsEnharmonic( ChromaticChord.GG7 ) );

							assertEquals(
								true, ton.get( ChromaticFunction.SUBV7_VI ).equalsEnharmonic( ChromaticChord.AA7 ) );

								assertEquals(
									ChromaticChord.CC.duplicate().inv(), ton
											.get( ChromaticFunction.N6 )
									);

									// TODO:
									// V7ALT

		ton = Tonality.Cm;
		
		assertEquals( true, ton.get( DiatonicFunction.VII7 ).equalsEnharmonic(ChromaticChord.AA7) );
		
		ton = Tonality.Db;
		assertEquals( true, ton.get( DiatonicFunction.II ).equalsEnharmonic( ChromaticChord.DDm ) );
	}

	@Test
	public void getFunction() {
		Tonality ton = Tonality.C;
		assertEquals( DiatonicFunction.I, ton.getFunction( ChromaticChord.C ) );
		assertEquals( DiatonicFunction.II, ton.getFunction( ChromaticChord.Dm ) );
		assertEquals( DiatonicFunction.III, ton.getFunction( ChromaticChord.Em ) );
		assertEquals( DiatonicFunction.IV, ton.getFunction( ChromaticChord.F ) );
		assertEquals( DiatonicFunction.V, ton.getFunction( ChromaticChord.G ) );
		assertEquals( DiatonicFunction.VI, ton.getFunction( ChromaticChord.Am ) );
		assertEquals( DiatonicFunction.VII, ton.getFunction( ChromaticChord.Bdim ) );

		assertEquals( ChromaticChord.Csus2, ton.get( DiatonicFunction.I2 ) );
		assertEquals( DiatonicFunction.I2, ton.getFunction( ChromaticChord.Csus2 ) );
		assertEquals( DiatonicFunction.II2, ton.getFunction( ChromaticChord.Dsus2 ) );
		// assertEquals( DiatonicFunction.III2, ton.getFunction( ChromaticChord.Em ) );
		assertEquals( DiatonicFunction.IV2, ton.getFunction( ChromaticChord.Fsus2 ) );
		assertEquals( DiatonicFunction.V2, ton.getFunction( ChromaticChord.Gsus2 ) );
		assertEquals( DiatonicFunction.VI2, ton.getFunction( ChromaticChord.Asus2 ) );
		// assertEquals( DiatonicFunction.VII2, ton.getFunction( ChromaticChord.Bdim )
		// );

		assertEquals( DiatonicFunction.I4, ton.getFunction( ChromaticChord.Csus4 ) );
		assertEquals( DiatonicFunction.II4, ton.getFunction( ChromaticChord.Dsus4 ) );
		assertEquals( DiatonicFunction.III4, ton.getFunction( ChromaticChord.Esus4 ) );
		// assertEquals( DiatonicFunction.IV4, ton.getFunction( ChromaticChord.F ) );
		assertEquals( DiatonicFunction.V4, ton.getFunction( ChromaticChord.Gsus4 ) );
		assertEquals( DiatonicFunction.VI4, ton.getFunction( ChromaticChord.Asus4 ) );
		// assertEquals( DiatonicFunction.VII4, ton.getFunction( ChromaticChord.Bdim )
		// );

		assertEquals( DiatonicFunction.I6, ton.getFunction( ChromaticChord.C6 ) );
		assertEquals( DiatonicFunction.II6, ton.getFunction( ChromaticChord.Dm6 ) );
		// assertEquals( DiatonicFunction.III6, ton.getFunction( ChromaticChord.Em ) );
		assertEquals( DiatonicFunction.IV6, ton.getFunction( ChromaticChord.F6 ) );
		assertEquals( DiatonicFunction.V6, ton.getFunction( ChromaticChord.G6 ) );
		// assertEquals( DiatonicFunction.VI6, ton.getFunction( ChromaticChord.Am ) );
		// assertEquals( DiatonicFunction.VII6, ton.getFunction( ChromaticChord.Bdim )
		// );

		assertEquals( DiatonicFunction.I7, ton.getFunction( ChromaticChord.CMaj7 ) );
		assertEquals( DiatonicFunction.II7, ton.getFunction( ChromaticChord.Dm7 ) );
		assertEquals( DiatonicFunction.III7, ton.getFunction( ChromaticChord.Em7 ) );
		assertEquals( DiatonicFunction.IV7, ton.getFunction( ChromaticChord.FMaj7 ) );
		assertEquals( DiatonicFunction.V7, ton.getFunction( ChromaticChord.G7 ) );
		assertEquals( DiatonicFunction.VI7, ton.getFunction( ChromaticChord.Am7 ) );
		assertEquals( DiatonicFunction.VII7, ton.getFunction( ChromaticChord.Bm7b5 ) );
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
		ton = Tonality.Cm;		
		assertEquals( DiatonicFunction.VII7, ton.getFunction( ChromaticChord.AA7.duplicate(true).rename(ton) ) );
	}
}
