package es.danisales.datune;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChromaticMidiTest {
	@Test
	public void noteConstructor() {
		ChromaticMidi n = ChromaticMidi.builder().pitch(Chromatic.C, 5).build();

		assertEquals( PitchChromaticMidi.C5.getCode(), n.getPitch().getCode() );
		assertEquals( 5, n.getOctave() );

		n = ChromaticMidi.builder().pitch(Chromatic.C.addSemi(5), 5).build();

		assertEquals( PitchChromaticMidi.from( 60 + 5 ).getCode(), n.getPitch().getCode() );
		assertEquals( 5, n.getOctave() );

		n = ChromaticMidi.builder().pitch(Chromatic.C.addSemi(12), 5).build();

		assertEquals( PitchChromaticMidi.C5.getCode(), n.getPitch().getCode() );
		assertEquals( 5, n.getOctave() );
	}
	
	@Test
	public void toDiatonic() {
		ChromaticMidi cm = ChromaticMidi.builder().pitch(Chromatic.F).build();
		DiatonicMidi dm = DiatonicMidi.builder().fromChromatic(cm, Tonality.C).build();
		Chromatic chromaticDm = Chromatic.from(dm);
		assertEquals(Chromatic.F, chromaticDm);
		cm = ChromaticMidi.builder().pitch(Chromatic.C).build();
		dm = DiatonicMidi.builder().fromChromatic(cm, Tonality.C).build();
		chromaticDm = Chromatic.from(dm);
		assertEquals(Chromatic.C, chromaticDm);
	}
	
	@Test
	public void equals() {
		ChromaticMidi cm = PitchChromaticMidi.C5.toMidi();
		ChromaticMidi cm2 = cm.clone();
		
		assertEquals(cm, cm2);
	}

	@Test
	public void fromBuilderChromaticAndOctave() {
		ChromaticMidi n = ChromaticMidi.builder()
				.pitch(Chromatic.C, 5 )
				.build();

		assertEquals( PitchChromaticMidi.C5, n.getPitch() );
	}
}
