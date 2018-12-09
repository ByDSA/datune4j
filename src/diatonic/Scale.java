package diatonic;

import java.util.Arrays;
import java.util.Collections;

public interface Scale {
	public int[] val();
	
	/**
	 * Returns the m mode of the scale
	 * @param m number of rotations
	 * @return the mode of the scale
	 */
	default Scale getMode(int m) {
		Integer[] neww = Arrays.stream( this.val() ).boxed().toArray( Integer[]::new );

		Collections.rotate(
			Arrays.asList( neww ), -m
		);
		return new CustomScale( Arrays.stream( neww ).mapToInt( Integer::intValue ).toArray() );
	}
	
	/**
	 * Get all modes from the scale
	 * @return the array within all modes from the scale
	 */
	default Scale[] getAllModes() {
		Scale[] ret = new ScaleEnum[length()];
		for ( int i = 0; i < length(); i++ )
			ret[i] = getMode( i );

		return ret;
	}
	
	public int length();
	
	public int get(int n);
	
	/**
	 * The diatonic scale is obtained from a chain of six successive fifths
It is either a sequence of successive natural notes or a transposition thereof.
It can be written using seven consecutive notes without accidentals on a staff with no key signature or, when transposed, with a conventional key signature or with accidentals.
	 * @return if it's diatonic
	 */
	default boolean isDiatonic() {
		for ( ScaleEnum s : ScaleEnum.DIATONICS )
			if ( this.equals( s ) )
				return true;
		return false;
	}
	
	default int trim(int n) {
		while ( n < 0 )
			n += length();
		n %= length();

		return n;
	}
	
	default String dist() {
		StringBuilder sb = new StringBuilder();
		sb.append( val()[0] );
		for ( int j = 1; j < val().length; j++ )
			sb.append( "-" + val()[j] );

		return sb.toString();
	}

	default Scale showDist() {
		System.out.println( Arrays.toString( val() ) );
		return this;
	}
	
	default boolean equals(Scale s) {
		if (this instanceof ScaleEnum && s instanceof ScaleEnum && ((ScaleEnum)this) == (ScaleEnum)s) {
			return true;
		}
		
		return Arrays.equals( val(), s.val() );
	}

	public static Scale of(int... v) {
		Scale s = ScaleEnum.of( v );
		if (s == null)
			s = new CustomScale( v );
		return s;
	}
}
