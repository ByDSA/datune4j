package es.danisales.datune.midi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;

import es.danisales.datune.eventsequences.Instrument;

public class Midi {

	public static void play(String path) throws MidiUnavailableException, IOException, InvalidMidiDataException {
		Sequencer sequencer = MidiSystem.getSequencer();

		sequencer.open();

		InputStream is = new BufferedInputStream(new FileInputStream(new File(path)));

		sequencer.setSequence(is);

		sequencer.start();
	}

	static Synthesizer midiSynth; 

	static javax.sound.midi.Instrument[] instr;
	public static MidiChannel[] mChannels;

	static {
		try{
			midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();
			instr = midiSynth.getDefaultSoundbank().getInstruments();
			mChannels = midiSynth.getChannels();
			midiSynth.loadInstrument(instr[0]);
		} catch (MidiUnavailableException e) { }
	}
	
	public static void setInstrument(Instrument i) {
	    mChannels[0].programChange(i.val());
	}	
}
