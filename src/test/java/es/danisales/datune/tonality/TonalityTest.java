package es.danisales.datune.tonality;

import es.danisales.datune.chords.DiatonicAltChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.ChromaticDegree;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.degrees.scale.PentatonicDegree;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.DiatonicAlt;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TonalityTest {
    @Test
    public void allSize() {
        List<Tonality> tonalities = TonalityRetrieval.allUsualKeys();

        assertEquals(1029, tonalities.size());
    }

    private void allContains(Tonality tonality) {
        List<Tonality> tonalities = TonalityRetrieval.allUsualKeys();

        assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    @Test
    public void allContains1() {
        allContains(Tonality.C);
    }

    @Test
    public void allContains2() {
        allContains(Tonality.C);
    }

    @Test
    public void allContains3() {
        allContains(Tonality.Ab);
    }

    @Test
    public void allContains4() {
        allContains(Tonality.from(DiatonicAlt.Ab, Scale.DORIAN));
    }

    @Test
    public void allContains5() {
        allContains(Tonality.from(DiatonicAlt.GG, Scale.DORIAN));
    }

    @Test
    public void allContainsValues() {
        List<Tonality> tonalities = TonalityRetrieval.allUsualKeys();

        Set<Tonality> values = TonalityRetrieval.ET12.ALL_MAJOR_MINOR;

        for (Tonality tonality : values)
            assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    @Test
    public void valuesSize() {
        Set<Tonality> tonalities = TonalityRetrieval.ET12.ALL_MAJOR_MINOR;

        assertEquals( 24, tonalities.size() );
    }

    private void valuesContains(Tonality tonality) {
        Set<Tonality> tonalities = TonalityRetrieval.ET12.ALL_MAJOR_MINOR;

        assertTrue( tonality.toString(), tonalities.contains(tonality) );
    }

    private void valuesNotContains(Tonality tonality) {
        Set<Tonality> tonalities = TonalityRetrieval.ET12.ALL_MAJOR_MINOR;

        assertFalse( tonality.toString(), tonalities.contains(tonality) );
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
        valuesContains(Tonality.Ab);
    }

    @Test
    public void valuesContains4() {
        valuesNotContains(Tonality.from(DiatonicAlt.Ab, Scale.DORIAN));
    }

    @Test
    public void valuesContains5() {
        valuesNotContains(Tonality.from(DiatonicAlt.GG, Scale.DORIAN));
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
        assertSame(Tonality.Gb.innerTonality, tonality.innerTonality);
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
        Tonality tonality = Tonality.from(DiatonicAlt.FF, Scale.MAJOR);

        assertEquals(Scale.MAJOR, tonality.getScale());
        assertEquals(DiatonicAlt.FF, tonality.getRoot());
        assertSame(Tonality.FF.innerTonality, tonality.innerTonality);
        assertNotEquals(Tonality.Gb, tonality);
    }

    @Test
    public void fromChromaticScale() {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MAJOR);

        assertEquals(Scale.MAJOR, tonality.getScale());
        assertEquals(DiatonicAlt.FF, tonality.getRoot());
        assertNotEquals(DiatonicAlt.Gb, tonality.getRoot());
        assertSame(Tonality.FF.innerTonality, tonality.innerTonality);
    }

    @Test
    public void fromChromaticScale2() {
        Tonality tonality = Tonality.from(Chromatic.DD, Scale.MINOR);

        assertEquals(Scale.MINOR, tonality.getScale());
        assertEquals(DiatonicAlt.DD, tonality.getRoot());
        assertNotEquals(DiatonicAlt.Eb, tonality.getRoot());
        assertSame(Tonality.DDm.innerTonality, tonality.innerTonality);
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
        Tonality tonality = Tonality.from(Chromatic.C, Scale.DORIAN);
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
        Tonality tonality = Tonality.from(Chromatic.C, Scale.DORIAN);
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
        assertEquals(DiatonicAlt.C, Tonality.C.getNote(DiatonicDegree.I));
        assertEquals(DiatonicAlt.B, Tonality.C.getNote(DiatonicDegree.VII));
        assertEquals(DiatonicAlt.Bb, Tonality.Cm.getNote(DiatonicDegree.VII));
        assertNotEquals(DiatonicAlt.AA, Tonality.Cm.getNote(DiatonicDegree.VII));
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
        ScaleDegree relativeDegree = ChromaticDegree.V;
        Scale scale = Scale.CHROMATIC;
        Tonality tonality = Tonality.from(DiatonicAlt.C, scale);

        assertEquals(DiatonicAlt.E,
                tonality.getNote(relativeDegree));
    }

    @Test
    public void getChromaticDegree3() throws ScaleRelativeDegreeException {
        ScaleDegree relativeDegree = ChromaticDegree.VIII;
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
    public void getRoot1() {
        assertEquals( DiatonicAlt.C, Tonality.C.getRoot() );
    }

    @Test
    public void getRoot2() {
        assertEquals( DiatonicAlt.Bb, Tonality.Bb.getRoot() );
    }

    @Test
    public void getRoot3() {
        assertEquals( DiatonicAlt.Bb, Tonality.Bbm.getRoot() );
    }

    @Test
    public void getScale1() {
        assertEquals( Scale.MAJOR, Tonality.C.getScale() );
    }

    @Test
    public void getScale2() {
        assertEquals( Scale.MAJOR, Tonality.Bb.getScale() );
    }

    @Test
    public void getScale3() {
        assertEquals( Scale.MINOR, Tonality.Bbm.getScale() );
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
        assertEquals(notes, Tonality.C );
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
        assertEquals(notes, Tonality.Am );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tryToEditNotes() {
        //Tonality.C.set(0, DiatonicAlt.CC);
    }

    @Test
    public void equals1() {
        Tonality tonality = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
        assertEquals( Tonality.C, tonality );
    }

    @Test
    public void equals2() {
        Tonality tonality = Tonality.from(DiatonicAlt.Bb, Scale.MAJOR);
        assertNotEquals( Tonality.C, tonality );
    }

    @Test
    public void equals3() {
        Tonality tonality1 = Tonality.from(DiatonicAlt.GG, Scale.DORIAN);
        Tonality tonality2 = Tonality.from(DiatonicAlt.Ab, Scale.DORIAN);
        assertNotEquals( tonality1, tonality2 );
    }

    @Test
    public void hashCode1() {
        Tonality tonality = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
        assertEquals( Tonality.C.hashCode(), tonality.hashCode() );
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
        assertEquals(0, Tonality.C.getDiatonicAlterationsNumber());
        assertEquals(0, Tonality.Am.getDiatonicAlterationsNumber());
        assertEquals(5, Tonality.Db.getDiatonicAlterationsNumber());
        assertEquals(2, Tonality.D.getDiatonicAlterationsNumber());
        assertEquals(3, Tonality.Eb.getDiatonicAlterationsNumber());
        assertEquals(4, Tonality.E.getDiatonicAlterationsNumber());
        assertEquals(3, Tonality.Cm.getDiatonicAlterationsNumber());
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
        assertNotEquals(Tonality.FF, Tonality.Gb);
    }
    @Test
    public void enharmonicNotEquals2() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        assertNotEquals(Tonality.C, tonality);
    }

    @Test
    public void minimizeAlterationsBB() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        Tonality minimizedTonality = TonalityRetrieval.getEnharmonicMinimalAltsFrom(tonality).iterator().next();

        assertEquals(Tonality.C, minimizedTonality);
    }

    @Test
    public void minimizeAlterationsSize1() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);
        Set<Tonality> minimizedTonalityList = TonalityRetrieval.getEnharmonicMinimalAltsFrom(tonality);

        assertEquals(1, minimizedTonalityList.size());
    }

    @Test
    public void minimizeAlterationsSizeNot1() {
        Set<Tonality> tonalityList = TonalityRetrieval.getEnharmonicMinimalAltsFrom(Tonality.Gb);

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
        Set<Tonality> minTonalityListGG = TonalityRetrieval.getEnharmonicMinimalAltsFrom(Tonality.from(DiatonicAlt.GG, Scale.MAJOR));
        Set<Tonality> minTonalityListFb = TonalityRetrieval.getEnharmonicMinimalAltsFrom(Tonality.from(DiatonicAlt.Ab, Scale.MAJOR));

        assertEquals(minTonalityListFb.hashCode(), minTonalityListGG.hashCode());
        assertEquals(minTonalityListFb, minTonalityListGG);
    }

    @Test
    public void minimizeAlterationsBidirectionalAll() {
        for (Tonality tonality : TonalityRetrieval.allUsualKeys()) {
            Set<Tonality> minTonalityListReference = TonalityRetrieval.getEnharmonicMinimalAltsFrom(tonality);

            if (minTonalityListReference.size() > 1)
                for (Tonality minTonality : minTonalityListReference) {
                    Set<Tonality> minTonalityListParticular = TonalityRetrieval.getEnharmonicMinimalAltsFrom(minTonality);

                    assertEquals(minTonalityListReference, minTonalityListParticular);
                }
        }
    }

    @Test
    public void getChordFunction() {
        Tonality ton = Tonality.E;
        ChromaticChord cc = ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.I)
                .build();

        assertEquals(ChromaticChord.E, cc);
        cc = ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.VII)
                .build();

        assertEquals(ChromaticChord.DDdim, cc);

        ton = Tonality.Em;
        cc = ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.I)
                .build();

        assertEquals(ChromaticChord.Em, cc);
        cc = ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.VII)
                .build();

        assertEquals(ChromaticChord.D, cc);

        ton = Tonality.C;
        cc = ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.V7)
                .build();

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
        Tonality ton = Tonality.C;

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
    public void hasFromDiatonicFunction() {
        for (Tonality t : TonalityRetrieval.ET12.ALL_MAJOR_MINOR)
            for (DiatonicFunction df : DiatonicFunction.values()) {
                ChromaticChord chromaticChord = ChromaticChord.builder()
                        .tonality(t)
                        .diatonicFunction(df)
                        .build();
                assertTrue(t.toString() + " " + df.toString() + " " + chromaticChord.toString(), t.containsAll(chromaticChord));
            }
    }

    @Test
    public void getDegree() throws TonalityException {
        Tonality ton = Tonality.C;

        assertEquals(DiatonicDegree.I, ton.getDegreeFrom(PitchChromaticMidi.C5.getChromatic()));
        assertEquals(DiatonicDegree.II, ton.getDegreeFrom(PitchChromaticMidi.D5.getChromatic()));
        assertEquals(DiatonicDegree.III, ton.getDegreeFrom(PitchChromaticMidi.E6.getChromatic()));
        assertEquals(DiatonicDegree.IV, ton.getDegreeFrom(Chromatic.F));
        assertNull(ton.getDegreeFrom(DiatonicAlt.EEEE));
        assertEquals(DiatonicDegree.V, ton.getDegreeFrom(Chromatic.from(DiatonicAlt.EEEE)));
    }

    @Test
    public void get() {
        Tonality ton = Tonality.C;
        assertEquals(ChromaticChord.C, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.I)
                .build());
        assertEquals(ChromaticChord.Dm, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.II)
                .build()
        );
        assertEquals(ChromaticChord.Em, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.III)
                .build()
        );
        assertEquals(ChromaticChord.F, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.IV)
                .build()
        );
        assertEquals(ChromaticChord.G, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.V)
                .build()
        );
        assertEquals(ChromaticChord.Am, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.VI)
                .build()
        );
        assertEquals(ChromaticChord.Bdim, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.VII)
                .build()
        );

        assertEquals(ChromaticChord.Csus4, ChromaticChord.builder()
                .tonality(ton)
                .harmonicFunction(ChromaticFunction.ISUS4)
                .build()
        );
        assertEquals(ChromaticChord.Dsus4, ChromaticChord.builder()
                .tonality(ton)
                .harmonicFunction(ChromaticFunction.IISUS4)
                .build()
        );
        assertEquals(ChromaticChord.DDsus4, ChromaticChord.builder()
                .tonality(ton)
                .harmonicFunction(ChromaticFunction.bIIISUS4)
                .build()
        );
        assertEquals(ChromaticChord.Gsus4, ChromaticChord.builder()
                .tonality(ton)
                .harmonicFunction(ChromaticFunction.VSUS4)
                .build()
        );
        assertEquals(ChromaticChord.Asus4, ChromaticChord.builder()
                .tonality(ton)
                .harmonicFunction(ChromaticFunction.VISUS4)
                .build()
        );

        assertEquals(ChromaticChord.C6, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.I6)
                .build()
        );
        assertEquals(ChromaticChord.Dm6, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.II6)
                .build());
        assertEquals(ChromaticChord.F6, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.IV6)
                .build());
        assertEquals(ChromaticChord.G6, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.V6)
                .build());

        assertEquals(ChromaticChord.CMaj7, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.I7)
                .build());
        assertEquals(ChromaticChord.Dm7, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.II7)
                .build());
        assertEquals(ChromaticChord.Em7, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.III7)
                .build());
        assertEquals(ChromaticChord.FMaj7, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.IV7)
                .build());
        assertEquals(ChromaticChord.G7, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.V7)
                .build());
        assertEquals(ChromaticChord.Am7, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.VI7)
                .build());
        assertEquals(ChromaticChord.Bm7b5, ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.VII7)
                .build());

        assertEquals(ChromaticChord.C5, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.I5)
                .build());
        assertEquals(ChromaticChord.D5, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.II5)
                .build());
        assertEquals(ChromaticChord.E5, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.III5)
                .build());
        assertEquals(ChromaticChord.F5, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.IV5)
                .build());
        assertEquals(ChromaticChord.G5, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V5)
                .build());
        assertEquals(ChromaticChord.A5, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.VI5)
                .build());
        assertEquals(ChromaticChord.B5, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.VII5)
                .build());

        assertEquals(ChromaticChord.A, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V_II)
                .build());
        assertEquals(ChromaticChord.B, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V_III)
                .build());
        assertEquals(ChromaticChord.C, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V_IV)
                .build());
        assertEquals(ChromaticChord.builder()
                        .tonality(ton)
                        .diatonicFunction(DiatonicFunction.I)
                        .build(),
                ChromaticChord.builder()
                        .tonality(ton)
                        .chromaticFunction(ChromaticFunction.V_IV)
                        .build());
        assertEquals(ChromaticChord.D, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V_V)
                .build());
        assertEquals(ChromaticChord.E, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V_VI)
                .build());

        assertEquals(ChromaticChord.A7, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V7_II)
                .build());
        assertEquals(ChromaticChord.B7, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V7_III)
                .build());
        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V7_IV).build(), ChromaticChord.C7);
        assertEquals(ChromaticChord.D7, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V7_V)
                .build());
        assertEquals(ChromaticChord.E7, ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V7_VI)
                .build());

        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.SUBV7).build(), ChromaticChord.CC7);

        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.SUBV7_II).build(), ChromaticChord.DD7);

        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.SUBV7_III).build(), ChromaticChord.F7);

        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.SUBV7_IV).build(), ChromaticChord.FF7);

        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.SUBV7_V).build(), ChromaticChord.GG7);

        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.SUBV7_VI).toString(), ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.SUBV7_VI).build(), ChromaticChord.AA7);

        ChromaticChord c = ChromaticChord.CC.clone();
        c.inv();

        assertEquals(
                c, ChromaticChord.builder()
                        .tonality(ton)
                        .chromaticFunction(ChromaticFunction.N6)
                        .build()
        );

        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .chromaticFunction(ChromaticFunction.V7ALT).build(), ChromaticChord.Gm7b5);

        ton = Tonality.Cm;
        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.VII7).build(), ChromaticChord.AA7);

        ton = Tonality.Db;
        assertEquals(ChromaticChord.builder()
                .tonality(ton)
                .diatonicFunction(DiatonicFunction.II).build(), ChromaticChord.DDm);
    }

    @Test
    public void getFunction() {
        Tonality ton = Tonality.C;
        assertEquals(DiatonicFunction.I, ton.getFunctionFrom(ChromaticChord.C));
        assertEquals(DiatonicFunction.II, ton.getFunctionFrom(ChromaticChord.Dm));
        assertEquals(DiatonicFunction.III, ton.getFunctionFrom(ChromaticChord.Em));
        assertEquals(DiatonicFunction.IV, ton.getFunctionFrom(ChromaticChord.F));
        assertEquals(DiatonicFunction.V, ton.getFunctionFrom(ChromaticChord.G));
        assertEquals(DiatonicFunction.VI, ton.getFunctionFrom(ChromaticChord.Am));
        assertEquals(DiatonicFunction.VII, ton.getFunctionFrom(ChromaticChord.Bdim));

        assertEquals(ChromaticFunction.ISUS4, ton.getFunctionFrom(ChromaticChord.Csus4));
        assertEquals(ChromaticFunction.IISUS4, ton.getFunctionFrom(ChromaticChord.Dsus4));
        assertEquals(ChromaticFunction.bIIISUS4, ton.getFunctionFrom(ChromaticChord.DDsus4));
        assertEquals(ChromaticFunction.VSUS4, ton.getFunctionFrom(ChromaticChord.Gsus4));
        assertEquals(ChromaticFunction.VISUS4, ton.getFunctionFrom(ChromaticChord.Asus4));

        assertEquals(DiatonicFunction.I6, ton.getFunctionFrom(ChromaticChord.C6));
        assertEquals(DiatonicFunction.II6, ton.getFunctionFrom(ChromaticChord.Dm6));
        assertEquals(DiatonicFunction.IV6, ton.getFunctionFrom(ChromaticChord.F6));
        assertEquals(DiatonicFunction.V6, ton.getFunctionFrom(ChromaticChord.G6));

        assertEquals(DiatonicFunction.I7, ton.getFunctionFrom(ChromaticChord.CMaj7));
        assertEquals(DiatonicFunction.II7, ton.getFunctionFrom(ChromaticChord.Dm7));
        assertEquals(DiatonicFunction.III7, ton.getFunctionFrom(ChromaticChord.Em7));
        assertEquals(DiatonicFunction.IV7, ton.getFunctionFrom(ChromaticChord.FMaj7));
        assertEquals(DiatonicFunction.V7, ton.getFunctionFrom(ChromaticChord.G7));
        assertEquals(DiatonicFunction.VI7, ton.getFunctionFrom(ChromaticChord.Am7));
        assertEquals(DiatonicFunction.VII7, ton.getFunctionFrom(ChromaticChord.Bm7b5));
    }

    @Test
    public void getDiatonicFunction() {
        Tonality t = Tonality.C;
        for (DiatonicFunction df : DiatonicFunction.values()) {
            assertNotNull(ChromaticChord.builder()
                    .tonality(t)
                    .diatonicFunction(df)
                    .build());
        }
    }

    @Test
    public void getChromaticFunction() {
        Tonality t = Tonality.C;
        for (ChromaticFunction cf : ChromaticFunction.values()) {
            assertNotNull(ChromaticChord.builder()
                    .tonality(t)
                    .chromaticFunction(cf)
                    .build());
        }
    }

    @Test
    public void getChordFromHarmonicFunction() {
        Tonality t = Tonality.C;

        t.getChordFromHarmonicFunction(DiatonicFunction.I);
    }

    @Test
    public void scaleRelative() throws ScaleRelativeDegreeException {
        Tonality scale = Tonality.E.getRelativeScaleDiatonic( DiatonicDegree.V );
        assertEquals( DiatonicAlt.B, scale.getRoot() );
        assertEquals( Tonality.from( Chromatic.B, Scale.MAJOR ).getScale(), scale.getScale() );
    }

    @Test
    public void getNoteFromDiatonicDegree() throws ScaleRelativeDegreeException {
        Tonality tonality = Tonality.C;

        assertEquals(DiatonicAlt.C, tonality.getRoot());

        assertEquals(DiatonicAlt.C, tonality.getNote(DiatonicDegree.I));
        assertEquals(DiatonicAlt.D, tonality.getNote(DiatonicDegree.II));
    }
}
