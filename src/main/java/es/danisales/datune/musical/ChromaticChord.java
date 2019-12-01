package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.utils.ListUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("WeakerAccess")
public final class ChromaticChord extends ChordProxy<ChromaticChordInterface, Chromatic, IntervalChromatic>
        implements ChordCommon<Chromatic>, Iterable<Chromatic>, PitchChromaticChord<Chromatic> {
    // Quintas
    public static final ChromaticChord C5 = new ChromaticChord(ChromaticChordImmutable.C5);
    public static final ChromaticChord CC5 = new ChromaticChord(ChromaticChordImmutable.CC5);
    public static final ChromaticChord D5 = new ChromaticChord(ChromaticChordImmutable.D5);
    public static final ChromaticChord DD5 = new ChromaticChord(ChromaticChordImmutable.DD5);
    public static final ChromaticChord E5 = new ChromaticChord(ChromaticChordImmutable.E5);
    public static final ChromaticChord F5 = new ChromaticChord(ChromaticChordImmutable.F5);
    public static final ChromaticChord FF5 = new ChromaticChord(ChromaticChordImmutable.FF5);
    public static final ChromaticChord G5 = new ChromaticChord(ChromaticChordImmutable.G5);
    public static final ChromaticChord GG5 = new ChromaticChord(ChromaticChordImmutable.GG5);
    public static final ChromaticChord A5 = new ChromaticChord(ChromaticChordImmutable.A5);
    public static final ChromaticChord AA5 = new ChromaticChord(ChromaticChordImmutable.AA5);
    public static final ChromaticChord B5 = new ChromaticChord(ChromaticChordImmutable.B5);

    // Mayores
    public static final ChromaticChord C = new ChromaticChord(ChromaticChordImmutable.C);
    public static final ChromaticChord CC = new ChromaticChord(ChromaticChordImmutable.CC);
    public static final ChromaticChord D = new ChromaticChord(ChromaticChordImmutable.D);
    public static final ChromaticChord DD = new ChromaticChord(ChromaticChordImmutable.DD);
    public static final ChromaticChord E = new ChromaticChord(ChromaticChordImmutable.E);
    public static final ChromaticChord F = new ChromaticChord(ChromaticChordImmutable.F);
    public static final ChromaticChord FF = new ChromaticChord(ChromaticChordImmutable.FF);
    public static final ChromaticChord G = new ChromaticChord(ChromaticChordImmutable.G);
    public static final ChromaticChord GG = new ChromaticChord(ChromaticChordImmutable.GG);
    public static final ChromaticChord A = new ChromaticChord(ChromaticChordImmutable.A);
    public static final ChromaticChord AA = new ChromaticChord(ChromaticChordImmutable.AA);
    public static final ChromaticChord B = new ChromaticChord(ChromaticChordImmutable.B);

    // Menores
    public static final ChromaticChord Cm = new ChromaticChord(ChromaticChordImmutable.Cm);
    public static final ChromaticChord CCm = new ChromaticChord(ChromaticChordImmutable.CCm);
    public static final ChromaticChord Dm = new ChromaticChord(ChromaticChordImmutable.Dm);
    public static final ChromaticChord DDm = new ChromaticChord(ChromaticChordImmutable.DDm);
    public static final ChromaticChord Em = new ChromaticChord(ChromaticChordImmutable.Em);
    public static final ChromaticChord Fm = new ChromaticChord(ChromaticChordImmutable.Fm);
    public static final ChromaticChord FFm = new ChromaticChord(ChromaticChordImmutable.FFm);
    public static final ChromaticChord Gm = new ChromaticChord(ChromaticChordImmutable.Gm);
    public static final ChromaticChord GGm = new ChromaticChord(ChromaticChordImmutable.GGm);
    public static final ChromaticChord Am = new ChromaticChord(ChromaticChordImmutable.Am);
    public static final ChromaticChord AAm = new ChromaticChord(ChromaticChordImmutable.AAm);
    public static final ChromaticChord Bm = new ChromaticChord(ChromaticChordImmutable.Bm);

    // Aumentados
    public static final ChromaticChord Caug = new ChromaticChord(ChromaticChordImmutable.Caug);
    public static final ChromaticChord CCaug = new ChromaticChord(ChromaticChordImmutable.CCaug);
    public static final ChromaticChord Daug = new ChromaticChord(ChromaticChordImmutable.Daug);
    public static final ChromaticChord DDaug = new ChromaticChord(ChromaticChordImmutable.DDaug);
    public static final ChromaticChord Eaug = new ChromaticChord(ChromaticChordImmutable.Eaug);
    public static final ChromaticChord Faug = new ChromaticChord(ChromaticChordImmutable.Faug);
    public static final ChromaticChord FFaug = new ChromaticChord(ChromaticChordImmutable.FFaug);
    public static final ChromaticChord Gaug = new ChromaticChord(ChromaticChordImmutable.Gaug);
    public static final ChromaticChord GGaug = new ChromaticChord(ChromaticChordImmutable.GGaug);
    public static final ChromaticChord Aaug = new ChromaticChord(ChromaticChordImmutable.Aaug);
    public static final ChromaticChord AAaug = new ChromaticChord(ChromaticChordImmutable.AAaug);
    public static final ChromaticChord Baug = new ChromaticChord(ChromaticChordImmutable.Baug);

    // Diminuidos
    public static final ChromaticChord Cdim = new ChromaticChord(ChromaticChordImmutable.Cdim);
    public static final ChromaticChord CCdim = new ChromaticChord(ChromaticChordImmutable.CCdim);
    public static final ChromaticChord Ddim = new ChromaticChord(ChromaticChordImmutable.Ddim);
    public static final ChromaticChord DDdim = new ChromaticChord(ChromaticChordImmutable.DDdim);
    public static final ChromaticChord Edim = new ChromaticChord(ChromaticChordImmutable.Edim);
    public static final ChromaticChord Fdim = new ChromaticChord(ChromaticChordImmutable.Fdim);
    public static final ChromaticChord FFdim = new ChromaticChord(ChromaticChordImmutable.FFdim);
    public static final ChromaticChord Gdim = new ChromaticChord(ChromaticChordImmutable.Gdim);
    public static final ChromaticChord GGdim = new ChromaticChord(ChromaticChordImmutable.GGdim);
    public static final ChromaticChord Adim = new ChromaticChord(ChromaticChordImmutable.Adim);
    public static final ChromaticChord AAdim = new ChromaticChord(ChromaticChordImmutable.AAdim);
    public static final ChromaticChord Bdim = new ChromaticChord(ChromaticChordImmutable.Bdim);

    // Cuarta suspendida
    public static final ChromaticChord Csus4 = new ChromaticChord(ChromaticChordImmutable.Csus4);
    public static final ChromaticChord CCsus4 = new ChromaticChord(ChromaticChordImmutable.CCsus4);
    public static final ChromaticChord Dsus4 = new ChromaticChord(ChromaticChordImmutable.Dsus4);
    public static final ChromaticChord DDsus4 = new ChromaticChord(ChromaticChordImmutable.DDsus4);
    public static final ChromaticChord Esus4 = new ChromaticChord(ChromaticChordImmutable.Esus4);
    public static final ChromaticChord Fsus4 = new ChromaticChord(ChromaticChordImmutable.Fsus4);
    public static final ChromaticChord FFsus4 = new ChromaticChord(ChromaticChordImmutable.FFsus4);
    public static final ChromaticChord Gsus4 = new ChromaticChord(ChromaticChordImmutable.Gsus4);
    public static final ChromaticChord GGsus4 = new ChromaticChord(ChromaticChordImmutable.GGsus4);
    public static final ChromaticChord Asus4 = new ChromaticChord(ChromaticChordImmutable.Asus4);
    public static final ChromaticChord AAsus4 = new ChromaticChord(ChromaticChordImmutable.AAsus4);
    public static final ChromaticChord Bsus4 = new ChromaticChord(ChromaticChordImmutable.Bsus4);

    // Segunda suspendida
    public static final ChromaticChord Csus2 = new ChromaticChord(ChromaticChordImmutable.Csus2);
    public static final ChromaticChord CCsus2 = new ChromaticChord(ChromaticChordImmutable.CCsus2);
    public static final ChromaticChord Dsus2 = new ChromaticChord(ChromaticChordImmutable.Dsus2);
    public static final ChromaticChord DDsus2 = new ChromaticChord(ChromaticChordImmutable.DDsus2);
    public static final ChromaticChord Esus2 = new ChromaticChord(ChromaticChordImmutable.Esus2);
    public static final ChromaticChord Fsus2 = new ChromaticChord(ChromaticChordImmutable.Fsus2);
    public static final ChromaticChord FFsus2 = new ChromaticChord(ChromaticChordImmutable.FFsus2);
    public static final ChromaticChord Gsus2 = new ChromaticChord(ChromaticChordImmutable.Gsus2);
    public static final ChromaticChord GGsus2 = new ChromaticChord(ChromaticChordImmutable.GGsus2);
    public static final ChromaticChord Asus2 = new ChromaticChord(ChromaticChordImmutable.Asus2);
    public static final ChromaticChord AAsus2 = new ChromaticChord(ChromaticChordImmutable.AAsus2);
    public static final ChromaticChord Bsus2 = new ChromaticChord(ChromaticChordImmutable.Bsus2);

    // Séptima (de dominante)
    public static final ChromaticChord C7 = new ChromaticChord(ChromaticChordImmutable.C7);
    public static final ChromaticChord CC7 = new ChromaticChord(ChromaticChordImmutable.CC7);
    public static final ChromaticChord D7 = new ChromaticChord(ChromaticChordImmutable.D7);
    public static final ChromaticChord DD7 = new ChromaticChord(ChromaticChordImmutable.DD7);
    public static final ChromaticChord E7 = new ChromaticChord(ChromaticChordImmutable.E7);
    public static final ChromaticChord F7 = new ChromaticChord(ChromaticChordImmutable.F7);
    public static final ChromaticChord FF7 = new ChromaticChord(ChromaticChordImmutable.FF7);
    public static final ChromaticChord G7 = new ChromaticChord(ChromaticChordImmutable.G7);
    public static final ChromaticChord GG7 = new ChromaticChord(ChromaticChordImmutable.GG7);
    public static final ChromaticChord A7 = new ChromaticChord(ChromaticChordImmutable.A7);
    public static final ChromaticChord AA7 = new ChromaticChord(ChromaticChordImmutable.AA7);
    public static final ChromaticChord B7 = new ChromaticChord(ChromaticChordImmutable.B7);

    // Séptima con quinta bemol
    public static final ChromaticChord C7b5 = new ChromaticChord(ChromaticChordImmutable.C7b5);
    public static final ChromaticChord CC7b5 = new ChromaticChord(ChromaticChordImmutable.CC7b5);
    public static final ChromaticChord D7b5 = new ChromaticChord(ChromaticChordImmutable.D7b5);
    public static final ChromaticChord DD7b5 = new ChromaticChord(ChromaticChordImmutable.DD7b5);
    public static final ChromaticChord E7b5 = new ChromaticChord(ChromaticChordImmutable.E7b5);
    public static final ChromaticChord F7b5 = new ChromaticChord(ChromaticChordImmutable.F7b5);
    public static final ChromaticChord FF7b5 = new ChromaticChord(ChromaticChordImmutable.FF7b5);
    public static final ChromaticChord G7b5 = new ChromaticChord(ChromaticChordImmutable.G7b5);
    public static final ChromaticChord GG7b5 = new ChromaticChord(ChromaticChordImmutable.GG7b5);
    public static final ChromaticChord A7b5 = new ChromaticChord(ChromaticChordImmutable.A7b5);
    public static final ChromaticChord AA7b5 = new ChromaticChord(ChromaticChordImmutable.AA7b5);
    public static final ChromaticChord B7b5 = new ChromaticChord(ChromaticChordImmutable.B7b5);

    // Séptima con quinta aumentada
    public static final ChromaticChord C7a5 = new ChromaticChord(ChromaticChordImmutable.C7a5);
    public static final ChromaticChord CC7a5 = new ChromaticChord(ChromaticChordImmutable.CC7a5);
    public static final ChromaticChord D7a5 = new ChromaticChord(ChromaticChordImmutable.D7a5);
    public static final ChromaticChord DD7a5 = new ChromaticChord(ChromaticChordImmutable.DD7a5);
    public static final ChromaticChord E7a5 = new ChromaticChord(ChromaticChordImmutable.E7a5);
    public static final ChromaticChord F7a5 = new ChromaticChord(ChromaticChordImmutable.F7a5);
    public static final ChromaticChord FF7a5 = new ChromaticChord(ChromaticChordImmutable.FF7a5);
    public static final ChromaticChord G7a5 = new ChromaticChord(ChromaticChordImmutable.G7a5);
    public static final ChromaticChord GG7a5 = new ChromaticChord(ChromaticChordImmutable.GG7a5);
    public static final ChromaticChord A7a5 = new ChromaticChord(ChromaticChordImmutable.A7a5);
    public static final ChromaticChord AA7a5 = new ChromaticChord(ChromaticChordImmutable.AA7a5);
    public static final ChromaticChord B7a5 = new ChromaticChord(ChromaticChordImmutable.B7a5);

    // Séptima con cuarta suspendida
    public static final ChromaticChord C7sus4 = new ChromaticChord(ChromaticChordImmutable.C7sus4);
    public static final ChromaticChord CC7sus4 = new ChromaticChord(ChromaticChordImmutable.CC7sus4);
    public static final ChromaticChord D7sus4 = new ChromaticChord(ChromaticChordImmutable.D7sus4);
    public static final ChromaticChord DD7sus4 = new ChromaticChord(ChromaticChordImmutable.DD7sus4);
    public static final ChromaticChord E7sus4 = new ChromaticChord(ChromaticChordImmutable.E7sus4);
    public static final ChromaticChord F7sus4 = new ChromaticChord(ChromaticChordImmutable.F7sus4);
    public static final ChromaticChord FF7sus4 = new ChromaticChord(ChromaticChordImmutable.FF7sus4);
    public static final ChromaticChord G7sus4 = new ChromaticChord(ChromaticChordImmutable.G7sus4);
    public static final ChromaticChord GG7sus4 = new ChromaticChord(ChromaticChordImmutable.GG7sus4);
    public static final ChromaticChord A7sus4 = new ChromaticChord(ChromaticChordImmutable.A7sus4);
    public static final ChromaticChord AA7sus4 = new ChromaticChord(ChromaticChordImmutable.AA7sus4);
    public static final ChromaticChord B7sus4 = new ChromaticChord(ChromaticChordImmutable.B7sus4);

    // Menor séptima
    public static final ChromaticChord Cm7 = new ChromaticChord(ChromaticChordImmutable.Cm7);
    public static final ChromaticChord CCm7 = new ChromaticChord(ChromaticChordImmutable.CCm7);
    public static final ChromaticChord Dm7 = new ChromaticChord(ChromaticChordImmutable.Dm7);
    public static final ChromaticChord DDm7 = new ChromaticChord(ChromaticChordImmutable.DDm7);
    public static final ChromaticChord Em7 = new ChromaticChord(ChromaticChordImmutable.Em7);
    public static final ChromaticChord Fm7 = new ChromaticChord(ChromaticChordImmutable.Fm7);
    public static final ChromaticChord FFm7 = new ChromaticChord(ChromaticChordImmutable.FFm7);
    public static final ChromaticChord Gm7 = new ChromaticChord(ChromaticChordImmutable.Gm7);
    public static final ChromaticChord GGm7 = new ChromaticChord(ChromaticChordImmutable.GGm7);
    public static final ChromaticChord Am7 = new ChromaticChord(ChromaticChordImmutable.Am7);
    public static final ChromaticChord AAm7 = new ChromaticChord(ChromaticChordImmutable.AAm7);
    public static final ChromaticChord Bm7 = new ChromaticChord(ChromaticChordImmutable.Bm7);

    // Menor sÉptima con quinta bemol
    public static final ChromaticChord Cm7b5 = new ChromaticChord(ChromaticChordImmutable.Cm7b5);
    public static final ChromaticChord CCm7b5 = new ChromaticChord(ChromaticChordImmutable.CCm7b5);
    public static final ChromaticChord Dm7b5 = new ChromaticChord(ChromaticChordImmutable.Dm7b5);
    public static final ChromaticChord DDm7b5 = new ChromaticChord(ChromaticChordImmutable.DDm7b5);
    public static final ChromaticChord Em7b5 = new ChromaticChord(ChromaticChordImmutable.Em7b5);
    public static final ChromaticChord Fm7b5 = new ChromaticChord(ChromaticChordImmutable.Fm7b5);
    public static final ChromaticChord FFm7b5 = new ChromaticChord(ChromaticChordImmutable.FFm7b5);
    public static final ChromaticChord Gm7b5 = new ChromaticChord(ChromaticChordImmutable.Gm7b5);
    public static final ChromaticChord GGm7b5 = new ChromaticChord(ChromaticChordImmutable.GGm7b5);
    public static final ChromaticChord Am7b5 = new ChromaticChord(ChromaticChordImmutable.Am7b5);
    public static final ChromaticChord AAm7b5 = new ChromaticChord(ChromaticChordImmutable.AAm7b5);
    public static final ChromaticChord Bm7b5 = new ChromaticChord(ChromaticChordImmutable.Bm7b5);

    // Menor sÉptima con quinta aumentada
    public static final ChromaticChord Cm7a5 = new ChromaticChord(ChromaticChordImmutable.Cm7a5);
    public static final ChromaticChord CCm7a5 = new ChromaticChord(ChromaticChordImmutable.CCm7a5);
    public static final ChromaticChord Dm7a5 = new ChromaticChord(ChromaticChordImmutable.Dm7a5);
    public static final ChromaticChord DDm7a5 = new ChromaticChord(ChromaticChordImmutable.DDm7a5);
    public static final ChromaticChord Em7a5 = new ChromaticChord(ChromaticChordImmutable.Em7a5);
    public static final ChromaticChord Fm7a5 = new ChromaticChord(ChromaticChordImmutable.Fm7a5);
    public static final ChromaticChord FFm7a5 = new ChromaticChord(ChromaticChordImmutable.FFm7a5);
    public static final ChromaticChord Gm7a5 = new ChromaticChord(ChromaticChordImmutable.Gm7a5);
    public static final ChromaticChord GGm7a5 = new ChromaticChord(ChromaticChordImmutable.GGm7a5);
    public static final ChromaticChord Am7a5 = new ChromaticChord(ChromaticChordImmutable.Am7a5);
    public static final ChromaticChord AAm7a5 = new ChromaticChord(ChromaticChordImmutable.AAm7a5);
    public static final ChromaticChord Bm7a5 = new ChromaticChord(ChromaticChordImmutable.Bm7a5);

    // Sexta
    public static final ChromaticChord C6 = new ChromaticChord(ChromaticChordImmutable.C6);
    public static final ChromaticChord CC6 = new ChromaticChord(ChromaticChordImmutable.CC6);
    public static final ChromaticChord D6 = new ChromaticChord(ChromaticChordImmutable.D6);
    public static final ChromaticChord DD6 = new ChromaticChord(ChromaticChordImmutable.DD6);
    public static final ChromaticChord E6 = new ChromaticChord(ChromaticChordImmutable.E6);
    public static final ChromaticChord F6 = new ChromaticChord(ChromaticChordImmutable.F6);
    public static final ChromaticChord FF6 = new ChromaticChord(ChromaticChordImmutable.FF6);
    public static final ChromaticChord G6 = new ChromaticChord(ChromaticChordImmutable.G6);
    public static final ChromaticChord GG6 = new ChromaticChord(ChromaticChordImmutable.GG6);
    public static final ChromaticChord A6 = new ChromaticChord(ChromaticChordImmutable.A6);
    public static final ChromaticChord AA6 = new ChromaticChord(ChromaticChordImmutable.AA6);
    public static final ChromaticChord B6 = new ChromaticChord(ChromaticChordImmutable.B6);

    // Menor sexta
    public static final ChromaticChord Cm6 = new ChromaticChord(ChromaticChordImmutable.Cm6);
    public static final ChromaticChord CCm6 = new ChromaticChord(ChromaticChordImmutable.CCm6);
    public static final ChromaticChord Dm6 = new ChromaticChord(ChromaticChordImmutable.Dm6);
    public static final ChromaticChord DDm6 = new ChromaticChord(ChromaticChordImmutable.DDm6);
    public static final ChromaticChord Em6 = new ChromaticChord(ChromaticChordImmutable.Em6);
    public static final ChromaticChord Fm6 = new ChromaticChord(ChromaticChordImmutable.Fm6);
    public static final ChromaticChord FFm6 = new ChromaticChord(ChromaticChordImmutable.FFm6);
    public static final ChromaticChord Gm6 = new ChromaticChord(ChromaticChordImmutable.Gm6);
    public static final ChromaticChord GGm6 = new ChromaticChord(ChromaticChordImmutable.GGm6);
    public static final ChromaticChord Am6 = new ChromaticChord(ChromaticChordImmutable.Am6);
    public static final ChromaticChord AAm6 = new ChromaticChord(ChromaticChordImmutable.AAm6);
    public static final ChromaticChord Bm6 = new ChromaticChord(ChromaticChordImmutable.Bm6);

    // Sexta con cuarta suspendida
    public static final ChromaticChord C6sus4 = new ChromaticChord(ChromaticChordImmutable.C6sus4);
    public static final ChromaticChord CC6sus4 = new ChromaticChord(ChromaticChordImmutable.CC6sus4);
    public static final ChromaticChord D6sus4 = new ChromaticChord(ChromaticChordImmutable.D6sus4);
    public static final ChromaticChord DD6sus4 = new ChromaticChord(ChromaticChordImmutable.DD6sus4);
    public static final ChromaticChord E6sus4 = new ChromaticChord(ChromaticChordImmutable.E6sus4);
    public static final ChromaticChord F6sus4 = new ChromaticChord(ChromaticChordImmutable.F6sus4);
    public static final ChromaticChord FF6sus4 = new ChromaticChord(ChromaticChordImmutable.FF6sus4);
    public static final ChromaticChord G6sus4 = new ChromaticChord(ChromaticChordImmutable.G6sus4);
    public static final ChromaticChord GG6sus4 = new ChromaticChord(ChromaticChordImmutable.GG6sus4);
    public static final ChromaticChord A6sus4 = new ChromaticChord(ChromaticChordImmutable.A6sus4);
    public static final ChromaticChord AA6sus4 = new ChromaticChord(ChromaticChordImmutable.AA6sus4);
    public static final ChromaticChord B6sus4 = new ChromaticChord(ChromaticChordImmutable.B6sus4);

    // Séptima mayor
    public static final ChromaticChord CMaj7 = new ChromaticChord(ChromaticChordImmutable.CMaj7);
    public static final ChromaticChord CCMaj7 = new ChromaticChord(ChromaticChordImmutable.CCMaj7);
    public static final ChromaticChord DMaj7 = new ChromaticChord(ChromaticChordImmutable.DMaj7);
    public static final ChromaticChord DDMaj7 = new ChromaticChord(ChromaticChordImmutable.DDMaj7);
    public static final ChromaticChord EMaj7 = new ChromaticChord(ChromaticChordImmutable.EMaj7);
    public static final ChromaticChord FMaj7 = new ChromaticChord(ChromaticChordImmutable.FMaj7);
    public static final ChromaticChord FFMaj7 = new ChromaticChord(ChromaticChordImmutable.FFMaj7);
    public static final ChromaticChord GMaj7 = new ChromaticChord(ChromaticChordImmutable.GMaj7);
    public static final ChromaticChord GGMaj7 = new ChromaticChord(ChromaticChordImmutable.GGMaj7);
    public static final ChromaticChord AMaj7 = new ChromaticChord(ChromaticChordImmutable.AMaj7);
    public static final ChromaticChord AAMaj7 = new ChromaticChord(ChromaticChordImmutable.AAMaj7);
    public static final ChromaticChord BMaj7 = new ChromaticChord(ChromaticChordImmutable.BMaj7);

    // Menor séptima mayor
    public static final ChromaticChord CmMaj7 = new ChromaticChord(ChromaticChordImmutable.CmMaj7);
    public static final ChromaticChord CCmMaj7 = new ChromaticChord(ChromaticChordImmutable.CCmMaj7);
    public static final ChromaticChord DmMaj7 = new ChromaticChord(ChromaticChordImmutable.DmMaj7);
    public static final ChromaticChord DDmMaj7 = new ChromaticChord(ChromaticChordImmutable.DDmMaj7);
    public static final ChromaticChord EmMaj7 = new ChromaticChord(ChromaticChordImmutable.EmMaj7);
    public static final ChromaticChord FmMaj7 = new ChromaticChord(ChromaticChordImmutable.FmMaj7);
    public static final ChromaticChord FFmMaj7 = new ChromaticChord(ChromaticChordImmutable.FFmMaj7);
    public static final ChromaticChord GmMaj7 = new ChromaticChord(ChromaticChordImmutable.GmMaj7);
    public static final ChromaticChord GGmMaj7 = new ChromaticChord(ChromaticChordImmutable.GGmMaj7);
    public static final ChromaticChord AmMaj7 = new ChromaticChord(ChromaticChordImmutable.AmMaj7);
    public static final ChromaticChord AAmMaj7 = new ChromaticChord(ChromaticChordImmutable.AAmMaj7);
    public static final ChromaticChord BmMaj7 = new ChromaticChord(ChromaticChordImmutable.BmMaj7);

    // Sexta con novena añadida
    public static final ChromaticChord C6add9 = new ChromaticChord(ChromaticChordImmutable.C6add9);
    public static final ChromaticChord CC6add9 = new ChromaticChord(ChromaticChordImmutable.CC6add9);
    public static final ChromaticChord D6add9 = new ChromaticChord(ChromaticChordImmutable.D6add9);
    public static final ChromaticChord DD6add9 = new ChromaticChord(ChromaticChordImmutable.DD6add9);
    public static final ChromaticChord E6add9 = new ChromaticChord(ChromaticChordImmutable.E6add9);
    public static final ChromaticChord F6add9 = new ChromaticChord(ChromaticChordImmutable.F6add9);
    public static final ChromaticChord FF6add9 = new ChromaticChord(ChromaticChordImmutable.FF6add9);
    public static final ChromaticChord G6add9 = new ChromaticChord(ChromaticChordImmutable.G6add9);
    public static final ChromaticChord GG6add9 = new ChromaticChord(ChromaticChordImmutable.GG6add9);
    public static final ChromaticChord A6add9 = new ChromaticChord(ChromaticChordImmutable.A6add9);
    public static final ChromaticChord AA6add9 = new ChromaticChord(ChromaticChordImmutable.AA6add9);
    public static final ChromaticChord B6add9 = new ChromaticChord(ChromaticChordImmutable.B6add9);

    // Sexta con novena añadida
    public static final ChromaticChord Cm6add9 = new ChromaticChord(ChromaticChordImmutable.Cm6add9);
    public static final ChromaticChord CCm6add9 = new ChromaticChord(ChromaticChordImmutable.CCm6add9);
    public static final ChromaticChord Dm6add9 = new ChromaticChord(ChromaticChordImmutable.Dm6add9);
    public static final ChromaticChord DDm6add9 = new ChromaticChord(ChromaticChordImmutable.DDm6add9);
    public static final ChromaticChord Em6add9 = new ChromaticChord(ChromaticChordImmutable.Em6add9);
    public static final ChromaticChord Fm6add9 = new ChromaticChord(ChromaticChordImmutable.Fm6add9);
    public static final ChromaticChord FFm6add9 = new ChromaticChord(ChromaticChordImmutable.FFm6add9);
    public static final ChromaticChord Gm6add9 = new ChromaticChord(ChromaticChordImmutable.Gm6add9);
    public static final ChromaticChord GGm6add9 = new ChromaticChord(ChromaticChordImmutable.GGm6add9);
    public static final ChromaticChord Am6add9 = new ChromaticChord(ChromaticChordImmutable.Am6add9);
    public static final ChromaticChord AAm6add9 = new ChromaticChord(ChromaticChordImmutable.AAm6add9);
    public static final ChromaticChord Bm6add9 = new ChromaticChord(ChromaticChordImmutable.Bm6add9);

    // Séptima con novena bemol (añadida)
    public static final ChromaticChord C7b9 = new ChromaticChord(ChromaticChordImmutable.C7b9);
    public static final ChromaticChord CC7b9 = new ChromaticChord(ChromaticChordImmutable.CC7b9);
    public static final ChromaticChord D7b9 = new ChromaticChord(ChromaticChordImmutable.D7b9);
    public static final ChromaticChord DD7b9 = new ChromaticChord(ChromaticChordImmutable.DD7b9);
    public static final ChromaticChord E7b9 = new ChromaticChord(ChromaticChordImmutable.E7b9);
    public static final ChromaticChord F7b9 = new ChromaticChord(ChromaticChordImmutable.F7b9);
    public static final ChromaticChord FF7b9 = new ChromaticChord(ChromaticChordImmutable.FF7b9);
    public static final ChromaticChord G7b9 = new ChromaticChord(ChromaticChordImmutable.G7b9);
    public static final ChromaticChord GG7b9 = new ChromaticChord(ChromaticChordImmutable.GG7b9);
    public static final ChromaticChord A7b9 = new ChromaticChord(ChromaticChordImmutable.A7b9);
    public static final ChromaticChord AA7b9 = new ChromaticChord(ChromaticChordImmutable.AA7b9);
    public static final ChromaticChord B7b9 = new ChromaticChord(ChromaticChordImmutable.B7b9);

    // Séptima con novena aumentada (añadida)
    public static final ChromaticChord C7a9 = new ChromaticChord(ChromaticChordImmutable.C7a9);
    public static final ChromaticChord CC7a9 = new ChromaticChord(ChromaticChordImmutable.CC7a9);
    public static final ChromaticChord D7a9 = new ChromaticChord(ChromaticChordImmutable.D7a9);
    public static final ChromaticChord DD7a9 = new ChromaticChord(ChromaticChordImmutable.DD7a9);
    public static final ChromaticChord E7a9 = new ChromaticChord(ChromaticChordImmutable.E7a9);
    public static final ChromaticChord F7a9 = new ChromaticChord(ChromaticChordImmutable.F7a9);
    public static final ChromaticChord FF7a9 = new ChromaticChord(ChromaticChordImmutable.FF7a9);
    public static final ChromaticChord G7a9 = new ChromaticChord(ChromaticChordImmutable.G7a9);
    public static final ChromaticChord GG7a9 = new ChromaticChord(ChromaticChordImmutable.GG7a9);
    public static final ChromaticChord A7a9 = new ChromaticChord(ChromaticChordImmutable.A7a9);
    public static final ChromaticChord AA7a9 = new ChromaticChord(ChromaticChordImmutable.AA7a9);
    public static final ChromaticChord B7a9 = new ChromaticChord(ChromaticChordImmutable.B7a9);

    // Menor séptima con novena bemol (añadida)
    public static final ChromaticChord Cm7b9 = new ChromaticChord(ChromaticChordImmutable.Cm7b9);
    public static final ChromaticChord CCm7b9 = new ChromaticChord(ChromaticChordImmutable.CCm7b9);
    public static final ChromaticChord Dm7b9 = new ChromaticChord(ChromaticChordImmutable.Dm7b9);
    public static final ChromaticChord DDm7b9 = new ChromaticChord(ChromaticChordImmutable.DDm7b9);
    public static final ChromaticChord Em7b9 = new ChromaticChord(ChromaticChordImmutable.Em7b9);
    public static final ChromaticChord Fm7b9 = new ChromaticChord(ChromaticChordImmutable.Fm7b9);
    public static final ChromaticChord FFm7b9 = new ChromaticChord(ChromaticChordImmutable.FFm7b9);
    public static final ChromaticChord Gm7b9 = new ChromaticChord(ChromaticChordImmutable.Gm7b9);
    public static final ChromaticChord GGm7b9 = new ChromaticChord(ChromaticChordImmutable.GGm7b9);
    public static final ChromaticChord Am7b9 = new ChromaticChord(ChromaticChordImmutable.Am7b9);
    public static final ChromaticChord AAm7b9 = new ChromaticChord(ChromaticChordImmutable.AAm7b9);
    public static final ChromaticChord Bm7b9 = new ChromaticChord(ChromaticChordImmutable.Bm7b9);

    // Séptima con oncena (añadida)
    public static final ChromaticChord C7add11 = new ChromaticChord(ChromaticChordImmutable.C7add11);
    public static final ChromaticChord CC7add11 = new ChromaticChord(ChromaticChordImmutable.CC7add11);
    public static final ChromaticChord D7add11 = new ChromaticChord(ChromaticChordImmutable.D7add11);
    public static final ChromaticChord DD7add11 = new ChromaticChord(ChromaticChordImmutable.DD7add11);
    public static final ChromaticChord E7add11 = new ChromaticChord(ChromaticChordImmutable.E7add11);
    public static final ChromaticChord F7add11 = new ChromaticChord(ChromaticChordImmutable.F7add11);
    public static final ChromaticChord FF7add11 = new ChromaticChord(ChromaticChordImmutable.FF7add11);
    public static final ChromaticChord G7add11 = new ChromaticChord(ChromaticChordImmutable.G7add11);
    public static final ChromaticChord GG7add11 = new ChromaticChord(ChromaticChordImmutable.GG7add11);
    public static final ChromaticChord A7add11 = new ChromaticChord(ChromaticChordImmutable.A7add11);
    public static final ChromaticChord AA7add11 = new ChromaticChord(ChromaticChordImmutable.AA7add11);
    public static final ChromaticChord B7add11 = new ChromaticChord(ChromaticChordImmutable.B7add11);

    // Séptima con treceava (añadida)
    public static final ChromaticChord C7add13 = new ChromaticChord(ChromaticChordImmutable.C7add13);
    public static final ChromaticChord CC7add13 = new ChromaticChord(ChromaticChordImmutable.CC7add13);
    public static final ChromaticChord D7add13 = new ChromaticChord(ChromaticChordImmutable.D7add13);
    public static final ChromaticChord DD7add13 = new ChromaticChord(ChromaticChordImmutable.DD7add13);
    public static final ChromaticChord E7add13 = new ChromaticChord(ChromaticChordImmutable.E7add13);
    public static final ChromaticChord F7add13 = new ChromaticChord(ChromaticChordImmutable.F7add13);
    public static final ChromaticChord FF7add13 = new ChromaticChord(ChromaticChordImmutable.FF7add13);
    public static final ChromaticChord G7add13 = new ChromaticChord(ChromaticChordImmutable.G7add13);
    public static final ChromaticChord GG7add13 = new ChromaticChord(ChromaticChordImmutable.GG7add13);
    public static final ChromaticChord A7add13 = new ChromaticChord(ChromaticChordImmutable.A7add13);
    public static final ChromaticChord AA7add13 = new ChromaticChord(ChromaticChordImmutable.AA7add13);
    public static final ChromaticChord B7add13 = new ChromaticChord(ChromaticChordImmutable.B7add13);

    // Novena
    public static final ChromaticChord C9 = new ChromaticChord(ChromaticChordImmutable.C9);
    public static final ChromaticChord CC9 = new ChromaticChord(ChromaticChordImmutable.CC9);
    public static final ChromaticChord D9 = new ChromaticChord(ChromaticChordImmutable.D9);
    public static final ChromaticChord DD9 = new ChromaticChord(ChromaticChordImmutable.DD9);
    public static final ChromaticChord E9 = new ChromaticChord(ChromaticChordImmutable.E9);
    public static final ChromaticChord F9 = new ChromaticChord(ChromaticChordImmutable.F9);
    public static final ChromaticChord FF9 = new ChromaticChord(ChromaticChordImmutable.FF9);
    public static final ChromaticChord G9 = new ChromaticChord(ChromaticChordImmutable.G9);
    public static final ChromaticChord GG9 = new ChromaticChord(ChromaticChordImmutable.GG9);
    public static final ChromaticChord A9 = new ChromaticChord(ChromaticChordImmutable.A9);
    public static final ChromaticChord AA9 = new ChromaticChord(ChromaticChordImmutable.AA9);
    public static final ChromaticChord B9 = new ChromaticChord(ChromaticChordImmutable.B9);

    // Menor novena
    public static final ChromaticChord Cm9 = new ChromaticChord(ChromaticChordImmutable.Cm9);
    public static final ChromaticChord CCm9 = new ChromaticChord(ChromaticChordImmutable.CCm9);
    public static final ChromaticChord Dm9 = new ChromaticChord(ChromaticChordImmutable.Dm9);
    public static final ChromaticChord DDm9 = new ChromaticChord(ChromaticChordImmutable.DDm9);
    public static final ChromaticChord Em9 = new ChromaticChord(ChromaticChordImmutable.Em9);
    public static final ChromaticChord Fm9 = new ChromaticChord(ChromaticChordImmutable.Fm9);
    public static final ChromaticChord FFm9 = new ChromaticChord(ChromaticChordImmutable.FFm9);
    public static final ChromaticChord Gm9 = new ChromaticChord(ChromaticChordImmutable.Gm9);
    public static final ChromaticChord GGm9 = new ChromaticChord(ChromaticChordImmutable.GGm9);
    public static final ChromaticChord Am9 = new ChromaticChord(ChromaticChordImmutable.Am9);
    public static final ChromaticChord AAm9 = new ChromaticChord(ChromaticChordImmutable.AAm9);
    public static final ChromaticChord Bm9 = new ChromaticChord(ChromaticChordImmutable.Bm9);

    // Novena con quinta bemol
    public static final ChromaticChord C9b5 = new ChromaticChord(ChromaticChordImmutable.C9b5);
    public static final ChromaticChord CC9b5 = new ChromaticChord(ChromaticChordImmutable.CC9b5);
    public static final ChromaticChord D9b5 = new ChromaticChord(ChromaticChordImmutable.D9b5);
    public static final ChromaticChord DD9b5 = new ChromaticChord(ChromaticChordImmutable.DD9b5);
    public static final ChromaticChord E9b5 = new ChromaticChord(ChromaticChordImmutable.E9b5);
    public static final ChromaticChord F9b5 = new ChromaticChord(ChromaticChordImmutable.F9b5);
    public static final ChromaticChord FF9b5 = new ChromaticChord(ChromaticChordImmutable.FF9b5);
    public static final ChromaticChord G9b5 = new ChromaticChord(ChromaticChordImmutable.G9b5);
    public static final ChromaticChord GG9b5 = new ChromaticChord(ChromaticChordImmutable.GG9b5);
    public static final ChromaticChord A9b5 = new ChromaticChord(ChromaticChordImmutable.A9b5);
    public static final ChromaticChord AA9b5 = new ChromaticChord(ChromaticChordImmutable.AA9b5);
    public static final ChromaticChord B9b5 = new ChromaticChord(ChromaticChordImmutable.B9b5);

    // Novena con quinta aumentada
    public static final ChromaticChord C9a5 = new ChromaticChord(ChromaticChordImmutable.C9a5);
    public static final ChromaticChord CC9a5 = new ChromaticChord(ChromaticChordImmutable.CC9a5);
    public static final ChromaticChord D9a5 = new ChromaticChord(ChromaticChordImmutable.D9a5);
    public static final ChromaticChord DD9a5 = new ChromaticChord(ChromaticChordImmutable.DD9a5);
    public static final ChromaticChord E9a5 = new ChromaticChord(ChromaticChordImmutable.E9a5);
    public static final ChromaticChord F9a5 = new ChromaticChord(ChromaticChordImmutable.F9a5);
    public static final ChromaticChord FF9a5 = new ChromaticChord(ChromaticChordImmutable.FF9a5);
    public static final ChromaticChord G9a5 = new ChromaticChord(ChromaticChordImmutable.G9a5);
    public static final ChromaticChord GG9a5 = new ChromaticChord(ChromaticChordImmutable.GG9a5);
    public static final ChromaticChord A9a5 = new ChromaticChord(ChromaticChordImmutable.A9a5);
    public static final ChromaticChord AA9a5 = new ChromaticChord(ChromaticChordImmutable.AA9a5);
    public static final ChromaticChord B9a5 = new ChromaticChord(ChromaticChordImmutable.B9a5);

    // Novena con cuarta suspendida
    public static final ChromaticChord C9sus4 = new ChromaticChord(ChromaticChordImmutable.C9sus4);
    public static final ChromaticChord CC9sus4 = new ChromaticChord(ChromaticChordImmutable.CC9sus4);
    public static final ChromaticChord D9sus4 = new ChromaticChord(ChromaticChordImmutable.D9sus4);
    public static final ChromaticChord DD9sus4 = new ChromaticChord(ChromaticChordImmutable.DD9sus4);
    public static final ChromaticChord E9sus4 = new ChromaticChord(ChromaticChordImmutable.E9sus4);
    public static final ChromaticChord F9sus4 = new ChromaticChord(ChromaticChordImmutable.F9sus4);
    public static final ChromaticChord FF9sus4 = new ChromaticChord(ChromaticChordImmutable.FF9sus4);
    public static final ChromaticChord G9sus4 = new ChromaticChord(ChromaticChordImmutable.G9sus4);
    public static final ChromaticChord GG9sus4 = new ChromaticChord(ChromaticChordImmutable.GG9sus4);
    public static final ChromaticChord A9sus4 = new ChromaticChord(ChromaticChordImmutable.A9sus4);
    public static final ChromaticChord AA9sus4 = new ChromaticChord(ChromaticChordImmutable.AA9sus4);
    public static final ChromaticChord B9sus4 = new ChromaticChord(ChromaticChordImmutable.B9sus4);

    // Novena mayor
    public static final ChromaticChord CMaj9 = new ChromaticChord(ChromaticChordImmutable.CMaj9);
    public static final ChromaticChord CCMaj9 = new ChromaticChord(ChromaticChordImmutable.CCMaj9);
    public static final ChromaticChord DMaj9 = new ChromaticChord(ChromaticChordImmutable.DMaj9);
    public static final ChromaticChord DDMaj9 = new ChromaticChord(ChromaticChordImmutable.DDMaj9);
    public static final ChromaticChord EMaj9 = new ChromaticChord(ChromaticChordImmutable.EMaj9);
    public static final ChromaticChord FMaj9 = new ChromaticChord(ChromaticChordImmutable.FMaj9);
    public static final ChromaticChord FFMaj9 = new ChromaticChord(ChromaticChordImmutable.FFMaj9);
    public static final ChromaticChord GMaj9 = new ChromaticChord(ChromaticChordImmutable.GMaj9);
    public static final ChromaticChord GGMaj9 = new ChromaticChord(ChromaticChordImmutable.GGMaj9);
    public static final ChromaticChord AMaj9 = new ChromaticChord(ChromaticChordImmutable.AMaj9);
    public static final ChromaticChord AAMaj9 = new ChromaticChord(ChromaticChordImmutable.AAMaj9);
    public static final ChromaticChord BMaj9 = new ChromaticChord(ChromaticChordImmutable.BMaj9);

    // Menor novena mayor
    public static final ChromaticChord CmMaj9 = new ChromaticChord(ChromaticChordImmutable.CmMaj9);
    public static final ChromaticChord CCmMaj9 = new ChromaticChord(ChromaticChordImmutable.CCmMaj9);
    public static final ChromaticChord DmMaj9 = new ChromaticChord(ChromaticChordImmutable.DmMaj9);
    public static final ChromaticChord DDmMaj9 = new ChromaticChord(ChromaticChordImmutable.DDmMaj9);
    public static final ChromaticChord EmMaj9 = new ChromaticChord(ChromaticChordImmutable.EmMaj9);
    public static final ChromaticChord FmMaj9 = new ChromaticChord(ChromaticChordImmutable.FmMaj9);
    public static final ChromaticChord FFmMaj9 = new ChromaticChord(ChromaticChordImmutable.FFmMaj9);
    public static final ChromaticChord GmMaj9 = new ChromaticChord(ChromaticChordImmutable.GmMaj9);
    public static final ChromaticChord GGmMaj9 = new ChromaticChord(ChromaticChordImmutable.GGmMaj9);
    public static final ChromaticChord AmMaj9 = new ChromaticChord(ChromaticChordImmutable.AmMaj9);
    public static final ChromaticChord AAmMaj9 = new ChromaticChord(ChromaticChordImmutable.AAmMaj9);
    public static final ChromaticChord BmMaj9 = new ChromaticChord(ChromaticChordImmutable.BmMaj9);

    // Novena con sexta (añadida)
    public static final ChromaticChord C9add6 = new ChromaticChord(ChromaticChordImmutable.C9add6);
    public static final ChromaticChord CC9add6 = new ChromaticChord(ChromaticChordImmutable.CC9add6);
    public static final ChromaticChord D9add6 = new ChromaticChord(ChromaticChordImmutable.D9add6);
    public static final ChromaticChord DD9add6 = new ChromaticChord(ChromaticChordImmutable.DD9add6);
    public static final ChromaticChord E9add6 = new ChromaticChord(ChromaticChordImmutable.E9add6);
    public static final ChromaticChord F9add6 = new ChromaticChord(ChromaticChordImmutable.F9add6);
    public static final ChromaticChord FF9add6 = new ChromaticChord(ChromaticChordImmutable.FF9add6);
    public static final ChromaticChord G9add6 = new ChromaticChord(ChromaticChordImmutable.G9add6);
    public static final ChromaticChord GG9add6 = new ChromaticChord(ChromaticChordImmutable.GG9add6);
    public static final ChromaticChord A9add6 = new ChromaticChord(ChromaticChordImmutable.A9add6);
    public static final ChromaticChord AA9add6 = new ChromaticChord(ChromaticChordImmutable.AA9add6);
    public static final ChromaticChord B9add6 = new ChromaticChord(ChromaticChordImmutable.B9add6);

    // Novena con onceava aumentada (añadida)
    public static final ChromaticChord C9a11 = new ChromaticChord(ChromaticChordImmutable.C9a11);
    public static final ChromaticChord CC9a11 = new ChromaticChord(ChromaticChordImmutable.CC9a11);
    public static final ChromaticChord D9a11 = new ChromaticChord(ChromaticChordImmutable.D9a11);
    public static final ChromaticChord DD9a11 = new ChromaticChord(ChromaticChordImmutable.DD9a11);
    public static final ChromaticChord E9a11 = new ChromaticChord(ChromaticChordImmutable.E9a11);
    public static final ChromaticChord F9a11 = new ChromaticChord(ChromaticChordImmutable.F9a11);
    public static final ChromaticChord FF9a11 = new ChromaticChord(ChromaticChordImmutable.FF9a11);
    public static final ChromaticChord G9a11 = new ChromaticChord(ChromaticChordImmutable.G9a11);
    public static final ChromaticChord GG9a11 = new ChromaticChord(ChromaticChordImmutable.GG9a11);
    public static final ChromaticChord A9a11 = new ChromaticChord(ChromaticChordImmutable.A9a11);
    public static final ChromaticChord AA9a11 = new ChromaticChord(ChromaticChordImmutable.AA9a11);
    public static final ChromaticChord B9a11 = new ChromaticChord(ChromaticChordImmutable.B9a11);

    // Novena mayor con onceava aumentada (añadida)
    public static final ChromaticChord CMaj9a11 = new ChromaticChord(ChromaticChordImmutable.CMaj9a11);
    public static final ChromaticChord CCMaj9a11 = new ChromaticChord(ChromaticChordImmutable.CCMaj9a11);
    public static final ChromaticChord DMaj9a11 = new ChromaticChord(ChromaticChordImmutable.DMaj9a11);
    public static final ChromaticChord DDMaj9a11 = new ChromaticChord(ChromaticChordImmutable.DDMaj9a11);
    public static final ChromaticChord EMaj9a11 = new ChromaticChord(ChromaticChordImmutable.EMaj9a11);
    public static final ChromaticChord FMaj9a11 = new ChromaticChord(ChromaticChordImmutable.FMaj9a11);
    public static final ChromaticChord FFMaj9a11 = new ChromaticChord(ChromaticChordImmutable.FFMaj9a11);
    public static final ChromaticChord GMaj9a11 = new ChromaticChord(ChromaticChordImmutable.GMaj9a11);
    public static final ChromaticChord GGMaj9a11 = new ChromaticChord(ChromaticChordImmutable.GGMaj9a11);
    public static final ChromaticChord AMaj9a11 = new ChromaticChord(ChromaticChordImmutable.AMaj9a11);
    public static final ChromaticChord AAMaj9a11 = new ChromaticChord(ChromaticChordImmutable.AAMaj9a11);
    public static final ChromaticChord BMaj9a11 = new ChromaticChord(ChromaticChordImmutable.BMaj9a11);

    // Onceava
    public static final ChromaticChord C11 = new ChromaticChord(ChromaticChordImmutable.C11);
    public static final ChromaticChord CC11 = new ChromaticChord(ChromaticChordImmutable.CC11);
    public static final ChromaticChord D11 = new ChromaticChord(ChromaticChordImmutable.D11);
    public static final ChromaticChord DD11 = new ChromaticChord(ChromaticChordImmutable.DD11);
    public static final ChromaticChord E11 = new ChromaticChord(ChromaticChordImmutable.E11);
    public static final ChromaticChord F11 = new ChromaticChord(ChromaticChordImmutable.F11);
    public static final ChromaticChord FF11 = new ChromaticChord(ChromaticChordImmutable.FF11);
    public static final ChromaticChord G11 = new ChromaticChord(ChromaticChordImmutable.G11);
    public static final ChromaticChord GG11 = new ChromaticChord(ChromaticChordImmutable.GG11);
    public static final ChromaticChord A11 = new ChromaticChord(ChromaticChordImmutable.A11);
    public static final ChromaticChord AA11 = new ChromaticChord(ChromaticChordImmutable.AA11);
    public static final ChromaticChord B11 = new ChromaticChord(ChromaticChordImmutable.B11);

    // Menor onceava
    public static final ChromaticChord Cm11 = new ChromaticChord(ChromaticChordImmutable.Cm11);
    public static final ChromaticChord CCm11 = new ChromaticChord(ChromaticChordImmutable.CCm11);
    public static final ChromaticChord Dm11 = new ChromaticChord(ChromaticChordImmutable.Dm11);
    public static final ChromaticChord DDm11 = new ChromaticChord(ChromaticChordImmutable.DDm11);
    public static final ChromaticChord Em11 = new ChromaticChord(ChromaticChordImmutable.Em11);
    public static final ChromaticChord Fm11 = new ChromaticChord(ChromaticChordImmutable.Fm11);
    public static final ChromaticChord FFm11 = new ChromaticChord(ChromaticChordImmutable.FFm11);
    public static final ChromaticChord Gm11 = new ChromaticChord(ChromaticChordImmutable.Gm11);
    public static final ChromaticChord GGm11 = new ChromaticChord(ChromaticChordImmutable.GGm11);
    public static final ChromaticChord Am11 = new ChromaticChord(ChromaticChordImmutable.Am11);
    public static final ChromaticChord AAm11 = new ChromaticChord(ChromaticChordImmutable.AAm11);
    public static final ChromaticChord Bm11 = new ChromaticChord(ChromaticChordImmutable.Bm11);

    // Onceava con novena bemol
    public static final ChromaticChord C11b9 = new ChromaticChord(ChromaticChordImmutable.C11b9);
    public static final ChromaticChord CC11b9 = new ChromaticChord(ChromaticChordImmutable.CC11b9);
    public static final ChromaticChord D11b9 = new ChromaticChord(ChromaticChordImmutable.D11b9);
    public static final ChromaticChord DD11b9 = new ChromaticChord(ChromaticChordImmutable.DD11b9);
    public static final ChromaticChord E11b9 = new ChromaticChord(ChromaticChordImmutable.E11b9);
    public static final ChromaticChord F11b9 = new ChromaticChord(ChromaticChordImmutable.F11b9);
    public static final ChromaticChord FF11b9 = new ChromaticChord(ChromaticChordImmutable.FF11b9);
    public static final ChromaticChord G11b9 = new ChromaticChord(ChromaticChordImmutable.G11b9);
    public static final ChromaticChord GG11b9 = new ChromaticChord(ChromaticChordImmutable.GG11b9);
    public static final ChromaticChord A11b9 = new ChromaticChord(ChromaticChordImmutable.A11b9);
    public static final ChromaticChord AA11b9 = new ChromaticChord(ChromaticChordImmutable.AA11b9);
    public static final ChromaticChord B11b9 = new ChromaticChord(ChromaticChordImmutable.B11b9);

    // Onceava con novena aumentada
    public static final ChromaticChord C11a9 = new ChromaticChord(ChromaticChordImmutable.C11a9);
    public static final ChromaticChord CC11a9 = new ChromaticChord(ChromaticChordImmutable.CC11a9);
    public static final ChromaticChord D11a9 = new ChromaticChord(ChromaticChordImmutable.D11a9);
    public static final ChromaticChord DD11a9 = new ChromaticChord(ChromaticChordImmutable.DD11a9);
    public static final ChromaticChord E11a9 = new ChromaticChord(ChromaticChordImmutable.E11a9);
    public static final ChromaticChord F11a9 = new ChromaticChord(ChromaticChordImmutable.F11a9);
    public static final ChromaticChord FF11a9 = new ChromaticChord(ChromaticChordImmutable.FF11a9);
    public static final ChromaticChord G11a9 = new ChromaticChord(ChromaticChordImmutable.G11a9);
    public static final ChromaticChord GG11a9 = new ChromaticChord(ChromaticChordImmutable.GG11a9);
    public static final ChromaticChord A11a9 = new ChromaticChord(ChromaticChordImmutable.A11a9);
    public static final ChromaticChord AA11a9 = new ChromaticChord(ChromaticChordImmutable.AA11a9);
    public static final ChromaticChord B11a9 = new ChromaticChord(ChromaticChordImmutable.B11a9);

    // Onceava mayor
    public static final ChromaticChord CMaj11 = new ChromaticChord(ChromaticChordImmutable.CMaj11);
    public static final ChromaticChord CCMaj11 = new ChromaticChord(ChromaticChordImmutable.CCMaj11);
    public static final ChromaticChord DMaj11 = new ChromaticChord(ChromaticChordImmutable.DMaj11);
    public static final ChromaticChord DDMaj11 = new ChromaticChord(ChromaticChordImmutable.DDMaj11);
    public static final ChromaticChord EMaj11 = new ChromaticChord(ChromaticChordImmutable.EMaj11);
    public static final ChromaticChord FMaj11 = new ChromaticChord(ChromaticChordImmutable.FMaj11);
    public static final ChromaticChord FFMaj11 = new ChromaticChord(ChromaticChordImmutable.FFMaj11);
    public static final ChromaticChord GMaj11 = new ChromaticChord(ChromaticChordImmutable.GMaj11);
    public static final ChromaticChord GGMaj11 = new ChromaticChord(ChromaticChordImmutable.GGMaj11);
    public static final ChromaticChord AMaj11 = new ChromaticChord(ChromaticChordImmutable.AMaj11);
    public static final ChromaticChord AAMaj11 = new ChromaticChord(ChromaticChordImmutable.AAMaj11);
    public static final ChromaticChord BMaj11 = new ChromaticChord(ChromaticChordImmutable.BMaj11);

    // Menor onceava mayor
    public static final ChromaticChord CmMaj11 = new ChromaticChord(ChromaticChordImmutable.CmMaj11);
    public static final ChromaticChord CCmMaj11 = new ChromaticChord(ChromaticChordImmutable.CCmMaj11);
    public static final ChromaticChord DmMaj11 = new ChromaticChord(ChromaticChordImmutable.DmMaj11);
    public static final ChromaticChord DDmMaj11 = new ChromaticChord(ChromaticChordImmutable.DDmMaj11);
    public static final ChromaticChord EmMaj11 = new ChromaticChord(ChromaticChordImmutable.EmMaj11);
    public static final ChromaticChord FmMaj11 = new ChromaticChord(ChromaticChordImmutable.FmMaj11);
    public static final ChromaticChord FFmMaj11 = new ChromaticChord(ChromaticChordImmutable.FFmMaj11);
    public static final ChromaticChord GmMaj11 = new ChromaticChord(ChromaticChordImmutable.GmMaj11);
    public static final ChromaticChord GGmMaj11 = new ChromaticChord(ChromaticChordImmutable.GGmMaj11);
    public static final ChromaticChord AmMaj11 = new ChromaticChord(ChromaticChordImmutable.AmMaj11);
    public static final ChromaticChord AAmMaj11 = new ChromaticChord(ChromaticChordImmutable.AAmMaj11);
    public static final ChromaticChord BmMaj11 = new ChromaticChord(ChromaticChordImmutable.BmMaj11);

    // Menor treceava
    public static final ChromaticChord Cm13 = new ChromaticChord(ChromaticChordImmutable.Cm13);
    public static final ChromaticChord CCm13 = new ChromaticChord(ChromaticChordImmutable.CCm13);
    public static final ChromaticChord Dm13 = new ChromaticChord(ChromaticChordImmutable.Dm13);
    public static final ChromaticChord DDm13 = new ChromaticChord(ChromaticChordImmutable.DDm13);
    public static final ChromaticChord Em13 = new ChromaticChord(ChromaticChordImmutable.Em13);
    public static final ChromaticChord Fm13 = new ChromaticChord(ChromaticChordImmutable.Fm13);
    public static final ChromaticChord FFm13 = new ChromaticChord(ChromaticChordImmutable.FFm13);
    public static final ChromaticChord Gm13 = new ChromaticChord(ChromaticChordImmutable.Gm13);
    public static final ChromaticChord GGm13 = new ChromaticChord(ChromaticChordImmutable.GGm13);
    public static final ChromaticChord Am13 = new ChromaticChord(ChromaticChordImmutable.Am13);
    public static final ChromaticChord AAm13 = new ChromaticChord(ChromaticChordImmutable.AAm13);
    public static final ChromaticChord Bm13 = new ChromaticChord(ChromaticChordImmutable.Bm13);

    // Treceava con cuarta suspendida
    public static final ChromaticChord C13sus4 = new ChromaticChord(ChromaticChordImmutable.C13sus4);
    public static final ChromaticChord CC13sus4 = new ChromaticChord(ChromaticChordImmutable.CC13sus4);
    public static final ChromaticChord D13sus4 = new ChromaticChord(ChromaticChordImmutable.D13sus4);
    public static final ChromaticChord DD13sus4 = new ChromaticChord(ChromaticChordImmutable.DD13sus4);
    public static final ChromaticChord E13sus4 = new ChromaticChord(ChromaticChordImmutable.E13sus4);
    public static final ChromaticChord F13sus4 = new ChromaticChord(ChromaticChordImmutable.F13sus4);
    public static final ChromaticChord FF13sus4 = new ChromaticChord(ChromaticChordImmutable.FF13sus4);
    public static final ChromaticChord G13sus4 = new ChromaticChord(ChromaticChordImmutable.G13sus4);
    public static final ChromaticChord GG13sus4 = new ChromaticChord(ChromaticChordImmutable.GG13sus4);
    public static final ChromaticChord A13sus4 = new ChromaticChord(ChromaticChordImmutable.A13sus4);
    public static final ChromaticChord AA13sus4 = new ChromaticChord(ChromaticChordImmutable.AA13sus4);
    public static final ChromaticChord B13sus4 = new ChromaticChord(ChromaticChordImmutable.B13sus4);

    // Treceava con quinta bemol
    public static final ChromaticChord C13b5 = new ChromaticChord(ChromaticChordImmutable.C13b5);
    public static final ChromaticChord CC13b5 = new ChromaticChord(ChromaticChordImmutable.CC13b5);
    public static final ChromaticChord D13b5 = new ChromaticChord(ChromaticChordImmutable.D13b5);
    public static final ChromaticChord DD13b5 = new ChromaticChord(ChromaticChordImmutable.DD13b5);
    public static final ChromaticChord E13b5 = new ChromaticChord(ChromaticChordImmutable.E13b5);
    public static final ChromaticChord F13b5 = new ChromaticChord(ChromaticChordImmutable.F13b5);
    public static final ChromaticChord FF13b5 = new ChromaticChord(ChromaticChordImmutable.FF13b5);
    public static final ChromaticChord G13b5 = new ChromaticChord(ChromaticChordImmutable.G13b5);
    public static final ChromaticChord GG13b5 = new ChromaticChord(ChromaticChordImmutable.GG13b5);
    public static final ChromaticChord A13b5 = new ChromaticChord(ChromaticChordImmutable.A13b5);
    public static final ChromaticChord AA13b5 = new ChromaticChord(ChromaticChordImmutable.AA13b5);
    public static final ChromaticChord B13b5 = new ChromaticChord(ChromaticChordImmutable.B13b5);

    // Treceava con quinta aumentada
    public static final ChromaticChord C13a5 = new ChromaticChord(ChromaticChordImmutable.C13a5);
    public static final ChromaticChord CC13a5 = new ChromaticChord(ChromaticChordImmutable.CC13a5);
    public static final ChromaticChord D13a5 = new ChromaticChord(ChromaticChordImmutable.D13a5);
    public static final ChromaticChord DD13a5 = new ChromaticChord(ChromaticChordImmutable.DD13a5);
    public static final ChromaticChord E13a5 = new ChromaticChord(ChromaticChordImmutable.E13a5);
    public static final ChromaticChord F13a5 = new ChromaticChord(ChromaticChordImmutable.F13a5);
    public static final ChromaticChord FF13a5 = new ChromaticChord(ChromaticChordImmutable.FF13a5);
    public static final ChromaticChord G13a5 = new ChromaticChord(ChromaticChordImmutable.G13a5);
    public static final ChromaticChord GG13a5 = new ChromaticChord(ChromaticChordImmutable.GG13a5);
    public static final ChromaticChord A13a5 = new ChromaticChord(ChromaticChordImmutable.A13a5);
    public static final ChromaticChord AA13a5 = new ChromaticChord(ChromaticChordImmutable.AA13a5);
    public static final ChromaticChord B13a5 = new ChromaticChord(ChromaticChordImmutable.B13a5);

    // Treceava con novena bemol
    public static final ChromaticChord C13b9 = new ChromaticChord(ChromaticChordImmutable.C13b9);
    public static final ChromaticChord CC13b9 = new ChromaticChord(ChromaticChordImmutable.CC13b9);
    public static final ChromaticChord D13b9 = new ChromaticChord(ChromaticChordImmutable.D13b9);
    public static final ChromaticChord DD13b9 = new ChromaticChord(ChromaticChordImmutable.DD13b9);
    public static final ChromaticChord E13b9 = new ChromaticChord(ChromaticChordImmutable.E13b9);
    public static final ChromaticChord F13b9 = new ChromaticChord(ChromaticChordImmutable.F13b9);
    public static final ChromaticChord FF13b9 = new ChromaticChord(ChromaticChordImmutable.FF13b9);
    public static final ChromaticChord G13b9 = new ChromaticChord(ChromaticChordImmutable.G13b9);
    public static final ChromaticChord GG13b9 = new ChromaticChord(ChromaticChordImmutable.GG13b9);
    public static final ChromaticChord A13b9 = new ChromaticChord(ChromaticChordImmutable.A13b9);
    public static final ChromaticChord AA13b9 = new ChromaticChord(ChromaticChordImmutable.AA13b9);
    public static final ChromaticChord B13b9 = new ChromaticChord(ChromaticChordImmutable.B13b9);

    // Treceava con novena aumentada
    public static final ChromaticChord C13a9 = new ChromaticChord(ChromaticChordImmutable.C13a9);
    public static final ChromaticChord CC13a9 = new ChromaticChord(ChromaticChordImmutable.CC13a9);
    public static final ChromaticChord D13a9 = new ChromaticChord(ChromaticChordImmutable.D13a9);
    public static final ChromaticChord DD13a9 = new ChromaticChord(ChromaticChordImmutable.DD13a9);
    public static final ChromaticChord E13a9 = new ChromaticChord(ChromaticChordImmutable.E13a9);
    public static final ChromaticChord F13a9 = new ChromaticChord(ChromaticChordImmutable.F13a9);
    public static final ChromaticChord FF13a9 = new ChromaticChord(ChromaticChordImmutable.FF13a9);
    public static final ChromaticChord G13a9 = new ChromaticChord(ChromaticChordImmutable.G13a9);
    public static final ChromaticChord GG13a9 = new ChromaticChord(ChromaticChordImmutable.GG13a9);
    public static final ChromaticChord A13a9 = new ChromaticChord(ChromaticChordImmutable.A13a9);
    public static final ChromaticChord AA13a9 = new ChromaticChord(ChromaticChordImmutable.AA13a9);
    public static final ChromaticChord B13a9 = new ChromaticChord(ChromaticChordImmutable.B13a9);

    // Treceava con quinta y novena bemoles
    public static final ChromaticChord C13b5b9 = new ChromaticChord(ChromaticChordImmutable.C13b5b9);
    public static final ChromaticChord CC13b5b9 = new ChromaticChord(ChromaticChordImmutable.CC13b5b9);
    public static final ChromaticChord D13b5b9 = new ChromaticChord(ChromaticChordImmutable.D13b5b9);
    public static final ChromaticChord DD13b5b9 = new ChromaticChord(ChromaticChordImmutable.DD13b5b9);
    public static final ChromaticChord E13b5b9 = new ChromaticChord(ChromaticChordImmutable.E13b5b9);
    public static final ChromaticChord F13b5b9 = new ChromaticChord(ChromaticChordImmutable.F13b5b9);
    public static final ChromaticChord FF13b5b9 = new ChromaticChord(ChromaticChordImmutable.FF13b5b9);
    public static final ChromaticChord G13b5b9 = new ChromaticChord(ChromaticChordImmutable.G13b5b9);
    public static final ChromaticChord GG13b5b9 = new ChromaticChord(ChromaticChordImmutable.GG13b5b9);
    public static final ChromaticChord A13b5b9 = new ChromaticChord(ChromaticChordImmutable.A13b5b9);
    public static final ChromaticChord AA13b5b9 = new ChromaticChord(ChromaticChordImmutable.AA13b5b9);
    public static final ChromaticChord B13b5b9 = new ChromaticChord(ChromaticChordImmutable.B13b5b9);

    // Treceava con quinta bemol y novena aumentada
    public static final ChromaticChord C13b5a9 = new ChromaticChord(ChromaticChordImmutable.C13b5a9);
    public static final ChromaticChord CC13b5a9 = new ChromaticChord(ChromaticChordImmutable.CC13b5a9);
    public static final ChromaticChord D13b5a9 = new ChromaticChord(ChromaticChordImmutable.D13b5a9);
    public static final ChromaticChord DD13b5a9 = new ChromaticChord(ChromaticChordImmutable.DD13b5a9);
    public static final ChromaticChord E13b5a9 = new ChromaticChord(ChromaticChordImmutable.E13b5a9);
    public static final ChromaticChord F13b5a9 = new ChromaticChord(ChromaticChordImmutable.F13b5a9);
    public static final ChromaticChord FF13b5a9 = new ChromaticChord(ChromaticChordImmutable.FF13b5a9);
    public static final ChromaticChord G13b5a9 = new ChromaticChord(ChromaticChordImmutable.G13b5a9);
    public static final ChromaticChord GG13b5a9 = new ChromaticChord(ChromaticChordImmutable.GG13b5a9);
    public static final ChromaticChord A13b5a9 = new ChromaticChord(ChromaticChordImmutable.A13b5a9);
    public static final ChromaticChord AA13b5a9 = new ChromaticChord(ChromaticChordImmutable.AA13b5a9);
    public static final ChromaticChord B13b5a9 = new ChromaticChord(ChromaticChordImmutable.B13b5a9);

    // Treceava con quinta aumentada y novena bemol
    public static final ChromaticChord C13a5b9 = new ChromaticChord(ChromaticChordImmutable.C13a5b9);
    public static final ChromaticChord CC13a5b9 = new ChromaticChord(ChromaticChordImmutable.CC13a5b9);
    public static final ChromaticChord D13a5b9 = new ChromaticChord(ChromaticChordImmutable.D13a5b9);
    public static final ChromaticChord DD13a5b9 = new ChromaticChord(ChromaticChordImmutable.DD13a5b9);
    public static final ChromaticChord E13a5b9 = new ChromaticChord(ChromaticChordImmutable.E13a5b9);
    public static final ChromaticChord F13a5b9 = new ChromaticChord(ChromaticChordImmutable.F13a5b9);
    public static final ChromaticChord FF13a5b9 = new ChromaticChord(ChromaticChordImmutable.FF13a5b9);
    public static final ChromaticChord G13a5b9 = new ChromaticChord(ChromaticChordImmutable.G13a5b9);
    public static final ChromaticChord GG13a5b9 = new ChromaticChord(ChromaticChordImmutable.GG13a5b9);
    public static final ChromaticChord A13a5b9 = new ChromaticChord(ChromaticChordImmutable.A13a5b9);
    public static final ChromaticChord AA13a5b9 = new ChromaticChord(ChromaticChordImmutable.AA13a5b9);
    public static final ChromaticChord B13a5b9 = new ChromaticChord(ChromaticChordImmutable.B13a5b9);

    // Treceava con quinta y novena aumentadas
    public static final ChromaticChord C13a5a9 = new ChromaticChord(ChromaticChordImmutable.C13a5a9);
    public static final ChromaticChord CC13a5a9 = new ChromaticChord(ChromaticChordImmutable.CC13a5a9);
    public static final ChromaticChord D13a5a9 = new ChromaticChord(ChromaticChordImmutable.D13a5a9);
    public static final ChromaticChord DD13a5a9 = new ChromaticChord(ChromaticChordImmutable.DD13a5a9);
    public static final ChromaticChord E13a5a9 = new ChromaticChord(ChromaticChordImmutable.E13a5a9);
    public static final ChromaticChord F13a5a9 = new ChromaticChord(ChromaticChordImmutable.F13a5a9);
    public static final ChromaticChord FF13a5a9 = new ChromaticChord(ChromaticChordImmutable.FF13a5a9);
    public static final ChromaticChord G13a5a9 = new ChromaticChord(ChromaticChordImmutable.G13a5a9);
    public static final ChromaticChord GG13a5a9 = new ChromaticChord(ChromaticChordImmutable.GG13a5a9);
    public static final ChromaticChord A13a5a9 = new ChromaticChord(ChromaticChordImmutable.A13a5a9);
    public static final ChromaticChord AA13a5a9 = new ChromaticChord(ChromaticChordImmutable.AA13a5a9);
    public static final ChromaticChord B13a5a9 = new ChromaticChord(ChromaticChordImmutable.B13a5a9);

    // Treceava mayor
    public static final ChromaticChord CMaj13 = new ChromaticChord(ChromaticChordImmutable.CMaj13);
    public static final ChromaticChord CCMaj13 = new ChromaticChord(ChromaticChordImmutable.CCMaj13);
    public static final ChromaticChord DMaj13 = new ChromaticChord(ChromaticChordImmutable.DMaj13);
    public static final ChromaticChord DDMaj13 = new ChromaticChord(ChromaticChordImmutable.DDMaj13);
    public static final ChromaticChord EMaj13 = new ChromaticChord(ChromaticChordImmutable.EMaj13);
    public static final ChromaticChord FMaj13 = new ChromaticChord(ChromaticChordImmutable.FMaj13);
    public static final ChromaticChord FFMaj13 = new ChromaticChord(ChromaticChordImmutable.FFMaj13);
    public static final ChromaticChord GMaj13 = new ChromaticChord(ChromaticChordImmutable.GMaj13);
    public static final ChromaticChord GGMaj13 = new ChromaticChord(ChromaticChordImmutable.GGMaj13);
    public static final ChromaticChord AMaj13 = new ChromaticChord(ChromaticChordImmutable.AMaj13);
    public static final ChromaticChord AAMaj13 = new ChromaticChord(ChromaticChordImmutable.AAMaj13);
    public static final ChromaticChord BMaj13 = new ChromaticChord(ChromaticChordImmutable.BMaj13);

    // Menor treceava mayor
    public static final ChromaticChord CmMaj13 = new ChromaticChord(ChromaticChordImmutable.CmMaj13);
    public static final ChromaticChord CCmMaj13 = new ChromaticChord(ChromaticChordImmutable.CCmMaj13);
    public static final ChromaticChord DmMaj13 = new ChromaticChord(ChromaticChordImmutable.DmMaj13);
    public static final ChromaticChord DDmMaj13 = new ChromaticChord(ChromaticChordImmutable.DDmMaj13);
    public static final ChromaticChord EmMaj13 = new ChromaticChord(ChromaticChordImmutable.EmMaj13);
    public static final ChromaticChord FmMaj13 = new ChromaticChord(ChromaticChordImmutable.FmMaj13);
    public static final ChromaticChord FFmMaj13 = new ChromaticChord(ChromaticChordImmutable.FFmMaj13);
    public static final ChromaticChord GmMaj13 = new ChromaticChord(ChromaticChordImmutable.GmMaj13);
    public static final ChromaticChord GGmMaj13 = new ChromaticChord(ChromaticChordImmutable.GGmMaj13);
    public static final ChromaticChord AmMaj13 = new ChromaticChord(ChromaticChordImmutable.AmMaj13);
    public static final ChromaticChord AAmMaj13 = new ChromaticChord(ChromaticChordImmutable.AAmMaj13);
    public static final ChromaticChord BmMaj13 = new ChromaticChord(ChromaticChordImmutable.BmMaj13);

    // Treceava mayor con quinta bemol
    public static final ChromaticChord CMaj13b5 = new ChromaticChord(ChromaticChordImmutable.CMaj13b5);
    public static final ChromaticChord CCMaj13b5 = new ChromaticChord(ChromaticChordImmutable.CCMaj13b5);
    public static final ChromaticChord DMaj13b5 = new ChromaticChord(ChromaticChordImmutable.DMaj13b5);
    public static final ChromaticChord DDMaj13b5 = new ChromaticChord(ChromaticChordImmutable.DDMaj13b5);
    public static final ChromaticChord EMaj13b5 = new ChromaticChord(ChromaticChordImmutable.EMaj13b5);
    public static final ChromaticChord FMaj13b5 = new ChromaticChord(ChromaticChordImmutable.FMaj13b5);
    public static final ChromaticChord FFMaj13b5 = new ChromaticChord(ChromaticChordImmutable.FFMaj13b5);
    public static final ChromaticChord GMaj13b5 = new ChromaticChord(ChromaticChordImmutable.GMaj13b5);
    public static final ChromaticChord GGMaj13b5 = new ChromaticChord(ChromaticChordImmutable.GGMaj13b5);
    public static final ChromaticChord AMaj13b5 = new ChromaticChord(ChromaticChordImmutable.AMaj13b5);
    public static final ChromaticChord AAMaj13b5 = new ChromaticChord(ChromaticChordImmutable.AAMaj13b5);
    public static final ChromaticChord BMaj13b5 = new ChromaticChord(ChromaticChordImmutable.BMaj13b5);

    // Treceava mayor con quinta aumentada
    public static final ChromaticChord CMaj13a5 = new ChromaticChord(ChromaticChordImmutable.CMaj13a5);
    public static final ChromaticChord CCMaj13a5 = new ChromaticChord(ChromaticChordImmutable.CCMaj13a5);
    public static final ChromaticChord DMaj13a5 = new ChromaticChord(ChromaticChordImmutable.DMaj13a5);
    public static final ChromaticChord DDMaj13a5 = new ChromaticChord(ChromaticChordImmutable.DDMaj13a5);
    public static final ChromaticChord EMaj13a5 = new ChromaticChord(ChromaticChordImmutable.EMaj13a5);
    public static final ChromaticChord FMaj13a5 = new ChromaticChord(ChromaticChordImmutable.FMaj13a5);
    public static final ChromaticChord FFMaj13a5 = new ChromaticChord(ChromaticChordImmutable.FFMaj13a5);
    public static final ChromaticChord GMaj13a5 = new ChromaticChord(ChromaticChordImmutable.GMaj13a5);
    public static final ChromaticChord GGMaj13a5 = new ChromaticChord(ChromaticChordImmutable.GGMaj13a5);
    public static final ChromaticChord AMaj13a5 = new ChromaticChord(ChromaticChordImmutable.AMaj13a5);
    public static final ChromaticChord AAMaj13a5 = new ChromaticChord(ChromaticChordImmutable.AAMaj13a5);
    public static final ChromaticChord BMaj13a5 = new ChromaticChord(ChromaticChordImmutable.BMaj13a5);

    // Treceava mayor con novena bemol
    public static final ChromaticChord CMaj13b9 = new ChromaticChord(ChromaticChordImmutable.CMaj13b9);
    public static final ChromaticChord CCMaj13b9 = new ChromaticChord(ChromaticChordImmutable.CCMaj13b9);
    public static final ChromaticChord DMaj13b9 = new ChromaticChord(ChromaticChordImmutable.DMaj13b9);
    public static final ChromaticChord DDMaj13b9 = new ChromaticChord(ChromaticChordImmutable.DDMaj13b9);
    public static final ChromaticChord EMaj13b9 = new ChromaticChord(ChromaticChordImmutable.EMaj13b9);
    public static final ChromaticChord FMaj13b9 = new ChromaticChord(ChromaticChordImmutable.FMaj13b9);
    public static final ChromaticChord FFMaj13b9 = new ChromaticChord(ChromaticChordImmutable.FFMaj13b9);
    public static final ChromaticChord GMaj13b9 = new ChromaticChord(ChromaticChordImmutable.GMaj13b9);
    public static final ChromaticChord GGMaj13b9 = new ChromaticChord(ChromaticChordImmutable.GGMaj13b9);
    public static final ChromaticChord AMaj13b9 = new ChromaticChord(ChromaticChordImmutable.AMaj13b9);
    public static final ChromaticChord AAMaj13b9 = new ChromaticChord(ChromaticChordImmutable.AAMaj13b9);
    public static final ChromaticChord BMaj13b9 = new ChromaticChord(ChromaticChordImmutable.BMaj13b9);

    // Treceava mayor con novena aumentada
    public static final ChromaticChord CMaj13a9 = new ChromaticChord(ChromaticChordImmutable.CMaj13a9);
    public static final ChromaticChord CCMaj13a9 = new ChromaticChord(ChromaticChordImmutable.CCMaj13a9);
    public static final ChromaticChord DMaj13a9 = new ChromaticChord(ChromaticChordImmutable.DMaj13a9);
    public static final ChromaticChord DDMaj13a9 = new ChromaticChord(ChromaticChordImmutable.DDMaj13a9);
    public static final ChromaticChord EMaj13a9 = new ChromaticChord(ChromaticChordImmutable.EMaj13a9);
    public static final ChromaticChord FMaj13a9 = new ChromaticChord(ChromaticChordImmutable.FMaj13a9);
    public static final ChromaticChord FFMaj13a9 = new ChromaticChord(ChromaticChordImmutable.FFMaj13a9);
    public static final ChromaticChord GMaj13a9 = new ChromaticChord(ChromaticChordImmutable.GMaj13a9);
    public static final ChromaticChord GGMaj13a9 = new ChromaticChord(ChromaticChordImmutable.GGMaj13a9);
    public static final ChromaticChord AMaj13a9 = new ChromaticChord(ChromaticChordImmutable.AMaj13a9);
    public static final ChromaticChord AAMaj13a9 = new ChromaticChord(ChromaticChordImmutable.AAMaj13a9);
    public static final ChromaticChord BMaj13a9 = new ChromaticChord(ChromaticChordImmutable.BMaj13a9);

    // Treceava mayor con quinta y novena bemoles
    public static final ChromaticChord CMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.CMaj13b5b9);
    public static final ChromaticChord CCMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.CCMaj13b5b9);
    public static final ChromaticChord DMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.DMaj13b5b9);
    public static final ChromaticChord DDMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.DDMaj13b5b9);
    public static final ChromaticChord EMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.EMaj13b5b9);
    public static final ChromaticChord FMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.FMaj13b5b9);
    public static final ChromaticChord FFMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.FFMaj13b5b9);
    public static final ChromaticChord GMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.GMaj13b5b9);
    public static final ChromaticChord GGMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.GGMaj13b5b9);
    public static final ChromaticChord AMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.AMaj13b5b9);
    public static final ChromaticChord AAMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.AAMaj13b5b9);
    public static final ChromaticChord BMaj13b5b9 = new ChromaticChord(ChromaticChordImmutable.BMaj13b5b9);

    // Treceava mayor con novena aumentada
    public static final ChromaticChord CMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.CMaj13b5a9);
    public static final ChromaticChord CCMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.CCMaj13b5a9);
    public static final ChromaticChord DMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.DMaj13b5a9);
    public static final ChromaticChord DDMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.DDMaj13b5a9);
    public static final ChromaticChord EMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.EMaj13b5a9);
    public static final ChromaticChord FMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.FMaj13b5a9);
    public static final ChromaticChord FFMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.FFMaj13b5a9);
    public static final ChromaticChord GMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.GMaj13b5a9);
    public static final ChromaticChord GGMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.GGMaj13b5a9);
    public static final ChromaticChord AMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.AMaj13b5a9);
    public static final ChromaticChord AAMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.AAMaj13b5a9);
    public static final ChromaticChord BMaj13b5a9 = new ChromaticChord(ChromaticChordImmutable.BMaj13b5a9);

    // Treceava mayor con quinta aumentada y novena bemol
    public static final ChromaticChord CMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.CMaj13a5b9);
    public static final ChromaticChord CCMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.CCMaj13a5b9);
    public static final ChromaticChord DMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.DMaj13a5b9);
    public static final ChromaticChord DDMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.DDMaj13a5b9);
    public static final ChromaticChord EMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.EMaj13a5b9);
    public static final ChromaticChord FMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.FMaj13a5b9);
    public static final ChromaticChord FFMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.FFMaj13a5b9);
    public static final ChromaticChord GMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.GMaj13a5b9);
    public static final ChromaticChord GGMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.GGMaj13a5b9);
    public static final ChromaticChord AMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.AMaj13a5b9);
    public static final ChromaticChord AAMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.AAMaj13a5b9);
    public static final ChromaticChord BMaj13a5b9 = new ChromaticChord(ChromaticChordImmutable.BMaj13a5b9);

    // Treceava mayor con quinta y novena aumentadas
    public static final ChromaticChord CMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.CMaj13a5a9);
    public static final ChromaticChord CCMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.CCMaj13a5a9);
    public static final ChromaticChord DMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.DMaj13a5a9);
    public static final ChromaticChord DDMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.DDMaj13a5a9);
    public static final ChromaticChord EMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.EMaj13a5a9);
    public static final ChromaticChord FMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.FMaj13a5a9);
    public static final ChromaticChord FFMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.FFMaj13a5a9);
    public static final ChromaticChord GMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.GMaj13a5a9);
    public static final ChromaticChord GGMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.GGMaj13a5a9);
    public static final ChromaticChord AMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.AMaj13a5a9);
    public static final ChromaticChord AAMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.AAMaj13a5a9);
    public static final ChromaticChord BMaj13a5a9 = new ChromaticChord(ChromaticChordImmutable.BMaj13a5a9);

    // Menor treceava
    public static final ChromaticChord Cm13omit11 = new ChromaticChord(ChromaticChordImmutable.Cm13omit11);
    public static final ChromaticChord CCm13omit11 = new ChromaticChord(ChromaticChordImmutable.CCm13omit11);
    public static final ChromaticChord Dm13omit11 = new ChromaticChord(ChromaticChordImmutable.Dm13omit11);
    public static final ChromaticChord DDm13omit11 = new ChromaticChord(ChromaticChordImmutable.DDm13omit11);
    public static final ChromaticChord Em13omit11 = new ChromaticChord(ChromaticChordImmutable.Em13omit11);
    public static final ChromaticChord Fm13omit11 = new ChromaticChord(ChromaticChordImmutable.Fm13omit11);
    public static final ChromaticChord FFm13omit11 = new ChromaticChord(ChromaticChordImmutable.FFm13omit11);
    public static final ChromaticChord Gm13omit11 = new ChromaticChord(ChromaticChordImmutable.Gm13omit11);
    public static final ChromaticChord GGm13omit11 = new ChromaticChord(ChromaticChordImmutable.GGm13omit11);
    public static final ChromaticChord Am13omit11 = new ChromaticChord(ChromaticChordImmutable.Am13omit11);
    public static final ChromaticChord AAm13omit11 = new ChromaticChord(ChromaticChordImmutable.AAm13omit11);
    public static final ChromaticChord Bm13omit11 = new ChromaticChord(ChromaticChordImmutable.Bm13omit11);

    // Treceava con cuarta suspendida
    public static final ChromaticChord C13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.C13sus4omit11);
    public static final ChromaticChord CC13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.CC13sus4omit11);
    public static final ChromaticChord D13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.D13sus4omit11);
    public static final ChromaticChord DD13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.DD13sus4omit11);
    public static final ChromaticChord E13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.E13sus4omit11);
    public static final ChromaticChord F13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.F13sus4omit11);
    public static final ChromaticChord FF13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.FF13sus4omit11);
    public static final ChromaticChord G13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.G13sus4omit11);
    public static final ChromaticChord GG13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.GG13sus4omit11);
    public static final ChromaticChord A13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.A13sus4omit11);
    public static final ChromaticChord AA13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.AA13sus4omit11);
    public static final ChromaticChord B13sus4omit11 = new ChromaticChord(ChromaticChordImmutable.B13sus4omit11);

    // Treceava con quinta bemol
    public static final ChromaticChord C13b5omit11 = new ChromaticChord(ChromaticChordImmutable.C13b5omit11);
    public static final ChromaticChord CC13b5omit11 = new ChromaticChord(ChromaticChordImmutable.CC13b5omit11);
    public static final ChromaticChord D13b5omit11 = new ChromaticChord(ChromaticChordImmutable.D13b5omit11);
    public static final ChromaticChord DD13b5omit11 = new ChromaticChord(ChromaticChordImmutable.DD13b5omit11);
    public static final ChromaticChord E13b5omit11 = new ChromaticChord(ChromaticChordImmutable.E13b5omit11);
    public static final ChromaticChord F13b5omit11 = new ChromaticChord(ChromaticChordImmutable.F13b5omit11);
    public static final ChromaticChord FF13b5omit11 = new ChromaticChord(ChromaticChordImmutable.FF13b5omit11);
    public static final ChromaticChord G13b5omit11 = new ChromaticChord(ChromaticChordImmutable.G13b5omit11);
    public static final ChromaticChord GG13b5omit11 = new ChromaticChord(ChromaticChordImmutable.GG13b5omit11);
    public static final ChromaticChord A13b5omit11 = new ChromaticChord(ChromaticChordImmutable.A13b5omit11);
    public static final ChromaticChord AA13b5omit11 = new ChromaticChord(ChromaticChordImmutable.AA13b5omit11);
    public static final ChromaticChord B13b5omit11 = new ChromaticChord(ChromaticChordImmutable.B13b5omit11);

    // Treceava con quinta aumentada
    public static final ChromaticChord C13a5omit11 = new ChromaticChord(ChromaticChordImmutable.C13a5omit11);
    public static final ChromaticChord CC13a5omit11 = new ChromaticChord(ChromaticChordImmutable.CC13a5omit11);
    public static final ChromaticChord D13a5omit11 = new ChromaticChord(ChromaticChordImmutable.D13a5omit11);
    public static final ChromaticChord DD13a5omit11 = new ChromaticChord(ChromaticChordImmutable.DD13a5omit11);
    public static final ChromaticChord E13a5omit11 = new ChromaticChord(ChromaticChordImmutable.E13a5omit11);
    public static final ChromaticChord F13a5omit11 = new ChromaticChord(ChromaticChordImmutable.F13a5omit11);
    public static final ChromaticChord FF13a5omit11 = new ChromaticChord(ChromaticChordImmutable.FF13a5omit11);
    public static final ChromaticChord G13a5omit11 = new ChromaticChord(ChromaticChordImmutable.G13a5omit11);
    public static final ChromaticChord GG13a5omit11 = new ChromaticChord(ChromaticChordImmutable.GG13a5omit11);
    public static final ChromaticChord A13a5omit11 = new ChromaticChord(ChromaticChordImmutable.A13a5omit11);
    public static final ChromaticChord AA13a5omit11 = new ChromaticChord(ChromaticChordImmutable.AA13a5omit11);
    public static final ChromaticChord B13a5omit11 = new ChromaticChord(ChromaticChordImmutable.B13a5omit11);

    // Treceava con novena bemol
    public static final ChromaticChord C13b9omit11 = new ChromaticChord(ChromaticChordImmutable.C13b9omit11);
    public static final ChromaticChord CC13b9omit11 = new ChromaticChord(ChromaticChordImmutable.CC13b9omit11);
    public static final ChromaticChord D13b9omit11 = new ChromaticChord(ChromaticChordImmutable.D13b9omit11);
    public static final ChromaticChord DD13b9omit11 = new ChromaticChord(ChromaticChordImmutable.DD13b9omit11);
    public static final ChromaticChord E13b9omit11 = new ChromaticChord(ChromaticChordImmutable.E13b9omit11);
    public static final ChromaticChord F13b9omit11 = new ChromaticChord(ChromaticChordImmutable.F13b9omit11);
    public static final ChromaticChord FF13b9omit11 = new ChromaticChord(ChromaticChordImmutable.FF13b9omit11);
    public static final ChromaticChord G13b9omit11 = new ChromaticChord(ChromaticChordImmutable.G13b9omit11);
    public static final ChromaticChord GG13b9omit11 = new ChromaticChord(ChromaticChordImmutable.GG13b9omit11);
    public static final ChromaticChord A13b9omit11 = new ChromaticChord(ChromaticChordImmutable.A13b9omit11);
    public static final ChromaticChord AA13b9omit11 = new ChromaticChord(ChromaticChordImmutable.AA13b9omit11);
    public static final ChromaticChord B13b9omit11 = new ChromaticChord(ChromaticChordImmutable.B13b9omit11);

    // Treceava con novena aumentada
    public static final ChromaticChord C13a9omit11 = new ChromaticChord(ChromaticChordImmutable.C13a9omit11);
    public static final ChromaticChord CC13a9omit11 = new ChromaticChord(ChromaticChordImmutable.CC13a9omit11);
    public static final ChromaticChord D13a9omit11 = new ChromaticChord(ChromaticChordImmutable.D13a9omit11);
    public static final ChromaticChord DD13a9omit11 = new ChromaticChord(ChromaticChordImmutable.DD13a9omit11);
    public static final ChromaticChord E13a9omit11 = new ChromaticChord(ChromaticChordImmutable.E13a9omit11);
    public static final ChromaticChord F13a9omit11 = new ChromaticChord(ChromaticChordImmutable.F13a9omit11);
    public static final ChromaticChord FF13a9omit11 = new ChromaticChord(ChromaticChordImmutable.FF13a9omit11);
    public static final ChromaticChord G13a9omit11 = new ChromaticChord(ChromaticChordImmutable.G13a9omit11);
    public static final ChromaticChord GG13a9omit11 = new ChromaticChord(ChromaticChordImmutable.GG13a9omit11);
    public static final ChromaticChord A13a9omit11 = new ChromaticChord(ChromaticChordImmutable.A13a9omit11);
    public static final ChromaticChord AA13a9omit11 = new ChromaticChord(ChromaticChordImmutable.AA13a9omit11);
    public static final ChromaticChord B13a9omit11 = new ChromaticChord(ChromaticChordImmutable.B13a9omit11);

    // Treceava con quinta y novena bemoles
    public static final ChromaticChord C13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.C13b5b9omit11);
    public static final ChromaticChord CC13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.CC13b5b9omit11);
    public static final ChromaticChord D13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.D13b5b9omit11);
    public static final ChromaticChord DD13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.DD13b5b9omit11);
    public static final ChromaticChord E13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.E13b5b9omit11);
    public static final ChromaticChord F13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.F13b5b9omit11);
    public static final ChromaticChord FF13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.FF13b5b9omit11);
    public static final ChromaticChord G13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.G13b5b9omit11);
    public static final ChromaticChord GG13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.GG13b5b9omit11);
    public static final ChromaticChord A13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.A13b5b9omit11);
    public static final ChromaticChord AA13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.AA13b5b9omit11);
    public static final ChromaticChord B13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.B13b5b9omit11);

    // Treceava con quinta bemol y novena aumentada
    public static final ChromaticChord C13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.C13b5a9omit11);
    public static final ChromaticChord CC13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.CC13b5a9omit11);
    public static final ChromaticChord D13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.D13b5a9omit11);
    public static final ChromaticChord DD13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.DD13b5a9omit11);
    public static final ChromaticChord E13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.E13b5a9omit11);
    public static final ChromaticChord F13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.F13b5a9omit11);
    public static final ChromaticChord FF13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.FF13b5a9omit11);
    public static final ChromaticChord G13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.G13b5a9omit11);
    public static final ChromaticChord GG13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.GG13b5a9omit11);
    public static final ChromaticChord A13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.A13b5a9omit11);
    public static final ChromaticChord AA13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.AA13b5a9omit11);
    public static final ChromaticChord B13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.B13b5a9omit11);

    // Treceava con quinta aumentada y novena bemol
    public static final ChromaticChord C13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.C13a5b9omit11);
    public static final ChromaticChord CC13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.CC13a5b9omit11);
    public static final ChromaticChord D13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.D13a5b9omit11);
    public static final ChromaticChord DD13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.DD13a5b9omit11);
    public static final ChromaticChord E13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.E13a5b9omit11);
    public static final ChromaticChord F13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.F13a5b9omit11);
    public static final ChromaticChord FF13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.FF13a5b9omit11);
    public static final ChromaticChord G13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.G13a5b9omit11);
    public static final ChromaticChord GG13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.GG13a5b9omit11);
    public static final ChromaticChord A13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.A13a5b9omit11);
    public static final ChromaticChord AA13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.AA13a5b9omit11);
    public static final ChromaticChord B13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.B13a5b9omit11);

    // Treceava con quinta y novena aumentadas
    public static final ChromaticChord C13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.C13a5a9omit11);
    public static final ChromaticChord CC13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.CC13a5a9omit11);
    public static final ChromaticChord D13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.D13a5a9omit11);
    public static final ChromaticChord DD13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.DD13a5a9omit11);
    public static final ChromaticChord E13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.E13a5a9omit11);
    public static final ChromaticChord F13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.F13a5a9omit11);
    public static final ChromaticChord FF13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.FF13a5a9omit11);
    public static final ChromaticChord G13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.G13a5a9omit11);
    public static final ChromaticChord GG13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.GG13a5a9omit11);
    public static final ChromaticChord A13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.A13a5a9omit11);
    public static final ChromaticChord AA13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.AA13a5a9omit11);
    public static final ChromaticChord B13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.B13a5a9omit11);

    // Treceava mayor
    public static final ChromaticChord CMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13omit11);
    public static final ChromaticChord CCMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13omit11);
    public static final ChromaticChord DMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13omit11);
    public static final ChromaticChord DDMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13omit11);
    public static final ChromaticChord EMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13omit11);
    public static final ChromaticChord FMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13omit11);
    public static final ChromaticChord FFMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13omit11);
    public static final ChromaticChord GMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13omit11);
    public static final ChromaticChord GGMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13omit11);
    public static final ChromaticChord AMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13omit11);
    public static final ChromaticChord AAMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13omit11);
    public static final ChromaticChord BMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13omit11);

    // Menor treceava mayor
    public static final ChromaticChord CmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.CmMaj13omit11);
    public static final ChromaticChord CCmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.CCmMaj13omit11);
    public static final ChromaticChord DmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.DmMaj13omit11);
    public static final ChromaticChord DDmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.DDmMaj13omit11);
    public static final ChromaticChord EmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.EmMaj13omit11);
    public static final ChromaticChord FmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.FmMaj13omit11);
    public static final ChromaticChord FFmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.FFmMaj13omit11);
    public static final ChromaticChord GmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.GmMaj13omit11);
    public static final ChromaticChord GGmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.GGmMaj13omit11);
    public static final ChromaticChord AmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.AmMaj13omit11);
    public static final ChromaticChord AAmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.AAmMaj13omit11);
    public static final ChromaticChord BmMaj13omit11 = new ChromaticChord(ChromaticChordImmutable.BmMaj13omit11);

    // Treceava mayor con quinta bemol
    public static final ChromaticChord CMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13b5omit11);
    public static final ChromaticChord CCMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13b5omit11);
    public static final ChromaticChord DMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13b5omit11);
    public static final ChromaticChord DDMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13b5omit11);
    public static final ChromaticChord EMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13b5omit11);
    public static final ChromaticChord FMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13b5omit11);
    public static final ChromaticChord FFMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13b5omit11);
    public static final ChromaticChord GMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13b5omit11);
    public static final ChromaticChord GGMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13b5omit11);
    public static final ChromaticChord AMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13b5omit11);
    public static final ChromaticChord AAMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13b5omit11);
    public static final ChromaticChord BMaj13b5omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13b5omit11);

    // Treceava mayor con quinta aumentada
    public static final ChromaticChord CMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13a5omit11);
    public static final ChromaticChord CCMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13a5omit11);
    public static final ChromaticChord DMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13a5omit11);
    public static final ChromaticChord DDMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13a5omit11);
    public static final ChromaticChord EMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13a5omit11);
    public static final ChromaticChord FMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13a5omit11);
    public static final ChromaticChord FFMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13a5omit11);
    public static final ChromaticChord GMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13a5omit11);
    public static final ChromaticChord GGMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13a5omit11);
    public static final ChromaticChord AMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13a5omit11);
    public static final ChromaticChord AAMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13a5omit11);
    public static final ChromaticChord BMaj13a5omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13a5omit11);

    // Treceava mayor con novena bemol
    public static final ChromaticChord CMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13b9omit11);
    public static final ChromaticChord CCMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13b9omit11);
    public static final ChromaticChord DMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13b9omit11);
    public static final ChromaticChord DDMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13b9omit11);
    public static final ChromaticChord EMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13b9omit11);
    public static final ChromaticChord FMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13b9omit11);
    public static final ChromaticChord FFMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13b9omit11);
    public static final ChromaticChord GMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13b9omit11);
    public static final ChromaticChord GGMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13b9omit11);
    public static final ChromaticChord AMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13b9omit11);
    public static final ChromaticChord AAMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13b9omit11);
    public static final ChromaticChord BMaj13b9omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13b9omit11);

    // Treceava mayor con novena aumentada
    public static final ChromaticChord CMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13a9omit11);
    public static final ChromaticChord CCMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13a9omit11);
    public static final ChromaticChord DMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13a9omit11);
    public static final ChromaticChord DDMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13a9omit11);
    public static final ChromaticChord EMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13a9omit11);
    public static final ChromaticChord FMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13a9omit11);
    public static final ChromaticChord FFMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13a9omit11);
    public static final ChromaticChord GMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13a9omit11);
    public static final ChromaticChord GGMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13a9omit11);
    public static final ChromaticChord AMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13a9omit11);
    public static final ChromaticChord AAMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13a9omit11);
    public static final ChromaticChord BMaj13a9omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13a9omit11);

    // Treceava mayor con quinta y novena bemoles
    public static final ChromaticChord CMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13b5b9omit11);
    public static final ChromaticChord CCMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13b5b9omit11);
    public static final ChromaticChord DMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13b5b9omit11);
    public static final ChromaticChord DDMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13b5b9omit11);
    public static final ChromaticChord EMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13b5b9omit11);
    public static final ChromaticChord FMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13b5b9omit11);
    public static final ChromaticChord FFMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13b5b9omit11);
    public static final ChromaticChord GMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13b5b9omit11);
    public static final ChromaticChord GGMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13b5b9omit11);
    public static final ChromaticChord AMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13b5b9omit11);
    public static final ChromaticChord AAMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13b5b9omit11);
    public static final ChromaticChord BMaj13b5b9omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13b5b9omit11);

    // Treceava mayor con novena aumentada
    public static final ChromaticChord CMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13b5a9omit11);
    public static final ChromaticChord CCMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13b5a9omit11);
    public static final ChromaticChord DMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13b5a9omit11);
    public static final ChromaticChord DDMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13b5a9omit11);
    public static final ChromaticChord EMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13b5a9omit11);
    public static final ChromaticChord FMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13b5a9omit11);
    public static final ChromaticChord FFMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13b5a9omit11);
    public static final ChromaticChord GMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13b5a9omit11);
    public static final ChromaticChord GGMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13b5a9omit11);
    public static final ChromaticChord AMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13b5a9omit11);
    public static final ChromaticChord AAMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13b5a9omit11);
    public static final ChromaticChord BMaj13b5a9omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13b5a9omit11);

    // Treceava mayor con quinta aumentada y novena bemol
    public static final ChromaticChord CMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13a5b9omit11);
    public static final ChromaticChord CCMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13a5b9omit11);
    public static final ChromaticChord DMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13a5b9omit11);
    public static final ChromaticChord DDMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13a5b9omit11);
    public static final ChromaticChord EMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13a5b9omit11);
    public static final ChromaticChord FMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13a5b9omit11);
    public static final ChromaticChord FFMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13a5b9omit11);
    public static final ChromaticChord GMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13a5b9omit11);
    public static final ChromaticChord GGMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13a5b9omit11);
    public static final ChromaticChord AMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13a5b9omit11);
    public static final ChromaticChord AAMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13a5b9omit11);
    public static final ChromaticChord BMaj13a5b9omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13a5b9omit11);

    // Treceava mayor con quinta y novena aumentadas
    public static final ChromaticChord CMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.CMaj13a5a9omit11);
    public static final ChromaticChord CCMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.CCMaj13a5a9omit11);
    public static final ChromaticChord DMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.DMaj13a5a9omit11);
    public static final ChromaticChord DDMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.DDMaj13a5a9omit11);
    public static final ChromaticChord EMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.EMaj13a5a9omit11);
    public static final ChromaticChord FMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.FMaj13a5a9omit11);
    public static final ChromaticChord FFMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.FFMaj13a5a9omit11);
    public static final ChromaticChord GMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.GMaj13a5a9omit11);
    public static final ChromaticChord GGMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.GGMaj13a5a9omit11);
    public static final ChromaticChord AMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.AMaj13a5a9omit11);
    public static final ChromaticChord AAMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.AAMaj13a5a9omit11);
    public static final ChromaticChord BMaj13a5a9omit11 = new ChromaticChord(ChromaticChordImmutable.BMaj13a5a9omit11);

    public static final ChromaticChord Csusa4 = new ChromaticChord(ChromaticChordImmutable.Csusa4);
    public static final ChromaticChord CCsusa4 = new ChromaticChord(ChromaticChordImmutable.CCsusa4);
    public static final ChromaticChord Dsusa4 = new ChromaticChord(ChromaticChordImmutable.Dsusa4);
    public static final ChromaticChord DDsusa4 = new ChromaticChord(ChromaticChordImmutable.DDsusa4);
    public static final ChromaticChord Esusa4 = new ChromaticChord(ChromaticChordImmutable.Esusa4);
    public static final ChromaticChord Fsusa4 = new ChromaticChord(ChromaticChordImmutable.Fsusa4);
    public static final ChromaticChord FFsusa4 = new ChromaticChord(ChromaticChordImmutable.FFsusa4);
    public static final ChromaticChord Gsusa4 = new ChromaticChord(ChromaticChordImmutable.Gsusa4);
    public static final ChromaticChord GGsusa4 = new ChromaticChord(ChromaticChordImmutable.GGsusa4);
    public static final ChromaticChord Asusa4 = new ChromaticChord(ChromaticChordImmutable.Asusa4);
    public static final ChromaticChord AAsusa4 = new ChromaticChord(ChromaticChordImmutable.AAsusa4);
    public static final ChromaticChord Bsusa4 = new ChromaticChord(ChromaticChordImmutable.Bsusa4);

    public static final ChromaticChord Csusb2 = new ChromaticChord(ChromaticChordImmutable.Csusb2);
    public static final ChromaticChord CCsusb2 = new ChromaticChord(ChromaticChordImmutable.CCsusb2);
    public static final ChromaticChord Dsusb2 = new ChromaticChord(ChromaticChordImmutable.Dsusb2);
    public static final ChromaticChord DDsusb2 = new ChromaticChord(ChromaticChordImmutable.DDsusb2);
    public static final ChromaticChord Esusb2 = new ChromaticChord(ChromaticChordImmutable.Esusb2);
    public static final ChromaticChord Fsusb2 = new ChromaticChord(ChromaticChordImmutable.Fsusb2);
    public static final ChromaticChord FFsusb2 = new ChromaticChord(ChromaticChordImmutable.FFsusb2);
    public static final ChromaticChord Gsusb2 = new ChromaticChord(ChromaticChordImmutable.Gsusb2);
    public static final ChromaticChord GGsusb2 = new ChromaticChord(ChromaticChordImmutable.GGsusb2);
    public static final ChromaticChord Asusb2 = new ChromaticChord(ChromaticChordImmutable.Asusb2);
    public static final ChromaticChord AAsusb2 = new ChromaticChord(ChromaticChordImmutable.AAsusb2);
    public static final ChromaticChord Bsusb2 = new ChromaticChord(ChromaticChordImmutable.Bsusb2);

    public static final ChromaticChord Csusb2b5 = new ChromaticChord(ChromaticChordImmutable.Csusb2b5);
    public static final ChromaticChord CCsusb2b5 = new ChromaticChord(ChromaticChordImmutable.CCsusb2b5);
    public static final ChromaticChord Dsusb2b5 = new ChromaticChord(ChromaticChordImmutable.Dsusb2b5);
    public static final ChromaticChord DDsusb2b5 = new ChromaticChord(ChromaticChordImmutable.DDsusb2b5);
    public static final ChromaticChord Esusb2b5 = new ChromaticChord(ChromaticChordImmutable.Esusb2b5);
    public static final ChromaticChord Fsusb2b5 = new ChromaticChord(ChromaticChordImmutable.Fsusb2b5);
    public static final ChromaticChord FFsusb2b5 = new ChromaticChord(ChromaticChordImmutable.FFsusb2b5);
    public static final ChromaticChord Gsusb2b5 = new ChromaticChord(ChromaticChordImmutable.Gsusb2b5);
    public static final ChromaticChord GGsusb2b5 = new ChromaticChord(ChromaticChordImmutable.GGsusb2b5);
    public static final ChromaticChord Asusb2b5 = new ChromaticChord(ChromaticChordImmutable.Asusb2b5);
    public static final ChromaticChord AAsusb2b5 = new ChromaticChord(ChromaticChordImmutable.AAsusb2b5);
    public static final ChromaticChord Bsusb2b5 = new ChromaticChord(ChromaticChordImmutable.Bsusb2b5);


    public static final Set<ChromaticChord> CHORDS_FIFTH = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_MAJOR = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_MINOR = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_AUGMENTED = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_DIMINISHED = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_SUS4 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_SUS2 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_7 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_7b5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_7a5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_7sus4 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_m7 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_m7b5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_m7a5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_6 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_6sus4 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_Maj7 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_mMaj7 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_6add9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_m6add9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_7b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_m6 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_7a9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_m7b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_7add11 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_7add13 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));


    public static final Set<ChromaticChord>	CHORDS_9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_m9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_9b5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_9a5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_9sus4 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_Maj9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_mMaj9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_9add6 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));
    public static final Set<ChromaticChord>	CHORDS_9a11 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));
    public static final Set<ChromaticChord>	CHORDS_Maj9a11 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_11 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));
    public static final Set<ChromaticChord>	CHORDS_m11 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));
    public static final Set<ChromaticChord>	CHORDS_11b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_11a9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));
    public static final Set<ChromaticChord>	CHORDS_Maj11 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));
    public static final Set<ChromaticChord>	CHORDS_mMaj11 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));
    public static final Set<ChromaticChord>	CHORDS_m13 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.Bm13,
            ChromaticChord.Cm13omit11,
            ChromaticChord.CCm13omit11,
            ChromaticChord.Dm13omit11,
            ChromaticChord.DDm13omit11,
            ChromaticChord.Em13omit11,
            ChromaticChord.Fm13omit11,
            ChromaticChord.FFm13omit11,
            ChromaticChord.Gm13omit11,
            ChromaticChord.GGm13omit11,
            ChromaticChord.Am13omit11,
            ChromaticChord.AAm13omit11,
            ChromaticChord.Bm13omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_13sus4 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13sus4,
            ChromaticChord.C13sus4omit11,
            ChromaticChord.CC13sus4omit11,
            ChromaticChord.D13sus4omit11,
            ChromaticChord.DD13sus4omit11,
            ChromaticChord.E13sus4omit11,
            ChromaticChord.F13sus4omit11,
            ChromaticChord.FF13sus4omit11,
            ChromaticChord.G13sus4omit11,
            ChromaticChord.GG13sus4omit11,
            ChromaticChord.A13sus4omit11,
            ChromaticChord.AA13sus4omit11,
            ChromaticChord.B13sus4omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_13b5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13b5 ,
            ChromaticChord.C13b5omit11,
            ChromaticChord.CC13b5omit11,
            ChromaticChord.D13b5omit11,
            ChromaticChord.DD13b5omit11,
            ChromaticChord.E13b5omit11,
            ChromaticChord.F13b5omit11,
            ChromaticChord.FF13b5omit11,
            ChromaticChord.G13b5omit11,
            ChromaticChord.GG13b5omit11,
            ChromaticChord.A13b5omit11,
            ChromaticChord.AA13b5omit11,
            ChromaticChord.B13b5omit11
    )));
    public static final Set<ChromaticChord>	CHORDS_13a5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13a5,
            ChromaticChord.C13a5omit11,
            ChromaticChord.CC13a5omit11,
            ChromaticChord.D13a5omit11,
            ChromaticChord.DD13a5omit11,
            ChromaticChord.E13a5omit11,
            ChromaticChord.F13a5omit11,
            ChromaticChord.FF13a5omit11,
            ChromaticChord.G13a5omit11,
            ChromaticChord.GG13a5omit11,
            ChromaticChord.A13a5omit11,
            ChromaticChord.AA13a5omit11,
            ChromaticChord.B13a5omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_13b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13b9,
            ChromaticChord.C13b9omit11,
            ChromaticChord.CC13b9omit11,
            ChromaticChord.D13b9omit11,
            ChromaticChord.DD13b9omit11,
            ChromaticChord.E13b9omit11,
            ChromaticChord.F13b9omit11,
            ChromaticChord.FF13b9omit11,
            ChromaticChord.G13b9omit11,
            ChromaticChord.GG13b9omit11,
            ChromaticChord.A13b9omit11,
            ChromaticChord.AA13b9omit11,
            ChromaticChord.B13b9omit11
    )));
    public static final Set<ChromaticChord>	CHORDS_13a9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13a9,
            ChromaticChord.C13a9omit11,
            ChromaticChord.CC13a9omit11,
            ChromaticChord.D13a9omit11,
            ChromaticChord.DD13a9omit11,
            ChromaticChord.E13a9omit11,
            ChromaticChord.F13a9omit11,
            ChromaticChord.FF13a9omit11,
            ChromaticChord.G13a9omit11,
            ChromaticChord.GG13a9omit11,
            ChromaticChord.A13a9omit11,
            ChromaticChord.AA13a9omit11,
            ChromaticChord.B13a9omit11
    )));
    public static final Set<ChromaticChord>	CHORDS_13b5b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13b5b9,
            ChromaticChord.C13b5b9omit11,
            ChromaticChord.CC13b5b9omit11,
            ChromaticChord.D13b5b9omit11,
            ChromaticChord.DD13b5b9omit11,
            ChromaticChord.E13b5b9omit11,
            ChromaticChord.F13b5b9omit11,
            ChromaticChord.FF13b5b9omit11,
            ChromaticChord.G13b5b9omit11,
            ChromaticChord.GG13b5b9omit11,
            ChromaticChord.A13b5b9omit11,
            ChromaticChord.AA13b5b9omit11,
            ChromaticChord.B13b5b9omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_13b5a9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13b5a9,
            ChromaticChord.C13b5a9omit11,
            ChromaticChord.CC13b5a9omit11,
            ChromaticChord.D13b5a9omit11,
            ChromaticChord.DD13b5a9omit11,
            ChromaticChord.E13b5a9omit11,
            ChromaticChord.F13b5a9omit11,
            ChromaticChord.FF13b5a9omit11,
            ChromaticChord.G13b5a9omit11,
            ChromaticChord.GG13b5a9omit11,
            ChromaticChord.A13b5a9omit11,
            ChromaticChord.AA13b5a9omit11,
            ChromaticChord.B13b5a9omit11
    )));
    public static final Set<ChromaticChord>	CHORDS_13a5b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13a5b9,
            ChromaticChord.C13a5b9omit11,
            ChromaticChord.CC13a5b9omit11,
            ChromaticChord.D13a5b9omit11,
            ChromaticChord.DD13a5b9omit11,
            ChromaticChord.E13a5b9omit11,
            ChromaticChord.F13a5b9omit11,
            ChromaticChord.FF13a5b9omit11,
            ChromaticChord.G13a5b9omit11,
            ChromaticChord.GG13a5b9omit11,
            ChromaticChord.A13a5b9omit11,
            ChromaticChord.AA13a5b9omit11,
            ChromaticChord.B13a5b9omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_13a5a9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.B13a5a9,
            ChromaticChord.C13a5a9omit11,
            ChromaticChord.CC13a5a9omit11,
            ChromaticChord.D13a5a9omit11,
            ChromaticChord.DD13a5a9omit11,
            ChromaticChord.E13a5a9omit11,
            ChromaticChord.F13a5a9omit11,
            ChromaticChord.FF13a5a9omit11,
            ChromaticChord.G13a5a9omit11,
            ChromaticChord.GG13a5a9omit11,
            ChromaticChord.A13a5a9omit11,
            ChromaticChord.AA13a5a9omit11,
            ChromaticChord.B13a5a9omit11
    )));
    public static final Set<ChromaticChord>	CHORDS_Maj13 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13,
            ChromaticChord.CMaj13omit11,
            ChromaticChord.CCMaj13omit11,
            ChromaticChord.DMaj13omit11,
            ChromaticChord.DDMaj13omit11,
            ChromaticChord.EMaj13omit11,
            ChromaticChord.FMaj13omit11,
            ChromaticChord.FFMaj13omit11,
            ChromaticChord.GMaj13omit11,
            ChromaticChord.GGMaj13omit11,
            ChromaticChord.AMaj13omit11,
            ChromaticChord.AAMaj13omit11,
            ChromaticChord.BMaj13omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_mMaj13 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BmMaj13,
            ChromaticChord.CmMaj13omit11,
            ChromaticChord.CCmMaj13omit11,
            ChromaticChord.DmMaj13omit11,
            ChromaticChord.DDmMaj13omit11,
            ChromaticChord.EmMaj13omit11,
            ChromaticChord.FmMaj13omit11,
            ChromaticChord.FFmMaj13omit11,
            ChromaticChord.GmMaj13omit11,
            ChromaticChord.GGmMaj13omit11,
            ChromaticChord.AmMaj13omit11,
            ChromaticChord.AAmMaj13omit11,
            ChromaticChord.BmMaj13omit11
    )));
    public static final Set<ChromaticChord>	CHORDS_Maj13b5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13b5,
            ChromaticChord.CMaj13b5omit11,
            ChromaticChord.CCMaj13b5omit11,
            ChromaticChord.DMaj13b5omit11,
            ChromaticChord.DDMaj13b5omit11,
            ChromaticChord.EMaj13b5omit11,
            ChromaticChord.FMaj13b5omit11,
            ChromaticChord.FFMaj13b5omit11,
            ChromaticChord.GMaj13b5omit11,
            ChromaticChord.GGMaj13b5omit11,
            ChromaticChord.AMaj13b5omit11,
            ChromaticChord.AAMaj13b5omit11,
            ChromaticChord.BMaj13b5omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_Maj13a5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13a5,
            ChromaticChord.CMaj13a5omit11,
            ChromaticChord.CCMaj13a5omit11,
            ChromaticChord.DMaj13a5omit11,
            ChromaticChord.DDMaj13a5omit11,
            ChromaticChord.EMaj13a5omit11,
            ChromaticChord.FMaj13a5omit11,
            ChromaticChord.FFMaj13a5omit11,
            ChromaticChord.GMaj13a5omit11,
            ChromaticChord.GGMaj13a5omit11,
            ChromaticChord.AMaj13a5omit11,
            ChromaticChord.AAMaj13a5omit11,
            ChromaticChord.BMaj13a5omit11
    )));
    public static final Set<ChromaticChord>	CHORDS_Maj13b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13b9,
            ChromaticChord.CMaj13b9omit11,
            ChromaticChord.CCMaj13b9omit11,
            ChromaticChord.DMaj13b9omit11,
            ChromaticChord.DDMaj13b9omit11,
            ChromaticChord.EMaj13b9omit11,
            ChromaticChord.FMaj13b9omit11,
            ChromaticChord.FFMaj13b9omit11,
            ChromaticChord.GMaj13b9omit11,
            ChromaticChord.GGMaj13b9omit11,
            ChromaticChord.AMaj13b9omit11,
            ChromaticChord.AAMaj13b9omit11,
            ChromaticChord.BMaj13b9omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_Maj13a9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13a9,
            ChromaticChord.CMaj13a9omit11,
            ChromaticChord.CCMaj13a9omit11,
            ChromaticChord.DMaj13a9omit11,
            ChromaticChord.DDMaj13a9omit11,
            ChromaticChord.EMaj13a9omit11,
            ChromaticChord.FMaj13a9omit11,
            ChromaticChord.FFMaj13a9omit11,
            ChromaticChord.GMaj13a9omit11,
            ChromaticChord.GGMaj13a9omit11,
            ChromaticChord.AMaj13a9omit11,
            ChromaticChord.AAMaj13a9omit11,
            ChromaticChord.BMaj13a9omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_Maj13b5b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13b5b9,
            ChromaticChord.CMaj13b5b9omit11,
            ChromaticChord.CCMaj13b5b9omit11,
            ChromaticChord.DMaj13b5b9omit11,
            ChromaticChord.DDMaj13b5b9omit11,
            ChromaticChord.EMaj13b5b9omit11,
            ChromaticChord.FMaj13b5b9omit11,
            ChromaticChord.FFMaj13b5b9omit11,
            ChromaticChord.GMaj13b5b9omit11,
            ChromaticChord.GGMaj13b5b9omit11,
            ChromaticChord.AMaj13b5b9omit11,
            ChromaticChord.AAMaj13b5b9omit11,
            ChromaticChord.BMaj13b5b9omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_Maj13b5a9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13b5a9,
            ChromaticChord.CMaj13b5a9omit11,
            ChromaticChord.CCMaj13b5a9omit11,
            ChromaticChord.DMaj13b5a9omit11,
            ChromaticChord.DDMaj13b5a9omit11,
            ChromaticChord.EMaj13b5a9omit11,
            ChromaticChord.FMaj13b5a9omit11,
            ChromaticChord.FFMaj13b5a9omit11,
            ChromaticChord.GMaj13b5a9omit11,
            ChromaticChord.GGMaj13b5a9omit11,
            ChromaticChord.AMaj13b5a9omit11,
            ChromaticChord.AAMaj13b5a9omit11,
            ChromaticChord.BMaj13b5a9omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_Maj13a5b9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13a5b9,
            ChromaticChord.CMaj13a5b9omit11,
            ChromaticChord.CCMaj13a5b9omit11,
            ChromaticChord.DMaj13a5b9omit11,
            ChromaticChord.DDMaj13a5b9omit11,
            ChromaticChord.EMaj13a5b9omit11,
            ChromaticChord.FMaj13a5b9omit11,
            ChromaticChord.FFMaj13a5b9omit11,
            ChromaticChord.GMaj13a5b9omit11,
            ChromaticChord.GGMaj13a5b9omit11,
            ChromaticChord.AMaj13a5b9omit11,
            ChromaticChord.AAMaj13a5b9omit11,
            ChromaticChord.BMaj13a5b9omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_Maj13a5a9 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
            ChromaticChord.BMaj13a5a9,
            ChromaticChord.CMaj13a5a9omit11,
            ChromaticChord.CCMaj13a5a9omit11,
            ChromaticChord.DMaj13a5a9omit11,
            ChromaticChord.DDMaj13a5a9omit11,
            ChromaticChord.EMaj13a5a9omit11,
            ChromaticChord.FMaj13a5a9omit11,
            ChromaticChord.FFMaj13a5a9omit11,
            ChromaticChord.GMaj13a5a9omit11,
            ChromaticChord.GGMaj13a5a9omit11,
            ChromaticChord.AMaj13a5a9omit11,
            ChromaticChord.AAMaj13a5a9omit11,
            ChromaticChord.BMaj13a5a9omit11
    )));

    public static final Set<ChromaticChord>	CHORDS_SUSa4 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_SUSb2 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

    public static final Set<ChromaticChord>	CHORDS_SUSb2b5 = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
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
    )));

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
            CHORDS_7add13,
            CHORDS_7sus4
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
            CHORDS_mMaj9,
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

    public static final Set<ChromaticChord>	PARTIAL_CHORDS = ListUtils.concatUnmodificable(
            CHORDS_FIFTH
    );

    public static final Set<ChromaticChord>	COMMON_CHORDS = ListUtils.concatUnmodificable(
            TRIAD_CHORDS, SEVENTH_CHORDS, SIXTH_CHORDS, NINTH_CHORDS,
            ELEVENTH_CHORDS, THIRTEENTH_CHORDS, PARTIAL_CHORDS
    );


    /*
     * END CONSTANT CHORDS
     *****************************************************************************************************************/

    public static ChromaticChordBuilder builder() {
        return new ChromaticChordBuilder();
    }

    ChromaticChord() {
        super();
    }

    public static @NonNull Set<ChromaticChord> immutableValues() {
        return ListUtils.concatUnmodificable(COMMON_CHORDS, UNUSUAL_CHORDS);
    }

    private ChromaticChord(ChromaticChordInterface chromaticChordInterface) {
        super(chromaticChordInterface);
    }

    @Override
    protected final void turnInnerChordIntoImmutableIfPossible() {
        if (getRootIndex() != 0)
            return;
        ChromaticChordImmutable chromaticChordImmutable = ChromaticChordImmutable.from(innerChord);
        if (chromaticChordImmutable != null)
            innerChord = chromaticChordImmutable;
    }

    @Override
    protected final void turnInnerIntoMutable() {
        innerChord = ChromaticChordMutable.from(innerChord);
    }

    @Override
    protected final boolean innerIsImmutable() {
        return innerChord instanceof ChromaticChordImmutable;
    }

    @Override
    protected final boolean InnerIsMutable() {
        return innerChord instanceof ChromaticChordMutable;
    }

    @Override
    protected final ChromaticChordMutable castCustom(ChromaticChordInterface chord) {
        return (ChromaticChordMutable) innerChord;
    }

    @Override
    protected final ChromaticChord create() {
        ChromaticChord chromaticChord = new ChromaticChord();
        chromaticChord.innerChord = new ChromaticChordMutable();
        return chromaticChord;
    }

    @NonNull
    public Quality getQuality() {
        return innerChord.getQuality();
    }

    @Override
    public void shift(IntervalChromatic intervalChromatic) {
        for (int i = 0; i < size(); i++)
            set(i, get(i).getShifted(intervalChromatic));
    }

    @Override
    public void shiftNegative(IntervalChromatic intervalChromatic) {
        for (int i = 0; i < size(); i++)
            set(i, get(i).getShiftedNegative(intervalChromatic));
    }

    @Override
    public final ChromaticChord clone() {
        return (ChromaticChord) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof ChromaticChord) )
            return false;

        ChromaticChord casted = (ChromaticChord)o;

        return casted.innerChord.equals(innerChord);
    }
}
