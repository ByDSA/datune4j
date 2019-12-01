package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface ChromaticChordInterface extends PitchChromaticChord<Chromatic> {
    static @NonNull ChromaticChordInterface from(DiatonicChord diatonicChord, Tonality tonality) throws TonalityException {
        ChromaticChordInterface chromaticChord = new ChromaticChordMutable();
        for (Diatonic diatonic : diatonicChord) {
            Chromatic chromatic = Chromatic.from(diatonic, tonality);
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
            ret.add(Chromatic.from(chromaticMidi));
        return ret;
    }

    static ChromaticChordInterface from(Iterable<Chromatic> c) {
        ChromaticChordInterface ret = new ChromaticChordMutable();
        for (Chromatic chromatic : c)
            ret.add(chromatic);

        return ret;
    }
}
