package es.danisales.datune.midi.binaries.events;

import es.danisales.io.binary.BinData;
import es.danisales.io.binary.BinEncoder;
import es.danisales.io.binary.BinSize;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Chunk<This extends Chunk> implements Event {
    static {
        BinEncoder.register(Chunk.class, (Chunk<?> self, BinEncoder.EncoderSettings settings) -> {
            ByteArrayOutputStream byteArrayOutputStream = settings.byteArrayOutputStream;
            BinData.encoder()
                    .from(self.type)
                    .to(settings)
                    .putIntoStream();

            byte[] lengthBytes = new byte[4];
            for (int i = 3; i >= 0; i--) {
                lengthBytes[i] = (byte) (self.length & 0xFF);
                self.length >>= 8;
            }

            BinData.encoder()
                    .from(lengthBytes)
                    .to(settings)
                    .putIntoStream();

            for (Object b : self.data)
                BinData.encoder()
                        .from(b)
                        .to(settings)
                        .putIntoStream();
        });

        BinSize.registerSize(Chunk.class, (Chunk<?> self, BinEncoder.EncoderSettings settings) -> {
            return 4 + self.type.length + self.dataSizeBytes();
        });
    }

	protected byte[] type;
    protected List<Object> data;
	protected int length;

	public Chunk(byte[] t) {
		type = t;
		data = new ArrayList<>();
	}

	public void add(Event cd) {
		add( cd );
	}

    public void add(Object b) {
		data.add(b);
	}
	
	public void add(byte[] b) {
        data.add(b);
	}

	@Override
	public This clone() {
		Chunk ret = new Chunk(type);

		return (This)this;
	}

	public int dataSizeBytes() {
		int s = 0;
        for (Object b : data)
            s += BinSize.getBinarySizeOf(b);

		return s;
	}
}
