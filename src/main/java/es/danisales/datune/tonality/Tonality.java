package es.danisales.datune.tonality;

import com.google.common.collect.ImmutableSet;
import es.danisales.datune.chords.Chord;
import es.danisales.datune.chords.ChordTransformations;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.timelayer.MainTonalFunction;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class Tonality<C extends CyclicDegree> implements Iterable<C> {
    TonalityInner<C> innerTonality;
    private final boolean immutable;

    private final TonalityCache tonalityCache = new TonalityCache(this);

    /** Building **/

    protected Tonality(TonalityInner<C> tonalityInterface) {
        this(tonalityInterface, true);
    }

    protected Tonality(TonalityInner<C> tonalityInterface, boolean immutable) {
        innerTonality = tonalityInterface;
        this.immutable = immutable;
    }

    public static @NonNull TonalityClassical from(@NonNull DiatonicAlt cyclicDegree, @NonNull Scale scale) {
        TonalityInner<DiatonicAlt> tonalityInterface = TonalityInnerImmutable.from(cyclicDegree, scale);
        if (tonalityInterface == null)
            tonalityInterface = new TonalityInnerMutable<>(cyclicDegree, scale);

        return new TonalityClassical(tonalityInterface, false);
    }

    public static @NonNull TonalityModern from(@NonNull Chromatic chromatic, @NonNull Scale scale) {
        TonalityInner<Chromatic> tonalityInterface = new TonalityInnerMutable<>(chromatic, scale);

        return new TonalityModern(tonalityInterface, false);
    }

    /** Notes **/

    public int size() {
        return getScale().size();
    }

    public @NonNull C getNote(@NonNull ScaleDegree scaleDegree) throws ScaleRelativeDegreeException {
        List<ScaleDegree> mainDegrees = ScaleDegree.getDefaultDegreesFromScaleSize(getScale().size());
        ScaleDegree firstMainDegree = mainDegrees.get(0);
        Class<? extends ScaleDegree> degreeClass = scaleDegree.getClass();
        Class<? extends ScaleDegree> firstMainDegreeClass = firstMainDegree.getClass();
        if (degreeClass.equals(firstMainDegreeClass))
            return getNotes().get(scaleDegree.ordinal());

        int indexInteger = getScale().getIndexByDegree(scaleDegree);
        return getNotes().get(indexInteger);
    }

    @SuppressWarnings("WeakerAccess")
    public boolean isModeOf(Tonality<C> t) {
        return this.getRoot().equals(t.getRoot()) && !getScale().equals(t.getScale());
    }

    public abstract @NonNull List<? extends Tonality<C>> getParallelModes();

    public @Nullable ScaleDegree getDegreeFrom(@NonNull C c) {
        Objects.requireNonNull(c, "No se ha especificado nota");

        for (ScaleDegree degree : getScaleMainDegrees()) {
            C c1 = getNoteSecure(degree);
            if (c1.equals(c))
                return degree;
        }

        return null;
    }

    private C getNoteSecure(ScaleDegree degree) {
        try {
            return getNote(degree);
        } catch (ScaleRelativeDegreeException e) {
            throw NeverHappensException.make("Siempre tiene los MainDegree");
        }
    }

    private List<ScaleDegree> getScaleMainDegrees() {
        return ScaleDegree.getDefaultDegreesFromScaleSize(getNotes().size());
    }

    private void excepIfFixed() {
        if (immutable)
            throw new UnsupportedOperationException();
    }

    public void setRoot(@NonNull C root) {
        excepIfFixed();

        if (!getRoot().equals(root))
            tonalityCache.clear();

        if (innerIsImmutable())
            turnInnerIntoMutable();
        ((TonalityInnerMutable) innerTonality).setRoot(root);

        turnIntoImmutableIfPossible();
    }

    public void setScale(@NonNull Scale scale) {
        excepIfFixed();

        if (!getScale().equals(scale))
            tonalityCache.clear();

        if (innerIsImmutable())
            turnInnerIntoMutable();
        ((TonalityInnerMutable) innerTonality).setScale(scale);

        turnIntoImmutableIfPossible();
    }

    private void turnIntoImmutableIfPossible() {
        if (getRoot() instanceof DiatonicAlt) {
            TonalityInnerImmutable tonalityInnerImmutable = TonalityInnerImmutable.from(getRoot(), getScale());
            if (tonalityInnerImmutable != null)
                innerTonality = (TonalityInner<C>)tonalityInnerImmutable;
        }
    }

    private boolean innerIsImmutable() {
        return innerTonality instanceof TonalityInnerImmutable;
    }

    private void turnInnerIntoMutable() {
        innerTonality = new TonalityInnerMutable<>(innerTonality.getRoot(), innerTonality.getScale());
    }

    public boolean containsAll(C note) {
        return getDegreeFrom( note ) != null;
    }

    public @NonNull Scale getScale() {
        return innerTonality.getScale();
    }

    public @NonNull C getRoot() {
        return innerTonality.getRoot();
    }

    public @NonNull List<C> getNotes() {
        return innerTonality.getNotes();
    }

    public MainTonalFunction getMainFunctionFrom(Chord<C> chord) {
        Chord<C> rootChord = getRootChord();

        Chromatic chromaticIII = (Chromatic)rootChord.get(1);
        Chromatic chromaticIV = (Chromatic)getRoot().getShifted(5);
        Chromatic chromaticV = (Chromatic)getRoot().getShifted(7);

        boolean hasIV = chord.contains(chromaticIV);
        boolean hasV = chord.contains(chromaticV);
        boolean hasI = chord.contains(getRoot());
        boolean hasIII = chord.contains(chromaticIII);

        List<Integer> allIntervalsTransitionIII = ChordTransformations.getAllIntervalsWithNote((ChromaticChord)chord, chromaticIII);
        List<Integer> allIntervalsTransitionI = ChordTransformations.getAllIntervalsWithNote((ChromaticChord)chord, (Chromatic)getRoot());

        if (!chord.contains(getRoot()) && !chord.contains(chromaticIII)) {
            for (int dist : allIntervalsTransitionIII) {
                if (dist == 6)
                    return MainTonalFunction.DOMINANT;
            }

            for (int dist : allIntervalsTransitionI) {
                if (dist == 1)
                    return MainTonalFunction.DOMINANT;
            }

            for (IntervalChromatic dist : ChordTransformations.getIntraIntervals((ChromaticChord)chord)) {
                if (dist.getSemitones() == 6)
                    return MainTonalFunction.DOMINANT;
            }
        }

        for (int dist : allIntervalsTransitionIII) {
            if (dist == 1)
                return MainTonalFunction.SUBDOMINANT;
        }

        for (int dist : allIntervalsTransitionI) {
            if (dist == 6)
                return MainTonalFunction.SUBDOMINANT;
        }

        for (IntervalChromatic dist : ChordTransformations.getIntraIntervals((ChromaticChord)chord)) {
            if (dist.getSemitones() == 2)
                return MainTonalFunction.SUBDOMINANT;
        }

        if (hasV && !hasI && !hasIII)
            return MainTonalFunction.DOMINANT;
        else if (hasIV)
            return MainTonalFunction.SUBDOMINANT;
        else
            return MainTonalFunction.TONIC;
    }

    @SuppressWarnings("WeakerAccess")
    public MainTonalFunction getMainFunctionFrom(@NonNull HarmonicFunction harmonicFunction) {
        Chord<C> chord = (Chord<C>)harmonicFunction.getChord((TonalityModern) this);
        if (chord == null)
            return null;

        return getMainFunctionFrom(chord);
    }

    private @NonNull Chord<C> getRootChord() {
        C root = getRoot();
        C note2 = null;
        C note3 = null;
        C note4 = null;
        try {
            note2 = getNote(DiatonicDegree.III);
            note3 = getNote(DiatonicDegree.V);
            note4 = getNote(DiatonicDegree.VII);
        } catch (ScaleRelativeDegreeException e) {
            e.printStackTrace();
        }

        Chord<C> chord;
        if (root instanceof Chromatic) {
            //noinspection unchecked
            chord = (Chord<C>) ChromaticChord.builder()
                    .build();

            chord.add(root);
            chord.add(note2);
            chord.add(note3);
            chord.add(note4);
            return chord;
        } else if (root instanceof DiatonicAlt) {
            return null;
        }

        throw new RuntimeException();
    }

    /** Functions **/

    public @NonNull Set<HarmonicFunction> getFunctionsFrom(@NonNull ChromaticChord chromaticChord) {
        chromaticChord = removeInversionAsClonedChordIfNeeded(chromaticChord);
        Set<? extends HarmonicFunction> diatonicFunctionList = tonalityCache.getFunctions(chromaticChord);

        return ImmutableSet.copyOf(diatonicFunctionList);
    }

    private ChromaticChord removeInversionAsClonedChordIfNeeded(@NonNull ChromaticChord chromaticChord) {
        if (chromaticChord.getInversionNumber() != 0) {
            chromaticChord = chromaticChord.clone();
            chromaticChord.toFundamental();
        }

        return chromaticChord;
    }

    public @Nullable ChromaticChord getChord(@NonNull HarmonicFunction harmonicFunction) {
        return tonalityCache.getChord(harmonicFunction);
    }

    public Set<? extends HarmonicFunction> getFunctions() {
        return tonalityCache.getFunctions();
    }

    int getMaxAltsNote() {
        if (getRoot() instanceof DiatonicAlt) {
            float max = Float.MIN_VALUE;
            for (DiatonicAlt diatonicAlt : (TonalityClassical)this) {
                float uAlts = diatonicAlt.getUnsignedAlterations();
                if (uAlts > max)
                    max = uAlts;
            }
            return (int)max;
        } else
            return -1;
    }

    public boolean containsAll(Iterable<C> chord) {
        for (C cyclicDegree : chord)
            if (!containsAll(cyclicDegree))
                return false;

        return true;
    }

    @Override
    @NonNull
    public Iterator<C> iterator() {
        return innerTonality.getNotes().iterator();
    }

    /* Object */

    @Override
    public String toString() {
        return getRoot() + " " + getScale();
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof Tonality))
            return false;

        Tonality otherCasted = (Tonality) o;

        return getRoot().equals(otherCasted.getRoot()) && getScale().equals(otherCasted.getScale());
    }

    @Override
    public int hashCode() {
        return getRoot().hashCode() + 31*getScale().hashCode();
    }
}
