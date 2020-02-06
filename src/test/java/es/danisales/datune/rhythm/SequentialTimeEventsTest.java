package es.danisales.datune.rhythm;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tempo.MusicalTime;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class SequentialTimeEventsTest {
    @Test
    public void createEmpty() {
        SequentialTimeEvents<Chromatic, DurableEvent<Chromatic, MusicalTime>, MusicalTime> sequentialTimeEvents = SequentialTimeEvents.create();

        assertNotNull(sequentialTimeEvents);
    }

    @Test
    public void add() {
        SequentialTimeEvents<Chromatic, DurableEvent<Chromatic, MusicalTime>, MusicalTime> sequentialTimeEvents = SequentialTimeEvents.create();
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.ZERO, Chromatic.C, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.QUARTER, Chromatic.D, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF, Chromatic.E, MusicalTime.QUARTER));
    }

    @Test
    public void get() {
        SequentialTimeEvents<Chromatic, DurableEvent<Chromatic, MusicalTime>, MusicalTime> sequentialTimeEvents = SequentialTimeEvents.create();
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.ZERO, Chromatic.C, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.QUARTER, Chromatic.D, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF, Chromatic.E, MusicalTime.QUARTER));

        assertEquals(Chromatic.C, sequentialTimeEvents.get(MusicalTime.ZERO));
        assertEquals(Chromatic.E, sequentialTimeEvents.get(MusicalTime.HALF));
        assertNull(sequentialTimeEvents.get(MusicalTime.LONGA));
    }

    @Test
    public void removeAndShift() {
        SequentialTimeEvents<Chromatic, DurableEvent<Chromatic, MusicalTime>, MusicalTime> sequentialTimeEvents = SequentialTimeEvents.create();
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.ZERO, Chromatic.C, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.QUARTER, Chromatic.D, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF, Chromatic.E, MusicalTime.QUARTER));

        sequentialTimeEvents.removeAndShift(MusicalTime.ZERO);
        assertEquals(Chromatic.D, sequentialTimeEvents.get(MusicalTime.ZERO));
    }

    @Test
    public void remove() {
        SequentialTimeEvents<Chromatic, DurableEvent<Chromatic, MusicalTime>, MusicalTime> sequentialTimeEvents = SequentialTimeEvents.create();
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.ZERO, Chromatic.C, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.QUARTER, Chromatic.D, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF, Chromatic.E, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.ZERO, Chromatic.F, MusicalTime.QUARTER));

        sequentialTimeEvents.remove(MusicalTime.ZERO);
        assertNull(sequentialTimeEvents.get(MusicalTime.ZERO));
        assertEquals(Chromatic.D, sequentialTimeEvents.get(MusicalTime.QUARTER));
    }

    @Test
    public void getLength() {
        SequentialTimeEvents<Chromatic, DurableEvent<Chromatic, MusicalTime>, MusicalTime> sequentialTimeEvents = SequentialTimeEvents.create();
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.ZERO, Chromatic.C, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.QUARTER, Chromatic.D, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF, Chromatic.E, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF.clone().dotted(), Chromatic.E, MusicalTime.QUARTER));

        assertEquals(MusicalTime.WHOLE, sequentialTimeEvents.getLength());
    }

    @Test
    public void getLength_afterRemoveShift() {
        SequentialTimeEvents<Chromatic, DurableEvent<Chromatic, MusicalTime>, MusicalTime> sequentialTimeEvents = SequentialTimeEvents.create();
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.ZERO, Chromatic.C, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.QUARTER, Chromatic.D, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF, Chromatic.E, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF.clone().dotted(), Chromatic.F, MusicalTime.QUARTER));
        sequentialTimeEvents.removeAndShift(MusicalTime.HALF);

        assertEquals(MusicalTime.QUARTER.clone().mult(3), sequentialTimeEvents.getLength());
    }

    @Test
    public void getLength_afterRemove() {
        SequentialTimeEvents<Chromatic, DurableEvent<Chromatic, MusicalTime>, MusicalTime> sequentialTimeEvents = SequentialTimeEvents.create();
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.ZERO, Chromatic.C, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.QUARTER, Chromatic.D, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF, Chromatic.E, MusicalTime.QUARTER));
        sequentialTimeEvents.add(DurableEvent.from(MusicalTime.HALF.clone().dotted(), Chromatic.F, MusicalTime.QUARTER));
        sequentialTimeEvents.remove(MusicalTime.HALF);

        assertEquals(MusicalTime.WHOLE, sequentialTimeEvents.getLength());
    }
}