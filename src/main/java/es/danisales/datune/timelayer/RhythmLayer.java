package es.danisales.datune.timelayer;

import es.danisales.datune.rhythm.RhythmPattern;
import es.danisales.datune.tempo.MusicalTime;

public class RhythmLayer extends SequentialTimeEvents<RhythmPattern, DurableEvent<RhythmPattern, MusicalTime>, MusicalTime>{

    public static RhythmLayer create() {
        return new RhythmLayer();
    }

    @SuppressWarnings("WeakerAccess")
    public MusicalTime getFirstCompassTime() {
        return MusicalTime.ZERO.clone();
    }

    @SuppressWarnings("WeakerAccess")
    public MusicalTime getNextCompassTime(MusicalTime fromTime) {
        return MusicalTime.WHOLE.clone().mult(4);//getEvent(fromTime).getEnd();
    }
}
