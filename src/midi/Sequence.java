package midi;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

import eventsequences.DrumsTrack;
import eventsequences.EventSequence;
import eventsequences.Instrument;
import eventsequences.Track;
import io.Binary.BinaryFile;
import midi.Events.Header;
import midi.Events.NoteOff;
import midi.Events.NoteOn;
import midi.Events.TempoEvent;

public class Sequence extends BinaryFile {
	public final static int MILLISECONDS = 0;
	public final static int MIDI = 1;

	protected int tempo;
	protected ArrayList<Track> tracks;
	protected Track firstChannel;

	protected EventSequence events;

	MidiChannel[] mChannels;
	javax.sound.midi.Instrument[] instr;

	Synthesizer midiSynth;

	public Sequence(String n, int t) {
		super(n);
		tempo = t;
		tracks = new ArrayList<Track>();

		firstChannel = new Track(0);
		firstChannel.firstOfSequence(this);
		add(firstChannel);

		events = new EventSequence();

		try {
			midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		//get and load default instrument and channel lists
		instr = midiSynth.getDefaultSoundbank().getInstruments();
		mChannels = midiSynth.getChannels();

	}

	public Track chanel(int i) {
		return tracks.get(i);
	}

	public Sequence add(Track c) {
		tracks.add(c);

		return this;
	}

	public Track createTrack(int mc, Instrument i) {
		Track t = new Track(mc, i);
		add(t);

		return t;
	}

	public DrumsTrack createDrumsTrack() {
		DrumsTrack t = new DrumsTrack();
		add(t);

		return t;
	}
	/*
	public void ready(int type) {
		events.add(0, new TempoEvent(tempo));

		for(Track c : channels) {
			//mChannels[c.midiChannel].programChange(instr[c.midiInstrument].getPatch().getProgram());

			EventSequence e = c.getBasicEvents();
			//e.show(Note.V1);

			for(Map.Entry<Long, ArrayList<Event>> entry : e.getMap().entrySet()) {
				Long key = entry.getKey();
				ArrayList<Event> value = entry.getValue();

				for(Event ev : value) {
					if (ev instanceof KeySignatureEvent)
						((KeySignatureEvent)ev).channel = c;

					long ms;
					if (type == MILLISECONDS)
						ms = (long)(60*1000.0 / tempo * key / Note.V4);
					else if (type == MIDI)
						ms = key;
					else
						ms = -1;
					events.add(ms, ev);

				}
			}
		}
		//events.show(1000);
	}*/
	/*
	public void play() throws MidiUnavailableException {
		ready(MILLISECONDS);

		boolean first = true;
		long begin = System.currentTimeMillis();

		while(events.size() > 0) {
			//System.out.println("Events remain: " + events.size());
			if (first)
				first = false;
			else
				try { Thread.sleep(10); // wait time in milliseconds to control duration
				} catch( InterruptedException e ) { }
			long ms = System.currentTimeMillis() - begin;
			//System.out.println("Tick: " + ms);

			while(true) {
				Iterator<Map.Entry<Long, ArrayList<Event>>> it = events.getMap().entrySet().iterator();
				if (it.hasNext() ) {
					Map.Entry<Long, ArrayList<Event>> entry = it.next();
					Long key = entry.getKey();
					ArrayList<Event> value = entry.getValue();
					if (key > ms)
						break;

					for(Event e : value) {
						if (e instanceof NoteOn) {
							NoteOn n = (NoteOn)e;
							//mChannels[n.channel.channel].noteOn(n.note.code, n.note.velocity);
							System.out.println(n.note);
						} else if (e instanceof NoteOff) {
							NoteOff n = (NoteOff)e;
							//mChannels[n.channel.channel].noteOff(n.note.code, n.note.velocity);
							//System.out.println("off");
						}
					}

					events.remove(key);
				} else
					break;
			}
		}

		System.out.println("END!");
	}
	 */
	@Override
	public void write(ByteBuffer buff) {
		//ready(MIDI);

		Header h = generateHeader();

		h.write( buff );


		for(Track c : tracks) {
			c.write( buff );
		}

		if ( !save() )
			throw new RuntimeException("No se pudo guardar");
	}
	
	private Header generateHeader() {
		return new Header(Header.MULTIPLE_TRACK, tracks.size(), new byte[]{0x03, (byte)0xc0});
	}
	
	@Override
	public int sizeBytes() {
		int s = 0;
		s += generateHeader().sizeBytes();
		for(Track c : tracks) {
			s += c.sizeBytes();
		}
		return s;
	}

	@Override
	public void read(ByteBuffer buff) {
		// TODO Auto-generated method stub
		
	}

	public int getTempo() {
		return tempo;
	}

	public Sequence setTempo(int time, int tem) {	
		firstChannel.add(time, new TempoEvent(tem));

		return this;
	}

	public Sequence toNotes() {
		for(int i = 0; i < tracks.size(); i++) {
			Track t = tracks.get(i);
			if (t.isDrums())
				continue;
			Track t2 = t.toNotes();
			tracks.set(i, t2);
		}

		return this;
	}

	public EventSequence flatHarmony() {
		EventSequence es = new EventSequence();
		for(Track t : tracks) {
			if (!t.isDrums())
				es.add(t);
		}

		return es;
	}

	public static Sequence loadRaw(String fname) throws InvalidMidiDataException, IOException {
		javax.sound.midi.Sequence sequence = MidiSystem.getSequence( new File(fname) );
		//System.out.println( sequence.getPatchList().length );
		int bpm = sequence.getResolution() / 8;
		Sequence song = new Sequence("", bpm);

		int trackNumber = 0;
		for (javax.sound.midi.Track track :  sequence.getTracks()) {
			trackNumber++;
			//System.out.println("Track " + trackNumber + ": size = " + track.size());
			eventsequences.Track t = null;
			//System.out.println();
			for (int i=0; i < track.size(); i++) { 
				MidiEvent event = track.get(i);
				//System.out.print("@" + event.getTick() / (float)sequence.getResolution() + " ");
				MidiMessage message = event.getMessage();
				if (message instanceof ShortMessage) {
					ShortMessage sm = (ShortMessage) message;
					//System.out.print("Channel: " + sm.getChannel() + " ");
					long time = Duration.V4 * event.getTick() / sequence.getResolution();
					if (t == null) {
						int ins = 0; // sequence.getPatchList()[sm.getChannel()].getProgram()

						t = new eventsequences.Track(sm.getChannel());
						song.add(t);
					}

					if (sm.getCommand() == 0x90) { // Note On
						int key = sm.getData1();
						int octave = (key / 12)-1;
						int note = key % 12;
						//String noteName = NOTE_NAMES[note];
						int velocity = sm.getData2();
						//System.out.println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity);
						t.add(time, new NoteOn( key, velocity ));
					} else if (sm.getCommand() == 0x80) { // Note Off
						int key = sm.getData1();
						int octave = (key / 12)-1;
						int note = key % 12;
						//String noteName = NOTE_NAMES[note];
						int velocity = sm.getData2();
						//System.out.println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity);
						t.add(time, new NoteOff(key, velocity));
					} else if (sm.getCommand() == 0xC0) { // Program Change
						int ins = sm.getData1();
						t.setInstrument(Instrument.get(ins));
					} else if (sm.getCommand() == 0xB0) { // Pan, volume...
						int type = sm.getData1();
						int data = sm.getData2();
						switch(type) {
						case 0x0A: t.setPan(data); break;
						case 0x07: t.setVolume(data); break;
						//default: System.out.println("Type:" + type);
						}

					} else {
						//System.out.println("Command:" + sm.getCommand());
					}
				} else {
					//System.out.println("Other message: " + message.getClass());
				}
			}

			//System.out.println();
		}

		return song;
	}
}
