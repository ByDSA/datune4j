package es.danisales.datune.timelayer;

import es.danisales.datune.rhythm.RhythmPattern;
import es.danisales.datune.tempo.MusicalTime;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RhythmSequence implements Iterable<TimeLayer> {
    private RhythmPattern rhythmPattern;
    private MusicalTime beat;
    private List<TimeLayer> timeLayerList;

    private RhythmSequence() {
        timeLayerList = new ArrayList<>();
    }

    public static RhythmSequence create(RhythmPattern rhythmPattern, MusicalTime beat) {
        RhythmSequence rhythmSequence = new RhythmSequence();
        rhythmSequence.rhythmPattern = rhythmPattern;
        rhythmSequence.beat = beat;

        return rhythmSequence;
    }

    public TimeLayer getLayer(int n) {
        return timeLayerList.get(n);
    }

    @Override
    @NonNull
    public Iterator<TimeLayer> iterator() {
        return timeLayerList.iterator();
    }
}
