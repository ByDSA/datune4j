package es.danisales.datune.chords.chromatic;

import es.danisales.datune.chords.Chord;
import es.danisales.datune.chords.IntervalShifter;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.interval.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

@SuppressWarnings("WeakerAccess")
public final class ChromaticChord
        extends Chord<Chromatic>
        implements IntervalShifter<IntervalChromatic> {
    // Fifths
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

    // Majors
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

    // Minors
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

    // Augmented
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

    // Diminished
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

    // sus4
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

    // Dominant 7th
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

    // 7b5
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

    // 7#5
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

    // 7sus4
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

    // 7th minor
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

    // 7th minor b5
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

    // 7th minor #5
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

    // 6th
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

    // 6th minor
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

    // 6th sus4
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

    // Maj7
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

    // Maj7 minor
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

    // 6th add9
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

    // 6th minor add9
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

    // 7th add b9
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

    // 7th add #9
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

    // 7th minor add b9
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

    // 7th add 11
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

    // 7th add 13
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

    // 9th
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

    // 9th minor
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

    // 9th b5
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

    // 9th #9
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

    // 9th sus4
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

    // Maj9
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

    // Maj9 minor
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

    // Menor treceava
    public static final ChromaticChord Cm13omit11 = new ChromaticChord(ChromaticChordEnum.Cm13omit11);
    public static final ChromaticChord CCm13omit11 = new ChromaticChord(ChromaticChordEnum.CCm13omit11);
    public static final ChromaticChord Dm13omit11 = new ChromaticChord(ChromaticChordEnum.Dm13omit11);
    public static final ChromaticChord DDm13omit11 = new ChromaticChord(ChromaticChordEnum.DDm13omit11);
    public static final ChromaticChord Em13omit11 = new ChromaticChord(ChromaticChordEnum.Em13omit11);
    public static final ChromaticChord Fm13omit11 = new ChromaticChord(ChromaticChordEnum.Fm13omit11);
    public static final ChromaticChord FFm13omit11 = new ChromaticChord(ChromaticChordEnum.FFm13omit11);
    public static final ChromaticChord Gm13omit11 = new ChromaticChord(ChromaticChordEnum.Gm13omit11);
    public static final ChromaticChord GGm13omit11 = new ChromaticChord(ChromaticChordEnum.GGm13omit11);
    public static final ChromaticChord Am13omit11 = new ChromaticChord(ChromaticChordEnum.Am13omit11);
    public static final ChromaticChord AAm13omit11 = new ChromaticChord(ChromaticChordEnum.AAm13omit11);
    public static final ChromaticChord Bm13omit11 = new ChromaticChord(ChromaticChordEnum.Bm13omit11);

    // Treceava con cuarta suspendida
    public static final ChromaticChord C13sus4omit11 = new ChromaticChord(ChromaticChordEnum.C13sus4omit11);
    public static final ChromaticChord CC13sus4omit11 = new ChromaticChord(ChromaticChordEnum.CC13sus4omit11);
    public static final ChromaticChord D13sus4omit11 = new ChromaticChord(ChromaticChordEnum.D13sus4omit11);
    public static final ChromaticChord DD13sus4omit11 = new ChromaticChord(ChromaticChordEnum.DD13sus4omit11);
    public static final ChromaticChord E13sus4omit11 = new ChromaticChord(ChromaticChordEnum.E13sus4omit11);
    public static final ChromaticChord F13sus4omit11 = new ChromaticChord(ChromaticChordEnum.F13sus4omit11);
    public static final ChromaticChord FF13sus4omit11 = new ChromaticChord(ChromaticChordEnum.FF13sus4omit11);
    public static final ChromaticChord G13sus4omit11 = new ChromaticChord(ChromaticChordEnum.G13sus4omit11);
    public static final ChromaticChord GG13sus4omit11 = new ChromaticChord(ChromaticChordEnum.GG13sus4omit11);
    public static final ChromaticChord A13sus4omit11 = new ChromaticChord(ChromaticChordEnum.A13sus4omit11);
    public static final ChromaticChord AA13sus4omit11 = new ChromaticChord(ChromaticChordEnum.AA13sus4omit11);
    public static final ChromaticChord B13sus4omit11 = new ChromaticChord(ChromaticChordEnum.B13sus4omit11);

    // Treceava con quinta bemol
    public static final ChromaticChord C13b5omit11 = new ChromaticChord(ChromaticChordEnum.C13b5omit11);
    public static final ChromaticChord CC13b5omit11 = new ChromaticChord(ChromaticChordEnum.CC13b5omit11);
    public static final ChromaticChord D13b5omit11 = new ChromaticChord(ChromaticChordEnum.D13b5omit11);
    public static final ChromaticChord DD13b5omit11 = new ChromaticChord(ChromaticChordEnum.DD13b5omit11);
    public static final ChromaticChord E13b5omit11 = new ChromaticChord(ChromaticChordEnum.E13b5omit11);
    public static final ChromaticChord F13b5omit11 = new ChromaticChord(ChromaticChordEnum.F13b5omit11);
    public static final ChromaticChord FF13b5omit11 = new ChromaticChord(ChromaticChordEnum.FF13b5omit11);
    public static final ChromaticChord G13b5omit11 = new ChromaticChord(ChromaticChordEnum.G13b5omit11);
    public static final ChromaticChord GG13b5omit11 = new ChromaticChord(ChromaticChordEnum.GG13b5omit11);
    public static final ChromaticChord A13b5omit11 = new ChromaticChord(ChromaticChordEnum.A13b5omit11);
    public static final ChromaticChord AA13b5omit11 = new ChromaticChord(ChromaticChordEnum.AA13b5omit11);
    public static final ChromaticChord B13b5omit11 = new ChromaticChord(ChromaticChordEnum.B13b5omit11);

    // Treceava con quinta aumentada
    public static final ChromaticChord C13a5omit11 = new ChromaticChord(ChromaticChordEnum.C13a5omit11);
    public static final ChromaticChord CC13a5omit11 = new ChromaticChord(ChromaticChordEnum.CC13a5omit11);
    public static final ChromaticChord D13a5omit11 = new ChromaticChord(ChromaticChordEnum.D13a5omit11);
    public static final ChromaticChord DD13a5omit11 = new ChromaticChord(ChromaticChordEnum.DD13a5omit11);
    public static final ChromaticChord E13a5omit11 = new ChromaticChord(ChromaticChordEnum.E13a5omit11);
    public static final ChromaticChord F13a5omit11 = new ChromaticChord(ChromaticChordEnum.F13a5omit11);
    public static final ChromaticChord FF13a5omit11 = new ChromaticChord(ChromaticChordEnum.FF13a5omit11);
    public static final ChromaticChord G13a5omit11 = new ChromaticChord(ChromaticChordEnum.G13a5omit11);
    public static final ChromaticChord GG13a5omit11 = new ChromaticChord(ChromaticChordEnum.GG13a5omit11);
    public static final ChromaticChord A13a5omit11 = new ChromaticChord(ChromaticChordEnum.A13a5omit11);
    public static final ChromaticChord AA13a5omit11 = new ChromaticChord(ChromaticChordEnum.AA13a5omit11);
    public static final ChromaticChord B13a5omit11 = new ChromaticChord(ChromaticChordEnum.B13a5omit11);

    // Treceava con novena bemol
    public static final ChromaticChord C13b9omit11 = new ChromaticChord(ChromaticChordEnum.C13b9omit11);
    public static final ChromaticChord CC13b9omit11 = new ChromaticChord(ChromaticChordEnum.CC13b9omit11);
    public static final ChromaticChord D13b9omit11 = new ChromaticChord(ChromaticChordEnum.D13b9omit11);
    public static final ChromaticChord DD13b9omit11 = new ChromaticChord(ChromaticChordEnum.DD13b9omit11);
    public static final ChromaticChord E13b9omit11 = new ChromaticChord(ChromaticChordEnum.E13b9omit11);
    public static final ChromaticChord F13b9omit11 = new ChromaticChord(ChromaticChordEnum.F13b9omit11);
    public static final ChromaticChord FF13b9omit11 = new ChromaticChord(ChromaticChordEnum.FF13b9omit11);
    public static final ChromaticChord G13b9omit11 = new ChromaticChord(ChromaticChordEnum.G13b9omit11);
    public static final ChromaticChord GG13b9omit11 = new ChromaticChord(ChromaticChordEnum.GG13b9omit11);
    public static final ChromaticChord A13b9omit11 = new ChromaticChord(ChromaticChordEnum.A13b9omit11);
    public static final ChromaticChord AA13b9omit11 = new ChromaticChord(ChromaticChordEnum.AA13b9omit11);
    public static final ChromaticChord B13b9omit11 = new ChromaticChord(ChromaticChordEnum.B13b9omit11);

    // Treceava con novena aumentada
    public static final ChromaticChord C13a9omit11 = new ChromaticChord(ChromaticChordEnum.C13a9omit11);
    public static final ChromaticChord CC13a9omit11 = new ChromaticChord(ChromaticChordEnum.CC13a9omit11);
    public static final ChromaticChord D13a9omit11 = new ChromaticChord(ChromaticChordEnum.D13a9omit11);
    public static final ChromaticChord DD13a9omit11 = new ChromaticChord(ChromaticChordEnum.DD13a9omit11);
    public static final ChromaticChord E13a9omit11 = new ChromaticChord(ChromaticChordEnum.E13a9omit11);
    public static final ChromaticChord F13a9omit11 = new ChromaticChord(ChromaticChordEnum.F13a9omit11);
    public static final ChromaticChord FF13a9omit11 = new ChromaticChord(ChromaticChordEnum.FF13a9omit11);
    public static final ChromaticChord G13a9omit11 = new ChromaticChord(ChromaticChordEnum.G13a9omit11);
    public static final ChromaticChord GG13a9omit11 = new ChromaticChord(ChromaticChordEnum.GG13a9omit11);
    public static final ChromaticChord A13a9omit11 = new ChromaticChord(ChromaticChordEnum.A13a9omit11);
    public static final ChromaticChord AA13a9omit11 = new ChromaticChord(ChromaticChordEnum.AA13a9omit11);
    public static final ChromaticChord B13a9omit11 = new ChromaticChord(ChromaticChordEnum.B13a9omit11);

    // Treceava con quinta y novena bemoles
    public static final ChromaticChord C13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.C13b5b9omit11);
    public static final ChromaticChord CC13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.CC13b5b9omit11);
    public static final ChromaticChord D13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.D13b5b9omit11);
    public static final ChromaticChord DD13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.DD13b5b9omit11);
    public static final ChromaticChord E13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.E13b5b9omit11);
    public static final ChromaticChord F13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.F13b5b9omit11);
    public static final ChromaticChord FF13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.FF13b5b9omit11);
    public static final ChromaticChord G13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.G13b5b9omit11);
    public static final ChromaticChord GG13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.GG13b5b9omit11);
    public static final ChromaticChord A13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.A13b5b9omit11);
    public static final ChromaticChord AA13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.AA13b5b9omit11);
    public static final ChromaticChord B13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.B13b5b9omit11);

    // Treceava con quinta bemol y novena aumentada
    public static final ChromaticChord C13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.C13b5a9omit11);
    public static final ChromaticChord CC13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.CC13b5a9omit11);
    public static final ChromaticChord D13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.D13b5a9omit11);
    public static final ChromaticChord DD13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.DD13b5a9omit11);
    public static final ChromaticChord E13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.E13b5a9omit11);
    public static final ChromaticChord F13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.F13b5a9omit11);
    public static final ChromaticChord FF13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.FF13b5a9omit11);
    public static final ChromaticChord G13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.G13b5a9omit11);
    public static final ChromaticChord GG13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.GG13b5a9omit11);
    public static final ChromaticChord A13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.A13b5a9omit11);
    public static final ChromaticChord AA13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.AA13b5a9omit11);
    public static final ChromaticChord B13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.B13b5a9omit11);

    // Treceava con quinta aumentada y novena bemol
    public static final ChromaticChord C13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.C13a5b9omit11);
    public static final ChromaticChord CC13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.CC13a5b9omit11);
    public static final ChromaticChord D13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.D13a5b9omit11);
    public static final ChromaticChord DD13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.DD13a5b9omit11);
    public static final ChromaticChord E13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.E13a5b9omit11);
    public static final ChromaticChord F13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.F13a5b9omit11);
    public static final ChromaticChord FF13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.FF13a5b9omit11);
    public static final ChromaticChord G13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.G13a5b9omit11);
    public static final ChromaticChord GG13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.GG13a5b9omit11);
    public static final ChromaticChord A13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.A13a5b9omit11);
    public static final ChromaticChord AA13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.AA13a5b9omit11);
    public static final ChromaticChord B13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.B13a5b9omit11);

    // Treceava con quinta y novena aumentadas
    public static final ChromaticChord C13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.C13a5a9omit11);
    public static final ChromaticChord CC13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.CC13a5a9omit11);
    public static final ChromaticChord D13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.D13a5a9omit11);
    public static final ChromaticChord DD13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.DD13a5a9omit11);
    public static final ChromaticChord E13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.E13a5a9omit11);
    public static final ChromaticChord F13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.F13a5a9omit11);
    public static final ChromaticChord FF13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.FF13a5a9omit11);
    public static final ChromaticChord G13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.G13a5a9omit11);
    public static final ChromaticChord GG13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.GG13a5a9omit11);
    public static final ChromaticChord A13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.A13a5a9omit11);
    public static final ChromaticChord AA13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.AA13a5a9omit11);
    public static final ChromaticChord B13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.B13a5a9omit11);

    // Treceava mayor
    public static final ChromaticChord CMaj13omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13omit11);
    public static final ChromaticChord CCMaj13omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13omit11);
    public static final ChromaticChord DMaj13omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13omit11);
    public static final ChromaticChord DDMaj13omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13omit11);
    public static final ChromaticChord EMaj13omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13omit11);
    public static final ChromaticChord FMaj13omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13omit11);
    public static final ChromaticChord FFMaj13omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13omit11);
    public static final ChromaticChord GMaj13omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13omit11);
    public static final ChromaticChord GGMaj13omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13omit11);
    public static final ChromaticChord AMaj13omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13omit11);
    public static final ChromaticChord AAMaj13omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13omit11);
    public static final ChromaticChord BMaj13omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13omit11);

    // Menor treceava mayor
    public static final ChromaticChord CmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.CmMaj13omit11);
    public static final ChromaticChord CCmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.CCmMaj13omit11);
    public static final ChromaticChord DmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.DmMaj13omit11);
    public static final ChromaticChord DDmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.DDmMaj13omit11);
    public static final ChromaticChord EmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.EmMaj13omit11);
    public static final ChromaticChord FmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.FmMaj13omit11);
    public static final ChromaticChord FFmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.FFmMaj13omit11);
    public static final ChromaticChord GmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.GmMaj13omit11);
    public static final ChromaticChord GGmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.GGmMaj13omit11);
    public static final ChromaticChord AmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.AmMaj13omit11);
    public static final ChromaticChord AAmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.AAmMaj13omit11);
    public static final ChromaticChord BmMaj13omit11 = new ChromaticChord(ChromaticChordEnum.BmMaj13omit11);

    // Treceava mayor con quinta bemol
    public static final ChromaticChord CMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13b5omit11);
    public static final ChromaticChord CCMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13b5omit11);
    public static final ChromaticChord DMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13b5omit11);
    public static final ChromaticChord DDMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13b5omit11);
    public static final ChromaticChord EMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13b5omit11);
    public static final ChromaticChord FMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13b5omit11);
    public static final ChromaticChord FFMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13b5omit11);
    public static final ChromaticChord GMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13b5omit11);
    public static final ChromaticChord GGMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13b5omit11);
    public static final ChromaticChord AMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13b5omit11);
    public static final ChromaticChord AAMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13b5omit11);
    public static final ChromaticChord BMaj13b5omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13b5omit11);

    // Treceava mayor con quinta aumentada
    public static final ChromaticChord CMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13a5omit11);
    public static final ChromaticChord CCMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13a5omit11);
    public static final ChromaticChord DMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13a5omit11);
    public static final ChromaticChord DDMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13a5omit11);
    public static final ChromaticChord EMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13a5omit11);
    public static final ChromaticChord FMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13a5omit11);
    public static final ChromaticChord FFMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13a5omit11);
    public static final ChromaticChord GMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13a5omit11);
    public static final ChromaticChord GGMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13a5omit11);
    public static final ChromaticChord AMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13a5omit11);
    public static final ChromaticChord AAMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13a5omit11);
    public static final ChromaticChord BMaj13a5omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13a5omit11);

    // Treceava mayor con novena bemol
    public static final ChromaticChord CMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13b9omit11);
    public static final ChromaticChord CCMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13b9omit11);
    public static final ChromaticChord DMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13b9omit11);
    public static final ChromaticChord DDMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13b9omit11);
    public static final ChromaticChord EMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13b9omit11);
    public static final ChromaticChord FMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13b9omit11);
    public static final ChromaticChord FFMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13b9omit11);
    public static final ChromaticChord GMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13b9omit11);
    public static final ChromaticChord GGMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13b9omit11);
    public static final ChromaticChord AMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13b9omit11);
    public static final ChromaticChord AAMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13b9omit11);
    public static final ChromaticChord BMaj13b9omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13b9omit11);

    // Treceava mayor con novena aumentada
    public static final ChromaticChord CMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13a9omit11);
    public static final ChromaticChord CCMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13a9omit11);
    public static final ChromaticChord DMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13a9omit11);
    public static final ChromaticChord DDMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13a9omit11);
    public static final ChromaticChord EMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13a9omit11);
    public static final ChromaticChord FMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13a9omit11);
    public static final ChromaticChord FFMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13a9omit11);
    public static final ChromaticChord GMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13a9omit11);
    public static final ChromaticChord GGMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13a9omit11);
    public static final ChromaticChord AMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13a9omit11);
    public static final ChromaticChord AAMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13a9omit11);
    public static final ChromaticChord BMaj13a9omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13a9omit11);

    // Treceava mayor con quinta y novena bemoles
    public static final ChromaticChord CMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13b5b9omit11);
    public static final ChromaticChord CCMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13b5b9omit11);
    public static final ChromaticChord DMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13b5b9omit11);
    public static final ChromaticChord DDMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13b5b9omit11);
    public static final ChromaticChord EMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13b5b9omit11);
    public static final ChromaticChord FMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13b5b9omit11);
    public static final ChromaticChord FFMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13b5b9omit11);
    public static final ChromaticChord GMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13b5b9omit11);
    public static final ChromaticChord GGMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13b5b9omit11);
    public static final ChromaticChord AMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13b5b9omit11);
    public static final ChromaticChord AAMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13b5b9omit11);
    public static final ChromaticChord BMaj13b5b9omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13b5b9omit11);

    // Treceava mayor con novena aumentada
    public static final ChromaticChord CMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13b5a9omit11);
    public static final ChromaticChord CCMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13b5a9omit11);
    public static final ChromaticChord DMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13b5a9omit11);
    public static final ChromaticChord DDMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13b5a9omit11);
    public static final ChromaticChord EMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13b5a9omit11);
    public static final ChromaticChord FMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13b5a9omit11);
    public static final ChromaticChord FFMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13b5a9omit11);
    public static final ChromaticChord GMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13b5a9omit11);
    public static final ChromaticChord GGMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13b5a9omit11);
    public static final ChromaticChord AMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13b5a9omit11);
    public static final ChromaticChord AAMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13b5a9omit11);
    public static final ChromaticChord BMaj13b5a9omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13b5a9omit11);

    // Treceava mayor con quinta aumentada y novena bemol
    public static final ChromaticChord CMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13a5b9omit11);
    public static final ChromaticChord CCMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13a5b9omit11);
    public static final ChromaticChord DMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13a5b9omit11);
    public static final ChromaticChord DDMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13a5b9omit11);
    public static final ChromaticChord EMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13a5b9omit11);
    public static final ChromaticChord FMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13a5b9omit11);
    public static final ChromaticChord FFMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13a5b9omit11);
    public static final ChromaticChord GMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13a5b9omit11);
    public static final ChromaticChord GGMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13a5b9omit11);
    public static final ChromaticChord AMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13a5b9omit11);
    public static final ChromaticChord AAMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13a5b9omit11);
    public static final ChromaticChord BMaj13a5b9omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13a5b9omit11);

    // Treceava mayor con quinta y novena aumentadas
    public static final ChromaticChord CMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.CMaj13a5a9omit11);
    public static final ChromaticChord CCMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.CCMaj13a5a9omit11);
    public static final ChromaticChord DMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.DMaj13a5a9omit11);
    public static final ChromaticChord DDMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.DDMaj13a5a9omit11);
    public static final ChromaticChord EMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.EMaj13a5a9omit11);
    public static final ChromaticChord FMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.FMaj13a5a9omit11);
    public static final ChromaticChord FFMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.FFMaj13a5a9omit11);
    public static final ChromaticChord GMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.GMaj13a5a9omit11);
    public static final ChromaticChord GGMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.GGMaj13a5a9omit11);
    public static final ChromaticChord AMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.AMaj13a5a9omit11);
    public static final ChromaticChord AAMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.AAMaj13a5a9omit11);
    public static final ChromaticChord BMaj13a5a9omit11 = new ChromaticChord(ChromaticChordEnum.BMaj13a5a9omit11);

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

    /*
     * END CONSTANT CHORDS
     *****************************************************************************************************************/

    public static ChromaticChordBuilder builder() {
        return new ChromaticChordBuilder();
    }

    public static @Nullable ChromaticChord from(@NonNull TonalChord tonalChord) {
        return tonalChord.getTonality().getChord(tonalChord.getHarmonicFunction());
    }

    public static ChromaticChord immutableFrom(@NonNull ChromaticChord chromaticChord) {
        if (chromaticChord.isImmutable())
            return chromaticChord;
        return new ChromaticChord(chromaticChord);
    }

    ChromaticChord() {
        super();
    }

    private ChromaticChord(ChromaticChordEnum chromaticChordInterface) {
        super(chromaticChordInterface);
    }

    private ChromaticChord(ChromaticChord chromaticChord) {
        super(chromaticChord);
    }

    public static ChromaticChordRetrieval retrieval() {
        return new ChromaticChordRetrieval();
    }

    /* Chord */

    @Override
    protected ChromaticChord create() {
        return new ChromaticChord();
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

    /* Object */

    @Override
    public ChromaticChord clone() {
        return (ChromaticChord)super.clone();
    }

    @Override
    public String toString() {
        ChromaticChordEnum chromaticChordImmutable = ChromaticChordEnum.from(this);
        if (chromaticChordImmutable != null)
            return chromaticChordImmutable.toString();

        return super.toString();
    }
}
