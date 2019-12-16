package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.binaries.events.NoteOn;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;

public class DrumsTrack extends Track {
	public DrumsTrack() {
		super(9, Instrument.ACOUSTIC_GRAND_PIANO);
	}

    public DrumsTrack add(int time, Drums pitchNumber) {
        try {
            add(
                    time,
                    NoteOn.builder()
                            .pitch(pitchNumber.getCode())
                            .build()
            );
        } catch (BuildingException e) {
            throw NeverHappensException.make("El código es de un enum con valor controlado.");
        }
		return this;
	}
}
