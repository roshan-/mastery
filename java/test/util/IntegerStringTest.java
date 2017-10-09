package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerStringTest {
    IntegerString i;
    @Test
    void validInputs() {
        assert(new IntegerString("5").getString().equals("5"));
    }
    @Test
    void getString() {
        assert(i.getString().equals("5"));
    }

    @Test
    void add() {
        assert (i.add(new IntegerString("3")).getString().equals("8"));
    }

    @Test
    void compareTo() {
        assert (i.compareTo(new IntegerString("3")) >  0);
        assert (i.compareTo(new IntegerString("9")) <  0);
        assert (i.compareTo(new IntegerString("5")) == 0);

    }

    @BeforeEach
    void setUp() {
        i = new IntegerString("5");
    }
}