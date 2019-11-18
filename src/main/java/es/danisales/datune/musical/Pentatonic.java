package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.diatonic.PentatonicDegree;
import es.danisales.datune.musical.transformations.PentatonicAdapter;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum Pentatonic implements AbsoluteDegree<PentatonicDegree> {
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
		int index = (ordinal() + 1) % NUMBER;
		return values()[index];
	}

	public Pentatonic getPrevious() {
		int index = (NUMBER + ordinal() - 1) % NUMBER;
		return values()[index];
	}

	/** Calculator **/

	@Override
	public PentatonicDegree getDegree() {
		return PentatonicDegree.values()[ ordinal() ];
	}

	public IntervalDiatonic dist(Pentatonic n2) {
		int d = n2.getDegree().ordinal() - getDegree().ordinal();
		d = MathUtils.rotativeTrim(d, Pentatonic.NUMBER);

		return IntervalDiatonic.values()[d];
	}
}
