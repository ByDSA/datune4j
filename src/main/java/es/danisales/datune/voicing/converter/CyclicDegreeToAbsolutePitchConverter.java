package es.danisales.datune.voicing.converter;

import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.voicing.AbsoluteOctavePitch;

public interface CyclicDegreeToAbsolutePitchConverter<C extends CyclicDegree, A extends AbsoluteOctavePitch<C>> {
    A convert(C c, int octave);
}
