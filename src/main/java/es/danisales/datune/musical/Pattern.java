package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Pattern<T extends PatternInterface> implements PatternInterface {
    final T innerPattern;

    Pattern(T pattern) {
        innerPattern = pattern;
    }

    @Override
    public final @NonNull List<Integer> getList() {
        return Collections.unmodifiableList( innerPattern.getList() );
    }

    @Override
    @NonNull
    public final Iterator<Integer> iterator() {
        return innerPattern.iterator();
    }

    @Override
    public final int hashCode() {
        return innerPattern.getList().hashCode();
    }

    @Override
    public final String toString() {
        return innerPattern.toString();
    }
}
