package es.danisales.datune.pitch;

import es.danisales.datune.midi.AddedException;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public abstract class Chord<N extends SymbolicPitch> implements List<N>, ChordMutableInterface<N> {
	protected int root = -1;
	private List<N> innerList = new ArrayList<>();

	@Override
	public abstract Chord<N> duplicate();

	@Override
	public int size() {
		return innerList.size();
	}

	@Override
	public boolean isEmpty() {
		return innerList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return innerList.contains(o);
	}

	@Override
	public @Nonnull Iterator<N> iterator() {
		return innerList.iterator();
	}

	@Override
	public void forEach(Consumer<? super N> consumer) {
		innerList.forEach(consumer);
	}

	@Override
	@Nonnull
	public Object[] toArray() {
		return innerList.toArray();
	}

	@SuppressWarnings("SuspiciousToArrayCall")
	@Override
	@Nonnull
	public <T> T[] toArray(@Nonnull T[] ts) {
		return innerList.toArray(ts);
	}

	@Override
	public boolean add(@Nonnull N note) {
		Objects.requireNonNull(note);
		innerList.add( note );
		resetRootIfNeeded();
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return innerList.remove(o);
	}

	@Override
	public boolean containsAll(@Nonnull Collection<?> collection) {
		return innerList.containsAll(collection);
	}

	@Override
	public boolean addAll(@Nonnull Collection<? extends N> collection) {
		boolean ret = innerList.addAll(collection);

		resetRootIfNeeded();

		return ret;
	}

	@Override
	public boolean addAll(int i, @Nonnull Collection<? extends N> collection) {
		return innerList.addAll(i, collection);
	}

	@Override
	public boolean removeAll(@Nonnull Collection<?> collection) {
		return innerList.removeAll(collection);
	}

	@Override
	public boolean removeIf(Predicate<? super N> predicate) {
		return innerList.removeIf(predicate);
	}

	@Override
	public boolean retainAll(@Nonnull Collection<?> collection) {
		return innerList.retainAll(collection);
	}

	@Override
	public void replaceAll(UnaryOperator<N> unaryOperator) {
		innerList.replaceAll(unaryOperator);
	}

	@Override
	public void sort(Comparator<? super N> comparator) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		innerList.clear();
	}

	@Override
	public void add(int n, N note) throws AddedException {
		innerList.add( n, note );
		resetRootIfNeeded();
	}

	@SuppressWarnings("unchecked")
	public boolean addAll(int pos, @Nonnull N... ns) {
		return addAll(pos, Arrays.asList(ns));
	}

	@Override
	public N remove(int n) {
		N root = getRoot();
		N ret = innerList.remove( n );
		if ( ret == root )
			resetRoot();

		return ret;
	}

	@Override
	public int indexOf(Object o) {
		return innerList.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return innerList.lastIndexOf(o);
	}

	@Override
	public @Nonnull ListIterator<N> listIterator() {
		return innerList.listIterator();
	}

	@Override
	public @Nonnull ListIterator<N> listIterator(int i) {
		return innerList.listIterator(i);
	}

	@Override
	public @Nonnull List<N> subList(int i, int i1) {
		return innerList.subList(i, i1);
	}

	@Override
	public Spliterator<N> spliterator() {
		return innerList.spliterator();
	}

	@Override
	public Stream<N> stream() {
		return innerList.stream();
	}

	@Override
	public Stream<N> parallelStream() {
		return innerList.parallelStream();
	}

	private void resetRootIfNeeded() {
		if ( hasInvalidRoot() )
			resetRoot();
	}

	private boolean hasInvalidRoot() {
		return indexOutArray(root, this);
	}

	private boolean indexOutArray(int index, Collection array) {
		return index < 0 || index >= array.size();
	}

	@Override
	public void setRootPos(int n) {
		if ( indexOutArray(n, this) )
			throw new ArrayIndexOutOfBoundsException();

		root = n;
	}

	@Override
	public @Nonnull N getRoot() {
		return get(root);
	}

	@Override
	public int getRootPos() {
		return root;
	}

	@Override
	public boolean equals(Object o) {
		if ( !( o instanceof Chord ) )
			return false;

		Chord chordCasted = (Chord) o;

		return innerList.equals(chordCasted.innerList) && getRoot().equals( chordCasted.getRoot() );
	}

	@Override
	public N get(int i) {
		return innerList.get(i);
	}

	@Override
	public N set(int i, N n) {
		return innerList.set(i, n);
	}

	@Override
	public String toString() {
		return ChordNamer.from(this);
	}
}
