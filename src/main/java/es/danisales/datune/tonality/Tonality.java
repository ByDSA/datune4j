package es.danisales.datune.tonality;

import es.danisales.datune.chords.Chord;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

import static com.google.common.base.Preconditions.checkState;

public class Tonality<C extends CyclicDegree> implements Iterable<C> {
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
    public static final Tonality<DiatonicAlt> DDm = new Tonality<>(TonalityInnerImmutable.DDm);
    @SuppressWarnings("WeakerAccess")
    public static final Tonality<DiatonicAlt> Ebm = new Tonality<>(TonalityInnerImmutable.Ebm);
    public static final Tonality<DiatonicAlt> Em = new Tonality<>(TonalityInnerImmutable.Em);
    public static final Tonality<DiatonicAlt> Fm = new Tonality<>(TonalityInnerImmutable.Fm);
    public static final Tonality<DiatonicAlt> FFm = new Tonality<>(TonalityInnerImmutable.FFm);
    public static final Tonality<DiatonicAlt> Gm = new Tonality<>(TonalityInnerImmutable.Gm);
    public static final Tonality<DiatonicAlt> GGm = new Tonality<>(TonalityInnerImmutable.GGm);
    public static final Tonality<DiatonicAlt> Am = new Tonality<>(TonalityInnerImmutable.Am);
    public static final Tonality<DiatonicAlt> Bbm = new Tonality<>(TonalityInnerImmutable.Bbm);
    public static final Tonality<DiatonicAlt> Bm = new Tonality<>(TonalityInnerImmutable.Bm);

    public static class ET12 {
        private ET12() {
        }

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

    }

    /**
     * END CONSTANT TONALITIES
     ******************************************************************************/

    TonalityInner<C> innerTonality;
    private final boolean fixed;

    private Map<ChromaticChord, List<ChromaticFunction>> cacheChromaticMap;
    private Map<ChromaticChord, List<DiatonicFunction>> cacheDiatonicMap;

    /**
     * Building
     **/

    private Tonality(TonalityInner<C> tonalityInterface) {
        this(tonalityInterface, true);
    }

    private Tonality(TonalityInner<C> tonalityInterface, boolean fixed) {
        innerTonality = tonalityInterface;
        this.fixed = fixed;
    }

    public static <C extends CyclicDegree> @NonNull Tonality<C> from(@NonNull C cyclicDegree, @NonNull Scale scale) {
        TonalityInner tonalityInterface = TonalityInnerImmutable.from(cyclicDegree, scale);
        if (tonalityInterface == null)
            tonalityInterface = new TonalityInnerMutable(cyclicDegree, scale);

        return new Tonality(tonalityInterface, false);
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

    public boolean isModeOf(Tonality t) {
        return this.getRoot() == t.getRoot() && !getScale().equals(t.getScale());
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

    public List<Tonality<C>> getModesSameRoot() {
        List<Tonality<C>> ret = new ArrayList<>();

        for ( Scale scale : getScale().getModes() )
            for ( C c : (List<C>)values(getNotes().get(0).getClass()) ) {
                Tonality<C> t = Tonality.from( c, scale );
               /* if (t.innerTonality instanceof TonalityInnerMutable)
                    t = TonalityRetrieval.getEnharmonicMinimalAltsFrom(t).iterator().next();*/
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
            throw NeverHappensException.make("Siempre tiene los MainDegreea");
        }
    }

    private List<ScaleDegree> getScaleMainDegrees() {
        return ScaleDegree.getDefaultDegreesFromScaleSize(getNotes().size());
    }

    private void excepIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    public void setRoot(@NonNull C root) {
        excepIfFixed();

        if (!getRoot().equals(root))
            clearCaches();

        if (innerIsImmutable())
            turnInnerIntoMutable();
        ((TonalityInnerMutable) innerTonality).setRoot(root);

        turnIntoImmutableIfPossible();
    }

    public void setScale(@NonNull Scale scale) {
        excepIfFixed();

        if (!getScale().equals(scale))
            clearCaches();

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

    public @NonNull Tonality<C> getRelativeScaleDiatonic(ScaleDegree relativeDegree) throws ScaleRelativeDegreeException { // todo: sólo function
        C diatonicAlt = getNote(relativeDegree);

        return Tonality.from(diatonicAlt, getScale());
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

    /** Functions **/

    public @Nullable HarmonicFunction getFunctionFrom(@NonNull ChromaticChord chromaticChord) { // todo: move to checker
        ChromaticChord chromaticChordTmp = removeInversionAsClonedChordIfNeeded(chromaticChord);

        List<DiatonicFunction> diatonicFunctions = getDiatonicFunctionFrom(chromaticChordTmp);
        if (!diatonicFunctions.isEmpty())
            return diatonicFunctions.get(0);

        List<ChromaticFunction> chromaticFunctions = getChromaticFunctionFrom(chromaticChordTmp);
        if (!chromaticFunctions.isEmpty())
            return chromaticFunctions.get(0);

        return null;
    }

    public @NonNull List<HarmonicFunction> getAllFunctionsFrom(@NonNull ChromaticChord chromaticChord) { // todo: move to checker
        ChromaticChord chromaticChordTmp = removeInversionAsClonedChordIfNeeded(chromaticChord);

        List<DiatonicFunction> diatonicFunctions = getDiatonicFunctionFrom(chromaticChordTmp);
        List<HarmonicFunction> ret = new ArrayList<>(diatonicFunctions);

        List<ChromaticFunction> chromaticFunctions = getChromaticFunctionFrom(chromaticChordTmp);
        ret.addAll(chromaticFunctions);

        return ret;
    }

    public @NonNull List<DiatonicFunction> getDiatonicFunctionFrom(@NonNull ChromaticChord chromaticChord) {
        createCacheIfNeeded();

        chromaticChord = removeInversionAsClonedChordIfNeeded(chromaticChord);
        List<DiatonicFunction> diatonicFunctionList = cacheDiatonicMap.getOrDefault(chromaticChord, new ArrayList<>());

        return Collections.unmodifiableList( diatonicFunctionList );
    }

    @SuppressWarnings("WeakerAccess")
    public @NonNull List<ChromaticFunction> getChromaticFunctionFrom(ChromaticChord chromaticChord) {
        createCacheIfNeeded();

        chromaticChord = removeInversionAsClonedChordIfNeeded(chromaticChord);
        List<ChromaticFunction> chromaticFunctionList = cacheChromaticMap.getOrDefault(chromaticChord, new ArrayList<>());

        return Collections.unmodifiableList( chromaticFunctionList);
    }

    private ChromaticChord removeInversionAsClonedChordIfNeeded(@NonNull ChromaticChord chromaticChord) {
        if (chromaticChord.getInversionNumber() != 0) {
            chromaticChord = chromaticChord.clone();
            chromaticChord.toFundamental();
        }

        return chromaticChord;
    }

    @SuppressWarnings("Duplicates")
    private void createCache() {
        if (getRoot() instanceof DiatonicAlt)
            return;
        cacheDiatonicMap = new HashMap<>();
        for (DiatonicFunction diatonicFunction : DiatonicFunction.values()) {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .tonality((Tonality<Chromatic>)this)
                    .diatonicFunction(diatonicFunction)
                    .build();
            List<DiatonicFunction> list = cacheDiatonicMap.getOrDefault(chromaticChord, new ArrayList<>());
            list.add(diatonicFunction);
            cacheDiatonicMap.putIfAbsent(chromaticChord, list);
        }

        cacheChromaticMap = new HashMap<>();
        for (ChromaticFunction chromaticFunction : ChromaticFunction.values()) {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .tonality((Tonality<Chromatic>)this)
                    .chromaticFunction(chromaticFunction)
                    .build();
            List<ChromaticFunction> list = cacheChromaticMap.getOrDefault(chromaticChord, new ArrayList<>());
            list.add(chromaticFunction);
            cacheChromaticMap.putIfAbsent(chromaticChord, list);
        }
    }

    private void clearCaches() {
        cacheDiatonicMap = null;
        cacheChromaticMap = null;
    }

    private void createCacheIfNeeded() {
        if (cacheChromaticMap == null || cacheDiatonicMap == null)
            createCache();
        checkState(cacheDiatonicMap != null && cacheChromaticMap != null);
    }

    @Override
    @NonNull
    public Iterator<C> iterator() {
        return innerTonality.getNotes().iterator();
    }

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

    public Chord<C> getChordFromHarmonicFunction(@NonNull HarmonicFunction harmonicFunction) {
        if ( !(getRoot() instanceof Chromatic))
            return null;
        return (Chord<C>)ChromaticChord.builder()
                .harmonicFunction(harmonicFunction)
                .tonality((Tonality<Chromatic>)this)
                .build();
    }

    public boolean containsAll(Chord<C> chord) {
        for (C cyclicDegree : chord)
            if (!containsAll(cyclicDegree))
                return false;

        return true;
    }

    public int getMaxAltsNote() {
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
}
