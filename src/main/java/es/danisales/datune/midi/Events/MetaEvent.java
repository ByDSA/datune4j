package es.danisales.datune.midi.Events;

public class MetaEvent extends ChunkData {
	byte type;
	
	private MetaEvent() {
		super(0, (byte) 0);
	}
	
	public MetaEvent(int d, byte t) {
		super(d, (byte)0xFF);
		
		type = t;
	}
	
	public byte[] get() {
		byte[] ret = new byte[4+data.length];
		ret[0] = (byte)delta;
		ret[1] = status;
		ret[2] = type;
		ret[3] = (byte)data.length;
		for(int i = 0; i < data.length; i++)
			ret[i+4] = data[i];
		
		return ret;
	}

	@Override
	public MetaEvent clone() {
		MetaEvent m = new MetaEvent();
		m.type =  type;
		return m;
	}
}
