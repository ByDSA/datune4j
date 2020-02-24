package es.danisales.datune.tonality;

import es.danisales.datune.chords.Chord;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.diatonicalt.DiatonicAltRetrieval;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TonalityRetrieval {
    public static List<TonalityModern> fromChordProgression(List<ChromaticChord> chromaticChordProgression, List<TonalityModern> tonalities) {
        tonalities = new ArrayList<>(tonalities);
        for (Chord<Chromatic> chromaticChord : chromaticChordProgression) {
            tonalities = getFromChord((ChromaticChord)chromaticChord, tonalities);
        }
        return tonalities;
    }

    private static List<TonalityModern> getFromChord(ChromaticChord chromaticChord, List<TonalityModern> tonalities) {
        List<TonalityModern> ret = new ArrayList<>();
        List<HarmonicFunction> harmonicFunctionList = new ArrayList<>();
        harmonicFunctionList.addAll(DiatonicFunction.immutableValues());
        harmonicFunctionList.addAll(SecondaryDominant.values());

        for (TonalityModern tonality : tonalities) {
            Set<HarmonicFunction> harmonicFunctions = tonality.getFunctionsFrom(chromaticChord);
            for (HarmonicFunction harmonicFunction : harmonicFunctions)
                if (harmonicFunctionList.contains(harmonicFunction)) {
                    ret.add(tonality);
                    break;
                }
        }

        return ret;
    }

    public static final Set<TonalityModern> ALL_MAJOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            TonalityModern.C,
            TonalityModern.CC,
            TonalityModern.D,
            TonalityModern.DD,
            TonalityModern.E,
            TonalityModern.F,
            TonalityModern.FF,
            TonalityModern.G,
            TonalityModern.GG,
            TonalityModern.A,
            TonalityModern.AA,
            TonalityModern.B
    )));

    public static final Set<TonalityModern> ALL_MINOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            TonalityModern.Cm,
            TonalityModern.CCm,
            TonalityModern.Dm,
            TonalityModern.DDm,
            TonalityModern.Em,
            TonalityModern.Fm,
            TonalityModern.FFm,
            TonalityModern.Gm,
            TonalityModern.GGm,
            TonalityModern.Am,
            TonalityModern.AAm,
            TonalityModern.Bm
    )));

    public static final Set<TonalityModern> ALL_MAJOR_MINOR = Collections.unmodifiableSet(
            Stream.concat(ALL_MAJOR.stream(), ALL_MINOR.stream())
                    .collect(Collectors.toSet())
    );

    public static final Set<TonalityModern> ALL_DORIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.DORIAN),
            Tonality.from(Chromatic.CC, Scale.DORIAN),
            Tonality.from(Chromatic.D, Scale.DORIAN),
            Tonality.from(Chromatic.DD, Scale.DORIAN),
            Tonality.from(Chromatic.E, Scale.DORIAN),
            Tonality.from(Chromatic.F, Scale.DORIAN),
            Tonality.from(Chromatic.FF, Scale.DORIAN),
            Tonality.from(Chromatic.G, Scale.DORIAN),
            Tonality.from(Chromatic.GG, Scale.DORIAN),
            Tonality.from(Chromatic.A, Scale.DORIAN),
            Tonality.from(Chromatic.AA, Scale.DORIAN),
            Tonality.from(Chromatic.B, Scale.DORIAN)
    )));

    public static final Set<TonalityModern> ALL_PHRYGIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.PHRYGIAN),
            Tonality.from(Chromatic.CC, Scale.PHRYGIAN),
            Tonality.from(Chromatic.D, Scale.PHRYGIAN),
            Tonality.from(Chromatic.DD, Scale.PHRYGIAN),
            Tonality.from(Chromatic.E, Scale.PHRYGIAN),
            Tonality.from(Chromatic.F, Scale.PHRYGIAN),
            Tonality.from(Chromatic.FF, Scale.PHRYGIAN),
            Tonality.from(Chromatic.G, Scale.PHRYGIAN),
            Tonality.from(Chromatic.GG, Scale.PHRYGIAN),
            Tonality.from(Chromatic.A, Scale.PHRYGIAN),
            Tonality.from(Chromatic.AA, Scale.PHRYGIAN),
            Tonality.from(Chromatic.B, Scale.PHRYGIAN)
    )));

    public static final Set<TonalityModern> ALL_LYDIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LYDIAN),
            Tonality.from(Chromatic.CC, Scale.LYDIAN),
            Tonality.from(Chromatic.D, Scale.LYDIAN),
            Tonality.from(Chromatic.DD, Scale.LYDIAN),
            Tonality.from(Chromatic.E, Scale.LYDIAN),
            Tonality.from(Chromatic.F, Scale.LYDIAN),
            Tonality.from(Chromatic.FF, Scale.LYDIAN),
            Tonality.from(Chromatic.G, Scale.LYDIAN),
            Tonality.from(Chromatic.GG, Scale.LYDIAN),
            Tonality.from(Chromatic.A, Scale.LYDIAN),
            Tonality.from(Chromatic.AA, Scale.LYDIAN),
            Tonality.from(Chromatic.B, Scale.LYDIAN)
    )));

    public static final Set<TonalityModern> ALL_MIXOLYDIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.CC, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.D, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.DD, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.E, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.F, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.FF, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.G, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.GG, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.A, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.AA, Scale.MIXOLYDIAN),
            Tonality.from(Chromatic.B, Scale.MIXOLYDIAN)
    )));

    public static final Set<TonalityModern> ALL_LOCRIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LOCRIAN),
            Tonality.from(Chromatic.CC, Scale.LOCRIAN),
            Tonality.from(Chromatic.D, Scale.LOCRIAN),
            Tonality.from(Chromatic.DD, Scale.LOCRIAN),
            Tonality.from(Chromatic.E, Scale.LOCRIAN),
            Tonality.from(Chromatic.F, Scale.LOCRIAN),
            Tonality.from(Chromatic.FF, Scale.LOCRIAN),
            Tonality.from(Chromatic.G, Scale.LOCRIAN),
            Tonality.from(Chromatic.GG, Scale.LOCRIAN),
            Tonality.from(Chromatic.A, Scale.LOCRIAN),
            Tonality.from(Chromatic.AA, Scale.LOCRIAN),
            Tonality.from(Chromatic.B, Scale.LOCRIAN)
    )));

    public static final Set<TonalityModern> ALL_MAJOR_MODES = Collections.unmodifiableSet(
            Stream.concat(ALL_MAJOR.stream(),
                    Stream.concat(ALL_DORIAN.stream(),
                            Stream.concat(ALL_PHRYGIAN.stream(),
                                    Stream.concat(ALL_LYDIAN.stream(),
                                            Stream.concat(ALL_MIXOLYDIAN.stream(),
                                                    Stream.concat(ALL_MINOR.stream(),
                                                            ALL_LOCRIAN.stream()))))))
                    .collect(Collectors.toSet())
    );


    public static final Set<TonalityModern> ALL_HARMONIC_MINOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.CC, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.D, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.DD, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.E, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.F, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.FF, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.G, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.GG, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.A, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.AA, Scale.HARMONIC_MINOR),
            Tonality.from(Chromatic.B, Scale.HARMONIC_MINOR)
    )));

    public static final Set<TonalityModern> ALL_LOCRIAN_H6 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.CC, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.D, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.DD, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.E, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.F, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.FF, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.G, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.GG, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.A, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.AA, Scale.LOCRIAN_a6),
            Tonality.from(Chromatic.B, Scale.LOCRIAN_a6)
    )));

    public static final Set<TonalityModern> ALL_IONIAN_H5 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.IONIAN_a5),
            Tonality.from(Chromatic.CC, Scale.IONIAN_a5),
            Tonality.from(Chromatic.D, Scale.IONIAN_a5),
            Tonality.from(Chromatic.DD, Scale.IONIAN_a5),
            Tonality.from(Chromatic.E, Scale.IONIAN_a5),
            Tonality.from(Chromatic.F, Scale.IONIAN_a5),
            Tonality.from(Chromatic.FF, Scale.IONIAN_a5),
            Tonality.from(Chromatic.G, Scale.IONIAN_a5),
            Tonality.from(Chromatic.GG, Scale.IONIAN_a5),
            Tonality.from(Chromatic.A, Scale.IONIAN_a5),
            Tonality.from(Chromatic.AA, Scale.IONIAN_a5),
            Tonality.from(Chromatic.B, Scale.IONIAN_a5)
    )));

    public static final Set<TonalityModern> ALL_DORIAN_H4 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.DORIAN_a4),
            Tonality.from(Chromatic.CC, Scale.DORIAN_a4),
            Tonality.from(Chromatic.D, Scale.DORIAN_a4),
            Tonality.from(Chromatic.DD, Scale.DORIAN_a4),
            Tonality.from(Chromatic.E, Scale.DORIAN_a4),
            Tonality.from(Chromatic.F, Scale.DORIAN_a4),
            Tonality.from(Chromatic.FF, Scale.DORIAN_a4),
            Tonality.from(Chromatic.G, Scale.DORIAN_a4),
            Tonality.from(Chromatic.GG, Scale.DORIAN_a4),
            Tonality.from(Chromatic.A, Scale.DORIAN_a4),
            Tonality.from(Chromatic.AA, Scale.DORIAN_a4),
            Tonality.from(Chromatic.B, Scale.DORIAN_a4)
    )));

    public static final Set<TonalityModern> ALL_MIXOLIDIAN_b9_b13 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.CC, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.D, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.DD, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.E, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.F, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.FF, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.G, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.GG, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.A, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.AA, Scale.MIXOLIDIAN_b9_b13),
            Tonality.from(Chromatic.B, Scale.MIXOLIDIAN_b9_b13)
    )));

    public static final Set<TonalityModern> ALL_LYDIAN_H2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.CC, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.D, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.DD, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.E, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.F, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.FF, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.G, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.GG, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.A, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.AA, Scale.LYDIAN_a2),
            Tonality.from(Chromatic.B, Scale.LYDIAN_a2)
    )));

    public static final Set<TonalityModern> ALL_SUPERLOCRIAN_bb7 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.CC, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.D, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.DD, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.E, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.F, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.FF, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.G, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.GG, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.A, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.AA, Scale.SUPERLOCRIAN_bb7),
            Tonality.from(Chromatic.B, Scale.SUPERLOCRIAN_bb7)
    )));

    public static final Set<TonalityModern> ALL_HARMONIC_MINOR_MODES = Collections.unmodifiableSet(
            Stream.concat(ALL_HARMONIC_MINOR.stream(),
                    Stream.concat(ALL_LOCRIAN_H6.stream(),
                            Stream.concat(ALL_IONIAN_H5.stream(),
                                    Stream.concat(ALL_DORIAN_H4.stream(),
                                            Stream.concat(ALL_MIXOLIDIAN_b9_b13.stream(),
                                                    Stream.concat(ALL_LYDIAN_H2.stream(),
                                                            ALL_SUPERLOCRIAN_bb7.stream()))))))
                    .collect(Collectors.toSet())
    );

    public static final Set<TonalityModern> ALL_MELODIC_MINOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.CC, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.D, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.DD, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.E, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.F, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.FF, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.G, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.GG, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.A, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.AA, Scale.MELODIC_MINOR),
            Tonality.from(Chromatic.B, Scale.MELODIC_MINOR)
    )));

    public static final Set<TonalityModern> ALL_DORIAN_b2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.DORIAN_b2),
            Tonality.from(Chromatic.CC, Scale.DORIAN_b2),
            Tonality.from(Chromatic.D, Scale.DORIAN_b2),
            Tonality.from(Chromatic.DD, Scale.DORIAN_b2),
            Tonality.from(Chromatic.E, Scale.DORIAN_b2),
            Tonality.from(Chromatic.F, Scale.DORIAN_b2),
            Tonality.from(Chromatic.FF, Scale.DORIAN_b2),
            Tonality.from(Chromatic.G, Scale.DORIAN_b2),
            Tonality.from(Chromatic.GG, Scale.DORIAN_b2),
            Tonality.from(Chromatic.A, Scale.DORIAN_b2),
            Tonality.from(Chromatic.AA, Scale.DORIAN_b2),
            Tonality.from(Chromatic.B, Scale.DORIAN_b2)
    )));

    public static final Set<TonalityModern> ALL_LYDIAN_H5 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.CC, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.D, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.DD, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.E, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.F, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.FF, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.G, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.GG, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.A, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.AA, Scale.LYDIAN_a5),
            Tonality.from(Chromatic.B, Scale.LYDIAN_a5)
    )));

    public static final Set<TonalityModern> ALL_LYDIAN_b7 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.CC, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.D, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.DD, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.E, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.F, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.FF, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.G, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.GG, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.A, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.AA, Scale.LYDIAN_b7),
            Tonality.from(Chromatic.B, Scale.LYDIAN_b7)
    )));

    public static final Set<TonalityModern> ALL_MIXOLIDIAN_b13 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.CC, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.D, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.DD, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.E, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.F, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.FF, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.G, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.GG, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.A, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.AA, Scale.MIXOLIDIAN_b13),
            Tonality.from(Chromatic.B, Scale.MIXOLIDIAN_b13)
    )));

    public static final Set<TonalityModern> ALL_LOCRIAN_H2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.CC, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.D, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.DD, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.E, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.F, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.FF, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.G, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.GG, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.A, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.AA, Scale.LOCRIAN_a2),
            Tonality.from(Chromatic.B, Scale.LOCRIAN_a2)
    )));

    public static final Set<TonalityModern> ALL_SUPERLOCRIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.CC, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.D, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.DD, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.E, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.F, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.FF, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.G, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.GG, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.A, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.AA, Scale.SUPERLOCRIAN),
            Tonality.from(Chromatic.B, Scale.SUPERLOCRIAN)
    )));

    public static final Set<TonalityModern> ALL_MELODIC_MINOR_MODES = Collections.unmodifiableSet(
            Stream.concat(ALL_MELODIC_MINOR.stream(),
                    Stream.concat(ALL_DORIAN_b2.stream(),
                            Stream.concat(ALL_LYDIAN_H5.stream(),
                                    Stream.concat(ALL_LYDIAN_b7.stream(),
                                            Stream.concat(ALL_MIXOLIDIAN_b13.stream(),
                                                    Stream.concat(ALL_LOCRIAN_H2.stream(),
                                                            ALL_SUPERLOCRIAN.stream()))))))
                    .collect(Collectors.toSet())
    );

    public static final Set<TonalityModern> ALL_HARMONIC_MAJOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.CC, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.D, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.DD, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.E, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.F, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.FF, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.G, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.GG, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.A, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.AA, Scale.HARMONIC_MAJOR),
            Tonality.from(Chromatic.B, Scale.HARMONIC_MAJOR)
    )));

    public static final Set<TonalityModern> ALL_DORIAN_b5 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.DORIAN_b5),
            Tonality.from(Chromatic.CC, Scale.DORIAN_b5),
            Tonality.from(Chromatic.D, Scale.DORIAN_b5),
            Tonality.from(Chromatic.DD, Scale.DORIAN_b5),
            Tonality.from(Chromatic.E, Scale.DORIAN_b5),
            Tonality.from(Chromatic.F, Scale.DORIAN_b5),
            Tonality.from(Chromatic.FF, Scale.DORIAN_b5),
            Tonality.from(Chromatic.G, Scale.DORIAN_b5),
            Tonality.from(Chromatic.GG, Scale.DORIAN_b5),
            Tonality.from(Chromatic.A, Scale.DORIAN_b5),
            Tonality.from(Chromatic.AA, Scale.DORIAN_b5),
            Tonality.from(Chromatic.B, Scale.DORIAN_b5)
    )));

    public static final Set<TonalityModern> ALL_PHRYGIAN_b4 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.CC, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.D, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.DD, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.E, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.F, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.FF, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.G, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.GG, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.A, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.AA, Scale.PHRYGIAN_b4),
            Tonality.from(Chromatic.B, Scale.PHRYGIAN_b4)
    )));

    public static final Set<TonalityModern> ALL_LYDIAN_b3 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.CC, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.D, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.DD, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.E, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.F, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.FF, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.G, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.GG, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.A, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.AA, Scale.LYDIAN_b3),
            Tonality.from(Chromatic.B, Scale.LYDIAN_b3)
    )));

    public static final Set<TonalityModern> ALL_MIXOLYDIAN_b2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.CC, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.D, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.DD, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.E, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.F, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.FF, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.G, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.GG, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.A, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.AA, Scale.MIXOLYDIAN_b2),
            Tonality.from(Chromatic.B, Scale.MIXOLYDIAN_b2)
    )));

    public static final Set<TonalityModern> ALL_AEOLIAN_b1 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.CC, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.D, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.DD, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.E, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.F, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.FF, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.G, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.GG, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.A, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.AA, Scale.AEOLIAN_b1),
            Tonality.from(Chromatic.B, Scale.AEOLIAN_b1)
    )));

    public static final Set<TonalityModern> ALL_LOCRIAN_bb7 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.CC, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.D, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.DD, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.E, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.F, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.FF, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.G, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.GG, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.A, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.AA, Scale.LOCRIAN_bb7),
            Tonality.from(Chromatic.B, Scale.LOCRIAN_bb7)
    )));

    public static final Set<TonalityModern> ALL_HARMONIC_MAJOR_MODES = Collections.unmodifiableSet(
            Stream.concat(ALL_HARMONIC_MAJOR.stream(),
                    Stream.concat(ALL_DORIAN_b5.stream(),
                            Stream.concat(ALL_PHRYGIAN_b4.stream(),
                                    Stream.concat(ALL_LYDIAN_b3.stream(),
                                            Stream.concat(ALL_MIXOLYDIAN_b2.stream(),
                                                    Stream.concat(ALL_AEOLIAN_b1.stream(),
                                                            ALL_LOCRIAN_bb7.stream()))))))
                    .collect(Collectors.toSet())
    );

    public static final Set<TonalityModern> ALL_DOUBLE_HARMONIC = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.CC, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.D, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.DD, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.E, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.F, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.FF, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.G, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.GG, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.A, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.AA, Scale.DOUBLE_HARMONIC),
            Tonality.from(Chromatic.B, Scale.DOUBLE_HARMONIC)
    )));

    public static final Set<TonalityModern> ALL_LYDIAN_H2_H6 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.CC, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.D, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.DD, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.E, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.F, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.FF, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.G, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.GG, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.A, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.AA, Scale.LYDIAN_a2_a6),
            Tonality.from(Chromatic.B, Scale.LYDIAN_a2_a6)
    )));

    public static final Set<TonalityModern> ALL_ULTRAPHRYGIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.CC, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.D, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.DD, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.E, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.F, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.FF, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.G, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.GG, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.A, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.AA, Scale.ULTRAPHRYGIAN),
            Tonality.from(Chromatic.B, Scale.ULTRAPHRYGIAN)
    )));

    public static final Set<TonalityModern> ALL_HUNGARIAN_MINOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.CC, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.D, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.DD, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.E, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.F, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.FF, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.G, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.GG, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.A, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.AA, Scale.HUNGARIAN_MINOR),
            Tonality.from(Chromatic.B, Scale.HUNGARIAN_MINOR)
    )));

    public static final Set<TonalityModern> ALL_ORIENTAL = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.ORIENTAL),
            Tonality.from(Chromatic.CC, Scale.ORIENTAL),
            Tonality.from(Chromatic.D, Scale.ORIENTAL),
            Tonality.from(Chromatic.DD, Scale.ORIENTAL),
            Tonality.from(Chromatic.E, Scale.ORIENTAL),
            Tonality.from(Chromatic.F, Scale.ORIENTAL),
            Tonality.from(Chromatic.FF, Scale.ORIENTAL),
            Tonality.from(Chromatic.G, Scale.ORIENTAL),
            Tonality.from(Chromatic.GG, Scale.ORIENTAL),
            Tonality.from(Chromatic.A, Scale.ORIENTAL),
            Tonality.from(Chromatic.AA, Scale.ORIENTAL),
            Tonality.from(Chromatic.B, Scale.ORIENTAL)
    )));

    public static final Set<TonalityModern> ALL_IONIAN_AUGMENTED_H2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.CC, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.D, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.DD, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.E, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.F, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.FF, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.G, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.GG, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.A, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.AA, Scale.IONIAN_AUGMENTED_a2),
            Tonality.from(Chromatic.B, Scale.IONIAN_AUGMENTED_a2)
    )));

    public static final Set<TonalityModern> ALL_LOCRIAN_bb3_bb7 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.from(Chromatic.C, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.CC, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.D, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.DD, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.E, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.F, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.FF, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.G, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.GG, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.A, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.AA, Scale.LOCRIAN_bb3_bb7),
            Tonality.from(Chromatic.B, Scale.LOCRIAN_bb3_bb7)
    )));

    public static final Set<TonalityModern> ALL_DOUBLE_HARMONIC_MODES = Collections.unmodifiableSet(
            Stream.concat(ALL_DOUBLE_HARMONIC.stream(),
                    Stream.concat(ALL_LYDIAN_H2_H6.stream(),
                            Stream.concat(ALL_ULTRAPHRYGIAN.stream(),
                                    Stream.concat(ALL_HUNGARIAN_MINOR.stream(),
                                            Stream.concat(ALL_ORIENTAL.stream(),
                                                    Stream.concat(ALL_IONIAN_AUGMENTED_H2.stream(),
                                                            ALL_LOCRIAN_bb3_bb7.stream()))))))
                    .collect(Collectors.toSet())
    );

    /*
     *   END CONSTANTS
     */

    private TonalityRetrieval() {
    }

    public static @NonNull List<TonalityClassical> allUsualKeysDiatonicAlt() {
        List<TonalityClassical> ret = new ArrayList<>();
        List<DiatonicAlt> diatonicAltList = DiatonicAltRetrieval.listFromAlterations(1);
        diatonicAltList.sort(Comparator.comparing(DiatonicAlt::getDiatonic));
        for (Scale mode : Scale.allUsualScales())
            for ( DiatonicAlt diatonicAlt : diatonicAltList ) {
                TonalityClassical tonality = Tonality.from( diatonicAlt, mode );
                ret.add(tonality);
            }

        return ret;
    }

    public static @NonNull List<TonalityModern> allUsualKeys() {
        List<TonalityModern> ret = new ArrayList<>();
        for (Scale mode : Scale.allUsualScales())
            for ( Chromatic chromatic : Chromatic.values() ) {
                TonalityModern tonality = Tonality.from( chromatic, mode );
                ret.add(tonality);
            }

        return ret;
    }

    // todo: DiatonicAltChord
/*
    @SuppressWarnings("WeakerAccess")
    public static @NonNull List<TonalityModern> listFromChordDiatonicFunction(@NonNull ChromaticChord c) {
        List<TonalityModern> out = new ArrayList<>();
        for (TonalityModern t : TonalityRetrieval.allUsualKeys()) {
            if (t.containsAll(c))
                out.addAll( t );
        }

        return out;
    }
*/
    @SuppressWarnings("WeakerAccess")
    public static @Nullable TonalityModern listFromChordFirst(@NonNull ChromaticChord c) {
        for (TonalityModern t : TonalityRetrieval.allUsualKeys()) {
            if (t.containsAll(c))
                return t;
        }

        return null;
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull List<TonalityModern> listFromChordAllFunctions(@NonNull ChromaticChord chromaticChord) {
        List<TonalityModern> out = new ArrayList<>();
        for (TonalityModern tonality : TonalityRetrieval.allUsualKeys()) {
            if (tonality.getFunctionsFrom(chromaticChord).size() > 0)
                out.add( tonality );
        }

        return out;
    }

    static @NonNull TonalityModern fromDiatonicChordMidi(@NonNull ChromaticChord c, @NonNull TonalityClassical base) {
        if ( base.size() != 7 )
            throw new RuntimeException( "No tiene 7 notas la escala" );

        Chromatic[] notesChord = new Chromatic[c.size()];
        for ( int i = 0; i < c.size(); i++ )
            notesChord[i] = c.get(i);

        int posChordCorrector = 7 - c.get(0).ordinal();

        // Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
        Diatonic diatonic = base.getNotes().get(0).getDiatonic();
        int posBaseCorrector = (diatonic.ordinal()
                - base.getRoot().getDiatonic().ordinal() + 7) % 7;

        Chromatic[] tonalityNotes = new Chromatic[7];
        for ( int i = 0; i < 7; i++ ) {
            int pos = ( posBaseCorrector + i ) % DiatonicDegree.values().length;
            DiatonicDegree diatonicDegree = DiatonicDegree.values()[pos];

            boolean notFound = true;
            for ( int j = 0; j < notesChord.length; j++ ) {
                int index = (c.get(j).ordinal() + posChordCorrector) % base.getScale().size();
                if (index == i) {
                    tonalityNotes[i] = notesChord[j];
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                try {
                    tonalityNotes[i] = Chromatic.from( base.getNote(diatonicDegree) );
                } catch (ScaleRelativeDegreeException e) {
                    throw NeverHappensException.make("Las escalas diatónicas tienen todos los DiatonicDegree");
                }
            }
        }

        List<DiatonicAlt> diatonicAltList = new ArrayList<>();
        for (Chromatic chromatic : tonalityNotes)
            diatonicAltList.add( DiatonicAlt.from(chromatic) );
        Scale scale = Scale.fromDiatonicAlt(diatonicAltList);
        return Tonality.from(notesChord[0], scale);
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull Set<TonalityClassical> getEnharmonicFrom(@NonNull TonalityClassical tonality, int maxAlterations) {
        Set<TonalityClassical> ret = new HashSet<>();
        Set<DiatonicAlt> possibleRootList = DiatonicAltRetrieval.getEnharmonicsFrom(tonality.getRoot(), maxAlterations);

        for (DiatonicAlt diatonicAlt : possibleRootList) {
            TonalityClassical currentTonality = Tonality.from(diatonicAlt, tonality.getScale());
            ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static @NonNull Set<TonalityClassical> getEnharmonicMinimalTonalityAltsFrom(@NonNull TonalityClassical tonalityBase) {
        Set<TonalityClassical> ret = new HashSet<>();

        Set<TonalityClassical> enharmonicTonalities = getEnharmonicFrom(tonalityBase, 3);

        int minAlts = Integer.MAX_VALUE;
        for (TonalityClassical currentTonality : enharmonicTonalities) {
            int currentAlts = currentTonality.getDiatonicAlterationsNumber();
            if (currentAlts < minAlts) {
                ret.clear();
                minAlts = currentAlts;
                ret.add(currentTonality);
            } else if (currentAlts == minAlts )
                ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static @NonNull Set<TonalityClassical> getEnharmonicMinimalTonalityNoteAltsFrom(@NonNull TonalityClassical tonalityBase) {
        Set<TonalityClassical> ret = new HashSet<>();

        Set<TonalityClassical> enharmonicTonalities = getEnharmonicFrom(tonalityBase, 3);

        int minAlts = Integer.MAX_VALUE;
        int maxAltsNote = Integer.MAX_VALUE;
        for (TonalityClassical currentTonality : enharmonicTonalities) {
            int currentAlts = currentTonality.getDiatonicAlterationsNumber();
            if (currentAlts < minAlts || currentAlts == minAlts && currentTonality.getMaxAltsNote() < maxAltsNote) {
                ret.clear();
                minAlts = currentAlts;
                maxAltsNote = currentTonality.getMaxAltsNote();
                ret.add(currentTonality);
            } else if (currentAlts == minAlts && currentTonality.getMaxAltsNote() == maxAltsNote )
                ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static @NonNull Set<TonalityClassical> getEnharmonicMinimalNoteAltsFrom(@NonNull TonalityClassical tonalityBase) {
        Set<TonalityClassical> ret = new HashSet<>();

        Set<TonalityClassical> enharmonicTonalities = getEnharmonicFrom(tonalityBase, 3);

        int maxAltsNote = Integer.MAX_VALUE;
        for (TonalityClassical currentTonality : enharmonicTonalities) {
            int currentMaxAltsNote = currentTonality.getMaxAltsNote();
            if (currentMaxAltsNote < maxAltsNote) {
                ret.clear();
                maxAltsNote = currentMaxAltsNote;
                ret.add(currentTonality);
            } else if (currentMaxAltsNote == maxAltsNote )
                ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static @Nullable Tonality getRelativeMinorFrom(@NonNull Tonality tonality) {
        return getRelativeFrom(tonality, Scale.MINOR);
    }

    public static @Nullable Tonality getRelativeMajorFrom(@NonNull Tonality tonality) {
        return getRelativeFrom(tonality, Scale.MAJOR);
    }

    private static @Nullable Tonality getRelativeFrom(@NonNull Tonality tonalityBase, @NonNull Scale scale) {
        Objects.requireNonNull(tonalityBase);
        Objects.requireNonNull(scale);

        if (tonalityBase.getScale().equals(scale))
            return tonalityBase;

        List<Tonality> modes = tonalityBase.getParallelModes();
        for ( Tonality tonality : modes )
            if ( tonality.getScale().equals( scale ) )
                return tonality;

        return null;
    }

}
