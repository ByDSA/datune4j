package eventsequences;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

import diatonic.Tonality;
import midi.Sequence;
import midi.Events.Event;
import midi.Events.EventComplex;
import midi.Events.KeySignatureEvent;
import midi.Events.MetaEvent;
import midi.Events.Pan;
import midi.Events.ProgramChange;
import midi.Events.TempoEvent;
import midi.Events.TrackChunk;
import midi.Events.Volume;
import midi.Progressions.Progression;

public class Track extends EventSequence {
	int channel;
	Instrument midiInstrument;

	Sequence sequence; // Para firstOfSequence

	public Track(int mc, Instrument i) {
		channel = mc;
		midiInstrument = i;

		sequence = null;
	}

	public Track(int mc) {
		this(mc, Instrument.ACOUSTIC_GRAND_PIANO);
	}

	public void setInstrument(Instrument i) {
		midiInstrument = i;
	}

	public boolean isDrums() {
		return channel == 10-1;
	}

	public void add(int n, Progression p) {
		super.add(n, p);

		setScale(p.getScale());
	}

	public void add(EventComplex p) {
		add(0, p);
	}

	public void setScale(Tonality s) {
		add(0, new KeySignatureEvent(s));
	}

	public void setPan(int p) {
		add(0, new Pan(p));
	}

	public void setVolume(int p) {
		add(0, new Volume(p));
	}

	public void setScale(int t, Tonality s) {
		add(t, new KeySignatureEvent(s));
	}

	public void firstOfSequence(Sequence s) {
		sequence = s;
	}

	public int getChannel() {
		return channel;
	}

	public Instrument getInstrument() {
		return midiInstrument;
	}

	public Track toNotes() {
		EventSequence es = super.toNotes();
		Track t2 = new Track(getChannel(), getInstrument());
		t2.add(es);

		return t2;
	}

	public Track changeProgram(int d, Instrument v) {
		add(d, new ProgramChange(getChannel(), v));

		return this;
	}

	@Override
	public void write(ByteBuffer buff) {
		for(Map.Entry<Long, ArrayList<Event>> entry : this.getMap().entrySet()) {
			Long key = entry.getKey();
			ArrayList<Event> value = entry.getValue();
			//break;
		}

		EventSequence e = getBasicEvents();
		TrackChunk tc = new TrackChunk();

		if (sequence != null) {
			TempoEvent t = new TempoEvent( sequence.getTempo() );
			tc.add( t );

			final byte timeSigEvent[] = new byte[]
					{
						0x00, (byte)0xFF, 0x58, 0x04,
						0x04, // numerator
						0x02, // denominator (2==4, because it's a power of 2)
						0x18, // ticks per click (not used)
						0x08  // 32nd notes per crotchet 
					};
			tc.add (timeSigEvent);
		} else {
			tc.add(new MetaEvent(0, (byte)0x20) {
				{
					setData(new byte[]{(byte)channel});
				}
			});

			tc.add(new ProgramChange(channel, midiInstrument));
		}

		tc.add(e);

		// Standard footer
		final byte footer[] = new byte[]
				{
					0x00,
					(byte)0xFF, 0x2F, 0x00
				};

		tc.add(footer);

		tc.write( buff );
	}
}
