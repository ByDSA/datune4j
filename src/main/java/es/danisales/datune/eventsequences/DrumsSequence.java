package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.Duration;
import es.danisales.datune.midi.binaries.events.NoteOn;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;

public class DrumsSequence extends EventSequence {
    /* SAMPLES */
    public final static DrumsSequence POWER = new DrumsSequence();

    static {
        for (int i = 0; i < Duration.L1; i += Duration.L4)
            POWER.add(i, Drums.ACOUSTIC_SNARE);

        for (int i = 0; i < Duration.L1; i += Duration.L16)
            POWER.add(i, Drums.BASS_DRUM1);

        POWER.setLength(Duration.L1);
    }

    public DrumsSequence add(int time, Drums pitchNumber) {
        NoteOn noteOn;
        try {
            noteOn = NoteOn.builder()
                    .pitch(pitchNumber.getCode())
                    .build();
        } catch (BuildingException e) {
            throw NeverHappensException.make("La entrada siempre es válida al ser de un enum con valores controlados");
        }
        add(time, noteOn);
        return this;
    }
}
