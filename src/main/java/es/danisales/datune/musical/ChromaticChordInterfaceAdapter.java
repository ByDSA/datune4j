package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
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
