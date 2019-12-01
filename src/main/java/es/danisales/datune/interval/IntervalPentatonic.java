package es.danisales.datune.interval;

import es.danisales.datune.absolutedegree.Pentatonic;

public enum IntervalPentatonic implements Interval {
    UNISON, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH,
    OCTAVE, NINTH, TENTH, ELEVENTH, TWELFTH, THIRTEENTH, FOURTEENTH,
    FIFTEENTH;

    @Override
    public boolean isCompound() {
        return ordinal() > Pentatonic.NUMBER;
    }
}
