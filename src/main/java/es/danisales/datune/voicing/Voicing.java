package es.danisales.datune.voicing;

import es.danisales.datune.chords.Chord;
import es.danisales.datune.degrees.octave.CyclicDegree;

import java.util.ArrayList;
import java.util.List;

public class Voicing<C extends CyclicDegree> extends ArrayList<Voicing.RelativeVoice<C>> {
    private Voicing(List< RelativeVoice<C> > relativeVoices) {
        super(relativeVoices);
    }

    public static <C extends CyclicDegree> Voicing<C> from(VoicingType<C> voicingType, Chord<C> chord) {
        List< RelativeVoice<C> > relativeVoices = voicingType.make(chord);
        return new Voicing<>(relativeVoices);
    }

    public static class RelativeVoice<C extends CyclicDegree> {
        int octaveRelative;
        C note;

        private RelativeVoice() {
        }

        public static <C extends CyclicDegree> RelativeVoice<C> from(C note, int octaveRelative) {
            RelativeVoice<C> relativeVoice = new RelativeVoice<>();
            relativeVoice.note = note;
            relativeVoice.octaveRelative = octaveRelative;
            return relativeVoice;
        }

        public int getOctave() {
            return octaveRelative;
        }

        public C getNote() {
            return note;
        }

        public void shiftOctave(int i) {
            octaveRelative += i;
        }

        @Override
        public boolean equals(Object o) {
            if ( !(o instanceof RelativeVoice) )
                return false;

            RelativeVoice relativeVoice = (RelativeVoice)o;

            return note.equals(relativeVoice.note) && octaveRelative == relativeVoice.octaveRelative;
        }

        @Override
        public String toString() {
            return note + " " + octaveRelative;
        }
    }
}
