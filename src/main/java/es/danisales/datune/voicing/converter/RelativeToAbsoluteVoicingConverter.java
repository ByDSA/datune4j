package es.danisales.datune.voicing.converter;

import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.voicing.AbsoluteVoicing;

public interface RelativeToAbsoluteVoicingConverter<C extends CyclicDegree> {
    AbsoluteVoicing<C> convert();
}
