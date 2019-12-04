package es.danisales.datune.interval;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.musical.Quality;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public enum IntervalChromatic implements Interval {
    PERFECT_UNISON(0, Quality.PERFECT), DIMINISHED_SECOND(0, Quality.DIMINISHED),
    MINOR_SECOND(1, Quality.MINOR), AUGMENTED_UNISON(1, Quality.AUGMENTED),
    MAJOR_SECOND(2, Quality.MAJOR), DIMINISHED_THIRD(2, Quality.DIMINISHED),
    MINOR_THIRD(3, Quality.MINOR), AUGMENTED_SECOND(3, Quality.AUGMENTED),
    MAJOR_THIRD(4, Quality.MAJOR), DIMINISHED_FOURTH(4, Quality.DIMINISHED),
    PERFECT_FOURTH(5, Quality.PERFECT), AUGMENTED_THIRD(5, Quality.AUGMENTED),
    DIMINISHED_FIFTH(6, Quality.DIMINISHED), AUGMENTED_FOURTH(6, Quality.AUGMENTED),
    PERFECT_FIFTH(7, Quality.PERFECT), DIMINISHED_SIXTH(7, Quality.DIMINISHED),
    MINOR_SIXTH(8, Quality.MINOR), AUGMENTED_FIFTH(8, Quality.AUGMENTED),
    MAJOR_SIXTH(9, Quality.MAJOR), DIMINISHED_SEVENTH(9, Quality.DIMINISHED),
    MINOR_SEVENTH(10, Quality.MINOR), AUGMENTED_SIXTH(10, Quality.AUGMENTED),
    MAJOR_SEVENTH(11, Quality.MAJOR), DIMINISHED_OCTAVE(11, Quality.DIMINISHED),
    PERFECT_OCTAVE(12, Quality.PERFECT), AUGMENTED_SEVENTH(12, Quality.AUGMENTED), DIMINISHED_NINTH(12, Quality.DIMINISHED),
    MINOR_NINTH(13, Quality.MINOR), AUGMENTED_OCTAVE(13, Quality.AUGMENTED),
    MAJOR_NINTH(14, Quality.MAJOR), DIMINISHED_TENTH(14, Quality.DIMINISHED),
    MINOR_TENTH(15, Quality.MINOR), AUGMENTED_NINTH(15, Quality.AUGMENTED),
    MAJOR_TENTH(16, Quality.MAJOR), DIMINISHED_ELEVENTH(16, Quality.DIMINISHED),
    PERFECT_ELEVENTH(17, Quality.MINOR), AUGMENTED_TENTH(17, Quality.AUGMENTED),
    DIMINISHED_TWELFTH(18, Quality.DIMINISHED), AUGMENTED_ELEVENTH(18, Quality.AUGMENTED),
    PERFECT_TWELFTH(19, Quality.PERFECT), DIMINISHED_THIRTEENTH(19, Quality.DIMINISHED),
    MINOR_THIRTEENTH(20, Quality.MINOR), AUGMENTED_TWELFTH(20, Quality.AUGMENTED),
    MAJOR_THIRTEENTH(21, Quality.MAJOR), DIMINISHED_FOURTEENTH(21, Quality.DIMINISHED),
    MINOR_FOURTEENTH(22, Quality.MINOR), AUGMENTED_THIRTEENTH(22, Quality.AUGMENTED),
    MAJOR_FOURTEENTH(23, Quality.MAJOR), DIMINISHED_FIFTEENTH(23, Quality.DIMINISHED),
    PERFECT_FIFTEENTH(24, Quality.PERFECT), AUGMENTED_FOURTEENTH(24, Quality.AUGMENTED),
    AUGMENTED_FIFTEENTH(25, Quality.AUGMENTED);

    private final int semitones;
    private final Quality quality;

    IntervalChromatic(int semitones, @NonNull Quality quality) {
        this.semitones = semitones;
        this.quality = Objects.requireNonNull(quality);
    }

    public int getSemitones() {
        return semitones;
    }

    public @NonNull Quality getQuality() {
        return quality;
    }

    public boolean isCompound() {
        return (getSemitones() > Chromatic.NUMBER || this == DIMINISHED_NINTH);
    }

    public static @NonNull Set<IntervalChromatic> from(@NonNull IntervalDiatonic intervalDiatonic) {
        Set<IntervalChromatic> ret = new HashSet<>();
        switch(intervalDiatonic) {
            case UNISON:
                ret.add(PERFECT_UNISON);
                ret.add(AUGMENTED_UNISON);
                break;
            case SECOND:
                ret.add(DIMINISHED_SECOND);
                ret.add(MINOR_SECOND);
                ret.add(MAJOR_SECOND);
                ret.add(AUGMENTED_SECOND);
                break;
            case THIRD:
                ret.add(DIMINISHED_THIRD);
                ret.add(MINOR_THIRD);
                ret.add(MAJOR_THIRD);
                ret.add(AUGMENTED_THIRD);
                break;
            case FOURTH:
                ret.add(DIMINISHED_FOURTH);
                ret.add(PERFECT_FOURTH);
                ret.add(AUGMENTED_FOURTH);
                break;
            case FIFTH:
                ret.add(DIMINISHED_FIFTH);
                ret.add(PERFECT_FIFTH);
                ret.add(AUGMENTED_FIFTH);
                break;
            case SIXTH:
                ret.add(DIMINISHED_SIXTH);
                ret.add(MINOR_SIXTH);
                ret.add(MAJOR_SIXTH);
                ret.add(AUGMENTED_SIXTH);
                break;
            case SEVENTH:
                ret.add(DIMINISHED_SEVENTH);
                ret.add(MINOR_SEVENTH);
                ret.add(MAJOR_SEVENTH);
                ret.add(AUGMENTED_SEVENTH);
                break;
            case OCTAVE:
                ret.add(DIMINISHED_OCTAVE);
                ret.add(PERFECT_OCTAVE);
                ret.add(AUGMENTED_OCTAVE);
                break;
            case NINTH:
                ret.add(DIMINISHED_NINTH);
                ret.add(MINOR_NINTH);
                ret.add(MAJOR_NINTH);
                ret.add(AUGMENTED_NINTH);
                break;
            case TENTH:
                ret.add(DIMINISHED_TENTH);
                ret.add(MINOR_TENTH);
                ret.add(MAJOR_TENTH);
                ret.add(AUGMENTED_TENTH);
                break;
            case ELEVENTH:
                ret.add(DIMINISHED_ELEVENTH);
                ret.add(PERFECT_ELEVENTH);
                ret.add(AUGMENTED_ELEVENTH);
                break;
            case TWELFTH:
                ret.add(DIMINISHED_TWELFTH);
                ret.add(PERFECT_TWELFTH);
                ret.add(AUGMENTED_TWELFTH);
                break;
            case THIRTEENTH:
                ret.add(DIMINISHED_THIRTEENTH);
                ret.add(MINOR_THIRTEENTH);
                ret.add(MAJOR_THIRTEENTH);
                ret.add(AUGMENTED_THIRTEENTH);
                break;
            case FOURTEENTH:
                ret.add(DIMINISHED_FOURTEENTH);
                ret.add(MINOR_FOURTEENTH);
                ret.add(MAJOR_FOURTEENTH);
                ret.add(AUGMENTED_FOURTEENTH);
                break;
            case FIFTEENTH:
                ret.add(DIMINISHED_FIFTEENTH);
                ret.add(PERFECT_FIFTEENTH);
                ret.add(AUGMENTED_FIFTEENTH);
                break;
            default:
                throw NeverHappensException.switchOf(intervalDiatonic);
        }

        return ret;
    }

    public static @Nullable IntervalChromatic from(@NonNull IntervalDiatonic intervalDiatonic, int semitones) {
        switch (intervalDiatonic) {
            case UNISON:
                switch (semitones) {
                    case 0:
                        return PERFECT_UNISON;
                    case 1:
                        return AUGMENTED_UNISON;
                }
                break;
            case SECOND:
                switch (semitones) {
                    case 0:
                        return DIMINISHED_SECOND;
                    case 1:
                        return MINOR_SECOND;
                    case 2:
                        return MAJOR_SECOND;
                    case 3:
                        return AUGMENTED_SECOND;
                }
                break;
            case THIRD:
                switch (semitones) {
                    case 2:
                        return DIMINISHED_THIRD;
                    case 3:
                        return MINOR_THIRD;
                    case 4:
                        return MAJOR_THIRD;
                    case 5:
                        return AUGMENTED_THIRD;
                }
                break;
            case FOURTH:
                switch (semitones) {
                    case 4:
                        return DIMINISHED_FOURTH;
                    case 5:
                        return PERFECT_FOURTH;
                    case 6:
                        return AUGMENTED_FOURTH;
                }
                break;
            case FIFTH:
                switch (semitones) {
                    case 6:
                        return DIMINISHED_FIFTH;
                    case 7:
                        return PERFECT_FIFTH;
                    case 8:
                        return AUGMENTED_FIFTH;
                }
                break;
            case SIXTH:
                switch (semitones) {
                    case 7:
                        return DIMINISHED_SIXTH;
                    case 8:
                        return MINOR_SIXTH;
                    case 9:
                        return MAJOR_SIXTH;
                    case 10:
                        return AUGMENTED_SIXTH;
                }
                break;
            case SEVENTH:
                switch (semitones) {
                    case 9:
                        return DIMINISHED_SEVENTH;
                    case 10:
                        return MINOR_SEVENTH;
                    case 11:
                        return MAJOR_SEVENTH;
                    case 12:
                        return AUGMENTED_SEVENTH;
                }
                break;
            case OCTAVE:
                switch (semitones) {
                    case 11:
                        return DIMINISHED_OCTAVE;
                    case 12:
                        return PERFECT_OCTAVE;
                    case 13:
                        return AUGMENTED_OCTAVE;
                }
                break;
            case NINTH:
                switch (semitones) {
                    case 12:
                        return DIMINISHED_NINTH;
                    case 13:
                        return MINOR_NINTH;
                    case 14:
                        return MAJOR_NINTH;
                    case 15:
                        return AUGMENTED_NINTH;
                }
                break;
            case TENTH:
                switch (semitones) {
                    case 14:
                        return DIMINISHED_TENTH;
                    case 15:
                        return MINOR_TENTH;
                    case 16:
                        return MAJOR_TENTH;
                    case 17:
                        return AUGMENTED_TENTH;
                }
                break;
            case ELEVENTH:
                switch (semitones) {
                    case 16:
                        return DIMINISHED_ELEVENTH;
                    case 17:
                        return PERFECT_ELEVENTH;
                    case 18:
                        return AUGMENTED_ELEVENTH;
                }
                break;
            case TWELFTH:
                switch (semitones) {
                    case 18:
                        return DIMINISHED_TWELFTH;
                    case 19:
                        return PERFECT_TWELFTH;
                    case 20:
                        return AUGMENTED_TWELFTH;
                }
                break;
            case THIRTEENTH:
                switch (semitones) {
                    case 19:
                        return DIMINISHED_THIRTEENTH;
                    case 20:
                        return MINOR_THIRTEENTH;
                    case 21:
                        return MAJOR_THIRTEENTH;
                    case 22:
                        return AUGMENTED_THIRTEENTH;
                }
                break;
            case FOURTEENTH:
                switch (semitones) {
                    case 21:
                        return DIMINISHED_FOURTEENTH;
                    case 22:
                        return MINOR_FOURTEENTH;
                    case 23:
                        return MAJOR_FOURTEENTH;
                    case 24:
                        return AUGMENTED_FOURTEENTH;
                }
                break;
            case FIFTEENTH:
                switch (semitones) {
                    case 23:
                        return DIMINISHED_FIFTEENTH;
                    case 24:
                        return PERFECT_FIFTEENTH;
                    case 25:
                        return AUGMENTED_FIFTEENTH;
                }
                break;
            default: return null;
        }

        return null;
    }

    @Override
    public String toString() {
        return Namer.longFrom(this);
    }
}
