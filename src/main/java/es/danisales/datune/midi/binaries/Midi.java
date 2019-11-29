package es.danisales.datune.midi.binaries;

import es.danisales.datune.eventsequences.Instrument;

import javax.sound.midi.*;
import java.io.*;

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
