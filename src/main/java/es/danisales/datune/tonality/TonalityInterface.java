package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.ChromaticChordInterface;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface TonalityInterface {
    @NonNull ChromaticChord getChordFrom(DiatonicFunction diatonicFunction);

    @NonNull ChromaticChord getChordFrom(ChromaticFunction chromaticFunction);

    @NonNull Scale getScale();

    @NonNull DiatonicAlt getRoot();

    @NonNull List<DiatonicAlt> getNotes();

    @Nullable HarmonicFunction getFunction(ChromaticChord chromaticChord);
}
