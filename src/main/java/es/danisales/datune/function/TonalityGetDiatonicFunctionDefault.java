package es.danisales.datune.function;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

class TonalityGetDiatonicFunctionDefault {
    private static final Table<Tonality<Chromatic>, DiatonicFunction, ChromaticChord> table = HashBasedTable.create();

    static ChromaticChord get(@NonNull Tonality<Chromatic> tonality, @NonNull DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        ChromaticChord cached = table.get(tonality, diatonicFunction);
        if (cached != null)
            return cached;
        Chromatic noteBase = getNoteBaseFrom(tonality, diatonicFunction);
        DiatonicDegreePattern diatonicChordPattern = diatonicFunction.getDiatonicDegreePattern();

        try {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .chromaticBase(noteBase)
                    .diatonicDegreePattern(diatonicChordPattern)
                    .tonality(tonality)
                    .build();
            table.put(tonality, diatonicFunction, ChromaticChord.immutableFrom(chromaticChord));

            return chromaticChord;
        } catch (Exception e) {
            return null;
        }
    }

    private static Chromatic getNoteBaseFrom(Tonality<Chromatic> tonality, DiatonicFunction diatonicFunction) throws ScaleRelativeDegreeException {
        return tonality.getNote( diatonicFunction.getDiatonicDegree() );
    }
}
