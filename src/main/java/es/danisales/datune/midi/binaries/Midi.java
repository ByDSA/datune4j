package es.danisales.datune.midi.binaries;

import es.danisales.datune.eventsequences.Instrument;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.sound.midi.*;
import java.io.*;

public class Midi {

	public static void play(@NonNull File file) throws MidiUnavailableException, IOException, InvalidMidiDataException {
		Sequencer sequencer = MidiSystem.getSequencer();

		sequencer.open();

		InputStream is = new BufferedInputStream(new FileInputStream(file));

		sequencer.setSequence(is);

		sequencer.start();
	}

	public static MidiChannel[] mChannels;

	static {
		try{
			Synthesizer midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();
			javax.sound.midi.Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
			mChannels = midiSynth.getChannels();
			midiSynth.loadInstrument(instr[0]);
		} catch (MidiUnavailableException ignored) {
		}
	}
	
	public static void setInstrument(Instrument i) {
	    mChannels[0].programChange(i.value());
	}	
}
