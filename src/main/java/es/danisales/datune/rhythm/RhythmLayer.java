package es.danisales.datune.rhythm;

import es.danisales.datune.tempo.MusicalTime;

public class RhythmLayer extends SequentialTimeEvents<RhythmPattern, DurableEvent<RhythmPattern, MusicalTime>, MusicalTime>{

    public static RhythmLayer create() {
        return new RhythmLayer();
    }

    public MusicalTime getFirstCompassTime() {
        return MusicalTime.ZERO.clone();
    }

    public MusicalTime getNextCompassTime(MusicalTime fromTime) {
        return MusicalTime.WHOLE.clone().mult(4);//getEvent(fromTime).getEnd();
    }
}
