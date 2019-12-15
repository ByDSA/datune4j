package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.Duration;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.io.binary.BinData;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.assertEquals;

public class NoteOnTest {
    @Test
    public void binaryEncoding() throws BuildingException {
        ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .velocity(100)
                .length(Duration.L4)
                .build();

        NoteOn noteOn = NoteOn.builder()
                .from(chromaticMidi)
                .channel(0)
                .build();
        byte[] encoded = BinData.encoder()
                .from(noteOn)
                .getBytes();

        ByteBuffer byteBuffer = ByteBuffer.wrap(encoded);
        assertEquals((byte) 0x0, byteBuffer.get()); // delta
        assertEquals(NoteOn.STATUS_BASE, byteBuffer.get()); // status
        assertEquals(60, byteBuffer.get()); // data: key
        assertEquals(100, byteBuffer.get()); // data: velocity
    }
}