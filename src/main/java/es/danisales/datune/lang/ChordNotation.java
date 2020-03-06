package es.danisales.datune.lang;

/**
 * Clase auxiliar para nombrar acordes
 */
@SuppressWarnings("WeakerAccess")
public final class ChordNotation {
	public static final String FLAT = "b";
	public static final String SHARP = "#";

	public static final String POWER_CHORD = "5";
	public static final String MAJOR = "";
	public static final String MAJOR2 = "Maj";
	public static final String MINOR = "m";
	public static final String MINOR2 = MINOR;
	public static final String AUGMENTED = "+";
	public static final String AUGMENTED2 = SHARP;
	public static final String DIMINISHED = "dim";
	public static final String DIMINISHED2 = FLAT;
	public static final String SUS = "sus";
	public static final String SUS4 = SUS + "4";
	public static final String SUSb2 = SUS + "(" + DIMINISHED2 + "2)";
	public static final String SUSb2b5 = SUS + "(" + DIMINISHED2 + "2)" + DIMINISHED2 + "5";
	public static final String SUSa4 = SUS + "(" + AUGMENTED2 + "4)";
	public static final String OMIT11 = omit("11");

	public static final String SIXTH = "6";
	public static final String SEVENTH = "7";
	public static final String FIFTH = "5";
	public static final String NINTH = "9";
	public static final String ELEVENTH = "11";
	public static final String THIRTEEN = "13";
	public static final String b5 = DIMINISHED2 + FIFTH;
	public static final String b9 = DIMINISHED2 + NINTH;
	public static final String a5 = AUGMENTED2 + FIFTH;
	public static final String a9 = AUGMENTED2 + NINTH;
	public static final String a11 = AUGMENTED2 + ELEVENTH;
    public static final String ADD = "add";
	public static final String ADD_SIXTH = ADD + SIXTH;
	public static final String ADD_NINTH = ADD + NINTH;
	public static final String ADD_ELEVENTH = ADD + ELEVENTH;
	public static final String ADD_THIRTEEN = ADD + THIRTEEN;
	public static final String EMPTY_CHORD = "(Empty chord)";

	@SuppressWarnings("SameParameterValue")
	private static String omit(String s) {
		return " (omit" + s + ")";
	}
	
}
