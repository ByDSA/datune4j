package es.danisales.datune.musical.transformations;

import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.Chromatic;

public class DistanceCalculator {
    public static IntervalChromatic calculateDistance(Chromatic from, Chromatic to, IntervalDiatonic intervalDiatonic) {
        int d = to.intValue() - from.intValue();
        return IntervalChromatic.from( intervalDiatonic, d );
    }

    public static int calculateDistance(ChromaticMidi from, ChromaticMidi to) {
        return to.getCode() - from.getCode();
    }
}
