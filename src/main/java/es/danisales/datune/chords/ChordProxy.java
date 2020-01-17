package es.danisales.datune.chords;

import es.danisales.datune.degrees.OrderedDegree;
import es.danisales.datune.interval.Interval;
import es.danisales.datune.lang.ChordNotation;
import es.danisales.datune.pitch.PitchException;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public abstract class ChordProxy<C extends ChordCommon<N>, N extends OrderedDegree, I extends Interval>
        implements ChordMutableInterface<N, I> {
    private static final NeverHappensException NEVER_HAPPENS_EXCEPTION
            = NeverHappensException.make("Los ChordProxy son siempre de Chromatic o Diatonic y no tienen problemas de octava mínima o máxima");

    protected C innerChord;
    private boolean fixed;

    ChordProxy() {
        fixed = false;
    }

    ChordProxy(C chromaticChordInterface) {
        innerChord = chromaticChordInterface;
        fixed = true;
    }

    protected abstract void turnInnerChordIntoImmutableIfPossible();

    private void exceptionIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    private void turnInnerIntoMutableIfNot() {
        checkInnerNotNull();
        if (!(innerChord instanceof ChordMutableInterface))
            turnInnerIntoMutable();
    }

    private void checkInnerNotNull() {
        Objects.requireNonNull(innerChord);
    }

    protected abstract void turnInnerIntoMutable();

    protected abstract boolean innerIsImmutable();

    protected abstract boolean InnerIsMutable();

    protected abstract ChordMutableInterface<N, I> castCustom(C chord);

    protected abstract ChordProxy<C, N, I> create();

    @SuppressWarnings("unchecked")
    @Override
    public void shift(I interval) throws PitchException {
        exceptionIfFixed();

        turnInnerIntoMutable();

        for (int i = 0; i < size(); i++)
            set(i, (N) get(i).getShifted(interval.ordinal()));

        turnInnerChordIntoImmutableIfPossible();
    }

    @SuppressWarnings("unchecked")
    private List<N> getShiftedInto(I interval) throws PitchException {
        List<N> list = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            list.add((N) get(i).getShifted(interval.ordinal()));
        }

        return list;
    }

    public ChordProxy<C, N, I> getShifted(I interval) throws PitchException {
        List<N> list = getShiftedInto(interval);

        ChordProxy<C, N, I> diatonicChord = create();
        diatonicChord.innerChord.addAll(list);
        diatonicChord.setRootIndex(getRootIndex());
        diatonicChord.turnInnerChordIntoImmutableIfPossible();

        return diatonicChord;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void shiftNegative(I interval) throws PitchException {
        exceptionIfFixed();

        for (int i = 0; i < size(); i++)
            set(i, (N) get(i).getShifted(-interval.ordinal()));

        turnInnerChordIntoImmutableIfPossible();
    }

    @SuppressWarnings("unchecked")
    public ChordProxy<C, N, I> getShiftedNegative(I interval) throws PitchException {
        ChordProxy<C, N, I> diatonicChord = create();
        for (int i = 0; i < size(); i++) {
            diatonicChord.add((N) get(i).getShifted(-interval.ordinal()));
        }

        diatonicChord.turnInnerChordIntoImmutableIfPossible();

        return diatonicChord;
    }

    @Override
    public final void inv(int n) {
        exceptionIfFixed();

        if (innerIsImmutable())
            turnInnerIntoMutable();

        if (InnerIsMutable()) {
            try {
                castCustom(innerChord).inv(n);
            } catch (PitchException e) {
                throw NEVER_HAPPENS_EXCEPTION;
            }
            if (getRootIndex() == 0)
                turnInnerChordIntoImmutableIfPossible();
        }
    }

    @Override
    public final int getRootIndex() {
        return innerChord.getRootIndex();
    }

    @Override
    public final @Nullable N getRoot() {
        return innerChord.getRoot();
    }

    @SuppressWarnings({"unchecked", "MethodDoesntCallSuperMethod"})
    @Override
    public ChordProxy<C, N, I> clone() {
        ChordProxy<C, N, I> normalChordCommon = create();
        if (innerIsImmutable())
            normalChordCommon.innerChord = innerChord;
        else {
            normalChordCommon.innerChord = (C) ((ChordMutableInterface) innerChord).clone();
            normalChordCommon.turnInnerChordIntoImmutableIfPossible();
        }

        return normalChordCommon;
    }

    @Override
    public final void setRootIndex(int pos) {
        exceptionIfFixed();

        if (getRootIndex() == pos)
            return;

        else if (!InnerIsMutable() && pos != 0)
            turnInnerIntoMutable();

        castCustom(innerChord).setRootIndex(pos);

        turnInnerChordIntoImmutableIfPossible();
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
    @NonNull
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
    public @NonNull Object[] toArray() {
        return innerChord.toArray();
    }

    @Override
    public final boolean add(@NonNull N n) {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        innerChord.add(n);
        turnInnerChordIntoImmutableIfPossible();

        return true;
    }

    @Override
    public final boolean remove(Object o) {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        boolean ret = innerChord.remove(o);
        turnInnerChordIntoImmutableIfPossible();

        return ret;
    }

    @Override
    public final void add(int index, N element) {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        innerChord.add(index, element);
        turnInnerChordIntoImmutableIfPossible();
    }

    @Override
    public final N remove(int index) {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        N ret = innerChord.remove(index);
        turnInnerChordIntoImmutableIfPossible();
        return ret;
    }

    @Override
    public final boolean containsAll(@NonNull Collection<?> c) {
        return innerChord.containsAll(c);
    }

    @Override
    public final boolean addAll(@NonNull Collection<? extends N> c) {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        boolean ret = innerChord.addAll(c);
        turnInnerChordIntoImmutableIfPossible();

        return ret;
    }

    @Override
    public final boolean addAll(int index, @NonNull Collection<? extends N> c) {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        boolean ret = innerChord.addAll(index, c);
        turnInnerChordIntoImmutableIfPossible();

        return ret;
    }

    @Override
    public final boolean removeAll(@NonNull Collection<?> c) {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        boolean ret = innerChord.removeAll(c);
        turnInnerChordIntoImmutableIfPossible();

        return ret;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Override
    public final boolean retainAll(@NonNull Collection<?> c) {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        boolean ret = innerChord.removeAll(c);
        turnInnerChordIntoImmutableIfPossible();

        return ret;
    }

    @Override
    public final void clear() {
        exceptionIfFixed();
        turnInnerIntoMutableIfNot();
        innerChord.clear();
    }

    @Override
    public final N get(int index) {
        return innerChord.get(index);
    }

    @NonNull
    @Override
    public final N getCyclic(int noteNumber) {
        try {
            return ((ChordCommon<N>) this).getCyclic(noteNumber);
        } catch (PitchException e) {
            throw NEVER_HAPPENS_EXCEPTION;
        }
    }

    @Override
    public final void resetRoot() {
        checkInnerNotNull();
        exceptionIfFixed();

        turnInnerIntoMutableIfNot();
        ChordMutableInterface.super.resetRoot();
        turnInnerChordIntoImmutableIfPossible();
    }

    @Override
    public final N set(int index, N element) {
        exceptionIfFixed();

        if (get(index) == element)
            return element;

        turnInnerIntoMutableIfNot();

        N old = null;
        if (InnerIsMutable())
            old = innerChord.set(index, element);

        turnInnerChordIntoImmutableIfPossible();

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
        if (innerIsImmutable()) {
            return innerChord.toString();
        } else {
            if ( size() == 0 )
                return ChordNotation.EMPTY_CHORD;

            if (getRootIndex() != 0) {
                ChordProxy<C, N, I> normalChordCommon = clone();
                normalChordCommon.toFundamental();
                if (normalChordCommon.innerIsImmutable())
                    return normalChordCommon.toString() + "/" + get(0).toString();
            }
            return ChordNamer.from(this);
        }
    }

    @Override
    public final int hashCode() {
        if (size() == 0)
            return 0;

        int result = 1;

        for (N element : innerChord)
            result = 31 * result + (element == null ? 0 : element.hashCode());
        result = 37 * result + getRootIndex();

        return result;
    }

    public List<N> getNotes() {
        return Collections.unmodifiableList(this.subList(0, size()));
    }

    @Override
    public void over(@NonNull N chromatic) {
        try {
            ChordMutableInterface.super.over(chromatic);
        } catch (PitchException e) {
            throw NEVER_HAPPENS_EXCEPTION;
        }
    }

    @Override
    public void toFundamental() {
        try {
            ChordMutableInterface.super.toFundamental();
        } catch (PitchException e) {
            throw NEVER_HAPPENS_EXCEPTION;
        }
    }

    @Override
    public void inv() {
        try {
            ChordMutableInterface.super.inv();
        } catch (PitchException e) {
            throw NEVER_HAPPENS_EXCEPTION;
        }
    }
}
