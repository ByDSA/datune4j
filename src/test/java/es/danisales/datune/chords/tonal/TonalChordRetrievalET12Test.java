package es.danisales.datune.chords.tonal;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.TonalityModern;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TonalChordRetrievalET12Test {
    private static void contains(List<TonalChord> parametricChordExpectedList, List<TonalChord> parametricChordActualList) {
        assertTrue(parametricChordExpectedList.containsAll(parametricChordActualList));
    }

    @Test
    public void C_in_C() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.C)
                .harmonicFunctions(DiatonicFunction.immutableValues())
                .tonalities(TonalityModern.C)
                .retrieve();

        assertEquals(1, parametricChordList.size());
        contains(parametricChordList,
                Collections.singletonList(
                        TonalChord.from(TonalityModern.C, DiatonicFunction.I)
                )
        );
    }

    @Test
    public void C_in_C_Am() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.C)
                .allDiatonicFunctions()
                .tonalities(TonalityModern.C, TonalityModern.Am)
                .retrieve();

        assertEquals(2, parametricChordList.size());
        contains(parametricChordList,
                Arrays.asList(
                        TonalChord.from(TonalityModern.C, DiatonicFunction.I),
                        TonalChord.from(TonalityModern.Am, DiatonicFunction.III)
                )
        );
    }

    @Test
    public void C_in_12ET_MAJOR_MINOR() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.C)
                .allDiatonicFunctions()
                .tonalities(TonalityRetrieval.ALL_MAJOR_MINOR)
                .retrieve();

        assertEquals(6, parametricChordList.size());
        contains(parametricChordList,
                Arrays.asList(
                        TonalChord.from(TonalityModern.C, DiatonicFunction.I),
                        TonalChord.from(TonalityModern.Dm, DiatonicFunction.VII),
                        TonalChord.from(TonalityModern.Em, DiatonicFunction.VI),
                        TonalChord.from(TonalityModern.F, DiatonicFunction.V),
                        TonalChord.from(TonalityModern.G, DiatonicFunction.IV),
                        TonalChord.from(TonalityModern.Am, DiatonicFunction.III)
                )
        );
    }

    @Test
    public void C7_in_12ET_MAJOR_MINOR() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.CMaj7)
                .allDiatonicFunctions()
                .majorMinorET12()
                .retrieve();

        assertEquals(4, parametricChordList.size());
        contains(parametricChordList,
                Arrays.asList(
                        TonalChord.from(TonalityModern.C, DiatonicFunction.I7),
                        TonalChord.from(TonalityModern.Em, DiatonicFunction.VI7),
                        TonalChord.from(TonalityModern.G, DiatonicFunction.IV7),
                        TonalChord.from(TonalityModern.Am, DiatonicFunction.III7)
                )
        );
    }

    @Test
    public void C_in_12ET_main21Modes() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.CMaj7)
                .allDiatonicFunctions()
                .main21ModesET12()
                .retrieve();

        assertEquals(21, parametricChordList.size());
        contains(parametricChordList,
                Arrays.asList(
                        TonalChord.from(TonalityModern.C, DiatonicFunction.I7),
                        TonalChord.from(TonalityModern.from(Chromatic.FF, Scale.LOCRIAN), DiatonicFunction.V7),
                        TonalChord.from(TonalityModern.G, DiatonicFunction.IV7),
                        TonalChord.from(TonalityModern.from(Chromatic.B, Scale.LOCRIAN), DiatonicFunction.II7),
                        TonalChord.from(TonalityModern.from(Chromatic.D, Scale.MIXOLYDIAN), DiatonicFunction.VII7),
                        TonalChord.from(TonalityModern.from(Chromatic.E, Scale.PHRYGIAN), DiatonicFunction.VI7),
                        TonalChord.from(TonalityModern.from(Chromatic.D, Scale.DORIAN), DiatonicFunction.VII7),
                        TonalChord.from(TonalityModern.from(Chromatic.E, Scale.HARMONIC_MINOR), DiatonicFunction.VI7),
                        TonalChord.from(TonalityModern.from(Chromatic.G, Scale.IONIAN_a5), DiatonicFunction.IV7),
                        TonalChord.from(TonalityModern.from(Chromatic.B, Scale.MIXOLIDIAN_b9_b13), DiatonicFunction.II7),
                        TonalChord.from(TonalityModern.from(Chromatic.C, Scale.LYDIAN_a2), DiatonicFunction.I7),
                        TonalChord.from(TonalityModern.from(Chromatic.FF, Scale.LOCRIAN_a6), DiatonicFunction.V7),
                        TonalChord.from(TonalityModern.from(Chromatic.DD, Scale.SUPERLOCRIAN_bb7), DiatonicFunction.VII7),
                        TonalChord.from(TonalityModern.from(Chromatic.B, Scale.PHRYGIAN), DiatonicFunction.II7),
                        TonalChord.from(TonalityModern.from(Chromatic.A, Scale.DORIAN_a4), DiatonicFunction.III7),
                        TonalChord.from(TonalityModern.Am, DiatonicFunction.III7),
                        TonalChord.from(TonalityModern.from(Chromatic.G, Scale.MIXOLYDIAN), DiatonicFunction.IV7),
                        TonalChord.from(TonalityModern.from(Chromatic.C, Scale.LYDIAN), DiatonicFunction.I7),
                        TonalChord.from(TonalityModern.from(Chromatic.F, Scale.LYDIAN), DiatonicFunction.V7),
                        TonalChord.from(TonalityModern.from(Chromatic.A, Scale.DORIAN), DiatonicFunction.III7),
                        TonalChord.from(TonalityModern.Em, DiatonicFunction.VI7)
                )
        );
    }

    @Test
    public void C_in_12ET_main21Modes_asI7() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.CMaj7)
                .harmonicFunctions(DiatonicFunction.I7)
                .main21ModesET12()
                .retrieve();

        assertEquals(3, parametricChordList.size());
        contains(parametricChordList,
                Arrays.asList(
                        TonalChord.from(TonalityModern.C, DiatonicFunction.I7),
                        TonalChord.from(TonalityModern.from(Chromatic.C, Scale.LYDIAN_a2), DiatonicFunction.I7),
                        TonalChord.from(TonalityModern.from(Chromatic.C, Scale.LYDIAN), DiatonicFunction.I7)
                )
        );
    }

    @Test
    public void C_in_12ET_main21Modes_rootFF() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.CMaj7)
                .allDiatonicFunctions()
                .rootAny(Chromatic.FF)
                .main21ModesET12()
                .retrieve();

        assertEquals(2, parametricChordList.size());
        contains(parametricChordList,
                Arrays.asList(
                        TonalChord.from(TonalityModern.from(Chromatic.FF, Scale.LOCRIAN), DiatonicFunction.V7),
                        TonalChord.from(TonalityModern.from(Chromatic.FF, Scale.LOCRIAN_a6), DiatonicFunction.V7)
                )
        );
    }
}