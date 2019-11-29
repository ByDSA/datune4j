package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.NonNull;

class ChromaticChordInterfaceAdapter {
    private ChromaticChordInterfaceAdapter() {
    }

    static @NonNull ChromaticChordInterface from(@NonNull Iterable<Chromatic> chord) {
        ChromaticChordInterface ret = ChromaticChordImmutable.from(chord);
        if (ret == null)
            ret = ChromaticChordMutable.from(chord);
        return ret;
    }
}
