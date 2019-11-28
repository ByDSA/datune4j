package es.danisales.datune.midi;

import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DiatonicChordMidiAdapter {
    private DiatonicChordMidiAdapter() {
    }

    public static @NonNull List<DiatonicChordMidi> fromChromaticChord(ChromaticChord chromaticChordMidi, boolean outScale) {
        List<Tonality> tonalities;
/*        if (outScale)
           tonalities = TonalityRetrieval.listFromChordOutScale(chromaticChordMidi);
        else*/
            tonalities = TonalityRetrieval.listFromChord(chromaticChordMidi);

        if (tonalities.size() == 0)
            return new ArrayList<>();

        // usingChord.updateWhatIsItIfNeeded();

        ArrayList<DiatonicChordMidi> out = new ArrayList<>();
        for (Tonality tonality1 : tonalities) {
            ChromaticChord chromaticChord = ChromaticChord.builder().fromChromatic(chromaticChordMidi).build();
            HarmonicFunction harmonicFunction = tonality1.getFunctionFrom(chromaticChord);
            if (harmonicFunction == null)
                continue;

            DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                    .from(harmonicFunction, tonality1)
                    .build();
            out.add(diatonicChordMidi);
        }

        return out;
    }
}
