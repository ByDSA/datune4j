package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.ChromaticChordInterface;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public class Tonality implements Iterable<DiatonicAlt> {
    public static final Tonality C = new Tonality( TonalityEnum.C );
    public static final Tonality Db = new Tonality( TonalityEnum.Db );
    public static final Tonality D = new Tonality( TonalityEnum.D );
    public static final Tonality Eb = new Tonality( TonalityEnum.Eb );
    public static final Tonality E = new Tonality( TonalityEnum.E );
    public static final Tonality F = new Tonality( TonalityEnum.F );
    public static final Tonality FF = new Tonality( TonalityEnum.FF );
    public static final Tonality Gb = new Tonality( TonalityEnum.Gb );
    public static final Tonality G = new Tonality( TonalityEnum.G );
    public static final Tonality Ab = new Tonality( TonalityEnum.Ab );
    public static final Tonality A = new Tonality( TonalityEnum.A );
    public static final Tonality Bb = new Tonality( TonalityEnum.Bb );
    public static final Tonality B = new Tonality( TonalityEnum.B );

    public static final Tonality Cm = new Tonality( TonalityEnum.Cm );
    public static final Tonality CCm = new Tonality( TonalityEnum.CCm );
    public static final Tonality Dm = new Tonality( TonalityEnum.Dm );
    public static final Tonality DDm = new Tonality( TonalityEnum.DDm );
    public static final Tonality Ebm = new Tonality( TonalityEnum.Ebm );
    public static final Tonality Em = new Tonality( TonalityEnum.Em );
    public static final Tonality Fm = new Tonality( TonalityEnum.Fm );
    public static final Tonality FFm = new Tonality( TonalityEnum.FFm );
    public static final Tonality Gm = new Tonality( TonalityEnum.Gm );
    public static final Tonality GGm = new Tonality( TonalityEnum.GGm );
    public static final Tonality Am = new Tonality( TonalityEnum.Am );
    public static final Tonality Bbm = new Tonality( TonalityEnum.Bbm );
    public static final Tonality Bm = new Tonality( TonalityEnum.Bm );

    public static @NonNull List<Tonality> all() {
        return TonalityRetrieval.all();
    }

    static @NonNull List<Tonality> values() {
        return TonalityRetrieval.majorMinor();
    }

    /**
     * END CONSTANT TONALITIES
     ******************************************************************************/

    final TonalityInterface innerTonality;

    private Map<Chromatic, DiatonicAlt> chromaticDiatonicAltMap;
    private Map<ChromaticChord, List<HarmonicFunction>> cacheMap;

    private Tonality(TonalityInterface tonalityInterface) {
        innerTonality = tonalityInterface;

        createChromaticToDiatonicAltCache();
    }

    public static Tonality fromDiatonicChordMidi(@NonNull DiatonicChordMidi c, @NonNull Tonality base) throws TonalityException { // todo
        return TonalityRetrieval.fromDiatonicChordMidi(c, base);
    }

    public static Tonality from(@NonNull DiatonicAlt diatonicAlt, @NonNull Scale scale) {
        TonalityInterface tonalityInterface = TonalityEnum.of(diatonicAlt, scale);
        if (tonalityInterface == null) {
            tonalityInterface = new TonalityCustom(diatonicAlt, scale);
        }
        return new Tonality(tonalityInterface);
    }

    public static Tonality from(@NonNull Chromatic chromatic, @NonNull Scale scale) {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(chromatic);
        return from(diatonicAlt, scale);
    }

    public static Tonality from(@NonNull Tonality t) {
        return from(t.getRoot(), t.getScale());
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
        return getScale().has(IntervalChromatic.MAJOR_THIRD)
                && !getScale().has(IntervalChromatic.MINOR_THIRD);
    }

    public boolean isMinor() {
        return !getScale().has(IntervalChromatic.MAJOR_THIRD)
                && getScale().has(IntervalChromatic.MINOR_THIRD);
    }

    public int size() {
        return getScale().size();
    }

    public @NonNull DiatonicAlt getNote(@NonNull RelativeDegree degree) {
        RelativeDegreeAdapter.checkDegree(this, degree);

        int i = degree.ordinal();
        return getNotes().get(i);
    }

    public boolean isModeOf(Tonality t) {
        return getScale().isDiatonic() && this.getRoot() == t.getRoot() && !getScale().equals( t.getScale() );
    }

    public List<Tonality> getModes() {
        List<Tonality> ret = new ArrayList<>();

        for ( Scale scale : getScale().getModes() ) {
            Tonality tonality = Tonality.from(getRoot(), scale);
            ret.add(tonality);
        }

        return ret;
    }

    public int getAlterations() {
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
                    if (t.innerTonality instanceof TonalityCustom)
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

    public @Nullable RelativeDegree getDegreeFrom(@NonNull Chromatic chromatic) {
        Objects.requireNonNull(chromatic, "No se ha especificado nota");

        for ( RelativeDegree diatonicDegree : getDegrees() ) {
            DiatonicAlt degreeDiatonicAlt = getNote(diatonicDegree);
            Chromatic degreeChromatic = Chromatic.from(degreeDiatonicAlt);
            if (degreeChromatic == chromatic)
                return diatonicDegree;
        }

        return null;
    }

    public boolean has(DiatonicAlt note) {
        return getDegreeFrom( note ) != null;
    }

    public boolean has(Chromatic note) {
        return getDegreeFrom( note ) != null;
    }

    public boolean has(@NonNull Iterable<DiatonicAlt> notes) {
        for ( DiatonicAlt n : notes ) {
            if ( getDegreeFrom( n ) == null )
                return false;
        }

        return true;
    }

    public boolean has(@NonNull PitchChromaticChord<Chromatic> notes) {
        for ( Chromatic n : notes ) {
            if ( getDegreeFrom( n ) == null )
                return false;
        }

        return true;
    }

    public Tonality getRelativeScaleDiatonic(DiatonicDegree pos) { // todo: sólo diatonic
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

    public HarmonicFunction getFunction(ChromaticChord chromaticChord) {
        createCacheIfNeeded();

        List<HarmonicFunction> harmonicFunctionList = cacheMap.get(chromaticChord);
        if (harmonicFunctionList == null)
            return null;

        return harmonicFunctionList.get(0);
    }

    public boolean has(boolean outScale, @NonNull PitchChromaticChord<? extends PitchChromaticSingle> c) {
        Objects.requireNonNull(c);

        List<DiatonicAlt> cc = new ArrayList<>();
        for (PitchChromaticSingle chromatic : c)
            cc.add(DiatonicAlt.from(chromatic));
        boolean hasNotes = has( cc );

        if ( hasNotes )
            return true;
        else if ( outScale ) {
            for ( ChromaticFunction f : ChromaticFunction.ALL ) {
                try {
                    ChromaticChordInterface c2 = ChromaticChordInterface.from( new DiatonicChordMidi( f, this ) );
                    if ( c.hasSameNotesOrder( c2 ) )
                        return true;
                } catch ( TonalityException ignored) {
                }
            }
        }

        return false;
    }


    public DiatonicDegree getDegreeFrom(PitchChromaticSingle note) {
        assert note != null : "No se ha especificado nota";
        return getDegreeFrom( note, true );
    }

    public DiatonicDegree getDegreeFrom(PitchChromaticSingle note, boolean enharmonic) {
        assert note != null : "No se ha especificado nota";

        for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
            Chromatic chromatic = ChromaticAdapter.from(note);
            if (!enharmonic && getNote(diatonicDegree).equals(chromatic)
                    || enharmonic && Chromatic.from(getNote(diatonicDegree)) == chromatic)
                return diatonicDegree;
        }

        return null;
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
        cacheMap = new HashMap<>();
        for (DiatonicFunction diatonicFunction : DiatonicFunction.values()) {
            ChromaticChord chromaticChord = ChromaticChord.from(this, diatonicFunction);
            List<HarmonicFunction> list = cacheMap.getOrDefault(chromaticChord, new ArrayList<>());
            list.add(diatonicFunction);
            cacheMap.putIfAbsent(chromaticChord, list);
        }

        // todo: descomentar y precalcular a mano los acordes en TonalityGetDiatonicFunctonMajor
/*
		for (ChromaticFunction chromaticFunction : ChromaticFunction.values()) {
			ChromaticChord chromaticChord = ChromaticChord.from(this, chromaticFunction);
			List<HarmonicFunction> list = cacheMap.getOrDefault(chromaticChord, new ArrayList<>());
			list.add(chromaticFunction);
			cacheMap.putIfAbsent(chromaticChord, list);
		}*/
    }

    private void createCacheIfNeeded() {
        if (cacheMap == null)
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
        sb.append( ChromaticMidi.literal( getRoot(), this ) + " " );

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
