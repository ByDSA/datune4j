package es.danisales.datune.chords.chromatic;

import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.chords.diatonicalt.DiatonicAltChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.tonality.ChordRetrievalFromTonality;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuilderOfWays;
import es.danisales.utils.building.BuildingException;
import es.danisales.utils.building.BuildingWay;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class ChromaticChordBuilder extends es.danisales.utils.building.Builder<ChromaticChordBuilder, ChromaticChord> implements BuilderOfWays<ChromaticChord> {
    private ChromaticChord chromaticChord;
    private Chromatic chromaticBase;
    private Tonality<Chromatic> tonality;
    private IntervalDiatonic intervalDiatonic;
    private DiatonicDegree diatonicDegree = DiatonicDegree.I;
    private DiatonicDegreePattern diatonicDegreePattern;
    private ChromaticChordPattern chromaticChordPattern;
    private DiatonicFunction diatonicFunction;
    private ChromaticFunction chromaticFunction;
    private ChromaticDegreeFunction chromaticDegreeFunction;
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

    class DiatonicFunctionAndTonalityWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return tonality != null && diatonicFunction != null;
        }

        @NonNull
        @Override
        public ChromaticChord build() throws BuildingException {
            try {
                return ChordRetrievalFromTonality.getFromDiatonicFunction(tonality, diatonicFunction);
            } catch (ScaleRelativeDegreeException e) {
                throw new BuildingException(e);
            }
        }
    }

    class ChromaticFunctionAndTonalityWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return tonality != null && chromaticFunction != null;
        }

        @NonNull
        @Override
        public ChromaticChord build() throws BuildingException {
            try {
                return ChordRetrievalFromTonality.getFromChromaticFunction(tonality, chromaticFunction);
            } catch (ScaleRelativeDegreeException e) {
                throw new BuildingException(e);
            }
        }
    }

    class ChromaticDegreeFunctionAndTonalityWay implements BuildingWay<ChromaticChord> {
        @Override
        public boolean isReadyToBuild() {
            return tonality != null && chromaticDegreeFunction != null;
        }

        @NonNull
        @Override
        public ChromaticChord build() throws BuildingException {
            try {
                return ChordRetrievalFromTonality.getFromChromaticFunction(tonality, chromaticDegreeFunction);
            } catch (ScaleRelativeDegreeException e) {
                throw new BuildingException(e);
            }
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
            DiatonicChordPatternAndTonalityWay.class,
            DiatonicFunctionAndTonalityWay.class,
            ChromaticFunctionAndTonalityWay.class,
            ChromaticDegreeFunctionAndTonalityWay.class
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
    public ChromaticChord build() throws BuildingException {
        return BuilderOfWays.super.build();
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

    public ChromaticChordBuilder fromChordMidi(Collection<NoteMidi> chromaticChordMidi) {
        List<Chromatic> list = new ArrayList<>();

        for (NoteMidi chromaticMidi : chromaticChordMidi)
            list.add(chromaticMidi.getPitch().getNote());

        return addAll(list);
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

    public @NonNull ChromaticChordBuilder diatonicFunction(@NonNull DiatonicFunction diatonicFunction) {
        this.diatonicFunction = Objects.requireNonNull(diatonicFunction);

        return self();
    }

    public @NonNull ChromaticChordBuilder harmonicFunction(@NonNull HarmonicFunction harmonicFunction) {
        if (harmonicFunction instanceof DiatonicFunction)
            return diatonicFunction((DiatonicFunction) harmonicFunction);
        else if (harmonicFunction instanceof ChromaticFunction)
            return chromaticFunction((ChromaticFunction) harmonicFunction);
        else if (harmonicFunction instanceof ChromaticDegreeFunction)
            return chromaticDegreeFunction((ChromaticDegreeFunction)harmonicFunction);

        throw NeverHappensException.make("HarmonicFunction must be DiatonicFunction or ChromaticFunction");
    }

    public @NonNull ChromaticChordBuilder chromaticFunction(@NonNull ChromaticFunction chromaticFunction) {
        this.chromaticFunction = Objects.requireNonNull(chromaticFunction);

        return self();
    }

    public @NonNull ChromaticChordBuilder chromaticDegreeFunction(@NonNull ChromaticDegreeFunction chromaticDegreeFunction) {
        this.chromaticDegreeFunction = Objects.requireNonNull(chromaticDegreeFunction);

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
