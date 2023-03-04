package compiler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SimpleTest {

    private final int index = 0;

    @Test
    void testInitialValueToBeZero() {
        assertEquals(0, index);
    }

}
