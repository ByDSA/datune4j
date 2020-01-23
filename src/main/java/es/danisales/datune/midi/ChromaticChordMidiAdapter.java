package es.danisales.datune.midi;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;

class ChromaticChordMidiAdapter {
    private ChromaticChordMidiAdapter() {
    }

    public static <N extends PitchChromaticSingle> @NonNull ChordMidi from(@NonNull Iterable<N> iterable) throws PitchMidiException {
        ChordMidi self = new ChordMidi();

        for (N n : iterable) {
            ChromaticMidiBuilder builder = ChromaticMidi.builder();

            Chromatic chromaticN = null;
            if (n instanceof Chromatic)
                chromaticN = (Chromatic) n;
            else if (n instanceof ChromaticMidi)
                chromaticN = ((ChromaticMidi) n).getPitch().getNote();

            if (n instanceof PitchOctave)
                builder.pitch(chromaticN, (((PitchOctave) n).getOctave()));
            else
                builder.pitch(chromaticN);

            if (n instanceof Durable) {
                builder.length(((Durable) n).getLength());
            }

            if (n instanceof Velocitiable) {
                builder.velocity(((Velocitiable) n).getVelocity());
            }

            ChromaticMidi chromaticMidi = builder
                    .build();

            if (self.size() > 0) {
                Chromatic chromaticCm = chromaticMidi.getPitch().getNote();
                ChromaticMidi previous = self.get(self.size() - 1);
                Chromatic prevChromatic = previous.getPitch().getNote();
                chromaticMidi.getPitch().setOctave(previous.getPitch().getOctave());
                if (!(n instanceof PitchOctave) && self.size() > 0 && chromaticCm.ordinal() <= prevChromatic.ordinal()) {
                    chromaticMidi.getPitch().shiftOctave(1);
                }
            }

            self.add(chromaticMidi);
        }

        return self;
    }
}
