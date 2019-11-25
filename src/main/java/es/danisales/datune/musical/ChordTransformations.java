package es.danisales.datune.musical;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.midi.*;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> getAllInversionsFrom(T chordMidi) {
        ChordMidi<N, I, P> c = chordMidi.clone();
        c.setMinOctave();
        minimize(c);

        return getAllDispositionsSub(c, true, 0, true);
    }

    public static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> getAllDispositionsWithInv(T chordMidi) {
        List<T> ret = new ArrayList<>();
        List<T> bases = _getAllInversions(chordMidi);
        for (T c : bases)
            ret.addAll((List<T>) getAllInversionsFrom(c));

        return ret;
    }

    protected static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> getAllDispositionsSub(ChordMidi<N, I, P> chordMidi, boolean sub, int level, boolean first) {
        ArrayList<T> ret = new ArrayList<>();
        assert chordMidi.size() > 0;

        if (first && level == 0)
            ret.add((T) chordMidi.clone());

        try {
            while ((chordMidi.size() > 1 && chordMidi.get(0).getPitch().getMidiCode() < chordMidi.get(1).getPitch().getMidiCode()
                    || chordMidi.size() == 1)) {
                if (!first) {
                    T d = (T) chordMidi.clone();
                    ret.add(d);
                }

                if (sub && chordMidi.size() > 1) {
                    // Copia acorde desde la segunda a la �ltima nota
                    T subChord = chordMidi.newChord();
                    for (int j = 1; j < chordMidi.size(); j++)
                        subChord.add((N) chordMidi.get(j).clone());

                    List<T> subCombinations = getAllDispositionsSub(subChord.clone(), true, level + 1, first);
                    for (T subCombination : subCombinations) {
                        // Forma listOf superChord = [listOf[0] + subChordcombination]
                        T superChord = chordMidi.newChord();
                        superChord.add((N) chordMidi.get(0).clone());
                        superChord.addAll(subCombination.clone());

                        // Combinaciones de 'n�mero' dentro del listOf superChord = ['n�mero' +
                        // subChordcombination]
                        List<T> superCombinations = getAllDispositionsSub(superChord.clone(), false, level, false);
                        ret.addAll(superCombinations);
                    }
                }

                chordMidi.get(0).getPitch().shiftOctave(1);
                first = false;
            }
        } catch (PitchMidiException e) {

        }

        return ret;
    }

    public static <N extends Note<?>> void minimize(ChordMidi<N, ?, ?> chordMidi) {
        for (int i = 1; i < chordMidi.size(); i++) {
            N note = chordMidi.get(i);
            N prev = chordMidi.get(i - 1);
            while (note.getPitch().getMidiCode() - Chromatic.NUMBER > prev.getPitch().getMidiCode())
                note.getPitch().shiftOctave(-1);
        }
    }

    public static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> void minimizeDistanceTo(T chordMidi, @NonNull ChordMidi cIn) {
        Objects.requireNonNull(cIn);

        List<T> ret = getAllDispositionsWithInv(chordMidi);
        int minDist = 9999;
        T minDistChord = null;
        for (T c : ret) {
            int d = (int) Math.abs(cIn.dist(c));
            if (d < minDist) {
                minDist = d;
                minDistChord = c;
            }
        }
        chordMidi.assign(minDistChord);
    }

    private static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> _getAllInversions(T chordMidi) {
        List<T> ret = new ArrayList<>();

        ret.add((T) chordMidi.clone());

        T last = (T) chordMidi;
        for (int i = 0; i < chordMidi.size(); i++) {
            ret.add(last);
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
}
