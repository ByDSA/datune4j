package es.danisales.datune.absolutedegree;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

class ChromaticAdapter {
    private ChromaticAdapter() {
    }

    public static @NonNull Chromatic from(@NonNull Diatonic diatonic, Tonality tonality) throws TonalityException {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, tonality);

        return Chromatic.from(diatonicAlt);
    }

    public static @NonNull Chromatic from(@NonNull ChromaticMidi chromaticMidi) {
        return chromaticMidi.getPitch().getChromatic();
    }
}
