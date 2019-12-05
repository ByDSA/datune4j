package es.danisales.datune.midi.pitch;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.degree.Degree;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.ScaleDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.utils.NeverHappensException;
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

        octave += octaveCorrectionRootAlt(tonality);
        octave += octaveCorrectionDegree(relativeDegree, tonality);

        return octave;
    }

    private static DiatonicAlt getNoteSecure(Tonality tonality, Degree degree) {
        try {
            return tonality.getNote(degree);
        } catch (ScaleDegreeException e) {
            throw NeverHappensException.make("Siempre pertenece a Tonality");
        }
    }

    // todo: hacer test con Degree que no sea el por defecto de su cantidad de notas (ej: DiatonicDegree en Pentatonic)
    // todo: coger cosas comunes para octaveCorrector entre covnersores. Es lo mismo pero cambiado de signo
    private static int octaveCorrectionDegree(Degree degree1, Tonality tonality) {
        int octave = 0;

        DiatonicAlt degreeDiatonicAlt = getNoteSecure(tonality, degree1);
        DiatonicAlt root = tonality.getRoot();
        Chromatic rootChromatic = Chromatic.from(root);
        Chromatic degreeChromatic = Chromatic.from(degreeDiatonicAlt);
        if (degreeChromatic.ordinal() < rootChromatic.ordinal())
            octave--;

        return octave;
    }

    private static int octaveCorrectionRootAlt(Tonality tonality) {
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
