package diatonic;

/**
 * Grado
 */
public enum Degree {
	I(0), II(1), III(2), IV(3), V(4), VI(5), VII(6);

	private int value;

	private Degree(int v) {
		value = v;
	}

	/**
	 * Value
	 *
	 * @return the int value
	 */
	public int val() {
		return value; 
	}

	/**
	 * Returns the degree with the added integer value
	 *
	 * @param n the added degrees
	 * @return the new degree
	 */
	public Degree add(int n) {
		return get( value + n );
	}

	/**
	 * Returns the degree with the added interval diatonic
	 *
	 * @param id the id
	 * @return the degree
	 */
	public Degree add(IntervalDiatonic id) {
		return add( id.val() );
	}

	/**
	 * Gets the degree from an int
	 *
	 * @param n the n
	 * @return the degree
	 */
	public static Degree get(int n) {
		n = n % IntervalDiatonic.OCTAVE.val();
		if ( n < 0 )
			n += IntervalDiatonic.OCTAVE.val();
		switch ( n ) {
			case 0:
				return I;
			case 1:
				return II;
			case 2:
				return III;
			case 3:
				return IV;
			case 4:
				return V;
			case 5:
				return VI;
			case 6:
				return VII;
			default:
				return null;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		switch ( this ) {
			case I:
				return "I";
			case II:
				return "II";
			case III:
				return "III";
			case IV:
				return "IV";
			case V:
				return "V";
			case VI:
				return "VI";
			case VII:
				return "VII";
			default:
				return null;
		}
	}
}
