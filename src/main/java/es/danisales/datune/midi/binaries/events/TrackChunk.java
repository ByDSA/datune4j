package es.danisales.datune.midi.binaries.events;

import es.danisales.io.binary.BinEncoder;

public class TrackChunk extends Chunk {
	static {
		BinEncoder.register(TrackChunk.class, BinEncoder.getEncondingFunction(Chunk.class));
		/*BinSize.registerSize(TrackChunk.class, (TrackChunk self, BinEncoder.EncoderSettings settings) -> {
			return
		});*/
	}

	public TrackChunk() {
		super(new byte[]{'M', 'T', 'r', 'k'}); // 0x4d, 0x54, 0x68, 0x64
	}

	@Override
	public TrackChunk clone() {
		return new TrackChunk();
	}
}
