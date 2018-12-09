package diatonic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Log.String.Logging;
import arrays.ArrayUtils;
import pitch.Chromatic;
import pitch.ChromaticChord;
import pitch.ChromaticChordMidi;
import pitch.ChromaticMidi;
import pitch.Diatonic;
import pitch.DiatonicChord;
import pitch.DiatonicChordMidi;
import pitch.DiatonicMidi;
import pitch.PitchChromaticSingle;
import pitch.PitchChromaticableChord;
import pitch.PitchChromaticableSingle;

public class CustomTonality implements Tonality<CustomTonality, CustomTonality> {
	private Chromatic				root;
	private Scale					scale;

	/** Temp */
	private Chromatic[]				notes;
	private Map<Integer, Chromatic>	valChromaticMap;

	// TODO: no usado
	class ChromaticChordSet {
		public ChromaticChord	chord;
		public CustomTonality			tonality;
		public HarmonicFunction	function;

		public ChromaticChordSet(ChromaticChord c, CustomTonality t, HarmonicFunction f) {
			chord = c;
			tonality = t;
			function = f;
		}
	}

	// Cache
	private boolean										useCache;
	private Set<ChromaticChord>							scaleChords;
	private Set<ChromaticChord>							outScaleChords;
	private Set<ChromaticChord>							borrowedChords;
	private HashMap<DiatonicFunction, ChromaticChord>	functionChordsMap;
	private HashMap<ChromaticFunction, ChromaticChord>	chromaticChordsMap;
	public HashMap<ChromaticChord, HarmonicFunction>	chromaticChordFunction;	// TODO: private

	private static final int	SIZE_MIN	= 2;
	private static final int	SIZE_MAX	= 8;

	private void createCache() {
		scaleChords = new HashSet();
		outScaleChords = new HashSet();
		borrowedChords = new HashSet();
		chromaticChordFunction = new HashMap();

		functionChordsMap = new HashMap<>();
		for ( DiatonicFunction f : DiatonicFunction.ALL )
			functionChordsMap.put( f, get( f ) );

		chromaticChordsMap = new HashMap<>();
		for ( ChromaticFunction f : ChromaticFunction.ALL )
			chromaticChordsMap.put( f, get( f ) );

		useCache = true;

		for ( DiatonicFunction f : ArrayUtils
				.concat( DiatonicFunction.TRIADS, DiatonicFunction.SEVENTH ) ) {
			ChromaticChord cc = get( f );
			ChromaticChord[] modalChromaticChords = cc.getModalChords( this );
			if ( modalChromaticChords == null )
				continue;
			for ( ChromaticChord cc2 : modalChromaticChords )
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
		CustomTonality ton = duplicate();
		out.add( ton.duplicate() );
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
				out.add( this.duplicate() );
				if ( a == 0 )
					break;
			} else if ( a == minAlterations ) {
				out.add( ton.duplicate() );
			}
		}

		return out;
	}

	private void createCacheIfNeeded() {
		if ( !useCache )
			createCache();
	}

	public ArrayList<ChromaticChord> getAllChords() {
		createCacheIfNeeded();

		ArrayList<ChromaticChord> ret = new ArrayList<>();

		ret.addAll( getScaleChords() );
		ret.addAll( getOutScaleChords() );
		ret.addAll( getBorrowedChords() );

		return ret;
	}

	public Set<ChromaticChord> getBorrowedChords() {
		createCacheIfNeeded();
		Set<ChromaticChord> ret = new HashSet();
		for (ChromaticChord c : borrowedChords)
			ret.add( c.duplicate( true ) );
		return ret;
	}

	public static ArrayList<CustomTonality> getFromChord(PitchChromaticableChord c) {
		return getFromChord( false, c );
	}

	public static ArrayList<CustomTonality> getFromChord(boolean outScale, PitchChromaticableChord c) {
		ArrayList<CustomTonality> out = new ArrayList<>();
		for ( CustomTonality t : CustomTonality.all() ) {
			if ( t.has( outScale, c ) )
				out.add( t );
		}

		return out;
	}

	public boolean has(boolean outScale, PitchChromaticableChord c) {
		assert c != null;

		boolean hasNotes = has( c );

		if ( hasNotes )
			return true;
		else if ( outScale ) {
			for ( ChromaticFunction f : ChromaticFunction.ALL ) {
				try {
					PitchChromaticableChord c2 = new DiatonicChordMidi( f, this );
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
			ChromaticChordMidi chordCopy = chord.duplicate( false );

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

	public CustomTonality duplicate() {
		return new CustomTonality( root, scale );
	}

	public ChromaticChord get(DiatonicFunction f) {
		ChromaticChord cc = null;
		if ( functionChordsMap != null )
			cc = functionChordsMap.get( f );

		if ( cc == null ) {
			DiatonicChord dc = new DiatonicChord( f );
			assert dc != null : f + " " + this;

			cc = get( dc, f ).rename( this );
			assert cc.meta.str != null : cc.notesToString();
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

		cc = cc.duplicate( true );

		return cc;
	}

	public ChromaticChord get(ChromaticFunction f) {
		ChromaticChord cc = null;
		if ( chromaticChordsMap != null )
			cc = chromaticChordsMap.get( f );

		if ( cc == null ) {
			cc = new ChromaticChord( f, this );
			cc.updateWhatIsIt();
			assert cc != null : f + " " + this.notesToString();

			if ( chromaticChordsMap == null )
				chromaticChordsMap = new HashMap();
			chromaticChordsMap.put( f, cc );

			Degree d = null;
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

		cc = cc.duplicate( true );

		return cc;
	}

	public CustomTonality searchInModeSameRoot(ChromaticChord c) {
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
	}

	public ChromaticChord get(DiatonicChord dc, DiatonicFunction df) {
		return dc.toChromatic( this, df );
	}

	public ChromaticChord[] getTriadChords() {
		NoDiatonicScaleException.check( scale );
		ChromaticChord[] ret = new ChromaticChord[7];
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

	public ChromaticChord[] getSeventhChords() {
		NoDiatonicScaleException.check( scale );
		ChromaticChord[] ret = new ChromaticChord[7];
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

	public Chromatic get(Degree n) {
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

	public CustomTonality[] getModesSameRoot() {
		CustomTonality[] ret = new CustomTonality[length()];

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
			notesChord[i] = c.get( i ).toChromaticMidi().getChromatic();

		int posChordCorrector = 7 - c.get( 0 ).getDegree().val();

		// Integer posBaseCorrector = base.getDegree(notesChord[0]);
		Integer posBaseCorrector = ( Diatonic.get( notesChord[0] ).val()
				- Diatonic.get( base.root ).val() + 7 ) % 7;
		if ( posBaseCorrector == null )
			throw new TonalityException( c.get( 0 ).toChromaticMidi(), base );

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

	public Degree getDegree(PitchChromaticableSingle note) {
		assert note != null : "No se ha especificado nota";
		return getDegree( note, true );
	}

	public Degree getDegree(PitchChromaticableSingle note, boolean enharmonic) {
		assert note != null : "No se ha especificado nota";

		for ( int i = 0; i < length(); i++ )
			if ( !enharmonic && get( i ).equals( note.getChromatic() )
					|| enharmonic && get( i ).val() == note.getChromatic().val() )
				return Degree.get( i );

		return null;
	}
	/*
	 * public Integer getDegree(int note) { for ( int i = 0; i < length(); i++ ) if
	 * ( get( i ).val() == note ) return i;
	 * 
	 * return null; }
	 */

	public boolean has(PitchChromaticableSingle note) {
		return getDegree( note ) != null;
	}

	public <N extends PitchChromaticableSingle<N>> boolean has(PitchChromaticableChord<N, ?, ?> notes) {
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

	public CustomTonality getRelativeScaleDiatonic(Degree pos) {
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
		for ( DiatonicFunction i : DiatonicFunction.ALL )
			for ( DiatonicFunction j : DiatonicFunction.ALL ) {
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

	public Set<ChromaticChord> getScaleChords() {
		createCacheIfNeeded();
		Set<ChromaticChord> ret = new HashSet();
		for (ChromaticChord c : scaleChords)
			ret.add( c.duplicate( true ) );
		return ret;
	}

	public Set<ChromaticChord> getOutScaleChords() {
		createCacheIfNeeded();
		Set<ChromaticChord> ret = new HashSet();
		for (ChromaticChord c : outScaleChords)
			ret.add( c.duplicate( true ) );
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

	public IntervalChromatic getInterval(Degree d2, IntervalDiatonic id) {
		int idInt = id.val();

		int n = get( d2.val() + idInt ).val() - get( d2 ).val();
		if ( n < 0 )
			n += IntervalChromatic.PERFECT_OCTAVE.val();
		n += idInt / IntervalChromatic.PERFECT_OCTAVE.val();
		return IntervalChromatic.get( id, n );
	}

	public HarmonicFunction getFunction(ChromaticChord c) {
		HarmonicFunction hf = getFunction( c, true );
		if ( hf == null )
			hf = getFunction( c, false );
		return hf;
	}

	public HarmonicFunction getFunction(ChromaticChord c, boolean rename) {
		createCacheIfNeeded();
		ChromaticChord c2;
		if ( rename )
			try {
				c2 = c.duplicate( true ).rename( this );
			} catch ( TonalityException e ) {
				c2 = c;
			}
		else
			c2 = c;

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
	public CustomTonality duplicate(boolean b) {
		return new CustomTonality(getRoot(), getScale());
	}

	@Override
	public Chromatic[] getNotes() {
		return notes; // TODO: clone
	}
}
