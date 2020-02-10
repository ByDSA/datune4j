package es.danisales.datune.chords.chromatic;

import es.danisales.datune.GlobalSettings;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.lang.Language;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("unused")
public class ChromaticChordNamesTest {
    static {
        GlobalSettings.sigleton().setLanguage(Language.EN);
    }

    public static class FromParametricChord {
        private static TonalChord parametricChord;
        private static ChromaticChord chromaticChord;

        static void updateChromaticChord() {
            chromaticChord = ChromaticChord.from(parametricChord).clone();
        }

        @Test
        public void C_I() {
            parametricChord = TonalChord.from(Tonality.C, DiatonicFunction.I);
            updateChromaticChord();

            assertEquals("C", chromaticChord.toString());
        }

        @Test
        public void Cm_I() {
            parametricChord = TonalChord.from(Tonality.Cm, DiatonicFunction.I);
            updateChromaticChord();

            assertEquals("Cm", chromaticChord.toString());
        }

        @Test
        public void C_I_inv() {
            parametricChord = TonalChord.from(Tonality.C, DiatonicFunction.I);
            updateChromaticChord();
            chromaticChord.inv();

            assertEquals("C/E", chromaticChord.toString());
        }

        @Test
        public void C_I_inv2() {
            parametricChord = TonalChord.from(Tonality.C, DiatonicFunction.I);
            updateChromaticChord();
            chromaticChord.inv(2);

            assertEquals("C/G", chromaticChord.toString());
        }

        @Test
        public void C_I_inv3() {
            parametricChord = TonalChord.from(Tonality.ET12.C, DiatonicFunction.I);
            updateChromaticChord();
            chromaticChord.inv(3);

            assertEquals("C", chromaticChord.toString());
        }

        @Test
        public void C_IV5() {
            parametricChord = TonalChord.from(Tonality.ET12.C, ChromaticDegreeFunction.IV5);
            updateChromaticChord();

            assertEquals("F5", chromaticChord.toString());
        }

        @Test
        public void C_IV5_inv() {
            parametricChord = TonalChord.from(Tonality.ET12.C, ChromaticDegreeFunction.IV5);
            updateChromaticChord();
            chromaticChord.inv();

            assertEquals("F5/C", chromaticChord.toString());
        }

        @Test
        public void C_VSUS4() {
            parametricChord = TonalChord.from(Tonality.ET12.C, ChromaticDegreeFunction.VSUS4);
            updateChromaticChord();

            assertEquals("Gsus4", chromaticChord.toString());
        }

        @Test
        public void C_VSUS4_inv() {
            parametricChord = TonalChord.from(Tonality.ET12.C, ChromaticDegreeFunction.VSUS4);
            updateChromaticChord();
            chromaticChord.inv();

            assertEquals("Gsus4/C", chromaticChord.toString());
        }
    }
/*
    @Test
    public void names() throws PitchException, BuildingException {
        TonalChord parametricChord = TonalChord.from(Tonality.C, DiatonicFunction.I);
        ChromaticChord chromaticChord = ChromaticChord.from(parametricChord);

        chromaticChord = ChromaticChord.builder().addAll(
                Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.G)
                ;
        parametricChord = DiatonicChordMidi.builder()
                .from(chromaticChord, Tonality.C)
                .build();
        assertEquals("Csus2 (ISUS2)", parametricChord.toString());
    }
*/
    public static class Fixed {
        @Test
        public void F5() {
            GlobalSettings.sigleton().setLanguage(Language.EN);

            assertEquals("F5", ChromaticChord.F5.toString());
        }
    }
}
