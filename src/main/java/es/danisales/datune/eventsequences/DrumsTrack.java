package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.Events.NoteOn;

public class DrumsTrack extends Track {	
	public DrumsTrack() {
		super(9, Instrument.ACOUSTIC_GRAND_PIANO);
	}
	
	public DrumsTrack add(int d, int n) {
		add(d, new NoteOn(n));
		return this;
	}
}
