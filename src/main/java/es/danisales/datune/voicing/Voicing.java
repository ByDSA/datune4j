package es.danisales.datune.voicing;

import es.danisales.datune.chords.Chord;
import es.danisales.datune.degrees.CyclicDegree;

import java.util.ArrayList;
import java.util.List;

public class Voicing<C extends CyclicDegree> {
    private List<RelativeVoice<C>> relativeVoices;

    private Voicing(List< RelativeVoice<C> > relativeVoices) {
        this.relativeVoices = relativeVoices;
    }

    public static <C extends CyclicDegree> Voicing<C> from(VoicingType voicingType, Chord<C> chord) {
        List< RelativeVoice<C> > relativeVoices = new ArrayList<>();
        Voicing<C> voicing = new Voicing<>(relativeVoices);
        return voicing;
    }

    public static class RelativeVoice<C extends CyclicDegree> {
        int octaveRelative;
        C note;
    }
}
