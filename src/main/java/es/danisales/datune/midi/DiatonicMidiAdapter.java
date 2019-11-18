package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

class DiatonicMidiAdapter {
    public static @Nullable DiatonicMidi from(@NonNull ChromaticMidi chromaticMidi, @NonNull Tonality tonality) {
        Chromatic chromatic = Chromatic.from(chromaticMidi);
            DiatonicDegree pos = (DiatonicDegree)tonality.getDegreeFrom( chromatic );
            if ( pos == null ) {
                //throw new TonalityException( chromatic, tonality );
                return null;
            }

            else {
                int octaveNote = chromaticMidi.getOctave();
                DiatonicMidi ns = DiatonicMidi.builder()
                        .diatonicDegree(pos)
                        .tonality(tonality)
                        .octave( chromaticMidi.getPitchMidi().getOctave() )
                        .length(chromaticMidi.length)
                        .velocity( chromaticMidi.velocity)
                        .build();

                int octaveNoteScaleNote = ns.pitch.getOctave();
                ns.shiftOctave( octaveNote - octaveNoteScaleNote );

                return ns;
            }
        }
}
