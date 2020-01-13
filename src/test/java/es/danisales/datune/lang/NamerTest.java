package es.danisales.datune.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NamerTest {

    @Test
    public void alt_0() {
        assertEquals("", Namer.alt(0));
    }

    @Test
    public void alt_1() {
        assertEquals("#", Namer.alt(1));
    }

    @Test
    public void alt_m1() {
        assertEquals("b", Namer.alt(-1));
    }

    @Test
    public void alt_3() {
        assertEquals("###", Namer.alt(3));
    }

    @Test
    public void alt_m3() {
        assertEquals("bbb", Namer.alt(-3));
    }
}