package es.danisales.datune.rhythm;

import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.timelayer.DurableEvent;
import es.danisales.datune.timelayer.SequentialTimeEvents;
import es.danisales.datune.voicing.AbsolutePitch;

@SuppressWarnings("WeakerAccess")
public class Voice<C extends AbsolutePitch>
        extends SequentialTimeEvents<C, DurableEvent<C, MusicalTime>, MusicalTime> {
    private Voice() {
        super();
    }
}
