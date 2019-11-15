package es.danisales.datune.musical;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.utils.ListUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;
import java.util.function.BiFunction;

@SuppressWarnings("WeakerAccess")
public final class ChromaticChord extends NormalChordCommon<Chromatic> implements ChordCommon<Chromatic> {
    // Quintas
    public static final ChromaticChord C5 = new ChromaticChord(ChromaticChordEnum.C5);
    public static final ChromaticChord CC5 = new ChromaticChord(ChromaticChordEnum.CC5);
    public static final ChromaticChord D5 = new ChromaticChord(ChromaticChordEnum.D5);
    public static final ChromaticChord DD5 = new ChromaticChord(ChromaticChordEnum.DD5);
    public static final ChromaticChord E5 = new ChromaticChord(ChromaticChordEnum.E5);
    public static final ChromaticChord F5 = new ChromaticChord(ChromaticChordEnum.F5);
    public static final ChromaticChord FF5 = new ChromaticChord(ChromaticChordEnum.FF5);
    public static final ChromaticChord G5 = new ChromaticChord(ChromaticChordEnum.G5);
    public static final ChromaticChord GG5 = new ChromaticChord(ChromaticChordEnum.GG5);
    public static final ChromaticChord A5 = new ChromaticChord(ChromaticChordEnum.A5);
    public static final ChromaticChord AA5 = new ChromaticChord(ChromaticChordEnum.AA5);
    public static final ChromaticChord B5 = new ChromaticChord(ChromaticChordEnum.B5);

    // Mayores
    public static final ChromaticChord C = new ChromaticChord(ChromaticChordEnum.C);
    public static final ChromaticChord CC = new ChromaticChord(ChromaticChordEnum.CC);
    public static final ChromaticChord D = new ChromaticChord(ChromaticChordEnum.D);
    public static final ChromaticChord DD = new ChromaticChord(ChromaticChordEnum.DD);
    public static final ChromaticChord E = new ChromaticChord(ChromaticChordEnum.E);
    public static final ChromaticChord F = new ChromaticChord(ChromaticChordEnum.F);
    public static final ChromaticChord FF = new ChromaticChord(ChromaticChordEnum.FF);
    public static final ChromaticChord G = new ChromaticChord(ChromaticChordEnum.G);
    public static final ChromaticChord GG = new ChromaticChord(ChromaticChordEnum.GG);
    public static final ChromaticChord A = new ChromaticChord(ChromaticChordEnum.A);
    public static final ChromaticChord AA = new ChromaticChord(ChromaticChordEnum.AA);
    public static final ChromaticChord B = new ChromaticChord(ChromaticChordEnum.B);

    // Menores
    public static final ChromaticChord Cm = new ChromaticChord(ChromaticChordEnum.Cm);
    public static final ChromaticChord CCm = new ChromaticChord(ChromaticChordEnum.CCm);
    public static final ChromaticChord Dm = new ChromaticChord(ChromaticChordEnum.Dm);
    public static final ChromaticChord DDm = new ChromaticChord(ChromaticChordEnum.DDm);
    public static final ChromaticChord Em = new ChromaticChord(ChromaticChordEnum.Em);
    public static final ChromaticChord Fm = new ChromaticChord(ChromaticChordEnum.Fm);
    public static final ChromaticChord FFm = new ChromaticChord(ChromaticChordEnum.FFm);
    public static final ChromaticChord Gm = new ChromaticChord(ChromaticChordEnum.Gm);
    public static final ChromaticChord GGm = new ChromaticChord(ChromaticChordEnum.GGm);
    public static final ChromaticChord Am = new ChromaticChord(ChromaticChordEnum.Am);
    public static final ChromaticChord AAm = new ChromaticChord(ChromaticChordEnum.AAm);
    public static final ChromaticChord Bm = new ChromaticChord(ChromaticChordEnum.Bm);

    // Aumentados
    public static final ChromaticChord Caug = new ChromaticChord(ChromaticChordEnum.Caug);
    public static final ChromaticChord CCaug = new ChromaticChord(ChromaticChordEnum.CCaug);
    public static final ChromaticChord Daug = new ChromaticChord(ChromaticChordEnum.Daug);
    public static final ChromaticChord DDaug = new ChromaticChord(ChromaticChordEnum.DDaug);
    public static final ChromaticChord Eaug = new ChromaticChord(ChromaticChordEnum.Eaug);
    public static final ChromaticChord Faug = new ChromaticChord(ChromaticChordEnum.Faug);
    public static final ChromaticChord FFaug = new ChromaticChord(ChromaticChordEnum.FFaug);
    public static final ChromaticChord Gaug = new ChromaticChord(ChromaticChordEnum.Gaug);
    public static final ChromaticChord GGaug = new ChromaticChord(ChromaticChordEnum.GGaug);
    public static final ChromaticChord Aaug = new ChromaticChord(ChromaticChordEnum.Aaug);
    public static final ChromaticChord AAaug = new ChromaticChord(ChromaticChordEnum.AAaug);
    public static final ChromaticChord Baug = new ChromaticChord(ChromaticChordEnum.Baug);

    // Diminuidos
    public static final ChromaticChord Cdim = new ChromaticChord(ChromaticChordEnum.Cdim);
    public static final ChromaticChord CCdim = new ChromaticChord(ChromaticChordEnum.CCdim);
    public static final ChromaticChord Ddim = new ChromaticChord(ChromaticChordEnum.Ddim);
    public static final ChromaticChord DDdim = new ChromaticChord(ChromaticChordEnum.DDdim);
    public static final ChromaticChord Edim = new ChromaticChord(ChromaticChordEnum.Edim);
    public static final ChromaticChord Fdim = new ChromaticChord(ChromaticChordEnum.Fdim);
    public static final ChromaticChord FFdim = new ChromaticChord(ChromaticChordEnum.FFdim);
    public static final ChromaticChord Gdim = new ChromaticChord(ChromaticChordEnum.Gdim);
    public static final ChromaticChord GGdim = new ChromaticChord(ChromaticChordEnum.GGdim);
    public static final ChromaticChord Adim = new ChromaticChord(ChromaticChordEnum.Adim);
    public static final ChromaticChord AAdim = new ChromaticChord(ChromaticChordEnum.AAdim);
    public static final ChromaticChord Bdim = new ChromaticChord(ChromaticChordEnum.Bdim);

    // Cuarta suspendida
    public static final ChromaticChord Csus4 = new ChromaticChord(ChromaticChordEnum.Csus4);
    public static final ChromaticChord CCsus4 = new ChromaticChord(ChromaticChordEnum.CCsus4);
    public static final ChromaticChord Dsus4 = new ChromaticChord(ChromaticChordEnum.Dsus4);
    public static final ChromaticChord DDsus4 = new ChromaticChord(ChromaticChordEnum.DDsus4);
    public static final ChromaticChord Esus4 = new ChromaticChord(ChromaticChordEnum.Esus4);
    public static final ChromaticChord Fsus4 = new ChromaticChord(ChromaticChordEnum.Fsus4);
    public static final ChromaticChord FFsus4 = new ChromaticChord(ChromaticChordEnum.FFsus4);
    public static final ChromaticChord Gsus4 = new ChromaticChord(ChromaticChordEnum.Gsus4);
    public static final ChromaticChord GGsus4 = new ChromaticChord(ChromaticChordEnum.GGsus4);
    public static final ChromaticChord Asus4 = new ChromaticChord(ChromaticChordEnum.Asus4);
    public static final ChromaticChord AAsus4 = new ChromaticChord(ChromaticChordEnum.AAsus4);
    public static final ChromaticChord Bsus4 = new ChromaticChord(ChromaticChordEnum.Bsus4);

    // Segunda suspendida
    public static final ChromaticChord Csus2 = new ChromaticChord(ChromaticChordEnum.Csus2);
    public static final ChromaticChord CCsus2 = new ChromaticChord(ChromaticChordEnum.CCsus2);
    public static final ChromaticChord Dsus2 = new ChromaticChord(ChromaticChordEnum.Dsus2);
    public static final ChromaticChord DDsus2 = new ChromaticChord(ChromaticChordEnum.DDsus2);
    public static final ChromaticChord Esus2 = new ChromaticChord(ChromaticChordEnum.Esus2);
    public static final ChromaticChord Fsus2 = new ChromaticChord(ChromaticChordEnum.Fsus2);
    public static final ChromaticChord FFsus2 = new ChromaticChord(ChromaticChordEnum.FFsus2);
    public static final ChromaticChord Gsus2 = new ChromaticChord(ChromaticChordEnum.Gsus2);
    public static final ChromaticChord GGsus2 = new ChromaticChord(ChromaticChordEnum.GGsus2);
    public static final ChromaticChord Asus2 = new ChromaticChord(ChromaticChordEnum.Asus2);
    public static final ChromaticChord AAsus2 = new ChromaticChord(ChromaticChordEnum.AAsus2);
    public static final ChromaticChord Bsus2 = new ChromaticChord(ChromaticChordEnum.Bsus2);

    // Séptima (de dominante)
    public static final ChromaticChord C7 = new ChromaticChord(ChromaticChordEnum.C7);
    public static final ChromaticChord CC7 = new ChromaticChord(ChromaticChordEnum.CC7);
    public static final ChromaticChord D7 = new ChromaticChord(ChromaticChordEnum.D7);
    public static final ChromaticChord DD7 = new ChromaticChord(ChromaticChordEnum.DD7);
    public static final ChromaticChord E7 = new ChromaticChord(ChromaticChordEnum.E7);
    public static final ChromaticChord F7 = new ChromaticChord(ChromaticChordEnum.F7);
    public static final ChromaticChord FF7 = new ChromaticChord(ChromaticChordEnum.FF7);
    public static final ChromaticChord G7 = new ChromaticChord(ChromaticChordEnum.G7);
    public static final ChromaticChord GG7 = new ChromaticChord(ChromaticChordEnum.GG7);
    public static final ChromaticChord A7 = new ChromaticChord(ChromaticChordEnum.A7);
    public static final ChromaticChord AA7 = new ChromaticChord(ChromaticChordEnum.AA7);
    public static final ChromaticChord B7 = new ChromaticChord(ChromaticChordEnum.B7);

    // Séptima con quinta bemol
    public static final ChromaticChord C7b5 = new ChromaticChord(ChromaticChordEnum.C7b5);
    public static final ChromaticChord CC7b5 = new ChromaticChord(ChromaticChordEnum.CC7b5);
    public static final ChromaticChord D7b5 = new ChromaticChord(ChromaticChordEnum.D7b5);
    public static final ChromaticChord DD7b5 = new ChromaticChord(ChromaticChordEnum.DD7b5);
    public static final ChromaticChord E7b5 = new ChromaticChord(ChromaticChordEnum.E7b5);
    public static final ChromaticChord F7b5 = new ChromaticChord(ChromaticChordEnum.F7b5);
    public static final ChromaticChord FF7b5 = new ChromaticChord(ChromaticChordEnum.FF7b5);
    public static final ChromaticChord G7b5 = new ChromaticChord(ChromaticChordEnum.G7b5);
    public static final ChromaticChord GG7b5 = new ChromaticChord(ChromaticChordEnum.GG7b5);
    public static final ChromaticChord A7b5 = new ChromaticChord(ChromaticChordEnum.A7b5);
    public static final ChromaticChord AA7b5 = new ChromaticChord(ChromaticChordEnum.AA7b5);
    public static final ChromaticChord B7b5 = new ChromaticChord(ChromaticChordEnum.B7b5);

    // Séptima con quinta aumentada
    public static final ChromaticChord C7a5 = new ChromaticChord(ChromaticChordEnum.C7a5);
    public static final ChromaticChord CC7a5 = new ChromaticChord(ChromaticChordEnum.CC7a5);
    public static final ChromaticChord D7a5 = new ChromaticChord(ChromaticChordEnum.D7a5);
    public static final ChromaticChord DD7a5 = new ChromaticChord(ChromaticChordEnum.DD7a5);
    public static final ChromaticChord E7a5 = new ChromaticChord(ChromaticChordEnum.E7a5);
    public static final ChromaticChord F7a5 = new ChromaticChord(ChromaticChordEnum.F7a5);
    public static final ChromaticChord FF7a5 = new ChromaticChord(ChromaticChordEnum.FF7a5);
    public static final ChromaticChord G7a5 = new ChromaticChord(ChromaticChordEnum.G7a5);
    public static final ChromaticChord GG7a5 = new ChromaticChord(ChromaticChordEnum.GG7a5);
    public static final ChromaticChord A7a5 = new ChromaticChord(ChromaticChordEnum.A7a5);
    public static final ChromaticChord AA7a5 = new ChromaticChord(ChromaticChordEnum.AA7a5);
    public static final ChromaticChord B7a5 = new ChromaticChord(ChromaticChordEnum.B7a5);

    // Séptima con cuarta suspendida
    public static final ChromaticChord C7sus4 = new ChromaticChord(ChromaticChordEnum.C7sus4);
    public static final ChromaticChord CC7sus4 = new ChromaticChord(ChromaticChordEnum.CC7sus4);
    public static final ChromaticChord D7sus4 = new ChromaticChord(ChromaticChordEnum.D7sus4);
    public static final ChromaticChord DD7sus4 = new ChromaticChord(ChromaticChordEnum.DD7sus4);
    public static final ChromaticChord E7sus4 = new ChromaticChord(ChromaticChordEnum.E7sus4);
    public static final ChromaticChord F7sus4 = new ChromaticChord(ChromaticChordEnum.F7sus4);
    public static final ChromaticChord FF7sus4 = new ChromaticChord(ChromaticChordEnum.FF7sus4);
    public static final ChromaticChord G7sus4 = new ChromaticChord(ChromaticChordEnum.G7sus4);
    public static final ChromaticChord GG7sus4 = new ChromaticChord(ChromaticChordEnum.GG7sus4);
    public static final ChromaticChord A7sus4 = new ChromaticChord(ChromaticChordEnum.A7sus4);
    public static final ChromaticChord AA7sus4 = new ChromaticChord(ChromaticChordEnum.AA7sus4);
    public static final ChromaticChord B7sus4 = new ChromaticChord(ChromaticChordEnum.B7sus4);

    // Menor séptima
    public static final ChromaticChord Cm7 = new ChromaticChord(ChromaticChordEnum.Cm7);
    public static final ChromaticChord CCm7 = new ChromaticChord(ChromaticChordEnum.CCm7);
    public static final ChromaticChord Dm7 = new ChromaticChord(ChromaticChordEnum.Dm7);
    public static final ChromaticChord DDm7 = new ChromaticChord(ChromaticChordEnum.DDm7);
    public static final ChromaticChord Em7 = new ChromaticChord(ChromaticChordEnum.Em7);
    public static final ChromaticChord Fm7 = new ChromaticChord(ChromaticChordEnum.Fm7);
    public static final ChromaticChord FFm7 = new ChromaticChord(ChromaticChordEnum.FFm7);
    public static final ChromaticChord Gm7 = new ChromaticChord(ChromaticChordEnum.Gm7);
    public static final ChromaticChord GGm7 = new ChromaticChord(ChromaticChordEnum.GGm7);
    public static final ChromaticChord Am7 = new ChromaticChord(ChromaticChordEnum.Am7);
    public static final ChromaticChord AAm7 = new ChromaticChord(ChromaticChordEnum.AAm7);
    public static final ChromaticChord Bm7 = new ChromaticChord(ChromaticChordEnum.Bm7);

    // Menor sÉptima con quinta bemol
    public static final ChromaticChord Cm7b5 = new ChromaticChord(ChromaticChordEnum.Cm7b5);
    public static final ChromaticChord CCm7b5 = new ChromaticChord(ChromaticChordEnum.CCm7b5);
    public static final ChromaticChord Dm7b5 = new ChromaticChord(ChromaticChordEnum.Dm7b5);
    public static final ChromaticChord DDm7b5 = new ChromaticChord(ChromaticChordEnum.DDm7b5);
    public static final ChromaticChord Em7b5 = new ChromaticChord(ChromaticChordEnum.Em7b5);
    public static final ChromaticChord Fm7b5 = new ChromaticChord(ChromaticChordEnum.Fm7b5);
    public static final ChromaticChord FFm7b5 = new ChromaticChord(ChromaticChordEnum.FFm7b5);
    public static final ChromaticChord Gm7b5 = new ChromaticChord(ChromaticChordEnum.Gm7b5);
    public static final ChromaticChord GGm7b5 = new ChromaticChord(ChromaticChordEnum.GGm7b5);
    public static final ChromaticChord Am7b5 = new ChromaticChord(ChromaticChordEnum.Am7b5);
    public static final ChromaticChord AAm7b5 = new ChromaticChord(ChromaticChordEnum.AAm7b5);
    public static final ChromaticChord Bm7b5 = new ChromaticChord(ChromaticChordEnum.Bm7b5);

    // Menor sÉptima con quinta aumentada
    public static final ChromaticChord Cm7a5 = new ChromaticChord(ChromaticChordEnum.Cm7a5);
    public static final ChromaticChord CCm7a5 = new ChromaticChord(ChromaticChordEnum.CCm7a5);
    public static final ChromaticChord Dm7a5 = new ChromaticChord(ChromaticChordEnum.Dm7a5);
    public static final ChromaticChord DDm7a5 = new ChromaticChord(ChromaticChordEnum.DDm7a5);
    public static final ChromaticChord Em7a5 = new ChromaticChord(ChromaticChordEnum.Em7a5);
    public static final ChromaticChord Fm7a5 = new ChromaticChord(ChromaticChordEnum.Fm7a5);
    public static final ChromaticChord FFm7a5 = new ChromaticChord(ChromaticChordEnum.FFm7a5);
    public static final ChromaticChord Gm7a5 = new ChromaticChord(ChromaticChordEnum.Gm7a5);
    public static final ChromaticChord GGm7a5 = new ChromaticChord(ChromaticChordEnum.GGm7a5);
    public static final ChromaticChord Am7a5 = new ChromaticChord(ChromaticChordEnum.Am7a5);
    public static final ChromaticChord AAm7a5 = new ChromaticChord(ChromaticChordEnum.AAm7a5);
    public static final ChromaticChord Bm7a5 = new ChromaticChord(ChromaticChordEnum.Bm7a5);

    // Sexta
    public static final ChromaticChord C6 = new ChromaticChord(ChromaticChordEnum.C6);
    public static final ChromaticChord CC6 = new ChromaticChord(ChromaticChordEnum.CC6);
    public static final ChromaticChord D6 = new ChromaticChord(ChromaticChordEnum.D6);
    public static final ChromaticChord DD6 = new ChromaticChord(ChromaticChordEnum.DD6);
    public static final ChromaticChord E6 = new ChromaticChord(ChromaticChordEnum.E6);
    public static final ChromaticChord F6 = new ChromaticChord(ChromaticChordEnum.F6);
    public static final ChromaticChord FF6 = new ChromaticChord(ChromaticChordEnum.FF6);
    public static final ChromaticChord G6 = new ChromaticChord(ChromaticChordEnum.G6);
    public static final ChromaticChord GG6 = new ChromaticChord(ChromaticChordEnum.GG6);
    public static final ChromaticChord A6 = new ChromaticChord(ChromaticChordEnum.A6);
    public static final ChromaticChord AA6 = new ChromaticChord(ChromaticChordEnum.AA6);
    public static final ChromaticChord B6 = new ChromaticChord(ChromaticChordEnum.B6);

    // Menor sexta
    public static final ChromaticChord Cm6 = new ChromaticChord(ChromaticChordEnum.Cm6);
    public static final ChromaticChord CCm6 = new ChromaticChord(ChromaticChordEnum.CCm6);
    public static final ChromaticChord Dm6 = new ChromaticChord(ChromaticChordEnum.Dm6);
    public static final ChromaticChord DDm6 = new ChromaticChord(ChromaticChordEnum.DDm6);
    public static final ChromaticChord Em6 = new ChromaticChord(ChromaticChordEnum.Em6);
    public static final ChromaticChord Fm6 = new ChromaticChord(ChromaticChordEnum.Fm6);
    public static final ChromaticChord FFm6 = new ChromaticChord(ChromaticChordEnum.FFm6);
    public static final ChromaticChord Gm6 = new ChromaticChord(ChromaticChordEnum.Gm6);
    public static final ChromaticChord GGm6 = new ChromaticChord(ChromaticChordEnum.GGm6);
    public static final ChromaticChord Am6 = new ChromaticChord(ChromaticChordEnum.Am6);
    public static final ChromaticChord AAm6 = new ChromaticChord(ChromaticChordEnum.AAm6);
    public static final ChromaticChord Bm6 = new ChromaticChord(ChromaticChordEnum.Bm6);

    // Sexta con cuarta suspendida
    public static final ChromaticChord C6sus4 = new ChromaticChord(ChromaticChordEnum.C6sus4);
    public static final ChromaticChord CC6sus4 = new ChromaticChord(ChromaticChordEnum.CC6sus4);
    public static final ChromaticChord D6sus4 = new ChromaticChord(ChromaticChordEnum.D6sus4);
    public static final ChromaticChord DD6sus4 = new ChromaticChord(ChromaticChordEnum.DD6sus4);
    public static final ChromaticChord E6sus4 = new ChromaticChord(ChromaticChordEnum.E6sus4);
    public static final ChromaticChord F6sus4 = new ChromaticChord(ChromaticChordEnum.F6sus4);
    public static final ChromaticChord FF6sus4 = new ChromaticChord(ChromaticChordEnum.FF6sus4);
    public static final ChromaticChord G6sus4 = new ChromaticChord(ChromaticChordEnum.G6sus4);
    public static final ChromaticChord GG6sus4 = new ChromaticChord(ChromaticChordEnum.GG6sus4);
    public static final ChromaticChord A6sus4 = new ChromaticChord(ChromaticChordEnum.A6sus4);
    public static final ChromaticChord AA6sus4 = new ChromaticChord(ChromaticChordEnum.AA6sus4);
    public static final ChromaticChord B6sus4 = new ChromaticChord(ChromaticChordEnum.B6sus4);

    // Séptima mayor
    public static final ChromaticChord CMaj7 = new ChromaticChord(ChromaticChordEnum.CMaj7);
    public static final ChromaticChord CCMaj7 = new ChromaticChord(ChromaticChordEnum.CCMaj7);
    public static final ChromaticChord DMaj7 = new ChromaticChord(ChromaticChordEnum.DMaj7);
    public static final ChromaticChord DDMaj7 = new ChromaticChord(ChromaticChordEnum.DDMaj7);
    public static final ChromaticChord EMaj7 = new ChromaticChord(ChromaticChordEnum.EMaj7);
    public static final ChromaticChord FMaj7 = new ChromaticChord(ChromaticChordEnum.FMaj7);
    public static final ChromaticChord FFMaj7 = new ChromaticChord(ChromaticChordEnum.FFMaj7);
    public static final ChromaticChord GMaj7 = new ChromaticChord(ChromaticChordEnum.GMaj7);
    public static final ChromaticChord GGMaj7 = new ChromaticChord(ChromaticChordEnum.GGMaj7);
    public static final ChromaticChord AMaj7 = new ChromaticChord(ChromaticChordEnum.AMaj7);
    public static final ChromaticChord AAMaj7 = new ChromaticChord(ChromaticChordEnum.AAMaj7);
    public static final ChromaticChord BMaj7 = new ChromaticChord(ChromaticChordEnum.BMaj7);

    // Menor séptima mayor
    public static final ChromaticChord CmMaj7 = new ChromaticChord(ChromaticChordEnum.CmMaj7);
    public static final ChromaticChord CCmMaj7 = new ChromaticChord(ChromaticChordEnum.CCmMaj7);
    public static final ChromaticChord DmMaj7 = new ChromaticChord(ChromaticChordEnum.DmMaj7);
    public static final ChromaticChord DDmMaj7 = new ChromaticChord(ChromaticChordEnum.DDmMaj7);
    public static final ChromaticChord EmMaj7 = new ChromaticChord(ChromaticChordEnum.EmMaj7);
    public static final ChromaticChord FmMaj7 = new ChromaticChord(ChromaticChordEnum.FmMaj7);
    public static final ChromaticChord FFmMaj7 = new ChromaticChord(ChromaticChordEnum.FFmMaj7);
    public static final ChromaticChord GmMaj7 = new ChromaticChord(ChromaticChordEnum.GmMaj7);
    public static final ChromaticChord GGmMaj7 = new ChromaticChord(ChromaticChordEnum.GGmMaj7);
    public static final ChromaticChord AmMaj7 = new ChromaticChord(ChromaticChordEnum.AmMaj7);
    public static final ChromaticChord AAmMaj7 = new ChromaticChord(ChromaticChordEnum.AAmMaj7);
    public static final ChromaticChord BmMaj7 = new ChromaticChord(ChromaticChordEnum.BmMaj7);

    // Sexta con novena añadida
    public static final ChromaticChord C6add9 = new ChromaticChord(ChromaticChordEnum.C6add9);
    public static final ChromaticChord CC6add9 = new ChromaticChord(ChromaticChordEnum.CC6add9);
    public static final ChromaticChord D6add9 = new ChromaticChord(ChromaticChordEnum.D6add9);
    public static final ChromaticChord DD6add9 = new ChromaticChord(ChromaticChordEnum.DD6add9);
    public static final ChromaticChord E6add9 = new ChromaticChord(ChromaticChordEnum.E6add9);
    public static final ChromaticChord F6add9 = new ChromaticChord(ChromaticChordEnum.F6add9);
    public static final ChromaticChord FF6add9 = new ChromaticChord(ChromaticChordEnum.FF6add9);
    public static final ChromaticChord G6add9 = new ChromaticChord(ChromaticChordEnum.G6add9);
    public static final ChromaticChord GG6add9 = new ChromaticChord(ChromaticChordEnum.GG6add9);
    public static final ChromaticChord A6add9 = new ChromaticChord(ChromaticChordEnum.A6add9);
    public static final ChromaticChord AA6add9 = new ChromaticChord(ChromaticChordEnum.AA6add9);
    public static final ChromaticChord B6add9 = new ChromaticChord(ChromaticChordEnum.B6add9);

    // Sexta con novena añadida
    public static final ChromaticChord Cm6add9 = new ChromaticChord(ChromaticChordEnum.Cm6add9);
    public static final ChromaticChord CCm6add9 = new ChromaticChord(ChromaticChordEnum.CCm6add9);
    public static final ChromaticChord Dm6add9 = new ChromaticChord(ChromaticChordEnum.Dm6add9);
    public static final ChromaticChord DDm6add9 = new ChromaticChord(ChromaticChordEnum.DDm6add9);
    public static final ChromaticChord Em6add9 = new ChromaticChord(ChromaticChordEnum.Em6add9);
    public static final ChromaticChord Fm6add9 = new ChromaticChord(ChromaticChordEnum.Fm6add9);
    public static final ChromaticChord FFm6add9 = new ChromaticChord(ChromaticChordEnum.FFm6add9);
    public static final ChromaticChord Gm6add9 = new ChromaticChord(ChromaticChordEnum.Gm6add9);
    public static final ChromaticChord GGm6add9 = new ChromaticChord(ChromaticChordEnum.GGm6add9);
    public static final ChromaticChord Am6add9 = new ChromaticChord(ChromaticChordEnum.Am6add9);
    public static final ChromaticChord AAm6add9 = new ChromaticChord(ChromaticChordEnum.AAm6add9);
    public static final ChromaticChord Bm6add9 = new ChromaticChord(ChromaticChordEnum.Bm6add9);

    // Séptima con novena bemol (añadida)
    public static final ChromaticChord C7b9 = new ChromaticChord(ChromaticChordEnum.C7b9);
    public static final ChromaticChord CC7b9 = new ChromaticChord(ChromaticChordEnum.CC7b9);
    public static final ChromaticChord D7b9 = new ChromaticChord(ChromaticChordEnum.D7b9);
    public static final ChromaticChord DD7b9 = new ChromaticChord(ChromaticChordEnum.DD7b9);
    public static final ChromaticChord E7b9 = new ChromaticChord(ChromaticChordEnum.E7b9);
    public static final ChromaticChord F7b9 = new ChromaticChord(ChromaticChordEnum.F7b9);
    public static final ChromaticChord FF7b9 = new ChromaticChord(ChromaticChordEnum.FF7b9);
    public static final ChromaticChord G7b9 = new ChromaticChord(ChromaticChordEnum.G7b9);
    public static final ChromaticChord GG7b9 = new ChromaticChord(ChromaticChordEnum.GG7b9);
    public static final ChromaticChord A7b9 = new ChromaticChord(ChromaticChordEnum.A7b9);
    public static final ChromaticChord AA7b9 = new ChromaticChord(ChromaticChordEnum.AA7b9);
    public static final ChromaticChord B7b9 = new ChromaticChord(ChromaticChordEnum.B7b9);

    // Séptima con novena aumentada (añadida)
    public static final ChromaticChord C7a9 = new ChromaticChord(ChromaticChordEnum.C7a9);
    public static final ChromaticChord CC7a9 = new ChromaticChord(ChromaticChordEnum.CC7a9);
    public static final ChromaticChord D7a9 = new ChromaticChord(ChromaticChordEnum.D7a9);
    public static final ChromaticChord DD7a9 = new ChromaticChord(ChromaticChordEnum.DD7a9);
    public static final ChromaticChord E7a9 = new ChromaticChord(ChromaticChordEnum.E7a9);
    public static final ChromaticChord F7a9 = new ChromaticChord(ChromaticChordEnum.F7a9);
    public static final ChromaticChord FF7a9 = new ChromaticChord(ChromaticChordEnum.FF7a9);
    public static final ChromaticChord G7a9 = new ChromaticChord(ChromaticChordEnum.G7a9);
    public static final ChromaticChord GG7a9 = new ChromaticChord(ChromaticChordEnum.GG7a9);
    public static final ChromaticChord A7a9 = new ChromaticChord(ChromaticChordEnum.A7a9);
    public static final ChromaticChord AA7a9 = new ChromaticChord(ChromaticChordEnum.AA7a9);
    public static final ChromaticChord B7a9 = new ChromaticChord(ChromaticChordEnum.B7a9);

    // Menor séptima con novena bemol (añadida)
    public static final ChromaticChord Cm7b9 = new ChromaticChord(ChromaticChordEnum.Cm7b9);
    public static final ChromaticChord CCm7b9 = new ChromaticChord(ChromaticChordEnum.CCm7b9);
    public static final ChromaticChord Dm7b9 = new ChromaticChord(ChromaticChordEnum.Dm7b9);
    public static final ChromaticChord DDm7b9 = new ChromaticChord(ChromaticChordEnum.DDm7b9);
    public static final ChromaticChord Em7b9 = new ChromaticChord(ChromaticChordEnum.Em7b9);
    public static final ChromaticChord Fm7b9 = new ChromaticChord(ChromaticChordEnum.Fm7b9);
    public static final ChromaticChord FFm7b9 = new ChromaticChord(ChromaticChordEnum.FFm7b9);
    public static final ChromaticChord Gm7b9 = new ChromaticChord(ChromaticChordEnum.Gm7b9);
    public static final ChromaticChord GGm7b9 = new ChromaticChord(ChromaticChordEnum.GGm7b9);
    public static final ChromaticChord Am7b9 = new ChromaticChord(ChromaticChordEnum.Am7b9);
    public static final ChromaticChord AAm7b9 = new ChromaticChord(ChromaticChordEnum.AAm7b9);
    public static final ChromaticChord Bm7b9 = new ChromaticChord(ChromaticChordEnum.Bm7b9);

    // Séptima con oncena (añadida)
    public static final ChromaticChord C7add11 = new ChromaticChord(ChromaticChordEnum.C7add11);
    public static final ChromaticChord CC7add11 = new ChromaticChord(ChromaticChordEnum.CC7add11);
    public static final ChromaticChord D7add11 = new ChromaticChord(ChromaticChordEnum.D7add11);
    public static final ChromaticChord DD7add11 = new ChromaticChord(ChromaticChordEnum.DD7add11);
    public static final ChromaticChord E7add11 = new ChromaticChord(ChromaticChordEnum.E7add11);
    public static final ChromaticChord F7add11 = new ChromaticChord(ChromaticChordEnum.F7add11);
    public static final ChromaticChord FF7add11 = new ChromaticChord(ChromaticChordEnum.FF7add11);
    public static final ChromaticChord G7add11 = new ChromaticChord(ChromaticChordEnum.G7add11);
    public static final ChromaticChord GG7add11 = new ChromaticChord(ChromaticChordEnum.GG7add11);
    public static final ChromaticChord A7add11 = new ChromaticChord(ChromaticChordEnum.A7add11);
    public static final ChromaticChord AA7add11 = new ChromaticChord(ChromaticChordEnum.AA7add11);
    public static final ChromaticChord B7add11 = new ChromaticChord(ChromaticChordEnum.B7add11);

    // Séptima con treceava (añadida)
    public static final ChromaticChord C7add13 = new ChromaticChord(ChromaticChordEnum.C7add13);
    public static final ChromaticChord CC7add13 = new ChromaticChord(ChromaticChordEnum.CC7add13);
    public static final ChromaticChord D7add13 = new ChromaticChord(ChromaticChordEnum.D7add13);
    public static final ChromaticChord DD7add13 = new ChromaticChord(ChromaticChordEnum.DD7add13);
    public static final ChromaticChord E7add13 = new ChromaticChord(ChromaticChordEnum.E7add13);
    public static final ChromaticChord F7add13 = new ChromaticChord(ChromaticChordEnum.F7add13);
    public static final ChromaticChord FF7add13 = new ChromaticChord(ChromaticChordEnum.FF7add13);
    public static final ChromaticChord G7add13 = new ChromaticChord(ChromaticChordEnum.G7add13);
    public static final ChromaticChord GG7add13 = new ChromaticChord(ChromaticChordEnum.GG7add13);
    public static final ChromaticChord A7add13 = new ChromaticChord(ChromaticChordEnum.A7add13);
    public static final ChromaticChord AA7add13 = new ChromaticChord(ChromaticChordEnum.AA7add13);
    public static final ChromaticChord B7add13 = new ChromaticChord(ChromaticChordEnum.B7add13);

    // Novena
    public static final ChromaticChord C9 = new ChromaticChord(ChromaticChordEnum.C9);
    public static final ChromaticChord CC9 = new ChromaticChord(ChromaticChordEnum.CC9);
    public static final ChromaticChord D9 = new ChromaticChord(ChromaticChordEnum.D9);
    public static final ChromaticChord DD9 = new ChromaticChord(ChromaticChordEnum.DD9);
    public static final ChromaticChord E9 = new ChromaticChord(ChromaticChordEnum.E9);
    public static final ChromaticChord F9 = new ChromaticChord(ChromaticChordEnum.F9);
    public static final ChromaticChord FF9 = new ChromaticChord(ChromaticChordEnum.FF9);
    public static final ChromaticChord G9 = new ChromaticChord(ChromaticChordEnum.G9);
    public static final ChromaticChord GG9 = new ChromaticChord(ChromaticChordEnum.GG9);
    public static final ChromaticChord A9 = new ChromaticChord(ChromaticChordEnum.A9);
    public static final ChromaticChord AA9 = new ChromaticChord(ChromaticChordEnum.AA9);
    public static final ChromaticChord B9 = new ChromaticChord(ChromaticChordEnum.B9);

    // Menor novena
    public static final ChromaticChord Cm9 = new ChromaticChord(ChromaticChordEnum.Cm9);
    public static final ChromaticChord CCm9 = new ChromaticChord(ChromaticChordEnum.CCm9);
    public static final ChromaticChord Dm9 = new ChromaticChord(ChromaticChordEnum.Dm9);
    public static final ChromaticChord DDm9 = new ChromaticChord(ChromaticChordEnum.DDm9);
    public static final ChromaticChord Em9 = new ChromaticChord(ChromaticChordEnum.Em9);
    public static final ChromaticChord Fm9 = new ChromaticChord(ChromaticChordEnum.Fm9);
    public static final ChromaticChord FFm9 = new ChromaticChord(ChromaticChordEnum.FFm9);
    public static final ChromaticChord Gm9 = new ChromaticChord(ChromaticChordEnum.Gm9);
    public static final ChromaticChord GGm9 = new ChromaticChord(ChromaticChordEnum.GGm9);
    public static final ChromaticChord Am9 = new ChromaticChord(ChromaticChordEnum.Am9);
    public static final ChromaticChord AAm9 = new ChromaticChord(ChromaticChordEnum.AAm9);
    public static final ChromaticChord Bm9 = new ChromaticChord(ChromaticChordEnum.Bm9);

    // Novena con quinta bemol
    public static final ChromaticChord C9b5 = new ChromaticChord(ChromaticChordEnum.C9b5);
    public static final ChromaticChord CC9b5 = new ChromaticChord(ChromaticChordEnum.CC9b5);
    public static final ChromaticChord D9b5 = new ChromaticChord(ChromaticChordEnum.D9b5);
    public static final ChromaticChord DD9b5 = new ChromaticChord(ChromaticChordEnum.DD9b5);
    public static final ChromaticChord E9b5 = new ChromaticChord(ChromaticChordEnum.E9b5);
    public static final ChromaticChord F9b5 = new ChromaticChord(ChromaticChordEnum.F9b5);
    public static final ChromaticChord FF9b5 = new ChromaticChord(ChromaticChordEnum.FF9b5);
    public static final ChromaticChord G9b5 = new ChromaticChord(ChromaticChordEnum.G9b5);
    public static final ChromaticChord GG9b5 = new ChromaticChord(ChromaticChordEnum.GG9b5);
    public static final ChromaticChord A9b5 = new ChromaticChord(ChromaticChordEnum.A9b5);
    public static final ChromaticChord AA9b5 = new ChromaticChord(ChromaticChordEnum.AA9b5);
    public static final ChromaticChord B9b5 = new ChromaticChord(ChromaticChordEnum.B9b5);

    // Novena con quinta aumentada
    public static final ChromaticChord C9a5 = new ChromaticChord(ChromaticChordEnum.C9a5);
    public static final ChromaticChord CC9a5 = new ChromaticChord(ChromaticChordEnum.CC9a5);
    public static final ChromaticChord D9a5 = new ChromaticChord(ChromaticChordEnum.D9a5);
    public static final ChromaticChord DD9a5 = new ChromaticChord(ChromaticChordEnum.DD9a5);
    public static final ChromaticChord E9a5 = new ChromaticChord(ChromaticChordEnum.E9a5);
    public static final ChromaticChord F9a5 = new ChromaticChord(ChromaticChordEnum.F9a5);
    public static final ChromaticChord FF9a5 = new ChromaticChord(ChromaticChordEnum.FF9a5);
    public static final ChromaticChord G9a5 = new ChromaticChord(ChromaticChordEnum.G9a5);
    public static final ChromaticChord GG9a5 = new ChromaticChord(ChromaticChordEnum.GG9a5);
    public static final ChromaticChord A9a5 = new ChromaticChord(ChromaticChordEnum.A9a5);
    public static final ChromaticChord AA9a5 = new ChromaticChord(ChromaticChordEnum.AA9a5);
    public static final ChromaticChord B9a5 = new ChromaticChord(ChromaticChordEnum.B9a5);

    // Novena con cuarta suspendida
    public static final ChromaticChord C9sus4 = new ChromaticChord(ChromaticChordEnum.C9sus4);
    public static final ChromaticChord CC9sus4 = new ChromaticChord(ChromaticChordEnum.CC9sus4);
    public static final ChromaticChord D9sus4 = new ChromaticChord(ChromaticChordEnum.D9sus4);
    public static final ChromaticChord DD9sus4 = new ChromaticChord(ChromaticChordEnum.DD9sus4);
    public static final ChromaticChord E9sus4 = new ChromaticChord(ChromaticChordEnum.E9sus4);
    public static final ChromaticChord F9sus4 = new ChromaticChord(ChromaticChordEnum.F9sus4);
    public static final ChromaticChord FF9sus4 = new ChromaticChord(ChromaticChordEnum.FF9sus4);
    public static final ChromaticChord G9sus4 = new ChromaticChord(ChromaticChordEnum.G9sus4);
    public static final ChromaticChord GG9sus4 = new ChromaticChord(ChromaticChordEnum.GG9sus4);
    public static final ChromaticChord A9sus4 = new ChromaticChord(ChromaticChordEnum.A9sus4);
    public static final ChromaticChord AA9sus4 = new ChromaticChord(ChromaticChordEnum.AA9sus4);
    public static final ChromaticChord B9sus4 = new ChromaticChord(ChromaticChordEnum.B9sus4);

    // Novena mayor
    public static final ChromaticChord CMaj9 = new ChromaticChord(ChromaticChordEnum.CMaj9);
    public static final ChromaticChord CCMaj9 = new ChromaticChord(ChromaticChordEnum.CCMaj9);
    public static final ChromaticChord DMaj9 = new ChromaticChord(ChromaticChordEnum.DMaj9);
    public static final ChromaticChord DDMaj9 = new ChromaticChord(ChromaticChordEnum.DDMaj9);
    public static final ChromaticChord EMaj9 = new ChromaticChord(ChromaticChordEnum.EMaj9);
    public static final ChromaticChord FMaj9 = new ChromaticChord(ChromaticChordEnum.FMaj9);
    public static final ChromaticChord FFMaj9 = new ChromaticChord(ChromaticChordEnum.FFMaj9);
    public static final ChromaticChord GMaj9 = new ChromaticChord(ChromaticChordEnum.GMaj9);
    public static final ChromaticChord GGMaj9 = new ChromaticChord(ChromaticChordEnum.GGMaj9);
    public static final ChromaticChord AMaj9 = new ChromaticChord(ChromaticChordEnum.AMaj9);
    public static final ChromaticChord AAMaj9 = new ChromaticChord(ChromaticChordEnum.AAMaj9);
    public static final ChromaticChord BMaj9 = new ChromaticChord(ChromaticChordEnum.BMaj9);

    // Menor novena mayor
    public static final ChromaticChord CmMaj9 = new ChromaticChord(ChromaticChordEnum.CmMaj9);
    public static final ChromaticChord CCmMaj9 = new ChromaticChord(ChromaticChordEnum.CCmMaj9);
    public static final ChromaticChord DmMaj9 = new ChromaticChord(ChromaticChordEnum.DmMaj9);
    public static final ChromaticChord DDmMaj9 = new ChromaticChord(ChromaticChordEnum.DDmMaj9);
    public static final ChromaticChord EmMaj9 = new ChromaticChord(ChromaticChordEnum.EmMaj9);
    public static final ChromaticChord FmMaj9 = new ChromaticChord(ChromaticChordEnum.FmMaj9);
    public static final ChromaticChord FFmMaj9 = new ChromaticChord(ChromaticChordEnum.FFmMaj9);
    public static final ChromaticChord GmMaj9 = new ChromaticChord(ChromaticChordEnum.GmMaj9);
    public static final ChromaticChord GGmMaj9 = new ChromaticChord(ChromaticChordEnum.GGmMaj9);
    public static final ChromaticChord AmMaj9 = new ChromaticChord(ChromaticChordEnum.AmMaj9);
    public static final ChromaticChord AAmMaj9 = new ChromaticChord(ChromaticChordEnum.AAmMaj9);
    public static final ChromaticChord BmMaj9 = new ChromaticChord(ChromaticChordEnum.BmMaj9);

    // Novena con sexta (añadida)
    public static final ChromaticChord C9add6 = new ChromaticChord(ChromaticChordEnum.C9add6);
    public static final ChromaticChord CC9add6 = new ChromaticChord(ChromaticChordEnum.CC9add6);
    public static final ChromaticChord D9add6 = new ChromaticChord(ChromaticChordEnum.D9add6);
    public static final ChromaticChord DD9add6 = new ChromaticChord(ChromaticChordEnum.DD9add6);
    public static final ChromaticChord E9add6 = new ChromaticChord(ChromaticChordEnum.E9add6);
    public static final ChromaticChord F9add6 = new ChromaticChord(ChromaticChordEnum.F9add6);
    public static final ChromaticChord FF9add6 = new ChromaticChord(ChromaticChordEnum.FF9add6);
    public static final ChromaticChord G9add6 = new ChromaticChord(ChromaticChordEnum.G9add6);
    public static final ChromaticChord GG9add6 = new ChromaticChord(ChromaticChordEnum.GG9add6);
    public static final ChromaticChord A9add6 = new ChromaticChord(ChromaticChordEnum.A9add6);
    public static final ChromaticChord AA9add6 = new ChromaticChord(ChromaticChordEnum.AA9add6);
    public static final ChromaticChord B9add6 = new ChromaticChord(ChromaticChordEnum.B9add6);

    // Novena con onceava aumentada (añadida)
    public static final ChromaticChord C9a11 = new ChromaticChord(ChromaticChordEnum.C9a11);
    public static final ChromaticChord CC9a11 = new ChromaticChord(ChromaticChordEnum.CC9a11);
    public static final ChromaticChord D9a11 = new ChromaticChord(ChromaticChordEnum.D9a11);
    public static final ChromaticChord DD9a11 = new ChromaticChord(ChromaticChordEnum.DD9a11);
    public static final ChromaticChord E9a11 = new ChromaticChord(ChromaticChordEnum.E9a11);
    public static final ChromaticChord F9a11 = new ChromaticChord(ChromaticChordEnum.F9a11);
    public static final ChromaticChord FF9a11 = new ChromaticChord(ChromaticChordEnum.FF9a11);
    public static final ChromaticChord G9a11 = new ChromaticChord(ChromaticChordEnum.G9a11);
    public static final ChromaticChord GG9a11 = new ChromaticChord(ChromaticChordEnum.GG9a11);
    public static final ChromaticChord A9a11 = new ChromaticChord(ChromaticChordEnum.A9a11);
    public static final ChromaticChord AA9a11 = new ChromaticChord(ChromaticChordEnum.AA9a11);
    public static final ChromaticChord B9a11 = new ChromaticChord(ChromaticChordEnum.B9a11);

    // Novena mayor con onceava aumentada (añadida)
    public static final ChromaticChord CMaj9a11 = new ChromaticChord(ChromaticChordEnum.CMaj9a11);
    public static final ChromaticChord CCMaj9a11 = new ChromaticChord(ChromaticChordEnum.CCMaj9a11);
    public static final ChromaticChord DMaj9a11 = new ChromaticChord(ChromaticChordEnum.DMaj9a11);
    public static final ChromaticChord DDMaj9a11 = new ChromaticChord(ChromaticChordEnum.DDMaj9a11);
    public static final ChromaticChord EMaj9a11 = new ChromaticChord(ChromaticChordEnum.EMaj9a11);
    public static final ChromaticChord FMaj9a11 = new ChromaticChord(ChromaticChordEnum.FMaj9a11);
    public static final ChromaticChord FFMaj9a11 = new ChromaticChord(ChromaticChordEnum.FFMaj9a11);
    public static final ChromaticChord GMaj9a11 = new ChromaticChord(ChromaticChordEnum.GMaj9a11);
    public static final ChromaticChord GGMaj9a11 = new ChromaticChord(ChromaticChordEnum.GGMaj9a11);
    public static final ChromaticChord AMaj9a11 = new ChromaticChord(ChromaticChordEnum.AMaj9a11);
    public static final ChromaticChord AAMaj9a11 = new ChromaticChord(ChromaticChordEnum.AAMaj9a11);
    public static final ChromaticChord BMaj9a11 = new ChromaticChord(ChromaticChordEnum.BMaj9a11);

    // Onceava
    public static final ChromaticChord C11 = new ChromaticChord(ChromaticChordEnum.C11);
    public static final ChromaticChord CC11 = new ChromaticChord(ChromaticChordEnum.CC11);
    public static final ChromaticChord D11 = new ChromaticChord(ChromaticChordEnum.D11);
    public static final ChromaticChord DD11 = new ChromaticChord(ChromaticChordEnum.DD11);
    public static final ChromaticChord E11 = new ChromaticChord(ChromaticChordEnum.E11);
    public static final ChromaticChord F11 = new ChromaticChord(ChromaticChordEnum.F11);
    public static final ChromaticChord FF11 = new ChromaticChord(ChromaticChordEnum.FF11);
    public static final ChromaticChord G11 = new ChromaticChord(ChromaticChordEnum.G11);
    public static final ChromaticChord GG11 = new ChromaticChord(ChromaticChordEnum.GG11);
    public static final ChromaticChord A11 = new ChromaticChord(ChromaticChordEnum.A11);
    public static final ChromaticChord AA11 = new ChromaticChord(ChromaticChordEnum.AA11);
    public static final ChromaticChord B11 = new ChromaticChord(ChromaticChordEnum.B11);

    // Menor onceava
    public static final ChromaticChord Cm11 = new ChromaticChord(ChromaticChordEnum.Cm11);
    public static final ChromaticChord CCm11 = new ChromaticChord(ChromaticChordEnum.CCm11);
    public static final ChromaticChord Dm11 = new ChromaticChord(ChromaticChordEnum.Dm11);
    public static final ChromaticChord DDm11 = new ChromaticChord(ChromaticChordEnum.DDm11);
    public static final ChromaticChord Em11 = new ChromaticChord(ChromaticChordEnum.Em11);
    public static final ChromaticChord Fm11 = new ChromaticChord(ChromaticChordEnum.Fm11);
    public static final ChromaticChord FFm11 = new ChromaticChord(ChromaticChordEnum.FFm11);
    public static final ChromaticChord Gm11 = new ChromaticChord(ChromaticChordEnum.Gm11);
    public static final ChromaticChord GGm11 = new ChromaticChord(ChromaticChordEnum.GGm11);
    public static final ChromaticChord Am11 = new ChromaticChord(ChromaticChordEnum.Am11);
    public static final ChromaticChord AAm11 = new ChromaticChord(ChromaticChordEnum.AAm11);
    public static final ChromaticChord Bm11 = new ChromaticChord(ChromaticChordEnum.Bm11);

    // Onceava con novena bemol
    public static final ChromaticChord C11b9 = new ChromaticChord(ChromaticChordEnum.C11b9);
    public static final ChromaticChord CC11b9 = new ChromaticChord(ChromaticChordEnum.CC11b9);
    public static final ChromaticChord D11b9 = new ChromaticChord(ChromaticChordEnum.D11b9);
    public static final ChromaticChord DD11b9 = new ChromaticChord(ChromaticChordEnum.DD11b9);
    public static final ChromaticChord E11b9 = new ChromaticChord(ChromaticChordEnum.E11b9);
    public static final ChromaticChord F11b9 = new ChromaticChord(ChromaticChordEnum.F11b9);
    public static final ChromaticChord FF11b9 = new ChromaticChord(ChromaticChordEnum.FF11b9);
    public static final ChromaticChord G11b9 = new ChromaticChord(ChromaticChordEnum.G11b9);
    public static final ChromaticChord GG11b9 = new ChromaticChord(ChromaticChordEnum.GG11b9);
    public static final ChromaticChord A11b9 = new ChromaticChord(ChromaticChordEnum.A11b9);
    public static final ChromaticChord AA11b9 = new ChromaticChord(ChromaticChordEnum.AA11b9);
    public static final ChromaticChord B11b9 = new ChromaticChord(ChromaticChordEnum.B11b9);

    // Onceava con novena aumentada
    public static final ChromaticChord C11a9 = new ChromaticChord(ChromaticChordEnum.C11a9);
    public static final ChromaticChord CC11a9 = new ChromaticChord(ChromaticChordEnum.CC11a9);
    public static final ChromaticChord D11a9 = new ChromaticChord(ChromaticChordEnum.D11a9);
    public static final ChromaticChord DD11a9 = new ChromaticChord(ChromaticChordEnum.DD11a9);
    public static final ChromaticChord E11a9 = new ChromaticChord(ChromaticChordEnum.E11a9);
    public static final ChromaticChord F11a9 = new ChromaticChord(ChromaticChordEnum.F11a9);
    public static final ChromaticChord FF11a9 = new ChromaticChord(ChromaticChordEnum.FF11a9);
    public static final ChromaticChord G11a9 = new ChromaticChord(ChromaticChordEnum.G11a9);
    public static final ChromaticChord GG11a9 = new ChromaticChord(ChromaticChordEnum.GG11a9);
    public static final ChromaticChord A11a9 = new ChromaticChord(ChromaticChordEnum.A11a9);
    public static final ChromaticChord AA11a9 = new ChromaticChord(ChromaticChordEnum.AA11a9);
    public static final ChromaticChord B11a9 = new ChromaticChord(ChromaticChordEnum.B11a9);

    // Onceava mayor
    public static final ChromaticChord CMaj11 = new ChromaticChord(ChromaticChordEnum.CMaj11);
    public static final ChromaticChord CCMaj11 = new ChromaticChord(ChromaticChordEnum.CCMaj11);
    public static final ChromaticChord DMaj11 = new ChromaticChord(ChromaticChordEnum.DMaj11);
    public static final ChromaticChord DDMaj11 = new ChromaticChord(ChromaticChordEnum.DDMaj11);
    public static final ChromaticChord EMaj11 = new ChromaticChord(ChromaticChordEnum.EMaj11);
    public static final ChromaticChord FMaj11 = new ChromaticChord(ChromaticChordEnum.FMaj11);
    public static final ChromaticChord FFMaj11 = new ChromaticChord(ChromaticChordEnum.FFMaj11);
    public static final ChromaticChord GMaj11 = new ChromaticChord(ChromaticChordEnum.GMaj11);
    public static final ChromaticChord GGMaj11 = new ChromaticChord(ChromaticChordEnum.GGMaj11);
    public static final ChromaticChord AMaj11 = new ChromaticChord(ChromaticChordEnum.AMaj11);
    public static final ChromaticChord AAMaj11 = new ChromaticChord(ChromaticChordEnum.AAMaj11);
    public static final ChromaticChord BMaj11 = new ChromaticChord(ChromaticChordEnum.BMaj11);

    // Menor onceava mayor
    public static final ChromaticChord CmMaj11 = new ChromaticChord(ChromaticChordEnum.CmMaj11);
    public static final ChromaticChord CCmMaj11 = new ChromaticChord(ChromaticChordEnum.CCmMaj11);
    public static final ChromaticChord DmMaj11 = new ChromaticChord(ChromaticChordEnum.DmMaj11);
    public static final ChromaticChord DDmMaj11 = new ChromaticChord(ChromaticChordEnum.DDmMaj11);
    public static final ChromaticChord EmMaj11 = new ChromaticChord(ChromaticChordEnum.EmMaj11);
    public static final ChromaticChord FmMaj11 = new ChromaticChord(ChromaticChordEnum.FmMaj11);
    public static final ChromaticChord FFmMaj11 = new ChromaticChord(ChromaticChordEnum.FFmMaj11);
    public static final ChromaticChord GmMaj11 = new ChromaticChord(ChromaticChordEnum.GmMaj11);
    public static final ChromaticChord GGmMaj11 = new ChromaticChord(ChromaticChordEnum.GGmMaj11);
    public static final ChromaticChord AmMaj11 = new ChromaticChord(ChromaticChordEnum.AmMaj11);
    public static final ChromaticChord AAmMaj11 = new ChromaticChord(ChromaticChordEnum.AAmMaj11);
    public static final ChromaticChord BmMaj11 = new ChromaticChord(ChromaticChordEnum.BmMaj11);

    // Menor treceava
    public static final ChromaticChord Cm13 = new ChromaticChord(ChromaticChordEnum.Cm13);
    public static final ChromaticChord CCm13 = new ChromaticChord(ChromaticChordEnum.CCm13);
    public static final ChromaticChord Dm13 = new ChromaticChord(ChromaticChordEnum.Dm13);
    public static final ChromaticChord DDm13 = new ChromaticChord(ChromaticChordEnum.DDm13);
    public static final ChromaticChord Em13 = new ChromaticChord(ChromaticChordEnum.Em13);
    public static final ChromaticChord Fm13 = new ChromaticChord(ChromaticChordEnum.Fm13);
    public static final ChromaticChord FFm13 = new ChromaticChord(ChromaticChordEnum.FFm13);
    public static final ChromaticChord Gm13 = new ChromaticChord(ChromaticChordEnum.Gm13);
    public static final ChromaticChord GGm13 = new ChromaticChord(ChromaticChordEnum.GGm13);
    public static final ChromaticChord Am13 = new ChromaticChord(ChromaticChordEnum.Am13);
    public static final ChromaticChord AAm13 = new ChromaticChord(ChromaticChordEnum.AAm13);
    public static final ChromaticChord Bm13 = new ChromaticChord(ChromaticChordEnum.Bm13);

    // Treceava con cuarta suspendida
    public static final ChromaticChord C13sus4 = new ChromaticChord(ChromaticChordEnum.C13sus4);
    public static final ChromaticChord CC13sus4 = new ChromaticChord(ChromaticChordEnum.CC13sus4);
    public static final ChromaticChord D13sus4 = new ChromaticChord(ChromaticChordEnum.D13sus4);
    public static final ChromaticChord DD13sus4 = new ChromaticChord(ChromaticChordEnum.DD13sus4);
    public static final ChromaticChord E13sus4 = new ChromaticChord(ChromaticChordEnum.E13sus4);
    public static final ChromaticChord F13sus4 = new ChromaticChord(ChromaticChordEnum.F13sus4);
    public static final ChromaticChord FF13sus4 = new ChromaticChord(ChromaticChordEnum.FF13sus4);
    public static final ChromaticChord G13sus4 = new ChromaticChord(ChromaticChordEnum.G13sus4);
    public static final ChromaticChord GG13sus4 = new ChromaticChord(ChromaticChordEnum.GG13sus4);
    public static final ChromaticChord A13sus4 = new ChromaticChord(ChromaticChordEnum.A13sus4);
    public static final ChromaticChord AA13sus4 = new ChromaticChord(ChromaticChordEnum.AA13sus4);
    public static final ChromaticChord B13sus4 = new ChromaticChord(ChromaticChordEnum.B13sus4);

    // Treceava con quinta bemol
    public static final ChromaticChord C13b5 = new ChromaticChord(ChromaticChordEnum.C13b5);
    public static final ChromaticChord CC13b5 = new ChromaticChord(ChromaticChordEnum.CC13b5);
    public static final ChromaticChord D13b5 = new ChromaticChord(ChromaticChordEnum.D13b5);
    public static final ChromaticChord DD13b5 = new ChromaticChord(ChromaticChordEnum.DD13b5);
    public static final ChromaticChord E13b5 = new ChromaticChord(ChromaticChordEnum.E13b5);
    public static final ChromaticChord F13b5 = new ChromaticChord(ChromaticChordEnum.F13b5);
    public static final ChromaticChord FF13b5 = new ChromaticChord(ChromaticChordEnum.FF13b5);
    public static final ChromaticChord G13b5 = new ChromaticChord(ChromaticChordEnum.G13b5);
    public static final ChromaticChord GG13b5 = new ChromaticChord(ChromaticChordEnum.GG13b5);
    public static final ChromaticChord A13b5 = new ChromaticChord(ChromaticChordEnum.A13b5);
    public static final ChromaticChord AA13b5 = new ChromaticChord(ChromaticChordEnum.AA13b5);
    public static final ChromaticChord B13b5 = new ChromaticChord(ChromaticChordEnum.B13b5);

    // Treceava con quinta aumentada
    public static final ChromaticChord C13a5 = new ChromaticChord(ChromaticChordEnum.C13a5);
    public static final ChromaticChord CC13a5 = new ChromaticChord(ChromaticChordEnum.CC13a5);
    public static final ChromaticChord D13a5 = new ChromaticChord(ChromaticChordEnum.D13a5);
    public static final ChromaticChord DD13a5 = new ChromaticChord(ChromaticChordEnum.DD13a5);
    public static final ChromaticChord E13a5 = new ChromaticChord(ChromaticChordEnum.E13a5);
    public static final ChromaticChord F13a5 = new ChromaticChord(ChromaticChordEnum.F13a5);
    public static final ChromaticChord FF13a5 = new ChromaticChord(ChromaticChordEnum.FF13a5);
    public static final ChromaticChord G13a5 = new ChromaticChord(ChromaticChordEnum.G13a5);
    public static final ChromaticChord GG13a5 = new ChromaticChord(ChromaticChordEnum.GG13a5);
    public static final ChromaticChord A13a5 = new ChromaticChord(ChromaticChordEnum.A13a5);
    public static final ChromaticChord AA13a5 = new ChromaticChord(ChromaticChordEnum.AA13a5);
    public static final ChromaticChord B13a5 = new ChromaticChord(ChromaticChordEnum.B13a5);

    // Treceava con novena bemol
    public static final ChromaticChord C13b9 = new ChromaticChord(ChromaticChordEnum.C13b9);
    public static final ChromaticChord CC13b9 = new ChromaticChord(ChromaticChordEnum.CC13b9);
    public static final ChromaticChord D13b9 = new ChromaticChord(ChromaticChordEnum.D13b9);
    public static final ChromaticChord DD13b9 = new ChromaticChord(ChromaticChordEnum.DD13b9);
    public static final ChromaticChord E13b9 = new ChromaticChord(ChromaticChordEnum.E13b9);
    public static final ChromaticChord F13b9 = new ChromaticChord(ChromaticChordEnum.F13b9);
    public static final ChromaticChord FF13b9 = new ChromaticChord(ChromaticChordEnum.FF13b9);
    public static final ChromaticChord G13b9 = new ChromaticChord(ChromaticChordEnum.G13b9);
    public static final ChromaticChord GG13b9 = new ChromaticChord(ChromaticChordEnum.GG13b9);
    public static final ChromaticChord A13b9 = new ChromaticChord(ChromaticChordEnum.A13b9);
    public static final ChromaticChord AA13b9 = new ChromaticChord(ChromaticChordEnum.AA13b9);
    public static final ChromaticChord B13b9 = new ChromaticChord(ChromaticChordEnum.B13b9);

    // Treceava con novena aumentada
    public static final ChromaticChord C13a9 = new ChromaticChord(ChromaticChordEnum.C13a9);
    public static final ChromaticChord CC13a9 = new ChromaticChord(ChromaticChordEnum.CC13a9);
    public static final ChromaticChord D13a9 = new ChromaticChord(ChromaticChordEnum.D13a9);
    public static final ChromaticChord DD13a9 = new ChromaticChord(ChromaticChordEnum.DD13a9);
    public static final ChromaticChord E13a9 = new ChromaticChord(ChromaticChordEnum.E13a9);
    public static final ChromaticChord F13a9 = new ChromaticChord(ChromaticChordEnum.F13a9);
    public static final ChromaticChord FF13a9 = new ChromaticChord(ChromaticChordEnum.FF13a9);
    public static final ChromaticChord G13a9 = new ChromaticChord(ChromaticChordEnum.G13a9);
    public static final ChromaticChord GG13a9 = new ChromaticChord(ChromaticChordEnum.GG13a9);
    public static final ChromaticChord A13a9 = new ChromaticChord(ChromaticChordEnum.A13a9);
    public static final ChromaticChord AA13a9 = new ChromaticChord(ChromaticChordEnum.AA13a9);
    public static final ChromaticChord B13a9 = new ChromaticChord(ChromaticChordEnum.B13a9);

    // Treceava con quinta y novena bemoles
    public static final ChromaticChord C13b5b9 = new ChromaticChord(ChromaticChordEnum.C13b5b9);
    public static final ChromaticChord CC13b5b9 = new ChromaticChord(ChromaticChordEnum.CC13b5b9);
    public static final ChromaticChord D13b5b9 = new ChromaticChord(ChromaticChordEnum.D13b5b9);
    public static final ChromaticChord DD13b5b9 = new ChromaticChord(ChromaticChordEnum.DD13b5b9);
    public static final ChromaticChord E13b5b9 = new ChromaticChord(ChromaticChordEnum.E13b5b9);
    public static final ChromaticChord F13b5b9 = new ChromaticChord(ChromaticChordEnum.F13b5b9);
    public static final ChromaticChord FF13b5b9 = new ChromaticChord(ChromaticChordEnum.FF13b5b9);
    public static final ChromaticChord G13b5b9 = new ChromaticChord(ChromaticChordEnum.G13b5b9);
    public static final ChromaticChord GG13b5b9 = new ChromaticChord(ChromaticChordEnum.GG13b5b9);
    public static final ChromaticChord A13b5b9 = new ChromaticChord(ChromaticChordEnum.A13b5b9);
    public static final ChromaticChord AA13b5b9 = new ChromaticChord(ChromaticChordEnum.AA13b5b9);
    public static final ChromaticChord B13b5b9 = new ChromaticChord(ChromaticChordEnum.B13b5b9);

    // Treceava con quinta bemol y novena aumentada
    public static final ChromaticChord C13b5a9 = new ChromaticChord(ChromaticChordEnum.C13b5a9);
    public static final ChromaticChord CC13b5a9 = new ChromaticChord(ChromaticChordEnum.CC13b5a9);
    public static final ChromaticChord D13b5a9 = new ChromaticChord(ChromaticChordEnum.D13b5a9);
    public static final ChromaticChord DD13b5a9 = new ChromaticChord(ChromaticChordEnum.DD13b5a9);
    public static final ChromaticChord E13b5a9 = new ChromaticChord(ChromaticChordEnum.E13b5a9);
    public static final ChromaticChord F13b5a9 = new ChromaticChord(ChromaticChordEnum.F13b5a9);
    public static final ChromaticChord FF13b5a9 = new ChromaticChord(ChromaticChordEnum.FF13b5a9);
    public static final ChromaticChord G13b5a9 = new ChromaticChord(ChromaticChordEnum.G13b5a9);
    public static final ChromaticChord GG13b5a9 = new ChromaticChord(ChromaticChordEnum.GG13b5a9);
    public static final ChromaticChord A13b5a9 = new ChromaticChord(ChromaticChordEnum.A13b5a9);
    public static final ChromaticChord AA13b5a9 = new ChromaticChord(ChromaticChordEnum.AA13b5a9);
    public static final ChromaticChord B13b5a9 = new ChromaticChord(ChromaticChordEnum.B13b5a9);

    // Treceava con quinta aumentada y novena bemol
    public static final ChromaticChord C13a5b9 = new ChromaticChord(ChromaticChordEnum.C13a5b9);
    public static final ChromaticChord CC13a5b9 = new ChromaticChord(ChromaticChordEnum.CC13a5b9);
    public static final ChromaticChord D13a5b9 = new ChromaticChord(ChromaticChordEnum.D13a5b9);
    public static final ChromaticChord DD13a5b9 = new ChromaticChord(ChromaticChordEnum.DD13a5b9);
    public static final ChromaticChord E13a5b9 = new ChromaticChord(ChromaticChordEnum.E13a5b9);
    public static final ChromaticChord F13a5b9 = new ChromaticChord(ChromaticChordEnum.F13a5b9);
    public static final ChromaticChord FF13a5b9 = new ChromaticChord(ChromaticChordEnum.FF13a5b9);
    public static final ChromaticChord G13a5b9 = new ChromaticChord(ChromaticChordEnum.G13a5b9);
    public static final ChromaticChord GG13a5b9 = new ChromaticChord(ChromaticChordEnum.GG13a5b9);
    public static final ChromaticChord A13a5b9 = new ChromaticChord(ChromaticChordEnum.A13a5b9);
    public static final ChromaticChord AA13a5b9 = new ChromaticChord(ChromaticChordEnum.AA13a5b9);
    public static final ChromaticChord B13a5b9 = new ChromaticChord(ChromaticChordEnum.B13a5b9);

    // Treceava con quinta y novena aumentadas
    public static final ChromaticChord C13a5a9 = new ChromaticChord(ChromaticChordEnum.C13a5a9);
    public static final ChromaticChord CC13a5a9 = new ChromaticChord(ChromaticChordEnum.CC13a5a9);
    public static final ChromaticChord D13a5a9 = new ChromaticChord(ChromaticChordEnum.D13a5a9);
    public static final ChromaticChord DD13a5a9 = new ChromaticChord(ChromaticChordEnum.DD13a5a9);
    public static final ChromaticChord E13a5a9 = new ChromaticChord(ChromaticChordEnum.E13a5a9);
    public static final ChromaticChord F13a5a9 = new ChromaticChord(ChromaticChordEnum.F13a5a9);
    public static final ChromaticChord FF13a5a9 = new ChromaticChord(ChromaticChordEnum.FF13a5a9);
    public static final ChromaticChord G13a5a9 = new ChromaticChord(ChromaticChordEnum.G13a5a9);
    public static final ChromaticChord GG13a5a9 = new ChromaticChord(ChromaticChordEnum.GG13a5a9);
    public static final ChromaticChord A13a5a9 = new ChromaticChord(ChromaticChordEnum.A13a5a9);
    public static final ChromaticChord AA13a5a9 = new ChromaticChord(ChromaticChordEnum.AA13a5a9);
    public static final ChromaticChord B13a5a9 = new ChromaticChord(ChromaticChordEnum.B13a5a9);

    // Treceava mayor
    public static final ChromaticChord CMaj13 = new ChromaticChord(ChromaticChordEnum.CMaj13);
    public static final ChromaticChord CCMaj13 = new ChromaticChord(ChromaticChordEnum.CCMaj13);
    public static final ChromaticChord DMaj13 = new ChromaticChord(ChromaticChordEnum.DMaj13);
    public static final ChromaticChord DDMaj13 = new ChromaticChord(ChromaticChordEnum.DDMaj13);
    public static final ChromaticChord EMaj13 = new ChromaticChord(ChromaticChordEnum.EMaj13);
    public static final ChromaticChord FMaj13 = new ChromaticChord(ChromaticChordEnum.FMaj13);
    public static final ChromaticChord FFMaj13 = new ChromaticChord(ChromaticChordEnum.FFMaj13);
    public static final ChromaticChord GMaj13 = new ChromaticChord(ChromaticChordEnum.GMaj13);
    public static final ChromaticChord GGMaj13 = new ChromaticChord(ChromaticChordEnum.GGMaj13);
    public static final ChromaticChord AMaj13 = new ChromaticChord(ChromaticChordEnum.AMaj13);
    public static final ChromaticChord AAMaj13 = new ChromaticChord(ChromaticChordEnum.AAMaj13);
    public static final ChromaticChord BMaj13 = new ChromaticChord(ChromaticChordEnum.BMaj13);

    // Menor treceava mayor
    public static final ChromaticChord CmMaj13 = new ChromaticChord(ChromaticChordEnum.CmMaj13);
    public static final ChromaticChord CCmMaj13 = new ChromaticChord(ChromaticChordEnum.CCmMaj13);
    public static final ChromaticChord DmMaj13 = new ChromaticChord(ChromaticChordEnum.DmMaj13);
    public static final ChromaticChord DDmMaj13 = new ChromaticChord(ChromaticChordEnum.DDmMaj13);
    public static final ChromaticChord EmMaj13 = new ChromaticChord(ChromaticChordEnum.EmMaj13);
    public static final ChromaticChord FmMaj13 = new ChromaticChord(ChromaticChordEnum.FmMaj13);
    public static final ChromaticChord FFmMaj13 = new ChromaticChord(ChromaticChordEnum.FFmMaj13);
    public static final ChromaticChord GmMaj13 = new ChromaticChord(ChromaticChordEnum.GmMaj13);
    public static final ChromaticChord GGmMaj13 = new ChromaticChord(ChromaticChordEnum.GGmMaj13);
    public static final ChromaticChord AmMaj13 = new ChromaticChord(ChromaticChordEnum.AmMaj13);
    public static final ChromaticChord AAmMaj13 = new ChromaticChord(ChromaticChordEnum.AAmMaj13);
    public static final ChromaticChord BmMaj13 = new ChromaticChord(ChromaticChordEnum.BmMaj13);

    // Treceava mayor con quinta bemol
    public static final ChromaticChord CMaj13b5 = new ChromaticChord(ChromaticChordEnum.CMaj13b5);
    public static final ChromaticChord CCMaj13b5 = new ChromaticChord(ChromaticChordEnum.CCMaj13b5);
    public static final ChromaticChord DMaj13b5 = new ChromaticChord(ChromaticChordEnum.DMaj13b5);
    public static final ChromaticChord DDMaj13b5 = new ChromaticChord(ChromaticChordEnum.DDMaj13b5);
    public static final ChromaticChord EMaj13b5 = new ChromaticChord(ChromaticChordEnum.EMaj13b5);
    public static final ChromaticChord FMaj13b5 = new ChromaticChord(ChromaticChordEnum.FMaj13b5);
    public static final ChromaticChord FFMaj13b5 = new ChromaticChord(ChromaticChordEnum.FFMaj13b5);
    public static final ChromaticChord GMaj13b5 = new ChromaticChord(ChromaticChordEnum.GMaj13b5);
    public static final ChromaticChord GGMaj13b5 = new ChromaticChord(ChromaticChordEnum.GGMaj13b5);
    public static final ChromaticChord AMaj13b5 = new ChromaticChord(ChromaticChordEnum.AMaj13b5);
    public static final ChromaticChord AAMaj13b5 = new ChromaticChord(ChromaticChordEnum.AAMaj13b5);
    public static final ChromaticChord BMaj13b5 = new ChromaticChord(ChromaticChordEnum.BMaj13b5);

    // Treceava mayor con quinta aumentada
    public static final ChromaticChord CMaj13a5 = new ChromaticChord(ChromaticChordEnum.CMaj13a5);
    public static final ChromaticChord CCMaj13a5 = new ChromaticChord(ChromaticChordEnum.CCMaj13a5);
    public static final ChromaticChord DMaj13a5 = new ChromaticChord(ChromaticChordEnum.DMaj13a5);
    public static final ChromaticChord DDMaj13a5 = new ChromaticChord(ChromaticChordEnum.DDMaj13a5);
    public static final ChromaticChord EMaj13a5 = new ChromaticChord(ChromaticChordEnum.EMaj13a5);
    public static final ChromaticChord FMaj13a5 = new ChromaticChord(ChromaticChordEnum.FMaj13a5);
    public static final ChromaticChord FFMaj13a5 = new ChromaticChord(ChromaticChordEnum.FFMaj13a5);
    public static final ChromaticChord GMaj13a5 = new ChromaticChord(ChromaticChordEnum.GMaj13a5);
    public static final ChromaticChord GGMaj13a5 = new ChromaticChord(ChromaticChordEnum.GGMaj13a5);
    public static final ChromaticChord AMaj13a5 = new ChromaticChord(ChromaticChordEnum.AMaj13a5);
    public static final ChromaticChord AAMaj13a5 = new ChromaticChord(ChromaticChordEnum.AAMaj13a5);
    public static final ChromaticChord BMaj13a5 = new ChromaticChord(ChromaticChordEnum.BMaj13a5);

    // Treceava mayor con novena bemol
    public static final ChromaticChord CMaj13b9 = new ChromaticChord(ChromaticChordEnum.CMaj13b9);
    public static final ChromaticChord CCMaj13b9 = new ChromaticChord(ChromaticChordEnum.CCMaj13b9);
    public static final ChromaticChord DMaj13b9 = new ChromaticChord(ChromaticChordEnum.DMaj13b9);
    public static final ChromaticChord DDMaj13b9 = new ChromaticChord(ChromaticChordEnum.DDMaj13b9);
    public static final ChromaticChord EMaj13b9 = new ChromaticChord(ChromaticChordEnum.EMaj13b9);
    public static final ChromaticChord FMaj13b9 = new ChromaticChord(ChromaticChordEnum.FMaj13b9);
    public static final ChromaticChord FFMaj13b9 = new ChromaticChord(ChromaticChordEnum.FFMaj13b9);
    public static final ChromaticChord GMaj13b9 = new ChromaticChord(ChromaticChordEnum.GMaj13b9);
    public static final ChromaticChord GGMaj13b9 = new ChromaticChord(ChromaticChordEnum.GGMaj13b9);
    public static final ChromaticChord AMaj13b9 = new ChromaticChord(ChromaticChordEnum.AMaj13b9);
    public static final ChromaticChord AAMaj13b9 = new ChromaticChord(ChromaticChordEnum.AAMaj13b9);
    public static final ChromaticChord BMaj13b9 = new ChromaticChord(ChromaticChordEnum.BMaj13b9);

    // Treceava mayor con novena aumentada
    public static final ChromaticChord CMaj13a9 = new ChromaticChord(ChromaticChordEnum.CMaj13a9);
    public static final ChromaticChord CCMaj13a9 = new ChromaticChord(ChromaticChordEnum.CCMaj13a9);
    public static final ChromaticChord DMaj13a9 = new ChromaticChord(ChromaticChordEnum.DMaj13a9);
    public static final ChromaticChord DDMaj13a9 = new ChromaticChord(ChromaticChordEnum.DDMaj13a9);
    public static final ChromaticChord EMaj13a9 = new ChromaticChord(ChromaticChordEnum.EMaj13a9);
    public static final ChromaticChord FMaj13a9 = new ChromaticChord(ChromaticChordEnum.FMaj13a9);
    public static final ChromaticChord FFMaj13a9 = new ChromaticChord(ChromaticChordEnum.FFMaj13a9);
    public static final ChromaticChord GMaj13a9 = new ChromaticChord(ChromaticChordEnum.GMaj13a9);
    public static final ChromaticChord GGMaj13a9 = new ChromaticChord(ChromaticChordEnum.GGMaj13a9);
    public static final ChromaticChord AMaj13a9 = new ChromaticChord(ChromaticChordEnum.AMaj13a9);
    public static final ChromaticChord AAMaj13a9 = new ChromaticChord(ChromaticChordEnum.AAMaj13a9);
    public static final ChromaticChord BMaj13a9 = new ChromaticChord(ChromaticChordEnum.BMaj13a9);

    // Treceava mayor con quinta y novena bemoles
    public static final ChromaticChord CMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.CMaj13b5b9);
    public static final ChromaticChord CCMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.CCMaj13b5b9);
    public static final ChromaticChord DMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.DMaj13b5b9);
    public static final ChromaticChord DDMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.DDMaj13b5b9);
    public static final ChromaticChord EMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.EMaj13b5b9);
    public static final ChromaticChord FMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.FMaj13b5b9);
    public static final ChromaticChord FFMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.FFMaj13b5b9);
    public static final ChromaticChord GMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.GMaj13b5b9);
    public static final ChromaticChord GGMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.GGMaj13b5b9);
    public static final ChromaticChord AMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.AMaj13b5b9);
    public static final ChromaticChord AAMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.AAMaj13b5b9);
    public static final ChromaticChord BMaj13b5b9 = new ChromaticChord(ChromaticChordEnum.BMaj13b5b9);

    // Treceava mayor con novena aumentada
    public static final ChromaticChord CMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.CMaj13b5a9);
    public static final ChromaticChord CCMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.CCMaj13b5a9);
    public static final ChromaticChord DMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.DMaj13b5a9);
    public static final ChromaticChord DDMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.DDMaj13b5a9);
    public static final ChromaticChord EMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.EMaj13b5a9);
    public static final ChromaticChord FMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.FMaj13b5a9);
    public static final ChromaticChord FFMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.FFMaj13b5a9);
    public static final ChromaticChord GMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.GMaj13b5a9);
    public static final ChromaticChord GGMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.GGMaj13b5a9);
    public static final ChromaticChord AMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.AMaj13b5a9);
    public static final ChromaticChord AAMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.AAMaj13b5a9);
    public static final ChromaticChord BMaj13b5a9 = new ChromaticChord(ChromaticChordEnum.BMaj13b5a9);

    // Treceava mayor con quinta aumentada y novena bemol
    public static final ChromaticChord CMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.CMaj13a5b9);
    public static final ChromaticChord CCMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.CCMaj13a5b9);
    public static final ChromaticChord DMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.DMaj13a5b9);
    public static final ChromaticChord DDMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.DDMaj13a5b9);
    public static final ChromaticChord EMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.EMaj13a5b9);
    public static final ChromaticChord FMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.FMaj13a5b9);
    public static final ChromaticChord FFMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.FFMaj13a5b9);
    public static final ChromaticChord GMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.GMaj13a5b9);
    public static final ChromaticChord GGMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.GGMaj13a5b9);
    public static final ChromaticChord AMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.AMaj13a5b9);
    public static final ChromaticChord AAMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.AAMaj13a5b9);
    public static final ChromaticChord BMaj13a5b9 = new ChromaticChord(ChromaticChordEnum.BMaj13a5b9);

    // Treceava mayor con quinta y novena aumentadas
    public static final ChromaticChord CMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.CMaj13a5a9);
    public static final ChromaticChord CCMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.CCMaj13a5a9);
    public static final ChromaticChord DMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.DMaj13a5a9);
    public static final ChromaticChord DDMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.DDMaj13a5a9);
    public static final ChromaticChord EMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.EMaj13a5a9);
    public static final ChromaticChord FMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.FMaj13a5a9);
    public static final ChromaticChord FFMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.FFMaj13a5a9);
    public static final ChromaticChord GMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.GMaj13a5a9);
    public static final ChromaticChord GGMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.GGMaj13a5a9);
    public static final ChromaticChord AMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.AMaj13a5a9);
    public static final ChromaticChord AAMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.AAMaj13a5a9);
    public static final ChromaticChord BMaj13a5a9 = new ChromaticChord(ChromaticChordEnum.BMaj13a5a9);

    public static final ChromaticChord Csusa4 = new ChromaticChord(ChromaticChordEnum.Csusa4);
    public static final ChromaticChord CCsusa4 = new ChromaticChord(ChromaticChordEnum.CCsusa4);
    public static final ChromaticChord Dsusa4 = new ChromaticChord(ChromaticChordEnum.Dsusa4);
    public static final ChromaticChord DDsusa4 = new ChromaticChord(ChromaticChordEnum.DDsusa4);
    public static final ChromaticChord Esusa4 = new ChromaticChord(ChromaticChordEnum.Esusa4);
    public static final ChromaticChord Fsusa4 = new ChromaticChord(ChromaticChordEnum.Fsusa4);
    public static final ChromaticChord FFsusa4 = new ChromaticChord(ChromaticChordEnum.FFsusa4);
    public static final ChromaticChord Gsusa4 = new ChromaticChord(ChromaticChordEnum.Gsusa4);
    public static final ChromaticChord GGsusa4 = new ChromaticChord(ChromaticChordEnum.GGsusa4);
    public static final ChromaticChord Asusa4 = new ChromaticChord(ChromaticChordEnum.Asusa4);
    public static final ChromaticChord AAsusa4 = new ChromaticChord(ChromaticChordEnum.AAsusa4);
    public static final ChromaticChord Bsusa4 = new ChromaticChord(ChromaticChordEnum.Bsusa4);

    public static final ChromaticChord Csusb2 = new ChromaticChord(ChromaticChordEnum.Csusb2);
    public static final ChromaticChord CCsusb2 = new ChromaticChord(ChromaticChordEnum.CCsusb2);
    public static final ChromaticChord Dsusb2 = new ChromaticChord(ChromaticChordEnum.Dsusb2);
    public static final ChromaticChord DDsusb2 = new ChromaticChord(ChromaticChordEnum.DDsusb2);
    public static final ChromaticChord Esusb2 = new ChromaticChord(ChromaticChordEnum.Esusb2);
    public static final ChromaticChord Fsusb2 = new ChromaticChord(ChromaticChordEnum.Fsusb2);
    public static final ChromaticChord FFsusb2 = new ChromaticChord(ChromaticChordEnum.FFsusb2);
    public static final ChromaticChord Gsusb2 = new ChromaticChord(ChromaticChordEnum.Gsusb2);
    public static final ChromaticChord GGsusb2 = new ChromaticChord(ChromaticChordEnum.GGsusb2);
    public static final ChromaticChord Asusb2 = new ChromaticChord(ChromaticChordEnum.Asusb2);
    public static final ChromaticChord AAsusb2 = new ChromaticChord(ChromaticChordEnum.AAsusb2);
    public static final ChromaticChord Bsusb2 = new ChromaticChord(ChromaticChordEnum.Bsusb2);

    public static final ChromaticChord Csusb2b5 = new ChromaticChord(ChromaticChordEnum.Csusb2b5);
    public static final ChromaticChord CCsusb2b5 = new ChromaticChord(ChromaticChordEnum.CCsusb2b5);
    public static final ChromaticChord Dsusb2b5 = new ChromaticChord(ChromaticChordEnum.Dsusb2b5);
    public static final ChromaticChord DDsusb2b5 = new ChromaticChord(ChromaticChordEnum.DDsusb2b5);
    public static final ChromaticChord Esusb2b5 = new ChromaticChord(ChromaticChordEnum.Esusb2b5);
    public static final ChromaticChord Fsusb2b5 = new ChromaticChord(ChromaticChordEnum.Fsusb2b5);
    public static final ChromaticChord FFsusb2b5 = new ChromaticChord(ChromaticChordEnum.FFsusb2b5);
    public static final ChromaticChord Gsusb2b5 = new ChromaticChord(ChromaticChordEnum.Gsusb2b5);
    public static final ChromaticChord GGsusb2b5 = new ChromaticChord(ChromaticChordEnum.GGsusb2b5);
    public static final ChromaticChord Asusb2b5 = new ChromaticChord(ChromaticChordEnum.Asusb2b5);
    public static final ChromaticChord AAsusb2b5 = new ChromaticChord(ChromaticChordEnum.AAsusb2b5);
    public static final ChromaticChord Bsusb2b5 = new ChromaticChord(ChromaticChordEnum.Bsusb2b5);


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
            ChromaticChord.Bm13
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
            ChromaticChord.B13sus4
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
            ChromaticChord.B13b5
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
            ChromaticChord.B13a5
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
            ChromaticChord.B13b9
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
            ChromaticChord.B13a9
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
            ChromaticChord.B13b5b9
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
            ChromaticChord.B13b5a9
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
            ChromaticChord.B13a5b9
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
            ChromaticChord.B13a5a9
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
            ChromaticChord.BMaj13
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
            ChromaticChord.BmMaj13
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
            ChromaticChord.BMaj13b5
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
            ChromaticChord.BMaj13a5
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
            ChromaticChord.BMaj13b9
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
            ChromaticChord.BMaj13a9
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
            ChromaticChord.BMaj13b5b9
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
            ChromaticChord.BMaj13b5a9
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
            ChromaticChord.BMaj13a5b9
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
            ChromaticChord.BMaj13a5a9
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
