package es.danisales.datune.midi.binaries;

import es.danisales.datune.eventsequences.DrumsTrack;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.eventsequences.Instrument;
import es.danisales.datune.eventsequences.Track;
import es.danisales.datune.midi.Duration;
import es.danisales.datune.midi.binaries.events.Header;
import es.danisales.datune.midi.binaries.events.NoteOff;
import es.danisales.datune.midi.binaries.events.NoteOn;
import es.danisales.datune.midi.binaries.events.TempoEvent;
import es.danisales.io.binary.BinData;
import es.danisales.io.binary.BinEncoder;
import es.danisales.io.binary.BinFile;
import es.danisales.io.binary.BinSize;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.sound.midi.*;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Sequence extends BinFile {
	public final static int MILLISECONDS = 0;
	public final static int MIDI = 1;

	protected int tempo;
	protected List<Track> tracks;
	protected Track firstChannel;

	protected EventSequence events;

	MidiChannel[] mChannels;
	javax.sound.midi.Instrument[] instr;

	Synthesizer midiSynth;

	public Sequence(@NonNull Path path, int tempo) {
		super(path);
		this.tempo = tempo;
		tracks = new ArrayList<>();

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

		//getAllFrom and load default instrument and channel lists
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
		events.getWithSemiAdded(0, new TempoEvent(tempo));

		for(Track c : channels) {
			//mChannels[c.midiChannel].programChange(instr[c.midiInstrument].getPatch().getProgram());

			EventSequence e = c.getBasicEvents();
			//e.show(Note.V1);

			for(Map.Entry<Long, ArrayList<Event>> entry : e.getMap().entrySet()) {
				Long pitch = entry.getKey();
				ArrayList<Event> value = entry.getMidiCode();

				for(Event ev : value) {
					if (ev instanceof KeySignatureEvent)
						((KeySignatureEvent)ev).channel = c;

					long ms;
					if (type == MILLISECONDS)
						ms = (long)(60*1000.0 / tempo * pitch / Note.VSUS4);
					else if (type == MIDI)
						ms = pitch;
					else
						ms = -1;
					events.getWithSemiAdded(ms, ev);

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
			//System.out.println("events remain: " + events.size());
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
					Map.Entry<Long, ArrayList<Event>> entry = it.nextDiatonic();
					Long pitch = entry.getKey();
					ArrayList<Event> value = entry.getMidiCode();
					if (pitch > ms)
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

					events.remove(pitch);
				} else
					break;
			}
		}

		System.out.println("END!");
	}
	 */

	static {
		BinEncoder.register(Sequence.class, (Sequence self, BinEncoder.EncoderSettings settings) -> {
			DataOutputStream dataOutputStream = settings.getDataOutputStream();
			ByteArrayOutputStream byteArrayOutputStream = settings.getByteArrayOutputStream();
			Header header = self.generateHeader();

			BinData.encoder()
					.from(header)
					.toStream(dataOutputStream, byteArrayOutputStream)
					.putIntoStream();


			for (Track c : self.tracks) {
				BinData.encoder()
						.from(c)
						.toStream(dataOutputStream, byteArrayOutputStream)
						.putIntoStream();
			}
		});

		BinSize.register(Sequence.class, (Sequence self, BinEncoder.EncoderSettings settings) -> {
			int s = 0;
			Header h = self.generateHeader();
			s += BinSize.getBinarySizeOf(h);
			for (Track c : self.tracks) {
				s += c.sizeBytes();
			}
			return s;
		});
	}

	private Header generateHeader() {
		return new Header(Header.MULTIPLE_TRACK, tracks.size(), Header.TICKS_DEFAULT);
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

	public static Sequence loadRaw(File file) throws InvalidMidiDataException, IOException {
		javax.sound.midi.Sequence sequence = MidiSystem.getSequence( file );
		//System.out.println( sequence.getPatchList().size );
		int bpm = sequence.getResolution() / 8;
		Sequence song = new Sequence(null, bpm);

		int trackNumber = 0;
		for (javax.sound.midi.Track track :  sequence.getTracks()) {
			trackNumber++;
			//System.out.println("Track " + trackNumber + ": size = " + track.size());
			Track t = null;
			//System.out.println();
			for (int i = 0; i < track.size(); i++) {
				MidiEvent event = track.get(i);
				//System.out.print("@" + event.getTick() / (float)sequence.getResolution() + " ");
				MidiMessage message = event.getMessage();
				if (message instanceof ShortMessage) {
					ShortMessage sm = (ShortMessage) message;
					//System.out.print("Channel: " + sm.getChannel() + " ");
					long time = Duration.L4 * event.getTick() / sequence.getResolution();
					if (t == null) {
						int ins = 0; // sequence.getPatchList()[sm.getChannel()].getProgram()

						t = new Track(sm.getChannel());
						song.add(t);
					}

					if (sm.getCommand() == (int) NoteOn.STATUS_BASE) { // Note On
						int pitch = sm.getData1();
						int octave = (pitch / 12) - 1;
						int note = pitch % 12;
						//String noteName = NOTE_NAMES[note];
						int velocity = sm.getData2();
						//System.out.println("Note on, " + noteName + octave + " pitch=" + pitch + " velocity: " + velocity);
						NoteOn noteOn;
						try {
							noteOn = NoteOn.builder()
									.pitch(pitch)
									.velocity(velocity)
									.build();
						} catch (BuildingException e) {
							continue;
						}
						t.add(time, noteOn);
					} else if (sm.getCommand() == (int) NoteOff.STATUS_BASE) { // Note Off
						int pitch = sm.getData1();
						int octave = (pitch / 12) - 1;
						int note = pitch % 12;
						//String noteName = NOTE_NAMES[note];
						int velocity = sm.getData2();
						//System.out.println("Note off, " + noteName + octave + " pitch=" + pitch + " velocity: " + velocity);
						NoteOff noteOff;
						try {
							noteOff = NoteOff.builder()
									.pitch(pitch)
									.velocity(velocity)
									.build();
						} catch (BuildingException e) {
							continue;
						}
						t.add(time, noteOff);
					} else if (sm.getCommand() == 0xC0) { // Program Change
						int ins = sm.getData1();
						t.setInstrument(Instrument.get(ins));
					} else if (sm.getCommand() == 0xB0) { // Pan, volume...
						int type = sm.getData1();
						int data = sm.getData2();
						switch(type) {
							case 0x0A:
								t.setPan(data);
								break;
							case 0x07:
								t.setVolume(data);
								break;
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

	@Override
	protected byte[] encode() {
		return BinData.encoder()
				.from(this)
				.getBytes();
	}

	@Override
	protected void decode(byte[] byteArray) {
		BinData.decoder(Sequence.class)
				.from(ByteBuffer.wrap(byteArray))
				.getInstance();
	}
}
