package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.binaries.Utils;
import es.danisales.utils.MathUtils;

import java.util.Objects;

public class TempoEvent extends MetaEvent {
	private int tempo;

	public TempoEvent(int n) {
		super(0, (byte)0x51);
		tempo = n;

		int q = (int)Math.round(60.0*1000*1000 / tempo);

		byte[] bs = MathUtils.dec2bytes(q);

		setData(bs);
	}

	@SuppressWarnings("unused")
	public int getTempo() {
		return tempo;
	}

	public String toString() {
		return "Tempo: " + tempo;
	}

	@Override
	protected byte[] getMetaBytes() {
		Objects.requireNonNull(data, "No se ha especificado 'data'");

		byte[] deltaByte = Utils.deltaByte(delta);

		int l = deltaByte.length;

		byte[] ret = new byte[3+l+data.length];

		System.arraycopy(deltaByte, 0, ret, 0, l);

		ret[l] = status;
		ret[l+1] = type;
		ret[l+2] = (byte)0x03;
		for(int i = 0; i < data.length; i++)
			ret[i+l+3] = data[i];

		return ret;
	}
}
