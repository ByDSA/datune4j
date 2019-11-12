package es.danisales.datune.musical;

import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiFunction;

public class ChromaticChord implements ChordCommon<Chromatic>, ChordMutableInterface<Chromatic> {
    ChromaticChordInterface innerChord;
    private boolean fixed;

    private ChromaticChord() {
        fixed = false;
    }

    private ChromaticChord(ChromaticChordInterface chromaticChordInterface) {
        fixed = true;
        innerChord = chromaticChordInterface;
    }

    private void turnIntoEnumIfPossible() {
        ChromaticChordEnum diatonicChordEnum = ChromaticChordEnum.from(innerChord);
        if (diatonicChordEnum != null)
            innerChord = diatonicChordEnum;
    }

    private void exceptionIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    private void turnInnerIntoCustom() {
        innerChord = CustomChromaticChord.from(innerChord);
    }

    @Override
    public int getRootPos() {
        return innerChord.getRootPos();
    }

    @Nullable
    @Override
    public Chromatic getRoot() {
        return innerChord.getRoot();
    }

    @Override
    public ChromaticChord duplicate() {
        ChromaticChord chromaticChord = new ChromaticChord();
        chromaticChord.innerChord = innerChord.duplicate();
        chromaticChord.turnIntoEnumIfPossible();
        return chromaticChord;
    }

    @Override
    public void setRootPos(int pos) {

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
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Chromatic> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Chromatic chromatic) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Chromatic> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Chromatic> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Chromatic get(int index) {
        return null;
    }

    @Override
    public Chromatic set(int index, Chromatic element) {
        return null;
    }

    @Override
    public void add(int index, Chromatic element) {

    }

    @Override
    public Chromatic remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Chromatic> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Chromatic> listIterator(int index) {
        return null;
    }

    @Override
    public List<Chromatic> subList(int fromIndex, int toIndex) {
        return null;
    }
}
