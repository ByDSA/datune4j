package es.danisales.datune.function;

import es.danisales.datune.lang.Nominator;
import es.danisales.datune.chords.Quality;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class QualityTest {
    @Test
    public void longNameTest() {
        for (Quality quality : Quality.values()) {
            assertNotNull( Nominator.longFrom( quality ) );
        }
    }

    @Test
    public void shortNameTest() {
        for (Quality quality : Quality.values()) {
            assertNotNull( Nominator.shortFrom( quality ) );
        }
    }
}