package es.danisales.datune.chords.tonal;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.tonality.TonalityModern;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TonalChordRetrievalET12 {
    private Collection<ChromaticChord> chromaticChords;
    private Collection<TonalityModern> tonalityList;
    private Collection<? extends HarmonicFunction> harmonicFunctionList;
    private Collection<Chromatic> chromatics;

    TonalChordRetrievalET12() {
    }

    public TonalChordRetrievalET12 from(@NonNull ChromaticChord... chromaticChords) {
        if (this.chromaticChords == null)
            this.chromaticChords = new ArrayList<>();
        this.chromaticChords.addAll( Arrays.asList( Objects.requireNonNull(chromaticChords) ) );

        return this;
    }

    public TonalChordRetrievalET12 tonalities(@NonNull Collection<TonalityModern> tonalityList) {
        if (this.tonalityList == null)
            this.tonalityList = new ArrayList<>();

        this.tonalityList.addAll( Objects.requireNonNull(tonalityList) );
        return this;
    }

    public TonalChordRetrievalET12 tonalities(@NonNull TonalityModern... tonalityList) {
        if (this.tonalityList == null)
            this.tonalityList = new ArrayList<>();

        this.tonalityList.addAll( Arrays.asList( Objects.requireNonNull(tonalityList) ) );

        return this;
    }

    public TonalChordRetrievalET12 majorMinorET12() {
        return tonalities(TonalityRetrieval.ALL_MAJOR_MINOR);
    }

    public TonalChordRetrievalET12 majorModesET12() {
        return tonalities(TonalityRetrieval.ALL_MAJOR_MODES);
    }

    public TonalChordRetrievalET12 harmonicMinorModesET12() {
        return tonalities(TonalityRetrieval.ALL_HARMONIC_MINOR_MODES);
    }

    public TonalChordRetrievalET12 harmonicMajorModesET12() {
        return tonalities(TonalityRetrieval.ALL_HARMONIC_MAJOR_MODES);
    }

    public TonalChordRetrievalET12 doubleHarmonicModesET12() {
        return tonalities(TonalityRetrieval.ALL_DOUBLE_HARMONIC_MODES);
    }

    public TonalChordRetrievalET12 melodicMinorModesET12() {
        return tonalities(TonalityRetrieval.ALL_MELODIC_MINOR_MODES);
    }

    public TonalChordRetrievalET12 main21ModesET12() {
        majorModesET12();
        harmonicMinorModesET12();
        return melodicMinorModesET12();
    }

    public TonalChordRetrievalET12 harmonicFunctions(@NonNull Collection<? extends HarmonicFunction> chromaticFunctions) {
        this.harmonicFunctionList = Objects.requireNonNull(chromaticFunctions);

        return this;
    }

    public TonalChordRetrievalET12 harmonicFunctions(@NonNull HarmonicFunction... chromaticFunctions) {
        this.harmonicFunctionList = Arrays.asList( Objects.requireNonNull(chromaticFunctions) );

        return this;
    }

    public TonalChordRetrievalET12 allDiatonicFunctions() {
        return harmonicFunctions( DiatonicFunction.immutableValues() );
    }

    public TonalChordRetrievalET12 tonalityFunctionsAndTensionFunctions() {
        List<HarmonicFunction> harmonicFunctionList = new ArrayList<>();
        harmonicFunctionList.addAll( DiatonicFunction.immutableValues() );
        harmonicFunctionList.addAll( SecondaryDominant.values() );
        return harmonicFunctions( harmonicFunctionList );
    }

    public TonalChordRetrievalET12 root(@NonNull Chromatic... diatonicAlts) {
        if (this.chromatics == null)
            this.chromatics = new ArrayList<>();

        this.chromatics.addAll( Arrays.asList( Objects.requireNonNull(diatonicAlts) ) );

        return this;
    }

    public @NonNull List<TonalChord> retrieve() {
        List<TonalChord> parametricChordList = new CopyOnWriteArrayList<>();

        tonalityList.parallelStream().forEach((TonalityModern tonality) -> {
            if (chromatics == null || chromatics.contains(tonality.getRoot()))
                harmonicFunctionList.parallelStream().forEach((HarmonicFunction harmonicFunction) -> {
                    if (chromaticChords == null) {
                        parametricChordList.add(TonalChord.from(tonality, harmonicFunction));
                        return;
                    }

                    chromaticChords.parallelStream ().forEach((ChromaticChord chromaticChord) -> {
                        ChromaticChord forEachChromaticChord;

                        try {
                            forEachChromaticChord = harmonicFunction.getChord(tonality);
                            if (forEachChromaticChord == null)
                                throw new RuntimeException();
                        } catch (Exception e) {
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
