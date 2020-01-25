package es.danisales.datune.chords;

import com.google.common.collect.ImmutableList;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

@SuppressWarnings("WeakerAccess")
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
    public static final DiatonicDegreePattern I6 = new DiatonicDegreePattern(DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VI);
    public static final DiatonicDegreePattern II6 = new DiatonicDegreePattern(DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.VII);
    public static final DiatonicDegreePattern III6 = new DiatonicDegreePattern(DiatonicDegree.III, DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.I);
    public static final DiatonicDegreePattern IV6 = new DiatonicDegreePattern(DiatonicDegree.IV, DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.II);
    public static final DiatonicDegreePattern V6 = new DiatonicDegreePattern(DiatonicDegree.V, DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.III);
    public static final DiatonicDegreePattern VI6 = new DiatonicDegreePattern(DiatonicDegree.VI, DiatonicDegree.I, DiatonicDegree.III, DiatonicDegree.IV);
    public static final DiatonicDegreePattern VII6 = new DiatonicDegreePattern(DiatonicDegree.VII, DiatonicDegree.II, DiatonicDegree.IV, DiatonicDegree.V);

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

    private static final Map<List<DiatonicDegree>, DiatonicDegreePattern> precalculatedDiatonicDegreePatterns = new HashMap<>();
    static {
        precalculatedDiatonicDegreePatterns.put(I_SECOND.degrees, I_SECOND);
        precalculatedDiatonicDegreePatterns.put(II_SECOND.degrees, II_SECOND);
        precalculatedDiatonicDegreePatterns.put(III_SECOND.degrees, III_SECOND);
        precalculatedDiatonicDegreePatterns.put(IV_SECOND.degrees, IV_SECOND);
        precalculatedDiatonicDegreePatterns.put(V_SECOND.degrees, V_SECOND);
        precalculatedDiatonicDegreePatterns.put(VI_SECOND.degrees, VI_SECOND);
        precalculatedDiatonicDegreePatterns.put(VII_SECOND.degrees, VII_SECOND);
        precalculatedDiatonicDegreePatterns.put(I_THIRD.degrees, I_THIRD);
        precalculatedDiatonicDegreePatterns.put(II_THIRD.degrees, II_THIRD);
        precalculatedDiatonicDegreePatterns.put(III_THIRD.degrees, III_THIRD);
        precalculatedDiatonicDegreePatterns.put(IV_THIRD.degrees, IV_THIRD);
        precalculatedDiatonicDegreePatterns.put(V_THIRD.degrees, V_THIRD);
        precalculatedDiatonicDegreePatterns.put(VI_THIRD.degrees, VI_THIRD);
        precalculatedDiatonicDegreePatterns.put(VII_THIRD.degrees, VII_THIRD);
        precalculatedDiatonicDegreePatterns.put(I_FOURTH.degrees, I_FOURTH);
        precalculatedDiatonicDegreePatterns.put(II_FOURTH.degrees, II_FOURTH);
        precalculatedDiatonicDegreePatterns.put(III_FOURTH.degrees, III_FOURTH);
        precalculatedDiatonicDegreePatterns.put(IV_FOURTH.degrees, IV_FOURTH);
        precalculatedDiatonicDegreePatterns.put(V_FOURTH.degrees, V_FOURTH);
        precalculatedDiatonicDegreePatterns.put(VI_FOURTH.degrees, VI_FOURTH);
        precalculatedDiatonicDegreePatterns.put(VII_FOURTH.degrees, VII_FOURTH);
        precalculatedDiatonicDegreePatterns.put(I_FIFTH.degrees, I_FIFTH);
        precalculatedDiatonicDegreePatterns.put(II_FIFTH.degrees, II_FIFTH);
        precalculatedDiatonicDegreePatterns.put(III_FIFTH.degrees, III_FIFTH);
        precalculatedDiatonicDegreePatterns.put(IV_FIFTH.degrees, IV_FIFTH);
        precalculatedDiatonicDegreePatterns.put(V_FIFTH.degrees, V_FIFTH);
        precalculatedDiatonicDegreePatterns.put(VI_FIFTH.degrees, VI_FIFTH);
        precalculatedDiatonicDegreePatterns.put(VII_FIFTH.degrees, VII_FIFTH);
        precalculatedDiatonicDegreePatterns.put(I_SIXTH.degrees, I_SIXTH);
        precalculatedDiatonicDegreePatterns.put(II_SIXTH.degrees, II_SIXTH);
        precalculatedDiatonicDegreePatterns.put(III_SIXTH.degrees, III_SIXTH);
        precalculatedDiatonicDegreePatterns.put(IV_SIXTH.degrees, IV_SIXTH);
        precalculatedDiatonicDegreePatterns.put(V_SIXTH.degrees, V_SIXTH);
        precalculatedDiatonicDegreePatterns.put(VI_SIXTH.degrees, VI_SIXTH);
        precalculatedDiatonicDegreePatterns.put(VII_SIXTH.degrees, VII_SIXTH);
        precalculatedDiatonicDegreePatterns.put(I_SEVENTH.degrees, I_SEVENTH);
        precalculatedDiatonicDegreePatterns.put(II_SEVENTH.degrees, II_SEVENTH);
        precalculatedDiatonicDegreePatterns.put(III_SEVENTH.degrees, III_SEVENTH);
        precalculatedDiatonicDegreePatterns.put(IV_SEVENTH.degrees, IV_SEVENTH);
        precalculatedDiatonicDegreePatterns.put(V_SEVENTH.degrees, V_SEVENTH);
        precalculatedDiatonicDegreePatterns.put(VI_SEVENTH.degrees, VI_SEVENTH);
        precalculatedDiatonicDegreePatterns.put(VII_SEVENTH.degrees, VII_SEVENTH);
        precalculatedDiatonicDegreePatterns.put(I_OCTAVE.degrees, I_OCTAVE);
        precalculatedDiatonicDegreePatterns.put( II_OCTAVE.degrees, II_OCTAVE);
        precalculatedDiatonicDegreePatterns.put( III_OCTAVE.degrees, III_OCTAVE);
        precalculatedDiatonicDegreePatterns.put( IV_OCTAVE.degrees, IV_OCTAVE);
        precalculatedDiatonicDegreePatterns.put( V_OCTAVE.degrees, V_OCTAVE);
        precalculatedDiatonicDegreePatterns.put( VI_OCTAVE.degrees, VI_OCTAVE);
        precalculatedDiatonicDegreePatterns.put( VII_OCTAVE.degrees, VII_OCTAVE);
        precalculatedDiatonicDegreePatterns.put(I.degrees, I);
        precalculatedDiatonicDegreePatterns.put( II.degrees, II);
        precalculatedDiatonicDegreePatterns.put( III.degrees, III);
        precalculatedDiatonicDegreePatterns.put( IV.degrees, IV);
        precalculatedDiatonicDegreePatterns.put( V.degrees, V);
        precalculatedDiatonicDegreePatterns.put( VI.degrees, VI);
        precalculatedDiatonicDegreePatterns.put( VII.degrees, VII);

        precalculatedDiatonicDegreePatterns.put(I6.degrees, I6);
        precalculatedDiatonicDegreePatterns.put( II6.degrees, II6);
        precalculatedDiatonicDegreePatterns.put( III6.degrees, III6);
        precalculatedDiatonicDegreePatterns.put( IV6.degrees, IV6);
        precalculatedDiatonicDegreePatterns.put( V6.degrees, V6);
        precalculatedDiatonicDegreePatterns.put( VI6.degrees, VI6);
        precalculatedDiatonicDegreePatterns.put( VII6.degrees, VII6);

        precalculatedDiatonicDegreePatterns.put(I7.degrees, I7);
        precalculatedDiatonicDegreePatterns.put( II7.degrees, II7);
        precalculatedDiatonicDegreePatterns.put( III7.degrees, III7);
        precalculatedDiatonicDegreePatterns.put( IV7.degrees, IV7);
        precalculatedDiatonicDegreePatterns.put( V7.degrees, V7);
        precalculatedDiatonicDegreePatterns.put( VI7.degrees, VI7);
        precalculatedDiatonicDegreePatterns.put( VII7.degrees, VII7);

        precalculatedDiatonicDegreePatterns.put(I9.degrees, I9);
        precalculatedDiatonicDegreePatterns.put( II9.degrees, II9);
        precalculatedDiatonicDegreePatterns.put( III9.degrees, III9);
        precalculatedDiatonicDegreePatterns.put( IV9.degrees, IV9);
        precalculatedDiatonicDegreePatterns.put( V9.degrees, V9);
        precalculatedDiatonicDegreePatterns.put( VI9.degrees, VI9);
        precalculatedDiatonicDegreePatterns.put( VII9.degrees, VII9);

        precalculatedDiatonicDegreePatterns.put(I11.degrees, I11);
        precalculatedDiatonicDegreePatterns.put(II11.degrees, II11);
        precalculatedDiatonicDegreePatterns.put(III11.degrees, III11);
        precalculatedDiatonicDegreePatterns.put(IV11.degrees, IV11);
        precalculatedDiatonicDegreePatterns.put(V11.degrees, V11);
        precalculatedDiatonicDegreePatterns.put(VI11.degrees, VI11);
        precalculatedDiatonicDegreePatterns.put(VII11.degrees, VII11);

        precalculatedDiatonicDegreePatterns.put(I13.degrees, I13);
        precalculatedDiatonicDegreePatterns.put(II13.degrees, II13);
        precalculatedDiatonicDegreePatterns.put(III13.degrees, III13);
        precalculatedDiatonicDegreePatterns.put(IV13.degrees, IV13);
        precalculatedDiatonicDegreePatterns.put(V13.degrees, V13);
        precalculatedDiatonicDegreePatterns.put(VI13.degrees, VI13);
        precalculatedDiatonicDegreePatterns.put(VII13.degrees, VII13);
    }

    private static final NeverHappensException NO_COMPOUND_INTERVAL = NeverHappensException.make("No compound interval");

    private final List<DiatonicDegree> degrees;

    private DiatonicDegreePattern(DiatonicDegree... diatonicDegrees) {
        checkArgument(diatonicDegrees.length > 0);
        degrees = ImmutableList.copyOf(diatonicDegrees);
    }

    private DiatonicDegreePattern(List<DiatonicDegree> diatonicDegrees) {
        checkArgument(diatonicDegrees.size() > 0);
        degrees = ImmutableList.copyOf(diatonicDegrees);
    }

    private static @Nullable DiatonicDegreePattern getPrecalculated(List<DiatonicDegree> diatonicDegrees) {
        return precalculatedDiatonicDegreePatterns.get(diatonicDegrees);
    }

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

    public DiatonicDegreePattern getWithOmitted(DiatonicDegree... diatonicValues) {
        List<DiatonicDegree> diatonicDegrees = new ArrayList<>(degrees);

        diatonicDegrees.removeAll(Arrays.asList(diatonicValues));

        DiatonicDegreePattern diatonicDegreePattern = getPrecalculated(diatonicDegrees);
        if (diatonicDegreePattern == null) {
            diatonicDegreePattern = new DiatonicDegreePattern(diatonicDegrees);
            precalculatedDiatonicDegreePatterns.put(diatonicDegreePattern.degrees, diatonicDegreePattern);
        }
        return diatonicDegreePattern;
    }

    @NonNull
    @Override
    public Iterator<DiatonicDegree> iterator() {
        return degrees.iterator();
    }

    /* Object */

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof DiatonicDegreePattern))
            return false;

        DiatonicDegreePattern diatonicDegreePattern = (DiatonicDegreePattern)o;

        return degrees.equals(diatonicDegreePattern.degrees);
    }

    @Override
    public String toString() {
        return degrees.toString();
    }
}
