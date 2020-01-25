package es.danisales.datune.degrees;

import es.danisales.datune.pitch.PitchException;

public interface OrderedDegree
        extends Cloneable {
    <E extends PitchException> OrderedDegree getNext() throws E;
    <E extends PitchException> OrderedDegree getPrevious() throws E;
    <E extends PitchException> OrderedDegree getShifted(int i) throws E;
    int ordinal();
}
