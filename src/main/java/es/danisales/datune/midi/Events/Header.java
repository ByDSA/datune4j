package es.danisales.datune.midi.Events;

public class Header extends Chunk {
	// Standard MIDI file header, for one-track file
	// 4D, 54... are just magic numbers to identify the
	//  headers
	// Note that because we're only writing one track, we
	//  can for simplicity combine the file and track headers
	public final static byte SINGLE_TRACK = 0x00;
	public final static byte MULTIPLE_TRACK = 0x01;
	public final static byte MULTIPLE_SONG = 0x02;
	
	int tracks;
	byte[] ticks;
	byte type;

	public Header(byte type, int tracks, byte[] ticks) {
		super(new byte[]{'M', 'T', 'h', 'd'}); // 0x4d, 0x54, 0x68, 0x64
		this.type = type;
		this.tracks = tracks;
		this.ticks = ticks;

		add( new byte[]{ 0x00, type, // single-track format
				0x00, (byte)tracks, // tracks
				ticks[0], ticks[1], // 16 ticks per quarter
		});
	}

	@Override
	public Header clone() {
		return new Header(type, tracks, ticks.clone());
	}
}
