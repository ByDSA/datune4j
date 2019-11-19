package es.danisales.datune;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChromaticMidiTest {
	@Test
	public void noteConstructor() {
		ChromaticMidi n = ChromaticMidi.builder().pitch(Chromatic.C, 5).build();

		assertEquals( PitchMidi.C5.getCode(), n.getCode() );
		assertEquals( 5, n.getOctave() );

		n = ChromaticMidi.builder().pitch(Chromatic.C.addSemi(5), 5).build();

		assertEquals( PitchMidi.from( 60 + 5 ).getCode(), n.getCode() );
		assertEquals( 5, n.getOctave() );

		n = ChromaticMidi.builder().pitch(Chromatic.C.addSemi(12), 5).build();

		assertEquals( PitchMidi.C5.getCode(), n.getCode() );
		assertEquals( 5, n.getOctave() );
	}
	
	@Test
	public void toDiatonic() {
		ChromaticMidi cm = ChromaticMidi.builder().pitch(Chromatic.F).build();
		DiatonicMidi dm = DiatonicMidi.from(cm, Tonality.C);
		Chromatic chromaticDm = ChromaticAdapter.from(dm);
		assertEquals(Chromatic.F, chromaticDm);
		cm = ChromaticMidi.builder().pitch(Chromatic.C).build();
		dm = DiatonicMidi.from(cm, Tonality.C);
		chromaticDm = ChromaticAdapter.from(dm);
		assertEquals(Chromatic.C, chromaticDm);
	}
	
	@Test
	public void equals() {
		ChromaticMidi cm = PitchMidi.C5.toMidi();
		ChromaticMidi cm2 = cm.clone();
		
		assertEquals(cm, cm2);
		
	}

	@Test
	public void fromBuilderChromaticAndOctave() {
		ChromaticMidi n = ChromaticMidi.builder()
				.pitch(Chromatic.C, 5 )
				.build();

		assertEquals( PitchMidi.C5, n.getPitchMidi() );
	}
}
