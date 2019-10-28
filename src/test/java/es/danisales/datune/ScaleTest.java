package es.danisales.datune;

import es.danisales.datune.tonality.CustomScale;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleEnum;
import org.junit.Test;

import static org.junit.Assert.*;

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
