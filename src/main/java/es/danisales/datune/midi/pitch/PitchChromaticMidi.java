package es.danisales.datune.midi.pitch;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.degree.ChromaticDegree;
import es.danisales.datune.degree.Degree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.ScaleDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

public class PitchChromaticMidi implements PitchOctaveMidiEditable, PitchMidiInterface<IntervalChromatic> {
    @SuppressWarnings({"unused"})
    public static final PitchChromaticMidi C0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B0 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B1 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B2 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B3 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B3);
    @SuppressWarnings({"unused"})
    public static final PitchChromaticMidi C4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG4);
    @SuppressWarnings({"unused"})
    public static final PitchChromaticMidi A4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA4);
    @SuppressWarnings({"unused"})
    public static final PitchChromaticMidi B4 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C5);
    @SuppressWarnings({"unused"})
    public static final PitchChromaticMidi CC5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B5 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B6 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C7);
    @SuppressWarnings({"unused"})
    public static final PitchChromaticMidi CC7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B7 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B8 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.GG9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.A9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.AA9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B9 = new PitchChromaticMidi(PitchChromaticMidiImmutable.B9);
    @SuppressWarnings({"unused"})
    public static final PitchChromaticMidi C10 = new PitchChromaticMidi(PitchChromaticMidiImmutable.C10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC10 = new PitchChromaticMidi(PitchChromaticMidiImmutable.CC10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D10 = new PitchChromaticMidi(PitchChromaticMidiImmutable.D10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD10 = new PitchChromaticMidi(PitchChromaticMidiImmutable.DD10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E10 = new PitchChromaticMidi(PitchChromaticMidiImmutable.E10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F10 = new PitchChromaticMidi(PitchChromaticMidiImmutable.F10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF10 = new PitchChromaticMidi(PitchChromaticMidiImmutable.FF10);
    @SuppressWarnings({"unused"})
    public static final PitchChromaticMidi G10 = new PitchChromaticMidi(PitchChromaticMidiImmutable.G10);

    public static final PitchChromaticMidi MIN = C0;
    public static final PitchChromaticMidi MAX = G10;
    public static final int MIN_OCTAVE = 0;
    public static final int MAX_OCTAVE = 10;

    /**
     * END CONSTANTS
     * **********************************************************************************************************
     */

    private PitchChromaticMidiImmutable immutable;
    private final boolean fixed;

    public static @NonNull PitchChromaticMidi from(@NonNull PitchMidi pitchMidi) throws PitchMidiException {
        PitchChromaticMidiImmutable pitchChromaticMidiInmutable = pitchMidi.getPitchChromaticMidi().immutable;
        PitchChromaticMidi pitchChromaticMidi = new PitchChromaticMidi();
        pitchChromaticMidi.immutable = pitchChromaticMidiInmutable;
        if (pitchMidi.getCents() >= 50)
            pitchChromaticMidi.next();

        return pitchChromaticMidi;
    }

    public static @NonNull PitchChromaticMidi from(@NonNull PitchDiatonicMidi pitchDiatonicMidi) {
        Tonality tonality = pitchDiatonicMidi.tonality;
        Degree degree = pitchDiatonicMidi.degree;

        DiatonicAlt diatonicAlt;
        try {
            diatonicAlt = tonality.getNote(degree);
        } catch (ScaleDegreeException e) {
            throw NeverHappensException.make("Si PitchDiatonicMidi es consistente, es imposible que no exista el Degree en la Tonality");
        }
        Chromatic chromatic = Chromatic.from(diatonicAlt);

        int octave = pitchDiatonicMidi.octave;
        octave += octaveCorrector(tonality, degree);

        try {
            return from(chromatic, octave);
        } catch (PitchMidiException e) {
            throw NeverHappensException.make("Si PitchDiatonicMidi es consistente, se puede convertir a PitchChromaticMidi siempre");
        }
    }

    private static @NonNull DiatonicAlt tonalityGetNoteSecure(@NonNull Tonality tonality, @NonNull Degree degree) {
        try {
            return tonality.getNote(degree);
        } catch (ScaleDegreeException e) {
            throw NeverHappensException.make("Se supone que si se llama a 'secure' es porque la Tonality siempre tiene el Degree");
        }
    }

    private static int octaveCorrector(@NonNull Tonality tonality, @NonNull Degree degree) {
        int octave = 0;

        octave += octaveCorrectorAltRoot(tonality);
        octave += octaveCorrectorDegree(tonality, degree);

        return octave;
    }

    private static int octaveCorrectorAltRoot(@NonNull Tonality tonality) {
        int octave = 0;

        DiatonicAlt diatonicAlt = tonality.getRoot();
        Chromatic chromaticWithoutAlts = Chromatic.from(diatonicAlt.getDiatonic());
        float semis = chromaticWithoutAlts.ordinal() + diatonicAlt.getAlterations();
        while (semis < 0) {
            octave--;
            semis += Chromatic.NUMBER;
        }
        while (semis >= Chromatic.NUMBER) {
            octave++;
            semis -= Chromatic.NUMBER;
        }

        return octave;
    }

    private static int octaveCorrectorDegree(@NonNull Tonality tonality, @NonNull Degree degree) {
        int octave = 0;

        DiatonicAlt degreeDiatonicAlt = tonalityGetNoteSecure(tonality, degree);
        DiatonicAlt root = tonality.getRoot();
        Chromatic rootChromatic = Chromatic.from(root);
        Chromatic degreeChromatic = Chromatic.from(degreeDiatonicAlt);
        if (degreeChromatic.ordinal() < rootChromatic.ordinal())
            octave++;

        return octave;
    }

    public static PitchChromaticMidi from(int code) throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = new PitchChromaticMidi();
        pitchChromaticMidi.immutable = PitchChromaticMidiImmutable.from(code);
        return pitchChromaticMidi;
    }

    public static @NonNull PitchChromaticMidi from(@NonNull Chromatic chromatic, int octave) throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = new PitchChromaticMidi();
        pitchChromaticMidi.immutable = PitchChromaticMidiImmutable.from(chromatic, octave);
        return pitchChromaticMidi;
    }

    private PitchChromaticMidi(PitchChromaticMidiImmutable pitchChromaticMidiInmutable) {
        fixed = true;
        immutable = pitchChromaticMidiInmutable;
    }

    private PitchChromaticMidi() {
        fixed = false;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public PitchChromaticMidi clone() {
        PitchChromaticMidi pitchChromaticMidi = new PitchChromaticMidi();
        pitchChromaticMidi.immutable = immutable;
        return pitchChromaticMidi;
    }

    public ChromaticDegree getDegree() {
        return immutable.getDegree();
    }

    private void excepIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    @Override
    public void next() throws PitchMidiException {
        excepIfFixed();
        immutable = immutable.getNext();
    }

    @Override
    public void previous() throws PitchMidiException {
        excepIfFixed();
        immutable = immutable.getPrevious();
    }

    @Override
    public int getOctave() {
        return immutable.getOctave();
    }

    @Override
    public int getMidiCode() {
        return immutable.getCode();
    }

    public Chromatic getChromatic() {
        return immutable.getChromatic();
    }

    @Override
    public void shift(IntervalChromatic intervalChromatic) throws PitchMidiException {
        excepIfFixed();
        immutable = immutable.getShift(intervalChromatic);
    }

    @Override
    public void shift(int pos) throws PitchMidiException {
        excepIfFixed();
        immutable = immutable.getShift(pos);
    }

    public void shiftNegative(IntervalChromatic intervalChromatic) throws PitchMidiException {
        excepIfFixed();
        immutable = immutable.getShiftNegative(intervalChromatic);
    }

    @Override
    public void shiftOctave(int octaveShift) throws PitchMidiException {
        excepIfFixed();
        immutable = immutable.getWithShiftOctave(octaveShift);
    }

    @Override
    public void setOctave(int octave) throws PitchMidiException {
        excepIfFixed();
        immutable = immutable.getWithOctave(octave);
    }

    @Override
    public String toString() {
        return immutable.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PitchChromaticMidi))
            return false;


        PitchChromaticMidi pitchChromaticMidi = (PitchChromaticMidi) o;

        return pitchChromaticMidi.immutable == immutable;
    }

    @Override
    public int hashCode() {
        return immutable.hashCode();
    }
}
