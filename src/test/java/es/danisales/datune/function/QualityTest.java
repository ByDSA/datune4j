package es.danisales.datune.function;

import es.danisales.datune.lang.Namer;
import es.danisales.datune.chords.Quality;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class QualityTest {
    @Test
    public void longNameTest() {
        for (Quality quality : Quality.values()) {
            assertNotNull( Namer.longFrom( quality ) );
        }
    }

    @Test
    public void shortNameTest() {
        for (Quality quality : Quality.values()) {
            assertNotNull( Namer.shortFrom( quality ) );
        }
    }
}