package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.binaries.Utils;
import es.danisales.io.binary.BinEncoder;
import es.danisales.io.binary.BinSize;
import es.danisales.utils.MathUtils;

import java.io.IOException;

public class TempoEvent extends MetaEvent {
	static {
		BinEncoder.register(TempoEvent.class, (TempoEvent self, BinEncoder.EncoderSettings settings) -> {
			byte[] deltaByte = Utils.deltaByte(self.getDelta());

			int l = deltaByte.length;

			byte[] ret = new byte[3 + l + self.getData().length];

			System.arraycopy(deltaByte, 0, ret, 0, l);

			ret[l] = self.getStatus();
			ret[l + 1] = self.type;
			ret[l + 2] = (byte) 0x03;
			for (int i = 0; i < self.getData().length; i++)
				ret[i + l + 3] = self.getData()[i];

			try {
				settings.getDataOutputStream().write(ret);
			} catch (IOException ignored) {
			}
		});

		BinSize.registerSize(TempoEvent.class, (TempoEvent self, BinEncoder.EncoderSettings settings) -> {
			int l = Utils.deltaByte(self.getDelta()).length;
			return 3 + l + self.getData().length;
		});
	}

	private int tempo;

	public TempoEvent(int tempo) {
		super(0, (byte)0x51);
		this.tempo = tempo;

		updateData();
	}

	@Override
	protected byte[] generateData() {
		int q = (int) Math.round(60.0 * 1000 * 1000 / tempo);

		return MathUtils.dec2bytes(q);
	}

	@Override
	public TempoEvent clone() {
		return new TempoEvent(tempo);
	}

	@SuppressWarnings("unused")
	public int getTempo() {
		return tempo;
	}

	public String toString() {
		return "Tempo: " + tempo;
	}
}
