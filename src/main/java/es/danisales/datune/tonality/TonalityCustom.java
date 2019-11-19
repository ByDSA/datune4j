package es.danisales.datune.tonality;

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
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

class TonalityCustom implements TonalityInterface {
	private DiatonicAlt root;
	private Scale scale;

	/** Temp */
	private List<DiatonicAlt> notes;
	private Map<Chromatic, DiatonicAlt> chromaticDiatonicAltMap;

	// Cache
	private HashMap<DiatonicFunction, ChromaticChord> functionChordsMap;
	private HashMap<ChromaticFunction, ChromaticChord> chromaticChordsMap;
	private HashMap<ChromaticChord, HarmonicFunction> chromaticChordFunctionMap;

	private static final int SIZE_MIN = 2;
	private static final int SIZE_MAX = 8;

	private void createCache() {
		chromaticChordFunctionMap = new HashMap<>();

		functionChordsMap = new HashMap<>();
		for ( DiatonicFunction f : DiatonicFunction.COMMON )
			functionChordsMap.put( f, getChordFrom( f ) );

		chromaticChordsMap = new HashMap<>();
		for ( ChromaticFunction f : ChromaticFunction.ALL )
			chromaticChordsMap.put( f, getChordFrom( f ) );
	}

	public TonalityCustom(DiatonicAlt noteBase, Scale scale) {
		this.root = noteBase;
		this.scale = scale;

		updateNotes();
	}

	private void createCacheIfNeeded() {
		if ( chromaticChordFunctionMap == null )
			createCache();
	}

	@Override
	public TonalityCustom clone() {
		return new TonalityCustom( root, scale );
	}

	// todo: private
	@Override
	public @NonNull ChromaticChord getChordFrom(DiatonicFunction f) {
		ChromaticChord cc = null;
		if ( functionChordsMap != null )
			cc = functionChordsMap.get( f );
/*
		if ( cc == null ) {
			DiatonicChord dc = DiatonicChord.from( f );

			cc = ChromaticChord.from( getAllFrom( dc, f ) );
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
			chromaticChordFunctionMap.put( cc, f );
		}
*/
		cc = ChromaticChord.from(cc);

		return cc;
	}

	@Override
	public @NonNull ChromaticChord getChordFrom(ChromaticFunction f) {
		ChromaticChord cc = null;
		if ( chromaticChordsMap != null )
			cc = chromaticChordsMap.get( f );

		if ( cc == null ) {
			Tonality self = Tonality.from(root, scale);
			cc = ChromaticChord.from( self, f );
			if (cc instanceof ChromaticChord)
				((ChromaticChord)cc).updateWhatIsIt();

			if ( chromaticChordsMap == null )
				chromaticChordsMap = new HashMap<>();
			chromaticChordsMap.put( f, cc );

			if ( chromaticChordFunctionMap == null )
				chromaticChordFunctionMap = new HashMap<>();
			chromaticChordFunctionMap.putIfAbsent(cc, f);
		}

		cc = ChromaticChord.from(cc);

		return cc;
	}

	private void updateNotes() {
		notes = DiatonicAltRetrieval.listFrom(root, scale);
		Objects.requireNonNull(notes);

		createChromaticToDiatonicAltCache();
	}

	private void createChromaticToDiatonicAltCache() {
		chromaticDiatonicAltMap = new HashMap<>();
		for ( DiatonicAlt diatonicAlt : notes ) {
			Chromatic chromatic = Chromatic.from(diatonicAlt);
			chromaticDiatonicAltMap.put(chromatic, diatonicAlt);
		}
	}

	public static TonalityCustom createFromChord(DiatonicChordMidi c, Tonality base) throws TonalityException {
		assert base != null;
		if ( base.size() != 7 )
			throw new RuntimeException( "No tiene 7 notas la escala" );

		DiatonicAlt[] notesChord = new DiatonicAlt[c.size()];
		for ( int i = 0; i < c.size(); i++ ) {
			notesChord[i] = c.get(i).getDiatonicAlt();
		}

		int posChordCorrector = 7 - c.get( 0 ).getDegree().ordinal();

		// Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
		Integer posBaseCorrector = ( Diatonic.from( notesChord[0] ).ordinal()
				- Diatonic.from( base.getRoot() ).ordinal() + 7 ) % 7;
		if ( posBaseCorrector == null ) {
			DiatonicAlt chromatic = c.get(0).getDiatonicAlt();
			throw new TonalityException(chromatic, base);
		}

		List<DiatonicAlt> tonalityNotes = new ArrayList<>();
		for ( int i = 0; i < 7; i++ ) {
			DiatonicDegree diatonicDegree = DiatonicDegree.values()[( posBaseCorrector + i ) % DiatonicDegree.values().length];

			boolean notFound = true;
			for ( int j = 0; j < notesChord.length; j++ ) {
				int index = (c.get(j).getDegree().ordinal() + posChordCorrector) % base.getScale().size();
				if (index == i) {
					tonalityNotes.add(notesChord[j]);
					notFound = false;
					break;
				}
			}

			if ( notFound )
				tonalityNotes.add( base.getNote( diatonicDegree ) );
		}

		return new TonalityCustom( notesChord[0], Scale.from( tonalityNotes ) );
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof TonalityInterface) )
			return false;

		TonalityInterface tonality = (TonalityInterface)o;

		return getNotes().equals( tonality.getNotes() );
	}

	@Override
	public int hashCode() {
		return notes.hashCode();
	}

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
	public @Nullable HarmonicFunction getFunction(@NonNull ChromaticChord chromaticChord) {
		Objects.requireNonNull(chromaticChord);

		createCacheIfNeeded();

		return chromaticChordFunctionMap.get( chromaticChord );
	}

	public @Nullable DiatonicAlt getNote(@NonNull Chromatic chromatic) {
		Objects.requireNonNull(chromatic);

		return chromaticDiatonicAltMap.get( chromatic );
	}

	@Override
	public @NonNull List<DiatonicAlt> getNotes() {
		return Collections.unmodifiableList(notes);
	}
}
