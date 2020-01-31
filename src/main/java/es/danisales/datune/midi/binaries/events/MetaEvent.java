package es.danisales.datune.midi.binaries.events;

import es.danisales.io.binary.BinEncoder;

import java.io.IOException;

public abstract class MetaEvent extends ChunkData {
	private static final byte STATUS = (byte) 0xFF;
	byte type;

	protected MetaEvent(int delta, byte type) {
		super(delta, STATUS);

		this.type = type;
	}

	static void getMetaBytes(MetaEvent self, BinEncoder.EncoderSettings settings) {
		byte[] ret = new byte[4 + self.getData().length];
		ret[0] = (byte) self.getDelta();
		ret[1] = self.getStatus();
		ret[2] = self.type;
		ret[3] = (byte) self.getData().length;
		System.arraycopy(self.getData(), 0, ret, 4, self.getData().length);

		try {
			settings.getDataOutputStream().write(ret);
		} catch (IOException ignored) {
		}
	}
}
