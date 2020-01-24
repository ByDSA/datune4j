package es.danisales.datune.midi;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChromaticChordMidiBuilder extends es.danisales.utils.building.Builder<ChromaticChordMidiBuilder, ChordMidi> {
    private List<Chromatic> fromChromatic;
    private List<NoteMidi> fromChromaticMidi;
    private int octave = Settings.DefaultValues.OCTAVE;
    private int length = Settings.DefaultValues.LENGTH_CHORD;
    private int velocity = Settings.DefaultValues.VELOCITY;

    ChromaticChordMidiBuilder() {
    }

    public ChromaticChordMidiBuilder fromChromaticChord(@NonNull Iterable<Chromatic> cs) throws PitchMidiException {
        checkValidMidi();
        fromChromatic = new ArrayList<>();
        for (Chromatic c : cs)
            fromChromatic.add(c);

        return self();
    }

    private void checkValidMidi() throws PitchMidiException {
        // todo
    }

    public ChromaticChordMidiBuilder fromChromaticMidi(@NonNull NoteMidi... cs) {
        return fromChromaticMidi(Arrays.asList(cs));
    }

    public ChromaticChordMidiBuilder fromChromaticMidi(@NonNull Iterable<NoteMidi> cs) {
        fromChromaticMidi = new ArrayList<>();
        for (NoteMidi c : cs)
            fromChromaticMidi.add(c);

        return self();
    }

    @SuppressWarnings("WeakerAccess")
    public ChromaticChordMidiBuilder octaveBase(int octave) throws PitchMidiException {
        checkValidMidi();
        this.octave = octave;

        return self();
    }

    public ChromaticChordMidiBuilder length(int length) {
        this.length = length;

        return self();
    }

    public ChromaticChordMidiBuilder velocity(int velocity) {
        this.velocity = velocity;

        return self();
    }

    @NonNull
    @Override
    public ChordMidi build() {
        ChordMidi chromaticChordMidi = new ChordMidi();
        if (fromChromatic != null) {
            int currentOctave = octave;
            for (int i = 0; i < fromChromatic.size(); i++) {
                if (i > 0) {
                    Chromatic current = fromChromatic.get(i);
                    Chromatic previous = fromChromatic.get(i - 1);
                    if (current.ordinal() <= previous.ordinal())
                        currentOctave++;
                }

                PitchChromaticMidi pitchChromaticMidi;
                try {
                    pitchChromaticMidi = PitchChromaticMidi.from(fromChromatic.get(i), currentOctave);
                } catch (PitchMidiException e) {
                    //throw new BuildingException(e);
                    throw new RuntimeException();
                }
                NoteMidi chromaticMidi = NoteMidi.builder()
                        .pitch(pitchChromaticMidi)
                        .build();
                chromaticChordMidi.add(chromaticMidi);
            }
        } else if (fromChromaticMidi != null) {
            chromaticChordMidi.addAll(fromChromaticMidi);
        }

        return chromaticChordMidi;
    }

    private void createFromChromaticMidiArrayIfNull() {
        if (fromChromaticMidi == null)
            fromChromaticMidi = new ArrayList<>();
    }

    public @NonNull ChromaticChordMidiBuilder add(@NonNull NoteMidi chromaticMidi) {
        createFromChromaticMidiArrayIfNull();
        fromChromaticMidi.add(chromaticMidi);

        return self();
    }

    public @NonNull ChromaticChordMidiBuilder addAll(@NonNull Collection<NoteMidi> chromaticMidiCollection) {
        createFromChromaticMidiArrayIfNull();
        fromChromaticMidi.addAll(chromaticMidiCollection);

        return self();
    }

    public @NonNull ChromaticChordMidiBuilder add(@NonNull PitchChromaticMidi pitchChromaticMidi) {
        NoteMidi chromaticMidi = NoteMidi.builder()
                .pitch(pitchChromaticMidi)
                .build();
        return add(chromaticMidi);
    }

    public ChromaticChordMidiBuilder from(TonalChord from) throws PitchMidiException {
        return fromChromaticChord(ChromaticChord.from(from));
    }

    @Override
    @NonNull
    protected ChromaticChordMidiBuilder self() {
        return this;
    }
}