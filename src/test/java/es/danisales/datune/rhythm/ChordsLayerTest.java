package es.danisales.datune.rhythm;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.timelayer.ChordsLayer;
import es.danisales.datune.timelayer.DurableEvent;
import es.danisales.datune.tonality.Tonality;
import es.danisales.random.RandomMode;
import es.danisales.random.target.RandomPicker;
import org.junit.Test;

import java.util.Arrays;

public class ChordsLayerTest {
    @Test
    public void dd() {
        ChordsLayer chordsLayer = ChordsLayer.create();

        RandomPicker<ChromaticChord> randomPicker = RandomPicker.builder(ChromaticChord.class).setRandomMode(RandomMode.Secure).build();
        randomPicker.addAll(Arrays.asList(
                ChromaticChord.C,
                ChromaticChord.CC,
                ChromaticChord.D,
                ChromaticChord.DD,
                ChromaticChord.E,
                ChromaticChord.F,
                ChromaticChord.FF,
                ChromaticChord.G,
                ChromaticChord.GG,
                ChromaticChord.A,
                ChromaticChord.AA,
                ChromaticChord.B,
                ChromaticChord.Cm,
                ChromaticChord.CCm,
                ChromaticChord.Dm,
                ChromaticChord.DDm,
                ChromaticChord.Em,
                ChromaticChord.Fm,
                ChromaticChord.FFm,
                ChromaticChord.Gm,
                ChromaticChord.GGm,
                ChromaticChord.Am,
                ChromaticChord.AAm,
                ChromaticChord.Bm
        ));

        ChromaticChord chromaticChord = ChromaticChord.from(Tonality.ET12.C, DiatonicFunction.I);
        chordsLayer.add(DurableEvent.from(MusicalTime.ZERO, chromaticChord, MusicalTime.WHOLE));
        chromaticChord = ChromaticChord.from(Tonality.ET12.C, ChromaticDegreeFunction.bVI);
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE, chromaticChord, MusicalTime.WHOLE));
        chromaticChord = ChromaticChord.from(Tonality.ET12.C, ChromaticDegreeFunction.bVII);
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(2), chromaticChord, MusicalTime.WHOLE));
        chromaticChord = ChromaticChord.from(Tonality.ET12.C, DiatonicFunction.I);
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(3), chromaticChord, MusicalTime.WHOLE));
        chromaticChord = ChromaticChord.from(Tonality.ET12.FF, DiatonicFunction.VII);
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(4), chromaticChord, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(5), ChromaticChord.FFm, MusicalTime.WHOLE));
        chordsLayer.add(DurableEvent.from(MusicalTime.WHOLE.clone().mult(6), ChromaticChord.F, MusicalTime.WHOLE));

        chordsLayer.analise();
    }
}