package es.danisales.datune.chords;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityModern;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChordTransformationsTest {
    @Test
    public void getMinDistances_itself() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.C, ChromaticChord.C);
        for(int i : set) {
            assertEquals(0, i);
        }
    }

    @Test
    public void getMinDistances_itself_seventh() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.C7, ChromaticChord.C7);
        for(int i : set) {
            assertEquals(0, i);
        }
    }

    @Test
    public void getMinDistances_C_Dm() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.C, ChromaticChord.Dm);
        assertEquals(2, (int)set.get(0));
        assertEquals(1, (int)set.get(1));
        assertEquals(2, (int)set.get(2));
    }

    @Test
    public void getMinDistances_Dm7_CMaj7() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.Dm7, ChromaticChord.CMaj7);
        assertEquals(2, (int)set.get(0));
        assertEquals(1, (int)set.get(1));
        assertEquals(2, (int)set.get(2));
        assertEquals(0, (int)set.get(3));
    }

    @Test
    public void getMinDistances_FMaj7_CMaj7() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.FMaj7, ChromaticChord.CMaj7);
        assertEquals(1, (int)set.get(0));
        assertEquals(2, (int)set.get(1));
        assertEquals(0, (int)set.get(2));
        assertEquals(0, (int)set.get(3));
    }

    @Test
    public void getMinDistances_GG_C() {
        List<Integer> set = ChordTransformations.getMinDistances(ChromaticChord.GG, ChromaticChord.C);
        assertEquals(1, (int)set.get(0));
        assertEquals(0, (int)set.get(1));
        assertEquals(1, (int)set.get(2));
    }

    @Test
    public void negativeHarmony_CountBlissett_1Triad() {
        ChromaticChord chromaticChord = ChromaticChord.C;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord);

        assertEquals(ChromaticChord.Cm, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_1() {
        ChromaticChord chromaticChord = ChromaticChord.CMaj7;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord);

        assertEquals(ChromaticChord.GGMaj7, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_1Tensions() {
        ChromaticChord chromaticChord = ChromaticChord.Dm;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord, Chromatic.C);

        assertEquals(ChromaticChord.AA, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_1Tonality() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmony(TonalityModern.C);
        assertEquals(Tonality.from(Chromatic.GG, Scale.LYDIAN), tonalityModern);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_VI() {
        ChromaticChord chromaticChord = ChromaticChord.Am7;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord, Chromatic.C);

        assertEquals(ChromaticChord.Cm7, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_VI_Tonality() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmony(TonalityModern.Am, Chromatic.C);
        assertEquals(Tonality.from(Chromatic.C, Scale.AEOLIAN), tonalityModern);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_V() {
        ChromaticChord chromaticChord = ChromaticChord.G7;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord, Chromatic.C);

        assertEquals(ChromaticChord.Dm7b5, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_V_Tonality() {
        TonalityModern result = ChordTransformations.negativeHarmony(TonalityModern.from(Chromatic.G, Scale.MIXOLYDIAN), Chromatic.C);

        assertEquals(TonalityModern.from(Chromatic.D, Scale.LOCRIAN), result);
    }

    @Test
    public void negativeHarmony_CountBlissett_2Triad() {
        ChromaticChord chromaticChord = ChromaticChord.Am;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord, Chromatic.C);

        assertEquals(ChromaticChord.DD, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_II() {
        ChromaticChord chromaticChord = ChromaticChord.Dm7;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord, Chromatic.C);

        assertEquals(ChromaticChord.Gm7, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_II_Tonality() {
        TonalityModern result = ChordTransformations.negativeHarmony(TonalityModern.from(Chromatic.D, Scale.DORIAN), Chromatic.C);

        assertEquals(TonalityModern.from(Chromatic.G, Scale.PHRYGIAN), result);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_III() {
        ChromaticChord chromaticChord = ChromaticChord.Em7;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord, Chromatic.C);

        assertEquals(ChromaticChord.Fm7, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_III_Tonality() {
        TonalityModern result = ChordTransformations.negativeHarmony(TonalityModern.from(Chromatic.E, Scale.PHRYGIAN), Chromatic.C);

        assertEquals(TonalityModern.from(Chromatic.F, Scale.DORIAN), result);
    }


    @Test
    public void negativeHarmony_CountBlissett_C_IV() {
        ChromaticChord chromaticChord = ChromaticChord.FMaj7;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord, Chromatic.C);

        assertEquals(ChromaticChord.DDMaj7, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_IV_Tonality() {
        TonalityModern result = ChordTransformations.negativeHarmony(TonalityModern.from(Chromatic.F, Scale.LYDIAN), Chromatic.C);

        assertEquals(TonalityModern.from(Chromatic.DD, Scale.IONIAN), result);
    }



    @Test
    public void negativeHarmony_CountBlissett_C_VII() {
        ChromaticChord chromaticChord = ChromaticChord.Bm7b5;
        ChromaticChord result = ChordTransformations.negativeHarmony(chromaticChord, Chromatic.C);

        assertEquals(ChromaticChord.AA7, result);
    }

    @Test
    public void negativeHarmony_CountBlissett_C_VII_Tonality() {
        TonalityModern result = ChordTransformations.negativeHarmony(TonalityModern.from(Chromatic.B, Scale.LOCRIAN), Chromatic.C);

        assertEquals(TonalityModern.from(Chromatic.AA, Scale.MIXOLYDIAN), result);
    }

    @Test
    public void negativeHarmony_CountBlissett_Tonality_C() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmonyTonality(TonalityModern.C, Chromatic.C);
        assertEquals(Tonality.from(Chromatic.G, Scale.PHRYGIAN), tonalityModern);
    }

    @Test
    public void negativeHarmony_CountBlissett_Tonality_D_DORIAN() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmonyTonality(TonalityModern.from(Chromatic.D, Scale.DORIAN), Chromatic.C);
        assertEquals(Tonality.from(Chromatic.F, Scale.DORIAN), tonalityModern);
    }

    @Test
    public void negativeHarmony_CountBlissett_Tonality_E_PHRYGIAN() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmonyTonality(TonalityModern.from(Chromatic.E, Scale.PHRYGIAN), Chromatic.C);
        assertEquals(Tonality.from(Chromatic.DD, Scale.IONIAN), tonalityModern);
    }

    @Test
    public void negativeHarmony_CountBlissett_Tonality_F_LYDIAN() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmonyTonality(TonalityModern.from(Chromatic.F, Scale.LYDIAN), Chromatic.C);
        assertEquals(Tonality.from(Chromatic.D, Scale.LOCRIAN), tonalityModern);
    }

    @Test
    public void negativeHarmony_CountBlissett_Tonality_G_MIXOLYDIAN() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmonyTonality(TonalityModern.from(Chromatic.G, Scale.MIXOLYDIAN), Chromatic.C);
        assertEquals(Tonality.from(Chromatic.C, Scale.AEOLIAN), tonalityModern);
    }

    @Test
    public void negativeHarmony_CountBlissett_Tonality_A_AEOLIAN() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmonyTonality(TonalityModern.from(Chromatic.A, Scale.AEOLIAN), Chromatic.C);
        assertEquals(Tonality.from(Chromatic.AA, Scale.MIXOLYDIAN), tonalityModern);
    }

    @Test
    public void negativeHarmony_CountBlissett_Tonality_B_LOCRIAN() {
        TonalityModern tonalityModern = ChordTransformations.negativeHarmonyTonality(TonalityModern.from(Chromatic.B, Scale.LOCRIAN), Chromatic.C);
        assertEquals(Tonality.from(Chromatic.GG, Scale.LYDIAN), tonalityModern);
    }
}