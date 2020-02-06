package es.danisales.datune.rhythm;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.chromatic.ChromaticChordPattern;
import es.danisales.datune.interval.ConsonanceIntervalsCalculator;
import es.danisales.datune.tempo.MusicalTime;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class ChordsLayer extends SequentialTimeEvents<ChromaticChord, DurableEvent<ChromaticChord, MusicalTime>, MusicalTime> {
    private ChordsLayer() {
    }

    public static @NonNull ChordsLayer create() {
        return new ChordsLayer();
    }

    @SuppressWarnings("WeakerAccess")
    public void analise() {
        List<ChromaticChord> list = toList();
        for (int i = 1; i < list.size(); i++) {
            ChromaticChord from = list.get(i - 1);
            ChromaticChord to = list.get(i);

            int diff = ConsonanceIntervalsCalculator.differenceOfConsonanceChord(from, to);
            String change;
            if (diff > 0) {
                change = "Más consonante";
            } else if (diff < 0)
                change = "Más disonante";
            else
                change = "Igual";
            System.out.println(from + " (" + ChromaticChordPattern.from(from) + ") => " + to + " (" + ChromaticChordPattern.from(to) + ") " + change + " " + diff);
        }
    }
}
