package es.danisales.datune.function;

import es.danisales.datune.musical.Quality;
import es.danisales.datune.musical.transformations.Namer;
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