package es.danisales.datune.gravity;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GravityChromaticChords {
    private GravityChromaticChords() {
    }

    private ChromaticChord from;
    private Iterable<ChromaticChord> listChords = ChromaticChord.all_triads();
    private Iterable<Tonality<Chromatic>> tonalities;

    public static GravityChromaticChords getter() {
        return new GravityChromaticChords();
    }

    public GravityChromaticChords from(@NonNull ChromaticChord chromaticChord) {
        from = chromaticChord;

        return this;
    }

    public GravityChromaticChords listChords(@NonNull Iterable<ChromaticChord> chromaticChords) {
        listChords = chromaticChords;

        return this;
    }

    public GravityChromaticChords anyTonalities(@NonNull Iterable<Tonality<Chromatic>> tonalities) {
        this.tonalities = tonalities;

        return this;
    }

    private static Set<NoteTendency[]> getTendenciesCombinations(Set<NoteTendency> tendencies) {
        return TendenciesCombination.getCombinations( new ArrayList<>(tendencies) );
    }

    public Set<ChromaticChord> get() {
        Set<ChromaticChord> ret = new HashSet<>();

        Set<NoteTendency> tendencies = null;/*HarmonicGravitationalTendency.getter()
                .from(from)
                .generate();*/
        Set<NoteTendency[]> tendenciesCombinations = getTendenciesCombinations(tendencies);
        for (NoteTendency[] combination : tendenciesCombinations) {
            Set<Chromatic> toNotes = getToNotes(combination);
            if (tonalities != null)
                listChords = filterAnyTonalities(listChords, tonalities);
            for (ChromaticChord chromaticChord1 : listChords)
                if ( chromaticChord1.containsAll(toNotes))
                    ret.add(chromaticChord1);
        }
        return ret;
    }

    private static Iterable<ChromaticChord> filterAnyTonalities(Iterable<ChromaticChord> chromaticChords, Iterable<Tonality<Chromatic>> tonalities) {
        List<ChromaticChord> ret = new ArrayList<>();
        for (ChromaticChord chromaticChord : chromaticChords)
            for (Tonality<Chromatic> tonality : tonalities) {
                if (tonality.containsAll(chromaticChord)) {
                    ret.add(chromaticChord);
                    break;
                }
            }

        return ret;
    }

    private static Set<Chromatic> getToNotes(@NonNull NoteTendency[] combination) {
        Set<Chromatic> ret = new HashSet<>();
        for (NoteTendency noteTendency : combination)
            ret.add(noteTendency.getTo());

        return ret;
    }
}
