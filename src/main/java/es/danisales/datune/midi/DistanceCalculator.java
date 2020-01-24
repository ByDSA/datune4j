package es.danisales.datune.midi;

public class DistanceCalculator {
    private DistanceCalculator() {
    }

    public static int calculateDistanceInSemitones(NoteMidi from, NoteMidi to) {
        return to.getPitch().getMidiCode() - from.getPitch().getMidiCode();
    }
}
