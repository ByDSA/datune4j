package es.danisales.datune.pitch;

import es.danisales.datune.degree.Degree;
import es.danisales.datune.interval.Interval;
import es.danisales.datune.midi.pitch.PitchMidiException;

public interface PitchAbsoluteDegree<D extends Degree, I extends Interval> extends AbsoluteDegree<D> {
    <E extends PitchException> PitchAbsoluteDegree<D, I> getNext() throws E, PitchMidiException;

    <E extends PitchException> PitchAbsoluteDegree<D, I> getPrevious() throws E, PitchMidiException;

    <E extends PitchException> PitchAbsoluteDegree<D, I> getShifted(I interval) throws E, PitchMidiException;

    <E extends PitchException> PitchAbsoluteDegree<D, I> getShiftedNegative(I interval) throws E, PitchMidiException;
}
