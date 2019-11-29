package es.danisales.datune.midi;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.binaries.events.NoteOff;
import es.danisales.datune.midi.binaries.events.NoteOn;
import es.danisales.datune.midi.pitch.PitchMidiInterface;
import es.danisales.datune.pitch.SymbolicPitch;

public abstract class NoteMidi<P extends PitchMidiInterface> implements SymbolicPitch, EventComplex, Durable, Velocitiable {
    protected int velocity;
    protected int length;
    protected P pitch;

    @Override
    public final int getLength() {
        return length;
    }

    @Override
    public final void setLength(int d) {
        length = d;
    }

    @Override
    public final int getVelocity() {
        return velocity;
    }

    @Override
    public final void setVelocity(int v) {
        velocity = v;
    }

    public final P getPitch() {
        return pitch;
    }

    public abstract NoteMidi<P> clone();

    @Override
    public final EventSequence getEvents() {
        EventSequence es = new EventSequence();
        es.add(0, new NoteOn(this));
        es.add(length, new NoteOff(this));

        return es;
    }
}
