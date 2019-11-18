package es.danisales.datune.midi;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.NoteOff;
import es.danisales.datune.midi.Events.NoteOn;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.SymbolicPitch;
import es.danisales.others.Codeable;

public interface PitchSingleMidi extends PitchOctaveMidiEditable, EventComplex, Codeable, SymbolicPitch {
	@Override
	default EventSequence getEvents() {
		EventSequence es = new EventSequence();
		es.add( 0, new NoteOn( this ) );
		es.add( getLength(), new NoteOff( this ) );

		return es;
	}

	int getLength();
	PitchSingleMidi setLength(int length);
	PitchSingleMidi setVelocity(int velocity);
	int getVelocity();
	PitchSingleMidi clone();
	PitchMidi getPitchMidi();

	@Override
	default int getCode() {
		return getPitchMidi().getCode();
	}
}
