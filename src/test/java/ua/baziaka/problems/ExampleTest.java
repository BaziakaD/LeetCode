package ua.baziaka.problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTest {
    @Test
    public void testError() {
        throw new RuntimeException();
    }

    @Test
    public void testFailed() {
        assertFalse(true);
    }

    @Test
    public void testPassed() {
        assertTrue(true);
    }
    
    @Test
    public void assertEqualsDoesNotMatch() {
        assertEquals(1,2);
    }
}
