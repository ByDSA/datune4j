package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
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
        checkArgument(pitch.octave > 0);
        Objects.requireNonNull(pitch.degree);

        int dv = pitch.degree.ordinal();
        pitch.octave += ( dv < 0 && dv % pitch.tonality.getScale().size() != 0 ? -1 : 0 );

        DiatonicMidi dm = new DiatonicMidi();
        dm.setLength( length );
        dm.setVelocity( velocity );
        dm.pitch = pitch;

        return dm;
    }

    public DiatonicMidiBuilder length(int length) {
        checkArgument(length > 0);
        this.length = length;
        return self();
    }

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

    public DiatonicMidiBuilder pitch(@NonNull PitchDiatonicMidi pitch) {
        this.pitch = pitch;

        return self();
    }

    public DiatonicMidiBuilder pitch(DiatonicDegree diatonicDegree, Tonality tonality, int octave) throws TonalityException, PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(diatonicDegree, tonality, octave);

        return pitch(pitchDiatonicMidi);
    }

    public DiatonicMidiBuilder from(ChromaticMidi chromaticMidi, Tonality tonality) throws TonalityException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(chromaticMidi.getPitch(), tonality);

        pitch(pitchDiatonicMidi)
                .length(chromaticMidi.length)
                .velocity(chromaticMidi.velocity);

        return self();
    }
}
