package es.danisales.datune.midi.binaries.events;

public class TrackChunk extends Chunk {
	public TrackChunk() {
		super(new byte[]{'M', 'T', 'r', 'k'}); // 0x4d, 0x54, 0x68, 0x64
	}
}
