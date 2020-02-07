package es.danisales.datune.interval;

import es.danisales.datune.GlobalSettings;
import es.danisales.datune.chords.ChordTransformations;
import es.danisales.datune.chords.chromatic.ChromaticChord;

import java.util.Comparator;
import java.util.List;

public class ConsonanceIntervalsCalculator {
    private ConsonanceIntervalsCalculator() {
    }

    private static Comparator<IntervalChromatic> consonanceComparator = (o1, o2) -> -Integer.compare(
            GlobalSettings.sigleton().getCultural().getIntervalConsonance(o1),
            GlobalSettings.sigleton().getCultural().getIntervalConsonance(o2));

    @SuppressWarnings("WeakerAccess")
    public static int differenceOfConsonanceInterval(IntervalChromatic from, IntervalChromatic to) {
        return -GlobalSettings.sigleton().getCultural().getIntervalConsonance(to) + GlobalSettings.sigleton().getCultural().getIntervalConsonance(from);
    }

    public static int differenceOfConsonanceChord(ChromaticChord from, ChromaticChord to) {
        List<IntervalChromatic> intervalsFrom = ChordTransformations.getIntraIntervals(from);
        List<IntervalChromatic> intervalsTo = ChordTransformations.getIntraIntervals(to);

        intervalsFrom.sort(consonanceComparator);
        intervalsTo.sort(consonanceComparator);

        while(intervalsFrom.size() < intervalsTo.size()) {
            intervalsFrom.add(intervalsFrom.get(intervalsFrom.size()-1));
        }

        while(intervalsTo.size() < intervalsFrom.size()) {
            intervalsTo.add(intervalsTo.get(intervalsTo.size()-1));
        }

        int ret = 0;
        for (int i = 0; i < intervalsFrom.size(); i++) {
            // todo: quitar comentario cuando vaya bien
            //System.out.println(differenceOfConsonanceInterval(intervalsFrom.generate(i), intervalsTo.generate(i)) + " " + intervalsFrom.generate(i) + " " + intervalsTo.generate(i));
            ret += differenceOfConsonanceInterval(intervalsFrom.get(i), intervalsTo.get(i));
        }

        return ret;
    }
}
