package es.danisales.datune.rhythm;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tempo.Duration;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class SequentialTimeEventsTest {

    @Test
    public void createEmpty() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);

        assertNotNull(sequentialTimeEvents);
    }

    @Test
    public void add() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);
        sequentialTimeEvents.add(Chromatic.C, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.D, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.E, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.F, Duration.QUARTER);
    }

    @Test
    public void get() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);
        sequentialTimeEvents.add(Chromatic.C, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.D, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.E, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.F, Duration.QUARTER);

        assertEquals(Chromatic.C, sequentialTimeEvents.get(0));
        assertEquals(Chromatic.E, sequentialTimeEvents.get(Duration.HALF.getValue()));
        assertNull(sequentialTimeEvents.get(Duration.LONGA.getValue()));
    }

    @Test
    public void get_accuracy() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);
        sequentialTimeEvents.add(Chromatic.C, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.D, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.E, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.F, Duration.QUARTER);

        assertEquals(Chromatic.E, sequentialTimeEvents.get(Duration.HALF.getValue()-0.001d));
        assertEquals(Chromatic.D, sequentialTimeEvents.get(Duration.HALF.getValue()-0.01d));
    }

    @Test
    public void remove() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);
        sequentialTimeEvents.add(Chromatic.C, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.D, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.E, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.F, Duration.QUARTER);

        sequentialTimeEvents.remove(0);
        assertEquals(Chromatic.D, sequentialTimeEvents.get(0));
    }

    @Test
    public void removeKeepDuration() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);
        sequentialTimeEvents.add(Chromatic.C, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.D, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.E, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.F, Duration.QUARTER);

        sequentialTimeEvents.removeKeepDuration(0);
        assertNull(sequentialTimeEvents.get(0));
        assertEquals(Chromatic.D, sequentialTimeEvents.get(Duration.QUARTER.getValue()));
    }

    @Test
    public void getLength() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);
        sequentialTimeEvents.add(Chromatic.C, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.D, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.E, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.F, Duration.QUARTER);

        assertEquals(Duration.WHOLE.getValue(), sequentialTimeEvents.getLength());
    }

    @Test
    public void getLength_afterRemove() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);
        sequentialTimeEvents.add(Chromatic.C, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.D, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.E, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.F, Duration.QUARTER);
        sequentialTimeEvents.remove(Duration.HALF.getValue());

        assertEquals(Duration.QUARTER.getValue() * 3, sequentialTimeEvents.getLength());
    }

    @Test
    public void getLength_afterRemoveKeepDuration() {
        SequentialTimeEvents<Chromatic> sequentialTimeEvents = SequentialTimeEvents.createEmpty(Chromatic.class);
        sequentialTimeEvents.add(Chromatic.C, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.D, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.E, Duration.QUARTER);
        sequentialTimeEvents.add(Chromatic.F, Duration.QUARTER);
        sequentialTimeEvents.removeKeepDuration(Duration.HALF.getValue());

        assertEquals(Duration.WHOLE.getValue(), sequentialTimeEvents.getLength());
    }
}