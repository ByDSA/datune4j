package es.danisales.datune.musical;

import com.google.common.collect.ImmutableList;
import es.danisales.building.BuilderOfWays;
import es.danisales.building.BuildingWay;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.utils.ListUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ChromaticChordBuilder extends es.danisales.utils.building.Builder<ChromaticChordBuilder, ChromaticChord> implements BuilderOfWays<ChromaticChord> {
    private Collection<? extends PitchChromaticSingle> pitchChromaticSingles;
    private Chromatic chromaticBase;
    private Tonality tonality;
    private DiatonicChordPattern diatonicChordPattern;
    private ChromaticChordPattern chromaticChordPattern;
    private DiatonicFunction diatonicFunction;
    private ChromaticFunction chromaticFunction;
    private boolean dirty;

    class PitchChromaticSinglesWay implements BuildingWay<ChromaticChord> {

        @Override
        public boolean isReadyToBuild() {
            return pitchChromaticSingles != null;
        }

        @Override
        @NonNull
        public ChromaticChord build() {
            ChromaticChord ret = new ChromaticChord();
            ret.innerChord = ChromaticChordInterfaceAdapter.from(pitchChromaticSingles);
            return ret;
        }

    }

    class ChromaticBaseAndChromaticChordPatternWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return chromaticBase != null && chromaticChordPattern != null;
        }

        @NonNull
        @Override
        public ChromaticChord build() {
            ChromaticChord ret = new EmptyWay().build();
            int posBase = chromaticBase.ordinal();
            for (Integer diatonic : chromaticChordPattern) {
                int pos = (posBase + diatonic) % Chromatic.NUMBER;
                Chromatic chromatic = Chromatic.from(pos);
                ret.add(chromatic);
            }

            return ret;
        }

    }

    class ChromaticBaseAndDiatonicChordPatternAndTonalityWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return chromaticBase != null && diatonicChordPattern != null && tonality != null;
        }

        @NonNull
        @Override
        public ChromaticChord build() {
            ChromaticChord ret = new EmptyWay().build();

            try {
                int posBase = tonality.getDegreeFrom(chromaticBase).ordinal();
                for (Integer diatonic : diatonicChordPattern) {
                    int pos = (posBase + diatonic) % Diatonic.NUMBER;
                    DiatonicAlt diatonicAlt = tonality.getNotes().get(pos);
                    Chromatic chromatic = Chromatic.from(diatonicAlt);
                    ret.add(chromatic);
                }
            } catch (TonalityException e) {
                throw new RuntimeException();
            }

            return ret;
        }
    }

    class DiatonicFunctionAndTonalityWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return tonality != null && diatonicFunction != null;
        }

        @NonNull
        @Override
        public ChromaticChord build() {
            return tonality.getChordFrom(diatonicFunction);
        }

    }

    class ChromaticFunctionAndTonalityWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return tonality != null && chromaticFunction != null;
        }

        @NonNull
        @Override
        public ChromaticChord build() {
            return tonality.getChordFrom(chromaticFunction);
        }

    }

    class EmptyWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return !dirty;
        }

        @NonNull
        @Override
        public ChromaticChord build() {
            ChromaticChord ret = new ChromaticChord();
            ret.innerChord = ChromaticChordInterfaceAdapter.from(ImmutableList.of());
            return ret;
        }

    }

    private static final List<Class<? extends BuildingWay<ChromaticChord>>> buildingWays = Arrays.asList(
            EmptyWay.class,
            PitchChromaticSinglesWay.class,
            ChromaticBaseAndChromaticChordPatternWay.class,
            ChromaticBaseAndDiatonicChordPatternAndTonalityWay.class,
            DiatonicFunctionAndTonalityWay.class,
            ChromaticFunctionAndTonalityWay.class
    );

    @Override
    public Iterable<Class<? extends BuildingWay<ChromaticChord>>> getBuildingWaysClasses() {
        return buildingWays;
    }

    ChromaticChordBuilder() {
        dirty = false;
    }

    @NonNull
    @Override
    public ChromaticChord build() {
        return BuilderOfWays.super.build();
    }

    @NonNull
    @Override
    protected ChromaticChordBuilder self() {
        dirty = true;
        return this;
    }

    public @NonNull ChromaticChordBuilder fromList(@NonNull Collection<? extends PitchChromaticSingle> chromaticChord) {
        this.pitchChromaticSingles = Objects.requireNonNull(chromaticChord);

        return self();
    }

    public @NonNull ChromaticChordBuilder chromaticBase(@NonNull Chromatic chromaticBase) {
        this.chromaticBase = Objects.requireNonNull(chromaticBase);

        return self();
    }

    public @NonNull ChromaticChordBuilder diatonicChordPattern(@NonNull DiatonicChordPattern diatonicChordPattern) {
        this.diatonicChordPattern = Objects.requireNonNull(diatonicChordPattern);

        return self();
    }

    public @NonNull ChromaticChordBuilder chromaticChordPattern(@NonNull ChromaticChordPattern chromaticChordPattern) {
        this.chromaticChordPattern = Objects.requireNonNull(chromaticChordPattern);

        return self();
    }

    public @NonNull ChromaticChordBuilder tonality(@NonNull Tonality tonality) {
        this.tonality = Objects.requireNonNull(tonality);

        return self();
    }

    public @NonNull ChromaticChordBuilder diatonicFunction(@NonNull DiatonicFunction diatonicFunction) {
        this.diatonicFunction = Objects.requireNonNull(diatonicFunction);

        return self();
    }

    public @NonNull ChromaticChordBuilder chromaticFunction(@NonNull ChromaticFunction chromaticFunction) {
        this.chromaticFunction = Objects.requireNonNull(chromaticFunction);

        return self();
    }

    public static @NonNull ChromaticChord from(@NonNull DiatonicChord diatonicChord, @NonNull Tonality t, @NonNull DiatonicFunction df) {
        ChromaticChord cc = new ChromaticChord();
        cc.innerChord = ChromaticChordInterfaceAdapter.from(ImmutableList.of());

        for (Diatonic d : diatonicChord) {
            Chromatic chromatic = ChromaticAdapter.from(d, t);
            cc.add(chromatic);
        }

        switch (df) {
            case I2:
            case II2:
            case III2:
            case IV2:
            case V2:
            case VI2:
            case VII2:
                for (ChromaticChord c : ListUtils.concatUnmodificable(ChromaticChord.CHORDS_SUS2, ChromaticChord.CHORDS_SUSb2, ChromaticChord.CHORDS_SUSb2b5))
                    if (cc.equals(c)) {
                        return c;
                    }
                break;
            case I4:
            case II4:
            case III4:
            case IV4:
            case V4:
            case VI4:
            case VII4:
                for (ChromaticChord c : ListUtils.concatUnmodificable(ChromaticChord.CHORDS_SUS4, ChromaticChord.CHORDS_SUSa4))
                    if (cc.equals(c)) {
                        return c;
                    }
                break;
            case I6:
            case II6:
            case III6:
            case IV6:
            case V6:
            case VI6:
            case VII6:
                for (ChromaticChord c : ListUtils.concatUnmodificable(ChromaticChord.CHORDS_6, ChromaticChord.CHORDS_m6))
                    if (cc.equals(c)) {
                        return c;
                    }
                break;
        }

        WhatIsIt.updateWhatIsIt((ChromaticChordCustom) cc.innerChord);
        //assert cc.meta.str != null : "meta.str es null: " + cc.notesToString() + " [" + t + "] [" + df + "] " + t.notesToString();

        return cc;
    }
}
