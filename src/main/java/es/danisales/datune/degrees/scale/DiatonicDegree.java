package es.danisales.datune.degrees.scale;

import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.utils.MathUtils;
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
