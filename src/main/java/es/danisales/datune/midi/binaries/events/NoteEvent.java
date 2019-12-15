package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.midi.Settings;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

public abstract class NoteEvent extends ChannelEvent {
    private int key;
    private int velocity;

    public static abstract class Builder<N extends NoteEvent> extends es.danisales.utils.building.Builder<Builder<N>, N> {
        protected int delta = 0;
        protected int key = -1;
        protected int velocity = Settings.DefaultValues.VELOCITY;
        protected int channel = 0;

        protected Builder() {
        }

        public Builder<N> delta(int delta) {
            this.delta = delta;

            return self();
        }

        public Builder<N> key(int key) {
            this.key = key;

            return self();
        }

        public Builder<N> from(@NonNull NoteMidi noteMidi) {
            this.key = noteMidi.getPitch().getMidiCode();
            this.velocity = noteMidi.getVelocity();

            return self();
        }

        public Builder<N> velocity(int velocity) {
            this.velocity = velocity;

            return self();
        }

        public Builder<N> channel(int channel) {
            this.channel = channel;

            return self();
        }

        @NonNull
        @Override
        protected Builder<N> self() {
            return this;
        }

    }

    protected NoteEvent(int delta, int key, int velocity, byte statusBase, int channel) {
        super(delta, statusBase, channel);

        this.key = key;
        this.velocity = velocity;

        updateData();
    }

    public int getMidiCode() {
        return key;
    }

    public int getVelocity() {
        return velocity;
    }

    @Override
    protected byte[] generateData() {
        byte keyByte = (byte) key;
        byte velocityByte = (byte) velocity;

        return new byte[]{keyByte, velocityByte};
    }

    public String toString() {
        try {
            return "NoteOn " + PitchChromaticMidi.from(key);
        } catch (PitchMidiException e) {
            throw NeverHappensException.make("El código siempre es válido");
        }
    }
}
