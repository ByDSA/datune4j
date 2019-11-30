package es.danisales.datune.tonality;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.degree.RelativeDegree;
import es.danisales.datune.degree.RelativeDegreeAdapter;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

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

    public static @NonNull List<Tonality> all() {
        return TonalityRetrieval.all();
    }

    static @NonNull List<Tonality> values() {
        return TonalityRetrieval.majorMinor();
    }

    /**
     * END CONSTANT TONALITIES
     ******************************************************************************/

    final TonalityInner innerTonality;

    private Map<Chromatic, DiatonicAlt> chromaticDiatonicAltMap;
    private Map<ChromaticChord, List<ChromaticFunction>> cacheChromaticMap;
    private Map<ChromaticChord, List<DiatonicFunction>> cacheDiatonicMap;

    private Tonality(TonalityInner tonalityInterface) {
        innerTonality = tonalityInterface;

        createChromaticToDiatonicAltCache();
    }

    public static Tonality fromDiatonicChordMidi(@NonNull DiatonicChordMidi c, @NonNull Tonality base) { // todo
        return TonalityRetrieval.fromDiatonicChordMidi(c, base);
    }

    public static @NonNull Tonality from(@NonNull DiatonicAlt diatonicAlt, @NonNull Scale scale) {
        TonalityInner tonalityInterface = TonalityInnerImmutable.of(diatonicAlt, scale);
        if (tonalityInterface == null)
            tonalityInterface = new TonalityInnerMutable(diatonicAlt, scale);

        return new Tonality(tonalityInterface);
    }

    public static @NonNull Tonality from(@NonNull Chromatic chromatic, @NonNull Scale scale) {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(chromatic);
        return from(diatonicAlt, scale);
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Tonality clone() {
        return from(getRoot(), getScale());
    }

    public Tonality getRelativeMinor() {
        return TonalityChordRetrieval.getRelativeMinorFrom(this);
    }

    public Tonality getRelativeMajor() {
        return TonalityChordRetrieval.getRelativeMajorFrom(this);
    }

    public boolean isMajorOrMinor() {
        return isMajor() || isMinor();
    }

    public boolean isMajor() {
        return getScale().hasIntervalFromRoot(IntervalChromatic.MAJOR_THIRD)
                && !getScale().hasIntervalFromRoot(IntervalChromatic.MINOR_THIRD);
    }

    public boolean isMinor() {
        return !getScale().hasIntervalFromRoot(IntervalChromatic.MAJOR_THIRD)
                && getScale().hasIntervalFromRoot(IntervalChromatic.MINOR_THIRD);
    }

    public int size() {
        return getScale().size();
    }

    public @Nullable DiatonicAlt getNote(@NonNull RelativeDegree degree) {
        RelativeDegreeAdapter.checkDegree(this, degree);

        if (degree.getClass().equals(RelativeDegree.valuesFrom(getScale().size()).get(0).getClass()))
            return getNotes().get(degree.ordinal());

        Integer indexInteger = getScale().getIndexByRelativeDegree(degree);
        if (indexInteger == null)
            return null;
        return getNotes().get(indexInteger);
    }

    public boolean isModeOf(Tonality t) {
        return getScale().isDiatonic() && this.getRoot() == t.getRoot() && !getScale().equals( t.getScale() );
    }

    public @NonNull List<Tonality> getModes() {
        List<Tonality> ret = new ArrayList<>();

        for ( Scale scale : getScale().getModes() ) {
            Tonality tonality = Tonality.from(getRoot(), scale);
            ret.add(tonality);
        }

        return ret;
    }

    public int getAlterationsNumber() {
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
                if ( isModeOf( t ) ) {
                    if (t.innerTonality instanceof TonalityInnerMutable)
                        t = TonalityRetrieval.getEnharmonicMinimalAltsFrom(t).iterator().next();
                    ret.add( t );
                }
            }

        return ret;
    }

    public @Nullable RelativeDegree getDegreeFrom(@NonNull DiatonicAlt note) {
        Objects.requireNonNull(note, "No se ha especificado nota");

        for ( RelativeDegree diatonicDegree : getDegrees() ) {
            if (getNote(diatonicDegree).equals(note))
                return diatonicDegree;
        }

        return null;
    }

    public List<RelativeDegree> getDegrees() {
        return RelativeDegree.valuesFrom( getNotes().size() );
    }

    public @NonNull RelativeDegree getDegreeFrom(@NonNull Chromatic chromatic) throws TonalityException {
        Objects.requireNonNull(chromatic, "No se ha especificado nota");

        for ( RelativeDegree diatonicDegree : getDegrees() ) {
            DiatonicAlt degreeDiatonicAlt = getNote(diatonicDegree);
            Chromatic degreeChromatic = Chromatic.from(degreeDiatonicAlt);
            if (degreeChromatic == chromatic)
                return diatonicDegree;
        }

        throw new TonalityException(chromatic, this);
    }

    public boolean contains(DiatonicAlt note) {
        return getDegreeFrom( note ) != null;
    }

    public boolean contains(Chromatic note) {
        try {
            getDegreeFrom(note);
            return true;
        } catch (TonalityException e) {
            return false;
        }
    }

    public boolean has(@NonNull Iterable<Chromatic> notes) {
        for ( Chromatic n : notes ) {
            try {
                getDegreeFrom(n);
            } catch (TonalityException e) {
                return false;
            }
        }

        return true;
    }

    public Tonality getRelativeScaleDiatonic(DiatonicDegree pos) { // todo: sólo function
        return Tonality.from( getNote( pos ), getScale() );
    }

    public Tonality getRelativeScaleChromatic(int pos) {
        ScaleDistance distanceScale = ScaleDistance.from(pos);
        int semitones = distanceScale.getSemitones();
        return Tonality.from( getRoot().addSemi( semitones ), getScale() );
    }

    public IntervalChromatic getInterval(DiatonicDegree from, IntervalDiatonic id) { // todo: sólo diatónica
        int idInt = id.ordinal();
        DiatonicDegree toDiatonicDegree = DiatonicDegree.add(from, id);
        DiatonicAlt toDiatonicAlt = getNote(toDiatonicDegree);
        DiatonicAlt fromDiatonicAlt = getNote(from);
        Chromatic toChromatic = Chromatic.from(toDiatonicAlt);
        Chromatic fromChromatic = Chromatic.from(fromDiatonicAlt);
        int distSemitones = fromChromatic.distSemitonesTo(toChromatic);
        if ( distSemitones < 0 )
            distSemitones += IntervalChromatic.PERFECT_OCTAVE.getSemitones();
        distSemitones += idInt / IntervalChromatic.PERFECT_OCTAVE.getSemitones();
        return IntervalChromatic.from( id, distSemitones );
    }

    public @NonNull ChromaticChord getChordFrom(@NonNull DiatonicFunction diatonicFunction) {
        Objects.requireNonNull(diatonicFunction);

        ChromaticChord ret = TonalityGetDiatonicFunctionMajor.get(this, diatonicFunction);
        if (ret == null)
            ret = TonalityGetDiatonicFunctionMinor.get(this, diatonicFunction);
        if (ret == null)
            ret = TonalityGetDiatonicFunctionDefault.get(this, diatonicFunction);

        return ret;
    }

    public @NonNull ChromaticChord getChordFrom(@NonNull ChromaticFunction chromaticFunction) {
        Objects.requireNonNull(chromaticFunction);

        ChromaticChord ret = TonalityGetChromaticFunction.get(this, chromaticFunction);
        if (ret == null)
            throw new RuntimeException("Undefined chord for chromatic function " + chromaticFunction + " in " + this);
        return ret;
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

    public @Nullable HarmonicFunction getFunctionFrom(@NonNull ChromaticChord chromaticChord) {
        List<DiatonicFunction> diatonicFunctions = getDiatonicFunctionFrom(chromaticChord);

        if (!diatonicFunctions.isEmpty())
            return diatonicFunctions.get(0);

        List<ChromaticFunction> chromaticFunctions = getChromaticFunctionFrom(chromaticChord);
        if (!chromaticFunctions.isEmpty())
            return chromaticFunctions.get(0);

        return null;
    }

    public @NonNull List<DiatonicFunction> getDiatonicFunctionFrom(ChromaticChord chromaticChord) {
        createCacheIfNeeded();

        List<DiatonicFunction> diatonicFunctionList = cacheDiatonicMap.getOrDefault(chromaticChord, new ArrayList<>());

        return Collections.unmodifiableList( diatonicFunctionList );
    }

    public @NonNull List<ChromaticFunction> getChromaticFunctionFrom(ChromaticChord chromaticChord) {
        createCacheIfNeeded();

        List<ChromaticFunction> chromaticFunctionList = cacheChromaticMap.getOrDefault(chromaticChord, new ArrayList<>());

        return Collections.unmodifiableList( chromaticFunctionList );
    }

    public boolean has(boolean outScale, @NonNull ChromaticChord c) {
        Objects.requireNonNull(c);

        List<DiatonicAlt> cc = new ArrayList<>();
        for (PitchChromaticSingle chromatic : c)
            cc.add(DiatonicAlt.from(chromatic));
        boolean hasNotes = getNotes().containsAll( cc );

        if ( hasNotes )
            return true;
        else if ( outScale ) {
            for ( ChromaticFunction f : ChromaticFunction.ALL ) {
                if (size() != Diatonic.NUMBER && ArrayUtils.contains(f, ChromaticFunction.TENSIONS))
                    continue;

                ChromaticChord c2 = ChromaticChord.builder().fromDiatonicChordMidi(
                        DiatonicChordMidi.builder()
                                .from(f, this)
                                .build()
                ).build();
                if (c.getNotes().equals(c2.getNotes()))
                    return true;
            }
        }

        return false;
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

    private void createCacheIfNeeded() {
        if (cacheChromaticMap == null || cacheDiatonicMap == null)
            createCache();
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
        StringBuilder sb = new StringBuilder();
        sb.append(getRoot()).append(" ");

        sb.append( getScale() );

        return sb.toString();
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
