package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;
import java.util.function.BiFunction;

public class DiatonicChord extends NormalChordCommon<Diatonic> implements DiatonicChordCommon<Diatonic>, ChordMutableInterface<Diatonic> {
    public static final DiatonicChord TRIAD = new DiatonicChord( DiatonicChordEnum.TRIAD );
    public static final DiatonicChord THIRD = new DiatonicChord( DiatonicChordEnum.THIRD );
    public static final DiatonicChord SUS2 = new DiatonicChord( DiatonicChordEnum.SUS2 );
    public static final DiatonicChord SUS2_O5 = new DiatonicChord( DiatonicChordEnum.SUS2_O5 );
    public static final DiatonicChord SUS4 = new DiatonicChord( DiatonicChordEnum.SUS4 );
    public static final DiatonicChord SUS4_O5 = new DiatonicChord( DiatonicChordEnum.SUS4_O5 );
    public static final DiatonicChord SIXTH = new DiatonicChord( DiatonicChordEnum.SIXTH );
    public static final DiatonicChord SIXTH_O5 = new DiatonicChord( DiatonicChordEnum.SIXTH_O5 );
    public static final DiatonicChord SEVENTH = new DiatonicChord( DiatonicChordEnum.SEVENTH );
    public static final DiatonicChord SEVENTH_O3 = new DiatonicChord( DiatonicChordEnum.SEVENTH_O3 );
    public static final DiatonicChord SEVENTH_O5 = new DiatonicChord( DiatonicChordEnum.SEVENTH_O5 );
    public static final DiatonicChord NINTH = new DiatonicChord( DiatonicChordEnum.NINTH );
    public static final DiatonicChord NINTH_O7 = new DiatonicChord( DiatonicChordEnum.NINTH_O7 );
    public static final DiatonicChord NINTH_O3_O7 = new DiatonicChord( DiatonicChordEnum.NINTH_O3_O7 );
    public static final DiatonicChord ELEVENTH = new DiatonicChord( DiatonicChordEnum.ELEVENTH );
    public static final DiatonicChord THIRTEENTH = new DiatonicChord( DiatonicChordEnum.THIRTEENTH );


    public static DiatonicChord[] values() {
        return new DiatonicChord[]{
                TRIAD,
                THIRD,
                SUS2,
                SUS2_O5,
                SUS4,
                SUS4_O5,
                SIXTH,
                SIXTH_O5,
                SEVENTH,
                SEVENTH_O3,
                SEVENTH_O5,
                NINTH,
                NINTH_O7,
                NINTH_O3_O7,
                ELEVENTH,
                THIRTEENTH
        };
    }

    public static @NonNull DiatonicChord from(@NonNull Collection<Diatonic> diatonicChord) {
        DiatonicChord ret = new DiatonicChord();
        ret.innerChord = DiatonicChordAdapter.from(diatonicChord);
        return ret;
    }

    public static @NonNull DiatonicChord from(@NonNull DiatonicFunction f) {
        DiatonicChord ret = new DiatonicChord();
        ret.innerChord = DiatonicChordAdapter.from(f);
        return ret;
    }

    private DiatonicChord() {
        super();
    }

    private DiatonicChord(DiatonicChordInterface scaleInterface) {
        super(scaleInterface);
    }

    @Override
    protected final void turnIntoEnumIfPossible() {
        DiatonicChordEnum diatonicChordEnum = DiatonicChordEnum.from(innerChord);
        if (diatonicChordEnum != null)
            innerChord = diatonicChordEnum;
    }

    @Override
    protected final void turnInnerIntoCustom() {
        innerChord = DiatonicChordCustom.from(innerChord);
    }

    @Override
    protected final boolean isEnum() {
        return innerChord instanceof DiatonicChordEnum;
    }

    @Override
    protected final boolean isCustom() {
        return innerChord instanceof DiatonicChordCustom;
    }

    @Override
    protected final ChordMutableInterface<Diatonic> castCustom(ChordCommon<Diatonic> chord) {
        return (DiatonicChordCustom)innerChord;
    }

    @Override
    protected final DiatonicChord create() {
        return new DiatonicChord();
    }

    @Override
    protected ChordCommon<Diatonic> createInnerFrom(ChordCommon<Diatonic> chord) {
        return DiatonicChordAdapter.from(chord);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final List<DiatonicChord> getAllInversions() {
        return (List<DiatonicChord>)super.getAllInversions();
    }

    @Override
    public final DiatonicChord duplicate() {
        return (DiatonicChord)super.duplicate();
    }

    @Override
    public Boolean updateWhatIsIt(BiFunction<List<ChromaticChordCustom>, ChordCommon<?>, ChromaticChordCustom> fSelectChord) {
        return null;
    }

    @Override
    public Boolean updateWhatIsItIfNeeded() {
        return null;
    }

    @Override
    public final DiatonicDegree getDegree() {
        return ((DiatonicChordInterface)innerChord).getDegree();
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof DiatonicChord) )
            return false;
        DiatonicChord other = (DiatonicChord)o;
        return DiatonicChordAdapter.equals(((DiatonicChordInterface)innerChord), other.innerChord);
    }
}
