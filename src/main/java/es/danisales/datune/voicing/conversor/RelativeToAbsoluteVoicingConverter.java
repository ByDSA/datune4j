package es.danisales.datune.voicing.conversor;

import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.voicing.AbsoluteVoicing;

public interface RelativeToAbsoluteVoicingConverter<C extends CyclicDegree> {
    AbsoluteVoicing<C> convert();
}
