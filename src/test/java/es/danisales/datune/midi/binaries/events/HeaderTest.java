package es.danisales.datune.midi.binaries.events;

import es.danisales.io.binary.BinData;
import org.junit.Test;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HeaderTest {
    @Test
    public void binaryEncoding_singleTrack() {
        Header header = new Header(Header.SINGLE_TRACK, 1, Header.TICKS_DEFAULT);

        byte[] encoded = BinData.encoder()
                .from(header)
                .getBytes();

        ByteBuffer byteBuffer = ByteBuffer.wrap(encoded);

        // MThd
        assertEquals((byte) 0x4d, byteBuffer.get());
        assertEquals((byte) 0x54, byteBuffer.get());
        assertEquals((byte) 0x68, byteBuffer.get());
        assertEquals((byte) 0x64, byteBuffer.get());

        // length
        assertEquals((byte) 0x00, byteBuffer.get());
        assertEquals((byte) 0x00, byteBuffer.get());
        assertEquals((byte) 0x00, byteBuffer.get());
        assertEquals((byte) 0x06, byteBuffer.get());

        // data
        assertEquals((byte) 0x00, byteBuffer.get());
        assertEquals(Header.SINGLE_TRACK, byteBuffer.get());
        assertEquals((byte) 0x00, byteBuffer.get());
        assertEquals((byte) 1, byteBuffer.get());
        assertEquals(Header.TICKS_DEFAULT[0], byteBuffer.get());
        assertEquals(Header.TICKS_DEFAULT[1], byteBuffer.get());

        try {
            byteBuffer.get();
            fail();
        } catch (BufferUnderflowException ignored) {
        }
    }

}