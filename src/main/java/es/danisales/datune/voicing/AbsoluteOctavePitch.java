package es.danisales.datune.voicing;

import es.danisales.datune.degrees.octave.CyclicDegree;

public interface AbsoluteOctavePitch<C extends CyclicDegree> extends AbsolutePitch {
    int getOctave();
    C getNote();
}