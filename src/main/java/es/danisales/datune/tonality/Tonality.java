package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public interface Tonality extends Cloneable {
	static @NonNull List<Tonality> all() {
		return TonalityRetrieval.all();
	}

	static @NonNull List<Tonality> fromChord(PitchChromaticChord c) {
		return fromChord( false, c );
	}

	static @NonNull List<Tonality> fromChord(boolean outScale, PitchChromaticChord c) {
		return TonalityRetrieval.fromChord(outScale, c);
	}

	static Tonality fromDiatonicChord(@NonNull DiatonicChordMidi c, @NonNull Tonality base) throws TonalityException {
		return TonalityRetrieval.fromDiatonicChord(c, base);
	}

	static Tonality of(DiatonicAlt diatonicAlt, Scale scale) {
		Tonality t = TonalityEnum.of(diatonicAlt, scale);
		if (t == null)
			t = new CustomTonality(diatonicAlt, scale);
		return t;
	}

	static Tonality from(Chromatic chromatic, Scale s) {
		DiatonicAlt diatonicAlt = DiatonicAlt.from(chromatic);
		return of (diatonicAlt, s);
	}


	static @NonNull List<DiatonicAlt> getNotesFrom(@NonNull final DiatonicAlt noteBase, @NonNull final Scale scale) {
		List<DiatonicAlt> notes = new ArrayList<>();
		boolean first = true;
		Chromatic chromatic = Chromatic.from(noteBase);
		Diatonic diatonic = noteBase.getDiatonic();
		for ( ScaleDistance step : scale ) {
			if (first) {
				notes.add(noteBase);
				first = false;
			} else {
				if (noteBase.getDiatonic() == diatonic)
					break;
				DiatonicAlt newDiatonicAlt = DiatonicAlt.from(chromatic, diatonic);
				notes.add(newDiatonicAlt);
			}

			chromatic = chromatic.addSemi(step);
			diatonic = diatonic.next();
		}

		return notes;
	}

	static Tonality of(Tonality t) {
		return of(t.getRoot(), t.getScale());
	}

	default Tonality getRelativeMinor() {
		return TonalityChordRetrieval.getRelativeMinorFrom(this);
	}

	default Tonality getRelativeMajor() {
		return TonalityChordRetrieval.getRelativeMajorFrom(this);
	}

	default boolean isMajorOrMinor() {
		return ( getScale().equals( Scale.MAJOR ) || getScale().equals( Scale.MINOR ) );
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
		return getNotes().equals( t.getNotes() );
	}

	default int size() {
		return getScale().size();
	}

	default DiatonicAlt getNote(DiatonicDegree diatonicDegree) {
		int i = diatonicDegree.ordinal();
		return getNotes().get(i);
	}

	default boolean isModeOf(Tonality tonality) {
		if ( size() != tonality.size() )
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
		Tonality[] ret = new Tonality[size()];

		int j = 0;
		for ( Scale s : getScale().getAllModes() )
			for ( Chromatic chromatic : Chromatic.values() ) {
				Tonality t = Tonality.from( chromatic, s );
				if ( isModeOf( t ) )
					ret[j++] = t;
			}

		return ret;
	}

	default Integer getAlteration() {
		Objects.requireNonNull(getNotes());

		int ret = 0;
		for ( DiatonicAlt c : getNotes() )
			ret += c.getAlterations();

		return ret;
	}

	default List<Tonality> getModesSameRoot() {
		List<Tonality> ret = new ArrayList<>();

		for ( Scale s : getScale().getAllModes() )
			for ( Chromatic chromatic : Chromatic.values() ) {
				Tonality t = Tonality.from( chromatic, s );
				if ( isModeOf( t ) ) {
					if (t instanceof CustomTonality)
						((CustomTonality)t).minimizeAlterations();
					ret.add( t );
				}
			}

		return ret;
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
			DiatonicAlt degreeDiatonicAlt = getNote(diatonicDegree);
			Chromatic degreeChromatic = Chromatic.from(degreeDiatonicAlt);
			if (degreeChromatic == chromatic)
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

	default Tonality getMinor() {
		return Tonality.of( getRoot(), Scale.MINOR );
	}

	default Tonality getMajor() {
		return Tonality.of( getRoot(), Scale.MAJOR );
	}

	default Tonality getLydian() {
		return Tonality.of( getRoot(), Scale.LYDIAN );
	}

	default List<DiatonicChordMidi[]> commonChords(Tonality s) {
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

	default boolean has(ChromaticChord from) {
		return false; // todo
	}

	@NonNull Set<ChromaticChord> getAllChords();

	@NonNull Set<ChromaticChord> getBorrowedChords();

	default boolean has(boolean outScale, @NonNull PitchChromaticChord c) {
		Objects.requireNonNull(c);

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

	@NonNull Scale getScale();

	@NonNull DiatonicAlt getRoot();

	@NonNull List<DiatonicAlt> getNotes();

	@NonNull Set<ChromaticChord> getScaleChords();

	@NonNull Set<ChromaticChord> getOutScaleChords();

	@Nullable HarmonicFunction getFunction(PitchChromaticChord c, boolean rename);

	DiatonicAlt getDiatonicAltFrom(Chromatic chromatic) throws TonalityException;
}
