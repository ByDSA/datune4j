package es.danisales.datune.musical;

import com.sun.istack.internal.NotNull;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import es.danisales.datune.pitch.SymbolicPitch;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.function.BiFunction;

public abstract class NormalChordCommon<N extends SymbolicPitch> implements ChordMutableInterface<N> {
    protected ChordCommon<N> innerChord;
    protected boolean fixed;

    protected NormalChordCommon() {
        fixed = false;
    }

    protected NormalChordCommon( ChordCommon<N> chromaticChordInterface) {
        innerChord = chromaticChordInterface;
        fixed = true;
    }

    protected abstract void turnIntoEnumIfPossible();

    private void exceptionIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }


    private void turnIntoCustomIfNot() {
        if ( !(innerChord instanceof CustomDiatonicChord) )
            turnInnerIntoCustom();
    }

    protected abstract void turnInnerIntoCustom();

    protected abstract boolean isEnum();
    protected abstract boolean isCustom();
    protected abstract ChordMutableInterface<N> castCustom(ChordCommon<N> chord);
    protected abstract NormalChordCommon<N> create();
    protected abstract ChordCommon<N> createInnerFrom(ChordCommon<N> chord);

    @Override
    public final void inv(int n) {
        exceptionIfFixed();

        if (isEnum())
            turnInnerIntoCustom();

        if (isCustom()) {
            castCustom(innerChord).inv(n);
            if (getRootPos() == 0)
                turnIntoEnumIfPossible();
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<? extends ChordCommon<N>> getAllInversions() {
        ChordCommon<N> base;
        if (isCustom())
            base = castCustom(innerChord);
        else
            base = createInnerFrom(innerChord);
        List<ChordMutableInterface<N>> customDiatonicChords = base.getAllInversions();

        List<ChordCommon<N>> ret = new ArrayList<>();
        for (ChordCommon<N> customChromaticChord : customDiatonicChords) {
            NormalChordCommon<N> chromaticChord = create();
            chromaticChord.innerChord = customChromaticChord;
            chromaticChord.turnIntoEnumIfPossible();
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
    public NormalChordCommon<N> duplicate() {
        NormalChordCommon<N> normalChordCommon = create();
        normalChordCommon.innerChord = innerChord.duplicate();
        normalChordCommon.turnIntoEnumIfPossible();
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

        turnIntoEnumIfPossible();
    }

    @Override
    public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordCommon<?>, CustomChromaticChord> fSelectChord) {
        return null;
    }

    @Override
    public Boolean updateWhatIsItIfNeeded() {
        return null;
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

    @Override
    @NonNull
    public final N[] toArray() {
        return (N[])innerChord.toArray();
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
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final boolean remove(Object o) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.remove(o);
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final void add(int index, N element) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        innerChord.add(index, element);
        turnIntoEnumIfPossible();
    }

    @Override
    public final N remove(int index) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        N ret = innerChord.remove(index);
        turnIntoEnumIfPossible();
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
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final boolean addAll(int index, @NonNull Collection<? extends N> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.addAll(index, c);
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final boolean removeAll(@NonNull Collection<?> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.removeAll(c);
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public final boolean retainAll(@NonNull Collection<?> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerChord.removeAll(c);
        turnIntoEnumIfPossible();

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
        exceptionIfFixed();
        turnIntoCustomIfNot();
        ChordMutableInterface.super.resetRoot();
        turnIntoEnumIfPossible();
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

        turnIntoEnumIfPossible();

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
}
