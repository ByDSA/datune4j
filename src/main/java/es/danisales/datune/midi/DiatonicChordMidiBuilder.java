package es.danisales.datune.midi;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.Arpegios.Arpegio;
import es.danisales.datune.midi.Arpegios.ArpegioDefault;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChordInterface;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.DiatonicChordPattern;
import es.danisales.datune.tonality.*;
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

        initFromFunction(diatonicChordMidi);
        initArpegio(diatonicChordMidi);

        return diatonicChordMidi;
    }

    private void initArpegio(DiatonicChordMidi diatonicChordMidi) {
        if (arpegio == null)
            diatonicChordMidi.setArpegio(new ArpegioDefault());
        else
            diatonicChordMidi.arpegio = arpegio;
    }

    private void initFromFunction(DiatonicChordMidi diatonicChordMidi) {
        if (function instanceof ChromaticFunction) {
            chromaticFunctionProcess(diatonicChordMidi);
            Chromatic firstChromatic = Chromatic.from(diatonicChordMidi.get(0));
            Chromatic metaChromatic = Chromatic.from(diatonicChordMidi.metaTonality.getNote(DiatonicDegree.I));
            if (firstChromatic.ordinal() < metaChromatic.ordinal())
                diatonicChordMidi.shiftOctave(1);
        } else if (function instanceof DiatonicFunction)
            initFromDiatonicFunction(diatonicChordMidi);
    }

    protected void chromaticFunctionProcess(DiatonicChordMidi self) {
        ChromaticFunction t = (ChromaticFunction) function;
        if (t == ChromaticFunction.N6) {
            ChromaticChordInterface cc = ChromaticChordInterface.from(t, tonality);

            tonality = TonalityRetrieval.listFromChord(cc).get(0);

            ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder()
                    .fromChromatic(cc)
                    .octaveBase(octave)
                    .length(length)
                    .build();

            self.addAll(chromaticChordMidi);
        } else if (ArrayUtils.contains(t, ChromaticFunction.POWER_CHORDS)) {
            DiatonicDegree d = t.getDegree();

            IntervalChromatic ic = tonality.getInterval(d, IntervalDiatonic.FIFTH);

            if (!ic.equals(IntervalChromatic.PERFECT_FIFTH)) {
                DiatonicAlt diatonicAlt = tonality.getNote(d);
                tonality = Tonality.from(diatonicAlt, Scale.MAJOR);
                d = DiatonicDegree.I;
            }

            ChromaticMidi n = ChromaticMidi.builder()
                    .pitch(tonality.getNote(d), octave)
                    .length(Settings.DefaultValues.LENGTH_CHORD)
                    .build();
            self.add(n);
            ChromaticMidi n2 = n.clone();
            n2.getPitch().shift(IntervalChromatic.PERFECT_FIFTH);
            //assert !n.equalsEnharmonic( n2 ) : n2;
            self.add(n2);
        } else if (ArrayUtils.contains(t, ChromaticFunction.TENSIONS)) {
            DiatonicMidi n = null;
            switch (t) {
                case V_II:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.II)
                                    ).build(), tonality
                    );
                    break;
                case V7_II:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.II)
                                    ).build(), tonality
                    );
                    break;
                case V_III:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.III)
                                    ).build(), tonality
                    );
                    break;
                case V7_III:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.III)
                                    ).build(), tonality
                    );
                    break;
                case V_IV:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.IV)
                                    ).build(), tonality
                    );
                    break;
                case V7_IV:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.IV)
                                    ).build(), tonality
                    );
                    break;
                case V_V:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.V)
                                    ).build(), tonality
                    );
                    break;
                case V7_V:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.V)
                                    ).build(), tonality
                    );
                    break;
                case V_VI:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.VI)
                                    ).build(), tonality
                    );
                    break;
                case V7_VI:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.VI)
                                    ).build(), tonality
                    );
                    break;
                case SUBV7:
                    DiatonicChordMidi c = DiatonicChordMidi.builder()
                            .from(DiatonicFunction.V7, tonality)
                            .build();
                    Chromatic firstChromatic = Chromatic.from(c.get(0));
                    tonality = Tonality.from(
                            firstChromatic.addSemi(6), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_II:
                    DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_II, tonality
                            ).build();
                    Chromatic firstChromatic2 = Chromatic.from(c2.get(0));
                    tonality = Tonality.from(
                            firstChromatic2.addSemi(6), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_III:
                    DiatonicChordMidi c3 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_III, tonality
                            ).build();
                    Chromatic firstChromatic3 = Chromatic.from(c3.get(0));
                    tonality = Tonality.from(
                            firstChromatic3.addSemi(6), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_IV:
                    DiatonicChordMidi c4 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_IV, tonality
                            ).build();
                    Chromatic firstChromatic4 = Chromatic.from(c4.get(0));
                    tonality = Tonality.from(
                            firstChromatic4.addSemi(6), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_V:
                    DiatonicChordMidi c5 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_V, tonality
                            ).build();
                    Chromatic firstChromatic5 = Chromatic.from(c5.get(0));
                    tonality = Tonality.from(
                            firstChromatic5.addSemi(6), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_VI:
                    DiatonicChordMidi c6 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_VI, tonality
                            ).build();
                    Chromatic firstChromatic6 = Chromatic.from(c6.get(0));
                    tonality = Tonality.from(
                            firstChromatic6.addSemi(6), Scale.LYDIAN_b7
                    );
                    break;
                case V7ALT:
                    DiatonicChordMidi calt = DiatonicChordMidi.builder()
                            .from(
                                    DiatonicFunction.V7, tonality
                            ).build();
                    Chromatic firstChromaticAlt = Chromatic.from(calt.get(0));
                    tonality = Tonality.from(
                            firstChromaticAlt, Scale.SUPERLOCRIAN
                    );
                    break;
            }

            DiatonicFunction t2 = null;
            switch (t) {
                case V_II:
                case V_III:
                case V_IV:
                case V_V:
                case V_VI:
                    t2 = DiatonicFunction.I;
                    break;
                case V7_II:
                case V7_III:
                case V7_IV:
                case V7_V:
                case V7_VI:
                case SUBV7:
                case SUBV7_II:
                case SUBV7_III:
                case SUBV7_IV:
                case SUBV7_V:
                case SUBV7_VI:
                case V7ALT:
                    t2 = DiatonicFunction.I7;
                    break; // Ya se ha corregido la escala
            }
            assert t2 != null : t + " " + self.metaTonality;

            try {
                function = t2;
                initFromDiatonicFunction(self);
                function = t;
            } catch (TonalityException e) {
                System.out.println(t);
            }
        } else {
            ChromaticChordInterface cc = ChromaticChordInterface.from(t, tonality);

            ChromaticMidi[] ccmArray = new ChromaticMidi[cc.size()];
            int i = 0;
            for (Chromatic c : cc) {
                ChromaticMidi cm = ChromaticMidi.builder()
                        .pitch(c)
                        .build();
                ccmArray[i++] = cm;
            }

            ChromaticChordMidi ccm = ChromaticChordMidi.from(ccmArray);

            if (tonality.has(cc))
                self.addAll(ccm);
            else {
                self.metaTonality = TonalityChordRetrieval.searchInModeSameRoot(tonality, cc);
                if (self.metaTonality == null)
                    throw new TonalityException(cc, tonality);
                self.tonality = self.metaTonality;

                self.addAll(ccm);
            }
        }

        self.sortByPitch();
    }

    private void initFromDiatonicFunction(DiatonicChordMidi diatonicChordMidi) {
        DiatonicFunction diatonicFunction = (DiatonicFunction) function;
        DiatonicChordPattern diatonicChordPattern = DiatonicChordPattern.from(diatonicFunction);
        DiatonicDegree diatonicDegree = DiatonicDegree.from(diatonicFunction);
        initFromDiatonicFunctionAddNotes(diatonicChordMidi, diatonicDegree, diatonicChordPattern);
        diatonicChordMidi.setRootPos(0);
    }

    private void initFromDiatonicFunctionAddNotes(DiatonicChordMidi self, DiatonicDegree diatonicDegreeBase, DiatonicChordPattern diatonicChordPattern) {
        PitchDiatonicMidi pitchDiatonicMidiBase = PitchDiatonicMidi.from(diatonicDegreeBase, tonality, octave);
        if (pitchDiatonicMidiBase == null)
            throw new RuntimeException();
        for (final Integer diatonic : diatonicChordPattern) {
            PitchDiatonicMidi pitchDiatonicMidi = pitchDiatonicMidiBase.clone();
            pitchDiatonicMidi.shift(diatonic);
            DiatonicMidi diatonicMidi = DiatonicMidi.builder()
                    .pitch(pitchDiatonicMidi)
                    .build();
            self.add(diatonicMidi);
        }
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
