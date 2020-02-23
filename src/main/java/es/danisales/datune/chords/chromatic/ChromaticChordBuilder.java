package es.danisales.datune.chords.chromatic;

import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.chords.diatonicalt.DiatonicAltChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.BuilderOfWays;
import es.danisales.utils.building.BuildingException;
import es.danisales.utils.building.BuildingWay;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ChromaticChordBuilder extends es.danisales.utils.building.Builder<ChromaticChordBuilder, ChromaticChord> implements BuilderOfWays<ChromaticChord> {
    private ChromaticChord chromaticChord;
    private Chromatic chromaticBase;
    private Tonality<Chromatic> tonality;
    private IntervalDiatonic intervalDiatonic;
    private DiatonicDegree diatonicDegree = DiatonicDegree.I;
    private DiatonicDegreePattern diatonicDegreePattern;
    private ChromaticChordPattern chromaticChordPattern;
    private boolean dirty;

    class ChromaticChordWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return chromaticChord != null;
        }

        @Override
        @NonNull
        public ChromaticChord build() {
            return chromaticChord;
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

    class DiatonicChordPatternAndTonalityWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return (diatonicDegreePattern != null || intervalDiatonic != null) && tonality != null;
        }

        @NonNull
        @Override
        public ChromaticChord build() throws BuildingException {
            ChromaticChord ret = new EmptyWay().build();

            if (diatonicDegreePattern == null) {
                diatonicDegreePattern = DiatonicDegreePattern.from(diatonicDegree, intervalDiatonic);
            }

            for (DiatonicDegree diatonicDegree : diatonicDegreePattern) {
                CyclicDegree diatonicAlt;
                try {
                    diatonicAlt = tonality.getNote(diatonicDegree);
                } catch (ScaleRelativeDegreeException e) {
                    throw new BuildingException(e);
                }
                Chromatic chromatic = Chromatic.from(diatonicAlt);
                ret.add(chromatic);
            }

            return ret;
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
            return new ChromaticChord();
        }
    }

    private static final List<Class<? extends BuildingWay<ChromaticChord>>> buildingWays = Arrays.asList(
            EmptyWay.class,
            ChromaticChordWay.class,
            ChromaticBaseAndChromaticChordPatternWay.class,
            DiatonicChordPatternAndTonalityWay.class
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
        try {
            return BuilderOfWays.super.build(); // todo: datils quitar throw BuildingException
        } catch (BuildingException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @NonNull
    @Override
    protected ChromaticChordBuilder self() {
        dirty = true;
        return this;
    }

    public @NonNull ChromaticChordBuilder addAll(@NonNull Collection<Chromatic> chromaticList) {
        if (this.chromaticChord == null)
            this.chromaticChord = new ChromaticChord();
        this.chromaticChord.addAll(chromaticList);
        this.chromaticChord.resetRoot();

        return self();
    }

    public @NonNull ChromaticChordBuilder addAll(@NonNull Chromatic... chromaticChord) {
        return addAll(Arrays.asList(chromaticChord));
    }

    public @NonNull ChromaticChordBuilder chromaticBase(@NonNull Chromatic chromaticBase) {
        this.chromaticBase = Objects.requireNonNull(chromaticBase);

        return self();
    }

    public @NonNull ChromaticChordBuilder diatonicDegreePattern(@NonNull DiatonicDegreePattern diatonicChordPattern) {
        this.diatonicDegreePattern = Objects.requireNonNull(diatonicChordPattern);

        return self();
    }

    public @NonNull ChromaticChordBuilder chromaticChordPattern(@NonNull ChromaticChordPattern chromaticChordPattern) {
        this.chromaticChordPattern = Objects.requireNonNull(chromaticChordPattern);

        return self();
    }

    public @NonNull ChromaticChordBuilder tonality(@NonNull Tonality<Chromatic> tonality) {
        this.tonality = Objects.requireNonNull(tonality);

        return self();
    }

    public @NonNull ChromaticChordBuilder intervalDiatonic(@NonNull IntervalDiatonic intervalDiatonic) {
        this.intervalDiatonic = Objects.requireNonNull(intervalDiatonic);

        return self();
    }

    public @NonNull ChromaticChordBuilder intervalDiatonic(@NonNull DiatonicDegree diatonicDegree, @NonNull IntervalDiatonic intervalDiatonic) {
        this.diatonicDegree = Objects.requireNonNull(diatonicDegree);

        return intervalDiatonic(intervalDiatonic);
    }

    public static @NonNull ChromaticChord from(@NonNull DiatonicAltChord diatonicChord) {
        ChromaticChord chromaticChord = new ChromaticChord();

        for (DiatonicAlt diatonicAlt : diatonicChord) {
            Chromatic chromatic = Chromatic.from(diatonicAlt);
            chromaticChord.add(chromatic);
        }

        return chromaticChord;
    }
}
