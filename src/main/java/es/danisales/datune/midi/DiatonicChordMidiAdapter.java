package es.danisales.datune.midi;

import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DiatonicChordMidiAdapter {
    private DiatonicChordMidiAdapter() {
    }

    public static @NonNull List<DiatonicChordMidiInfo> fromChromaticChordAll(ChromaticChord chromaticChord) {
        List<DiatonicChordMidiInfo> out = new ArrayList<>();
        for (Tonality tonality : Tonality.all()) {
            HarmonicFunction harmonicFunction = tonality.getFunctionFrom(chromaticChord);

            if (harmonicFunction == null)
                continue;

            DiatonicChordMidiInfo diatonicChordMidiInfo = new DiatonicChordMidiInfo(chromaticChord, harmonicFunction, tonality);
            out.add(diatonicChordMidiInfo);
        }

        return out;
    }

    public static @NonNull List<DiatonicChordMidiInfo> fromChromaticChordDiatonic(ChromaticChord chromaticChord) {
        List<DiatonicChordMidiInfo> out = new ArrayList<>();
        for (Tonality tonality : Tonality.all()) {
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