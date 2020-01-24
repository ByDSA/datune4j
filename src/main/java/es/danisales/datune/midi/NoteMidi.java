package es.danisales.datune.midi;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.binaries.events.NoteOff;
import es.danisales.datune.midi.binaries.events.NoteOn;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiInterface;
import es.danisales.datune.pitch.SymbolicPitch;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

public class NoteMidi<P extends PitchMidiInterface> implements SymbolicPitch, EventComplex, Durable, Velocitiable {
    protected int velocity;
    protected int length;
    protected PitchChromaticMidi pitch;

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

    public final PitchChromaticMidi getPitch() {
        return pitch;
    }

    @Override
    public final EventSequence getEvents() {
        EventSequence es = new EventSequence();
        NoteOn noteOn;
        try {
            noteOn = NoteOn.builder()
                    .from(this)
                    .build();

            es.add(0, noteOn);

            NoteOff noteOff = NoteOff.builder()
                    .from(this)
                    .build();
            es.add(length, noteOff);

        } catch (BuildingException ignored) {
            throw NeverHappensException.make("");
        }

        return es;
    }

    public static NoteMidiBuilder builder() {
        return new NoteMidiBuilder();
    }

    public @NonNull NoteMidi clone() {
        return NoteMidi.builder()
                .pitch(pitch.clone())
                .velocity(velocity)
                .length(length)
                .build();
    }

    @Override
    public String toString() {
        return pitch + " (vel=" + velocity + ", length=" + length + ")";
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof NoteMidi) )
            return false;

        NoteMidi chromaticMidi = (NoteMidi) o;

        return pitch.equals( chromaticMidi.pitch) && velocity == chromaticMidi.velocity && length == chromaticMidi.length;
    }

    @Override
    public int hashCode() {
        return pitch.hashCode() + 31 * ( Integer.hashCode(velocity) + 37 * Integer.hashCode(length) );
    }
}
