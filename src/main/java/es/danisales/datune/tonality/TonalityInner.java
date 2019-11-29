package es.danisales.datune.tonality;

import es.danisales.datune.musical.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public interface TonalityInner {
    @NonNull Scale getScale();

    @NonNull DiatonicAlt getRoot();

    @NonNull List<DiatonicAlt> getNotes();
}
