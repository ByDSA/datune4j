package es.danisales.datune.pitch;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.midi.AddedException;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class Chord<N extends SymbolicPitch> extends ListProxy<N> implements List<N>, ChordMutableInterface<N> {
	protected int rootIndex = -1;
	private List<N> innerList;

	protected Chord(List<N> listAdapter) {
		super(listAdapter);

		innerList = listAdapter;
	}

	@Override
	public abstract Chord<N> duplicate();

	@Override
	public boolean add(@Nonnull N note) {
		Objects.requireNonNull(note);
		innerList.add( note );
		resetRootIfNeeded();
		return true;
	}

	@Override
	public boolean addAll(@Nonnull Collection<? extends N> collection) {
		boolean ret = innerList.addAll(collection);

		resetRootIfNeeded();

		return ret;
	}

	@Override
	public void sort(Comparator<? super N> comparator) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int n, N note) throws AddedException {
		innerList.add( n, note );
		resetRootIfNeeded();
	}

	@Override
	public N remove(int n) {
		N root = getRoot();
		N ret = innerList.remove( n );
		if ( ret == root )
			resetRoot();

		return ret;
	}

	private void resetRootIfNeeded() {
		if ( hasInvalidRoot() )
			resetRoot();
	}

	private boolean hasInvalidRoot() {
		return indexOutArray(rootIndex, this);
	}

	private boolean indexOutArray(int index, Collection array) {
		return index < 0 || index >= array.size();
	}

	@Override
	public void setRootPos(int n) {
		if ( indexOutArray(n, this) )
			throw new ArrayIndexOutOfBoundsException();

		rootIndex = n;
	}

	@Override
	public @Nonnull N getRoot() {
		return get(rootIndex);
	}

	@Override
	public int getRootPos() {
		return rootIndex;
	}

	@Override
	public boolean equals(Object o) {
		if ( !( o instanceof Chord ) )
			return false;

		Chord chordCasted = (Chord) o;

		return super.equals(o) && getRoot().equals( chordCasted.getRoot() );
	}

	@Override
	public String toString() {
		return ChordNamer.from(this);
	}
}
