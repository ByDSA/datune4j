package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.transformations.DiatonicAdapter;
import es.danisales.datune.pitch.PitchDiatonicSingle;

public enum Diatonic implements PitchDiatonicSingle {
	C, D, E, F, G, A, B;

	public static final int N = 7;

	int intValue() {
		return ordinal();
	}

	/** Constrution **/

	public static Diatonic from(DiatonicDegree d) {
		return DiatonicAdapter.from( d );
	}

	public static Diatonic from(Chromatic chromatic) {
		return DiatonicAdapter.from(chromatic);
	}

	/** Transforms **/

	public Diatonic shift(int n) {
		return DiatonicAdapter.from( this.intValue() + n );
	}

	/** Calculator **/

	@Override
	public DiatonicDegree getDegree() {
		return DiatonicDegree.fromIndex( ordinal() );
	}

	public IntervalDiatonic dist(Diatonic n2) {
		int d = n2.getDegree().val() - getDegree().val();

		return IntervalDiatonic.fromIndex( d );
	}

	@Override
	public Diatonic getDiatonic() {
		return this;
	}
}
