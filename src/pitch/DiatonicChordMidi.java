package pitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import arrays.ArrayUtils;
import chromaticchord.CustomChromaticChord;
import diatonic.ChordNotation;
import diatonic.ChromaticFunction;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.HarmonicFunction;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import midi.AddedException;
import midi.Settings;
import tonality.CustomTonality;
import tonality.ScaleEnum;
import tonality.Tonality;
import tonality.TonalityException;

public class DiatonicChordMidi extends ChordMidi<DiatonicMidi, DiatonicChordMidi, IntervalChromatic>
implements PitchDiatonic<DiatonicChordMidi, IntervalChromatic> {
	protected HarmonicFunction	function	= null;
	public Tonality				metaTonality;

	protected Tonality tonality;

	public DiatonicChordMidi() {
	}

	public DiatonicChordMidi(Tonality t) {
		tonality = t;
		metaTonality = tonality;
	}

	public DiatonicChordMidi(DiatonicMidi... ns) {
		assert ns.length > 0;
		tonality = ns[0].getTonality();
		metaTonality = tonality;

		add( ns );
	}

	public DiatonicChordMidi(Tonality t, DiatonicChord ns) {
		this( t );
		add( ns.toMidi( t ) );
	}

	public DiatonicChordMidi(Tonality t, PitchMidi... ns) {
		this( t );
		for ( PitchMidi n : ns )
			addNoReset( n.toMidi().toDiatonicChordMidi( t ) );

		resetRoot();
	}

	public DiatonicChordMidi(Tonality t, Diatonic... ns) {
		this( t, new DiatonicChord( ns ) );
	}

	public <N extends PitchChromaticableSingle, Array extends PitchChromaticableChord<N, ?, ?>> DiatonicChordMidi(Array ns, Tonality t) {
		this(
			ns,
			t,
			Settings.DefaultValues.OCTAVE
				);
	}

	public <N extends PitchChromaticableSingle, Array extends PitchChromaticableChord<N, ?, ?>> DiatonicChordMidi(Array ns, Tonality t, int o) {
		this(
			ns,
			t,
			o,
			Settings.DefaultValues.DURATION_CHORD,
			Settings.DefaultValues.VELOCITY
				);
	}

	public <N extends PitchChromaticableSingle, Array extends PitchChromaticableChord<N, ?, ?>> DiatonicChordMidi(Array ns, Tonality t, int o, int d, int v) {
		for ( N n : ns ) {
			DiatonicMidi cm = new DiatonicMidi( t.getDegree( n ), t, o, d, v );
			if ( size() > 0 && cm.getChromatic().val() <= get( size() - 1 ).getChromatic().val() ) {
				o++;
				cm.shiftOctave( 1 );
			}

			addNoReset( cm );
		}

		resetRoot();
	}

	public DiatonicChordMidi(HarmonicFunction t, Tonality s) {
		this( t, Settings.DefaultValues.OCTAVE, s );
	}

	public DiatonicChordMidi(HarmonicFunction t, int o, Tonality s) {
		this( t, o, s, Settings.DefaultValues.DURATION_CHORD );
	}

	public DiatonicChordMidi(HarmonicFunction f, int o, Tonality ton, int len) {
		this( ton );
		length = len;
		function = f;

		if ( ton == null )
			throw new NullPointerException( "El objeto Scale es null" );

		if ( f instanceof ChromaticFunction ) {
			chromaticFunctionProcess( (ChromaticFunction) f, o );
			if ( get( 0 ).getChromatic().val() < metaTonality.get( 0 ).val() )
				shiftOctave( 1 );
		} else if ( f instanceof DiatonicFunction )
			diatonicFunctionProcess( (DiatonicFunction) f, o );
		setArpegioIfNull();
	}

	public boolean hasTonality(Tonality t) {
		return metaTonality.equals( t );
	}

	/*
	 * public boolean hasTonality(Tonality[] ts) { for ( Tonality t : ts ) if (
	 * hasTonality( t ) ) return true;
	 * 
	 * return false; }
	 */
	public static ChromaticChordMidi reduceDistances(ChromaticChordMidi chord) {
		return chord.clone();
	}

	public static ArrayList<ChromaticChordMidi> reduceDistances(final List<ChromaticChordMidi> chords) {
		ArrayList<ChromaticChordMidi> out = new ArrayList<>();
		for ( ChromaticChordMidi c : chords ) {
			out.add( reduceDistances( c ) );
		}

		return out;
	}

	public static void showWhatIsIt(boolean outscale, ChromaticMidi... notes) {
		showWhatIsIt( outscale, () -> {
			return true;
		}, notes );
	}

	public static void showWhatIsIt(ChromaticMidi... notes) {
		showWhatIsIt( false, notes );
	}

	public static void showWhatIsIt(boolean outscale, Supplier<Boolean> f, ChromaticMidi... notes) {
		ArrayList<DiatonicChordMidi> chords = new ChromaticChordMidi( notes )
				.toDiatonicChordMidi( outscale );

		if ( chords.isEmpty() ) {
			System.out.print( "La sucesión de notas no es nada:" );
			for ( ChromaticMidi n : notes ) {
				System.out.print( " " + n );
			}
			System.out.print( "\n" );
		}

		for ( DiatonicChordMidi c : chords )
			if ( f.get() )
				c.show();
	}

	public static void showPossibleProgressionsMajorMinor(List<ChromaticChordMidi> cs) {
		assert cs != null;
		showPossibleProgressionsMajorMinor( (c) -> {
			return true;
		}, cs );
	}

	public static void showPossibleProgressionsMajorMinor(Function<DiatonicChordMidi, Boolean> f, List<ChromaticChordMidi> cs) {
		assert f != null;
		assert cs != null;
		showPossibleProgressions( (DiatonicChordMidi c) -> {
			return ( c.metaTonality != null && c.metaTonality.isMajorMinor()
					|| c.tonality.isMajorMinor() ) && f.apply( c );
		}, cs );
	}

	public static void showPossibleProgressions(Function<DiatonicChordMidi, Boolean> f, List<ChromaticChordMidi> chordsIn) {
		ArrayList<ChromaticChordMidi> chords = reduceDistances( chordsIn );

		ArrayList<Tonality> possibleTonalities = CustomTonality.getFromChords( true, chords );

		// DEBUG
		if ( possibleTonalities == null || possibleTonalities.size() == 0 ) {
			for ( ChromaticChordMidi c : chords ) {
				for ( ChromaticMidi n : c )
					System.out.print( n + "  " );
				System.out.println();
			}
		}

		assert possibleTonalities != null
				&& possibleTonalities.size() > 0 : "No se ha encontrado escala";

		// Mostrar por consola
		for ( Tonality t : possibleTonalities ) {
			if ( t.isMajorMinor() ) {
				StringBuilder sb = new StringBuilder();
				boolean yep = true;
				boolean first = false;
				sb.append( "----" + t + "----" );
				for ( ChromaticChordMidi n : chords ) {
					DiatonicChordMidi c = new DiatonicChordMidi( t, n );
					if ( !f.apply( c ) ) {
						yep = false;
						break;
					}

					sb.append( "\n" + c );
					first = false;
				}

				if ( yep )
					System.out.println( sb );

			}
		}
	}

	public boolean hasScale(ScaleEnum s) {
		return metaTonality.getScale().equals( s );
	}

	public boolean isTonic() {
		return function == DiatonicFunction.I || function == DiatonicFunction.III
				|| function == DiatonicFunction.VI;
	}

	public boolean isSubdominant() {
		for ( DiatonicMidi n : this )
			if ( n.getDegree() == Degree.IV )
				return true;
		return false;
	}

	public boolean isDominant() {
		function = getFunction();
		return function == DiatonicFunction.V || function == DiatonicFunction.VII;
	}

	public <N extends PitchChromaticableSingle, Array extends PitchChromaticableChord<N, ?, ?>> DiatonicChordMidi(Tonality ton, Array ns) {
		tonality = ton;
		metaTonality = ton;

		if ( ns instanceof ChordMidi )
			meta = ( (ChordMidi) ns ).meta;

		try {
			ChromaticChordMidi n = new ChromaticChordMidi( ns );
			add( n );
		} catch ( TonalityException e ) {
			clear();
			Set<CustomChromaticChord> cs = ton.getOutScaleChords();
			cs.addAll( ton.getBorrowedChords() );
			CustomChromaticChord c = null;
			for ( CustomChromaticChord dc : cs )
				if ( ns.equalsEnharmonic( dc ) ) {
					c = dc;
					break;
				}
			assert c != null : "Acorde " + ns + " no reconocido en tonalidad " + tonality + ": "
					+ ns.notesToString() + " "
					+ Arrays.toString( ns.integerNotationFromRoot() );

			function = ton.getFunction( c );
			if ( function == null ) {
				tonality = tonality.searchInModeSameRoot( c );
				metaTonality = tonality;
			} else
				tonality = Tonality.getFromChord( c ).get( 0 );

			if ( tonality == null )
				throw new TonalityException( ns, ton );

			add( c.toMidi() );
		}

		Chord c = ( (Chord) ns );
		setRoot( c.getRootPos() );

		root = get( ns.getRootPos() );

		if ( ns instanceof ChordMidi ) {
			arpegio = ( (ChordMidi) ns ).arpegio;
			length = ( (ChordMidi) ns ).length;
		}

		setArpegioIfNull();
	}

	public Degree getDegree() {
		Degree d = null;
		if ( function instanceof ChromaticFunction )
			d = ( (ChromaticFunction) function ).getDegree();
		if ( d == null ) {
			Chromatic c = root.getChromatic();
			d = metaTonality.getDegree( c );
		}
		return d;
	}

	public DiatonicChordMidi assign(DiatonicChordMidi c) {
		assert c != null;
		super.assign( c );
		tonality = c.tonality;
		this.function = c.function;
		this.metaTonality = c.metaTonality;

		return this;
	}

	public static ArrayList<DiatonicChordMidi> chordsWhereTonalityIs(ArrayList<DiatonicChordMidi> in, Tonality t, boolean meta, boolean intercambioModal) {
		ArrayList<DiatonicChordMidi> cs = new ArrayList<>();
		ArrayList<DiatonicChordMidi> csModal = new ArrayList<>();

		for ( final DiatonicChordMidi i : in )
			if ( meta && i.metaTonality.equals( t ) || !meta && i.getTonality().equals( t ) ) {
				cs.add( i );
			} else if ( intercambioModal && i.metaTonality.isIntercambioModalOf( t ) )
				csModal.add( i );

		if ( cs.isEmpty() )
			return csModal;
		else
			return cs;
	}

	public static DiatonicChordMidi chordWhereTonalityIs(ArrayList<DiatonicChordMidi> in, Tonality t, boolean meta, boolean intercambioModal) {
		ArrayList<DiatonicChordMidi> cs = chordsWhereTonalityIs( in, t, meta, intercambioModal );
		if ( cs.size() == 0 )
			throw new RuntimeException( "No hay un acorde" );

		return cs.get( 0 );
	}

	private void chromaticFunctionProcess(ChromaticFunction t, int octave) {
		if ( t == ChromaticFunction.N6 ) {
			CustomChromaticChord cc = new CustomChromaticChord( t, tonality );

			tonality = Tonality.getFromChord( cc ).get( 0 );

			add( cc.toMidi() );
		} else if ( ArrayUtils.contained( t, ChromaticFunction.POWER_CHORDS ) ) {
			Degree d = t.getDegree();

			IntervalChromatic ic = tonality.getInterval( d, IntervalDiatonic.FIFTH );

			if ( !ic.equals( IntervalChromatic.PERFECT_FIFTH ) ) {
				tonality = Tonality.of( tonality.get( d ), ScaleEnum.MAJOR );
				d = Degree.I;
			}

			ChromaticMidi n = tonality.get( d ).toMidi( octave );
			addNoReset( n );
			ChromaticMidi n2 = ChromaticMidi
					.add( n.clone(), IntervalChromatic.PERFECT_FIFTH.val() );
			assert !n.equalsEnharmonic( n2 ) : n2;
			add( n2 );
		} else if ( ArrayUtils.contained( t, ChromaticFunction.TENSIONS ) ) {
			DiatonicMidi n = null;
			switch ( t ) {
				case V_II:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.SECOND )
								), tonality
							);
					break;
				case V7_II:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.SECOND )
								), tonality
							);
					break;
				case V_III:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.THIRD )
								), tonality
							);
					break;
				case V7_III:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.THIRD )
								), tonality
							);
					break;
				case V_IV:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.FOURTH )
								), tonality
							);
					break;
				case V7_IV:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.FOURTH )
								), tonality
							);
					break;
				case V_V:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.FIFTH )
								), tonality
							);
					break;
				case V7_V:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.FIFTH )
								), tonality
							);
					break;
				case V_VI:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.SIXTH )
								), tonality
							);
					break;
				case V7_VI:
					tonality = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, tonality
							.getRelativeScaleDiatonic( IntervalDiatonic.SIXTH )
								), tonality
							);
					break;
				case SUBV7:
					DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.V7, tonality );
					tonality = Tonality.of(
						c.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_II:
					DiatonicChordMidi c2 = new DiatonicChordMidi(
						ChromaticFunction.V7_II, tonality
							);
					tonality = Tonality.of(
						c2.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_III:
					DiatonicChordMidi c3 = new DiatonicChordMidi(
						ChromaticFunction.V7_III, tonality
							);
					tonality = Tonality.of(
						c3.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_IV:
					DiatonicChordMidi c4 = new DiatonicChordMidi(
						ChromaticFunction.V7_IV, tonality
							);
					tonality = Tonality.of(
						c4.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_V:
					DiatonicChordMidi c5 = new DiatonicChordMidi(
						ChromaticFunction.V7_V, tonality
							);
					tonality = Tonality.of(
						c5.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_VI:
					DiatonicChordMidi c6 = new DiatonicChordMidi(
						ChromaticFunction.V7_VI, tonality
							);
					tonality = Tonality.of(
						c6.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case V7ALT:
					DiatonicChordMidi calt = new DiatonicChordMidi(
						DiatonicFunction.V7, tonality
							);
					tonality = Tonality.of(
						calt.get( 0 ).toChromaticMidi().getChromatic(), ScaleEnum.SUPERLOCRIAN
							);
					break;
			}

			DiatonicFunction t2 = null;
			switch ( t ) {
				case V_II:
				case V_III:
				case V_IV:
				case V_V:
				case V_VI:
					t2 = DiatonicFunction.I;
					break;
				case V7_II:
				case V7_III:
				case V7_IV:
				case V7_V:
				case V7_VI:
				case SUBV7:
				case SUBV7_II:
				case SUBV7_III:
				case SUBV7_IV:
				case SUBV7_V:
				case SUBV7_VI:
				case V7ALT:
					t2 = DiatonicFunction.I7;
					break; // Ya se ha corregido la escala
			}
			assert t2 != null : t + " " + metaTonality;

			try {
				diatonicFunctionProcess( t2, octave );
			} catch ( TonalityException e ) {
				System.out.println( t );
			}
		} else {
			CustomChromaticChord cc = new CustomChromaticChord( t, tonality );
			ChromaticChordMidi ccm = new ChromaticChordMidi( cc );
			if ( tonality.has( cc ) )
				add( ccm );
			else {
				metaTonality = tonality.searchInModeSameRoot( cc );
				if ( metaTonality == null )
					throw new TonalityException( cc, tonality );
				tonality = metaTonality;

				add( ccm );
			}
		}

		sort();
	}

	private void diatonicFunctionProcess(DiatonicFunction t, int octave) {
		assert t != null;
		DiatonicChord dt = new DiatonicChord( t );

		add( dt, octave );
		root = get( 0 );

		sort();
	}

	public void add(DiatonicChord dt, int octave) {
		add( dt.toMidi( tonality ) );
		if ( octave != Settings.DefaultValues.OCTAVE )
			setOctave( octave );
	}

	public Boolean isOmitByInterval(IntervalDiatonic i) {
		if ( function == null )
			return false;

		switch ( i ) {
			case THIRD:
				switch ( (DiatonicFunction) function ) {
					case I7_O3:
					case II7_O3:
					case III7_O3:
					case IV7_O3:
					case V7_O3:
					case VI7_O3:
					case VII7_O3:
					case I9_O3_O7:
					case II9_O3_O7:
					case III9_O3_O7:
					case IV9_O3_O7:
					case V9_O3_O7:
					case VI9_O3_O7:
					case VII9_O3_O7:
						return true;
				}
				break;
			case FIFTH:
				switch ( (DiatonicFunction) function ) {
					case I_THIRD:
					case II_THIRD:
					case III_THIRD:
					case IV_THIRD:
					case V_THIRD:
					case VI_THIRD:
					case VII_THIRD:
					case I_SECOND:
					case II_SECOND:
					case III_SECOND:
					case IV_SECOND:
					case V_SECOND:
					case VI_SECOND:
					case VII_SECOND:
					case I_FOURTH:
					case II_FOURTH:
					case III_FOURTH:
					case IV_FOURTH:
					case V_FOURTH:
					case VI_FOURTH:
					case VII_FOURTH:
					case I6_O5:
					case II6_O5:
					case III6_O5:
					case IV6_O5:
					case V6_O5:
					case VI6_O5:
					case VII6_O5:
					case I7_O5:
					case II7_O5:
					case III7_O5:
					case IV7_O5:
					case V7_O5:
					case VI7_O5:
					case VII7_O5:
						return true;
				}
				break;
			case ELEVENTH:
				break;
			case FIFTEENTH:
				break;
			case FOURTEENTH:
				break;
			case FOURTH:
				break;
			case NINTH:
				break;
			case OCTAVE:
				break;
			case SECOND:
				break;
			case SEVENTH:
				switch ( (DiatonicFunction) function ) {
					case I9_O7:
					case II9_O7:
					case III9_O7:
					case IV9_O7:
					case V9_O7:
					case VI9_O7:
					case VII9_O7:
					case I9_O3_O7:
					case II9_O3_O7:
					case III9_O3_O7:
					case IV9_O3_O7:
					case V9_O3_O7:
					case VI9_O3_O7:
					case VII9_O3_O7:
						return true;
				}
				break;
			case SIXTH:
				break;
			case TENTH:
				break;
			case THIRTEENTH:
				break;
			case TWELFTH:
				break;
			case UNISON:
				break;
		}

		return false;
	}

	public boolean hasByType(IntervalDiatonic i) {
		if ( function instanceof DiatonicFunction )
			switch ( i ) {
				case SECOND:
					switch ( (DiatonicFunction) function ) {
						case I2:
						case II2:
						case III2:
						case IV2:
						case V2:
						case VI2:
						case VII2:
						case I_SECOND:
						case II_SECOND:
						case III_SECOND:
						case IV_SECOND:
						case V_SECOND:
						case VI_SECOND:
						case VII_SECOND:
							return true;
					}
					break;
				case THIRD:
					return !( hasByType( IntervalDiatonic.SECOND )
							|| hasByType( IntervalDiatonic.FOURTH ) )
							&& !isOmitByInterval( IntervalDiatonic.THIRD );
				case FOURTH:
					switch ( (DiatonicFunction) function ) {
						case I4:
						case II4:
						case III4:
						case IV4:
						case V4:
						case VI4:
						case VII4:
						case I_FOURTH:
						case II_FOURTH:
						case III_FOURTH:
						case IV_FOURTH:
						case V_FOURTH:
						case VI_FOURTH:
						case VII_FOURTH:
							return true;
					}
					break;
				case FIFTH:
					return !isOmitByInterval( IntervalDiatonic.FIFTH );
				case SIXTH:
					switch ( (DiatonicFunction) function ) {
						case I6:
						case II6:
						case III6:
						case IV6:
						case V6:
						case VI6:
						case VII6:
						case I6_O5:
						case II6_O5:
						case III6_O5:
						case IV6_O5:
						case V6_O5:
						case VI6_O5:
						case VII6_O5:
							return true;
					}
					break;
				case SEVENTH:
					switch ( (DiatonicFunction) function ) {
						case I7:
						case II7:
						case III7:
						case IV7:
						case V7:
						case VI7:
						case VII7:

						case I7_O5:
						case II7_O5:
						case III7_O5:
						case IV7_O5:
						case V7_O5:
						case VI7_O5:
						case VII7_O5:
						case I7_O3:
						case II7_O3:
						case III7_O3:
						case IV7_O3:
						case V7_O3:
						case VI7_O3:
						case VII7_O3:

						case I9:
						case II9:
						case III9:
						case IV9:
						case V9:
						case VI9:
						case VII9:
						case I11:
						case II11:
						case III11:
						case IV11:
						case V11:
						case VI11:
						case VII11:
							return true;
					}
					break;
				case NINTH:
					switch ( (DiatonicFunction) function ) {
						case I9:
						case II9:
						case III9:
						case IV9:
						case V9:
						case VI9:
						case VII9:
						case I9_O7:
						case II9_O7:
						case III9_O7:
						case IV9_O7:
						case V9_O7:
						case VI9_O7:
						case VII9_O7:
						case I9_O3_O7:
						case II9_O3_O7:
						case III9_O3_O7:
						case IV9_O3_O7:
						case V9_O3_O7:
						case VI9_O3_O7:
						case VII9_O3_O7:
						case I11:
						case II11:
						case III11:
						case IV11:
						case V11:
						case VI11:
						case VII11:
							return true;
					}
				case ELEVENTH:
					switch ( (DiatonicFunction) function ) {
						case I11:
						case II11:
						case III11:
						case IV11:
						case V11:
						case VI11:
						case VII11:
							return true;
					}
				case THIRTEENTH:
					switch ( (DiatonicFunction) function ) {
						case I13:
						case II13:
						case III13:
						case IV13:
						case V13:
						case VI13:
						case VII13:
							return true;
					}
			}
		else
			throw new RuntimeException( function + " " + metaTonality );

		return false;
	}

	public boolean add(ChromaticMidi... ns) throws AddedException, TonalityException {
		assert tonality != null;
		for ( ChromaticMidi n : ns )
			addNoReset( n.toDiatonicChordMidi( tonality ) );

		resetRootIfNeeded();

		return true;
	}

	protected boolean addNoReset(ChromaticMidi note) throws AddedException {
		assert tonality != null;
		return super.addNoReset( note.toDiatonicChordMidi( tonality ) );
	}

	@Override
	public boolean add(DiatonicMidi... ns) throws AddedException, TonalityException {
		for ( DiatonicMidi n : ns )
			addNoReset( n );

		resetRootIfNeeded();

		return true;
	}

	public DiatonicChordMidi add(PitchChromaticableChord<ChromaticMidi, ?, ?> ns)
			throws AddedException {
		for ( int i = 0; i < ns.size(); i++ ) {
			ChromaticMidi n = ns.get( i );
			assert n != null;
			addNoReset( n );
		}

		resetRootIfNeeded();

		return this;
	}

	public DiatonicChordMidi addDuplicate(int oct) {
		if ( oct == 0 )
			throw new AddedException( this );

		int sizeIni = size();
		for ( int i = 0; i < sizeIni; i++ ) {
			DiatonicMidi n = get( i ).clone().shiftOctave( oct );
			add( n );
		}

		return this;
	}

	public static boolean contains(List<DiatonicChordMidi> chords, boolean sameOctave, boolean sameTonality, DiatonicChordMidi c) {
		for ( DiatonicChordMidi ccc : chords )
			if ( sameTonality && ccc.isSameChordNotesAndTonality( sameOctave, c )
					|| !sameTonality && ccc.hasSameNotesOrder( sameOctave, c ) )
				return true;

		return false;
	}

	public boolean isSameChordNotesAndTonality(boolean sameOctave, DiatonicChordMidi notes) {
		return hasSameNotesOrder( sameOctave, notes ) && tonality.equals( notes.tonality );
	}

	public DiatonicMidi get(int note, List<DiatonicMidi> ns) {
		if ( ns.size() == 0 )
			return null;

		DiatonicMidi n;
		if ( note >= ns.size() ) {
			n = ns.get( note % ns.size() );
			n = DiatonicMidi.add( n, note / ns.size() * IntervalDiatonic.OCTAVE.val() );
		} else if ( note < 0 ) {
			int num = Math.abs( ns.size() + note % ns.size() );
			n = ns.get( num );
			n = DiatonicMidi.add( n, ( note / ns.size() - 1 ) * IntervalDiatonic.OCTAVE.val() );
		} else {
			n = (DiatonicMidi) ns.get( note ).clone();
		}

		return n;
	}

	public boolean hasMainTriadType() {
		return ( function == DiatonicFunction.I || function == DiatonicFunction.II
				|| function == DiatonicFunction.III || function == DiatonicFunction.IV
				|| function == DiatonicFunction.V || function == DiatonicFunction.VI
				|| function == DiatonicFunction.VII );
	}

	@Override
	public DiatonicChordMidi clone() {
		DiatonicChordMidi c = new DiatonicChordMidi( tonality );
		c.length = length;
		c.metaTonality = metaTonality;
		c.function = function;

		if ( arpegio != null )
			c.arpegio = arpegio.clone();
		for ( DiatonicMidi n : this )
			c.add( n.clone() );

		int pos = getRootPos();
		c.root = get( pos );

		return c;
	}

	public ArrayList<ChromaticMidi> commonNotes(DiatonicChordMidi c) {
		return commonNotes( c, false );
	}

	public ArrayList<ChromaticMidi> commonNotes(DiatonicChordMidi c, boolean sameOctave) {
		ArrayList<ChromaticMidi> ret = new ArrayList<ChromaticMidi>();

		for ( DiatonicMidi nscale1 : this ) {
			ChromaticMidi n1 = nscale1.toChromaticMidi();
			for ( DiatonicMidi nscale2 : c ) {
				ChromaticMidi n2 = nscale2.toChromaticMidi();

				if ( n1.getPitchCode() == n2.getPitchCode() )
					ret.add( n2 );
				else if ( sameOctave && n1.getChromatic() == n2.getChromatic() )
					ret.add( n2 );
			}
		}

		return ret;
	}

	/*
	 * private int correctOctave(NoteScale n) { int diffOctave = octave -
	 * n.toNote().getOctave(); if (diffOctave != 0) shiftOctave(diffOctave);
	 * 
	 * return diffOctave; }
	 */
	public DiatonicChordMidi relative(DiatonicFunction pos) {
		Tonality s = tonality.getRelativeScaleDiatonic( get( 0 ).getDegree() );
		DiatonicChordMidi c = new DiatonicChordMidi( pos, getOctave(), s );

		return c;
	}

	public DiatonicChordMidi shiftOctave(int o) {
		for ( DiatonicMidi n : this )
			n.shiftOctave( o );

		return this;
	}

	public static ArrayList<DiatonicChordMidi> shiftOctave(ArrayList<DiatonicChordMidi> a, int o) {
		for ( DiatonicChordMidi c : a )
			c.shiftOctave( o );

		return a;
	}

	public static ArrayList<DiatonicChordMidi> duplicate(ArrayList<DiatonicChordMidi> a) {
		ArrayList<DiatonicChordMidi> b = new ArrayList<DiatonicChordMidi>();
		for ( DiatonicChordMidi c : a )
			b.add( (DiatonicChordMidi) c.clone() );

		return b;
	}

	public DiatonicChordMidi setTonality(Tonality s) {
		tonality = s;

		for ( DiatonicMidi n : this )
			n.setTonality( s );

		updateWhatIsIt();

		return this;
	}

	public DiatonicChordMidi setScaleMinor() {
		return setTonality( tonality.minor() );
	}

	public DiatonicChordMidi setScaleMajor() {
		return setTonality( tonality.major() );
	}

	public boolean add(DiatonicMidi n) throws AddedException {
		boolean r = super.add( n );

		setArpegioIfNull();

		return r;
	}

	public boolean addIfNotExists(DiatonicMidi n) {
		try {
			return add( n );
		} catch ( AddedException e ) {
			return false;
		}
	}

	public DiatonicChordMidi addIntervalIfNotExists(IntervalDiatonic n) {
		try {
			return addInterval( n );
		} catch ( AddedException e ) {
			return this;
		}
	}

	public DiatonicChordMidi addInterval(IntervalDiatonic interval) throws AddedException {
		return add( root.getDegree().add( interval.val() ) );
	}

	public DiatonicChordMidi add(Degree pos) throws AddedException {
		Integer octave = getOctave();
		DiatonicMidi ns = new DiatonicMidi(
			pos, tonality, octave == null ? Settings.DefaultValues.OCTAVE : octave
				);
		add( ns );
		setRoot( 0 );

		return this;
	}

	public DiatonicMidi getFromBase(int note) {
		List<DiatonicMidi> ns = new ArrayList();

		DiatonicChordMidi c = this.clone();
		int inversion = getInversionNumber();
		if ( inversion > 0 )
			c.inv( -inversion );
		ns = c;

		// Quitar notas duplicadas (en diferente octava)
		for ( int i = 0; i < ns.size(); i++ )
			for ( int j = i + 1; j < ns.size(); j++ ) {
				if ( ns.get( i ).getDegree() == ns.get( j ).getDegree() ) {
					ns.remove( j );
					j--;
				}
			}

		return get( note, ns );
	}

	public Tonality getTonality() {
		return tonality;
	}

	public Tonality getMetatonality() {
		return metaTonality;
	}

	public ChromaticChordMidi toChromaticChordMidi() {
		ChromaticChordMidi c = new ChromaticChordMidi();
		for ( DiatonicMidi n : this )
			c.add( n.toChromaticMidi() );
		c.arpegio = arpegio;
		c.length = length;
		c.root = c.get( getRootPos() );

		return c;
	}

	@Override
	public String toString() {
		if ( size() == 0 )
			return ChordNotation.EMPTY_CHORD;
		else if ( size() == 1 )
			return get( 0 ).toString();

		StringBuilder sb = new StringBuilder();

		Boolean ok = updateWhatIsItIfNeeded();

		if ( ok != null ) {
			sb.append( meta );

			sb.append( " (" + getFunction() + ")" );
			/*
			 * if (metaTonality != null) sb.append(" (" + metaTonality + ")");
			 */

		} else {
			boolean first = true;
			for ( DiatonicMidi n : this ) {
				if ( first )
					first = false;
				else
					sb.append( " - " );
				sb.append( n );
			}
		}

		return sb.toString();
	}

	public Integer[] toChromaticArrayValues() {
		Integer[] out = new Integer[size()];
		for ( int i = 0; i < size(); i++ ) {
			out[i] = get( i ).toChromaticMidi().getChromatic().val();
		}

		return out;
	}

	protected void updateFunction() {
		function = HarmonicFunction.get( this );
	}

	protected void updateFunctionIfNull() {
		if ( function == null )
			updateFunction();
	}

	public HarmonicFunction getFunction() {
		updateFunctionIfNull();

		assert function != null;

		return function;
	}

	@Override
	public IntervalChromatic[] integerNotationFromRoot() {
		IntervalChromatic[] distancesAbsolute = null;

		if ( size() > 0 ) {
			try {
				distancesAbsolute = new IntervalChromatic[size() - 1];

				for ( int i = 1; i < size(); i++ ) {
					DiatonicMidi n1 = get( 0 );
					DiatonicMidi n2 = get( i );
					IntervalChromatic d = n1.dist( n2 );
					distancesAbsolute[i - 1] = d;
				}
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}

		return distancesAbsolute;
	}

	@Override
	public void removeHigherDuplicates() {
		// TODO Auto-generated method stub

	}

	@Override
	public DiatonicChordMidi newArray() {
		return new DiatonicChordMidi();
	}

	@Override
	public Boolean updateWhatIsIt() {
		return updateWhatIsIt(
			(ArrayList<CustomChromaticChord> chords, PitchChromaticableChord<?, ?, ?> self) -> {
				updateFunctionIfNull();
				CustomChromaticChord ret = null;
				if ( function instanceof DiatonicFunction )
					ret = new CustomChromaticChord( tonality.get( (DiatonicFunction) function ) );
				else
					ret = new CustomChromaticChord( tonality.get( (ChromaticFunction) function ) );

				assert this.size() == ret.size();

				if ( getRootPos() != 0 )
					ret = ret.clone( true ).inv( ret.size() - getRootPos() );

				assert ret.meta.str != null : " " + ( function instanceof DiatonicFunction );

				return ret;
			}
				);
	}

	@Override
	public IntervalChromatic dist(DiatonicChordMidi n) {
		int d = Math.round( n.getPitchMean() - getPitchMean() );

		int dDia = n.getDegree().val() - getDegree().val();
		IntervalDiatonic id = IntervalDiatonic.get( dDia );

		IntervalChromatic ic = IntervalChromatic.get( id, d );
		return ic;
	}

	@Override
	public boolean equals(Object o) {
		if ( !( o instanceof DiatonicChordMidi ) )
			return false;

		DiatonicChordMidi dcm = (DiatonicChordMidi) o;

		return super.equals( dcm ) && getFunction().equals( dcm.getFunction() )
				&& metaTonality.equals( dcm.metaTonality );
	}

	public boolean isSus4() {
		return this.toChromaticChord().isSus4();
	}

	public boolean isSus2() {
		return this.toChromaticChord().isSus2();
	}

	@Override
	public boolean addAll(Collection<? extends DiatonicMidi> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends DiatonicMidi> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DiatonicMidi get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<DiatonicMidi> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<DiatonicMidi> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<DiatonicMidi> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DiatonicMidi set(int index, DiatonicMidi element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DiatonicMidi> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
