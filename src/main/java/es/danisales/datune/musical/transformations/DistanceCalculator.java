package es.danisales.datune.musical.transformations;

import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.Chromatic;

public class DistanceCalculator {
    public static IntervalChromatic calculareInterval(Chromatic from, Chromatic to, IntervalDiatonic intervalDiatonic) {
        int d = from.distSemitonesTo(to);
        return IntervalChromatic.from( intervalDiatonic, d );
    }

    public static int calculateDistanceInSemitones(ChromaticMidi from, ChromaticMidi to) {
        return to.getPitch().getMidiCode() - from.getPitch().getMidiCode();
    }
}
