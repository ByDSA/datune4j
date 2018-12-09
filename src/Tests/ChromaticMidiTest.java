package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import diatonic.Tonality;
import pitch.Chromatic;
import pitch.ChromaticMidi;
import pitch.DiatonicMidi;
import pitch.Pitch;

public class ChromaticMidiTest {
	@Test
	public void noteConstructor() {
		ChromaticMidi n = Chromatic.C.toMidi( 5 );

		assertEquals( Pitch.C5, n.getPitchCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 5 ).toMidi( 5 );

		assertEquals( Pitch.getFromCode( 60 + 5 ), n.getPitchCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 12 ).toMidi( 5 );

		assertEquals( Pitch.C5, n.getPitchCode() );
		assertEquals( 5, n.getOctave() );
	}
	
	@Test
	public void toDiatonic() {
		ChromaticMidi cm = Chromatic.F.toMidi();
		DiatonicMidi dm = cm.toDiatonicChordMidi(Tonality.C);
		assertEquals(Chromatic.F, dm.toChromaticMidi().getChromatic());
		cm = Chromatic.C.toMidi();
		dm = cm.toDiatonicChordMidi(Tonality.C);
		assertEquals(Chromatic.C, dm.toChromaticMidi().getChromatic());
	}
	
	@Test
	public void equals() {
		ChromaticMidi cm = Pitch.C5.toMidi();
		ChromaticMidi cm2 = cm.duplicate();
		
		assertEquals(cm, cm2);
		
	}
}
