package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

@SuppressWarnings("WeakerAccess")
public final class DiatonicChord extends NormalChordCommon<Diatonic, IntervalDiatonic>
        implements DiatonicChordCommon<Diatonic>, ChordMutableInterface<Diatonic, IntervalDiatonic> {
    public static final DiatonicChord C_TRIAD = new DiatonicChord(DiatonicChordEnum.C_TRIAD);
    public static final DiatonicChord C_THIRD = new DiatonicChord(DiatonicChordEnum.C_THIRD);
    public static final DiatonicChord C_SUS2 = new DiatonicChord(DiatonicChordEnum.C_SUS2);
    public static final DiatonicChord C_SUS2_O5 = new DiatonicChord(DiatonicChordEnum.C_SUS2_O5);
    public static final DiatonicChord C_SUS4 = new DiatonicChord(DiatonicChordEnum.C_SUS4);
    public static final DiatonicChord C_SUS4_O5 = new DiatonicChord(DiatonicChordEnum.C_SUS4_O5);
    public static final DiatonicChord C_SIXTH = new DiatonicChord(DiatonicChordEnum.C_SIXTH);
    public static final DiatonicChord C_SIXTH_O5 = new DiatonicChord(DiatonicChordEnum.C_SIXTH_O5);
    public static final DiatonicChord C_SEVENTH = new DiatonicChord(DiatonicChordEnum.C_SEVENTH);
    public static final DiatonicChord C_SEVENTH_O3 = new DiatonicChord(DiatonicChordEnum.C_SEVENTH_O3);
    public static final DiatonicChord C_SEVENTH_O5 = new DiatonicChord(DiatonicChordEnum.C_SEVENTH_O5);
    public static final DiatonicChord C_NINTH = new DiatonicChord(DiatonicChordEnum.C_NINTH);
    public static final DiatonicChord C_NINTH_O7 = new DiatonicChord(DiatonicChordEnum.C_NINTH_O7);
    public static final DiatonicChord C_NINTH_O3_O7 = new DiatonicChord(DiatonicChordEnum.C_NINTH_O3_O7);
    public static final DiatonicChord C_ELEVENTH = new DiatonicChord(DiatonicChordEnum.C_ELEVENTH);
    public static final DiatonicChord C_THIRTEENTH = new DiatonicChord(DiatonicChordEnum.C_THIRTEENTH);

    public static DiatonicChord[] values() {
        return new DiatonicChord[]{
                C_TRIAD,
                C_THIRD,
                C_SUS2,
                C_SUS2_O5,
                C_SUS4,
                C_SUS4_O5,
                C_SIXTH,
                C_SIXTH_O5,
                C_SEVENTH,
                C_SEVENTH_O3,
                C_SEVENTH_O5,
                C_NINTH,
                C_NINTH_O7,
                C_NINTH_O3_O7,
                C_ELEVENTH,
                C_THIRTEENTH
        };
    }

    public static @NonNull DiatonicChord from(@NonNull Collection<Diatonic> diatonicChord) {
        DiatonicChord ret = new DiatonicChord();
        ret.innerChord = DiatonicChordInterfaceAdapter.from(diatonicChord);
        return ret;
    }

    public static @NonNull DiatonicChord from(@NonNull DiatonicChordMidi diatonicChordMidi) {
        DiatonicChord ret = new DiatonicChord();
        for (DiatonicMidi diatonicMidi : diatonicChordMidi)
            ret.add(diatonicMidi.getPitch().getDiatonic());
        return ret;
    }

    private DiatonicChord() {
        super();
    }

    private DiatonicChord(DiatonicChordInterface scaleInterface) {
        super(scaleInterface);
    }

    public static DiatonicChord from(DiatonicFunction diatonicFunction, Diatonic diatonic) {
        DiatonicChordPattern diatonicChordPattern = DiatonicChordPattern.from(diatonicFunction);
        return DiatonicChord.from(diatonic, diatonicChordPattern);
    }

    private static DiatonicChord from(Diatonic diatonic, DiatonicChordPattern diatonicChordPattern) {
        DiatonicChord diatonicChord = new DiatonicChord();
        for (Integer i : diatonicChordPattern) {
            Diatonic diatonicAdd = diatonic;
            for (int j = 0; j < diatonicChordPattern.get(i); j++) {
                diatonicAdd = diatonicAdd.getShifted(IntervalDiatonic.SECOND);
            }
        }

        return diatonicChord;
    }

    @Override
    public DiatonicChord getShiftedNegative(IntervalDiatonic intervalDiatonic) {
        return (DiatonicChord)super.getShiftedNegative(intervalDiatonic);
    }

    @Override
    public DiatonicChord getShifted(IntervalDiatonic intervalDiatonic) {
        return (DiatonicChord)super.getShifted(intervalDiatonic);
    }

    @Override
    public void shift(IntervalDiatonic intervalDiatonic) {
        super.shift(intervalDiatonic);
    }

    @Override
    public void shiftNegative(IntervalDiatonic intervalDiatonic) {
        super.shiftNegative(intervalDiatonic);
    }

    @Override
    protected final void turnInnerChordIntoEnumIfPossible() {
        if (getRootPos() != 0)
            return;
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
    protected final ChordMutableInterface<Diatonic, IntervalDiatonic> castCustom(ChordCommon<Diatonic> chord) {
        return (DiatonicChordCustom)innerChord;
    }

    @Override
    protected final DiatonicChord create() {
        DiatonicChord diatonicChord = new DiatonicChord();
        diatonicChord.innerChord = new DiatonicChordCustom();
        return diatonicChord;
    }

    @Override
    protected ChordCommon<Diatonic> createInnerFrom(ChordCommon<Diatonic> chord) {
        return DiatonicChordInterfaceAdapter.from(chord);
    }

    @Override
    public DiatonicChord clone() {
        return (DiatonicChord) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof DiatonicChord) )
            return false;
        DiatonicChord other = (DiatonicChord)o;
        return DiatonicChordInterfaceAdapter.equals(((DiatonicChordInterface)innerChord), other.innerChord);
    }
}
