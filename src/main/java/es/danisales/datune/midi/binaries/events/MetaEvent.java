package es.danisales.datune.midi.binaries.events;

public class MetaEvent extends ChunkData {
	byte type;
	
	private MetaEvent() {
		super(0, (byte) 0);
	}
	
	protected MetaEvent(int d, byte t) {
		super(d, (byte)0xFF);
		
		type = t;
	}
	
	protected byte[] getMetaBytes() {
		byte[] ret = new byte[4+data.length];
		ret[0] = (byte)delta;
		ret[1] = status;
		ret[2] = type;
		ret[3] = (byte)data.length;
		System.arraycopy(data, 0, ret, 4, data.length);
		
		return ret;
	}

	@Override
	public MetaEvent clone() {
		MetaEvent m = new MetaEvent();
		m.type =  type;
		return m;
	}
}
