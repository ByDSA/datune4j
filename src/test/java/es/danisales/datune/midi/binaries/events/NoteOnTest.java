package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DurationMidi;
import es.danisales.datune.midi.Settings;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.io.binary.BinData;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NoteOnTest {
    @Test
    public void binaryEncoding() throws BuildingException {
        ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .velocity(100)
                .length(DurationMidi.L4)
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
        assertEquals(60, byteBuffer.get()); // data: pitch
        assertEquals(100, byteBuffer.get()); // data: velocity
    }

    @SuppressWarnings("unused")
    public static class NoteEventInheritance {
        public static class Building {
            @Test
            public void values() throws BuildingException {
                NoteOn noteOn = NoteOn.builder()
                        .velocity(100)
                        .pitch(60)
                        .delta(2)
                        .build();

                assertEquals(100, noteOn.getVelocity());
                assertEquals(60, noteOn.getMidiCode());
                assertEquals(2, noteOn.getDelta());
            }

            @Test
            public void defaultValues() {
                NoteOn noteOn = NoteOn.builder()
                        .build();

                assertEquals(Settings.DefaultValues.VELOCITY, noteOn.getVelocity());
                assertEquals(0, noteOn.getDelta());
                assertEquals(0, noteOn.getMidiCode());
            }

            @Test
            public void keyValid() throws BuildingException {
                NoteOn.builder()
                        .pitch(PitchChromaticMidi.C5.getMidiCode())
                        .build();
            }

            @Test
            public void keyExceedException() throws BuildingException {
                NoteOn noteOn = NoteOn.builder()
                        .pitch(PitchChromaticMidi.MAX.getMidiCode() + 1)
                        .build();

                assertEquals(PitchChromaticMidi.MAX.getMidiCode(), noteOn.getMidiCode());
            }

            @Test
            public void keyInsufficientException() throws BuildingException {
                NoteOn noteOn = NoteOn.builder()
                        .pitch(PitchChromaticMidi.MIN.getMidiCode() - 1)
                        .build();

                assertEquals(PitchChromaticMidi.MIN.getMidiCode(), noteOn.getMidiCode());
            }

            @Test
            public void velocityValid() throws BuildingException {
                NoteOn.builder()
                        .pitch(60)
                        .velocity(101)
                        .build();
            }

            @Test
            public void buildExceptionVelocityInsufficient() throws BuildingException {
                NoteOn noteOn = NoteOn.builder()
                        .velocity(-1)
                        .pitch(60)
                        .build();

                assertEquals(0, noteOn.getVelocity());
            }

            @Test
            public void buildExceptionVelocityExceed() throws BuildingException {
                NoteOn noteOn = NoteOn.builder()
                        .velocity(128)
                        .pitch(60)
                        .build();

                assertEquals(127, noteOn.getVelocity());
            }

            @Test
            public void buildExceptionDeltaInsufficient() throws BuildingException {
                NoteOn noteOn = NoteOn.builder()
                        .delta(-1)
                        .pitch(60)
                        .build();

                assertEquals(0, noteOn.getDelta());
            }

            @Test
            public void deltaExceedException() throws BuildingException {
                NoteOn noteOn = NoteOn.builder()
                        .delta(999999)
                        .pitch(60)
                        .build();

                assertEquals(65535, noteOn.getDelta());
            }

            @Test
            public void sameBuilderTwoInstancesEquals() throws BuildingException {
                NoteEvent.Builder<NoteOn> builder = NoteOn.builder()
                        .velocity(100)
                        .pitch(60)
                        .delta(2);

                NoteOn noteOn = builder.build();
                NoteOn noteOn2 = builder.build();

                assertEquals(noteOn, noteOn2);
            }
        }
    }

    public static class ObjectInheritance {
        @Test
        public void equals() throws BuildingException {
            NoteOn noteOn = NoteOn.builder()
                    .velocity(100)
                    .pitch(60)
                    .delta(2)
                    .build();

            NoteOn noteOn2 = NoteOn.builder()
                    .velocity(100)
                    .pitch(60)
                    .delta(2)
                    .build();

            assertEquals(noteOn.getDelta(), noteOn2.getDelta());
            assertEquals(noteOn.getMidiCode(), noteOn2.getMidiCode());
            assertEquals(noteOn.getDelta(), noteOn2.getDelta());
        }

        @Test
        public void cloneEquals() throws BuildingException {
            NoteOn noteOn = NoteOn.builder()
                    .velocity(100)
                    .pitch(60)
                    .delta(2)
                    .build();

            NoteOn cloned = noteOn.clone();
            assertEquals(noteOn, cloned);
        }

        @Test
        public void hashCodeSameCloned() throws BuildingException {
            NoteOn noteOn = NoteOn.builder()
                    .velocity(100)
                    .pitch(60)
                    .delta(2)
                    .build();

            NoteOn cloned = noteOn.clone();
            assertEquals(noteOn.hashCode(), cloned.hashCode());
        }

        @Test
        public void noteOffNotEquals() throws BuildingException {
            NoteOn noteOn = NoteOn.builder()
                    .pitch(60)
                    .build();

            NoteOff noteOff = NoteOff.builder()
                    .pitch(noteOn.getMidiCode())
                    .velocity(noteOn.getVelocity())
                    .delta(noteOn.getDelta())
                    .build();

            assertNotEquals(noteOn, noteOff);
        }
    }
}