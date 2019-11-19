package es.danisales.datune.musical;

import es.danisales.datune.musical.transformations.EnharmonicsRetrieval;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleDistance;
import org.checkerframework.checker.nullness.qual.NonNull;

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

    public static @NonNull List<DiatonicAlt> listFrom(@NonNull DiatonicAlt noteBase, @NonNull final Scale scale) {
        if (scale.size() > 7)
            return moreThan7listFrom(noteBase, scale);
        else
            return normalListFrom(noteBase, scale);
    }

    private static @NonNull List<DiatonicAlt> moreThan7listFrom(@NonNull DiatonicAlt noteBase, @NonNull final Scale scale) {
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

    private static @NonNull List<DiatonicAlt> normalListFrom(@NonNull DiatonicAlt noteBase, @NonNull final Scale scale) {
        List<DiatonicAlt> retNotes = new ArrayList<>();
        retNotes.add(noteBase);

        DiatonicAlt newDiatonicAlt;
        AbsoluteDegree absoluteDegree = AbsoluteDegree.from(noteBase, scale.size());
        float semis = Chromatic.from(noteBase.getDiatonic()).ordinal() + noteBase.getAlterations();

        for (int i = 0; i < scale.size()-1; i++) {
            ScaleDistance step = scale.getCode().get(i);
            semis += step.getMicrotonalSemitones();
            absoluteDegree = absoluteDegree.getNext();
            newDiatonicAlt = DiatonicAlt.from(semis, absoluteDegree);

            retNotes.add(newDiatonicAlt);
        }

        return retNotes;
    }

    public static Set<DiatonicAlt> getEnharmonicsFrom(DiatonicAlt diatonicAlt, int maxAlterations) {
        return EnharmonicsRetrieval.getFromDiatonicAlt(diatonicAlt, maxAlterations);
    }
}
