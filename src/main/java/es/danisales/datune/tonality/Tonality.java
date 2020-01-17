package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

import static com.google.common.base.Preconditions.checkState;

public class Tonality implements Iterable<DiatonicAlt> {
    public static final Tonality C = new Tonality(TonalityInnerImmutable.C);
    @SuppressWarnings("WeakerAccess")
    public static final Tonality Db = new Tonality(TonalityInnerImmutable.Db);
    public static final Tonality D = new Tonality(TonalityInnerImmutable.D);
    public static final Tonality Eb = new Tonality(TonalityInnerImmutable.Eb);
    public static final Tonality E = new Tonality(TonalityInnerImmutable.E);
    public static final Tonality F = new Tonality(TonalityInnerImmutable.F);
    public static final Tonality FF = new Tonality(TonalityInnerImmutable.FF);
    @SuppressWarnings("WeakerAccess")
    public static final Tonality Gb = new Tonality(TonalityInnerImmutable.Gb);
    public static final Tonality G = new Tonality(TonalityInnerImmutable.G);
    @SuppressWarnings("WeakerAccess")
    public static final Tonality Ab = new Tonality(TonalityInnerImmutable.Ab);
    public static final Tonality A = new Tonality(TonalityInnerImmutable.A);
    public static final Tonality Bb = new Tonality(TonalityInnerImmutable.Bb);
    public static final Tonality B = new Tonality(TonalityInnerImmutable.B);

    public static final Tonality Cm = new Tonality(TonalityInnerImmutable.Cm);
    public static final Tonality CCm = new Tonality(TonalityInnerImmutable.CCm);
    public static final Tonality Dm = new Tonality(TonalityInnerImmutable.Dm);
    public static final Tonality DDm = new Tonality(TonalityInnerImmutable.DDm);
    @SuppressWarnings("WeakerAccess")
    public static final Tonality Ebm = new Tonality(TonalityInnerImmutable.Ebm);
    public static final Tonality Em = new Tonality(TonalityInnerImmutable.Em);
    public static final Tonality Fm = new Tonality(TonalityInnerImmutable.Fm);
    public static final Tonality FFm = new Tonality(TonalityInnerImmutable.FFm);
    public static final Tonality Gm = new Tonality(TonalityInnerImmutable.Gm);
    public static final Tonality GGm = new Tonality(TonalityInnerImmutable.GGm);
    public static final Tonality Am = new Tonality(TonalityInnerImmutable.Am);
    public static final Tonality Bbm = new Tonality(TonalityInnerImmutable.Bbm);
    public static final Tonality Bm = new Tonality(TonalityInnerImmutable.Bm);

    /**
     * END CONSTANT TONALITIES
     ******************************************************************************/

    TonalityInner innerTonality;
    private final boolean fixed;

    private Map<Chromatic, DiatonicAlt> chromaticDiatonicAltMap;
    private Map<ChromaticChord, List<ChromaticFunction>> cacheChromaticMap;
    private Map<ChromaticChord, List<DiatonicFunction>> cacheDiatonicMap;

    /**
     * Building
     **/

    private Tonality(TonalityInner tonalityInterface) {
        this(tonalityInterface, true);
    }

    private Tonality(TonalityInner tonalityInterface, boolean fixed) {
        innerTonality = tonalityInterface;
        this.fixed = fixed;

        createChromaticToDiatonicAltCache();
    }

    public static Tonality fromDiatonicChordMidi(@NonNull DiatonicChordMidi c, @NonNull Tonality base) { // todo
        return TonalityRetrieval.fromDiatonicChordMidi(c, base);
    }

    public static @NonNull Tonality from(@NonNull DiatonicAlt diatonicAlt, @NonNull Scale scale) {
        TonalityInner tonalityInterface = TonalityInnerImmutable.from(diatonicAlt, scale);
        if (tonalityInterface == null)
            tonalityInterface = new TonalityInnerMutable(diatonicAlt, scale);

        return new Tonality(tonalityInterface, false);
    }

    public static @NonNull Tonality from(@NonNull Chromatic chromatic, @NonNull Scale scale) {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(chromatic);
        return from(diatonicAlt, scale);
    }

    /** Notes **/

    public int size() {
        return getScale().size();
    }

    public @NonNull DiatonicAlt getNote(@NonNull ScaleDegree degree) throws ScaleRelativeDegreeException {
        List<ScaleDegree> mainDegrees = ScaleDegree.getDefaultDegreesFromScaleSize(getScale().size());
        ScaleDegree firstMainDegree = mainDegrees.get(0);
        if (degree.getClass().equals(firstMainDegree.getClass()))
            return getNotes().get(degree.ordinal());

        int indexInteger = getScale().getIndexByDegree(degree);
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

        int ret = 0;
        for ( DiatonicAlt c : getNotes() )
            ret += c.getUnsignedAlterations();

        return ret;
    }

    public List<Tonality> getModesSameRoot() {
        List<Tonality> ret = new ArrayList<>();

        for ( Scale s : getScale().getModes() )
            for ( Chromatic chromatic : Chromatic.values() ) {
                Tonality t = Tonality.from( chromatic, s );
                if (t.innerTonality instanceof TonalityInnerMutable)
                    t = TonalityRetrieval.getEnharmonicMinimalAltsFrom(t).iterator().next();
                ret.add(t);
            }

        return ret;
    }

    public @Nullable ScaleDegree getDegreeFrom(@NonNull DiatonicAlt diatonicAlt) {
        Objects.requireNonNull(diatonicAlt, "No se ha especificado nota");

        for (ScaleDegree degree : getScaleMainDegrees()) {
            DiatonicAlt diatonicAlt1 = getNoteSecure(degree);
            if (diatonicAlt1.equals(diatonicAlt))
                return degree;
        }

        return null;
    }

    private DiatonicAlt getNoteSecure(ScaleDegree degree) {
        try {
            return getNote(degree);
        } catch (ScaleRelativeDegreeException e) {
            throw NeverHappensException.make("Siempre tiene los MainDegreea");
        }
    }

    private List<ScaleDegree> getScaleMainDegrees() {
        return ScaleDegree.getDefaultDegreesFromScaleSize(getNotes().size());
    }

    public @NonNull ScaleDegree getDegreeFrom(@NonNull Chromatic chromatic) throws TonalityException {
        Objects.requireNonNull(chromatic, "No se ha especificado nota");

        for (ScaleDegree degree : getScaleMainDegrees()) {
            DiatonicAlt diatonicAlt = getNoteSecure(degree);

            Chromatic chromatic1 = Chromatic.from(diatonicAlt);
            if (chromatic1 == chromatic)
                return degree;
        }

        throw new TonalityException(chromatic, this);
    }

    private void excepIfFixed() {
        if (fixed)
            throw new UnsupportedOperationException();
    }

    public void setRoot(@NonNull DiatonicAlt root) {
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
        TonalityInnerImmutable tonalityInnerImmutable = TonalityInnerImmutable.from(getRoot(), getScale());
        if (tonalityInnerImmutable != null)
            innerTonality = tonalityInnerImmutable;
    }

    private boolean innerIsImmutable() {
        return innerTonality instanceof TonalityInnerImmutable;
    }

    private void turnInnerIntoMutable() {
        innerTonality = new TonalityInnerMutable(innerTonality.getRoot(), innerTonality.getScale());
    }

    public boolean contains(DiatonicAlt note) {
        return getDegreeFrom( note ) != null;
    }

    public boolean contains(@NonNull Chromatic chromatic) {
        try {
            getDegreeFrom(chromatic);
            return true;
        } catch (TonalityException e) {
            return false;
        }
    }

    public boolean containsAll(@NonNull Iterable<Chromatic> notes) {
        for (Chromatic chromatic : notes) {
            if (!contains(chromatic))
                return false;
        }

        return true;
    }

    public @NonNull Tonality getRelativeScaleDiatonic(ScaleDegree relativeDegree) throws ScaleRelativeDegreeException { // todo: sólo function
        DiatonicAlt diatonicAlt = getNote(relativeDegree);

        return Tonality.from(diatonicAlt, getScale());
    }

    public @NonNull Scale getScale() {
        return innerTonality.getScale();
    }

    public @NonNull DiatonicAlt getRoot() {
        return innerTonality.getRoot();
    }

    public @NonNull List<DiatonicAlt> getNotes() {
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

    private void createChromaticToDiatonicAltCache() {
        chromaticDiatonicAltMap = new HashMap<>();
        for ( DiatonicAlt diatonicAlt : innerTonality.getNotes() ) {
            Chromatic chromatic = Chromatic.from(diatonicAlt);
            chromaticDiatonicAltMap.put(chromatic, diatonicAlt);
        }
    }

    @SuppressWarnings("Duplicates")
    private void createCache() {
        cacheDiatonicMap = new HashMap<>();
        for (DiatonicFunction diatonicFunction : DiatonicFunction.values()) {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .tonality(this)
                    .diatonicFunction(diatonicFunction)
                    .build();
            List<DiatonicFunction> list = cacheDiatonicMap.getOrDefault(chromaticChord, new ArrayList<>());
            list.add(diatonicFunction);
            cacheDiatonicMap.putIfAbsent(chromaticChord, list);
        }

        cacheChromaticMap = new HashMap<>();
        for (ChromaticFunction chromaticFunction : ChromaticFunction.values()) {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .tonality(this)
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

    public @Nullable DiatonicAlt getNote(@NonNull Chromatic chromatic) {
        Objects.requireNonNull(chromatic);

        return chromaticDiatonicAltMap.get( chromatic );
    }

    @Override
    @NonNull
    public Iterator<DiatonicAlt> iterator() {
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
    public Tonality clone() {
        return from(getRoot(), getScale());
    }
}
