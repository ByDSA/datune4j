package es.danisales.datune.midi.Events;

import es.danisales.datune.midi.Utils;

import java.nio.ByteBuffer;

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

	@Override
	public int sizeBytes() {
		byte[] deltaByte = Utils.deltaByte(delta);
		int l = deltaByte.length;

		return 1+l+data.length;
	}

	@Override
	public void write(ByteBuffer buff) {
		if (data == null)
			throw new NullPointerException("No se ha especificado 'data'");

		byte[] deltaByte = Utils.deltaByte(delta);
		buff.put( deltaByte );
		buff.put( status );
		buff.put( data );
	}

	void cloneInto(ChunkData cd) {
		cd.delta = delta;
		cd.status = status;
		int len = data.length;
		cd.data = new byte[len];
		System.arraycopy(data, 0, cd.data, 0, len);
	}

	@Override
	public void read(ByteBuffer buff) {
		// TODO Auto-generated method stub

	}
	
	public abstract ChunkData clone();
}
