package es.danisales.datune.chords;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.tonality.TonalityModern;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class ChordTransformations {
    private ChordTransformations() {
    }

    public static <CH extends Chord<C>, C extends CyclicDegree> List<CH> getAllInversionsFrom(CH chord) {
        List<CH> ret = new ArrayList<>();

        //noinspection unchecked
        CH last = (CH) chord.clone();
        for (int i = 0; i < chord.size(); i++) {
            //noinspection unchecked
            ret.add((CH) last.clone());
            if (i < chord.size() - 1) {
                last.inv();
            }
        }

        return ret;
    }

    static List<Integer> getMinDistances(ChromaticChord chromaticChordFrom, ChromaticChord chromaticChordTo) {
        List<Integer> ret = new ArrayList<>();
        for (Chromatic chromaticFrom : chromaticChordFrom){
            int min = Integer.MAX_VALUE;
            for (Chromatic chromaticTo : chromaticChordTo) {
                int semis = chromaticFrom.minDistSemitonesTo(chromaticTo);
                if (semis < min)
                    min = semis;
            }
            ret.add(min);
        }

        return ret;
    }

    public static List<IntervalChromatic> getIntraIntervals(@NonNull ChromaticChord chromaticChord) {
        List<IntervalChromatic> ret = new ArrayList<>();
        for (int i = 0; i < chromaticChord.size(); i++){
            for (int j = i+1; j < chromaticChord.size(); j++) {
                Chromatic chromaticFrom = chromaticChord.get(i);
                Chromatic chromaticTo = chromaticChord.get(j);

                int semis = chromaticFrom.distSemitonesTo(chromaticTo);
                IntervalChromatic intervalChromatic = IntervalChromatic.from(semis);
                ret.add(intervalChromatic);
            }
        }

        return ret;
    }

    public static List<Integer> getAllIntervalsWithNote(ChromaticChord chromaticChordFrom, Chromatic chromaticTo) {
        List<Integer> ret = new ArrayList<>();
        for (Chromatic chromaticFrom : chromaticChordFrom) {
            int semis = chromaticFrom.distSemitonesTo(chromaticTo);
            ret.add(semis);
        }

        return ret;
    }

    public static @NonNull TonalityModern negativeHarmony(@NonNull TonalityModern tonalityModern, @NonNull Chromatic axis) {
        ChromaticChord chromaticChord = tonalityModern.getChord(DiatonicFunction.I7);
        checkNotNull(chromaticChord);
        ChromaticChord chord = ChordTransformations.negativeHarmony(chromaticChord, axis);

        ChromaticChord tensions = tonalityModern.getChord(DiatonicFunction.II);
        checkNotNull(tensions);
        ChromaticChord resultTensions = ChordTransformations.negativeHarmony(tensions, axis);

        List<Chromatic> notes = new ArrayList<>();
        notes.addAll(chord);
        notes.addAll(resultTensions);

        return TonalityModern.from(notes);
    }

    public static TonalityModern negativeHarmonyTonality(TonalityModern tonalityModern, Chromatic root) {
        ChromaticChord chromaticChord = ChromaticChord.builder().build();
        chromaticChord.addAll(tonalityModern.getNotes());

        ChromaticChord result = negativeHarmonyNoteByNote(chromaticChord, root);

        return TonalityModern.from(result);

    }

    public static @NonNull TonalityModern negativeHarmony(@NonNull TonalityModern tonalityModern) {
        Chromatic root = tonalityModern.getRoot();
        return negativeHarmony(tonalityModern, root);
    }

    public static @NonNull ChromaticChord negativeHarmony(@NonNull ChromaticChord chromaticChord) {
        Chromatic root = chromaticChord.getRoot();
        checkNotNull(root);
        return negativeHarmony(chromaticChord, root);
    }

    public static @NonNull ChromaticChord negativeHarmony(@NonNull ChromaticChord chromaticChord, @NonNull Chromatic root) {
        ChromaticChord chromaticChord2 = negativeHarmonyNoteByNote(chromaticChord, root);

        Collections.reverse(chromaticChord2);

        return chromaticChord2;
    }

    private static @NonNull ChromaticChord negativeHarmonyNoteByNote(@NonNull ChromaticChord chromaticChord, @NonNull Chromatic root) {
        ChromaticChord chromaticChord1;
        if (chromaticChord.getInversionNumber() > 0) {
            chromaticChord1 = chromaticChord.clone();
            chromaticChord1.toFundamental();
        } else {
            chromaticChord1 = chromaticChord;
        }

        int doubleCenter = root.ordinal() + 7;

        ChromaticChord chromaticChord2 = ChromaticChord.builder().build();
        for (Chromatic chromatic : chromaticChord1) {
            int n = doubleCenter - chromatic.ordinal();
            Chromatic chromatic1 = Chromatic.from(n);
            chromaticChord2.add(chromatic1);
        }

        return chromaticChord2;
    }
}
