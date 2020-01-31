package es.danisales.datune.midi.binaries.events;

import es.danisales.io.binary.BinEncoder;

public class Header extends Chunk {
    public static final byte[] TICKS_DEFAULT = new byte[]{0x03, (byte) 0xc0};

    static {
        BinEncoder.register(Header.class, BinEncoder.getEncondingFunction(Chunk.class));
    }

	// Standard MIDI file header, for one-track file
	// 4D, 54... are just magic numbers to identify the
	//  headers
	// Note that because we're only writing one track, we
	//  can for simplicity combine the file and track headers
	public enum Type {
		SINGLE_TRACK((byte)0x00), MULTIPLE_TRACK((byte)0x01), MULTIPLE_SONG((byte)0x02);

		private byte byteValue;

		Type(byte b) {
			byteValue = b;
		}

		public byte getByte() {
			return byteValue;
		}
	}

	private int tracks;
	private byte[] ticks;
	private Type type;

	public Header(Type type, int tracks, byte[] ticks) {
		super(new byte[]{'M', 'T', 'h', 'd'}); // 0x4d, 0x54, 0x68, 0x64

		this.type = type;
		this.tracks = tracks;
		this.ticks = ticks;

        addData(new byte[]{0x00, type.getByte(), // track format
				0x00, (byte)tracks, // tracks
				ticks[0], ticks[1], // 16 ticks per quarter
		});
	}

	@Override
	public Header clone() {
		return new Header(type, tracks, ticks.clone());
	}
}
