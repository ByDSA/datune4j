package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.io.binary.BinEncoder;
import es.danisales.io.binary.BinSize;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static com.google.common.base.Preconditions.checkState;

public final class NoteOff extends NoteEvent {
	public static final byte STATUS_BASE = (byte) 0x80;

	static {
		BinEncoder.register(NoteOn.class, (BiConsumer<ChannelEvent, BinEncoder.EncoderSettings>) ChunkData::encoder);
		BinSize.registerSize(NoteOn.class, (BiFunction<ChannelEvent, BinEncoder.EncoderSettings, Integer>) ChunkData::getBinarySize);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder extends NoteEvent.Builder<NoteOff> {
		private Builder() {
		}

		@NonNull
		@Override
		public NoteOff build() throws BuildingException {
			checkState(pitch > -1);
			try {
				PitchMidiException.check(pitch);
				return new NoteOff(delta, pitch, velocity, channel);
			} catch (PitchMidiException e) {
				throw new BuildingException(e);
			}
		}
	}

	private NoteOff(int delta, int pitch, int velocity, int channel) {
		super(delta, pitch, velocity, STATUS_BASE, channel);
	}

	public String toString() {
		try {
			return "NoteOn " + PitchChromaticMidi.from(getMidiCode());
		} catch (PitchMidiException e) {
			throw NeverHappensException.make("El código siempre es válido");
		}
	}

	@Override
	public NoteOff clone() {
		return new NoteOff(getDelta(), getMidiCode(), getVelocity(), getChannel());
	}
}
