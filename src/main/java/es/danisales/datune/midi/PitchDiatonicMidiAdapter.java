package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleDistance;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

class PitchDiatonicMidiAdapter {
    private PitchDiatonicMidiAdapter() {
    }

    /**
     * FROM PitchChromaticMidi, Tonality
     */

    public static @Nullable PitchDiatonicMidi from(@NonNull PitchChromaticMidi pitchChromaticMidi, @NonNull Tonality tonality) {
        Objects.requireNonNull(pitchChromaticMidi);
        Objects.requireNonNull(tonality);
        DiatonicDegree diatonicDegree = getDegreeFromChromaticMidi(pitchChromaticMidi, tonality);
        if (diatonicDegree == null)
            return null;

        int octave = getRootOctaveFromChromaticMidi(pitchChromaticMidi, diatonicDegree, tonality);

        return fromUncheck(diatonicDegree, tonality, octave);
    }

    private static @Nullable DiatonicDegree getDegreeFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, Tonality tonality) {
        Chromatic chromatic = pitchChromaticMidi.getChromatic();
        return (DiatonicDegree) tonality.getDegreeFrom(chromatic);
    }

    private static int getRootOctaveFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, DiatonicDegree diatonicDegree, Tonality tonality) {
        int octave = getRootOctaveWithoutAlts(pitchChromaticMidi, tonality);
        octave += octaveCorrector(pitchChromaticMidi, diatonicDegree, tonality);
        return octave;
    }

    private static int octaveCorrector(PitchChromaticMidi pitchChromaticMidi, DiatonicDegree diatonicDegree, Tonality tonality) {
        int octave = 0;

        octave += octaveCorrectionAlts(tonality);
        octave += octaveCorrectionDiatonicDegree(pitchChromaticMidi, diatonicDegree, tonality.getScale());

        return octave;
    }

    private static int octaveCorrectionDiatonicDegree(PitchChromaticMidi pitchChromaticMidi, DiatonicDegree diatonicDegree, Scale scale) {
        int semis = pitchChromaticMidi.getChromatic().ordinal();
        int octave = 0;

        for (DiatonicDegree degree = diatonicDegree.getPrevious(); degree != DiatonicDegree.VII; degree = degree.getPrevious()) {
            ScaleDistance scaleDistance = scale.get(degree);
            semis -= scaleDistance.getMicrotonalSemitones();
            if (semis < 0) {
                semis += Chromatic.NUMBER;
                octave--;
            }
        }
        return octave;
    }

    private static int octaveCorrectionAlts(Tonality tonality) {
        Diatonic diatonicRoot = tonality.getRoot().getDiatonic();
        float semis = Chromatic.from(diatonicRoot).ordinal() + tonality.getRoot().getAlterations();
        int octaveVariation = 0;
        while (semis < 0) {
            octaveVariation++;
            semis += Chromatic.NUMBER;
        }

        while (semis >= Chromatic.NUMBER) {
            octaveVariation--;
            semis -= Chromatic.NUMBER;
        }


        return octaveVariation;
    }

    private static int getRootOctaveWithoutAlts(PitchChromaticMidi pitchChromaticMidi, Tonality tonality) {
        Diatonic diatonicRoot = tonality.getRoot().getDiatonic();
        Chromatic chromaticRootWithoutAlts = Chromatic.from(diatonicRoot);

        PitchChromaticMidi pitchChromaticMidiRootWithoutAlts = PitchChromaticMidi.from(chromaticRootWithoutAlts, pitchChromaticMidi.getOctave());
        return pitchChromaticMidiRootWithoutAlts.getOctave();
    }

    static @NonNull PitchDiatonicMidi fromUncheck(@NonNull DiatonicDegree diatonicDegree, @NonNull Tonality tonality, int octave) {
        PitchDiatonicMidi ret = new PitchDiatonicMidi();
        ret.degree = diatonicDegree;
        ret.tonality = tonality;
        ret.octave = octave;

        return ret;
    }

    /**
     * FROM DiatonicDegree, Tonality, Octave
     */

    public static @Nullable PitchDiatonicMidi from(@NonNull DiatonicDegree diatonicDegree, @NonNull Tonality tonality, int octave) {
        Objects.requireNonNull(diatonicDegree);
        Objects.requireNonNull(tonality);
        PitchDiatonicMidi ret = PitchDiatonicMidiAdapter.fromUncheck(diatonicDegree, tonality, octave);

        return checkPossibleConversion(ret) ? ret : null;
    }

    private static boolean checkPossibleConversion(PitchDiatonicMidi pitchDiatonicMidi) {
        return PitchChromaticMidi.from(pitchDiatonicMidi) != null;
    }
}
