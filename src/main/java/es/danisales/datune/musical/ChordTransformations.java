package es.danisales.datune.musical;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;

import java.util.ArrayList;
import java.util.List;

public class ChordTransformations {
    private ChordTransformations() {
    }

    public static <N, T extends ChordCommon<N>> T removeHigherDuplicates(ChordMutableInterface<N, ?> chordMutableInterface) { // todo: move
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
        ChromaticChordMidi out = self.newChord();
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

    public static <N, I extends Interval, T extends ChordMutableInterface<N, I>> List<T> getAllInversionsFrom(ChordMutableInterface<N, I> chordMutableInterface) {
        List<T> ret = new ArrayList<>();

        T last = (T) chordMutableInterface.clone();
        for (int i = 0; i < chordMutableInterface.size(); i++) {
            ret.add((T) last.clone());
            if (i < chordMutableInterface.size() - 1)
                last.inv();
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
    public static <N extends AbsoluteDegree<?, I>, I extends Interval> List<? extends ChordCommon<N>> getAllInversions(NormalChordCommon<N, I> normalChordCommon) {
        List<ChordMutableInterface<N, I>> customDiatonicChords = getAllInversionsRaw(normalChordCommon);

        return createListFrom(normalChordCommon, customDiatonicChords);
    }

    private static <N extends AbsoluteDegree<?, I>, I extends Interval> List<ChordMutableInterface<N, I>> getAllInversionsRaw(NormalChordCommon<N, I> normalChordCommon) {
        List<ChordMutableInterface<N, I>> customDiatonicChords;

        if (normalChordCommon.isCustom()) {
            customDiatonicChords = ChordTransformations.getAllInversionsFrom(normalChordCommon.castCustom(normalChordCommon.innerChord));
        } else {
            ChordCommon<N> tmp = normalChordCommon.innerChord;
            normalChordCommon.turnInnerIntoCustom();
            customDiatonicChords = ChordTransformations.getAllInversionsFrom(normalChordCommon.castCustom(normalChordCommon.innerChord));
            normalChordCommon.innerChord = tmp;
        }

        return customDiatonicChords;
    }

    private static <N extends AbsoluteDegree<?, I>, I extends Interval> List<NormalChordCommon<N, I>> createListFrom(NormalChordCommon<N, I> self, List<ChordMutableInterface<N, I>> list) {
        List<NormalChordCommon<N, I>> ret = new ArrayList<>();
        for (ChordCommon<N> customChromaticChord : list) {
            NormalChordCommon<N, I> chromaticChord = self.create();
            chromaticChord.innerChord = customChromaticChord;
            chromaticChord.turnInnerChordIntoEnumIfPossible();
            ret.add(chromaticChord);
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
    public static <C extends Chord> ArrayList<C> duplicateList(List<C> a) {
        ArrayList<C> b = new ArrayList<>();
        for (C c : a)
            b.add((C) c.clone());

        return b;
    }
}
