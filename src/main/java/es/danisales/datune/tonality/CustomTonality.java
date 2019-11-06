package es.danisales.datune.tonality;

import java.util.*;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;

public class CustomTonality implements Tonality {
	private DiatonicAlt				root;
	private Scale					scale;

	/** Temp */
	private DiatonicAlt[]				notes;
	private Map<Integer, DiatonicAlt>	valChromaticMap;

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
				if ( !hasEnharmonic( cc2 ) ) {
					borrowedChords.add( cc2 );
				}
		}
		/*
		 * if ( this.isMajorMinor() ) { Scale otherScale = scale.equals( Scale.MAJOR ) ?
		 * Scale.MINOR : Scale.MAJOR; Tonality ton = new Tonality( root, otherScale );
		 * DiatonicFunction[] fs = new DiatonicFunction[] { DiatonicFunction.D,
		 * DiatonicFunction.E, DiatonicFunction.F, DiatonicFunction.G,
		 * DiatonicFunction.A, DiatonicFunction.B }; for ( DiatonicFunction cf : fs )
		 * { DiatonicChordMidi dcm = new DiatonicChordMidi( cf, ton );
		 *
		 * int d = dcm.getDegreeFrom().intValue();
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

	public CustomTonality(DiatonicAlt noteBase, Scale scale) {
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
		List<DiatonicAlt> possibilities = root.getEnharmonics(3);
		DiatonicAlt initialRoot = root;
		Integer minAlterations = getAlteration();
		CustomTonality ton = clone();
		out.add( ton.clone() );
		for ( DiatonicAlt p : possibilities ) {
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
					PitchChromaticChord c2 = ChromaticChordMidi.from( new DiatonicChordMidi( f, this ) );
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
					chordCopy = chordCopy.subList( 0, chordCopy.size() - 1 );
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
			/*CustomDiatonicChord dc = new CustomDiatonicChord( f );
			assert dc != null : f + " " + this;

			cc = CustomChromaticChord.from( calculateFrom( dc, f ) );
			cc.rename( this );
			//assert cc.meta.str != null : cc.notesToString();
			if ( functionChordsMap == null )
				functionChordsMap = new HashMap<>();
			functionChordsMap.put( f, cc );

			if ( scaleChords == null )
				scaleChords = new HashSet<>();
			scaleChords.addSemi( cc );

			if ( chromaticChordFunction == null )
				chromaticChordFunction = new HashMap<>();
			chromaticChordFunction.put( cc, f );*/
		}

		cc = cc.clone( true );

		return cc;
	}

	public CustomChromaticChord get(ChromaticFunction f) {
		CustomChromaticChord cc = null;
		if ( chromaticChordsMap != null )
			cc = chromaticChordsMap.get( f );

		if ( cc == null ) {
			cc = (CustomChromaticChord)ChromaticChord.from( f, this );
			cc.updateWhatIsIt();
			assert cc != null : f + " " + this.notesToString();

			if ( chromaticChordsMap == null )
				chromaticChordsMap = new HashMap<>();
			chromaticChordsMap.put( f, cc );

			DiatonicDegree d = null;
			d = f.getDegree();
			assert d != null : f;
			if ( outScaleChords == null )
				outScaleChords = new HashSet<>();
			if (ArrayUtils.contains( f, ChromaticFunction.ALL ))
				outScaleChords.add( cc );

			if ( chromaticChordFunction == null )
				chromaticChordFunction = new HashMap<>();
			chromaticChordFunction.putIfAbsent(cc, f);
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

	public boolean updateChromaticsFromBase(DiatonicAlt noteBase) {
		Chromatic note = Chromatic.from(noteBase);
		int len = length();
		notes = new DiatonicAlt[len];
		notes[0] = noteBase;
		Diatonic noteBaseDiatonic = notes[0].getDiatonic();
		int alt = 0;
		for ( int i = 1; i < len; i++ ) {
			note = note.addSemi( scale.get( i - 1 ) );
			try {
				noteBaseDiatonic = noteBaseDiatonic.shift( 1 );
				notes[i] = ChromaticAdapter.from( noteBaseDiatonic, note );
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
		for ( DiatonicAlt diatonicAlt : notes ) {
			Chromatic chromatic = Chromatic.from(diatonicAlt);
			valChromaticMap.put(chromatic.ordinal(), diatonicAlt);
		}
	}
	/*
	public CustomTonality(int noteBase, Scale scale) {
		this( Chromatic.calculateFrom( noteBase ), scale );
	}*/

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

		for ( DiatonicAlt note : notes )
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
			for ( Chromatic chromatic : Chromatic.values() ) {
				DiatonicAlt diatonicAlt = DiatonicAlt.from(chromatic);
				CustomTonality customTonality = new CustomTonality( diatonicAlt, s );
				if ( isModeOf( customTonality ) )
					ret[j++] = customTonality;
			}

		return ret;
	}
	/*
	public List<CustomTonality> getModesSameRoot() {
		List<CustomTonality> ret = new CustomTonality[length()];

		int j = 0;
		for ( Scale s : scale.getAllModes() )
			for ( int i = 0; i < 12; i++ ) {
				CustomTonality t = new CustomTonality( Chromatic.calculateFrom( i ), s );
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
		ArrayList<CustomTonality> ret = new ArrayList<>();
		for ( ScaleEnum mode : ScaleEnum.values() )
			for ( int i = 0; i < Chromatic.NUMBER; i++ ) {
				Chromatic chromatic = Chromatic.from(i);
				DiatonicAlt diatonicAlt = DiatonicAlt.from(chromatic);
				ret.add(new CustomTonality(diatonicAlt, mode));
			}

		return ret;
	}

	public Integer getAlteration() {
		assert notes != null;
		int ret = 0;
		for ( DiatonicAlt c : notes )
			ret += c.getAlterations();

		return ret;
	}

	public static CustomTonality createFromChord(DiatonicChordMidi c, CustomTonality base) throws TonalityException {
		assert base != null;
		if ( base.length() != 7 )
			throw new RuntimeException( "No tiene 7 notas la escala" );

		DiatonicAlt[] notesChord = new DiatonicAlt[c.size()];
		for ( int i = 0; i < c.size(); i++ ) {
			notesChord[i] = c.get(i).getDiatonicAlt();
		}

		int posChordCorrector = 7 - c.get( 0 ).getDegree().val();

		// Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
		Integer posBaseCorrector = ( Diatonic.from( notesChord[0] ).ordinal()
				- Diatonic.from( base.root ).ordinal() + 7 ) % 7;
		if ( posBaseCorrector == null ) {
			DiatonicAlt chromatic = c.get(0).getDiatonicAlt();
			throw new TonalityException(chromatic, base);
		}

		DiatonicAlt[] tonalityNotes = new DiatonicAlt[7];
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

	public static Scale notes2scale(DiatonicAlt[] notes) {
		int[] ton = new int[notes.length];
		int sum = 0;
		for ( int i = 0; i < notes.length - 1; i++ ) {
			DiatonicAlt current = notes[i];
			DiatonicAlt next = notes[i + 1];
			ton[i] = Chromatic.from(current).distSemitonesTo(Chromatic.from(next));
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

	public DiatonicDegree getDegreeFrom(PitchChromaticSingle note) {
		assert note != null : "No se ha especificado nota";
		return getDegreeFrom( note, true );
	}

	public DiatonicDegree getDegreeFrom(PitchChromaticSingle note, boolean enharmonic) {
		assert note != null : "No se ha especificado nota";

		for ( int i = 0; i < length(); i++ ) {
			Chromatic chromatic = ChromaticAdapter.from(note);
			if (!enharmonic && get(i).equals(chromatic)
					|| enharmonic && Chromatic.from(get(i)) == chromatic)
				return DiatonicDegree.fromIndex(i);
		}

		return null;
	}
	/*
	 * public Integer getDegreeFrom(int note) { for ( int i = 0; i < length(); i++ ) if
	 * ( calculateFrom( i ).intValue() == note ) return i;
	 *
	 * return null; }
	 */

	public boolean has(DiatonicAlt note) {
		return getDegreeFrom( note ) != null;
	}

	/*
	 * public boolean has(int note) { return getDegreeFrom( note ) != null; }
	 *
	 * public boolean has(int[] notes) { for ( int n : notes ) if ( getDegreeFrom( n )
	 * == null ) return false;
	 *
	 * return true; }
	 */

	public CustomTonality getRelativeScaleChromatic(int pos) {
		return new CustomTonality( root.addSemi( pos ), getScale() );
	}

	public CustomTonality setScale(ScaleEnum t) {
		scale = t;

		return this;
	}

	public Scale getScale() {
		return scale;
	}

	public DiatonicAlt getRoot() {
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( ChromaticMidi.literal( root, this ) + " " );

		sb.append( scale );

		return sb.toString();
	}

	public HarmonicFunction getFunction(CustomChromaticChord c) {
		HarmonicFunction hf = getFunction( c, true );
		if ( hf == null )
			hf = getFunction( c, false );
		return hf;
	}

	@Override
	public HarmonicFunction getFunction(PitchChromaticChord c, boolean rename) {
		createCacheIfNeeded();
		CustomChromaticChord c2;
		c2 = CustomChromaticChord.from( c );
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

	@Override
	public DiatonicAlt get(Chromatic chromatic) throws TonalityException {
		DiatonicAlt c = valChromaticMap.get( chromatic.ordinal() );
		if ( c == null )
			throw new TonalityException( chromatic, this );
		return c;
	}

	@Override
	public DiatonicAlt[] getNotes() {
		return notes; // TODO: clone
	}
}
