package tonality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import Log.String.Logging;
import chromaticchord.CustomChromaticChord;
import diatonic.ChromaticFunction;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.HarmonicFunction;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import pitch.Chromatic;
import pitch.ChromaticMidi;
import pitch.Diatonic;
import pitch.CustomDiatonicChord;
import pitch.DiatonicChordMidi;
import pitch.PitchChromaticChord;
import pitch.PitchChromaticableChord;
import pitch.PitchChromaticableSingle;

public interface Tonality extends Cloneable {
	public ArrayList<CustomChromaticChord> getAllChords();

	public Set<CustomChromaticChord> getBorrowedChords();

	public static ArrayList<Tonality> getFromChord(PitchChromaticableChord c) {
		return getFromChord( false, c );
	}

	public static ArrayList<Tonality> getFromChord(boolean outScale, PitchChromaticableChord c) {
		ArrayList<Tonality> out = new ArrayList<>();
		for ( Tonality t : Tonality.all() ) {
			if ( t.has( outScale, c ) )
				out.add( t );
		}

		return out;
	}

	public boolean has(boolean outScale, PitchChromaticableChord c);

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

	default boolean sameRootEnharmonics(Tonality t) {
		return getRoot().equalsEnharmonic( t.getRoot() );
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

	boolean updateChromaticsFromBase(Chromatic noteBase);

	default int length() {
		return getScale().length();
	}

	default Chromatic get(int pos) {
		int i = getScale().trim( pos );
		Chromatic note = getNotes()[i];

		return note;
	}

	default Chromatic get(IntervalDiatonic n) {
		return get( n.val() );
	}

	default Chromatic get(Degree n) {
		assert n != null;
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

		for ( Chromatic note : getNotes() )
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
			for ( int i = 0; i < 12; i++ ) {
				Tonality t = Tonality.of( i, s );
				if ( isModeOf( t ) )
					ret[j++] = t;
			}

		return ret;
	}

	default List<Tonality> getModesSameRoot() {
		List<Tonality> ret = new ArrayList<>();

		for ( Scale s : getScale().getAllModes() )
			for ( int i = 0; i < 12; i++ ) {
				Tonality t = Tonality.of( i, s );
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
			for ( int i = 0; i < 12; i++ )
				ret.add( Tonality.of( i, mode ) );

		return ret;
	}

	default Integer getAlteration() {
		assert getNotes() != null;
		int ret = 0;
		for ( Chromatic c : getNotes() )
			ret += c.getAlterations();

		return ret;
	}

	public static Tonality createFromChord(DiatonicChordMidi c, Tonality base) throws TonalityException {
		assert base != null;
		if ( base.length() != 7 )
			throw new RuntimeException( "No tiene 7 notas la escala" );

		Chromatic[] notesChord = new Chromatic[c.size()];
		for ( int i = 0; i < c.size(); i++ )
			notesChord[i] = c.get( i ).toChromaticMidi().getChromatic();

		int posChordCorrector = 7 - c.get( 0 ).getDegree().val();

		// Integer posBaseCorrector = base.getDegree(notesChord[0]);
		Integer posBaseCorrector = ( Diatonic.get( notesChord[0] ).val()
				- Diatonic.get( base.getRoot() ).val() + 7 ) % 7;
		if ( posBaseCorrector == null )
			throw new TonalityException( c.get( 0 ).toChromaticMidi(), base );

		Chromatic[] tonalityNotes = new Chromatic[7];
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

	default Degree getDegree(PitchChromaticableSingle note) {
		assert note != null : "No se ha especificado nota";
		return getDegree( note, true );
	}

	default Degree getDegree(PitchChromaticableSingle note, boolean enharmonic) {
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

	default boolean has(PitchChromaticableSingle note) {
		return getDegree( note ) != null;
	}

	default <N extends PitchChromaticableSingle> boolean has(PitchChromaticableChord<N, ?> notes) {
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

	default Tonality getRelativeScaleDiatonic(IntervalDiatonic pos) {
		return Tonality.of( get( pos ), getScale() );
	}

	default Tonality getRelativeScaleDiatonic(Degree pos) {
		return getRelativeScaleDiatonic( IntervalDiatonic.get( pos ) );
	}

	default Tonality getRelativeScaleChromatic(int pos) {
		return Tonality.of( getRoot().add( pos ), getScale() );
	}

	public Scale getScale();

	public Chromatic getRoot();

	public Chromatic[] getNotes();

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

	public Set<CustomChromaticChord> getScaleChords();

	public Set<CustomChromaticChord> getOutScaleChords();

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

	default IntervalChromatic getInterval(Degree d2, IntervalDiatonic id) {
		int idInt = id.val();

		int n = get( d2.val() + idInt ).val() - get( d2 ).val();
		if ( n < 0 )
			n += IntervalChromatic.PERFECT_OCTAVE.val();
		n += idInt / IntervalChromatic.PERFECT_OCTAVE.val();
		return IntervalChromatic.get( id, n );
	}

	default HarmonicFunction getFunction(PitchChromaticChord c) {
		HarmonicFunction hf = getFunction( c, true );
		if ( hf == null )
			hf = getFunction( c, false );
		return hf;
	}

	public HarmonicFunction getFunction(PitchChromaticChord c, boolean rename);

	public void showChromaticChordFunction();

	public Chromatic getEnharmonic(Chromatic chromatic) throws TonalityException;

	public static Tonality of(Chromatic c, Scale s) {
		Tonality t = TonalityEnum.of(c, s);
		if (t == null)
			t = new CustomTonality(c, s);
		return t;
	}

	public static Tonality of(int i, Scale s) {
		return of (Chromatic.get( i ), s);
	}
	
	public static Tonality of(Tonality t) {
		return of(t.getRoot(), t.getScale());
	}
}
