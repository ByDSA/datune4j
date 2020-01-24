package es.danisales.datune.voicing;

import es.danisales.datune.degrees.octave.CyclicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface AbsoluteOctavePitch<C extends CyclicDegree> extends AbsolutePitch {
    int getOctave();
    @NonNull C getNote();
}