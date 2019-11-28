package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleDistance;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

class PitchDiatonicMidiAdapter {
    private PitchDiatonicMidiAdapter() {
    }

    /**
     * FROM PitchChromaticMidi, Tonality
     */

    public static @NonNull PitchDiatonicMidi from(@NonNull PitchChromaticMidi pitchChromaticMidi, @NonNull Tonality tonality) throws TonalityException {
        Objects.requireNonNull(pitchChromaticMidi);
        Objects.requireNonNull(tonality);
        DiatonicDegree diatonicDegree = getDegreeFromChromaticMidi(pitchChromaticMidi, tonality);

        int octave = getRootOctaveFromChromaticMidi(pitchChromaticMidi, diatonicDegree, tonality);

        return fromUncheck(diatonicDegree, tonality, octave);
    }

    private static @NonNull DiatonicDegree getDegreeFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, Tonality tonality) throws TonalityException {
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

        PitchChromaticMidi pitchChromaticMidiRootWithoutAlts = null;
        try {
            pitchChromaticMidiRootWithoutAlts = PitchChromaticMidi.from(chromaticRootWithoutAlts, pitchChromaticMidi.getOctave());
        } catch (PitchMidiException e) {
            throw new RuntimeException();
        }
        return pitchChromaticMidiRootWithoutAlts.getOctave();
    }

    static @NonNull PitchDiatonicMidi fromUncheck(@NonNull RelativeDegree diatonicDegree, @NonNull Tonality tonality, int octave) {
        PitchDiatonicMidi ret = new PitchDiatonicMidi();
        ret.degree = diatonicDegree;
        ret.tonality = tonality;
        ret.octave = octave;

        return ret;
    }

    /**
     * FROM DiatonicDegree, Tonality, Octave
     */

    public static @NonNull PitchDiatonicMidi from(@NonNull RelativeDegree diatonicDegree, @NonNull Tonality tonality, int octave) throws PitchMidiException {
        Objects.requireNonNull(diatonicDegree);
        Objects.requireNonNull(tonality);
        PitchDiatonicMidi ret = PitchDiatonicMidiAdapter.fromUncheck(diatonicDegree, tonality, octave);

        checkPossibleConversion(ret);
        return ret;
    }

    private static void checkPossibleConversion(PitchDiatonicMidi pitchDiatonicMidi) throws PitchMidiException {
        PitchChromaticMidi.from(pitchDiatonicMidi);
    }
}
