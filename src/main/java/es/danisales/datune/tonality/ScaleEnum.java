package es.danisales.datune.tonality;

import com.google.common.primitives.Ints;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.musical.transformations.Namer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.base.Preconditions.checkArgument;

public enum ScaleEnum implements Scale {
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
	YO_SCALE( BLUES_MAJOR);

	private static final Map<List<Integer>, ScaleEnum> _map = new HashMap<>();
	static {
		for (ScaleEnum s : values()) {
			Integer[] integers = Arrays.stream( s.value ).boxed().toArray( Integer[]::new );
			List<Integer> array = Arrays.asList(integers);
			_map.putIfAbsent(array, s);
		}
	}

	public static @Nullable ScaleEnum of(@NonNull List<Integer> integers) {
		Objects.requireNonNull(integers);
		checkArgument(integers.size() > 0);

		return _map.get( integers );
	}

	public static final ScaleEnum[] DIATONICS = new ScaleEnum[] {
			IONIAN,
			DORIAN,
			PHRYGIAN,
			LYDIAN,
			MIXOLYDIAN,
			AEOLIAN,
			LOCRIAN
	};

	private int[] value;

	ScaleEnum(int... i) throws ScaleException {
		value = i;
		if (IntStream.of( i ).sum() != IntervalChromatic.PERFECT_OCTAVE.getSemitones()) {
			System.out.println( IntStream.of( i ).sum() );
			System.out.println( IntervalChromatic.PERFECT_OCTAVE.getSemitones() );
			throw new ScaleException( this );
		}
	}

	ScaleEnum(Scale s) {
		this( Ints.toArray(s.getValue()) );
	}

	@Override
	public List<Integer> getValue() {
		return Arrays.stream(value).boxed().collect(Collectors.toList());
	}

	@Override
	public int size() {
		return value.length;
	}

	@Override
	public int get(DiatonicDegree diatonicDegree) {
		return value[diatonicDegree.ordinal()];
	}

	@Override
	public String toString() {
		return ScaleNamer.from(this);
	}
}
