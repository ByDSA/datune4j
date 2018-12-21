package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import midi.Arpegios.Arpegio;
import musical.ChromaticChordEnum;

public class ArpegioTest {
	/*@Test
	public void duplicate() {
		Arpegio a = new Arpegio();
		a.setChord( ChromaticChordEnum.C.toMidi() );
		Arpegio a2 = a.duplicate();

		assertEquals( a.getLength(), a2.getLength() );

		assertEquals( a.getChord().size(), a2.getChord().size() );

		assertEquals( a.getNodes().size(), a2.getNodes().size() );

		for ( int i = 0; i < a.getChord().size(); i++ ) {
			assertEquals( a.getChord().get( i ), a2.getChord().get( i ) );
		}

		for ( int i = 0; i < a.getNodes().size(); i++ )
			assertEquals( a.getNodes().get( i ), a2.getNodes().get( i ) );

		assertEquals( true, a.equals( a2 ) );
	}*/
}
