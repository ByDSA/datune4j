package midi.Events;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import binary.Binary;

public class Chunk<This extends Chunk> implements Event {
	protected byte[] type;
	protected List<Binary> data;
	protected int length;

	public Chunk(byte[] t) {
		type = t;
		data = new ArrayList();
	}

	public void add(Event cd) {
		add( cd );
	}

	public void add(Binary b) {
		data.add(b);
	}
	
	public void add(byte[] b) {
		data.add( Binary.toBinary( b ) );
	}

	@Override
	public This clone() {
		Chunk ret = new Chunk(type);

		return (This)this;
	}

	public int dataSizeBytes() {
		int s = 0;
		for (Binary b : data)
			s += b.sizeBytes();

		return s;
	}

	@Override
	public int sizeBytes() {
		return 4 + type.length + dataSizeBytes();
	}

	@Override
	public void write(ByteBuffer buff) {
		buff.put( type );
		
		byte[] lengthBytes = new byte[4];
		for(int i = 3; i >= 0; i--) {
			lengthBytes[i] = (byte)(length & 0xFF);
			length >>= 8;
		}

		buff.put( lengthBytes );
		
		for (Binary b : data)
			b.write( buff );
	}

	@Override
	public void read(ByteBuffer buff) {
		// TODO Auto-generated method stub

	}
}
