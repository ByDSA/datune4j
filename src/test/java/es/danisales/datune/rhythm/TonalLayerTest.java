package es.danisales.datune.rhythm;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.tempo.MusicalTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class TonalLayerTest {

    @Test
    public void get() {
        ChordsLayer chordsLayer = ChordsLayer.create();
        chordsLayer.add(DurableEvent.from(MusicalTime.ZERO, ChromaticChord.C, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE, ChromaticChord.G, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(2), ChromaticChord.Am, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(3), ChromaticChord.F, MusicalTime.WHOLE));

        RhythmLayer rhythmLayer = RhythmLayer.create();
        rhythmLayer.add(DurableEvent.from(MusicalTime.ZERO, RhythmPattern.QUARTER, MusicalTime.WHOLE));

        TonalLayer tonalLayer = TonalLayer.create(rhythmLayer, chordsLayer);
        tonalLayer.get();
    }
}