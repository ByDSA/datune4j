package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class ChromaticChordPatternCustom implements ChromaticChordPatternInterface {
    private List<Integer> pattern;

    private ChromaticChordPatternCustom(Integer... patternArray) {
        pattern = Arrays.asList(patternArray);
    }

    public static @NonNull ChromaticChordPatternCustom from(Integer... patternArray) {
        return new ChromaticChordPatternCustom( patternArray );
    }

    @Override
    @NonNull
    public Iterator<Integer> iterator() {
        return pattern.iterator();
    }

    @Override
    public List<Integer> getPattern() {
        return Collections.unmodifiableList(pattern);
    }
}
