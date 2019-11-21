package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.IntervalChromatic;

public interface PitchChromaticSingle extends AbsoluteDegree<ChromaticDegree, IntervalChromatic>, PitchChromatic, SymbolicPitch {
    @Override PitchChromaticSingle getNext();
    @Override PitchChromaticSingle getPrevious();
    @Override PitchChromaticSingle getShifted(IntervalChromatic intervalChromatic);
    @Override PitchChromaticSingle getShiftedNegative(IntervalChromatic intervalChromatic);
}
