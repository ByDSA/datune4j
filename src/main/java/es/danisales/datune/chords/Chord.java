package es.danisales.datune.chords;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.degrees.CyclicDegree;
import es.danisales.datune.lang.ChordNotation;
import es.danisales.utils.MathUtils;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

public class Chord<C extends CyclicDegree>
        extends ListProxy<C>
        implements ChordCommon<C>, List<C> {
    private int rootIndex = -1;

    public int getRootIndex() {
        return rootIndex;
    }

    public @Nullable C getRoot() {
        return get(rootIndex);
    }

    public @NonNull C getCyclic(int noteNumber) {
        noteNumber = MathUtils.rotativeTrim(noteNumber, size());

        return get(noteNumber);
    }

    public int getInversionNumber() {
        int rootPos = getRootIndex();
        if (rootPos > 0)
            return size() - rootPos;
        else
            return 0;
    }

    public void resetRoot() {
        if ( isEmpty() )
            return;

        setRootIndex(0);
    }

    public void setRootIndex(int pos) {
        checkArgument(pos >= 0 && pos < size());
        rootIndex = pos;
    }

    public void toFundamental() {
        inv( getRootIndex() );
        checkState(getRootIndex() == 0, getRootIndex());
    }

    public void over(@NonNull C cyclicDegree) throws InvalidChordException {
        for (int i = 0; i < size(); i++) {
            if ( get(0).equals(cyclicDegree) )
                return;
            inv();
        }

        throw new InvalidChordException();
    }

    public void inv() {
        inv( 1 );
    }

    public void inv(int n) {
        if ( n == 0 )
            return;
        Collections.rotate(this, -n);
        int rootIndex = MathUtils.rotativeTrim(getRootIndex() - n, size());
        setRootIndex(rootIndex);
    }

    private static final NeverHappensException NEVER_HAPPENS_EXCEPTION
            = NeverHappensException.make("Los ChordProxy son siempre de Chromatic o Diatonic y no tienen problemas de octava mínima o máxima");

    private boolean fixed;

    Chord() {
        super( new ArrayList<>() );
        fixed = false;
    }

    Chord(ChordCommon<C> chordCommon) {
        super( chordCommon );
        fixed = true;
    }

    @Override
    public final String toString() {
        if ( isEmpty() )
            return ChordNotation.EMPTY_CHORD;

        if (getRootIndex() != 0) {
            Chord<C> normalChordCommon = clone();
            normalChordCommon.toFundamental();
            return normalChordCommon.toString() + "/" + get(0).toString();
        }
        return ChordNamer.from(this);
    }

    public Chord<C> clone() {
        Chord<C> chord = new Chord<>();
        chord.addAll(this);
        chord.setRootIndex( getRootIndex() );

        return chord;
    }

    @Override
    public final int hashCode() {
        if (isEmpty())
            return 0;

        return 31 * rootIndex + super.hashCode();
    }
}
