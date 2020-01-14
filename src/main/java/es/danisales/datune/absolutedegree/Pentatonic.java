package es.danisales.datune.absolutedegree;

import es.danisales.datune.degree.PentatonicDegree;
import es.danisales.datune.interval.IntervalPentatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.CyclicAbsoluteDegree;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public enum Pentatonic implements CyclicAbsoluteDegree<PentatonicDegree, IntervalPentatonic> {
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

	@Override
    public @Nullable Pentatonic getShifted(@NonNull IntervalPentatonic intervalPentatonic) {
		int i = (ordinal() + intervalPentatonic.ordinal()) % NUMBER;
		return values()[i];
	}

	@Override
    public Pentatonic getShiftedNegative(@NonNull IntervalPentatonic intervalPentatonic) {
		int i = (ordinal() - intervalPentatonic.ordinal()) % NUMBER;
		return values()[i];
	}

	/** Calculator **/

	@Override
    public @NonNull PentatonicDegree getDegree() {
		return PentatonicDegree.values()[ ordinal() ];
	}
}
