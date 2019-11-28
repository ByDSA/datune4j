package es.danisales.datune.midi;

public class Duration {
	private Duration() {
	}

	/**
	 * Base Length
	 */

	@SuppressWarnings("WeakerAccess")
	public final static int L256 = 15;
	@SuppressWarnings("WeakerAccess")
	public final static int L128 = 2 * L256;
	@SuppressWarnings("WeakerAccess")
	public final static int L64 = 2 * L128;
	public final static int L32 = 2 * L64;
	public final static int L16 = 2 * L32;
	public final static int L8 = 2 * L16;
	public final static int L4 = 2 * L8;
	public final static int L2 = 2 * L4;
	public final static int L1 = 2 * L2;

	/**
	 * Dotted
	 */

	@SuppressWarnings("unused")
	public final static int L128D = dotted(L128);
	@SuppressWarnings("unused")
	public final static int L64D = dotted(L64);
	@SuppressWarnings("unused")
	public final static int L32D = dotted(L32);
	@SuppressWarnings("unused")
	public final static int L16D = dotted(L16);
	@SuppressWarnings("unused")
	public final static int L8D = dotted(L8);
	@SuppressWarnings("unused")
	public final static int L4D = dotted(L4);
	@SuppressWarnings("unused")
	public final static int L2D = dotted(L2);
	@SuppressWarnings("unused")
	public final static int L1D = dotted(L1);

	/**
	 * Triplet
	 */

	public final static int L2_3 = triplet(L2);
	public final static int L4_3 = triplet(L4);
	@SuppressWarnings("unused")
	public final static int L8_3 = triplet(L8);


	@SuppressWarnings("WeakerAccess")
	public static int dotted(int length) {
		return length + length/2;
	}

	@SuppressWarnings("WeakerAccess")
	public static int triplet(int length) {
		return Math.round(length / 3.0f);
	}
}
