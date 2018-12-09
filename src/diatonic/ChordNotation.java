package diatonic;

/**
 * Clase auxiliar para nombrar acordes
 */
public final class ChordNotation {
	
	/** The Constant INV. */
	public static final String INV = "Inv";
	
	/** The Constant DUPLICATED. */
	public static final String DUPLICATED = " (dup)";
	
	/** The Constant POWER_CHORD. */
	public static final String POWER_CHORD = "5";
	
	/** The Constant MAJOR. */
	public static final String MAJOR = "";
	
	/** The Constant MAJOR2. */
	public static final String MAJOR2 = "Maj";
	
	/** The Constant MINOR. */
	public static final String MINOR = "m";
	
	/** The Constant MINOR2. */
	public static final String MINOR2 = MINOR;
	
	/** The Constant AUGMENTED. */
	public static final String AUGMENTED = "+";
	
	/** The Constant AUGMENTED2. */
	public static final String AUGMENTED2 = "#";
	
	/** The Constant DIMINISHED. */
	public static final String DIMINISHED = "dim";
	
	/** The Constant DIMINISHED2. */
	public static final String DIMINISHED2 = "b";
	
	/** The Constant SUS. */
	public static final String SUS = "sus";
	
	/** The Constant SUS4. */
	public static final String SUS4 = SUS + "4";
	
	/** The Constant SUS2. */
	public static final String SUS2 = SUS + "2";
	
	/** The Constant SUSb2. */
	public static final String SUSb2 = SUS + "(" + DIMINISHED2 + "2)";
	
	/** The Constant SUSb2b5. */
	public static final String SUSb2b5 = SUS + "(" + DIMINISHED2 + "2)" + DIMINISHED2 + "5";
	
	/** The Constant SUSb4. */
	public static final String SUSb4 = SUS + "(" + DIMINISHED2+ "4)";
	
	/** The Constant SUSa4. */
	public static final String SUSa4 = SUS + "(" + AUGMENTED2 + "4)";
	
	/** The Constant OMIT3. */
	public static final String OMIT3 = omit("3");
	
	/** The Constant OMIT7. */
	public static final String OMIT7 = omit("7");
	
	/** The Constant SIXTH. */
	public static final String SIXTH = "6";
	
	/** The Constant SEVENTH. */
	public static final String SEVENTH = "7";
	
	/** The Constant FIFTH. */
	public static final String FIFTH = "5";
	
	/** The Constant NINTH. */
	public static final String NINTH = "9";
	
	/** The Constant ELEVENTH. */
	public static final String ELEVENTH = "11";
	
	/** The Constant THIRTEEN. */
	public static final String THIRTEEN = "13";
	
	/** The Constant b5. */
	public static final String b5 = DIMINISHED2 + FIFTH;
	
	/** The Constant b9. */
	public static final String b9 = DIMINISHED2 + NINTH;
	
	/** The Constant a5. */
	public static final String a5 = AUGMENTED2 + FIFTH;
	
	/** The Constant a9. */
	public static final String a9 = AUGMENTED2 + NINTH;
	
	/** The Constant a11. */
	public static final String a11 = AUGMENTED2 + ELEVENTH;
	
	/** The Constant ADD. */
	public static final String ADD = "add";
	
	/** The Constant ADD_SIXTH. */
	public static final String ADD_SIXTH = ADD + SIXTH;
	
	/** The Constant ADD_NINTH. */
	public static final String ADD_NINTH = ADD + NINTH;
	
	/** The Constant ADD_ELEVENTH. */
	public static final String ADD_ELEVENTH = ADD + ELEVENTH;
	
	/** The Constant ADD_THIRTEEN. */
	public static final String ADD_THIRTEEN = ADD + THIRTEEN;
	
	/** The Constant EMPTY_CHORD. */
	public static final String EMPTY_CHORD = "(Empty chord)";
	
	/**
	 * Omit.
	 *
	 * @param s the s
	 * @return the string
	 */
	private static String omit(String s) {
		return " (no" + s + ")";
	}
	
}
