package es.danisales.datune.tempo;

import org.junit.Test;

public class MusicalTimeTest {
    @Test(expected = IllegalArgumentException.class)
    public void negative() {
        MusicalTime.from(-1);
    }
}