package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.io.binary.BinEncoder;
import es.danisales.io.binary.BinSize;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public final class NoteOn extends NoteEvent {
	public static final byte STATUS_BASE = (byte) (0x90);

	static {
		BinEncoder.register(NoteOn.class, (BiConsumer<ChannelEvent, BinEncoder.EncoderSettings>) ChunkData::encoder);
		BinSize.registerSize(NoteOn.class, (BiFunction<ChannelEvent, BinEncoder.EncoderSettings, Integer>) ChunkData::getBinarySize);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder extends NoteEvent.Builder<NoteOn> {
		private Builder() {
		}

		@NonNull
		@Override
		public NoteOn build() {
			return new NoteOn(delta, pitch, velocity, channel);
		}
	}

	private NoteOn(int delta, int key, int velocity, int channel) {
		super(delta, key, velocity, STATUS_BASE, channel);
	}

	public String toString() {
		try {
			return "NoteOn " + PitchChromaticMidi.from(getMidiCode());
		} catch (PitchMidiException e) {
			throw NeverHappensException.make("El código siempre es válido");
		}
	}

	@Override
	public NoteOn clone() {
		return new NoteOn(getDelta(), getMidiCode(), getVelocity(), getChannel());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof NoteOn))
			return false;

		return super.equals(o);
	}
}
