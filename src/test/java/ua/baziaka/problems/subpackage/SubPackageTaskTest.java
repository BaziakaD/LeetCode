package ua.baziaka.problems.subpackage;

import org.junit.jupiter.api.Test;
import ua.epam.rd.javatester.TestMark;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SubPackageTaskTest {

    @Test
    @TestMark(1)
    public void test() {
        assertTrue(new SubPackageTask().execute());
    }
}