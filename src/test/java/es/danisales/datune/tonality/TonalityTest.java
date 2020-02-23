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
import org.junit.Assert;
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
            assertTrue(Tonality.Classical.C.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Db.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.D.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Eb.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.E.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.F.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.FF.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Gb.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.G.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Ab.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.A.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Bb.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.B.getRoot() instanceof DiatonicAlt);
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        public void diatonicAltTonalitiesAreReallyDiatonicAltTonalities_MINOR() {
            assertTrue(Tonality.Classical.Cm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.CCm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Dm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.DDm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Ebm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Em.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Fm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.FFm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Gm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.GGm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Am.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Bbm.getRoot() instanceof DiatonicAlt);
            assertTrue(Tonality.Classical.Bm.getRoot() instanceof DiatonicAlt);
        }

        @Test
        public void root_MAJOR() {
            assertEquals(Tonality.Classical.C.getRoot(), DiatonicAlt.C);
            assertEquals(Tonality.Classical.Db.getRoot(), DiatonicAlt.Db);
            assertEquals(Tonality.Classical.D.getRoot(), DiatonicAlt.D);
            assertEquals(Tonality.Classical.Eb.getRoot(), DiatonicAlt.Eb);
            assertEquals(Tonality.Classical.E.getRoot(), DiatonicAlt.E);
            assertEquals(Tonality.Classical.F.getRoot(), DiatonicAlt.F);
            assertEquals(Tonality.Classical.FF.getRoot(), DiatonicAlt.FF);
            assertEquals(Tonality.Classical.Gb.getRoot(), DiatonicAlt.Gb);
            assertEquals(Tonality.Classical.G.getRoot(), DiatonicAlt.G);
            assertEquals(Tonality.Classical.Ab.getRoot(), DiatonicAlt.Ab);
            assertEquals(Tonality.Classical.A.getRoot(), DiatonicAlt.A);
            assertEquals(Tonality.Classical.Bb.getRoot(), DiatonicAlt.Bb);
            assertEquals(Tonality.Classical.B.getRoot(), DiatonicAlt.B);
        }

        @Test
        public void root_MINOR() {
            assertEquals(Tonality.Classical.Cm.getRoot(), DiatonicAlt.C);
            assertEquals(Tonality.Classical.CCm.getRoot(), DiatonicAlt.CC);
            assertEquals(Tonality.Classical.Dm.getRoot(), DiatonicAlt.D);
            assertEquals(Tonality.Classical.DDm.getRoot(), DiatonicAlt.DD);
            assertEquals(Tonality.Classical.Ebm.getRoot(), DiatonicAlt.Eb);
            assertEquals(Tonality.Classical.Em.getRoot(), DiatonicAlt.E);
            assertEquals(Tonality.Classical.Fm.getRoot(), DiatonicAlt.F);
            assertEquals(Tonality.Classical.FFm.getRoot(), DiatonicAlt.FF);
            assertEquals(Tonality.Classical.Gm.getRoot(), DiatonicAlt.G);
            assertEquals(Tonality.Classical.GGm.getRoot(), DiatonicAlt.GG);
            assertEquals(Tonality.Classical.Am.getRoot(), DiatonicAlt.A);
            assertEquals(Tonality.Classical.Bbm.getRoot(), DiatonicAlt.Bb);
            assertEquals(Tonality.Classical.Bm.getRoot(), DiatonicAlt.B);
        }

        @Test
        public void root_MAJOR_ET12() {
            assertEquals(Tonality.C.getRoot(), Chromatic.C);
            assertEquals(Tonality.CC.getRoot(), Chromatic.CC);
            assertEquals(Tonality.D.getRoot(), Chromatic.D);
            assertEquals(Tonality.DD.getRoot(), Chromatic.DD);
            assertEquals(Tonality.E.getRoot(), Chromatic.E);
            assertEquals(Tonality.F.getRoot(), Chromatic.F);
            assertEquals(Tonality.FF.getRoot(), Chromatic.FF);
            assertEquals(Tonality.G.getRoot(), Chromatic.G);
            assertEquals(Tonality.GG.getRoot(), Chromatic.GG);
            assertEquals(Tonality.A.getRoot(), Chromatic.A);
            assertEquals(Tonality.AA.getRoot(), Chromatic.AA);
            assertEquals(Tonality.B.getRoot(), Chromatic.B);
        }

        @Test
        public void root_MINOR_ET12() {
            assertEquals(Tonality.Cm.getRoot(), Chromatic.C);
            assertEquals(Tonality.CCm.getRoot(), Chromatic.CC);
            assertEquals(Tonality.Dm.getRoot(), Chromatic.D);
            assertEquals(Tonality.DDm.getRoot(), Chromatic.DD);
            assertEquals(Tonality.Em.getRoot(), Chromatic.E);
            assertEquals(Tonality.Fm.getRoot(), Chromatic.F);
            assertEquals(Tonality.FFm.getRoot(), Chromatic.FF);
            assertEquals(Tonality.Gm.getRoot(), Chromatic.G);
            assertEquals(Tonality.GGm.getRoot(), Chromatic.GG);
            assertEquals(Tonality.Am.getRoot(), Chromatic.A);
            assertEquals(Tonality.AAm.getRoot(), Chromatic.AA);
            assertEquals(Tonality.Bm.getRoot(), Chromatic.B);
        }

        @Test
        public void reallyScaleMajor_diatonicAlt() {
            assertEquals(Tonality.Classical.C.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.Db.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.D.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.Eb.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.E.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.F.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.FF.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.Gb.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.G.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.Ab.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.A.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.Bb.getScale(), Scale.MAJOR);
            assertEquals(Tonality.Classical.B.getScale(), Scale.MAJOR);
        }

        @Test
        public void reallyScaleMajor_ET12() {
            assertEquals(Tonality.C.getScale(), Scale.MAJOR);
            assertEquals(Tonality.CC.getScale(), Scale.MAJOR);
            assertEquals(Tonality.D.getScale(), Scale.MAJOR);
            assertEquals(Tonality.DD.getScale(), Scale.MAJOR);
            assertEquals(Tonality.E.getScale(), Scale.MAJOR);
            assertEquals(Tonality.F.getScale(), Scale.MAJOR);
            assertEquals(Tonality.FF.getScale(), Scale.MAJOR);
            assertEquals(Tonality.G.getScale(), Scale.MAJOR);
            assertEquals(Tonality.GG.getScale(), Scale.MAJOR);
            assertEquals(Tonality.A.getScale(), Scale.MAJOR);
            assertEquals(Tonality.AA.getScale(), Scale.MAJOR);
            assertEquals(Tonality.B.getScale(), Scale.MAJOR);
        }

        @Test
        public void reallyScaleMinor_diatonicAlt() {
            assertEquals(Tonality.Classical.Cm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.CCm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.Dm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.DDm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.Ebm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.Em.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.Fm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.FFm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.Gm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.GGm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.Am.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.Bbm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Classical.Bm.getScale(), Scale.MINOR);
        }

        @Test
        public void reallyScaleMinor_ET12() {
            assertEquals(Tonality.Cm.getScale(), Scale.MINOR);
            assertEquals(Tonality.CCm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Dm.getScale(), Scale.MINOR);
            assertEquals(Tonality.DDm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Em.getScale(), Scale.MINOR);
            assertEquals(Tonality.Fm.getScale(), Scale.MINOR);
            assertEquals(Tonality.FFm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Gm.getScale(), Scale.MINOR);
            assertEquals(Tonality.GGm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Am.getScale(), Scale.MINOR);
            assertEquals(Tonality.AAm.getScale(), Scale.MINOR);
            assertEquals(Tonality.Bm.getScale(), Scale.MINOR);
        }
    }


    @Test
    public void valuesContains1() {
        valuesContains(Tonality.C);
    }

    @Test
    public void valuesContains2() {
        valuesContains(Tonality.C);
    }

    @Test
    public void valuesContains3() {
        valuesContains(Tonality.GG);
    }

    @Test
    public void valuesContains4() {
        valuesNotContains(Tonality.from(Chromatic.GG, Scale.DORIAN));
    }

    @Test
    public void valuesContains5() {
        valuesNotContains(Tonality.from(Chromatic.FF, Scale.DORIAN));
    }

    private void valuesContains(Tonality tonality) {
        Set<Tonality<Chromatic>> tonalities = TonalityRetrieval.ALL_MAJOR_MINOR;

        Assert.assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    private void valuesNotContains(Tonality tonality) {
        Set<Tonality<Chromatic>> tonalities = TonalityRetrieval.ALL_MAJOR_MINOR;

        assertFalse( tonality.toString(), tonalities.contains(tonality) );
    }

    @Test
    public void fromDiatonicChordMidi() { // todo
        //Tonality tonality = Tonality.fromFirst();
    }

    @Test
    public void fromDiatonicAltScale() {
        Tonality tonality = Tonality.from(DiatonicAlt.Gb, Scale.MAJOR);

        assertEquals(Scale.MAJOR, tonality.getScale());
        assertEquals(DiatonicAlt.Gb, tonality.getRoot());
        assertSame(Tonality.Classical.Gb.innerTonality, tonality.innerTonality);
        assertNotEquals(Tonality.FF, tonality);
    }

    @Test
    public void fromDiatonicAltScalePentatonic() {
        Tonality tonality = Tonality.from(DiatonicAlt.Eb, Scale.PENTATONIC_MINOR);

        assertEquals(Scale.PENTATONIC_MINOR, tonality.getScale());
        assertEquals(DiatonicAlt.Eb, tonality.getRoot());
    }

    @Test
    public void fromDiatonicAltScale2() {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.FF, Scale.MAJOR);

        assertEquals(Scale.MAJOR, tonality.getScale());
        assertEquals(DiatonicAlt.FF, tonality.getRoot());
        assertSame(Tonality.Classical.FF.innerTonality, tonality.innerTonality);
        assertNotEquals(Tonality.Classical.Gb, tonality);
    }

    @Test
    public void fromChromaticScale() {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.FF, Scale.MAJOR);

        assertEquals(Scale.MAJOR, tonality.getScale());
        assertEquals(DiatonicAlt.FF, tonality.getRoot());
        assertNotEquals(DiatonicAlt.Gb, tonality.getRoot());
        assertSame(Tonality.Classical.FF.innerTonality, tonality.innerTonality);
    }

    @Test
    public void fromChromaticScale2() {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.DD, Scale.MINOR);

        assertEquals(Scale.MINOR, tonality.getScale());
        assertEquals(DiatonicAlt.DD, tonality.getRoot());
        assertNotEquals(DiatonicAlt.Eb, tonality.getRoot());
        assertSame(Tonality.Classical.DDm.innerTonality, tonality.innerTonality);
    }

    @Test
    public void getRelativeMinor() {
        Tonality tonality = TonalityRetrieval.getRelativeMinorFrom(Tonality.C);
        assertEquals(Tonality.Cm, tonality);
    }

    @Test
    public void getRelativeMinorAlready() {
        Tonality tonality = TonalityRetrieval.getRelativeMinorFrom(Tonality.Cm);
        assertEquals(Tonality.Cm, tonality);
    }

    @Test
    public void getRelativeMinor2() {
        Tonality<Chromatic> tonality = Tonality.from(Chromatic.C, Scale.DORIAN);
        tonality = TonalityRetrieval.getRelativeMinorFrom(tonality);
        assertEquals(Tonality.Cm, tonality);
    }

    @Test
    public void getRelativeMinorNull() {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.PENTATONIC);
        tonality = TonalityRetrieval.getRelativeMinorFrom(tonality);
        assertNull(tonality);
    }

    @Test
    public void getRelativeMajor() {
        Tonality tonality = TonalityRetrieval.getRelativeMajorFrom(Tonality.Cm);
        assertEquals(Tonality.C, tonality);
    }

    @Test
    public void getRelativeMajor2() {
        Tonality<Chromatic> tonality = Tonality.from(Chromatic.C, Scale.DORIAN);
        tonality = TonalityRetrieval.getRelativeMajorFrom(tonality);
        assertEquals(Tonality.C, tonality);
    }

    @Test
    public void getRelativeMajorNull() {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.PENTATONIC);
        tonality = TonalityRetrieval.getRelativeMajorFrom(tonality);
        assertNull(tonality);
    }

    @Test
    public void getRelativeMajorAlready() {
        Tonality tonality = Tonality.C;
        tonality = TonalityRetrieval.getRelativeMajorFrom(tonality);
        assertEquals(Tonality.C, tonality);
    }

    @Test
    public void isMajorOrMinor() {
        assertTrue(TonalityUtils.isMajorOrMinor(Tonality.C));
        assertTrue(TonalityUtils.isMajorOrMinor(Tonality.Cm));
        assertTrue(TonalityUtils.isMajorOrMinor(Tonality.from(Chromatic.C, Scale.LYDIAN)));
        assertTrue(TonalityUtils.isMajorOrMinor(Tonality.from(Chromatic.C, Scale.DORIAN)));
        assertTrue(TonalityUtils.isMajorOrMinor(Tonality.from(Chromatic.C, Scale.PENTATONIC_MINOR)));
        assertTrue(TonalityUtils.isMajorOrMinor(Tonality.from(Chromatic.C, Scale.PENTATONIC)));
        assertFalse(TonalityUtils.isMajorOrMinor(Tonality.from(Chromatic.C, Scale.CHROMATIC)));
    }

    @Test
    public void isMajor() {
        assertTrue(TonalityUtils.isMajor(Tonality.C));
        assertFalse(TonalityUtils.isMajor(Tonality.Cm));
        assertTrue(TonalityUtils.isMajor(Tonality.from(Chromatic.C, Scale.LYDIAN)));
        assertFalse(TonalityUtils.isMajor(Tonality.from(Chromatic.C, Scale.DORIAN)));
        assertFalse(TonalityUtils.isMajor(Tonality.from(Chromatic.C, Scale.PENTATONIC_MINOR)));
        assertTrue(TonalityUtils.isMajor(Tonality.from(Chromatic.C, Scale.PENTATONIC)));
        assertFalse(TonalityUtils.isMajor(Tonality.from(Chromatic.C, Scale.CHROMATIC)));
    }

    @Test
    public void isMinor() {
        assertFalse(TonalityUtils.isMinor(Tonality.C));
        assertTrue(TonalityUtils.isMinor(Tonality.Cm));
        assertFalse(TonalityUtils.isMinor(Tonality.from(Chromatic.C, Scale.LYDIAN)));
        assertTrue(TonalityUtils.isMinor(Tonality.from(Chromatic.C, Scale.DORIAN)));
        assertTrue(TonalityUtils.isMinor(Tonality.from(Chromatic.C, Scale.PENTATONIC_MINOR)));
        assertFalse(TonalityUtils.isMinor(Tonality.from(Chromatic.C, Scale.PENTATONIC)));
        assertFalse(TonalityUtils.isMinor(Tonality.from(Chromatic.C, Scale.CHROMATIC)));
    }

    @Test
    public void size() {
        for (Tonality tonality : TonalityRetrieval.allUsualKeys())
            assertEquals(tonality.getScale().size(), tonality.size());
    }

    @Test
    public void getNoteDiatonic() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.C, Tonality.Classical.C.getNote(DiatonicDegree.I));
        assertEquals(DiatonicAlt.B, Tonality.Classical.C.getNote(DiatonicDegree.VII));
        assertEquals(DiatonicAlt.Bb, Tonality.Classical.Cm.getNote(DiatonicDegree.VII));
        assertNotEquals(DiatonicAlt.AA, Tonality.Classical.Cm.getNote(DiatonicDegree.VII));
    }

    @Test
    public void getNotePentatonic() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.A,
                Tonality.from(DiatonicAlt.C, Scale.PENTATONIC)
                        .getNote(PentatonicDegree.V));
    }

    @Test
    public void getNotePentatonic2() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.AA,
                Tonality.from(DiatonicAlt.CC, Scale.PENTATONIC)
                        .getNote(PentatonicDegree.V));
    }

    @Test
    public void getNotePentatonic3() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.AA,
                Tonality.from(DiatonicAlt.DD, Scale.PENTATONIC_MINOR)
                        .getNote(PentatonicDegree.IV));
    }

    @Test
    public void getNotePentatonic4() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.G,
                Tonality.from(DiatonicAlt.C, Scale.PENTATONIC)
                        .getNote(DiatonicDegree.V));
    }

    @Test
    public void getNotePentatonic5() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.G,
                Tonality.from(DiatonicAlt.C, Scale.PENTATONIC)
                        .getNote(PentatonicDegree.IV));
    }

    @Test(expected = ScaleRelativeDegreeException.class)
    public void getNotePentatonic6() throws ScaleRelativeDegreeException {
        Tonality.from(DiatonicAlt.C, Scale.PENTATONIC)
                .getNote(DiatonicDegree.IV);
    }

    @Test
    public void getNotePentatonic7() throws ScaleRelativeDegreeException {
        assertEquals(DiatonicAlt.G,
                Tonality.from(DiatonicAlt.C, Scale.PENTATONIC)
                        .getNote(PentatonicDegree.IV)
        );
    }

    @Test
    public void getNoteAbsoluteDegree() throws ScaleRelativeDegreeException {
        ScaleDegree relativeDegree = ScaleDegree.getDefaultDegreesFromScaleSize(6).get(0);
        Tonality tonality = Tonality.from(DiatonicAlt.C, Scale.WHOLE_TONE);
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
        Tonality tonality = Tonality.from(DiatonicAlt.C, scale);
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
        Tonality tonality = Tonality.from(DiatonicAlt.C, scale);
        assertEquals(DiatonicAlt.C,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getChromaticDegree2() throws ScaleRelativeDegreeException {
        ScaleDegree relativeDegree = ChromaticDegree.III;
        Scale scale = Scale.CHROMATIC;
        Tonality tonality = Tonality.from(DiatonicAlt.C, scale);

        assertEquals(DiatonicAlt.E,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getChromaticDegree3() throws ScaleRelativeDegreeException {
        ScaleDegree relativeDegree = ChromaticDegree.V;
        Scale scale = Scale.CHROMATIC;
        Tonality tonality = Tonality.from(DiatonicAlt.C, scale);

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
        Tonality tonality = Tonality.from(DiatonicAlt.C, scale);

        assertEquals(DiatonicAlt.C,
                tonality.getNote(relativeDegree));

        relativeDegree = ScaleDegree.getDefaultDegreesFromScaleSize(scale.size()).get(8);

        assertEquals(DiatonicAlt.G,
                tonality.getNote(relativeDegree));
    }

    @Test(expected = ScaleRelativeDegreeException.class)
    public void getNoteWrongDegreeType() throws ScaleRelativeDegreeException {
        Tonality.from(Chromatic.C, Scale.PENTATONIC)
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

        assertEquals(notes, Tonality.Classical.C.getNotes() );
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
        assertEquals(notes, Tonality.Classical.Am.getNotes() );
    }

    @Test
    public void equals1() {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
        assertEquals( Tonality.Classical.C, tonality );
    }

    @Test
    public void equals2() {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.Bb, Scale.MAJOR);
        assertNotEquals( Tonality.Classical.C, tonality );
    }

    @Test
    public void equals3() {
        Tonality<DiatonicAlt> tonality1 = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality<DiatonicAlt> tonality2 = Tonality.from(DiatonicAlt.Ab, Scale.DORIAN);
        assertNotEquals( tonality1, tonality2 );
    }

    @Test
    public void hashCode1() {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
        assertEquals( Tonality.Classical.C.hashCode(), tonality.hashCode() );
    }

    @Test
    public void hashCode2() {
        Tonality tonality = Tonality.from(DiatonicAlt.Bb, Scale.MAJOR);
        assertNotEquals( Tonality.C.hashCode(), tonality.hashCode() );
    }

    @Test
    public void hashCode3() {
        Tonality tonality1 = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality tonality2 = Tonality.from(DiatonicAlt.Ab, Scale.DORIAN);
        assertNotEquals( tonality1.hashCode(), tonality2.hashCode() );
    }

    @Test
    public void getAlterationsNumberFixedTonalities() {
        assertEquals(0, Tonality.Classical.C.getDiatonicAlterationsNumber());
        assertEquals(0, Tonality.Classical.Am.getDiatonicAlterationsNumber());
        assertEquals(5, Tonality.Classical.Db.getDiatonicAlterationsNumber());
        assertEquals(2, Tonality.Classical.D.getDiatonicAlterationsNumber());
        assertEquals(3, Tonality.Classical.Eb.getDiatonicAlterationsNumber());
        assertEquals(4, Tonality.Classical.E.getDiatonicAlterationsNumber());
        assertEquals(3, Tonality.Classical.Cm.getDiatonicAlterationsNumber());
    }

    @Test
    public void getAlterationsNumberCustom() {
        Tonality tonality = Tonality.from(DiatonicAlt.FF, Scale.CHROMATIC);
        assertEquals(tonality.toString(), 5, tonality.getDiatonicAlterationsNumber());
        tonality = Tonality.from(DiatonicAlt.Gb, Scale.CHROMATIC);
        assertEquals(tonality.toString(), 5, tonality.getDiatonicAlterationsNumber());
    }

    @Test
    public void cloneTest() {
        for (Tonality tonality : TonalityRetrieval.allUsualKeys()) {
            Tonality clonedTonality = tonality.clone();
            assertEquals(tonality, clonedTonality);
            assertNotSame(tonality, clonedTonality);
            assertSame(tonality.getRoot(), clonedTonality.getRoot());
            assertSame(tonality.getScale(), clonedTonality.getScale());
        }
    }

    @Test
    public void enharmonicNotEquals1() {
        assertNotEquals(Tonality.FF, Tonality.Classical.Gb);
    }
    @Test
    public void enharmonicNotEquals2() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        assertNotEquals(Tonality.C, tonality);
    }

    @Test
    public void minimizeAlterationsBB() {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        Tonality<DiatonicAlt> minimizedTonality = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(tonality).iterator().next();

        assertEquals(Tonality.Classical.C, minimizedTonality);
    }

    @Test
    public void minimizeAlterationsSize1() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        Set<Tonality> minimizedTonalityList = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(tonality);

        assertEquals(1, minimizedTonalityList.size());
    }

    @Test
    public void minimizeAlterationsSizeNot1() {
        Set<Tonality<DiatonicAlt>> tonalityList = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(Tonality.Classical.Gb);

        assertEquals(2, tonalityList.size());
    }

    @Test
    public void hashCodeTest() {
        Tonality tonality1 = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality tonality1b = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);

        assertEquals(tonality1.hashCode(), tonality1b.hashCode());
    }

    @Test
    public void minimizeAlterationsBidirectional1() {
        Set<Tonality<DiatonicAlt>> minTonalityListGG = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(Tonality.from(DiatonicAlt.GG, Scale.MAJOR));
        Set<Tonality<DiatonicAlt>> minTonalityListFb = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(Tonality.from(DiatonicAlt.Ab, Scale.MAJOR));

        assertEquals(minTonalityListFb.hashCode(), minTonalityListGG.hashCode());
        assertEquals(minTonalityListFb, minTonalityListGG);
    }

    @Test
    public void minimizeAlterationsBidirectionalAll() {
        for (Tonality<DiatonicAlt> tonality : TonalityRetrieval.allUsualKeysDiatonicAlt()) {
            Set<Tonality<DiatonicAlt>> minTonalityListReference = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(tonality);

            if (minTonalityListReference.size() > 1)
                for (Tonality minTonality : minTonalityListReference) {
                    Set<Tonality> minTonalityListParticular = TonalityRetrieval.getEnharmonicMinimalNoteAltsFrom(minTonality);

                    assertEquals(minTonalityListReference, minTonalityListParticular);
                }
        }
    }

    @Test
    public void getChordFunction() throws ScaleRelativeDegreeException {
        Tonality ton = Tonality.E;
        ChromaticChord cc = DiatonicFunction.I.getChromaticChordFromTonality(ton);

        assertEquals(ChromaticChord.E, cc);
        cc = DiatonicFunction.VII.getChromaticChordFromTonality(ton);

        assertEquals(ChromaticChord.DDdim, cc);

        ton = Tonality.Em;
        cc = DiatonicFunction.I.getChromaticChordFromTonality(ton);

        assertEquals(ChromaticChord.Em, cc);
        cc = DiatonicFunction.VII.getChromaticChordFromTonality(ton);

        assertEquals(ChromaticChord.D, cc);

        ton = Tonality.C;
        cc = DiatonicFunction.V7.getChromaticChordFromTonality(ton);

        assertEquals(ChromaticChord.G7, cc);
    }

    @Test
    public void getTriadSeventhChords() {
        Tonality t = Tonality.C;

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

        t = Tonality.Am;

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
        Tonality<Chromatic> ton = Tonality.C;

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
    public void getDegree() throws TonalityException {
        Tonality<Chromatic> ton = Tonality.C;

        assertEquals(DiatonicDegree.I, ton.getDegreeFrom(PitchChromaticMidi.C5.getNote()));
        assertEquals(DiatonicDegree.II, ton.getDegreeFrom(PitchChromaticMidi.D5.getNote()));
        assertEquals(DiatonicDegree.III, ton.getDegreeFrom(PitchChromaticMidi.E6.getNote()));
        assertEquals(DiatonicDegree.IV, ton.getDegreeFrom(Chromatic.F));
        assertEquals(DiatonicDegree.V, ton.getDegreeFrom(Chromatic.from(DiatonicAlt.from(Diatonic.E, 3))));
    }

    @Test
    public void get() throws ScaleRelativeDegreeException {
        Tonality<Chromatic> ton = Tonality.C;
        assertEquals(ChromaticChord.C, DiatonicFunction.I.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Dm, DiatonicFunction.II.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Em, DiatonicFunction.III.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.F, DiatonicFunction.IV.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.G, DiatonicFunction.V.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Am, DiatonicFunction.VI.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Bdim, DiatonicFunction.VII.getChromaticChordFromTonality(ton));

        assertEquals(ChromaticChord.Csus4, ChromaticDegreeFunction.ISUS4.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Dsus4, ChromaticDegreeFunction.IISUS4.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.DDsus4, ChromaticDegreeFunction.bIIISUS4.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Gsus4, ChromaticDegreeFunction.VSUS4.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Asus4, ChromaticDegreeFunction.VISUS4.getChromaticChordFromTonality(ton));

        assertEquals(ChromaticChord.C6, DiatonicFunction.I6.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Dm6, DiatonicFunction.II6.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.F6, DiatonicFunction.IV6.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.G6, DiatonicFunction.V6.getChromaticChordFromTonality(ton));

        assertEquals(ChromaticChord.CMaj7, DiatonicFunction.I7.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Dm7, DiatonicFunction.II7.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Em7, DiatonicFunction.III7.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.FMaj7, DiatonicFunction.IV7.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.G7, DiatonicFunction.V7.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Am7, DiatonicFunction.VI7.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.Bm7b5, DiatonicFunction.VII7.getChromaticChordFromTonality(ton));

        assertEquals(ChromaticChord.C5, ChromaticDegreeFunction.I5.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.D5, ChromaticDegreeFunction.II5.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.E5, ChromaticDegreeFunction.III5.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.F5, ChromaticDegreeFunction.IV5.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.G5, ChromaticDegreeFunction.V5.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.A5, ChromaticDegreeFunction.VI5.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.B5, ChromaticDegreeFunction.VII5.getChromaticChordFromTonality(ton));

        assertEquals(ChromaticChord.A, SecondaryDominant.V_II.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.B, SecondaryDominant.V_III.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.C, SecondaryDominant.V_IV.getChromaticChordFromTonality(ton));
        assertEquals(DiatonicFunction.I.getChromaticChordFromTonality(ton),
                SecondaryDominant.V_IV.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.D, SecondaryDominant.V_V.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.E, SecondaryDominant.V_VI.getChromaticChordFromTonality(ton));

        assertEquals(ChromaticChord.A7, SecondaryDominant.V7_II.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.B7, SecondaryDominant.V7_III.getChromaticChordFromTonality(ton));
        assertEquals(SecondaryDominant.V7_IV.getChromaticChordFromTonality(ton), ChromaticChord.C7);
        assertEquals(ChromaticChord.D7, SecondaryDominant.V7_V.getChromaticChordFromTonality(ton));
        assertEquals(ChromaticChord.E7, SecondaryDominant.V7_VI.getChromaticChordFromTonality(ton));

        assertEquals(SecondaryDominant.SUBV7.getChromaticChordFromTonality(ton), ChromaticChord.CC7);

        assertEquals(SecondaryDominant.SUBV7_II.getChromaticChordFromTonality(ton), ChromaticChord.DD7);

        assertEquals(SecondaryDominant.SUBV7_III.getChromaticChordFromTonality(ton), ChromaticChord.F7);

        assertEquals(SecondaryDominant.SUBV7_IV.getChromaticChordFromTonality(ton), ChromaticChord.FF7);

        assertEquals(SecondaryDominant.SUBV7_V.getChromaticChordFromTonality(ton), ChromaticChord.GG7);

        assertEquals(SecondaryDominant.SUBV7_VI.getChromaticChordFromTonality(ton).toString(),
                SecondaryDominant.SUBV7_VI.getChromaticChordFromTonality(ton), ChromaticChord.AA7);

        ChromaticChord c = ChromaticChord.CC.clone();

        assertEquals(
                c, ChromaticDegreeFunction.N6.getChromaticChordFromTonality(ton)
        );

        assertEquals(ChromaticChord.Gm7b5, V7ALT.b5.getChromaticChordFromTonality(ton));

        ton = Tonality.Cm;
        assertEquals(ChromaticChord.AA7, DiatonicFunction.VII7.getChromaticChordFromTonality(ton));

        ton = Tonality.CC;
        assertEquals(ChromaticChord.DDm, DiatonicFunction.II.getChromaticChordFromTonality(ton));
    }

    @Test
    public void getDiatonicFunction() throws ScaleRelativeDegreeException {
        Tonality<Chromatic> t = Tonality.C;
        for (DiatonicFunction df : DiatonicFunction.immutableValues()) {
            assertNotNull(df.getChromaticChordFromTonality(t));
        }
    }

    @Test
    public void getNoteFromDiatonicDegree() throws ScaleRelativeDegreeException {
        Tonality<DiatonicAlt> tonality = Tonality.Classical.C;

        assertEquals(DiatonicAlt.C, tonality.getRoot());

        assertEquals(DiatonicAlt.C, tonality.getNote(DiatonicDegree.I));
        assertEquals(DiatonicAlt.D, tonality.getNote(DiatonicDegree.II));
    }

    @Test
    public void getMainFunctionFrom() {
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(ChromaticChord.C));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.Dm));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(ChromaticChord.Em));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.F));
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.G));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(ChromaticChord.Am));
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.Bdim));

        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.Gsus4)); // dominant o subdominant??
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.Csus4)); // dominant o subdominant??

        assertEquals(MainTonalFunction.TONIC, Tonality.Am.getMainFunctionFrom(ChromaticChord.Am));
        assertEquals(MainTonalFunction.DOMINANT, Tonality.Am.getMainFunctionFrom(ChromaticChord.Bdim));
        assertEquals(MainTonalFunction.TONIC, Tonality.Am.getMainFunctionFrom(ChromaticChord.C));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.Am.getMainFunctionFrom(ChromaticChord.Dm));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.Am.getMainFunctionFrom(ChromaticChord.Em));
        assertEquals(MainTonalFunction.TONIC, Tonality.Am.getMainFunctionFrom(ChromaticChord.F));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.Am.getMainFunctionFrom(ChromaticChord.G));

        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.Am.getMainFunctionFrom(ChromaticChord.G)); // bVII es subdominante según internet
    }

    @Test
    public void modalExchange() {
        assertEquals(MainTonalFunction.DOMINANT, Tonality.Cm.getMainFunctionFrom(ChromaticChord.G)); // III en menor
        assertEquals(MainTonalFunction.DOMINANT, Tonality.Cm.getMainFunctionFrom(ChromaticChord.Bdim)); // bV en menor

        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.GG)); // bVI en mayor
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.AA)); // bVII en mayor
    }

    @Test
    public void getMainFunctionFrom_seventh() {
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(ChromaticChord.CMaj7));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.Dm7));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(ChromaticChord.Em7));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.FMaj7));
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.G7));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(ChromaticChord.Am7));
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(ChromaticChord.B7b5));
    }

    @Test
    public void secondaryDominants() {
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(SecondaryDominant.V_IV));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(SecondaryDominant.V7_IV));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(SecondaryDominant.V_V));
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(SecondaryDominant.V7_V));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(SecondaryDominant.V_II));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(SecondaryDominant.V7_II));
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(SecondaryDominant.V_III));
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(SecondaryDominant.V7_III));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(SecondaryDominant.V_VI));
        assertEquals(MainTonalFunction.TONIC, Tonality.C.getMainFunctionFrom(SecondaryDominant.V7_VI));
    }

    @Test
    public void otherChromaticFunctions() throws ScaleRelativeDegreeException {
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(ChromaticDegreeFunction.N6)); // ?

        ChromaticChord chromaticChord = DiatonicFunction.I.getChromaticChordFromTonality(Tonality.Cm);
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.II.getChromaticChordFromTonality(Tonality.Cm);
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.III.getChromaticChordFromTonality(Tonality.Cm);
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.IV.getChromaticChordFromTonality(Tonality.Cm);
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.V.getChromaticChordFromTonality(Tonality.Cm);
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.VI.getChromaticChordFromTonality(Tonality.Cm);
        assertEquals(MainTonalFunction.SUBDOMINANT, Tonality.C.getMainFunctionFrom(chromaticChord));

        chromaticChord = DiatonicFunction.VII.getChromaticChordFromTonality(Tonality.Cm);
        assertEquals(MainTonalFunction.DOMINANT, Tonality.C.getMainFunctionFrom(chromaticChord));

    }
}
