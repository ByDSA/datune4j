package es.danisales.datune.chords.tonal;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TonalChordRetrievalChromatic {
    private Collection<ChromaticChord> chromaticChords;
    private Collection<Tonality<Chromatic>> tonalityList;
    private Collection<ChromaticFunction> harmonicFunctionList;
    private Collection<Chromatic> chromatics;

    TonalChordRetrievalChromatic() {
    }

    public TonalChordRetrievalChromatic from(@NonNull ChromaticChord... chromaticChords) {
        if (this.chromaticChords == null)
            this.chromaticChords = new ArrayList<>();
        this.chromaticChords.addAll( Arrays.asList( Objects.requireNonNull(chromaticChords) ) );

        return this;
    }

    public TonalChordRetrievalChromatic tonalities(@NonNull Collection<Tonality<Chromatic>> tonalityList) {
        if (this.tonalityList == null)
            this.tonalityList = new ArrayList<>();

        this.tonalityList.addAll( Objects.requireNonNull(tonalityList) );
        return this;
    }

    public TonalChordRetrievalChromatic tonalities(@NonNull Tonality<Chromatic>... tonalityList) {
        if (this.tonalityList == null)
            this.tonalityList = new ArrayList<>();

        this.tonalityList.addAll( Arrays.asList( Objects.requireNonNull(tonalityList) ) );

        return this;
    }

    public TonalChordRetrievalChromatic majorMinorET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_MAJOR_MINOR);
    }

    public TonalChordRetrievalChromatic majorModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_MAJOR_MODES);
    }

    public TonalChordRetrievalChromatic harmonicMinorModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_HARMONIC_MINOR_MODES);
    }

    public TonalChordRetrievalChromatic harmonicMajorModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_HARMONIC_MAJOR_MODES);
    }

    public TonalChordRetrievalChromatic doubleHarmonicModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_DOUBLE_HARMONIC_MODES);
    }

    public TonalChordRetrievalChromatic melodicMinorModesET12() {
        return tonalities(TonalityRetrieval.ET12.ALL_MELODIC_MINOR_MODES);
    }

    public TonalChordRetrievalChromatic main21ModesET12() {
        majorModesET12();
        harmonicMinorModesET12();
        return melodicMinorModesET12();
    }

    public TonalChordRetrievalChromatic harmonicFunctions(@NonNull Collection<ChromaticFunction> chromaticFunctions) {
        this.harmonicFunctionList = Objects.requireNonNull(chromaticFunctions);

        return this;
    }

    public TonalChordRetrievalChromatic harmonicFunctions(@NonNull ChromaticFunction... chromaticFunctions) {
        this.harmonicFunctionList = Arrays.asList( Objects.requireNonNull(chromaticFunctions) );

        return this;
    }

    public TonalChordRetrievalChromatic allDiatonicFunctions() {
        return harmonicFunctions( DiatonicFunction.values() );
    }

    public TonalChordRetrievalChromatic tonalityFunctionsAndTensionFunctions() {
        List<ChromaticFunction> harmonicFunctionList = new ArrayList<>();
        harmonicFunctionList.addAll( Arrays.asList(DiatonicFunction.values() ) );
        harmonicFunctionList.addAll( SecondaryDominant.ALL );
        return harmonicFunctions( harmonicFunctionList );
    }

    public TonalChordRetrievalChromatic root(@NonNull Chromatic... diatonicAlts) {
        if (this.chromatics == null)
            this.chromatics = new ArrayList<>();

        this.chromatics.addAll( Arrays.asList( Objects.requireNonNull(diatonicAlts) ) );

        return this;
    }

    public @NonNull List<TonalChord> retrieve() {
        List<TonalChord> parametricChordList = new CopyOnWriteArrayList<>();

        tonalityList.parallelStream().forEach((Tonality<Chromatic> tonality) -> {
            if (chromatics == null || chromatics.contains(tonality.getRoot()))
                harmonicFunctionList.parallelStream().forEach((ChromaticFunction harmonicFunction) -> {
                    if (chromaticChords == null) {
                        parametricChordList.add(TonalChord.from(tonality, harmonicFunction));
                        return;
                    }

                    chromaticChords.parallelStream ().forEach((ChromaticChord chromaticChord) -> {
                        ChromaticChord forEachChromaticChord;
                        try {
                            forEachChromaticChord = ChromaticChord.builder()
                                    .tonality(tonality)
                                    .function(harmonicFunction)
                                    .build();
                        } catch (BuildingException e) {
                            return;
                        }

                        if (forEachChromaticChord.isImmutable())
                            forEachChromaticChord = forEachChromaticChord.clone();

                        for (int i = 0; i < chromaticChord.size(); i++) {
                            if (chromaticChord.equals(forEachChromaticChord)) {
                                parametricChordList.add(TonalChord.from(tonality, harmonicFunction));
                                break;
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
