package es.danisales.datune.eventsequences;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

import es.danisales.datune.midi.Sequence;
import es.danisales.datune.midi.Events.Event;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.KeySignatureEvent;
import es.danisales.datune.midi.Events.MetaEvent;
import es.danisales.datune.midi.Events.Pan;
import es.danisales.datune.midi.Events.ProgramChange;
import es.danisales.datune.midi.Events.TempoEvent;
import es.danisales.datune.midi.Events.TrackChunk;
import es.danisales.datune.midi.Events.Volume;
import es.danisales.datune.midi.Progressions.Progression;
import es.danisales.datune.tonality.Tonality;

public class Track extends EventSequence {
	private int channel;
	private Instrument midiInstrument;

	private Sequence sequence; // Para firstOfSequence

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

	public void add(int n, Progression progression) {
		super.add(n, progression);

		setScale(progression.getScale());
	}

	public void add(EventComplex eventComplex) {
		add(0, eventComplex);
	}

	public void setScale(Tonality tonality) {
		add(0, new KeySignatureEvent(tonality));
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

	public void changeProgram(int d, Instrument v) {
		add(d, new ProgramChange(getChannel(), v));
	}

	@Override
	public void write(ByteBuffer buff) {
		EventSequence e = getBasicEvents();
		TrackChunk tc = new TrackChunk();

		if (sequence != null) {
			TempoEvent t = new TempoEvent( sequence.getTempo() );
			tc.add( t );

			final byte[] timeSigEvent = new byte[]
					{
						0x00, (byte)0xFF, 0x58, 0x04,
						0x04, // numerator
						0x02, // denominator (2==4, because it's a power fromIndex 2)
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

			tc.add( new ProgramChange(channel, midiInstrument) );
		}

		tc.add(e);

		// Standard footer
		final byte[] footer = new byte[]
				{
					0x00,
					(byte)0xFF, 0x2F, 0x00
				};

		tc.add(footer);

		tc.write( buff );
	}
}
