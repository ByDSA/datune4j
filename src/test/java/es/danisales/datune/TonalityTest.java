package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChordEnum;
import es.danisales.datune.musical.CustomChromaticChord;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.CustomTonality;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TonalityTest {
	@Test
	public void notes2tonality() {
		Tonality s = TonalityEnum.A;
		Chromatic[] notes = new Chromatic[7];
		for ( int i = 0; i < 7; i++ )
			notes[i] = s.get( i );

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
			assertEquals( true, t.sameRoot( Tonality.of( t ) ) );
			assertEquals( true, t.sameScale( Tonality.of( t ) ) );
			assertEquals( true, t.sameNotes( Tonality.of( t ) ) );
			assertEquals( true, t.equals( Tonality.of( t ) ) );
		}

		assertEquals( false, TonalityEnum.FF.equals( TonalityEnum.Gb ) );
	}

	@Test
	public void minimizeAlterations() {
		for ( final CustomTonality t : CustomTonality.all() ) {
			CustomTonality t2 = t.clone();
			int alt = t2.getAlteration();
			ArrayList<CustomTonality> out = t2.minimizeAlterations();

			assertEquals( true, t2.getAlteration() <= alt );
		}
	}

	@Test
	public void updateChromaticsFromBase() {
		Tonality t = TonalityEnum.Gb;
		assertEquals( Chromatic.Gb, t.getRoot() );
		t.updateChromaticsFromBase( Chromatic.FF );
		assertEquals( Chromatic.FF, t.getRoot() );
	}

	@Test
	public void whichGetsChord() {
		ArrayList<CustomTonality> ts = CustomTonality.getFromChord( false, ChromaticChordEnum.C );
		assertEquals( true, ts.size() > 0 );
	}

	@Test
	public void whichGetsChordOutScale() {
		ArrayList<CustomTonality> ts = CustomTonality.getFromChord( true, ChromaticChordEnum.C );
		assertEquals( true, ts.size() > 0 );
	}

	@Test
	public void getChordFunction() {
		Tonality ton = TonalityEnum.E;
		PitchChromaticChord cc = ton.get( DiatonicFunction.I );

		assertEquals( ChromaticChordEnum.E, cc );
		cc = ton.get( DiatonicFunction.VII );

		assertEquals( ChromaticChordEnum.DDdim, cc );

		ton = TonalityEnum.Em;
		cc = ton.get( DiatonicFunction.I );

		assertEquals( ChromaticChordEnum.Em, cc );
		cc = ton.get( DiatonicFunction.VII );

		assertEquals( ChromaticChordEnum.D, cc );

		ton = TonalityEnum.C;
		cc = ton.get( DiatonicFunction.V7 );

		assertEquals( ChromaticChordEnum.G7, cc );
	}

	@Test
	public void getTriadSeventhChords() {
		Tonality t = TonalityEnum.C;

		assertArrayEquals(
			new ChromaticChordEnum[] {
				ChromaticChordEnum.C,
				ChromaticChordEnum.Dm,
				ChromaticChordEnum.Em,
				ChromaticChordEnum.F,
				ChromaticChordEnum.G,
				ChromaticChordEnum.Am,
				ChromaticChordEnum.Bdim

			}, t.getTriadChords()
		);

		assertArrayEquals(
			new ChromaticChordEnum[] {
				ChromaticChordEnum.CMaj7,
				ChromaticChordEnum.Dm7,
				ChromaticChordEnum.Em7,
				ChromaticChordEnum.FMaj7,
				ChromaticChordEnum.G7,
				ChromaticChordEnum.Am7,
				ChromaticChordEnum.Bm7b5

			}, t.getSeventhChords()
		);

		t = TonalityEnum.Am;

		assertArrayEquals(
			new ChromaticChordEnum[] {
				ChromaticChordEnum.Am,
				ChromaticChordEnum.Bdim,
				ChromaticChordEnum.C,
				ChromaticChordEnum.Dm,
				ChromaticChordEnum.Em,
				ChromaticChordEnum.F,
				ChromaticChordEnum.G
			}, t.getTriadChords()
		);

		assertArrayEquals(
			new ChromaticChordEnum[] {
				ChromaticChordEnum.Am7,
				ChromaticChordEnum.Bm7b5,
				ChromaticChordEnum.CMaj7,
				ChromaticChordEnum.Dm7,
				ChromaticChordEnum.Em7,
				ChromaticChordEnum.FMaj7,
				ChromaticChordEnum.G7
			}, t.getSeventhChords()
		);
	}

	@Test
	public void getAllChords() {
		Tonality t = TonalityEnum.C;
		Set<CustomChromaticChord> cs = t.getScaleChords();
		assertEquals( 49, DiatonicFunction.COMMON.length );
		assertEquals( 49, cs.size() );
		
		cs = t.getBorrowedChords();
		assertEquals( 42, cs.size() );
		cs = t.getOutScaleChords();
		int i = 1;
		for (CustomChromaticChord c : cs) {
			System.out.println( t.getFunction( c )  + ": " + c);
		}
		assertEquals( 25, ChromaticFunction.ALL.length );
		assertEquals( 25, cs.size() );
		
		ArrayList<CustomChromaticChord> ccs = t.getAllChords( );
		assertEquals( 116, ccs.size() );
	}

	@Test
	public void has() {
		TonalityEnum ton = TonalityEnum.C;

		assertEquals( true, ton.has( ChromaticChordEnum.C ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Dm ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Em ) );
		assertEquals( true, ton.has( ChromaticChordEnum.F ) );
		assertEquals( true, ton.has( ChromaticChordEnum.G ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Am ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Bdim ) );

		assertEquals( true, ton.has( ChromaticChordEnum.Csus2 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Dsus2 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Esusb2 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Fsus2 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Gsus2 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Asus2 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Bsusb2b5 ) );

		assertEquals( true, ton.has( ChromaticChordEnum.Csus4 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Dsus4 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Esus4 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Fsusa4 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Gsus4 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Asus4 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.Bsusa4 ) );

		assertEquals( true, ton.has( ChromaticChordEnum.C6 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Dm6 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.Em6 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.F6 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.G6 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.Am6 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.B6 ) );

		assertEquals( true, ton.has( ChromaticChordEnum.CMaj7 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Dm7 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Em7 ) );
		// assertEquals( true, ton.has( ChromaticChordEnum.F7 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.G7 ) );
		assertEquals( true, ton.has( ChromaticChordEnum.Am7 ) );
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

		for ( CustomChromaticChord c : ton.getScaleChords() ) {
			/*c.show();
			c.showNotes();*/
			assertEquals( true, ton.has( c ) );
		}

		for ( DiatonicFunction df : DiatonicFunction.COMMON )
			assertEquals( true, ton.has( ton.get( df ) ) );

		ton = TonalityEnum.Db;
		for ( CustomChromaticChord c : ton.getScaleChords() )
			assertEquals( true, ton.has( c ) );

		for ( DiatonicFunction df : DiatonicFunction.COMMON )
			assertEquals( true, ton.has( ton.get( df ) ) );
	}

	@Test
	public void getDegree() {
		Tonality ton = TonalityEnum.C;

		assertEquals( DiatonicDegree.I, ton.getDegreeFrom( PitchMidi.C5 ) );
		assertEquals( DiatonicDegree.II, ton.getDegreeFrom( PitchMidi.D5 ) );
		assertEquals( DiatonicDegree.III, ton.getDegreeFrom( PitchMidi.E6 ) );
		assertEquals( DiatonicDegree.IV, ton.getDegreeFrom( Chromatic.F ) );
		assertEquals( null, ton.getDegreeFrom( Chromatic.EEEE, false ) );
		assertEquals( DiatonicDegree.V, ton.getDegreeFrom( Chromatic.EEEE ) );
	}

	@Test
	public void get() {
		Tonality ton = TonalityEnum.C;
		assertEquals( ChromaticChordEnum.C, ton.get( DiatonicFunction.I ) );
		assertEquals( ChromaticChordEnum.Dm, ton.get( DiatonicFunction.II ) );
		assertEquals( ChromaticChordEnum.Em, ton.get( DiatonicFunction.III ) );
		assertEquals( ChromaticChordEnum.F, ton.get( DiatonicFunction.IV ) );
		assertEquals( ChromaticChordEnum.G, ton.get( DiatonicFunction.V ) );
		assertEquals( ChromaticChordEnum.Am, ton.get( DiatonicFunction.VI ) );
		assertEquals( ChromaticChordEnum.Bdim, ton.get( DiatonicFunction.VII ) );

		assertEquals( ChromaticChordEnum.Csus2, ton.get( DiatonicFunction.I2 ) );
		assertEquals( ChromaticChordEnum.Dsus2, ton.get( DiatonicFunction.II2 ) );
		// assertEquals( DiatonicFunction.III2, ton.getFunction( ChromaticChord.Em ) );
		assertEquals( ChromaticChordEnum.Fsus2, ton.get( DiatonicFunction.IV2 ) );
		assertEquals( ChromaticChordEnum.Gsus2, ton.get( DiatonicFunction.V2 ) );
		assertEquals( ChromaticChordEnum.Asus2, ton.get( DiatonicFunction.VI2 ) );
		// assertEquals( DiatonicFunction.VII2, ton.calculateFrom( ChromaticChord.Bdim ) );

		assertEquals( ChromaticChordEnum.Csus4, ton.get( DiatonicFunction.I4 ) );
		assertEquals( ChromaticChordEnum.Dsus4, ton.get( DiatonicFunction.II4 ) );
		assertEquals( ChromaticChordEnum.Esus4, ton.get( DiatonicFunction.III4 ) );
		// assertEquals( DiatonicFunction.IV4, ton.calculateFrom( ChromaticChord.F ) );
		assertEquals( ChromaticChordEnum.Gsus4, ton.get( DiatonicFunction.V4 ) );
		assertEquals( ChromaticChordEnum.Asus4, ton.get( DiatonicFunction.VI4 ) );
		// assertEquals( DiatonicFunction.VII4, ton.calculateFrom( ChromaticChord.Bdim ) );

		assertEquals( ChromaticChordEnum.C6, ton.get( DiatonicFunction.I6 ) );
		assertEquals( ChromaticChordEnum.Dm6, ton.get( DiatonicFunction.II6 ) );
		// assertEquals( DiatonicFunction.III6, ton.calculateFrom( ChromaticChord.Em ) );
		assertEquals( ChromaticChordEnum.F6, ton.get( DiatonicFunction.IV6 ) );
		assertEquals( ChromaticChordEnum.G6, ton.get( DiatonicFunction.V6 ) );
		// assertEquals( DiatonicFunction.VI6, ton.calculateFrom( ChromaticChord.Am ) );
		// assertEquals( DiatonicFunction.VII6, ton.calculateFrom( ChromaticChord.Bdim ) );

		assertEquals( ChromaticChordEnum.CMaj7, ton.get( DiatonicFunction.I7 ) );
		assertEquals( ChromaticChordEnum.Dm7, ton.get( DiatonicFunction.II7 ) );
		assertEquals( ChromaticChordEnum.Em7, ton.get( DiatonicFunction.III7 ) );
		assertEquals( ChromaticChordEnum.FMaj7, ton.get( DiatonicFunction.IV7 ) );
		assertEquals( ChromaticChordEnum.G7, ton.get( DiatonicFunction.V7 ) );
		assertEquals( ChromaticChordEnum.Am7, ton.get( DiatonicFunction.VI7 ) );
		assertEquals( ChromaticChordEnum.Bm7b5, ton.get( DiatonicFunction.VII7 ) );

		assertEquals( ChromaticChordEnum.C5, ton.get( ChromaticFunction.I5 ) );
		assertEquals( ChromaticChordEnum.D5, ton.get( ChromaticFunction.II5 ) );
		assertEquals( ChromaticChordEnum.E5, ton.get( ChromaticFunction.III5 ) );
		assertEquals( ChromaticChordEnum.F5, ton.get( ChromaticFunction.IV5 ) );
		assertEquals( ChromaticChordEnum.G5, ton.get( ChromaticFunction.V5 ) );
		assertEquals( ChromaticChordEnum.A5, ton.get( ChromaticFunction.VI5 ) );
		assertEquals( ChromaticChordEnum.B5, ton.get( ChromaticFunction.VII5 ) );

		assertEquals( ChromaticChordEnum.A, ton.get( ChromaticFunction.V_II ) );
		assertEquals( ChromaticChordEnum.B, ton.get( ChromaticFunction.V_III ) );
		assertEquals( ChromaticChordEnum.C, ton.get( ChromaticFunction.V_IV ) );
		assertEquals( ton.get( DiatonicFunction.I ), ton.get( ChromaticFunction.V_IV ) );
		assertEquals( ChromaticChordEnum.D, ton.get( ChromaticFunction.V_V ) );
		assertEquals( ChromaticChordEnum.E, ton.get( ChromaticFunction.V_VI ) );

		assertEquals( ChromaticChordEnum.A7, ton.get( ChromaticFunction.V7_II ) );
		assertEquals( ChromaticChordEnum.B7, ton.get( ChromaticFunction.V7_III ) );
		assertEquals(
			true, ton.get( ChromaticFunction.V7_IV ).equalsEnharmonic( ChromaticChordEnum.C7 ) );
			assertEquals( ChromaticChordEnum.D7, ton.get( ChromaticFunction.V7_V ) );
		assertEquals( ChromaticChordEnum.E7, ton.get( ChromaticFunction.V7_VI ) );

		assertEquals(
			true, ton.get( ChromaticFunction.SUBV7 ).equalsEnharmonic( ChromaticChordEnum.CC7 ) );

			assertEquals(
				true, ton.get( ChromaticFunction.SUBV7_II ).equalsEnharmonic( ChromaticChordEnum.DD7 ) );

				assertEquals(
					true, ton.get( ChromaticFunction.SUBV7_III ).equalsEnharmonic( ChromaticChordEnum.F7 ) );

					assertEquals(
						true, ton.get( ChromaticFunction.SUBV7_IV ).equalsEnharmonic( ChromaticChordEnum.FF7 ) );

						assertEquals(
							true, ton.get( ChromaticFunction.SUBV7_V ).equalsEnharmonic( ChromaticChordEnum.GG7 ) );

							assertEquals(
								true, ton.get( ChromaticFunction.SUBV7_VI ).equalsEnharmonic( ChromaticChordEnum.AA7 ) );

								assertEquals(
										ChromaticChordEnum.CC.getInv(), ton
											.get( ChromaticFunction.N6 )
									);

									// TODO:
									// V7ALT

		ton = TonalityEnum.Cm;
		
		assertEquals( true, ton.get( DiatonicFunction.VII7 ).equalsEnharmonic(ChromaticChordEnum.AA7) );
		
		ton = TonalityEnum.Db;
		assertEquals( true, ton.get( DiatonicFunction.II ).equalsEnharmonic( ChromaticChordEnum.DDm ) );
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

		assertEquals( ChromaticChordEnum.Csus2, ton.get( DiatonicFunction.I2 ) );
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
