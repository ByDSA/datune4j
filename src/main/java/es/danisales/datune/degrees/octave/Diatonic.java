package es.danisales.datune.degrees.octave;

import es.danisales.datune.GlobalSettings;
import es.danisales.datune.degrees.OrderedDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.lang.Language;
import es.danisales.utils.MathUtils;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum Diatonic implements CyclicDegree, OrderedDegree, Cloneable {
	C, D, E, F, G, A, B;

	public static final int NUMBER = 7;

	/** Building **/

	public static Diatonic from(DiatonicDegree d) {
		return DiatonicAdapter.from( d );
	}

	private static final Map<Integer, Function<CyclicDegree, Diatonic>> mapConverter = new HashMap<>();

	static {
		mapConverter.put(7, (CyclicDegree absoluteDegree) -> (Diatonic) absoluteDegree);

		mapConverter.put(12, (CyclicDegree absoluteDegree) -> {
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

		mapConverter.put(5, (CyclicDegree absoluteDegree) -> {
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

    public static Diatonic from(@NonNull CyclicDegree absoluteDegree) {
		if (absoluteDegree instanceof Diatonic)
			return (Diatonic) absoluteDegree;

        Integer number = CyclicDegreeAdapter.getNumber(absoluteDegree);
		Function<CyclicDegree, Diatonic> f = mapConverter.get(number);
		if (f == null)
			f = Diatonic::defaultAbsoluteDegreeFunction;
		return f.apply(absoluteDegree);
	}

    private static Diatonic defaultAbsoluteDegreeFunction(CyclicDegree absoluteDegree) {
		int index = absoluteDegree.ordinal();

        int absoluteDegreeNumber = CyclicDegreeAdapter.getNumber(absoluteDegree);
		if (absoluteDegreeNumber > Diatonic.NUMBER)
			index = (int)Math.round((double) (Diatonic.NUMBER) / absoluteDegreeNumber * index) % Diatonic.NUMBER;

		return Diatonic.values()[index];
	}

	/** Transforms **/

	public Diatonic getShifted(IntervalDiatonic intervalDiatonic) {
		return getShifted( intervalDiatonic.ordinal() );
	}

	public Diatonic getShiftedNegative(IntervalDiatonic intervalDiatonic) {
		return getShifted( -intervalDiatonic.ordinal() );
	}

	@Override
	public Diatonic getShifted(int i) {
		return DiatonicAdapter.from( this.ordinal() + i );
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

	public IntervalDiatonic dist(Diatonic n2) {
		int d = n2.ordinal() - ordinal();
		d = MathUtils.rotativeTrim(d, Diatonic.NUMBER);

		return IntervalDiatonic.values()[d];
	}

	@Override
	public String toString() {
		switch (GlobalSettings.sigleton().getLanguage()) {
			default:
			case EN:
				return name();
			case ES:
				switch (this) {
					case C:
						return "Do";
					case D:
						return "Re";
					case E:
						return "Mi";
					case F:
						return "Fa";
					case G:
						return "Sol";
					case A:
						return "La";
					case B:
						return "Si";
				}
		}

		throw NeverHappensException.switchOf(this);
	}
}
