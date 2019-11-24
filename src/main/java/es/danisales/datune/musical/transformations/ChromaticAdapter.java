package es.danisales.datune.musical.transformations;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.PitchChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
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

    public static @NonNull Chromatic from(PitchChromaticMidi pitchMidi) {
        int value = pitchMidi.getMidiCode();
        return Chromatic.from( value % Chromatic.NUMBER );
    }

    public static @NonNull Chromatic from(ChromaticMidi chromaticMidi) {
        return from( chromaticMidi.getPitch() );
    }

    public static @NonNull Chromatic from(PitchChromaticSingle t) {
        if (t.getClass().equals(PitchChromaticMidi.class))
            return from((PitchChromaticMidi)t);
        else if (t.getClass().equals(Chromatic.class))
            return (Chromatic)t;
        else if (t.getClass().equals(ChromaticMidi.class))
            return ((ChromaticMidi) t).getPitch().getChromatic();

        throw new RuntimeException("Undefined for class " + t.getClass());
    }
}
