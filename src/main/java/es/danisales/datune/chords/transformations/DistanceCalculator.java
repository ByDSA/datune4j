package es.danisales.datune.chords.transformations;

import es.danisales.datune.midi.NoteMidi;

public class DistanceCalculator {
    private DistanceCalculator() {
    }

    public static int calculateDistanceInSemitones(NoteMidi from, NoteMidi to) {
        return to.getPitch().getMidiCode() - from.getPitch().getMidiCode();
    }
}
