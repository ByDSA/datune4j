package es.danisales.datune.voicing;

import es.danisales.datune.chords.Chord;
import es.danisales.datune.degrees.octave.CyclicDegree;

import java.util.ArrayList;
import java.util.List;

public abstract class VoicingType<C extends CyclicDegree> {

    @SuppressWarnings("StaticInitializerReferencesSubClass")
    public static final VoicingType CLOSED = new VoicingTypeClosed<>();

    protected static class VoicingTypeClosed<CC extends CyclicDegree> extends VoicingType<CC> {
        @Override
        public List<Voicing.RelativeVoice<CC>> make(Chord<CC> chord) {
            List<Voicing.RelativeVoice<CC>> ret = new ArrayList<>();
            CC previous = null;
            int octave = 0;
            for (CC current : chord) {
                if (previous != null && current.ordinal() < previous.ordinal())
                    octave++;

                Voicing.RelativeVoice<CC> relativeVoice = Voicing.RelativeVoice.from(current, octave);
                ret.add(relativeVoice);

                previous = current;
            }
            return ret;
        }
    }

    public abstract List<Voicing.RelativeVoice<C>> make(Chord<C> chord);
}
