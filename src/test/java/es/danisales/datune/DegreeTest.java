package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
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
		/*assertEquals( DiatonicDegree.I, DiatonicDegree.fromIndex(-7) );
		assertEquals( DiatonicDegree.II, DiatonicDegree.fromIndex(-6) );
		assertEquals( DiatonicDegree.III, DiatonicDegree.fromIndex(-5) );
		assertEquals( DiatonicDegree.IV, DiatonicDegree.fromIndex(-4) );
		assertEquals( DiatonicDegree.V, DiatonicDegree.fromIndex(-3) );
		assertEquals( DiatonicDegree.VI, DiatonicDegree.fromIndex(-2) );
		assertEquals( DiatonicDegree.VII, DiatonicDegree.fromIndex(-1) );*/
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
	public void differentsValues() {
		Set<Integer> set = new HashSet<>();
		for(DiatonicDegree d : DiatonicDegree.values())
			set.add( d.ordinal() );
		assertEquals(DiatonicDegree.values().length, set.size());
	}
	
	@Test
	public void _toStringNotNull() {
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( cf.toString() );
		}
	}
}
