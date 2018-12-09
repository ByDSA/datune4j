package diatonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import datastructures.ArrayWrapper;

public enum ScaleEnum implements Scale {
	// 7
	MAJOR( 2, 2, 1, 2, 2, 2, 1 ),
	IONIAN( MAJOR ),
	DORIAN( MAJOR.getMode( 1 ) ),
	PHRYGIAN( MAJOR.getMode( 2 ) ),
	LYDIAN( MAJOR.getMode( 3 ) ),
	MIXOLYDIAN( MAJOR.getMode( 4 ) ),
	MINOR( MAJOR.getMode( 5 ) ),
	AEOLIAN( MINOR ),
	LOCRIAN( MAJOR.getMode( 6 ) ),

	HARMONIC_MINOR( 2, 1, 2, 2, 1, 3, 1 ),
	LOCRIAN_H6( HARMONIC_MINOR.getMode( 1 ) ),
	IONIAN_H5( HARMONIC_MINOR.getMode( 2 ) ),
	DORIAN_H4( HARMONIC_MINOR.getMode( 3 ) ),
	UKRANIAN_MINOR_SCALE( DORIAN_H4 ),
	MIXOLIDIAN_b9_b13( HARMONIC_MINOR.getMode( 4 ) ),
	LYDIAN_H2( HARMONIC_MINOR.getMode( 5 ) ),
	SUPERLOCRIAN_bb7( HARMONIC_MINOR.getMode( 6 ) ),

	HARMONIC_MAJOR( 2, 2, 1, 2, 1, 3, 1 ),
	DORIAN_b5( HARMONIC_MAJOR.getMode( 1 ) ),
	PHRYGIAN_b4( HARMONIC_MAJOR.getMode( 2 ) ),
	LYDIAN_b3( HARMONIC_MAJOR.getMode( 3 ) ),
	MIXOLYDIAN_b2( HARMONIC_MAJOR.getMode( 4 ) ),
	AEOLIAN_b1( HARMONIC_MAJOR.getMode( 5 ) ),
	LOCRIAN_bb7( HARMONIC_MAJOR.getMode( 6 ) ),

	MELODIC_MINOR( 2, 1, 2, 2, 2, 2, 1 ),
	DORIAN_b2( MELODIC_MINOR.getMode( 1 ) ),
	LYDIAN_H5( MELODIC_MINOR.getMode( 2 ) ),
	LYDIAN_b7( MELODIC_MINOR.getMode( 3 ) ),
	MIXOLIDIAN_b13( MELODIC_MINOR.getMode( 4 ) ),
	LOCRIAN_H2( MELODIC_MINOR.getMode( 5 ) ),
	SUPERLOCRIAN( MELODIC_MINOR.getMode( 6 ) ),

	DOUBLE_HARMONIC( 1, 3, 1, 2, 1, 3, 1 ),
	LYDIAN_H2_H6( DOUBLE_HARMONIC.getMode( 1 ) ),
	ULTRAPHRYGIAN( DOUBLE_HARMONIC.getMode( 2 ) ),
	HUNGARIAN_MINOR( DOUBLE_HARMONIC.getMode( 3 ) ),
	ORIENTAL( DOUBLE_HARMONIC.getMode( 4 ) ),
	IONIAN_AUGMENTED_H2( DOUBLE_HARMONIC.getMode( 5 ) ),
	LOCRIAN_bb3_bb7( DOUBLE_HARMONIC.getMode( 6 ) ),

	NEAPOLITAN_MINOR( 1, 2, 2, 2, 1, 3, 1 ),
	NEAPOLITAN_MAJOR( 1, 2, 2, 2, 2, 2, 1 ),

	BLUES( 3, 2, 1, 1, 3, 2 ),

	// 6
	WOLE_TONE( 2, 2, 2, 2, 2, 2 ),

	// 5
	PENTATONIC_MINOR( 3, 2, 3, 2, 2 ),
	PENTATONIC( PENTATONIC_MINOR.getMode( 1 ) ),
	EGYPCIAN( PENTATONIC_MINOR.getMode( 2 ) ),
	SUSPENDED( EGYPCIAN ),
	BLUES_MINOR( PENTATONIC_MINOR.getMode( 3 ) ),
	MAN_GONG( BLUES_MINOR ),
	BLUES_MAJOR( PENTATONIC_MINOR.getMode( 4 ) ),
	YO_SCALE( BLUES_MAJOR);

	private static final Map<ArrayWrapper<Integer>, ScaleEnum> _map = new HashMap();
	static {
		for (ScaleEnum s : values()) {
			Integer[] integers = Arrays.stream( s.value ).boxed().toArray( Integer[]::new );
			ArrayWrapper array =  new ArrayWrapper<Integer>(integers);
			if (_map.get( array ) == null)
				_map.put( array, s );
		}
	}

	public static ScaleEnum of(int[] v) {
		Integer[] integers = Arrays.stream( v ).boxed().toArray( Integer[]::new );
		return of(integers);
	}
	
	public static ScaleEnum of(Integer[] integers) {
		ArrayWrapper array =  new ArrayWrapper<Integer>(integers);
		return _map.get( array );
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

	private ScaleEnum(int... i) throws ScaleException {
		value = i;
		if (IntStream.of( i ).sum() != IntervalChromatic.PERFECT_OCTAVE.val()) {
			System.out.println( IntStream.of( i ).sum() );
			System.out.println( IntervalChromatic.PERFECT_OCTAVE.val() );
			throw new ScaleException( this );
		}
	}

	private ScaleEnum(Scale s) {
		this(s.val());
	}

	@Override
	public int[] val() {
		// TODO: comprobar si hace falta a hacer copia
		return Arrays.copyOf(
			value, value.length
				);
	}

	@Override
	public int length() {
		return value.length;
	}

	public int get(int n) {
		return value[trim( n )];
	}

	@Override
	public String toString() {
		if ( this.equals( ScaleEnum.MAJOR ) )
			return "Mayor";
		else if ( this.equals( ScaleEnum.MINOR ) )
			return "Menor";
		else if ( this.equals( ScaleEnum.HARMONIC_MINOR ) )
			return "Menor armónica";
		else if ( this.equals( ScaleEnum.MELODIC_MINOR ) )
			return "Menor melódica";
		else if ( this.equals( ScaleEnum.AEOLIAN ) )
			return "Eólica";
		else if ( this.equals( ScaleEnum.DORIAN ) )
			return "Dórica";
		else if ( this.equals( ScaleEnum.LOCRIAN ) )
			return "Locria";
		else if ( this.equals( ScaleEnum.SUPERLOCRIAN ) )
			return "Superlocria";
		else if ( this.equals( ScaleEnum.LYDIAN ) )
			return "Lidia";
		else if ( this.equals( ScaleEnum.LYDIAN_b7 ) )
			return "Lidia b7";
		else if ( this.equals( ScaleEnum.MIXOLYDIAN ) )
			return "Mixolidia";
		else if ( this.equals( ScaleEnum.MIXOLIDIAN_b9_b13 ) )
			return "Mixolidia b9 b13";
		else if ( this.equals( ScaleEnum.MIXOLIDIAN_b13 ) )
			return "Mixolidia b13";
		else if ( this.equals( ScaleEnum.PHRYGIAN ) )
			return "Frigia";
		else if ( this.equals( ScaleEnum.NEAPOLITAN_MAJOR ) )
			return "Napolitana mayor";
		else if ( this.equals( ScaleEnum.NEAPOLITAN_MINOR ) )
			return "Napolitana menor";
		else if ( this.equals( HARMONIC_MINOR ) )
			return "Menor Armónica";
		else if ( this.equals( LOCRIAN_H6 ) )
			return "Locria #6";
		else if ( this.equals( IONIAN_H5 ) )
			return "Jónica #5";
		else if ( this.equals( DORIAN_H4 ) )
			return "Dórica #4";
		else if ( this.equals( MIXOLIDIAN_b9_b13 ) )
			return "Mixolidia b9 b13";
		else if ( this.equals( LYDIAN_H2 ) )
			return "Lidia #2";
		else if ( this.equals( SUPERLOCRIAN_bb7 ) )
			return "Superlocria bb7";
		else if ( this.equals( HARMONIC_MAJOR ) )
			return "Mayor Armónica";
		else if ( this.equals( DORIAN_b5 ) )
			return "Dórica b5";
		else if ( this.equals( PHRYGIAN_b4 ) )
			return "Frigia b4";
		else if ( this.equals( LYDIAN_b3 ) )
			return "Lidia b3";
		else if ( this.equals( MIXOLYDIAN_b2 ) )
			return "Mixolidia b2";
		else if ( this.equals( AEOLIAN_b1 ) )
			return "Eólica b1";
		else if ( this.equals( LOCRIAN_bb7 ) )
			return "Locria bb7";
		else if ( this.equals( MELODIC_MINOR ) )
			return "Menor Melódica";
		else if ( this.equals( DORIAN_b2 ) )
			return "Dórica b2";
		else if ( this.equals( LYDIAN_H5 ) )
			return "Lidia #5";
		else if ( this.equals( LYDIAN_b7 ) )
			return "Lidia b7";
		else if ( this.equals( MIXOLIDIAN_b13 ) )
			return "Mixolidia b13";
		else if ( this.equals( LOCRIAN_H2 ) )
			return "Locria #2";
		else if ( this.equals( SUPERLOCRIAN ) )
			return "Superlocria";
		else if ( this.equals( DOUBLE_HARMONIC ) )
			return "Doble Armónica";
		else if ( this.equals( LYDIAN_H2_H6 ) )
			return "Lidia #2 #6";
		else if ( this.equals( ULTRAPHRYGIAN ) )
			return "Ultrafrigia";
		else if ( this.equals( HUNGARIAN_MINOR ) )
			return "Húngara menor";
		else if ( this.equals( ORIENTAL ) )
			return "Oriental";
		else if ( this.equals( IONIAN_AUGMENTED_H2 ) )
			return "Jónica aumentada #2";
		else if ( this.equals( LOCRIAN_bb3_bb7 ) )
			return "Locria bb3 bb7";
		else
			return null;
	}

	public void showAlterationsTonality() {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < length(); i++ ) {
			if ( i > 0 )
				sb.append( " " );

			int altered = showAlterationsTonality( i );
			if ( altered == -1 )
				sb.append( "b" );
			else if ( altered == -2 )
				sb.append( "bb" );
			else if ( altered == 1 )
				sb.append( "#" );
			else if ( altered == 0 )
				;
			else
				sb.append( "?" );

			sb.append( i + 1 );
		}

		System.out.println( sb.toString() );
	}

	private int showAlterationsTonality(int pos) {
		int majorScale = 0;
		int alteredScale = 0;

		for ( int i = 0; i < pos; i++ ) {
			majorScale += ScaleEnum.MAJOR.get( i );
			alteredScale += get( i );
		}

		return alteredScale - majorScale;
	}
}
