package es.danisales.datune.tonality;

import com.google.common.primitives.Ints;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public interface Scale {
	List<Integer> getValue();

	/**
	 * Returns the scale mode
	 * @param diatonicDegree number of rotations
	 * @return scale mode
	 */
	default Scale getMode(DiatonicDegree diatonicDegree) {
		List<Integer> baseValues = this.getValue();
		Collections.rotate( baseValues, -diatonicDegree.ordinal() );
		return Scale.of( baseValues );
	}

	static Scale of(List<Integer> values) {
		return new CustomScale( values );
	}

	static Scale fromDiatonicAlt(@NonNull List<DiatonicAlt> notes) {
		int[] ton = new int[notes.size()];
		int sum = 0;
		for ( int i = 0; i < notes.size() - 1; i++ ) {
			DiatonicAlt current = notes.get(i);
			DiatonicAlt next = notes.get(i + 1);
			Chromatic nextChromatic = Chromatic.from(next);
			ton[i] = Chromatic.from(current).distSemitonesTo(nextChromatic);
			while ( ton[i] < 0 )
				ton[i] += Chromatic.NUMBER;
			sum += ton[i];
		}
		int dif = Chromatic.NUMBER - sum;
		checkArgument(dif > 0);
		ton[notes.size() - 1] = dif;

		return Scale.of( ton );
	}

	/**
	 * Get all modes fromIndex the scale
	 * @return the array within all modes fromIndex the scale
	 */
	default List<Scale> getAllModes() {
		List<Scale> ret = new ArrayList<>();
		for ( DiatonicDegree diatonicDegree : DiatonicDegree.values()) {
			Scale scaleMode = getMode(diatonicDegree);
			ret.add(scaleMode);
		}

		return ret;
	}

	int size();

	int get(DiatonicDegree diatonicDegree);

	/**
	 * The diatonic scale is obtained from a chain from six successive fifths
	 It is either a sequence from successive natural notes or a transposition thereof.
	 It can be written using seven consecutive notes without accidentals on a staff with no key signature or, when transposed, with a conventional key signature or with accidentals.
	 * @return if it's diatonic
	 */
	default boolean isDiatonic() {
		for ( ScaleEnum s : ScaleEnum.DIATONICS )
			if ( this.equals( s ) )
				return true;
		return false;
	}

	default boolean equals(Scale s) {
		return getValue().equals(s.getValue());
	}

	static @NonNull Scale of(int... v) {
		List<Integer> integerList = Ints.asList(v);
		Scale s = ScaleEnum.of( integerList );
		if (s == null)
			s = new CustomScale( integerList );
		return s;
	}
}
