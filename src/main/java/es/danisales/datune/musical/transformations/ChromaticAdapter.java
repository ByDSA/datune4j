package es.danisales.datune.musical.transformations;

import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.midi.PitchSingleMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityInterface;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ChromaticAdapter {
    private ChromaticAdapter() {
    }

    public static @Nullable Chromatic from(@NonNull Diatonic diatonic, Tonality tonality) {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, tonality);
        if (diatonicAlt == null)
            return null;
        return Chromatic.from(diatonicAlt);
    }

    public static @NonNull Chromatic from(PitchMidi pitchMidi) {
        int value = pitchMidi.getCode();
        return Chromatic.from( value % Chromatic.NUMBER );
    }

    public static @NonNull Chromatic from(PitchSingleMidi chromaticMidi) {
        return from( chromaticMidi.getPitchMidi() );
    }

    public static @NonNull Chromatic from(PitchChromaticSingle t) {
        if (t.getClass().equals(PitchMidi.class))
            return from((PitchMidi)t);
        else if (t.getClass().equals(PitchSingleMidi.class))
            return from((PitchSingleMidi) t);
        else if (t.getClass().equals(Chromatic.class))
            return (Chromatic)t;

        throw new RuntimeException("Undefined for class " + t.getClass());
    }
}
