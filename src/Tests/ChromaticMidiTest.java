package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pitch.Chromatic;
import pitch.ChromaticMidi;
import pitch.DiatonicMidi;
import pitch.PitchMidiEnum;
import pitch.PitchMidiSingle;
import tonality.TonalityEnum;

public class ChromaticMidiTest {
	@Test
	public void noteConstructor() {
		ChromaticMidi n = Chromatic.C.toMidi( 5 );

		assertEquals( PitchMidiEnum.C5, n.getCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 5 ).toMidi( 5 );

		assertEquals( PitchMidiSingle.of( 60 + 5 ), n.getCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 12 ).toMidi( 5 );

		assertEquals( PitchMidiEnum.C5, n.getCode() );
		assertEquals( 5, n.getOctave() );
	}
	
	@Test
	public void toDiatonic() {
		ChromaticMidi cm = Chromatic.F.toMidi();
		DiatonicMidi dm = cm.toDiatonicChordMidi(TonalityEnum.C);
		assertEquals(Chromatic.F, dm.toChromaticMidi().getChromatic());
		cm = Chromatic.C.toMidi();
		dm = cm.toDiatonicChordMidi(TonalityEnum.C);
		assertEquals(Chromatic.C, dm.toChromaticMidi().getChromatic());
	}
	
	@Test
	public void equals() {
		ChromaticMidi cm = PitchMidiEnum.C5.toMidi();
		ChromaticMidi cm2 = cm.clone();
		
		assertEquals(cm, cm2);
		
	}
}
