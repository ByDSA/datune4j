package es.danisales.datune.midi.binaries.events;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PanTest {
    public static class ChunkDataInheritance {
        @Test
        public void deltaValid() {
            Pan pan = Pan.builder()
                    .build();

            pan.setDelta(123);

            assertEquals(123, pan.getDelta());
        }

        @Test
        public void deltaInsufficient() {
            Pan pan = Pan.builder()
                    .delta(-1)
                    .build();

            assertEquals(0, pan.getDelta());
        }

        @Test
        public void deltaExceed() {
            Pan noteOn = Pan.builder()
                    .delta(999999)
                    .build();

            assertEquals(65535, noteOn.getDelta());
        }

        @Test
        public void channelValid() {
            Pan pan = Pan.builder()
                    .build();

            pan.setChannel(10);

            assertEquals(10, pan.getChannel());
        }

        @Test
        public void channelInsufficient() {
            Pan pan = Pan.builder()
                    .channel(-1)
                    .build();

            assertEquals(0, pan.getChannel());
        }

        @Test
        public void channelExceed() {
            Pan noteOn = Pan.builder()
                    .channel(999999)
                    .build();

            assertEquals(15, noteOn.getChannel());
        }

        @Test
        public void sameBuilderTwoInstancesEquals() {
            Pan.Builder builder = Pan.builder()
                    .channel(5)
                    .delta(2);

            Pan pan = builder.build();
            Pan pan2 = builder.build();

            assertEquals(pan, pan2);
        }

        @Test(expected = UnsupportedOperationException.class)
        public void status() {
            Pan pan = Pan.builder()
                    .build();

            pan.setStatus((byte) 123);
        }
    }

    public static class BuildingTests {
        @Test
        public void defaultValues() {
            Pan pan = Pan.builder().build();

            assertEquals(Pan.MID, pan.getValue());
            assertEquals(0, pan.getChannel());
            assertEquals(0, pan.getDelta());
            assertEquals(Pan.STATUS, pan.getStatus());
        }

        @Test
        public void value() {
            Pan pan = Pan.builder()
                    .value(23)
                    .build();

            assertEquals(23, pan.getValue());
        }
    }

    @Test
    public void valueValid() {
        Pan pan = Pan.builder()
                .build();

        pan.setValue(123);

        assertEquals(123, pan.getValue());
    }

    @Test
    public void valueInsufficient() {
        Pan pan = Pan.builder()
                .value(-1)
                .build();

        assertEquals(Pan.LEFT, pan.getValue());
    }

    @Test
    public void channelExceed() {
        Pan noteOn = Pan.builder()
                .value(999999)
                .build();

        assertEquals(Pan.RIGHT, noteOn.getValue());
    }

}