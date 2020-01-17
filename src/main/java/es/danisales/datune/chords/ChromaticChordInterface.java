package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface ChromaticChordInterface extends PitchChromaticChord<Chromatic> {
    static @NonNull ChromaticChordInterface from(DiatonicChord diatonicChord, Tonality tonality) throws TonalityException {
        ChromaticChordInterface chromaticChord = new ChromaticChordMutable();
        for (Diatonic diatonic : diatonicChord) {
            DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, tonality);
            Chromatic chromatic = Chromatic.from(diatonicAlt);
            chromaticChord.add(chromatic);
        }
        return chromaticChord;
    }

    static ChromaticChordInterface from(DiatonicChordMidi diatonicChordMidi) {
        ChromaticChord chromaticChord = ChromaticChord.builder().fromDiatonicChordMidi(diatonicChordMidi).build();
        return ChromaticChordInterface.from(chromaticChord);
    }

    static ChromaticChordInterface from(ChromaticChordMidi chromaticChordMidi) {
        ChromaticChordInterface ret = new ChromaticChordMutable();
        for (ChromaticMidi chromaticMidi : chromaticChordMidi)
            ret.add(chromaticMidi.getPitch().getChromatic());
        return ret;
    }

    static ChromaticChordInterface from(Iterable<Chromatic> c) {
        ChromaticChordInterface ret = new ChromaticChordMutable();
        for (Chromatic chromatic : c)
            ret.add(chromatic);

        return ret;
    }
}
