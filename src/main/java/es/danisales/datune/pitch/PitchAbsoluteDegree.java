package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;

public interface PitchAbsoluteDegree<D extends RelativeDegree, I extends Interval> extends AbsoluteDegree<D> {
    <E extends PitchException> PitchAbsoluteDegree<D, I> getNext() throws E;

    <E extends PitchException> PitchAbsoluteDegree<D, I> getPrevious() throws E;

    <E extends PitchException> PitchAbsoluteDegree<D, I> getShifted(I interval) throws E;

    <E extends PitchException> PitchAbsoluteDegree<D, I> getShiftedNegative(I interval) throws E;
}
