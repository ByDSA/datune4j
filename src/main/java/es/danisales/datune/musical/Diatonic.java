package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.transformations.DiatonicAdapter;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.pitch.AbsoluteDegreeAdapter;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum Diatonic implements PitchDiatonicSingle {
	C, D, E, F, G, A, B;

	public static final int NUMBER = 7;

	/** Building **/

	public static Diatonic from(DiatonicDegree d) {
		return DiatonicAdapter.from( d );
	}

	public static Diatonic from(DiatonicAlt diatonicAlt) {
		return DiatonicAdapter.from(diatonicAlt);
	}

	private static final Map<Integer, Function<AbsoluteDegree, Diatonic>> mapConversor = new HashMap<>();

	static {
		mapConversor.put(7, (AbsoluteDegree absoluteDegree) -> (Diatonic) absoluteDegree);

		mapConversor.put(12, (AbsoluteDegree absoluteDegree) -> {
			Chromatic chromatic = (Chromatic) absoluteDegree;

			switch (chromatic) {
				case C:
				case CC:
					return C;
				case D:
				case DD:
					return D;
				case E:
					return E;
				case F:
				case FF:
					return F;
				case G:
				case GG:
					return G;
				case A:
				case AA:
					return A;
				case B:
					return B;
			}

			return null;
		});

		mapConversor.put(5, (AbsoluteDegree absoluteDegree) -> {
			Pentatonic pentatonic = (Pentatonic) absoluteDegree;

			switch (pentatonic) {
				case C: return C;
				case D: return D;
				case E: return E;
				case G: return G;
				case A: return A;
			}

			return null;
		});
	}

	public static Diatonic from(@NonNull AbsoluteDegree absoluteDegree) {
		Integer number = AbsoluteDegreeAdapter.getNumber(absoluteDegree);
		Function<AbsoluteDegree, Diatonic> f = mapConversor.get(number);
		if (f == null)
			f = Diatonic::defaultAbsoluteDegreeFunction;
		return f.apply(absoluteDegree);
	}

	private static Diatonic defaultAbsoluteDegreeFunction(AbsoluteDegree absoluteDegree) {
		int index = absoluteDegree.getDegree().ordinal();

		int absoluteDegreeNumber = AbsoluteDegreeAdapter.getNumber(absoluteDegree);
		if (absoluteDegreeNumber > Diatonic.NUMBER)
			index = (int)Math.round((double) (Diatonic.NUMBER) / absoluteDegreeNumber * index) % Diatonic.NUMBER;

		return Diatonic.values()[index];
	}

	/** Transforms **/

	@Override
	public Diatonic getShifted(IntervalDiatonic intervalDiatonic) {
		return DiatonicAdapter.from( this.ordinal() + intervalDiatonic.ordinal() );
	}

	@Override
	public Diatonic getShiftedNegative(IntervalDiatonic intervalDiatonic) {
		return DiatonicAdapter.from( this.ordinal() - intervalDiatonic.ordinal() );
	}

	@Override
	public Diatonic getNext() {
		return getShifted(IntervalDiatonic.SECOND);
	}

	@Override
	public Diatonic getPrevious() {
		return getShiftedNegative(IntervalDiatonic.SECOND);
	}

	/** Calculator **/

	@Override
	public DiatonicDegree getDegree() {
		return DiatonicDegree.values()[ ordinal() ];
	}

	public IntervalDiatonic dist(Diatonic n2) {
		int d = n2.getDegree().ordinal() - getDegree().ordinal();
		d = MathUtils.rotativeTrim(d, Diatonic.NUMBER);

		return IntervalDiatonic.values()[d];
	}

	@Override
	public Diatonic getDiatonic() {
		return this;
	}
}
