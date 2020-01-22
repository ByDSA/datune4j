package es.danisales.datune.voicing;

import es.danisales.datune.degrees.CyclicDegree;

import java.util.ArrayList;
import java.util.List;

public class AbsoluteVoicing<C extends CyclicDegree> {
    private List<AbsoluteOctavePitch<C>> relativeVoices;

    private AbsoluteVoicing(List<AbsoluteOctavePitch<C>> relativeVoices) {
        this.relativeVoices = relativeVoices;
    }

    public static <C extends CyclicDegree> AbsoluteVoicing<C> from(Voicing<C> voicing, int absoluteOctaveBase) {
        List<AbsoluteOctavePitch<C>> relativeVoices = new ArrayList<>();
        AbsoluteVoicing<C> absoluteVoicing = new AbsoluteVoicing<>(relativeVoices);
        return absoluteVoicing;
    }
}
