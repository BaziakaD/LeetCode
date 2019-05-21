package ua.baziaka.problems;

import org.junit.jupiter.api.Test;
import ua.epam.rd.javatester.TestMark;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
        fail();
    }
}