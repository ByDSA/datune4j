package es.danisales.datune.rhythm;

import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

public class RhythmPattern implements Iterable<Integer> {
    public static final RhythmPattern QUARTER = RhythmPattern.fromPattern(4);
    public static final RhythmPattern THIRD = RhythmPattern.fromPattern(3);
    public static final RhythmPattern QUARTER_THIRD = RhythmPattern.fromPattern(4, 3);
    public static final RhythmPattern TRESILLO = RhythmPattern.fromPattern(3, 3, 2);
    public static final RhythmPattern CINQUILLO = RhythmPattern.fromPattern(2, 1, 2, 1, 2);
    public static final RhythmPattern RUMBA = RhythmPattern.fromPattern(2, 3, 2, 2, 3);

    private RhythmPattern() {
    }

    private List<Integer> array = new ArrayList<>();

    @Override
    @NonNull
    public Iterator<Integer> iterator() {
        return array.iterator();
    }

    @SuppressWarnings("WeakerAccess")
    public static RhythmPattern fromInt(int... ints) {
        RhythmPattern rhythm = new RhythmPattern();
        for (int i : ints)
            rhythm.array.add(i == 0 ? 0 : 1);

        rhythm.checkFirstOne();
        rhythm.makeArrayImmutable();

        return rhythm;
    }

    @SuppressWarnings("WeakerAccess")
    public static RhythmPattern fromPattern(int... ints) {
        RhythmPattern rhythm = new RhythmPattern();
        for (int i : ints)
            for (int j = 0; j < i; j++)
                if (j == 0)
                    rhythm.array.add(1);
                else
                    rhythm.array.add(0);

        rhythm.checkFirstOne();
        rhythm.makeArrayImmutable();

        return rhythm;
    }

    @SuppressWarnings("WeakerAccess")
    public static RhythmPattern fromPattern(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = list.get(i);

        return fromPattern(array);
    }

    public int get(int pos) {
        return array.get(pos);
    }

    private void makeArrayImmutable() {
        array = ImmutableList.copyOf(array);
    }

    public int size() {
        return array.size();
    }

    @SuppressWarnings("WeakerAccess")
    public RhythmPattern getRotation(int n) {
        RhythmPattern rhythm = new RhythmPattern();
        rhythm.array = new ArrayList<>(array);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < size(); j++) {
                Collections.rotate(rhythm.array, 1);
                if (get(0) == 1)
                    break;
            }

        rhythm.makeArrayImmutable();
        rhythm.checkFirstOne();

        return rhythm;
    }

    private void checkFirstOne() {
        checkState(array.get(0) == 1);
    }

    @SuppressWarnings("WeakerAccess")
    public List<Integer> getPattern() {
        List<Integer> ret = new ArrayList<>();
        int current = 1;
        for (int i = 1; i < size(); i++) {
            if (get(i) == 0)
                current++;
            else {
                ret.add(current);
                current = 1;
            }
        }

        ret.add(current);

        return ret;
    }

    @SuppressWarnings("WeakerAccess")
    public RhythmPattern getReversed() {
        List<Integer> eucledianString = getPattern();
        Collections.reverse(eucledianString);

        return RhythmPattern.fromPattern(eucledianString);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RhythmPattern))
            return false;

        RhythmPattern rhythm = (RhythmPattern) o;

        return rhythm.array.equals(array);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        boolean first = true;
        for (int i : getPattern()) {
            if (first)
                first = false;
            else
                stringBuilder.append(", ");
            stringBuilder.append(i);
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
