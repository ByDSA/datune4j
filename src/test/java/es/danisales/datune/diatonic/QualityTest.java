package es.danisales.datune.diatonic;

import es.danisales.datune.musical.transformations.Namer;
import org.junit.Test;

import static org.junit.Assert.*;

public class QualityTest {
    @Test
    public void longNameTest() {
        for (Quality quality : Quality.values()) {
            assertNotNull( Namer.fromLong( quality ) );
        }
    }

    @Test
    public void shortNameTest() {
        for (Quality quality : Quality.values()) {
            assertNotNull( Namer.fromShort( quality ) );
        }
    }
}