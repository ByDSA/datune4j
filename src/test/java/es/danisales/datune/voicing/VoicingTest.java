package es.danisales.datune.voicing;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoicingTest {
    @Test
    public void C_closed() {
        ChromaticChord chromaticChord = ChromaticChord.C;
        @SuppressWarnings("unchecked")
        VoicingType<Chromatic> voicingType = VoicingType.CLOSED;
        Voicing<Chromatic> voicing = Voicing.from(voicingType, chromaticChord);

        assertEquals(3, voicing.size());
        assertEquals(Voicing.RelativeVoice.from(Chromatic.C, 0), voicing.get(0));
        assertEquals(Voicing.RelativeVoice.from(Chromatic.E, 0), voicing.get(1));
        assertEquals(Voicing.RelativeVoice.from(Chromatic.G, 0), voicing.get(2));

    }

    @Test
    public void C9_closed() {
        ChromaticChord chromaticChord = ChromaticChord.C9;
        @SuppressWarnings("unchecked")
        VoicingType<Chromatic> voicingType = VoicingType.CLOSED;
        Voicing<Chromatic> voicing = Voicing.from(voicingType, chromaticChord);

        assertEquals(5, voicing.size());
        assertEquals(Voicing.RelativeVoice.from(Chromatic.C, 0), voicing.get(0));
        assertEquals(Voicing.RelativeVoice.from(Chromatic.E, 0), voicing.get(1));
        assertEquals(Voicing.RelativeVoice.from(Chromatic.G, 0), voicing.get(2));
        assertEquals(Voicing.RelativeVoice.from(Chromatic.AA, 0), voicing.get(3));
        assertEquals(Voicing.RelativeVoice.from(Chromatic.D, 1), voicing.get(4));
    }

    @Test
    public void B_closed() {
        ChromaticChord chromaticChord = ChromaticChord.Bm;
        @SuppressWarnings("unchecked")
        VoicingType<Chromatic> voicingType = VoicingType.CLOSED;
        Voicing<Chromatic> voicing = Voicing.from(voicingType, chromaticChord);

        assertEquals(3, voicing.size());
        assertEquals(Voicing.RelativeVoice.from(Chromatic.B, 0), voicing.get(0));
        assertEquals(Voicing.RelativeVoice.from(Chromatic.D, 1), voicing.get(1));
        assertEquals(Voicing.RelativeVoice.from(Chromatic.FF, 1), voicing.get(2));
    }
}