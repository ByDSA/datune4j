package es.danisales.datune.musical;

import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

class ChromaticChordInterfaceAdapter {
    private ChromaticChordInterfaceAdapter() {
    }

    static <T extends PitchChromaticSingle> @NonNull ChromaticChordInterface from(@NonNull Collection<T> chord) {
        ChromaticChordInterface ret = ChromaticChordEnum.from(chord);
        if (ret == null)
            ret = ChromaticChordCustom.from(chord);
        return ret;
    }
}