package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChromaticChordMidiBuilder extends es.danisales.utils.building.Builder<ChromaticChordMidiBuilder, ChromaticChordMidi> {
    private List<Chromatic> fromChromatic;
    private List<ChromaticMidi> fromChromaticMidi;
    private DiatonicChordMidi diatonicChordMidi;
    private int octave = Settings.DefaultValues.OCTAVE;
    private int length = Settings.DefaultValues.LENGTH_CHORD;
    private int velocity = Settings.DefaultValues.VELOCITY;

    ChromaticChordMidiBuilder() {
    }

    public ChromaticChordMidiBuilder fromChromatic(@NonNull Chromatic... cs) throws PitchMidiException {
        return fromChromaticChord(Arrays.asList(cs));
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

    public ChromaticChordMidiBuilder fromChromaticMidi(@NonNull ChromaticMidi... cs) {
        return fromChromaticMidi(Arrays.asList(cs));
    }

    public ChromaticChordMidiBuilder fromChromaticMidi(@NonNull Iterable<ChromaticMidi> cs) {
        fromChromaticMidi = new ArrayList<>();
        for (ChromaticMidi c : cs)
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
    public ChromaticChordMidi build() {
        ChromaticChordMidi chromaticChordMidi = new ChromaticChordMidi();
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

    private void createFromChromaticMidiArrayIfNull() {
        if (fromChromaticMidi == null)
            fromChromaticMidi = new ArrayList<>();
    }

    public @NonNull ChromaticChordMidiBuilder add(@NonNull ChromaticMidi chromaticMidi) {
        createFromChromaticMidiArrayIfNull();
        fromChromaticMidi.add(chromaticMidi);

        return self();
    }

    public @NonNull ChromaticChordMidiBuilder addAll(@NonNull Collection<ChromaticMidi> chromaticMidiCollection) {
        createFromChromaticMidiArrayIfNull();
        fromChromaticMidi.addAll(chromaticMidiCollection);

        return self();
    }

    public @NonNull ChromaticChordMidiBuilder add(@NonNull PitchChromaticMidi pitchChromaticMidi) {
        ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                .pitch(pitchChromaticMidi)
                .build();
        return add(chromaticMidi);
    }

    public @NonNull ChromaticChordMidiBuilder fromDiatonicChordMidi(@NonNull DiatonicChordMidi diatonicChordMidi) {
        this.diatonicChordMidi = diatonicChordMidi;

        return self();
    }


    @Override
    @NonNull
    protected ChromaticChordMidiBuilder self() {
        return this;
    }
}