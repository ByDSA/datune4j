package es.danisales.datune.rhythm;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.tonality.Tonality;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TonalLayerTest {

    @Test
    public void chordLayerI_V_vi_IV__rhythmPattern_4x4() {
        ChordsLayer chordsLayer = ChordsLayer.create();
        chordsLayer.add(DurableEvent.from(MusicalTime.ZERO, ChromaticChord.C, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE, ChromaticChord.G, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(2), ChromaticChord.Am, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(3), ChromaticChord.F, MusicalTime.WHOLE));

        RhythmLayer rhythmLayer = RhythmLayer.create();
        rhythmLayer.add(DurableEvent.from(MusicalTime.ZERO, RhythmPattern.QUARTER, MusicalTime.WHOLE));


        TonalLayerCalculator tonalLayerCalculator = TonalLayerCalculator.create();
        tonalLayerCalculator.setRhythmLayer(rhythmLayer);
        tonalLayerCalculator.setChordsLayer(chordsLayer);

        TonalLayer tonalLayer = tonalLayerCalculator.generate();
        assertEquals(MusicalTime.LONGA, tonalLayer.getLength());
        assertTonalLayer(Tonality.ET12.C, tonalLayer, Arrays.asList(
                new Pair<>(MusicalTime.ZERO, DiatonicFunction.I),
                new Pair<>(MusicalTime.WHOLE, DiatonicFunction.V),
                new Pair<>(MusicalTime.WHOLE.clone().mult(2), DiatonicFunction.VI),
                new Pair<>(MusicalTime.WHOLE.clone().mult(3), DiatonicFunction.IV)
        ));
    }

    @Test
    public void chordLayerI_V_vi_IV__rhythmPattern_4x4_seventh() {
        ChordsLayer chordsLayer = ChordsLayer.create();
        chordsLayer.add(DurableEvent.from(MusicalTime.ZERO, ChromaticChord.CMaj7, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE, ChromaticChord.G7, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(2), ChromaticChord.Am7, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(3), ChromaticChord.FMaj7, MusicalTime.WHOLE));

        RhythmLayer rhythmLayer = RhythmLayer.create();
        rhythmLayer.add(DurableEvent.from(MusicalTime.ZERO, RhythmPattern.QUARTER, MusicalTime.WHOLE));

        TonalLayerCalculator tonalLayerCalculator = TonalLayerCalculator.create();
        tonalLayerCalculator.setRhythmLayer(rhythmLayer);
        tonalLayerCalculator.setChordsLayer(chordsLayer);

        TonalLayer tonalLayer = tonalLayerCalculator.generate();
        assertEquals(MusicalTime.LONGA, tonalLayer.getLength());
        assertTonalLayer(Tonality.ET12.C, tonalLayer, Arrays.asList(
                new Pair<>(MusicalTime.ZERO, DiatonicFunction.I7),
                new Pair<>(MusicalTime.WHOLE, DiatonicFunction.V7),
                new Pair<>(MusicalTime.WHOLE.clone().mult(2), DiatonicFunction.VI7),
                new Pair<>(MusicalTime.WHOLE.clone().mult(3), DiatonicFunction.IV7)
        ));
    }

    private void assertTonalLayer(Tonality<Chromatic> tonality, TonalLayer tonalLayer, List<Pair<MusicalTime, HarmonicFunction>> pairs) {
        for (Pair<MusicalTime, HarmonicFunction> pair : pairs) {
            assertEquals(tonalLayer.get(pair.getKey()).toString(),
                    1, tonalLayer.get(pair.getKey()).size());
            assertEquals(TonalLayer.Node.from(tonality, pair.getValue()), tonalLayer.get(pair.getKey()).get(0));
        }

    }
}