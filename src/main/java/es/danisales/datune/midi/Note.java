package es.danisales.datune.midi;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.NoteOff;
import es.danisales.datune.midi.Events.NoteOn;
import es.danisales.datune.pitch.SymbolicPitch;

public abstract class Note<P extends PitchMidiInterface> implements SymbolicPitch, EventComplex {
    protected int velocity;
    protected int length;
    protected P pitch;

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

    public final P getPitch() {
        return pitch;
    }

    public abstract Note<P> clone();

    @Override
    public final EventSequence getEvents() {
        EventSequence es = new EventSequence();
        es.add(0, new NoteOn(this));
        es.add(length, new NoteOff(this));

        return es;
    }
}
