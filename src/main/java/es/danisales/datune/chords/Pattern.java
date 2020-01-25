package es.danisales.datune.chords;

import com.google.common.collect.ImmutableList;
import es.danisales.datastructures.ListProxy;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pattern
        extends ListProxy<Integer> {
    protected Pattern() {
        super(new ArrayList<>());
    }

    protected Pattern(@NonNull Integer[] pattern) {
        this(Arrays.asList(pattern));
    }

    protected Pattern(@NonNull List<Integer> patternList) {
        super(ImmutableList.copyOf(patternList));
    }

    public boolean isImmutable() {
        return listAdapter instanceof ImmutableList;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Pattern clone() {
        Pattern pattern = new Pattern();
        pattern.addAll(this);
        return pattern;
    }

    public final @NonNull List<Integer> getList() {
        return Collections.unmodifiableList(listAdapter);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pattern))
            return false;

        return super.equals(o);
    }

}
