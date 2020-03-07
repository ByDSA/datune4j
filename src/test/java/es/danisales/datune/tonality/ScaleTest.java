package es.danisales.datune.tonality;

import es.danisales.datune.degrees.scale.ChromaticDegree;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.degrees.scale.PentatonicDegree;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ScaleTest {
    /* fromScaleDistances */

    @Test
    public void fromScaleDistances() {
        List<ScaleDistance> listAdded = Collections.unmodifiableList(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ) );
        Scale scale = Scale.fromDistances(listAdded);

        assertEquals(listAdded, scale.getCode());
        assertEquals(7, scale.size());
    }

    @Test
    public void fromScaleDistances_Microtonal() {
        List<ScaleDistance> listAdded = Collections.unmodifiableList(Arrays.asList(
                ScaleDistance.QUARTER,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.QUARTER
        ) );
        Scale scale = Scale.fromDistances(listAdded);

        assertEquals(listAdded, scale.getCode());
        assertEquals(13, scale.size());
    }

    @Test(expected = ScaleBuildingException.class)
    public void fromScaleDistances_DontSum12() {
        List<ScaleDistance> listAdded = Collections.unmodifiableList(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE
        ) );

        Scale scale = Scale.fromDistances(listAdded);
        assertTrue(scale.getCode().size() < 7);
    }

    /* fromIntegers */

    @Test(expected = ScaleBuildingException.class)
    public void fromIntegers_DontSum12() {
        Scale scale = Scale.fromIntegers(Arrays.asList(2, 2, 1, 2, 2, 2));
        assertTrue(scale.getCode().size() < 7);
    }

    @Test
    public void fromIntegers_list() {
        Scale scale = Scale.fromIntegers(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        assertEquals(Scale.CHROMATIC, scale);
        assertEquals(Scale.CHROMATIC.hashCode(), scale.hashCode());
        assertEquals(12, scale.getCode().size());
    }

    @Test
    public void fromIntegers_list2() {
        Scale scale = Scale.fromIntegers(Arrays.asList(2, 2, 1, 2, 2, 2, 1));
        assertEquals(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ), scale.getCode());
    }

    @Test
    public void fromIntegers_array() {
        Scale scale = Scale.fromIntegers(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertEquals(Scale.CHROMATIC, scale);
        assertEquals(Scale.CHROMATIC.hashCode(), scale.hashCode());
        assertEquals(12, scale.getCode().size());
    }

    @Test
    public void fromIntegers_array2() {
        Scale scale = Scale.fromIntegers(2, 2, 1, 2, 2, 2, 1);
        assertEquals(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ), scale.getCode());
    }

    /* fromDiatonicAlt */

    @Test
    public void fromDiatonicAlt() {
        Scale scale = Scale.fromDiatonicAlt(Arrays.asList(
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E,
                DiatonicAlt.F,
                DiatonicAlt.G,
                DiatonicAlt.A,
                DiatonicAlt.B
        ) );

        assertEquals(Scale.MAJOR, scale);
        assertEquals(Scale.MAJOR.hashCode(), scale.hashCode());
    }

    @Test
    public void fromDiatonicAlt2() {
        Scale scale = Scale.fromDiatonicAlt(Arrays.asList(
                DiatonicAlt.A,
                DiatonicAlt.B,
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E,
                DiatonicAlt.F,
                DiatonicAlt.G
        ) );

        assertEquals(Scale.MINOR, scale);
        assertEquals(Scale.MINOR.hashCode(), scale.hashCode());
    }

    @Test
    public void fromDiatonicAlt3() {
        Scale scale = Scale.fromDiatonicAlt(Arrays.asList(
                DiatonicAlt.F,
                DiatonicAlt.G,
                DiatonicAlt.A,
                DiatonicAlt.Bb,
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E
        ) ); // Fa Major

        assertEquals(Scale.MAJOR, scale);
        assertEquals(Scale.MAJOR.hashCode(), scale.hashCode());
    }

    @Test
    public void fromDiatonicAlt_Unsorted() {
        Scale scale = Scale.fromDiatonicAlt(Arrays.asList(
                DiatonicAlt.A,
                DiatonicAlt.C,
                DiatonicAlt.F,
                DiatonicAlt.D,
                DiatonicAlt.B,
                DiatonicAlt.G,
                DiatonicAlt.E
        ) );

        assertEquals(Scale.MINOR, scale);
    }

    @Test
    public void fromDiatonicAlt_DuplicatedNotes() {
        Scale scale = Scale.fromDiatonicAlt(Arrays.asList(
                DiatonicAlt.A,
                DiatonicAlt.C,
                DiatonicAlt.A,
                DiatonicAlt.F,
                DiatonicAlt.D,
                DiatonicAlt.B,
                DiatonicAlt.B,
                DiatonicAlt.G,
                DiatonicAlt.G,
                DiatonicAlt.E,
                DiatonicAlt.E
        ));

        assertEquals(Scale.MINOR, scale);
    }

    @Test
    public void fromDiatonicAlt_DuplicatedNotesEnharmonic() {
        Scale scale = Scale.fromDiatonicAlt(Arrays.asList(
                DiatonicAlt.A,
                DiatonicAlt.BB,
                DiatonicAlt.C,
                DiatonicAlt.Gbb,
                DiatonicAlt.F,
                DiatonicAlt.D,
                DiatonicAlt.B,
                DiatonicAlt.Cb,
                DiatonicAlt.G,
                DiatonicAlt.AAA,
                DiatonicAlt.E,
                DiatonicAlt.E
        ));

        assertEquals(Scale.MINOR, scale);
    }

    @Test
    public void fromDiatonicAlt_List() throws ScaleRelativeDegreeException {
        Tonality<DiatonicAlt> s = TonalityClassical.A;
        List<DiatonicAlt> notes = new ArrayList<>();
        for (DiatonicDegree diatonicDegree : DiatonicDegree.values())
            notes.add(s.getNote(diatonicDegree));

        assertEquals(s.getScale(), Scale.fromDiatonicAlt(notes));
        assertEquals(s.getScale().hashCode(), Scale.fromDiatonicAlt(notes).hashCode());
    }

    /* getMode */

    @Test
    public void getMode() throws ScaleRelativeDegreeException {
        assertEquals(Scale.DORIAN, Scale.IONIAN.getModeFrom(DiatonicDegree.II));
    }

    @Test
    public void getMode_Pentatonic() throws ScaleRelativeDegreeException {
        assertEquals(Scale.PENTATONIC, Scale.PENTATONIC_MINOR.getModeFrom(PentatonicDegree.II));
    }

    @Test
    public void getMode_PentatonicDiatonicDegree() throws ScaleRelativeDegreeException {
        assertEquals(Scale.PENTATONIC, Scale.PENTATONIC_MINOR.getModeFrom(DiatonicDegree.III));
    }

    @Test(expected = ScaleRelativeDegreeException.class)
    public void getModePentatonicDiatonicDegreeImpossible() throws ScaleRelativeDegreeException {
        assertEquals(Scale.PENTATONIC, Scale.PENTATONIC_MINOR.getModeFrom(DiatonicDegree.II));
    }

    /* getParallelModes */

    @Test
    public void getModes_FromMajor() {
        Scale scale = Scale.MAJOR;

        List<Scale> scaleModes = scale.getModes();

        assertEquals(6, scaleModes.size());
        assertSame(Scale.DORIAN.innerScale, scaleModes.get(0).innerScale);
        assertSame(Scale.PHRYGIAN.innerScale, scaleModes.get(1).innerScale);
        assertSame(Scale.LYDIAN.innerScale, scaleModes.get(2).innerScale);
        assertSame(Scale.MIXOLYDIAN.innerScale, scaleModes.get(3).innerScale);
        assertSame(Scale.MINOR.innerScale, scaleModes.get(4).innerScale);
        assertSame(Scale.LOCRIAN.innerScale, scaleModes.get(5).innerScale);
    }

    @Test
    public void getModes_FromPentatonic() {
        Scale scale = Scale.PENTATONIC;

        List<Scale> scaleModes = scale.getModes();

        assertEquals(4, scaleModes.size());
        assertSame(Scale.EGYPCIAN.innerScale, scaleModes.get(0).innerScale);
        assertSame(Scale.BLUES_MINOR.innerScale, scaleModes.get(1).innerScale);
        assertSame(Scale.BLUES_MAJOR.innerScale, scaleModes.get(2).innerScale);
        assertSame(Scale.PENTATONIC_MINOR.innerScale, scaleModes.get(3).innerScale);
    }

    @Test
    public void getModes_FromWholeNoteScale() {
        Scale scale = Scale.WHOLE_TONE;

        List<Scale> scaleModes = scale.getModes();

        assertEquals(5, scaleModes.size());
        assertSame(Scale.WHOLE_TONE.innerScale, scaleModes.get(0).innerScale);
        assertSame(Scale.WHOLE_TONE.innerScale, scaleModes.get(1).innerScale);
        assertSame(Scale.WHOLE_TONE.innerScale, scaleModes.get(2).innerScale);
        assertSame(Scale.WHOLE_TONE.innerScale, scaleModes.get(3).innerScale);
        assertSame(Scale.WHOLE_TONE.innerScale, scaleModes.get(4).innerScale);
    }

    /* getCode */

    @Test
    public void getCode() {
        assertEquals(
                Arrays.asList(
                        ScaleDistance.WHOLE,
                        ScaleDistance.HALF,
                        ScaleDistance.WHOLE,
                        ScaleDistance.WHOLE,
                        ScaleDistance.HALF,
                        ScaleDistance.WHOLE,
                        ScaleDistance.WHOLE
                ), Scale.MINOR.getCode()
        );
    }

    /* size */

    @Test
    public void size() {
        assertEquals(7, Scale.MAJOR.size());
        assertEquals(7, Scale.MINOR.size());
        assertEquals(5, Scale.PENTATONIC.size());
        assertEquals(6, Scale.WHOLE_TONE.size());
        assertEquals(12, Scale.CHROMATIC.size());
    }

    @Test
    public void size_Custom() {
        assertEquals(13, Scale.fromDistances(Arrays.asList(
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER
        )).size());
    }

    /* iterator */

    @Test
    public void iterator() {
        Iterator<ScaleDistance> iterator = Scale.MAJOR.iterator();
        assertNotNull(iterator);
    }

    @Test
    public void iterator_Next() {
        Iterator<ScaleDistance> iterator = Scale.MAJOR.iterator();
        assertEquals(ScaleDistance.WHOLE, iterator.next());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemove() {
        Iterator<ScaleDistance> iterator = Scale.MAJOR.iterator();
        iterator.next();
        iterator.remove();
    }

    @Test
    public void iterator_HasNext() {
        Iterator<ScaleDistance> iterator = Scale.PENTATONIC.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextEnd() {
        Iterator<ScaleDistance> iterator = Scale.MAJOR.iterator();
        while (iterator.hasNext())
            iterator.next();
        iterator.next();
    }

    /* getDistance ScaleDegree */

    @Test
    public void getDistance() throws ScaleRelativeDegreeException {
        assertEquals(ScaleDistance.NONE, Scale.MAJOR.getDistance(DiatonicDegree.I));
        assertEquals(ScaleDistance.WHOLE, Scale.MAJOR.getDistance(DiatonicDegree.II));
        assertEquals(ScaleDistance.HALF, Scale.MAJOR.getDistance(DiatonicDegree.IV));
        assertEquals(ScaleDistance.WHOLE, Scale.MAJOR.getDistance(DiatonicDegree.VII));
    }

    @Test
    public void getDistance_PentatonicScale() throws ScaleRelativeDegreeException {
        assertEquals(ScaleDistance.NONE, Scale.PENTATONIC.getDistance(PentatonicDegree.I));
        assertEquals(ScaleDistance.WHOLE, Scale.PENTATONIC.getDistance(PentatonicDegree.II));
        assertEquals(ScaleDistance.WHOLE_HALF, Scale.PENTATONIC.getDistance(PentatonicDegree.IV));
    }

    @Test
    public void getDistance_ChromaticScale() throws ScaleRelativeDegreeException {
        for (ChromaticDegree chromaticDegree = ChromaticDegree.I;
             chromaticDegree.getPrevious() != ChromaticDegree.VII;
             chromaticDegree = chromaticDegree.getNext())
            if (chromaticDegree == ChromaticDegree.I)
                assertEquals(ScaleDistance.NONE, Scale.CHROMATIC.getDistance(chromaticDegree));
            else
                assertEquals(ScaleDistance.HALF, Scale.CHROMATIC.getDistance(chromaticDegree));
    }

    @Test
    public void getDistance_WholeToneScale() throws ScaleRelativeDegreeException {
        List<ScaleDegree> degrees = ScaleDegree.getDefaultDegreesFromScaleSize(Scale.WHOLE_TONE.size());
        for (ScaleDegree degree : degrees)
            if (degree == degrees.get(0))
                assertEquals(ScaleDistance.NONE, Scale.WHOLE_TONE.getDistance(degree));
            else
                assertEquals(ScaleDistance.WHOLE, Scale.WHOLE_TONE.getDistance(degree));
    }

    @Test
    public void getDistance_PentatonicScale_DiatonicDegree_Found() throws ScaleRelativeDegreeException {
        assertEquals(ScaleDistance.NONE, Scale.PENTATONIC.getDistance(DiatonicDegree.I));
    }

    @Test(expected = ScaleRelativeDegreeException.class)
    public void getDistance_PentatonicScale_DiatonicDegree_NotFound() throws ScaleRelativeDegreeException {
        Scale.PENTATONIC.getDistance(DiatonicDegree.VII);
    }

    /* getIndexByDegree */

    @Test
    public void getIndexByDegree() throws ScaleRelativeDegreeException {
        Scale scale = Scale.MAJOR;
        DiatonicDegree diatonicDegree = DiatonicDegree.VII;
        Integer ret = scale.getIndexByDegree(diatonicDegree);
        assertEquals((Integer) 6, ret);
    }

    @Test
    public void getIndexByDegree_PentatonicScale_DiatonicDegree_Found() throws ScaleRelativeDegreeException {
        Scale scale = Scale.PENTATONIC;
        DiatonicDegree diatonicDegree = DiatonicDegree.I;
        Integer ret = scale.getIndexByDegree(diatonicDegree);
        assertEquals((Integer) 0, ret);
    }

    @Test(expected = ScaleRelativeDegreeException.class)
    public void getIndexByDegree_PentatonicScale_DiatonicDegree_NotFound() throws ScaleRelativeDegreeException {
        Scale scale = Scale.PENTATONIC_MINOR;
        DiatonicDegree diatonicDegree = DiatonicDegree.II;
        scale.getIndexByDegree(diatonicDegree);
    }

    @Test
    public void getIndexByDegree_PentatonicScale_PentatonicDegree() throws ScaleRelativeDegreeException {
        Scale scale = Scale.PENTATONIC_MINOR;
        PentatonicDegree pentatonicDegree = PentatonicDegree.II;
        Integer ret = scale.getIndexByDegree(pentatonicDegree);
        assertEquals((Integer) 1, ret);
    }

    /* degreeGetter */

    @Test
    public void degreeGetter() {
        Scale scale = Scale.MAJOR;
        Set<ScaleDegree> degreeSet = scale.degreeGetter()
                .index(0)
                .get();
        assertEquals(1, degreeSet.size());
        assertTrue(degreeSet.contains(DiatonicDegree.I));
    }

    @Test
    public void degreeGetter_Pentatonic() {
        Scale scale = Scale.PENTATONIC;
        Set<ScaleDegree> degreeSet = scale.degreeGetter()
                .index(0)
                .get();
        assertEquals(2, degreeSet.size());
        assertTrue(degreeSet.contains(DiatonicDegree.I));
        assertTrue(degreeSet.contains(PentatonicDegree.I));
    }

    @Test
    public void degreeGetter_Pentatonic2() {
        Scale scale = Scale.PENTATONIC_MINOR;
        Set<ScaleDegree> degreeSet = scale.degreeGetter()
                .index(1)
                .get();
        assertEquals(2, degreeSet.size());
        assertTrue(degreeSet.contains(DiatonicDegree.III));
        assertTrue(degreeSet.contains(PentatonicDegree.II));
    }

    @Test
    public void degreeGetter_Chromatic() {
        Scale scale = Scale.CHROMATIC;
        Set<ScaleDegree> degreeSet = scale.degreeGetter()
                .index(7)
                .get();
        assertEquals(2, degreeSet.size());
        assertTrue(degreeSet.contains(DiatonicDegree.V));
        assertTrue(degreeSet.contains(ChromaticDegree.V));
    }

    /* degreeGetter Diatonic */

    @Test
    public void degreeGetterDiatonic() {
        Scale scale = Scale.MAJOR;
        DiatonicDegree diatonicDegree = scale.degreeGetter()
                .index(0)
                .getFirstOfClass(DiatonicDegree.class);
        assertEquals(DiatonicDegree.I, diatonicDegree);
    }

    @Test
    public void degreeGetterDiatonic2() {
        Scale scale = Scale.MAJOR;
        DiatonicDegree diatonicDegree = scale.degreeGetter()
                .index(6)
                .getFirstOfClass(DiatonicDegree.class);
        assertEquals(DiatonicDegree.VII, diatonicDegree);
    }

    @Test
    public void degreeGetterDiatonic_GreaterThanSize() {
        Scale scale = Scale.MAJOR;
        DiatonicDegree diatonicDegree = scale.degreeGetter()
                .index(7)
                .getFirstOfClass(DiatonicDegree.class);
        assertEquals(DiatonicDegree.I, diatonicDegree);
    }

    @Test
    public void degreeGetterDiatonic_LowerThanSize() {
        Scale scale = Scale.MAJOR;
        DiatonicDegree diatonicDegree = scale.degreeGetter()
                .index(-1)
                .getFirstOfClass(DiatonicDegree.class);
        assertEquals(DiatonicDegree.VII, diatonicDegree);
    }

    @Test
    public void degreeGetterDiatonic_Pentatonic() {
        Scale scale = Scale.PENTATONIC;
        DiatonicDegree diatonicDegree = scale.degreeGetter()
                .index(0)
                .getFirstOfClass(DiatonicDegree.class);
        assertEquals(DiatonicDegree.I, diatonicDegree);
    }

    @Test
    public void degreeGetterDiatonic_PentatonicGreaterThanSize() {
        Scale scale = Scale.PENTATONIC_MINOR;
        DiatonicDegree diatonicDegree = scale.degreeGetter()
                .index(5)
                .getFirstOfClass(DiatonicDegree.class);
        assertEquals(DiatonicDegree.I, diatonicDegree);
    }

    @Test
    public void degreeGetterDiatonic_PentatonicLowerThanSize() {
        Scale scale = Scale.PENTATONIC;
        DiatonicDegree pentatonicDegree = scale.degreeGetter()
                .index(-1)
                .getFirstOfClass(DiatonicDegree.class);
        assertEquals(DiatonicDegree.VI, pentatonicDegree);
    }

    /* setScaleDegreeReparametrizer */

    @Test
    public void setScaleDiatonicReparametrizer() {
        Scale scale = Scale.PENTATONIC.clone();
        assertNotNull(scale.degreeGetter()
                .index(0)
                .getFirstOfClass(DiatonicDegree.class)
        );

        scale.setScaleDegreeReparametrizer(null);

        assertNull(scale.degreeGetter()
                .index(0)
                .getFirstOfClass(DiatonicDegree.class)
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setScaleDiatonicReparametrizerFails() {
        Scale.PENTATONIC.setScaleDegreeReparametrizer(null);
    }

    @Test
    public void setScaleDegreeReparametrizer_autoTurnIntoImmutable() {
        Scale scale = Scale.CHROMATIC.clone();
        scale.setScaleDegreeReparametrizer(null);

        ScaleDegreeReparameterize scaleDiatonicReparametrizer = getCopyFrom(Scale.CHROMATIC);
        scale.setScaleDegreeReparametrizer(scaleDiatonicReparametrizer);

        assertEquals(Scale.CHROMATIC, scale);
        assertSame(Scale.CHROMATIC.innerScale, scale.innerScale);
    }

    @SuppressWarnings("SameParameterValue")
    private ScaleDegreeReparameterize getCopyFrom(Scale scale) {
        ScaleDegreeReparameterize scaleDiatonicReparametrizer = ScaleDegreeReparameterize.create();
        for (int i = 0; i < scale.size(); i++)
            scaleDiatonicReparametrizer.put(i,
                    scale.degreeGetter()
                            .index(i)
                            .getFirstOfClass(DiatonicDegree.class)
            );
        return scaleDiatonicReparametrizer;
    }

    /* isDiatonic */

    @Test
    public void isDiatonicTrue() {
        assertTrue(Scale.MAJOR.isDiatonic());
    }

    @Test
    public void isDiatonicAllDiatonics() {
        for (Scale scale : Scale.diatonicScales())
            assertTrue(scale.toString(), scale.isDiatonic());
    }

    @Test
    public void isDiatonicFalse() {
        assertFalse(Scale.PENTATONIC.isDiatonic());
    }

    /* innerScale */

    @Test
    public void autoTurnIntoImmutable() {
        Scale scale = Scale.fromIntegers(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

        assertEquals(Scale.CHROMATIC, scale);
        assertSame(Scale.CHROMATIC.innerScale, scale.innerScale);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void scaleEnumReusable1() {
        ScaleInnerImmutable scaleEnum = ScaleInnerImmutable.from(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ));

        assertSame(ScaleInnerImmutable.MAJOR, scaleEnum);
        assertNotSame(ScaleInnerImmutable.IONIAN, scaleEnum);
        assertEquals(ScaleInnerImmutable.MAJOR.hashCode(), scaleEnum.hashCode());
    }

    @Test
    public void scaleEnumReusableAsInner() {
        Scale scale = Scale.fromDistances(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ));

        ScaleInnerImmutable scaleEnum = (ScaleInnerImmutable) scale.innerScale;

        assertSame(ScaleInnerImmutable.MAJOR, scaleEnum);
        assertNotSame(ScaleInnerImmutable.IONIAN, scaleEnum);
    }

    @Test
    public void innerScaleNotNullAll() {
        for (Scale scale : Scale.allUsualScales())
            assertNotNull(scale.innerScale);
    }

    /* Others */

    @Test
    public void sameScaleWithDifferentName() {
        assertEquals(Scale.MINOR, Scale.AEOLIAN);
        assertEquals(Scale.MINOR.hashCode(), Scale.AEOLIAN.hashCode());
        assertNotSame(Scale.MINOR.innerScale, Scale.AEOLIAN.innerScale); // Es distinto enum

        assertEquals(Scale.MAJOR, Scale.IONIAN);
        assertEquals(Scale.MAJOR.hashCode(), Scale.IONIAN.hashCode());
        assertNotSame(Scale.MAJOR.innerScale, Scale.IONIAN.innerScale); // Es distinto enum
    }

    /* Equals */

    @Test
    public void equalsScaleOfListTwice() {
        List<ScaleDistance> listAdded = Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        );

        Scale scale1 = Scale.fromDistances(listAdded);
        Scale scale2 = Scale.fromDistances(listAdded);

        assertEquals(scale1, scale2);
        assertEquals(scale1.hashCode(), scale2.hashCode());
    }

    @Test
    public void equalsScaleOfListRespectMajor() {
        List<ScaleDistance> listAdded = Collections.unmodifiableList(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ));

        Scale scale = Scale.fromDistances(listAdded);

        assertEquals(Scale.MAJOR, scale);
        assertEquals(Scale.MAJOR.hashCode(), scale.hashCode());
    }

    @Test
    public void equalsDifferentName() {
        assertEquals(Scale.MAJOR, Scale.IONIAN);
        assertEquals(Scale.MAJOR.hashCode(), Scale.IONIAN.hashCode());
    }

    @Test
    public void equalsFromIntegers() {
        Scale a = Scale.MAJOR;

        Scale b = Scale.fromIntegers(Arrays.asList(2, 2, 1, 2, 2, 2, 1));
        assertNotSame(a, b);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void equalsFromScaleDistance() {
        Scale a = Scale.MAJOR;
        Scale b = Scale.fromDistances( Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ) );
        assertNotSame(a, b);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    /* toString */

    @Test
    public void toString_NotEmpty() {
        for (Scale scale : Scale.allUsualScales()) {
            checkNotEmptyScaleToString(scale);
        }
    }

    @Test
    public void toString_Custom_NotEmpty() {
        Scale scale = Scale.fromDistances(Arrays.asList(
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.HALF,
                ScaleDistance.QUARTER,
                ScaleDistance.QUARTER
        ));
        checkNotEmptyScaleToString(scale);
    }

    private void checkNotEmptyScaleToString(Scale scale) {
        assertNotNull(scale.toString());
        assertNotEquals("", scale.toString());
        assertNotEquals(" ", scale.toString());
    }

    /* clone */

    @Test
    public void cloneTest() {
        Scale scale = Scale.CHROMATIC.clone();

        assertEquals(Scale.CHROMATIC, scale);
        assertNotSame(Scale.CHROMATIC, scale);
        assertSame(Scale.CHROMATIC.innerScale, scale.innerScale);
    }

    @Test
    public void cloneTest2() {
        Scale scale = Scale.CHROMATIC.clone();
        scale.setScaleDegreeReparametrizer(null);

        assertNotEquals(Scale.CHROMATIC, scale);
    }

    /* hashCode */

    @Test
    public void hashCode_dependsOnCode() {
        assertNotEquals(Scale.MAJOR.hashCode(), Scale.DORIAN.hashCode());
        assertEquals(Scale.MAJOR.hashCode(), Scale.MAJOR.clone().hashCode());
    }

    @Test
    public void hashCode_dependsOnScaleDegreeReparametrizer() {
        assertEquals(Scale.BLUES_a4.getCode(), Scale.BLUES_b5.getCode());
        assertNotEquals(Scale.BLUES_a4.hashCode(), Scale.BLUES_b5.hashCode());
    }

    /* allUsual sizes */

    @Test
    public void allUsualScales_size() {
        assertEquals(49, Scale.allUsualScales().size());
    }

    @Test
    public void allUsualScales_hasDuplicates() {
        Set<Scale> setAllScales = new HashSet<>(Scale.allUsualScales());

        assertEquals(getScaleAllMinusSetAllScales(setAllScales).toString(),
                Scale.allUsualScales().size(), setAllScales.size());
    }

    private List<Scale> getScaleAllMinusSetAllScales(Set<Scale> setAllScales) {
        List<Scale> diff = new ArrayList<>(Scale.allUsualScales());
        main:
        for (int i = 0; i < diff.size(); i++) {
            for (Scale scale : setAllScales)
                if (diff.get(i) == scale) {
                    diff.remove(i);
                    i--;
                    continue main;
                }
        }

        return diff;
    }

    @Test
    public void diatonicScales_size() {
        assertEquals(7, Scale.diatonicScales().size());
    }

    @Test
    public void diatonicScales_hasIonianMajorAeolianMinor() {
        assertTrue(Scale.diatonicScales().contains(Scale.MAJOR));
        assertTrue(Scale.diatonicScales().contains(Scale.IONIAN));
        assertTrue(Scale.diatonicScales().contains(Scale.MINOR));
        assertTrue(Scale.diatonicScales().contains(Scale.AEOLIAN));
    }
}