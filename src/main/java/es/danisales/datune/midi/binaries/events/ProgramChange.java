package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.eventsequences.Instrument;

public class ProgramChange extends ChannelEvent {
	private Instrument value;

	public ProgramChange(int delta, int channel, Instrument v) {
		super(delta, (byte)0xC0, channel);
		
		setValue(v);
	}
	
	public ProgramChange(int channel, Instrument v) {
		this(0, channel, v);
	}
	
	public ProgramChange(Instrument v) {
		this(0, 0, v);
	}
	
	public void setValue(Instrument v) {
		value = v;

		setData(new byte[]{(byte)(value.val() & 0x7F)});
	}

	@SuppressWarnings("MethodDoesntCallSuperMethod")
	@Override
	public ProgramChange clone() {
		ProgramChange r = new ProgramChange(value);
		r.setData(getData());

		return r;
	}
}