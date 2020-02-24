package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityClassical;
import es.danisales.datune.tonality.TonalityModern;

class TonalityConverter {
    private TonalityConverter() {
    }

    static TonalityModern fromDiatonicAltToChromatic(TonalityClassical tonality) {
        Chromatic root = Chromatic.from(tonality.getRoot());
        return Tonality.from(root, tonality.getScale());
    }
}
