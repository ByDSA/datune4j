package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.Progressions.Progression;
import es.danisales.datune.midi.binaries.Sequence;
import es.danisales.datune.midi.binaries.events.*;
import es.danisales.datune.tonality.Tonality;
import es.danisales.io.binary.BinData;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

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

		setScale(progression.getTonality());
	}

	public void add(EventComplex eventComplex) {
		add(0, eventComplex);
	}

	public void setScale(Tonality tonality) {
		add(0, new KeySignatureEvent(tonality));
	}

	public void setPan(int p) {
		Pan pan = Pan.builder()
				.delta(0)
				.value(p)
				.channel(channel)
				.build();
		add(0, pan);
	}

	public void setVolume(int p) {
		add(0, new Volume(0, p, channel));
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

	class MetaEvent20 extends MetaEvent {
		public MetaEvent20() {
			super(0, (byte) 0x20);
		}

		@Override
		protected byte[] generateData() {
			return new byte[]{(byte) channel};
		}

		@Override
		public MetaEvent20 clone() {
			return new MetaEvent20();
		}
	}

	public void writeIn(DataOutputStream dataOutputStream, ByteArrayOutputStream byteArrayOutputStream) {
		EventSequence eventSequence = getBasicEvents();
		TrackChunk trackChunk = new TrackChunk();

		if (sequence != null) {
			TempoEvent t = new TempoEvent( sequence.getTempo() );
			trackChunk.add(t);

			final byte[] timeSigEvent = new byte[]
					{
							0x00, (byte) 0xFF, 0x58, 0x04,
							0x04, // numerator
							0x02, // denominator (2==4, because it's a power fromIndex 2)
							0x18, // ticks per click (not used)
							0x08  // 32nd notes per crotchet
					};
			trackChunk.add(timeSigEvent);
		} else {
			trackChunk.add(new MetaEvent20());

			trackChunk.add(new ProgramChange(channel, midiInstrument));
		}

		trackChunk.add(eventSequence);

		// Standard footer
		final byte[] footer = new byte[]
				{
						0x00,
						(byte) 0xFF, 0x2F, 0x00
				};

		trackChunk.add(footer);

		BinData.encoder()
				.from(trackChunk)
				.toStream(dataOutputStream, byteArrayOutputStream)
				.putIntoStream();
	}
}
