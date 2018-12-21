package tonality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Log.String.Logging;
import arrays.ArrayUtils;
import diatonic.ChromaticFunction;
import diatonic.DiatonicDegree;
import diatonic.DiatonicFunction;
import diatonic.HarmonicFunction;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import musical.Chromatic;
import musical.CustomChromaticChord;
import musical.CustomDiatonicChord;
import musical.Diatonic;
import pitch.ChromaticChordMidi;
import pitch.ChromaticMidi;
import pitch.DiatonicChordMidi;
import pitch.PitchChromaticChord;
import pitch.PitchChromaticSingle;
import pitch.PitchChromaticChord;
import pitch.PitchSingle;

public class CustomTonality implements Tonality {
	private Chromatic				root;
	private Scale					scale;

	/** Temp */
	private Chromatic[]				notes;
	private Map<Integer, Chromatic>	valChromaticMap;

	// TODO: no usado
	class ChromaticChordSet {
		public CustomChromaticChord	chord;
		public CustomTonality			tonality;
		public HarmonicFunction	function;

		public ChromaticChordSet(CustomChromaticChord c, CustomTonality t, HarmonicFunction f) {
			chord = c;
			tonality = t;
			function = f;
		}
	}

	// Cache
	private boolean										useCache;
	private Set<CustomChromaticChord>							scaleChords;
	private Set<CustomChromaticChord>							outScaleChords;
	private Set<CustomChromaticChord>							borrowedChords;
	private HashMap<DiatonicFunction, CustomChromaticChord>	functionChordsMap;
	private HashMap<ChromaticFunction, CustomChromaticChord>	chromaticChordsMap;
	public HashMap<CustomChromaticChord, HarmonicFunction>	chromaticChordFunction;	// TODO: private

	private static final int	SIZE_MIN	= 2;
	private static final int	SIZE_MAX	= 8;

	private void createCache() {
		scaleChords = new HashSet();
		outScaleChords = new HashSet();
		borrowedChords = new HashSet();
		chromaticChordFunction = new HashMap();

		functionChordsMap = new HashMap<>();
		for ( DiatonicFunction f : DiatonicFunction.COMMON )
			functionChordsMap.put( f, get( f ) );

		chromaticChordsMap = new HashMap<>();
		for ( ChromaticFunction f : ChromaticFunction.ALL )
			chromaticChordsMap.put( f, get( f ) );

		useCache = true;

		for ( DiatonicFunction f : ArrayUtils
				.concat( DiatonicFunction.TRIADS, DiatonicFunction.SEVENTH ) ) {
			CustomChromaticChord cc = get( f );
			CustomChromaticChord[] modalChromaticChords = cc.getModalChords( this );
			if ( modalChromaticChords == null )
				continue;
			for ( CustomChromaticChord cc2 : modalChromaticChords )
				if ( !has( cc2 ) ) {
					borrowedChords.add( cc2 );
				}
		}
		/*
		 * if ( this.isMajorMinor() ) { Scale otherScale = scale.equals( Scale.MAJOR ) ?
		 * Scale.MINOR : Scale.MAJOR; Tonality ton = new Tonality( root, otherScale );
		 * DiatonicFunction[] fs = new DiatonicFunction[] { DiatonicFunction.II,
		 * DiatonicFunction.III, DiatonicFunction.IV, DiatonicFunction.V,
		 * DiatonicFunction.VI, DiatonicFunction.VII }; for ( DiatonicFunction cf : fs )
		 * { DiatonicChordMidi dcm = new DiatonicChordMidi( cf, ton );
		 * 
		 * int d = dcm.getDegree().val();
		 * 
		 * addCacheOut( dcm.toChromaticChord(), d ); } }
		 */
		/*
		 * for ( ChromaticFunction cf : ChromaticFunction.ALL ) { DiatonicChordMidi dcm
		 * = new DiatonicChordMidi( cf, this );
		 * 
		 * addCacheOut( dcm.toChromaticChord(), 6 ); }
		 */

		// assert outChords != null;
	}

	public CustomTonality(Chromatic noteBase, Scale scale) {
		useCache = false;
		this.root = noteBase;
		this.scale = scale;

		updateChromaticsFromBase( root );

		if ( notes == null )
			throw new RuntimeException(
				"Error inicializando las notas de la tonalidad con note base " + this.root
				+ " y escala " + this.scale
					);
	}

	public ArrayList<CustomTonality> minimizeAlterations() {
		ArrayList<CustomTonality> out = new ArrayList<>();
		Chromatic[] possibilities = root.getEnharmonics();
		Chromatic initialRoot = root;
		int i;
		Integer minAlterations = getAlteration();
		CustomTonality ton = clone();
		out.add( ton.clone() );
		for ( Chromatic p : possibilities ) {
			if ( p.equals( initialRoot ) || !ton.updateChromaticsFromBase( p ) )
				continue;

			Integer a = ton.getAlteration();
			assert a != null;
			if ( a < minAlterations ) {
				minAlterations = a;
				root = ton.root;
				notes = ton.notes;

				out.clear();
				out.add( this.clone() );
				if ( a == 0 )
					break;
			} else if ( a == minAlterations ) {
				out.add( ton.clone() );
			}
		}

		return out;
	}

	private void createCacheIfNeeded() {
		if ( !useCache )
			createCache();
	}

	public ArrayList<CustomChromaticChord> getAllChords() {
		createCacheIfNeeded();

		ArrayList<CustomChromaticChord> ret = new ArrayList<>();

		ret.addAll( getScaleChords() );
		ret.addAll( getOutScaleChords() );
		ret.addAll( getBorrowedChords() );

		return ret;
	}

	public Set<CustomChromaticChord> getBorrowedChords() {
		createCacheIfNeeded();
		Set<CustomChromaticChord> ret = new HashSet();
		for (CustomChromaticChord c : borrowedChords)
			ret.add( c.clone() );
		return ret;
	}

	public static ArrayList<CustomTonality> getFromChord(PitchChromaticChord c) {
		return getFromChord( false, c );
	}

	public static ArrayList<CustomTonality> getFromChord(boolean outScale, PitchChromaticChord c) {
		ArrayList<CustomTonality> out = new ArrayList<>();
		for ( CustomTonality t : CustomTonality.all() ) {
			if ( t.has( outScale, c ) )
				out.add( t );
		}

		return out;
	}

	public boolean has(boolean outScale, PitchChromaticChord c) {
		assert c != null;

		boolean hasNotes = has( c );

		if ( hasNotes )
			return true;
		else if ( outScale ) {
			for ( ChromaticFunction f : ChromaticFunction.ALL ) {
				try {
					PitchChromaticChord c2 = new DiatonicChordMidi( f, this );
					if ( c.hasSameNotesOrder( c2 ) )
						return true;
				} catch ( TonalityException e ) {
					continue;
				}
			}
		}

		return false;
	}

	private static boolean contains(ArrayList<CustomTonality> c, CustomTonality t) {
		for ( CustomTonality i : c )
			if ( i.equals( t ) )
				return true;
		return false;
	}

	public boolean isMajorMinor() {
		if ( scale.equals( ScaleEnum.MAJOR ) || scale.equals( ScaleEnum.MINOR ) )
			return true;
		else
			return false;
	}

	public static ArrayList<Tonality> getFromChords(boolean outScale, ArrayList<ChromaticChordMidi> chords) {
		ArrayList<Tonality> candidates = new ArrayList<Tonality>();

		assert chords.size() > 0;

		boolean first = true;
		for ( ChromaticChordMidi chord : chords ) {
			if ( chord.size() == 0 )
				continue;
			ChromaticChordMidi chordCopy = chord.clone();

			ArrayList<Tonality> candidatesPrev = candidates;

			do {
				ArrayList<DiatonicChordMidi> possibleChords = chordCopy
						.toDiatonicChordMidi( outScale );
				if ( first ) {
					for ( DiatonicChordMidi c : possibleChords ) {
						Tonality t = c.getTonality();
						if ( !candidates.contains( t ) )
							candidates.add( t );
					}
					first = false;
				} else {
					candidates = new ArrayList<Tonality>();

					for ( DiatonicChordMidi c : possibleChords ) {
						for ( Tonality t : candidatesPrev )
							if ( ( c.metaTonality.equals( t )
									|| c.getTonality().isIntercambioModalOf( t ) )
									&& !candidates.contains( t ) )
								candidates.add( t );
					}
				}

				if ( candidates.size() == 0 ) {
					chordCopy = chordCopy.copyOf( 0, chordCopy.size() - 1 );
				}
			} while ( candidates.size() == 0 && chordCopy.size() > 0 );
		}

		return candidates;
	}

	public boolean equals(CustomTonality t) {
		return sameRoot( t ) && sameScale( t ) && sameNotes( t );
	}

	public boolean sameRoot(CustomTonality t) {
		assert t != null;
		assert root != null;
		assert t.root != null;
		return root.equals( t.root );
	}

	public boolean sameRootEnharmonics(CustomTonality t) {
		return root.equalsEnharmonic( t.root );
	}

	public boolean sameScale(CustomTonality t) {
		return scale.equals( t.scale );
	}

	public boolean sameNotes(CustomTonality t) {
		return Arrays.equals( notes, t.notes );
	}

	public CustomTonality clone() {
		return new CustomTonality( root, scale );
	}

	public CustomChromaticChord get(DiatonicFunction f) {
		CustomChromaticChord cc = null;
		if ( functionChordsMap != null )
			cc = functionChordsMap.get( f );

		if ( cc == null ) {
			CustomDiatonicChord dc = new CustomDiatonicChord( f );
			assert dc != null : f + " " + this;

			cc = CustomChromaticChord.copyOf( get( dc, f ) );
			cc.rename( this );
			//assert cc.meta.str != null : cc.notesToString();
			if ( functionChordsMap == null )
				functionChordsMap = new HashMap();
			functionChordsMap.put( f, cc );

			if ( scaleChords == null )
				scaleChords = new HashSet();
			scaleChords.add( cc );

			if ( chromaticChordFunction == null )
				chromaticChordFunction = new HashMap();
			chromaticChordFunction.put( cc, f );
		}

		cc = cc.clone( true );

		return cc;
	}

	public CustomChromaticChord get(ChromaticFunction f) {
		CustomChromaticChord cc = null;
		if ( chromaticChordsMap != null )
			cc = chromaticChordsMap.get( f );

		if ( cc == null ) {
			cc = new CustomChromaticChord( f, this );
			cc.updateWhatIsIt();
			assert cc != null : f + " " + this.notesToString();

			if ( chromaticChordsMap == null )
				chromaticChordsMap = new HashMap();
			chromaticChordsMap.put( f, cc );

			DiatonicDegree d = null;
			d = f.getDegree();
			assert d != null : f;
			if ( outScaleChords == null )
				outScaleChords = new HashSet();
			if (ArrayUtils.contained( f, ChromaticFunction.ALL ))
				outScaleChords.add( cc );

			if ( chromaticChordFunction == null )
				chromaticChordFunction = new HashMap();
			if ( chromaticChordFunction.get( cc ) == null )
				chromaticChordFunction.put( cc, f );
		}

		cc = cc.clone( true );

		return cc;
	}
	/*
	public CustomTonality searchInModeSameRoot(CustomChromaticChord c) {
		CustomTonality[] ts;
		if ( this.scale.isDiatonic() )
			ts = new CustomTonality[] {
				new CustomTonality( this.root, ScaleEnum.MAJOR ),
				new CustomTonality( this.root, ScaleEnum.MINOR ),
				new CustomTonality( this.root, ScaleEnum.DORIAN ),
				new CustomTonality( this.root, ScaleEnum.PHRYGIAN ),
				new CustomTonality( this.root, ScaleEnum.LYDIAN ),
				new CustomTonality( this.root, ScaleEnum.MIXOLYDIAN ),
				new CustomTonality( this.root, ScaleEnum.LOCRIAN )
		};
		else
			ts = this.getModesSameRoot();

		for ( CustomTonality t : ts ) {
			if ( t.equals( this ) )
				continue;
			HarmonicFunction function = t.getFunction( c );
			if ( function != null && function instanceof DiatonicFunction ) {
				return t;
			}
		}

		return null;
	}*/

	public PitchChromaticChord<Chromatic> get(CustomDiatonicChord dc, DiatonicFunction df) {
		return dc.toChromatic( this, df );
	}

	public CustomChromaticChord[] getTriadChords() {
		NoDiatonicScaleException.check( scale );
		CustomChromaticChord[] ret = new CustomChromaticChord[7];
		for ( int i = 0; i < 7; i++ ) {
			DiatonicFunction f = null;
			switch ( i ) {
				case 0:
					f = DiatonicFunction.I;
					break;
				case 1:
					f = DiatonicFunction.II;
					break;
				case 2:
					f = DiatonicFunction.III;
					break;
				case 3:
					f = DiatonicFunction.IV;
					break;
				case 4:
					f = DiatonicFunction.V;
					break;
				case 5:
					f = DiatonicFunction.VI;
					break;
				case 6:
					f = DiatonicFunction.VII;
			}
			ret[i] = get( f );
		}

		return ret;
	}

	public CustomChromaticChord[] getSeventhChords() {
		NoDiatonicScaleException.check( scale );
		CustomChromaticChord[] ret = new CustomChromaticChord[7];
		for ( int i = 0; i < 7; i++ ) {
			DiatonicFunction f = null;
			switch ( i ) {
				case 0:
					f = DiatonicFunction.I7;
					break;
				case 1:
					f = DiatonicFunction.II7;
					break;
				case 2:
					f = DiatonicFunction.III7;
					break;
				case 3:
					f = DiatonicFunction.IV7;
					break;
				case 4:
					f = DiatonicFunction.V7;
					break;
				case 5:
					f = DiatonicFunction.VI7;
					break;
				case 6:
					f = DiatonicFunction.VII7;
			}
			ret[i] = get( f );
		}

		return ret;
	}

	public boolean updateChromaticsFromBase(Chromatic noteBase) {
		Chromatic note = noteBase;
		int len = length();
		notes = new Chromatic[len];
		notes[0] = noteBase;
		Diatonic noteBaseDiatonic = Diatonic.get( notes[0] );
		int alt = 0;
		for ( int i = 1; i < len; i++ ) {
			note = note.add( scale.get( i - 1 ) );
			try {
				noteBaseDiatonic = noteBaseDiatonic.add( 1 );
				notes[i] = noteBaseDiatonic.toChromatic( note );
				alt += notes[i].getAlterations();
			} catch ( Exception e ) {
				// e.printStackTrace();
				notes = null;
				return false;
			}
		}

		updateValChromaticMap();

		root = noteBase;

		return true;
	}

	private void updateValChromaticMap() {
		valChromaticMap = new HashMap<>();
		for ( Chromatic c : notes )
			valChromaticMap.put( c.val(), c );
	}
	/*
	public CustomTonality(int noteBase, Scale scale) {
		this( Chromatic.get( noteBase ), scale );
	}*/

	public int length() {
		return scale.length();
	}

	public Chromatic get(int pos) {
		int i = scale.trim( pos );
		Chromatic note = notes[i];

		return note;
	}

	public Chromatic get(IntervalDiatonic n) {
		return get( n.val() );
	}

	public Chromatic get(DiatonicDegree n) {
		assert n != null;
		return get( n.val() );
	}

	public CustomTonality getRelativeMinor() {
		CustomTonality[] rel = getModes();
		for ( CustomTonality s : rel )
			if ( s.getScale().equals( ScaleEnum.MINOR ) )
				return s;

		return null;
	}

	public CustomTonality getRelativeMajor() {
		CustomTonality[] rel = getModes();
		for ( CustomTonality s : rel )
			if ( s.getScale().equals( ScaleEnum.MAJOR ) )
				return s;

		return null;
	}

	public boolean isModeOf(CustomTonality tonality) {
		if ( length() != tonality.length() )
			return false;

		for ( Chromatic note : notes )
			if ( !tonality.has( note ) ) {
				return false;
			}

		return true;
	}

	public boolean isIntercambioModalOf(CustomTonality t) {
		return scale.isDiatonic() && this.root == t.root && !scale.equals( t.scale );
	}

	public CustomTonality[] getModes() {
		CustomTonality[] ret = new CustomTonality[length()];

		int j = 0;
		for ( Scale s : scale.getAllModes() )
			for ( int i = 0; i < 12; i++ ) {
				CustomTonality t = new CustomTonality( Chromatic.get( i ), s );
				if ( isModeOf( t ) )
					ret[j++] = t;
			}

		return ret;
	}
	/*
	public List<CustomTonality> getModesSameRoot() {
		List<CustomTonality> ret = new CustomTonality[length()];

		int j = 0;
		for ( Scale s : scale.getAllModes() )
			for ( int i = 0; i < 12; i++ ) {
				CustomTonality t = new CustomTonality( Chromatic.get( i ), s );
				if ( isModeOf( t ) ) {
					t.updateChromaticsFromBase( root );
					t.minimizeAlterations();
					ret[j++] = t;
				}
			}

		return ret;
	}
	 */
	public static ArrayList<CustomTonality> all() {
		ArrayList<CustomTonality> ret = new ArrayList<CustomTonality>();
		for ( ScaleEnum mode : ScaleEnum.values() )
			for ( int i = 0; i < 12; i++ )
				ret.add( new CustomTonality( Chromatic.get( i ), mode ) );

		return ret;
	}

	public Integer getAlteration() {
		assert notes != null;
		int ret = 0;
		for ( Chromatic c : notes )
			ret += c.getAlterations();

		return ret;
	}

	public static CustomTonality createFromChord(DiatonicChordMidi c, CustomTonality base) throws TonalityException {
		assert base != null;
		if ( base.length() != 7 )
			throw new RuntimeException( "No tiene 7 notas la escala" );

		Chromatic[] notesChord = new Chromatic[c.size()];
		for ( int i = 0; i < c.size(); i++ )
			notesChord[i] = c.get( i ).getChromatic().getChromatic();

		int posChordCorrector = 7 - c.get( 0 ).getDegree().val();

		// Integer posBaseCorrector = base.getDegree(notesChord[0]);
		Integer posBaseCorrector = ( Diatonic.get( notesChord[0] ).val()
				- Diatonic.get( base.root ).val() + 7 ) % 7;
		if ( posBaseCorrector == null )
			throw new TonalityException( c.get( 0 ).getChromatic(), base );

		Chromatic[] tonalityNotes = new Chromatic[7];
		for ( int i = 0; i < 7; i++ ) {
			int pos = ( posBaseCorrector + i ) % 7;

			boolean notFound = true;
			for ( int j = 0; j < notesChord.length; j++ )
				if ( base.scale.trim( c.get( j ).getDegree().val() + posChordCorrector ) == i ) {
					tonalityNotes[i] = notesChord[j];
					notFound = false;
					break;
				}

			if ( notFound )
				tonalityNotes[i] = base.get( pos );
		}

		return new CustomTonality( notesChord[0], notes2scale( tonalityNotes ) );
	}

	public static Scale notes2scale(Chromatic[] notes) {
		int[] ton = new int[notes.length];
		int sum = 0;
		for ( int i = 0; i < notes.length - 1; i++ ) {
			ton[i] = notes[i + 1].val() - notes[i].val();
			while ( ton[i] < 0 )
				ton[i] += 12;
			sum += ton[i];
			// assert ton[i] != 0; // TODO
		}
		int dif = 12 - sum;
		assert dif > 0;
		ton[notes.length - 1] = dif;

		return Scale.of( ton );
	}

	public DiatonicDegree getDegree(PitchChromaticSingle note) {
		assert note != null : "No se ha especificado nota";
		return getDegree( note, true );
	}

	public DiatonicDegree getDegree(PitchChromaticSingle note, boolean enharmonic) {
		assert note != null : "No se ha especificado nota";

		for ( int i = 0; i < length(); i++ )
			if ( !enharmonic && get( i ).equals( note.getChromatic() )
					|| enharmonic && get( i ).val() == note.getChromatic().val() )
				return DiatonicDegree.get( i );

		return null;
	}
	/*
	 * public Integer getDegree(int note) { for ( int i = 0; i < length(); i++ ) if
	 * ( get( i ).val() == note ) return i;
	 * 
	 * return null; }
	 */

	public boolean has(PitchChromaticSingle note) {
		return getDegree( note ) != null;
	}

	public <N extends PitchChromaticSingle> boolean has(PitchChromaticChord<N> notes) {
		for ( N n : notes ) {
			if ( getDegree( n ) == null )
				return false;
		}

		return true;
	}
	/*
	 * public boolean has(int note) { return getDegree( note ) != null; }
	 * 
	 * public boolean has(int[] notes) { for ( int n : notes ) if ( getDegree( n )
	 * == null ) return false;
	 * 
	 * return true; }
	 */

	public CustomTonality getRelativeScaleDiatonic(IntervalDiatonic pos) {
		return new CustomTonality( get( pos ), getScale() );
	}

	public CustomTonality getRelativeScaleDiatonic(DiatonicDegree pos) {
		return getRelativeScaleDiatonic( IntervalDiatonic.get( pos ) );
	}

	public CustomTonality getRelativeScaleChromatic(int pos) {
		return new CustomTonality( root.add( pos ), getScale() );
	}

	public CustomTonality setScale(ScaleEnum t) {
		scale = t;

		return this;
	}

	public Scale getScale() {
		return scale;
	}

	public Chromatic getRoot() {
		return root;
	}

	public CustomTonality minor() {
		CustomTonality s = new CustomTonality( root, ScaleEnum.MINOR );
		return s;
	}

	public CustomTonality major() {
		CustomTonality s = new CustomTonality( root, ScaleEnum.MAJOR );
		return s;
	}

	public CustomTonality lydian() {
		CustomTonality s = new CustomTonality( root, ScaleEnum.LYDIAN );
		return s;
	}

	public ArrayList<DiatonicChordMidi[]> commonChords(CustomTonality s) {
		ArrayList<DiatonicChordMidi[]> ret = new ArrayList<>();
		for ( DiatonicFunction i : DiatonicFunction.COMMON )
			for ( DiatonicFunction j : DiatonicFunction.COMMON ) {
				DiatonicChordMidi c = new DiatonicChordMidi( i, this );
				DiatonicChordMidi c2 = new DiatonicChordMidi( j, s );

				if ( c.commonNotes( c2, false ).size() == c.size() && c.size() == c2.size() )
					ret.add(
						new DiatonicChordMidi[] {
							c,
							c2
						}
							);
			}
		return ret;
	}

	public Set<CustomChromaticChord> getScaleChords() {
		createCacheIfNeeded();
		Set<CustomChromaticChord> ret = new HashSet();
		for (CustomChromaticChord c : scaleChords)
			ret.add( c.clone( true ) );
		return ret;
	}

	public Set<CustomChromaticChord> getOutScaleChords() {
		createCacheIfNeeded();
		Set<CustomChromaticChord> ret = new HashSet();
		for (CustomChromaticChord c : outScaleChords)
			ret.add( c.clone( true ) );
		return ret;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( ChromaticMidi.literal( root, this ) + " " );

		sb.append( scale );

		return sb.toString();
	}

	public void showNotes() {
		Logging.log( this + ": " + notesToString() );
	}

	public String notesToString() {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < length(); i++ ) {
			sb.append( ChromaticMidi.literal( get( i ), this ) + " " );
		}

		return sb.toString();
	}

	public IntervalChromatic getInterval(DiatonicDegree d2, IntervalDiatonic id) {
		int idInt = id.val();

		int n = get( d2.val() + idInt ).val() - get( d2 ).val();
		if ( n < 0 )
			n += IntervalChromatic.PERFECT_OCTAVE.val();
		n += idInt / IntervalChromatic.PERFECT_OCTAVE.val();
		return IntervalChromatic.get( id, n );
	}

	public HarmonicFunction getFunction(CustomChromaticChord c) {
		HarmonicFunction hf = getFunction( c, true );
		if ( hf == null )
			hf = getFunction( c, false );
		return hf;
	}

	public HarmonicFunction getFunction(PitchChromaticChord c, boolean rename) {
		createCacheIfNeeded();
		CustomChromaticChord c2;
		c2 = CustomChromaticChord.copyOf( c );
		if ( rename )
			c2.rename( this );

		return chromaticChordFunction.get( c2 );
	}

	public void showChromaticChordFunction() {
		createCacheIfNeeded();
		chromaticChordFunction.forEach( (c, f) -> {
			System.out.println( f + ":\t" + c + "\t" + c.notesToString() );
		} );
	}

	public Chromatic getEnharmonic(Chromatic chromatic) throws TonalityException {
		Chromatic c = valChromaticMap.get( chromatic.val() );
		if ( c == null )
			throw new TonalityException( chromatic, this );
		return c;
	}

	@Override
	public Chromatic[] getNotes() {
		return notes; // TODO: clone
	}
}
