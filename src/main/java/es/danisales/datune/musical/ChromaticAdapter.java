package es.danisales.datune.musical;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.PitchChromaticMidi;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ChromaticAdapter {
    private ChromaticAdapter() {
    }

    public static @NonNull Chromatic from(@NonNull Diatonic diatonic, Tonality tonality) throws TonalityException {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, tonality);

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
