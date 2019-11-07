package es.danisales.datune.tonality;

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
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

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

	private final DiatonicAlt root;
	private final Scale	scale;

	/** Temp */
	private final List<DiatonicAlt>	notes;

	static @Nullable Tonality of(@NonNull DiatonicAlt diatonicAlt, @NonNull Scale scale) {
		Objects.requireNonNull(diatonicAlt);
		Objects.requireNonNull(scale);

		for (TonalityEnum tonalityEnum : values())
			if (tonalityEnum.getScale().equals(scale) && diatonicAlt.equals(tonalityEnum.getRoot()))
				return tonalityEnum;

		return null;
	}

	public static List<TonalityEnum> getFromChord(PitchChromaticChord c) {
		return getFromChord( false, c );
	}

	public static List<TonalityEnum> getFromChord(boolean outScale, PitchChromaticChord c) {
		List<TonalityEnum> out = new ArrayList<>();
		for ( TonalityEnum t : TonalityEnum.values() ) {
			if ( t.has( outScale, c ) )
				out.add( t );
		}

		return out;
	}

	public static List<Tonality> getFromChords(boolean outScale, @NonNull List<ChromaticChordMidi> chords) {
		checkArgument(chords.size() > 0);
		List<Tonality> candidates = new ArrayList<>();

		boolean first = true;
		for ( ChromaticChordMidi chord : chords ) {
			if ( chord.isEmpty() )
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
					candidates = new ArrayList<>();

					for ( DiatonicChordMidi c : possibleChords ) {
						for ( Tonality t : candidatesPrev )
							if ( ( c.metaTonality.equals( t )
									|| c.getTonality().isIntercambioModalOf( t ) )
									&& !candidates.contains( t ) )
								candidates.add( t );
					}
				}

				if ( candidates.isEmpty() ) {
					chordCopy = chordCopy.subList( 0, chordCopy.size() - 1 );
				}
			} while ( candidates.isEmpty() && !chordCopy.isEmpty() );
		}

		return candidates;
	}

	TonalityEnum(DiatonicAlt noteBase, Scale scale) {
		this.root = noteBase;
		this.scale = scale;

		notes = Collections.unmodifiableList( Tonality.getNotesFrom(noteBase, scale) );
	}

	@Override
	public @NonNull Set<ChromaticChord> getAllChords() {
		Set<ChromaticChord> ret = new HashSet<>();

		ret.addAll( getScaleChords() );
		ret.addAll( getOutScaleChords() );
		ret.addAll( getBorrowedChords() );

		return ret;
	}

	@Override
	public @NonNull Set<ChromaticChord> getBorrowedChords() {
		return null;
	}

	@Override
	public @NonNull Set<ChromaticChord> getOutScaleChords() {
		return null;
	}

	@Override
	public @NonNull Set<ChromaticChord> getScaleChords() {
		return null;
	}

	public boolean has(Chromatic note) {
		return getDegreeFrom( note ) != null;
	}

	public @NonNull Scale getScale() {
		return scale;
	}

	public @NonNull DiatonicAlt getRoot() {
		return root;
	}

	public String toString() {
		return ChromaticMidi.literal(root, this) + " " +
				scale;
	}

	public HarmonicFunction getFunction(PitchChromaticChord c, boolean rename) {
// todo
		return null;
	}

	public DiatonicAlt getDiatonicAltFrom(Chromatic chromatic) throws TonalityException {
		// todo
		return null;
	}

	@Override
	public @NonNull List<DiatonicAlt> getNotes() {
		return notes;
	}
}
