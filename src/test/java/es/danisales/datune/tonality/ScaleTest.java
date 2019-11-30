package es.danisales.datune.tonality;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.musical.DiatonicAlt;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ScaleTest {
    @Test
    public void getMode() {
        assertEquals(Scale.DORIAN, Scale.IONIAN.getMode(DiatonicDegree.II));
    }

    @Test
    public void constantScalesSameAsScaleEnumSize() {
        assertEquals(ScaleInnerImmutable.values().length, Scale.ALL.size());
    }

    @Test
    public void constantScalesSameAsScaleEnumContent() {
        List<ScaleInnerImmutable> scaleEnumList = Arrays.asList(ScaleInnerImmutable.values());
        List<ScaleInnerImmutable> scaleEnumListFromScale = new ArrayList<>();
        for (Scale scale : Scale.ALL)
            scaleEnumListFromScale.add((ScaleInnerImmutable) scale.innerScale);

        for (ScaleInnerImmutable scaleEnum : scaleEnumListFromScale)
            assertTrue(scaleEnum.toString(), scaleEnumList.contains(scaleEnum));

        for (ScaleInnerImmutable scaleEnum : scaleEnumList) {
            assertTrue(scaleEnum.toString(), scaleEnumListFromScale.contains(scaleEnum));
        }

        assertEquals(ScaleInnerImmutable.values().length, Scale.ALL.size());
    }

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
    public void fromScaleDistancesMicrotonal() {
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
    public void fromScaleDistancesDontSum12() {
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

    @Test(expected = ScaleBuildingException.class)
    public void integersDontSum12() {
        Scale scale = Scale.fromIntegers(Arrays.asList(2, 2, 1, 2, 2, 2));
        assertTrue(scale.getCode().size() < 7);
    }

    @Test
    public void integersChromatic() {
        Scale scale = Scale.fromIntegers(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        assertEquals(Scale.CHROMATIC, scale);
        assertEquals(Scale.CHROMATIC.hashCode(), scale.hashCode());
        assertEquals(12, scale.getCode().size());
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
    public void fromDiatonicAltList1() {
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
    public void fromDiatonicAltList2() {
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
    public void fromDiatonicAltList3() {
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
    public void fromDiatonicAltListUnordered() {
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
    public void fromDuplicatedNotes() {
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
    public void fromDuplicatedNotesEnharmonic() {
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
    public void getAllModes() {
        Scale scale = Scale.MAJOR;

        List<Scale> scaleModes = scale.getModes();

        assertEquals(7, scaleModes.size());
        assertEquals(Scale.MAJOR, scaleModes.get(0));
        assertEquals(Scale.DORIAN, scaleModes.get(1));
        assertEquals(Scale.PHRYGIAN, scaleModes.get(2));
        assertEquals(Scale.LYDIAN, scaleModes.get(3));
        assertEquals(Scale.MIXOLYDIAN, scaleModes.get(4));
        assertEquals(Scale.AEOLIAN, scaleModes.get(5));
        assertEquals(Scale.LOCRIAN, scaleModes.get(6));

        assertEquals(Scale.MAJOR.hashCode(), scaleModes.get(0).hashCode());
        assertEquals(Scale.DORIAN.hashCode(), scaleModes.get(1).hashCode());
        assertEquals(Scale.PHRYGIAN.hashCode(), scaleModes.get(2).hashCode());
        assertEquals(Scale.LYDIAN.hashCode(), scaleModes.get(3).hashCode());
        assertEquals(Scale.MIXOLYDIAN.hashCode(), scaleModes.get(4).hashCode());
        assertEquals(Scale.AEOLIAN.hashCode(), scaleModes.get(5).hashCode());
        assertEquals(Scale.LOCRIAN.hashCode(), scaleModes.get(6).hashCode());
    }

    @Test
    public void isDiatonicTrue() {
        assertTrue(Scale.MAJOR.isDiatonic());
    }

    @Test
    public void isDiatonicAllDiatonics() {
        for (Scale scale : Scale.DIATONICS)
            assertTrue(scale.isDiatonic());
    }

    @Test
    public void isDiatonicFalse() {
        assertFalse(Scale.PENTATONIC.isDiatonic());
    }

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
        ) );

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

    @Test
    public void fromDiatonicAltList() {
        Tonality s = Tonality.A;
        List<DiatonicAlt> notes = new ArrayList<>();
        for (DiatonicDegree diatonicDegree : DiatonicDegree.values())
            notes.add(s.getNote(diatonicDegree));

        assertEquals(s.getScale(), Scale.fromDiatonicAlt(notes));
        assertEquals(s.getScale().hashCode(), Scale.fromDiatonicAlt(notes).hashCode());
    }

    @Test
    public void getNoteFromDiatonicDegree() {
        Tonality tonality = Tonality.C;

        assertEquals( DiatonicAlt.C, tonality.getRoot() );

        assertEquals( DiatonicAlt.C, tonality.getNote( DiatonicDegree.I ) );
        assertEquals( DiatonicAlt.D, tonality.getNote( DiatonicDegree.II ) );
    }

    @Test
    public void fromIntegers() {
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

    @Test
    public void toStringNotEmpty() {
        for (Scale scale : Scale.ALL) {
            assertNotNull(scale.toString());
            assertNotEquals("",scale.toString());
            assertNotEquals(" ",scale.toString());
        }
    }

    @Test
    public void innerScaleNotNullAll() {
        for (Scale scale : Scale.ALL)
            assertNotNull(scale.innerScale);
    }

    @Test
    public void hasIntervalChromatic() {
        assertTrue(Scale.MAJOR.hasIntervalFromRoot(IntervalChromatic.MAJOR_THIRD));
        assertTrue(Scale.PENTATONIC.hasIntervalFromRoot(IntervalChromatic.MAJOR_THIRD));
        assertFalse(Scale.MAJOR.hasIntervalFromRoot(IntervalChromatic.MINOR_THIRD));
        assertFalse(Scale.PENTATONIC.hasIntervalFromRoot(IntervalChromatic.MINOR_THIRD));
        assertTrue(Scale.MINOR.hasIntervalFromRoot(IntervalChromatic.MINOR_THIRD));
        assertTrue(Scale.PENTATONIC_MINOR.hasIntervalFromRoot(IntervalChromatic.MINOR_THIRD));
        assertTrue(Scale.MAJOR.hasIntervalFromRoot(IntervalChromatic.PERFECT_FIFTH));
        assertTrue(Scale.MINOR.hasIntervalFromRoot(IntervalChromatic.PERFECT_FIFTH));
        assertFalse(Scale.LOCRIAN.hasIntervalFromRoot(IntervalChromatic.PERFECT_FIFTH));
        assertTrue(Scale.LOCRIAN.hasIntervalFromRoot(IntervalChromatic.PERFECT_OCTAVE));
    }

    @Test
    public void hasIntervalChromaticGreatherThan12() {
        assertTrue(Scale.MAJOR.hasIntervalFromRoot(IntervalChromatic.MAJOR_TENTH));
        assertFalse(Scale.MAJOR.hasIntervalFromRoot(IntervalChromatic.MINOR_TENTH));
        assertTrue(Scale.MINOR.hasIntervalFromRoot(IntervalChromatic.MINOR_TENTH));
        assertTrue(Scale.MAJOR.hasIntervalFromRoot(IntervalChromatic.PERFECT_TWELFTH));
        assertTrue(Scale.MINOR.hasIntervalFromRoot(IntervalChromatic.PERFECT_TWELFTH));
        assertFalse(Scale.LOCRIAN.hasIntervalFromRoot(IntervalChromatic.PERFECT_TWELFTH));
    }

    @Test
    public void setScaleDiatonicReparametrizer() {
        Scale scale = Scale.PENTATONIC.clone();
        scale.setScaleDiatonicReparametrizer(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setScaleDiatonicReparametrizerFails() {
        Scale.PENTATONIC.setScaleDiatonicReparametrizer(null);
    }

    @Test
    public void getRelativeDegreeByIndex() {  // todo
    }

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
        scale.setScaleDiatonicReparametrizer(null);

        assertNotEquals(Scale.CHROMATIC, scale);
    }

    @Test
    public void autoTurnIntoImmutable() {
        Scale scale = Scale.CHROMATIC.clone();
        scale.setScaleDiatonicReparametrizer(null);

        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = getCopyFrom(Scale.CHROMATIC);
        scale.setScaleDiatonicReparametrizer(scaleDiatonicReparametrizer);

        assertEquals(Scale.CHROMATIC, scale);
        assertSame(Scale.CHROMATIC.innerScale, scale.innerScale);
    }

    @SuppressWarnings("SameParameterValue")
    private ScaleDegreeReparametrizer getCopyFrom(Scale scale) {
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        for (int i = 0; i < scale.size(); i++)
            scaleDiatonicReparametrizer.put(i, scale.getRelativeDegreeByIndex(i));
        return scaleDiatonicReparametrizer;
    }

    @Test
    public void autoTurnIntoImmutable2() {
        Scale scale = Scale.fromIntegers(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

        assertEquals(Scale.CHROMATIC, scale);
        assertSame(Scale.CHROMATIC.innerScale, scale.innerScale);
    }

    @Test
    public void getIndexByRelativeDegree() {
        // todo
    }
}