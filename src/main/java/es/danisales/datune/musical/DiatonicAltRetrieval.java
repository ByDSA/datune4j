package es.danisales.datune.musical;

import es.danisales.datune.musical.transformations.EnharmonicsRetrieval;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleDistance;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<DiatonicAlt> notes = new ArrayList<>();
        Chromatic chromatic = Chromatic.from(noteBase);
        float semitones = chromatic.ordinal();
        float microtonalPart = 0;
        AbsoluteDegree absoluteDegree = AbsoluteDegree.from(noteBase, scale.size());
        Objects.requireNonNull(absoluteDegree, noteBase + " " + scale.size());

        for ( ScaleDistance step : scale ) {
            DiatonicAlt newDiatonicAlt = DiatonicAlt.from(chromatic, absoluteDegree);
            if (scale.size() > Diatonic.NUMBER && newDiatonicAlt.getAlterations() >= 1)
                newDiatonicAlt = EnharmonicsRetrieval.getMinAlts(newDiatonicAlt);

            newDiatonicAlt = DiatonicAlt.from(newDiatonicAlt.getDiatonic(), newDiatonicAlt.getSemitonesAdded() + microtonalPart);

            notes.add(newDiatonicAlt);

            semitones += step.getMicrotonalSemitones();
            microtonalPart = MathUtils.decimalPart( step.getMicrotonalSemitones() );
            if (semitones > Chromatic.NUMBER)
                semitones -= Chromatic.NUMBER;
            chromatic = Chromatic.from(Math.round(semitones));
            absoluteDegree = absoluteDegree.getNext();
        }

        return notes;
    }

    public static boolean areEnharmonic(DiatonicAlt diatonicAlt1, DiatonicAlt diatonicAlt2) {
        Chromatic chromatic1 = Chromatic.from(diatonicAlt1);
        Chromatic chromatic2 = Chromatic.from(diatonicAlt2);
        return chromatic1 == chromatic2;
    }


    public static Set<DiatonicAlt> getEnharmonicsFrom(DiatonicAlt diatonicAlt, int maxAlterations) {
        return EnharmonicsRetrieval.getAllFrom(diatonicAlt, maxAlterations);
    }
}
