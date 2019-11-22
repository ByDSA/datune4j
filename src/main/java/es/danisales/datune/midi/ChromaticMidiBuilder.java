package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ChromaticMidiBuilder extends es.danisales.utils.building.Builder<ChromaticMidiBuilder, ChromaticMidi> {
    private PitchChromaticMidi pitchChromaticMidi;
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

    public ChromaticMidiBuilder pitch(PitchMidi pitchMidi) {
        pitchChromaticMidi = PitchChromaticMidi.from(pitchMidi);

        return self();
    }

    public ChromaticMidiBuilder pitch(int code) {
        return pitch( PitchChromaticMidi.from(code) );
    }

    public ChromaticMidiBuilder pitch(Chromatic chromatic, int octave) {
        return pitch( PitchChromaticMidi.from(chromatic, octave) );
    }


    public ChromaticMidiBuilder pitch(DiatonicAlt diatonicAlt, int octave) {
        Chromatic chromatic = Chromatic.from(diatonicAlt);
        return pitch( PitchChromaticMidi.from(chromatic, octave) );
    }

    public ChromaticMidiBuilder pitch(Chromatic chromatic) {
        pitchChromaticMidi = PitchChromaticMidi.from(chromatic, Settings.DefaultValues.OCTAVE);

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

    @NonNull
    @Override
    public ChromaticMidi build() {
        ChromaticMidi chromaticMidi = new ChromaticMidi();
        chromaticMidi.pitch = pitchChromaticMidi;
        chromaticMidi.length = length;
        chromaticMidi.velocity = velocity;
        return chromaticMidi;
    }

    @NonNull
    @Override
    protected ChromaticMidiBuilder self() {
        return this;
    }
}
