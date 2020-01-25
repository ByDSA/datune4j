package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.eventsequences.Instrument;
import es.danisales.io.binary.BinEncoder;

import java.util.function.BiConsumer;

public final class ProgramChange extends ChannelEvent {
    static {
        BinEncoder.register(ProgramChange.class, (BiConsumer<ProgramChange, BinEncoder.EncoderSettings>) ChunkData::encoder);
    }
	static final byte STATUS = (byte) 0xC0;
	private Instrument instrument;

	private ProgramChange(int delta, int channel, Instrument instrument) {
		super(delta, STATUS, channel);

		setInstrument(instrument);
	}

	public ProgramChange(int channel, Instrument v) {
		this(0, channel, v);
	}

	public void setInstrument(Instrument v) {
		instrument = v;

		updateData();
	}

	@Override
	public byte[] generateData() {
		return new byte[]{(byte) (instrument.value() & 0x7F)};
	}

	@Override
	public ProgramChange clone() {
		return new ProgramChange(getDelta(), getChannel(), instrument);
	}
}
