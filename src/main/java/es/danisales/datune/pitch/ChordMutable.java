package es.danisales.datune.pitch;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.diatonic.Interval;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class ChordMutable<N extends SymbolicPitch, I extends Interval> extends ListProxy<N> implements ChordMutableInterface<N, I> {
	protected int rootIndex = -1;
	private final List<N> innerList;

	protected ChordMutable(List<N> listAdapter) {
		super(listAdapter);

		innerList = listAdapter;
	}

	@Override
	public boolean add(@NonNull N note) {
		Objects.requireNonNull(note);

		innerList.add( note );
		resetRootIfNeeded();

		return true;
	}

	@Override
	public void add(int n, N note) {
		innerList.add( n, note );
		resetRootIfNeeded();
	}

	@Override
	public boolean addAll(@NonNull Collection<? extends N> collection) {
		boolean ret = innerList.addAll(collection);

		resetRootIfNeeded();

		return ret;
	}

	@Override
	public final N remove(int n) {
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
	public final void setRootIndex(int n) {
		if ( indexOutArray(n, this) )
			throw new ArrayIndexOutOfBoundsException();

		rootIndex = n;
	}

	@Override
	public final @NonNull N getRoot() {
		return get(rootIndex);
	}

	@Override
	public final int getRootIndex() {
		return rootIndex;
	}

	@Override
	public abstract ChordMutable<N, I> clone();

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ChordMutable))
			return false;

		ChordMutable chordCasted = (ChordMutable) o;

		return innerList.equals(chordCasted.innerList) && rootIndex == chordCasted.rootIndex;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + 31 * rootIndex;
	}

	@Override
	public String toString() {
		return ChordNamer.from(this);
	}
}
