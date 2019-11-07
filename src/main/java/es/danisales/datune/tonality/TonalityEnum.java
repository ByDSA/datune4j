package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.log.string.Logging;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public enum TonalityEnum implements Tonality {
	C( DiatonicAlt.C, Scale.MAJOR ),
	D( DiatonicAlt.D, Scale.MAJOR ),
	E( DiatonicAlt.E, Scale.MAJOR ),
	F( DiatonicAlt.F, Scale.MAJOR ),
	G( DiatonicAlt.G, Scale.MAJOR ),
	A( DiatonicAlt.A, Scale.MAJOR ),
	B( DiatonicAlt.B, Scale.MAJOR ),
	Db( DiatonicAlt.Db, Scale.MAJOR ),
	Eb( DiatonicAlt.Eb, Scale.MAJOR ),
	FF( DiatonicAlt.FF, Scale.MAJOR ),
	Gb( DiatonicAlt.Gb, Scale.MAJOR ),
	Ab( DiatonicAlt.Ab, Scale.MAJOR ),
	Bb( DiatonicAlt.Bb, Scale.MAJOR ),

	Cm( DiatonicAlt.C, Scale.MINOR ),
	Dm( DiatonicAlt.D, Scale.MINOR ),
	Em( DiatonicAlt.E, Scale.MINOR ),
	Fm( DiatonicAlt.F, Scale.MINOR ),
	Gm( DiatonicAlt.G, Scale.MINOR ),
	Am( DiatonicAlt.A, Scale.MINOR ),
	Bm( DiatonicAlt.B, Scale.MINOR ),
	CCm( DiatonicAlt.CC, Scale.MINOR ),
	DDm( DiatonicAlt.DD, Scale.MINOR ),
	Ebm( DiatonicAlt.Eb, Scale.MINOR ),
	FFm( DiatonicAlt.FF, Scale.MINOR ),
	GGm( DiatonicAlt.GG, Scale.MINOR ),
	Bbm( DiatonicAlt.Bb, Scale.MINOR );

	public static final TonalityEnum[]	MAJOR_TONALITIES	= new TonalityEnum[] {
		C,
		Db,
		D,
		Eb,
		E,
		F,
		FF,
		G,
		Ab,
		A,
		Bb,
		B
	};

	public static final TonalityEnum[]	MINOR_TONALITIES	= new TonalityEnum[] {
		Cm,
		CCm,
		Dm,
		DDm,
		Em,
		Fm,
		FFm,
		Gm,
		GGm,
		Am,
		Bbm,
		Bm
	};

	private final DiatonicAlt				root;
	private final Scale					scale;

	/** Temp */
	private final DiatonicAlt[]				notes;

	private TonalityEnum(DiatonicAlt noteBase, Scale scale) {
		this.root = noteBase;
		this.scale = scale;

		notes = updateChromaticsFromBase();

		if ( notes == null )
			throw new RuntimeException(
				"Error inicializando las notas de la tonalidad con note base " + this.root
				+ " y escala " + this.scale
					);
	}

	@Override
	public List<ChromaticChord> getAllChords() {
		List<ChromaticChord> ret = new ArrayList<>();

		ret.addAll( getScaleChords() );
		ret.addAll( getOutScaleChords() );
		ret.addAll( getBorrowedChords() );

		return ret;
	}

	@Override
	public Set<ChromaticChord> getBorrowedChords() {
		return null;
	}

	public static ArrayList<TonalityEnum> getFromChord(PitchChromaticChord c) {
		return getFromChord( false, c );
	}

	public static ArrayList<TonalityEnum> getFromChord(boolean outScale, PitchChromaticChord c) {
		ArrayList<TonalityEnum> out = new ArrayList<>();
		for ( TonalityEnum t : TonalityEnum.values() ) {
			if ( t.has( outScale, c ) )
				out.add( t );
		}

		return out;
	}

	public boolean has(boolean outScale, @NonNull PitchChromaticChord c) {
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

	private static boolean contains(ArrayList<TonalityEnum> c, TonalityEnum t) {
		for ( TonalityEnum i : c )
			if ( i.equals( t ) )
				return true;
		return false;
	}

	public boolean isMajorOrMinor() {
		if ( scale.equals( Scale.MAJOR ) || scale.equals( Scale.MINOR ) )
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

	public boolean equals(TonalityEnum t) {
		return sameRoot( t ) && sameScale( t ) && sameNotes( t );
	}

	public boolean sameRoot(TonalityEnum t) {
		assert t != null;
		assert root != null;
		assert t.root != null;
		return root.equals( t.root );
	}

	public boolean sameScale(TonalityEnum t) {
		return scale.equals( t.scale );
	}

	public boolean sameNotes(TonalityEnum t) {
		return Arrays.equals( notes, t.notes );
	}

	public PitchChromaticChord<Chromatic> getChordFrom(CustomDiatonicChord dc, DiatonicFunction df) {
		return dc.toChromatic( this, df );
	}

	@Override
	public boolean updateChromaticsFromBase(DiatonicAlt noteBase) {
		// TODO
		return false;
	}

	protected DiatonicAlt[] updateChromaticsFromBase() {
		DiatonicAlt diatonicAlt = root;
		int len = length();
		DiatonicAlt[] notes = new DiatonicAlt[len];
		notes[0] = root;
		Diatonic noteBaseDiatonic = Diatonic.from( notes[0] );
		int alt = 0;
		for ( int i = 1; i < len; i++ ) {
			DiatonicDegree diatonicDegree = DiatonicDegree.values()[i-1];
			ScaleDistance distanceScale = scale.get( diatonicDegree );
			int semitones = distanceScale.getSemitones();
			diatonicAlt = diatonicAlt.addSemi( semitones );
			try {
				noteBaseDiatonic = noteBaseDiatonic.shift( 1 );
				Chromatic chromatic = Chromatic.from(diatonicAlt);
				notes[i] = ChromaticAdapter.from(noteBaseDiatonic, chromatic );
				alt += notes[i].getAlterations();
			} catch ( Exception e ) {
				// e.printStackTrace();
				return null;
			}
		}

		return notes;
	}

	public TonalityEnum getRelativeMinor() {
		TonalityEnum[] rel = getModes();
		for ( TonalityEnum s : rel )
			if ( s.getScale().equals( Scale.MINOR ) )
				return s;

		return null;
	}

	public TonalityEnum getRelativeMajor() {
		TonalityEnum[] rel = getModes();
		for ( TonalityEnum s : rel )
			if ( s.getScale().equals( Scale.MAJOR ) )
				return s;

		return null;
	}

	public boolean isModeOf(TonalityEnum tonality) {
		if ( length() != tonality.length() )
			return false;

		for ( DiatonicAlt note : notes )
			if ( !tonality.has( note ) ) {
				return false;
			}

		return true;
	}

	public boolean isIntercambioModalOf(TonalityEnum t) {
		return scale.isDiatonic() && this.root == t.root && !scale.equals( t.scale );
	}

	public TonalityEnum[] getModes() {
		return null;
	}

	public Integer getAlteration() {
		assert notes != null;
		int ret = 0;
		for ( DiatonicAlt c : notes )
			ret += c.getAlterations();

		return ret;
	}

	public static Scale notes2scale(DiatonicAlt[] notes) {
		int[] ton = new int[notes.length];
		int sum = 0;
		for ( int i = 0; i < notes.length - 1; i++ ) {
			DiatonicAlt current = notes[i];
			Chromatic currentChromatic = Chromatic.from(current);
			DiatonicAlt next = notes[i + 1];
			Chromatic nextChromatic = Chromatic.from(next);
			ton[i] = currentChromatic.distSemitonesTo(nextChromatic);
			while ( ton[i] < 0 )
				ton[i] += 12;
			sum += ton[i];
			// assert ton[i] != 0; // TODO
		}
		int dif = 12 - sum;
		assert dif > 0;
		ton[notes.length - 1] = dif;

		return Scale.fromIntegers( ton );
	}

	public DiatonicDegree getDegreeFrom(PitchChromaticSingle note) {
		assert note != null : "No se ha especificado nota";
		return getDegreeFrom( note, true );
	}

	public @Nullable DiatonicDegree getDegreeFrom(@NonNull PitchChromaticSingle note, boolean enharmonic) {
		for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
			Chromatic chromatic = ChromaticAdapter.from(note);
			if (equalEnharmonic(Chromatic.from(getNote(diatonicDegree)), chromatic, enharmonic))
				return diatonicDegree;
		}

		return null;
	}

	private boolean equalEnharmonic(Chromatic chromatic1, Chromatic chromatic2, boolean enharmonic) {
		return !enharmonic && chromatic1.equals(chromatic2)
				|| enharmonic && chromatic1.compareEnharmonicTo(chromatic2) == 0;
	}
	/*
	 * public Integer getDegreeFrom(int note) { for ( int i = 0; i < size(); i++ ) if
	 * ( calculateFrom( i ).intValue() == note ) return i;
	 * 
	 * return null; }
	 */

	public boolean has(PitchChromaticSingle note) {
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

	public TonalityEnum getRelativeScaleChromatic(int pos) {
		return null;
	}

	public Scale getScale() {
		return scale;
	}

	public DiatonicAlt getRoot() {
		return root;
	}

	public TonalityEnum minor() {
		TonalityEnum s = TonalityEnum.of( root, Scale.MINOR );
		return s;
	}

	public TonalityEnum major() {
		TonalityEnum s = TonalityEnum.of( root, Scale.MAJOR );
		return s;
	}

	public TonalityEnum lydian() {
		TonalityEnum s = TonalityEnum.of( root, Scale.LYDIAN );
		return s;
	}

	public ArrayList<DiatonicChordMidi[]> commonChords(TonalityEnum s) {
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

	@Override
	public Set<ChromaticChord> getScaleChords() {
		return null;
	}

	@Override
	public Set<ChromaticChord> getOutScaleChords() {
		return null;
	}

	public String toString() {
		return ChromaticMidi.literal(root, this) + " " +
				scale;
	}

	public void showNotes() {
		Logging.log( this + ": " + notesToString() );
	}

	public String notesToString() {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < length(); i++ ) {
			sb.append(ChromaticMidi.literal(getNote(i), this)).append(" ");
		}

		return sb.toString();
	}

	public HarmonicFunction getFunction(PitchChromaticChord c) {
		HarmonicFunction hf = getFunction( c, true );
		if ( hf == null )
			hf = getFunction( c, false );
		return hf;
	}

	public HarmonicFunction getFunction(PitchChromaticChord c, boolean rename) {

		return null;
	}

	public DiatonicAlt getChordFrom(Chromatic chromatic) throws TonalityException {
		return null;
	}

	@Override
	public DiatonicAlt[] getNotes() {
		return notes;
	}

	static TonalityEnum of(DiatonicAlt c2, Scale s) {
		return null;
	}

	@Override
	public void showChromaticChordFunction() {
		// TODO Auto-generated method stub

	}
}
