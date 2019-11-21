package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class Pattern<T extends PatternInterface> implements List<Integer>, PatternInterface {
    final T innerPattern;

    Pattern(T pattern) {
        innerPattern = pattern;
    }

    @Override
    public final @NonNull List<Integer> getList() {
        return Collections.unmodifiableList( innerPattern.getList() );
    }

    /**
     *  Override List Proxy
     */

    @Override
    public final int size() {
        return getList().size();
    }

    @Override
    public final boolean isEmpty() {
        return getList().isEmpty();
    }

    @Override
    public final boolean contains(Object o) {
        return getList().contains(o);
    }

    @Override
    @NonNull
    public final Iterator<Integer> iterator() {
        return innerPattern.iterator();
    }

    @Override
    public final Object[] toArray() {
        return getList().toArray();
    }

    @SuppressWarnings("SuspiciousToArrayCall")
    @Override
    public final @NonNull <TT> TT[] toArray(@NonNull TT[] a) {
        return getList().toArray(a);
    }

    @Override
    public final boolean containsAll(@NonNull Collection<?> c) {
        return getList().containsAll(c);
    }

    @Override
    public final int hashCode() {
        return getList().hashCode();
    }

    @Override
    public final Integer get(int index) {
        return getList().get(index);
    }

    @Override
    public final int indexOf(Object o) {
        return getList().indexOf(o);
    }

    @Override
    public final int lastIndexOf(Object o) {
        return getList().lastIndexOf(o);
    }

    @Override
    @NonNull
    public final ListIterator<Integer> listIterator() {
        return getList().listIterator();
    }

    @Override
    @NonNull
    public final ListIterator<Integer> listIterator(int index) {
        return getList().listIterator(index);
    }

    @Override
    @NonNull
    public final List<Integer> subList(int fromIndex, int toIndex) {
        return getList().subList(fromIndex, toIndex);
    }

    @Override
    public final String toString() {
        return innerPattern.toString();
    }

    @Override
    public final Integer set(int index, Integer element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void add(int index, Integer element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Integer remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(@NonNull Collection<? extends Integer> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(int index, @NonNull Collection<? extends Integer> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(@NonNull Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean retainAll(@NonNull Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean add(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
}
