package es.danisales.datune.chords.chromatic;

import es.danisales.datune.chords.Quality;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChromaticChordInfoTest {
    @Test
    public void getQuality() {
        assertEquals(Quality.MAJOR, ChromaticChordInfo.TRIAD_MAJOR.getQuality());
        assertEquals(Quality.MINOR, ChromaticChordInfo.TRIAD_MINOR.getQuality());
    }

    @Test
    public void getPattern() {
        assertEquals(ChromaticChordPattern.TRIAD_MAJOR, ChromaticChordInfo.TRIAD_MAJOR.getPattern());
        assertEquals(ChromaticChordPattern.TRIAD_MINOR, ChromaticChordInfo.TRIAD_MINOR.getPattern());
    }

    @Test
    public void getSuffix() {
        assertEquals("", ChromaticChordInfo.TRIAD_MAJOR.getSuffix());
        assertEquals("m", ChromaticChordInfo.TRIAD_MINOR.getSuffix());
    }
}