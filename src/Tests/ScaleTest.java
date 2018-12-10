package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tonality.CustomScale;
import tonality.Scale;
import tonality.ScaleEnum;

public class ScaleTest {
	@Test
	public void _equals() {			
		Scale a = ScaleEnum.MAJOR;
		Scale b = ScaleEnum.MAJOR;
		
		assertTrue( a == b );
		assertEquals(a, b);
		
		b = new CustomScale( 2, 2, 1, 2, 2, 2, 1 );
		assertFalse( a == b );
		assertTrue( a.equals( b ));
		
		b = Scale.of( 2, 2, 1, 2, 2, 2, 1 );
		assertTrue( a == b );
		assertTrue( a.equals( b ));
		
		b = ScaleEnum.IONIAN;
		assertFalse( a ==  b );
		assertTrue( a.equals( b ));
	}
}
