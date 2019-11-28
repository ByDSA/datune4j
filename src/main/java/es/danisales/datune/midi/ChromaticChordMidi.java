package es.danisales.datune.midi;

import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ChromaticChordMidi extends ChordMidi<ChromaticMidi, IntervalChromatic, PitchChromaticMidi>
        implements PitchChromaticChord<ChromaticMidi> {

    public static ChromaticChordMidiBuilder builder() {
        return new ChromaticChordMidiBuilder();
    }

    protected ChromaticChordMidi() {
    }

    public void compact() {
        for (int i = 1; i < this.size(); i++) {
            int distFromPrevious = this.get(i - 1).distTo(this.get(i));
            if (distFromPrevious > IntervalChromatic.PERFECT_OCTAVE.getSemitones()) {
                try {
                    get(i).getPitch().shiftOctave(
                            -distFromPrevious / IntervalChromatic.PERFECT_OCTAVE.getSemitones()
                    );
                } catch (PitchMidiException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Impossible!");
                }
            }
        }
    }

    @Override
    @NonNull
    public Quality getQuality() {
        return meta.getQuality();
    }

    @Override
    public ChromaticChordMidi newChord() {
        return new ChromaticChordMidi();
    }

    @Override
    public void shift(IntervalChromatic intervalChromatic) {
        try {
            for (ChromaticMidi chromaticMidi : this) {

                chromaticMidi.getPitch().shift(intervalChromatic);
            }
        } catch (PitchMidiException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void shiftNegative(IntervalChromatic intervalChromatic) {
        try {
            for (ChromaticMidi chromaticMidi : this) {

                chromaticMidi.getPitch().shiftNegative(intervalChromatic);
            }
        } catch (PitchMidiException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public @NonNull ChromaticChordMidi clone() {
        return (ChromaticChordMidi) super.clone();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ChromaticMidi chromaticMidi : this)
            stringBuilder.append(chromaticMidi.toString()).append("\n");

        return stringBuilder.toString();
    }
}
