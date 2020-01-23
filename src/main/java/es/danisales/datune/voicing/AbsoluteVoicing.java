package es.danisales.datune.voicing;

import es.danisales.datune.degrees.octave.CyclicDegree;

import java.util.ArrayList;
import java.util.List;

public class AbsoluteVoicing<C extends CyclicDegree> extends ArrayList<AbsoluteOctavePitch<C>> {
    private AbsoluteVoicing(List<AbsoluteOctavePitch<C>> relativeVoices) {
        super(relativeVoices);
    }

    public AbsoluteVoicing<C> clone() {
        return new AbsoluteVoicing<>(this);
    }

    public static <C extends CyclicDegree> AbsoluteVoicing<C> from(Voicing<C> voicing, int absoluteOctaveBase) {
        List<AbsoluteOctavePitch<C>> relativeVoices = new ArrayList<>();
        AbsoluteVoicing<C> absoluteVoicing = new AbsoluteVoicing<>(relativeVoices);
        return absoluteVoicing;
    }
}
