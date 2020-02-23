package es.danisales.datune.chords.chromatic;

import com.google.common.collect.ImmutableSet;
import es.danisales.datastructures.SetUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Set;

public final class ChromaticChordRetrieval {
    ChromaticChordRetrieval() {
    }

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_FIFTH = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_MAJOR = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_MINOR = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_AUGMENTED = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_DIMINISHED = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_SUS4 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_7 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_7b5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_7a5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_7sus4 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m7 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m7b5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m7a5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_6 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_6sus4 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj7 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_mMaj7 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_6add9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m6add9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_7b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));
    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m6 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_7a9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m7b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_7add11 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_7add13 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_9b5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_9a5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_9sus4 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_mMaj9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_9add6 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_9a11 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj9a11 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_11 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m11 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_11b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_11a9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj11 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_mMaj11 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_m13 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13sus4 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13b5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13a5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13a9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13b5b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13b5a9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13a5b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_13a5a9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_mMaj13 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13b5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13a5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13a9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13b5b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13b5a9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13a5b9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_Maj13a5a9 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_SUSa4 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_SUSb2 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> CHORDS_SUSb2b5 = ImmutableSet.copyOf(Arrays.asList(
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
    ));

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> UNUSUAL_CHORDS = SetUtils.concatImmutable(
            CHORDS_SUSb2,
            CHORDS_SUSa4,
            CHORDS_SUSb2b5
    );

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> TRIAD_CHORDS = SetUtils.concatImmutable(
            CHORDS_MAJOR,
            CHORDS_MINOR,
            CHORDS_DIMINISHED,
            CHORDS_AUGMENTED,
            CHORDS_SUS4
    );

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> SEVENTH_CHORDS = SetUtils.concatImmutable(
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

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> SIXTH_CHORDS = SetUtils.concatImmutable(
            CHORDS_6,
            CHORDS_m6,
            CHORDS_6sus4,
            CHORDS_6add9,
            CHORDS_m6add9
    );

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> NINTH_CHORDS = SetUtils.concatImmutable(
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

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> ELEVENTH_CHORDS = SetUtils.concatImmutable(
            CHORDS_11,
            CHORDS_m11,
            CHORDS_11b9,
            CHORDS_11a9,
            CHORDS_Maj11,
            CHORDS_mMaj11
    );

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> THIRTEENTH_CHORDS = SetUtils.concatImmutable(
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

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> PARTIAL_CHORDS = SetUtils.concatImmutable(
            CHORDS_FIFTH
    );

    @SuppressWarnings("WeakerAccess")
    protected static final Set<ChromaticChord> COMMON_CHORDS = SetUtils.concatImmutable(
            TRIAD_CHORDS, SEVENTH_CHORDS, SIXTH_CHORDS, NINTH_CHORDS,
            ELEVENTH_CHORDS, THIRTEENTH_CHORDS, PARTIAL_CHORDS
    );

    public static @NonNull Set<ChromaticChord> immutableValues() {
        return SetUtils.concatImmutable(COMMON_CHORDS, UNUSUAL_CHORDS);
    }


    public static Set<ChromaticChord> all_triads() {
        return TRIAD_CHORDS;
    }
}
