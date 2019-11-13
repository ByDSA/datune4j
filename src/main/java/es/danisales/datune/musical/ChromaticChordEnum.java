package es.danisales.datune.musical;

import es.danisales.datastructures.EnumTreeSet;
import es.danisales.datastructures.SetUtils;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.annotation.Nonnull;
import java.util.*;

public enum ChromaticChordEnum implements PitchChromaticChord<Chromatic>, ChromaticChordInterface {
	// Quintas
	C5(ChromaticChordMeta.POWER_CHORD, Chromatic.C, Chromatic.G),
	CC5(ChromaticChordMeta.POWER_CHORD, Chromatic.CC, Chromatic.GG),
	D5(ChromaticChordMeta.POWER_CHORD, Chromatic.D, Chromatic.A),
	DD5(ChromaticChordMeta.POWER_CHORD, Chromatic.DD, Chromatic.AA),
	E5(ChromaticChordMeta.POWER_CHORD, Chromatic.E, Chromatic.B),
	F5(ChromaticChordMeta.POWER_CHORD, Chromatic.F, Chromatic.C),
	FF5(ChromaticChordMeta.POWER_CHORD, Chromatic.FF, Chromatic.CC),
	G5(ChromaticChordMeta.POWER_CHORD, Chromatic.G, Chromatic.D),
	GG5(ChromaticChordMeta.POWER_CHORD, Chromatic.GG, Chromatic.DD),
	A5(ChromaticChordMeta.POWER_CHORD, Chromatic.A, Chromatic.E),
	AA5(ChromaticChordMeta.POWER_CHORD, Chromatic.AA, Chromatic.F),
	B5(ChromaticChordMeta.POWER_CHORD, Chromatic.B, Chromatic.FF),

	// Mayores
	C(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.C, Chromatic.E, Chromatic.G),
	CC(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.CC, Chromatic.F, Chromatic.GG),
	D(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.D, Chromatic.FF, Chromatic.A),
	DD(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.DD, Chromatic.G, Chromatic.AA),
	E(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.E, Chromatic.GG, Chromatic.B),
	F(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.F, Chromatic.A, Chromatic.C),
	FF(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.FF, Chromatic.AA, Chromatic.CC),
	G(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.G, Chromatic.B, Chromatic.D),
	GG(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.GG, Chromatic.C, Chromatic.DD),
	A(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.A, Chromatic.CC, Chromatic.E),
	AA(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.AA, Chromatic.D, Chromatic.F),
	B(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.B, Chromatic.DD, Chromatic.FF),

	// Menores
	Cm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.C, Chromatic.DD, Chromatic.G),
	CCm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.CC, Chromatic.E, Chromatic.GG),
	Dm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.D, Chromatic.F, Chromatic.A),
	DDm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	Em(ChromaticChordMeta.TRIAD_MINOR, Chromatic.E, Chromatic.G, Chromatic.B),
	Fm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.F, Chromatic.GG, Chromatic.C),
	FFm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.FF, Chromatic.A, Chromatic.CC),
	Gm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.G, Chromatic.AA, Chromatic.D),
	GGm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.GG, Chromatic.B, Chromatic.DD),
	Am(ChromaticChordMeta.TRIAD_MINOR, Chromatic.A, Chromatic.C, Chromatic.E),
	AAm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.AA, Chromatic.CC, Chromatic.F),
	Bm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.B, Chromatic.D, Chromatic.FF),

	// Aumentados
	Caug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.C, Chromatic.E, Chromatic.GG),
	CCaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.CC, Chromatic.F, Chromatic.A),
	Daug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.D, Chromatic.FF, Chromatic.AA),
	DDaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.DD, Chromatic.G, Chromatic.B),
	Eaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.E, Chromatic.GG, Chromatic.C),
	Faug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.F, Chromatic.A, Chromatic.CC),
	FFaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.FF, Chromatic.AA, Chromatic.D),
	Gaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.G, Chromatic.B, Chromatic.DD),
	GGaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.GG, Chromatic.C, Chromatic.E),
	Aaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.A, Chromatic.CC, Chromatic.F),
	AAaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.AA, Chromatic.D, Chromatic.FF),
	Baug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.B, Chromatic.DD, Chromatic.G),

	// Diminuidos
	Cdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.C, Chromatic.DD, Chromatic.FF),
	CCdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.CC, Chromatic.E, Chromatic.G),
	Ddim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.D, Chromatic.F, Chromatic.GG),
	DDdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.DD, Chromatic.FF, Chromatic.A),
	Edim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.E, Chromatic.G, Chromatic.AA),
	Fdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.F, Chromatic.GG, Chromatic.B),
	FFdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.FF, Chromatic.A, Chromatic.C),
	Gdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.G, Chromatic.AA, Chromatic.CC),
	GGdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.GG, Chromatic.B, Chromatic.D),
	Adim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.A, Chromatic.C, Chromatic.DD),
	AAdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.AA, Chromatic.CC, Chromatic.E),
	Bdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.B, Chromatic.D, Chromatic.F),

	// Cuarta suspendida
	Csus4(ChromaticChordMeta.SUS4, Chromatic.C, Chromatic.F, Chromatic.G),
	CCsus4(ChromaticChordMeta.SUS4,Chromatic.CC, Chromatic.FF, Chromatic.GG),
	Dsus4(ChromaticChordMeta.SUS4,Chromatic.D, Chromatic.G, Chromatic.A),
	DDsus4(ChromaticChordMeta.SUS4,Chromatic.DD, Chromatic.GG, Chromatic.AA),
	Esus4(ChromaticChordMeta.SUS4,Chromatic.E, Chromatic.A, Chromatic.B),
	Fsus4(ChromaticChordMeta.SUS4,Chromatic.F, Chromatic.AA, Chromatic.C),
	FFsus4(ChromaticChordMeta.SUS4,Chromatic.FF, Chromatic.B, Chromatic.CC),
	Gsus4(ChromaticChordMeta.SUS4,Chromatic.G, Chromatic.C, Chromatic.D),
	GGsus4(ChromaticChordMeta.SUS4,Chromatic.GG, Chromatic.CC, Chromatic.DD),
	Asus4(ChromaticChordMeta.SUS4,Chromatic.A, Chromatic.D, Chromatic.E),
	AAsus4(ChromaticChordMeta.SUS4,Chromatic.AA, Chromatic.DD, Chromatic.F),
	Bsus4(ChromaticChordMeta.SUS4,Chromatic.B, Chromatic.E, Chromatic.FF),

	// Segunda suspendida
	Csus2(ChromaticChordMeta.SUS2,Chromatic.C, Chromatic.D, Chromatic.G),
	CCsus2(ChromaticChordMeta.SUS2,Chromatic.CC, Chromatic.DD, Chromatic.GG),
	Dsus2(ChromaticChordMeta.SUS2,Chromatic.D, Chromatic.E, Chromatic.A),
	DDsus2(ChromaticChordMeta.SUS2,Chromatic.DD, Chromatic.F, Chromatic.AA),
	Esus2(ChromaticChordMeta.SUS2,Chromatic.E, Chromatic.FF, Chromatic.B),
	Fsus2(ChromaticChordMeta.SUS2,Chromatic.F, Chromatic.G, Chromatic.C),
	FFsus2(ChromaticChordMeta.SUS2,Chromatic.FF, Chromatic.GG, Chromatic.CC),
	Gsus2(ChromaticChordMeta.SUS2,Chromatic.G, Chromatic.A, Chromatic.D),
	GGsus2(ChromaticChordMeta.SUS2,Chromatic.GG, Chromatic.AA, Chromatic.DD),
	Asus2(ChromaticChordMeta.SUS2,Chromatic.A, Chromatic.B, Chromatic.E),
	AAsus2(ChromaticChordMeta.SUS2,Chromatic.AA, Chromatic.C, Chromatic.F),
	Bsus2(ChromaticChordMeta.SUS2,Chromatic.B, Chromatic.CC, Chromatic.FF),

	// S�ptima (de dominante)
	C7(ChromaticChordMeta.SEVENTH, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA),
	CC7(ChromaticChordMeta.SEVENTH, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B),
	D7(ChromaticChordMeta.SEVENTH, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C),
	DD7(ChromaticChordMeta.SEVENTH, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC),
	E7(ChromaticChordMeta.SEVENTH, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D),
	F7(ChromaticChordMeta.SEVENTH, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD),
	FF7(ChromaticChordMeta.SEVENTH, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E),
	G7(ChromaticChordMeta.SEVENTH, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F),
	GG7(ChromaticChordMeta.SEVENTH, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF),
	A7(ChromaticChordMeta.SEVENTH, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G),
	AA7(ChromaticChordMeta.SEVENTH, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG),
	B7(ChromaticChordMeta.SEVENTH, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A),

	// S�ptima con quinta bemol
	C7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	CC7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	D7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	DD7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),
	E7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	F7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	FF7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	G7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	GG7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	A7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	AA7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),
	B7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),

	// S�ptima con quinta aumentada
	C7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA),
	CC7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B),
	D7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C),
	DD7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC),
	E7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D),
	F7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD),
	FF7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E),
	G7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F),
	GG7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF),
	A7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G),
	AA7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG),
	B7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A),

	// S�ptima con cuarta suspendida
	C7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA),
	CC7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B),
	D7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C),
	DD7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC),
	E7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D),
	F7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD),
	FF7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E),
	G7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F),
	GG7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF),
	A7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G),
	AA7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG),
	B7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A),

	// Menor s�ptima
	Cm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA),
	CCm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B),
	Dm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
	DDm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC),
	Em7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D),
	Fm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD),
	FFm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E),
	Gm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F),
	GGm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF),
	Am7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G),
	AAm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG),
	Bm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A),

	// Menor s�ptima con quinta bemol
	Cm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	CCm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	Dm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	DDm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	Em7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	Fm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	FFm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	Gm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	GGm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	Am7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	AAm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),
	Bm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),

	// Menor s�ptima con quinta aumentada
	Cm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA),
	CCm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B),
	Dm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C),
	DDm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC),
	Em7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D),
	Fm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD),
	FFm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E),
	Gm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F),
	GGm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF),
	Am7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G),
	AAm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG),
	Bm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A),

	// Sexta
	C6(ChromaticChordMeta.SIXTH, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A),
	CC6(ChromaticChordMeta.SIXTH, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA),
	D6(ChromaticChordMeta.SIXTH, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B),
	DD6(ChromaticChordMeta.SIXTH, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C),
	E6(ChromaticChordMeta.SIXTH, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC),
	F6(ChromaticChordMeta.SIXTH, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D),
	FF6(ChromaticChordMeta.SIXTH, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD),
	G6(ChromaticChordMeta.SIXTH, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E),
	GG6(ChromaticChordMeta.SIXTH, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F),
	A6(ChromaticChordMeta.SIXTH, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF),
	AA6(ChromaticChordMeta.SIXTH, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G),
	B6(ChromaticChordMeta.SIXTH, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG),

	// Menor sexta
	Cm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A),
	CCm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA),
	Dm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B),
	DDm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C),
	Em6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC),
	Fm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D),
	FFm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD),
	Gm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E),
	GGm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F),
	Am6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF),
	AAm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G),
	Bm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG),

	// Sexta con cuarta suspendida
	C6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.A),
	CC6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.AA),
	D6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.B),
	DD6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.C),
	E6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.CC),
	F6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.D),
	FF6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.DD),
	G6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.E),
	GG6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.F),
	A6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.FF),
	AA6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.G),
	B6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.GG),

	// S�ptima mayor
	CMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	CCMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	DMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	DDMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	EMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	FMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	FFMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	GMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	GGMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	AMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),
	AAMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	BMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),

	// Menor s�ptima mayor
	CmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	CCmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	DmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	DDmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	EmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	FmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	FFmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),
	GmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	GGmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	AmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),
	AAmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	BmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),

	// Sexta con novena a�adida
	C6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.D),
	CC6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.DD),
	D6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.E),
	DD6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.F),
	E6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.FF),
	F6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.G),
	FF6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.GG),
	G6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.A),
	GG6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.AA),
	A6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.B),
	AA6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.C),
	B6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.CC),

	// Sexta con novena a�adida
	Cm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D),
	CCm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD),
	Dm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E),
	DDm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F),
	Em6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF),
	Fm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G),
	FFm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG),
	Gm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A),
	GGm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA),
	Am6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B),
	AAm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C),
	Bm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC),

	// S�ptima con novena bemol (a�adida)
	C7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC),
	CC7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D),
	D7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD),
	DD7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E),
	E7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F),
	F7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF),
	FF7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G),
	G7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG),
	GG7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A),
	A7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA),
	AA7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B),
	B7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C),

	// S�ptima con novena aumentada (a�adida)
	C7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD),
	CC7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E),
	D7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F),
	DD7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF),
	E7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G),
	F7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG),
	FF7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A),
	G7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA),
	GG7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B),
	A7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C),
	AA7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC),
	B7a9(ChromaticChordMeta.SEVENTH_a9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D),

	// Menor s�ptima con novena bemol (a�adida)
	Cm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC),
	CCm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D),
	Dm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD),
	DDm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E),
	Em7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F),
	Fm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF),
	FFm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G),
	Gm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG),
	GGm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A),
	Am7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA),
	AAm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B),
	Bm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C),

	// S�ptima con oncena (a�adida)
	C7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.F),
	CC7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.FF),
	D7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.G),
	DD7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.GG),
	E7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.A),
	F7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.AA),
	FF7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.B),
	G7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.C),
	GG7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.CC),
	A7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.D),
	AA7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.DD),
	B7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.E),

	// S�ptima con treceava (a�adida)
	C7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.A),
	CC7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.AA),
	D7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.B),
	DD7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.C),
	E7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.CC),
	F7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.D),
	FF7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.DD),
	G7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.E),
	GG7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.F),
	A7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.FF),
	AA7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.G),
	B7add13(ChromaticChordMeta.SEVENTH_ADD13, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.GG),

	// Novena
	C9(ChromaticChordMeta.NINTH, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	CC9(ChromaticChordMeta.NINTH, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	D9(ChromaticChordMeta.NINTH, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	DD9(ChromaticChordMeta.NINTH, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	E9(ChromaticChordMeta.NINTH, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	F9(ChromaticChordMeta.NINTH, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	FF9(ChromaticChordMeta.NINTH, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),
	G9(ChromaticChordMeta.NINTH, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	GG9(ChromaticChordMeta.NINTH, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	A9(ChromaticChordMeta.NINTH, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	AA9(ChromaticChordMeta.NINTH, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	B9(ChromaticChordMeta.NINTH, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),

	// Menor novena
	Cm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	CCm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	Dm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	DDm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	Em9(ChromaticChordMeta.NINTH_MINOR, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	Fm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	FFm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),
	Gm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	GGm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	Am9(ChromaticChordMeta.NINTH_MINOR, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	AAm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	Bm9(ChromaticChordMeta.NINTH_MINOR, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),

	// Novena con quinta bemol
	C9b5(ChromaticChordMeta.NINTH_b5, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D),
	CC9b5(ChromaticChordMeta.NINTH_b5, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD),
	D9b5(ChromaticChordMeta.NINTH_b5, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E),
	DD9b5(ChromaticChordMeta.NINTH_b5, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F),
	E9b5(ChromaticChordMeta.NINTH_b5, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF),
	F9b5(ChromaticChordMeta.NINTH_b5, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G),
	FF9b5(ChromaticChordMeta.NINTH_b5, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG),
	G9b5(ChromaticChordMeta.NINTH_b5, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A),
	GG9b5(ChromaticChordMeta.NINTH_b5, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA),
	A9b5(ChromaticChordMeta.NINTH_b5, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B),
	AA9b5(ChromaticChordMeta.NINTH_b5, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C),
	B9b5(ChromaticChordMeta.NINTH_b5, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC),

	// Novena con quinta aumentada
	C9a5(ChromaticChordMeta.NINTH_a5, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	CC9a5(ChromaticChordMeta.NINTH_a5, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	D9a5(ChromaticChordMeta.NINTH_a5, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	DD9a5(ChromaticChordMeta.NINTH_a5, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	E9a5(ChromaticChordMeta.NINTH_a5, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	F9a5(ChromaticChordMeta.NINTH_a5, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	FF9a5(ChromaticChordMeta.NINTH_a5, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),
	G9a5(ChromaticChordMeta.NINTH_a5, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),
	GG9a5(ChromaticChordMeta.NINTH_a5, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	A9a5(ChromaticChordMeta.NINTH_a5, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	AA9a5(ChromaticChordMeta.NINTH_a5, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	B9a5(ChromaticChordMeta.NINTH_a5, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),

	// Novena con cuarta suspendida
	C9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D),
	CC9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD),
	D9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E),
	DD9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F),
	E9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF),
	F9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G),
	FF9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG),
	G9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A),
	GG9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	A9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B),
	AA9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C),
	B9sus4(ChromaticChordMeta.NINTH_SUS4, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC),

	// Novena mayor
	CMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D),
	CCMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD),
	DMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E),
	DDMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F),
	EMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF),
	FMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G),
	FFMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG),
	GMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A),
	GGMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA),
	AMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B),
	AAMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
	BMaj9(ChromaticChordMeta.NINTH_MAJ9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC),

	// Menor novena mayor
	CmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D),
	CCmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD),
	DmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E),
	DDmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F),
	EmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF),
	FmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G),
	FFmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG),
	GmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A),
	GGmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA),
	AmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B),
	AAmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C),
	BmMaj9(ChromaticChordMeta.NINTH_MINOR_MAJ9, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC),

	// Novena con sexta (a�adida)
	C9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.AA, Chromatic.D),
	CC9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.B, Chromatic.DD),
	D9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.C, Chromatic.E),
	DD9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.CC, Chromatic.F),
	E9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.D, Chromatic.FF),
	F9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.DD, Chromatic.G),
	FF9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.E, Chromatic.GG),
	G9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.F, Chromatic.A),
	GG9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.FF, Chromatic.AA),
	A9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.G, Chromatic.B),
	AA9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.GG, Chromatic.C),
	B9add6(ChromaticChordMeta.NINTH_ADD6, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.A, Chromatic.CC),

	// Novena con onceava aumentada (a�adida)
	C9a11(ChromaticChordMeta.NINTH_a11, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	CC9a11(ChromaticChordMeta.NINTH_a11, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	D9a11(ChromaticChordMeta.NINTH_a11, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),
	DD9a11(ChromaticChordMeta.NINTH_a11, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	E9a11(ChromaticChordMeta.NINTH_a11, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),
	F9a11(ChromaticChordMeta.NINTH_a11, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	FF9a11(ChromaticChordMeta.NINTH_a11, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	G9a11(ChromaticChordMeta.NINTH_a11, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	GG9a11(ChromaticChordMeta.NINTH_a11, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	A9a11(ChromaticChordMeta.NINTH_a11, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	AA9a11(ChromaticChordMeta.NINTH_a11, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	B9a11(ChromaticChordMeta.NINTH_a11, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),

	// Novena mayor con onceava aumentada (a�adida)
	CMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	CCMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	DMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),
	DDMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	EMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	FMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	FFMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	GMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	GGMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	AMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	AAMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	BMaj9a11(ChromaticChordMeta.NINTH_MAJ9_a11, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),

	// Onceava
	C11(ChromaticChordMeta.ELEVENTH, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F),
	CC11(ChromaticChordMeta.ELEVENTH, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF),
	D11(ChromaticChordMeta.ELEVENTH, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G),
	DD11(ChromaticChordMeta.ELEVENTH, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG),
	E11(ChromaticChordMeta.ELEVENTH, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A),
	F11(ChromaticChordMeta.ELEVENTH, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA),
	FF11(ChromaticChordMeta.ELEVENTH, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B),
	G11(ChromaticChordMeta.ELEVENTH, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
	GG11(ChromaticChordMeta.ELEVENTH, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC),
	A11(ChromaticChordMeta.ELEVENTH, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D),
	AA11(ChromaticChordMeta.ELEVENTH, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD),
	B11(ChromaticChordMeta.ELEVENTH, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E),

	// Menor onceava
	Cm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F),
	CCm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF),
	Dm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G),
	DDm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG),
	Em11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A),
	Fm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA),
	FFm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B),
	Gm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
	GGm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC),
	Am11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D),
	AAm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD),
	Bm11(ChromaticChordMeta.ELEVENTH_MINOR, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E),

	// Onceava con novena bemol
	C11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	CC11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	D11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	DD11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),
	E11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	F11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	FF11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	G11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	GG11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	A11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	AA11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	B11b9(ChromaticChordMeta.ELEVENTH_b9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),

	// Onceava con novena aumentada
	C11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F),
	CC11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF),
	D11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G),
	DD11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG),
	E11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A),
	F11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA),
	FF11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B),
	G11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C),
	GG11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC),
	A11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D),
	AA11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD),
	B11a9(ChromaticChordMeta.ELEVENTH_a9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E),

	// Onceava mayor
	CMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F),
	CCMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF),
	DMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G),
	DDMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG),
	EMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A),
	FMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA),
	FFMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B),
	GMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C),
	GGMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC),
	AMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D),
	AAMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD),
	BMaj11(ChromaticChordMeta.ELEVENTH_MAJ11, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E),

	// Menor onceava mayor
	CmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F),
	CCmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF),
	DmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G),
	DDmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG),
	EmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A),
	FmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA),
	FFmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B),
	GmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C),
	GGmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC),
	AmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D),
	AAmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD),
	BmMaj11(ChromaticChordMeta.ELEVENTH_MINOR_MAJ11, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E),

	// Menor treceava
	Cm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	CCm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	Dm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	DDm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	Em13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	Fm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	Gm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	GGm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	Am13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	Bm13(ChromaticChordMeta.THIRTEENTH_MINOR, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava con cuarta suspendida
	C13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	CC13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	D13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	DD13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	E13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	F13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	FF13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	G13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	GG13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	A13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	AA13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	B13sus4(ChromaticChordMeta.THIRTEENTH_SUS4, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava con quinta bemol
	C13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	CC13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	D13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	DD13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	E13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	F13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	FF13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	G13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	GG13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	A13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	AA13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	B13b5(ChromaticChordMeta.THIRTEENTH_b5, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava con quinta aumentada
	C13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	CC13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	D13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	DD13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	E13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	F13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	FF13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	G13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	GG13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	A13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	AA13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	B13a5(ChromaticChordMeta.THIRTEENTH_a5, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava con novena bemol
	C13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	CC13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),
	D13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	DD13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	E13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	F13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FF13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	G13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	GG13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),
	A13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AA13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	B13b9(ChromaticChordMeta.THIRTEENTH_b9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava con novena aumentada
	C13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A),
	CC13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA),
	D13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B),
	DD13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C),
	E13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC),
	F13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FF13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD),
	G13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E),
	GG13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F),
	A13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF),
	AA13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G),
	B13a9(ChromaticChordMeta.THIRTEENTH_a9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava con quinta y novena bemoles
	C13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	CC13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),
	D13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	DD13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	E13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	F13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FF13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	G13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	GG13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),
	A13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AA13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	B13b5b9(ChromaticChordMeta.THIRTEENTH_b5b9, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava con quinta bemol y novena aumentada
	C13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A),
	CC13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA),
	D13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B),
	DD13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C),
	E13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC),
	F13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FF13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD),
	G13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E),
	GG13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F),
	A13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF),
	AA13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G),
	B13b5a9(ChromaticChordMeta.THIRTEENTH_b5a9, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava con quinta aumentada y novena bemol
	C13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	CC13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),
	D13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	DD13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	E13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	F13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FF13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	G13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	GG13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),
	A13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AA13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	B13a5b9(ChromaticChordMeta.THIRTEENTH_a5b9, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava con quinta y novena aumentadas
	C13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A),
	CC13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA),
	D13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B),
	DD13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C),
	E13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC),
	F13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FF13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD),
	G13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E),
	GG13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F),
	A13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF),
	AA13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G),
	B13a5a9(ChromaticChordMeta.THIRTEENTH_a5a9, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava mayor
	CMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	CCMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	DMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	DDMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	EMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	FMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	GMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	GGMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	AMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	BMaj13(ChromaticChordMeta.THIRTEENTH_MAJ13, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Menor treceava mayor
	CmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	CCmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	DmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	DDmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	EmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	FmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	GmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	GGmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	AmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	BmMaj13(ChromaticChordMeta.THIRTEENTH_MINOR_MAJ13, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta bemol
	CMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	CCMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	DMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	DDMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	EMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	FMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	GMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	GGMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	AMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	BMaj13b5(ChromaticChordMeta.THIRTEENTH_MAJ13_b5, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta aumentada
	CMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	CCMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	DMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	DDMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	EMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	FMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	GMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	GGMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	AMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	BMaj13a5(ChromaticChordMeta.THIRTEENTH_MAJ13_a5, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava mayor con novena bemol
	CMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A),
	CCMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA),
	DMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B),
	DDMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C),
	EMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC),
	FMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FFMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD),
	GMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E),
	GGMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F),
	AMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AAMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G),
	BMaj13b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava mayor con novena aumentada
	CMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),
	CCMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	DMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	DDMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	EMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),
	FMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FFMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	GMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	GGMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	AMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	AAMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	BMaj13a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a9, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta y novena bemoles
	CMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A),
	CCMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA),
	DMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B),
	DDMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C),
	EMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC),
	FMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FFMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD),
	GMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E),
	GGMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F),
	AMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AAMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G),
	BMaj13b5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5b9, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava mayor con novena aumentada
	CMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),
	CCMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	DMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	DDMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	EMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),
	FMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FFMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	GMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	GGMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	AMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	AAMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	BMaj13b5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_b5a9, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta aumentada y novena bemol
	CMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A),
	CCMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA),
	DMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B),
	DDMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C),
	EMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC),
	FMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FFMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD),
	GMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E),
	GGMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F),
	AMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AAMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G),
	BMaj13a5b9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5b9,Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta y novena aumentadas
	CMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),
	CCMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	DMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	DDMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	EMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),
	FMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FFMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	GMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	GGMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	AMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	AAMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	BMaj13a5a9(ChromaticChordMeta.THIRTEENTH_MAJ13_a5a9, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),

	Csusa4(ChromaticChordMeta.SUS4a4, Chromatic.C, Chromatic.FF, Chromatic.G),
	CCsusa4(ChromaticChordMeta.SUS4a4, Chromatic.CC, Chromatic.G, Chromatic.GG),
	Dsusa4(ChromaticChordMeta.SUS4a4, Chromatic.D, Chromatic.GG, Chromatic.A),
	DDsusa4(ChromaticChordMeta.SUS4a4, Chromatic.DD, Chromatic.A, Chromatic.AA),
	Esusa4(ChromaticChordMeta.SUS4a4, Chromatic.E, Chromatic.AA, Chromatic.B),
	Fsusa4(ChromaticChordMeta.SUS4a4, Chromatic.F, Chromatic.B, Chromatic.C),
	FFsusa4(ChromaticChordMeta.SUS4a4, Chromatic.FF, Chromatic.C, Chromatic.CC),
	Gsusa4(ChromaticChordMeta.SUS4a4, Chromatic.G, Chromatic.CC, Chromatic.D),
	GGsusa4(ChromaticChordMeta.SUS4a4, Chromatic.GG, Chromatic.D, Chromatic.DD),
	Asusa4(ChromaticChordMeta.SUS4a4, Chromatic.A, Chromatic.DD, Chromatic.E),
	AAsusa4(ChromaticChordMeta.SUS4a4, Chromatic.AA, Chromatic.E, Chromatic.F),
	Bsusa4(ChromaticChordMeta.SUS4a4, Chromatic.B, Chromatic.F, Chromatic.FF),

	Csusb2(ChromaticChordMeta.SUS2b2, Chromatic.C, Chromatic.CC, Chromatic.G),
	CCsusb2(ChromaticChordMeta.SUS2b2, Chromatic.CC, Chromatic.D, Chromatic.GG),
	Dsusb2(ChromaticChordMeta.SUS2b2, Chromatic.D, Chromatic.DD, Chromatic.A),
	DDsusb2(ChromaticChordMeta.SUS2b2, Chromatic.DD, Chromatic.E, Chromatic.AA),
	Esusb2(ChromaticChordMeta.SUS2b2, Chromatic.E, Chromatic.F, Chromatic.B),
	Fsusb2(ChromaticChordMeta.SUS2b2, Chromatic.F, Chromatic.FF, Chromatic.C),
	FFsusb2(ChromaticChordMeta.SUS2b2, Chromatic.FF, Chromatic.G, Chromatic.CC),
	Gsusb2(ChromaticChordMeta.SUS2b2, Chromatic.G, Chromatic.GG, Chromatic.D),
	GGsusb2(ChromaticChordMeta.SUS2b2, Chromatic.GG, Chromatic.A, Chromatic.DD),
	Asusb2(ChromaticChordMeta.SUS2b2, Chromatic.A, Chromatic.AA, Chromatic.E),
	AAsusb2(ChromaticChordMeta.SUS2b2, Chromatic.AA, Chromatic.B, Chromatic.F),
	Bsusb2(ChromaticChordMeta.SUS2b2, Chromatic.B, Chromatic.C, Chromatic.FF),

	Csusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.C, Chromatic.CC, Chromatic.FF),
	CCsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.CC, Chromatic.D, Chromatic.G),
	Dsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.D, Chromatic.DD, Chromatic.GG),
	DDsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.DD, Chromatic.E, Chromatic.A),
	Esusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.E, Chromatic.F, Chromatic.AA),
	Fsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.F, Chromatic.FF, Chromatic.B),
	FFsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.FF, Chromatic.G, Chromatic.C),
	Gsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.G, Chromatic.GG, Chromatic.CC),
	GGsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.GG, Chromatic.A, Chromatic.D),
	Asusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.A, Chromatic.AA, Chromatic.DD),
	AAsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.AA, Chromatic.B, Chromatic.E),
	Bsusb2b5(ChromaticChordMeta.SUS2b2b5, Chromatic.B, Chromatic.C, Chromatic.F);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_FIFTH = EnumSet.of(
			ChromaticChordEnum.C5,
			ChromaticChordEnum.CC5,
			ChromaticChordEnum.D5,
			ChromaticChordEnum.DD5,
			ChromaticChordEnum.E5,
			ChromaticChordEnum.F5,
			ChromaticChordEnum.FF5,
			ChromaticChordEnum.G5,
			ChromaticChordEnum.GG5,
			ChromaticChordEnum.A5,
			ChromaticChordEnum.AA5,
			ChromaticChordEnum.B5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_MAJOR	= EnumSet.of(
			ChromaticChordEnum.C,
			ChromaticChordEnum.CC,
			ChromaticChordEnum.D,
			ChromaticChordEnum.DD,
			ChromaticChordEnum.E,
			ChromaticChordEnum.F,
			ChromaticChordEnum.FF,
			ChromaticChordEnum.G,
			ChromaticChordEnum.GG,
			ChromaticChordEnum.A,
			ChromaticChordEnum.AA,
			ChromaticChordEnum.B
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_MINOR	= EnumSet.of(
			ChromaticChordEnum.Cm,
			ChromaticChordEnum.CCm,
			ChromaticChordEnum.Dm,
			ChromaticChordEnum.DDm,
			ChromaticChordEnum.Em,
			ChromaticChordEnum.Fm,
			ChromaticChordEnum.FFm,
			ChromaticChordEnum.Gm,
			ChromaticChordEnum.GGm,
			ChromaticChordEnum.Am,
			ChromaticChordEnum.AAm,
			ChromaticChordEnum.Bm
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_AUGMENTED	= EnumSet.of(
			ChromaticChordEnum.Caug,
			ChromaticChordEnum.CCaug,
			ChromaticChordEnum.Daug,
			ChromaticChordEnum.DDaug,
			ChromaticChordEnum.Eaug,
			ChromaticChordEnum.Faug,
			ChromaticChordEnum.FFaug,
			ChromaticChordEnum.Gaug,
			ChromaticChordEnum.GGaug,
			ChromaticChordEnum.Aaug,
			ChromaticChordEnum.AAaug,
			ChromaticChordEnum.Baug
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_DIMINISHED	= EnumSet.of(
			ChromaticChordEnum.Cdim,
			ChromaticChordEnum.CCdim,
			ChromaticChordEnum.Ddim,
			ChromaticChordEnum.DDdim,
			ChromaticChordEnum.Edim,
			ChromaticChordEnum.Fdim,
			ChromaticChordEnum.FFdim,
			ChromaticChordEnum.Gdim,
			ChromaticChordEnum.GGdim,
			ChromaticChordEnum.Adim,
			ChromaticChordEnum.AAdim,
			ChromaticChordEnum.Bdim
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_SUS4	= EnumSet.of(
			ChromaticChordEnum.Csus4,
			ChromaticChordEnum.CCsus4,
			ChromaticChordEnum.Dsus4,
			ChromaticChordEnum.DDsus4,
			ChromaticChordEnum.Esus4,
			ChromaticChordEnum.Fsus4,
			ChromaticChordEnum.FFsus4,
			ChromaticChordEnum.Gsus4,
			ChromaticChordEnum.GGsus4,
			ChromaticChordEnum.Asus4,
			ChromaticChordEnum.AAsus4,
			ChromaticChordEnum.Bsus4
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_SUS2	= EnumSet.of(
			ChromaticChordEnum.Csus2,
			ChromaticChordEnum.CCsus2,
			ChromaticChordEnum.Dsus2,
			ChromaticChordEnum.DDsus2,
			ChromaticChordEnum.Esus2,
			ChromaticChordEnum.Fsus2,
			ChromaticChordEnum.FFsus2,
			ChromaticChordEnum.Gsus2,
			ChromaticChordEnum.GGsus2,
			ChromaticChordEnum.Asus2,
			ChromaticChordEnum.AAsus2,
			ChromaticChordEnum.Bsus2
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_7	= EnumSet.of(
			ChromaticChordEnum.C7,
			ChromaticChordEnum.CC7,
			ChromaticChordEnum.D7,
			ChromaticChordEnum.DD7,
			ChromaticChordEnum.E7,
			ChromaticChordEnum.F7,
			ChromaticChordEnum.FF7,
			ChromaticChordEnum.G7,
			ChromaticChordEnum.GG7,
			ChromaticChordEnum.A7,
			ChromaticChordEnum.AA7,
			ChromaticChordEnum.B7
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_7b5	= EnumSet.of(
			ChromaticChordEnum.C7b5,
			ChromaticChordEnum.CC7b5,
			ChromaticChordEnum.D7b5,
			ChromaticChordEnum.DD7b5,
			ChromaticChordEnum.E7b5,
			ChromaticChordEnum.F7b5,
			ChromaticChordEnum.FF7b5,
			ChromaticChordEnum.G7b5,
			ChromaticChordEnum.GG7b5,
			ChromaticChordEnum.A7b5,
			ChromaticChordEnum.AA7b5,
			ChromaticChordEnum.B7b5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_7a5	= EnumSet.of(
			ChromaticChordEnum.C7a5,
			ChromaticChordEnum.CC7a5,
			ChromaticChordEnum.D7a5,
			ChromaticChordEnum.DD7a5,
			ChromaticChordEnum.E7a5,
			ChromaticChordEnum.F7a5,
			ChromaticChordEnum.FF7a5,
			ChromaticChordEnum.G7a5,
			ChromaticChordEnum.GG7a5,
			ChromaticChordEnum.A7a5,
			ChromaticChordEnum.AA7a5,
			ChromaticChordEnum.B7a5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_7sus4	= EnumSet.of(
			ChromaticChordEnum.C7sus4,
			ChromaticChordEnum.CC7sus4,
			ChromaticChordEnum.D7sus4,
			ChromaticChordEnum.DD7sus4,
			ChromaticChordEnum.E7sus4,
			ChromaticChordEnum.F7sus4,
			ChromaticChordEnum.FF7sus4,
			ChromaticChordEnum.G7sus4,
			ChromaticChordEnum.GG7sus4,
			ChromaticChordEnum.A7sus4,
			ChromaticChordEnum.AA7sus4,
			ChromaticChordEnum.B7sus4
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_m7	= EnumSet.of(
			ChromaticChordEnum.Cm7,
			ChromaticChordEnum.CCm7,
			ChromaticChordEnum.Dm7,
			ChromaticChordEnum.DDm7,
			ChromaticChordEnum.Em7,
			ChromaticChordEnum.Fm7,
			ChromaticChordEnum.FFm7,
			ChromaticChordEnum.Gm7,
			ChromaticChordEnum.GGm7,
			ChromaticChordEnum.Am7,
			ChromaticChordEnum.AAm7,
			ChromaticChordEnum.Bm7
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_m7b5	= EnumSet.of(
			ChromaticChordEnum.Cm7b5,
			ChromaticChordEnum.CCm7b5,
			ChromaticChordEnum.Dm7b5,
			ChromaticChordEnum.DDm7b5,
			ChromaticChordEnum.Em7b5,
			ChromaticChordEnum.Fm7b5,
			ChromaticChordEnum.FFm7b5,
			ChromaticChordEnum.Gm7b5,
			ChromaticChordEnum.GGm7b5,
			ChromaticChordEnum.Am7b5,
			ChromaticChordEnum.AAm7b5,
			ChromaticChordEnum.Bm7b5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_m7a5	= EnumSet.of(
			ChromaticChordEnum.Cm7a5,
			ChromaticChordEnum.CCm7a5,
			ChromaticChordEnum.Dm7a5,
			ChromaticChordEnum.DDm7a5,
			ChromaticChordEnum.Em7a5,
			ChromaticChordEnum.Fm7a5,
			ChromaticChordEnum.FFm7a5,
			ChromaticChordEnum.Gm7a5,
			ChromaticChordEnum.GGm7a5,
			ChromaticChordEnum.Am7a5,
			ChromaticChordEnum.AAm7a5,
			ChromaticChordEnum.Bm7a5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_6	= EnumSet.of(
			ChromaticChordEnum.C6,
			ChromaticChordEnum.CC6,
			ChromaticChordEnum.D6,
			ChromaticChordEnum.DD6,
			ChromaticChordEnum.E6,
			ChromaticChordEnum.F6,
			ChromaticChordEnum.FF6,
			ChromaticChordEnum.G6,
			ChromaticChordEnum.GG6,
			ChromaticChordEnum.A6,
			ChromaticChordEnum.AA6,
			ChromaticChordEnum.B6
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_6sus4	= EnumSet.of(
			ChromaticChordEnum.C6sus4,
			ChromaticChordEnum.CC6sus4,
			ChromaticChordEnum.D6sus4,
			ChromaticChordEnum.DD6sus4,
			ChromaticChordEnum.E6sus4,
			ChromaticChordEnum.F6sus4,
			ChromaticChordEnum.FF6sus4,
			ChromaticChordEnum.G6sus4,
			ChromaticChordEnum.GG6sus4,
			ChromaticChordEnum.A6sus4,
			ChromaticChordEnum.AA6sus4,
			ChromaticChordEnum.B6sus4
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj7	= EnumSet.of(
			ChromaticChordEnum.CMaj7,
			ChromaticChordEnum.CCMaj7,
			ChromaticChordEnum.DMaj7,
			ChromaticChordEnum.DDMaj7,
			ChromaticChordEnum.EMaj7,
			ChromaticChordEnum.FMaj7,
			ChromaticChordEnum.FFMaj7,
			ChromaticChordEnum.GMaj7,
			ChromaticChordEnum.GGMaj7,
			ChromaticChordEnum.AMaj7,
			ChromaticChordEnum.AAMaj7,
			ChromaticChordEnum.BMaj7
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_mMaj7	= EnumSet.of(
			ChromaticChordEnum.CmMaj7,
			ChromaticChordEnum.CCmMaj7,
			ChromaticChordEnum.DmMaj7,
			ChromaticChordEnum.DDmMaj7,
			ChromaticChordEnum.EmMaj7,
			ChromaticChordEnum.FmMaj7,
			ChromaticChordEnum.FFmMaj7,
			ChromaticChordEnum.GmMaj7,
			ChromaticChordEnum.GGmMaj7,
			ChromaticChordEnum.AmMaj7,
			ChromaticChordEnum.AAmMaj7,
			ChromaticChordEnum.BmMaj7
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_6add9	= EnumSet.of(
			ChromaticChordEnum.C6add9,
			ChromaticChordEnum.CC6add9,
			ChromaticChordEnum.D6add9,
			ChromaticChordEnum.DD6add9,
			ChromaticChordEnum.E6add9,
			ChromaticChordEnum.F6add9,
			ChromaticChordEnum.FF6add9,
			ChromaticChordEnum.G6add9,
			ChromaticChordEnum.GG6add9,
			ChromaticChordEnum.A6add9,
			ChromaticChordEnum.AA6add9,
			ChromaticChordEnum.B6add9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_m6add9	= EnumSet.of(
			ChromaticChordEnum.Cm6add9,
			ChromaticChordEnum.CCm6add9,
			ChromaticChordEnum.Dm6add9,
			ChromaticChordEnum.DDm6add9,
			ChromaticChordEnum.Em6add9,
			ChromaticChordEnum.Fm6add9,
			ChromaticChordEnum.FFm6add9,
			ChromaticChordEnum.Gm6add9,
			ChromaticChordEnum.GGm6add9,
			ChromaticChordEnum.Am6add9,
			ChromaticChordEnum.AAm6add9,
			ChromaticChordEnum.Bm6add9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_7b9	= EnumSet.of(
			ChromaticChordEnum.C7b9,
			ChromaticChordEnum.CC7b9,
			ChromaticChordEnum.D7b9,
			ChromaticChordEnum.DD7b9,
			ChromaticChordEnum.E7b9,
			ChromaticChordEnum.F7b9,
			ChromaticChordEnum.FF7b9,
			ChromaticChordEnum.G7b9,
			ChromaticChordEnum.GG7b9,
			ChromaticChordEnum.A7b9,
			ChromaticChordEnum.AA7b9,
			ChromaticChordEnum.B7b9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_m6	= EnumSet.of(
			ChromaticChordEnum.Cm6,
			ChromaticChordEnum.CCm6,
			ChromaticChordEnum.Dm6,
			ChromaticChordEnum.DDm6,
			ChromaticChordEnum.Em6,
			ChromaticChordEnum.Fm6,
			ChromaticChordEnum.FFm6,
			ChromaticChordEnum.Gm6,
			ChromaticChordEnum.GGm6,
			ChromaticChordEnum.Am6,
			ChromaticChordEnum.AAm6,
			ChromaticChordEnum.Bm6
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_7a9	= EnumSet.of(
			ChromaticChordEnum.C7a9,
			ChromaticChordEnum.CC7a9,
			ChromaticChordEnum.D7a9,
			ChromaticChordEnum.DD7a9,
			ChromaticChordEnum.E7a9,
			ChromaticChordEnum.F7a9,
			ChromaticChordEnum.FF7a9,
			ChromaticChordEnum.G7a9,
			ChromaticChordEnum.GG7a9,
			ChromaticChordEnum.A7a9,
			ChromaticChordEnum.AA7a9,
			ChromaticChordEnum.B7a9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_m7b9	= EnumSet.of(
			ChromaticChordEnum.Cm7b9,
			ChromaticChordEnum.CCm7b9,
			ChromaticChordEnum.Dm7b9,
			ChromaticChordEnum.DDm7b9,
			ChromaticChordEnum.Em7b9,
			ChromaticChordEnum.Fm7b9,
			ChromaticChordEnum.FFm7b9,
			ChromaticChordEnum.Gm7b9,
			ChromaticChordEnum.GGm7b9,
			ChromaticChordEnum.Am7b9,
			ChromaticChordEnum.AAm7b9,
			ChromaticChordEnum.Bm7b9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_7add11	= EnumSet.of(
			ChromaticChordEnum.C7add11,
			ChromaticChordEnum.CC7add11,
			ChromaticChordEnum.D7add11,
			ChromaticChordEnum.DD7add11,
			ChromaticChordEnum.E7add11,
			ChromaticChordEnum.F7add11,
			ChromaticChordEnum.FF7add11,
			ChromaticChordEnum.G7add11,
			ChromaticChordEnum.GG7add11,
			ChromaticChordEnum.A7add11,
			ChromaticChordEnum.AA7add11,
			ChromaticChordEnum.B7add11
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_7add13	= EnumSet.of(
			ChromaticChordEnum.C7add13,
			ChromaticChordEnum.CC7add13,
			ChromaticChordEnum.D7add13,
			ChromaticChordEnum.DD7add13,
			ChromaticChordEnum.E7add13,
			ChromaticChordEnum.F7add13,
			ChromaticChordEnum.FF7add13,
			ChromaticChordEnum.G7add13,
			ChromaticChordEnum.GG7add13,
			ChromaticChordEnum.A7add13,
			ChromaticChordEnum.AA7add13,
			ChromaticChordEnum.B7add13
	);


	public static final EnumSet<ChromaticChordEnum>	CHORDS_9	= EnumSet.of(
			ChromaticChordEnum.C9,
			ChromaticChordEnum.CC9,
			ChromaticChordEnum.D9,
			ChromaticChordEnum.DD9,
			ChromaticChordEnum.E9,
			ChromaticChordEnum.F9,
			ChromaticChordEnum.FF9,
			ChromaticChordEnum.G9,
			ChromaticChordEnum.GG9,
			ChromaticChordEnum.A9,
			ChromaticChordEnum.AA9,
			ChromaticChordEnum.B9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_m9	= EnumSet.of(
			ChromaticChordEnum.Cm9,
			ChromaticChordEnum.CCm9,
			ChromaticChordEnum.Dm9,
			ChromaticChordEnum.DDm9,
			ChromaticChordEnum.Em9,
			ChromaticChordEnum.Fm9,
			ChromaticChordEnum.FFm9,
			ChromaticChordEnum.Gm9,
			ChromaticChordEnum.GGm9,
			ChromaticChordEnum.Am9,
			ChromaticChordEnum.AAm9,
			ChromaticChordEnum.Bm9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_9b5	= EnumSet.of(
			ChromaticChordEnum.C9b5,
			ChromaticChordEnum.CC9b5,
			ChromaticChordEnum.D9b5,
			ChromaticChordEnum.DD9b5,
			ChromaticChordEnum.E9b5,
			ChromaticChordEnum.F9b5,
			ChromaticChordEnum.FF9b5,
			ChromaticChordEnum.G9b5,
			ChromaticChordEnum.GG9b5,
			ChromaticChordEnum.A9b5,
			ChromaticChordEnum.AA9b5,
			ChromaticChordEnum.B9b5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_9a5	= EnumSet.of(
			ChromaticChordEnum.C9a5,
			ChromaticChordEnum.CC9a5,
			ChromaticChordEnum.D9a5,
			ChromaticChordEnum.DD9a5,
			ChromaticChordEnum.E9a5,
			ChromaticChordEnum.F9a5,
			ChromaticChordEnum.FF9a5,
			ChromaticChordEnum.G9a5,
			ChromaticChordEnum.GG9a5,
			ChromaticChordEnum.A9a5,
			ChromaticChordEnum.AA9a5,
			ChromaticChordEnum.B9a5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_9sus4	= EnumSet.of(
			ChromaticChordEnum.C9sus4,
			ChromaticChordEnum.CC9sus4,
			ChromaticChordEnum.D9sus4,
			ChromaticChordEnum.DD9sus4,
			ChromaticChordEnum.E9sus4,
			ChromaticChordEnum.F9sus4,
			ChromaticChordEnum.FF9sus4,
			ChromaticChordEnum.G9sus4,
			ChromaticChordEnum.GG9sus4,
			ChromaticChordEnum.A9sus4,
			ChromaticChordEnum.AA9sus4,
			ChromaticChordEnum.B9sus4
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj9	= EnumSet.of(
			ChromaticChordEnum.CMaj9,
			ChromaticChordEnum.CCMaj9,
			ChromaticChordEnum.DMaj9,
			ChromaticChordEnum.DDMaj9,
			ChromaticChordEnum.EMaj9,
			ChromaticChordEnum.FMaj9,
			ChromaticChordEnum.FFMaj9,
			ChromaticChordEnum.GMaj9,
			ChromaticChordEnum.GGMaj9,
			ChromaticChordEnum.AMaj9,
			ChromaticChordEnum.AAMaj9,
			ChromaticChordEnum.BMaj9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_mMaj9	= EnumSet.of(
			ChromaticChordEnum.CmMaj9,
			ChromaticChordEnum.CCmMaj9,
			ChromaticChordEnum.DmMaj9,
			ChromaticChordEnum.DDmMaj9,
			ChromaticChordEnum.EmMaj9,
			ChromaticChordEnum.FmMaj9,
			ChromaticChordEnum.FFmMaj9,
			ChromaticChordEnum.GmMaj9,
			ChromaticChordEnum.GGmMaj9,
			ChromaticChordEnum.AmMaj9,
			ChromaticChordEnum.AAmMaj9,
			ChromaticChordEnum.BmMaj9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_9add6	= EnumSet.of(
			ChromaticChordEnum.C9add6,
			ChromaticChordEnum.CC9add6,
			ChromaticChordEnum.D9add6,
			ChromaticChordEnum.DD9add6,
			ChromaticChordEnum.E9add6,
			ChromaticChordEnum.F9add6,
			ChromaticChordEnum.FF9add6,
			ChromaticChordEnum.G9add6,
			ChromaticChordEnum.GG9add6,
			ChromaticChordEnum.A9add6,
			ChromaticChordEnum.AA9add6,
			ChromaticChordEnum.B9add6
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_9a11	= EnumSet.of(
			ChromaticChordEnum.C9a11,
			ChromaticChordEnum.CC9a11,
			ChromaticChordEnum.D9a11,
			ChromaticChordEnum.DD9a11,
			ChromaticChordEnum.E9a11,
			ChromaticChordEnum.F9a11,
			ChromaticChordEnum.FF9a11,
			ChromaticChordEnum.G9a11,
			ChromaticChordEnum.GG9a11,
			ChromaticChordEnum.A9a11,
			ChromaticChordEnum.AA9a11,
			ChromaticChordEnum.B9a11
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj9a11	= EnumSet.of(
			ChromaticChordEnum.CMaj9a11,
			ChromaticChordEnum.CCMaj9a11,
			ChromaticChordEnum.DMaj9a11,
			ChromaticChordEnum.DDMaj9a11,
			ChromaticChordEnum.EMaj9a11,
			ChromaticChordEnum.FMaj9a11,
			ChromaticChordEnum.FFMaj9a11,
			ChromaticChordEnum.GMaj9a11,
			ChromaticChordEnum.GGMaj9a11,
			ChromaticChordEnum.AMaj9a11,
			ChromaticChordEnum.AAMaj9a11,
			ChromaticChordEnum.BMaj9a11
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_11	= EnumSet.of(
			ChromaticChordEnum.C11,
			ChromaticChordEnum.CC11,
			ChromaticChordEnum.D11,
			ChromaticChordEnum.DD11,
			ChromaticChordEnum.E11,
			ChromaticChordEnum.F11,
			ChromaticChordEnum.FF11,
			ChromaticChordEnum.G11,
			ChromaticChordEnum.GG11,
			ChromaticChordEnum.A11,
			ChromaticChordEnum.AA11,
			ChromaticChordEnum.B11
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_m11	= EnumSet.of(
			ChromaticChordEnum.Cm11,
			ChromaticChordEnum.CCm11,
			ChromaticChordEnum.Dm11,
			ChromaticChordEnum.DDm11,
			ChromaticChordEnum.Em11,
			ChromaticChordEnum.Fm11,
			ChromaticChordEnum.FFm11,
			ChromaticChordEnum.Gm11,
			ChromaticChordEnum.GGm11,
			ChromaticChordEnum.Am11,
			ChromaticChordEnum.AAm11,
			ChromaticChordEnum.Bm11
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_11b9	= EnumSet.of(
			ChromaticChordEnum.C11b9,
			ChromaticChordEnum.CC11b9,
			ChromaticChordEnum.D11b9,
			ChromaticChordEnum.DD11b9,
			ChromaticChordEnum.E11b9,
			ChromaticChordEnum.F11b9,
			ChromaticChordEnum.FF11b9,
			ChromaticChordEnum.G11b9,
			ChromaticChordEnum.GG11b9,
			ChromaticChordEnum.A11b9,
			ChromaticChordEnum.AA11b9,
			ChromaticChordEnum.B11b9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_11a9	= EnumSet.of(
			ChromaticChordEnum.C11a9,
			ChromaticChordEnum.CC11a9,
			ChromaticChordEnum.D11a9,
			ChromaticChordEnum.DD11a9,
			ChromaticChordEnum.E11a9,
			ChromaticChordEnum.F11a9,
			ChromaticChordEnum.FF11a9,
			ChromaticChordEnum.G11a9,
			ChromaticChordEnum.GG11a9,
			ChromaticChordEnum.A11a9,
			ChromaticChordEnum.AA11a9,
			ChromaticChordEnum.B11a9
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj11	= EnumSet.of(
			ChromaticChordEnum.CMaj11,
			ChromaticChordEnum.CCMaj11,
			ChromaticChordEnum.DMaj11,
			ChromaticChordEnum.DDMaj11,
			ChromaticChordEnum.EMaj11,
			ChromaticChordEnum.FMaj11,
			ChromaticChordEnum.FFMaj11,
			ChromaticChordEnum.GMaj11,
			ChromaticChordEnum.GGMaj11,
			ChromaticChordEnum.AMaj11,
			ChromaticChordEnum.AAMaj11,
			ChromaticChordEnum.BMaj11
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_mMaj11	= EnumSet.of(
			ChromaticChordEnum.CmMaj11,
			ChromaticChordEnum.CCmMaj11,
			ChromaticChordEnum.DmMaj11,
			ChromaticChordEnum.DDmMaj11,
			ChromaticChordEnum.EmMaj11,
			ChromaticChordEnum.FmMaj11,
			ChromaticChordEnum.FFmMaj11,
			ChromaticChordEnum.GmMaj11,
			ChromaticChordEnum.GGmMaj11,
			ChromaticChordEnum.AmMaj11,
			ChromaticChordEnum.AAmMaj11,
			ChromaticChordEnum.BmMaj11
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_m13	= EnumSet.of(
			ChromaticChordEnum.Cm13,
			ChromaticChordEnum.CCm13,
			ChromaticChordEnum.Dm13,
			ChromaticChordEnum.DDm13,
			ChromaticChordEnum.Em13,
			ChromaticChordEnum.Fm13,
			ChromaticChordEnum.FFm13,
			ChromaticChordEnum.Gm13,
			ChromaticChordEnum.GGm13,
			ChromaticChordEnum.Am13,
			ChromaticChordEnum.AAm13,
			ChromaticChordEnum.Bm13
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_13sus4	= EnumSet.of(
			ChromaticChordEnum.C13sus4,
			ChromaticChordEnum.CC13sus4,
			ChromaticChordEnum.D13sus4,
			ChromaticChordEnum.DD13sus4,
			ChromaticChordEnum.E13sus4,
			ChromaticChordEnum.F13sus4,
			ChromaticChordEnum.FF13sus4,
			ChromaticChordEnum.G13sus4,
			ChromaticChordEnum.GG13sus4,
			ChromaticChordEnum.A13sus4,
			ChromaticChordEnum.AA13sus4,
			ChromaticChordEnum.B13sus4
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_13b5	= EnumSet.of(
			ChromaticChordEnum.C13b5,
			ChromaticChordEnum.CC13b5,
			ChromaticChordEnum.D13b5,
			ChromaticChordEnum.DD13b5,
			ChromaticChordEnum.E13b5,
			ChromaticChordEnum.F13b5,
			ChromaticChordEnum.FF13b5,
			ChromaticChordEnum.G13b5,
			ChromaticChordEnum.GG13b5,
			ChromaticChordEnum.A13b5,
			ChromaticChordEnum.AA13b5,
			ChromaticChordEnum.B13b5
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_13a5	= EnumSet.of(
			ChromaticChordEnum.C13a5,
			ChromaticChordEnum.CC13a5,
			ChromaticChordEnum.D13a5,
			ChromaticChordEnum.DD13a5,
			ChromaticChordEnum.E13a5,
			ChromaticChordEnum.F13a5,
			ChromaticChordEnum.FF13a5,
			ChromaticChordEnum.G13a5,
			ChromaticChordEnum.GG13a5,
			ChromaticChordEnum.A13a5,
			ChromaticChordEnum.AA13a5,
			ChromaticChordEnum.B13a5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_13b9	= EnumSet.of(
			ChromaticChordEnum.C13b9,
			ChromaticChordEnum.CC13b9,
			ChromaticChordEnum.D13b9,
			ChromaticChordEnum.DD13b9,
			ChromaticChordEnum.E13b9,
			ChromaticChordEnum.F13b9,
			ChromaticChordEnum.FF13b9,
			ChromaticChordEnum.G13b9,
			ChromaticChordEnum.GG13b9,
			ChromaticChordEnum.A13b9,
			ChromaticChordEnum.AA13b9,
			ChromaticChordEnum.B13b9
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_13a9	= EnumSet.of(
			ChromaticChordEnum.C13a9,
			ChromaticChordEnum.CC13a9,
			ChromaticChordEnum.D13a9,
			ChromaticChordEnum.DD13a9,
			ChromaticChordEnum.E13a9,
			ChromaticChordEnum.F13a9,
			ChromaticChordEnum.FF13a9,
			ChromaticChordEnum.G13a9,
			ChromaticChordEnum.GG13a9,
			ChromaticChordEnum.A13a9,
			ChromaticChordEnum.AA13a9,
			ChromaticChordEnum.B13a9
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_13b5b9	= EnumSet.of(
			ChromaticChordEnum.C13b5b9,
			ChromaticChordEnum.CC13b5b9,
			ChromaticChordEnum.D13b5b9,
			ChromaticChordEnum.DD13b5b9,
			ChromaticChordEnum.E13b5b9,
			ChromaticChordEnum.F13b5b9,
			ChromaticChordEnum.FF13b5b9,
			ChromaticChordEnum.G13b5b9,
			ChromaticChordEnum.GG13b5b9,
			ChromaticChordEnum.A13b5b9,
			ChromaticChordEnum.AA13b5b9,
			ChromaticChordEnum.B13b5b9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_13b5a9	= EnumSet.of(
			ChromaticChordEnum.C13b5a9,
			ChromaticChordEnum.CC13b5a9,
			ChromaticChordEnum.D13b5a9,
			ChromaticChordEnum.DD13b5a9,
			ChromaticChordEnum.E13b5a9,
			ChromaticChordEnum.F13b5a9,
			ChromaticChordEnum.FF13b5a9,
			ChromaticChordEnum.G13b5a9,
			ChromaticChordEnum.GG13b5a9,
			ChromaticChordEnum.A13b5a9,
			ChromaticChordEnum.AA13b5a9,
			ChromaticChordEnum.B13b5a9
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_13a5b9	= EnumSet.of(
			ChromaticChordEnum.C13a5b9,
			ChromaticChordEnum.CC13a5b9,
			ChromaticChordEnum.D13a5b9,
			ChromaticChordEnum.DD13a5b9,
			ChromaticChordEnum.E13a5b9,
			ChromaticChordEnum.F13a5b9,
			ChromaticChordEnum.FF13a5b9,
			ChromaticChordEnum.G13a5b9,
			ChromaticChordEnum.GG13a5b9,
			ChromaticChordEnum.A13a5b9,
			ChromaticChordEnum.AA13a5b9,
			ChromaticChordEnum.B13a5b9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_13a5a9	= EnumSet.of(
			ChromaticChordEnum.C13a5a9,
			ChromaticChordEnum.CC13a5a9,
			ChromaticChordEnum.D13a5a9,
			ChromaticChordEnum.DD13a5a9,
			ChromaticChordEnum.E13a5a9,
			ChromaticChordEnum.F13a5a9,
			ChromaticChordEnum.FF13a5a9,
			ChromaticChordEnum.G13a5a9,
			ChromaticChordEnum.GG13a5a9,
			ChromaticChordEnum.A13a5a9,
			ChromaticChordEnum.AA13a5a9,
			ChromaticChordEnum.B13a5a9
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13	= EnumSet.of(
			ChromaticChordEnum.CMaj13,
			ChromaticChordEnum.CCMaj13,
			ChromaticChordEnum.DMaj13,
			ChromaticChordEnum.DDMaj13,
			ChromaticChordEnum.EMaj13,
			ChromaticChordEnum.FMaj13,
			ChromaticChordEnum.FFMaj13,
			ChromaticChordEnum.GMaj13,
			ChromaticChordEnum.GGMaj13,
			ChromaticChordEnum.AMaj13,
			ChromaticChordEnum.AAMaj13,
			ChromaticChordEnum.BMaj13
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_mMaj13	= EnumSet.of(
			ChromaticChordEnum.CmMaj13,
			ChromaticChordEnum.CCmMaj13,
			ChromaticChordEnum.DmMaj13,
			ChromaticChordEnum.DDmMaj13,
			ChromaticChordEnum.EmMaj13,
			ChromaticChordEnum.FmMaj13,
			ChromaticChordEnum.FFmMaj13,
			ChromaticChordEnum.GmMaj13,
			ChromaticChordEnum.GGmMaj13,
			ChromaticChordEnum.AmMaj13,
			ChromaticChordEnum.AAmMaj13,
			ChromaticChordEnum.BmMaj13
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13b5	= EnumSet.of(
			ChromaticChordEnum.CMaj13b5,
			ChromaticChordEnum.CCMaj13b5,
			ChromaticChordEnum.DMaj13b5,
			ChromaticChordEnum.DDMaj13b5,
			ChromaticChordEnum.EMaj13b5,
			ChromaticChordEnum.FMaj13b5,
			ChromaticChordEnum.FFMaj13b5,
			ChromaticChordEnum.GMaj13b5,
			ChromaticChordEnum.GGMaj13b5,
			ChromaticChordEnum.AMaj13b5,
			ChromaticChordEnum.AAMaj13b5,
			ChromaticChordEnum.BMaj13b5
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13a5	= EnumSet.of(
			ChromaticChordEnum.CMaj13a5,
			ChromaticChordEnum.CCMaj13a5,
			ChromaticChordEnum.DMaj13a5,
			ChromaticChordEnum.DDMaj13a5,
			ChromaticChordEnum.EMaj13a5,
			ChromaticChordEnum.FMaj13a5,
			ChromaticChordEnum.FFMaj13a5,
			ChromaticChordEnum.GMaj13a5,
			ChromaticChordEnum.GGMaj13a5,
			ChromaticChordEnum.AMaj13a5,
			ChromaticChordEnum.AAMaj13a5,
			ChromaticChordEnum.BMaj13a5
	);
	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13b9	= EnumSet.of(
			ChromaticChordEnum.CMaj13b9,
			ChromaticChordEnum.CCMaj13b9,
			ChromaticChordEnum.DMaj13b9,
			ChromaticChordEnum.DDMaj13b9,
			ChromaticChordEnum.EMaj13b9,
			ChromaticChordEnum.FMaj13b9,
			ChromaticChordEnum.FFMaj13b9,
			ChromaticChordEnum.GMaj13b9,
			ChromaticChordEnum.GGMaj13b9,
			ChromaticChordEnum.AMaj13b9,
			ChromaticChordEnum.AAMaj13b9,
			ChromaticChordEnum.BMaj13b9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13a9	= EnumSet.of(
			ChromaticChordEnum.CMaj13a9,
			ChromaticChordEnum.CCMaj13a9,
			ChromaticChordEnum.DMaj13a9,
			ChromaticChordEnum.DDMaj13a9,
			ChromaticChordEnum.EMaj13a9,
			ChromaticChordEnum.FMaj13a9,
			ChromaticChordEnum.FFMaj13a9,
			ChromaticChordEnum.GMaj13a9,
			ChromaticChordEnum.GGMaj13a9,
			ChromaticChordEnum.AMaj13a9,
			ChromaticChordEnum.AAMaj13a9,
			ChromaticChordEnum.BMaj13a9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13b5b9	= EnumSet.of(
			ChromaticChordEnum.CMaj13b5b9,
			ChromaticChordEnum.CCMaj13b5b9,
			ChromaticChordEnum.DMaj13b5b9,
			ChromaticChordEnum.DDMaj13b5b9,
			ChromaticChordEnum.EMaj13b5b9,
			ChromaticChordEnum.FMaj13b5b9,
			ChromaticChordEnum.FFMaj13b5b9,
			ChromaticChordEnum.GMaj13b5b9,
			ChromaticChordEnum.GGMaj13b5b9,
			ChromaticChordEnum.AMaj13b5b9,
			ChromaticChordEnum.AAMaj13b5b9,
			ChromaticChordEnum.BMaj13b5b9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13b5a9	= EnumSet.of(
			ChromaticChordEnum.CMaj13b5a9,
			ChromaticChordEnum.CCMaj13b5a9,
			ChromaticChordEnum.DMaj13b5a9,
			ChromaticChordEnum.DDMaj13b5a9,
			ChromaticChordEnum.EMaj13b5a9,
			ChromaticChordEnum.FMaj13b5a9,
			ChromaticChordEnum.FFMaj13b5a9,
			ChromaticChordEnum.GMaj13b5a9,
			ChromaticChordEnum.GGMaj13b5a9,
			ChromaticChordEnum.AMaj13b5a9,
			ChromaticChordEnum.AAMaj13b5a9,
			ChromaticChordEnum.BMaj13b5a9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13a5b9	= EnumSet.of(
			ChromaticChordEnum.CMaj13a5b9,
			ChromaticChordEnum.CCMaj13a5b9,
			ChromaticChordEnum.DMaj13a5b9,
			ChromaticChordEnum.DDMaj13a5b9,
			ChromaticChordEnum.EMaj13a5b9,
			ChromaticChordEnum.FMaj13a5b9,
			ChromaticChordEnum.FFMaj13a5b9,
			ChromaticChordEnum.GMaj13a5b9,
			ChromaticChordEnum.GGMaj13a5b9,
			ChromaticChordEnum.AMaj13a5b9,
			ChromaticChordEnum.AAMaj13a5b9,
			ChromaticChordEnum.BMaj13a5b9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_Maj13a5a9	= EnumSet.of(
			ChromaticChordEnum.CMaj13a5a9,
			ChromaticChordEnum.CCMaj13a5a9,
			ChromaticChordEnum.DMaj13a5a9,
			ChromaticChordEnum.DDMaj13a5a9,
			ChromaticChordEnum.EMaj13a5a9,
			ChromaticChordEnum.FMaj13a5a9,
			ChromaticChordEnum.FFMaj13a5a9,
			ChromaticChordEnum.GMaj13a5a9,
			ChromaticChordEnum.GGMaj13a5a9,
			ChromaticChordEnum.AMaj13a5a9,
			ChromaticChordEnum.AAMaj13a5a9,
			ChromaticChordEnum.BMaj13a5a9
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_SUSa4	= EnumSet.of(
			ChromaticChordEnum.Csusa4,
			ChromaticChordEnum.CCsusa4,
			ChromaticChordEnum.Dsusa4,
			ChromaticChordEnum.DDsusa4,
			ChromaticChordEnum.Esusa4,
			ChromaticChordEnum.Fsusa4,
			ChromaticChordEnum.FFsusa4,
			ChromaticChordEnum.Gsusa4,
			ChromaticChordEnum.GGsusa4,
			ChromaticChordEnum.Asusa4,
			ChromaticChordEnum.AAsusa4,
			ChromaticChordEnum.Bsusa4
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_SUSb2	= EnumSet.of(
			ChromaticChordEnum.Csusb2,
			ChromaticChordEnum.CCsusb2,
			ChromaticChordEnum.Dsusb2,
			ChromaticChordEnum.DDsusb2,
			ChromaticChordEnum.Esusb2,
			ChromaticChordEnum.Fsusb2,
			ChromaticChordEnum.FFsusb2,
			ChromaticChordEnum.Gsusb2,
			ChromaticChordEnum.GGsusb2,
			ChromaticChordEnum.Asusb2,
			ChromaticChordEnum.AAsusb2,
			ChromaticChordEnum.Bsusb2
	);

	public static final EnumSet<ChromaticChordEnum>	CHORDS_SUSb2b5	= EnumSet.of(
			ChromaticChordEnum.Csusb2b5,
			ChromaticChordEnum.CCsusb2b5,
			ChromaticChordEnum.Dsusb2b5,
			ChromaticChordEnum.DDsusb2b5,
			ChromaticChordEnum.Esusb2b5,
			ChromaticChordEnum.Fsusb2b5,
			ChromaticChordEnum.FFsusb2b5,
			ChromaticChordEnum.Gsusb2b5,
			ChromaticChordEnum.GGsusb2b5,
			ChromaticChordEnum.Asusb2b5,
			ChromaticChordEnum.AAsusb2b5,
			ChromaticChordEnum.Bsusb2b5
	);

	public static final EnumSet<ChromaticChordEnum>	UNUSUAL_CHORDS			= SetUtils.concat(
			CHORDS_SUSb2,
			CHORDS_SUSa4,
			CHORDS_SUSb2b5
	);

	public static final EnumSet<ChromaticChordEnum>	TRIAD_CHORDS		= SetUtils.concat(
			CHORDS_MAJOR,
			CHORDS_MINOR,
			CHORDS_DIMINISHED,
			CHORDS_AUGMENTED,
			CHORDS_SUS4,
			CHORDS_SUS2
	);

	public static final EnumSet<ChromaticChordEnum>	SEVENTH_CHORDS			= SetUtils.concat(
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
	);

	public static final EnumSet<ChromaticChordEnum>	SIXTH_CHORDS	= SetUtils.concat(
			CHORDS_6,
			CHORDS_m6,
			CHORDS_6sus4,
			CHORDS_6add9,
			CHORDS_m6add9
	);

	public static final EnumSet<ChromaticChordEnum>	NINTH_CHORDS		= SetUtils.concat(
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
	);

	public static final EnumSet<ChromaticChordEnum>	ELEVENTH_CHORDS			= SetUtils.concat(
			CHORDS_11,
			CHORDS_m11,
			CHORDS_11b9,
			CHORDS_11a9,
			CHORDS_Maj11,
			CHORDS_mMaj11
	);

	public static final EnumSet<ChromaticChordEnum>	THIRTEENTH_CHORDS		= SetUtils.concat(
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
	);

	public static final EnumSet<ChromaticChordEnum>	PARTIAL_CHORDS			= SetUtils.concat(
			CHORDS_FIFTH
	);

	public static final EnumSet<ChromaticChordEnum>	COMMON_CHORDS	= SetUtils.concat(TRIAD_CHORDS, SEVENTH_CHORDS, SIXTH_CHORDS, NINTH_CHORDS, ELEVENTH_CHORDS, THIRTEENTH_CHORDS, PARTIAL_CHORDS);

	private static final HashMap<List<Integer>, ArrayList<ChromaticChordEnum>> sameOrderChromatics = new HashMap<>();

	static EnumTreeSet<Chromatic, ChromaticChordEnum> chordTree;

	static {
		chordTree = new EnumTreeSet<>( Chromatic.class, ChromaticChordEnum.class );
		for (ChromaticChordEnum c : values()) {
			chordTree.addContent( c, c.notes );
		}
	}

	/** Variables */
	final List<Chromatic> notes;
	final ChromaticChordMeta meta;

	ChromaticChordEnum(ChromaticChordMeta m, @NonNull Chromatic... cs) {
		Objects.requireNonNull(cs);

		List<Chromatic> notesMutatable = new ArrayList<>(Arrays.asList(cs));
		notes = Collections.unmodifiableList( notesMutatable );

		meta = m;
	}

	public static @Nullable ChromaticChordEnum from(@NonNull Collection<? extends PitchChromaticSingle> chromaticCollection) {
		for (ChromaticChordEnum chromaticChordEnum : ChromaticChordEnum.values())
			if (chromaticChordEnum.sameChromaticAs(chromaticCollection))
				return chromaticChordEnum;

		return null;
	}

	private boolean sameChromaticAs(Collection<? extends PitchChromaticSingle> diatonicCollection) {
		if (notes.size() != diatonicCollection.size())
			return false;

		int i = 0;
		for (PitchChromaticSingle pitchChromaticSingle : diatonicCollection) {
			if (notes.get(i) != pitchChromaticSingle)
				return false;
			i++;
		}

		return true;
	}

	public static EnumSet<ChromaticChordEnum> getChordsWithRepeatedNotes() { // todo: mover a retrieval
		EnumSet<ChromaticChordEnum> chords = EnumSet.noneOf( ChromaticChordEnum.class );
		for (ChromaticChordEnum cc : ChromaticChordEnum.values()) {
			EnumMap<Chromatic, Integer> e = new EnumMap<>( Chromatic.class );
			for (Chromatic c : Chromatic.values())
				e.put( c, 0 );
			for (Chromatic c : cc) {
				Integer i = e.get( c );
				if (i > 0)
					chords.add( cc );
				e.put( c, i+1 );
			}
		}

		return chords;
	}

	@Override
	public int size() {
		return notes.size();
	}

	@Override
	public Chromatic get(int index) {
		return notes.get( index );
	}

	@Override
	public Chromatic getRoot() {
		return notes.get( getRootPos() );
	}

	@Override
	public int getRootPos() {
		return 0;
	}

	@Override
	public int getInversionNumber() {
		return 0;
	}

	@Override
	public Quality getQuality() {
		return meta.quality;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return notes.contains( o );
	}

	@Override
	public boolean containsAll(@NonNull Collection<?> c) {
		return notes.containsAll( c );
	}

	@Override
	public int indexOf(Object o) {
		return notes.indexOf( o );
	}

	@Override
	public Iterator<Chromatic> iterator() {
		return notes.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return notes.lastIndexOf( o );
	}

	@Override
	public ListIterator<Chromatic> listIterator() {
		return notes.listIterator();
	}

	@Override
	public ListIterator<Chromatic> listIterator(int index) {
		return notes.listIterator(index);
	}

	@Override
	@NonNull
	public PitchChromaticChord<Chromatic> subList(int fromIndex, int toIndex) {
		return PitchChromaticChord.of( notes.subList( fromIndex, toIndex ) );
	}

	@Override
	public Object[] toArray() {
		return notes.toArray();
	}

	@SuppressWarnings("SuspiciousToArrayCall")
	@Override
	public <T> T[] toArray(@NonNull T[] a) {
		return notes.toArray( a );
	}

	@Override
	public boolean isSus4() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSus2() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *  UnsupportedOperation
	 */

	private void excep() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		excep();
	}

	@Override
	public boolean remove(Object o) {
		excep();
		return false;
	}

	@Override
	public Chromatic remove(int index) {
		excep();
		return null;
	}

	@Override
	public boolean removeAll(@Nonnull Collection<?> c) {
		excep();
		return false;
	}

	@Override
	public boolean retainAll(@NonNull Collection<?> c) {
		excep();
		return false;
	}

	@Override
	public Chromatic set(int index, Chromatic element) {
		excep();
		return null;
	}

	@Override
	public boolean add(Chromatic e) {
		excep();
		return false;
	}

	@Override
	public void add(int index, Chromatic element) {
		excep();
	}

	@Override
	public boolean addAll(@NonNull Collection<? extends Chromatic> c) {
		excep();
		return false;
	}

	@Override
	public boolean addAll(int index, @NonNull Collection<? extends Chromatic> c) {
		excep();
		return false;
	}




	public static ChromaticChordEnum whichRootIs(Chromatic c, EnumSet<ChromaticChordEnum> pcc) { // todo: mover a retrieval
		for (ChromaticChordEnum chord : pcc)
			if (chord.getRoot() == c)
				return chord;

		return null;
	}

	@Override
	public boolean hasSameNotes(PitchChromaticChord<Chromatic> chord) { // todo: mover a retrieval
		EnumSet<Chromatic> e = EnumSet.noneOf( Chromatic.class );
		e.addAll(this);

		EnumSet<Chromatic> ee = EnumSet.noneOf( Chromatic.class );
		ee.addAll(chord);

		return e.equals( ee );
	}
}