package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class DiatonicChordPatternCustom implements DiatonicChordPatternInterface {
    private List<Integer> pattern;

    private DiatonicChordPatternCustom(Integer... patternArray) {
        pattern = Arrays.asList(patternArray);
    }

    public static @NonNull DiatonicChordPatternCustom from(Integer... patternArray) {
        return new DiatonicChordPatternCustom( patternArray );
    }

    @Override
    @NonNull
    public Iterator<Integer> iterator() {
        return pattern.iterator();
    }

    @Override
    public List<Integer> getList() {
        return Collections.unmodifiableList(pattern);
    }

    @Override
    public String toString() {
        return pattern.toString();
    }
}
