package es.danisales.datune.chords;

import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.lang.Language;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("unused")
public class ChromaticChordNamesTest {
    static {
        Language.current = Language.ENG;
    }

    public static class FromParametricChord {
        private static ParametricChord parametricChord;
        private static ChromaticChord chromaticChord;

        static void updateChromaticChord() {
            chromaticChord = ChromaticChord.immutableFrom(parametricChord);
            if (chromaticChord.innerChord instanceof ChromaticChordImmutable)
                chromaticChord = chromaticChord.clone();
        }

        @Test
        public void C_I() {
            parametricChord = ParametricChord.from(Tonality.C, DiatonicFunction.I);
            updateChromaticChord();

            assertEquals("C", chromaticChord.toString());
        }

        @Test
        public void Cm_I() {
            parametricChord = ParametricChord.from(Tonality.Cm, DiatonicFunction.I);
            updateChromaticChord();

            assertEquals("Cm", chromaticChord.toString());
        }

        @Test
        public void C_I_inv() {
            parametricChord = ParametricChord.from(Tonality.C, DiatonicFunction.I);
            updateChromaticChord();
            chromaticChord.inv();

            assertEquals("C/E", chromaticChord.toString());
        }

        @Test
        public void C_I_inv2() {
            parametricChord = ParametricChord.from(Tonality.C, DiatonicFunction.I);
            updateChromaticChord();
            chromaticChord.inv(2);

            assertEquals("C/G", chromaticChord.toString());
        }

        @Test
        public void C_I_inv3() {
            parametricChord = ParametricChord.from(Tonality.C, DiatonicFunction.I);
            updateChromaticChord();
            chromaticChord.inv(3);

            assertEquals("C", chromaticChord.toString());
        }

        @Test
        public void C_IV5() {
            parametricChord = ParametricChord.from(Tonality.C, ChromaticFunction.IV5);
            updateChromaticChord();

            assertEquals("F5", chromaticChord.toString());
        }

        @Test
        public void C_IV5_inv() {
            parametricChord = ParametricChord.from(Tonality.C, ChromaticFunction.IV5);
            updateChromaticChord();
            chromaticChord.inv();

            assertEquals("F5/C", chromaticChord.toString());
        }

        @Test
        public void C_VSUS4() {
            parametricChord = ParametricChord.from(Tonality.C, ChromaticFunction.VSUS4);
            updateChromaticChord();

            assertEquals("Gsus4", chromaticChord.toString());
        }

        @Test
        public void C_VSUS4_inv() {
            parametricChord = ParametricChord.from(Tonality.C, ChromaticFunction.VSUS4);
            updateChromaticChord();
            chromaticChord.inv();

            assertEquals("Gsus4/C", chromaticChord.toString());
        }
    }
/*
    @Test
    public void names() throws PitchException, BuildingException {
        ParametricChord parametricChord = ParametricChord.immutableFrom(Tonality.C, DiatonicFunction.I);
        ChromaticChord chromaticChord = ChromaticChord.immutableFrom(parametricChord);

        chromaticChord = ChromaticChord.builder().addAll(
                Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.G)
                ;
        parametricChord = DiatonicChordMidi.builder()
                .immutableFrom(chromaticChord, Tonality.C)
                .build();
        assertEquals("Csus2 (ISUS2)", parametricChord.toString());
    }
*/
    public static class Fixed {
        @Test
        public void F5() {
            Language.current = Language.ENG;

            assertEquals("F5", ChromaticChord.F5.toString());
        }
    }
}
