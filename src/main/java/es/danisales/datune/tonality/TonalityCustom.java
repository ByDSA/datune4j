package es.danisales.datune.tonality;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

class TonalityCustom implements Tonality {
	private DiatonicAlt				root;
	private Scale					scale;

	/** Temp */
	private List<DiatonicAlt>				notes;
	private Map<Chromatic, DiatonicAlt> chromaticDiatonicAltMap;

	// TODO: no usado
	class ChromaticChordSet {
		public ChromaticChord chord;
		public TonalityCustom tonality;
		public HarmonicFunction	function;

		public ChromaticChordSet(ChromaticChord c, TonalityCustom t, HarmonicFunction f) {
			chord = c;
			tonality = t;
			function = f;
		}
	}

	// Cache
	private boolean										useCache;
	private Set<ChromaticChord>							outScaleChords;
	private HashMap<DiatonicFunction, ChromaticChord>	functionChordsMap;
	private HashMap<ChromaticFunction, ChromaticChord>	chromaticChordsMap;
	private HashMap<ChromaticChord, HarmonicFunction> chromaticChordFunctionMap;

	private static final int	SIZE_MIN	= 2;
	private static final int	SIZE_MAX	= 8;

	private void createCache() {
		outScaleChords = new HashSet<>();
		chromaticChordFunctionMap = new HashMap<>();

		functionChordsMap = new HashMap<>();
		for ( DiatonicFunction f : DiatonicFunction.COMMON )
			functionChordsMap.put( f, getChordFrom( f ) );

		chromaticChordsMap = new HashMap<>();
		for ( ChromaticFunction f : ChromaticFunction.ALL )
			chromaticChordsMap.put( f, getChordFrom( f ) );

		useCache = true;
	}

	public TonalityCustom(DiatonicAlt noteBase, Scale scale) {
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

	private void createCacheIfNeeded() {
		if ( !useCache )
			createCache();
	}

	@Override
	public TonalityCustom clone() {
		return new TonalityCustom( root, scale );
	}

	// todo: private
	@Override
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

	@Override
	public ChromaticChord getChordFrom(ChromaticFunction f) {
		ChromaticChord cc = null;
		if ( chromaticChordsMap != null )
			cc = chromaticChordsMap.get( f );

		if ( cc == null ) {
			cc = ChromaticChord.from( this, f );
			if (cc instanceof ChromaticChord)
				((ChromaticChord)cc).updateWhatIsIt();
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

	public static TonalityCustom createFromChord(DiatonicChordMidi c, TonalityCustom base) throws TonalityException {
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

		return new TonalityCustom( notesChord[0], Scale.fromDiatonicAltList( tonalityNotes ) );
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

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof Tonality) )
			return false;

		Tonality tonality = (Tonality)o;

		return getNotes().equals( tonality.getNotes() );
	}

	@Override
	public int hashCode() {
		return notes.hashCode();
	}

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

	public TonalityCustom getRelativeScaleChromatic(int semitonesAdded) {
		ScaleDistance distanceScale = ScaleDistance.from(semitonesAdded);
		int semitones = distanceScale.getSemitones();
		DiatonicAlt shiftedRoot = root.addSemi( semitones );
		return new TonalityCustom( shiftedRoot, getScale() );
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( ChromaticMidi.literal( root, this ) + " " );

		sb.append( scale );

		return sb.toString();
	}

	public HarmonicFunction getFunction(ChromaticChord c) {
		HarmonicFunction hf = getFunction( c, true );
		if ( hf == null )
			hf = getFunction( c, false );
		return hf;
	}

	@Override
	public HarmonicFunction getFunction(ChromaticChord c, boolean rename) {
		createCacheIfNeeded();
		ChromaticChord c2;
		c2 = ChromaticChord.from( c );
		/*if ( rename )
			c2.rename( this );*/

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
