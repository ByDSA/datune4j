package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.pitch.PitchOctave;

public interface PitchMidiInterface<I extends Interval> extends PitchOctave {
    int getMidiCode();

    void shiftOctave(int i);

    void next();

    void previous();

    void shift(I intervalDiatonic);

    void shiftNegative(I intervalDiatonic);
}
