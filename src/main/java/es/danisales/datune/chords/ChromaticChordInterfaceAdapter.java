package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Chromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

class ChromaticChordInterfaceAdapter {
    private ChromaticChordInterfaceAdapter() {
    }

    static @NonNull ChromaticChordInterface from(@NonNull Collection<Chromatic> chord) {
        ChromaticChordInterface ret = ChromaticChordImmutable.from(chord);
        if (ret == null)
            ret = ChromaticChordMutable.from(chord);
        return ret;
    }
}
