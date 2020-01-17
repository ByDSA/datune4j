package es.danisales.datune.chords;

import es.danisales.datune.interval.Interval;
import es.danisales.datune.pitch.PitchException;
import es.danisales.datune.pitch.SymbolicPitch;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

abstract class ChordMutableNonMidi<N extends SymbolicPitch, I extends Interval>
        extends ChordMutable<N, I> {
    private static final NeverHappensException NEVER_HAPPENS_EXCEPTION
            = NeverHappensException.make("ChromaticChordMutable es siempre de Chromatic o Diatonic y no tiene problemas de octava mínima o máxima");

    ChordMutableNonMidi() {
        super(new ArrayList<>());
    }

    @Override
    public final void over(@NonNull N symbolicPitch) {
        try {
            super.over(symbolicPitch);
        } catch (PitchException e) {
            throw NEVER_HAPPENS_EXCEPTION;
        }
    }

    @Override
    public final void inv() {
        try {
            super.inv();
        } catch (PitchException e) {
            throw NEVER_HAPPENS_EXCEPTION;
        }
    }

    @Override
    public final void inv(int n) {
        try {
            super.inv(n);
        } catch (PitchException e) {
            throw NEVER_HAPPENS_EXCEPTION;
        }
    }

    @Override
    public final void toFundamental() {
        try {
            super.toFundamental();
        } catch (PitchException e) {
            throw NEVER_HAPPENS_EXCEPTION;
        }
    }
}
