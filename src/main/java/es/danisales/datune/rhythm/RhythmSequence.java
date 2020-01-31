package es.danisales.datune.rhythm;

import es.danisales.datune.tempo.Duration;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RhythmSequence implements Iterable<TimeLayer> {
    private RhythmPattern rhythmPattern;
    private Duration beat;
    private List<TimeLayer> timeLayerList;

    private RhythmSequence() {
        timeLayerList = new ArrayList<>();
    }

    public static RhythmSequence create(RhythmPattern rhythmPattern, Duration beat) {
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
