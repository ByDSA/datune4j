package es.danisales.datune.tonality;

import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.chords.DiatonicAltRetrieval;
import es.danisales.datune.chords.PitchChromaticChord;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicChordMidiBuilder;
import es.danisales.datune.midi.DiatonicChordMidiInfo;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;

public class TonalityRetrieval {
    public static class ET12 {
        public static final Set<Tonality> ALL_MAJOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.C,
                Tonality.Db,
                Tonality.D,
                Tonality.Eb,
                Tonality.E,
                Tonality.F,
                Tonality.Gb,
                Tonality.G,
                Tonality.Ab,
                Tonality.A,
                Tonality.Bb,
                Tonality.B
        )));

        public static final Set<Tonality> ALL_MINOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.Cm,
                Tonality.CCm,
                Tonality.Dm,
                Tonality.Ebm,
                Tonality.Em,
                Tonality.Fm,
                Tonality.FFm,
                Tonality.Gm,
                Tonality.GGm,
                Tonality.Am,
                Tonality.Bbm,
                Tonality.Bm
        )));

        public static final Set<Tonality> ALL_MAJOR_MINOR = Collections.unmodifiableSet(
                Stream.concat(ALL_MAJOR.stream(), ALL_MINOR.stream())
                        .collect(Collectors.toSet())
        );

        public static final Set<Tonality> ALL_DORIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.DORIAN),
                Tonality.from(DiatonicAlt.CC, Scale.DORIAN),
                Tonality.from(DiatonicAlt.D, Scale.DORIAN),
                Tonality.from(DiatonicAlt.DD, Scale.DORIAN),
                Tonality.from(DiatonicAlt.E, Scale.DORIAN),
                Tonality.from(DiatonicAlt.F, Scale.DORIAN),
                Tonality.from(DiatonicAlt.FF, Scale.DORIAN),
                Tonality.from(DiatonicAlt.G, Scale.DORIAN),
                Tonality.from(DiatonicAlt.GG, Scale.DORIAN),
                Tonality.from(DiatonicAlt.A, Scale.DORIAN),
                Tonality.from(DiatonicAlt.AA, Scale.DORIAN),
                Tonality.from(DiatonicAlt.B, Scale.DORIAN)
        )));

        public static final Set<Tonality> ALL_PHRYGIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.CC, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.D, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.DD, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.E, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.F, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.FF, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.G, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.GG, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.A, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.AA, Scale.PHRYGIAN),
                Tonality.from(DiatonicAlt.B, Scale.PHRYGIAN)
        )));

        public static final Set<Tonality> ALL_LYDIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.CC, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.D, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.DD, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.E, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.F, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.FF, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.G, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.GG, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.A, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.AA, Scale.LYDIAN),
                Tonality.from(DiatonicAlt.B, Scale.LYDIAN)
        )));

        public static final Set<Tonality> ALL_MIXOLYDIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.CC, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.D, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.DD, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.E, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.F, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.FF, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.G, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.GG, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.A, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.AA, Scale.MIXOLYDIAN),
                Tonality.from(DiatonicAlt.B, Scale.MIXOLYDIAN)
        )));

        public static final Set<Tonality> ALL_LOCRIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.CC, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.D, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.DD, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.E, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.F, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.FF, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.G, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.GG, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.A, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.AA, Scale.LOCRIAN),
                Tonality.from(DiatonicAlt.B, Scale.LOCRIAN)
        )));

        public static final Set<Tonality> ALL_MAJOR_MODES = Collections.unmodifiableSet(
                Stream.concat(ALL_MAJOR.stream(),
                        Stream.concat(ALL_DORIAN.stream(),
                                Stream.concat(ALL_PHRYGIAN.stream(),
                                        Stream.concat(ALL_LYDIAN.stream(),
                                                Stream.concat(ALL_MIXOLYDIAN.stream(),
                                                        Stream.concat(ALL_MINOR.stream(),
                                                                ALL_LOCRIAN.stream()))))))
                        .collect(Collectors.toSet())
        );


        public static final Set<Tonality> ALL_HARMONIC_MINOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.CC, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.D, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.DD, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.E, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.F, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.FF, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.G, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.GG, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.A, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.AA, Scale.HARMONIC_MINOR),
                Tonality.from(DiatonicAlt.B, Scale.HARMONIC_MINOR)
        )));

        public static final Set<Tonality> ALL_LOCRIAN_H6 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.CC, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.D, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.DD, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.E, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.F, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.FF, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.G, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.GG, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.A, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.AA, Scale.LOCRIAN_H6),
                Tonality.from(DiatonicAlt.B, Scale.LOCRIAN_H6)
        )));

        public static final Set<Tonality> ALL_IONIAN_H5 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.CC, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.D, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.DD, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.E, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.F, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.FF, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.G, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.GG, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.A, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.AA, Scale.IONIAN_H5),
                Tonality.from(DiatonicAlt.B, Scale.IONIAN_H5)
        )));

        public static final Set<Tonality> ALL_DORIAN_H4 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.CC, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.D, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.DD, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.E, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.F, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.FF, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.G, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.GG, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.A, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.AA, Scale.DORIAN_H4),
                Tonality.from(DiatonicAlt.B, Scale.DORIAN_H4)
        )));

        public static final Set<Tonality> ALL_MIXOLIDIAN_b9_b13 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.CC, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.D, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.DD, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.E, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.F, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.FF, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.G, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.GG, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.A, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.AA, Scale.MIXOLIDIAN_b9_b13),
                Tonality.from(DiatonicAlt.B, Scale.MIXOLIDIAN_b9_b13)
        )));

        public static final Set<Tonality> ALL_LYDIAN_H2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.CC, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.D, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.DD, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.E, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.F, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.FF, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.G, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.GG, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.A, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.AA, Scale.LYDIAN_H2),
                Tonality.from(DiatonicAlt.B, Scale.LYDIAN_H2)
        )));

        public static final Set<Tonality> ALL_SUPERLOCRIAN_bb7 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.CC, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.D, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.DD, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.E, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.F, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.FF, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.G, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.GG, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.A, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.AA, Scale.SUPERLOCRIAN_bb7),
                Tonality.from(DiatonicAlt.B, Scale.SUPERLOCRIAN_bb7)
        )));

        public static final Set<Tonality> ALL_HARMONIC_MINOR_MODES = Collections.unmodifiableSet(
                Stream.concat(ALL_HARMONIC_MINOR.stream(),
                        Stream.concat(ALL_LOCRIAN_H6.stream(),
                                Stream.concat(ALL_IONIAN_H5.stream(),
                                        Stream.concat(ALL_DORIAN_H4.stream(),
                                                Stream.concat(ALL_MIXOLIDIAN_b9_b13.stream(),
                                                        Stream.concat(ALL_LYDIAN_H2.stream(),
                                                                ALL_SUPERLOCRIAN_bb7.stream()))))))
                        .collect(Collectors.toSet())
        );

        public static final Set<Tonality> ALL_MELODIC_MINOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.CC, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.D, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.DD, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.E, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.F, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.FF, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.G, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.GG, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.A, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.AA, Scale.MELODIC_MINOR),
                Tonality.from(DiatonicAlt.B, Scale.MELODIC_MINOR)
        )));

        public static final Set<Tonality> ALL_DORIAN_b2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.CC, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.D, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.DD, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.E, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.F, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.FF, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.G, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.GG, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.A, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.AA, Scale.DORIAN_b2),
                Tonality.from(DiatonicAlt.B, Scale.DORIAN_b2)
        )));

        public static final Set<Tonality> ALL_LYDIAN_H5 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.CC, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.D, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.DD, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.E, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.F, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.FF, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.G, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.GG, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.A, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.AA, Scale.LYDIAN_H5),
                Tonality.from(DiatonicAlt.B, Scale.LYDIAN_H5)
        )));

        public static final Set<Tonality> ALL_LYDIAN_b7 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.CC, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.D, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.DD, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.E, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.F, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.FF, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.G, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.GG, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.A, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.AA, Scale.LYDIAN_b7),
                Tonality.from(DiatonicAlt.B, Scale.LYDIAN_b7)
        )));

        public static final Set<Tonality> ALL_MIXOLIDIAN_b13 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.CC, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.D, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.DD, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.E, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.F, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.FF, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.G, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.GG, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.A, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.AA, Scale.MIXOLIDIAN_b13),
                Tonality.from(DiatonicAlt.B, Scale.MIXOLIDIAN_b13)
        )));

        public static final Set<Tonality> ALL_LOCRIAN_H2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.CC, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.D, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.DD, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.E, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.F, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.FF, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.G, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.GG, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.A, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.AA, Scale.LOCRIAN_H2),
                Tonality.from(DiatonicAlt.B, Scale.LOCRIAN_H2)
        )));

        public static final Set<Tonality> ALL_SUPERLOCRIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.CC, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.D, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.DD, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.E, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.F, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.FF, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.G, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.GG, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.A, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.AA, Scale.SUPERLOCRIAN),
                Tonality.from(DiatonicAlt.B, Scale.SUPERLOCRIAN)
        )));

        public static final Set<Tonality> ALL_MELODIC_MINOR_MODES = Collections.unmodifiableSet(
                Stream.concat(ALL_MELODIC_MINOR.stream(),
                        Stream.concat(ALL_DORIAN_b2.stream(),
                                Stream.concat(ALL_LYDIAN_H5.stream(),
                                        Stream.concat(ALL_LYDIAN_b7.stream(),
                                                Stream.concat(ALL_MIXOLIDIAN_b13.stream(),
                                                        Stream.concat(ALL_LOCRIAN_H2.stream(),
                                                                ALL_SUPERLOCRIAN.stream()))))))
                        .collect(Collectors.toSet())
        );

        public static final Set<Tonality> ALL_HARMONIC_MAJOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.CC, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.D, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.DD, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.E, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.F, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.FF, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.G, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.GG, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.A, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.AA, Scale.HARMONIC_MAJOR),
                Tonality.from(DiatonicAlt.B, Scale.HARMONIC_MAJOR)
        )));

        public static final Set<Tonality> ALL_DORIAN_b5 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.CC, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.D, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.DD, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.E, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.F, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.FF, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.G, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.GG, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.A, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.AA, Scale.DORIAN_b5),
                Tonality.from(DiatonicAlt.B, Scale.DORIAN_b5)
        )));

        public static final Set<Tonality> ALL_PHRYGIAN_b4 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.CC, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.D, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.DD, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.E, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.F, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.FF, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.G, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.GG, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.A, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.AA, Scale.PHRYGIAN_b4),
                Tonality.from(DiatonicAlt.B, Scale.PHRYGIAN_b4)
        )));

        public static final Set<Tonality> ALL_LYDIAN_b3 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.CC, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.D, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.DD, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.E, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.F, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.FF, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.G, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.GG, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.A, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.AA, Scale.LYDIAN_b3),
                Tonality.from(DiatonicAlt.B, Scale.LYDIAN_b3)
        )));

        public static final Set<Tonality> ALL_MIXOLYDIAN_b2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.CC, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.D, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.DD, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.E, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.F, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.FF, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.G, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.GG, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.A, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.AA, Scale.MIXOLYDIAN_b2),
                Tonality.from(DiatonicAlt.B, Scale.MIXOLYDIAN_b2)
        )));

        public static final Set<Tonality> ALL_AEOLIAN_b1 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.CC, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.D, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.DD, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.E, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.F, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.FF, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.G, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.GG, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.A, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.AA, Scale.AEOLIAN_b1),
                Tonality.from(DiatonicAlt.B, Scale.AEOLIAN_b1)
        )));

        public static final Set<Tonality> ALL_LOCRIAN_bb7 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.CC, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.D, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.DD, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.E, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.F, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.FF, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.G, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.GG, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.A, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.AA, Scale.LOCRIAN_bb7),
                Tonality.from(DiatonicAlt.B, Scale.LOCRIAN_bb7)
        )));

        public static final Set<Tonality> ALL_HARMONIC_MAJOR_MODES = Collections.unmodifiableSet(
                Stream.concat(ALL_HARMONIC_MAJOR.stream(),
                        Stream.concat(ALL_DORIAN_b5.stream(),
                                Stream.concat(ALL_PHRYGIAN_b4.stream(),
                                        Stream.concat(ALL_LYDIAN_b3.stream(),
                                                Stream.concat(ALL_MIXOLYDIAN_b2.stream(),
                                                        Stream.concat(ALL_AEOLIAN_b1.stream(),
                                                                ALL_LOCRIAN_bb7.stream()))))))
                        .collect(Collectors.toSet())
        );

        public static final Set<Tonality> ALL_DOUBLE_HARMONIC = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.CC, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.D, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.DD, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.E, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.F, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.FF, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.G, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.GG, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.A, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.AA, Scale.DOUBLE_HARMONIC),
                Tonality.from(DiatonicAlt.B, Scale.DOUBLE_HARMONIC)
        )));

        public static final Set<Tonality> ALL_LYDIAN_H2_H6 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.CC, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.D, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.DD, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.E, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.F, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.FF, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.G, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.GG, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.A, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.AA, Scale.LYDIAN_H2_H6),
                Tonality.from(DiatonicAlt.B, Scale.LYDIAN_H2_H6)
        )));

        public static final Set<Tonality> ALL_ULTRAPHRYGIAN = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.CC, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.D, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.DD, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.E, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.F, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.FF, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.G, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.GG, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.A, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.AA, Scale.ULTRAPHRYGIAN),
                Tonality.from(DiatonicAlt.B, Scale.ULTRAPHRYGIAN)
        )));

        public static final Set<Tonality> ALL_HUNGARIAN_MINOR = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.CC, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.D, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.DD, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.E, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.F, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.FF, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.G, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.GG, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.A, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.AA, Scale.HUNGARIAN_MINOR),
                Tonality.from(DiatonicAlt.B, Scale.HUNGARIAN_MINOR)
        )));

        public static final Set<Tonality> ALL_ORIENTAL = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.CC, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.D, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.DD, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.E, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.F, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.FF, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.G, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.GG, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.A, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.AA, Scale.ORIENTAL),
                Tonality.from(DiatonicAlt.B, Scale.ORIENTAL)
        )));

        public static final Set<Tonality> ALL_IONIAN_AUGMENTED_H2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.CC, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.D, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.DD, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.E, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.F, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.FF, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.G, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.GG, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.A, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.AA, Scale.IONIAN_AUGMENTED_H2),
                Tonality.from(DiatonicAlt.B, Scale.IONIAN_AUGMENTED_H2)
        )));

        public static final Set<Tonality> ALL_LOCRIAN_bb3_bb7 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                Tonality.from(DiatonicAlt.C, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.CC, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.D, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.DD, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.E, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.F, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.FF, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.G, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.GG, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.A, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.AA, Scale.LOCRIAN_bb3_bb7),
                Tonality.from(DiatonicAlt.B, Scale.LOCRIAN_bb3_bb7)
        )));

        public static final Set<Tonality> ALL_DOUBLE_HARMONIC_MODES = Collections.unmodifiableSet(
                Stream.concat(ALL_DOUBLE_HARMONIC.stream(),
                        Stream.concat(ALL_LYDIAN_H2_H6.stream(),
                                Stream.concat(ALL_ULTRAPHRYGIAN.stream(),
                                        Stream.concat(ALL_HUNGARIAN_MINOR.stream(),
                                                Stream.concat(ALL_ORIENTAL.stream(),
                                                        Stream.concat(ALL_IONIAN_AUGMENTED_H2.stream(),
                                                                ALL_LOCRIAN_bb3_bb7.stream()))))))
                        .collect(Collectors.toSet())
        );
    }

    private TonalityRetrieval() {
    }

    public static @NonNull List<Tonality> allUsualKeys() {
        List<Tonality> ret = new ArrayList<>();
        List<DiatonicAlt> diatonicAltList = DiatonicAltRetrieval.listFromAlterations(1);
        diatonicAltList.sort(Comparator.comparing(DiatonicAlt::getDiatonic));
        for (Scale mode : Scale.allUsualScales())
            for ( DiatonicAlt diatonicAlt : diatonicAltList ) {
                Tonality tonality = Tonality.from( diatonicAlt, mode );
                ret.add(tonality);
            }

        return ret;
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull List<Tonality> listFromChordDiatonicFunction(@NonNull ChromaticChord c) {
        List<Tonality> out = new ArrayList<>();
        for (Tonality t : TonalityRetrieval.allUsualKeys()) {
            if (t.containsAll(c))
                out.add( t );
        }

        return out;
    }

    @SuppressWarnings("WeakerAccess")
    public static @Nullable Tonality listFromChordFirst(@NonNull ChromaticChord c) {
        for (Tonality t : TonalityRetrieval.allUsualKeys()) {
            if (t.containsAll(c))
                return t;
        }

        return null;
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull List<Tonality> listFromChordAllFunctions(@NonNull ChromaticChord c) {
        List<Tonality> out = new ArrayList<>();
        for (Tonality t : TonalityRetrieval.allUsualKeys()) {
            if (TonalityUtils.hasAsChromaticFunction(t, c))
                out.add( t );
        }

        return out;
    }

    static @NonNull Tonality<DiatonicAlt> fromDiatonicChordMidi(@NonNull DiatonicChordMidi c, @NonNull Tonality<DiatonicAlt> base) {
        if ( base.size() != 7 )
            throw new RuntimeException( "No tiene 7 notas la escala" );

        DiatonicAlt[] notesChord = new DiatonicAlt[c.size()];
        for ( int i = 0; i < c.size(); i++ )
            notesChord[i] = (DiatonicAlt)c.get(i).getPitch().getDiatonicAlt();

        int posChordCorrector = 7 - c.get(0).getPitch().getDegree().ordinal();

        // Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
        int posBaseCorrector = (notesChord[0].getDiatonic().ordinal()
                - base.getRoot().getDiatonic().ordinal() + 7) % 7;

        DiatonicAlt[] tonalityNotes = new DiatonicAlt[7];
        for ( int i = 0; i < 7; i++ ) {
            int pos = ( posBaseCorrector + i ) % DiatonicDegree.values().length;
            DiatonicDegree diatonicDegree = DiatonicDegree.values()[pos];

            boolean notFound = true;
            for ( int j = 0; j < notesChord.length; j++ ) {
                int index = (c.get(j).getPitch().getDegree().ordinal() + posChordCorrector) % base.getScale().size();
                if (index == i) {
                    tonalityNotes[i] = notesChord[j];
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                try {
                    tonalityNotes[i] = base.getNote(diatonicDegree);
                } catch (ScaleRelativeDegreeException e) {
                    throw NeverHappensException.make("Las escalas diatónicas tienen todos los DiatonicDegree");
                }
            }
        }

        List<DiatonicAlt> notes = Arrays.asList(tonalityNotes);
        Scale scale = Scale.fromDiatonicAlt(notes);
        return Tonality.from(notesChord[0], scale);
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull Set<Tonality> getEnharmonicFrom(@NonNull Tonality<DiatonicAlt> tonality, int maxAlterations) {
        Set<Tonality> ret = new HashSet<>();
        Set<DiatonicAlt> possibleRootList = DiatonicAltRetrieval.getEnharmonicsFrom(tonality.getRoot(), maxAlterations);

        for (DiatonicAlt diatonicAlt : possibleRootList) {
            Tonality currentTonality = Tonality.from(diatonicAlt, tonality.getScale());
            ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static @NonNull Set<Tonality> getEnharmonicMinimalAltsFrom(@NonNull Tonality tonalityBase) {
        Set<Tonality> ret = new HashSet<>();

        Set<Tonality> enharmonicTonalities = getEnharmonicFrom(tonalityBase, 3);

        int minAlts = Integer.MAX_VALUE;
        for (Tonality currentTonality : enharmonicTonalities) {
            int currentAlts = currentTonality.getDiatonicAlterationsNumber();
            if (currentAlts < minAlts) {
                ret.clear();
                minAlts = currentAlts;
                ret.add(currentTonality);
            } else if (currentAlts == minAlts)
                ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static @NonNull List<Tonality> getFromChords(boolean outScale, @NonNull List<ChromaticChord> chords) {
        checkArgument(chords.size() > 0);
        List<Tonality> candidates = new ArrayList<>();

        boolean first = true;
        for (ChromaticChord chord : chords) {
            if ( chord.isEmpty() )
                continue;
            ChromaticChord chordCopy = chord.clone();

            List<Tonality> candidatesPrev = candidates;

            do {
                List<DiatonicChordMidiInfo> possibleChords = DiatonicChordMidiBuilder.fromChromaticChord(
                        chordCopy,
                        outScale
                );
                if ( first ) {
                    for (DiatonicChordMidiInfo c : possibleChords) {
                        Tonality t = c.getParametricChord().getTonality();
                        if ( !candidates.contains( t ) )
                            candidates.add( t );
                    }
                    first = false;
                } else {
                    candidates = new ArrayList<>();

                    for (DiatonicChordMidiInfo c : possibleChords) {
                        for ( Tonality t : candidatesPrev )
                            if ((c.getParametricChord().getTonality().equals(t)
                                    || c.getParametricChord().getTonality().isModeOf( t ) )
                                    && !candidates.contains( t ) )
                                candidates.add( t );
                    }
                }

                if ( candidates.isEmpty() ) {
                    chordCopy = ChromaticChord.builder()
                            .addAll(
                                    chordCopy.subList(0, chordCopy.size() - 1)
                            ).build();
                }
            } while ( candidates.isEmpty() && !chordCopy.isEmpty() );
        }

        return candidates;
    }

    public static Tonality searchInModeSameRoot(Tonality tonality, PitchChromaticChord c) {
        List<Tonality> ts;
        if ( tonality.getScale().isDiatonic() ) {
            ts = new ArrayList<>();
            ts.add( Tonality.from( tonality.getRoot(), Scale.MAJOR ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.MINOR ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.DORIAN ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.PHRYGIAN ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.LYDIAN ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.MIXOLYDIAN ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.LOCRIAN ) );
        } else
            ts = tonality.getModesSameRoot();

        for ( Tonality t : ts ) {
            if ( t.equals( tonality ) )
                continue;
            ChromaticChord chromaticChord = ChromaticChord.builder().fromChromaticMidi(c).build();
            DiatonicFunction diatonicFunction = DiatonicFunction.from(chromaticChord, t);
            if (diatonicFunction != null)
                return t;
        }

        return null;
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

        List<Tonality> modes = tonalityBase.getModes();
        for ( Tonality tonality : modes )
            if ( tonality.getScale().equals( scale ) )
                return tonality;

        return null;
    }

}
