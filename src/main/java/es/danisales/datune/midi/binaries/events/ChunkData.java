package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.binaries.Utils;
import es.danisales.io.binary.BinData;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public abstract class ChunkData implements Event {
	int delta;
	byte status;
	byte[] data;

	ChunkData(int d, byte s) {
		delta = d;
		setStatus(s);
	}

	public ChunkData(byte s) {
		this(0, s);
	}

	public void setDelta(int d) {
		delta = d;
	}

	protected void setData(byte[] da) {
		data = da;
	}

	public void setStatus(byte s) {
		status = s;
	}

	public byte[] getData() {
		return data;
	}

	public int sizeBytes() {
		byte[] deltaByte = Utils.deltaByte(delta);
		int l = deltaByte.length;

		return 1+l+data.length;
	}

	public void writeInto(DataOutputStream dataOutputStream, ByteArrayOutputStream buff) {
		if (data == null)
			throw new NullPointerException("No se ha especificado 'data'");

		byte[] deltaByte = Utils.deltaByte(delta);
		BinData.encoder()
				.from(deltaByte)
				.to(dataOutputStream, buff)
				.putIntoStream();

		BinData.encoder()
				.from(status)
				.to(dataOutputStream, buff)
				.putIntoStream();

		BinData.encoder()
				.from(data)
				.to(dataOutputStream, buff)
				.putIntoStream();
	}

	void cloneInto(ChunkData cd) {
		cd.delta = delta;
		cd.status = status;
		int len = data.length;
		cd.data = new byte[len];
		System.arraycopy(data, 0, cd.data, 0, len);
	}
	
	public abstract ChunkData clone();
}
