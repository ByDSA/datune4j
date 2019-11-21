package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.pitch.SymbolicPitch;

public abstract class Note<N extends PitchMidiInterface<D, I>, D extends RelativeDegree, I extends Interval> implements SymbolicPitch, PitchMidiInterface<D, I>, EventComplex {
    protected int velocity;
    protected int length;
    protected N pitch;

    public final int getLength() {
        return length;
    }

    public final int getVelocity() {
        return velocity;
    }

    public final void setVelocity(int v) {
        velocity = v;
    }

    public final void setLength(int d) {
        length = d;
    }

    public final N getPitch() {
        return pitch;
    }

    public abstract Note<N, D, I> clone();
}
