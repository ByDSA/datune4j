package chromaticchord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiFunction;

import arrays.ArrayUtils;
import arrays.ArrayWrapperInteger;
import chromaticchord.CustomChromaticChord.ImpossibleChord;
import diatonic.ChordNotation;
import diatonic.Quality;
import pitch.Chromatic;
import pitch.PitchChromaticChord;
import pitch.PitchChromaticable;
import pitch.PitchChromaticableChord;
import pitch.PitchChromaticableSingle;
import pitch.PitchDiatonic;
import tonality.Tonality;
import tonality.TonalityException;

public enum ChromaticChordEnum implements PitchChromaticChord<Chromatic> {
	// Quintas
	C5(Chromatic.C, Chromatic.G),
	CC5(Chromatic.CC, Chromatic.GG),
	D5(Chromatic.D, Chromatic.A),
	DD5(Chromatic.DD, Chromatic.AA),
	E5(Chromatic.E, Chromatic.B),
	F5(Chromatic.F, Chromatic.C),
	FF5(Chromatic.FF, Chromatic.CC),
	G5(Chromatic.G, Chromatic.D),
	GG5(Chromatic.GG, Chromatic.DD),
	A5(Chromatic.A, Chromatic.E),
	AA5(Chromatic.AA, Chromatic.F),
	B5(Chromatic.B, Chromatic.FF),

	// Mayores
	C(Chromatic.C, Chromatic.E, Chromatic.G),
	CC(Chromatic.CC, Chromatic.F, Chromatic.GG),
	D(Chromatic.D, Chromatic.FF, Chromatic.A),
	DD(Chromatic.DD, Chromatic.G, Chromatic.AA),
	E(Chromatic.E, Chromatic.GG, Chromatic.B),
	F(Chromatic.F, Chromatic.A, Chromatic.C),
	FF(Chromatic.FF, Chromatic.AA, Chromatic.CC),
	G(Chromatic.G, Chromatic.B, Chromatic.D),
	GG(Chromatic.GG, Chromatic.C, Chromatic.DD),
	A(Chromatic.A, Chromatic.CC, Chromatic.E),
	AA(Chromatic.AA, Chromatic.D, Chromatic.F),
	B(Chromatic.B, Chromatic.DD, Chromatic.FF),

	// Menores
	Cm(Chromatic.C, Chromatic.DD, Chromatic.G),
	CCm(Chromatic.CC, Chromatic.E, Chromatic.GG),
	Dm(Chromatic.D, Chromatic.F, Chromatic.A),
	DDm(Chromatic.DD, Chromatic.FF, Chromatic.AA),
	Em(Chromatic.E, Chromatic.G, Chromatic.B),
	Fm(Chromatic.F, Chromatic.GG, Chromatic.C),
	FFm(Chromatic.FF, Chromatic.A, Chromatic.CC),
	Gm(Chromatic.G, Chromatic.AA, Chromatic.D),
	GGm(Chromatic.GG, Chromatic.B, Chromatic.DD),
	Am(Chromatic.A, Chromatic.C, Chromatic.E),
	AAm(Chromatic.AA, Chromatic.CC, Chromatic.F),
	Bm(Chromatic.B, Chromatic.D, Chromatic.FF),

	// Aumentados
	Caug(Chromatic.C, Chromatic.E, Chromatic.GG),
	CCaug(Chromatic.CC, Chromatic.F, Chromatic.A),
	Daug(Chromatic.D, Chromatic.FF, Chromatic.AA),
	DDaug(Chromatic.DD, Chromatic.G, Chromatic.B),
	Eaug(Chromatic.E, Chromatic.GG, Chromatic.C),
	Faug(Chromatic.F, Chromatic.A, Chromatic.CC),
	FFaug(Chromatic.FF, Chromatic.AA, Chromatic.D),
	Gaug(Chromatic.G, Chromatic.B, Chromatic.DD),
	GGaug(Chromatic.GG, Chromatic.C, Chromatic.E),
	Aaug(Chromatic.A, Chromatic.CC, Chromatic.F),
	AAaug(Chromatic.AA, Chromatic.D, Chromatic.FF),
	Baug(Chromatic.B, Chromatic.DD, Chromatic.G),

	// Diminuidos
	Cdim(Chromatic.C, Chromatic.DD, Chromatic.FF),
	CCdim(Chromatic.CC, Chromatic.E, Chromatic.G),
	Ddim(Chromatic.D, Chromatic.F, Chromatic.GG),
	DDdim(Chromatic.DD, Chromatic.FF, Chromatic.A),
	Edim(Chromatic.E, Chromatic.G, Chromatic.AA),
	Fdim(Chromatic.F, Chromatic.GG, Chromatic.B),
	FFdim(Chromatic.FF, Chromatic.A, Chromatic.C),
	Gdim(Chromatic.G, Chromatic.AA, Chromatic.CC),
	GGdim(Chromatic.GG, Chromatic.B, Chromatic.D),
	Adim(Chromatic.A, Chromatic.C, Chromatic.DD),
	AAdim(Chromatic.AA, Chromatic.CC, Chromatic.E),
	Bdim(Chromatic.B, Chromatic.D, Chromatic.F),

	// Cuarta suspendida
	Csus4(Chromatic.C, Chromatic.F, Chromatic.G),
	CCsus4(Chromatic.CC, Chromatic.FF, Chromatic.GG),
	Dsus4(Chromatic.D, Chromatic.G, Chromatic.A),
	DDsus4(Chromatic.DD, Chromatic.GG, Chromatic.AA),
	Esus4(Chromatic.E, Chromatic.A, Chromatic.B),
	Fsus4(Chromatic.F, Chromatic.AA, Chromatic.C),
	FFsus4(Chromatic.FF, Chromatic.B, Chromatic.CC),
	Gsus4(Chromatic.G, Chromatic.C, Chromatic.D),
	GGsus4(Chromatic.GG, Chromatic.CC, Chromatic.DD),
	Asus4(Chromatic.A, Chromatic.D, Chromatic.E),
	AAsus4(Chromatic.AA, Chromatic.DD, Chromatic.F),
	Bsus4(Chromatic.B, Chromatic.E, Chromatic.FF),

	// Segunda suspendida
	Csus2(Chromatic.C, Chromatic.D, Chromatic.G),
	CCsus2(Chromatic.CC, Chromatic.DD, Chromatic.GG),
	Dsus2(Chromatic.D, Chromatic.E, Chromatic.A),
	DDsus2(Chromatic.DD, Chromatic.F, Chromatic.AA),
	Esus2(Chromatic.E, Chromatic.FF, Chromatic.B),
	Fsus2(Chromatic.F, Chromatic.G, Chromatic.C),
	FFsus2(Chromatic.FF, Chromatic.GG, Chromatic.CC),
	Gsus2(Chromatic.G, Chromatic.A, Chromatic.D),
	GGsus2(Chromatic.GG, Chromatic.AA, Chromatic.DD),
	Asus2(Chromatic.A, Chromatic.B, Chromatic.E),
	AAsus2(Chromatic.AA, Chromatic.C, Chromatic.F),
	Bsus2(Chromatic.B, Chromatic.CC, Chromatic.FF),

	// Séptima (de dominante)
	C7(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA),
	CC7(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B),
	D7(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C),
	DD7(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC),
	E7(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D),
	F7(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD),
	FF7(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E),
	G7(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F),
	GG7(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF),
	A7(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G),
	AA7(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG),
	B7(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A),

	// Séptima con quinta bemol
	C7b5(Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	CC7b5(Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	D7b5(Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	DD7b5(Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),
	E7b5(Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	F7b5(Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	FF7b5(Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	G7b5(Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	GG7b5(Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	A7b5(Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	AA7b5(Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),
	B7b5(Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),

	// Séptima con quinta aumentada
	C7a5(Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA),
	CC7a5(Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B),
	D7a5(Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C),
	DD7a5(Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC),
	E7a5(Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D),
	F7a5(Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD),
	FF7a5(Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E),
	G7a5(Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F),
	GG7a5(Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF),
	A7a5(Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G),
	AA7a5(Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG),
	B7a5(Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A),

	// Séptima con cuarta suspendida
	C7sus4(Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA),
	CC7sus4(Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B),
	D7sus4(Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C),
	DD7sus4(Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC),
	E7sus4(Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D),
	F7sus4(Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD),
	FF7sus4(Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E),
	G7sus4(Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F),
	GG7sus4(Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF),
	A7sus4(Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G),
	AA7sus4(Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG),
	B7sus4(Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A),

	// Menor séptima
	Cm7(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA),
	CCm7(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B),
	Dm7(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
	DDm7(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC),
	Em7(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D),
	Fm7(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD),
	FFm7(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E),
	Gm7(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F),
	GGm7(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF),
	Am7(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G),
	AAm7(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG),
	Bm7(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A),

	// Menor séptima con quinta bemol
	Cm7b5(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	CCm7b5(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	Dm7b5(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	DDm7b5(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	Em7b5(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	Fm7b5(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	FFm7b5(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	Gm7b5(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	GGm7b5(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	Am7b5(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	AAm7b5(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),
	Bm7b5(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),

	// Menor séptima con quinta aumentada
	Cm7a5(Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA),
	CCm7a5(Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B),
	Dm7a5(Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C),
	DDm7a5(Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC),
	Em7a5(Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D),
	Fm7a5(Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD),
	FFm7a5(Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E),
	Gm7a5(Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F),
	GGm7a5(Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF),
	Am7a5(Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G),
	AAm7a5(Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG),
	Bm7a5(Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A),

	// Sexta
	C6(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A),
	CC6(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA),
	D6(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B),
	DD6(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C),
	E6(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC),
	F6(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D),
	FF6(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD),
	G6(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E),
	GG6(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F),
	A6(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF),
	AA6(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G),
	B6(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG),

	// Menor sexta
	Cm6(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A),
	CCm6(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA),
	Dm6(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B),
	DDm6(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C),
	Em6(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC),
	Fm6(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D),
	FFm6(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD),
	Gm6(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E),
	GGm6(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F),
	Am6(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF),
	AAm6(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G),
	Bm6(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG),

	// Sexta con cuarta suspendida
	C6sus4(Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.A),
	CC6sus4(Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.AA),
	D6sus4(Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.B),
	DD6sus4(Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.C),
	E6sus4(Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.CC),
	F6sus4(Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.D),
	FF6sus4(Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.DD),
	G6sus4(Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.E),
	GG6sus4(Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.F),
	A6sus4(Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.FF),
	AA6sus4(Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.G),
	B6sus4(Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.GG),

	// Séptima mayor
	CMaj7(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	CCMaj7(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	DMaj7(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	DDMaj7(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	EMaj7(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	FMaj7(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	FFMaj7(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	GMaj7(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	GGMaj7(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	AMaj7(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),
	AAMaj7(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	BMaj7(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),

	// Menor séptima mayor
	CmMaj7(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	CCmMaj7(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	DmMaj7(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	DDmMaj7(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	EmMaj7(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	FmMaj7(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	FFmMaj7(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),
	GmMaj7(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	GGmMaj7(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	AmMaj7(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),
	AAmMaj7(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	BmMaj7(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),

	// Sexta con novena añadida
	C6add9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.D),
	CC6add9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.DD),
	D6add9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.E),
	DD6add9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.F),
	E6add9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.FF),
	F6add9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.G),
	FF6add9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.GG),
	G6add9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.A),
	GG6add9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.AA),
	A6add9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.B),
	AA6add9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.C),
	B6add9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.CC),

	// Sexta con novena añadida
	Cm6add9(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D),
	CCm6add9(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD),
	Dm6add9(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E),
	DDm6add9(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F),
	Em6add9(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF),
	Fm6add9(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G),
	FFm6add9(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG),
	Gm6add9(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A),
	GGm6add9(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA),
	Am6add9(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B),
	AAm6add9(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C),
	Bm6add9(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC),

	// Séptima con novena bemol (añadida)
	C7b9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC),
	CC7b9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D),
	D7b9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD),
	DD7b9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E),
	E7b9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F),
	F7b9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF),
	FF7b9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G),
	G7b9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG),
	GG7b9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A),
	A7b9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA),
	AA7b9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B),
	B7b9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C),

	// Séptima con novena aumentada (añadida)
	C7a9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD),
	CC7a9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E),
	D7a9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F),
	DD7a9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF),
	E7a9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G),
	F7a9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG),
	FF7a9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A),
	G7a9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA),
	GG7a9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B),
	A7a9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C),
	AA7a9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC),
	B7a9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D),

	// Menor séptima con novena bemol (añadida)
	Cm7b9(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC),
	CCm7b9(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D),
	Dm7b9(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD),
	DDm7b9(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E),
	Em7b9(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F),
	Fm7b9(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF),
	FFm7b9(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G),
	Gm7b9(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG),
	GGm7b9(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A),
	Am7b9(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA),
	AAm7b9(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B),
	Bm7b9(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C),

	// Séptima con oncena (añadida)
	C7add11(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.F),
	CC7add11(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.FF),
	D7add11(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.G),
	DD7add11(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.GG),
	E7add11(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.A),
	F7add11(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.AA),
	FF7add11(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.B),
	G7add11(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.C),
	GG7add11(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.CC),
	A7add11(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.D),
	AA7add11(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.DD),
	B7add11(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.E),

	// Séptima con oncena (añadida)
	C7add13(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.A),
	CC7add13(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.AA),
	D7add13(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.B),
	DD7add13(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.C),
	E7add13(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.CC),
	F7add13(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.D),
	FF7add13(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.DD),
	G7add13(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.E),
	GG7add13(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.F),
	A7add13(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.FF),
	AA7add13(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.G),
	B7add13(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.GG),

	// Novena
	C9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	CC9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	D9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	DD9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	E9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	F9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	FF9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),
	G9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	GG9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	A9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	AA9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	B9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),

	// Menor novena
	Cm9(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	CCm9(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	Dm9(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	DDm9(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	Em9(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	Fm9(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	FFm9(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),
	Gm9(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	GGm9(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	Am9(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	AAm9(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	Bm9(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),

	// Novena con quinta bemol
	C9b5(Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D),
	CC9b5(Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD),
	D9b5(Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E),
	DD9b5(Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F),
	E9b5(Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF),
	F9b5(Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G),
	FF9b5(Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG),
	G9b5(Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A),
	GG9b5(Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA),
	A9b5(Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B),
	AA9b5(Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C),
	B9b5(Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC),

	// Novena con quinta aumentada
	C9a5(Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	CC9a5(Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	D9a5(Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	DD9a5(Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	E9a5(Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	F9a5(Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	FF9a5(Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),
	G9a5(Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),
	GG9a5(Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	A9a5(Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	AA9a5(Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	B9a5(Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),

	// Novena con cuarta suspendida
	C9sus4(Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D),
	CC9sus4(Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD),
	D9sus4(Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E),
	DD9sus4(Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F),
	E9sus4(Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF),
	F9sus4(Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G),
	FF9sus4(Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG),
	G9sus4(Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A),
	GG9sus4(Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	A9sus4(Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B),
	AA9sus4(Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C),
	B9sus4(Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC),

	// Novena mayor
	CMaj9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D),
	CCMaj9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD),
	DMaj9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E),
	DDMaj9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F),
	EMaj9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF),
	FMaj9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G),
	FFMaj9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG),
	GMaj9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A),
	GGMaj9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA),
	AMaj9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B),
	AAMaj9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
	BMaj9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC),

	// Menor novena mayor
	CmMaj9(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D),
	CCmMaj9(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD),
	DmMaj9(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E),
	DDmMaj9(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F),
	EmMaj9(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF),
	FmMaj9(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G),
	FFmMaj9(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG),
	GmMaj9(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A),
	GGmMaj9(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA),
	AmMaj9(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B),
	AAmMaj9(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C),
	BmMaj9(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC),

	// Novena con sexta (añadida)
	C9add6(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.AA, Chromatic.D),
	CC9add6(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.B, Chromatic.DD),
	D9add6(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.C, Chromatic.E),
	DD9add6(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.CC, Chromatic.F),
	E9add6(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.D, Chromatic.FF),
	F9add6(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.DD, Chromatic.G),
	FF9add6(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.E, Chromatic.GG),
	G9add6(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.F, Chromatic.A),
	GG9add6(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.FF, Chromatic.AA),
	A9add6(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.G, Chromatic.B),
	AA9add6(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.GG, Chromatic.C),
	B9add6(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.A, Chromatic.CC),

	// Novena con onceava aumentada (añadida)
	C9a11(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	CC9a11(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	D9a11(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),
	DD9a11(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	E9a11(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),
	F9a11(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	FF9a11(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	G9a11(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	GG9a11(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	A9a11(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	AA9a11(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	B9a11(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),

	// Novena mayor con onceava aumentada (añadida)
	CMaj9a11(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	CCMaj9a11(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	DMaj9a11(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),
	DDMaj9a11(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	EMaj9a11(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	FMaj9a11(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	FFMaj9a11(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	GMaj9a11(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	GGMaj9a11(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	AMaj9a11(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	AAMaj9a11(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	BMaj9a11(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),

	// Onceava
	C11(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F),
	CC11(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF),
	D11(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G),
	DD11(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG),
	E11(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A),
	F11(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA),
	FF11(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B),
	G11(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
	GG11(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC),
	A11(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D),
	AA11(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD),
	B11(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E),

	// Menor onceava
	Cm11(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F),
	CCm11(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF),
	Dm11(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G),
	DDm11(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG),
	Em11(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A),
	Fm11(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA),
	FFm11(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B),
	Gm11(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
	GGm11(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC),
	Am11(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D),
	AAm11(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD),
	Bm11(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E),

	// Onceava con novena bemol
	C11b9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	CC11b9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	D11b9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	DD11b9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),
	E11b9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	F11b9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	FF11b9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	G11b9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	GG11b9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	A11b9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	AA11b9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	B11b9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),

	// Onceava con novena aumentada
	C11a9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F),
	CC11a9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF),
	D11a9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G),
	DD11a9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG),
	E11a9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A),
	F11a9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA),
	FF11a9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B),
	G11a9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C),
	GG11a9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC),
	A11a9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D),
	AA11a9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD),
	B11a9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E),

	// Onceava mayor
	CMaj11(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F),
	CCMaj11(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF),
	DMaj11(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G),
	DDMaj11(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG),
	EMaj11(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A),
	FMaj11(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA),
	FFMaj11(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B),
	GMaj11(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C),
	GGMaj11(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC),
	AMaj11(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D),
	AAMaj11(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD),
	BMaj11(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E),

	// Menor onceava mayor
	CmMaj11(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F),
	CCmMaj11(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF),
	DmMaj11(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G),
	DDmMaj11(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG),
	EmMaj11(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A),
	FmMaj11(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA),
	FFmMaj11(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B),
	GmMaj11(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C),
	GGmMaj11(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC),
	AmMaj11(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D),
	AAmMaj11(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD),
	BmMaj11(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E),

	// Menor treceava
	Cm13(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	CCm13(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	Dm13(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	DDm13(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	Em13(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	Fm13(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFm13(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	Gm13(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	GGm13(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	Am13(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAm13(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	Bm13(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava con cuarta suspendida
	C13sus4(Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	CC13sus4(Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	D13sus4(Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	DD13sus4(Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	E13sus4(Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	F13sus4(Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	FF13sus4(Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	G13sus4(Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	GG13sus4(Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	A13sus4(Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	AA13sus4(Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	B13sus4(Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava con quinta bemol
	C13b5(Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	CC13b5(Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	D13b5(Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	DD13b5(Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	E13b5(Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	F13b5(Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	FF13b5(Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	G13b5(Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	GG13b5(Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	A13b5(Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	AA13b5(Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	B13b5(Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava con quinta aumentada
	C13a5(Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A),
	CC13a5(Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	D13a5(Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B),
	DD13a5(Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C),
	E13a5(Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC),
	F13a5(Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D),
	FF13a5(Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD),
	G13a5(Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E),
	GG13a5(Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F),
	A13a5(Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF),
	AA13a5(Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G),
	B13a5(Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava con novena bemol
	C13b9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	CC13b9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),
	D13b9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	DD13b9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	E13b9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	F13b9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FF13b9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	G13b9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	GG13b9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),
	A13b9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AA13b9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	B13b9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava con novena aumentada
	C13a9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A),
	CC13a9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA),
	D13a9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B),
	DD13a9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C),
	E13a9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC),
	F13a9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FF13a9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD),
	G13a9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E),
	GG13a9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F),
	A13a9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF),
	AA13a9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G),
	B13a9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava con quinta y novena bemoles
	C13b5b9(Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	CC13b5b9(Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),
	D13b5b9(Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	DD13b5b9(Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	E13b5b9(Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	F13b5b9(Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FF13b5b9(Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	G13b5b9(Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	GG13b5b9(Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),
	A13b5b9(Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AA13b5b9(Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	B13b5b9(Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava con quinta bemol y novena aumentada
	C13b5a9(Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A),
	CC13b5a9(Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA),
	D13b5a9(Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B),
	DD13b5a9(Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C),
	E13b5a9(Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC),
	F13b5a9(Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FF13b5a9(Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD),
	G13b5a9(Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E),
	GG13b5a9(Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F),
	A13b5a9(Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF),
	AA13b5a9(Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G),
	B13b5a9(Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava con quinta aumentada y novena bemol
	C13a5b9(Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A),
	CC13a5b9(Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA),
	D13a5b9(Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B),
	DD13a5b9(Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C),
	E13a5b9(Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC),
	F13a5b9(Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FF13a5b9(Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD),
	G13a5b9(Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E),
	GG13a5b9(Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F),
	A13a5b9(Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AA13a5b9(Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G),
	B13a5b9(Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava con quinta y novena aumentadas
	C13a5a9(Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A),
	CC13a5a9(Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA),
	D13a5a9(Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B),
	DD13a5a9(Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C),
	E13a5a9(Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC),
	F13a5a9(Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FF13a5a9(Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD),
	G13a5a9(Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E),
	GG13a5a9(Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F),
	A13a5a9(Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF),
	AA13a5a9(Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G),
	B13a5a9(Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava mayor
	CMaj13(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	CCMaj13(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	DMaj13(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	DDMaj13(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	EMaj13(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	FMaj13(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFMaj13(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	GMaj13(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	GGMaj13(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	AMaj13(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAMaj13(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	BMaj13(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Menor treceava mayor
	CmMaj13(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	CCmMaj13(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	DmMaj13(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	DDmMaj13(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	EmMaj13(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	FmMaj13(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFmMaj13(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	GmMaj13(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	GGmMaj13(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	AmMaj13(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAmMaj13(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	BmMaj13(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta bemol
	CMaj13b5(Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	CCMaj13b5(Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	DMaj13b5(Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	DDMaj13b5(Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	EMaj13b5(Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	FMaj13b5(Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFMaj13b5(Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	GMaj13b5(Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	GGMaj13b5(Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	AMaj13b5(Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAMaj13b5(Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	BMaj13b5(Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta aumentada
	CMaj13a5(Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A),
	CCMaj13a5(Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA),
	DMaj13a5(Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B),
	DDMaj13a5(Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C),
	EMaj13a5(Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC),
	FMaj13a5(Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D),
	FFMaj13a5(Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD),
	GMaj13a5(Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E),
	GGMaj13a5(Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F),
	AMaj13a5(Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF),
	AAMaj13a5(Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G),
	BMaj13a5(Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG),

	// Treceava mayor con novena bemol
	CMaj13b9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A),
	CCMaj13b9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA),
	DMaj13b9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B),
	DDMaj13b9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C),
	EMaj13b9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC),
	FMaj13b9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FFMaj13b9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD),
	GMaj13b9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E),
	GGMaj13b9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F),
	AMaj13b9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AAMaj13b9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G),
	BMaj13b9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava mayor con novena aumentada
	CMaj13a9(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),
	CCMaj13a9(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	DMaj13a9(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	DDMaj13a9(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	EMaj13a9(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),
	FMaj13a9(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FFMaj13a9(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	GMaj13a9(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	GGMaj13a9(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	AMaj13a9(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	AAMaj13a9(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	BMaj13a9(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta y novena bemoles
	CMaj13b5b9(Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A),
	CCMaj13b5b9(Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA),
	DMaj13b5b9(Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B),
	DDMaj13b5b9(Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C),
	EMaj13b5b9(Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC),
	FMaj13b5b9(Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FFMaj13b5b9(Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD),
	GMaj13b5b9(Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E),
	GGMaj13b5b9(Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F),
	AMaj13b5b9(Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AAMaj13b5b9(Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G),
	BMaj13b5b9(Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava mayor con novena aumentada
	CMaj13b5a9(Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),
	CCMaj13b5a9(Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	DMaj13b5a9(Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	DDMaj13b5a9(Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	EMaj13b5a9(Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),
	FMaj13b5a9(Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FFMaj13b5a9(Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	GMaj13b5a9(Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	GGMaj13b5a9(Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	AMaj13b5a9(Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	AAMaj13b5a9(Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	BMaj13b5a9(Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta aumentada y novena bemol
	CMaj13a5b9(Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.CC, Chromatic.F, Chromatic.A),
	CCMaj13a5b9(Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D, Chromatic.FF, Chromatic.AA),
	DMaj13a5b9(Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD, Chromatic.G, Chromatic.B),
	DDMaj13a5b9(Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.E, Chromatic.GG, Chromatic.C),
	EMaj13a5b9(Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F, Chromatic.A, Chromatic.CC),
	FMaj13a5b9(Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.FF, Chromatic.AA, Chromatic.D),
	FFMaj13a5b9(Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G, Chromatic.B, Chromatic.DD),
	GMaj13a5b9(Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.GG, Chromatic.C, Chromatic.E),
	GGMaj13a5b9(Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.A, Chromatic.CC, Chromatic.F),
	AMaj13a5b9(Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA, Chromatic.D, Chromatic.FF),
	AAMaj13a5b9(Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.B, Chromatic.DD, Chromatic.G),
	BMaj13a5b9(Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C, Chromatic.E, Chromatic.GG),

	// Treceava mayor con quinta y novena aumentadas
	CMaj13a5a9(Chromatic.C, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F, Chromatic.A),
	CCMaj13a5a9(Chromatic.CC, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.FF, Chromatic.AA),
	DMaj13a5a9(Chromatic.D, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G, Chromatic.B),
	DDMaj13a5a9(Chromatic.DD, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.GG, Chromatic.C),
	EMaj13a5a9(Chromatic.E, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A, Chromatic.CC),
	FMaj13a5a9(Chromatic.F, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA, Chromatic.D),
	FFMaj13a5a9(Chromatic.FF, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.B, Chromatic.DD),
	GMaj13a5a9(Chromatic.G, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C, Chromatic.E),
	GGMaj13a5a9(Chromatic.GG, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.CC, Chromatic.F),
	AMaj13a5a9(Chromatic.A, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D, Chromatic.FF),
	AAMaj13a5a9(Chromatic.AA, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD, Chromatic.G),
	BMaj13a5a9(Chromatic.B, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.E, Chromatic.GG),

	Csusa4(Chromatic.C, Chromatic.FF, Chromatic.G),
	CCsusa4(Chromatic.CC, Chromatic.G, Chromatic.GG),
	Dsusa4(Chromatic.D, Chromatic.GG, Chromatic.A),
	DDsusa4(Chromatic.DD, Chromatic.A, Chromatic.AA),
	Esusa4(Chromatic.E, Chromatic.AA, Chromatic.B),
	Fsusa4(Chromatic.F, Chromatic.B, Chromatic.C),
	FFsusa4(Chromatic.FF, Chromatic.C, Chromatic.CC),
	Gsusa4(Chromatic.G, Chromatic.CC, Chromatic.D),
	GGsusa4(Chromatic.GG, Chromatic.D, Chromatic.DD),
	Asusa4(Chromatic.A, Chromatic.DD, Chromatic.E),
	AAsusa4(Chromatic.AA, Chromatic.E, Chromatic.F),
	Bsusa4(Chromatic.B, Chromatic.F, Chromatic.FF),

	Csusb2(Chromatic.C, Chromatic.CC, Chromatic.G),
	CCsusb2(Chromatic.CC, Chromatic.D, Chromatic.GG),
	Dsusb2(Chromatic.D, Chromatic.DD, Chromatic.A),
	DDsusb2(Chromatic.DD, Chromatic.E, Chromatic.AA),
	Esusb2(Chromatic.E, Chromatic.F, Chromatic.B),
	Fsusb2(Chromatic.F, Chromatic.FF, Chromatic.C),
	FFsusb2(Chromatic.FF, Chromatic.G, Chromatic.CC),
	Gsusb2(Chromatic.G, Chromatic.GG, Chromatic.D),
	GGsusb2(Chromatic.GG, Chromatic.A, Chromatic.DD),
	Asusb2(Chromatic.A, Chromatic.AA, Chromatic.E),
	AAsusb2(Chromatic.AA, Chromatic.B, Chromatic.F),
	Bsusb2(Chromatic.B, Chromatic.C, Chromatic.FF),

	Csusb2b5(Chromatic.C, Chromatic.CC, Chromatic.FF),
	CCsusb2b5(Chromatic.CC, Chromatic.D, Chromatic.G),
	Dsusb2b5(Chromatic.D, Chromatic.DD, Chromatic.GG),
	DDsusb2b5(Chromatic.DD, Chromatic.E, Chromatic.A),
	Esusb2b5(Chromatic.E, Chromatic.F, Chromatic.AA),
	Fsusb2b5(Chromatic.F, Chromatic.FF, Chromatic.B),
	FFsusb2b5(Chromatic.FF, Chromatic.G, Chromatic.C),
	Gsusb2b5(Chromatic.G, Chromatic.GG, Chromatic.CC),
	GGsusb2b5(Chromatic.GG, Chromatic.A, Chromatic.D),
	Asusb2b5(Chromatic.A, Chromatic.AA, Chromatic.DD),
	AAsusb2b5(Chromatic.AA, Chromatic.B, Chromatic.E),
	Bsusb2b5(Chromatic.B, Chromatic.C, Chromatic.F);

	public static final ChromaticChordEnum[]	CHORDS_FIFTH	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_MAJOR	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_MINOR	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_AUGMENTED	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_DIMINISHED	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_SUS4	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_SUS2	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_7	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_7b5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_7a5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_7sus4	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_m7	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_m7b5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_m7a5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_6	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_6sus4	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_Maj7	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_mMaj7	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_6add9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_m6add9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_7b9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_m6	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_7a9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_m7b9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_7add11	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_7add13	= new ChromaticChordEnum[] {
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
	};


	public static final ChromaticChordEnum[]	CHORDS_9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_m9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_9b5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_9a5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_9sus4	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_Maj9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_mMaj9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_9add6	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_9a11	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_Maj9a11	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_11	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_m11	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_11b9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_11a9	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_Maj11	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_mMaj11	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_m13	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_13sus4	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_13b5	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_13a5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_13b9	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_13a9	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_13b5b9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_13b5a9	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_13a5b9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_13a5a9	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_Maj13	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_mMaj13	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_Maj13b5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_Maj13a5	= new ChromaticChordEnum[] {
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
	};
	public static final ChromaticChordEnum[]	CHORDS_Maj13b9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_Maj13a9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_Maj13b5b9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_Maj13b5a9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_Maj13a5b9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_Maj13a5a9	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_SUSa4	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_SUSb2	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[]	CHORDS_SUSb2b5	= new ChromaticChordEnum[] {
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
	};

	public static final ChromaticChordEnum[][]	UNUSUAL_CHORDS_GROUPS	= {
		CHORDS_SUSb2,
		CHORDS_SUSa4,
		CHORDS_SUSb2b5
	};
	public static final ChromaticChordEnum[]	UNUSUAL_CHORDS			= (ChromaticChordEnum[]) ArrayUtils
			.concat( UNUSUAL_CHORDS_GROUPS );

	public static final ChromaticChordEnum[][]	TRIAD_CHORDS_GROUP	= {
		CHORDS_MAJOR,
		CHORDS_MINOR,
		CHORDS_DIMINISHED,
		CHORDS_AUGMENTED,
		CHORDS_SUS4,
		CHORDS_SUS2
	};
	public static final ChromaticChordEnum[]	TRIAD_CHORDS		= (ChromaticChordEnum[]) ArrayUtils
			.concat( TRIAD_CHORDS_GROUP );

	public static final ChromaticChordEnum[][]	SEVENTH_CHORDS_GROUP	= {
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
	public static final ChromaticChordEnum[]	SEVENTH_CHORDS			= (ChromaticChordEnum[]) ArrayUtils
			.concat( SEVENTH_CHORDS_GROUP );

	public static final ChromaticChordEnum[][]	SIXTH_CHORDS_GROUP	= {
		CHORDS_6,
		CHORDS_m6,
		CHORDS_6sus4,
		CHORDS_6add9,
		CHORDS_m6add9
	};
	public static final ChromaticChordEnum[]	SIXTH_CHORDS		= (ChromaticChordEnum[]) ArrayUtils
			.concat( SIXTH_CHORDS_GROUP );

	public static final ChromaticChordEnum[][]	NINTH_CHORDS_GROUP	= {
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
	public static final ChromaticChordEnum[]	NINTH_CHORDS		= (ChromaticChordEnum[]) ArrayUtils
			.concat( NINTH_CHORDS_GROUP );

	public static final ChromaticChordEnum[][]	ELEVENTH_CHORDS_GROUP	= {
		CHORDS_11,
		CHORDS_m11,
		CHORDS_11b9,
		CHORDS_11a9,
		CHORDS_Maj11,
		CHORDS_mMaj11
	};
	public static final ChromaticChordEnum[]	ELEVENTH_CHORDS			= (ChromaticChordEnum[]) ArrayUtils
			.concat( ELEVENTH_CHORDS_GROUP );

	public static final ChromaticChordEnum[][]	THIRTEENTH_CHORDS_GROUP	= {
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
	public static final ChromaticChordEnum[]	THIRTEENTH_CHORDS		= (ChromaticChordEnum[]) ArrayUtils
			.concat( THIRTEENTH_CHORDS_GROUP );

	public static final ChromaticChordEnum[][]	PARTIAL_CHORDS_GROUP	= {
		CHORDS_FIFTH
	};
	public static final ChromaticChordEnum[]	PARTIAL_CHORDS			= (ChromaticChordEnum[]) ArrayUtils
			.concat( PARTIAL_CHORDS_GROUP );

	public static final ChromaticChordEnum[][]	COMMON_CHORDS_GROUP	= (ChromaticChordEnum[][]) ArrayUtils.concat(TRIAD_CHORDS_GROUP, SEVENTH_CHORDS_GROUP, SIXTH_CHORDS_GROUP, NINTH_CHORDS_GROUP, ELEVENTH_CHORDS_GROUP, THIRTEENTH_CHORDS_GROUP, PARTIAL_CHORDS_GROUP);
	public static final ChromaticChordEnum[]	COMMON_CHORDS		= (ChromaticChordEnum[]) ArrayUtils
			.concat( COMMON_CHORDS_GROUP );

	public static final HashMap<ArrayWrapperInteger, ArrayList<ChromaticChordEnum>> sameOrderChromatics = new HashMap();

	private ChromaticChordMeta initializeMeta() {
		ChromaticChordMeta m = new ChromaticChordMeta();
		// Parciales
		if ( this == ChromaticChordEnum.C5 || this == ChromaticChordEnum.CC5 || this ==	ChromaticChordEnum.D5 || this == ChromaticChordEnum.DD5 ||
				this == ChromaticChordEnum.E5 || this == ChromaticChordEnum.F5 || this == ChromaticChordEnum.FF5 || this == ChromaticChordEnum.G5 ||
				this == ChromaticChordEnum.GG5 || this == ChromaticChordEnum.A5 || this == ChromaticChordEnum.AA5 || this == ChromaticChordEnum.B5 ) {
			m.quality = Quality.INDETERMINATED;
			m.str = ChordNotation.POWER_CHORD;
		}
		// Triadas
		else if ( this == ChromaticChordEnum.C || this == ChromaticChordEnum.CC || this == ChromaticChordEnum.D || this == ChromaticChordEnum.DD || this == ChromaticChordEnum.E || this == ChromaticChordEnum.F || this == ChromaticChordEnum.FF || this == ChromaticChordEnum.G || this == ChromaticChordEnum.GG || this == ChromaticChordEnum.A || this == ChromaticChordEnum.AA || this == ChromaticChordEnum.B ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR;
		} else if ( this == ChromaticChordEnum.Cm || this == ChromaticChordEnum.CCm || this == ChromaticChordEnum.Dm || this == ChromaticChordEnum.DDm || this == ChromaticChordEnum.Em || this == ChromaticChordEnum.Fm || this == ChromaticChordEnum.FFm || this == ChromaticChordEnum.Gm || this == ChromaticChordEnum.GGm || this == ChromaticChordEnum.Am || this == ChromaticChordEnum.AAm || this == ChromaticChordEnum.Bm ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR;
		} else if ( this == ChromaticChordEnum.Cdim || this == ChromaticChordEnum.CCdim || this == ChromaticChordEnum.Ddim || this == ChromaticChordEnum.DDdim || this == ChromaticChordEnum.Edim || this == ChromaticChordEnum.Fdim || this == ChromaticChordEnum.FFdim || this == ChromaticChordEnum.Gdim || this == ChromaticChordEnum.GGdim || this == ChromaticChordEnum.Adim || this == ChromaticChordEnum.AAdim || this == ChromaticChordEnum.Bdim ) {
			m.quality = Quality.DIMINISHED;
			m.str = ChordNotation.DIMINISHED;
		} else if ( this == ChromaticChordEnum.Caug || this == ChromaticChordEnum.CCaug || this == ChromaticChordEnum.Daug || this == ChromaticChordEnum.DDaug || this == ChromaticChordEnum.Eaug || this == ChromaticChordEnum.Faug || this == ChromaticChordEnum.FFaug || this == ChromaticChordEnum.Gaug || this == ChromaticChordEnum.GGaug || this == ChromaticChordEnum.Aaug || this == ChromaticChordEnum.AAaug || this == ChromaticChordEnum.Baug ) {
			m.quality = Quality.AUGMENTED;
			m.str = ChordNotation.AUGMENTED;
		} else if ( this == ChromaticChordEnum.Csus4 || this == ChromaticChordEnum.CCsus4 || this == ChromaticChordEnum.Dsus4 || this == ChromaticChordEnum.DDsus4 || this == ChromaticChordEnum.Esus4 || this == ChromaticChordEnum.Fsus4 || this == ChromaticChordEnum.FFsus4 || this == ChromaticChordEnum.Gsus4 || this == ChromaticChordEnum.GGsus4 || this == ChromaticChordEnum.Asus4 || this == ChromaticChordEnum.AAsus4 || this == ChromaticChordEnum.Bsus4 ) {
			m.quality = Quality.INDETERMINATED;
			m.str = ChordNotation.SUS4;
		} else if ( this == ChromaticChordEnum.Csus2 || this == ChromaticChordEnum.CCsus2 || this == ChromaticChordEnum.Dsus2 || this == ChromaticChordEnum.DDsus2 || this == ChromaticChordEnum.Esus2 || this == ChromaticChordEnum.Fsus2 || this == ChromaticChordEnum.FFsus2 || this == ChromaticChordEnum.Gsus2 || this == ChromaticChordEnum.GGsus2 || this == ChromaticChordEnum.Asus2 || this == ChromaticChordEnum.AAsus2 || this == ChromaticChordEnum.Bsus2 ) {
			m.quality = Quality.INDETERMINATED;
			m.str = ChordNotation.SUS2;
		}
		// Séptima
		else if ( this == ChromaticChordEnum.C7 || this == ChromaticChordEnum.CC7 || this == ChromaticChordEnum.D7 || this == ChromaticChordEnum.DD7 || this == ChromaticChordEnum.E7 || this == ChromaticChordEnum.F7 || this == ChromaticChordEnum.FF7 || this == ChromaticChordEnum.G7 || this == ChromaticChordEnum.GG7 || this == ChromaticChordEnum.A7 || this == ChromaticChordEnum.AA7 || this == ChromaticChordEnum.B7 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SEVENTH;
		} else if ( this == ChromaticChordEnum.CMaj7 || this == ChromaticChordEnum.CCMaj7 || this == ChromaticChordEnum.DMaj7 || this == ChromaticChordEnum.DDMaj7 || this == ChromaticChordEnum.EMaj7 || this == ChromaticChordEnum.FMaj7 || this == ChromaticChordEnum.FFMaj7 || this == ChromaticChordEnum.GMaj7 || this == ChromaticChordEnum.GGMaj7 || this == ChromaticChordEnum.AMaj7 || this == ChromaticChordEnum.AAMaj7 || this == ChromaticChordEnum.BMaj7 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.SEVENTH;
		} else if ( this == ChromaticChordEnum.Cm7 || this == ChromaticChordEnum.CCm7 || this == ChromaticChordEnum.Dm7 || this == ChromaticChordEnum.DDm7 || this == ChromaticChordEnum.Em7 || this == ChromaticChordEnum.Fm7 || this == ChromaticChordEnum.FFm7 || this == ChromaticChordEnum.Gm7 || this == ChromaticChordEnum.GGm7 || this == ChromaticChordEnum.Am7 || this == ChromaticChordEnum.AAm7 || this == ChromaticChordEnum.Bm7 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.SEVENTH;
		} else if ( this == ChromaticChordEnum.C7b5 || this == ChromaticChordEnum.CC7b5 || this == ChromaticChordEnum.D7b5 || this == ChromaticChordEnum.DD7b5 || this == ChromaticChordEnum.E7b5 || this == ChromaticChordEnum.F7b5 || this == ChromaticChordEnum.FF7b5 || this == ChromaticChordEnum.G7b5 || this == ChromaticChordEnum.GG7b5 || this == ChromaticChordEnum.A7b5 || this == ChromaticChordEnum.AA7b5 || this == ChromaticChordEnum.B7b5 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SEVENTH + ChordNotation.b5;
		} else if ( this == ChromaticChordEnum.CmMaj7 || this == ChromaticChordEnum.CCmMaj7 || this == ChromaticChordEnum.DmMaj7 || this == ChromaticChordEnum.DDmMaj7 || this == ChromaticChordEnum.EmMaj7 || this == ChromaticChordEnum.FmMaj7 || this == ChromaticChordEnum.FFmMaj7 || this == ChromaticChordEnum.GmMaj7 || this == ChromaticChordEnum.GGmMaj7 || this == ChromaticChordEnum.AmMaj7 || this == ChromaticChordEnum.AAmMaj7 || this == ChromaticChordEnum.BmMaj7 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.SEVENTH;
		} else if ( this == ChromaticChordEnum.C7a5 || this == ChromaticChordEnum.CC7a5 || this == ChromaticChordEnum.D7a5 || this == ChromaticChordEnum.DD7a5 || this == ChromaticChordEnum.E7a5 || this == ChromaticChordEnum.F7a5 || this == ChromaticChordEnum.FF7a5 || this == ChromaticChordEnum.G7a5 || this == ChromaticChordEnum.GG7a5 || this == ChromaticChordEnum.A7a5 || this == ChromaticChordEnum.AA7a5 || this == ChromaticChordEnum.B7a5 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SEVENTH + ChordNotation.a5;
		} else if ( this == ChromaticChordEnum.Cm7a5 || this == ChromaticChordEnum.CCm7a5 || this == ChromaticChordEnum.Dm7a5 || this == ChromaticChordEnum.DDm7a5 || this == ChromaticChordEnum.Em7a5 || this == ChromaticChordEnum.Fm7a5 || this == ChromaticChordEnum.FFm7a5 || this == ChromaticChordEnum.Gm7a5 || this == ChromaticChordEnum.GGm7a5 || this == ChromaticChordEnum.Am7a5 || this == ChromaticChordEnum.AAm7a5 || this == ChromaticChordEnum.Bm7a5 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.a5;
		} else if ( this == ChromaticChordEnum.Cm7b5 || this == ChromaticChordEnum.CCm7b5 || this == ChromaticChordEnum.Dm7b5 || this == ChromaticChordEnum.DDm7b5 || this == ChromaticChordEnum.Em7b5 || this == ChromaticChordEnum.Fm7b5 || this == ChromaticChordEnum.FFm7b5 || this == ChromaticChordEnum.Gm7b5 || this == ChromaticChordEnum.GGm7b5 || this == ChromaticChordEnum.Am7b5 || this == ChromaticChordEnum.AAm7b5 || this == ChromaticChordEnum.Bm7b5 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b5;
		} else if ( this == ChromaticChordEnum.C7add11 || this == ChromaticChordEnum.CC7add11 || this == ChromaticChordEnum.D7add11 || this == ChromaticChordEnum.DD7add11 || this == ChromaticChordEnum.E7add11 || this == ChromaticChordEnum.F7add11 || this == ChromaticChordEnum.FF7add11 || this == ChromaticChordEnum.G7add11 || this == ChromaticChordEnum.GG7add11 || this == ChromaticChordEnum.A7add11 || this == ChromaticChordEnum.AA7add11 || this == ChromaticChordEnum.B7add11 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SEVENTH + ChordNotation.ADD_ELEVENTH;
		} else if ( this == ChromaticChordEnum.C7add13 || this == ChromaticChordEnum.CC7add13 || this == ChromaticChordEnum.D7add13 || this == ChromaticChordEnum.DD7add13 || this == ChromaticChordEnum.E7add13 || this == ChromaticChordEnum.F7add13 || this == ChromaticChordEnum.FF7add13 || this == ChromaticChordEnum.G7add13 || this == ChromaticChordEnum.GG7add13 || this == ChromaticChordEnum.A7add13 || this == ChromaticChordEnum.AA7add13 || this == ChromaticChordEnum.B7add13 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SEVENTH + ChordNotation.ADD_THIRTEEN;
		}
		// Unusual
		else if ( this == ChromaticChordEnum.Csusa4 || this == ChromaticChordEnum.CCsusa4 || this == ChromaticChordEnum.Dsusa4 || this == ChromaticChordEnum.DDsusa4 || this == ChromaticChordEnum.Esusa4 || this == ChromaticChordEnum.Fsusa4 || this == ChromaticChordEnum.FFsusa4 || this == ChromaticChordEnum.Gsusa4 || this == ChromaticChordEnum.GGsusa4 || this == ChromaticChordEnum.Asusa4 || this == ChromaticChordEnum.AAsusa4 || this == ChromaticChordEnum.Bsusa4 ) {
			m.quality = Quality.INDETERMINATED;
			m.str = ChordNotation.SUSa4;
		} else if ( this == ChromaticChordEnum.Csusb2 || this == ChromaticChordEnum.CCsusb2 || this == ChromaticChordEnum.Dsusb2 || this == ChromaticChordEnum.DDsusb2 || this == ChromaticChordEnum.Esusb2 || this == ChromaticChordEnum.Fsusb2 || this == ChromaticChordEnum.FFsusb2 || this == ChromaticChordEnum.Gsusb2 || this == ChromaticChordEnum.GGsusb2 || this == ChromaticChordEnum.Asusb2 || this == ChromaticChordEnum.AAsusb2 || this == ChromaticChordEnum.Bsusb2 ) {
			m.quality = Quality.INDETERMINATED;
			m.str = ChordNotation.SUSb2;
		} else if ( this == ChromaticChordEnum.Csusb2b5 || this == ChromaticChordEnum.CCsusb2b5 || this == ChromaticChordEnum.Dsusb2b5 || this == ChromaticChordEnum.DDsusb2b5 || this == ChromaticChordEnum.Esusb2b5 || this == ChromaticChordEnum.Fsusb2b5 || this == ChromaticChordEnum.FFsusb2b5 || this == ChromaticChordEnum.Gsusb2b5 || this == ChromaticChordEnum.GGsusb2b5 || this == ChromaticChordEnum.Asusb2b5 || this == ChromaticChordEnum.AAsusb2b5 || this == ChromaticChordEnum.Bsusb2b5 ) {
			m.quality = Quality.INDETERMINATED;
			m.str = ChordNotation.SUSb2b5;
		}
		// Novena
		else if ( this == ChromaticChordEnum.C7b9 || this == ChromaticChordEnum.CC7b9 || this == ChromaticChordEnum.D7b9 || this == ChromaticChordEnum.DD7b9 || this == ChromaticChordEnum.E7b9 || this == ChromaticChordEnum.F7b9 || this == ChromaticChordEnum.FF7b9 || this == ChromaticChordEnum.G7b9 || this == ChromaticChordEnum.GG7b9 || this == ChromaticChordEnum.A7b9 || this == ChromaticChordEnum.AA7b9 || this == ChromaticChordEnum.B7b9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SEVENTH + ChordNotation.b9;
		}
		else if ( this == ChromaticChordEnum.C7a9 || this == ChromaticChordEnum.CC7a9 || this == ChromaticChordEnum.D7a9 || this == ChromaticChordEnum.DD7a9 || this == ChromaticChordEnum.E7a9 || this == ChromaticChordEnum.F7a9 || this == ChromaticChordEnum.FF7a9 || this == ChromaticChordEnum.G7a9 || this == ChromaticChordEnum.GG7a9 || this == ChromaticChordEnum.A7a9 || this == ChromaticChordEnum.AA7a9 || this == ChromaticChordEnum.B7a9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SEVENTH + ChordNotation.a9;
		} else if ( this == ChromaticChordEnum.Cm7b9 || this == ChromaticChordEnum.CCm7b9 || this == ChromaticChordEnum.Dm7b9 || this == ChromaticChordEnum.DDm7b9 || this == ChromaticChordEnum.Em7b9 || this == ChromaticChordEnum.Fm7b9 || this == ChromaticChordEnum.FFm7b9 || this == ChromaticChordEnum.Gm7b9 || this == ChromaticChordEnum.GGm7b9 || this == ChromaticChordEnum.Am7b9 || this == ChromaticChordEnum.AAm7b9 || this == ChromaticChordEnum.Bm7b9 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b9;
		} else if ( this == ChromaticChordEnum.C9 || this == ChromaticChordEnum.CC9 || this == ChromaticChordEnum.D9 || this == ChromaticChordEnum.DD9 || this == ChromaticChordEnum.E9 || this == ChromaticChordEnum.F9 || this == ChromaticChordEnum.FF9 || this == ChromaticChordEnum.G9 || this == ChromaticChordEnum.GG9 || this == ChromaticChordEnum.A9 || this == ChromaticChordEnum.AA9 || this == ChromaticChordEnum.B9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.NINTH;
		}else if ( this == ChromaticChordEnum.Cm9 || this == ChromaticChordEnum.CCm9 || this == ChromaticChordEnum.Dm9 || this == ChromaticChordEnum.DDm9 || this == ChromaticChordEnum.Em9 || this == ChromaticChordEnum.Fm9 || this == ChromaticChordEnum.FFm9 || this == ChromaticChordEnum.Gm9 || this == ChromaticChordEnum.GGm9 || this == ChromaticChordEnum.Am9 || this == ChromaticChordEnum.AAm9 || this == ChromaticChordEnum.Bm9 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.NINTH;
		} else if ( this == ChromaticChordEnum.C9b5 || this == ChromaticChordEnum.CC9b5 || this == ChromaticChordEnum.D9b5 || this == ChromaticChordEnum.DD9b5 || this == ChromaticChordEnum.E9b5 || this == ChromaticChordEnum.F9b5 || this == ChromaticChordEnum.FF9b5 || this == ChromaticChordEnum.G9b5 || this == ChromaticChordEnum.GG9b5 || this == ChromaticChordEnum.A9b5 || this == ChromaticChordEnum.AA9b5 || this == ChromaticChordEnum.B9b5 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.NINTH + ChordNotation.b5;
		} else if ( this == ChromaticChordEnum.C9a5 || this == ChromaticChordEnum.CC9a5 || this == ChromaticChordEnum.D9a5 || this == ChromaticChordEnum.DD9a5 || this == ChromaticChordEnum.E9a5 || this == ChromaticChordEnum.F9a5 || this == ChromaticChordEnum.FF9a5 || this == ChromaticChordEnum.G9a5 || this == ChromaticChordEnum.GG9a5 || this == ChromaticChordEnum.A9a5 || this == ChromaticChordEnum.AA9a5 || this == ChromaticChordEnum.B9a5 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.NINTH + ChordNotation.a5;
		} else if ( this == ChromaticChordEnum.C9sus4 || this == ChromaticChordEnum.CC9sus4 || this == ChromaticChordEnum.D9sus4 || this == ChromaticChordEnum.DD9sus4 || this == ChromaticChordEnum.E9sus4 || this == ChromaticChordEnum.F9sus4 || this == ChromaticChordEnum.FF9sus4 || this == ChromaticChordEnum.G9sus4 || this == ChromaticChordEnum.GG9sus4 || this == ChromaticChordEnum.A9sus4 || this == ChromaticChordEnum.AA9sus4 || this == ChromaticChordEnum.B9sus4 ) {
			m.quality = Quality.INDETERMINATED;
			m.str = ChordNotation.NINTH + ChordNotation.SUS4;
		} else if ( this == ChromaticChordEnum.CMaj9 || this == ChromaticChordEnum.CCMaj9 || this == ChromaticChordEnum.DMaj9 || this == ChromaticChordEnum.DDMaj9 || this == ChromaticChordEnum.EMaj9 || this == ChromaticChordEnum.FMaj9 || this == ChromaticChordEnum.FFMaj9 || this == ChromaticChordEnum.GMaj9 || this == ChromaticChordEnum.GGMaj9 || this == ChromaticChordEnum.AMaj9 || this == ChromaticChordEnum.AAMaj9 || this == ChromaticChordEnum.BMaj9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.NINTH;
		} else if ( this == ChromaticChordEnum.C9add6 || this == ChromaticChordEnum.CC9add6 || this == ChromaticChordEnum.D9add6 || this == ChromaticChordEnum.DD9add6 || this == ChromaticChordEnum.E9add6 || this == ChromaticChordEnum.F9add6 || this == ChromaticChordEnum.FF9add6 || this == ChromaticChordEnum.G9add6 || this == ChromaticChordEnum.GG9add6 || this == ChromaticChordEnum.A9add6 || this == ChromaticChordEnum.AA9add6 || this == ChromaticChordEnum.B9add6 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.NINTH + ChordNotation.ADD_SIXTH;
		} else if ( this == ChromaticChordEnum.C9a11 || this == ChromaticChordEnum.CC9a11 || this == ChromaticChordEnum.D9a11 || this == ChromaticChordEnum.DD9a11 || this == ChromaticChordEnum.E9a11 || this == ChromaticChordEnum.F9a11 || this == ChromaticChordEnum.FF9a11 || this == ChromaticChordEnum.G9a11 || this == ChromaticChordEnum.GG9a11 || this == ChromaticChordEnum.A9a11 || this == ChromaticChordEnum.AA9a11 || this == ChromaticChordEnum.B9a11 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.NINTH + ChordNotation.a11;
		} else if ( this == ChromaticChordEnum.CMaj9a11 || this == ChromaticChordEnum.CCMaj9a11 || this == ChromaticChordEnum.DMaj9a11 || this == ChromaticChordEnum.DDMaj9a11 || this == ChromaticChordEnum.EMaj9a11 || this == ChromaticChordEnum.FMaj9a11 || this == ChromaticChordEnum.FFMaj9a11 || this == ChromaticChordEnum.GMaj9a11 || this == ChromaticChordEnum.GGMaj9a11 || this == ChromaticChordEnum.AMaj9a11 || this == ChromaticChordEnum.AAMaj9a11 || this == ChromaticChordEnum.BMaj9a11 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.NINTH + ChordNotation.a11;
		}
		// Sexta
		else if ( this == ChromaticChordEnum.C6 || this == ChromaticChordEnum.CC6 || this == ChromaticChordEnum.D6 || this == ChromaticChordEnum.DD6 || this == ChromaticChordEnum.E6 || this == ChromaticChordEnum.F6 || this == ChromaticChordEnum.FF6 || this == ChromaticChordEnum.G6 || this == ChromaticChordEnum.GG6 || this == ChromaticChordEnum.A6 || this == ChromaticChordEnum.AA6 || this == ChromaticChordEnum.B6 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SIXTH;
		} else if ( this == ChromaticChordEnum.Cm6 || this == ChromaticChordEnum.CCm6 || this == ChromaticChordEnum.Dm6 || this == ChromaticChordEnum.DDm6 || this == ChromaticChordEnum.Em6 || this == ChromaticChordEnum.Fm6 || this == ChromaticChordEnum.FFm6 || this == ChromaticChordEnum.Gm6 || this == ChromaticChordEnum.GGm6 || this == ChromaticChordEnum.Am6 || this == ChromaticChordEnum.AAm6 || this == ChromaticChordEnum.Bm6 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.SIXTH;
		} else if ( this == ChromaticChordEnum.C6sus4 || this == ChromaticChordEnum.CC6sus4 || this == ChromaticChordEnum.D6sus4 || this == ChromaticChordEnum.DD6sus4 || this == ChromaticChordEnum.E6sus4 || this == ChromaticChordEnum.F6sus4 || this == ChromaticChordEnum.FF6sus4 || this == ChromaticChordEnum.G6sus4 || this == ChromaticChordEnum.GG6sus4 || this == ChromaticChordEnum.A6sus4 || this == ChromaticChordEnum.AA6sus4 || this == ChromaticChordEnum.B6sus4 ) {
			m.quality = Quality.INDETERMINATED;
			m.str = ChordNotation.SIXTH + ChordNotation.SUS4;
		} else if ( this == ChromaticChordEnum.C6add9 || this == ChromaticChordEnum.CC6add9 || this == ChromaticChordEnum.D6add9 || this == ChromaticChordEnum.DD6add9 || this == ChromaticChordEnum.E6add9 || this == ChromaticChordEnum.F6add9 || this == ChromaticChordEnum.FF6add9 || this == ChromaticChordEnum.G6add9 || this == ChromaticChordEnum.GG6add9 || this == ChromaticChordEnum.A6add9 || this == ChromaticChordEnum.AA6add9 || this == ChromaticChordEnum.B6add9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.SIXTH + ChordNotation.ADD_NINTH;
		} else if ( this == ChromaticChordEnum.Cm6add9 || this == ChromaticChordEnum.CCm6add9 || this == ChromaticChordEnum.Dm6add9 || this == ChromaticChordEnum.DDm6add9 || this == ChromaticChordEnum.Em6add9 || this == ChromaticChordEnum.Fm6add9 || this == ChromaticChordEnum.FFm6add9 || this == ChromaticChordEnum.Gm6add9 || this == ChromaticChordEnum.GGm6add9 || this == ChromaticChordEnum.Am6add9 || this == ChromaticChordEnum.AAm6add9 || this == ChromaticChordEnum.Bm6add9 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.SIXTH + ChordNotation.ADD_NINTH;
		}
		// Onceava
		else if ( this == ChromaticChordEnum.C11 || this == ChromaticChordEnum.CC11 || this == ChromaticChordEnum.D11 || this == ChromaticChordEnum.DD11 || this == ChromaticChordEnum.E11 || this == ChromaticChordEnum.F11 || this == ChromaticChordEnum.FF11 || this == ChromaticChordEnum.G11 || this == ChromaticChordEnum.GG11 || this == ChromaticChordEnum.A11 || this == ChromaticChordEnum.AA11 || this == ChromaticChordEnum.B11 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.ELEVENTH;
		} else if ( this == ChromaticChordEnum.Cm11 || this == ChromaticChordEnum.CCm11 || this == ChromaticChordEnum.Dm11 || this == ChromaticChordEnum.DDm11 || this == ChromaticChordEnum.Em11 || this == ChromaticChordEnum.Fm11 || this == ChromaticChordEnum.FFm11 || this == ChromaticChordEnum.Gm11 || this == ChromaticChordEnum.GGm11 || this == ChromaticChordEnum.Am11 || this == ChromaticChordEnum.AAm11 || this == ChromaticChordEnum.Bm11 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.ELEVENTH;
		} else if ( this == ChromaticChordEnum.C11b9 || this == ChromaticChordEnum.CC11b9 || this == ChromaticChordEnum.D11b9 || this == ChromaticChordEnum.DD11b9 || this == ChromaticChordEnum.E11b9 || this == ChromaticChordEnum.F11b9 || this == ChromaticChordEnum.FF11b9 || this == ChromaticChordEnum.G11b9 || this == ChromaticChordEnum.GG11b9 || this == ChromaticChordEnum.A11b9 || this == ChromaticChordEnum.AA11b9 || this == ChromaticChordEnum.B11b9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.ELEVENTH + ChordNotation.b9;
		} else if ( this == ChromaticChordEnum.C11a9 || this == ChromaticChordEnum.CC11a9 || this == ChromaticChordEnum.D11a9 || this == ChromaticChordEnum.DD11a9 || this == ChromaticChordEnum.E11a9 || this == ChromaticChordEnum.F11a9 || this == ChromaticChordEnum.FF11a9 || this == ChromaticChordEnum.G11a9 || this == ChromaticChordEnum.GG11a9 || this == ChromaticChordEnum.A11a9 || this == ChromaticChordEnum.AA11a9 || this == ChromaticChordEnum.B11a9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.ELEVENTH + ChordNotation.a9;
		} else if ( this == ChromaticChordEnum.CMaj11 || this == ChromaticChordEnum.CCMaj11 || this == ChromaticChordEnum.DMaj11 || this == ChromaticChordEnum.DDMaj11 || this == ChromaticChordEnum.EMaj11 || this == ChromaticChordEnum.FMaj11 || this == ChromaticChordEnum.FFMaj11 || this == ChromaticChordEnum.GMaj11 || this == ChromaticChordEnum.GGMaj11 || this == ChromaticChordEnum.AMaj11 || this == ChromaticChordEnum.AAMaj11 || this == ChromaticChordEnum.BMaj11 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.ELEVENTH;
		} else if ( this == ChromaticChordEnum.CmMaj11 || this == ChromaticChordEnum.CCmMaj11 || this == ChromaticChordEnum.DmMaj11 || this == ChromaticChordEnum.DDmMaj11 || this == ChromaticChordEnum.EmMaj11 || this == ChromaticChordEnum.FmMaj11 || this == ChromaticChordEnum.FFmMaj11 || this == ChromaticChordEnum.GmMaj11 || this == ChromaticChordEnum.GGmMaj11 || this == ChromaticChordEnum.AmMaj11 || this == ChromaticChordEnum.AAmMaj11 || this == ChromaticChordEnum.BmMaj11 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.ELEVENTH;
		}
		// Treceava
		else if ( this == ChromaticChordEnum.Cm13 || this == ChromaticChordEnum.CCm13 || this == ChromaticChordEnum.Dm13 || this == ChromaticChordEnum.DDm13 || this == ChromaticChordEnum.Em13 || this == ChromaticChordEnum.Fm13 || this == ChromaticChordEnum.FFm13 || this == ChromaticChordEnum.Gm13 || this == ChromaticChordEnum.GGm13 || this == ChromaticChordEnum.Am13 || this == ChromaticChordEnum.AAm13 || this == ChromaticChordEnum.Bm13 ) {
			m.quality = Quality.MINOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.THIRTEEN;
		} else if ( this == ChromaticChordEnum.C13sus4 || this == ChromaticChordEnum.CC13sus4 || this == ChromaticChordEnum.D13sus4 || this == ChromaticChordEnum.DD13sus4 || this == ChromaticChordEnum.E13sus4 || this == ChromaticChordEnum.F13sus4 || this == ChromaticChordEnum.FF13sus4 || this == ChromaticChordEnum.G13sus4 || this == ChromaticChordEnum.GG13sus4 || this == ChromaticChordEnum.A13sus4 || this == ChromaticChordEnum.AA13sus4 || this == ChromaticChordEnum.B13sus4 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.SUS4;
		} else if ( this == ChromaticChordEnum.C13b5 || this == ChromaticChordEnum.CC13b5 || this == ChromaticChordEnum.D13b5 || this == ChromaticChordEnum.DD13b5 || this == ChromaticChordEnum.E13b5 || this == ChromaticChordEnum.F13b5 || this == ChromaticChordEnum.FF13b5 || this == ChromaticChordEnum.G13b5 || this == ChromaticChordEnum.GG13b5 || this == ChromaticChordEnum.A13b5 || this == ChromaticChordEnum.AA13b5 || this == ChromaticChordEnum.B13b5 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.b5;
		} else if ( this == ChromaticChordEnum.C13a5 || this == ChromaticChordEnum.CC13a5 || this == ChromaticChordEnum.D13a5 || this == ChromaticChordEnum.DD13a5 || this == ChromaticChordEnum.E13a5 || this == ChromaticChordEnum.F13a5 || this == ChromaticChordEnum.FF13a5 || this == ChromaticChordEnum.G13a5 || this == ChromaticChordEnum.GG13a5 || this == ChromaticChordEnum.A13a5 || this == ChromaticChordEnum.AA13a5 || this == ChromaticChordEnum.B13a5 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.a5;
		} else if ( this == ChromaticChordEnum.C13b9 || this == ChromaticChordEnum.CC13b9 || this == ChromaticChordEnum.D13b9 || this == ChromaticChordEnum.DD13b9 || this == ChromaticChordEnum.E13b9 || this == ChromaticChordEnum.F13b9 || this == ChromaticChordEnum.FF13b9 || this == ChromaticChordEnum.G13b9 || this == ChromaticChordEnum.GG13b9 || this == ChromaticChordEnum.A13b9 || this == ChromaticChordEnum.AA13b9 || this == ChromaticChordEnum.B13b9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.b9;
		} else if ( this == ChromaticChordEnum.C13a9 || this == ChromaticChordEnum.CC13a9 || this == ChromaticChordEnum.D13a9 || this == ChromaticChordEnum.DD13a9 || this == ChromaticChordEnum.E13a9 || this == ChromaticChordEnum.F13a9 || this == ChromaticChordEnum.FF13a9 || this == ChromaticChordEnum.G13a9 || this == ChromaticChordEnum.GG13a9 || this == ChromaticChordEnum.A13a9 || this == ChromaticChordEnum.AA13a9 || this == ChromaticChordEnum.B13a9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.a9;
		} else if ( this == ChromaticChordEnum.C13b5b9 || this == ChromaticChordEnum.CC13b5b9 || this == ChromaticChordEnum.D13b5b9 || this == ChromaticChordEnum.DD13b5b9 || this == ChromaticChordEnum.E13b5b9 || this == ChromaticChordEnum.F13b5b9 || this == ChromaticChordEnum.FF13b5b9 || this == ChromaticChordEnum.G13b5b9 || this == ChromaticChordEnum.GG13b5b9 || this == ChromaticChordEnum.A13b5b9 || this == ChromaticChordEnum.AA13b5b9 || this == ChromaticChordEnum.B13b5b9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9;
		} else if ( this == ChromaticChordEnum.C13b5a9 || this == ChromaticChordEnum.CC13b5a9 || this == ChromaticChordEnum.D13b5a9 || this == ChromaticChordEnum.DD13b5a9 || this == ChromaticChordEnum.E13b5a9 || this == ChromaticChordEnum.F13b5a9 || this == ChromaticChordEnum.FF13b5a9 || this == ChromaticChordEnum.G13b5a9 || this == ChromaticChordEnum.GG13b5a9 || this == ChromaticChordEnum.A13b5a9 || this == ChromaticChordEnum.AA13b5a9 || this == ChromaticChordEnum.B13b5a9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9;
		} else if ( this == ChromaticChordEnum.C13a5b9 || this == ChromaticChordEnum.CC13a5b9 || this == ChromaticChordEnum.D13a5b9 || this == ChromaticChordEnum.DD13a5b9 || this == ChromaticChordEnum.E13a5b9 || this == ChromaticChordEnum.F13a5b9 || this == ChromaticChordEnum.FF13a5b9 || this == ChromaticChordEnum.G13a5b9 || this == ChromaticChordEnum.GG13a5b9 || this == ChromaticChordEnum.A13a5b9 || this == ChromaticChordEnum.AA13a5b9 || this == ChromaticChordEnum.B13a5b9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9;
		} else if ( this == ChromaticChordEnum.C13a5a9 || this == ChromaticChordEnum.CC13a5a9 || this == ChromaticChordEnum.D13a5a9 || this == ChromaticChordEnum.DD13a5a9 || this == ChromaticChordEnum.E13a5a9 || this == ChromaticChordEnum.F13a5a9 || this == ChromaticChordEnum.FF13a5a9 || this == ChromaticChordEnum.G13a5a9 || this == ChromaticChordEnum.GG13a5a9 || this == ChromaticChordEnum.A13a5a9 || this == ChromaticChordEnum.AA13a5a9 || this == ChromaticChordEnum.B13a5a9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9;
		} else if ( this == ChromaticChordEnum.CMaj13 || this == ChromaticChordEnum.CCMaj13 || this == ChromaticChordEnum.DMaj13 || this == ChromaticChordEnum.DDMaj13 || this == ChromaticChordEnum.EMaj13 || this == ChromaticChordEnum.FMaj13 || this == ChromaticChordEnum.FFMaj13 || this == ChromaticChordEnum.GMaj13 || this == ChromaticChordEnum.GGMaj13 || this == ChromaticChordEnum.AMaj13 || this == ChromaticChordEnum.AAMaj13 || this == ChromaticChordEnum.BMaj13 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN;
		} else if ( this == ChromaticChordEnum.CmMaj13 || this == ChromaticChordEnum.CCmMaj13 || this == ChromaticChordEnum.DmMaj13 || this == ChromaticChordEnum.DDmMaj13 || this == ChromaticChordEnum.EmMaj13 || this == ChromaticChordEnum.FmMaj13 || this == ChromaticChordEnum.FFmMaj13 || this == ChromaticChordEnum.GmMaj13 || this == ChromaticChordEnum.GGmMaj13 || this == ChromaticChordEnum.AmMaj13 || this == ChromaticChordEnum.AAmMaj13 || this == ChromaticChordEnum.BmMaj13 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.THIRTEEN;
		} else if ( this == ChromaticChordEnum.CMaj13b5 || this == ChromaticChordEnum.CCMaj13b5 || this == ChromaticChordEnum.DMaj13b5 || this == ChromaticChordEnum.DDMaj13b5 || this == ChromaticChordEnum.EMaj13b5 || this == ChromaticChordEnum.FMaj13b5 || this == ChromaticChordEnum.FFMaj13b5 || this == ChromaticChordEnum.GMaj13b5 || this == ChromaticChordEnum.GGMaj13b5 || this == ChromaticChordEnum.AMaj13b5 || this == ChromaticChordEnum.AAMaj13b5 || this == ChromaticChordEnum.BMaj13b5 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5;
		} else if ( this == ChromaticChordEnum.CMaj13a5 || this == ChromaticChordEnum.CCMaj13a5 || this == ChromaticChordEnum.DMaj13a5 || this == ChromaticChordEnum.DDMaj13a5 || this == ChromaticChordEnum.EMaj13a5 || this == ChromaticChordEnum.FMaj13a5 || this == ChromaticChordEnum.FFMaj13a5 || this == ChromaticChordEnum.GMaj13a5 || this == ChromaticChordEnum.GGMaj13a5 || this == ChromaticChordEnum.AMaj13a5 || this == ChromaticChordEnum.AAMaj13a5 || this == ChromaticChordEnum.BMaj13a5 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5;
		} else if ( this == ChromaticChordEnum.CMaj13b9 || this == ChromaticChordEnum.CCMaj13b9 || this == ChromaticChordEnum.DMaj13b9 || this == ChromaticChordEnum.DDMaj13b9 || this == ChromaticChordEnum.EMaj13b9 || this == ChromaticChordEnum.FMaj13b9 || this == ChromaticChordEnum.FFMaj13b9 || this == ChromaticChordEnum.GMaj13b9 || this == ChromaticChordEnum.GGMaj13b9 || this == ChromaticChordEnum.AMaj13b9 || this == ChromaticChordEnum.AAMaj13b9 || this == ChromaticChordEnum.BMaj13b9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b9;
		} else if ( this == ChromaticChordEnum.CMaj13a9 || this == ChromaticChordEnum.CCMaj13a9 || this == ChromaticChordEnum.DMaj13a9 || this == ChromaticChordEnum.DDMaj13a9 || this == ChromaticChordEnum.EMaj13a9 || this == ChromaticChordEnum.FMaj13a9 || this == ChromaticChordEnum.FFMaj13a9 || this == ChromaticChordEnum.GMaj13a9 || this == ChromaticChordEnum.GGMaj13a9 || this == ChromaticChordEnum.AMaj13a9 || this == ChromaticChordEnum.AAMaj13a9 || this == ChromaticChordEnum.BMaj13a9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a9;
		} else if ( this == ChromaticChordEnum.CMaj13b5b9 || this == ChromaticChordEnum.CCMaj13b5b9 || this == ChromaticChordEnum.DMaj13b5b9 || this == ChromaticChordEnum.DDMaj13b5b9 || this == ChromaticChordEnum.EMaj13b5b9 || this == ChromaticChordEnum.FMaj13b5b9 || this == ChromaticChordEnum.FFMaj13b5b9 || this == ChromaticChordEnum.GMaj13b5b9 || this == ChromaticChordEnum.GGMaj13b5b9 || this == ChromaticChordEnum.AMaj13b5b9 || this == ChromaticChordEnum.AAMaj13b5b9 || this == ChromaticChordEnum.BMaj13b5b9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5
					+ ChordNotation.b9;
		} else if ( this == ChromaticChordEnum.CMaj13b5a9 || this == ChromaticChordEnum.CCMaj13b5a9 || this == ChromaticChordEnum.DMaj13b5a9 || this == ChromaticChordEnum.DDMaj13b5a9 || this == ChromaticChordEnum.EMaj13b5a9 || this == ChromaticChordEnum.FMaj13b5a9 || this == ChromaticChordEnum.FFMaj13b5a9 || this == ChromaticChordEnum.GMaj13b5a9 || this == ChromaticChordEnum.GGMaj13b5a9 || this == ChromaticChordEnum.AMaj13b5a9 || this == ChromaticChordEnum.AAMaj13b5a9 || this == ChromaticChordEnum.BMaj13b5a9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5
					+ ChordNotation.a9;
		} else if ( this == ChromaticChordEnum.CMaj13a5b9 || this == ChromaticChordEnum.CCMaj13a5b9 || this == ChromaticChordEnum.DMaj13a5b9 || this == ChromaticChordEnum.DDMaj13a5b9 || this == ChromaticChordEnum.EMaj13a5b9 || this == ChromaticChordEnum.FMaj13a5b9 || this == ChromaticChordEnum.FFMaj13a5b9 || this == ChromaticChordEnum.GMaj13a5b9 || this == ChromaticChordEnum.GGMaj13a5b9 || this == ChromaticChordEnum.AMaj13a5b9 || this == ChromaticChordEnum.AAMaj13a5b9 || this == ChromaticChordEnum.BMaj13a5b9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5
					+ ChordNotation.b9;
		} else if ( this == ChromaticChordEnum.CMaj13a5a9 || this == ChromaticChordEnum.CCMaj13a5a9 || this == ChromaticChordEnum.DMaj13a5a9 || this == ChromaticChordEnum.DDMaj13a5a9 || this == ChromaticChordEnum.EMaj13a5a9 || this == ChromaticChordEnum.FMaj13a5a9 || this == ChromaticChordEnum.FFMaj13a5a9 || this == ChromaticChordEnum.GMaj13a5a9 || this == ChromaticChordEnum.GGMaj13a5a9 || this == ChromaticChordEnum.AMaj13a5a9 || this == ChromaticChordEnum.AAMaj13a5a9 || this == ChromaticChordEnum.BMaj13a5a9 ) {
			m.quality = Quality.MAJOR;
			m.str = ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5
					+ ChordNotation.a9;
		}

		return m;
	}

	/** Variables */
	private final Chromatic[] notes;
	private final ChromaticChordMeta meta;

	private ChromaticChordEnum(Chromatic... cs) {
		assert cs != null;
		notes = cs;
		meta = initializeMeta();
	}

	public CustomChromaticChord over(Chromatic c) throws ImpossibleChord {
		CustomChromaticChord dup = new CustomChromaticChord(this);
		for(int i = 0; i < size(); i++) {
			if ( get(0).val() == c.val() )
				return dup;
			if (i < size()-1)
				dup.inv();
		}

		throw new ImpossibleChord();
	}

	@Override
	public void clear() {
		throw new RuntimeException();
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean remove(Object arg0) {
		throw new RuntimeException();
	}

	@Override
	public Chromatic remove(int arg0) {
		throw new RuntimeException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new RuntimeException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new RuntimeException();
	}

	@Override
	public Chromatic set(int index, Chromatic element) {
		throw new RuntimeException();
	}

	@Override
	public int size() {
		return notes.length;
	}

	@Override
	public CustomChromaticChord inv(int n) {
		CustomChromaticChord c = new CustomChromaticChord(this);
		return c.inv( n );
	}

	@Override
	public Chromatic get(int index) {
		return notes[index];
	}

	@Override
	public Chromatic getRoot() {
		return notes[getRootPos()];
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

	public static PitchChromaticChord of(PitchChromaticableSingle... chord) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static PitchChromaticChord of(PitchChromaticableChord chord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomChromaticChord newArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String notesToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showNotes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeHigherDuplicates() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(Chromatic e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, Chromatic element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends Chromatic> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Chromatic> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Chromatic> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Chromatic> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Chromatic> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chromatic> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Diatonic extends PitchDiatonic<Diatonic, ?>> Diatonic toDiatonicChordMidi(Tonality ton)
			throws TonalityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getPitchMean() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean updateWhatIsItIfNeeded() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean resetRoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setRoot(int n) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomChromaticChord inv() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Boolean updateWhatIsIt(BiFunction<ArrayList<CustomChromaticChord>, PitchChromaticableChord<?, ?>, CustomChromaticChord> fSelectChord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChromaticChordEnum getChromatic() {
		return this;
	}
}
