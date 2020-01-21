package es.danisales.datune.midi;

import es.danisales.datune.chords.TonalChord;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DiatonicChordMidiInfo implements Cloneable {
    private ChromaticChord chromaticChord;
    private TonalChord parametricChord;
    private DiatonicChordMidi diatonicChordMidi;

    private DiatonicChordMidiInfo() {
    }

    DiatonicChordMidiInfo(HarmonicFunction harmonicFunction, Tonality tonality) {
        this.parametricChord = TonalChord.from(tonality, harmonicFunction);
        this.chromaticChord = ChromaticChord.from(parametricChord);
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
        parametricChord = TonalChord.from(tonality, harmonicFunction);
    }

    public @NonNull ChromaticChord getChromaticChord() {
        if (chromaticChord != null)
            return chromaticChord.clone();
        else {
            update();
            return getChromaticChord();
        }
    }

    public @Nullable TonalChord getParametricChord() {
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