package es.danisales.datune.rhythm;

import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.voicing.AbsolutePitch;

public class MusicalSequence<C extends AbsolutePitch> extends TimeSequence<C, DurableEvent<C, MusicalTime>, MusicalTime> {
    private MusicalSequence(MusicalTime cellSize) {
       super(cellSize);
    }

    public static <C extends AbsolutePitch> MusicalSequence<C> create() {
        return new MusicalSequence<>(MusicalTime.WHOLE);
    }
}
