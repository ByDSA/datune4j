package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import es.danisales.utils.building.Builder;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public final class DiatonicMidiBuilder extends Builder<DiatonicMidiBuilder, DiatonicMidi> {
    private Tonality tonality;
    private int octave;
    private DiatonicDegree diatonicDegree;
    private int length;
    private int velocity;

    DiatonicMidiBuilder() {
        length = Settings.DefaultValues.DURATION_NOTE;
        velocity = Settings.DefaultValues.VELOCITY;
    }

    @NonNull
    @Override
    public DiatonicMidi build() {
        checkArgument(length > 0);
        checkArgument(velocity > 0);
        Objects.requireNonNull(tonality);
        checkArgument(octave > 0);
        Objects.requireNonNull(diatonicDegree);

        int dv = diatonicDegree.val();
        octave += ( dv < 0 && dv % tonality.getScale().length() != 0 ? -1 : 0 );

        DiatonicMidi dm = new DiatonicMidi();
        dm.setLength( length );
        dm.setVelocity( velocity );
        dm.tonality = tonality;
        dm.octave = octave;
        dm.degree = diatonicDegree;
        dm.pitch = PitchMidi.from( diatonicDegree, tonality, octave );

        return dm;
    }

    public DiatonicMidiBuilder tonality(@NonNull Tonality tonality) {
        Objects.requireNonNull(tonality);
        this.tonality = tonality;
        return self();
    }

    public DiatonicMidiBuilder octave(int octave) {
        this.octave = octave;
        return self();
    }

    public DiatonicMidiBuilder diatonicDegree(@NonNull DiatonicDegree diatonicDegree) {
        Objects.requireNonNull(diatonicDegree);
        this.diatonicDegree = diatonicDegree;
        return self();
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
}
