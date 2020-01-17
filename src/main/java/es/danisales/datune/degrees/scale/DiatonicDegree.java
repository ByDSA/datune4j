package es.danisales.datune.degrees.scale;

import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.utils.MathUtils;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.Utils;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum DiatonicDegree implements ScaleDegree {
	I, II, III, IV, V, VI, VII;

	public static DiatonicDegree from(IntervalDiatonic intervalDiatonic) {
		return values()[intervalDiatonic.ordinal() % DiatonicDegree.values().length];
	}

	/**
	 * Returns the relativedegree with the added interval function
	 *
	 * @param id the id
	 * @return the relativedegree
	 */
	public static DiatonicDegree add(DiatonicDegree diatonicDegree, IntervalDiatonic id) {
		return fromIndex( diatonicDegree.ordinal() + id.ordinal() );
	}

	public static DiatonicDegree sub(DiatonicDegree diatonicDegree, IntervalDiatonic id) {
		return fromIndex( diatonicDegree.ordinal() - id.ordinal() );
	}

	@Override
	public DiatonicDegree getShifted(int i) {
		i = MathUtils.rotativeTrim(i, values().length);
		return values()[i];
	}

	/**
	 * Gets the relativedegree fromIndex an int
	 *
	 * @param n the n
	 * @return the relativedegree
	 */
	private static DiatonicDegree fromIndex(int n) {
		n = limitToOneOctave(n);

		return values()[n];
	}

	private static int limitToOneOctave(int n) {
		n = n % Diatonic.NUMBER;
		if ( n < 0 )
			n += Diatonic.NUMBER;
		return n;
	}

	public static @NonNull DiatonicDegree from(@NonNull DiatonicFunction diatonicFunction) {
		switch ( diatonicFunction ) {
			case I:
			case I6:
			case I7:
			case I9:
			case I11:
			case I13:
				return DiatonicDegree.I;
			case II:
			case II6:
			case II7:
			case II9:
			case II11:
			case II13:
				return DiatonicDegree.II;
			case III:
			case III6:
			case III7:
			case III9:
			case III11:
			case III13:
				return DiatonicDegree.III;
			case IV:
			case IV6:
			case IV7:
			case IV9:
			case IV11:
			case IV13:
				return DiatonicDegree.IV;
			case V:
			case V6:
			case V7:
			case V9:
			case V11:
			case V13:
				return DiatonicDegree.V;
			case VI:
			case VI6:
			case VI7:
			case VI9:
			case VI11:
			case VI13:
				return DiatonicDegree.VI;
			case VII:
			case VII6:
			case VII7:
			case VII9:
			case VII11:
			case VII13:
				return DiatonicDegree.VII;
		}
		throw NeverHappensException.switchOf(diatonicFunction);
	}

	public static @NonNull DiatonicDegree from(@NonNull ChromaticFunction chromaticFunction) {
		switch ( chromaticFunction ) {
			case I:
			case I5:
			case i:
			case I0:
			case ISUS4:
				return DiatonicDegree.I;
			case II:
			case II5:
			case ii:
			case II0:
			case N6:
			case IISUS4:
				return DiatonicDegree.II;
			case III:
			case III5:
			case iii:
			case III0:
			case bIII:
			case bIIISUS4:
				return DiatonicDegree.III;
			case IV:
			case IV5:
			case iv:
			case IV0:
			case IVSUS4:
				return DiatonicDegree.IV;
			case V:
			case V5:
			case v:
			case V0:
			case VSUS4:
				return DiatonicDegree.V;
			case VI:
			case VI5:
			case vi:
			case VI0:
			case bVI:
			case VISUS4:
				return DiatonicDegree.VI;
			case VII:
			case VII5:
			case vii:
			case VII0:
			case bVII:
			case bVIISUS4:
				return DiatonicDegree.VII;
			case SUBV7:
			case V7ALT:
				return DiatonicDegree.I;
			case SUBV7_II:
			case V7_II:
			case V_II:
				return DiatonicDegree.II;
			case SUBV7_III:
			case V7_III:
			case V_III:
				return DiatonicDegree.III;
			case SUBV7_IV:
			case V7_IV:
			case V_IV:
				return DiatonicDegree.IV;
			case SUBV7_V:
			case V_V:
			case V7_V:
				return DiatonicDegree.V;
			case SUBV7_VI:
			case V7_VI:
			case V_VI:
				return DiatonicDegree.VI;
		}

		throw NeverHappensException.switchOf(chromaticFunction);
	}

	@NonNull
	@Override
	public DiatonicDegree getNext() {
		int index = (ordinal() + 1) % DiatonicDegree.values().length;
		return values()[index];
	}

	@NonNull
	@Override
	public DiatonicDegree getPrevious() {
		int index = Utils.rotativeTrimLowerOnce(ordinal() - 1, values().length);

		return values()[index];
	}

	@Override
	public String toString() {
		return "Diatonic " + super.toString();
	}
}
