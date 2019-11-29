package es.danisales.datune.midi;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.utils.building.Builder;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public final class DiatonicMidiBuilder extends Builder<DiatonicMidiBuilder, DiatonicMidi> {
    private PitchDiatonicMidi pitch;
    private int length;
    private int velocity;

    DiatonicMidiBuilder() {
        length = Settings.DefaultValues.LENGTH_NOTE;
        velocity = Settings.DefaultValues.VELOCITY;
    }

    @NonNull
    @Override
    public DiatonicMidi build() {
        checkArgument(length > 0);
        checkArgument(velocity > 0);
        Objects.requireNonNull(pitch);
        checkArgument(pitch.getOctave() > 0);
        Objects.requireNonNull(pitch.getDegree());

        int dv = pitch.getDegree().ordinal();
        int shiftOctave = (dv < 0 && dv % pitch.getTonality().getScale().size() != 0 ? -1 : 0);
        pitch.shiftOctave(shiftOctave);

        DiatonicMidi dm = new DiatonicMidi();
        dm.setLength( length );
        dm.setVelocity( velocity );
        dm.pitch = pitch;

        return dm;
    }

    @NonNull
    public DiatonicMidiBuilder length(int length) {
        checkArgument(length > 0);
        this.length = length;
        return self();
    }

    @NonNull
    public DiatonicMidiBuilder velocity(int velocity) {
        checkArgument(velocity > 0);
        this.velocity = velocity;
        return self();
    }

    @NonNull
    @Override
    protected DiatonicMidiBuilder self() {
        return this;
    }

    @NonNull
    public DiatonicMidiBuilder pitch(@NonNull PitchDiatonicMidi pitch) {
        this.pitch = pitch;

        return self();
    }

    @NonNull
    public DiatonicMidiBuilder pitch(@NonNull DiatonicDegree diatonicDegree, @NonNull Tonality tonality, int octave) throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(diatonicDegree, tonality, octave);

        return pitch(pitchDiatonicMidi);
    }

    @NonNull
    public DiatonicMidiBuilder from(@NonNull ChromaticMidi chromaticMidi, @NonNull Tonality tonality) throws TonalityException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(chromaticMidi.getPitch(), tonality);

        pitch(pitchDiatonicMidi)
                .length(chromaticMidi.length)
                .velocity(chromaticMidi.velocity);

        return self();
    }
}
