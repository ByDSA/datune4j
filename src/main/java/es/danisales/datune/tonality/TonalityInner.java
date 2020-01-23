package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.CyclicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

interface TonalityInner<C extends CyclicDegree> {
    @NonNull Scale getScale();

    @NonNull C getRoot();

    @NonNull List<C> getNotes();
}
