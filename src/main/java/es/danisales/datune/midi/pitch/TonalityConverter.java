package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;

public class TonalityConverter {
    private TonalityConverter() {
    }

    public static Tonality<Chromatic> fromDiatonicAltToChromatic(Tonality<DiatonicAlt> tonality) {
        Chromatic root = Chromatic.from(tonality.getRoot());
        return Tonality.from(root, tonality.getScale());
    }
}
