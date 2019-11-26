package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.midi.Arpegios.Arpegio;
import es.danisales.datune.midi.Arpegios.ArpegioDefault;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.Builder;
import org.checkerframework.checker.nullness.qual.NonNull;

public class DiatonicChordMidiBuilder extends Builder<DiatonicChordMidiBuilder, DiatonicChordMidi> {
    Tonality tonality = Settings.DefaultValues.TONALITY;
    int length = Settings.DefaultValues.LENGTH_CHORD;
    int velocity = Settings.DefaultValues.VELOCITY;
    HarmonicFunction function;
    Arpegio arpegio;
    int octave = Settings.DefaultValues.OCTAVE;

    @NonNull
    @Override
    public DiatonicChordMidi build() {
        DiatonicChordMidi diatonicChordMidi = new DiatonicChordMidi();
        diatonicChordMidi.tonality = tonality;
        diatonicChordMidi.metaTonality = tonality;
        diatonicChordMidi.setLength(length);
        diatonicChordMidi.setVelocity(velocity);

        if (function instanceof ChromaticFunction) {
            diatonicChordMidi.chromaticFunctionProcess((ChromaticFunction) function, octave);
            Chromatic firstChromatic = Chromatic.from(diatonicChordMidi.get(0));
            Chromatic metaChromatic = Chromatic.from(diatonicChordMidi.metaTonality.getNote(DiatonicDegree.I));
            if (firstChromatic.ordinal() < metaChromatic.ordinal())
                diatonicChordMidi.shiftOctave(1);
        } else if (function instanceof DiatonicFunction)
            diatonicChordMidi.diatonicFunctionProcess((DiatonicFunction) function, octave);

        if (arpegio == null)
            diatonicChordMidi.setArpegio(new ArpegioDefault());
        else
            diatonicChordMidi.arpegio = arpegio;

        return diatonicChordMidi;
    }

    public DiatonicChordMidiBuilder tonality(@NonNull Tonality tonality) {
        this.tonality = tonality;

        return self();
    }

    public DiatonicChordMidiBuilder from(@NonNull HarmonicFunction harmonicFunction, @NonNull Tonality tonality) {
        this.function = harmonicFunction;
        this.tonality = tonality;

        return self();
    }

    public DiatonicChordMidiBuilder length(int length) {
        this.length = length;

        return self();
    }

    public DiatonicChordMidiBuilder velocity(int velocity) {
        this.velocity = velocity;

        return self();
    }

    public DiatonicChordMidiBuilder octave(int octave) {
        this.octave = octave;

        return self();
    }



    @NonNull
    @Override
    protected DiatonicChordMidiBuilder self() {
        return this;
    }
}
