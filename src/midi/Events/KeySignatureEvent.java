package midi.Events;

import eventsequences.Track;
import pitch.Chromatic;
import pitch.ChromaticMidi;
import tonality.Scale;
import tonality.ScaleEnum;
import tonality.Tonality;

public class KeySignatureEvent extends MetaEvent {
	static final byte[] C_MAJOR = new byte[]{0, 0};
	static final byte[] C_SHARP_MAJOR = new byte[]{7, 0};
	static final byte[] D_MAJOR = new byte[]{2, 0};
	static final byte[] E_BEMOL_MAJOR = new byte[]{-3, 0};
	static final byte[] E_MAJOR = new byte[]{4, 0};
	static final byte[] F_MAJOR = new byte[]{-1, 0};
	static final byte[] F_SHARP_MAJOR = new byte[]{6, 0};
	static final byte[] G_MAJOR = new byte[]{1, 0};
	static final byte[] A_BEMOL_MAJOR = new byte[]{-4, 0};
	static final byte[] A_MAJOR = new byte[]{3, 0};
	static final byte[] B_BEMOL_MAJOR = new byte[]{-2, 0};
	static final byte[] B_MAJOR = new byte[]{5, 0};
	
	static final byte[] C_MINOR = new byte[]{-3, 1};
	static final byte[] C_SHARP_MINOR = new byte[]{4, 1};
	static final byte[] D_MINOR = new byte[]{-1, 1};
	static final byte[] E_BEMOL_MINOR = new byte[]{-5, 1};
	static final byte[] E_MINOR = new byte[]{1, 1};
	static final byte[] F_MINOR = new byte[]{-4, 1};
	static final byte[] F_SHARP_MINOR = new byte[]{3, 1};
	static final byte[] G_MINOR = new byte[]{-2, 1};
	static final byte[] A_BEMOL_MINOR = new byte[]{5, 1};
	static final byte[] A_MINOR = new byte[]{0, 1};
	static final byte[] B_BEMOL_MINOR = new byte[]{-5, 1};
	static final byte[] B_MINOR = new byte[]{2, 1};

	public Track channel;

	Tonality tonality;

	public KeySignatureEvent(int d, Tonality s) {
		super(d, (byte)0x59);
		tonality = s;
	}
	
	public KeySignatureEvent(Tonality s) {
		this(0, s);
	}

	public byte[] get() {
		Scale scale = tonality.getScale();
		Chromatic note = tonality.getRoot();
		byte[] bytes = null; 

		if (scale.equals(ScaleEnum.MAJOR)) {
			bytes = major(note);
		} else if (scale.equals(ScaleEnum.MINOR)) {
			bytes = minor(note);
		} else
			bytes = minor(note); // TODO

		setData(bytes);

		return super.get();
	}
	
	public Tonality getScale() {
		return tonality;
	}

	protected byte[] major(Chromatic note) {
		switch(note) {
		case C: return C_MAJOR;
		case CC: return C_SHARP_MAJOR;
		case D: return D_MAJOR;
		case DD: return E_BEMOL_MAJOR;
		case E: return E_MAJOR;
		case F: return F_MAJOR;
		case FF: return F_SHARP_MAJOR;
		case G: return G_MAJOR;
		case GG: return A_BEMOL_MAJOR;
		case A: return A_MAJOR;
		case AA: return B_BEMOL_MAJOR;
		case B: return B_MAJOR;
		}

		return null;
	}
	
	protected byte[] minor(Chromatic note) {
		switch(note) {
		case C: return C_MINOR;
		case CC: return C_SHARP_MINOR;
		case D: return D_MINOR;
		case DD: return E_BEMOL_MINOR;
		case E: return E_MINOR;
		case F: return F_MINOR;
		case FF: return F_SHARP_MINOR;
		case G: return G_MINOR;
		case GG: return A_BEMOL_MINOR;
		case A: return A_MINOR;
		case AA: return B_BEMOL_MINOR;
		case B: return B_MINOR;
		}

		return null;
	}
	
	public String toString() {
		Scale scale = tonality.getScale();
		Chromatic note = tonality.getRoot();
		StringBuilder sb = new StringBuilder();
		
		sb.append("KeySignature: " + ChromaticMidi.literal(note, tonality));

		if (scale.equals(ScaleEnum.MAJOR)) {
			sb.append(" Mayor");
		} else if (scale.equals(ScaleEnum.MINOR)) {
			sb.append(" Menor");
		}
		
		return sb.toString();
	}
}
