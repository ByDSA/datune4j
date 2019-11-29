package es.danisales.datune.tonality;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

@SuppressWarnings("WeakerAccess")
public class Scale implements Iterable<ScaleDistance> {
	/**
	 * Constant Scales
	 */

	// 7
	public static final Scale MAJOR = new Scale(ScaleInnerImmutable.MAJOR);
	public static final Scale IONIAN = new Scale(ScaleInnerImmutable.IONIAN);
	public static final Scale DORIAN = new Scale(ScaleInnerImmutable.DORIAN);
	public static final Scale PHRYGIAN = new Scale(ScaleInnerImmutable.PHRYGIAN);
	public static final Scale LYDIAN = new Scale(ScaleInnerImmutable.LYDIAN);
	public static final Scale MIXOLYDIAN = new Scale(ScaleInnerImmutable.MIXOLYDIAN);
	public static final Scale MINOR = new Scale(ScaleInnerImmutable.MINOR);
	public static final Scale AEOLIAN = new Scale(ScaleInnerImmutable.AEOLIAN);
	public static final Scale LOCRIAN = new Scale(ScaleInnerImmutable.LOCRIAN);

	public static final Scale HARMONIC_MINOR = new Scale(ScaleInnerImmutable.HARMONIC_MINOR);
	public static final Scale LOCRIAN_H6 = new Scale(ScaleInnerImmutable.LOCRIAN_H6);
	public static final Scale IONIAN_H5 = new Scale(ScaleInnerImmutable.IONIAN_H5);
	public static final Scale DORIAN_H4 = new Scale(ScaleInnerImmutable.DORIAN_H4);
	public static final Scale UKRANIAN_MINOR_SCALE = new Scale(ScaleInnerImmutable.UKRANIAN_MINOR_SCALE);
	public static final Scale MIXOLIDIAN_b9_b13 = new Scale(ScaleInnerImmutable.MIXOLIDIAN_b9_b13);
	public static final Scale LYDIAN_H2 = new Scale(ScaleInnerImmutable.LYDIAN_H2);
	public static final Scale SUPERLOCRIAN_bb7 = new Scale(ScaleInnerImmutable.SUPERLOCRIAN_bb7);

	public static final Scale HARMONIC_MAJOR = new Scale(ScaleInnerImmutable.HARMONIC_MAJOR);
	public static final Scale DORIAN_b5 = new Scale(ScaleInnerImmutable.DORIAN_b5);
	public static final Scale PHRYGIAN_b4 = new Scale(ScaleInnerImmutable.PHRYGIAN_b4);
	public static final Scale LYDIAN_b3 = new Scale(ScaleInnerImmutable.LYDIAN_b3);
	public static final Scale MIXOLYDIAN_b2 = new Scale(ScaleInnerImmutable.MIXOLYDIAN_b2);
	public static final Scale AEOLIAN_b1 = new Scale(ScaleInnerImmutable.AEOLIAN_b1);
	public static final Scale LOCRIAN_bb7 = new Scale(ScaleInnerImmutable.LOCRIAN_bb7);

	public static final Scale MELODIC_MINOR = new Scale(ScaleInnerImmutable.MELODIC_MINOR);
	public static final Scale DORIAN_b2 = new Scale(ScaleInnerImmutable.DORIAN_b2);
	public static final Scale LYDIAN_H5 = new Scale(ScaleInnerImmutable.LYDIAN_H5);
	public static final Scale LYDIAN_b7 = new Scale(ScaleInnerImmutable.LYDIAN_b7);
	public static final Scale MIXOLIDIAN_b13 = new Scale(ScaleInnerImmutable.MIXOLIDIAN_b13);
	public static final Scale LOCRIAN_H2 = new Scale(ScaleInnerImmutable.LOCRIAN_H2);
	public static final Scale SUPERLOCRIAN = new Scale(ScaleInnerImmutable.SUPERLOCRIAN);

	public static final Scale DOUBLE_HARMONIC = new Scale(ScaleInnerImmutable.DOUBLE_HARMONIC);
	public static final Scale LYDIAN_H2_H6 = new Scale(ScaleInnerImmutable.LYDIAN_H2_H6);
	public static final Scale ULTRAPHRYGIAN = new Scale(ScaleInnerImmutable.ULTRAPHRYGIAN);
	public static final Scale HUNGARIAN_MINOR = new Scale(ScaleInnerImmutable.HUNGARIAN_MINOR);
	public static final Scale ORIENTAL = new Scale(ScaleInnerImmutable.ORIENTAL);
	public static final Scale IONIAN_AUGMENTED_H2 = new Scale(ScaleInnerImmutable.IONIAN_AUGMENTED_H2);
	public static final Scale LOCRIAN_bb3_bb7 = new Scale(ScaleInnerImmutable.LOCRIAN_bb3_bb7);

	public static final Scale NEAPOLITAN_MINOR = new Scale(ScaleInnerImmutable.NEAPOLITAN_MINOR);
	public static final Scale NEAPOLITAN_MAJOR = new Scale(ScaleInnerImmutable.NEAPOLITAN_MAJOR);

	public static final Scale BLUES = new Scale(ScaleInnerImmutable.BLUES);

	// 6
	public static final Scale WOLE_TONE = new Scale(ScaleInnerImmutable.WOLE_TONE);

	// 5
	public static final Scale PENTATONIC_MINOR = new Scale(ScaleInnerImmutable.PENTATONIC_MINOR);
	public static final Scale PENTATONIC = new Scale(ScaleInnerImmutable.PENTATONIC);
	public static final Scale EGYPCIAN = new Scale(ScaleInnerImmutable.EGYPCIAN);
	public static final Scale SUSPENDED = new Scale(ScaleInnerImmutable.SUSPENDED);
	public static final Scale BLUES_MINOR = new Scale(ScaleInnerImmutable.BLUES_MINOR);
	public static final Scale MAN_GONG = new Scale(ScaleInnerImmutable.MAN_GONG);
	public static final Scale BLUES_MAJOR = new Scale(ScaleInnerImmutable.BLUES_MAJOR);
	public static final Scale YO_SCALE = new Scale(ScaleInnerImmutable.YO_SCALE);

	// 12
	public static final Scale CHROMATIC = new Scale(ScaleInnerImmutable.CHROMATIC);

	public static final Set<Scale> DIATONICS = Collections.unmodifiableSet( new HashSet<>(Arrays.asList(
			Scale.IONIAN,
			Scale.DORIAN,
			Scale.PHRYGIAN,
			Scale.LYDIAN,
			Scale.MIXOLYDIAN,
			Scale.AEOLIAN,
			Scale.LOCRIAN
	) ) );

	public static final List<Scale> ALL = Collections.unmodifiableList(Arrays.asList(
			MAJOR,
			IONIAN,
			DORIAN,
			PHRYGIAN,
			LYDIAN,
			MIXOLYDIAN,
			MINOR,
			AEOLIAN,
			LOCRIAN,HARMONIC_MINOR,
			LOCRIAN_H6,
			IONIAN_H5,
			DORIAN_H4,
			UKRANIAN_MINOR_SCALE,
			MIXOLIDIAN_b9_b13,
			LYDIAN_H2,
			SUPERLOCRIAN_bb7,
			HARMONIC_MAJOR,
			DORIAN_b5,
			PHRYGIAN_b4,
			LYDIAN_b3,
			MIXOLYDIAN_b2,
			AEOLIAN_b1,
			LOCRIAN_bb7,
			MELODIC_MINOR,
			DORIAN_b2,
			LYDIAN_H5,
			LYDIAN_b7,
			MIXOLIDIAN_b13,
			LOCRIAN_H2,
			SUPERLOCRIAN,
			DOUBLE_HARMONIC,
			LYDIAN_H2_H6,
			ULTRAPHRYGIAN,
			HUNGARIAN_MINOR,
			ORIENTAL,
			IONIAN_AUGMENTED_H2,
			LOCRIAN_bb3_bb7,
			NEAPOLITAN_MINOR,
			NEAPOLITAN_MAJOR,
			BLUES/*,
			WOLE_TONE,
			PENTATONIC_MINOR,
			PENTATONIC,
			EGYPCIAN,
			SUSPENDED,
			BLUES_MINOR,
			MAN_GONG,
			BLUES_MAJOR,
			YO_SCALE,
			CHROMATIC*/
	));

	/**
	 * END CONSTANT SCALES
	 ***************************************************************************************************************/

	final ScaleInner innerScale;

	public static @NonNull Scale fromIntegers(List<Integer> v) {
		return new Scale( ScaleAdapter.fromIntegers(v) );
	}

	public static @NonNull Scale fromDistances(@NonNull List<ScaleDistance> scaleDistances) {
		return new Scale(ScaleInner.from(scaleDistances));
	}

	public static @NonNull Scale fromDiatonicAlt(@NonNull List<DiatonicAlt> notes) {
		return ScaleAdapter.fromDiatonicAltList(notes);
	}

	Scale(@NonNull ScaleInner scaleInterface) {
		innerScale = scaleInterface;
	}

	public @NonNull List<ScaleDistance> getCode() {
		return innerScale.getCode();
	}

	public @NonNull Scale getMode(@NonNull DiatonicDegree diatonicDegree) {
		return Scale.fromDistances(innerScale.getMode(diatonicDegree).getCode());
	}

	/**
	 * Get all modes fromDistances the scale
	 * @return the array within all modes fromDistances the scale
	 */
	public @NonNull List<Scale> getModes() {
		List<Scale> ret = new ArrayList<>();
		for ( int i = 0; i < size(); i++) {
			DiatonicDegree diatonicDegree = DiatonicDegree.values()[i];
			Scale scaleMode = getMode(diatonicDegree);
			ret.add(scaleMode);
		}

		return ret;
	}

	public boolean has(IntervalChromatic intervalChromatic) {
		int intervalChromaticSemitones = intervalChromatic.getSemitones() % Chromatic.NUMBER;
		float sum = 0;
		for (ScaleDistance scaleDistance : innerScale.getCode()) {
			if ( ScaleDistance.compare(sum, intervalChromaticSemitones) )
				return true;
			else if (sum > intervalChromaticSemitones)
				return false;
			sum += scaleDistance.getMicrotonalSemitones();
		}

		return false;
	}

	public int size() {
		return innerScale.size();
	}

	@Override
	public @NonNull Iterator<ScaleDistance> iterator() {
		return innerScale.getCode().iterator();
	}

	public @Nullable ScaleDistance get(DiatonicDegree diatonicDegree) {
		switch (size()) {
			default:
			case 7:
				return innerScale.get(diatonicDegree);
			case 5:
				if (equals(Scale.PENTATONIC)) {
					switch (diatonicDegree) {
						case I:
							return innerScale.get(DiatonicDegree.I);
						case II:
							return innerScale.get(DiatonicDegree.II);
						case III:
							return innerScale.get(DiatonicDegree.III);
						case V:
							return innerScale.get(DiatonicDegree.IV);
						case VI:
							return innerScale.get(DiatonicDegree.V);
					}
				} else if (equals(Scale.PENTATONIC_MINOR)) {
					switch (diatonicDegree) {
						case I:
							return innerScale.get(DiatonicDegree.I);
						case III:
							return innerScale.get(DiatonicDegree.II);
						case IV:
							return innerScale.get(DiatonicDegree.III);
						case V:
							return innerScale.get(DiatonicDegree.IV);
						case VII:
							return innerScale.get(DiatonicDegree.V);
					}
				}
				break;
		}

		return null;
	}

	/**
	 * The function scale is obtained fromDiatonicAlt a chain fromDiatonicAlt six successive fifths
	 It is either a sequence fromDiatonicAlt successive natural notes or a transposition thereof.
	 It can be written using seven consecutive notes without accidentals on a staff with no key signature or, when transposed, with a conventional key signature or with accidentals.
	 * @return if it's function
	 */
	public boolean isDiatonic() {
		for (Scale scale : DIATONICS)
			if (scale.equals(this))
				return true;
		return false;
	}

	@Override
	public String toString() {
		return ScaleNamer.from(this);
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof Scale))
			return false;

		Scale scale = (Scale)o;
		return scale.getCode().equals(getCode());
	}

	@Override
	public int hashCode() {
		return getCode().hashCode();
	}
}
