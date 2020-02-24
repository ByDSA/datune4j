package es.danisales.datune.chords;

import com.google.common.collect.ImmutableList;
import es.danisales.datastructures.ListProxy;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.lang.ChordNotation;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Collections;

import static com.google.common.base.Preconditions.checkState;

public class Chord<C extends CyclicDegree>
        extends ListProxy<C>
        implements ChordCommon<C> {
    private int rootIndex = 0;
    private final boolean immutable;

    protected Chord() {
        super( new ArrayList<>() );
        immutable = false;
    }

    protected Chord(ChordCommon<C> chordCommon) {
        super( ImmutableList.copyOf(chordCommon) );
        rootIndex = chordCommon.getRootIndex();
        immutable = true;
    }

    protected Chord<C> create() {
        return new Chord<>();
    }

    public @NonNull C getCyclic(int noteNumber) {
        noteNumber = MathUtils.rotativeTrim(noteNumber, size());

        return get(noteNumber);
    }

    /* Root */

    public int getRootIndex() {
        return rootIndex;
    }

    public @Nullable C getRoot() {
        return get(rootIndex);
    }

    public void resetRoot() {
        exceptionIfImmutable();
        if ( isEmpty() )
            return;

        setRootIndex(0);
    }

    public void setRootIndex(int pos) {
        exceptionIfImmutable();
        if (pos < 0 || pos >= size())
            throw new ArrayIndexOutOfBoundsException(pos);
        rootIndex = pos;
    }

    /* Inversion*/

    public void inv() {
        inv( 1 );
    }

    public void inv(int n) {
        exceptionIfImmutable();
        if ( n == 0 )
            return;
        Collections.rotate(this, -n);
        int rootIndex = MathUtils.rotativeTrim(getRootIndex() - n, size());
        setRootIndex(rootIndex);
    }

    public int getInversionNumber() {
        int rootPos = getRootIndex();
        if (rootPos > 0)
            return size() - rootPos;
        else
            return 0;
    }

    public void over(@NonNull C cyclicDegree) throws ChordCreationException {
        exceptionIfImmutable();
        for (int i = 0; i < size(); i++) {
            if ( get(0).equals(cyclicDegree) )
                return;
            inv();
        }

        throw new ChordCreationException();
    }

    public void toFundamental() {
        exceptionIfImmutable();
        inv( getRootIndex() );
        checkState(getRootIndex() == 0, getRootIndex());
    }

    /* Immutable */

    public boolean isImmutable() {
        return immutable;
    }

    private void exceptionIfImmutable() {
        if (isImmutable())
            throw new UnsupportedOperationException();
    }

    /* Object */

    @Override
    public String toString() {
        if ( isEmpty() )
            return ChordNotation.EMPTY_CHORD;

        if (getRootIndex() != 0) {
            Chord<C> normalChordCommon = clone();
            normalChordCommon.toFundamental();
            return normalChordCommon.toString() + "/" + get(0).toString();
        }
        return autoname(this);
    }

    private static <N extends CyclicDegree> String autoname(Chord<N> chord) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (N n : chord) {
            if (first) {
                first = false;
            } else
                sb.append(", ");
            sb.append(n);
        }

        sb.append(" | rootAny = ");
        sb.append(chord.getRoot());
        sb.append("(");
        sb.append(chord.getRootIndex());
        sb.append(")");

        return sb.toString();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Chord<C> clone() {
        if ( isEmpty() )
            return create();
        Chord<C> chord = create();
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

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof Chord) )
            return false;

        Chord chord = (Chord)o;
        boolean superEquals = super.equals(chord);
        boolean rootEquals = rootIndex == chord.rootIndex;

        return superEquals && rootEquals;
    }
}
