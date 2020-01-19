package es.danisales.datune.midi;

import es.danisales.datune.chords.ParametricChord;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DiatonicChordMidiInfo implements Cloneable {
    private ChromaticChord chromaticChord;
    private ParametricChord parametricChord;
    private DiatonicChordMidi diatonicChordMidi;

    private DiatonicChordMidiInfo() {
    }

    DiatonicChordMidiInfo(HarmonicFunction harmonicFunction, Tonality tonality) {
        this.parametricChord = ParametricChord.from(tonality, harmonicFunction);
        this.chromaticChord = ChromaticChord.immutableFrom(parametricChord);
    }

    DiatonicChordMidiInfo(DiatonicChordMidi diatonicChordMidi) {
        this.diatonicChordMidi = diatonicChordMidi;
    }

    void update() {
        chromaticChord = ChromaticChord.builder()
                .fromDiatonicChordMidi(diatonicChordMidi)
                .build();

        Tonality tonality = diatonicChordMidi.tonality;
        HarmonicFunction harmonicFunction = tonality.getFunctionFrom(chromaticChord);
        parametricChord = ParametricChord.from(tonality, harmonicFunction);
    }

    public @NonNull ChromaticChord getChromaticChord() {
        if (chromaticChord != null)
            return chromaticChord.clone();
        else {
            update();
            return getChromaticChord();
        }
    }

    public @Nullable ParametricChord getParametricChord() {
        return parametricChord;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public DiatonicChordMidiInfo clone() {
        DiatonicChordMidiInfo info = new DiatonicChordMidiInfo();
        info.diatonicChordMidi = diatonicChordMidi;
        info.chromaticChord = chromaticChord != null ? chromaticChord.clone() : null;
        info.parametricChord = parametricChord;
        return info;
    }

    @Override
    public String toString() {
        return parametricChord.toString();
    }
}