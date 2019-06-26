package ua.baziaka.problems;

import org.junit.jupiter.api.Test;
import ua.epam.rd.javatester.domain.TestMark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotImplementedTaskTest {

    @Test
    public void notImplementedTaskTest() {
        new NotImplementedTask().execute();
    }

    @Test
    @TestMark(5)
    public void successTest() {
        assertTrue(true);
    }


    @Test
    @TestMark(5)
    public void failedTest() {
        assertEquals(1, 2);
    }
}