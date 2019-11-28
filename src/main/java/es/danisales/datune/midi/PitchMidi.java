package es.danisales.datune.midi;

import es.danisales.datune.pitch.PitchChromaticSingle;

import static com.google.common.base.Preconditions.checkArgument;

public final class PitchMidi implements PitchChromaticSingle, Cloneable {
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

    public PitchChromaticMidi getPitchChromaticMidi() {
        return pitchChromaticMidi;
    }

    @SuppressWarnings("WeakerAccess")
    public int getCents() {
        return cents;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public PitchMidi clone() {
        return PitchMidi.from(pitchChromaticMidi, cents);
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
        return pitchChromaticMidi.getMidiCode() * 100 + cents;
    }
}
