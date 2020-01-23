package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.chords.transformations.EnharmonicsRetrieval;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleDistance;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DiatonicAltRetrieval {
    private DiatonicAltRetrieval() {
    }

    public static List<DiatonicAlt> listFromAlterations(int alts) {
        List<DiatonicAlt> ret = new ArrayList<>();
        for (int i = -alts; i <= alts; i++)
            for (Diatonic diatonic : Diatonic.values()) {
                DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, i);
                ret.add(diatonicAlt);
            }

        return ret;
    }

    public static <C extends CyclicDegree> @NonNull List<C> listFrom(@NonNull C noteBase, @NonNull final Scale scale) {
        if (noteBase instanceof DiatonicAlt) {
            if (scale.size() == 7)
                return (List<C>)sevenListFrom((DiatonicAlt)noteBase, scale);
            else if (scale.size() < 7)
                return (List<C>)lowerThan7ListFrom((DiatonicAlt)noteBase, scale);
            else
                return (List<C>)genericListFrom((DiatonicAlt)noteBase, scale);
        }

        throw new RuntimeException();
    }

    private static @NonNull List<DiatonicAlt> genericListFrom(@NonNull DiatonicAlt noteBase, @NonNull final Scale scale) {
        List<DiatonicAlt> retNotes = new ArrayList<>();
        retNotes.add(noteBase);

        DiatonicAlt newDiatonicAlt = noteBase;

        for (int i = 0; i < scale.size()-1; i++) {
            ScaleDistance step = scale.getCode().get(i);
            newDiatonicAlt = newDiatonicAlt.add(step);
            if (newDiatonicAlt.getUnsignedAlterations() >= 1)
                newDiatonicAlt = EnharmonicsRetrieval.getMinAlts(newDiatonicAlt);

            retNotes.add(newDiatonicAlt);
        }

        return retNotes;
    }

    private static @NonNull List<DiatonicAlt> sevenListFrom(@NonNull DiatonicAlt noteBase, @NonNull final Scale scale) {
        List<DiatonicAlt> retNotes = new ArrayList<>();
        retNotes.add(noteBase);
        Diatonic diatonic = noteBase.getDiatonic();
        float semis = Chromatic.from(noteBase.getDiatonic()).ordinal() + noteBase.getAlterations();

        for (int i = 0; i < scale.size() - 1; i++) {
            ScaleDistance step = scale.getCode().get(i);
            semis += step.getMicrotonalSemitones();
            diatonic = diatonic.getNext();
            DiatonicAlt newDiatonicAlt = DiatonicAlt.from(semis, diatonic);

            retNotes.add(newDiatonicAlt);
        }

        return retNotes;
    }

    private static @NonNull List<DiatonicAlt> lowerThan7ListFrom(@NonNull DiatonicAlt noteBase, @NonNull final Scale scale) {
        List<DiatonicAlt> retNotes = new ArrayList<>();
        retNotes.add(noteBase);

        DiatonicAlt newDiatonicAlt;
        Diatonic diatonicBase = noteBase.getDiatonic();
        float semis = Chromatic.from(noteBase.getDiatonic()).ordinal() + noteBase.getAlterations();

        for (int i = 0; i < scale.size()-1; i++) {
            ScaleDistance step = scale.getCode().get(i);
            semis += step.getMicrotonalSemitones();
            ScaleDegree relativeDegree;
            relativeDegree = getDiatonicDegreeFromRelativeDegreeSet(scale.degreeGetter().index(i + 1).get());
            if (relativeDegree == null)
                return genericListFrom(noteBase, scale);
            int index = diatonicBase.ordinal() + relativeDegree.ordinal();
            index %= Diatonic.NUMBER;
            Diatonic absoluteDegree = Diatonic.values()[index];
            newDiatonicAlt = DiatonicAlt.from(semis, absoluteDegree);

            retNotes.add(newDiatonicAlt);
        }

        return retNotes;
    }

    private static @Nullable DiatonicDegree getDiatonicDegreeFromRelativeDegreeSet(Set<ScaleDegree> set) {
        for (ScaleDegree relativeDegree : set)
            if (relativeDegree instanceof DiatonicDegree)
                return (DiatonicDegree) relativeDegree;

        return null;
    }

    public static Set<DiatonicAlt> getEnharmonicsFrom(DiatonicAlt diatonicAlt, int maxAlterations) {
        return EnharmonicsRetrieval.getFromDiatonicAlt(diatonicAlt, maxAlterations);
    }
}
