package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.midi.arpegios.Arpegio;
import es.danisales.datune.midi.arpegios.ArpegioDefault;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicChordPattern;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityChordRetrieval;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.datune.tonality.TonalityGetChromaticFunction;
import es.danisales.utils.building.Builder;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkState;

public class DiatonicChordMidiBuilder extends Builder<DiatonicChordMidiBuilder, DiatonicChordMidi> {
    private Tonality tonality = Settings.DefaultValues.TONALITY;
    private int length = Settings.DefaultValues.LENGTH_CHORD;
    private int velocity = Settings.DefaultValues.VELOCITY;
    private HarmonicFunction function;
    private Arpegio arpegio;
    private int octave = Settings.DefaultValues.OCTAVE;

    @NonNull
    @Override
    public DiatonicChordMidi build() {
        DiatonicChordMidi diatonicChordMidi = new DiatonicChordMidi();
        diatonicChordMidi.tonality = Objects.requireNonNull(tonality);

        initFromFunction(diatonicChordMidi);

        diatonicChordMidi.setLength(length);
        diatonicChordMidi.setVelocity(velocity);

        initArpegio(diatonicChordMidi);
        diatonicChordMidi.building = false;

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
            try {
                chromaticFunctionProcess2(diatonicChordMidi);
            } catch (TonalityException | PitchMidiException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        } else if (function instanceof DiatonicFunction)
            initFromDiatonicFunction(diatonicChordMidi);
    }

    private void chromaticFunctionProcess2(DiatonicChordMidi self) throws TonalityException, PitchMidiException {
        ChromaticFunction chromaticFunction = (ChromaticFunction) function;
        ChromaticChord chromaticChord = TonalityGetChromaticFunction.get(self.tonality, chromaticFunction);
        tonality = TonalityGetChromaticFunction.getTonalityFromChromaticFunction(tonality, chromaticFunction);
        self.tonality = Objects.requireNonNull(tonality, chromaticFunction.toString());

        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder()
                .fromChromatic(chromaticChord)
                .length(length)
                .velocity(velocity)
                .octaveBase(octave)
                .build();

        self.addAll(chromaticChordMidi);
    }

    /*
        protected void chromaticFunctionProcess(DiatonicChordMidi self) throws TonalityException, PitchMidiException {
            ChromaticFunction t = (ChromaticFunction) function;
            if (t == ChromaticFunction.N6) {
                ChromaticChordInterface cc = ChromaticChordInterface.from(t, tonality);

                tonality = TonalityRetrieval.listFromChord(cc).getCyclic(0);

                ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder()
                        .fromChromatic(cc)
                        .octaveBase(octave)
                        .length(length)
                        .build();

                self.addAll(chromaticChordMidi);
            } else if (ArrayUtils.contains(t, ChromaticFunction.POWER_CHORDS)) {
                DiatonicDegree d = DiatonicDegree.from(t);

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
                try {
                    n2.getPitch().shift(IntervalChromatic.PERFECT_FIFTH);
                } catch (PitchMidiException e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
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
                        Chromatic firstChromatic = Chromatic.from(c.getCyclic(0));
                        tonality = Tonality.from(
                                firstChromatic.getWithSemiAdded(6), Scale.LYDIAN_b7
                        );
                        break;
                    case SUBV7_II:
                        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                                .from(
                                        ChromaticFunction.V7_II, tonality
                                ).build();
                        Chromatic firstChromatic2 = Chromatic.from(c2.getCyclic(0));
                        tonality = Tonality.from(
                                firstChromatic2.getWithSemiAdded(6), Scale.LYDIAN_b7
                        );
                        break;
                    case SUBV7_III:
                        DiatonicChordMidi c3 = DiatonicChordMidi.builder()
                                .from(
                                        ChromaticFunction.V7_III, tonality
                                ).build();
                        Chromatic firstChromatic3 = Chromatic.from(c3.getCyclic(0));
                        tonality = Tonality.from(
                                firstChromatic3.getWithSemiAdded(6), Scale.LYDIAN_b7
                        );
                        break;
                    case SUBV7_IV:
                        DiatonicChordMidi c4 = DiatonicChordMidi.builder()
                                .from(
                                        ChromaticFunction.V7_IV, tonality
                                ).build();
                        Chromatic firstChromatic4 = Chromatic.from(c4.getCyclic(0));
                        tonality = Tonality.from(
                                firstChromatic4.getWithSemiAdded(6), Scale.LYDIAN_b7
                        );
                        break;
                    case SUBV7_V:
                        DiatonicChordMidi c5 = DiatonicChordMidi.builder()
                                .from(
                                        ChromaticFunction.V7_V, tonality
                                ).build();
                        Chromatic firstChromatic5 = Chromatic.from(c5.getCyclic(0));
                        tonality = Tonality.from(
                                firstChromatic5.getWithSemiAdded(6), Scale.LYDIAN_b7
                        );
                        break;
                    case SUBV7_VI:
                        DiatonicChordMidi c6 = DiatonicChordMidi.builder()
                                .from(
                                        ChromaticFunction.V7_VI, tonality
                                ).build();
                        Chromatic firstChromatic6 = Chromatic.from(c6.getCyclic(0));
                        tonality = Tonality.from(
                                firstChromatic6.getWithSemiAdded(6), Scale.LYDIAN_b7
                        );
                        break;
                    case V7ALT:
                        DiatonicChordMidi calt = DiatonicChordMidi.builder()
                                .from(
                                        DiatonicFunction.V7, tonality
                                ).build();
                        Chromatic firstChromaticAlt = Chromatic.from(calt.getCyclic(0));
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

                if (tonality.size() != Diatonic.NUMBER)
                    throw new RuntimeException("DiatonicFunction is for function scales. Actual: " + self.metaTonality + " " + function + " size=" + tonality.size());

                    function = t2;
                    initFromDiatonicFunction(self);
                    function = t;
            } else {
                ChromaticChordInterface chromaticChordInterface = ChromaticChordInterface.from(t, tonality);

                ChromaticMidi[] ccmArray = new ChromaticMidi[chromaticChordInterface.size()];
                int i = 0;
                for (Chromatic chromatic : chromaticChordInterface) {
                    ChromaticMidi cm = ChromaticMidi.builder()
                            .pitch(chromatic)
                            .build();
                    ccmArray[i++] = cm;
                }

                ChromaticChordMidi ccm = ChromaticChordMidi.builder().fromChromaticMidi(ccmArray).build();

                if (tonality.hasAsDiatonicFunction(chromaticChordInterface))
                    self.addAll(ccm);
                else {
                    self.metaTonality = TonalityChordRetrieval.searchInModeSameRoot(tonality, chromaticChordInterface);
                    if (self.metaTonality == null)
                        throw new RuntimeException();
                    self.tonality = self.metaTonality;

                    self.addAll(ccm);
                }
            }

            self.sortByPitch();
        }
    */
    private void initFromDiatonicFunction(DiatonicChordMidi diatonicChordMidi) {
        DiatonicFunction diatonicFunction = (DiatonicFunction) function;
        DiatonicChordPattern diatonicChordPattern = DiatonicChordPattern.from(diatonicFunction);
        DiatonicDegree diatonicDegree = DiatonicDegree.from(diatonicFunction);
        initFromDiatonicFunctionAddNotes(diatonicChordMidi, diatonicDegree, diatonicChordPattern);
        diatonicChordMidi.setRootIndex(0);
    }

    private void initFromDiatonicFunctionAddNotes(DiatonicChordMidi self, DiatonicDegree diatonicDegreeBase, DiatonicChordPattern diatonicChordPattern) {
        PitchDiatonicMidi pitchDiatonicMidiBase;
        try {
            pitchDiatonicMidiBase = PitchDiatonicMidi.from(diatonicDegreeBase, tonality, octave);
        } catch (PitchMidiException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        for (final Integer diatonic : diatonicChordPattern) {
            PitchDiatonicMidi pitchDiatonicMidi = pitchDiatonicMidiBase.clone();
            pitchDiatonicMidi.shift(diatonic);
            DiatonicMidi diatonicMidi = DiatonicMidi.builder()
                    .pitch(pitchDiatonicMidi)
                    .build();
            self.add(diatonicMidi);
        }
        self.building = false;
    }

    public DiatonicChordMidiBuilder tonality(@NonNull Tonality tonality) {
        this.tonality = tonality;

        return self();
    }

    public DiatonicChordMidiBuilder from(@NonNull HarmonicFunction harmonicFunction, @NonNull Tonality tonality) {
        this.function = Objects.requireNonNull(harmonicFunction);
        this.tonality = Objects.requireNonNull(tonality);

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

    public DiatonicChordMidiBuilder from(@NonNull ChromaticChord chromaticChord, @NonNull Tonality tonality) {
        HarmonicFunction f = tonality.getFunctionFrom(chromaticChord);
        checkState(f != null);
        function = f;

        return self();
    }

    // todo: integrate into builder
    public static @NonNull List<DiatonicChordMidiInfo> fromChromaticChord(ChromaticChord chromaticChord, boolean outScale) {
        if (outScale)
            return DiatonicChordMidiAdapter.fromChromaticChordAll(chromaticChord);
        else
            return DiatonicChordMidiAdapter.fromChromaticChordDiatonic(chromaticChord);
    }

    // todo: integrate
    public static DiatonicChordMidi from(@NonNull List<DiatonicMidi> diatonicMidiList) {
        DiatonicChordMidi diatonicChordMidi = new DiatonicChordMidi();
        diatonicChordMidi.tonality = diatonicMidiList.get(0).getPitch().getTonality();
        diatonicChordMidi.addAll(diatonicMidiList);
        diatonicChordMidi.building = false;

        return diatonicChordMidi;
    }

    // todo: integrate into builder
    public static DiatonicChordMidi from(Tonality ton, @NonNull ChromaticChord ns) {
        DiatonicChordMidi diatonicChordMidi = new DiatonicChordMidi();
        diatonicChordMidi.tonality = ton;
/*
        if ( ns instanceof ChordMidi )
            meta = ( (ChordMidi) ns ).meta;
*/
        try {
            for (Chromatic chromatic : ns) {
                ChromaticMidi cm = ChromaticMidi.builder()
                        .pitch(chromatic)
                        .length(Settings.DefaultValues.LENGTH_CHORD)
                        .build();
                diatonicChordMidi.add(cm);
            }
        } catch (TonalityException e) {
            diatonicChordMidi.clear();

            diatonicChordMidi.tonality = TonalityChordRetrieval.searchInModeSameRoot(diatonicChordMidi.tonality, ns);

            checkState(diatonicChordMidi.tonality != null);

            try {
                ChromaticChordMidi c = ChromaticChordMidi.builder().fromChromatic(ns).build();
                diatonicChordMidi.addAll(c);
            } catch (TonalityException | PitchMidiException e1) {
                throw new RuntimeException();
            }
        }

        diatonicChordMidi.setRootIndex(ns.getRootIndex());

        diatonicChordMidi.setRootIndex(ns.getRootIndex());
/*
        if ( ns instanceof ChordMidi ) {
            arpegio = ( (ChordMidi) ns ).arpegio;
            length = ( (ChordMidi) ns ).length;
        }
*/
        diatonicChordMidi.setArpegioIfNull();
        diatonicChordMidi.building = false;

        return diatonicChordMidi;
    }


    @NonNull
    @Override
    protected DiatonicChordMidiBuilder self() {
        return this;
    }
}
