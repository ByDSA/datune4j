package pitch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;

import arrays.ArrayUtils;
import diatonic.ChordNotation;
import diatonic.ChromaticFunction;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.HarmonicFunction;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import diatonic.Quality;
import diatonic.ScaleEnum;
import diatonic.Tonality;
import diatonic.TonalityException;
import midi.Settings;
import midi.Utils;
import midi.Utils.ArrayWrapInteger;

public class ChromaticChord extends Chord<Chromatic, ChromaticChord, Integer>
		implements PitchChromaticChord<Chromatic, ChromaticChord> {
	// Quintas
	public static final ChromaticChord		C5				= new ChromaticChord(
		Chromatic.C, Chromatic.G
	);
	public static final ChromaticChord		CC5				= new ChromaticChord(
		Chromatic.CC, Chromatic.GG
	);
	public static final ChromaticChord		D5				= new ChromaticChord(
		Chromatic.D, Chromatic.A
	);
	public static final ChromaticChord		DD5				= new ChromaticChord(
		Chromatic.DD, Chromatic.AA
	);
	public static final ChromaticChord		E5				= new ChromaticChord(
		Chromatic.E, Chromatic.B
	);
	public static final ChromaticChord		F5				= new ChromaticChord(
		Chromatic.F, Chromatic.C
	);
	public static final ChromaticChord		FF5				= new ChromaticChord(
		Chromatic.FF, Chromatic.CC
	);
	public static final ChromaticChord		G5				= new ChromaticChord(
		Chromatic.G, Chromatic.D
	);
	public static final ChromaticChord		GG5				= new ChromaticChord(
		Chromatic.GG, Chromatic.DD
	);
	public static final ChromaticChord		A5				= new ChromaticChord(
		Chromatic.A, Chromatic.E
	);
	public static final ChromaticChord		AA5				= new ChromaticChord(
		Chromatic.AA, Chromatic.F
	);
	public static final ChromaticChord		B5				= new ChromaticChord(
		Chromatic.B, Chromatic.FF
	);
	public static final ChromaticChord[]	CHORDS_FIFTH	= new ChromaticChord[] {
		ChromaticChord.C5,
		ChromaticChord.CC5,
		ChromaticChord.D5,
		ChromaticChord.DD5,
		ChromaticChord.E5,
		ChromaticChord.F5,
		ChromaticChord.FF5,
		ChromaticChord.G5,
		ChromaticChord.GG5,
		ChromaticChord.A5,
		ChromaticChord.AA5,
		ChromaticChord.B5
	};

	// Mayores
	public static final ChromaticChord		C				= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		CC				= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		D				= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		DD				= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		E				= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		F				= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		FF				= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		G				= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		GG				= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		A				= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		AA				= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		B				= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord[]	CHORDS_MAJOR	= new ChromaticChord[] {
		ChromaticChord.C,
		ChromaticChord.CC,
		ChromaticChord.D,
		ChromaticChord.DD,
		ChromaticChord.E,
		ChromaticChord.F,
		ChromaticChord.FF,
		ChromaticChord.G,
		ChromaticChord.GG,
		ChromaticChord.A,
		ChromaticChord.AA,
		ChromaticChord.B
	};

	// Menores
	public static final ChromaticChord		Cm				= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		CCm				= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		Dm				= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		DDm				= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		Em				= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		Fm				= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		FFm				= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		Gm				= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		GGm				= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		Am				= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		AAm				= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		Bm				= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord[]	CHORDS_MINOR	= new ChromaticChord[] {
		ChromaticChord.Cm,
		ChromaticChord.CCm,
		ChromaticChord.Dm,
		ChromaticChord.DDm,
		ChromaticChord.Em,
		ChromaticChord.Fm,
		ChromaticChord.FFm,
		ChromaticChord.Gm,
		ChromaticChord.GGm,
		ChromaticChord.Am,
		ChromaticChord.AAm,
		ChromaticChord.Bm
	};

	// Aumentados
	public static final ChromaticChord		Caug				= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		CCaug				= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		Daug				= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DDaug				= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		Eaug				= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		Faug				= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FFaug				= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		Gaug				= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GGaug				= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		Aaug				= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AAaug				= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		Baug				= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord[]	CHORDS_AUGMENTED	= new ChromaticChord[] {
		ChromaticChord.Caug,
		ChromaticChord.CCaug,
		ChromaticChord.Daug,
		ChromaticChord.DDaug,
		ChromaticChord.Eaug,
		ChromaticChord.Faug,
		ChromaticChord.FFaug,
		ChromaticChord.Gaug,
		ChromaticChord.GGaug,
		ChromaticChord.Aaug,
		ChromaticChord.AAaug,
		ChromaticChord.Baug
	};

	// Diminuidos
	public static final ChromaticChord		Cdim				= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		CCdim				= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		Ddim				= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		DDdim				= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		Edim				= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		Fdim				= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		FFdim				= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		Gdim				= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		GGdim				= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		Adim				= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		AAdim				= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		Bdim				= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord[]	CHORDS_DIMINISHED	= new ChromaticChord[] {
		ChromaticChord.Cdim,
		ChromaticChord.CCdim,
		ChromaticChord.Ddim,
		ChromaticChord.DDdim,
		ChromaticChord.Edim,
		ChromaticChord.Fdim,
		ChromaticChord.FFdim,
		ChromaticChord.Gdim,
		ChromaticChord.GGdim,
		ChromaticChord.Adim,
		ChromaticChord.AAdim,
		ChromaticChord.Bdim
	};

	// Cuarta suspendida
	public static final ChromaticChord		Csus4		= new ChromaticChord(
		Chromatic.C, Chromatic.F, Chromatic.G
	);
	public static final ChromaticChord		CCsus4		= new ChromaticChord(
		Chromatic.CC, Chromatic.FF, Chromatic.GG
	);
	public static final ChromaticChord		Dsus4		= new ChromaticChord(
		Chromatic.D, Chromatic.G, Chromatic.A
	);
	public static final ChromaticChord		DDsus4		= new ChromaticChord(
		Chromatic.DD, Chromatic.GG, Chromatic.AA
	);
	public static final ChromaticChord		Esus4		= new ChromaticChord(
		Chromatic.E, Chromatic.A, Chromatic.B
	);
	public static final ChromaticChord		Fsus4		= new ChromaticChord(
		Chromatic.F, Chromatic.AA, Chromatic.C
	);
	public static final ChromaticChord		FFsus4		= new ChromaticChord(
		Chromatic.FF, Chromatic.B, Chromatic.CC
	);
	public static final ChromaticChord		Gsus4		= new ChromaticChord(
		Chromatic.G, Chromatic.C, Chromatic.D
	);
	public static final ChromaticChord		GGsus4		= new ChromaticChord(
		Chromatic.GG, Chromatic.CC, Chromatic.DD
	);
	public static final ChromaticChord		Asus4		= new ChromaticChord(
		Chromatic.A, Chromatic.D, Chromatic.E
	);
	public static final ChromaticChord		AAsus4		= new ChromaticChord(
		Chromatic.AA, Chromatic.DD, Chromatic.F
	);
	public static final ChromaticChord		Bsus4		= new ChromaticChord(
		Chromatic.B, Chromatic.E, Chromatic.FF
	);
	public static final ChromaticChord[]	CHORDS_SUS4	= new ChromaticChord[] {
		ChromaticChord.Csus4,
		ChromaticChord.CCsus4,
		ChromaticChord.Dsus4,
		ChromaticChord.DDsus4,
		ChromaticChord.Esus4,
		ChromaticChord.Fsus4,
		ChromaticChord.FFsus4,
		ChromaticChord.Gsus4,
		ChromaticChord.GGsus4,
		ChromaticChord.Asus4,
		ChromaticChord.AAsus4,
		ChromaticChord.Bsus4
	};

	// Segunda suspendida
	public static final ChromaticChord		Csus2		= new ChromaticChord(
		Chromatic.C, Chromatic.D, Chromatic.G
	);
	public static final ChromaticChord		CCsus2		= new ChromaticChord(
		Chromatic.CC, Chromatic.DD, Chromatic.GG
	);
	public static final ChromaticChord		Dsus2		= new ChromaticChord(
		Chromatic.D, Chromatic.E, Chromatic.A
	);
	public static final ChromaticChord		DDsus2		= new ChromaticChord(
		Chromatic.DD, Chromatic.F, Chromatic.AA
	);
	public static final ChromaticChord		Esus2		= new ChromaticChord(
		Chromatic.E, Chromatic.FF, Chromatic.B
	);
	public static final ChromaticChord		Fsus2		= new ChromaticChord(
		Chromatic.F, Chromatic.G, Chromatic.C
	);
	public static final ChromaticChord		FFsus2		= new ChromaticChord(
		Chromatic.FF, Chromatic.GG, Chromatic.CC
	);
	public static final ChromaticChord		Gsus2		= new ChromaticChord(
		Chromatic.G, Chromatic.A, Chromatic.D
	);
	public static final ChromaticChord		GGsus2		= new ChromaticChord(
		Chromatic.GG, Chromatic.AA, Chromatic.DD
	);
	public static final ChromaticChord		Asus2		= new ChromaticChord(
		Chromatic.A, Chromatic.B, Chromatic.E
	);
	public static final ChromaticChord		AAsus2		= new ChromaticChord(
		Chromatic.AA, Chromatic.C, Chromatic.F
	);
	public static final ChromaticChord		Bsus2		= new ChromaticChord(
		Chromatic.B, Chromatic.CC, Chromatic.FF
	);
	public static final ChromaticChord[]	CHORDS_SUS2	= new ChromaticChord[] {
		ChromaticChord.Csus2,
		ChromaticChord.CCsus2,
		ChromaticChord.Dsus2,
		ChromaticChord.DDsus2,
		ChromaticChord.Esus2,
		ChromaticChord.Fsus2,
		ChromaticChord.FFsus2,
		ChromaticChord.Gsus2,
		ChromaticChord.GGsus2,
		ChromaticChord.Asus2,
		ChromaticChord.AAsus2,
		ChromaticChord.Bsus2
	};

	// Séptima (de dominante)
	public static final ChromaticChord		C7			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		CC7			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		D7			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		DD7			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		E7			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		F7			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		FF7			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		G7			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		GG7			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		A7			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		AA7			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		B7			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord[]	CHORDS_7	= new ChromaticChord[] {
		ChromaticChord.C7,
		ChromaticChord.CC7,
		ChromaticChord.D7,
		ChromaticChord.DD7,
		ChromaticChord.E7,
		ChromaticChord.F7,
		ChromaticChord.FF7,
		ChromaticChord.G7,
		ChromaticChord.GG7,
		ChromaticChord.A7,
		ChromaticChord.AA7,
		ChromaticChord.B7
	};

	// Séptima con quinta bemol
	public static final ChromaticChord		C7b5		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		CC7b5		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		D7b5		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		DD7b5		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		E7b5		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		F7b5		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		FF7b5		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		G7b5		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		GG7b5		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		A7b5		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		AA7b5		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		B7b5		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord[]	CHORDS_7b5	= new ChromaticChord[] {
		ChromaticChord.C7b5,
		ChromaticChord.CC7b5,
		ChromaticChord.D7b5,
		ChromaticChord.DD7b5,
		ChromaticChord.E7b5,
		ChromaticChord.F7b5,
		ChromaticChord.FF7b5,
		ChromaticChord.G7b5,
		ChromaticChord.GG7b5,
		ChromaticChord.A7b5,
		ChromaticChord.AA7b5,
		ChromaticChord.B7b5
	};

	// Séptima con quinta aumentada
	public static final ChromaticChord		C7a5		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA
	);
	public static final ChromaticChord		CC7a5		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B
	);
	public static final ChromaticChord		D7a5		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C
	);
	public static final ChromaticChord		DD7a5		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC
	);
	public static final ChromaticChord		E7a5		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D
	);
	public static final ChromaticChord		F7a5		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD
	);
	public static final ChromaticChord		FF7a5		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E
	);
	public static final ChromaticChord		G7a5		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F
	);
	public static final ChromaticChord		GG7a5		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF
	);
	public static final ChromaticChord		A7a5		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G
	);
	public static final ChromaticChord		AA7a5		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG
	);
	public static final ChromaticChord		B7a5		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A
	);
	public static final ChromaticChord[]	CHORDS_7a5	= new ChromaticChord[] {
		ChromaticChord.C7a5,
		ChromaticChord.CC7a5,
		ChromaticChord.D7a5,
		ChromaticChord.DD7a5,
		ChromaticChord.E7a5,
		ChromaticChord.F7a5,
		ChromaticChord.FF7a5,
		ChromaticChord.G7a5,
		ChromaticChord.GG7a5,
		ChromaticChord.A7a5,
		ChromaticChord.AA7a5,
		ChromaticChord.B7a5
	};

	// Séptima con cuarta suspendida
	public static final ChromaticChord		C7sus4			= new ChromaticChord(
		Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		CC7sus4			= new ChromaticChord(
		Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		D7sus4			= new ChromaticChord(
		Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		DD7sus4			= new ChromaticChord(
		Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		E7sus4			= new ChromaticChord(
		Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		F7sus4			= new ChromaticChord(
		Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		FF7sus4			= new ChromaticChord(
		Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		G7sus4			= new ChromaticChord(
		Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		GG7sus4			= new ChromaticChord(
		Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		A7sus4			= new ChromaticChord(
		Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		AA7sus4			= new ChromaticChord(
		Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		B7sus4			= new ChromaticChord(
		Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord[]	CHORDS_7sus4	= new ChromaticChord[] {
		ChromaticChord.C7sus4,
		ChromaticChord.CC7sus4,
		ChromaticChord.D7sus4,
		ChromaticChord.DD7sus4,
		ChromaticChord.E7sus4,
		ChromaticChord.F7sus4,
		ChromaticChord.FF7sus4,
		ChromaticChord.G7sus4,
		ChromaticChord.GG7sus4,
		ChromaticChord.A7sus4,
		ChromaticChord.AA7sus4,
		ChromaticChord.B7sus4
	};

	// Menor séptima
	public static final ChromaticChord		Cm7			= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		CCm7		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		Dm7			= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		DDm7		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		Em7			= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		Fm7			= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		FFm7		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		Gm7			= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		GGm7		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		Am7			= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		AAm7		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		Bm7			= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord[]	CHORDS_m7	= new ChromaticChord[] {
		ChromaticChord.Cm7,
		ChromaticChord.CCm7,
		ChromaticChord.Dm7,
		ChromaticChord.DDm7,
		ChromaticChord.Em7,
		ChromaticChord.Fm7,
		ChromaticChord.FFm7,
		ChromaticChord.Gm7,
		ChromaticChord.GGm7,
		ChromaticChord.Am7,
		ChromaticChord.AAm7,
		ChromaticChord.Bm7
	};

	// Menor séptima con quinta bemol
	public static final ChromaticChord		Cm7b5		= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		CCm7b5		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		Dm7b5		= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		DDm7b5		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		Em7b5		= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		Fm7b5		= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		FFm7b5		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		Gm7b5		= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		GGm7b5		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		Am7b5		= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		AAm7b5		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		Bm7b5		= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord[]	CHORDS_m7b5	= new ChromaticChord[] {
		ChromaticChord.Cm7b5,
		ChromaticChord.CCm7b5,
		ChromaticChord.Dm7b5,
		ChromaticChord.DDm7b5,
		ChromaticChord.Em7b5,
		ChromaticChord.Fm7b5,
		ChromaticChord.FFm7b5,
		ChromaticChord.Gm7b5,
		ChromaticChord.GGm7b5,
		ChromaticChord.Am7b5,
		ChromaticChord.AAm7b5,
		ChromaticChord.Bm7b5
	};

	// Menor séptima con quinta aumentada
	public static final ChromaticChord		Cm7a5		= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA
	);
	public static final ChromaticChord		CCm7a5		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B
	);
	public static final ChromaticChord		Dm7a5		= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C
	);
	public static final ChromaticChord		DDm7a5		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC
	);
	public static final ChromaticChord		Em7a5		= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D
	);
	public static final ChromaticChord		Fm7a5		= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD
	);
	public static final ChromaticChord		FFm7a5		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E
	);
	public static final ChromaticChord		Gm7a5		= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F
	);
	public static final ChromaticChord		GGm7a5		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF
	);
	public static final ChromaticChord		Am7a5		= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G
	);
	public static final ChromaticChord		AAm7a5		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG
	);
	public static final ChromaticChord		Bm7a5		= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A
	);
	public static final ChromaticChord[]	CHORDS_m7a5	= new ChromaticChord[] {
		ChromaticChord.Cm7a5,
		ChromaticChord.CCm7a5,
		ChromaticChord.Dm7a5,
		ChromaticChord.DDm7a5,
		ChromaticChord.Em7a5,
		ChromaticChord.Fm7a5,
		ChromaticChord.FFm7a5,
		ChromaticChord.Gm7a5,
		ChromaticChord.GGm7a5,
		ChromaticChord.Am7a5,
		ChromaticChord.AAm7a5,
		ChromaticChord.Bm7a5
	};

	// Sexta
	public static final ChromaticChord		C6			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A
	);
	public static final ChromaticChord		CC6			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA
	);
	public static final ChromaticChord		D6			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B
	);
	public static final ChromaticChord		DD6			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C
	);
	public static final ChromaticChord		E6			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC
	);
	public static final ChromaticChord		F6			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D
	);
	public static final ChromaticChord		FF6			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD
	);
	public static final ChromaticChord		G6			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E
	);
	public static final ChromaticChord		GG6			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F
	);
	public static final ChromaticChord		A6			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF
	);
	public static final ChromaticChord		AA6			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G
	);
	public static final ChromaticChord		B6			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_6	= new ChromaticChord[] {
		ChromaticChord.C6,
		ChromaticChord.CC6,
		ChromaticChord.D6,
		ChromaticChord.DD6,
		ChromaticChord.E6,
		ChromaticChord.F6,
		ChromaticChord.FF6,
		ChromaticChord.G6,
		ChromaticChord.GG6,
		ChromaticChord.A6,
		ChromaticChord.AA6,
		ChromaticChord.B6
	};

	// Menor sexta
	public static final ChromaticChord		Cm6			= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A
	);
	public static final ChromaticChord		CCm6		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA
	);
	public static final ChromaticChord		Dm6			= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B
	);
	public static final ChromaticChord		DDm6		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C
	);
	public static final ChromaticChord		Em6			= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC
	);
	public static final ChromaticChord		Fm6			= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D
	);
	public static final ChromaticChord		FFm6		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD
	);
	public static final ChromaticChord		Gm6			= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E
	);
	public static final ChromaticChord		GGm6		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F
	);
	public static final ChromaticChord		Am6			= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF
	);
	public static final ChromaticChord		AAm6		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G
	);
	public static final ChromaticChord		Bm6			= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_m6	= new ChromaticChord[] {
		ChromaticChord.Cm6,
		ChromaticChord.CCm6,
		ChromaticChord.Dm6,
		ChromaticChord.DDm6,
		ChromaticChord.Em6,
		ChromaticChord.Fm6,
		ChromaticChord.FFm6,
		ChromaticChord.Gm6,
		ChromaticChord.GGm6,
		ChromaticChord.Am6,
		ChromaticChord.AAm6,
		ChromaticChord.Bm6
	};

	// Sexta con cuarta suspendida
	public static final ChromaticChord		C6sus4			= new ChromaticChord(
		Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.A
	);
	public static final ChromaticChord		CC6sus4			= new ChromaticChord(
		Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.AA
	);
	public static final ChromaticChord		D6sus4			= new ChromaticChord(
		Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.B
	);
	public static final ChromaticChord		DD6sus4			= new ChromaticChord(
		Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.C
	);
	public static final ChromaticChord		E6sus4			= new ChromaticChord(
		Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.CC
	);
	public static final ChromaticChord		F6sus4			= new ChromaticChord(
		Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.D
	);
	public static final ChromaticChord		FF6sus4			= new ChromaticChord(
		Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.DD
	);
	public static final ChromaticChord		G6sus4			= new ChromaticChord(
		Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.E
	);
	public static final ChromaticChord		GG6sus4			= new ChromaticChord(
		Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.F
	);
	public static final ChromaticChord		A6sus4			= new ChromaticChord(
		Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.FF
	);
	public static final ChromaticChord		AA6sus4			= new ChromaticChord(
		Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.G
	);
	public static final ChromaticChord		B6sus4			= new ChromaticChord(
		Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_6sus4	= new ChromaticChord[] {
		ChromaticChord.C6sus4,
		ChromaticChord.CC6sus4,
		ChromaticChord.D6sus4,
		ChromaticChord.DD6sus4,
		ChromaticChord.E6sus4,
		ChromaticChord.F6sus4,
		ChromaticChord.FF6sus4,
		ChromaticChord.G6sus4,
		ChromaticChord.GG6sus4,
		ChromaticChord.A6sus4,
		ChromaticChord.AA6sus4,
		ChromaticChord.B6sus4
	};

	// Séptima mayor
	public static final ChromaticChord		CMaj7		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		CCMaj7		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		DMaj7		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		DDMaj7		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		EMaj7		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		FMaj7		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		FFMaj7		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		GMaj7		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		GGMaj7		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		AMaj7		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		AAMaj7		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		BMaj7		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord[]	CHORDS_Maj7	= new ChromaticChord[] {
		ChromaticChord.CMaj7,
		ChromaticChord.CCMaj7,
		ChromaticChord.DMaj7,
		ChromaticChord.DDMaj7,
		ChromaticChord.EMaj7,
		ChromaticChord.FMaj7,
		ChromaticChord.FFMaj7,
		ChromaticChord.GMaj7,
		ChromaticChord.GGMaj7,
		ChromaticChord.AMaj7,
		ChromaticChord.AAMaj7,
		ChromaticChord.BMaj7
	};

	// Menor séptima mayor
	public static final ChromaticChord		CmMaj7			= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		CCmMaj7			= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		DmMaj7			= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		DDmMaj7			= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		EmMaj7			= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		FmMaj7			= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		FFmMaj7			= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		GmMaj7			= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		GGmMaj7			= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		AmMaj7			= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		AAmMaj7			= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		BmMaj7			= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord[]	CHORDS_mMaj7	= new ChromaticChord[] {
		ChromaticChord.CmMaj7,
		ChromaticChord.CCmMaj7,
		ChromaticChord.DmMaj7,
		ChromaticChord.DDmMaj7,
		ChromaticChord.EmMaj7,
		ChromaticChord.FmMaj7,
		ChromaticChord.FFmMaj7,
		ChromaticChord.GmMaj7,
		ChromaticChord.GGmMaj7,
		ChromaticChord.AmMaj7,
		ChromaticChord.AAmMaj7,
		ChromaticChord.BmMaj7
	};

	// Sexta con novena añadida
	public static final ChromaticChord		C6add9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.D
	);
	public static final ChromaticChord		CC6add9			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.DD
	);
	public static final ChromaticChord		D6add9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.E
	);
	public static final ChromaticChord		DD6add9			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.F
	);
	public static final ChromaticChord		E6add9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.FF
	);
	public static final ChromaticChord		F6add9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.G
	);
	public static final ChromaticChord		FF6add9			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.GG
	);
	public static final ChromaticChord		G6add9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.A
	);
	public static final ChromaticChord		GG6add9			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.AA
	);
	public static final ChromaticChord		A6add9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.B
	);
	public static final ChromaticChord		AA6add9			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.C
	);
	public static final ChromaticChord		B6add9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_6add9	= new ChromaticChord[] {
		ChromaticChord.C6add9,
		ChromaticChord.CC6add9,
		ChromaticChord.D6add9,
		ChromaticChord.DD6add9,
		ChromaticChord.E6add9,
		ChromaticChord.F6add9,
		ChromaticChord.FF6add9,
		ChromaticChord.G6add9,
		ChromaticChord.GG6add9,
		ChromaticChord.A6add9,
		ChromaticChord.AA6add9,
		ChromaticChord.B6add9
	};

	// Sexta con novena añadida
	public static final ChromaticChord		Cm6add9			= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D
	);
	public static final ChromaticChord		CCm6add9		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD
	);
	public static final ChromaticChord		Dm6add9			= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E
	);
	public static final ChromaticChord		DDm6add9		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F
	);
	public static final ChromaticChord		Em6add9			= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF
	);
	public static final ChromaticChord		Fm6add9			= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G
	);
	public static final ChromaticChord		FFm6add9		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG
	);
	public static final ChromaticChord		Gm6add9			= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A
	);
	public static final ChromaticChord		GGm6add9		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA
	);
	public static final ChromaticChord		Am6add9			= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B
	);
	public static final ChromaticChord		AAm6add9		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C
	);
	public static final ChromaticChord		Bm6add9			= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_m6add9	= new ChromaticChord[] {
		ChromaticChord.Cm6add9,
		ChromaticChord.CCm6add9,
		ChromaticChord.Dm6add9,
		ChromaticChord.DDm6add9,
		ChromaticChord.Em6add9,
		ChromaticChord.Fm6add9,
		ChromaticChord.FFm6add9,
		ChromaticChord.Gm6add9,
		ChromaticChord.GGm6add9,
		ChromaticChord.Am6add9,
		ChromaticChord.AAm6add9,
		ChromaticChord.Bm6add9
	};

	// Séptima con novena bemol (añadida)
	public static final ChromaticChord		C7b9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		CC7b9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		D7b9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		DD7b9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		E7b9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		F7b9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		FF7b9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		G7b9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		GG7b9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		A7b9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		AA7b9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		B7b9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord[]	CHORDS_7b9	= new ChromaticChord[] {
		ChromaticChord.C7b9,
		ChromaticChord.CC7b9,
		ChromaticChord.D7b9,
		ChromaticChord.DD7b9,
		ChromaticChord.E7b9,
		ChromaticChord.F7b9,
		ChromaticChord.FF7b9,
		ChromaticChord.G7b9,
		ChromaticChord.GG7b9,
		ChromaticChord.A7b9,
		ChromaticChord.AA7b9,
		ChromaticChord.B7b9
	};

	// Séptima con novena aumentada (añadida)
	public static final ChromaticChord		C7a9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD
	);
	public static final ChromaticChord		CC7a9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E
	);
	public static final ChromaticChord		D7a9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F
	);
	public static final ChromaticChord		DD7a9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF
	);
	public static final ChromaticChord		E7a9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G
	);
	public static final ChromaticChord		F7a9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG
	);
	public static final ChromaticChord		FF7a9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A
	);
	public static final ChromaticChord		G7a9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA
	);
	public static final ChromaticChord		GG7a9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B
	);
	public static final ChromaticChord		A7a9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C
	);
	public static final ChromaticChord		AA7a9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC
	);
	public static final ChromaticChord		B7a9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D
	);
	public static final ChromaticChord[]	CHORDS_7a9	= new ChromaticChord[] {
		ChromaticChord.C7a9,
		ChromaticChord.CC7a9,
		ChromaticChord.D7a9,
		ChromaticChord.DD7a9,
		ChromaticChord.E7a9,
		ChromaticChord.F7a9,
		ChromaticChord.FF7a9,
		ChromaticChord.G7a9,
		ChromaticChord.GG7a9,
		ChromaticChord.A7a9,
		ChromaticChord.AA7a9,
		ChromaticChord.B7a9
	};

	// Menor séptima con novena bemol (añadida)
	public static final ChromaticChord		Cm7b9		= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		CCm7b9		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		Dm7b9		= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		DDm7b9		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		Em7b9		= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		Fm7b9		= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		FFm7b9		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		Gm7b9		= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		GGm7b9		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		Am7b9		= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		AAm7b9		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		Bm7b9		= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord[]	CHORDS_m7b9	= new ChromaticChord[] {
		ChromaticChord.Cm7b9,
		ChromaticChord.CCm7b9,
		ChromaticChord.Dm7b9,
		ChromaticChord.DDm7b9,
		ChromaticChord.Em7b9,
		ChromaticChord.Fm7b9,
		ChromaticChord.FFm7b9,
		ChromaticChord.Gm7b9,
		ChromaticChord.GGm7b9,
		ChromaticChord.Am7b9,
		ChromaticChord.AAm7b9,
		ChromaticChord.Bm7b9
	};

	// Séptima con oncena (añadida)
	public static final ChromaticChord		C7add11			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.F
	);
	public static final ChromaticChord		CC7add11		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.FF
	);
	public static final ChromaticChord		D7add11			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.G
	);
	public static final ChromaticChord		DD7add11		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.GG
	);
	public static final ChromaticChord		E7add11			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.A
	);
	public static final ChromaticChord		F7add11			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.AA
	);
	public static final ChromaticChord		FF7add11		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.B
	);
	public static final ChromaticChord		G7add11			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.C
	);
	public static final ChromaticChord		GG7add11		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.CC
	);
	public static final ChromaticChord		A7add11			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.D
	);
	public static final ChromaticChord		AA7add11		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.DD
	);
	public static final ChromaticChord		B7add11			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.E
	);
	public static final ChromaticChord[]	CHORDS_7add11	= new ChromaticChord[] {
		ChromaticChord.C7add11,
		ChromaticChord.CC7add11,
		ChromaticChord.D7add11,
		ChromaticChord.DD7add11,
		ChromaticChord.E7add11,
		ChromaticChord.F7add11,
		ChromaticChord.FF7add11,
		ChromaticChord.G7add11,
		ChromaticChord.GG7add11,
		ChromaticChord.A7add11,
		ChromaticChord.AA7add11,
		ChromaticChord.B7add11
	};

	// Séptima con oncena (añadida)
	public static final ChromaticChord		C7add13			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.A
	);
	public static final ChromaticChord		CC7add13		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.AA
	);
	public static final ChromaticChord		D7add13			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.B
	);
	public static final ChromaticChord		DD7add13		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.C
	);
	public static final ChromaticChord		E7add13			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.CC
	);
	public static final ChromaticChord		F7add13			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.D
	);
	public static final ChromaticChord		FF7add13		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.DD
	);
	public static final ChromaticChord		G7add13			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.E
	);
	public static final ChromaticChord		GG7add13		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.F
	);
	public static final ChromaticChord		A7add13			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.FF
	);
	public static final ChromaticChord		AA7add13		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.G
	);
	public static final ChromaticChord		B7add13			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_7add13	= new ChromaticChord[] {
		ChromaticChord.C7add13,
		ChromaticChord.CC7add13,
		ChromaticChord.D7add13,
		ChromaticChord.DD7add13,
		ChromaticChord.E7add13,
		ChromaticChord.F7add13,
		ChromaticChord.FF7add13,
		ChromaticChord.G7add13,
		ChromaticChord.GG7add13,
		ChromaticChord.A7add13,
		ChromaticChord.AA7add13,
		ChromaticChord.B7add13
	};

	// Novena
	public static final ChromaticChord		C9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		CC9			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		D9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		DD9			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		E9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		F9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		FF9			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		G9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		GG9			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		A9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		AA9			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		B9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_9	= new ChromaticChord[] {
		ChromaticChord.C9,
		ChromaticChord.CC9,
		ChromaticChord.D9,
		ChromaticChord.DD9,
		ChromaticChord.E9,
		ChromaticChord.F9,
		ChromaticChord.FF9,
		ChromaticChord.G9,
		ChromaticChord.GG9,
		ChromaticChord.A9,
		ChromaticChord.AA9,
		ChromaticChord.B9
	};

	// Menor novena
	public static final ChromaticChord		Cm9			= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		CCm9		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		Dm9			= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		DDm9		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		Em9			= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		Fm9			= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		FFm9		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		Gm9			= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		GGm9		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		Am9			= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		AAm9		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		Bm9			= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_m9	= new ChromaticChord[] {
		ChromaticChord.Cm9,
		ChromaticChord.CCm9,
		ChromaticChord.Dm9,
		ChromaticChord.DDm9,
		ChromaticChord.Em9,
		ChromaticChord.Fm9,
		ChromaticChord.FFm9,
		ChromaticChord.Gm9,
		ChromaticChord.GGm9,
		ChromaticChord.Am9,
		ChromaticChord.AAm9,
		ChromaticChord.Bm9
	};

	// Novena con quinta bemol
	public static final ChromaticChord		C9b5		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		CC9b5		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		D9b5		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		DD9b5		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		E9b5		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		F9b5		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		FF9b5		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		G9b5		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		GG9b5		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		A9b5		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		AA9b5		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		B9b5		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_9b5	= new ChromaticChord[] {
		ChromaticChord.C9b5,
		ChromaticChord.CC9b5,
		ChromaticChord.D9b5,
		ChromaticChord.DD9b5,
		ChromaticChord.E9b5,
		ChromaticChord.F9b5,
		ChromaticChord.FF9b5,
		ChromaticChord.G9b5,
		ChromaticChord.GG9b5,
		ChromaticChord.A9b5,
		ChromaticChord.AA9b5,
		ChromaticChord.B9b5
	};

	// Novena con quinta aumentada
	public static final ChromaticChord		C9a5		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		CC9a5		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		D9a5		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		DD9a5		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		E9a5		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		F9a5		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		FF9a5		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		G9a5		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		GG9a5		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		A9a5		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		AA9a5		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		B9a5		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_9a5	= new ChromaticChord[] {
		ChromaticChord.C9a5,
		ChromaticChord.CC9a5,
		ChromaticChord.D9a5,
		ChromaticChord.DD9a5,
		ChromaticChord.E9a5,
		ChromaticChord.F9a5,
		ChromaticChord.FF9a5,
		ChromaticChord.G9a5,
		ChromaticChord.GG9a5,
		ChromaticChord.A9a5,
		ChromaticChord.AA9a5,
		ChromaticChord.B9a5
	};

	// Novena con cuarta suspendida
	public static final ChromaticChord		C9sus4			= new ChromaticChord(
		Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		CC9sus4			= new ChromaticChord(
		Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		D9sus4			= new ChromaticChord(
		Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		DD9sus4			= new ChromaticChord(
		Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		E9sus4			= new ChromaticChord(
		Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		F9sus4			= new ChromaticChord(
		Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		FF9sus4			= new ChromaticChord(
		Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		G9sus4			= new ChromaticChord(
		Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		GG9sus4			= new ChromaticChord(
		Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		A9sus4			= new ChromaticChord(
		Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		AA9sus4			= new ChromaticChord(
		Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		B9sus4			= new ChromaticChord(
		Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_9sus4	= new ChromaticChord[] {
		ChromaticChord.C9sus4,
		ChromaticChord.CC9sus4,
		ChromaticChord.D9sus4,
		ChromaticChord.DD9sus4,
		ChromaticChord.E9sus4,
		ChromaticChord.F9sus4,
		ChromaticChord.FF9sus4,
		ChromaticChord.G9sus4,
		ChromaticChord.GG9sus4,
		ChromaticChord.A9sus4,
		ChromaticChord.AA9sus4,
		ChromaticChord.B9sus4
	};

	// Novena mayor
	public static final ChromaticChord		CMaj9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		CCMaj9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		DMaj9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		DDMaj9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		EMaj9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		FMaj9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		FFMaj9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		GMaj9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		GGMaj9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		AMaj9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		AAMaj9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		BMaj9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_Maj9	= new ChromaticChord[] {
		ChromaticChord.CMaj9,
		ChromaticChord.CCMaj9,
		ChromaticChord.DMaj9,
		ChromaticChord.DDMaj9,
		ChromaticChord.EMaj9,
		ChromaticChord.FMaj9,
		ChromaticChord.FFMaj9,
		ChromaticChord.GMaj9,
		ChromaticChord.GGMaj9,
		ChromaticChord.AMaj9,
		ChromaticChord.AAMaj9,
		ChromaticChord.BMaj9
	};

	// Menor novena mayor
	public static final ChromaticChord		CmMaj9			= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		CCmMaj9			= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		DmMaj9			= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord		DDmMaj9			= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		EmMaj9			= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		FmMaj9			= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		FFmMaj9			= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		GmMaj9			= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		GGmMaj9			= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		AmMaj9			= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		AAmMaj9			= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		BmMaj9			= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_mMaj9	= new ChromaticChord[] {
		ChromaticChord.CmMaj9,
		ChromaticChord.CCmMaj9,
		ChromaticChord.DmMaj9,
		ChromaticChord.DDmMaj9,
		ChromaticChord.EmMaj9,
		ChromaticChord.FmMaj9,
		ChromaticChord.FFmMaj9,
		ChromaticChord.GmMaj9,
		ChromaticChord.GGmMaj9,
		ChromaticChord.AmMaj9,
		ChromaticChord.AAmMaj9,
		ChromaticChord.BmMaj9
	};

	// Novena con sexta (añadida)
	public static final ChromaticChord		C9add6			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		CC9add6			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		D9add6			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		DD9add6			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		E9add6			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		F9add6			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		FF9add6			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		G9add6			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		GG9add6			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		A9add6			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		AA9add6			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		B9add6			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord[]	CHORDS_9add6	= new ChromaticChord[] {
		ChromaticChord.C9add6,
		ChromaticChord.CC9add6,
		ChromaticChord.D9add6,
		ChromaticChord.DD9add6,
		ChromaticChord.E9add6,
		ChromaticChord.F9add6,
		ChromaticChord.FF9add6,
		ChromaticChord.G9add6,
		ChromaticChord.GG9add6,
		ChromaticChord.A9add6,
		ChromaticChord.AA9add6,
		ChromaticChord.B9add6
	};

	// Novena con onceava aumentada (añadida)
	public static final ChromaticChord		C9a11		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		CC9a11		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		D9a11		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		DD9a11		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		E9a11		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		F9a11		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		FF9a11		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		G9a11		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		GG9a11		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		A9a11		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		AA9a11		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		B9a11		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord[]	CHORDS_9a11	= new ChromaticChord[] {
		ChromaticChord.C9a11,
		ChromaticChord.CC9a11,
		ChromaticChord.D9a11,
		ChromaticChord.DD9a11,
		ChromaticChord.E9a11,
		ChromaticChord.F9a11,
		ChromaticChord.FF9a11,
		ChromaticChord.G9a11,
		ChromaticChord.GG9a11,
		ChromaticChord.A9a11,
		ChromaticChord.AA9a11,
		ChromaticChord.B9a11
	};

	// Novena mayor con onceava aumentada (añadida)
	public static final ChromaticChord		CMaj9a11		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		CCMaj9a11		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		DMaj9a11		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		DDMaj9a11		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		EMaj9a11		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		FMaj9a11		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		FFMaj9a11		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		GMaj9a11		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		GGMaj9a11		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		AMaj9a11		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		AAMaj9a11		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		BMaj9a11		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord[]	CHORDS_Maj9a11	= new ChromaticChord[] {
		ChromaticChord.CMaj9a11,
		ChromaticChord.CCMaj9a11,
		ChromaticChord.DMaj9a11,
		ChromaticChord.DDMaj9a11,
		ChromaticChord.EMaj9a11,
		ChromaticChord.FMaj9a11,
		ChromaticChord.FFMaj9a11,
		ChromaticChord.GMaj9a11,
		ChromaticChord.GGMaj9a11,
		ChromaticChord.AMaj9a11,
		ChromaticChord.AAMaj9a11,
		ChromaticChord.BMaj9a11
	};

	// Onceava
	public static final ChromaticChord		C11			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		CC11		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		D11			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		DD11		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		E11			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		F11			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		FF11		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		G11			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		GG11		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		A11			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		AA11		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		B11			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord[]	CHORDS_11	= new ChromaticChord[] {
		ChromaticChord.C11,
		ChromaticChord.CC11,
		ChromaticChord.D11,
		ChromaticChord.DD11,
		ChromaticChord.E11,
		ChromaticChord.F11,
		ChromaticChord.FF11,
		ChromaticChord.G11,
		ChromaticChord.GG11,
		ChromaticChord.A11,
		ChromaticChord.AA11,
		ChromaticChord.B11
	};

	// Menor onceava
	public static final ChromaticChord		Cm11		= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		CCm11		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		Dm11		= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		DDm11		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		Em11		= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		Fm11		= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		FFm11		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		Gm11		= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		GGm11		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		Am11		= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		AAm11		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		Bm11		= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord[]	CHORDS_m11	= new ChromaticChord[] {
		ChromaticChord.Cm11,
		ChromaticChord.CCm11,
		ChromaticChord.Dm11,
		ChromaticChord.DDm11,
		ChromaticChord.Em11,
		ChromaticChord.Fm11,
		ChromaticChord.FFm11,
		ChromaticChord.Gm11,
		ChromaticChord.GGm11,
		ChromaticChord.Am11,
		ChromaticChord.AAm11,
		ChromaticChord.Bm11
	};

	// Onceava con novena bemol
	public static final ChromaticChord		C11b9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		CC11b9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		D11b9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		DD11b9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord		E11b9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		F11b9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		FF11b9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		G11b9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		GG11b9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		A11b9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		AA11b9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		B11b9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord[]	CHORDS_11b9	= new ChromaticChord[] {
		ChromaticChord.C11b9,
		ChromaticChord.CC11b9,
		ChromaticChord.D11b9,
		ChromaticChord.DD11b9,
		ChromaticChord.E11b9,
		ChromaticChord.F11b9,
		ChromaticChord.FF11b9,
		ChromaticChord.G11b9,
		ChromaticChord.GG11b9,
		ChromaticChord.A11b9,
		ChromaticChord.AA11b9,
		ChromaticChord.B11b9
	};

	// Onceava con novena aumentada
	public static final ChromaticChord		C11a9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F
	);
	public static final ChromaticChord		CC11a9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF
	);
	public static final ChromaticChord		D11a9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G
	);
	public static final ChromaticChord		DD11a9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG
	);
	public static final ChromaticChord		E11a9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A
	);
	public static final ChromaticChord		F11a9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA
	);
	public static final ChromaticChord		FF11a9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B
	);
	public static final ChromaticChord		G11a9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C
	);
	public static final ChromaticChord		GG11a9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC
	);
	public static final ChromaticChord		A11a9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D
	);
	public static final ChromaticChord		AA11a9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD
	);
	public static final ChromaticChord		B11a9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E
	);
	public static final ChromaticChord[]	CHORDS_11a9	= new ChromaticChord[] {
		ChromaticChord.C11a9,
		ChromaticChord.CC11a9,
		ChromaticChord.D11a9,
		ChromaticChord.DD11a9,
		ChromaticChord.E11a9,
		ChromaticChord.F11a9,
		ChromaticChord.FF11a9,
		ChromaticChord.G11a9,
		ChromaticChord.GG11a9,
		ChromaticChord.A11a9,
		ChromaticChord.AA11a9,
		ChromaticChord.B11a9
	};

	// Onceava mayor
	public static final ChromaticChord		CMaj11			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		CCMaj11			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		DMaj11			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		DDMaj11			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		EMaj11			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		FMaj11			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		FFMaj11			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		GMaj11			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		GGMaj11			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		AMaj11			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		AAMaj11			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		BMaj11			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord[]	CHORDS_Maj11	= new ChromaticChord[] {
		ChromaticChord.CMaj11,
		ChromaticChord.CCMaj11,
		ChromaticChord.DMaj11,
		ChromaticChord.DDMaj11,
		ChromaticChord.EMaj11,
		ChromaticChord.FMaj11,
		ChromaticChord.FFMaj11,
		ChromaticChord.GMaj11,
		ChromaticChord.GGMaj11,
		ChromaticChord.AMaj11,
		ChromaticChord.AAMaj11,
		ChromaticChord.BMaj11
	};

	// Menor onceava mayor
	public static final ChromaticChord		CmMaj11			= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F
	);
	public static final ChromaticChord		CCmMaj11		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF
	);
	public static final ChromaticChord		DmMaj11			= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G
	);
	public static final ChromaticChord		DDmMaj11		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG
	);
	public static final ChromaticChord		EmMaj11			= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A
	);
	public static final ChromaticChord		FmMaj11			= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA
	);
	public static final ChromaticChord		FFmMaj11		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B
	);
	public static final ChromaticChord		GmMaj11			= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C
	);
	public static final ChromaticChord		GGmMaj11		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC
	);
	public static final ChromaticChord		AmMaj11			= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D
	);
	public static final ChromaticChord		AAmMaj11		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD
	);
	public static final ChromaticChord		BmMaj11			= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E
	);
	public static final ChromaticChord[]	CHORDS_mMaj11	= new ChromaticChord[] {
		ChromaticChord.CmMaj11,
		ChromaticChord.CCmMaj11,
		ChromaticChord.DmMaj11,
		ChromaticChord.DDmMaj11,
		ChromaticChord.EmMaj11,
		ChromaticChord.FmMaj11,
		ChromaticChord.FFmMaj11,
		ChromaticChord.GmMaj11,
		ChromaticChord.GGmMaj11,
		ChromaticChord.AmMaj11,
		ChromaticChord.AAmMaj11,
		ChromaticChord.BmMaj11
	};

	// Menor treceava
	public static final ChromaticChord		Cm13		= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCm13		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		Dm13		= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDm13		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		Em13		= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		Fm13		= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFm13		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		Gm13		= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGm13		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		Am13		= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAm13		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		Bm13		= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_m13	= new ChromaticChord[] {
		ChromaticChord.Cm13,
		ChromaticChord.CCm13,
		ChromaticChord.Dm13,
		ChromaticChord.DDm13,
		ChromaticChord.Em13,
		ChromaticChord.Fm13,
		ChromaticChord.FFm13,
		ChromaticChord.Gm13,
		ChromaticChord.GGm13,
		ChromaticChord.Am13,
		ChromaticChord.AAm13,
		ChromaticChord.Bm13
	};

	// Treceava con cuarta suspendida
	public static final ChromaticChord		C13sus4			= new ChromaticChord(
		Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13sus4		= new ChromaticChord(
		Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13sus4			= new ChromaticChord(
		Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13sus4		= new ChromaticChord(
		Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13sus4			= new ChromaticChord(
		Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13sus4			= new ChromaticChord(
		Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13sus4		= new ChromaticChord(
		Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13sus4			= new ChromaticChord(
		Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13sus4		= new ChromaticChord(
		Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13sus4			= new ChromaticChord(
		Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13sus4		= new ChromaticChord(
		Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13sus4			= new ChromaticChord(
		Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13sus4	= new ChromaticChord[] {
		ChromaticChord.C13sus4,
		ChromaticChord.CC13sus4,
		ChromaticChord.D13sus4,
		ChromaticChord.DD13sus4,
		ChromaticChord.E13sus4,
		ChromaticChord.F13sus4,
		ChromaticChord.FF13sus4,
		ChromaticChord.G13sus4,
		ChromaticChord.GG13sus4,
		ChromaticChord.A13sus4,
		ChromaticChord.AA13sus4,
		ChromaticChord.B13sus4
	};

	// Treceava con quinta bemol
	public static final ChromaticChord		C13b5		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13b5		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13b5		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13b5		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13b5		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13b5		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13b5		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13b5		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13b5		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13b5		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13b5		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13b5		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13b5	= new ChromaticChord[] {
		ChromaticChord.C13b5,
		ChromaticChord.CC13b5,
		ChromaticChord.D13b5,
		ChromaticChord.DD13b5,
		ChromaticChord.E13b5,
		ChromaticChord.F13b5,
		ChromaticChord.FF13b5,
		ChromaticChord.G13b5,
		ChromaticChord.GG13b5,
		ChromaticChord.A13b5,
		ChromaticChord.AA13b5,
		ChromaticChord.B13b5
	};

	// Treceava con quinta aumentada
	public static final ChromaticChord		C13a5		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13a5		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13a5		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13a5		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13a5		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13a5		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13a5		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13a5		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13a5		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13a5		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13a5		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13a5		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13a5	= new ChromaticChord[] {
		ChromaticChord.C13a5,
		ChromaticChord.CC13a5,
		ChromaticChord.D13a5,
		ChromaticChord.DD13a5,
		ChromaticChord.E13a5,
		ChromaticChord.F13a5,
		ChromaticChord.FF13a5,
		ChromaticChord.G13a5,
		ChromaticChord.GG13a5,
		ChromaticChord.A13a5,
		ChromaticChord.AA13a5,
		ChromaticChord.B13a5
	};

	// Treceava con novena bemol
	public static final ChromaticChord		C13b9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13b9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13b9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13b9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13b9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13b9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13b9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13b9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13b9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13b9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13b9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13b9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13b9	= new ChromaticChord[] {
		ChromaticChord.C13b9,
		ChromaticChord.CC13b9,
		ChromaticChord.D13b9,
		ChromaticChord.DD13b9,
		ChromaticChord.E13b9,
		ChromaticChord.F13b9,
		ChromaticChord.FF13b9,
		ChromaticChord.G13b9,
		ChromaticChord.GG13b9,
		ChromaticChord.A13b9,
		ChromaticChord.AA13b9,
		ChromaticChord.B13b9
	};

	// Treceava con novena aumentada
	public static final ChromaticChord		C13a9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13a9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13a9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13a9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13a9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13a9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13a9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13a9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13a9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13a9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13a9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13a9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13a9	= new ChromaticChord[] {
		ChromaticChord.C13a9,
		ChromaticChord.CC13a9,
		ChromaticChord.D13a9,
		ChromaticChord.DD13a9,
		ChromaticChord.E13a9,
		ChromaticChord.F13a9,
		ChromaticChord.FF13a9,
		ChromaticChord.G13a9,
		ChromaticChord.GG13a9,
		ChromaticChord.A13a9,
		ChromaticChord.AA13a9,
		ChromaticChord.B13a9
	};

	// Treceava con quinta y novena bemoles
	public static final ChromaticChord		C13b5b9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13b5b9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13b5b9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13b5b9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13b5b9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13b5b9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13b5b9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13b5b9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13b5b9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13b5b9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13b5b9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13b5b9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13b5b9	= new ChromaticChord[] {
		ChromaticChord.C13b5b9,
		ChromaticChord.CC13b5b9,
		ChromaticChord.D13b5b9,
		ChromaticChord.DD13b5b9,
		ChromaticChord.E13b5b9,
		ChromaticChord.F13b5b9,
		ChromaticChord.FF13b5b9,
		ChromaticChord.G13b5b9,
		ChromaticChord.GG13b5b9,
		ChromaticChord.A13b5b9,
		ChromaticChord.AA13b5b9,
		ChromaticChord.B13b5b9
	};

	// Treceava con quinta bemol y novena aumentada
	public static final ChromaticChord		C13b5a9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13b5a9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13b5a9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13b5a9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13b5a9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13b5a9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13b5a9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13b5a9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13b5a9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13b5a9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13b5a9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13b5a9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13b5a9	= new ChromaticChord[] {
		ChromaticChord.C13b5a9,
		ChromaticChord.CC13b5a9,
		ChromaticChord.D13b5a9,
		ChromaticChord.DD13b5a9,
		ChromaticChord.E13b5a9,
		ChromaticChord.F13b5a9,
		ChromaticChord.FF13b5a9,
		ChromaticChord.G13b5a9,
		ChromaticChord.GG13b5a9,
		ChromaticChord.A13b5a9,
		ChromaticChord.AA13b5a9,
		ChromaticChord.B13b5a9
	};

	// Treceava con quinta aumentada y novena bemol
	public static final ChromaticChord		C13a5b9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13a5b9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13a5b9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13a5b9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13a5b9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13a5b9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13a5b9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13a5b9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13a5b9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13a5b9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13a5b9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13a5b9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13a5b9	= new ChromaticChord[] {
		ChromaticChord.C13a5b9,
		ChromaticChord.CC13a5b9,
		ChromaticChord.D13a5b9,
		ChromaticChord.DD13a5b9,
		ChromaticChord.E13a5b9,
		ChromaticChord.F13a5b9,
		ChromaticChord.FF13a5b9,
		ChromaticChord.G13a5b9,
		ChromaticChord.GG13a5b9,
		ChromaticChord.A13a5b9,
		ChromaticChord.AA13a5b9,
		ChromaticChord.B13a5b9
	};

	// Treceava con quinta y novena aumentadas
	public static final ChromaticChord		C13a5a9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CC13a5a9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		D13a5a9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DD13a5a9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		E13a5a9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		F13a5a9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FF13a5a9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		G13a5a9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GG13a5a9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		A13a5a9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AA13a5a9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		B13a5a9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_13a5a9	= new ChromaticChord[] {
		ChromaticChord.C13a5a9,
		ChromaticChord.CC13a5a9,
		ChromaticChord.D13a5a9,
		ChromaticChord.DD13a5a9,
		ChromaticChord.E13a5a9,
		ChromaticChord.F13a5a9,
		ChromaticChord.FF13a5a9,
		ChromaticChord.G13a5a9,
		ChromaticChord.GG13a5a9,
		ChromaticChord.A13a5a9,
		ChromaticChord.AA13a5a9,
		ChromaticChord.B13a5a9
	};

	// Treceava mayor
	public static final ChromaticChord		CMaj13			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13	= new ChromaticChord[] {
		ChromaticChord.CMaj13,
		ChromaticChord.CCMaj13,
		ChromaticChord.DMaj13,
		ChromaticChord.DDMaj13,
		ChromaticChord.EMaj13,
		ChromaticChord.FMaj13,
		ChromaticChord.FFMaj13,
		ChromaticChord.GMaj13,
		ChromaticChord.GGMaj13,
		ChromaticChord.AMaj13,
		ChromaticChord.AAMaj13,
		ChromaticChord.BMaj13
	};

	// Menor treceava mayor
	public static final ChromaticChord		CmMaj13			= new ChromaticChord(
		Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCmMaj13		= new ChromaticChord(
		Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DmMaj13			= new ChromaticChord(
		Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDmMaj13		= new ChromaticChord(
		Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EmMaj13			= new ChromaticChord(
		Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FmMaj13			= new ChromaticChord(
		Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFmMaj13		= new ChromaticChord(
		Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GmMaj13			= new ChromaticChord(
		Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGmMaj13		= new ChromaticChord(
		Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AmMaj13			= new ChromaticChord(
		Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAmMaj13		= new ChromaticChord(
		Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BmMaj13			= new ChromaticChord(
		Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_mMaj13	= new ChromaticChord[] {
		ChromaticChord.CmMaj13,
		ChromaticChord.CCmMaj13,
		ChromaticChord.DmMaj13,
		ChromaticChord.DDmMaj13,
		ChromaticChord.EmMaj13,
		ChromaticChord.FmMaj13,
		ChromaticChord.FFmMaj13,
		ChromaticChord.GmMaj13,
		ChromaticChord.GGmMaj13,
		ChromaticChord.AmMaj13,
		ChromaticChord.AAmMaj13,
		ChromaticChord.BmMaj13
	};

	// Treceava mayor con quinta bemol
	public static final ChromaticChord		CMaj13b5		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13b5		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13b5		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13b5		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13b5		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13b5		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13b5		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13b5		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13b5		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13b5		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13b5		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13b5		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13b5	= new ChromaticChord[] {
		ChromaticChord.CMaj13b5,
		ChromaticChord.CCMaj13b5,
		ChromaticChord.DMaj13b5,
		ChromaticChord.DDMaj13b5,
		ChromaticChord.EMaj13b5,
		ChromaticChord.FMaj13b5,
		ChromaticChord.FFMaj13b5,
		ChromaticChord.GMaj13b5,
		ChromaticChord.GGMaj13b5,
		ChromaticChord.AMaj13b5,
		ChromaticChord.AAMaj13b5,
		ChromaticChord.BMaj13b5
	};

	// Treceava mayor con quinta aumentada
	public static final ChromaticChord		CMaj13a5		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13a5		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13a5		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13a5		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13a5		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13a5		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13a5		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13a5		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13a5		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13a5		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13a5		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13a5		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13a5	= new ChromaticChord[] {
		ChromaticChord.CMaj13a5,
		ChromaticChord.CCMaj13a5,
		ChromaticChord.DMaj13a5,
		ChromaticChord.DDMaj13a5,
		ChromaticChord.EMaj13a5,
		ChromaticChord.FMaj13a5,
		ChromaticChord.FFMaj13a5,
		ChromaticChord.GMaj13a5,
		ChromaticChord.GGMaj13a5,
		ChromaticChord.AMaj13a5,
		ChromaticChord.AAMaj13a5,
		ChromaticChord.BMaj13a5
	};

	// Treceava mayor con novena bemol
	public static final ChromaticChord		CMaj13b9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13b9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13b9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13b9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13b9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13b9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13b9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13b9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13b9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13b9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13b9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13b9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13b9	= new ChromaticChord[] {
		ChromaticChord.CMaj13b9,
		ChromaticChord.CCMaj13b9,
		ChromaticChord.DMaj13b9,
		ChromaticChord.DDMaj13b9,
		ChromaticChord.EMaj13b9,
		ChromaticChord.FMaj13b9,
		ChromaticChord.FFMaj13b9,
		ChromaticChord.GMaj13b9,
		ChromaticChord.GGMaj13b9,
		ChromaticChord.AMaj13b9,
		ChromaticChord.AAMaj13b9,
		ChromaticChord.BMaj13b9
	};

	// Treceava mayor con novena aumentada
	public static final ChromaticChord		CMaj13a9		= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13a9		= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13a9		= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13a9		= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13a9		= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13a9		= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13a9		= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13a9		= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13a9		= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13a9		= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13a9		= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13a9		= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13a9	= new ChromaticChord[] {
		ChromaticChord.CMaj13a9,
		ChromaticChord.CCMaj13a9,
		ChromaticChord.DMaj13a9,
		ChromaticChord.DDMaj13a9,
		ChromaticChord.EMaj13a9,
		ChromaticChord.FMaj13a9,
		ChromaticChord.FFMaj13a9,
		ChromaticChord.GMaj13a9,
		ChromaticChord.GGMaj13a9,
		ChromaticChord.AMaj13a9,
		ChromaticChord.AAMaj13a9,
		ChromaticChord.BMaj13a9
	};

	// Treceava mayor con quinta y novena bemoles
	public static final ChromaticChord		CMaj13b5b9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13b5b9			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13b5b9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13b5b9			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13b5b9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13b5b9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13b5b9			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13b5b9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13b5b9			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13b5b9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13b5b9			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13b5b9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13b5b9	= new ChromaticChord[] {
		ChromaticChord.CMaj13b5b9,
		ChromaticChord.CCMaj13b5b9,
		ChromaticChord.DMaj13b5b9,
		ChromaticChord.DDMaj13b5b9,
		ChromaticChord.EMaj13b5b9,
		ChromaticChord.FMaj13b5b9,
		ChromaticChord.FFMaj13b5b9,
		ChromaticChord.GMaj13b5b9,
		ChromaticChord.GGMaj13b5b9,
		ChromaticChord.AMaj13b5b9,
		ChromaticChord.AAMaj13b5b9,
		ChromaticChord.BMaj13b5b9
	};

	// Treceava mayor con novena aumentada
	public static final ChromaticChord		CMaj13b5a9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13b5a9			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13b5a9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13b5a9			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13b5a9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13b5a9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13b5a9			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13b5a9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13b5a9			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13b5a9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13b5a9			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13b5a9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13b5a9	= new ChromaticChord[] {
		ChromaticChord.CMaj13b5a9,
		ChromaticChord.CCMaj13b5a9,
		ChromaticChord.DMaj13b5a9,
		ChromaticChord.DDMaj13b5a9,
		ChromaticChord.EMaj13b5a9,
		ChromaticChord.FMaj13b5a9,
		ChromaticChord.FFMaj13b5a9,
		ChromaticChord.GMaj13b5a9,
		ChromaticChord.GGMaj13b5a9,
		ChromaticChord.AMaj13b5a9,
		ChromaticChord.AAMaj13b5a9,
		ChromaticChord.BMaj13b5a9
	};

	// Treceava mayor con quinta aumentada y novena bemol
	public static final ChromaticChord		CMaj13a5b9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13a5b9			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13a5b9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13a5b9			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13a5b9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13a5b9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13a5b9			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13a5b9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13a5b9			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13a5b9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13a5b9			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13a5b9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13a5b9	= new ChromaticChord[] {
		ChromaticChord.CMaj13a5b9,
		ChromaticChord.CCMaj13a5b9,
		ChromaticChord.DMaj13a5b9,
		ChromaticChord.DDMaj13a5b9,
		ChromaticChord.EMaj13a5b9,
		ChromaticChord.FMaj13a5b9,
		ChromaticChord.FFMaj13a5b9,
		ChromaticChord.GMaj13a5b9,
		ChromaticChord.GGMaj13a5b9,
		ChromaticChord.AMaj13a5b9,
		ChromaticChord.AAMaj13a5b9,
		ChromaticChord.BMaj13a5b9
	};

	// Treceava mayor con quinta y novena aumentadas
	public static final ChromaticChord		CMaj13a5a9			= new ChromaticChord(
		Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A
	);
	public static final ChromaticChord		CCMaj13a5a9			= new ChromaticChord(
		Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA
	);
	public static final ChromaticChord		DMaj13a5a9			= new ChromaticChord(
		Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B
	);
	public static final ChromaticChord		DDMaj13a5a9			= new ChromaticChord(
		Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C
	);
	public static final ChromaticChord		EMaj13a5a9			= new ChromaticChord(
		Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC
	);
	public static final ChromaticChord		FMaj13a5a9			= new ChromaticChord(
		Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D
	);
	public static final ChromaticChord		FFMaj13a5a9			= new ChromaticChord(
		Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD
	);
	public static final ChromaticChord		GMaj13a5a9			= new ChromaticChord(
		Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E
	);
	public static final ChromaticChord		GGMaj13a5a9			= new ChromaticChord(
		Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F
	);
	public static final ChromaticChord		AMaj13a5a9			= new ChromaticChord(
		Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF
	);
	public static final ChromaticChord		AAMaj13a5a9			= new ChromaticChord(
		Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G
	);
	public static final ChromaticChord		BMaj13a5a9			= new ChromaticChord(
		Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG
	);
	public static final ChromaticChord[]	CHORDS_Maj13a5a9	= new ChromaticChord[] {
		ChromaticChord.CMaj13a5a9,
		ChromaticChord.CCMaj13a5a9,
		ChromaticChord.DMaj13a5a9,
		ChromaticChord.DDMaj13a5a9,
		ChromaticChord.EMaj13a5a9,
		ChromaticChord.FMaj13a5a9,
		ChromaticChord.FFMaj13a5a9,
		ChromaticChord.GMaj13a5a9,
		ChromaticChord.GGMaj13a5a9,
		ChromaticChord.AMaj13a5a9,
		ChromaticChord.AAMaj13a5a9,
		ChromaticChord.BMaj13a5a9
	};

	public static final ChromaticChord		Csusa4			= new ChromaticChord(
		Chromatic.C, Chromatic.FF, Chromatic.G
	);
	public static final ChromaticChord		CCsusa4			= new ChromaticChord(
		Chromatic.CC, Chromatic.G, Chromatic.GG
	);
	public static final ChromaticChord		Dsusa4			= new ChromaticChord(
		Chromatic.D, Chromatic.GG, Chromatic.A
	);
	public static final ChromaticChord		DDsusa4			= new ChromaticChord(
		Chromatic.DD, Chromatic.A, Chromatic.AA
	);
	public static final ChromaticChord		Esusa4			= new ChromaticChord(
		Chromatic.E, Chromatic.AA, Chromatic.B
	);
	public static final ChromaticChord		Fsusa4			= new ChromaticChord(
		Chromatic.F, Chromatic.B, Chromatic.C
	);
	public static final ChromaticChord		FFsusa4			= new ChromaticChord(
		Chromatic.FF, Chromatic.C, Chromatic.CC
	);
	public static final ChromaticChord		Gsusa4			= new ChromaticChord(
		Chromatic.G, Chromatic.CC, Chromatic.D
	);
	public static final ChromaticChord		GGsusa4			= new ChromaticChord(
		Chromatic.GG, Chromatic.D, Chromatic.DD
	);
	public static final ChromaticChord		Asusa4			= new ChromaticChord(
		Chromatic.A, Chromatic.DD, Chromatic.E
	);
	public static final ChromaticChord		AAsusa4			= new ChromaticChord(
		Chromatic.AA, Chromatic.E, Chromatic.F
	);
	public static final ChromaticChord		Bsusa4			= new ChromaticChord(
		Chromatic.B, Chromatic.F, Chromatic.FF
	);
	public static final ChromaticChord[]	CHORDS_SUSa4	= new ChromaticChord[] {
		ChromaticChord.Csusa4,
		ChromaticChord.CCsusa4,
		ChromaticChord.Dsusa4,
		ChromaticChord.DDsusa4,
		ChromaticChord.Esusa4,
		ChromaticChord.Fsusa4,
		ChromaticChord.FFsusa4,
		ChromaticChord.Gsusa4,
		ChromaticChord.GGsusa4,
		ChromaticChord.Asusa4,
		ChromaticChord.AAsusa4,
		ChromaticChord.Bsusa4
	};

	public static final ChromaticChord		Csusb2			= new ChromaticChord(
		Chromatic.C, Chromatic.CC, Chromatic.G
	);
	public static final ChromaticChord		CCsusb2			= new ChromaticChord(
		Chromatic.CC, Chromatic.D, Chromatic.GG
	);
	public static final ChromaticChord		Dsusb2			= new ChromaticChord(
		Chromatic.D, Chromatic.DD, Chromatic.A
	);
	public static final ChromaticChord		DDsusb2			= new ChromaticChord(
		Chromatic.DD, Chromatic.E, Chromatic.AA
	);
	public static final ChromaticChord		Esusb2			= new ChromaticChord(
		Chromatic.E, Chromatic.F, Chromatic.B
	);
	public static final ChromaticChord		Fsusb2			= new ChromaticChord(
		Chromatic.F, Chromatic.FF, Chromatic.C
	);
	public static final ChromaticChord		FFsusb2			= new ChromaticChord(
		Chromatic.FF, Chromatic.G, Chromatic.CC
	);
	public static final ChromaticChord		Gsusb2			= new ChromaticChord(
		Chromatic.G, Chromatic.GG, Chromatic.D
	);
	public static final ChromaticChord		GGsusb2			= new ChromaticChord(
		Chromatic.GG, Chromatic.A, Chromatic.DD
	);
	public static final ChromaticChord		Asusb2			= new ChromaticChord(
		Chromatic.A, Chromatic.AA, Chromatic.E
	);
	public static final ChromaticChord		AAsusb2			= new ChromaticChord(
		Chromatic.AA, Chromatic.B, Chromatic.F
	);
	public static final ChromaticChord		Bsusb2			= new ChromaticChord(
		Chromatic.B, Chromatic.C, Chromatic.FF
	);
	public static final ChromaticChord[]	CHORDS_SUSb2	= new ChromaticChord[] {
		ChromaticChord.Csusb2,
		ChromaticChord.CCsusb2,
		ChromaticChord.Dsusb2,
		ChromaticChord.DDsusb2,
		ChromaticChord.Esusb2,
		ChromaticChord.Fsusb2,
		ChromaticChord.FFsusb2,
		ChromaticChord.Gsusb2,
		ChromaticChord.GGsusb2,
		ChromaticChord.Asusb2,
		ChromaticChord.AAsusb2,
		ChromaticChord.Bsusb2
	};

	public static final ChromaticChord		Csusb2b5		= new ChromaticChord(
		Chromatic.C, Chromatic.CC, Chromatic.FF
	);
	public static final ChromaticChord		CCsusb2b5		= new ChromaticChord(
		Chromatic.CC, Chromatic.D, Chromatic.G
	);
	public static final ChromaticChord		Dsusb2b5		= new ChromaticChord(
		Chromatic.D, Chromatic.DD, Chromatic.GG
	);
	public static final ChromaticChord		DDsusb2b5		= new ChromaticChord(
		Chromatic.DD, Chromatic.E, Chromatic.A
	);
	public static final ChromaticChord		Esusb2b5		= new ChromaticChord(
		Chromatic.E, Chromatic.F, Chromatic.AA
	);
	public static final ChromaticChord		Fsusb2b5		= new ChromaticChord(
		Chromatic.F, Chromatic.FF, Chromatic.B
	);
	public static final ChromaticChord		FFsusb2b5		= new ChromaticChord(
		Chromatic.FF, Chromatic.G, Chromatic.C
	);
	public static final ChromaticChord		Gsusb2b5		= new ChromaticChord(
		Chromatic.G, Chromatic.GG, Chromatic.CC
	);
	public static final ChromaticChord		GGsusb2b5		= new ChromaticChord(
		Chromatic.GG, Chromatic.A, Chromatic.D
	);
	public static final ChromaticChord		Asusb2b5		= new ChromaticChord(
		Chromatic.A, Chromatic.AA, Chromatic.DD
	);
	public static final ChromaticChord		AAsusb2b5		= new ChromaticChord(
		Chromatic.AA, Chromatic.B, Chromatic.E
	);
	public static final ChromaticChord		Bsusb2b5		= new ChromaticChord(
		Chromatic.B, Chromatic.C, Chromatic.F
	);
	public static final ChromaticChord[]	CHORDS_SUSb2b5	= new ChromaticChord[] {
		ChromaticChord.Csusb2b5,
		ChromaticChord.CCsusb2b5,
		ChromaticChord.Dsusb2b5,
		ChromaticChord.DDsusb2b5,
		ChromaticChord.Esusb2b5,
		ChromaticChord.Fsusb2b5,
		ChromaticChord.FFsusb2b5,
		ChromaticChord.Gsusb2b5,
		ChromaticChord.GGsusb2b5,
		ChromaticChord.Asusb2b5,
		ChromaticChord.AAsusb2b5,
		ChromaticChord.Bsusb2b5
	};

	public static final ChromaticChord[][]	UNUSUAL_CHORDS_GROUPS	= {
		CHORDS_SUSb2,
		CHORDS_SUSa4,
		CHORDS_SUSb2b5
	};
	public static final ChromaticChord[]	UNUSUAL_CHORDS			= (ChromaticChord[]) ArrayUtils
			.concat( UNUSUAL_CHORDS_GROUPS );

	public static final ChromaticChord[][]	TRIAD_CHORDS_GROUP	= {
		CHORDS_MAJOR,
		CHORDS_MINOR,
		CHORDS_DIMINISHED,
		CHORDS_AUGMENTED,
		CHORDS_SUS4,
		CHORDS_SUS2
	};
	public static final ChromaticChord[]	TRIAD_CHORDS		= (ChromaticChord[]) ArrayUtils
			.concat( TRIAD_CHORDS_GROUP );

	public static final ChromaticChord[][]	SEVENTH_CHORDS_GROUP	= {
		CHORDS_7,
		CHORDS_Maj7,
		CHORDS_m7,
		CHORDS_7b5,
		CHORDS_mMaj7,
		CHORDS_7a5,
		CHORDS_m7a5,
		CHORDS_m7b5,
		CHORDS_7add11,
		CHORDS_7add13
	};
	public static final ChromaticChord[]	SEVENTH_CHORDS			= (ChromaticChord[]) ArrayUtils
			.concat( SEVENTH_CHORDS_GROUP );

	public static final ChromaticChord[][]	SIXTH_CHORDS_GROUP	= {
		CHORDS_6,
		CHORDS_m6,
		CHORDS_6sus4,
		CHORDS_6add9,
		CHORDS_m6add9
	};
	public static final ChromaticChord[]	SIXTH_CHORDS		= (ChromaticChord[]) ArrayUtils
			.concat( SIXTH_CHORDS_GROUP );

	public static final ChromaticChord[][]	NINTH_CHORDS_GROUP	= {
		CHORDS_7b9,
		CHORDS_7a9,
		CHORDS_m7b9,
		CHORDS_9,
		CHORDS_m9,
		CHORDS_9b5,
		CHORDS_9a5,
		CHORDS_9sus4,
		CHORDS_Maj9,
		CHORDS_9add6,
		CHORDS_9a11,
		CHORDS_Maj9a11
	};
	public static final ChromaticChord[]	NINTH_CHORDS		= (ChromaticChord[]) ArrayUtils
			.concat( NINTH_CHORDS_GROUP );

	public static final ChromaticChord[][]	ELEVENTH_CHORDS_GROUP	= {
		CHORDS_11,
		CHORDS_m11,
		CHORDS_11b9,
		CHORDS_11a9,
		CHORDS_Maj11,
		CHORDS_mMaj11
	};
	public static final ChromaticChord[]	ELEVENTH_CHORDS			= (ChromaticChord[]) ArrayUtils
			.concat( ELEVENTH_CHORDS_GROUP );

	public static final ChromaticChord[][]	THIRTEENTH_CHORDS_GROUP	= {
		CHORDS_m13,
		CHORDS_13sus4,
		CHORDS_13b5,
		CHORDS_13a5,
		CHORDS_13b9,
		CHORDS_13a9,
		CHORDS_13b5b9,
		CHORDS_13b5a9,
		CHORDS_13a5b9,
		CHORDS_13a5a9,
		CHORDS_Maj13,
		CHORDS_mMaj13,
		CHORDS_Maj13b5,
		CHORDS_Maj13a5,
		CHORDS_Maj13b9,
		CHORDS_Maj13a9,
		CHORDS_Maj13b5b9,
		CHORDS_Maj13b5a9,
		CHORDS_Maj13a5b9,
		CHORDS_Maj13a5a9
	};
	public static final ChromaticChord[]	THIRTEENTH_CHORDS		= (ChromaticChord[]) ArrayUtils
			.concat( THIRTEENTH_CHORDS_GROUP );

	public static final ChromaticChord[][]	PARTIAL_CHORDS_GROUP	= {
		CHORDS_FIFTH
	};
	public static final ChromaticChord[]	PARTIAL_CHORDS			= (ChromaticChord[]) ArrayUtils
			.concat( PARTIAL_CHORDS_GROUP );

	public static final ChromaticChord[][]	COMMON_CHORDS_GROUP	= (ChromaticChord[][]) ArrayUtils.concat(
		TRIAD_CHORDS_GROUP, SEVENTH_CHORDS_GROUP, SIXTH_CHORDS_GROUP, NINTH_CHORDS_GROUP, ELEVENTH_CHORDS_GROUP, THIRTEENTH_CHORDS_GROUP, PARTIAL_CHORDS_GROUP
	);
	public static final ChromaticChord[]	COMMON_CHORDS		= (ChromaticChord[]) ArrayUtils
			.concat( COMMON_CHORDS_GROUP );

	public static final HashMap<Utils.ArrayWrapInteger, ArrayList<ChromaticChord>> sameOrderChromatics = new HashMap();

	static {
		// Parciales
		for ( ChromaticChord c : CHORDS_FIFTH ) {
			c.meta.quality = Quality.INDETERMINATED;
			c.meta.str = ChordNotation.POWER_CHORD;
		}

		// Triadas
		for ( ChromaticChord c : CHORDS_MAJOR ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR;
		}

		for ( ChromaticChord c : CHORDS_MINOR ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR;
		}

		for ( ChromaticChord c : CHORDS_DIMINISHED ) {
			c.meta.quality = Quality.DIMINISHED;
			c.meta.str = ChordNotation.DIMINISHED;
		}

		for ( ChromaticChord c : CHORDS_AUGMENTED ) {
			c.meta.quality = Quality.AUGMENTED;
			c.meta.str = ChordNotation.AUGMENTED;
		}

		for ( ChromaticChord c : CHORDS_SUS4 ) {
			c.meta.quality = Quality.INDETERMINATED;
			c.meta.str = ChordNotation.SUS4;
		}

		for ( ChromaticChord c : CHORDS_SUS2 ) {
			c.meta.quality = Quality.INDETERMINATED;
			c.meta.str = ChordNotation.SUS2;
		}

		// Séptima
		for ( ChromaticChord c : CHORDS_7 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SEVENTH;
		}

		for ( ChromaticChord c : CHORDS_Maj7 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.SEVENTH;
		}

		for ( ChromaticChord c : CHORDS_m7 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.SEVENTH;
		}

		for ( ChromaticChord c : CHORDS_7b5 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SEVENTH + ChordNotation.b5;
		}

		for ( ChromaticChord c : CHORDS_mMaj7 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.SEVENTH;
		}

		for ( ChromaticChord c : CHORDS_7a5 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SEVENTH + ChordNotation.a5;
		}

		for ( ChromaticChord c : CHORDS_m7a5 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.a5;
		}

		for ( ChromaticChord c : CHORDS_m7b5 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b5;
		}

		for ( ChromaticChord c : CHORDS_7add11 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SEVENTH + ChordNotation.ADD_ELEVENTH;
		}

		for ( ChromaticChord c : CHORDS_7add13 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SEVENTH + ChordNotation.ADD_THIRTEEN;
		}

		// Unusual
		for ( ChromaticChord c : CHORDS_SUSa4 ) {
			c.meta.quality = Quality.INDETERMINATED;
			c.meta.str = ChordNotation.SUSa4;
		}

		for ( ChromaticChord c : CHORDS_SUSb2 ) {
			c.meta.quality = Quality.INDETERMINATED;
			c.meta.str = ChordNotation.SUSb2;
		}

		for ( ChromaticChord c : CHORDS_SUSb2b5 ) {
			c.meta.quality = Quality.INDETERMINATED;
			c.meta.str = ChordNotation.SUSb2b5;
		}

		// Novena
		for ( ChromaticChord c : CHORDS_7b9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SEVENTH + ChordNotation.b9;
		}
		for ( ChromaticChord c : CHORDS_7a9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SEVENTH + ChordNotation.a9;
		}
		for ( ChromaticChord c : CHORDS_m7b9 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b9;
		}
		for ( ChromaticChord c : CHORDS_9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.NINTH;
		}
		for ( ChromaticChord c : CHORDS_m9 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.NINTH;
		}
		for ( ChromaticChord c : CHORDS_9b5 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.NINTH + ChordNotation.b5;
		}
		for ( ChromaticChord c : CHORDS_9a5 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.NINTH + ChordNotation.a5;
		}

		for ( ChromaticChord c : CHORDS_9sus4 ) {
			c.meta.quality = Quality.INDETERMINATED;
			c.meta.str = ChordNotation.NINTH + ChordNotation.SUS4;
		}

		for ( ChromaticChord c : CHORDS_Maj9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.NINTH;
		}

		for ( ChromaticChord c : CHORDS_9add6 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.NINTH + ChordNotation.ADD_SIXTH;
		}

		for ( ChromaticChord c : CHORDS_9a11 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.NINTH + ChordNotation.a11;
		}

		for ( ChromaticChord c : CHORDS_Maj9a11 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.NINTH + ChordNotation.a11;
		}

		// Sexta
		for ( ChromaticChord c : CHORDS_6 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SIXTH;
		}

		for ( ChromaticChord c : CHORDS_m6 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.SIXTH;
		}

		for ( ChromaticChord c : CHORDS_6sus4 ) {
			c.meta.quality = Quality.INDETERMINATED;
			c.meta.str = ChordNotation.SIXTH + ChordNotation.SUS4;
		}

		for ( ChromaticChord c : CHORDS_6add9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.SIXTH + ChordNotation.ADD_NINTH;
		}

		for ( ChromaticChord c : CHORDS_m6add9 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.SIXTH + ChordNotation.ADD_NINTH;
		}

		// Onceava
		for ( ChromaticChord c : CHORDS_11 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.ELEVENTH;
		}

		for ( ChromaticChord c : CHORDS_m11 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.ELEVENTH;
		}

		for ( ChromaticChord c : CHORDS_11b9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.ELEVENTH + ChordNotation.b9;
		}

		for ( ChromaticChord c : CHORDS_11a9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.ELEVENTH + ChordNotation.a9;
		}

		for ( ChromaticChord c : CHORDS_Maj11 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.ELEVENTH;
		}

		for ( ChromaticChord c : CHORDS_mMaj11 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.ELEVENTH;
		}

		// Treceava
		for ( ChromaticChord c : CHORDS_m13 ) {
			c.meta.quality = Quality.MINOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.THIRTEEN;
		}

		for ( ChromaticChord c : CHORDS_13sus4 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.SUS4;
		}

		for ( ChromaticChord c : CHORDS_13b5 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.b5;
		}

		for ( ChromaticChord c : CHORDS_13a5 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.a5;
		}

		for ( ChromaticChord c : CHORDS_13b9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.b9;
		}

		for ( ChromaticChord c : CHORDS_13a9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.a9;
		}

		for ( ChromaticChord c : CHORDS_13b5b9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9;
		}

		for ( ChromaticChord c : CHORDS_13b5a9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9;
		}

		for ( ChromaticChord c : CHORDS_13a5b9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9;
		}

		for ( ChromaticChord c : CHORDS_13a5a9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9;
		}

		for ( ChromaticChord c : CHORDS_Maj13 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN;
		}

		for ( ChromaticChord c : CHORDS_mMaj13 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.THIRTEEN;
		}

		for ( ChromaticChord c : CHORDS_Maj13b5 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5;
		}

		for ( ChromaticChord c : CHORDS_Maj13a5 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5;
		}

		for ( ChromaticChord c : CHORDS_Maj13b9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b9;
		}

		for ( ChromaticChord c : CHORDS_Maj13a9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a9;
		}

		for ( ChromaticChord c : CHORDS_Maj13b5b9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5
					+ ChordNotation.b9;
		}

		for ( ChromaticChord c : CHORDS_Maj13b5a9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5
					+ ChordNotation.a9;
		}

		for ( ChromaticChord c : CHORDS_Maj13a5b9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5
					+ ChordNotation.b9;
		}

		for ( ChromaticChord c : CHORDS_Maj13a5a9 ) {
			c.meta.quality = Quality.MAJOR;
			c.meta.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5
					+ ChordNotation.a9;
		}

		for ( ChromaticChord[] group : ArrayUtils.concat( COMMON_CHORDS_GROUP, UNUSUAL_CHORDS_GROUPS ) )
			for ( ChromaticChord c : group ) {
				c.meta.updated = true;
				for ( int i = 0; i < c.size(); i++ ) {
					ChromaticChord c2 = c.duplicate( true );
					if ( i > 0 )
						c2.inv( i );
					Utils.ArrayWrapInteger array = new Utils.ArrayWrapInteger(
						c2.toIntegerChromatics()
					);
					// System.out.println(Arrays.toString(array) + c2);
					ArrayList<ChromaticChord> arrayListChords = sameOrderChromatics.get( array );
					if ( arrayListChords == null )
						arrayListChords = new ArrayList<>();

					assert c2.meta.str != null : c2.notesToString();
					arrayListChords.add( c2 );
					sameOrderChromatics.put( array, arrayListChords );
				}
			}
	}

	public Meta meta = new Meta(); // TODO: protected

	public ChromaticChord(PitchChromaticableSingle... cs) {
		assert cs != null;
		for ( int i = 0; i < cs.length; i++ ) {
			assert cs[i] != null;
			Chromatic c = cs[i].getChromatic();
			add( c );
		}
	}

	public ChromaticChord(PitchChromaticableChord<?, ?, ?> cs) {
		assert cs != null;
		for ( int i = 0; i < cs.size(); i++ ) {
			assert cs.get( i ) != null;
			Chromatic c = cs.get( i ).getChromatic();
			add( c );
		}
	}

	public ChromaticChord(ChromaticFunction f, Tonality t) {
		if ( f == ChromaticFunction.I || f == ChromaticFunction.II || f == ChromaticFunction.III
				|| f == ChromaticFunction.IV || f == ChromaticFunction.V
				|| f == ChromaticFunction.VI || f == ChromaticFunction.VII ) {
			int index = t.get( f.getDegree() ).val();
			add( ChromaticChord.CHORDS_MAJOR[index] );
		} else if ( f == ChromaticFunction.i || f == ChromaticFunction.ii
				|| f == ChromaticFunction.iii
				|| f == ChromaticFunction.iv || f == ChromaticFunction.v
				|| f == ChromaticFunction.vi || f == ChromaticFunction.vii ) {
			int index = t.get( f.getDegree() ).val();
			add( ChromaticChord.CHORDS_MINOR[index] );
		} else if ( f == ChromaticFunction.I0 || f == ChromaticFunction.I0
				|| f == ChromaticFunction.II0 || f == ChromaticFunction.III0
				|| f == ChromaticFunction.IV0 || f == ChromaticFunction.V0
				|| f == ChromaticFunction.VI0 || f == ChromaticFunction.VII0 ) {
			int index = t.get( f.getDegree() ).val();
			add( ChromaticChord.CHORDS_DIMINISHED[index] );
		} else if ( f == ChromaticFunction.N6 ) {
			Chromatic base = t.get( 0 );

			Chromatic n1 = base.add( 1 );
			Chromatic n2 = base.add( 5 );
			Chromatic n3 = base.add( 8 );

			add( n2, n3, n1 ); // Primera inversión
		} else if ( f == ChromaticFunction.I5 || f == ChromaticFunction.II5
				|| f == ChromaticFunction.III5 || f == ChromaticFunction.IV5
				|| f == ChromaticFunction.V5 || f == ChromaticFunction.VI5
				|| f == ChromaticFunction.VII5 ) {
			Degree d = f.getDegree();

			Chromatic n = t.get( d );
			add( n );
			Chromatic n2 = n.add( IntervalChromatic.PERFECT_FIFTH.val() );
			add( n2 );
		} else {
			DiatonicMidi n = null;
			switch ( f ) {
				case V_II:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
									.getRelativeScaleDiatonic( IntervalDiatonic.SECOND )
						), t
					);
					break;
				case V7_II:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( IntervalDiatonic.SECOND )
						), t
					);
					break;
				case V_III:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
									.getRelativeScaleDiatonic( IntervalDiatonic.THIRD )
						), t
					);
					break;
				case V7_III:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( IntervalDiatonic.THIRD )
						), t
					);
					break;
				case V_IV:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
									.getRelativeScaleDiatonic( IntervalDiatonic.FOURTH )
						), t
					);
					break;
				case V7_IV:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( IntervalDiatonic.FOURTH )
						), t
					);
					break;
				case V_V:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
									.getRelativeScaleDiatonic( IntervalDiatonic.FIFTH )
						), t
					);
					break;
				case V7_V:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( IntervalDiatonic.FIFTH )
						), t
					);
					break;
				case V_VI:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
									.getRelativeScaleDiatonic( IntervalDiatonic.SIXTH )
						), t
					);
					break;
				case V7_VI:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( IntervalDiatonic.SIXTH )
						), t
					);
					break;
				case SUBV7:
					DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.V7, t );
					t = new Tonality(
						c.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_II:
					DiatonicChordMidi c2 = new DiatonicChordMidi(
						ChromaticFunction.V7_II, t
					);
					t = new Tonality(
						c2.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_III:
					DiatonicChordMidi c3 = new DiatonicChordMidi(
						ChromaticFunction.V7_III, t
					);
					t = new Tonality(
						c3.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_IV:
					DiatonicChordMidi c4 = new DiatonicChordMidi(
						ChromaticFunction.V7_IV, t
					);
					t = new Tonality(
						c4.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_V:
					DiatonicChordMidi c5 = new DiatonicChordMidi(
						ChromaticFunction.V7_V, t
					);
					t = new Tonality(
						c5.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_VI:
					DiatonicChordMidi c6 = new DiatonicChordMidi(
						ChromaticFunction.V7_VI, t
					);
					t = new Tonality(
						c6.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case V7ALT:
					DiatonicChordMidi calt = new DiatonicChordMidi(
						DiatonicFunction.V7, t
					);
					t = new Tonality(
						calt.get( 0 ).toChromaticMidi().getChromatic(), ScaleEnum.SUPERLOCRIAN
					);
					break;
			}

			DiatonicFunction f2 = null;
			switch ( f ) {
				case V_II:
				case V_III:
				case V_IV:
				case V_V:
				case V_VI:
					f2 = DiatonicFunction.I;
					break;
				case V7_II:
				case V7_III:
				case V7_IV:
				case V7_V:
				case V7_VI:
				case SUBV7:
				case SUBV7_II:
				case SUBV7_III:
				case SUBV7_IV:
				case SUBV7_V:
				case SUBV7_VI:
				case V7ALT:
					f2 = DiatonicFunction.I7;
					break; // Ya se ha corregido la escala
			}

			DiatonicChord dc = new DiatonicChord( f2 );
			ChromaticChord cc = dc.toChromatic( t );
			add( cc );
		}

	}

	public ChromaticChord duplicate(boolean b) {
		Chromatic[] a = new Chromatic[size()];
		a = this.toArray( a );

		ChromaticChord ca = new ChromaticChord( a );
		ca.assignMeta( this );
		return ca;
	}

	public Integer[] toIntegerChromatics() {
		Integer[] out = new Integer[size()];
		for ( int i = 0; i < size(); i++ ) {
			out[i] = get( i ).val();
		}

		return out;
	}

	public ChromaticChord assignMeta(ChromaticChord c) {
		setRoot( c.getRootPos() );
		this.meta.quality = c.meta.quality;
		this.meta.str = c.meta.str;
		this.meta.updated = c.meta.updated;

		return this;
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<ArrayList<ChromaticChord>, PitchChromaticableChord<?, ?, ?>, ChromaticChord> fSelectChord) {
		ArrayWrapInteger a = new ArrayWrapInteger( this.toIntegerChromatics() );
		assert ChromaticChord.sameOrderChromatics != null;
		ArrayList<ChromaticChord> foundChords = ChromaticChord.sameOrderChromatics.get( a );

		if ( foundChords == null ) {
			assert meta != null;
			autoName();
			meta.updated = true;
			return null;
		}

		assert fSelectChord != null;

		ChromaticChord foundChord = fSelectChord.apply( foundChords, this );

		assert foundChord != null;

		this.assignMeta( foundChord );

		assert meta.str != null : foundChord.notesToString();

		meta.updated = true;

		return true;
	}

	public Boolean updateWhatIsIt() {
		return updateWhatIsIt(
			(ArrayList<ChromaticChord> chords, PitchChromaticableChord<?, ?, ?> self) -> {
				return chords.get( 0 );
			}
		);
	}

	public Boolean updateWhatIsItIfNeeded() {
		if ( !meta.updated )
			return updateWhatIsIt();

		return false;
	}

	public String invPartString() {
		if ( getInversionNumber() > 0 )
			return "/" + get( 0 ).toString();
		else
			return "";
	}

	@Override
	public String toString() {
		if ( size() == 0 )
			return ChordNotation.EMPTY_CHORD;

		updateWhatIsItIfNeeded();

		assert meta.str != null : "meta.str es null: " + notesToString();

		return root + meta.str + invPartString();
	}

	public void autoName() {
		Integer[] array = this.integerNotationFromRoot();

		meta.str = "";
		if ( array.length >= 2 )
			if ( array[1] == IntervalChromatic.DIMINISHED_THIRD.val()
					&& array[2] == IntervalChromatic.DIMINISHED_FIFTH.val() )
				meta.str += ChordNotation.DIMINISHED;
			else if ( array[1] == IntervalChromatic.DIMINISHED_THIRD.val()
					&& array[2] == IntervalChromatic.PERFECT_FIFTH.val() )
				meta.str += ChordNotation.MINOR;
			else {
				if ( array[1] == IntervalChromatic.MINOR_SECOND.val() )
					meta.str += ChordNotation.SUSb2;
				else if ( array[1] == IntervalChromatic.MAJOR_SECOND.val() )
					meta.str += ChordNotation.SUS2;

				if ( array[1] == IntervalChromatic.DIMINISHED_FOURTH.val() )
					meta.str += ChordNotation.SUSb4;
				else if ( array[1] == IntervalChromatic.AUGMENTED_FOURTH.val() )
					meta.str += ChordNotation.SUSa4;

				if ( array[1] == IntervalChromatic.DIMINISHED_FIFTH.val() )
					meta.str += ChordNotation.b5;
			}

		if ( array.length >= 4 )
			if ( array[3] == IntervalChromatic.MINOR_SEVENTH.val() )
				meta.str += ChordNotation.SEVENTH;
			else if ( array[3] == IntervalChromatic.MAJOR_SEVENTH.val() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.SEVENTH;
			else if ( array[3] == IntervalChromatic.DIMINISHED_SEVENTH.val() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.SEVENTH;

		if ( array.length >= 5 )
			if ( array[4] == IntervalChromatic.MAJOR_NINTH.val() )
				meta.str += ChordNotation.NINTH;
			else if ( array[4] == IntervalChromatic.AUGMENTED_NINTH.val() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.NINTH;
			else if ( array[4] == IntervalChromatic.MINOR_NINTH.val() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.NINTH;

		if ( array.length >= 6 )
			if ( array[5] == IntervalChromatic.PERFECT_ELEVENTH.val() )
				meta.str += ChordNotation.ELEVENTH;
			else if ( array[5] == IntervalChromatic.AUGMENTED_ELEVENTH.val() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.ELEVENTH;
			else if ( array[5] == IntervalChromatic.DIMINISHED_ELEVENTH.val() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.ELEVENTH;

		if ( array.length >= 7 )
			if ( array[5] == IntervalChromatic.MINOR_THIRTEENTH.val() )
				meta.str += ChordNotation.THIRTEEN;
			else if ( array[5] == IntervalChromatic.MAJOR_THIRTEENTH.val() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.THIRTEEN;
			else if ( array[5] == IntervalChromatic.DIMINISHED_THIRTEENTH.val() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.THIRTEEN;

		if ( meta.str.equals( "" ) )
			meta.str = null;
	}

	public <A extends Chord<Chromatic, ChromaticChord, ?>> boolean hasSameNotesOrder(A notes) {
		if ( size() != notes.size() || size() == 0 )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ).val() != notes.get( i ).val() )
				return false;
		}

		return true;
	}

	public boolean has(Chromatic n) {
		for ( Chromatic n2 : this ) {
			if ( n2.equals( n ) )
				return true;
		}

		return false;
	}

	public class Meta { // TODO: protected
		public Quality	quality;
		public String	str;
		public boolean	updated	= false;
	}

	public Quality getQuality() {
		return meta.quality;
	}

	public ChromaticChord[] getModalChords(Tonality t) {
		HarmonicFunction f = t.getFunction( this );
		if ( f == null || f instanceof ChromaticFunction )
			return null;

		DiatonicFunction fCasted = (DiatonicFunction) f;
		Tonality[] ts = t.getModesSameRoot();

		int i = 0;
		ChromaticChord[] ret = new ChromaticChord[t.length()];
		for ( Tonality t2 : ts )
			ret[i++] = t2.get( fCasted );

		return ret;
	}

	@Override
	public ChromaticChord newArray() {
		return new ChromaticChord();
	}

	@Override
	public float getPitchMean() {
		int sum = 0, oct = 0;
		Chromatic last = null;
		for ( Chromatic c : this ) {
			if ( last != null && c.val() <= last.val() )
				oct++;
			sum += oct * ChromaticMidi.NOTES_PER_OCTAVE + c.val();
		}
		return ( (float) sum ) / size();
	}

	@Override
	public DiatonicChordMidi toDiatonicChordMidi(Tonality ton) throws TonalityException {
		return this.toMidi().toDiatonicChordMidi( ton );
	}

	public boolean isSus4() {
		return this.equalsEnharmonicInvArray( CHORDS_SUS4 )
				|| this.equalsEnharmonicInvArray( CHORDS_SUSa4 );
	}

	public boolean isSus2() {
		return this.equalsEnharmonicInvArray( CHORDS_SUS2 ) || this.equalsEnharmonicInvArray(
			CHORDS_SUSb2
		) || this.equalsEnharmonicInvArray( CHORDS_SUSb2b5 );
	}

	@Override
	public void removeHigherDuplicates() {
		// TODO Auto-generated method stub

	}

	public ChromaticChordMidi toMidi(int octave, int length, int velocity) {
		resetRootIfNeeded();
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		for ( Chromatic c : this ) {
			ccm.addNoReset( c.toMidi( octave, length, velocity ) );
			if ( c == root )
				ccm.setRoot( ccm.size() - 1 );
		}

		ccm.meta = this;

		ccm.setArpegioIfNull();

		return ccm;
	}

	public ChromaticChordMidi toMidi(int octave, int length) {
		return toMidi( octave, length, Settings.DefaultValues.VELOCITY );
	}

	public ChromaticChordMidi toMidi(int octave) {
		return toMidi( octave, Settings.DefaultValues.DURATION_CHORD );
	}

	public ChromaticChordMidi toMidi() {
		return toMidi( Settings.DefaultValues.OCTAVE );
	}

	public ChromaticChord rename(Tonality ton) {
		assert ton != null;
		int rp = getRootPos();
		for ( int i = 0; i < size(); i++ ) {
			Chromatic c = get( i );
			assert c != null : i + " " + this.notesToString();
			Chromatic c2 = c.rename( ton );
			assert c2 != null;
			set( i, c2 );
		}

		setRoot( rp );

		return this;
	}
}
