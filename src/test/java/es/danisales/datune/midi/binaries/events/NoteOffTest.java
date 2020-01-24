package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.DurationMidi;
import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.midi.Settings;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.io.binary.BinData;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NoteOffTest {
    @Test
    public void binaryEncoding() throws BuildingException {
        NoteMidi chromaticMidi = NoteMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .velocity(100)
                .length(DurationMidi.L4)
                .build();

        NoteOff noteOff = NoteOff.builder()
                .from(chromaticMidi)
                .channel(0)
                .build();

        byte[] encoded = BinData.encoder()
                .from(noteOff)
                .getBytes();

        ByteBuffer byteBuffer = ByteBuffer.wrap(encoded);
        assertEquals((byte) 0x0, byteBuffer.get()); // delta
        assertEquals(NoteOff.STATUS_BASE, byteBuffer.get()); // status
        assertEquals(60, byteBuffer.get()); // data: pitch
        assertEquals(100, byteBuffer.get()); // data: velocity
    }

    @SuppressWarnings("unused")
    public static class NoteEventInheritance {
        public static class Building {
            @Test
            public void values() throws BuildingException {
                NoteOff noteOff = NoteOff.builder()
                        .velocity(100)
                        .pitch(60)
                        .delta(2)
                        .build();

                assertEquals(100, noteOff.getVelocity());
                assertEquals(60, noteOff.getMidiCode());
                assertEquals(2, noteOff.getDelta());
            }

            @Test
            public void defaultValues() {
                NoteOff noteOff = NoteOff.builder()
                        .build();

                assertEquals(Settings.DefaultValues.VELOCITY, noteOff.getVelocity());
                assertEquals(0, noteOff.getDelta());
                assertEquals(0, noteOff.getMidiCode());
            }

            @Test
            public void keyValid() throws BuildingException {
                NoteOff.builder()
                        .pitch(PitchChromaticMidi.C5.getMidiCode())
                        .build();
            }

            @Test
            public void keyExceedException() throws BuildingException {
                NoteOff noteOff = NoteOff.builder()
                        .pitch(PitchChromaticMidi.MAX.getMidiCode() + 1)
                        .build();

                assertEquals(PitchChromaticMidi.MAX.getMidiCode(), noteOff.getMidiCode());
            }

            @Test
            public void keyInsufficientException() throws BuildingException {
                NoteOff noteOff = NoteOff.builder()
                        .pitch(PitchChromaticMidi.MIN.getMidiCode() - 1)
                        .build();

                assertEquals(PitchChromaticMidi.MIN.getMidiCode(), noteOff.getMidiCode());
            }

            @Test
            public void velocityValid() throws BuildingException {
                NoteOff.builder()
                        .pitch(60)
                        .velocity(101)
                        .build();
            }

            @Test
            public void buildExceptionVelocityInsufficient() throws BuildingException {
                NoteOff noteOff = NoteOff.builder()
                        .velocity(-1)
                        .pitch(60)
                        .build();

                assertEquals(0, noteOff.getVelocity());
            }

            @Test
            public void buildExceptionVelocityExceed() throws BuildingException {
                NoteOff noteOff = NoteOff.builder()
                        .velocity(128)
                        .pitch(60)
                        .build();

                assertEquals(127, noteOff.getVelocity());
            }

            @Test
            public void buildExceptionDeltaInsufficient() throws BuildingException {
                NoteOff noteOff = NoteOff.builder()
                        .delta(-1)
                        .pitch(60)
                        .build();

                assertEquals(0, noteOff.getDelta());
            }

            @Test
            public void deltaExceedException() throws BuildingException {
                NoteOff noteOff = NoteOff.builder()
                        .delta(999999)
                        .pitch(60)
                        .build();

                assertEquals(65535, noteOff.getDelta());
            }

            @Test
            public void sameBuilderTwoInstancesEquals() throws BuildingException {
                NoteEvent.Builder<NoteOff> builder = NoteOff.builder()
                        .velocity(100)
                        .pitch(60)
                        .delta(2);

                NoteOff noteOff = builder.build();
                NoteOff noteOff2 = builder.build();

                assertEquals(noteOff, noteOff2);
            }
        }
    }

    public static class ObjectInheritance {
        @Test
        public void equals() throws BuildingException {
            NoteOff noteOff = NoteOff.builder()
                    .velocity(100)
                    .pitch(60)
                    .delta(2)
                    .build();

            NoteOff noteOff2 = NoteOff.builder()
                    .velocity(100)
                    .pitch(60)
                    .delta(2)
                    .build();

            assertEquals(noteOff.getDelta(), noteOff2.getDelta());
            assertEquals(noteOff.getMidiCode(), noteOff2.getMidiCode());
            assertEquals(noteOff.getDelta(), noteOff2.getDelta());
        }

        @Test
        public void cloneEquals() throws BuildingException {
            NoteOff noteOff = NoteOff.builder()
                    .velocity(100)
                    .pitch(60)
                    .delta(2)
                    .build();

            NoteOff cloned = noteOff.clone();
            assertEquals(noteOff, cloned);
        }

        @Test
        public void hashCodeSameCloned() throws BuildingException {
            NoteOff noteOff = NoteOff.builder()
                    .velocity(100)
                    .pitch(60)
                    .delta(2)
                    .build();

            NoteOff cloned = noteOff.clone();
            assertEquals(noteOff.hashCode(), cloned.hashCode());
        }

        @Test
        public void noteOnNotEquals() throws BuildingException {
            NoteOn noteOn = NoteOn.builder()
                    .pitch(60)
                    .build();

            NoteOff noteOff = NoteOff.builder()
                    .pitch(noteOn.getMidiCode())
                    .velocity(noteOn.getVelocity())
                    .delta(noteOn.getDelta())
                    .build();

            assertNotEquals(noteOff, noteOn);
        }
    }
}