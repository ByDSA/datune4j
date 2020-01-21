package es.danisales.datune.chords;

import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParametricChordRetrieval {
    private Collection<ChromaticChord> chromaticChords;
    private Collection<Tonality> tonalityList;
    private Collection<HarmonicFunction> harmonicFunctionList;
    private Collection<DiatonicAlt> diatonicAlts;

    ParametricChordRetrieval() {
    }

    public ParametricChordRetrieval from(@NonNull ChromaticChord... chromaticChords) {
        if (this.chromaticChords == null)
            this.chromaticChords = new ArrayList<>();
        this.chromaticChords.addAll( Arrays.asList( Objects.requireNonNull(chromaticChords) ) );

        return this;
    }

    public ParametricChordRetrieval tonalities(@NonNull Collection<Tonality> tonalityList) {
        if (this.tonalityList == null)
            this.tonalityList = new ArrayList<>();

        this.tonalityList.addAll( Objects.requireNonNull(tonalityList) );
        return this;
    }

    public ParametricChordRetrieval tonalities(@NonNull Tonality... tonalityList) {
        if (this.tonalityList == null)
            this.tonalityList = new ArrayList<>();

        this.tonalityList.addAll( Arrays.asList( Objects.requireNonNull(tonalityList) ) );

        return this;
    }

    public ParametricChordRetrieval majorMinorET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_MAJOR_MINOR);
    }

    public ParametricChordRetrieval majorModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_MAJOR_MODES);
    }

    public ParametricChordRetrieval harmonicMinorModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_HARMONIC_MINOR_MODES);
    }

    public ParametricChordRetrieval harmonicMajorModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_HARMONIC_MAJOR_MODES);
    }

    public ParametricChordRetrieval doubleHarmonicModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_DOUBLE_HARMONIC_MODES);
    }

    public ParametricChordRetrieval melodicMinorModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_MELODIC_MINOR_MODES);
    }

    public ParametricChordRetrieval main21ModesET12() {
        majorModesET12();
        harmonicMinorModesET12();
        return melodicMinorModesET12();
    }

    public ParametricChordRetrieval harmonicFunctions(@NonNull Collection<HarmonicFunction> harmonicFunctionList) {
        this.harmonicFunctionList = Objects.requireNonNull(harmonicFunctionList);

        return this;
    }

    public ParametricChordRetrieval harmonicFunctions(@NonNull HarmonicFunction... harmonicFunctionList) {
        this.harmonicFunctionList = Arrays.asList( Objects.requireNonNull(harmonicFunctionList) );

        return this;
    }

    public ParametricChordRetrieval allDiatonicFunctions() {
        return harmonicFunctions( DiatonicFunction.values() );
    }

    public ParametricChordRetrieval tonalityFunctionsAndTensionFunctions() {
        List<HarmonicFunction> harmonicFunctionList = new ArrayList<>();
        harmonicFunctionList.addAll( Arrays.asList(DiatonicFunction.values() ) );
        harmonicFunctionList.addAll( Arrays.asList(ChromaticFunction.TENSIONS) );
        return harmonicFunctions( harmonicFunctionList );
    }

    public ParametricChordRetrieval root(@NonNull DiatonicAlt... diatonicAlts) {
        if (this.diatonicAlts == null)
            this.diatonicAlts = new ArrayList<>();

        this.diatonicAlts.addAll( Arrays.asList( Objects.requireNonNull(diatonicAlts) ) );

        return this;
    }

    public @NonNull List<TonalChord> retrieve() {
        List<TonalChord> parametricChordList = new CopyOnWriteArrayList<>();

        tonalityList.parallelStream().forEach((Tonality tonality) -> {

            if (diatonicAlts == null || diatonicAlts.contains(tonality.getRoot()))
                harmonicFunctionList.parallelStream().forEach((HarmonicFunction harmonicFunction) -> {
                    if (chromaticChords == null) {
                        parametricChordList.add(TonalChord.from(tonality, harmonicFunction));
                        return;
                    }

                    chromaticChords.parallelStream ().forEach((ChromaticChord chromaticChord) -> {
                        ChromaticChord forEachChromaticChord = ChromaticChord.builder()
                                .tonality(tonality)
                                .harmonicFunction(harmonicFunction)
                                .build();

                        if (forEachChromaticChord.innerChord instanceof ChromaticChordImmutable)
                            forEachChromaticChord = forEachChromaticChord.clone();

                        for (int i = 0; i < chromaticChord.size(); i++) {
                            if (chromaticChord.equals(forEachChromaticChord)) {
                                parametricChordList.add(TonalChord.from(tonality, harmonicFunction));
                            }

                            if (i == chromaticChord.size() - 1)
                                break;

                            forEachChromaticChord.inv();
                        }
                    });
                });
        });

        return parametricChordList;
    }
}
