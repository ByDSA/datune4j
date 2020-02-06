package es.danisales.datune.rhythm;

import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.voicing.AbsolutePitch;

public class Voice<C extends AbsolutePitch>
        extends SequentialTimeEvents<C, DurableEvent<C, MusicalTime>, MusicalTime> {
    private Voice() {
        super();
    }
}
