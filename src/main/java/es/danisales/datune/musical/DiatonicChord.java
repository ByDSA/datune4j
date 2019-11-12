package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiFunction;

public class DiatonicChord implements DiatonicChordCommon<Diatonic>, ChordMutableInterface<Diatonic> {
    public static final DiatonicChord TRIAD = new DiatonicChord( DiatonicChordEnum.TRIAD );
    public static final DiatonicChord THIRD = new DiatonicChord( DiatonicChordEnum.THIRD );
    public static final DiatonicChord SUS2 = new DiatonicChord( DiatonicChordEnum.SUS2 );
    public static final DiatonicChord SUS2_O5 = new DiatonicChord( DiatonicChordEnum.SUS2_O5 );
    public static final DiatonicChord SUS4 = new DiatonicChord( DiatonicChordEnum.SUS4 );
    public static final DiatonicChord SUS4_O5 = new DiatonicChord( DiatonicChordEnum.SUS4_O5 );
    public static final DiatonicChord SIXTH = new DiatonicChord( DiatonicChordEnum.SIXTH );
    public static final DiatonicChord SIXTH_O5 = new DiatonicChord( DiatonicChordEnum.SIXTH_O5 );
    public static final DiatonicChord SEVENTH = new DiatonicChord( DiatonicChordEnum.SEVENTH );
    public static final DiatonicChord SEVENTH_O3 = new DiatonicChord( DiatonicChordEnum.SEVENTH_O3 );
    public static final DiatonicChord SEVENTH_O5 = new DiatonicChord( DiatonicChordEnum.SEVENTH_O5 );
    public static final DiatonicChord NINTH = new DiatonicChord( DiatonicChordEnum.NINTH );
    public static final DiatonicChord NINTH_O7 = new DiatonicChord( DiatonicChordEnum.NINTH_O7 );
    public static final DiatonicChord NINTH_O3_O7 = new DiatonicChord( DiatonicChordEnum.NINTH_O3_O7 );
    public static final DiatonicChord ELEVENTH = new DiatonicChord( DiatonicChordEnum.ELEVENTH );
    public static final DiatonicChord THIRTEENTH = new DiatonicChord( DiatonicChordEnum.THIRTEENTH );


    public static DiatonicChord[] values() {
        return new DiatonicChord[]{
                TRIAD,
                THIRD,
                SUS2,
                SUS2_O5,
                SUS4,
                SUS4_O5,
                SIXTH,
                SIXTH_O5,
                SEVENTH,
                SEVENTH_O3,
                SEVENTH_O5,
                NINTH,
                NINTH_O7,
                NINTH_O3_O7,
                ELEVENTH,
                THIRTEENTH
        };
    }

    public static @NonNull DiatonicChord from(@NonNull Collection<Diatonic> diatonicChord) {
        DiatonicChord ret = new DiatonicChord();
        ret.innerObject = DiatonicChordAdapter.from(diatonicChord);
        return ret;
    }

    public static @NonNull DiatonicChord from(@NonNull DiatonicFunction f) {
        DiatonicChord ret = new DiatonicChord();
        ret.innerObject = DiatonicChordAdapter.from(f);
        return ret;
    }
    DiatonicChordInterface innerObject;

    private boolean fixed;

    private DiatonicChord() {
        fixed = false;
    }

    private DiatonicChord(DiatonicChordInterface scaleInterface) {
        innerObject = scaleInterface;
        fixed = true;
    }

    @Override
    public DiatonicChordInterface getShifted(IntervalDiatonic i) {
        return innerObject.getShifted(i);
    }

    @Override
    public void inv(int n) {
        exceptionIfFixed();

        if (innerObject instanceof DiatonicChordEnum)
            turnInnerIntoCustom();

        if (innerObject instanceof CustomDiatonicChord) {
            ((CustomDiatonicChord) innerObject).inv(n);
            if (getRootPos() == 0)
                turnIntoEnumIfPossible();
        }
    }

    private void turnIntoEnumIfPossible() {
        DiatonicChordEnum diatonicChordEnum = DiatonicChordEnum.from(innerObject);
        if (diatonicChordEnum != null)
            innerObject = diatonicChordEnum;
    }

    @Override
    public List<DiatonicChord> getAllInversions() {
        return innerObject.getAllInversions();
    }

    @Override
    public int getRootPos() {
        return innerObject.getRootPos();
    }

    @Nullable
    @Override
    public Diatonic getRoot() {
        return innerObject.getRoot();
    }

    @Override
    public DiatonicChord duplicate() {
        DiatonicChord ret = new DiatonicChord();
        ret.innerObject = innerObject.duplicate();
        turnIntoEnumIfPossible();
        return ret;
    }

    private void exceptionIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    @Override
    public void setRootPos(int pos) {
       exceptionIfFixed();

        if (getRootPos() == pos)
            return;

        if (innerObject instanceof CustomDiatonicChord)
            ((CustomDiatonicChord)innerObject).setRootPos(pos);
        else if (pos != 0) {
            turnInnerIntoCustom();
            ((CustomDiatonicChord)innerObject).setRootPos(pos);
        }

        turnIntoEnumIfPossible();
    }

    private void turnInnerIntoCustom() {
        innerObject = CustomDiatonicChord.from(innerObject);
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
    public DiatonicDegree getDegree() {
        return innerObject.getDegree();
    }

    @Override
    public int size() {
        return innerObject.size();
    }

    @Override
    public boolean isEmpty() {
        return innerObject.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return innerObject.contains(o);
    }

    @Override
    @NonNull
    public Iterator<Diatonic> iterator() {
        return innerObject.iterator();
    }

    @Override
    public @NonNull Object[] toArray() {
        return innerObject.toArray();
    }

    @Override
    public @NonNull<T> T[] toArray(@NonNull T[] a) {
        return innerObject.toArray(a);
    }

    @Override
    public boolean add(Diatonic diatonic) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerObject.add(diatonic);
        turnIntoEnumIfPossible();

        return ret;
    }

    private void turnIntoCustomIfNot() {
        if ( !(innerObject instanceof CustomDiatonicChord) )
            turnInnerIntoCustom();
    }

    @Override
    public boolean remove(Object o) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerObject.remove(o);
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> c) {
        return innerObject.containsAll(c);
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends Diatonic> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerObject.addAll(c);
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public boolean addAll(int index, @NonNull Collection<? extends Diatonic> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerObject.addAll(index, c);
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerObject.removeAll(c);
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> c) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        boolean ret = innerObject.removeAll(c);
        turnIntoEnumIfPossible();

        return ret;
    }

    @Override
    public void clear() {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        innerObject.clear();
    }

    @Override
    public Diatonic get(int index) {
        return innerObject.get(index);
    }

    @Override
    public void resetRoot() {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        ChordMutableInterface.super.resetRoot();
        turnIntoEnumIfPossible();
    }

    @Override
    public Diatonic set(int index, Diatonic element) {
        exceptionIfFixed();

        if (get(index) == element)
            return element;

        turnIntoCustomIfNot();

        Diatonic old = null;
        if (innerObject instanceof CustomDiatonicChord)
            old = innerObject.set(index, element);

        turnIntoEnumIfPossible();

        return old;
    }

    @Override
    public void add(int index, Diatonic element) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        innerObject.add(index, element);
        turnIntoEnumIfPossible();
    }

    @Override
    public Diatonic remove(int index) {
        exceptionIfFixed();
        turnIntoCustomIfNot();
        Diatonic ret = innerObject.remove(index);
        turnIntoEnumIfPossible();
        return ret;
    }

    @Override
    public int indexOf(Object o) {
        return innerObject.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return innerObject.lastIndexOf(o);
    }

    @Override
    @NonNull
    public ListIterator<Diatonic> listIterator() {
        return innerObject.listIterator();
    }

    @Override
    @NonNull
    public ListIterator<Diatonic> listIterator(int index) {
        return innerObject.listIterator(index);
    }

    @Override
    @NonNull
    public List<Diatonic> subList(int fromIndex, int toIndex) {
        return innerObject.subList(fromIndex, toIndex);
    }

    @Override
    public String toString() {
        return innerObject.toString();
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof DiatonicChord) )
            return false;
        DiatonicChord other = (DiatonicChord)o;
        return DiatonicChordAdapter.equals(innerObject, other.innerObject);
    }

    @Override
    public int hashCode() {
        return innerObject._hashCode();
    }
}
