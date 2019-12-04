package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.eventsequences.Track;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

public class KeySignatureEvent extends MetaEvent {
	private static final byte[] C_MAJOR = new byte[]{0, 0};
	private static final byte[] C_SHARP_MAJOR = new byte[]{7, 0};
	private static final byte[] D_MAJOR = new byte[]{2, 0};
	private static final byte[] E_BEMOL_MAJOR = new byte[]{-3, 0};
	private static final byte[] E_MAJOR = new byte[]{4, 0};
	private static final byte[] F_MAJOR = new byte[]{-1, 0};
	private static final byte[] F_SHARP_MAJOR = new byte[]{6, 0};
	private static final byte[] G_MAJOR = new byte[]{1, 0};
	private static final byte[] A_BEMOL_MAJOR = new byte[]{-4, 0};
	private static final byte[] A_MAJOR = new byte[]{3, 0};
	private static final byte[] B_BEMOL_MAJOR = new byte[]{-2, 0};
	private static final byte[] B_MAJOR = new byte[]{5, 0};

	private static final byte[] C_MINOR = new byte[]{-3, 1};
	private static final byte[] C_SHARP_MINOR = new byte[]{4, 1};
	private static final byte[] D_MINOR = new byte[]{-1, 1};
	private static final byte[] E_BEMOL_MINOR = new byte[]{-5, 1};
	private static final byte[] E_MINOR = new byte[]{1, 1};
	private static final byte[] F_MINOR = new byte[]{-4, 1};
	private static final byte[] F_SHARP_MINOR = new byte[]{3, 1};
	private static final byte[] G_MINOR = new byte[]{-2, 1};
	private static final byte[] A_BEMOL_MINOR = new byte[]{5, 1};
	private static final byte[] A_MINOR = new byte[]{0, 1};
	private static final byte[] B_BEMOL_MINOR = new byte[]{-5, 1};
	private static final byte[] B_MINOR = new byte[]{2, 1};

	public Track channel;

	private Tonality tonality;

	public KeySignatureEvent(int d, Tonality s) {
		super(d, (byte)0x59);
		tonality = s;
	}
	
	public KeySignatureEvent(Tonality s) {
		this(0, s);
	}

	@Override
	protected byte[] getMetaBytes() {
		Scale scale = tonality.getScale();
		DiatonicAlt diatonicAlt = tonality.getRoot();
		Chromatic note = Chromatic.from( diatonicAlt );
		byte[] bytes;

		if (scale.equals(Scale.MAJOR)) {
			bytes = major(note);
		} else if (scale.equals(Scale.MINOR)) {
			bytes = minor(note);
		} else
			bytes = minor(note); // TODO

		setData(bytes);

		return super.getMetaBytes();
	}
	
	public Tonality getTonality() {
		return tonality;
	}

	protected byte[] major(@NonNull Chromatic chromatic) {
		switch (chromatic) {
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

		throw NeverHappensException.switchOf(chromatic);
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
		DiatonicAlt note = tonality.getRoot();
		StringBuilder sb = new StringBuilder();

        sb.append("KeySignature: " + note);

		if (scale.equals(Scale.MAJOR)) {
			sb.append(" Mayor");
		} else if (scale.equals(Scale.MINOR)) {
			sb.append(" Menor");
		}
		
		return sb.toString();
	}
}
