package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class DiatonicMidiTest {
	int[]	diffM	= new int[] {
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
	int[]	diffm	= new int[] {
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

	@Test
	public void fromChromaticMidi() {
		ChromaticMidi cm = ChromaticMidi.builder().pitch(Chromatic.F).build();
		DiatonicMidi dm = DiatonicMidi.from(cm, Tonality.C);
		Chromatic chromaticDm = Chromatic.from(dm);
		assertEquals(Chromatic.F, chromaticDm);
		cm = ChromaticMidi.builder().pitch(Chromatic.C).build();
		dm = DiatonicMidi.from(cm, Tonality.C);
		chromaticDm = Chromatic.from(dm);
		assertEquals(Chromatic.C, chromaticDm);
	}

	@Test
	public void addNegative() {
		DiatonicMidi n = DiatonicMidi.builder()
				.pitch(DiatonicDegree.V, Tonality.E, 6)
				.build();
		DiatonicMidi n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.UNISON);
		assertEquals(PitchChromaticMidiInmutable.B6, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.SECOND);
		assertEquals(PitchChromaticMidiInmutable.A6, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.THIRD);
		assertEquals(PitchChromaticMidiInmutable.GG6, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.FOURTH);
		assertEquals(PitchChromaticMidiInmutable.FF6, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.FIFTH);
		assertEquals(PitchChromaticMidiInmutable.E6, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.SIXTH);
		assertEquals(PitchChromaticMidiInmutable.DD6, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.SEVENTH);
		assertEquals(PitchChromaticMidiInmutable.CC6, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.OCTAVE);
		assertEquals(PitchChromaticMidiInmutable.B5, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.NINTH);
		assertEquals(PitchChromaticMidiInmutable.A5, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.TENTH);
		assertEquals(PitchChromaticMidiInmutable.GG5, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shiftNegative(IntervalDiatonic.ELEVENTH);
		assertEquals(PitchChromaticMidiInmutable.FF5, n2.getPitch());

	}

	@Test
	public void add() {
		Tonality s = Tonality.from( Chromatic.FF, Scale.MIXOLYDIAN );
		DiatonicMidi n = DiatonicMidi.builder()
				.pitch(DiatonicDegree.I, s, 3)
				.build();
		assertEquals( 42, n.getPitch() );
		assertEquals( 3, n.getPitch().getOctave() );
		DiatonicMidi n2 = n.clone();
		n2.getPitch().shift(IntervalDiatonic.THIRD);
		assertEquals(46, n2.getPitch());
		n2 = n.clone();
		n2.getPitch().shift(IntervalDiatonic.FIFTH);
		assertEquals(49, n2);
		assertEquals(3, n2.getPitch().getOctave());
		n2 = n.clone();
		n2.getPitch().shift(IntervalDiatonic.SEVENTH);
		assertEquals(52, n2.getPitch());
	}

	@Test
	public void noteScaleAdd() {
		Tonality s = Tonality.from( Chromatic.C, Scale.MAJOR );
		DiatonicMidi n = DiatonicMidi.builder()
				.pitch(DiatonicDegree.I, s, 4)
				.build();

		for ( int i = 0; i < diffM.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.fromIndex( i+1 );
			DiatonicMidi n2 = n.clone();
			n2.getPitch().shift(id);
			int d1 = n2.getPitch().getMidiCode() - n.getPitch().getMidiCode();
			int d2 = diffM[i];
			assertEquals( d2, d1 );
		}

		s = Tonality.from( Chromatic.FF, Scale.MINOR );
		n = DiatonicMidi.builder()
				.pitch(DiatonicDegree.I, s, 4)
				.build();

		for ( int i = 0; i < diffm.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.fromIndex( i+1 );
			DiatonicMidi n2 = n.clone();
			n2.getPitch().shift(id);
			int d1 = n2.getPitch().getMidiCode() - n.getPitch().getMidiCode();
			int d2 = diffm[i];
			assertEquals("Error al añadir " + i + " posiciones a " + n, d2, d1);
		}

		n = DiatonicMidi.builder()
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
		for ( int i = 0; i < r.length; i++ ) {
			IntervalDiatonic id = IntervalDiatonic.fromIndex( i );
			DiatonicMidi n2 = n.clone();
			n2.getPitch().shift(id);
			int d1 = n2.getPitch().getMidiCode();
			assertEquals( "Error al añadir " + i + " posiciones a " + n, r[i], d1 );
		}
	}

	@Test
	public void equals() {
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
	public void cloneTest() {
		DiatonicMidi dm = DiatonicMidi.builder()
				.pitch(DiatonicDegree.I, Tonality.C, 5)
				.build();
		DiatonicMidi dm2 = dm.clone();
		assertEquals(dm2, dm);
		assertEquals(dm, dm2);
		assertNotSame(dm, dm2);
	}
}
