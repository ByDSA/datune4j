package es.danisales.datune;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DegreeTest {
	@Test
	public void values() {
		assertEquals( 0, DiatonicDegree.I.val() );
		assertEquals( 1, DiatonicDegree.II.val() );
		assertEquals( 2, DiatonicDegree.III.val() );
		assertEquals( 3, DiatonicDegree.IV.val() );
		assertEquals( 4, DiatonicDegree.V.val() );
		assertEquals( 5, DiatonicDegree.VI.val() );
		assertEquals( 6, DiatonicDegree.VII.val() );
	}
	
	@Test
	public void get() {
		assertEquals( DiatonicDegree.I, DiatonicDegree.fromIndex(-7) );
		assertEquals( DiatonicDegree.II, DiatonicDegree.fromIndex(-6) );
		assertEquals( DiatonicDegree.III, DiatonicDegree.fromIndex(-5) );
		assertEquals( DiatonicDegree.IV, DiatonicDegree.fromIndex(-4) );
		assertEquals( DiatonicDegree.V, DiatonicDegree.fromIndex(-3) );
		assertEquals( DiatonicDegree.VI, DiatonicDegree.fromIndex(-2) );
		assertEquals( DiatonicDegree.VII, DiatonicDegree.fromIndex(-1) );
		assertEquals( DiatonicDegree.I, DiatonicDegree.fromIndex(0) );
		assertEquals( DiatonicDegree.II, DiatonicDegree.fromIndex(1) );
		assertEquals( DiatonicDegree.III, DiatonicDegree.fromIndex(2) );
		assertEquals( DiatonicDegree.IV, DiatonicDegree.fromIndex(3) );
		assertEquals( DiatonicDegree.V, DiatonicDegree.fromIndex(4) );
		assertEquals( DiatonicDegree.VI, DiatonicDegree.fromIndex(5) );
		assertEquals( DiatonicDegree.VII, DiatonicDegree.fromIndex(6) );
		assertEquals( DiatonicDegree.I, DiatonicDegree.fromIndex(7) );
		assertEquals( DiatonicDegree.II, DiatonicDegree.fromIndex(8) );
		assertEquals( DiatonicDegree.III, DiatonicDegree.fromIndex(9) );
		assertEquals( DiatonicDegree.IV, DiatonicDegree.fromIndex(10) );
		assertEquals( DiatonicDegree.V, DiatonicDegree.fromIndex(11) );
		assertEquals( DiatonicDegree.VI, DiatonicDegree.fromIndex(12) );
		assertEquals( DiatonicDegree.VII, DiatonicDegree.fromIndex(13) );
	}
	
	@Test
	public void differentsValues() {
		Set<Integer> set = new HashSet();
		for(DiatonicDegree d : DiatonicDegree.values())
			set.add( d.val() );
		assertEquals(DiatonicDegree.values().length, set.size());
	}
	
	@Test
	public void _toStringNotNull() {
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( cf.toString() );
		}
	}
}
