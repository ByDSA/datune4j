package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.log.string.Logging;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

public interface Tonality extends Cloneable {
	List<ChromaticChord> getAllChords();

	Set<ChromaticChord> getBorrowedChords();

	static List<Tonality> getFromChord(PitchChromaticChord c) {
		return getFromChord( false, c );
	}

	static List<Tonality> getFromChord(boolean outScale, PitchChromaticChord c) {
		List<Tonality> out = new ArrayList<>();
		for ( Tonality t : Tonality.all() ) {
			if ( t.has( outScale, c ) )
				out.add( t );
		}

		return out;
	}

	default Tonality getRelativeMinor() {
		return TonalityChordRetrieval.getRelativeMinorFrom(this);
	}

	default Tonality getRelativeMajor() {
		return TonalityChordRetrieval.getRelativeMajorFrom(this);
	}

	boolean has(boolean outScale, PitchChromaticChord c);

	default boolean isMajorOrMinor() {
		return ( getScale().equals( ScaleEnum.MAJOR ) || getScale().equals( ScaleEnum.MINOR ) );
	}

	default boolean equals(Tonality t) {
		return hasSameRootAs( t ) && hasSameScaleAs( t ) && hasSameNotesAs( t );
	}

	default boolean hasSameRootAs(@NonNull Tonality t) {
		Objects.requireNonNull(t);
		Objects.requireNonNull(getRoot());
		Objects.requireNonNull(t.getRoot());

		return getRoot().equals( t.getRoot() );
	}

	default boolean hasSameScaleAs(Tonality t) {
		return getScale().equals( t.getScale() );
	}

	default boolean hasSameNotesAs(Tonality t) {
		return Arrays.equals( getNotes(), t.getNotes() );
	}

	@Deprecated
	default PitchChromaticChord getChordFrom(CustomDiatonicChord dc, DiatonicFunction df) {
		return dc.toChromatic( this, df );
	}

	boolean updateChromaticsFromBase(DiatonicAlt noteBase);

	default int length() {
		return getScale().size();
	}

	default DiatonicAlt getNote(int pos) {
		int i = pos % getScale().size();
		return getNotes()[i];
	}

	default DiatonicAlt getNote(DiatonicDegree diatonicDegree) {
		return getNote(diatonicDegree.ordinal());
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

	static List<Tonality> all() {
		List<Tonality> ret = new ArrayList<>();
		for ( Scale mode : Scale.ALL )
			for ( Chromatic chromatic : Chromatic.values() )
				ret.add( Tonality.of( chromatic, mode ) );

		return ret;
	}

	default Integer getAlteration() {
		Objects.requireNonNull(getNotes());

		int ret = 0;
		for ( DiatonicAlt c : getNotes() )
			ret += c.getAlterations();

		return ret;
	}

	static Tonality createFromChord(DiatonicChordMidi c, Tonality base) throws TonalityException {
		assert base != null;
		if ( base.length() != 7 )
			throw new RuntimeException( "No tiene 7 notas la escala" );

		DiatonicAlt[] notesChord = new DiatonicAlt[c.size()];
		for ( int i = 0; i < c.size(); i++ )
			notesChord[i] = c.get( i ).getDiatonicAlt();

		int posChordCorrector = 7 - c.get( 0 ).getDegree().val();

		// Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
		Integer posBaseCorrector = ( Diatonic.from( notesChord[0] ).ordinal()
				- Diatonic.from( base.getRoot() ).ordinal() + 7 ) % 7;
		if ( posBaseCorrector == null ) {
			DiatonicAlt chromatic = c.get(0).getDiatonicAlt();
			throw new TonalityException(chromatic, base);
		}

		DiatonicAlt[] tonalityNotes = new DiatonicAlt[7];
		for ( int i = 0; i < 7; i++ ) {
			int pos = ( posBaseCorrector + i ) % 7;

			boolean notFound = true;
			for ( int j = 0; j < notesChord.length; j++ ) {
				int index = (c.get(j).getDegree().val() + posChordCorrector) % base.getScale().size();
				if (index == i) {
					tonalityNotes[i] = notesChord[j];
					notFound = false;
					break;
				}
			}

			if ( notFound )
				tonalityNotes[i] = base.getNote( pos );
		}

		return Tonality.of( notesChord[0], Scale.fromDiatonicAltList( Arrays.asList(tonalityNotes) ) );
	}

	default @Nullable DiatonicDegree getDegreeFrom(@NonNull DiatonicAlt note) {
		Objects.requireNonNull(note, "No se ha especificado nota");

		for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
			if (getNote(diatonicDegree).equals(note))
				return diatonicDegree;
		}

		return null;
	}

	default @Nullable DiatonicDegree getDegreeFrom(@NonNull Chromatic chromatic) {
		Objects.requireNonNull(chromatic, "No se ha especificado nota");
		for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
			if (Chromatic.from( getNote(diatonicDegree) ) == chromatic)
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

	default boolean has(DiatonicAlt note) {
		return getDegreeFrom( note ) != null;
	}

	default boolean hasEnharmonic(Chromatic note) {
		return getDegreeFrom( note ) != null;
	}

	default <N extends DiatonicAlt> boolean has(Iterable<N> notes) {
		for ( N n : notes ) {
			if ( getDegreeFrom( n ) == null )
				return false;
		}

		return true;
	}

	default <N extends Chromatic> boolean hasEnharmonic(Iterable<N> notes) {
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
		return Tonality.of( getNote( pos ), getScale() );
	}

	default Tonality getRelativeScaleChromatic(int pos) {
		ScaleDistance distanceScale = ScaleDistance.from(pos);
		return Tonality.of( getRoot().addSemi( distanceScale.getSemitones() ), getScale() );
	}

	Scale getScale();

	DiatonicAlt getRoot();

	DiatonicAlt[] getNotes();

	default Tonality minor() {
		Tonality s = Tonality.of( getRoot(), Scale.MINOR );
		return s;
	}

	default Tonality major() {
		Tonality s = Tonality.of( getRoot(), Scale.MAJOR );
		return s;
	}

	default Tonality lydian() {
		Tonality s = Tonality.of( getRoot(), Scale.LYDIAN );
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

	Set<ChromaticChord> getScaleChords();

	Set<ChromaticChord> getOutScaleChords();

	default void showNotes() {
		Logging.log( this + ": " + notesToString() );
	}

	default String notesToString() {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < length(); i++ ) {
			sb.append( ChromaticMidi.literal( getNote( i ), this ) + " " );
		}

		return sb.toString();
	}

	default IntervalChromatic getInterval(DiatonicDegree from, IntervalDiatonic id) {
		int idInt = id.ordinal();
		DiatonicDegree toDiatonicDegree = DiatonicDegree.add(from, id);
		DiatonicAlt toDiatonicAlt = getNote(toDiatonicDegree);
		DiatonicAlt fromDiatonicAlt = getNote(from);
		Chromatic toChromatic = Chromatic.from(toDiatonicAlt);
		Chromatic fromChromatic = Chromatic.from(fromDiatonicAlt);
		int distSemitones = fromChromatic.distSemitonesTo(toChromatic);
		if ( distSemitones < 0 )
			distSemitones += IntervalChromatic.PERFECT_OCTAVE.getSemitones();
		distSemitones += idInt / IntervalChromatic.PERFECT_OCTAVE.getSemitones();
		return IntervalChromatic.from( id, distSemitones );
	}

	default @Nullable HarmonicFunction getFunction(PitchChromaticChord c) {
		HarmonicFunction hf = getFunction( c, true );
		if ( hf == null )
			hf = getFunction( c, false );
		return hf;
	}

	@Nullable HarmonicFunction getFunction(PitchChromaticChord c, boolean rename);

	void showChromaticChordFunction();

	DiatonicAlt getChordFrom(Chromatic chromatic) throws TonalityException;

	static Tonality of(DiatonicAlt c, Scale s) {
		Tonality t = TonalityEnum.of(c, s);
		if (t == null)
			t = new CustomTonality(c, s);
		return t;
	}

	static Tonality of(Chromatic chromatic, Scale s) {
		return of (chromatic, s);
	}

	static Tonality of(Tonality t) {
		return of(t.getRoot(), t.getScale());
	}

	default boolean has(ChromaticChord from) {
		return false; // todo
	}
}
