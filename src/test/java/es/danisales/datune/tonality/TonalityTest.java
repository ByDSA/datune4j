package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.degrees.scale.ChromaticDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.degrees.scale.PentatonicDegree;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.function.V7ALT;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.timelayer.MainTonalFunction;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TonalityTest {
    public static class Immutables {
        @SuppressWarnings("ConstantConditions")
        @Test
        public void diatonicAltTonalitiesAreReallyDiatonicAltTonalities_MAJOR() {
            assertTrue(TonalityClassical.C.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Db.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.D.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Eb.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.E.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.F.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.FF.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Gb.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.G.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Ab.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.A.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Bb.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.B.getRoot() instanceof DiatonicAlt);
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        public void diatonicAltTonalitiesAreReallyDiatonicAltTonalities_MINOR() {
            assertTrue(TonalityClassical.Cm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.CCm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Dm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.DDm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Ebm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Em.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Fm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.FFm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Gm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.GGm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Am.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Bbm.getRoot() instanceof DiatonicAlt);
            assertTrue(TonalityClassical.Bm.getRoot() instanceof DiatonicAlt);
        }

        @Test
        public void root_MAJOR() {
            assertEquals(TonalityClassical.C.getRoot(), DiatonicAlt.C);
            assertEquals(TonalityClassical.Db.getRoot(), DiatonicAlt.Db);
            assertEquals(TonalityClassical.D.getRoot(), DiatonicAlt.D);
            assertEquals(TonalityClassical.Eb.getRoot(), DiatonicAlt.Eb);
            assertEquals(TonalityClassical.E.getRoot(), DiatonicAlt.E);
            assertEquals(TonalityClassical.F.getRoot(), DiatonicAlt.F);
            assertEquals(TonalityClassical.FF.getRoot(), DiatonicAlt.FF);
            assertEquals(TonalityClassical.Gb.getRoot(), DiatonicAlt.Gb);
            assertEquals(TonalityClassical.G.getRoot(), DiatonicAlt.G);
            assertEquals(TonalityClassical.Ab.getRoot(), DiatonicAlt.Ab);
            assertEquals(TonalityClassical.A.getRoot(), DiatonicAlt.A);
            assertEquals(TonalityClassical.Bb.getRoot(), DiatonicAlt.Bb);
            assertEquals(TonalityClassical.B.getRoot(), DiatonicAlt.B);
        }

        @Test
        public void root_MINOR() {
            assertEquals(TonalityClassical.Cm.getRoot(), DiatonicAlt.C);
            assertEquals(TonalityClassical.CCm.getRoot(), DiatonicAlt.CC);
            assertEquals(TonalityClassical.Dm.getRoot(), DiatonicAlt.D);
            assertEquals(TonalityClassical.DDm.getRoot(), DiatonicAlt.DD);
            assertEquals(TonalityClassical.Ebm.getRoot(), DiatonicAlt.Eb);
            assertEquals(TonalityClassical.Em.getRoot(), DiatonicAlt.E);
            assertEquals(TonalityClassical.Fm.getRoot(), DiatonicAlt.F);
            assertEquals(TonalityClassical.FFm.getRoot(), DiatonicAlt.FF);
            assertEquals(TonalityClassical.Gm.getRoot(), DiatonicAlt.G);
            assertEquals(TonalityClassical.GGm.getRoot(), DiatonicAlt.GG);
            assertEquals(TonalityClassical.Am.getRoot(), DiatonicAlt.A);
            assertEquals(TonalityClassical.Bbm.getRoot(), DiatonicAlt.Bb);
            assertEquals(TonalityClassical.Bm.getRoot(), DiatonicAlt.B);
        }

        @Test
        public void root_MAJOR_ET12() {
            assertEquals(TonalityModern.C.getRoot(), Chromatic.C);
            assertEquals(TonalityModern.CC.getRoot(), Chromatic.CC);
            assertEquals(TonalityModern.D.getRoot(), Chromatic.D);
            assertEquals(TonalityModern.DD.getRoot(), Chromatic.DD);
            assertEquals(TonalityModern.E.getRoot(), Chromatic.E);
            assertEquals(TonalityModern.F.getRoot(), Chromatic.F);
            assertEquals(TonalityModern.FF.getRoot(), Chromatic.FF);
            assertEquals(TonalityModern.G.getRoot(), Chromatic.G);
            assertEquals(TonalityModern.GG.getRoot(), Chromatic.GG);
            assertEquals(TonalityModern.A.getRoot(), Chromatic.A);
            assertEquals(TonalityModern.AA.getRoot(), Chromatic.AA);
            assertEquals(TonalityModern.B.getRoot(), Chromatic.B);
        }

        @Test
        public void root_MINOR_ET12() {
            assertEquals(TonalityModern.Cm.getRoot(), Chromatic.C);
            assertEquals(TonalityModern.CCm.getRoot(), Chromatic.CC);
            assertEquals(TonalityModern.Dm.getRoot(), Chromatic.D);
            assertEquals(TonalityModern.DDm.getRoot(), Chromatic.DD);
            assertEquals(TonalityModern.Em.getRoot(), Chromatic.E);
            assertEquals(TonalityModern.Fm.getRoot(), Chromatic.F);
            assertEquals(TonalityModern.FFm.getRoot(), Chromatic.FF);
            assertEquals(TonalityModern.Gm.getRoot(), Chromatic.G);
            assertEquals(TonalityModern.GGm.getRoot(), Chromatic.GG);
            assertEquals(TonalityModern.Am.getRoot(), Chromatic.A);
            assertEquals(TonalityModern.AAm.getRoot(), Chromatic.AA);
            assertEquals(TonalityModern.Bm.getRoot(), Chromatic.B);
        }

        @Test
        public void reallyScaleMajor_diatonicAlt() {
            assertEquals(TonalityClassical.C.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.Db.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.D.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.Eb.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.E.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.F.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.FF.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.Gb.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.G.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.Ab.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.A.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.Bb.getScale(), Scale.MAJOR);
            assertEquals(TonalityClassical.B.getScale(), Scale.MAJOR);
        }

        @Test
        public void reallyScaleMajor_ET12() {
            assertEquals(TonalityModern.C.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.CC.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.D.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.DD.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.E.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.F.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.FF.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.G.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.GG.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.A.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.AA.getScale(), Scale.MAJOR);
            assertEquals(TonalityModern.B.getScale(), Scale.MAJOR);
        }

        @Test
        public void reallyScaleMinor_diatonicAlt() {
            assertEquals(TonalityClassical.Cm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.CCm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.Dm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.DDm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.Ebm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.Em.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.Fm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.FFm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.Gm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.GGm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.Am.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.Bbm.getScale(), Scale.MINOR);
            assertEquals(TonalityClassical.Bm.getScale(), Scale.MINOR);
        }

        @Test
        public void reallyScaleMinor_ET12() {
            assertEquals(TonalityModern.Cm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.CCm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.Dm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.DDm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.Em.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.Fm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.FFm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.Gm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.GGm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.Am.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.AAm.getScale(), Scale.MINOR);
            assertEquals(TonalityModern.Bm.getScale(), Scale.MINOR);
        }
    }


    @Test
    public void valuesContains1() {
        valuesContains(TonalityModern.C);
    }

    @Test
    public void valuesContains2() {
        valuesContains(TonalityModern.C);
    }

    @Test
    public void valuesContains3() {
        valuesContains(TonalityModern.GG);
    }

    @Test
    public void valuesContains4() {
        valuesNotContains(TonalityModern.from(Chromatic.GG, Scale.DORIAN));
    }

    @Test
    public void valuesContains5() {
        valuesNotContains(TonalityModern.from(Chromatic.FF, Scale.DORIAN));
    }

    private void valuesContains(TonalityModern tonality) {
        Set<TonalityModern> tonalities = TonalityRetrieval.ALL_MAJOR_MINOR;

        assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    private void valuesNotContains(TonalityModern tonality) {
        Set<TonalityModern> tonalities = TonalityRetrieval.ALL_MAJOR_MINOR;

        assertFalse( tonality.toString(), tonalities.contains(tonality) );
    }

    @Test
    public void fromDiatonicChordMidi() { // todo
        //Tonality tonality = TonalityModern.fromFirst();
    }

    @Test
    public void fromDiatonicAltScale() {
        Tonality tonality = TonalityModern.from(DiatonicAlt.Gb, Scale.MAJOR);

        assertEquals(Scale.MAJOR, tonality.getScale());
        assertEquals(DiatonicAlt.Gb, tonality.getRoot());
        assertSame(TonalityClassical.Gb.innerTonality, tonality.innerTonality);
        assertNotEquals(TonalityModern.FF, tonality);
    }

    @Test
    public void fromDiatonicAltScalePentatonic() {
        Tonality tonality = TonalityModern.from(DiatonicAlt.Eb, Scale.PENTATONIC_MINOR);

        assertEquals(Scale.PENTATONIC_MINOR, tonality.getScale());
        assertEquals(DiatonicAlt.Eb, tonality.getRoot());
    }

    @Test
    public void fromDiatonicAltScale2() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.FF, Scale.MAJOR);

        assertEquals(Scale.MAJOR, tonality.getScale());
        assertEquals(DiatonicAlt.FF, tonality.getRoot());
        assertSame(TonalityClassical.FF.innerTonality, tonality.innerTonality);
        assertNotEquals(TonalityClassical.Gb, tonality);
    }

    @Test
    public void fromChromaticScale() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.FF, Scale.MAJOR);

        assertEquals(Scale.MAJOR, tonality.getScale());
        assertEquals(DiatonicAlt.FF, tonality.getRoot());
        assertNotEquals(DiatonicAlt.Gb, tonality.getRoot());
        assertSame(TonalityClassical.FF.innerTonality, tonality.innerTonality);
    }

    @Test
    public void fromChromaticScale2() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.DD, Scale.MINOR);

        assertEquals(Scale.MINOR, tonality.getScale());
        assertEquals(DiatonicAlt.DD, tonality.getRoot());
        assertNotEquals(DiatonicAlt.Eb, tonality.getRoot());
        assertSame(TonalityClassical.DDm.innerTonality, tonality.innerTonality);
    }

    @Test
    public void getRelativeMinor() {
        Tonality tonality = TonalityRetrieval.getRelativeMinorFrom(TonalityModern.C);
        assertEquals(TonalityModern.Cm, tonality);
    }

    @Test
    public void getRelativeMinorAlready() {
        Tonality tonality = TonalityRetrieval.getRelativeMinorFrom(TonalityModern.Cm);
        assertEquals(TonalityModern.Cm, tonality);
    }

    @Test
    public void getRelativeMinor2() {
        TonalityModern tonality = TonalityModern.from(Chromatic.C, Scale.DORIAN);
        tonality = TonalityRetrieval.getRelativeMinorFrom(tonality);
        assertEquals(TonalityModern.Cm, tonality);
    }

    @Test
    public void getRelativeMinorNull() {
        Tonality tonality = TonalityModern.from(Chromatic.C, Scale.PENTATONIC);
        tonality = TonalityRetrieval.getRelativeMinorFrom(tonality);
        assertNull(tonality);
    }

    @Test
    public void getRelativeMajor() {
        Tonality tonality = TonalityRetrieval.getRelativeMajorFrom(TonalityModern.Cm);
        assertEquals(TonalityModern.C, tonality);
    }

    @Test
    public void getRelativeMajor2() {
        Tonality<Chromatic> tonality = TonalityModern.from(Chromatic.C, Scale.DORIAN);
        tonality = TonalityRetrieval.getRelativeMajorFrom(tonality);
        assertEquals(TonalityModern.C, tonality);
    }

    @Test
    public void getRelativeMajorNull() {
        Tonality tonality = TonalityModern.from(Chromatic.C, Scale.PENTATONIC);
        tonality = TonalityRetrieval.getRelativeMajorFrom(tonality);
        assertNull(tonality);
    }

    @Test
    public void getRelativeMajorAlready() {
        Tonality tonality = TonalityModern.C;
        tonality = TonalityRetrieval.getRelativeMajorFrom(tonality);
        assertEquals(TonalityModern.C, tonality);
    }

    @Test
    public void isMajorOrMinor() {
        assertTrue(TonalityUtils.isMajorOrMinor(TonalityModern.C));
        assertTrue(TonalityUtils.isMajorOrMinor(TonalityModern.Cm));
        assertTrue(TonalityUtils.isMajorOrMinor(TonalityModern.from(Chromatic.C, Scale.LYDIAN)));
        assertTrue(TonalityUtils.isMajorOrMinor(TonalityModern.from(Chromatic.C, Scale.DORIAN)));
        assertTrue(TonalityUtils.isMajorOrMinor(TonalityModern.from(Chromatic.C, Scale.PENTATONIC_MINOR)));
        assertTrue(TonalityUtils.isMajorOrMinor(TonalityModern.from(Chromatic.C, Scale.PENTATONIC)));
        assertFalse(TonalityUtils.isMajorOrMinor(TonalityModern.from(Chromatic.C, Scale.CHROMATIC)));
    }

    @Test
    public void isMajor() {
        assertTrue(TonalityUtils.isMajor(TonalityModern.C));
        assertFalse(TonalityUtils.isMajor(TonalityModern.Cm));
        assertTrue(TonalityUtils.isMajor(TonalityModern.from(Chromatic.C, Scale.LYDIAN)));
        assertFalse(TonalityUtils.isMajor(TonalityModern.from(Chromatic.C, Scale.DORIAN)));
        assertFalse(TonalityUtils.isMajor(TonalityModern.from(Chromatic.C, Scale.PENTATONIC_MINOR)));
        assertTrue(TonalityUtils.isMajor(TonalityModern.from(Chromatic.C, Scale.PENTATONIC)));
        assertFalse(TonalityUtils.isMajor(TonalityModern.from(Chromatic.C, Scale.CHROMATIC)));
    }

    @Test
    public void isMinor() {
        assertFalse(TonalityUtils.isMinor(TonalityModern.C));
        assertTrue(TonalityUtils.isMinor(TonalityModern.Cm));
        assertFalse(TonalityUtils.isMinor(TonalityModern.from(Chromatic.C, Scale.LYDIAN)));
        assertTrue(TonalityUtils.isMinor(TonalityModern.from(Chromatic.C, Scale.DORIAN)));
        assertTrue(TonalityUtils.isMinor(TonalityModern.from(Chromatic.C, Scale.PENTATONIC_MINOR)));
        assertFalse(TonalityUtils.isMinor(TonalityModern.from(Chromatic.C, Scale.PENTATONIC)));
        assertFalse(TonalityUtils.isMinor(TonalityModern.from(Chromatic.C, Scale.CHROMATIC)));
    }

    @Test
    public void size() {
        for (Tonality tonality : TonalityRetrieval.allUsualKeys())
            assertEquals(tonality.getScale().size(), tonality.size());
    }

    @Test
    public void getNoteDiatonic() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.C, TonalityClassical.C.getNote(DiatonicDegree.I));
        assertEquals(DiatonicAlt.B, TonalityClassical.C.getNote(DiatonicDegree.VII));
        assertEquals(DiatonicAlt.Bb, TonalityClassical.Cm.getNote(DiatonicDegree.VII));
        assertNotEquals(DiatonicAlt.AA, TonalityClassical.Cm.getNote(DiatonicDegree.VII));
    }

    @Test
    public void getNotePentatonic() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.A,
                TonalityModern.from(DiatonicAlt.C, Scale.PENTATONIC)
                        .getNote(PentatonicDegree.V));
    }

    @Test
    public void getNotePentatonic2() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.AA,
                TonalityModern.from(DiatonicAlt.CC, Scale.PENTATONIC)
                        .getNote(PentatonicDegree.V));
    }

    @Test
    public void getNotePentatonic3() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.AA,
                TonalityModern.from(DiatonicAlt.DD, Scale.PENTATONIC_MINOR)
                        .getNote(PentatonicDegree.IV));
    }

    @Test
    public void getNotePentatonic4() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.G,
                TonalityModern.from(DiatonicAlt.C, Scale.PENTATONIC)
                        .getNote(DiatonicDegree.V));
    }

    @Test
    public void getNotePentatonic5() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.G,
                TonalityModern.from(DiatonicAlt.C, Scale.PENTATONIC)
                        .getNote(PentatonicDegree.IV));
    }

    @Test(expected = ScaleRelativeDegreeException.class)
    public void getNotePentatonic6() throws ScaleRelativeDegreeException {
        TonalityModern.from(DiatonicAlt.C, Scale.PENTATONIC)
                .getNote(DiatonicDegree.IV);
    }

    @Test
    public void getNotePentatonic7() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.G,
                TonalityModern.from(DiatonicAlt.C, Scale.PENTATONIC)
                        .getNote(PentatonicDegree.IV)
        );
    }

    @Test
    public void getNoteAbsoluteDegree() throws ScaleRelativeDegreeException {
        ScaleDegree relativeDegree = ScaleDegree.getDefaultDegreesFromScaleSize(6).get(0);
        Tonality tonality = TonalityModern.from(DiatonicAlt.C, Scale.WHOLE_TONE);
        assertEquals(DiatonicAlt.C,
                tonality.getNote(relativeDegree));

        relativeDegree = ScaleDegree.getDefaultDegreesFromScaleSize(6).get(5);

        assertEquals(DiatonicAlt.AA,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getNoteAbsoluteDegree2() throws ScaleRelativeDegreeException {
        Scale scale = Scale.fromIntegers(Arrays.asList(1, 1, 1, 1, 2, 1, 2, 1, 2));
        ScaleDegree relativeDegree = ScaleDegree.getDefaultDegreesFromScaleSize(scale.size()).get(0);
        Tonality tonality = TonalityModern.from(DiatonicAlt.C, scale);
        assertEquals(DiatonicAlt.C,
                tonality.getNote(relativeDegree));

        relativeDegree = ScaleDegree.getDefaultDegreesFromScaleSize(scale.size()).get(8);

        assertEquals(DiatonicAlt.AA,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getChromaticDegree() throws ScaleRelativeDegreeException {
        ScaleDegree relativeDegree = ChromaticDegree.I;
        Scale scale = Scale.CHROMATIC;
        Tonality tonality = TonalityModern.from(DiatonicAlt.C, scale);
        assertEquals(DiatonicAlt.C,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getChromaticDegree2() throws ScaleRelativeDegreeException {
        ScaleDegree relativeDegree = ChromaticDegree.III;
        Scale scale = Scale.CHROMATIC;
        Tonality tonality = TonalityModern.from(DiatonicAlt.C, scale);

        assertEquals(DiatonicAlt.E,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getChromaticDegree3() throws ScaleRelativeDegreeException {
        ScaleDegree relativeDegree = ChromaticDegree.V;
        Scale scale = Scale.CHROMATIC;
        Tonality tonality = TonalityModern.from(DiatonicAlt.C, scale);

        assertEquals(DiatonicAlt.G,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getNoteAbsoluteDegreeMicrotonal() throws ScaleRelativeDegreeException {
        Scale scale = Scale.fromDistances( Arrays.asList(
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ));
        ScaleDegree relativeDegree = ScaleDegree.getDefaultDegreesFromScaleSize(scale.size()).get(0);
        Tonality tonality = TonalityModern.from(DiatonicAlt.C, scale);

        assertEquals(DiatonicAlt.C,
                tonality.getNote(relativeDegree));

        relativeDegree = ScaleDegree.getDefaultDegreesFromScaleSize(scale.size()).get(8);

        assertEquals(DiatonicAlt.G,
                tonality.getNote(relativeDegree));
    }

    @Test(expected = ScaleRelativeDegreeException.class)
    public void getNoteWrongDegreeType() throws ScaleRelativeDegreeException {
        TonalityModern.from(Chromatic.C, Scale.PENTATONIC)
                .getNote(DiatonicDegree.VII);
    }

    @Test
    public void getNotes1() {
        List<DiatonicAlt> notes = Arrays.asList(
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E,
                DiatonicAlt.F,
                DiatonicAlt.G,
                DiatonicAlt.A,
                DiatonicAlt.B
        );

        assertEquals(notes, TonalityClassical.C.getNotes() );
    }

    @Test
    public void getNotes2() {
        List<DiatonicAlt> notes = Arrays.asList(
                DiatonicAlt.A,
                DiatonicAlt.B,
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E,
                DiatonicAlt.F,
                DiatonicAlt.G
        );
        assertEquals(notes, TonalityClassical.Am.getNotes() );
    }

    @Test
    public void equals1() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.C, Scale.MAJOR);
        assertEquals( TonalityClassical.C, tonality );
    }

    @Test
    public void equals2() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.Bb, Scale.MAJOR);
        assertNotEquals( TonalityClassical.C, tonality );
    }

    @Test
    public void equals3() {
        TonalityClassical tonality1 = TonalityModern.from(DiatonicAlt.GG, Scale.DORIAN);
        TonalityClassical tonality2 = TonalityModern.from(DiatonicAlt.Ab, Scale.DORIAN);
        assertNotEquals( tonality1, tonality2 );
    }

    @Test
    public void hashCode1() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.C, Scale.MAJOR);
        assertEquals( TonalityClassical.C.hashCode(), tonality.hashCode() );
    }

    @Test
    public void hashCode2() {
        Tonality tonality = TonalityModern.from(DiatonicAlt.Bb, Scale.MAJOR);
        assertNotEquals( TonalityModern.C.hashCode(), tonality.hashCode() );
    }

    @Test
    public void hashCode3() {
        Tonality tonality1 = TonalityModern.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality tonality2 = TonalityModern.from(DiatonicAlt.Ab, Scale.DORIAN);
        assertNotEquals( tonality1.hashCode(), tonality2.hashCode() );
    }

    @Test
    public void getAlterationsNumberFixedTonalities() {
        assertEquals(0, TonalityClassical.C.getDiatonicAlterationsNumber());
        assertEquals(0, TonalityClassical.Am.getDiatonicAlterationsNumber());
        assertEquals(5, TonalityClassical.Db.getDiatonicAlterationsNumber());
        assertEquals(2, TonalityClassical.D.getDiatonicAlterationsNumber());
        assertEquals(3, TonalityClassical.Eb.getDiatonicAlterationsNumber());
        assertEquals(4, TonalityClassical.E.getDiatonicAlterationsNumber());
        assertEquals(3, TonalityClassical.Cm.getDiatonicAlterationsNumber());
    }

    @Test
    public void getAlterationsNumberCustom() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.FF, Scale.CHROMATIC);
        assertEquals(tonality.toString(), 5, tonality.getDiatonicAlterationsNumber());
        tonality = TonalityModern.from(DiatonicAlt.Gb, Scale.CHROMATIC);
        assertEquals(tonality.toString(), 5, tonality.getDiatonicAlterationsNumber());
    }

    @Test
    public void cloneTest() {
        for (TonalityModern tonality : TonalityRetrieval.allUsualKeys()) {
            Tonality clonedTonality = tonality.clone();
            assertEquals(tonality, clonedTonality);
            assertNotSame(tonality, clonedTonality);
            assertSame(tonality.getRoot(), clonedTonality.getRoot());
            assertSame(tonality.getScale(), clonedTonality.getScale());
        }
    }

    @Test
    public void enharmonicNotEquals1() {
        assertNotEquals(TonalityModern.FF, TonalityClassical.Gb);
    }
    @Test
    public void enharmonicNotEquals2() {
        Tonality tonality = TonalityModern.from(DiatonicAlt.BB, Scale.MAJOR);
        assertNotEquals(TonalityModern.C, tonality);
    }

    @Test
    public void minimizeAlterationsBB() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.BB, Scale.MAJOR);
        TonalityClassical minimizedTonality = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(tonality).iterator().next();

        assertEquals(TonalityClassical.C, minimizedTonality);
    }

    @Test
    public void minimizeAlterationsSize1() {
        TonalityClassical tonality = TonalityModern.from(DiatonicAlt.BB, Scale.MAJOR);
        Set<TonalityClassical> minimizedTonalityList = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(tonality);

        assertEquals(1, minimizedTonalityList.size());
    }

    @Test
    public void minimizeAlterationsSizeNot1() {
        Set<TonalityClassical> tonalityList = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(TonalityClassical.Gb);

        assertEquals(2, tonalityList.size());
    }

    @Test
    public void hashCodeTest() {
        Tonality tonality1 = TonalityModern.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality tonality1b = TonalityModern.from(DiatonicAlt.GG, Scale.DORIAN);

        assertEquals(tonality1.hashCode(), tonality1b.hashCode());
    }

    @Test
    public void minimizeAlterationsBidirectional1() {
        Set<TonalityClassical> minTonalityListGG = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(TonalityModern.from(DiatonicAlt.GG, Scale.MAJOR));
        Set<TonalityClassical> minTonalityListFb = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(TonalityModern.from(DiatonicAlt.Ab, Scale.MAJOR));

        assertEquals(minTonalityListFb.hashCode(), minTonalityListGG.hashCode());
        assertEquals(minTonalityListFb, minTonalityListGG);
    }

    @Test
    public void minimizeAlterationsBidirectionalAll() {
        for (TonalityClassical tonality : TonalityRetrieval.allUsualKeysDiatonicAlt()) {
            Set<TonalityClassical> minTonalityListReference = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(tonality);

            if (minTonalityListReference.size() > 1)
                for (TonalityClassical minTonality : minTonalityListReference) {
                    Set<TonalityClassical> minTonalityListParticular = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(minTonality);

                    assertEquals(minTonalityListReference, minTonalityListParticular);
                }
        }
    }

    @Test
    public void getChordFunction() {
        TonalityModern ton = TonalityModern.E;
        ChromaticChord cc = DiatonicFunction.I.getChord(ton);

        assertEquals(ChromaticChord.E, cc);
        cc = DiatonicFunction.VII.getChord(ton);

        assertEquals(ChromaticChord.DDdim, cc);

        ton = TonalityModern.Em;
        cc = DiatonicFunction.I.getChord(ton);

        assertEquals(ChromaticChord.Em, cc);
        cc = DiatonicFunction.VII.getChord(ton);

        assertEquals(ChromaticChord.D, cc);

        ton = TonalityModern.C;
        cc = DiatonicFunction.V7.getChord(ton);

        assertEquals(ChromaticChord.G7, cc);
    }

    @Test
    public void getTriadSeventhChords() {
        TonalityModern t = TonalityModern.C;

        assertEquals(
                Arrays.asList(
                        ChromaticChord.C,
                        ChromaticChord.Dm,
                        ChromaticChord.Em,
                        ChromaticChord.F,
                        ChromaticChord.G,
                        ChromaticChord.Am,
                        ChromaticChord.Bdim

                ), TonalityChordRetrieval.getTriadChordsFrom(t)
        );

        assertEquals(
                Arrays.asList(
                        ChromaticChord.CMaj7,
                        ChromaticChord.Dm7,
                        ChromaticChord.Em7,
                        ChromaticChord.FMaj7,
                        ChromaticChord.G7,
                        ChromaticChord.Am7,
                        ChromaticChord.Bm7b5
                ), TonalityChordRetrieval.getSeventhChordsFrom(t)
        );

        t = TonalityModern.Am;

        assertEquals(
                Arrays.asList(
                        ChromaticChord.Am,
                        ChromaticChord.Bdim,
                        ChromaticChord.C,
                        ChromaticChord.Dm,
                        ChromaticChord.Em,
                        ChromaticChord.F,
                        ChromaticChord.G
                ), TonalityChordRetrieval.getTriadChordsFrom(t)
        );

        assertEquals(
                Arrays.asList(
                        ChromaticChord.Am7,
                        ChromaticChord.Bm7b5,
                        ChromaticChord.CMaj7,
                        ChromaticChord.Dm7,
                        ChromaticChord.Em7,
                        ChromaticChord.FMaj7,
                        ChromaticChord.G7
                ), TonalityChordRetrieval.getSeventhChordsFrom(t)
        );
    }

    @Test
    public void has() {
        Tonality<Chromatic> ton = TonalityModern.C;

        assertTrue(ton.containsAll(ChromaticChord.C));
        assertTrue(ton.containsAll(ChromaticChord.Dm));
        assertTrue(ton.containsAll(ChromaticChord.Em));
        assertTrue(ton.containsAll(ChromaticChord.F));
        assertTrue(ton.containsAll(ChromaticChord.G));
        assertTrue(ton.containsAll(ChromaticChord.Am));
        assertTrue(ton.containsAll(ChromaticChord.Bdim));

        assertTrue(ton.containsAll(ChromaticChord.Esusb2));
        assertTrue(ton.containsAll(ChromaticChord.Bsusb2b5));

        assertTrue(ton.containsAll(ChromaticChord.Csus4));
        assertTrue(ton.containsAll(ChromaticChord.Dsus4));
        assertTrue(ton.containsAll(ChromaticChord.Esus4));
        assertTrue(ton.containsAll(ChromaticChord.Fsusa4));
        assertTrue(ton.containsAll(ChromaticChord.Gsus4));
        assertTrue(ton.containsAll(ChromaticChord.Asus4));
        assertFalse(ton.containsAll(ChromaticChord.Bsusa4));

        assertTrue(ton.containsAll(ChromaticChord.C6));
        assertTrue(ton.containsAll(ChromaticChord.Dm6));
        assertFalse(ton.containsAll(ChromaticChord.Em6));
        assertTrue(ton.containsAll(ChromaticChord.F6));
        assertTrue(ton.containsAll(ChromaticChord.G6));
        assertFalse(ton.containsAll(ChromaticChord.Am6));
        assertFalse(ton.containsAll(ChromaticChord.B6));

        assertTrue(ton.containsAll(ChromaticChord.CMaj7));
        assertTrue(ton.containsAll(ChromaticChord.Dm7));
        assertTrue(ton.containsAll(ChromaticChord.Em7));
        assertTrue(ton.containsAll(ChromaticChord.FMaj7));
        assertTrue(ton.containsAll(ChromaticChord.G7));
        assertTrue(ton.containsAll(ChromaticChord.Am7));
        assertFalse(ton.containsAll(ChromaticChord.B7));
    }

    @Test
    public void getDegree() {
        Tonality<Chromatic> ton = TonalityModern.C;

        assertEquals(DiatonicDegree.I, ton.getDegreeFrom(PitchChromaticMidi.C5.getNote()));
        assertEquals(DiatonicDegree.II, ton.getDegreeFrom(PitchChromaticMidi.D5.getNote()));
        assertEquals(DiatonicDegree.III, ton.getDegreeFrom(PitchChromaticMidi.E6.getNote()));
        assertEquals(DiatonicDegree.IV, ton.getDegreeFrom(Chromatic.F));
        assertEquals(DiatonicDegree.V, ton.getDegreeFrom(Chromatic.from(DiatonicAlt.from(Diatonic.E, 3))));
    }

    @Test
    public void get() {
        TonalityModern ton = TonalityModern.C;
        assertEquals(ChromaticChord.C, DiatonicFunction.I.getChord(ton));
        assertEquals(ChromaticChord.Dm, DiatonicFunction.II.getChord(ton));
        assertEquals(ChromaticChord.Em, DiatonicFunction.III.getChord(ton));
        assertEquals(ChromaticChord.F, DiatonicFunction.IV.getChord(ton));
        assertEquals(ChromaticChord.G, DiatonicFunction.V.getChord(ton));
        assertEquals(ChromaticChord.Am, DiatonicFunction.VI.getChord(ton));
        assertEquals(ChromaticChord.Bdim, DiatonicFunction.VII.getChord(ton));

        assertEquals(ChromaticChord.Csus4, ChromaticDegreeFunction.ISUS4.getChord(ton));
        assertEquals(ChromaticChord.Dsus4, ChromaticDegreeFunction.IISUS4.getChord(ton));
        assertEquals(ChromaticChord.DDsus4, ChromaticDegreeFunction.bIIISUS4.getChord(ton));
        assertEquals(ChromaticChord.Gsus4, ChromaticDegreeFunction.VSUS4.getChord(ton));
        assertEquals(ChromaticChord.Asus4, ChromaticDegreeFunction.VISUS4.getChord(ton));

        assertEquals(ChromaticChord.C6, DiatonicFunction.I6.getChord(ton));
        assertEquals(ChromaticChord.Dm6, DiatonicFunction.II6.getChord(ton));
        assertEquals(ChromaticChord.F6, DiatonicFunction.IV6.getChord(ton));
        assertEquals(ChromaticChord.G6, DiatonicFunction.V6.getChord(ton));

        assertEquals(ChromaticChord.CMaj7, DiatonicFunction.I7.getChord(ton));
        assertEquals(ChromaticChord.Dm7, DiatonicFunction.II7.getChord(ton));
        assertEquals(ChromaticChord.Em7, DiatonicFunction.III7.getChord(ton));
        assertEquals(ChromaticChord.FMaj7, DiatonicFunction.IV7.getChord(ton));
        assertEquals(ChromaticChord.G7, DiatonicFunction.V7.getChord(ton));
        assertEquals(ChromaticChord.Am7, DiatonicFunction.VI7.getChord(ton));
        assertEquals(ChromaticChord.Bm7b5, DiatonicFunction.VII7.getChord(ton));

        assertEquals(ChromaticChord.C5, ChromaticDegreeFunction.I5.getChord(ton));
        assertEquals(ChromaticChord.D5, ChromaticDegreeFunction.II5.getChord(ton));
        assertEquals(ChromaticChord.E5, ChromaticDegreeFunction.III5.getChord(ton));
        assertEquals(ChromaticChord.F5, ChromaticDegreeFunction.IV5.getChord(ton));
        assertEquals(ChromaticChord.G5, ChromaticDegreeFunction.V5.getChord(ton));
        assertEquals(ChromaticChord.A5, ChromaticDegreeFunction.VI5.getChord(ton));
        assertEquals(ChromaticChord.B5, ChromaticDegreeFunction.VII5.getChord(ton));

        assertEquals(ChromaticChord.A, SecondaryDominant.V_II.getChord(ton));
        assertEquals(ChromaticChord.B, SecondaryDominant.V_III.getChord(ton));
        assertEquals(ChromaticChord.C, SecondaryDominant.V_IV.getChord(ton));
        assertEquals(DiatonicFunction.I.getChord(ton),
                SecondaryDominant.V_IV.getChord(ton));
        assertEquals(ChromaticChord.D, SecondaryDominant.V_V.getChord(ton));
        assertEquals(ChromaticChord.E, SecondaryDominant.V_VI.getChord(ton));

        assertEquals(ChromaticChord.A7, SecondaryDominant.V7_II.getChord(ton));
        assertEquals(ChromaticChord.B7, SecondaryDominant.V7_III.getChord(ton));
        assertEquals(SecondaryDominant.V7_IV.getChord(ton), ChromaticChord.C7);
        assertEquals(ChromaticChord.D7, SecondaryDominant.V7_V.getChord(ton));
        assertEquals(ChromaticChord.E7, SecondaryDominant.V7_VI.getChord(ton));

        assertEquals(SecondaryDominant.SUBV7.getChord(ton), ChromaticChord.CC7);

        assertEquals(SecondaryDominant.SUBV7_II.getChord(ton), ChromaticChord.DD7);

        assertEquals(SecondaryDominant.SUBV7_III.getChord(ton), ChromaticChord.F7);

        assertEquals(SecondaryDominant.SUBV7_IV.getChord(ton), ChromaticChord.FF7);

        assertEquals(SecondaryDominant.SUBV7_V.getChord(ton), ChromaticChord.GG7);

        assertEquals(SecondaryDominant.SUBV7_VI.getChord(ton), ChromaticChord.AA7);

        ChromaticChord c = ChromaticChord.CC.clone();

        assertEquals(
                c, ChromaticDegreeFunction.N6.getChord(ton)
        );

        assertEquals(ChromaticChord.Gm7b5, V7ALT.b5.getChord(ton));

        ton = TonalityModern.Cm;
        assertEquals(ChromaticChord.AA7, DiatonicFunction.VII7.getChord(ton));

        ton = TonalityModern.CC;
        assertEquals(ChromaticChord.DDm, DiatonicFunction.II.getChord(ton));
    }

    @Test
    public void getDiatonicFunction() {
        TonalityModern t = TonalityModern.C;
        for (DiatonicFunction df : DiatonicFunction.immutableValues()) {
            assertNotNull(df.getChord(t));
        }
    }

    @Test
    public void getNoteFromDiatonicDegree() throws ScaleRelativeDegreeException {
        TonalityClassical tonality = TonalityClassical.C;

        assertEquals(DiatonicAlt.C, tonality.getRoot());

        assertEquals(DiatonicAlt.C, tonality.getNote(DiatonicDegree.I));
        assertEquals(DiatonicAlt.D, tonality.getNote(DiatonicDegree.II));
    }

    @Test
    public void getMainFunctionFrom() {
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(ChromaticChord.C));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Dm));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Em));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.F));
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.G));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Am));
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Bdim));

        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Gsus4)); // dominant o subdominant??
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Csus4)); // dominant o subdominant??

        assertEquals(MainTonalFunction.TONIC, TonalityModern.Am.getMainFunctionFrom(ChromaticChord.Am));
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.Am.getMainFunctionFrom(ChromaticChord.Bdim));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.Am.getMainFunctionFrom(ChromaticChord.C));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.Am.getMainFunctionFrom(ChromaticChord.Dm));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.Am.getMainFunctionFrom(ChromaticChord.Em));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.Am.getMainFunctionFrom(ChromaticChord.F));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.Am.getMainFunctionFrom(ChromaticChord.G));

        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.Am.getMainFunctionFrom(ChromaticChord.G)); // bVII es subdominante según internet
    }

    @Test
    public void modalExchange() {
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.Cm.getMainFunctionFrom(ChromaticChord.G)); // III en menor
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.Cm.getMainFunctionFrom(ChromaticChord.Bdim)); // bV en menor

        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.GG)); // bVI en mayor
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.AA)); // bVII en mayor
    }

    @Test
    public void getMainFunctionFrom_seventh() {
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(ChromaticChord.CMaj7));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Dm7));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Em7));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.FMaj7));
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.G7));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(ChromaticChord.Am7));
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticChord.B7b5));
    }

    @Test
    public void secondaryDominants() {
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V_IV));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V7_IV));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V_V));
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V7_V));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V_II));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V7_II));
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V_III));
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V7_III));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V_VI));
        assertEquals(MainTonalFunction.TONIC, TonalityModern.C.getMainFunctionFrom(SecondaryDominant.V7_VI));
    }

    @Test
    public void otherChromaticFunctions() {
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(ChromaticDegreeFunction.N6)); // ?

        ChromaticChord chromaticChord = DiatonicFunction.I.getChord(TonalityModern.Cm);
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.II.getChord(TonalityModern.Cm);
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.III.getChord(TonalityModern.Cm);
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.IV.getChord(TonalityModern.Cm);
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.V.getChord(TonalityModern.Cm);
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.VI.getChord(TonalityModern.Cm);
        assertEquals(MainTonalFunction.SUBDOMINANT, TonalityModern.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.VII.getChord(TonalityModern.Cm);
        assertEquals(MainTonalFunction.DOMINANT, TonalityModern.C.getMainFunctionFrom(chromaticChord));

    }
}
