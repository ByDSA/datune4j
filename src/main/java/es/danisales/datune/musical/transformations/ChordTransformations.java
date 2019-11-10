package es.danisales.datune.musical.transformations;

import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicChord;

public class ChordTransformations {
    private ChordTransformations() {
    }

    public DiatonicChord removeHigherDuplicatesFrom(DiatonicChord diatonicChord) {
        DiatonicChord out = diatonicChord;
        for(Diatonic n : diatonicChord) {
            boolean found = false;

            if (!found)
                out.add(n);
        }

        diatonicChord.clear();
        diatonicChord.addAll(out);

        return out;
    }
}
