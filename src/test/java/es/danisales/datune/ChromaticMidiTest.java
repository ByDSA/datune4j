package es.danisales.datune;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.TonalityEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChromaticMidiTest {
	@Test
	public void noteConstructor() {
		ChromaticMidi n = Chromatic.C.toMidi( 5 );

		assertEquals( PitchMidi.C5.getCode(), n.getCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 5 ).toMidi( 5 );

		assertEquals( PitchMidi.of( 60 + 5 ).getCode(), n.getCode() );
		assertEquals( 5, n.getOctave() );

		n = Chromatic.C.add( 12 ).toMidi( 5 );

		assertEquals( PitchMidi.C5.getCode(), n.getCode() );
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
		ChromaticMidi cm = PitchMidi.C5.toMidi();
		ChromaticMidi cm2 = cm.clone();
		
		assertEquals(cm, cm2);
		
	}
}
