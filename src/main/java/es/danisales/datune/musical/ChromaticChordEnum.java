package es.danisales.datune.musical;

import es.danisales.datastructures.EnumTreeSet;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.annotation.Nonnull;
import java.util.*;

public enum ChromaticChordEnum implements PitchChromaticChord<Chromatic>, ChromaticChordInterface {
	// Quintas
	C5(ChromaticChordMeta.POWER_CHORD, Chromatic.C),
	CC5(ChromaticChordMeta.POWER_CHORD, Chromatic.CC),
	D5(ChromaticChordMeta.POWER_CHORD, Chromatic.D),
	DD5(ChromaticChordMeta.POWER_CHORD, Chromatic.DD),
	E5(ChromaticChordMeta.POWER_CHORD, Chromatic.E),
	F5(ChromaticChordMeta.POWER_CHORD, Chromatic.F),
	FF5(ChromaticChordMeta.POWER_CHORD, Chromatic.FF),
	G5(ChromaticChordMeta.POWER_CHORD, Chromatic.G),
	GG5(ChromaticChordMeta.POWER_CHORD, Chromatic.GG),
	A5(ChromaticChordMeta.POWER_CHORD, Chromatic.A),
	AA5(ChromaticChordMeta.POWER_CHORD, Chromatic.AA),
	B5(ChromaticChordMeta.POWER_CHORD, Chromatic.B),

	// Mayores
	C(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.C),
	CC(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.CC),
	D(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.D),
	DD(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.DD),
	E(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.E),
	F(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.F),
	FF(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.FF),
	G(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.G),
	GG(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.GG),
	A(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.A),
	AA(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.AA),
	B(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.B),

	// Menores
	Cm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.C),
	CCm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.CC),
	Dm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.D),
	DDm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.DD),
	Em(ChromaticChordMeta.TRIAD_MINOR, Chromatic.E),
	Fm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.F),
	FFm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.FF),
	Gm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.G),
	GGm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.GG),
	Am(ChromaticChordMeta.TRIAD_MINOR, Chromatic.A),
	AAm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.AA),
	Bm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.B),

	// Aumentados
	Caug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.C),
	CCaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.CC),
	Daug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.D),
	DDaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.DD),
	Eaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.E),
	Faug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.F),
	FFaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.FF),
	Gaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.G),
	GGaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.GG),
	Aaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.A),
	AAaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.AA),
	Baug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.B),

	// Diminuidos
	Cdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.C),
	CCdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.CC),
	Ddim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.D),
	DDdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.DD),
	Edim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.E),
	Fdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.F),
	FFdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.FF),
	Gdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.G),
	GGdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.GG),
	Adim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.A),
	AAdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.AA),
	Bdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.B),

	// Cuarta suspendida
	Csus4(ChromaticChordMeta.SUS4, Chromatic.C),
	CCsus4(ChromaticChordMeta.SUS4,Chromatic.CC),
	Dsus4(ChromaticChordMeta.SUS4,Chromatic.D),
	DDsus4(ChromaticChordMeta.SUS4,Chromatic.DD),
	Esus4(ChromaticChordMeta.SUS4,Chromatic.E),
	Fsus4(ChromaticChordMeta.SUS4,Chromatic.F),
	FFsus4(ChromaticChordMeta.SUS4,Chromatic.FF),
	Gsus4(ChromaticChordMeta.SUS4,Chromatic.G),
	GGsus4(ChromaticChordMeta.SUS4,Chromatic.GG),
	Asus4(ChromaticChordMeta.SUS4,Chromatic.A),
	AAsus4(ChromaticChordMeta.SUS4,Chromatic.AA),
	Bsus4(ChromaticChordMeta.SUS4,Chromatic.B),

	// Segunda suspendida
	Csus2(ChromaticChordMeta.SUS2,Chromatic.C),
	CCsus2(ChromaticChordMeta.SUS2,Chromatic.CC),
	Dsus2(ChromaticChordMeta.SUS2,Chromatic.D),
	DDsus2(ChromaticChordMeta.SUS2,Chromatic.DD),
	Esus2(ChromaticChordMeta.SUS2,Chromatic.E),
	Fsus2(ChromaticChordMeta.SUS2,Chromatic.F),
	FFsus2(ChromaticChordMeta.SUS2,Chromatic.FF),
	Gsus2(ChromaticChordMeta.SUS2,Chromatic.G),
	GGsus2(ChromaticChordMeta.SUS2,Chromatic.GG),
	Asus2(ChromaticChordMeta.SUS2,Chromatic.A),
	AAsus2(ChromaticChordMeta.SUS2,Chromatic.AA),
	Bsus2(ChromaticChordMeta.SUS2,Chromatic.B),

	// Séptima (de dominante)
	C7(ChromaticChordMeta.SEVENTH, Chromatic.C),
	CC7(ChromaticChordMeta.SEVENTH, Chromatic.CC),
	D7(ChromaticChordMeta.SEVENTH, Chromatic.D),
	DD7(ChromaticChordMeta.SEVENTH, Chromatic.DD),
	E7(ChromaticChordMeta.SEVENTH, Chromatic.E),
	F7(ChromaticChordMeta.SEVENTH, Chromatic.F),
	FF7(ChromaticChordMeta.SEVENTH, Chromatic.FF),
	G7(ChromaticChordMeta.SEVENTH, Chromatic.G),
	GG7(ChromaticChordMeta.SEVENTH, Chromatic.GG),
	A7(ChromaticChordMeta.SEVENTH, Chromatic.A),
	AA7(ChromaticChordMeta.SEVENTH, Chromatic.AA),
	B7(ChromaticChordMeta.SEVENTH, Chromatic.B),

	// Séptima con quinta bemol
	C7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.C),
	CC7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.CC),
	D7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.D),
	DD7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.DD),
	E7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.E),
	F7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.F),
	FF7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.FF),
	G7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.G),
	GG7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.GG),
	A7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.A),
	AA7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.AA),
	B7b5(ChromaticChordMeta.SEVENTH_b5, Chromatic.B),

	// Séptima con quinta aumentada
	C7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.C),
	CC7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.CC),
	D7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.D),
	DD7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.DD),
	E7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.E),
	F7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.F),
	FF7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.FF),
	G7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.G),
	GG7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.GG),
	A7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.A),
	AA7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.AA),
	B7a5(ChromaticChordMeta.SEVENTH_a5, Chromatic.B),

	// Séptima con cuarta suspendida
	C7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.C),
	CC7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.CC),
	D7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.D),
	DD7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.DD),
	E7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.E),
	F7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.F),
	FF7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.FF),
	G7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.G),
	GG7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.GG),
	A7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.A),
	AA7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.AA),
	B7sus4(ChromaticChordMeta.SEVENTH_SUS4, Chromatic.B),

	// Menor séptima
	Cm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.C),
	CCm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.CC),
	Dm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.D),
	DDm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.DD),
	Em7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.E),
	Fm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.F),
	FFm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.FF),
	Gm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.G),
	GGm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.GG),
	Am7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.A),
	AAm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.AA),
	Bm7(ChromaticChordMeta.SEVENTH_MINOR, Chromatic.B),

	// Menor séptima con quinta bemol
	Cm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.C),
	CCm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.CC),
	Dm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.D),
	DDm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.DD),
	Em7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.E),
	Fm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.F),
	FFm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.FF),
	Gm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.G),
	GGm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.GG),
	Am7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.A),
	AAm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.AA),
	Bm7b5(ChromaticChordMeta.SEVENTH_MINOR_b5, Chromatic.B),

	// Menor séptima con quinta aumentada
	Cm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.C),
	CCm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.CC),
	Dm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.D),
	DDm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.DD),
	Em7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.E),
	Fm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.F),
	FFm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.FF),
	Gm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.G),
	GGm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.GG),
	Am7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.A),
	AAm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.AA),
	Bm7a5(ChromaticChordMeta.SEVENTH_MINOR_a5, Chromatic.B),

	// Sexta
	C6(ChromaticChordMeta.SIXTH, Chromatic.C),
	CC6(ChromaticChordMeta.SIXTH, Chromatic.CC),
	D6(ChromaticChordMeta.SIXTH, Chromatic.D),
	DD6(ChromaticChordMeta.SIXTH, Chromatic.DD),
	E6(ChromaticChordMeta.SIXTH, Chromatic.E),
	F6(ChromaticChordMeta.SIXTH, Chromatic.F),
	FF6(ChromaticChordMeta.SIXTH, Chromatic.FF),
	G6(ChromaticChordMeta.SIXTH, Chromatic.G),
	GG6(ChromaticChordMeta.SIXTH, Chromatic.GG),
	A6(ChromaticChordMeta.SIXTH, Chromatic.A),
	AA6(ChromaticChordMeta.SIXTH, Chromatic.AA),
	B6(ChromaticChordMeta.SIXTH, Chromatic.B),

	// Menor sexta
	Cm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.C),
	CCm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.CC),
	Dm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.D),
	DDm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.DD),
	Em6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.E),
	Fm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.F),
	FFm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.FF),
	Gm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.G),
	GGm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.GG),
	Am6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.A),
	AAm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.AA),
	Bm6(ChromaticChordMeta.SIXTH_MINOR, Chromatic.B),

	// Sexta con cuarta suspendida
	C6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.C),
	CC6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.CC),
	D6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.D),
	DD6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.DD),
	E6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.E),
	F6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.F),
	FF6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.FF),
	G6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.G),
	GG6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.GG),
	A6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.A),
	AA6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.AA),
	B6sus4(ChromaticChordMeta.SIXTH_SUS4, Chromatic.B),

	// Séptima mayor
	CMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.C),
	CCMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.CC),
	DMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.D),
	DDMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.DD),
	EMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.E),
	FMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.F),
	FFMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.FF),
	GMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.G),
	GGMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.GG),
	AMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.A),
	AAMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.AA),
	BMaj7(ChromaticChordMeta.SEVENTH_MAJ7, Chromatic.B),

	// Menor séptima mayor
	CmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.C),
	CCmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.CC),
	DmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.D),
	DDmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.DD),
	EmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.E),
	FmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.F),
	FFmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.FF),
	GmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.G),
	GGmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.GG),
	AmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.A),
	AAmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7,Chromatic.AA),
	BmMaj7(ChromaticChordMeta.SEVENTH_MINOR_MAJ7, Chromatic.B),

	// Sexta con novena añadida
	C6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.C),
	CC6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.CC),
	D6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.D),
	DD6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.DD),
	E6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.E),
	F6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.F),
	FF6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.FF),
	G6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.G),
	GG6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.GG),
	A6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.A),
	AA6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.AA),
	B6add9(ChromaticChordMeta.SIXTH_ADD9, Chromatic.B),

	// Sexta con novena añadida
	Cm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.C),
	CCm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.CC),
	Dm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.D),
	DDm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.DD),
	Em6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.E),
	Fm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.F),
	FFm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.FF),
	Gm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.G),
	GGm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.GG),
	Am6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.A),
	AAm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.AA),
	Bm6add9(ChromaticChordMeta.SIXTH_MINOR_ADD9, Chromatic.B),

	// Séptima con novena bemol (añadida)
	C7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.C),
	CC7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.CC),
	D7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.D),
	DD7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.DD),
	E7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.E),
	F7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.F),
	FF7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.FF),
	G7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.G),
	GG7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.GG),
	A7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.A),
	AA7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.AA),
	B7b9(ChromaticChordMeta.SEVENTH_b9, Chromatic.B),

	// Séptima con novena aumentada (añadida)
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

	// Menor séptima con novena bemol (añadida)
	Cm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.C),
	CCm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.CC),
	Dm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.D),
	DDm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.DD),
	Em7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.E),
	Fm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.F),
	FFm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.FF),
	Gm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.G),
	GGm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.GG),
	Am7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.A),
	AAm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.AA),
	Bm7b9(ChromaticChordMeta.SEVENTH_MINOR_b9, Chromatic.B),

	// Séptima con oncena (añadida)
	C7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.C),
	CC7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.CC),
	D7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.D),
	DD7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.DD),
	E7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.E),
	F7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.F),
	FF7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.FF),
	G7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.G),
	GG7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.GG),
	A7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.A),
	AA7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.AA),
	B7add11(ChromaticChordMeta.SEVENTH_ADD11, Chromatic.B),

	// Séptima con treceava (añadida)
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


	static EnumTreeSet<Chromatic, ChromaticChordEnum> chordTree;

	static {
		chordTree = new EnumTreeSet<>( Chromatic.class, ChromaticChordEnum.class );
		for (ChromaticChordEnum c : values()) {
			chordTree.addContent( c, c.notes );
		}
	}

	/** Variables */
	final private List<Chromatic> notes;
	final private ChromaticChordMeta meta;

	ChromaticChordEnum(@NonNull ChromaticChordMeta chromaticChordMeta, @NonNull Chromatic... chromatics) {
		Objects.requireNonNull(chromaticChordMeta);
		Objects.requireNonNull(chromatics);

		List<Chromatic> notesMutatable = Arrays.asList(chromatics);
		notes = Collections.unmodifiableList( notesMutatable );
		meta = chromaticChordMeta;
	}

	ChromaticChordEnum(@NonNull ChromaticChordMeta chromaticChordMeta, @NonNull Chromatic base) {
		Objects.requireNonNull(chromaticChordMeta);
		Objects.requireNonNull(base);
		Objects.requireNonNull(chromaticChordMeta.getPattern());

		List<Chromatic> mutableNotesList = new ArrayList<>();
		for (Integer n : chromaticChordMeta.getPattern()) {
			Chromatic newChromatic = base.addSemi(n);
			mutableNotesList.add(newChromatic);
		}

		notes = Collections.unmodifiableList( mutableNotesList );
		meta = chromaticChordMeta;
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
	@NonNull
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
}