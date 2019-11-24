package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import org.checkerframework.checker.nullness.qual.NonNull;

class ChromaticChordMidiAdapter {
    private ChromaticChordMidiAdapter() {
    }

    public static @NonNull ChromaticChordMidi fromChromatics(Chromatic[] chromatics) {
        ChromaticChordMidi ns = new ChromaticChordMidi();
        for (int i = 0; i < chromatics.length; i++) {
            ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                    .pitch(chromatics[i])
                    .build();
            if (i > 0) {
                int lastElementOctave = ns.get(ns.size() - 1).getPitch().getOctave();
                if (chromatics[i].ordinal() < (chromatics[i - 1].ordinal()))
                    chromaticMidi.getPitch().setOctave(lastElementOctave + 1);
                else
                    chromaticMidi.getPitch().setOctave(lastElementOctave);
            }
            ns.add(chromaticMidi);
        }
        return ns;
    }

    public static <N extends PitchChromaticSingle> @NonNull ChromaticChordMidi from(Iterable<N> iterable) {
        ChromaticChordMidi self = new ChromaticChordMidi();

        for (N n : iterable) {
            ChromaticMidiBuilder builder = ChromaticMidi.builder();

            Chromatic chromaticN = ChromaticAdapter.from(n);

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
        chromaticChordMidi.setRootPos(diatonicChordMidi.getRootPos());

        return chromaticChordMidi;
    }
}
