package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.log.string.Logging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public enum TonalityEnum implements Tonality {
	C( Chromatic.C, ScaleEnum.MAJOR ),
	D( Chromatic.D, ScaleEnum.MAJOR ),
	E( Chromatic.E, ScaleEnum.MAJOR ),
	F( Chromatic.F, ScaleEnum.MAJOR ),
	G( Chromatic.G, ScaleEnum.MAJOR ),
	A( Chromatic.A, ScaleEnum.MAJOR ),
	B( Chromatic.B, ScaleEnum.MAJOR ),
	Db( Chromatic.Db, ScaleEnum.MAJOR ),
	Eb( Chromatic.Eb, ScaleEnum.MAJOR ),
	FF( Chromatic.FF, ScaleEnum.MAJOR ),
	Gb( Chromatic.Gb, ScaleEnum.MAJOR ),
	Ab( Chromatic.Ab, ScaleEnum.MAJOR ),
	Bb( Chromatic.Bb, ScaleEnum.MAJOR ),

	Cm( Chromatic.C, ScaleEnum.MINOR ),
	Dm( Chromatic.D, ScaleEnum.MINOR ),
	Em( Chromatic.E, ScaleEnum.MINOR ),
	Fm( Chromatic.F, ScaleEnum.MINOR ),
	Gm( Chromatic.G, ScaleEnum.MINOR ),
	Am( Chromatic.A, ScaleEnum.MINOR ),
	Bm( Chromatic.B, ScaleEnum.MINOR ),
	CCm( Chromatic.CC, ScaleEnum.MINOR ),
	DDm( Chromatic.DD, ScaleEnum.MINOR ),
	Ebm( Chromatic.Eb, ScaleEnum.MINOR ),
	FFm( Chromatic.FF, ScaleEnum.MINOR ),
	GGm( Chromatic.GG, ScaleEnum.MINOR ),
	Bbm( Chromatic.Bb, ScaleEnum.MINOR );

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

	private final Chromatic				root;
	private final Scale					scale;

	/** Temp */
	private final Chromatic[]				notes;

	private TonalityEnum(Chromatic noteBase, Scale scale) {
		this.root = noteBase;
		this.scale = scale;

		notes = updateChromaticsFromBase();

		if ( notes == null )
			throw new RuntimeException(
				"Error inicializando las notas de la tonalidad con note base " + this.root
				+ " y escala " + this.scale
					);
	}

	public ArrayList<CustomChromaticChord> getAllChords() {
		ArrayList<CustomChromaticChord> ret = new ArrayList<>();

		ret.addAll( getScaleChords() );
		ret.addAll( getOutScaleChords() );
		ret.addAll( getBorrowedChords() );

		return ret;
	}

	public Set<CustomChromaticChord> getBorrowedChords() {
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

	public boolean has(boolean outScale, PitchChromaticChord c) {
		assert c != null;

		boolean hasNotes = has( c );

		if ( hasNotes )
			return true;
		else if ( outScale ) {
			for ( ChromaticFunction f : ChromaticFunction.ALL ) {
				try {
					PitchChromaticChord c2 = new DiatonicChordMidi( f, this );
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

	public boolean equals(TonalityEnum t) {
		return sameRoot( t ) && sameScale( t ) && sameNotes( t );
	}

	public boolean sameRoot(TonalityEnum t) {
		assert t != null;
		assert root != null;
		assert t.root != null;
		return root.equals( t.root );
	}

	public boolean sameRootEnharmonics(TonalityEnum t) {
		return root.equalsEnharmonic( t.root );
	}

	public boolean sameScale(TonalityEnum t) {
		return scale.equals( t.scale );
	}

	public boolean sameNotes(TonalityEnum t) {
		return Arrays.equals( notes, t.notes );
	}

	@Override
	public PitchChromaticChord get(DiatonicFunction f) {
		PitchChromaticChord ret = GetDiatonicFunctionMajor.get(this, f);
		if (ret == null)
			ret = GetDiatonicFunctionMinor.get(this, f);
		return ret;
	}

	@Override
	public CustomChromaticChord get(ChromaticFunction f) {


		return null;
	}

	public PitchChromaticChord<Chromatic> get(CustomDiatonicChord dc, DiatonicFunction df) {
		return dc.toChromatic( this, df );
	}

	public PitchChromaticChord[] getTriadChords() {
		NoDiatonicScaleException.check( scale );
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

	public PitchChromaticChord[] getSeventhChords() {
		NoDiatonicScaleException.check( scale );
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

	private Chromatic[] updateChromaticsFromBase() {
		Chromatic note = root;
		int len = length();
		Chromatic[] notes = new Chromatic[len];
		notes[0] = root;
		Diatonic noteBaseDiatonic = Diatonic.get( notes[0] );
		int alt = 0;
		for ( int i = 1; i < len; i++ ) {
			note = note.add( scale.get( i - 1 ) );
			try {
				noteBaseDiatonic = noteBaseDiatonic.shift( 1 );
				notes[i] = noteBaseDiatonic.toChromatic( note );
				alt += notes[i].getAlterations();
			} catch ( Exception e ) {
				// e.printStackTrace();
				return null;
			}
		}

		return notes;
	}

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

	public Chromatic get(DiatonicDegree n) {
		assert n != null;
		return get( n.val() );
	}

	public TonalityEnum getRelativeMinor() {
		TonalityEnum[] rel = getModes();
		for ( TonalityEnum s : rel )
			if ( s.getScale().equals( ScaleEnum.MINOR ) )
				return s;

		return null;
	}

	public TonalityEnum getRelativeMajor() {
		TonalityEnum[] rel = getModes();
		for ( TonalityEnum s : rel )
			if ( s.getScale().equals( ScaleEnum.MAJOR ) )
				return s;

		return null;
	}

	public boolean isModeOf(TonalityEnum tonality) {
		if ( length() != tonality.length() )
			return false;

		for ( Chromatic note : notes )
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
		for ( Chromatic c : notes )
			ret += c.getAlterations();

		return ret;
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

	public DiatonicDegree getDegree(PitchChromaticSingle note) {
		assert note != null : "No se ha especificado nota";
		return getDegree( note, true );
	}

	public DiatonicDegree getDegree(PitchChromaticSingle note, boolean enharmonic) {
		assert note != null : "No se ha especificado nota";

		for ( int i = 0; i < length(); i++ )
			if ( !enharmonic && get( i ).equals( note.getChromatic() )
					|| enharmonic && get( i ).val() == note.getChromatic().val() )
				return DiatonicDegree.get( i );

		return null;
	}
	/*
	 * public Integer getDegree(int note) { for ( int i = 0; i < length(); i++ ) if
	 * ( get( i ).val() == note ) return i;
	 * 
	 * return null; }
	 */

	public boolean has(PitchChromaticSingle note) {
		return getDegree( note ) != null;
	}

	public <N extends PitchChromaticSingle> boolean has(PitchChromaticChord<N> notes) {
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

	public TonalityEnum getRelativeScaleDiatonic(IntervalDiatonic pos) {
		return null;
	}

	public TonalityEnum getRelativeScaleDiatonic(DiatonicDegree pos) {
		return getRelativeScaleDiatonic( IntervalDiatonic.get( pos ) );
	}

	public TonalityEnum getRelativeScaleChromatic(int pos) {
		return null;
	}

	public Scale getScale() {
		return scale;
	}

	public Chromatic getRoot() {
		return root;
	}

	public TonalityEnum minor() {
		TonalityEnum s = TonalityEnum.of( root, ScaleEnum.MINOR );
		return s;
	}

	public TonalityEnum major() {
		TonalityEnum s = TonalityEnum.of( root, ScaleEnum.MAJOR );
		return s;
	}

	public TonalityEnum lydian() {
		TonalityEnum s = TonalityEnum.of( root, ScaleEnum.LYDIAN );
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

	public Set<CustomChromaticChord> getScaleChords() {
		return null;
	}

	public Set<CustomChromaticChord> getOutScaleChords() {
		return null;
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

	public IntervalChromatic getInterval(DiatonicDegree d2, IntervalDiatonic id) {
		int idInt = id.val();

		int n = get( d2.val() + idInt ).val() - get( d2 ).val();
		if ( n < 0 )
			n += IntervalChromatic.PERFECT_OCTAVE.val();
		n += idInt / IntervalChromatic.PERFECT_OCTAVE.val();
		return IntervalChromatic.get( id, n );
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

	public Chromatic getEnharmonic(Chromatic chromatic) throws TonalityException {
		return null;
	}

	@Override
	public Chromatic[] getNotes() {
		return notes;
	}

	static TonalityEnum of(Chromatic c2, Scale s) {
		return null;
	}

	@Override
	public boolean updateChromaticsFromBase(Chromatic noteBase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showChromaticChordFunction() {
		// TODO Auto-generated method stub

	}
}
