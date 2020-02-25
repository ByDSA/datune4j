package es.danisales.datune.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameTest {

    @Test
    public void alt_0() {
        assertEquals("", Nominator.alt(0));
    }

    @Test
    public void alt_1() {
        assertEquals("#", Nominator.alt(1));
    }

    @Test
    public void alt_m1() {
        assertEquals("b", Nominator.alt(-1));
    }

    @Test
    public void alt_3() {
        assertEquals("###", Nominator.alt(3));
    }

    @Test
    public void alt_m3() {
        assertEquals("bbb", Nominator.alt(-3));
    }
}