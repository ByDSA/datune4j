package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
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

    public static <C extends CyclicDegree> @NonNull PitchDiatonicMidi from(@NonNull PitchChromaticMidi pitchChromaticMidi, @NonNull Tonality<C> tonality) throws TonalityException {
        Objects.requireNonNull(pitchChromaticMidi);
        Objects.requireNonNull(tonality);
        ScaleDegree scaleDegree = getDegreeFromPitchChromaticMidi(pitchChromaticMidi, tonality);

        int octave = getRootOctaveFromChromaticMidi(pitchChromaticMidi, scaleDegree, tonality);

        return fromUncheck(scaleDegree, tonality, octave);
    }

    private static <C extends CyclicDegree> @NonNull ScaleDegree getDegreeFromPitchChromaticMidi(@NonNull PitchChromaticMidi pitchChromaticMidi, @NonNull Tonality<C> tonality) throws TonalityException {
        C c;
        if (tonality.getRoot() instanceof Chromatic)
            //noinspection unchecked
            c = (C)pitchChromaticMidi.getNote();
        else if (tonality.getRoot() instanceof DiatonicAlt)
            //noinspection unchecked
            c = (C)DiatonicAlt.from(pitchChromaticMidi.getNote(), (Tonality<DiatonicAlt>)tonality);
        else
            throw NeverHappensException.make("");

        return tonality.getDegreeFrom(c);
    }

    private static <C extends CyclicDegree> int getRootOctaveFromChromaticMidi(PitchChromaticMidi pitchChromaticMidi, @NonNull ScaleDegree scaleDegree, @NonNull Tonality<C> tonality) {
        int octave = octaveCorrector(pitchChromaticMidi, scaleDegree, tonality);
        if (tonality.getRoot() instanceof DiatonicAlt)
            //noinspection unchecked
            octave += getRootOctaveWithoutAlts(pitchChromaticMidi, (Tonality<DiatonicAlt>)tonality);
        return octave;
    }

    private static <C extends CyclicDegree> int octaveCorrector(PitchChromaticMidi pitchChromaticMidi, @NonNull ScaleDegree scaleDegree, @NonNull Tonality<C> tonality) {
        int octave = 0;

        if (tonality.getRoot() instanceof DiatonicAlt)
            //noinspection unchecked
            octave += octaveCorrectionRootAlt((Tonality<DiatonicAlt>)tonality);
        octave += octaveCorrectionDegree(scaleDegree, tonality);

        return octave;
    }

    private static <C extends CyclicDegree> @NonNull C getNoteSecure(@NonNull Tonality<C> tonality, @NonNull ScaleDegree scaleDegree) {
        try {
            return tonality.getNote(scaleDegree);
        } catch (ScaleRelativeDegreeException e) {
            throw NeverHappensException.make("Siempre pertenece a Tonality");
        }
    }

    // todo: hacer test con ScaleDegree que no sea el por defecto de su cantidad de notas (ej: DiatonicDegree en Pentatonic)
    // todo: coger cosas comunes para octaveCorrector entre covnersores. Es lo mismo pero cambiado de signo
    private static <C extends CyclicDegree> int octaveCorrectionDegree(@NonNull ScaleDegree scaleDegree, @NonNull Tonality<C> tonality) {
        int octave = 0;

        C degreeDiatonicAlt = getNoteSecure(tonality, scaleDegree);
        C root = tonality.getRoot();
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

    static <C extends CyclicDegree> @NonNull PitchDiatonicMidi<C> fromUncheck(@NonNull ScaleDegree diatonicDegree, @NonNull Tonality<C> tonality, int octave) {
        PitchDiatonicMidi ret = new PitchDiatonicMidi();
        ret.degree = diatonicDegree;
        ret.tonality = tonality;
        ret.octave = octave;

        return ret;
    }

    /**
     * FROM DiatonicDegree, Tonality, Octave
     */

    public static <C extends CyclicDegree> @NonNull PitchDiatonicMidi<C> from(@NonNull ScaleDegree scaleDegree, @NonNull Tonality<C> tonality, int octave) throws PitchMidiException {
        Objects.requireNonNull(scaleDegree);
        Objects.requireNonNull(tonality);
        PitchDiatonicMidi<C> ret = PitchDiatonicMidiAdapter.fromUncheck(scaleDegree, tonality, octave);

        PitchMidiException.check(ret);
        return ret;
    }
}
