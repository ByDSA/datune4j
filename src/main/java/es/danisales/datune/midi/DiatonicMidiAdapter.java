package es.danisales.datune.midi;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;

class DiatonicMidiAdapter {
    private DiatonicMidiAdapter() {
    }

    public static @NonNull DiatonicMidi from(@NonNull ChromaticMidi chromaticMidi, @NonNull Tonality tonality) throws TonalityException, PitchMidiException {
        Chromatic chromatic = chromaticMidi.getPitch().getChromatic();
        DiatonicDegree pos = (DiatonicDegree) tonality.getDegreeFrom(chromatic);

        int octaveNote = chromaticMidi.getPitch().getOctave();
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(pos, tonality, chromaticMidi.getPitch().getOctave());
        DiatonicMidi ns = DiatonicMidi.builder()
                .pitch(pitchDiatonicMidi)
                .length(chromaticMidi.length)
                .velocity(chromaticMidi.velocity)
                .build();

        int octaveNoteScaleNote = ns.pitch.getOctave();
        ns.getPitch().shiftOctave(octaveNote - octaveNoteScaleNote);

        return ns;
    }
}
