package midi.Events;

import java.nio.ByteBuffer;

import eventsequences.Melody;
import midi.Utils;

public abstract class ChunkData implements Event {
	protected int delta;
	protected byte status;
	byte[] data;

	public ChunkData(int d, byte s) {
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

	protected void cloneInto(ChunkData cd) {
		cd.delta = delta;
		cd.status = status;
		int len = data.length;
		cd.data = new byte[len];
		for(int i = 0; i < len; i++)
			cd.data[i] = data[i];
	}

	@Override
	public void read(ByteBuffer buff) {
		// TODO Auto-generated method stub

	}
	
	public abstract ChunkData clone();
}
