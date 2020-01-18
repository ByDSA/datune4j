package es.danisales.datune.chords;

import com.google.common.collect.ImmutableList;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.utils.NeverHappensException;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

public class DiatonicDegreePattern implements Iterable<DiatonicDegree> {
    // Intervals
    public static final DiatonicDegreePattern I_SECOND = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.II);
    public static final DiatonicDegreePattern II_SECOND = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.III);
    public static final DiatonicDegreePattern III_SECOND = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.IV);
    public static final DiatonicDegreePattern IV_SECOND = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.V);
    public static final DiatonicDegreePattern V_SECOND = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VI);
    public static final DiatonicDegreePattern VI_SECOND = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.VII);
    public static final DiatonicDegreePattern VII_SECOND = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.I);

    public static final DiatonicDegreePattern I_THIRD = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.III);
    public static final DiatonicDegreePattern II_THIRD = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.IV);
    public static final DiatonicDegreePattern III_THIRD = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.V);
    public static final DiatonicDegreePattern IV_THIRD = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VI);
    public static final DiatonicDegreePattern V_THIRD = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VII);
    public static final DiatonicDegreePattern VI_THIRD = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.I);
    public static final DiatonicDegreePattern VII_THIRD = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.II);

    public static final DiatonicDegreePattern I_FOURTH = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.IV);
    public static final DiatonicDegreePattern II_FOURTH = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.V);
    public static final DiatonicDegreePattern III_FOURTH = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.VI);
    public static final DiatonicDegreePattern IV_FOURTH = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VII);
    public static final DiatonicDegreePattern V_FOURTH = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.I);
    public static final DiatonicDegreePattern VI_FOURTH = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.II);
    public static final DiatonicDegreePattern VII_FOURTH = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.III);

    public static final DiatonicDegreePattern I_FIFTH = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.V);
    public static final DiatonicDegreePattern II_FIFTH = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.VI);
    public static final DiatonicDegreePattern III_FIFTH = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.VII);
    public static final DiatonicDegreePattern IV_FIFTH = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.I);
    public static final DiatonicDegreePattern V_FIFTH = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.II);
    public static final DiatonicDegreePattern VI_FIFTH = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.III);
    public static final DiatonicDegreePattern VII_FIFTH = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.IV);

    public static final DiatonicDegreePattern I_SIXTH = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.VI);
    public static final DiatonicDegreePattern II_SIXTH = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.VII);
    public static final DiatonicDegreePattern III_SIXTH = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.I);
    public static final DiatonicDegreePattern IV_SIXTH = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.II);
    public static final DiatonicDegreePattern V_SIXTH = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.III);
    public static final DiatonicDegreePattern VI_SIXTH = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.IV);
    public static final DiatonicDegreePattern VII_SIXTH = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.V);

    public static final DiatonicDegreePattern I_SEVENTH = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.VII);
    public static final DiatonicDegreePattern II_SEVENTH = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.I);
    public static final DiatonicDegreePattern III_SEVENTH = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.II);
    public static final DiatonicDegreePattern IV_SEVENTH = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.III);
    public static final DiatonicDegreePattern V_SEVENTH = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.IV);
    public static final DiatonicDegreePattern VI_SEVENTH = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.V);
    public static final DiatonicDegreePattern VII_SEVENTH = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.VI);

    public static final DiatonicDegreePattern I_OCTAVE = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.I);
    public static final DiatonicDegreePattern II_OCTAVE = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.II);
    public static final DiatonicDegreePattern III_OCTAVE = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.III);
    public static final DiatonicDegreePattern IV_OCTAVE = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.IV);
    public static final DiatonicDegreePattern V_OCTAVE = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.V);
    public static final DiatonicDegreePattern VI_OCTAVE = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.VI);
    public static final DiatonicDegreePattern VII_OCTAVE = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.VII);

    // Triads
    public static final DiatonicDegreePattern I = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V);
    public static final DiatonicDegreePattern II = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI);
    public static final DiatonicDegreePattern III = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII);
    public static final DiatonicDegreePattern IV = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I);
    public static final DiatonicDegreePattern V = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II);
    public static final DiatonicDegreePattern VI = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III);
    public static final DiatonicDegreePattern VII = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV);

    // Sixth
    public static final DiatonicDegreePattern I6 = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.VI);
    public static final DiatonicDegreePattern II6 = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VII);
    public static final DiatonicDegreePattern III6 = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.I);
    public static final DiatonicDegreePattern IV6 = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.II);
    public static final DiatonicDegreePattern V6 = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.III);
    public static final DiatonicDegreePattern VI6 = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.IV);
    public static final DiatonicDegreePattern VII6 = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.V);

    // Seventh
    public static final DiatonicDegreePattern I7 = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII);
    public static final DiatonicDegreePattern II7 = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I);
    public static final DiatonicDegreePattern III7 = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II);
    public static final DiatonicDegreePattern IV7 = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III);
    public static final DiatonicDegreePattern V7 = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV);
    public static final DiatonicDegreePattern VI7 = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V);
    public static final DiatonicDegreePattern VII7 = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI);

    // 9th
    public static final DiatonicDegreePattern I9 = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II);
    public static final DiatonicDegreePattern II9 = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III);
    public static final DiatonicDegreePattern III9 = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV);
    public static final DiatonicDegreePattern IV9 = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V);
    public static final DiatonicDegreePattern V9 = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI);
    public static final DiatonicDegreePattern VI9 = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII);
    public static final DiatonicDegreePattern VII9 = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I);

    // 11th
    public static final DiatonicDegreePattern I11 = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV);
    public static final DiatonicDegreePattern II11 = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V);
    public static final DiatonicDegreePattern III11 = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI);
    public static final DiatonicDegreePattern IV11 = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII);
    public static final DiatonicDegreePattern V11 = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I);
    public static final DiatonicDegreePattern VI11 = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II);
    public static final DiatonicDegreePattern VII11 = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III);

    // 13th
    public static final DiatonicDegreePattern I13 = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI);
    public static final DiatonicDegreePattern II13 = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII);
    public static final DiatonicDegreePattern III13 = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I);
    public static final DiatonicDegreePattern IV13 = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II);
    public static final DiatonicDegreePattern V13 = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III);
    public static final DiatonicDegreePattern VI13 = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV);
    public static final DiatonicDegreePattern VII13 = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V);
    private static final DiatonicDegreePattern I_NOTE = new DiatonicDegreePattern(DiatonicDegree.I);
    private static final DiatonicDegreePattern II_NOTE = new DiatonicDegreePattern(DiatonicDegree.II);
    private static final DiatonicDegreePattern III_NOTE = new DiatonicDegreePattern(DiatonicDegree.III);
    private static final DiatonicDegreePattern IV_NOTE = new DiatonicDegreePattern(DiatonicDegree.IV);
    private static final DiatonicDegreePattern V_NOTE = new DiatonicDegreePattern(DiatonicDegree.V);
    private static final DiatonicDegreePattern VI_NOTE = new DiatonicDegreePattern(DiatonicDegree.VI);
    private static final DiatonicDegreePattern VII_NOTE = new DiatonicDegreePattern(DiatonicDegree.VII);

    final List<DiatonicDegree> degrees;

    private DiatonicDegreePattern(DiatonicDegree... diatonicDegrees) {
        checkArgument(diatonicDegrees.length > 0);
        degrees = ImmutableList.copyOf(diatonicDegrees);
    }

    private DiatonicDegreePattern(List<DiatonicDegree> diatonicDegrees) {
        checkArgument(diatonicDegrees.size() > 0);
        degrees = ImmutableList.copyOf(diatonicDegrees);
    }

    private static final NeverHappensException NO_COMPOUND_INTERVAL = NeverHappensException.make("No compound interval");

    public static @NonNull DiatonicDegreePattern from(DiatonicDegree diatonicDegree, IntervalDiatonic intervalDiatonic) {
        checkArgument(!intervalDiatonic.isCompound());

        switch (diatonicDegree) {
            case I:
                switch (intervalDiatonic) {
                    case UNISON:
                        return DiatonicDegreePattern.I_NOTE;
                    case SECOND:
                        return DiatonicDegreePattern.I_SECOND;
                    case THIRD:
                        return DiatonicDegreePattern.I_THIRD;
                    case FOURTH:
                        return DiatonicDegreePattern.I_FOURTH;
                    case FIFTH:
                        return DiatonicDegreePattern.I_FIFTH;
                    case SIXTH:
                        return DiatonicDegreePattern.I_SIXTH;
                    case SEVENTH:
                        return DiatonicDegreePattern.I_SEVENTH;
                    case OCTAVE:
                        return DiatonicDegreePattern.I_OCTAVE;
                    default:
                        throw NO_COMPOUND_INTERVAL;
                }
            case II:
                switch (intervalDiatonic) {
                    case UNISON:
                        return DiatonicDegreePattern.II_NOTE;
                    case SECOND:
                        return DiatonicDegreePattern.II_SECOND;
                    case THIRD:
                        return DiatonicDegreePattern.II_THIRD;
                    case FOURTH:
                        return DiatonicDegreePattern.II_FOURTH;
                    case FIFTH:
                        return DiatonicDegreePattern.II_FIFTH;
                    case SIXTH:
                        return DiatonicDegreePattern.II_SIXTH;
                    case SEVENTH:
                        return DiatonicDegreePattern.II_SEVENTH;
                    case OCTAVE:
                        return DiatonicDegreePattern.II_OCTAVE;
                    default:
                        throw NO_COMPOUND_INTERVAL;
                }
            case III:
                switch (intervalDiatonic) {
                    case UNISON:
                        return DiatonicDegreePattern.III_NOTE;
                    case SECOND:
                        return DiatonicDegreePattern.III_SECOND;
                    case THIRD:
                        return DiatonicDegreePattern.III_THIRD;
                    case FOURTH:
                        return DiatonicDegreePattern.III_FOURTH;
                    case FIFTH:
                        return DiatonicDegreePattern.III_FIFTH;
                    case SIXTH:
                        return DiatonicDegreePattern.III_SIXTH;
                    case SEVENTH:
                        return DiatonicDegreePattern.III_SEVENTH;
                    case OCTAVE:
                        return DiatonicDegreePattern.III_OCTAVE;
                    default:
                        throw NO_COMPOUND_INTERVAL;
                }
            case IV:
                switch (intervalDiatonic) {
                    case UNISON:
                        return DiatonicDegreePattern.IV_NOTE;
                    case SECOND:
                        return DiatonicDegreePattern.IV_SECOND;
                    case THIRD:
                        return DiatonicDegreePattern.IV_THIRD;
                    case FOURTH:
                        return DiatonicDegreePattern.IV_FOURTH;
                    case FIFTH:
                        return DiatonicDegreePattern.IV_FIFTH;
                    case SIXTH:
                        return DiatonicDegreePattern.IV_SIXTH;
                    case SEVENTH:
                        return DiatonicDegreePattern.IV_SEVENTH;
                    case OCTAVE:
                        return DiatonicDegreePattern.IV_OCTAVE;
                    default:
                        throw NO_COMPOUND_INTERVAL;
                }
            case V:
                switch (intervalDiatonic) {
                    case UNISON:
                        return DiatonicDegreePattern.V_NOTE;
                    case SECOND:
                        return DiatonicDegreePattern.V_SECOND;
                    case THIRD:
                        return DiatonicDegreePattern.V_THIRD;
                    case FOURTH:
                        return DiatonicDegreePattern.V_FOURTH;
                    case FIFTH:
                        return DiatonicDegreePattern.V_FIFTH;
                    case SIXTH:
                        return DiatonicDegreePattern.V_SIXTH;
                    case SEVENTH:
                        return DiatonicDegreePattern.V_SEVENTH;
                    case OCTAVE:
                        return DiatonicDegreePattern.V_OCTAVE;
                    default:
                        throw NO_COMPOUND_INTERVAL;
                }
            case VI:
                switch (intervalDiatonic) {
                    case UNISON:
                        return DiatonicDegreePattern.VI_NOTE;
                    case SECOND:
                        return DiatonicDegreePattern.VI_SECOND;
                    case THIRD:
                        return DiatonicDegreePattern.VI_THIRD;
                    case FOURTH:
                        return DiatonicDegreePattern.VI_FOURTH;
                    case FIFTH:
                        return DiatonicDegreePattern.VI_FIFTH;
                    case SIXTH:
                        return DiatonicDegreePattern.VI_SIXTH;
                    case SEVENTH:
                        return DiatonicDegreePattern.VI_SEVENTH;
                    case OCTAVE:
                        return DiatonicDegreePattern.VI_OCTAVE;
                    default:
                        throw NO_COMPOUND_INTERVAL;
                }
            case VII:
                switch (intervalDiatonic) {
                    case UNISON:
                        return DiatonicDegreePattern.VII_NOTE;
                    case SECOND:
                        return DiatonicDegreePattern.VII_SECOND;
                    case THIRD:
                        return DiatonicDegreePattern.VII_THIRD;
                    case FOURTH:
                        return DiatonicDegreePattern.VII_FOURTH;
                    case FIFTH:
                        return DiatonicDegreePattern.VII_FIFTH;
                    case SIXTH:
                        return DiatonicDegreePattern.VII_SIXTH;
                    case SEVENTH:
                        return DiatonicDegreePattern.VII_SEVENTH;
                    case OCTAVE:
                        return DiatonicDegreePattern.VII_OCTAVE;
                    default:
                        throw NO_COMPOUND_INTERVAL;
                }
        }

        throw NeverHappensException.switchOf(diatonicDegree);
    }

    public @NonNull DiatonicDegree getFirstDiatonicDegree() {
        return degrees.get(0);
    }

    public static @NonNull DiatonicDegreePattern from(@NonNull DiatonicFunction diatonicFunction) {
        switch (diatonicFunction) {
            case I: return I;
            case II: return II;
            case III: return III;
            case IV: return IV;
            case V: return V;
            case VI: return VI;
            case VII: return VII;
            case I6: return I6;
            case II6: return II6;
            case III6: return III6;
            case IV6: return IV6;
            case V6: return V6;
            case VI6: return VI6;
            case VII6: return VII6;
            case I7: return I7;
            case II7: return II7;
            case III7: return III7;
            case IV7: return IV7;
            case V7: return V7;
            case VI7: return VI7;
            case VII7: return VII7;
            case I9: return I9;
            case II9: return II9;
            case III9: return III9;
            case IV9: return IV9;
            case V9: return V9;
            case VI9: return VI9;
            case VII9: return VII9;
            case I11: return I11;
            case II11: return II11;
            case III11: return III11;
            case IV11: return IV11;
            case V11: return V11;
            case VI11: return VI11;
            case VII11: return VII11;
            case I13: return I13;
            case II13: return II13;
            case III13: return III13;
            case IV13: return IV13;
            case V13: return V13;
            case VI13: return VI13;
            case VII13: return VII13;
        }

        throw NeverHappensException.switchOf(diatonicFunction);
    }

    public DiatonicDegreePattern getWithOmitted(Integer... diatonicValues) {
        checkOmittedValues(diatonicValues);

        List<DiatonicDegree> newDiatonicDegrees = new ArrayList<>();

        int checkedNotes = 0;
        int i = 0;
        for (DiatonicDegree diatonicDegree = degrees.get(0); checkedNotes < diatonicValues.length; diatonicDegree = diatonicDegree.getNext()) {

            if (diatonicDegree.equals(degrees.get(checkedNotes))) {
                checkedNotes++;

                if (i != diatonicDegree.ordinal()-1)
                    newDiatonicDegrees.add(diatonicDegree);
            }
            i++;
        }

        return new DiatonicDegreePattern(newDiatonicDegrees);
    }

    private void checkOmittedValues(Integer... diatonicValues) {
        for (Integer integer : diatonicValues)
            if (integer <= 1 || integer >= 11)
                throw new RuntimeException();
    }

    @Override
    public Iterator<DiatonicDegree> iterator() {
        return degrees.iterator();
    }
}
