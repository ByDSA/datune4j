package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.pitch.PitchException;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

@SuppressWarnings("WeakerAccess")
public final class DiatonicChord extends ChordProxy<DiatonicChordInterface, Diatonic, IntervalDiatonic>
        implements DiatonicChordCommon<Diatonic>, ChordMutableInterface<Diatonic, IntervalDiatonic> {
    public static final DiatonicChord C_TRIAD = new DiatonicChord(DiatonicChordImmutable.C_TRIAD);
    public static final DiatonicChord C_THIRD = new DiatonicChord(DiatonicChordImmutable.C_THIRD);
    public static final DiatonicChord C_SUS2 = new DiatonicChord(DiatonicChordImmutable.C_SUS2);
    public static final DiatonicChord C_SUS2_O5 = new DiatonicChord(DiatonicChordImmutable.C_SUS2_O5);
    public static final DiatonicChord C_SUS4 = new DiatonicChord(DiatonicChordImmutable.C_SUS4);
    public static final DiatonicChord C_SUS4_O5 = new DiatonicChord(DiatonicChordImmutable.C_SUS4_O5);
    public static final DiatonicChord C_SIXTH = new DiatonicChord(DiatonicChordImmutable.C_SIXTH);
    public static final DiatonicChord C_SIXTH_O5 = new DiatonicChord(DiatonicChordImmutable.C_SIXTH_O5);
    public static final DiatonicChord C_SEVENTH = new DiatonicChord(DiatonicChordImmutable.C_SEVENTH);
    public static final DiatonicChord C_SEVENTH_O3 = new DiatonicChord(DiatonicChordImmutable.C_SEVENTH_O3);
    public static final DiatonicChord C_SEVENTH_O5 = new DiatonicChord(DiatonicChordImmutable.C_SEVENTH_O5);
    public static final DiatonicChord C_NINTH = new DiatonicChord(DiatonicChordImmutable.C_NINTH);
    public static final DiatonicChord C_NINTH_O7 = new DiatonicChord(DiatonicChordImmutable.C_NINTH_O7);
    public static final DiatonicChord C_NINTH_O3_O7 = new DiatonicChord(DiatonicChordImmutable.C_NINTH_O3_O7);
    public static final DiatonicChord C_ELEVENTH = new DiatonicChord(DiatonicChordImmutable.C_ELEVENTH);
    public static final DiatonicChord C_THIRTEENTH = new DiatonicChord(DiatonicChordImmutable.C_THIRTEENTH);

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

    public static @NonNull DiatonicChord from(DiatonicFunction diatonicFunction, Diatonic diatonic) {
        DiatonicChordPattern diatonicChordPattern = DiatonicChordPattern.from(diatonicFunction);
        DiatonicDegree diatonicDegree = DiatonicDegree.from(diatonicFunction);
        IntervalDiatonic intervalDiatonic = IntervalDiatonic.from(diatonicDegree);
        Diatonic diatonicShifted = diatonic.getShifted(intervalDiatonic);
        return DiatonicChord.from(diatonicShifted, diatonicChordPattern);
    }

    public static @NonNull DiatonicChord from(@NonNull Diatonic diatonic, @NonNull DiatonicChordPattern diatonicChordPattern) {
        DiatonicChord diatonicChord = new DiatonicChord();
        diatonicChord.innerChord = new DiatonicChordMutable();
        for (Integer i : diatonicChordPattern) {
            Diatonic diatonicAdd = diatonic;
            for (int j = 0; j < i; j++) {
                diatonicAdd = diatonicAdd.getShifted(IntervalDiatonic.SECOND);
            }
            diatonicChord.innerChord.add(diatonicAdd);
        }

        diatonicChord.turnInnerChordIntoImmutableIfPossible();

        return diatonicChord;
    }

    @Override
    public DiatonicChord getShiftedNegative(IntervalDiatonic intervalDiatonic) {
        try {
            return (DiatonicChord)super.getShiftedNegative(intervalDiatonic);
        } catch (PitchException e) {
            throw NeverHappensException.make("Diatonic is cyclic.");
        }
    }

    @Override
    public DiatonicChord getShifted(IntervalDiatonic intervalDiatonic) {
        try {
        return (DiatonicChord)super.getShifted(intervalDiatonic);
        } catch (PitchException e) {
            throw NeverHappensException.make("Diatonic is cyclic.");
        }
    }

    @Override
    public void shift(IntervalDiatonic intervalDiatonic) {
        try {
        super.shift(intervalDiatonic);
        } catch (PitchException e) {
            throw NeverHappensException.make("Diatonic is cyclic.");
        }
    }

    @Override
    public void shiftNegative(IntervalDiatonic intervalDiatonic) {
        try {
        super.shiftNegative(intervalDiatonic);
        } catch (PitchException e) {
            throw NeverHappensException.make("Diatonic is cyclic.");
        }
    }

    @Override
    protected final void turnInnerChordIntoImmutableIfPossible() {
        if (getRootIndex() != 0)
            return;
        DiatonicChordImmutable diatonicChordEnum = DiatonicChordImmutable.from(innerChord);
        if (diatonicChordEnum != null)
            innerChord = diatonicChordEnum;
    }

    @Override
    protected final void turnInnerIntoMutable() {
        innerChord = DiatonicChordMutable.from(innerChord);
    }

    @Override
    protected final boolean innerIsImmutable() {
        return innerChord instanceof DiatonicChordImmutable;
    }

    @Override
    protected final boolean InnerIsMutable() {
        return innerChord instanceof DiatonicChordMutable;
    }

    @Override
    protected final ChordMutableInterface<Diatonic, IntervalDiatonic> castCustom(DiatonicChordInterface chord) {
        return (DiatonicChordMutable) innerChord;
    }

    @Override
    protected final DiatonicChord create() {
        DiatonicChord diatonicChord = new DiatonicChord();
        diatonicChord.innerChord = new DiatonicChordMutable();
        return diatonicChord;
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
        return DiatonicChordInterfaceAdapter.equals(innerChord, other.innerChord);
    }
}
