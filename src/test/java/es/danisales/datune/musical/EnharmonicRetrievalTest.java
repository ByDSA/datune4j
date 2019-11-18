package es.danisales.datune.musical;

import es.danisales.datune.musical.transformations.EnharmonicsRetrieval;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnharmonicRetrievalTest {
    @Test
    public void getMinAlts() {
        assertEquals(DiatonicAlt.E, EnharmonicsRetrieval.getMinAlts(DiatonicAlt.Fb));
    }
}
