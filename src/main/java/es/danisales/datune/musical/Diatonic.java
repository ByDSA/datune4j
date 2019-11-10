package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.transformations.DiatonicAdapter;
import es.danisales.datune.pitch.PitchDiatonicSingle;

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

	/** Transforms **/

	public Diatonic shift(IntervalDiatonic intervalDiatonic) {
		return DiatonicAdapter.from( this.intValue() + intervalDiatonic.ordinal() );
	}

	public Diatonic next() {
		return shift(IntervalDiatonic.SECOND);
	}

	/** Calculator **/

	int intValue() {
		return ordinal();
	}

	@Override
	public DiatonicDegree getDegree() {
		return DiatonicDegree.values()[ ordinal() ];
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
