package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class Pattern implements List<Integer>, PatternInterface, Cloneable {
    List<Integer> numbersPattern;
    final private boolean fixed;

    Pattern(@NonNull Integer... pattern) {
        this(Arrays.asList(pattern));
    }

    Pattern(@NonNull List<Integer> patternList) {
        numbersPattern = patternList;
        fixed = true;
    }

    Pattern() {
        numbersPattern = new ArrayList<>();
        fixed = false;
    }

    @SuppressWarnings("WeakerAccess")
    public boolean isImmutable() {
        return fixed;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Pattern clone() {
        Pattern pattern = new Pattern();
        pattern.addAll(this);
        return pattern;
    }

    @Override
    public final @NonNull List<Integer> getList() {
        return Collections.unmodifiableList(numbersPattern);
    }

    /**
     *  Override List Proxy
     */

    @Override
    public final int size() {
        return numbersPattern.size();
    }

    @Override
    public final boolean isEmpty() {
        return numbersPattern.isEmpty();
    }

    @Override
    public final boolean contains(Object o) {
        return numbersPattern.contains(o);
    }

    @Override
    @NonNull
    public final Iterator<Integer> iterator() {
        return numbersPattern.iterator();
    }

    @Override
    public final Object[] toArray() {
        return numbersPattern.toArray();
    }

    @SuppressWarnings("SuspiciousToArrayCall")
    @Override
    public final @NonNull <TT> TT[] toArray(@NonNull TT[] a) {
        return numbersPattern.toArray(a);
    }

    @Override
    public final boolean containsAll(@NonNull Collection<?> c) {
        return numbersPattern.containsAll(c);
    }

    @Override
    public final Integer get(int index) {
        return numbersPattern.get(index);
    }

    @Override
    public final int indexOf(Object o) {
        return numbersPattern.indexOf(o);
    }

    @Override
    public final int lastIndexOf(Object o) {
        return numbersPattern.lastIndexOf(o);
    }

    @Override
    @NonNull
    public final ListIterator<Integer> listIterator() {
        return numbersPattern.listIterator();
    }

    @Override
    @NonNull
    public final ListIterator<Integer> listIterator(int index) {
        return numbersPattern.listIterator(index);
    }

    @Override
    @NonNull
    public final List<Integer> subList(int fromIndex, int toIndex) {
        return numbersPattern.subList(fromIndex, toIndex);
    }

    @Override
    public final String toString() {
        return numbersPattern.toString();
    }

    private void excepIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    @Override
    public final Integer set(int index, Integer element) {
        excepIfFixed();
        return numbersPattern.set(index, element);
    }

    @Override
    public final void add(int index, Integer element) {
        excepIfFixed();
        numbersPattern.add(index, element);
    }

    @Override
    public final Integer remove(int index) {
        excepIfFixed();
        return numbersPattern.remove(index);
    }

    @Override
    public final boolean addAll(@NonNull Collection<? extends Integer> c) {
        excepIfFixed();
        return numbersPattern.addAll(c);
    }

    @Override
    public final boolean addAll(int index, @NonNull Collection<? extends Integer> c) {
        excepIfFixed();
        return numbersPattern.addAll(index, c);
    }

    @Override
    public final boolean removeAll(@NonNull Collection<?> c) {
        excepIfFixed();
        return numbersPattern.removeAll(c);
    }

    @Override
    public final boolean retainAll(@NonNull Collection<?> c) {
        excepIfFixed();
        return numbersPattern.retainAll(c);
    }

    @Override
    public final void clear() {
        excepIfFixed();
        numbersPattern.clear();
    }

    @Override
    public final boolean add(Integer integer) {
        excepIfFixed();
        return numbersPattern.add(integer);
    }

    @Override
    public final boolean remove(Object o) {
        excepIfFixed();
        return numbersPattern.remove(o);
    }

    @Override
    public final int hashCode() {
        return numbersPattern.hashCode() + 31 * Boolean.hashCode(fixed);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pattern))
            return false;

        Pattern otherCasted = (Pattern) o;

        return numbersPattern.equals(otherCasted.numbersPattern);
    }

}
