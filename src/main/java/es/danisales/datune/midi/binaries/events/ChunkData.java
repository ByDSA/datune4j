package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.binaries.Utils;
import es.danisales.io.binary.BinData;
import es.danisales.io.binary.BinEncoder;

import java.io.IOException;
import java.util.Arrays;

public abstract class ChunkData implements Event {
	private int delta;
	private byte status;
	private byte[] data;

	public abstract static class Builder<B, RET> extends es.danisales.utils.building.Builder<Builder<B, RET>, RET> {
		int delta = 0;

		public Builder<B, RET> delta(int delta) {
			this.delta = boundDelta(delta);

			return self();
		}
	}

	static int boundDelta(int delta) {
        return es.danisales.utils.Utils.bound(delta, 0, 65535); // 2 bytes
    }

	@SuppressWarnings("unused")
	static int getBinarySize(ChunkData self, BinEncoder.EncoderSettings settings) {
		byte[] deltaByte = Utils.deltaByte(self.delta);
		int l = deltaByte.length;

		return 1 + l + self.data.length;
	}

	protected static void encoder(ChunkData self, BinEncoder.EncoderSettings settings) {
		if (self.data == null)
			self.updateData();

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

	ChunkData(int delta, byte status) {
		this.delta = delta;
		this.status = status;
	}

	public void setDelta(int d) {
		delta = d;
	}

    final void updateData() {
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
    public boolean equals(Object o) {
        if (!(o instanceof ChunkData))
            return false;

        ChunkData casted = (ChunkData) o;

        return delta == casted.delta
                && status == casted.status
                && Arrays.equals(data, casted.data);
    }

	@Override
	public String toString() {
		return "Delta: " + delta + " Status: " + status + " Data: " + Arrays.toString(data);
	}
}
