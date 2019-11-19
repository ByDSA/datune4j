package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public interface Tonality {
    Tonality C = TonalityEnum.C;
    Tonality Db = TonalityEnum.Db;
    Tonality D = TonalityEnum.D;
    Tonality Eb = TonalityEnum.Eb;
    Tonality E = TonalityEnum.E;
    Tonality F = TonalityEnum.F;
    Tonality FF = TonalityEnum.FF;
    Tonality Gb = TonalityEnum.Gb;
    Tonality G = TonalityEnum.G;
    Tonality Ab = TonalityEnum.Ab;
    Tonality A = TonalityEnum.A;
    Tonality Bb = TonalityEnum.Bb;
    Tonality B = TonalityEnum.B;

    Tonality Cm = TonalityEnum.Cm;
    Tonality CCm = TonalityEnum.CCm;
    Tonality Dm = TonalityEnum.Dm;
    Tonality DDm = TonalityEnum.DDm;
    Tonality Ebm = TonalityEnum.Ebm;
    Tonality Em = TonalityEnum.Em;
    Tonality Fm = TonalityEnum.Fm;
    Tonality FFm = TonalityEnum.FFm;
    Tonality Gm = TonalityEnum.Gm;
    Tonality GGm = TonalityEnum.GGm;
    Tonality Am = TonalityEnum.Am;
    Tonality Bbm = TonalityEnum.Bbm;
    Tonality Bm = TonalityEnum.Bm;

    static @NonNull List<Tonality> all() {
        return TonalityRetrieval.all();
    }

    static @NonNull List<Tonality> values() {
        return TonalityRetrieval.majorMinor();
    }

    /**
     * END CONSTANT TONALITIES
     ******************************************************************************/

    static Tonality fromDiatonicChord(@NonNull DiatonicChordMidi c, @NonNull Tonality base) throws TonalityException { // todo
        return TonalityRetrieval.fromDiatonicChord(c, base);
    }

    static Tonality from(DiatonicAlt diatonicAlt, Scale scale) {
        Tonality t = TonalityEnum.of(diatonicAlt, scale);
        if (t == null)
            t = new TonalityCustom(diatonicAlt, scale);
        return t;
    }

    static Tonality from(Chromatic chromatic, Scale scale) {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(chromatic);
        return from(diatonicAlt, scale);
    }

    static Tonality from(@NonNull Tonality t) {
        return from(t.getRoot(), t.getScale());
    }

    default Tonality getRelativeMinor() {
        return TonalityChordRetrieval.getRelativeMinorFrom(this);
    }

    default Tonality getRelativeMajor() {
        return TonalityChordRetrieval.getRelativeMajorFrom(this);
    }

    default boolean isMajorOrMinor() {
        return isMajor() || isMinor();
    }

    default boolean isMajor() {
        return getScale().has(IntervalChromatic.MAJOR_THIRD)
                && !getScale().has(IntervalChromatic.MINOR_THIRD);
    }

    default boolean isMinor() {
        return !getScale().has(IntervalChromatic.MAJOR_THIRD)
                && getScale().has(IntervalChromatic.MINOR_THIRD);
    }

    default int size() {
        return getScale().size();
    }

    default @NonNull DiatonicAlt getNote(@NonNull RelativeDegree degree) {
        RelativeDegreeAdapter.checkDegree(this, degree);

        int i = degree.ordinal();
        return getNotes().get(i);
    }

    default boolean isModeOf(Tonality t) {
        return getScale().isDiatonic() && this.getRoot() == t.getRoot() && !getScale().equals( t.getScale() );
    }

    default List<Tonality> getModes() {
        List<Tonality> ret = new ArrayList<>();

        for ( Scale scale : getScale().getModes() ) {
            Tonality tonality = Tonality.from(getRoot(), scale);
            ret.add(tonality);
        }

        return ret;
    }

    default int getAlterations() {
        Objects.requireNonNull(getNotes());

        int ret = 0;
        for ( DiatonicAlt c : getNotes() )
            ret += c.getUnsignedAlterations();

        return ret;
    }

    default List<Tonality> getModesSameRoot() {
        List<Tonality> ret = new ArrayList<>();

        for ( Scale s : getScale().getModes() )
            for ( Chromatic chromatic : Chromatic.values() ) {
                Tonality t = Tonality.from( chromatic, s );
                if ( isModeOf( t ) ) {
                    if (t instanceof TonalityCustom)
                        t = TonalityRetrieval.getEnharmonicMinimalAltsFrom(t).iterator().next();
                    ret.add( t );
                }
            }

        return ret;
    }

    default @Nullable RelativeDegree getDegreeFrom(@NonNull DiatonicAlt note) {
        Objects.requireNonNull(note, "No se ha especificado nota");

        for ( RelativeDegree diatonicDegree : getDegrees() ) {
            if (getNote(diatonicDegree).equals(note))
                return diatonicDegree;
        }

        return null;
    }

    default List<RelativeDegree> getDegrees() {
        return RelativeDegree.valuesFrom( getNotes().size() );
    }

    default @Nullable RelativeDegree getDegreeFrom(@NonNull Chromatic chromatic) {
        Objects.requireNonNull(chromatic, "No se ha especificado nota");

        for ( RelativeDegree diatonicDegree : getDegrees() ) {
            DiatonicAlt degreeDiatonicAlt = getNote(diatonicDegree);
            Chromatic degreeChromatic = Chromatic.from(degreeDiatonicAlt);
            if (degreeChromatic == chromatic)
                return diatonicDegree;
        }

        return null;
    }

    /*
     * public Integer getDegreeFrom(int note) { for ( int i = 0; i < size(); i++ ) if
     * ( getFromChromatic( i ).ordinal() == note ) return i;
     *
     * return null; }
     */

    default boolean has(DiatonicAlt note) {
        return getDegreeFrom( note ) != null;
    }

    default boolean has(Chromatic note) {
        return getDegreeFrom( note ) != null;
    }

    default boolean has(@NonNull Iterable<DiatonicAlt> notes) {
        for ( DiatonicAlt n : notes ) {
            if ( getDegreeFrom( n ) == null )
                return false;
        }

        return true;
    }

    default boolean has(@NonNull PitchChromaticChord<Chromatic> notes) {
        for ( Chromatic n : notes ) {
            if ( getDegreeFrom( n ) == null )
                return false;
        }

        return true;
    }

    /*
     * public boolean has(int note) { return getDegreeFrom( note ) != null; }
     *
     * public boolean has(int[] notes) { for ( int n : notes ) if ( getDegreeFrom( n )
     * == null ) return false;
     *
     * return true; }
     */

    default Tonality getRelativeScaleDiatonic(DiatonicDegree pos) { // todo: sólo diatonic
        return Tonality.from( getNote( pos ), getScale() );
    }

    default Tonality getRelativeScaleChromatic(int pos) {
        ScaleDistance distanceScale = ScaleDistance.from(pos);
        int semitones = distanceScale.getSemitones();
        return Tonality.from( getRoot().addSemi( semitones ), getScale() );
    }

    default Tonality getMinor() {
        return Tonality.from( getRoot(), Scale.MINOR );
    }

    default Tonality getMajor() {
        return Tonality.from( getRoot(), Scale.MAJOR );
    }

    default Tonality getLydian() {
        return Tonality.from( getRoot(), Scale.LYDIAN );
    }

    default List<DiatonicChordMidi[]> commonChords(Tonality s) {
        List<DiatonicChordMidi[]> ret = new ArrayList<>();
        for ( DiatonicFunction i : DiatonicFunction.COMMON )
            for ( DiatonicFunction j : DiatonicFunction.COMMON ) {
                DiatonicChordMidi c = new DiatonicChordMidi( i, this );
                DiatonicChordMidi c2 = new DiatonicChordMidi( j, s );

                if ( c.commonNotes( c2, false ).size() == c.size() && c.size() == c2.size() )
                    ret.add(
                            new DiatonicChordMidi[] {
                                    c,
                                    c2
                            }
                    );
            }
        return ret;
    }

    default IntervalChromatic getInterval(DiatonicDegree from, IntervalDiatonic id) { // todo: sólo diatónica
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

    default @Nullable HarmonicFunction getFunction(ChromaticChord c) {
        HarmonicFunction hf = getFunction( c, true );
        if ( hf == null )
            hf = getFunction( c, false );
        return hf;
    }

    ChromaticChord getChordFrom(DiatonicFunction diatonicFunction);

    ChromaticChord getChordFrom(ChromaticFunction chromaticFunction);

    default boolean has(boolean outScale, @NonNull PitchChromaticChord<? extends PitchChromaticSingle> c) {
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

    @NonNull Scale getScale();

    @NonNull DiatonicAlt getRoot();

    @NonNull List<DiatonicAlt> getNotes();

    @Nullable HarmonicFunction getFunction(ChromaticChord c, boolean rename);

    DiatonicAlt getDiatonicAltFrom(Chromatic chromatic) throws TonalityException;
}
