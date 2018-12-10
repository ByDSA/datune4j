package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pitch.Chromatic;
import pitch.ChromaticMidi;
import pitch.DiatonicMidi;
import pitch.PitchMidi;
import tonality.TonalityEnum;

public class ChromaticMidiTest {
	@Test
	public void noteConstructor() {
		ChromaticMidi n = Chromatic.C.toMidi( 5 );

		assertEquals( PitchMidi.C5, n.getPitchCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 5 ).toMidi( 5 );

		assertEquals( PitchMidi.getFromCode( 60 + 5 ), n.getPitchCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 12 ).toMidi( 5 );

		assertEquals( PitchMidi.C5, n.getPitchCode() );
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
		ChromaticMidi cm = PitchMidi.C5.toMidi();
		ChromaticMidi cm2 = cm.clone();
		
		assertEquals(cm, cm2);
		
	}
}
