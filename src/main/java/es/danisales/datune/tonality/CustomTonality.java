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
import org.checkerframework.checker.nullness.qual.NonNull;

import static com.google.common.base.Preconditions.checkArgument;

public class CustomTonality implements Tonality {
	private DiatonicAlt				root;
	private Scale					scale;

	/** Temp */
	private List<DiatonicAlt>				notes;
	private Map<Chromatic, DiatonicAlt> chromaticDiatonicAltMap;

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
	private Set<ChromaticChord>							scaleChords;
	private Set<ChromaticChord>							outScaleChords;
	private Set<ChromaticChord>							borrowedChords;
	private HashMap<DiatonicFunction, ChromaticChord>	functionChordsMap;
	private HashMap<ChromaticFunction, ChromaticChord>	chromaticChordsMap;
	private HashMap<ChromaticChord, HarmonicFunction> chromaticChordFunctionMap;

	private static final int	SIZE_MIN	= 2;
	private static final int	SIZE_MAX	= 8;

	private void createCache() {
		scaleChords = new HashSet<>();
		outScaleChords = new HashSet<>();
		borrowedChords = new HashSet<>();
		chromaticChordFunctionMap = new HashMap<>();

		functionChordsMap = new HashMap<>();
		for ( DiatonicFunction f : DiatonicFunction.COMMON )
			functionChordsMap.put( f, getChordFrom( f ) );

		chromaticChordsMap = new HashMap<>();
		for ( ChromaticFunction f : ChromaticFunction.ALL )
			chromaticChordsMap.put( f, getChordFrom( f ) );

		useCache = true;

		for ( DiatonicFunction f : ArrayUtils
				.concat( DiatonicFunction.TRIADS, DiatonicFunction.SEVENTH ) ) {
			ChromaticChord cc = getChordFrom( f );
			ChromaticChord[] modalChromaticChords = cc.getModalChords( this );
			if ( modalChromaticChords == null )
				continue;
			for ( ChromaticChord cc2 : modalChromaticChords )
				if ( !hasEnharmonic( cc2 ) ) {
					borrowedChords.add( cc2 );
				}
		}
		/*
		 * if ( this.isMajorOrMinor() ) { Scale otherScale = scale.equals( Scale.MAJOR ) ?
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

		updateNotes();

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
			if ( p.equals( initialRoot ) )
				continue;

			ton.updateNotes();

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
			} else if (a.equals(minAlterations)) {
				out.add( ton.clone() );
			}
		}

		return out;
	}

	private void createCacheIfNeeded() {
		if ( !useCache )
			createCache();
	}

	@Override
	public @NonNull Set<ChromaticChord> getAllChords() {
		createCacheIfNeeded();

		Set<ChromaticChord> ret = new HashSet<>();

		ret.addAll( getScaleChords() );
		ret.addAll( getOutScaleChords() );
		ret.addAll( getBorrowedChords() );

		return ret;
	}

	@Override
	public @NonNull Set<ChromaticChord> getBorrowedChords() {
		createCacheIfNeeded();
		Set<ChromaticChord> ret = new HashSet<>();
		for (ChromaticChord c : borrowedChords)
			ret.add( ChromaticChord.from(c) );
		return ret;
	}

	public static List<CustomTonality> getFromChord(PitchChromaticChord c) {
		return getFromChord( false, c );
	}

	public static List<CustomTonality> getFromChord(boolean outScale, PitchChromaticChord c) {
		List<CustomTonality> out = new ArrayList<>();
		for ( CustomTonality t : CustomTonality.all() ) {
			if ( t.has( outScale, c ) )
				out.add( t );
		}

		return out;
	}

	public static List<Tonality> getFromChords(boolean outScale, List<ChromaticChordMidi> chords) {
		checkArgument(chords.size() > 0);
		List<Tonality> candidates = new ArrayList<>();

		boolean first = true;
		for ( ChromaticChordMidi chord : chords ) {
			if ( chord.size() == 0 )
				continue;
			ChromaticChordMidi chordCopy = chord.clone();

			List<Tonality> candidatesPrev = candidates;

			do {
				List<DiatonicChordMidi> possibleChords = chordCopy
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

	public CustomTonality clone() {
		return new CustomTonality( root, scale );
	}

	// todo: private
	public ChromaticChord getChordFrom(DiatonicFunction f) {
		ChromaticChord cc = null;
		if ( functionChordsMap != null )
			cc = functionChordsMap.get( f );

		if ( cc == null ) {
			/*CustomDiatonicChord dc = new CustomDiatonicChord( f );
			assert dc != null : f + " " + this;

			cc = CustomChromaticChord.fromIntegers( calculateFrom( dc, f ) );
			cc.rename( this );
			//assert cc.meta.str != null : cc.notesToString();
			if ( functionChordsMap == null )
				functionChordsMap = new HashMap<>();
			functionChordsMap.put( f, cc );

			if ( scaleChords == null )
				scaleChords = new HashSet<>();
			scaleChords.addSemi( cc );

			if ( chromaticChordFunctionMap == null )
				chromaticChordFunctionMap = new HashMap<>();
			chromaticChordFunctionMap.put( cc, f );*/
		}

		cc = ChromaticChord.from(cc);

		return cc;
	}

	// todo: private
	public ChromaticChord getChordFrom(ChromaticFunction f) {
		ChromaticChord cc = null;
		if ( chromaticChordsMap != null )
			cc = chromaticChordsMap.get( f );

		if ( cc == null ) {
			cc = ChromaticChord.from( f, this );
			if (cc instanceof CustomChromaticChord)
				((CustomChromaticChord)cc).updateWhatIsIt();
			assert cc != null : f + " " + TonalityNamer.notesFrom(this);

			if ( chromaticChordsMap == null )
				chromaticChordsMap = new HashMap<>();
			chromaticChordsMap.put( f, cc );

			if ( outScaleChords == null )
				outScaleChords = new HashSet<>();
			if (ArrayUtils.contains( f, ChromaticFunction.ALL ))
				outScaleChords.add( cc );

			if ( chromaticChordFunctionMap == null )
				chromaticChordFunctionMap = new HashMap<>();
			chromaticChordFunctionMap.putIfAbsent(cc, f);
		}

		cc = ChromaticChord.from(cc);

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

	private void updateNotes() {
		notes = Tonality.getNotesFrom(root, scale);

		updateValChromaticMap();
	}

	private void updateValChromaticMap() {
		chromaticDiatonicAltMap = new HashMap<>();
		for ( DiatonicAlt diatonicAlt : notes ) {
			Chromatic chromatic = Chromatic.from(diatonicAlt);
			chromaticDiatonicAltMap.put(chromatic, diatonicAlt);
		}
	}

	/*
	public List<CustomTonality> getModesSameRoot() {
		List<CustomTonality> ret = new CustomTonality[size()];

		int j = 0;
		for ( Scale s : scale.getAllModes() )
			for ( int i = 0; i < 12; i++ ) {
				CustomTonality t = new CustomTonality( Chromatic.calculateFrom( i ), s );
				if ( isModeOf( t ) ) {
					t.updateNotes( root );
					t.minimizeAlterations();
					ret[j++] = t;
				}
			}

		return ret;
	}
	 */
	public static ArrayList<CustomTonality> all() {
		ArrayList<CustomTonality> ret = new ArrayList<>();
		for ( Scale mode : Scale.ALL )
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
		if ( base.size() != 7 )
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

		List<DiatonicAlt> tonalityNotes = new ArrayList<>();
		for ( int i = 0; i < 7; i++ ) {
			DiatonicDegree diatonicDegree = DiatonicDegree.values()[( posBaseCorrector + i ) % DiatonicDegree.values().length];

			boolean notFound = true;
			for ( int j = 0; j < notesChord.length; j++ ) {
				int index = (c.get(j).getDegree().val() + posChordCorrector) % base.getScale().size();
				if (index == i) {
					tonalityNotes.add(notesChord[j]);
					notFound = false;
					break;
				}
			}

			if ( notFound )
				tonalityNotes.add( base.getNote( diatonicDegree ) );
		}

		return new CustomTonality( notesChord[0], Scale.fromDiatonicAltList( tonalityNotes ) );
	}

	public DiatonicDegree getDegreeFrom(PitchChromaticSingle note) {
		assert note != null : "No se ha especificado nota";
		return getDegreeFrom( note, true );
	}

	public DiatonicDegree getDegreeFrom(PitchChromaticSingle note, boolean enharmonic) {
		assert note != null : "No se ha especificado nota";

		for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
			Chromatic chromatic = ChromaticAdapter.from(note);
			if (!enharmonic && getNote(diatonicDegree).equals(chromatic)
					|| enharmonic && Chromatic.from(getNote(diatonicDegree)) == chromatic)
				return diatonicDegree;
		}

		return null;
	}
	/*
	 * public Integer getDegreeFrom(int note) { for ( int i = 0; i < size(); i++ ) if
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

	public CustomTonality getRelativeScaleChromatic(int semitonesAdded) {
		ScaleDistance distanceScale = ScaleDistance.from(semitonesAdded);
		int semitones = distanceScale.getSemitones();
		DiatonicAlt shiftedRoot = root.addSemi( semitones );
		return new CustomTonality( shiftedRoot, getScale() );
	}

	public void setScale(@NonNull Scale scale) {
		this.scale = scale;

		updateNotes();
	}

	public void setRoot(@NonNull DiatonicAlt root) {
		this.root = root;

		updateNotes();
	}

	public @NonNull Scale getScale() {
		return scale;
	}

	public @NonNull DiatonicAlt getRoot() {
		return root;
	}

	public List<DiatonicChordMidi[]> commonChords(CustomTonality s) {
		List<DiatonicChordMidi[]> ret = new ArrayList<>();
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

	@Override
	public @NonNull Set<ChromaticChord> getScaleChords() {
		createCacheIfNeeded();
		Set<ChromaticChord> ret = new HashSet<>();
		for (ChromaticChord c : scaleChords) {
			ChromaticChord c2 = ChromaticChord.from(c);
			ret.add(c2);
		}
		return ret;
	}

	@Override
	public @NonNull Set<ChromaticChord> getOutScaleChords() {
		createCacheIfNeeded();
		Set<ChromaticChord> ret = new HashSet<>();
		for (ChromaticChord c : outScaleChords) {
			ChromaticChord c2 = ChromaticChord.from(c);
			ret.add(c2);
		}
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

		return chromaticChordFunctionMap.get( c2 );
	}

	@Override
	public DiatonicAlt getDiatonicAltFrom(Chromatic chromatic) throws TonalityException {
		DiatonicAlt c = chromaticDiatonicAltMap.get( chromatic );
		if ( c == null )
			throw new TonalityException( chromatic, this );
		return c;
	}

	@Override
	public @NonNull List<DiatonicAlt> getNotes() {
		return notes; // TODO: clone
	}
}
