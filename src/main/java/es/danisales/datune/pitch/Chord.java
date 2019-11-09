package es.danisales.datune.pitch;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import es.danisales.datune.midi.AddedException;
import es.danisales.datune.midi.PitchMidiException;
import es.danisales.datune.musical.CustomChromaticChord.ImpossibleChord;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class Chord<N extends SymbolicPitch> implements List<N>, ChordMutableInterface<N> {
	protected int root = -1;
	private List<N> innerList = new ArrayList<>();

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
	public Iterator<N> iterator() {
		return innerList.iterator();
	}

	@Override
	public void forEach(Consumer<? super N> consumer) {
		innerList.forEach(consumer);
	}

	@Override
	public Object[] toArray() {
		return innerList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] ts) {
		return innerList.toArray(ts);
	}

	@Override
	public boolean add(@NonNull N note) {
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
	public boolean containsAll(@NonNull Collection<?> collection) {
		return innerList.containsAll(collection);
	}

	public @NonNull Chord<N> getOver(@NonNull N c) throws ImpossibleChord {
		Chord<N> dup = (Chord<N>) clone();
		dup.addAll(this);
		dup.over(c);

		return dup;
	}


	public void over(@NonNull N c) throws ImpossibleChord {
		for(int i = 0; i < size(); i++) {
			if ( get(0).equals( c ) )
				return;
			if (i < size()-1)
				inv();
		}

		throw new ImpossibleChord();
	}

	@Override
	public boolean addAll(@NonNull Collection<? extends N> collection) {
		boolean ret = innerList.addAll(collection);

		resetRootIfNeeded();

		return ret;
	}

	@Override
	public boolean addAll(int i, @NonNull Collection<? extends N> collection) {
		return innerList.addAll(i, collection);
	}

	@Override
	public boolean removeAll(@NonNull Collection<?> collection) {
		return innerList.removeAll(collection);
	}

	@Override
	public boolean removeIf(Predicate<? super N> predicate) {
		return innerList.removeIf(predicate);
	}

	@Override
	public boolean retainAll(@NonNull Collection<?> collection) {
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

	public boolean addAll(int pos, @NonNull N... ns) {
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
	public ListIterator<N> listIterator() {
		return innerList.listIterator();
	}

	@Override
	public ListIterator<N> listIterator(int i) {
		return innerList.listIterator(i);
	}

	@Override
	public List<N> subList(int i, int i1) {
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

	@Override
	public <T extends ChordCommon<N>> List<T> getAllInversions() {
		List<T> ret = new ArrayList<>();

		ret.add( (T) this.clone() );

		T last = ret.get( 0 );
		for ( int i = 1; i < size(); i++ ) {
			try {
				last = last.getInv();
			} catch ( PitchMidiException e ) {
				last = last.getInv( -size() + 1 );
			}
			ret.add( last );
		}

		return ret;
	}

	protected void resetRootIfNeeded() {
		if ( hasInvalidRoot() )
			resetRoot();
	}

	protected boolean hasInvalidRoot() {
		return root < 0 || root >= size();
	}

	@Override
	public void setRootPos(int n) {
		if ( n >= size() || n < 0 )
			throw new ArrayIndexOutOfBoundsException();

		root = n;
	}

	@Override
	public @NonNull N getRoot() {
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
