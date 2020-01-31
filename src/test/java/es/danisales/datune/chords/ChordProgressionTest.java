package es.danisales.datune.chords;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChordProgressionTest {

    @Test
    public void create() {
        ChordProgression<Chromatic> chromaticChordProgression = ChordProgression.create();
        chromaticChordProgression.add(ChromaticChord.C);
        chromaticChordProgression.add(ChromaticChord.G);
        chromaticChordProgression.add(ChromaticChord.Am);
        chromaticChordProgression.add(ChromaticChord.Fm);

        assertEquals(4, chromaticChordProgression.size());
        assertEquals(ChromaticChord.C, chromaticChordProgression.get(0));
        assertEquals(ChromaticChord.G, chromaticChordProgression.get(1));
        assertEquals(ChromaticChord.Am, chromaticChordProgression.get(2));
        assertEquals(ChromaticChord.Fm, chromaticChordProgression.get(3));
    }
}