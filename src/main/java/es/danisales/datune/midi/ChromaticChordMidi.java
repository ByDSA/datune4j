package es.danisales.datune.midi;

import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.Quality;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.utils.MathUtils;
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
    public @NonNull ChromaticMidi getCyclic(int noteNumber) throws PitchMidiException {
        ChromaticMidi n;

        int num = MathUtils.rotativeTrim(noteNumber, size());
        n = get(num);

        if (noteNumber >= size()) {
            int octaves = noteNumber / size();
            int index = octaves * IntervalChromatic.PERFECT_OCTAVE.getSemitones();
            n.getPitch().shift(index);
        } else if (noteNumber < 0) {
            int octaves = noteNumber / size() - 1;
            int index = -octaves * IntervalChromatic.PERFECT_OCTAVE.getSemitones();
            n.getPitch().shift(index);
        } else
            n = get(num).clone();

        return n;
    }

    @Override
    public @NonNull ChromaticChordMidi clone() {
        ChromaticChordMidi chromaticChordMidi = new ChromaticChordMidi();
        return (ChromaticChordMidi) commonClone(chromaticChordMidi);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ChromaticMidi chromaticMidi : this)
            stringBuilder.append(chromaticMidi.toString()).append("\n");

        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return 43 * super.hashCode();
    }
}
