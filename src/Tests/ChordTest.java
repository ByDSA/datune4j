package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chromaticchord.ChromaticChordEnum;
import pitch.Chord;
import pitch.DiatonicChordMidi;
import tonality.TonalityEnum;

public class ChordTest {
	/*@Test
	public void equals() {
		Chord cm = ChromaticChordEnum.C.toMidi();
		Chord cm2 = (Chord) cm.duplicate();

		assertEquals(true, cm instanceof Chord);
		assertEquals(true, cm2 instanceof Chord);
		assertEquals( cm.size(), cm2.size() );
		assertEquals( cm.getRoot(), cm2.getRoot() );
		for ( int i = 0; i < cm.size(); i++ ) {
			assertEquals( cm.get( i ), cm2.get( i ) );
		}

		cm = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C );
		cm2 = (Chord) cm.duplicate();

		assertEquals(true, cm instanceof Chord);
		assertEquals(true, cm2 instanceof Chord);
		assertEquals( cm.size(), cm2.size() );
		assertEquals( cm.getRoot(), cm2.getRoot() );
		for ( int i = 0; i < cm.size(); i++ ) {
			assertEquals( cm.get( i ), cm2.get( i ) );
		}
	}*/
}
