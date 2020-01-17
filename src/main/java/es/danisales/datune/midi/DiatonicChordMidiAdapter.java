package es.danisales.datune.midi;

import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

class DiatonicChordMidiAdapter {
    private DiatonicChordMidiAdapter() {
    }

    static @NonNull List<DiatonicChordMidiInfo> fromChromaticChordAll(ChromaticChord chromaticChord) {
        List<DiatonicChordMidiInfo> out = new ArrayList<>();
        for (Tonality tonality : TonalityRetrieval.allUsualKeys()) {
            HarmonicFunction harmonicFunction = tonality.getFunctionFrom(chromaticChord);

            if (harmonicFunction == null)
                continue;

            DiatonicChordMidiInfo diatonicChordMidiInfo = new DiatonicChordMidiInfo(chromaticChord, harmonicFunction, tonality);
            out.add(diatonicChordMidiInfo);
        }

        return out;
    }

    static @NonNull List<DiatonicChordMidiInfo> fromChromaticChordDiatonic(ChromaticChord chromaticChord) {
        List<DiatonicChordMidiInfo> out = new ArrayList<>();
        for (Tonality tonality : TonalityRetrieval.allUsualKeys()) {
            List<DiatonicFunction> diatonicFunctionList = tonality.getDiatonicFunctionFrom(chromaticChord);

            if (diatonicFunctionList.isEmpty())
                continue;

            for (DiatonicFunction diatonicFunction : diatonicFunctionList) {
                DiatonicChordMidiInfo diatonicChordMidiInfo = new DiatonicChordMidiInfo(chromaticChord, diatonicFunction, tonality);
                out.add(diatonicChordMidiInfo);
            }
        }

        return out;
    }
}