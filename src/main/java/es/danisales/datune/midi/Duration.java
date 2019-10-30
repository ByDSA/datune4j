package es.danisales.datune.midi;

public class Duration {
	private Duration() {
	}

	public final static int V256 = 15;
	public final static int V128 = 2*V256;
	public final static int V64 = 2*V128;
	public final static int V32 = 2*V64;
	public final static int V16 = 2*V32;
	public final static int V8 = 2*V16;
	public final static int V4 = 2*V8;
	public final static int V2 = 2*V4;
	public final static int V1 = 2*V2;

	public final static int V128D = V128 + V256;
	public final static int V64D = V64 + V128;
	public final static int V32D = V32 + V64;
	public final static int V16D = V16 + V32;
	public final static int V8D = V8 + V16;
	public final static int V4D = V4 + V8;
	public final static int V2D = V2 + V4;
	public final static int V1D = V1 + V2;

	public final static int V2_3 = (int)Math.round(V2/3.0);
	public final static int V4_3 = (int)Math.round(V4/3.0);
	public final static int V8_3 = (int)Math.round(V8/3.0);
}
