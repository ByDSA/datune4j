package es.danisales.datune.musical.transformations;

import es.danisales.datune.pitch.ChordMutable;

public class ChordChecker {
    private ChordChecker() {
    }

    public static <N extends ChordMutable> boolean hasSameNotesOrder(N notes1, N notes) {
        if (notes1.size() != notes.size() || notes1.size() == 0)
            return false;

        for (int i = 0; i < notes1.size(); i++) {
            if (notes1.get(i) != notes.get(i))
                return false;
        }

        return true;
    }

    public static <N extends ChordMutable> boolean hasSameNotesOrder(N notes1, boolean sameOctave, N notes) {
        return sameOctave && hasSameNotesOrder(notes1, notes)
                ;//|| !sameOctave && hasSameNotesOrder( notes );
    }
}
