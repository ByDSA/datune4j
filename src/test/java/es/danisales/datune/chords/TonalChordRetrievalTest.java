package es.danisales.datune.chords;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityModern;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TonalChordRetrievalTest {
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
                .harmonicFunctions(DiatonicFunction.immutableValues())
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
                .harmonicFunctions(DiatonicFunction.immutableValues())
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
                .harmonicFunctions(DiatonicFunction.immutableValues())
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
}