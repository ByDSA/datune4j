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

import java.util.*;

import static com.google.common.base.Preconditions.checkState;

public class Tonality<C extends CyclicDegree> implements Iterable<C> {
    public static final Tonality<Chromatic> C = Tonality.from(Chromatic.C, Scale.MAJOR);
    public static final Tonality<Chromatic> CC = Tonality.from(Chromatic.CC, Scale.MAJOR);
    public static final Tonality<Chromatic> D = Tonality.from(Chromatic.D, Scale.MAJOR);
    public static final Tonality<Chromatic> DD = Tonality.from(Chromatic.DD, Scale.MAJOR);
    public static final Tonality<Chromatic> E = Tonality.from(Chromatic.E, Scale.MAJOR);
    public static final Tonality<Chromatic> F = Tonality.from(Chromatic.F, Scale.MAJOR);
    public static final Tonality<Chromatic> FF = Tonality.from(Chromatic.FF, Scale.MAJOR);
    public static final Tonality<Chromatic> G = Tonality.from(Chromatic.G, Scale.MAJOR);
    public static final Tonality<Chromatic> GG = Tonality.from(Chromatic.GG, Scale.MAJOR);
    public static final Tonality<Chromatic> A = Tonality.from(Chromatic.A, Scale.MAJOR);
    public static final Tonality<Chromatic> AA = Tonality.from(Chromatic.AA, Scale.MAJOR);
    public static final Tonality<Chromatic> B = Tonality.from(Chromatic.B, Scale.MAJOR);

    public static final Tonality<Chromatic> Cm = Tonality.from(Chromatic.C, Scale.MINOR);
    public static final Tonality<Chromatic> CCm = Tonality.from(Chromatic.CC, Scale.MINOR);
    public static final Tonality<Chromatic> Dm = Tonality.from(Chromatic.D, Scale.MINOR);
    public static final Tonality<Chromatic> DDm = Tonality.from(Chromatic.DD, Scale.MINOR);
    public static final Tonality<Chromatic> Em = Tonality.from(Chromatic.E, Scale.MINOR);
    public static final Tonality<Chromatic> Fm = Tonality.from(Chromatic.F, Scale.MINOR);
    public static final Tonality<Chromatic> FFm = Tonality.from(Chromatic.FF, Scale.MINOR);
    public static final Tonality<Chromatic> Gm = Tonality.from(Chromatic.G, Scale.MINOR);
    public static final Tonality<Chromatic> GGm = Tonality.from(Chromatic.GG, Scale.MINOR);
    public static final Tonality<Chromatic> Am = Tonality.from(Chromatic.A, Scale.MINOR);
    public static final Tonality<Chromatic> AAm = Tonality.from(Chromatic.AA, Scale.MINOR);
    public static final Tonality<Chromatic> Bm = Tonality.from(Chromatic.B, Scale.MINOR);

    public static class Classical {
        private Classical() {
        }

        public static final Tonality<DiatonicAlt> C = new Tonality<>(TonalityInnerImmutable.C);
        @SuppressWarnings("WeakerAccess")
        public static final Tonality<DiatonicAlt> Db = new Tonality<>(TonalityInnerImmutable.Db);
        public static final Tonality<DiatonicAlt> D = new Tonality<>(TonalityInnerImmutable.D);
        public static final Tonality<DiatonicAlt> Eb = new Tonality<>(TonalityInnerImmutable.Eb);
        public static final Tonality<DiatonicAlt> E = new Tonality<>(TonalityInnerImmutable.E);
        public static final Tonality<DiatonicAlt> F = new Tonality<>(TonalityInnerImmutable.F);
        public static final Tonality<DiatonicAlt> FF = new Tonality<>(TonalityInnerImmutable.FF);
        @SuppressWarnings("WeakerAccess")
        public static final Tonality<DiatonicAlt> Gb = new Tonality<>(TonalityInnerImmutable.Gb);
        public static final Tonality<DiatonicAlt> G = new Tonality<>(TonalityInnerImmutable.G);
        @SuppressWarnings("WeakerAccess")
        public static final Tonality<DiatonicAlt> Ab = new Tonality<>(TonalityInnerImmutable.Ab);
        public static final Tonality<DiatonicAlt> A = new Tonality<>(TonalityInnerImmutable.A);
        public static final Tonality<DiatonicAlt> Bb = new Tonality<>(TonalityInnerImmutable.Bb);
        public static final Tonality<DiatonicAlt> B = new Tonality<>(TonalityInnerImmutable.B);

        public static final Tonality<DiatonicAlt> Cm = new Tonality<>(TonalityInnerImmutable.Cm);
        public static final Tonality<DiatonicAlt> CCm = new Tonality<>(TonalityInnerImmutable.CCm);
        public static final Tonality<DiatonicAlt> Dm = new Tonality<>(TonalityInnerImmutable.Dm);
        @SuppressWarnings("WeakerAccess")
        public static final Tonality<DiatonicAlt> DDm = new Tonality<>(TonalityInnerImmutable.DDm);
        public static final Tonality<DiatonicAlt> Ebm = new Tonality<>(TonalityInnerImmutable.Ebm);
        public static final Tonality<DiatonicAlt> Em = new Tonality<>(TonalityInnerImmutable.Em);
        public static final Tonality<DiatonicAlt> Fm = new Tonality<>(TonalityInnerImmutable.Fm);
        public static final Tonality<DiatonicAlt> FFm = new Tonality<>(TonalityInnerImmutable.FFm);
        public static final Tonality<DiatonicAlt> Gm = new Tonality<>(TonalityInnerImmutable.Gm);
        public static final Tonality<DiatonicAlt> GGm = new Tonality<>(TonalityInnerImmutable.GGm);
        public static final Tonality<DiatonicAlt> Am = new Tonality<>(TonalityInnerImmutable.Am);
        public static final Tonality<DiatonicAlt> Bbm = new Tonality<>(TonalityInnerImmutable.Bbm);
        public static final Tonality<DiatonicAlt> Bm = new Tonality<>(TonalityInnerImmutable.Bm);

    }

    /**
     * END CONSTANT TONALITIES
     ******************************************************************************/

    TonalityInner<C> innerTonality;
    private final boolean immutable;

    private final TonalityCache tonalityCache = new TonalityCache(this);

    /** Building **/

    private Tonality(TonalityInner<C> tonalityInterface) {
        this(tonalityInterface, true);
    }

    private Tonality(TonalityInner<C> tonalityInterface, boolean immutable) {
        innerTonality = tonalityInterface;
        this.immutable = immutable;
    }

    public static <C extends CyclicDegree> @NonNull Tonality<C> from(@NonNull C cyclicDegree, @NonNull Scale scale) {
        TonalityInner<C> tonalityInterface = (TonalityInner<C>)TonalityInnerImmutable.from(cyclicDegree, scale);
        if (tonalityInterface == null)
            tonalityInterface = new TonalityInnerMutable<>(cyclicDegree, scale);

        return new Tonality<C>(tonalityInterface, false);
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

    @SuppressWarnings("WeakerAccess")
    public @NonNull List<Tonality> getModes() {
        List<Tonality> ret = new ArrayList<>();

        for ( Scale scale : getScale().getModes() ) {
            Tonality tonality = Tonality.from(getRoot(), scale);
            ret.add(tonality);
        }

        return ret;
    }

    int getDiatonicAlterationsNumber() {
        Objects.requireNonNull(getNotes());
        checkState(getNotes().get(0) instanceof DiatonicAlt);

        int ret = 0;
        for ( DiatonicAlt c : (List<DiatonicAlt>)getNotes() )
            ret += c.getUnsignedAlterations();

        return ret;
    }

    public List<Tonality<C>> getParallelModes() {
        List<Tonality<C>> ret = new ArrayList<>();

        for ( Scale scale : getScale().getModes() )
            for ( C c : (List<C>)values(getNotes().get(0).getClass()) ) {
                Tonality<C> t = Tonality.from( c, scale );
                ret.add(t);
            }

        return ret;
    }

    private static <C extends CyclicDegree> List<C> values(Class<C> cClass) {
        if (cClass.equals(Chromatic.class))
            return (List<C>) Arrays.asList( Chromatic.values() );
        else
            throw new RuntimeException();
    }

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
        innerTonality = new TonalityInnerMutable(innerTonality.getRoot(), innerTonality.getScale());
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

    public MainTonalFunction getMainFunctionFrom(HarmonicFunction harmonicFunction) {
        Chord<C> chord = null;
        try {
            chord = (Chord<C>)harmonicFunction.getChromaticChordFromTonality((Tonality<Chromatic>)this);
        } catch (ScaleRelativeDegreeException e) {
            return null;
        }
        return getMainFunctionFrom(chord);
    }

    private Chord<C> getRootChord() {
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

        Chord<C> chord = null;
        if (root instanceof Chromatic) {
            chord = (Chord<C>) ChromaticChord.builder()
                    .build();

            chord.add(root);
            chord.add(note2);
            chord.add(note3);
            chord.add(note4);
        } else if (root instanceof DiatonicAlt) {
            return null;
        }

        return chord;
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

    int getMaxAltsNote() {
        if (getRoot() instanceof DiatonicAlt) {
            float max = Float.MIN_VALUE;
            for (DiatonicAlt diatonicAlt : (Tonality<DiatonicAlt>)this) {
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

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Tonality<C> clone() {
        return from(getRoot(), getScale());
    }
}
