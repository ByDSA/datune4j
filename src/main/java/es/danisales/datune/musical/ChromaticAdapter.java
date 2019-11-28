package es.danisales.datune.musical;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.PitchChromaticMidi;
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
        return chromaticMidi.getPitch().getChromatic();
    }
}
