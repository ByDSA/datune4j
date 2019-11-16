package es.danisales.datune.musical;

import java.util.List;

public interface ChromaticChordPatternInterface extends Iterable<Integer> {
    List<Integer> getPattern();
}
