package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.eventsequences.Track;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityModern;
import es.danisales.io.binary.BinEncoder;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.BiConsumer;

public class KeySignatureEvent extends MetaEvent {
	static {
		BinEncoder.register(KeySignatureEvent.class, (BiConsumer<KeySignatureEvent, BinEncoder.EncoderSettings>) MetaEvent::getMetaBytes);
	}

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

	private static final byte STATUS = (byte) 0x59;

	public Track channel;
	private TonalityModern tonality;

	private KeySignatureEvent(int delta, TonalityModern tonality) {
		super(delta, STATUS);
		this.tonality = tonality;
	}
	
	private KeySignatureEvent(TonalityModern tonality) {
		this(0, tonality);
	}

	public static @NonNull KeySignatureEvent from(TonalityModern tonality) {
		return new KeySignatureEvent(tonality);
	}

	@Override
	protected byte[] generateData() {
		Scale scale = tonality.getScale();
		Chromatic root = tonality.getRoot();
		byte[] bytes;

		if (scale.equals(Scale.MAJOR)) {
			bytes = majorTonalityFrom(root);
		} else if (scale.equals(Scale.MINOR)) {
			bytes = minorTonalityFrom(root);
		} else
			bytes = majorTonalityFrom(root);

		return bytes;
	}

	@Override
	public ChunkData clone() {
		return new KeySignatureEvent(getDelta(), tonality.clone());
	}

	public Tonality getTonality() {
		return tonality;
	}

	@SuppressWarnings("Duplicates")
	private static byte[] majorTonalityFrom(@NonNull Chromatic chromatic) {
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

	@SuppressWarnings("Duplicates")
	private static byte[] minorTonalityFrom(Chromatic chromatic) {
		switch(chromatic) {
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
		return "KeySignature: " + tonality;
	}
}
