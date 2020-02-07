package es.danisales.datune.rhythm;

import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.timelayer.DurableEvent;
import es.danisales.datune.timelayer.MusicalSequence;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MusicalSequenceTest {
    @Test
    public void get_middle() {
        MusicalSequence<PitchChromaticMidi> musicalSequence = MusicalSequence.create();
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.C5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.E5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.G5, MusicalTime.WHOLE));

        List<PitchChromaticMidi> list = musicalSequence.get(MusicalTime.HALF);

        assertEquals(3, list.size());
        assertTrue(list.containsAll(Arrays.asList(PitchChromaticMidi.C5, PitchChromaticMidi.E5,PitchChromaticMidi.G5)));
    }

    @Test
    public void get_leftLimit() {
        MusicalSequence<PitchChromaticMidi> musicalSequence = MusicalSequence.create();
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.C5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.E5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.G5, MusicalTime.WHOLE));

        List<PitchChromaticMidi> list = musicalSequence.get(MusicalTime.HALF);

        assertEquals(3, list.size());
        assertTrue(list.containsAll(Arrays.asList(PitchChromaticMidi.C5, PitchChromaticMidi.E5,PitchChromaticMidi.G5)));
    }

    @Test
    public void get_rightLimit() {
        MusicalSequence<PitchChromaticMidi> musicalSequence = MusicalSequence.create();
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.C5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.E5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.G5, MusicalTime.WHOLE));

        List<PitchChromaticMidi> list = musicalSequence.get(MusicalTime.WHOLE);

        assertEquals(0, list.size());
    }

    @Test
    public void get_rightLimit2() {
        MusicalSequence<PitchChromaticMidi> musicalSequence = MusicalSequence.create();
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.C5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.E5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.ZERO, PitchChromaticMidi.G5, MusicalTime.WHOLE));

        MusicalTime musicalTime = MusicalTime.WHOLE.clone();
        musicalTime.sub(MusicalTime.SIXTYFOURTH);
        List<PitchChromaticMidi> list = musicalSequence.get(musicalTime);

        assertEquals(3, list.size());
    }

    @Test
    public void get_before() {
        MusicalSequence<PitchChromaticMidi> musicalSequence = MusicalSequence.create();
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.C5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.E5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.G5, MusicalTime.WHOLE));

        List<PitchChromaticMidi> list = musicalSequence.get(MusicalTime.ZERO);

        assertEquals(0, list.size());
    }

    @Test
    public void get_after() {
        MusicalSequence<PitchChromaticMidi> musicalSequence = MusicalSequence.create();
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.C5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.E5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.G5, MusicalTime.WHOLE));

        List<PitchChromaticMidi> list = musicalSequence.get(MusicalTime.DOUBLE);

        assertEquals(0, list.size());
    }

    @Test
    public void get_middle2() {
        MusicalSequence<PitchChromaticMidi> musicalSequence = MusicalSequence.create();
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.C5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.E5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.HALF, PitchChromaticMidi.G5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.WHOLE, PitchChromaticMidi.D5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.WHOLE, PitchChromaticMidi.F5, MusicalTime.WHOLE));
        musicalSequence.add(DurableEvent.from(MusicalTime.WHOLE, PitchChromaticMidi.A5, MusicalTime.WHOLE));

        List<PitchChromaticMidi> list2 = musicalSequence.get(MusicalTime.WHOLE);

        assertEquals(6, list2.size());
        assertTrue(list2.containsAll(Arrays.asList(PitchChromaticMidi.C5, PitchChromaticMidi.E5,PitchChromaticMidi.G5, PitchChromaticMidi.D5, PitchChromaticMidi.F5,PitchChromaticMidi.A5)));
    }

}