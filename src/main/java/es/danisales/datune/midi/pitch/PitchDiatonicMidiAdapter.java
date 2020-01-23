package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
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
        ScaleDegree relativeDegree = getDegreeFromChromaticMidi(pitchChromaticMidi, tonality);

        int octave = getRootOctaveFromChromaticMidi(pitchChromaticMidi, relativeDegree, tonality);

        return fromUncheck(relativeDegree, tonality, octave);
    }

    private static @NonNull ScaleDegree getDegreeFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, Tonality tonality) throws TonalityException {
        Chromatic chromatic = pitchChromaticMidi.getNote();
        return tonality.getDegreeFrom(chromatic);
    }

    private static int getRootOctaveFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, ScaleDegree relativeDegree, Tonality tonality) {
        int octave = getRootOctaveWithoutAlts(pitchChromaticMidi, tonality);
        octave += octaveCorrector(pitchChromaticMidi, relativeDegree, tonality);
        return octave;
    }

    private static int octaveCorrector(PitchChromaticMidi pitchChromaticMidi, ScaleDegree relativeDegree, Tonality tonality) {
        int octave = 0;

        octave += octaveCorrectionRootAlt(tonality);
        octave += octaveCorrectionDegree(relativeDegree, tonality);

        return octave;
    }

    private static DiatonicAlt getNoteSecure(Tonality<DiatonicAlt> tonality, ScaleDegree degree) {
        try {
            return tonality.getNote(degree);
        } catch (ScaleRelativeDegreeException e) {
            throw NeverHappensException.make("Siempre pertenece a Tonality");
        }
    }

    // todo: hacer test con ScaleDegree que no sea el por defecto de su cantidad de notas (ej: DiatonicDegree en Pentatonic)
    // todo: coger cosas comunes para octaveCorrector entre covnersores. Es lo mismo pero cambiado de signo
    private static int octaveCorrectionDegree(ScaleDegree degree1, Tonality<DiatonicAlt> tonality) {
        int octave = 0;

        DiatonicAlt degreeDiatonicAlt = getNoteSecure(tonality, degree1);
        DiatonicAlt root = tonality.getRoot();
        Chromatic rootChromatic = Chromatic.from(root);
        Chromatic degreeChromatic = Chromatic.from(degreeDiatonicAlt);
        if (degreeChromatic.ordinal() < rootChromatic.ordinal())
            octave--;

        return octave;
    }

    private static int octaveCorrectionRootAlt(Tonality<DiatonicAlt> tonality) {
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

    private static int getRootOctaveWithoutAlts(PitchChromaticMidi pitchChromaticMidi, Tonality<DiatonicAlt> tonality) {
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

    static @NonNull PitchDiatonicMidi fromUncheck(@NonNull ScaleDegree diatonicDegree, @NonNull Tonality tonality, int octave) {
        PitchDiatonicMidi ret = new PitchDiatonicMidi();
        ret.degree = diatonicDegree;
        ret.tonality = tonality;
        ret.octave = octave;

        return ret;
    }

    /**
     * FROM DiatonicDegree, Tonality, Octave
     */

    public static @NonNull PitchDiatonicMidi from(@NonNull ScaleDegree scaleDegree, @NonNull Tonality tonality, int octave) throws PitchMidiException {
        Objects.requireNonNull(scaleDegree);
        Objects.requireNonNull(tonality);
        PitchDiatonicMidi ret = PitchDiatonicMidiAdapter.fromUncheck(scaleDegree, tonality, octave);

        PitchMidiException.check(ret);
        return ret;
    }
}
