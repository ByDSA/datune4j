package es.danisales.datune.chords;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.tonality.Tonality;
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
                .tonalities(Tonality.ET12.C)
                .retrieve();

        assertEquals(1, parametricChordList.size());
        contains(parametricChordList,
                Collections.singletonList(
                        TonalChord.from(Tonality.ET12.C, DiatonicFunction.I)
                )
        );
    }

    @Test
    public void C_in_C_Am() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.C)
                .harmonicFunctions(DiatonicFunction.immutableValues())
                .tonalities(Tonality.ET12.C, Tonality.ET12.Am)
                .retrieve();

        assertEquals(2, parametricChordList.size());
        contains(parametricChordList,
                Arrays.asList(
                        TonalChord.from(Tonality.ET12.C, DiatonicFunction.I),
                        TonalChord.from(Tonality.ET12.Am, DiatonicFunction.III)
                )
        );
    }

    @Test
    public void C_in_12ET_MAJOR_MINOR() {
        List<TonalChord> parametricChordList = TonalChord.retrieval()
                .from(ChromaticChord.C)
                .harmonicFunctions(DiatonicFunction.immutableValues())
                .tonalities(TonalityRetrieval.ET12.ALL_MAJOR_MINOR)
                .retrieve();

        assertEquals(6, parametricChordList.size());
        contains(parametricChordList,
                Arrays.asList(
                        TonalChord.from(Tonality.ET12.C, DiatonicFunction.I),
                        TonalChord.from(Tonality.ET12.Dm, DiatonicFunction.VII),
                        TonalChord.from(Tonality.ET12.Em, DiatonicFunction.VI),
                        TonalChord.from(Tonality.ET12.F, DiatonicFunction.V),
                        TonalChord.from(Tonality.ET12.G, DiatonicFunction.IV),
                        TonalChord.from(Tonality.ET12.Am, DiatonicFunction.III)
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
                        TonalChord.from(Tonality.ET12.C, DiatonicFunction.I7),
                        TonalChord.from(Tonality.ET12.Em, DiatonicFunction.VI7),
                        TonalChord.from(Tonality.ET12.G, DiatonicFunction.IV7),
                        TonalChord.from(Tonality.ET12.Am, DiatonicFunction.III7)
                )
        );
    }
}