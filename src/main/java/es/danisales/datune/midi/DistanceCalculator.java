package es.danisales.datune.midi;

class DistanceCalculator {
    private DistanceCalculator() {
    }

    static int calculateDistanceInSemitones(NoteMidi from, NoteMidi to) {
        return to.getPitch().getMidiCode() - from.getPitch().getMidiCode();
    }
}
