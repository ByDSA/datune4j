package es.danisales.datune;

import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.interval.IntervalDiatonic;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DegreeTest {
	@Test
	public void values() {
		assertEquals( 0, DiatonicDegree.I.ordinal() );
		assertEquals( 1, DiatonicDegree.II.ordinal() );
		assertEquals( 2, DiatonicDegree.III.ordinal() );
		assertEquals( 3, DiatonicDegree.IV.ordinal() );
		assertEquals( 4, DiatonicDegree.V.ordinal() );
		assertEquals( 5, DiatonicDegree.VI.ordinal() );
		assertEquals( 6, DiatonicDegree.VII.ordinal() );
	}
	
	@Test
	public void get() {
		assertEquals( DiatonicDegree.I, DiatonicDegree.from(IntervalDiatonic.UNISON) );
		assertEquals( DiatonicDegree.II, DiatonicDegree.from(IntervalDiatonic.SECOND) );
		assertEquals( DiatonicDegree.III, DiatonicDegree.from(IntervalDiatonic.THIRD) );
		assertEquals( DiatonicDegree.IV, DiatonicDegree.from(IntervalDiatonic.FOURTH) );
		assertEquals( DiatonicDegree.V, DiatonicDegree.from(IntervalDiatonic.FIFTH) );
		assertEquals( DiatonicDegree.VI, DiatonicDegree.from(IntervalDiatonic.SIXTH) );
		assertEquals( DiatonicDegree.VII, DiatonicDegree.from(IntervalDiatonic.SEVENTH) );
		assertEquals( DiatonicDegree.I, DiatonicDegree.from(IntervalDiatonic.OCTAVE) );
		assertEquals( DiatonicDegree.II, DiatonicDegree.from(IntervalDiatonic.NINTH) );
		assertEquals( DiatonicDegree.III, DiatonicDegree.from(IntervalDiatonic.TENTH) );
		assertEquals( DiatonicDegree.IV, DiatonicDegree.from(IntervalDiatonic.ELEVENTH) );
		assertEquals( DiatonicDegree.V, DiatonicDegree.from(IntervalDiatonic.TWELFTH) );
		assertEquals( DiatonicDegree.VI, DiatonicDegree.from(IntervalDiatonic.THIRTEENTH) );
		assertEquals( DiatonicDegree.VII, DiatonicDegree.from(IntervalDiatonic.FOURTEENTH) );
	}
	
	@Test
	public void differentValues() {
		Set<Integer> set = new HashSet<>();
		for(DiatonicDegree d : DiatonicDegree.values())
			set.add( d.ordinal() );
		assertEquals(DiatonicDegree.values().length, set.size());
	}
	
	@Test
	public void _toStringNotNull() {
		for (ChromaticDegreeFunction cf : SecondaryDominant.values()) {
			assertNotNull( cf.toString() );
		}
	}
}
