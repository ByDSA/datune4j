package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import musical.ChromaticChordEnum;
import pitch.Chord;
import pitch.DiatonicChordMidi;
import pitch.ChordInterface;
import tonality.TonalityEnum;

public class ChordTest {
	/*@Test
	public void equals() {
		PitchChord cm = ChromaticChordEnum.C;
		PitchChord cm2 = cm.clone();

		assertEquals(true, cm instanceof Chord);
		assertEquals(true, cm2 instanceof Chord);
		assertEquals( cm.size(), cm2.size() );
		assertEquals( cm.getRoot(), cm2.getRoot() );
		for ( int i = 0; i < cm.size(); i++ ) {
			assertEquals( cm.get( i ), cm2.get( i ) );
		}

		cm = new DiatonicChordMidi( TonalityEnum.C, ChromaticChordEnum.C );
		cm2 = cm.clone();

		assertEquals(true, cm instanceof Chord);
		assertEquals(true, cm2 instanceof Chord);
		assertEquals( cm.size(), cm2.size() );
		assertEquals( cm.getRoot(), cm2.getRoot() );
		for ( int i = 0; i < cm.size(); i++ ) {
			assertEquals( cm.get( i ), cm2.get( i ) );
		}
	}*/
}
