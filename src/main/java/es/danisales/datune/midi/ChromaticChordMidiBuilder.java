package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChromaticChordMidiBuilder extends es.danisales.utils.building.Builder<ChromaticChordMidiBuilder, ChromaticChordMidi> {
    private List<Chromatic> fromChromatic;
    private List<ChromaticMidi> fromChromaticMidi;
    private DiatonicChordMidi diatonicChordMidi;
    private int _octave = Settings.DefaultValues.OCTAVE;
    private int _length = Settings.DefaultValues.LENGTH_CHORD;
    private int _velocity = Settings.DefaultValues.VELOCITY;

    ChromaticChordMidiBuilder() {
    }

    public ChromaticChordMidiBuilder fromChromatic(@NonNull Chromatic... cs) throws PitchMidiException {
        return fromChromatic(Arrays.asList(cs));
    }

    public ChromaticChordMidiBuilder fromChromatic(@NonNull Iterable<Chromatic> cs) throws PitchMidiException {
        fromChromatic = new ArrayList<>();
        for (Chromatic c : cs)
            fromChromatic.add(c);

        return self();
    }

    public ChromaticChordMidiBuilder fromChromaticMidi(@NonNull ChromaticMidi... cs) {
        return fromChromaticMidi(Arrays.asList(cs));
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
        ChromaticChordMidi chromaticChordMidi = new ChromaticChordMidi();
        if (fromChromatic != null) {
            int currentOctave = _octave;
            for (int i = 0; i < fromChromatic.size(); i++) {
                if (i > 0) {
                    Chromatic current = fromChromatic.get(i);
                    Chromatic previous = fromChromatic.get(i - 1);
                    if (current.ordinal() <= previous.ordinal())
                        currentOctave++;
                }

                PitchChromaticMidi pitchChromaticMidi = null;
                try {
                    pitchChromaticMidi = PitchChromaticMidi.from(fromChromatic.get(i), currentOctave);
                } catch (PitchMidiException e) {
                    e.printStackTrace();
                    throw new RuntimeException(); // todo: check argument pitch consistence when add octave or chromaticmidi
                }
                ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                        .pitch(pitchChromaticMidi)
                        .build();
                chromaticChordMidi.add(chromaticMidi);
            }
        } else if (fromChromaticMidi != null) {
            chromaticChordMidi.addAll(fromChromaticMidi);
        } else if (diatonicChordMidi != null) {
            return ChromaticChordMidiAdapter.fromDiatonicChordMidi(diatonicChordMidi);
        }

        return chromaticChordMidi;
    }

    public @NonNull ChromaticChordMidiBuilder fromDiatonicChordMidi(@NonNull DiatonicChordMidi diatonicChordMidi) throws PitchMidiException {
        this.diatonicChordMidi = diatonicChordMidi;

        return self();
    }


    @Override
    @NonNull
    protected ChromaticChordMidiBuilder self() {
        return this;
    }
}