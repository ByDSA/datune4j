package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class ChromaticMidiBuilder extends es.danisales.utils.building.Builder<ChromaticMidiBuilder, ChromaticMidi> {
    private PitchChromaticMidi pitchChromaticMidi;
    private DiatonicMidi diatonicMidi;
    private int velocity;
    private int length;

    ChromaticMidiBuilder() {
        pitchChromaticMidi = Settings.DefaultValues.PITCH_CHROMATIC_MIDI;
        velocity = Settings.DefaultValues.VELOCITY;
        length = Settings.DefaultValues.LENGTH_NOTE;
    }

    public ChromaticMidiBuilder pitch(PitchChromaticMidi pitchMidiEnum) {
        pitchChromaticMidi = pitchMidiEnum;

        return self();
    }

    public ChromaticMidiBuilder pitch(PitchMidi pitchMidi) throws PitchMidiException {
        pitchChromaticMidi = PitchChromaticMidi.from(pitchMidi);

        return self();
    }

    public ChromaticMidiBuilder pitch(int code) throws PitchMidiException {
        return pitch( PitchChromaticMidi.from(code) );
    }

    public ChromaticMidiBuilder pitch(Chromatic chromatic, int octave) throws PitchMidiException {
        return pitch( PitchChromaticMidi.from(chromatic, octave) );
    }


    public ChromaticMidiBuilder pitch(DiatonicAlt diatonicAlt, int octave) throws PitchMidiException {
        Chromatic chromatic = Chromatic.from(diatonicAlt);
        return pitch( PitchChromaticMidi.from(chromatic, octave) );
    }

    public ChromaticMidiBuilder pitch(Chromatic chromatic) {
        try {
            pitchChromaticMidi = PitchChromaticMidi.from(chromatic, Settings.DefaultValues.OCTAVE);
        } catch (PitchMidiException e) {
            throw new RuntimeException("Impossible!");
        }

        return self();
    }

    public ChromaticMidiBuilder velocity(int velocity) {
        this.velocity = velocity;

        return self();
    }

    public ChromaticMidiBuilder length(int length) {
        this.length = length;

        return self();
    }

    public @NonNull ChromaticMidiBuilder from(@NonNull DiatonicMidi diatonicMidi) {
        this.diatonicMidi = Objects.requireNonNull(diatonicMidi);

        return self();
    }

    @NonNull
    @Override
    public ChromaticMidi build() {
        if (diatonicMidi != null) {
            PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(diatonicMidi.pitch);
            return ChromaticMidi.builder()
                    .pitch(pitchChromaticMidi)
                    .velocity(diatonicMidi.velocity)
                    .length(diatonicMidi.length)
                    .build();
        } else {
            ChromaticMidi chromaticMidi = new ChromaticMidi();
            chromaticMidi.pitch = pitchChromaticMidi;
            chromaticMidi.length = length;
            chromaticMidi.velocity = velocity;
            return chromaticMidi;
        }
    }

    @NonNull
    @Override
    protected ChromaticMidiBuilder self() {
        return this;
    }
}
