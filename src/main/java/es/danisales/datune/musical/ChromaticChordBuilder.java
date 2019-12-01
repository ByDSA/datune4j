package es.danisales.datune.musical;

import com.google.common.collect.ImmutableList;
import es.danisales.building.BuilderOfWays;
import es.danisales.building.BuildingException;
import es.danisales.building.BuildingWay;
import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class ChromaticChordBuilder extends es.danisales.utils.building.Builder<ChromaticChordBuilder, ChromaticChord> implements BuilderOfWays<ChromaticChord> {
    private Collection<Chromatic> pitchChromaticSingles;
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
        public ChromaticChord build() throws BuildingException {
            try {
                return tonality.getChordFrom(chromaticFunction);
            } catch (TonalityException e) {
                throw new BuildingException(e.getMessage());
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
    public ChromaticChord build() { // todo: datild: throws BuildingException
        try {
            return BuilderOfWays.super.build();
        } catch (BuildingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @NonNull
    @Override
    protected ChromaticChordBuilder self() {
        dirty = true;
        return this;
    }

    public @NonNull ChromaticChordBuilder fromChromatic(@NonNull Collection<Chromatic> chromaticChord) {
        this.pitchChromaticSingles = Objects.requireNonNull(chromaticChord);

        return self();
    }

    public ChromaticChordBuilder fromChromaticMidi(Collection<ChromaticMidi> chromaticChordMidi) {
        List<Chromatic> list = new ArrayList<>();

        for (ChromaticMidi chromaticMidi : chromaticChordMidi)
            list.add(chromaticMidi.getPitch().getChromatic());

        return fromChromatic(list);
    }

    public @NonNull ChromaticChordBuilder fromChromatic(@NonNull Chromatic... chromaticChord) {
        return fromChromatic(Arrays.asList(chromaticChord));
    }

    public ChromaticChordBuilder fromDiatonicChordMidi(DiatonicChordMidi diatonicChordMidi) {
        tonality = diatonicChordMidi.getTonality();

        pitchChromaticSingles = new ArrayList<>();
        for (DiatonicMidi diatonicMidi : diatonicChordMidi) {
            PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(diatonicMidi.getPitch());
            Chromatic chromatic = pitchChromaticMidi.getChromatic();
            pitchChromaticSingles.add(chromatic);
        }

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

    public static @NonNull ChromaticChord from(@NonNull DiatonicChord diatonicChord, @NonNull Tonality tonality) throws TonalityException {
        ChromaticChord chromaticChord = new ChromaticChord();
        chromaticChord.innerChord = ChromaticChordInterfaceAdapter.from(ImmutableList.of());

        for (Diatonic diatonic : diatonicChord) {
            Chromatic chromatic = Chromatic.from(diatonic, tonality);
            chromaticChord.add(chromatic);
        }

        return chromaticChord;
    }
}
