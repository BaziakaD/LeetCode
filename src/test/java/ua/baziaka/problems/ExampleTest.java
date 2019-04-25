package ua.baziaka.problems;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
