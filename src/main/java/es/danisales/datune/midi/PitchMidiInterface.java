package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface PitchMidiInterface<I extends Interval> extends PitchOctave, Cloneable, Comparable<PitchMidiInterface<?>> {
    PitchMidiInterface<I> clone();

    int getMidiCode();

    void shiftOctave(int i);

    void next();

    void previous();

    void shift(I intervalDiatonic);

    void shiftNegative(I intervalDiatonic);

    @Override
    default int compareTo(@NonNull PitchMidiInterface<?> pitchMidiInterface) {
        return Integer.compare(this.getMidiCode(), pitchMidiInterface.getMidiCode());
    }
}
