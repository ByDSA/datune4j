package es.danisales.datune.midi;

import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DiatonicChordMidiAdapter {
    private DiatonicChordMidiAdapter() {
    }

    public static @NonNull List<DiatonicChordMidi> fromChromaticChordMidi(ChromaticChordMidi chromaticChordMidi, boolean outScale) {
        List<Tonality> tonalities;
        if (outScale)
            tonalities = TonalityRetrieval.listFromChordOutScale(chromaticChordMidi);
        else
            tonalities = TonalityRetrieval.listFromChord(chromaticChordMidi);

        if (tonalities.size() == 0)
            return new ArrayList<>();

        ChromaticChordMidi usingChord = chromaticChordMidi.clone();
        // usingChord.updateWhatIsItIfNeeded();

        ArrayList<DiatonicChordMidi> out = new ArrayList<>();
        for (Tonality t : tonalities)
            out.add(new DiatonicChordMidi(t, usingChord));

        return out;
    }

    public static @Nullable DiatonicChordMidi fromChromaticChordMidi(ChromaticChordMidi chromaticChordMidi, Tonality tonality) {
        List<DiatonicChordMidi> diatonicChordMidiList = fromChromaticChordMidi(chromaticChordMidi, true);
        for (DiatonicChordMidi diatonicChordMidi : diatonicChordMidiList)
            if (diatonicChordMidi.tonality.equals(tonality))
                return diatonicChordMidi;

        return null;
    }
}
