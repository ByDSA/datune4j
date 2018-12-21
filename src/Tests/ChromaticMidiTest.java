package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import musical.Chromatic;
import pitch.ChromaticMidi;
import pitch.DiatonicMidi;
import pitch.NoteMidi;
import tonality.TonalityEnum;

public class ChromaticMidiTest {
	@Test
	public void noteConstructor() {
		ChromaticMidi n = Chromatic.C.toMidi( 5 );

		assertEquals( NoteMidi.C5.getCode(), n.getCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 5 ).toMidi( 5 );

		assertEquals( NoteMidi.of( 60 + 5 ).getCode(), n.getCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 12 ).toMidi( 5 );

		assertEquals( NoteMidi.C5.getCode(), n.getCode() );
		assertEquals( 5, n.getOctave() );
	}
	
	@Test
	public void toDiatonic() {
		ChromaticMidi cm = Chromatic.F.toMidi();
		DiatonicMidi dm = cm.getDiatonicMidi(TonalityEnum.C);
		assertEquals(Chromatic.F, dm.getChromatic().getChromatic());
		cm = Chromatic.C.toMidi();
		dm = cm.getDiatonicMidi(TonalityEnum.C);
		assertEquals(Chromatic.C, dm.getChromatic().getChromatic());
	}
	
	@Test
	public void equals() {
		ChromaticMidi cm = NoteMidi.C5.toMidi();
		ChromaticMidi cm2 = cm.clone();
		
		assertEquals(cm, cm2);
		
	}
}
