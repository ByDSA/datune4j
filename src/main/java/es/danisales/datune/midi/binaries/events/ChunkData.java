package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.binaries.Utils;
import es.danisales.io.binary.BinData;
import es.danisales.io.binary.BinEncoder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

abstract class ChunkData implements Event {
	private int delta;
	private byte status;
	private byte[] data;

	ChunkData(int delta, byte status) {
		this.delta = delta;
		setStatus(status);
	}

	public void setDelta(int d) {
		delta = d;
	}

	protected final void updateData() {
		data = generateData();
	}

	protected abstract byte[] generateData();

	void setStatus(byte s) {
		status = s;
	}

	byte[] getData() {
		return data;
	}

	int getDelta() {
		return delta;
	}

	byte getStatus() {
		return status;
	}

	@SuppressWarnings("unused")
	static int getBinarySize(ChunkData self, BinEncoder.EncoderSettings settings) {
		byte[] deltaByte = Utils.deltaByte(self.delta);
		int l = deltaByte.length;

		return 1 + l + self.data.length;
	}

	static void encoder(ChunkData self, BinEncoder.EncoderSettings settings) {
		Objects.requireNonNull(self.data);

		byte[] deltaByte = Utils.deltaByte(self.delta);
		try {
			settings.getDataOutputStream().write(deltaByte);

			BinData.encoder()
					.from(self.status)
					.toStream(settings.getDataOutputStream(), settings.getByteArrayOutputStream())
					.putIntoStream();

			settings.getDataOutputStream().write(self.data);

		} catch (IOException ignored) {
		}
	}

	protected void assign(ChunkData cd) {
		cd.delta = delta;
		cd.status = status;
		int len = data.length;
		cd.data = new byte[len];
		System.arraycopy(data, 0, cd.data, 0, len);
	}

	public abstract ChunkData clone();

	@Override
	public int hashCode() {
		return Integer.hashCode(delta) + Byte.hashCode(status) + Arrays.hashCode(data);
	}

	@Override
	public String toString() {
		return "Delta: " + delta + " Status: " + status + " Data: " + Arrays.toString(data);
	}
}
