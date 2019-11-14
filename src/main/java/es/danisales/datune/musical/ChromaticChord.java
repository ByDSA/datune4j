package es.danisales.datune.musical;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.utils.ListUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

public final class ChromaticChord extends NormalChordCommon<Chromatic> implements ChordCommon<Chromatic> {
    // Quintas
    public static final ChromaticChord C5 = new ChromaticChord(ChromaticChordEnum.C5);
    public static final ChromaticChord CC5(ChromaticChordMeta.POWER_CHORD, Chromatic.CC, Chromatic.GG),
    public static final ChromaticChord D5(ChromaticChordMeta.POWER_CHORD, Chromatic.D, Chromatic.A),
    public static final ChromaticChord DD5(ChromaticChordMeta.POWER_CHORD, Chromatic.DD, Chromatic.AA),
    public static final ChromaticChord E5(ChromaticChordMeta.POWER_CHORD, Chromatic.E, Chromatic.B),
    public static final ChromaticChord F5(ChromaticChordMeta.POWER_CHORD, Chromatic.F, Chromatic.C),
    public static final ChromaticChord FF5(ChromaticChordMeta.POWER_CHORD, Chromatic.FF, Chromatic.CC),
    public static final ChromaticChord G5(ChromaticChordMeta.POWER_CHORD, Chromatic.G, Chromatic.D),
    public static final ChromaticChord GG5(ChromaticChordMeta.POWER_CHORD, Chromatic.GG, Chromatic.DD),
    public static final ChromaticChord A5(ChromaticChordMeta.POWER_CHORD, Chromatic.A, Chromatic.E),
    public static final ChromaticChord AA5(ChromaticChordMeta.POWER_CHORD, Chromatic.AA, Chromatic.F),
    public static final ChromaticChord B5(ChromaticChordMeta.POWER_CHORD, Chromatic.B, Chromatic.FF),

    // Mayores
    public static final ChromaticChord C(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.C, Chromatic.E, Chromatic.G),
    public static final ChromaticChord CC(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.CC, Chromatic.F, Chromatic.GG),
    public static final ChromaticChord D(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.D, Chromatic.FF, Chromatic.A),
    public static final ChromaticChord DD(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.DD, Chromatic.G, Chromatic.AA),
    public static final ChromaticChord E(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.E, Chromatic.GG, Chromatic.B),
    public static final ChromaticChord F(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.F, Chromatic.A, Chromatic.C),
    public static final ChromaticChord FF(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.FF, Chromatic.AA, Chromatic.CC),
    public static final ChromaticChord G(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.G, Chromatic.B, Chromatic.D),
    public static final ChromaticChord GG(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.GG, Chromatic.C, Chromatic.DD),
    public static final ChromaticChord A(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.A, Chromatic.CC, Chromatic.E),
    public static final ChromaticChord AA(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.AA, Chromatic.D, Chromatic.F),
    public static final ChromaticChord B(ChromaticChordMeta.TRIAD_MAJOR, Chromatic.B, Chromatic.DD, Chromatic.FF),

    // Menores
    public static final ChromaticChord Cm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.C, Chromatic.DD, Chromatic.G),
    public static final ChromaticChord CCm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.CC, Chromatic.E, Chromatic.GG),
    public static final ChromaticChord Dm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.D, Chromatic.F, Chromatic.A),
    public static final ChromaticChord DDm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.DD, Chromatic.FF, Chromatic.AA),
    public static final ChromaticChord Em(ChromaticChordMeta.TRIAD_MINOR, Chromatic.E, Chromatic.G, Chromatic.B),
    public static final ChromaticChord Fm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.F, Chromatic.GG, Chromatic.C),
    public static final ChromaticChord FFm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.FF, Chromatic.A, Chromatic.CC),
    public static final ChromaticChord Gm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.G, Chromatic.AA, Chromatic.D),
    public static final ChromaticChord GGm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.GG, Chromatic.B, Chromatic.DD),
    public static final ChromaticChord Am(ChromaticChordMeta.TRIAD_MINOR, Chromatic.A, Chromatic.C, Chromatic.E),
    public static final ChromaticChord AAm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.AA, Chromatic.CC, Chromatic.F),
    public static final ChromaticChord Bm(ChromaticChordMeta.TRIAD_MINOR, Chromatic.B, Chromatic.D, Chromatic.FF),

    // Aumentados
    public static final ChromaticChord Caug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.C, Chromatic.E, Chromatic.GG),
    public static final ChromaticChord CCaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.CC, Chromatic.F, Chromatic.A),
    public static final ChromaticChord Daug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.D, Chromatic.FF, Chromatic.AA),
    public static final ChromaticChord DDaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.DD, Chromatic.G, Chromatic.B),
    public static final ChromaticChord Eaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.E, Chromatic.GG, Chromatic.C),
    public static final ChromaticChord Faug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.F, Chromatic.A, Chromatic.CC),
    public static final ChromaticChord FFaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.FF, Chromatic.AA, Chromatic.D),
    public static final ChromaticChord Gaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.G, Chromatic.B, Chromatic.DD),
    public static final ChromaticChord GGaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.GG, Chromatic.C, Chromatic.E),
    public static final ChromaticChord Aaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.A, Chromatic.CC, Chromatic.F),
    public static final ChromaticChord AAaug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.AA, Chromatic.D, Chromatic.FF),
    public static final ChromaticChord Baug(ChromaticChordMeta.TRIAD_AUGMENTED, Chromatic.B, Chromatic.DD, Chromatic.G),

    // Diminuidos
    public static final ChromaticChord Cdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.C, Chromatic.DD, Chromatic.FF),
    public static final ChromaticChord CCdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.CC, Chromatic.E, Chromatic.G),
    public static final ChromaticChord Ddim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.D, Chromatic.F, Chromatic.GG),
    public static final ChromaticChord DDdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.DD, Chromatic.FF, Chromatic.A),
    public static final ChromaticChord Edim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.E, Chromatic.G, Chromatic.AA),
    public static final ChromaticChord Fdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.F, Chromatic.GG, Chromatic.B),
    public static final ChromaticChord FFdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.FF, Chromatic.A, Chromatic.C),
    public static final ChromaticChord Gdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.G, Chromatic.AA, Chromatic.CC),
    public static final ChromaticChord GGdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.GG, Chromatic.B, Chromatic.D),
    public static final ChromaticChord Adim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.A, Chromatic.C, Chromatic.DD),
    public static final ChromaticChord AAdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.AA, Chromatic.CC, Chromatic.E),
    public static final ChromaticChord Bdim(ChromaticChordMeta.TRIAD_DIMINISHED, Chromatic.B, Chromatic.D, Chromatic.F),

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




    public static final Set<ChromaticChord> CHORDS_FIFTH = Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_MAJOR	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_MINOR	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_AUGMENTED	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_DIMINISHED	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_SUS4	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_SUS2	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_7	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_7b5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_7a5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_7sus4	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_m7	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_m7b5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_m7a5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_6	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_6sus4	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_Maj7	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_mMaj7	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_6add9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_m6add9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_7b9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_m6	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_7a9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_m7b9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_7add11	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_7add13	= Set.of(
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
    );


    public static final Set<ChromaticChord>	CHORDS_9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_m9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_9b5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_9a5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_9sus4	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_Maj9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_mMaj9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_9add6	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_9a11	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_Maj9a11	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_11	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_m11	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_11b9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_11a9	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_Maj11	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_mMaj11	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_m13	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_13sus4	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_13b5	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_13a5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_13b9	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_13a9	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_13b5b9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_13b5a9	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_13a5b9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_13a5a9	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_Maj13	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_mMaj13	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_Maj13b5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_Maj13a5	= Set.of(
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
    );
    public static final Set<ChromaticChord>	CHORDS_Maj13b9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_Maj13a9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_Maj13b5b9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_Maj13b5a9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_Maj13a5b9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_Maj13a5a9	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_SUSa4	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_SUSb2	= Set.of(
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
    );

    public static final Set<ChromaticChord>	CHORDS_SUSb2b5	= Set.of(
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
    );

    public static final Set<ChromaticChord>	UNUSUAL_CHORDS			= ListUtils.concatUnmodificable(
            CHORDS_SUSb2,
            CHORDS_SUSa4,
            CHORDS_SUSb2b5
    );

    public static final Set<ChromaticChord>	TRIAD_CHORDS		= ListUtils.concatUnmodificable(
            CHORDS_MAJOR,
            CHORDS_MINOR,
            CHORDS_DIMINISHED,
            CHORDS_AUGMENTED,
            CHORDS_SUS4,
            CHORDS_SUS2
    );

    public static final Set<ChromaticChord>	SEVENTH_CHORDS			= ListUtils.concatUnmodificable(
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

    public static final Set<ChromaticChord>	SIXTH_CHORDS	= ListUtils.concatUnmodificable(
            CHORDS_6,
            CHORDS_m6,
            CHORDS_6sus4,
            CHORDS_6add9,
            CHORDS_m6add9
    );

    public static final Set<ChromaticChord>	NINTH_CHORDS		= ListUtils.concatUnmodificable(
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

    public static final Set<ChromaticChord>	ELEVENTH_CHORDS			= ListUtils.concatUnmodificable(
            CHORDS_11,
            CHORDS_m11,
            CHORDS_11b9,
            CHORDS_11a9,
            CHORDS_Maj11,
            CHORDS_mMaj11
    );

    public static final Set<ChromaticChord>	THIRTEENTH_CHORDS		= ListUtils.concatUnmodificable(
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

    public static final Set<ChromaticChord>	PARTIAL_CHORDS			= ListUtils.concatUnmodificable(
            CHORDS_FIFTH
    );

    public static final Set<ChromaticChord>	COMMON_CHORDS	= ListUtils.concatUnmodificable(TRIAD_CHORDS, SEVENTH_CHORDS, SIXTH_CHORDS, NINTH_CHORDS, ELEVENTH_CHORDS, THIRTEENTH_CHORDS, PARTIAL_CHORDS);

    public static @NonNull ChromaticChord from(@NonNull Iterable<? extends PitchChromaticSingle> chromaticChord) {
        ChromaticChord ret = new ChromaticChord();
        ret.innerChord = ChromaticChordAdapter.from(chromaticChord);
        return ret;
    }

    public static @NonNull ChromaticChord from(@NonNull ChromaticFunction f) {
        ChromaticChord ret = new ChromaticChord();
        ret.innerChord = ChromaticChordAdapter.from(f);
        return ret;
    }

    private ChromaticChord() {
        super();
    }

    @Override
    protected final void turnIntoEnumIfPossible() {
        ChromaticChordEnum chromaticChordEnum = ChromaticChordEnum.from(innerChord);
        if (chromaticChordEnum != null)
            innerChord = chromaticChordEnum;
    }

    @Override
    protected final void turnInnerIntoCustom() {
        innerChord = ChromaticChordCustom.from(innerChord);
    }

    @Override
    protected final boolean isEnum() {
        return innerChord instanceof ChromaticChordEnum;
    }

    @Override
    protected final boolean isCustom() {
        return innerChord instanceof ChromaticChordCustom;
    }

    @Override
    protected final ChordMutableInterface<Chromatic> castCustom(ChordCommon<Chromatic> chord) {
        return (ChromaticChordCustom)innerChord;
    }

    @Override
    protected final ChromaticChord create() {
        return new ChromaticChord();
    }

    @Override
    protected final ChordCommon<Chromatic> createInnerFrom(ChordCommon<Chromatic> chord) {
        return ChromaticChordAdapter.from(chord);
    }

    private ChromaticChord(ChromaticChordInterface chromaticChordInterface) {
        super(chromaticChordInterface);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final List<ChromaticChord> getAllInversions() {
        return (List<ChromaticChord>)super.getAllInversions();
    }

    @Override
    public final ChromaticChord duplicate() {
        return (ChromaticChord)super.duplicate();
    }

    @Override
    public Boolean updateWhatIsIt(BiFunction<List<ChromaticChordCustom>, ChordCommon<?>, ChromaticChordCustom> fSelectChord) {
        return null;
    }

    @Override
    public Boolean updateWhatIsItIfNeeded() {
        return null;
    }


	/*
    @Override
    public boolean isSus4() {
        return this.equalsEnharmonicInvArray( ChromaticChordEnum.CHORDS_SUS4 )
                || this.equalsEnharmonicInvArray( ChromaticChordEnum.CHORDS_SUSa4 );
    }

    @Override
    public boolean isSus2() {
        return this.equalsEnharmonicInvArray( ChromaticChordEnum.CHORDS_SUS2 ) || this.equalsEnharmonicInvArray(
            ChromaticChordEnum.CHORDS_SUSb2
                ) || this.equalsEnharmonicInvArray( ChromaticChordEnum.CHORDS_SUSb2b5 );
    }
     */
}
