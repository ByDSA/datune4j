package es.danisales.datune.midi.pitch;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface PitchMidiInterface<I extends Interval> extends PitchOctave, Cloneable, Comparable<PitchMidiInterface<?>> {
    PitchMidiInterface<I> clone();

    int getMidiCode();

    void shiftOctave(int i) throws PitchMidiException;

    void next() throws PitchMidiException;

    void previous() throws PitchMidiException;

    void shift(I intervalDiatonic) throws PitchMidiException;

    void shiftNegative(I intervalDiatonic) throws PitchMidiException;

    @Override
    default int compareTo(@NonNull PitchMidiInterface<?> pitchMidiInterface) {
        return Integer.compare(this.getMidiCode(), pitchMidiInterface.getMidiCode());
    }

    void shift(int pos) throws PitchMidiException;
}
