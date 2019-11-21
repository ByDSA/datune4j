package es.danisales.datune.musical;

import com.sun.istack.internal.NotNull;
import es.danisales.datastructures.ListProxy;
import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public abstract class NormalChordCommon<N extends AbsoluteDegree<D, I>, D extends RelativeDegree, I extends Interval> extends ListProxy<N> implements ChordMutableInterface<N, D, I> {
    ChordCommon<N, D, I> innerChord;
    private boolean fixed;

    NormalChordCommon() {
        super(new ArrayList<>());
        fixed = false;
    }

    NormalChordCommon(ChordCommon<N, D, I> chromaticChordInterface) {
        super(chromaticChordInterface);
        innerChord = chromaticChordInterface;
        fixed = true;
    }

    protected abstract void turnInnerChordIntoEnumIfPossible();

    private void exceptionIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }


    private void turnIntoCustomIfNot() {
        checkInnerNotNull();
        if ( !(innerChord instanceof DiatonicChordCustom) )
            turnInnerIntoCustom();
    }

    private void checkInnerNotNull() {
        Objects.requireNonNull(innerChord);
    }

    protected abstract void turnInnerIntoCustom();

    protected abstract boolean isEnum();
    protected abstract boolean isCustom();
    protected abstract ChordMutableInterface<N, D, I> castCustom(ChordCommon<N, D, I> chord);
    protected abstract NormalChordCommon<N, D, I> create();
    protected abstract ChordCommon<N, D, I> createInnerFrom(ChordCommon<N, D, I> chord);


    @Override
    public void shift(I interval) {
        exceptionIfFixed();

        turnInnerIntoCustom();

        for (int i = 0; i < size(); i++)
            innerChord.set(i, (N)get(i).getShifted(interval));

        turnInnerChordIntoEnumIfPossible();
    }

    private List<N> getShiftedInto(I interval) {
        List<N> list = new ArrayList<>();
        for (int i = 0; i < size(); i++)
            list.add( (N)get(i).getShifted(interval) );

        return list;
    }

    public NormalChordCommon<N, D, I> getShifted(I interval) {
        List<N> list = getShiftedInto(interval);

        NormalChordCommon<N, D, I> diatonicChord = create();
        diatonicChord.innerChord.addAll(list);
        diatonicChord.setRootPos(getRootPos());
        diatonicChord.turnInnerChordIntoEnumIfPossible();

        return diatonicChord;
    }

    @Override
    public void shiftNegative(I interval) {
        exceptionIfFixed();

        for (int i = 0; i < size(); i++)
            set( i, (N)get(i).getShiftedNegative(interval) );

        turnInnerChordIntoEnumIfPossible();
    }

    public NormalChordCommon<N, D, I> getShiftedNegative(I interval) {
        NormalChordCommon<N, D, I> diatonicChord = create();
        for (int i = 0; i < size(); i++)
            diatonicChord.add( (N)get(i).getShiftedNegative(interval) );

        diatonicChord.turnInnerChordIntoEnumIfPossible();

        return diatonicChord;
    }

    @Override
    public final void inv(int n) {
        exceptionIfFixed();

        if (isEnum())
            turnInnerIntoCustom();

        if (isCustom()) {
            castCustom(innerChord).inv(n);
            if (getRootPos() == 0)
                turnInnerChordIntoEnumIfPossible();
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<? extends ChordCommon<N, D, I>> getAllInversions() {
        List<ChordMutableInterface<N, D, I>> customDiatonicChords = getAllInversionsRaw();

        return createListFrom(customDiatonicChords);
    }

    private List<ChordMutableInterface<N, D, I>> getAllInversionsRaw() {
        List<ChordMutableInterface<N, D, I>> customDiatonicChords;

        if (isCustom()) {
            customDiatonicChords = castCustom(innerChord).getAllInversions();
        } else {
            ChordCommon<N, D, I> tmp = innerChord;
            turnInnerIntoCustom();
            customDiatonicChords = castCustom(innerChord).getAllInversions();
            innerChord = tmp;
        }

        return customDiatonicChords;
    }

    private List<NormalChordCommon<N, D, I>> createListFrom(List<ChordMutableInterface<N, D, I>> list) {
        List<NormalChordCommon<N, D, I>> ret = new ArrayList<>();
        for (ChordCommon<N, D, I> customChromaticChord : list) {
            NormalChordCommon<N, D, I> chromaticChord = create();
            chromaticChord.innerChord = customChromaticChord;
            chromaticChord.turnInnerChordIntoEnumIfPossible();
            ret.add(chromaticChord);
        }

        return ret;
    }

    @Override
    public final int getRootPos() {
        return innerChord.getRootPos();
    }

    @Nullable
    @Override
    public final N getRoot() {
        return innerChord.getRoot();
    }

    @Override
    public NormalChordCommon<N, D, I> duplicate() {
        NormalChordCommon<N, D, I> normalChordCommon = create();
        normalChordCommon.innerChord = innerChord.duplicate();
        normalChordCommon.turnInnerChordIntoEnumIfPossible();
        return normalChordCommon;
    }

    @Override
    public final void setRootPos(int pos) {
        exceptionIfFixed();

        if (getRootPos() == pos)
            return;

        if (isCustom())
            castCustom(innerChord).setRootPos(pos);
        else if (pos != 0) {
            turnInnerIntoCustom();
            castCustom(innerChord).setRootPos(pos);
        }

        turnInnerChordIntoEnumIfPossible();
    }

    @Override
    public final int size() {
        return innerChord.size();
    }

    @Override
    public final boolean isEmpty() {
        return innerChord.isEmpty();
    }

    @Override
    public final boolean contains(Object o) {
        return innerChord.contains(o);
    }

    @Override
    @NotNull
    public final Iterator<N> iterator() {
        return innerChord.iterator();
    }

    @SuppressWarnings("SuspiciousToArrayCall")
    @Override
    @NonNull
    public final <T> T[] toArray(@NonNull T[] a) {
        return innerChord.toArray(a);
    }

    @Override
    public final boolean add(N n) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.add(n);
        turnInnerChordIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final boolean remove(Object o) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.remove(o);
        turnInnerChordIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final void add(int index, N element) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        innerChord.add(index, element);
        turnInnerChordIntoEnumIfPossible();
    }

    @Override
    public final N remove(int index) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        N ret = innerChord.remove(index);
        turnInnerChordIntoEnumIfPossible();
        return ret;
    }

    @Override
    public final boolean containsAll(@NonNull Collection<?> c) {
        return innerChord.containsAll(c);
    }

    @Override
    public final boolean addAll(@NonNull Collection<? extends N> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.addAll(c);
        turnInnerChordIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final boolean addAll(int index, @NonNull Collection<? extends N> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.addAll(index, c);
        turnInnerChordIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final boolean removeAll(@NonNull Collection<?> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.removeAll(c);
        turnInnerChordIntoEnumIfPossible();

        return ret;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Override
    public final boolean retainAll(@NonNull Collection<?> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.removeAll(c);
        turnInnerChordIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final void clear() {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        innerChord.clear();
    }

    @Override
    public final N get(int index) {
        return innerChord.get(index);
    }

    @Override
    public final void resetRoot() {
        checkInnerNotNull();
        exceptionIfFixed();

        turnIntoCustomIfNot();
        ChordMutableInterface.super.resetRoot();
        turnInnerChordIntoEnumIfPossible();
    }

    @Override
    public final N set(int index, N element) {
        exceptionIfFixed();

        if (get(index) == element)
            return element;

        turnIntoCustomIfNot();

        N old = null;
        if (isCustom())
            old = innerChord.set(index, element);

        turnInnerChordIntoEnumIfPossible();

        return old;
    }

    @Override
    public final int indexOf(Object o) {
        return innerChord.indexOf(o);
    }

    @Override
    public final int lastIndexOf(Object o) {
        return innerChord.lastIndexOf(o);
    }

    @Override
    @NonNull
    public final ListIterator<N> listIterator() {
        return innerChord.listIterator();
    }

    @Override
    @NonNull
    public final ListIterator<N> listIterator(int index) {
        return innerChord.listIterator(index);
    }

    @Override
    @NonNull
    public final List<N> subList(int fromIndex, int toIndex) {
        return innerChord.subList(fromIndex, toIndex);
    }

    @Override
    public final String toString() {
        return innerChord.toString();
    }

    @Override
    public final int hashCode() {
        return innerChord._hashCode();
    }

    public List<N> getNotes() {
        return Collections.unmodifiableList(this.subList(0, size()));
    }
}
