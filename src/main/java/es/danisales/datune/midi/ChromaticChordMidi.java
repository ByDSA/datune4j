package es.danisales.datune.midi;

import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.ChromaticChordInfo;
import es.danisales.datune.chords.transformations.DistanceCalculator;
import es.danisales.datune.chords.PitchChromaticChord;
import es.danisales.utils.MathUtils;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ChromaticChordMidi extends ChordMidi<ChromaticMidi, IntervalChromatic, PitchChromaticMidi>
        implements PitchChromaticChord<ChromaticMidi> {
    private ChromaticChordInfo info;

    public static ChromaticChordMidiBuilder builder() {
        return new ChromaticChordMidiBuilder();
    }

    protected ChromaticChordMidi() {
    }

    public void compact() {
        for (int i = 1; i < this.size(); i++) {
            int distFromPrevious = DistanceCalculator.calculateDistanceInSemitones(get(i - 1), get(i));
            if (distFromPrevious > IntervalChromatic.PERFECT_OCTAVE.getSemitones()) {
                try {
                    get(i).getPitch().shiftOctave(
                            -distFromPrevious / IntervalChromatic.PERFECT_OCTAVE.getSemitones()
                    );
                } catch (PitchMidiException e) {
                    NeverHappensException.msg("Si antes era válido, la versión compactada lo seguirá siendo siempre");
                }
            }
        }
    }

    @Override
    public @NonNull ChromaticChordInfo getInfo() {
        return info;
    }

    @Override
    public void shift(IntervalChromatic intervalChromatic) throws PitchMidiException {
        for (ChromaticMidi chromaticMidi : this) {
            chromaticMidi.getPitch().shift(intervalChromatic);
        }

        onMutation();
    }

    @Override
    public void shiftNegative(IntervalChromatic intervalChromatic) throws PitchMidiException {
        for (ChromaticMidi chromaticMidi : this) {
            chromaticMidi.getPitch().shiftNegative(intervalChromatic);
        }

        onMutation();
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
    protected void onMutation() {
        ChromaticChord chromaticChord = ChromaticChord.builder()
                .fromChromaticMidi(this)
                .build();
        info = ChromaticChordInfo.from(chromaticChord);
    }

    @Override
    public @NonNull ChromaticChordMidi clone() {
        ChromaticChordMidi chromaticChordMidi = new ChromaticChordMidi();
        chromaticChordMidi = (ChromaticChordMidi) commonClone(chromaticChordMidi);
        chromaticChordMidi.info = info;
        return chromaticChordMidi;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ChromaticMidi chromaticMidi : this)
            stringBuilder.append(chromaticMidi.toString()).append("\n");

        return stringBuilder.toString();
    }
}
