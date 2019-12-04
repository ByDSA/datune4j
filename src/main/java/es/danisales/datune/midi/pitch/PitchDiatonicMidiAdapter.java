package es.danisales.datune.midi.pitch;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.degree.Degree;
import es.danisales.datune.tonality.*;
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
        Degree relativeDegree = getDegreeFromChromaticMidi(pitchChromaticMidi, tonality);

        int octave = getRootOctaveFromChromaticMidi(pitchChromaticMidi, relativeDegree, tonality);

        return fromUncheck(relativeDegree, tonality, octave);
    }

    private static @NonNull Degree getDegreeFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, Tonality tonality) throws TonalityException {
        Chromatic chromatic = pitchChromaticMidi.getChromatic();
        return tonality.getDegreeFrom(chromatic);
    }

    private static int getRootOctaveFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, Degree relativeDegree, Tonality tonality) {
        int octave = getRootOctaveWithoutAlts(pitchChromaticMidi, tonality);
        octave += octaveCorrector(pitchChromaticMidi, relativeDegree, tonality);
        return octave;
    }

    private static int octaveCorrector(PitchChromaticMidi pitchChromaticMidi, Degree relativeDegree, Tonality tonality) {
        int octave = 0;

        octave += octaveCorrectionAlts(tonality);
        octave += octaveCorrectionDiatonicDegree(pitchChromaticMidi, relativeDegree, tonality.getScale());

        return octave;
    }

    private static int octaveCorrectionDiatonicDegree(PitchChromaticMidi pitchChromaticMidi, Degree relativeDegree, Scale scale) {
        int semis = pitchChromaticMidi.getChromatic().ordinal();
        int octave = 0;

        for (Degree degree = relativeDegree.getPrevious(); degree.getNext().ordinal() != 0; degree = degree.getPrevious()) {
            ScaleDistance scaleDistance = null;
            try {
                scaleDistance = scale.getDistance(degree);
            } catch (ScaleDegreeException e) {
                continue;
            }
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

        PitchChromaticMidi pitchChromaticMidiRootWithoutAlts;
        try {
            pitchChromaticMidiRootWithoutAlts = PitchChromaticMidi.from(chromaticRootWithoutAlts, pitchChromaticMidi.getOctave());
        } catch (PitchMidiException e) {
            throw new RuntimeException();
        }
        return pitchChromaticMidiRootWithoutAlts.getOctave();
    }

    static @NonNull PitchDiatonicMidi fromUncheck(@NonNull Degree diatonicDegree, @NonNull Tonality tonality, int octave) {
        PitchDiatonicMidi ret = new PitchDiatonicMidi();
        ret.degree = diatonicDegree;
        ret.tonality = tonality;
        ret.octave = octave;

        return ret;
    }

    /**
     * FROM DiatonicDegree, Tonality, Octave
     */

    public static @NonNull PitchDiatonicMidi from(@NonNull Degree diatonicDegree, @NonNull Tonality tonality, int octave) throws PitchMidiException {
        Objects.requireNonNull(diatonicDegree);
        Objects.requireNonNull(tonality);
        PitchDiatonicMidi ret = PitchDiatonicMidiAdapter.fromUncheck(diatonicDegree, tonality, octave);

        PitchMidiException.check(ret);
        return ret;
    }
}
