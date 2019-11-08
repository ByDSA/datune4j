package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
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
        assertEquals(ScaleEnum.values().length, Scale.ALL.size());
    }

    @Test
    public void constantScalesSameAsScaleEnumContent() {
        List<ScaleEnum> scaleEnumList = Arrays.asList( ScaleEnum.values() );
        List<ScaleEnum> scaleEnumListFromScale = new ArrayList<>();
        for (Scale scale : Scale.ALL)
            scaleEnumListFromScale.add((ScaleEnum)scale.innerScale);

        for (ScaleEnum scaleEnum : scaleEnumListFromScale)
            assertTrue(scaleEnum.toString(), scaleEnumList.contains(scaleEnum));

        for (ScaleEnum scaleEnum : scaleEnumList) {
            assertTrue(scaleEnum.toString(), scaleEnumListFromScale.contains(scaleEnum));
        }

        assertEquals(ScaleEnum.values().length, Scale.ALL.size());
    }

    @Test
    public void of() {
        List<ScaleDistance> listAdded = Collections.unmodifiableList(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ) );
        Scale scale = Scale.of(listAdded);

        assertEquals(listAdded, scale.getCode());
        assertEquals(7, scale.size());
    }

    @Test(expected = ScaleBuildingException.class)
    public void ofDontSum12() {
        List<ScaleDistance> listAdded = Collections.unmodifiableList(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE
        ) );

        Scale scale = Scale.of(listAdded);
        assertTrue(scale.getCode().size() < 7);
    }

    @Test(expected = ScaleBuildingException.class)
    public void integersDontSum12() {
        Scale scale = Scale.fromIntegers( 2, 2, 1, 2, 2, 2 );
        assertTrue(scale.getCode().size() < 7);
    }

    @Test
    public void integersChromatic() {
        Scale scale = Scale.fromIntegers( 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 );
        assertEquals(Scale.CHROMATIC, scale);
        assertEquals(12, scale.getCode().size());
    }

    @Test
    public void scaleEnumReusable1() {
        ScaleEnum scaleEnum = ScaleEnum.of(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ));

        assertSame(ScaleEnum.MAJOR, scaleEnum);
        assertNotSame(ScaleEnum.IONIAN, scaleEnum);
    }

    @Test
    public void scaleEnumReusableAsInner() {
        Scale scale = Scale.of(Arrays.asList(
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.WHOLE,
                ScaleDistance.HALF
        ));

        ScaleEnum scaleEnum = (ScaleEnum)scale.innerScale;

        assertSame(ScaleEnum.MAJOR, scaleEnum);
        assertNotSame(ScaleEnum.IONIAN, scaleEnum);
    }

    @Test
    public void fromDiatonicAltList1() {
        Scale scale = Scale.fromDiatonicAltList( Arrays.asList(
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E,
                DiatonicAlt.F,
                DiatonicAlt.G,
                DiatonicAlt.A,
                DiatonicAlt.B
        ) );

        assertEquals(Scale.MAJOR, scale);
    }

    @Test
    public void fromDiatonicAltList2() {
        Scale scale = Scale.fromDiatonicAltList( Arrays.asList(
                DiatonicAlt.A,
                DiatonicAlt.B,
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E,
                DiatonicAlt.F,
                DiatonicAlt.G
        ) );

        assertEquals(Scale.MINOR, scale);
    }

    @Test
    public void fromDiatonicAltList3() {
        Scale scale = Scale.fromDiatonicAltList( Arrays.asList(
                DiatonicAlt.F,
                DiatonicAlt.G,
                DiatonicAlt.A,
                DiatonicAlt.Bb,
                DiatonicAlt.C,
                DiatonicAlt.D,
                DiatonicAlt.E
        ) ); // Fa Major

        assertEquals(Scale.MAJOR, scale);
    }

    @Test
    public void getAllModes() {
        Scale scale = Scale.MAJOR;

        List<Scale> scaleModes = scale.getAllModes();

        assertEquals(7, scaleModes.size());
        assertEquals(Scale.MAJOR, scaleModes.get(0));
        assertEquals(Scale.DORIAN, scaleModes.get(1));
        assertEquals(Scale.PHRYGIAN, scaleModes.get(2));
        assertEquals(Scale.LYDIAN, scaleModes.get(3));
        assertEquals(Scale.MIXOLYDIAN, scaleModes.get(4));
        assertEquals(Scale.AEOLIAN, scaleModes.get(5));
        assertEquals(Scale.LOCRIAN, scaleModes.get(6));
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

        Scale scale1 = Scale.of(listAdded);
        Scale scale2 = Scale.of(listAdded);

        assertEquals(scale1, scale2);
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

        Scale scale = Scale.of(listAdded);

        assertEquals(Scale.MAJOR, scale);
    }

    @Test
    public void equalsDifferentName() {
        assertEquals(Scale.MAJOR, Scale.IONIAN);
    }


    @Test
    public void fromDiatonicAltList() {
        Tonality s = Tonality.A;
        List<DiatonicAlt> notes = new ArrayList<>();
        for (DiatonicDegree diatonicDegree : DiatonicDegree.values())
            notes.add(s.getNote(diatonicDegree));

        assertEquals(s.getScale(), Scale.fromDiatonicAltList(notes));
    }

    @Test
    public void fromIntegers() {
        Scale scale = Scale.fromIntegers( 2, 2, 1, 2, 2, 2, 1 );
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

        Scale b = Scale.fromIntegers( 2, 2, 1, 2, 2, 2, 1 );
        assertNotSame(a, b);
        assertEquals(a, b);
    }

    @Test
    public void equalsFromScaleDistance() {
        Scale a = Scale.MAJOR;
        Scale b = Scale.of( Arrays.asList(
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
}