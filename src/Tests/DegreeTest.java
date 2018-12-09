package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import diatonic.ChromaticFunction;
import diatonic.Degree;

public class DegreeTest {
	@Test
	public void values() {
		assertEquals( 0, Degree.I.val() );
		assertEquals( 1, Degree.II.val() );
		assertEquals( 2, Degree.III.val() );
		assertEquals( 3, Degree.IV.val() );
		assertEquals( 4, Degree.V.val() );
		assertEquals( 5, Degree.VI.val() );
		assertEquals( 6, Degree.VII.val() );
	}
	
	@Test
	public void get() {
		assertEquals( Degree.I, Degree.get(-7) );
		assertEquals( Degree.II, Degree.get(-6) );
		assertEquals( Degree.III, Degree.get(-5) );
		assertEquals( Degree.IV, Degree.get(-4) );
		assertEquals( Degree.V, Degree.get(-3) );
		assertEquals( Degree.VI, Degree.get(-2) );
		assertEquals( Degree.VII, Degree.get(-1) );
		assertEquals( Degree.I, Degree.get(0) );
		assertEquals( Degree.II, Degree.get(1) );
		assertEquals( Degree.III, Degree.get(2) );
		assertEquals( Degree.IV, Degree.get(3) );
		assertEquals( Degree.V, Degree.get(4) );
		assertEquals( Degree.VI, Degree.get(5) );
		assertEquals( Degree.VII, Degree.get(6) );
		assertEquals( Degree.I, Degree.get(7) );
		assertEquals( Degree.II, Degree.get(8) );
		assertEquals( Degree.III, Degree.get(9) );
		assertEquals( Degree.IV, Degree.get(10) );
		assertEquals( Degree.V, Degree.get(11) );
		assertEquals( Degree.VI, Degree.get(12) );
		assertEquals( Degree.VII, Degree.get(13) );
	}
	
	@Test
	public void differentsValues() {
		Set<Integer> set = new HashSet();
		for(Degree d : Degree.values())
			set.add( d.val() );
		assertEquals(Degree.values().length, set.size());
	}
	
	@Test
	public void _toStringNotNull() {
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( cf.toString() );
		}
	}
}
