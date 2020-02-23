package es.danisales.datune.chords.chromatic;

import es.danisales.datune.GlobalSettings;
import es.danisales.datune.chords.ChordTransformations;
import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.lang.Language;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.BuildingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

public class ChromaticChordTest {
    /* Building */
    @Test
    public void from() {
        ChromaticChord chromaticChord = ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.E)).build();
        assertNotNull(chromaticChord);

        assertEquals(3, chromaticChord.size());
        assertEquals(0, chromaticChord.getRootIndex());
        assertEquals(Chromatic.C, chromaticChord.get(0));
        assertEquals(Chromatic.D, chromaticChord.get(1));
        assertEquals(Chromatic.E, chromaticChord.get(2));
    }

    @Test
    public void fromChromaticDiatonicChordTonality() {
        ChromaticChord chromaticChord = ChromaticChord.builder()
                .diatonicDegreePattern(DiatonicDegreePattern.VII9)
                .tonality(Tonality.C)
                .build();
        assertEquals( Arrays.asList(
                Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C),
                chromaticChord
        );
    }

    public static class BuilderTest {
        @Test
        public void fromFunction() throws ScaleRelativeDegreeException {
            ChromaticChord chromaticChord = DiatonicFunction.I.getChromaticChordFromTonality(Tonality.C);

            assertEquals(ChromaticChord.C, chromaticChord);
        }

        @Test
        public void fromFunction_bVII() throws ScaleRelativeDegreeException {
            ChromaticChord chromaticChord = ChromaticDegreeFunction.bVII.getChromaticChordFromTonality(Tonality.C);

            ChromaticChord chromaticChordReference = ChromaticChord.AA;

            assertEquals(chromaticChordReference, chromaticChord);
        }

        @Test
        public void fromFunction_bVI() throws ScaleRelativeDegreeException {
            ChromaticChord chromaticChord = ChromaticDegreeFunction.bVI.getChromaticChordFromTonality(Tonality.C);

            ChromaticChord chromaticChordReference = ChromaticChord.GG;

            assertEquals(chromaticChordReference, chromaticChord);
        }

        @Test
        public void fromInterval_C_I_Third() {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .intervalDiatonic(IntervalDiatonic.THIRD)
                    .tonality(Tonality.C)
                    .build();

            assertEquals(2, chromaticChord.size());
            assertEquals(Chromatic.C, chromaticChord.get(0));
            assertEquals(Chromatic.E, chromaticChord.get(1));
        }

        @Test
        public void fromInterval_C_VII_Second() {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .intervalDiatonic(DiatonicDegree.VII, IntervalDiatonic.SECOND)
                    .tonality(Tonality.C)
                    .build();

            assertEquals(2, chromaticChord.size());
            assertEquals(Chromatic.B, chromaticChord.get(0));
            assertEquals(Chromatic.C, chromaticChord.get(1));
        }

        @Test
        public void fromInterval_Cm_I_Third() {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .intervalDiatonic(IntervalDiatonic.THIRD)
                    .tonality(Tonality.Cm)
                    .build();

            assertEquals(2, chromaticChord.size());
            assertEquals(Chromatic.C, chromaticChord.get(0));
            assertEquals(Chromatic.DD, chromaticChord.get(1));
        }

        static void assertPitchInChord(Chromatic chromatic, ChromaticChord chromaticChord, int pos) {
            assertEquals(chromatic, chromaticChord.get(pos));
        }

        @Test
        public void fromDiatonicFunction3() {
            ChromaticChord diatonicChordMidi = ChromaticChord.builder()
                    .intervalDiatonic(IntervalDiatonic.THIRD)
                    .tonality(Tonality.Gm)
                    .build();
            Assert.assertEquals(2, diatonicChordMidi.size());
            assertPitchInChord(Chromatic.G, diatonicChordMidi, 0);
            assertPitchInChord(Chromatic.AA, diatonicChordMidi, 1);
        }

        @Test
        public void fromDiatonicFunction4() {
            ChromaticChord diatonicChordMidi = ChromaticChord.builder()
                    .intervalDiatonic(DiatonicDegree.II, IntervalDiatonic.THIRD)
                    .tonality(Tonality.Gm)
                    .build();
            Assert.assertEquals(2, diatonicChordMidi.size());
            assertPitchInChord(Chromatic.A, diatonicChordMidi, 0);
            assertPitchInChord(Chromatic.C, diatonicChordMidi, 1);
        }

        @Test
        public void fromDiatonicFunction5() {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .intervalDiatonic(DiatonicDegree.VI, IntervalDiatonic.THIRD)
                    .tonality(Tonality.Gm)
                    .build();
            Assert.assertEquals(2, chromaticChord.size());
            assertPitchInChord(Chromatic.DD, chromaticChord, 0);
            assertPitchInChord(Chromatic.G, chromaticChord, 1);
        }

        @Test
        public void fromChromaticFunction_ISUS4() throws ScaleRelativeDegreeException {
            ChromaticChord chromaticChord = ChromaticDegreeFunction.ISUS4.getChromaticChordFromTonality(Tonality.C);
            Assert.assertEquals(3, chromaticChord.size());
            assertPitchInChord(Chromatic.C, chromaticChord, 0);
            assertPitchInChord(Chromatic.F, chromaticChord, 1);
            assertPitchInChord(Chromatic.G, chromaticChord, 2);
        }
    }

    // Fuente: https://es.wikipedia.org/wiki/Anexo:Especies_de_acordes
    @Test
    public void contentImmutableChords() {
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.G
        ), ChromaticChord.C5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G
        ), ChromaticChord.C);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G
        ), ChromaticChord.Cm);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG
        ), ChromaticChord.Caug);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.FF
        ), ChromaticChord.Cdim);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G
        ), ChromaticChord.Csus4);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA
        ), ChromaticChord.C7);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA
        ), ChromaticChord.C7b5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.AA
        ), ChromaticChord.C7a5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.AA
        ), ChromaticChord.C7sus4);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA
        ), ChromaticChord.Cm7);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.FF,
                Chromatic.AA
        ), ChromaticChord.Cm7b5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.GG,
                Chromatic.AA
        ), ChromaticChord.Cm7a5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.A
        ), ChromaticChord.C6);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.A
        ), ChromaticChord.C6sus4);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B
        ), ChromaticChord.CMaj7);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B
        ), ChromaticChord.CmMaj7);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.A,
                Chromatic.D
        ), ChromaticChord.C6add9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.A,
                Chromatic.D
        ), ChromaticChord.Cm6add9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC
        ), ChromaticChord.C7b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.DD
        ), ChromaticChord.C7a9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC
        ), ChromaticChord.Cm7b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC
        ), ChromaticChord.Cm7b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.F
        ), ChromaticChord.C7add11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.A
        ), ChromaticChord.C7add13);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.Cm9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9b5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9a5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9sus4);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D
        ), ChromaticChord.CMaj9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D
        ), ChromaticChord.CmMaj9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.A,
                Chromatic.AA,
                Chromatic.D
        ), ChromaticChord.C9add6);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.FF
        ), ChromaticChord.C9a11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.FF
        ), ChromaticChord.CMaj9a11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F
        ), ChromaticChord.C11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F
        ), ChromaticChord.Cm11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.F
        ), ChromaticChord.C11b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.DD,
                Chromatic.F
        ), ChromaticChord.C11a9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F
        ), ChromaticChord.CMaj11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F
        ), ChromaticChord.CmMaj11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.Cm13);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.Cm13omit11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13sus4);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.F,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.C13sus4omit11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13b5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.C13b5omit11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13a5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.AA,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.C13a5omit11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.A
        ), ChromaticChord.C13b9omit11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13a9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.AA,
                Chromatic.DD,
                Chromatic.A
        ), ChromaticChord.C13a9omit11);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.C13b5b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.AA,
                Chromatic.CC,
                Chromatic.A
        ), ChromaticChord.C13b5b9omit11);

        // Do treceava mayor
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.CMaj13omit11);

        // Do menor treceava mayor
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CmMaj13);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.DD,
                Chromatic.G,
                Chromatic.B,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.CmMaj13omit11);

        // Do treceava mayor con quinta bemol
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.D,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13b5);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.D,
                Chromatic.A
        ), ChromaticChord.CMaj13b5omit11);

        // Do treceava mayor con quinta aumentada
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13a9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.A
        ), ChromaticChord.CMaj13a9omit11);

        // Do treceava mayor con novena bemol
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.A
        ), ChromaticChord.CMaj13b9omit11);


        // Do treceava mayor con novena aumentada
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13a9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.G,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.A
        ), ChromaticChord.CMaj13a9omit11);

        // Do treceava mayor con quinta y novena bemoles
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13b5b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.A
        ), ChromaticChord.CMaj13b5b9omit11);

        // Do treceava mayor con quinta bemol y novena aumentada
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13b5a9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.FF,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.A
        ), ChromaticChord.CMaj13b5a9omit11);

        //Do treceava mayor con quinta aumentada y novena bemol
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13a5b9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.B,
                Chromatic.CC,
                Chromatic.A
        ), ChromaticChord.CMaj13a5b9omit11);

        // Do treceava mayor con quinta y novena aumentadas
        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.F,
                Chromatic.A
        ), ChromaticChord.CMaj13a5a9);

        Assert.assertEquals(Arrays.asList(
                Chromatic.C,
                Chromatic.E,
                Chromatic.GG,
                Chromatic.B,
                Chromatic.DD,
                Chromatic.A
        ), ChromaticChord.CMaj13a5a9omit11);

    }

    @Test
    public void getCyclic_above() {
        ChromaticChord chromaticChord = ChromaticChord.C;
        assertEquals(Chromatic.C, chromaticChord.getCyclic(3));
    }

    @Test
    public void getCyclic_below() {
        ChromaticChord chromaticChord = ChromaticChord.C;
        assertEquals(Chromatic.G, chromaticChord.getCyclic(-1));
    }

    public static class InheritChord {
        /* Root */
        @Test
        public void getRootIndex_initialIsZero() {
            for (DiatonicFunction function : DiatonicFunction.immutableValues()) {
                TonalChord parametricChord1 = TonalChord.from(Tonality.C, function);
                ChromaticChord chromaticChord1 = ChromaticChord.from(parametricChord1);
                assertEquals(0, chromaticChord1.getRootIndex());
            }
        }

        @Test
        public void getRoot_fromPrecalculated() {
            assertEquals(Chromatic.C, ChromaticChord.C.getRoot());
        }

        @Test
        public void getRoot_fromInv() {
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            chromaticChord.inv();
            assertEquals(1, chromaticChord.getInversionNumber());
        }

        @Test
        public void getRootIndex_fromInv() {
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            chromaticChord.inv();
            assertEquals(2, chromaticChord.getRootIndex());
        }

        @Test(expected = UnsupportedOperationException.class)
        public void resetRoot_immutable() {
            ChromaticChord.C.resetRoot();
        }

        @Test(expected = UnsupportedOperationException.class)
        public void resetRoot_mutable() {
            ChromaticChord.C.resetRoot();
        }

        /* Inversion */
        @Test
        public void getInversionNumber_initialIsZero() {
            for (DiatonicFunction function : DiatonicFunction.immutableValues()) {
                TonalChord parametricChord1 = TonalChord.from(Tonality.C, function);
                ChromaticChord chromaticChord1 = ChromaticChord.from(parametricChord1);
                assertEquals(0, chromaticChord1.getInversionNumber());
            }
        }

        @Test
        public void inv() {
            ChromaticChord chromaticChord = ChromaticChord.Gsus4.clone();
            chromaticChord.inv();
            assertEquals(Arrays.asList(
                    Chromatic.C,
                    Chromatic.D,
                    Chromatic.G
                    ),
                    chromaticChord
            );
            assertEquals(2, chromaticChord.getRootIndex());
            chromaticChord.inv(2);
            assertEquals(Arrays.asList(
                    Chromatic.G,
                    Chromatic.C,
                    Chromatic.D
                    ),
                    chromaticChord
            );
            assertEquals(0, chromaticChord.getRootIndex());
        }

        @Test
        public void over() {
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            chromaticChord.over(Chromatic.G);

            assertEquals(Chromatic.G, chromaticChord.get(0));
            assertEquals(2, chromaticChord.getInversionNumber());
        }

        @Test
        public void toFundamental() {
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            chromaticChord.inv();
            assertNotEquals(ChromaticChord.C, chromaticChord);

            chromaticChord.toFundamental();
            assertEquals(ChromaticChord.C, chromaticChord);
        }

        @Test
        public void getAllInversions() throws BuildingException {
            List<ChromaticChord> listChromaticChords = ChordTransformations.getAllInversionsFrom(ChromaticChord.C);

            ChromaticChord original = ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)).build();
            ChromaticChord inv1 = ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C)).build();
            inv1.setRootIndex(2);
            ChromaticChord inv2 = ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E)).build();
            inv2.setRootIndex(1);

            assertEquals(
                    Arrays.asList(original, inv1, inv2),
                    listChromaticChords
            );
        }

        /* Immutable */
        @Test
        public void isImmutable_precalculatedChord() {
            assertTrue(ChromaticChord.C.isImmutable());
        }

        @Test
        public void isImmutable_clonedImmutable() {
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            assertFalse(chromaticChord.isImmutable());
        }
    }

    public static class InheritListProxy {
        @Test
        public void set() {
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            chromaticChord.set(1, Chromatic.DD);

            assertEquals(Chromatic.DD, chromaticChord.get(1));
        }

        /* Precalculated Chords */
        @Test
        public void size_precalculated() {
            for (ChromaticChord c : ChromaticChord.CHORDS_FIFTH)
                Assert.assertEquals(2, c.size());

            for (ChromaticChord c : ChromaticChord.TRIAD_CHORDS)
                Assert.assertEquals(3, c.size());

            for (ChromaticChord c : ChromaticChord.SEVENTH_CHORDS)
                if (ChromaticChord.CHORDS_7add11.contains(c) || ChromaticChord.CHORDS_7add13.contains(c))
                    Assert.assertEquals(c.toString(), 5, c.size());
                else
                    Assert.assertEquals(c.toString(), 4, c.size());

            for (ChromaticChord c : ChromaticChord.NINTH_CHORDS)
                if (ChromaticChord.CHORDS_9add6.contains(c) || ChromaticChord.CHORDS_9a11.contains(c) || ChromaticChord.CHORDS_Maj9a11.contains(c))
                    Assert.assertEquals(c.toString(), 6, c.size());
                else
                    Assert.assertEquals(c.toString(), 5, c.size());

            for (ChromaticChord c : ChromaticChord.ELEVENTH_CHORDS)
                Assert.assertEquals(c.toString(), 6, c.size());

            for (ChromaticChord c : ChromaticChord.THIRTEENTH_CHORDS)
                Assert.assertTrue(c.toString(), c.size() == 6 || c.size() == 7);
        }

        @Test(expected = UnsupportedOperationException.class)
        public void set_precalculated() {
            ChromaticChord chromaticChord = ChromaticChord.C;
            chromaticChord.set(1, Chromatic.DD);
        }

    }

    public static class InheritObject {
        /* Clone Mutable */
        @Test
        public void clone_mutable() throws BuildingException {
            ChromaticChord chromaticChord = ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.E)).build();
            ChromaticChord duplicatedChromaticChord = chromaticChord.clone();

            assertEquals(chromaticChord, duplicatedChromaticChord);

            chromaticChord.set(2, Chromatic.G);

            assertNotEquals(chromaticChord, duplicatedChromaticChord);
        }

        @Test
        public void inv_clonedMutable() throws BuildingException {
            ChromaticChord chromaticChord = ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.D)).build();
            chromaticChord.inv();
            ChromaticChord duplicatedChromaticChord = chromaticChord.clone();

            assertEquals(chromaticChord, duplicatedChromaticChord);
        }

        /* Clone Immutable */
        @Test
        public void cloneAndSet_immutable() {
            ChromaticChord chromaticChord = ChromaticChord.C.clone();

            chromaticChord.set(1, Chromatic.DD);

            assertNotEquals(ChromaticChord.C, chromaticChord);
        }

        @Test
        public void clone_immutable() {
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            assertEquals(ChromaticChord.C, chromaticChord);
            assertNotSame(ChromaticChord.C, chromaticChord);
        }

        /* Equals */
        @Test
        public void equals_self() {
            assertEquals(ChromaticChord.C, ChromaticChord.C);
            assertSame(ChromaticChord.C, ChromaticChord.C);
        }

        @Test
        public void equals_sameNotesDifferentRoot() {
            TonalChord parametricChord1 = TonalChord.from(Tonality.C, DiatonicFunction.I7);
            TonalChord parametricChord2 = TonalChord.from(Tonality.C, DiatonicFunction.III6);
            ChromaticChord chromaticChord1 = ChromaticChord.from(parametricChord1);
            ChromaticChord chromaticChord2 = ChromaticChord.from(parametricChord2);

            assertNotEquals(chromaticChord1, chromaticChord2);
            assertNotEquals(chromaticChord2, chromaticChord1);
        }

        /* toString: Precalculated Chords */

        @Test
        public void names_ES() {
            GlobalSettings.sigleton().setLanguage(Language.ES);
            assertEquals("Do", ChromaticChord.C.toString());
            assertEquals("Dom", ChromaticChord.Cm.toString());
            assertEquals("Do7", ChromaticChord.C7.toString());
            assertEquals("Fa5", ChromaticChord.F5.toString());
            assertEquals("Solsus4", ChromaticChord.Gsus4.toString());
            assertEquals("Do13#5#9", ChromaticChord.C13a5a9.toString());
            assertEquals("Do#13#5b9 (omit11)", ChromaticChord.CC13a5b9omit11.toString());
        }

        @Test
        public void names_EN() {
            GlobalSettings.sigleton().setLanguage(Language.EN);
            assertEquals("C", ChromaticChord.C.toString());
            assertEquals("Cm", ChromaticChord.Cm.toString());
            assertEquals("C7", ChromaticChord.C7.toString());
            assertEquals("F5", ChromaticChord.F5.toString());
            assertEquals("Gsus4", ChromaticChord.Gsus4.toString());
            assertEquals("C13#5#9", ChromaticChord.C13a5a9.toString());
            assertEquals("C#13#5b9 (omit11)", ChromaticChord.CC13a5b9omit11.toString());
        }

        /* toString: autoname */
        @Test
        public void namesFrom() throws BuildingException {
            ChromaticChord cc = ChromaticChord.builder().addAll(
                    Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)
            ).build();

            GlobalSettings.sigleton().setLanguage(Language.EN);
            assertEquals("C", cc.toString());
            GlobalSettings.sigleton().setLanguage(Language.ES);
            assertEquals("Do", cc.toString());

            cc = ChromaticChord.builder().addAll(
                    Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA)
            ).build();
            GlobalSettings.sigleton().setLanguage(Language.EN);
            assertEquals("C7", cc.toString());
            GlobalSettings.sigleton().setLanguage(Language.ES);
            assertEquals("Do7", cc.toString());
        }

        @Test
        public void namesInv_EN() {
            GlobalSettings.sigleton().setLanguage(Language.EN);
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            chromaticChord.inv();
            assertEquals("C/E", chromaticChord.toString());
            chromaticChord.inv();
            assertEquals("C/G", chromaticChord.toString());
            chromaticChord.inv();
            assertEquals("C", chromaticChord.toString());

            chromaticChord = ChromaticChord.F5.clone();
            chromaticChord.inv();
            assertEquals("F5/C", chromaticChord.toString());

            chromaticChord = ChromaticChord.Gsus4.clone();
            chromaticChord.inv();
            assertEquals("Gsus4/C", chromaticChord.toString());
        }

        @Test
        public void namesInv_ES() {
            GlobalSettings.sigleton().setLanguage(Language.ES);
            ChromaticChord chromaticChord = ChromaticChord.C.clone();
            chromaticChord.inv();
            assertEquals("Do/Mi", chromaticChord.toString());
            chromaticChord.inv();
            assertEquals("Do/Sol", chromaticChord.toString());
            chromaticChord.inv();
            assertEquals("Do", chromaticChord.toString());

            chromaticChord = ChromaticChord.F5.clone();
            chromaticChord.inv();
            assertEquals("Fa5/Do", chromaticChord.toString());

            chromaticChord = ChromaticChord.Gsus4.clone();
            chromaticChord.inv();
            assertEquals("Solsus4/Do", chromaticChord.toString());
        }
    }
}
