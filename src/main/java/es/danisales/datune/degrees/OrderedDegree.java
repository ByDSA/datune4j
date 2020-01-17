package es.danisales.datune.degrees;

import es.danisales.datune.pitch.PitchException;
import es.danisales.datune.pitch.SymbolicPitch;

public interface OrderedDegree
        extends SymbolicPitch {
    <E extends PitchException> OrderedDegree getNext() throws E;
    <E extends PitchException> OrderedDegree getPrevious() throws E;
    <E extends PitchException> OrderedDegree getShifted(int i) throws E;
    int ordinal();
}
