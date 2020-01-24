package es.danisales.datune.midi;

import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

public class NoteMidiBuilder extends es.danisales.utils.building.Builder<NoteMidiBuilder, NoteMidi> {
    private PitchChromaticMidi pitchNoteMidi;
    private int velocity;
    private int length;

    NoteMidiBuilder() {
        pitchNoteMidi = Settings.DefaultValues.PITCH_CHROMATIC_MIDI;
        velocity = Settings.DefaultValues.VELOCITY;
        length = Settings.DefaultValues.LENGTH_NOTE;
    }

    public NoteMidiBuilder pitch(PitchChromaticMidi pitchNoteMidi1) {
        pitchNoteMidi = pitchNoteMidi1;

        return self();
    }

    public NoteMidiBuilder pitch(PitchMidi pitchMidi) throws PitchMidiException {
        pitchNoteMidi = PitchChromaticMidi.from(pitchMidi);

        return self();
    }

    public NoteMidiBuilder pitch(int code) throws PitchMidiException {
        return pitch( PitchChromaticMidi.from(code) );
    }

    public NoteMidiBuilder pitch(Chromatic chromatic, int octave) throws PitchMidiException {
        return pitch( PitchChromaticMidi.from(chromatic, octave) );
    }


    public NoteMidiBuilder pitch(DiatonicAlt diatonicAlt, int octave) throws PitchMidiException {
        Chromatic chromatic = Chromatic.from(diatonicAlt);
        return pitch( PitchChromaticMidi.from(chromatic, octave) );
    }

    public NoteMidiBuilder pitch(Chromatic chromatic) {
        try {
            pitchNoteMidi = PitchChromaticMidi.from(chromatic, Settings.DefaultValues.OCTAVE);
        } catch (PitchMidiException e) {
            NeverHappensException.msg("Un Chromatic con la octava por defecto siempre va a ser válido.");
        }

        return self();
    }

    public NoteMidiBuilder velocity(int velocity) {
        this.velocity = velocity;

        return self();
    }

    public NoteMidiBuilder length(int length) {
        this.length = length;

        return self();
    }

    @NonNull
    @Override
    public NoteMidi build() {
        NoteMidi chromaticMidi = new NoteMidi();
        chromaticMidi.pitch = pitchNoteMidi;
        chromaticMidi.length = length;
        chromaticMidi.velocity = velocity;
        return chromaticMidi;
    }

    @NonNull
    @Override
    protected NoteMidiBuilder self() {
        return this;
    }
}
