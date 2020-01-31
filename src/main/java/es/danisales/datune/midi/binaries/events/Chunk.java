package es.danisales.datune.midi.binaries.events;

import es.danisales.io.binary.BinData;
import es.danisales.io.binary.BinEncoder;
import es.danisales.io.binary.BinSize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class Chunk implements Event {
    static {
        BinEncoder.register(byte[].class, (byte[] self, BinEncoder.EncoderSettings settings) -> { // todo: move to datils
            try {
                settings.getByteArrayOutputStream().write(self);
            } catch (IOException ignored) {
            }
        });
        BinSize.register(byte[].class, (byte[] self, BinEncoder.EncoderSettings settings) -> { // todo: move to datils
            return self.length;
        });

        BinEncoder.register(Chunk.class, (Chunk self, BinEncoder.EncoderSettings settings) -> {
            try {
                settings.getByteArrayOutputStream().write(self.type);

                writeLength(self.dataSizeBytes(), settings.getByteArrayOutputStream());

                for (Object b : self.data)
                    BinData.encoder()
                            .from(b)
                            .toStream(settings.getDataOutputStream(), settings.getByteArrayOutputStream())
                            .putIntoStream();
            } catch (IOException ignored) {
            }
        });

        BinSize.register(Chunk.class, (Chunk self, BinEncoder.EncoderSettings settings) -> 4 + self.type.length + self.dataSizeBytes());
    }

    private static void writeLength(int length, ByteArrayOutputStream byteOutputStream) throws IOException {
        byte[] lengthBytes = new byte[4];
        for (int i = 3; i >= 0; i--) {
            lengthBytes[i] = (byte) (length & 0xFF);
            length >>= 8;
        }

        byteOutputStream.write(lengthBytes);
    }

	protected byte[] type;
    private List<Object> data;
	protected int length;

    Chunk(byte[] type) {
        this.type = type;
		data = new ArrayList<>();
	}

    public void addData(Object b) {
        data.add(b);
	}

	private int dataSizeBytes() {
		int s = 0;
        for (Object b : data)
            s += BinSize.getBinarySizeOf(b);

		return s;
	}

    @Override
    public abstract Chunk clone();
}
