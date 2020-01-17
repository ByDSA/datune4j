package es.danisales.datune.degrees.octave;

import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.degrees.scale.PentatonicDegree;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum Pentatonic implements OctaveDegree {
	C, D, E, G, A;

	public static final int NUMBER = 5;

	/** Building **/

	public static Pentatonic from(PentatonicDegree d) {
		return PentatonicAdapter.from( d );
	}

	@SuppressWarnings("Duplicates")
	public static @NonNull Pentatonic from(DiatonicAlt noteBase) {
		Diatonic diatonic = noteBase.getDiatonic();
		switch (diatonic) {
			case C: return C;
			case D: return D;
			case E: return E;
			case F: return E;
			case G: return G;
			case A: return A;
			case B: return C;
		}

		return null;
	}

	/** Transforms **/

	public Pentatonic getNext() {
		int index = MathUtils.rotativeTrim(ordinal() + 1, NUMBER);
		return values()[index];
	}

	public Pentatonic getPrevious() {
		int index = MathUtils.rotativeTrim(ordinal() - 1, NUMBER);
		return values()[index];
	}

	@Override
	public Pentatonic getShifted(int i) {
		i = MathUtils.rotativeTrim(ordinal()+i, NUMBER);
		return values()[i];
	}
}
