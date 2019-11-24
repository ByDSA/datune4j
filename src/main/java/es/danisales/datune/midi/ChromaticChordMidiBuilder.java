package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChromaticChordMidiBuilder extends es.danisales.utils.building.Builder<ChromaticChordMidiBuilder, ChromaticChordMidi> {
    private List<Chromatic> fromChromatic;
    private List<ChromaticMidi> fromChromaticMidi;
    private int _octave;
    private int _length;
    private int _velocity;

    ChromaticChordMidiBuilder() {
    }

    public ChromaticChordMidiBuilder fromChromatic(@NonNull Chromatic... cs) {
        fromChromatic = Arrays.asList(cs);

        return self();
    }

    public ChromaticChordMidiBuilder fromChromaticMidi(@NonNull ChromaticMidi... cs) {
        fromChromaticMidi = Arrays.asList(cs);

        return self();
    }

    public ChromaticChordMidiBuilder fromChromatic(@NonNull Iterable<Chromatic> cs) {
        fromChromatic = new ArrayList<>();
        for (Chromatic c : cs)
            fromChromatic.add(c);

        return self();
    }

    public ChromaticChordMidiBuilder fromChromaticMidi(@NonNull Iterable<ChromaticMidi> cs) {
        fromChromaticMidi = new ArrayList<>();
        for (ChromaticMidi c : cs)
            fromChromaticMidi.add(c);

        return self();
    }

    public ChromaticChordMidiBuilder octaveBase(int octave) {
        this._octave = octave;

        return self();
    }

    public ChromaticChordMidiBuilder length(int length) {
        this._length = length;

        return self();
    }

    public ChromaticChordMidiBuilder velocity(int velocity) {
        this._velocity = velocity;

        return self();
    }

    @NonNull
    @Override
    public ChromaticChordMidi build() {
        ChromaticChordMidi ns = new ChromaticChordMidi();
        if (fromChromatic != null) {
            for (int i = 0; i < fromChromatic.size(); i++) {
                ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                        .pitch(fromChromatic.get(i))
                        .build();
                if (i > 0) {
                    int lastElementOctave = ns.get(ns.size() - 1).getPitch().getOctave();
                    Chromatic current = fromChromatic.get(i);
                    Chromatic previous = fromChromatic.get(i - 1);
                    if (current.ordinal() < previous.ordinal())
                        chromaticMidi.getPitch().setOctave(lastElementOctave + 1);
                    else
                        chromaticMidi.getPitch().setOctave(lastElementOctave);
                }
                ns.add(chromaticMidi);
            }
        } else if (fromChromaticMidi != null) {

        }

        return ns;
    }


    @Override
    @NonNull
    protected ChromaticChordMidiBuilder self() {
        return this;
    }
}