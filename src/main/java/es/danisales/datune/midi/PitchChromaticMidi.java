package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

@SuppressWarnings("WeakerAccess")
public class PitchChromaticMidi implements PitchOctaveMidiEditable, PitchMidiInterface<IntervalChromatic> {
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B0 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B0);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B1 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B1);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B2 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B2);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B3 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B3);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B4 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B4);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B5 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B5);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B6 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B6);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A7);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B7 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B8 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B8);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi GG9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.GG9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi A9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.A9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi AA9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.AA9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi B9 = new PitchChromaticMidi(PitchChromaticMidiInmutable.B9);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi C10 = new PitchChromaticMidi(PitchChromaticMidiInmutable.C10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi CC10 = new PitchChromaticMidi(PitchChromaticMidiInmutable.CC10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi D10 = new PitchChromaticMidi(PitchChromaticMidiInmutable.D10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi DD10 = new PitchChromaticMidi(PitchChromaticMidiInmutable.DD10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi E10 = new PitchChromaticMidi(PitchChromaticMidiInmutable.E10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi F10 = new PitchChromaticMidi(PitchChromaticMidiInmutable.F10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi FF10 = new PitchChromaticMidi(PitchChromaticMidiInmutable.FF10);
    @SuppressWarnings("unused")
    public static final PitchChromaticMidi G10 = new PitchChromaticMidi(PitchChromaticMidiInmutable.G10);

    public static final PitchChromaticMidi MIN = C0;
    public static final PitchChromaticMidi MAX = G10;
    public static final int MIN_OCTAVE = 0;
    public static final int MAX_OCTAVE = 10;

    /**
     * END CONSTANTS
     * **********************************************************************************************************
     */

    private PitchChromaticMidiInmutable immutable;
    private final boolean fixed;

    public static @NonNull PitchChromaticMidi from(@NonNull PitchMidi pitchMidi) throws PitchMidiException {
        PitchChromaticMidiInmutable pitchChromaticMidiInmutable = pitchMidi.getPitchChromaticMidi().immutable;
        PitchChromaticMidi pitchChromaticMidi = new PitchChromaticMidi();
        pitchChromaticMidi.immutable = pitchChromaticMidiInmutable;
        if (pitchMidi.getCents() >= 50)
            pitchChromaticMidi.next();

        return pitchChromaticMidi;
    }

    public static @NonNull PitchChromaticMidi from(@NonNull PitchDiatonicMidi pitchDiatonicMidi) {
        Tonality tonality = pitchDiatonicMidi.tonality;
        RelativeDegree degree = pitchDiatonicMidi.degree;

        DiatonicAlt diatonicAlt = tonality.getNote(degree);
        Chromatic chromatic = Chromatic.from(diatonicAlt);

        int octave = pitchDiatonicMidi.octave;
        octave += octaveCorrector(tonality, degree);

        try {
            return from(chromatic, octave);
        } catch (PitchMidiException e) {
            e.printStackTrace();
            throw new RuntimeException("Impossible! (except checking)");
        }
    }

    private static int octaveCorrector(Tonality tonality, RelativeDegree diatonicDegree) {
        int octave = 0;

        DiatonicAlt diatonicAlt = tonality.getNote(diatonicDegree);
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

        DiatonicAlt root = tonality.getRoot();
        Chromatic rootChromatic = Chromatic.from(root);
        Chromatic chromatic = Chromatic.from(diatonicAlt);
        if (chromatic.ordinal() < rootChromatic.ordinal())
            octave++;

        return octave;
    }

    public static PitchChromaticMidi from(int code) throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = new PitchChromaticMidi();
        pitchChromaticMidi.immutable = PitchChromaticMidiInmutable.from(code);
        return pitchChromaticMidi;
    }

    public static @NonNull PitchChromaticMidi from(@NonNull Chromatic chromatic, int octave) throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = new PitchChromaticMidi();
        pitchChromaticMidi.immutable = PitchChromaticMidiInmutable.from(chromatic, octave);
        return pitchChromaticMidi;
    }

    private PitchChromaticMidi(PitchChromaticMidiInmutable pitchChromaticMidiInmutable) {
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
