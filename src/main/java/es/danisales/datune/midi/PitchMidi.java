package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;

import static com.google.common.base.Preconditions.checkArgument;

public final class PitchMidi implements PitchChromaticSingle, PitchOctave, PitchOctaveMidiEditable, Cloneable {
    private int cents;
    private PitchChromaticMidi pitchChromaticMidi;

    private PitchMidi() {
    }

    public static PitchMidi from(PitchChromaticMidi pitchChromaticMidi) {
       return from(pitchChromaticMidi, 0);
    }

    public static PitchMidi from(PitchChromaticMidi pitchChromaticMidi, int cents) {
        checkArgument(cents < 100 && cents >= 0);

        PitchMidi ret = new PitchMidi();
        ret.pitchChromaticMidi = pitchChromaticMidi;
        ret.cents = cents;

        return ret;
    }

    @SuppressWarnings("WeakerAccess")
    public PitchChromaticMidi getPitchChromaticMidi() {
        return pitchChromaticMidi;
    }

    @SuppressWarnings("WeakerAccess")
    public int getCents() {
        return cents;
    }

    @Override
    public int getOctave() {
        return pitchChromaticMidi.getOctave();
    }

    @Override
    public ChromaticDegree getDegree() {
        return pitchChromaticMidi.getDegree();
    }

    @Override
    public @NonNull PitchMidi getNext() {
        PitchMidi ret = new PitchMidi();
        ret.pitchChromaticMidi = pitchChromaticMidi.getNext();
        ret.cents = cents;
        return ret;
    }

    @Override
    public @NonNull PitchMidi getPrevious() {
        PitchMidi ret = new PitchMidi();
        ret.pitchChromaticMidi = pitchChromaticMidi.getPrevious();
        ret.cents = cents;
        return ret;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public PitchMidi clone() {
        return PitchMidi.from(pitchChromaticMidi, cents);
    }

    @Override
    public PitchMidi getShifted(IntervalChromatic intervalChromatic) {
        PitchMidi pitchMidi = clone();
        pitchMidi.pitchChromaticMidi = pitchMidi.pitchChromaticMidi.getShift(intervalChromatic);
        return pitchMidi;
    }

    @Override
    public PitchMidi getShiftedNegative(IntervalChromatic intervalChromatic) {
        PitchMidi pitchMidi = clone();
        pitchMidi.pitchChromaticMidi = pitchMidi.pitchChromaticMidi.getShiftNegative(intervalChromatic);
        return pitchMidi;
    }

    @Override
    public void shiftOctave(int o) {
        pitchChromaticMidi = pitchChromaticMidi.getWithShiftOctave(o);
    }

    @Override
    public void setOctave(int o) {
        pitchChromaticMidi = pitchChromaticMidi.getWithOctave(o);
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof PitchMidi) )
            return  false;

        PitchMidi pitchMidi = (PitchMidi) o;

        return pitchChromaticMidi.equals(pitchMidi.pitchChromaticMidi) && cents == pitchMidi.cents;
    }

    @Override
    public int hashCode() {
        return pitchChromaticMidi.ordinal() * 100 + cents;
    }

    public void shift(IntervalChromatic i) {
        pitchChromaticMidi = pitchChromaticMidi.getShift(i);
    }
}
