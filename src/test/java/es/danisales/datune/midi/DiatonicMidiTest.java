package es.danisales.datune.midi;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class DiatonicMidiTest {
	@Test
	public void fromChromaticMidi() throws TonalityException, PitchMidiException {
        ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                .pitch(PitchChromaticMidi.F5)
				.build();

		DiatonicMidi diatonicMidi = DiatonicMidi.builder().from(chromaticMidi, Tonality.C).build();
        assertNotNull(diatonicMidi);
        assertEquals(
                PitchDiatonicMidi.from(DiatonicDegree.IV, Tonality.C, 5),
                diatonicMidi.getPitch()
        );
        assertEquals(chromaticMidi.getLength(), diatonicMidi.getLength());
        assertEquals(chromaticMidi.getVelocity(), diatonicMidi.getVelocity());
	}

	@Test
	public void aa() throws PitchMidiException {
		DiatonicMidi diatonicMidi = DiatonicMidi.builder()
                .pitch(DiatonicDegree.I, Tonality.C, 4)
				.build();
		assertEquals(DiatonicDegree.I, diatonicMidi.getPitch().getDegree());
	}

	@Test
	public void noteScaleAdd() throws PitchMidiException {
        Tonality s = Tonality.C;
		DiatonicMidi n = DiatonicMidi.builder()
				.pitch(DiatonicDegree.I, s, 4)
				.build();

        int[] diffM = new int[]{
                2,
                4,
                5,
                7,
                9,
                11,
                12,
                14,
                16
        };

        IntervalDiatonic intervalDiatonic = IntervalDiatonic.UNISON;
		for ( int i = 0; i < diffM.length; i++ ) {
            intervalDiatonic = intervalDiatonic.getNext();
            assertNotNull(intervalDiatonic);

            DiatonicMidi diatonicMidi = n.clone();
            diatonicMidi.getPitch().shift(intervalDiatonic);
            int d1 = diatonicMidi.getPitch().getMidiCode() - n.getPitch().getMidiCode();
			int d2 = diffM[i];
            assertEquals("" + i, d2, d1);
        }
    }

    @Test
	public void noteScaleAdd2() throws PitchMidiException {
        Tonality s = Tonality.FFm;
        DiatonicMidi n = DiatonicMidi.builder()
                .pitch(DiatonicDegree.I, s, 4)
                .build();

        int[] diffm = new int[]{
                2,
                3,
                5,
                7,
                8,
                10,
                12,
                14,
                15
        };

        IntervalDiatonic intervalDiatonic = IntervalDiatonic.UNISON;
        for (int i = 0; i < diffm.length; i++) {
            intervalDiatonic = intervalDiatonic.getNext();
            assertNotNull(intervalDiatonic);

            DiatonicMidi n2 = n.clone();
            n2.getPitch().shift(intervalDiatonic);
            int d1 = n2.getPitch().getMidiCode() - n.getPitch().getMidiCode();
            int d2 = diffm[i];
            assertEquals("Error al añadir " + i + " posiciones a " + n, d2, d1);
        }
    }

    @Test
	public void noteScaleAdd3() throws PitchMidiException {
        Tonality s = Tonality.FFm;
        DiatonicMidi n = DiatonicMidi.builder()
				.pitch(DiatonicDegree.VI, s, 4)
				.build();
		int[] r = new int[] {
				62,
				64,
				66,
				68,
				69,
				71,
				73,
				74
		};

        IntervalDiatonic intervalDiatonic = IntervalDiatonic.UNISON;
		for ( int i = 0; i < r.length; i++ ) {
            if (i > 0) {
                intervalDiatonic = intervalDiatonic.getNext();
                assertNotNull(intervalDiatonic);
            }

			DiatonicMidi n2 = n.clone();
            n2.getPitch().shift(intervalDiatonic);
			int d1 = n2.getPitch().getMidiCode();
			assertEquals( "Error al añadir " + i + " posiciones a " + n, r[i], d1 );
		}
	}

	@Test
	public void equals() throws PitchMidiException {
		DiatonicMidi dm = DiatonicMidi.builder()
				.pitch(DiatonicDegree.I, Tonality.C, 5)
				.build();
		DiatonicMidi dm2 = DiatonicMidi.builder()
				.pitch(DiatonicDegree.I, Tonality.C, 5)
				.build();
		assertEquals(dm2, dm);
		assertEquals(dm, dm2);
	}

	@Test
	public void cloneTest() throws PitchMidiException {
		DiatonicMidi dm = DiatonicMidi.builder()
				.pitch(DiatonicDegree.I, Tonality.C, 5)
				.build();
		DiatonicMidi dm2 = dm.clone();
		assertEquals(dm2, dm);
		assertEquals(dm, dm2);
		assertNotSame(dm, dm2);
	}
}
