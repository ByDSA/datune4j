package es.danisales.datune.midi;

import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DiatonicChordMidiInfo implements Cloneable {
    private ChromaticChord chromaticChord;
    private HarmonicFunction function;
    private Tonality tonality;
    private DiatonicChordMidi diatonicChordMidi;

    private DiatonicChordMidiInfo() {
    }

    DiatonicChordMidiInfo(ChromaticChord chromaticChord, HarmonicFunction harmonicFunction, Tonality tonality) {
        this.chromaticChord = chromaticChord;
        this.function = harmonicFunction;
        this.tonality = tonality;
    }

    DiatonicChordMidiInfo(DiatonicChordMidi diatonicChordMidi) {
        this.diatonicChordMidi = diatonicChordMidi;
    }

    void update() {
        chromaticChord = ChromaticChord.builder()
                .fromDiatonicChordMidi(diatonicChordMidi)
                .build();

        tonality = diatonicChordMidi.tonality;

        function = tonality.getFunctionFrom(chromaticChord);
    }

    public @NonNull ChromaticChord getChromaticChord() {
        if (chromaticChord != null)
            return chromaticChord.clone();
        else {
            update();
            return getChromaticChord();
        }
    }

    public @Nullable HarmonicFunction getFunction() {
        return function;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public DiatonicChordMidiInfo clone() {
        DiatonicChordMidiInfo info = new DiatonicChordMidiInfo();
        info.diatonicChordMidi = diatonicChordMidi;
        info.chromaticChord = chromaticChord != null ? chromaticChord.clone() : null;
        info.tonality = tonality != null ? tonality.clone() : null;
        info.function = function;
        return info;
    }

    public Tonality getTonality() {
        return tonality;
    }

    @Override
    public String toString() {
        return function + " " + tonality;
    }
}