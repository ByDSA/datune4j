package es.danisales.datune.gravity;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import javafx.util.Pair;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class GravityChromaticChordsTest {
    @Test
    public void a() {
        ChromaticChord chromaticChord = ChromaticChord.Bdim;
        Set<ChromaticChord> chords = GravityChromaticChords.getChordsTendencies(chromaticChord);
        System.out.println(chords.size());
        for (ChromaticChord chromaticChord1 : chords)
            System.out.println(chromaticChord1);
    }
}