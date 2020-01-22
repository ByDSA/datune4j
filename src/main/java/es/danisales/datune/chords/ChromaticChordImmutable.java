package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Chromatic;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.annotation.Nonnull;
import java.util.*;

enum ChromaticChordImmutable implements PitchChromaticChord<Chromatic>, ChordCommon<Chromatic> {
	// Quintas
	C5(ChromaticChordInfo.POWER_CHORD, Chromatic.C),
	CC5(ChromaticChordInfo.POWER_CHORD, Chromatic.CC),
	D5(ChromaticChordInfo.POWER_CHORD, Chromatic.D),
	DD5(ChromaticChordInfo.POWER_CHORD, Chromatic.DD),
	E5(ChromaticChordInfo.POWER_CHORD, Chromatic.E),
	F5(ChromaticChordInfo.POWER_CHORD, Chromatic.F),
	FF5(ChromaticChordInfo.POWER_CHORD, Chromatic.FF),
	G5(ChromaticChordInfo.POWER_CHORD, Chromatic.G),
	GG5(ChromaticChordInfo.POWER_CHORD, Chromatic.GG),
	A5(ChromaticChordInfo.POWER_CHORD, Chromatic.A),
	AA5(ChromaticChordInfo.POWER_CHORD, Chromatic.AA),
	B5(ChromaticChordInfo.POWER_CHORD, Chromatic.B),

	// Mayores
	C(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.C),
	CC(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.CC),
	D(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.D),
	DD(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.DD),
	E(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.E),
	F(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.F),
	FF(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.FF),
	G(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.G),
	GG(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.GG),
	A(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.A),
	AA(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.AA),
	B(ChromaticChordInfo.TRIAD_MAJOR, Chromatic.B),

	// Menores
	Cm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.C),
	CCm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.CC),
	Dm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.D),
	DDm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.DD),
	Em(ChromaticChordInfo.TRIAD_MINOR, Chromatic.E),
	Fm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.F),
	FFm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.FF),
	Gm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.G),
	GGm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.GG),
	Am(ChromaticChordInfo.TRIAD_MINOR, Chromatic.A),
	AAm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.AA),
	Bm(ChromaticChordInfo.TRIAD_MINOR, Chromatic.B),

	// Aumentados
	Caug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.C),
	CCaug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.CC),
	Daug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.D),
	DDaug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.DD),
	Eaug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.E),
	Faug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.F),
	FFaug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.FF),
	Gaug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.G),
	GGaug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.GG),
	Aaug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.A),
	AAaug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.AA),
	Baug(ChromaticChordInfo.TRIAD_AUGMENTED, Chromatic.B),

	// Diminuidos
	Cdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.C),
	CCdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.CC),
	Ddim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.D),
	DDdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.DD),
	Edim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.E),
	Fdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.F),
	FFdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.FF),
	Gdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.G),
	GGdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.GG),
	Adim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.A),
	AAdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.AA),
	Bdim(ChromaticChordInfo.TRIAD_DIMINISHED, Chromatic.B),

	// Cuarta suspendida
	Csus4(ChromaticChordInfo.SUS4, Chromatic.C),
	CCsus4(ChromaticChordInfo.SUS4, Chromatic.CC),
	Dsus4(ChromaticChordInfo.SUS4, Chromatic.D),
	DDsus4(ChromaticChordInfo.SUS4, Chromatic.DD),
	Esus4(ChromaticChordInfo.SUS4, Chromatic.E),
	Fsus4(ChromaticChordInfo.SUS4, Chromatic.F),
	FFsus4(ChromaticChordInfo.SUS4, Chromatic.FF),
	Gsus4(ChromaticChordInfo.SUS4, Chromatic.G),
	GGsus4(ChromaticChordInfo.SUS4, Chromatic.GG),
	Asus4(ChromaticChordInfo.SUS4, Chromatic.A),
	AAsus4(ChromaticChordInfo.SUS4, Chromatic.AA),
	Bsus4(ChromaticChordInfo.SUS4, Chromatic.B),

	// Séptima (de dominante)
	C7(ChromaticChordInfo.SEVENTH, Chromatic.C),
	CC7(ChromaticChordInfo.SEVENTH, Chromatic.CC),
	D7(ChromaticChordInfo.SEVENTH, Chromatic.D),
	DD7(ChromaticChordInfo.SEVENTH, Chromatic.DD),
	E7(ChromaticChordInfo.SEVENTH, Chromatic.E),
	F7(ChromaticChordInfo.SEVENTH, Chromatic.F),
	FF7(ChromaticChordInfo.SEVENTH, Chromatic.FF),
	G7(ChromaticChordInfo.SEVENTH, Chromatic.G),
	GG7(ChromaticChordInfo.SEVENTH, Chromatic.GG),
	A7(ChromaticChordInfo.SEVENTH, Chromatic.A),
	AA7(ChromaticChordInfo.SEVENTH, Chromatic.AA),
	B7(ChromaticChordInfo.SEVENTH, Chromatic.B),

	// Séptima con quinta bemol
	C7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.C),
	CC7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.CC),
	D7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.D),
	DD7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.DD),
	E7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.E),
	F7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.F),
	FF7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.FF),
	G7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.G),
	GG7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.GG),
	A7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.A),
	AA7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.AA),
	B7b5(ChromaticChordInfo.SEVENTH_b5, Chromatic.B),

	// Séptima con quinta aumentada
	C7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.C),
	CC7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.CC),
	D7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.D),
	DD7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.DD),
	E7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.E),
	F7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.F),
	FF7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.FF),
	G7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.G),
	GG7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.GG),
	A7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.A),
	AA7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.AA),
	B7a5(ChromaticChordInfo.SEVENTH_a5, Chromatic.B),

	// Séptima con cuarta suspendida
	C7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.C),
	CC7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.CC),
	D7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.D),
	DD7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.DD),
	E7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.E),
	F7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.F),
	FF7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.FF),
	G7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.G),
	GG7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.GG),
	A7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.A),
	AA7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.AA),
	B7sus4(ChromaticChordInfo.SEVENTH_SUS4, Chromatic.B),

	// Menor séptima
	Cm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.C),
	CCm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.CC),
	Dm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.D),
	DDm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.DD),
	Em7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.E),
	Fm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.F),
	FFm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.FF),
	Gm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.G),
	GGm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.GG),
	Am7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.A),
	AAm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.AA),
	Bm7(ChromaticChordInfo.SEVENTH_MINOR, Chromatic.B),

	// Menor séptima con quinta bemol
	Cm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.C),
	CCm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.CC),
	Dm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.D),
	DDm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.DD),
	Em7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.E),
	Fm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.F),
	FFm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.FF),
	Gm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.G),
	GGm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.GG),
	Am7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.A),
	AAm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.AA),
	Bm7b5(ChromaticChordInfo.SEVENTH_MINOR_b5, Chromatic.B),

	// Menor séptima con quinta aumentada
	Cm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.C),
	CCm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.CC),
	Dm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.D),
	DDm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.DD),
	Em7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.E),
	Fm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.F),
	FFm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.FF),
	Gm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.G),
	GGm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.GG),
	Am7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.A),
	AAm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.AA),
	Bm7a5(ChromaticChordInfo.SEVENTH_MINOR_a5, Chromatic.B),

	// Sexta
	C6(ChromaticChordInfo.SIXTH, Chromatic.C),
	CC6(ChromaticChordInfo.SIXTH, Chromatic.CC),
	D6(ChromaticChordInfo.SIXTH, Chromatic.D),
	DD6(ChromaticChordInfo.SIXTH, Chromatic.DD),
	E6(ChromaticChordInfo.SIXTH, Chromatic.E),
	F6(ChromaticChordInfo.SIXTH, Chromatic.F),
	FF6(ChromaticChordInfo.SIXTH, Chromatic.FF),
	G6(ChromaticChordInfo.SIXTH, Chromatic.G),
	GG6(ChromaticChordInfo.SIXTH, Chromatic.GG),
	A6(ChromaticChordInfo.SIXTH, Chromatic.A),
	AA6(ChromaticChordInfo.SIXTH, Chromatic.AA),
	B6(ChromaticChordInfo.SIXTH, Chromatic.B),

	// Menor sexta
	Cm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.C),
	CCm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.CC),
	Dm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.D),
	DDm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.DD),
	Em6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.E),
	Fm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.F),
	FFm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.FF),
	Gm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.G),
	GGm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.GG),
	Am6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.A),
	AAm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.AA),
	Bm6(ChromaticChordInfo.SIXTH_MINOR, Chromatic.B),

	// Sexta con cuarta suspendida
	C6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.C),
	CC6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.CC),
	D6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.D),
	DD6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.DD),
	E6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.E),
	F6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.F),
	FF6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.FF),
	G6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.G),
	GG6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.GG),
	A6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.A),
	AA6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.AA),
	B6sus4(ChromaticChordInfo.SIXTH_SUS4, Chromatic.B),

	// Séptima mayor
	CMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.C),
	CCMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.CC),
	DMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.D),
	DDMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.DD),
	EMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.E),
	FMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.F),
	FFMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.FF),
	GMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.G),
	GGMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.GG),
	AMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.A),
	AAMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.AA),
	BMaj7(ChromaticChordInfo.SEVENTH_MAJ7, Chromatic.B),

	// Menor séptima mayor
	CmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.C),
	CCmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.CC),
	DmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.D),
	DDmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.DD),
	EmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.E),
	FmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.F),
	FFmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.FF),
	GmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.G),
	GGmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.GG),
	AmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.A),
	AAmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.AA),
	BmMaj7(ChromaticChordInfo.SEVENTH_MINOR_MAJ7, Chromatic.B),

	// Sexta con novena añadida
	C6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.C),
	CC6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.CC),
	D6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.D),
	DD6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.DD),
	E6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.E),
	F6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.F),
	FF6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.FF),
	G6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.G),
	GG6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.GG),
	A6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.A),
	AA6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.AA),
	B6add9(ChromaticChordInfo.SIXTH_ADD9, Chromatic.B),

	// Sexta con novena añadida
	Cm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.C),
	CCm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.CC),
	Dm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.D),
	DDm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.DD),
	Em6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.E),
	Fm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.F),
	FFm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.FF),
	Gm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.G),
	GGm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.GG),
	Am6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.A),
	AAm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.AA),
	Bm6add9(ChromaticChordInfo.SIXTH_MINOR_ADD9, Chromatic.B),

	// Séptima con novena bemol (añadida)
	C7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.C),
	CC7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.CC),
	D7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.D),
	DD7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.DD),
	E7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.E),
	F7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.F),
	FF7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.FF),
	G7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.G),
	GG7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.GG),
	A7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.A),
	AA7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.AA),
	B7b9(ChromaticChordInfo.SEVENTH_b9, Chromatic.B),

	// Séptima con novena aumentada (añadida)
	C7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.C),
	CC7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.CC),
	D7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.D),
	DD7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.DD),
	E7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.E),
	F7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.F),
	FF7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.FF),
	G7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.G),
	GG7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.GG),
	A7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.A),
	AA7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.AA),
	B7a9(ChromaticChordInfo.SEVENTH_a9, Chromatic.B),

	// Menor séptima con novena bemol (añadida)
	Cm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.C),
	CCm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.CC),
	Dm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.D),
	DDm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.DD),
	Em7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.E),
	Fm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.F),
	FFm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.FF),
	Gm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.G),
	GGm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.GG),
	Am7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.A),
	AAm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.AA),
	Bm7b9(ChromaticChordInfo.SEVENTH_MINOR_b9, Chromatic.B),

	// Séptima con oncena (añadida)
	C7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.C),
	CC7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.CC),
	D7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.D),
	DD7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.DD),
	E7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.E),
	F7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.F),
	FF7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.FF),
	G7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.G),
	GG7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.GG),
	A7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.A),
	AA7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.AA),
	B7add11(ChromaticChordInfo.SEVENTH_ADD11, Chromatic.B),

	// Séptima con treceava (añadida)
	C7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.C),
	CC7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.CC),
	D7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.D),
	DD7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.DD),
	E7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.E),
	F7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.F),
	FF7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.FF),
	G7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.G),
	GG7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.GG),
	A7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.A),
	AA7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.AA),
	B7add13(ChromaticChordInfo.SEVENTH_ADD13, Chromatic.B),

	// Novena
	C9(ChromaticChordInfo.NINTH, Chromatic.C),
	CC9(ChromaticChordInfo.NINTH, Chromatic.CC),
	D9(ChromaticChordInfo.NINTH, Chromatic.D),
	DD9(ChromaticChordInfo.NINTH, Chromatic.DD),
	E9(ChromaticChordInfo.NINTH, Chromatic.E),
	F9(ChromaticChordInfo.NINTH, Chromatic.F),
	FF9(ChromaticChordInfo.NINTH, Chromatic.FF),
	G9(ChromaticChordInfo.NINTH, Chromatic.G),
	GG9(ChromaticChordInfo.NINTH, Chromatic.GG),
	A9(ChromaticChordInfo.NINTH, Chromatic.A),
	AA9(ChromaticChordInfo.NINTH, Chromatic.AA),
	B9(ChromaticChordInfo.NINTH, Chromatic.B),

	// Menor novena
	Cm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.C),
	CCm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.CC),
	Dm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.D),
	DDm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.DD),
	Em9(ChromaticChordInfo.NINTH_MINOR, Chromatic.E),
	Fm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.F),
	FFm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.FF),
	Gm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.G),
	GGm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.GG),
	Am9(ChromaticChordInfo.NINTH_MINOR, Chromatic.A),
	AAm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.AA),
	Bm9(ChromaticChordInfo.NINTH_MINOR, Chromatic.B),

	// Novena con quinta bemol
	C9b5(ChromaticChordInfo.NINTH_b5, Chromatic.C),
	CC9b5(ChromaticChordInfo.NINTH_b5, Chromatic.CC),
	D9b5(ChromaticChordInfo.NINTH_b5, Chromatic.D),
	DD9b5(ChromaticChordInfo.NINTH_b5, Chromatic.DD),
	E9b5(ChromaticChordInfo.NINTH_b5, Chromatic.E),
	F9b5(ChromaticChordInfo.NINTH_b5, Chromatic.F),
	FF9b5(ChromaticChordInfo.NINTH_b5, Chromatic.FF),
	G9b5(ChromaticChordInfo.NINTH_b5, Chromatic.G),
	GG9b5(ChromaticChordInfo.NINTH_b5, Chromatic.GG),
	A9b5(ChromaticChordInfo.NINTH_b5, Chromatic.A),
	AA9b5(ChromaticChordInfo.NINTH_b5, Chromatic.AA),
	B9b5(ChromaticChordInfo.NINTH_b5, Chromatic.B),

	// Novena con quinta aumentada
	C9a5(ChromaticChordInfo.NINTH_a5, Chromatic.C),
	CC9a5(ChromaticChordInfo.NINTH_a5, Chromatic.CC),
	D9a5(ChromaticChordInfo.NINTH_a5, Chromatic.D),
	DD9a5(ChromaticChordInfo.NINTH_a5, Chromatic.DD),
	E9a5(ChromaticChordInfo.NINTH_a5, Chromatic.E),
	F9a5(ChromaticChordInfo.NINTH_a5, Chromatic.F),
	FF9a5(ChromaticChordInfo.NINTH_a5, Chromatic.FF),
	G9a5(ChromaticChordInfo.NINTH_a5, Chromatic.G),
	GG9a5(ChromaticChordInfo.NINTH_a5, Chromatic.GG),
	A9a5(ChromaticChordInfo.NINTH_a5, Chromatic.A),
	AA9a5(ChromaticChordInfo.NINTH_a5, Chromatic.AA),
	B9a5(ChromaticChordInfo.NINTH_a5, Chromatic.B),

	// Novena con cuarta suspendida
	C9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.C),
	CC9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.CC),
	D9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.D),
	DD9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.DD),
	E9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.E),
	F9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.F),
	FF9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.FF),
	G9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.G),
	GG9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.GG),
	A9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.A),
	AA9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.AA),
	B9sus4(ChromaticChordInfo.NINTH_SUS4, Chromatic.B),

	// Novena mayor
	CMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.C),
	CCMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.CC),
	DMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.D),
	DDMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.DD),
	EMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.E),
	FMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.F),
	FFMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.FF),
	GMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.G),
	GGMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.GG),
	AMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.A),
	AAMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.AA),
	BMaj9(ChromaticChordInfo.NINTH_MAJ9, Chromatic.B),

	// Menor novena mayor
	CmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.C),
	CCmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.CC),
	DmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.D),
	DDmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.DD),
	EmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.E),
	FmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.F),
	FFmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.FF),
	GmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.G),
	GGmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.GG),
	AmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.A),
	AAmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.AA),
	BmMaj9(ChromaticChordInfo.NINTH_MINOR_MAJ9, Chromatic.B),

	// Novena con sexta (añadida)
	C9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.C),
	CC9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.CC),
	D9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.D),
	DD9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.DD),
	E9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.E),
	F9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.F),
	FF9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.FF),
	G9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.G),
	GG9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.GG),
	A9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.A),
	AA9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.AA),
	B9add6(ChromaticChordInfo.NINTH_ADD6, Chromatic.B),

	// Novena con onceava aumentada (añadida)
	C9a11(ChromaticChordInfo.NINTH_a11, Chromatic.C),
	CC9a11(ChromaticChordInfo.NINTH_a11, Chromatic.CC),
	D9a11(ChromaticChordInfo.NINTH_a11, Chromatic.D),
	DD9a11(ChromaticChordInfo.NINTH_a11, Chromatic.DD),
	E9a11(ChromaticChordInfo.NINTH_a11, Chromatic.E),
	F9a11(ChromaticChordInfo.NINTH_a11, Chromatic.F),
	FF9a11(ChromaticChordInfo.NINTH_a11, Chromatic.FF),
	G9a11(ChromaticChordInfo.NINTH_a11, Chromatic.G),
	GG9a11(ChromaticChordInfo.NINTH_a11, Chromatic.GG),
	A9a11(ChromaticChordInfo.NINTH_a11, Chromatic.A),
	AA9a11(ChromaticChordInfo.NINTH_a11, Chromatic.AA),
	B9a11(ChromaticChordInfo.NINTH_a11, Chromatic.B),

	// Novena mayor con onceava aumentada (añadida)
	CMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.C),
	CCMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.CC),
	DMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.D),
	DDMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.DD),
	EMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.E),
	FMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.F),
	FFMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.FF),
	GMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.G),
	GGMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.GG),
	AMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.A),
	AAMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.AA),
	BMaj9a11(ChromaticChordInfo.NINTH_MAJ9_a11, Chromatic.B),

	// Onceava
	C11(ChromaticChordInfo.ELEVENTH, Chromatic.C),
	CC11(ChromaticChordInfo.ELEVENTH, Chromatic.CC),
	D11(ChromaticChordInfo.ELEVENTH, Chromatic.D),
	DD11(ChromaticChordInfo.ELEVENTH, Chromatic.DD),
	E11(ChromaticChordInfo.ELEVENTH, Chromatic.E),
	F11(ChromaticChordInfo.ELEVENTH, Chromatic.F),
	FF11(ChromaticChordInfo.ELEVENTH, Chromatic.FF),
	G11(ChromaticChordInfo.ELEVENTH, Chromatic.G),
	GG11(ChromaticChordInfo.ELEVENTH, Chromatic.GG),
	A11(ChromaticChordInfo.ELEVENTH, Chromatic.A),
	AA11(ChromaticChordInfo.ELEVENTH, Chromatic.AA),
	B11(ChromaticChordInfo.ELEVENTH, Chromatic.B),

	// Menor onceava
	Cm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.C),
	CCm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.CC),
	Dm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.D),
	DDm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.DD),
	Em11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.E),
	Fm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.F),
	FFm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.FF),
	Gm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.G),
	GGm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.GG),
	Am11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.A),
	AAm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.AA),
	Bm11(ChromaticChordInfo.ELEVENTH_MINOR, Chromatic.B),

	// Onceava con novena bemol
	C11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.C),
	CC11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.CC),
	D11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.D),
	DD11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.DD),
	E11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.E),
	F11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.F),
	FF11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.FF),
	G11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.G),
	GG11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.GG),
	A11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.A),
	AA11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.AA),
	B11b9(ChromaticChordInfo.ELEVENTH_b9, Chromatic.B),

	// Onceava con novena aumentada
	C11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.C),
	CC11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.CC),
	D11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.D),
	DD11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.DD),
	E11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.E),
	F11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.F),
	FF11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.FF),
	G11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.G),
	GG11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.GG),
	A11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.A),
	AA11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.AA),
	B11a9(ChromaticChordInfo.ELEVENTH_a9, Chromatic.B),

	// Onceava mayor
	CMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.C),
	CCMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.CC),
	DMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.D),
	DDMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.DD),
	EMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.E),
	FMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.F),
	FFMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.FF),
	GMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.G),
	GGMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.GG),
	AMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.A),
	AAMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.AA),
	BMaj11(ChromaticChordInfo.ELEVENTH_MAJ11, Chromatic.B),

	// Menor onceava mayor
	CmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.C),
	CCmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.CC),
	DmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.D),
	DDmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.DD),
	EmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.E),
	FmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.F),
	FFmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.FF),
	GmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.G),
	GGmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.GG),
	AmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.A),
	AAmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.AA),
	BmMaj11(ChromaticChordInfo.ELEVENTH_MINOR_MAJ11, Chromatic.B),

	// Menor treceava
	Cm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.C),
	CCm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.CC),
	Dm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.D),
	DDm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.DD),
	Em13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.E),
	Fm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.F),
	FFm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.FF),
	Gm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.G),
	GGm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.GG),
	Am13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.A),
	AAm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.AA),
	Bm13(ChromaticChordInfo.THIRTEENTH_MINOR, Chromatic.B),

	// Treceava con cuarta suspendida
	C13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.C),
	CC13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.CC),
	D13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.D),
	DD13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.DD),
	E13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.E),
	F13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.F),
	FF13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.FF),
	G13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.G),
	GG13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.GG),
	A13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.A),
	AA13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.AA),
	B13sus4(ChromaticChordInfo.THIRTEENTH_SUS4, Chromatic.B),

	// Treceava con quinta bemol
	C13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.C),
	CC13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.CC),
	D13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.D),
	DD13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.DD),
	E13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.E),
	F13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.F),
	FF13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.FF),
	G13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.G),
	GG13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.GG),
	A13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.A),
	AA13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.AA),
	B13b5(ChromaticChordInfo.THIRTEENTH_b5, Chromatic.B),

	// Treceava con quinta aumentada
	C13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.C),
	CC13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.CC),
	D13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.D),
	DD13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.DD),
	E13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.E),
	F13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.F),
	FF13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.FF),
	G13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.G),
	GG13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.GG),
	A13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.A),
	AA13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.AA),
	B13a5(ChromaticChordInfo.THIRTEENTH_a5, Chromatic.B),

	// Treceava con novena bemol
	C13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.C),
	CC13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.CC),
	D13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.D),
	DD13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.DD),
	E13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.E),
	F13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.F),
	FF13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.FF),
	G13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.G),
	GG13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.GG),
	A13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.A),
	AA13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.AA),
	B13b9(ChromaticChordInfo.THIRTEENTH_b9, Chromatic.B),

	// Treceava con novena aumentada
	C13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.C),
	CC13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.CC),
	D13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.D),
	DD13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.DD),
	E13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.E),
	F13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.F),
	FF13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.FF),
	G13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.G),
	GG13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.GG),
	A13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.A),
	AA13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.AA),
	B13a9(ChromaticChordInfo.THIRTEENTH_a9, Chromatic.B),

	// Treceava con quinta y novena bemoles
	C13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.C),
	CC13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.CC),
	D13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.D),
	DD13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.DD),
	E13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.E),
	F13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.F),
	FF13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.FF),
	G13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.G),
	GG13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.GG),
	A13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.A),
	AA13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.AA),
	B13b5b9(ChromaticChordInfo.THIRTEENTH_b5b9, Chromatic.B),

	// Treceava con quinta bemol y novena aumentada
	C13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.C),
	CC13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.CC),
	D13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.D),
	DD13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.DD),
	E13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.E),
	F13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.F),
	FF13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.FF),
	G13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.G),
	GG13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.GG),
	A13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.A),
	AA13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.AA),
	B13b5a9(ChromaticChordInfo.THIRTEENTH_b5a9, Chromatic.B),

	// Treceava con quinta aumentada y novena bemol
	C13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.C),
	CC13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.CC),
	D13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.D),
	DD13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.DD),
	E13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.E),
	F13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.F),
	FF13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.FF),
	G13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.G),
	GG13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.GG),
	A13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.A),
	AA13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.AA),
	B13a5b9(ChromaticChordInfo.THIRTEENTH_a5b9, Chromatic.B),

	// Treceava con quinta y novena aumentadas
	C13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.C),
	CC13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.CC),
	D13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.D),
	DD13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.DD),
	E13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.E),
	F13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.F),
	FF13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.FF),
	G13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.G),
	GG13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.GG),
	A13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.A),
	AA13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.AA),
	B13a5a9(ChromaticChordInfo.THIRTEENTH_a5a9, Chromatic.B),

	// Treceava mayor
	CMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.C),
	CCMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.CC),
	DMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.D),
	DDMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.DD),
	EMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.E),
	FMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.F),
	FFMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.FF),
	GMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.G),
	GGMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.GG),
	AMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.A),
	AAMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.AA),
	BMaj13(ChromaticChordInfo.THIRTEENTH_MAJ13, Chromatic.B),

	// Menor treceava mayor
	CmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.C),
	CCmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.CC),
	DmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.D),
	DDmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.DD),
	EmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.E),
	FmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.F),
	FFmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.FF),
	GmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.G),
	GGmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.GG),
	AmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.A),
	AAmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.AA),
	BmMaj13(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13, Chromatic.B),

	// Treceava mayor con quinta bemol
	CMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.C),
	CCMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.CC),
	DMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.D),
	DDMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.DD),
	EMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.E),
	FMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.F),
	FFMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.FF),
	GMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.G),
	GGMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.GG),
	AMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.A),
	AAMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.AA),
	BMaj13b5(ChromaticChordInfo.THIRTEENTH_MAJ13_b5, Chromatic.B),

	// Treceava mayor con quinta aumentada
	CMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.C),
	CCMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.CC),
	DMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.D),
	DDMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.DD),
	EMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.E),
	FMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.F),
	FFMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.FF),
	GMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.G),
	GGMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.GG),
	AMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.A),
	AAMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.AA),
	BMaj13a5(ChromaticChordInfo.THIRTEENTH_MAJ13_a5, Chromatic.B),

	// Treceava mayor con novena bemol
	CMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.C),
	CCMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.CC),
	DMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.D),
	DDMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.DD),
	EMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.E),
	FMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.F),
	FFMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.FF),
	GMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.G),
	GGMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.GG),
	AMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.A),
	AAMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.AA),
	BMaj13b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b9, Chromatic.B),

	// Treceava mayor con novena aumentada
	CMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.C),
	CCMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.CC),
	DMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.D),
	DDMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.DD),
	EMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.E),
	FMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.F),
	FFMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.FF),
	GMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.G),
	GGMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.GG),
	AMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.A),
	AAMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.AA),
	BMaj13a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a9, Chromatic.B),

	// Treceava mayor con quinta y novena bemoles
	CMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.C),
	CCMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.CC),
	DMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.D),
	DDMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.DD),
	EMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.E),
	FMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.F),
	FFMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.FF),
	GMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.G),
	GGMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.GG),
	AMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.A),
	AAMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.AA),
	BMaj13b5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9, Chromatic.B),

	// Treceava mayor con novena aumentada
	CMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.C),
	CCMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.CC),
	DMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.D),
	DDMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.DD),
	EMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.E),
	FMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.F),
	FFMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.FF),
	GMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.G),
	GGMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.GG),
	AMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.A),
	AAMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.AA),
	BMaj13b5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9, Chromatic.B),

	// Treceava mayor con quinta aumentada y novena bemol
	CMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.C),
	CCMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.CC),
	DMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.D),
	DDMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.DD),
	EMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.E),
	FMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.F),
	FFMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.FF),
	GMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.G),
	GGMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.GG),
	AMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.A),
	AAMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.AA),
	BMaj13a5b9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.B),

	// Treceava mayor con quinta y novena aumentadas
	CMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.C),
	CCMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.CC),
	DMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.D),
	DDMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.DD),
	EMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.E),
	FMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.F),
	FFMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.FF),
	GMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.G),
	GGMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.GG),
	AMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.A),
	AAMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.AA),
	BMaj13a5a9(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9, Chromatic.B),

/**
OMIT11
**/

	// Menor treceava
Cm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.C),
	CCm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.CC),
	Dm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.D),
	DDm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.DD),
	Em13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.E),
	Fm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.F),
	FFm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.FF),
	Gm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.G),
	GGm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.GG),
	Am13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.A),
	AAm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.AA),
	Bm13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_OMIT11, Chromatic.B),

	// Treceava con cuarta suspendida
	C13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.C),
	CC13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.CC),
	D13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.D),
	DD13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.DD),
	E13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.E),
	F13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.F),
	FF13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.FF),
	G13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.G),
	GG13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.GG),
	A13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.A),
	AA13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.AA),
	B13sus4omit11(ChromaticChordInfo.THIRTEENTH_SUS4_OMIT11, Chromatic.B),

	// Treceava con quinta bemol
	C13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.C),
	CC13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.CC),
	D13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.D),
	DD13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.DD),
	E13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.E),
	F13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.F),
	FF13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.FF),
	G13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.G),
	GG13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.GG),
	A13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.A),
	AA13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.AA),
	B13b5omit11(ChromaticChordInfo.THIRTEENTH_b5_OMIT11, Chromatic.B),

	// Treceava con quinta aumentada
	C13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.C),
	CC13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.CC),
	D13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.D),
	DD13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.DD),
	E13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.E),
	F13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.F),
	FF13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.FF),
	G13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.G),
	GG13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.GG),
	A13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.A),
	AA13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.AA),
	B13a5omit11(ChromaticChordInfo.THIRTEENTH_a5_OMIT11, Chromatic.B),

	// Treceava con novena bemol
	C13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.C),
	CC13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.CC),
	D13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.D),
	DD13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.DD),
	E13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.E),
	F13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.F),
	FF13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.FF),
	G13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.G),
	GG13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.GG),
	A13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.A),
	AA13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.AA),
	B13b9omit11(ChromaticChordInfo.THIRTEENTH_b9_OMIT11, Chromatic.B),

	// Treceava con novena aumentada
	C13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.C),
	CC13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.CC),
	D13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.D),
	DD13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.DD),
	E13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.E),
	F13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.F),
	FF13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.FF),
	G13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.G),
	GG13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.GG),
	A13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.A),
	AA13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.AA),
	B13a9omit11(ChromaticChordInfo.THIRTEENTH_a9_OMIT11, Chromatic.B),

	// Treceava con quinta y novena bemoles
	C13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.C),
	CC13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.CC),
	D13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.D),
	DD13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.DD),
	E13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.E),
	F13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.F),
	FF13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.FF),
	G13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.G),
	GG13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.GG),
	A13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.A),
	AA13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.AA),
	B13b5b9omit11(ChromaticChordInfo.THIRTEENTH_b5b9_OMIT11, Chromatic.B),

	// Treceava con quinta bemol y novena aumentada
	C13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.C),
	CC13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.CC),
	D13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.D),
	DD13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.DD),
	E13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.E),
	F13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.F),
	FF13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.FF),
	G13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.G),
	GG13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.GG),
	A13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.A),
	AA13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.AA),
	B13b5a9omit11(ChromaticChordInfo.THIRTEENTH_b5a9_OMIT11, Chromatic.B),

	// Treceava con quinta aumentada y novena bemol
	C13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.C),
	CC13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.CC),
	D13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.D),
	DD13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.DD),
	E13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.E),
	F13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.F),
	FF13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.FF),
	G13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.G),
	GG13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.GG),
	A13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.A),
	AA13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.AA),
	B13a5b9omit11(ChromaticChordInfo.THIRTEENTH_a5b9_OMIT11, Chromatic.B),

	// Treceava con quinta y novena aumentadas
	C13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.C),
	CC13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.CC),
	D13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.D),
	DD13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.DD),
	E13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.E),
	F13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.F),
	FF13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.FF),
	G13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.G),
	GG13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.GG),
	A13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.A),
	AA13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.AA),
	B13a5a9omit11(ChromaticChordInfo.THIRTEENTH_a5a9_OMIT11, Chromatic.B),

	// Treceava mayor
	CMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.C),
	CCMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.CC),
	DMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.D),
	DDMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.DD),
	EMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.E),
	FMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.F),
	FFMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.FF),
	GMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.G),
	GGMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.GG),
	AMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.A),
	AAMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.AA),
	BMaj13omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_OMIT11, Chromatic.B),

	// Menor treceava mayor
	CmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.C),
	CCmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.CC),
	DmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.D),
	DDmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.DD),
	EmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.E),
	FmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.F),
	FFmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.FF),
	GmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.G),
	GGmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.GG),
	AmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.A),
	AAmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.AA),
	BmMaj13omit11(ChromaticChordInfo.THIRTEENTH_MINOR_MAJ13_OMIT11, Chromatic.B),

	// Treceava mayor con quinta bemol
	CMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.C),
	CCMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.CC),
	DMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.D),
	DDMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.DD),
	EMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.E),
	FMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.F),
	FFMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.FF),
	GMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.G),
	GGMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.GG),
	AMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.A),
	AAMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.AA),
	BMaj13b5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5_OMIT11, Chromatic.B),

	// Treceava mayor con quinta aumentada
	CMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.C),
	CCMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.CC),
	DMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.D),
	DDMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.DD),
	EMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.E),
	FMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.F),
	FFMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.FF),
	GMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.G),
	GGMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.GG),
	AMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.A),
	AAMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.AA),
	BMaj13a5omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5_OMIT11, Chromatic.B),

	// Treceava mayor con novena bemol
	CMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.C),
	CCMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.CC),
	DMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.D),
	DDMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.DD),
	EMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.E),
	FMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.F),
	FFMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.FF),
	GMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.G),
	GGMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.GG),
	AMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.A),
	AAMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.AA),
	BMaj13b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b9_OMIT11, Chromatic.B),

	// Treceava mayor con novena aumentada
	CMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.C),
	CCMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.CC),
	DMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.D),
	DDMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.DD),
	EMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.E),
	FMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.F),
	FFMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.FF),
	GMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.G),
	GGMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.GG),
	AMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.A),
	AAMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.AA),
	BMaj13a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a9_OMIT11, Chromatic.B),

	// Treceava mayor con quinta y novena bemoles
	CMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.C),
	CCMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.CC),
	DMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.D),
	DDMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.DD),
	EMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.E),
	FMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.F),
	FFMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.FF),
	GMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.G),
	GGMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.GG),
	AMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.A),
	AAMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.AA),
	BMaj13b5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5b9_OMIT11, Chromatic.B),

	// Treceava mayor con novena aumentada
	CMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.C),
	CCMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.CC),
	DMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.D),
	DDMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.DD),
	EMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.E),
	FMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.F),
	FFMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.FF),
	GMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.G),
	GGMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.GG),
	AMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.A),
	AAMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.AA),
	BMaj13b5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_b5a9_OMIT11, Chromatic.B),

	// Treceava mayor con quinta aumentada y novena bemol
	CMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9_OMIT11, Chromatic.C),
	CCMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.CC),
	DMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.D),
	DDMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.DD),
	EMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.E),
	FMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.F),
	FFMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.FF),
	GMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.G),
	GGMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.GG),
	AMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.A),
	AAMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.AA),
	BMaj13a5b9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5b9, Chromatic.B),

	// Treceava mayor con quinta y novena aumentadas
	CMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.C),
	CCMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.CC),
	DMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.D),
	DDMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.DD),
	EMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.E),
	FMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.F),
	FFMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.FF),
	GMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.G),
	GGMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.GG),
	AMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.A),
	AAMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.AA),
	BMaj13a5a9omit11(ChromaticChordInfo.THIRTEENTH_MAJ13_a5a9_OMIT11, Chromatic.B),

	Csusa4(ChromaticChordInfo.SUS4a4, Chromatic.C),
	CCsusa4(ChromaticChordInfo.SUS4a4, Chromatic.CC),
	Dsusa4(ChromaticChordInfo.SUS4a4, Chromatic.D),
	DDsusa4(ChromaticChordInfo.SUS4a4, Chromatic.DD),
	Esusa4(ChromaticChordInfo.SUS4a4, Chromatic.E),
	Fsusa4(ChromaticChordInfo.SUS4a4, Chromatic.F),
	FFsusa4(ChromaticChordInfo.SUS4a4, Chromatic.FF),
	Gsusa4(ChromaticChordInfo.SUS4a4, Chromatic.G),
	GGsusa4(ChromaticChordInfo.SUS4a4, Chromatic.GG),
	Asusa4(ChromaticChordInfo.SUS4a4, Chromatic.A),
	AAsusa4(ChromaticChordInfo.SUS4a4, Chromatic.AA),
	Bsusa4(ChromaticChordInfo.SUS4a4, Chromatic.B),

	Csusb2(ChromaticChordInfo.SUS2b2, Chromatic.C),
	CCsusb2(ChromaticChordInfo.SUS2b2, Chromatic.CC),
	Dsusb2(ChromaticChordInfo.SUS2b2, Chromatic.D),
	DDsusb2(ChromaticChordInfo.SUS2b2, Chromatic.DD),
	Esusb2(ChromaticChordInfo.SUS2b2, Chromatic.E),
	Fsusb2(ChromaticChordInfo.SUS2b2, Chromatic.F),
	FFsusb2(ChromaticChordInfo.SUS2b2, Chromatic.FF),
	Gsusb2(ChromaticChordInfo.SUS2b2, Chromatic.G),
	GGsusb2(ChromaticChordInfo.SUS2b2, Chromatic.GG),
	Asusb2(ChromaticChordInfo.SUS2b2, Chromatic.A),
	AAsusb2(ChromaticChordInfo.SUS2b2, Chromatic.AA),
	Bsusb2(ChromaticChordInfo.SUS2b2, Chromatic.B),

	Csusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.C),
	CCsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.CC),
	Dsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.D),
	DDsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.DD),
	Esusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.E),
	Fsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.F),
	FFsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.FF),
	Gsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.G),
	GGsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.GG),
	Asusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.A),
	AAsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.AA),
	Bsusb2b5(ChromaticChordInfo.SUS2b2b5, Chromatic.B);

	/** Variables */
	final List<Chromatic> notes;
	final private ChromaticChordInfo info;

	ChromaticChordImmutable(@NonNull ChromaticChordInfo chromaticChordInfo, @NonNull Chromatic base) {
		Objects.requireNonNull(chromaticChordInfo);
		Objects.requireNonNull(base);
		Objects.requireNonNull(chromaticChordInfo.getPattern());

		List<Chromatic> mutableNotesList = new ArrayList<>();
		for (Integer n : chromaticChordInfo.getPattern()) {
			Chromatic newChromatic = base.getNext(n);
			mutableNotesList.add(newChromatic);
		}

		notes = Collections.unmodifiableList( mutableNotesList );
		info = chromaticChordInfo;
	}

	static @Nullable ChromaticChordImmutable from(@NonNull Iterable<Chromatic> chromaticCollection) {
		for (ChromaticChordImmutable chromaticChordEnum : ChromaticChordImmutable.values())
			if (chromaticChordEnum.hasSameNotesAs(chromaticCollection))
				return chromaticChordEnum;

		return null;
	}

	private boolean hasSameNotesAs(@NonNull Iterable<Chromatic> diatonicCollection) {
		return notes.equals(diatonicCollection);
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
	@NonNull
	public Chromatic getRoot() {
		return notes.get(getRootIndex());
	}

	@Override
	public int getRootIndex() {
		return 0;
	}

	@Override
	public int getInversionNumber() {
		return 0;
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
	public List<Chromatic> subList(int fromIndex, int toIndex) {
		return notes.subList( fromIndex, toIndex );
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

	@Override
	public String toString() {
		return getRoot() + info.getSuffix();
	}

	@Override
	public @NonNull ChromaticChordInfo getInfo() {
		return info;
	}
}