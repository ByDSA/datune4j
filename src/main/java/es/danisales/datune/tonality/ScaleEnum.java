package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

enum ScaleEnum implements ScaleInterface {
	// 7
	MAJOR( 2, 2, 1, 2, 2, 2, 1 ),
	IONIAN( MAJOR ),
	DORIAN( MAJOR.getMode(DiatonicDegree.II) ),
	PHRYGIAN( MAJOR.getMode( DiatonicDegree.III ) ),
	LYDIAN( MAJOR.getMode( DiatonicDegree.IV ) ),
	MIXOLYDIAN( MAJOR.getMode( DiatonicDegree.V ) ),
	MINOR( MAJOR.getMode( DiatonicDegree.VI ) ),
	AEOLIAN( MINOR ),
	LOCRIAN( MAJOR.getMode( DiatonicDegree.VII ) ),

	HARMONIC_MINOR( 2, 1, 2, 2, 1, 3, 1 ),
	LOCRIAN_H6( HARMONIC_MINOR.getMode( DiatonicDegree.II ) ),
	IONIAN_H5( HARMONIC_MINOR.getMode( DiatonicDegree.III ) ),
	DORIAN_H4( HARMONIC_MINOR.getMode( DiatonicDegree.IV ) ),
	UKRANIAN_MINOR_SCALE( DORIAN_H4 ),
	MIXOLIDIAN_b9_b13( HARMONIC_MINOR.getMode( DiatonicDegree.V ) ),
	LYDIAN_H2( HARMONIC_MINOR.getMode( DiatonicDegree.VI ) ),
	SUPERLOCRIAN_bb7( HARMONIC_MINOR.getMode( DiatonicDegree.VII ) ),

	HARMONIC_MAJOR( 2, 2, 1, 2, 1, 3, 1 ),
	DORIAN_b5( HARMONIC_MAJOR.getMode( DiatonicDegree.II ) ),
	PHRYGIAN_b4( HARMONIC_MAJOR.getMode( DiatonicDegree.III ) ),
	LYDIAN_b3( HARMONIC_MAJOR.getMode( DiatonicDegree.IV ) ),
	MIXOLYDIAN_b2( HARMONIC_MAJOR.getMode( DiatonicDegree.V ) ),
	AEOLIAN_b1( HARMONIC_MAJOR.getMode( DiatonicDegree.VI ) ),
	LOCRIAN_bb7( HARMONIC_MAJOR.getMode( DiatonicDegree.VII ) ),

	MELODIC_MINOR( 2, 1, 2, 2, 2, 2, 1 ),
	DORIAN_b2( MELODIC_MINOR.getMode( DiatonicDegree.II ) ),
	LYDIAN_H5( MELODIC_MINOR.getMode( DiatonicDegree.III ) ),
	LYDIAN_b7( MELODIC_MINOR.getMode( DiatonicDegree.IV ) ),
	MIXOLIDIAN_b13( MELODIC_MINOR.getMode( DiatonicDegree.V ) ),
	LOCRIAN_H2( MELODIC_MINOR.getMode( DiatonicDegree.VI ) ),
	SUPERLOCRIAN( MELODIC_MINOR.getMode( DiatonicDegree.VII ) ),

	DOUBLE_HARMONIC( 1, 3, 1, 2, 1, 3, 1 ),
	LYDIAN_H2_H6( DOUBLE_HARMONIC.getMode( DiatonicDegree.II ) ),
	ULTRAPHRYGIAN( DOUBLE_HARMONIC.getMode( DiatonicDegree.III ) ),
	HUNGARIAN_MINOR( DOUBLE_HARMONIC.getMode( DiatonicDegree.IV ) ),
	ORIENTAL( DOUBLE_HARMONIC.getMode( DiatonicDegree.V ) ),
	IONIAN_AUGMENTED_H2( DOUBLE_HARMONIC.getMode( DiatonicDegree.VI ) ),
	LOCRIAN_bb3_bb7( DOUBLE_HARMONIC.getMode( DiatonicDegree.VII ) ),

	NEAPOLITAN_MINOR( 1, 2, 2, 2, 1, 3, 1 ),
	NEAPOLITAN_MAJOR( 1, 2, 2, 2, 2, 2, 1 ),

	BLUES( 3, 2, 1, 1, 3, 2 ),

	// 6
	WOLE_TONE( 2, 2, 2, 2, 2, 2 ),

	// 5
	PENTATONIC_MINOR( 3, 2, 3, 2, 2 ),
	PENTATONIC( PENTATONIC_MINOR.getMode( DiatonicDegree.II ) ),
	EGYPCIAN( PENTATONIC_MINOR.getMode( DiatonicDegree.III ) ),
	SUSPENDED( EGYPCIAN ),
	BLUES_MINOR( PENTATONIC_MINOR.getMode( DiatonicDegree.IV ) ),
	MAN_GONG( BLUES_MINOR ),
	BLUES_MAJOR( PENTATONIC_MINOR.getMode( DiatonicDegree.V ) ),
	YO_SCALE( BLUES_MAJOR),

	// 12
	CHROMATIC(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

	private static final Map<List<ScaleDistance>, ScaleEnum> _map = new HashMap<>();
	static {
		for (ScaleEnum s : values()) {
			_map.putIfAbsent(s.value, s);
		}
	}

	@SuppressWarnings("ConstantConditions") // Se crea primero las constantes de ScaleEnum que el map.
	static @Nullable ScaleEnum of(@NonNull List<ScaleDistance> code) {
		if (_map == null)
			return null;
		Objects.requireNonNull(code);
		checkArgument(code.size() > 0);

		return _map.get( code );
	}

	private final List<ScaleDistance> value;

	ScaleEnum(List<ScaleDistance> values) {
		value = Collections.unmodifiableList(values);

		sumCheck();
	}

	ScaleEnum(int... intValues) {
		ScaleDistance[] distanceScales = new ScaleDistance[intValues.length];
		for (int i = 0; i < intValues.length; i++)
			distanceScales[i] = ScaleDistance.from(intValues[i]);

		value = Collections.unmodifiableList (Arrays.asList(distanceScales));

		sumCheck();
	}

	ScaleEnum(ScaleInterface s) {
		this( s.getCode() );
	}

	@Override
	public List<ScaleDistance> getCode() {
		return value;
	}

	@Override
	public int size() {
		return value.size();
	}

	@Override
	public @NonNull ScaleDistance get(DiatonicDegree diatonicDegree) {
		return value.get(diatonicDegree.ordinal());
	}
}
