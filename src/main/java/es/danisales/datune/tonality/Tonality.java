package es.danisales.datune.tonality;

import java.nio.file.DirectoryStream;
import java.util.*;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.musical.transformations.DistanceCalculator;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.log.string.Logging;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Tonality extends Cloneable {
	ArrayList<CustomChromaticChord> getAllChords();

	Set<CustomChromaticChord> getBorrowedChords();

	static ArrayList<Tonality> getFromChord(PitchChromaticChord c) {
		return getFromChord( false, c );
	}

	static ArrayList<Tonality> getFromChord(boolean outScale, PitchChromaticChord c) {
		ArrayList<Tonality> out = new ArrayList<>();
		for ( Tonality t : Tonality.all() ) {
			if ( t.has( outScale, c ) )
				out.add( t );
		}

		return out;
	}

	boolean has(boolean outScale, PitchChromaticChord c);

	default boolean isMajorMinor() {
		return ( getScale().equals( ScaleEnum.MAJOR ) || getScale().equals( ScaleEnum.MINOR ) );
	}

	default boolean equals(Tonality t) {
		return sameRoot( t ) && sameScale( t ) && sameNotes( t );
	}

	default boolean sameRoot(Tonality t) {
		assert t != null;
		assert getRoot() != null;
		assert t.getRoot() != null;
		return getRoot().equals( t.getRoot() );
	}

	default boolean sameScale(Tonality t) {
		return getScale().equals( t.getScale() );
	}

	default boolean sameNotes(Tonality t) {
		return Arrays.equals( getNotes(), t.getNotes() );
	}

	public PitchChromaticChord get(DiatonicFunction f);

	public PitchChromaticChord get(ChromaticFunction f);

	default Tonality searchInModeSameRoot(PitchChromaticChord c) {
		List<Tonality> ts;
		if ( this.getScale().isDiatonic() ) {
			ts = new ArrayList<>();
			ts.add( new CustomTonality( this.getRoot(), ScaleEnum.MAJOR ) );
			ts.add( new CustomTonality( this.getRoot(), ScaleEnum.MINOR ) );
			ts.add( new CustomTonality( this.getRoot(), ScaleEnum.DORIAN ) );
			ts.add( new CustomTonality( this.getRoot(), ScaleEnum.PHRYGIAN ) );
			ts.add( new CustomTonality( this.getRoot(), ScaleEnum.LYDIAN ) );
			ts.add( new CustomTonality( this.getRoot(), ScaleEnum.MIXOLYDIAN ) );
			ts.add( new CustomTonality( this.getRoot(), ScaleEnum.LOCRIAN ) );
		} else
			ts = this.getModesSameRoot();

		for ( Tonality t : ts ) {
			if ( t.equals( this ) )
				continue;
			HarmonicFunction function = t.getFunction( c );
			if ( function != null && function instanceof DiatonicFunction ) {
				return t;
			}
		}

		return null;
	}

	default PitchChromaticChord get(CustomDiatonicChord dc, DiatonicFunction df) {
		return dc.toChromatic( this, df );
	}

	default PitchChromaticChord[] getTriadChords() {
		NoDiatonicScaleException.check( getScale() );
		PitchChromaticChord[] ret = new PitchChromaticChord[7];
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

	default PitchChromaticChord[] getSeventhChords() {
		NoDiatonicScaleException.check( getScale() );
		PitchChromaticChord[] ret = new PitchChromaticChord[7];
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

	boolean updateChromaticsFromBase(DiatonicAlt noteBase);

	default int length() {
		return getScale().length();
	}

	default DiatonicAlt get(int pos) {
		int i = getScale().trim( pos );
		return getNotes()[i];
	}

	default @NonNull DiatonicAlt get(@NonNull DiatonicDegree n) {
		return get( n.val() );
	}

	default Tonality getRelativeMinor() {
		Tonality[] rel = getModes();
		for ( Tonality s : rel )
			if ( s.getScale().equals( ScaleEnum.MINOR ) )
				return s;

		return null;
	}

	default Tonality getRelativeMajor() {
		Tonality[] rel = getModes();
		for ( Tonality s : rel )
			if ( s.getScale().equals( ScaleEnum.MAJOR ) )
				return s;

		return null;
	}

	default boolean isModeOf(Tonality tonality) {
		if ( length() != tonality.length() )
			return false;

		for ( DiatonicAlt note : getNotes() )
			if ( !tonality.has( note ) ) {
				return false;
			}

		return true;
	}

	default boolean isIntercambioModalOf(Tonality t) {
		return getScale().isDiatonic() && this.getRoot() == t.getRoot() && !getScale().equals( t.getScale() );
	}

	default Tonality[] getModes() {
		Tonality[] ret = new Tonality[length()];

		int j = 0;
		for ( Scale s : getScale().getAllModes() )
			for ( Chromatic chromatic : Chromatic.values() ) {
				Tonality t = Tonality.of( chromatic, s );
				if ( isModeOf( t ) )
					ret[j++] = t;
			}

		return ret;
	}

	default List<Tonality> getModesSameRoot() {
		List<Tonality> ret = new ArrayList<>();

		for ( Scale s : getScale().getAllModes() )
			for ( Chromatic chromatic : Chromatic.values() ) {
				Tonality t = Tonality.of( chromatic, s );
				if ( isModeOf( t ) ) {
					t.updateChromaticsFromBase( getRoot() );
					if (t instanceof CustomTonality)
						((CustomTonality)t).minimizeAlterations();
					ret.add( t );
				}
			}

		return ret;
	}

	public static ArrayList<Tonality> all() {
		ArrayList<Tonality> ret = new ArrayList<Tonality>();
		for ( ScaleEnum mode : ScaleEnum.values() )
			for ( Chromatic chromatic : Chromatic.values() )
				ret.add( Tonality.of( chromatic, mode ) );

		return ret;
	}

	default Integer getAlteration() {
		assert getNotes() != null;
		int ret = 0;
		for ( DiatonicAlt c : getNotes() )
			ret += c.getAlterations();

		return ret;
	}

	public static Tonality createFromChord(DiatonicChordMidi c, Tonality base) throws TonalityException {
		assert base != null;
		if ( base.length() != 7 )
			throw new RuntimeException( "No tiene 7 notas la escala" );

		DiatonicAlt[] notesChord = new DiatonicAlt[c.size()];
		for ( int i = 0; i < c.size(); i++ )
			notesChord[i] = c.get( i );

		int posChordCorrector = 7 - c.get( 0 ).getDegree().val();

		// Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
		Integer posBaseCorrector = ( Diatonic.from( notesChord[0] ).ordinal()
				- Diatonic.from( base.getRoot() ).ordinal() + 7 ) % 7;
		if ( posBaseCorrector == null ) {
			DiatonicAlt chromatic = c.get(0);
			throw new TonalityException(chromatic, base);
		}

		DiatonicAlt[] tonalityNotes = new DiatonicAlt[7];
		for ( int i = 0; i < 7; i++ ) {
			int pos = ( posBaseCorrector + i ) % 7;

			boolean notFound = true;
			for ( int j = 0; j < notesChord.length; j++ )
				if ( base.getScale().trim( c.get( j ).getDegree().val() + posChordCorrector ) == i ) {
					tonalityNotes[i] = notesChord[j];
					notFound = false;
					break;
				}

			if ( notFound )
				tonalityNotes[i] = base.get( pos );
		}

		return Tonality.of( notesChord[0], notes2scale( tonalityNotes ) );
	}

	static Scale notes2scale(DiatonicAlt[] notes) {
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

	default @Nullable DiatonicDegree getDegreeFrom(@NonNull DiatonicAlt note) {
		Objects.requireNonNull(note, "No se ha especificado nota");
		return getDegreeFrom( note, true );
	}

	default DiatonicDegree getDegreeFrom(DiatonicAlt note, boolean enharmonic) {
		assert note != null : "No se ha especificado nota";

		for ( int i = 0; i < length(); i++ ) {
			Chromatic chromatic = Chromatic.from(note);
			if (!enharmonic && get(i).equals(chromatic)
					|| enharmonic && Chromatic.from( get(i) ) == chromatic)
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

	default boolean has(DiatonicAlt note) {
		return getDegreeFrom( note ) != null;
	}

	default <N extends DiatonicAlt> boolean has(Iterable<N> notes) {
		for ( N n : notes ) {
			if ( getDegreeFrom( n ) == null )
				return false;
		}

		return true;
	}
	/*
	 * public boolean has(int note) { return getDegreeFrom( note ) != null; }
	 * 
	 * public boolean has(int[] notes) { for ( int n : notes ) if ( getDegreeFrom( n )
	 * == null ) return false;
	 * 
	 * return true; }
	 */

	default Tonality getRelativeScaleDiatonic(DiatonicDegree pos) {
		return Tonality.of( get( pos ), getScale() );
	}

	default Tonality getRelativeScaleChromatic(int pos) {
		return Tonality.of( getRoot().addSemi( pos ), getScale() );
	}

	Scale getScale();

	DiatonicAlt getRoot();

	DiatonicAlt[] getNotes();

	default Tonality minor() {
		Tonality s = Tonality.of( getRoot(), ScaleEnum.MINOR );
		return s;
	}

	default Tonality major() {
		Tonality s = Tonality.of( getRoot(), ScaleEnum.MAJOR );
		return s;
	}

	default Tonality lydian() {
		Tonality s = Tonality.of( getRoot(), ScaleEnum.LYDIAN );
		return s;
	}

	default ArrayList<DiatonicChordMidi[]> commonChords(Tonality s) {
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

	Set<CustomChromaticChord> getScaleChords();

	Set<CustomChromaticChord> getOutScaleChords();

	default void showNotes() {
		Logging.log( this + ": " + notesToString() );
	}

	default String notesToString() {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < length(); i++ ) {
			sb.append( ChromaticMidi.literal( get( i ), this ) + " " );
		}

		return sb.toString();
	}

	default IntervalChromatic getInterval(DiatonicDegree from, IntervalDiatonic id) {
		int idInt = id.ordinal();
		DiatonicDegree toDiatonicDegree = DiatonicDegree.add(from, id);
		DiatonicAlt toDiatonicAlt = get(toDiatonicDegree);
		DiatonicAlt fromDiatonicAlt = get(from);
		Chromatic toChromatic = Chromatic.from(toDiatonicAlt);
		Chromatic fromChromatic = Chromatic.from(fromDiatonicAlt);
		int distSemitones = fromChromatic.distSemitonesTo(toChromatic);
		if ( distSemitones < 0 )
			distSemitones += IntervalChromatic.PERFECT_OCTAVE.getSemitones();
		distSemitones += idInt / IntervalChromatic.PERFECT_OCTAVE.getSemitones();
		return IntervalChromatic.from( id, distSemitones );
	}

	default HarmonicFunction getFunction(PitchChromaticChord c) {
		HarmonicFunction hf = getFunction( c, true );
		if ( hf == null )
			hf = getFunction( c, false );
		return hf;
	}

	HarmonicFunction getFunction(PitchChromaticChord c, boolean rename);

	public void showChromaticChordFunction();

	public Chromatic getEnharmonic(Chromatic chromatic) throws TonalityException;

	public static Tonality of(DiatonicAlt c, Scale s) {
		Tonality t = TonalityEnum.of(c, s);
		if (t == null)
			t = new CustomTonality(c, s);
		return t;
	}

	public static Tonality of(Chromatic chromatic, Scale s) {
		return of (chromatic, s);
	}
	
	public static Tonality of(Tonality t) {
		return of(t.getRoot(), t.getScale());
	}
}
