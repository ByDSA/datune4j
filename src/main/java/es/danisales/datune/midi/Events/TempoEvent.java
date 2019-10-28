package es.danisales.datune.midi.Events;

import es.danisales.datune.midi.Utils;

public class TempoEvent extends MetaEvent {
	int tempo;

	public TempoEvent(int n) {
		super(0, (byte)0x51);
		tempo = n;

		int q = (int)Math.round(60.0*1000*1000 / tempo);

		byte[] bs = Utils.dec2bytes(q);

		setData(bs);
	}

	public int getTempo() {
		return tempo;
	}

	public String toString() {
		return "Tempo: " + tempo;
	}

	public byte[] get() {
		if (data == null)
			throw new NullPointerException("No se ha especificado 'data'");

		byte[] deltaByte = Utils.deltaByte(delta);

		int l = deltaByte.length;

		byte[] ret = new byte[3+l+data.length];

		for(int i = 0; i < l; i++)
			ret[i] = deltaByte[i];

		ret[l] = status;
		ret[l+1] = type;
		ret[l+2] = (byte)0x03;
		for(int i = 0; i < data.length; i++)
			ret[i+l+3] = data[i];

		return ret;
	}
}
