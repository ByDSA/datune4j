package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;

class ChromaticChordMidiAdapter {
    private ChromaticChordMidiAdapter() {
    }

    public static <N extends PitchChromaticSingle> @NonNull ChromaticChordMidi from(@NonNull Iterable<N> iterable) throws PitchMidiException {
        ChromaticChordMidi self = new ChromaticChordMidi();

        for (N n : iterable) {
            ChromaticMidiBuilder builder = ChromaticMidi.builder();

            Chromatic chromaticN = null;
            if (n instanceof Chromatic)
                chromaticN = (Chromatic) n;
            else if (n instanceof ChromaticMidi)
                chromaticN = ((ChromaticMidi) n).getPitch().getChromatic();

            if (n instanceof PitchOctave)
                builder.pitch(chromaticN, (((PitchOctave) n).getOctave()));
            else
                builder.pitch(chromaticN);

            if (n instanceof Durable) {
                builder.length(((Durable) n).getLength());
            }

            if (n instanceof VelocityNote) {
                builder.velocity(((VelocityNote) n).getVelocity());
            }

            ChromaticMidi chromaticMidi = builder
                    .build();

            if (self.size() > 0) {
                Chromatic chromaticCm = Chromatic.from(chromaticMidi);
                ChromaticMidi previous = self.get(self.size() - 1);
                Chromatic prevChromatic = Chromatic.from(previous);
                chromaticMidi.getPitch().setOctave(previous.getPitch().getOctave());
                if (!(n instanceof PitchOctave) && self.size() > 0 && chromaticCm.ordinal() <= prevChromatic.ordinal()) {
                    chromaticMidi.getPitch().shiftOctave(1);
                }
            }

            self.add(chromaticMidi);
        }

        return self;
    }

    public static @NonNull ChromaticChordMidi fromDiatonicChordMidi(@NonNull DiatonicChordMidi diatonicChordMidi) {
        ChromaticChordMidi chromaticChordMidi = new ChromaticChordMidi();
        for (DiatonicMidi diatonicMidi : diatonicChordMidi) {
            ChromaticMidi nChromatic = ChromaticMidi.from(diatonicMidi);
            chromaticChordMidi.add(nChromatic);
        }
        chromaticChordMidi.arpegio = diatonicChordMidi.arpegio;
        chromaticChordMidi.length = diatonicChordMidi.length;
        chromaticChordMidi.setRootIndex(diatonicChordMidi.getRootIndex());

        return chromaticChordMidi;
    }
}
