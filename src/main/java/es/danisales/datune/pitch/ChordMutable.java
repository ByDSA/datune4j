package es.danisales.datune.pitch;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.interval.Interval;
import es.danisales.utils.HashingUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class ChordMutable<N extends SymbolicPitch, I extends Interval> extends ListProxy<N> implements ChordMutableInterface<N, I> {
	private static final int NO_VALUE = -1;

	protected int rootIndex = NO_VALUE;
	private final List<N> innerList;

	protected ChordMutable(List<N> listAdapter) {
		super(listAdapter);

		innerList = listAdapter;
	}

	@Override
	public boolean add(@NonNull N note) {
		Objects.requireNonNull(note);

		innerList.add( note );
		resetRootIfNeededElseOnMutation();

		return true;
	}

	@Override
	public void add(int n, @NonNull N note) {
		innerList.add( n, note );

		if (n <= rootIndex)
			rootIndex++;

		resetRootIfNeededElseOnMutation();
	}

	@Override
	public boolean addAll(@NonNull Collection<? extends N> collection) {
		boolean ret = innerList.addAll(collection);

		resetRootIfNeededElseOnMutation();

		return ret;
	}

	@Override
	public boolean addAll(int index, @NonNull Collection<? extends N> collection) {
		boolean ret = innerList.addAll(index, collection);

		if (index <= rootIndex)
			rootIndex += collection.size();

		resetRootIfNeededElseOnMutation();

		return ret;
	}

	@Override
	public final N remove(int n) {
		N root = getRoot();
		N ret = innerList.remove( n );
		if ( ret == root )
			resetRoot();
		else if (ret != null)
			onMutation();

		return ret;
	}

	private void resetRootIfNeededElseOnMutation() {
		if (hasInvalidRoot()) {
			resetRoot();
		} else
			onMutation();
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

		onMutation();
	}

	protected abstract void onMutation();

	@Override
	public final void clear() {
		super.clear();
		rootIndex = NO_VALUE;
	}

	@Override
	public final @Nullable N getRoot() {
		if (rootIndex == NO_VALUE)
			return null;
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
		return innerList.hashCode() + HashingUtils.from(rootIndex);
	}

	@Override
	public String toString() {
		return ChordNamer.from(this);
	}
}
