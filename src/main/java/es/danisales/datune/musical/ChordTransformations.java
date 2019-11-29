package es.danisales.datune.musical;

import es.danisales.datune.interval.Interval;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.pitch.*;

import java.util.ArrayList;
import java.util.List;

public class ChordTransformations {
    private ChordTransformations() {
    }

    public static <N extends SymbolicPitch, T extends ChordCommon<N>> T removeHigherDuplicates(ChordMutableInterface<N, ?> chordMutableInterface) {
        ChordMutableInterface<N, ?> out = chordMutableInterface.clone();
        for (N n : chordMutableInterface) {
            boolean found = false;

            if (!found)
                out.add(n);
        }

        chordMutableInterface.clear();
        chordMutableInterface.addAll(out);

        return (T) out;
    }

    public static void removeHigherDuplicates(ChromaticChordMidi self) {
        ChromaticChordMidi out = ChromaticChordMidi.builder().build();
        for (ChromaticMidi n : self) {
            boolean found = false;
            for (ChromaticMidi n2 : out) {
                Chromatic chromaticN2 = Chromatic.from(n2);
                Chromatic chromaticN = Chromatic.from(n);
                if (chromaticN2.ordinal() == chromaticN.ordinal()) {
                    found = true;
                    break;
                }
            }

            if (!found)
                out.add(n);
        }

        self.clear();
        self.addAll(out);
    }

    public static <IN extends ChordCommon<N>, C extends ChordMutableInterface<N, I>, N extends CyclicAbsoluteDegree<?, I>, I extends Interval> List<C> getAllInversionsFrom(C chordMutableInterface) {
        List<C> ret = new ArrayList<>();

        C last = (C) chordMutableInterface.clone();
        for (int i = 0; i < chordMutableInterface.size(); i++) {
            ret.add((C) last.clone());
            if (i < chordMutableInterface.size() - 1)
                last.inv();
        }

        return ret;
    }

    public static <C extends ChordProxy<ChordMutableInterface<N, I>, N, I>, N extends CyclicAbsoluteDegree<?, I>, I extends Interval> List<C> getAllInversions(C normalChordCommon) {
        List<ChordMutableInterface<N, I>> customDiatonicChords = getAllInversionsRaw(normalChordCommon);

        return createListFrom(normalChordCommon, customDiatonicChords);
    }

    private static <IN extends ChordCommon<N>, C extends ChordProxy<IN, N, I>, N extends CyclicAbsoluteDegree<?, I>, I extends Interval> List<ChordMutableInterface<N, I>> getAllInversionsRaw(C normalChordCommon) {
        List<ChordMutableInterface<N, I>> customDiatonicChords;

        if (normalChordCommon.InnerIsMutable()) {
            ChordMutableInterface<N, I> chordMutableInterface = normalChordCommon.castCustom(normalChordCommon.innerChord);
            customDiatonicChords = ChordTransformations.getAllInversionsFrom(normalChordCommon);
        } else {
            IN tmp = normalChordCommon.innerChord;
            normalChordCommon.turnInnerIntoMutable();
            ChordMutableInterface<N, I> chordMutableInterface = normalChordCommon.castCustom(normalChordCommon.innerChord);
            customDiatonicChords = ChordTransformations.getAllInversionsFrom(normalChordCommon);
            normalChordCommon.innerChord = tmp;
        }

        return customDiatonicChords;
    }

    private static <C extends ChordProxy<ChordMutableInterface<N, I>, N, I>, N extends CyclicAbsoluteDegree<?, I>, I extends Interval> List<C> createListFrom(C self, List<ChordMutableInterface<N, I>> list) {
        List<C> ret = new ArrayList<>();
        for (ChordMutableInterface<N, I> customChromaticChord : list) {
            C chromaticChord = (C) self.create();
            chromaticChord.innerChord = customChromaticChord;
            chromaticChord.turnInnerChordIntoImmutableIfPossible();
            ret.add(chromaticChord);
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
    public static <C extends ChordMutable> ArrayList<C> duplicateList(List<C> a) {
        ArrayList<C> b = new ArrayList<>();
        for (C c : a)
            b.add((C) c.clone());

        return b;
    }
}
